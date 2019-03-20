package com.home.serviceManagement.backend.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.serviceManagement.backend.dto.TeacherDTO;
import com.home.serviceManagement.backend.dto.TicketDTO;
import com.home.serviceManagement.backend.dto.Ticket_ApparatusDTO;
import com.home.serviceManagement.backend.entity.Teacher;
import com.home.serviceManagement.backend.entity.Ticket;
import com.home.serviceManagement.backend.entity.Ticket_Apparatus_PK;
import com.home.serviceManagement.backend.entity.Ticket_Appratus;
import com.home.serviceManagement.backend.repository.TeacherRepository;
import com.home.serviceManagement.backend.service.TeacherService;
import com.home.serviceManagement.backend.util.TicketId;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<TeacherDTO> findAllTeacher() {
		
		List<Teacher> findAll = teacherRepository.findAll();
		List<TeacherDTO> teList=new ArrayList<TeacherDTO>();
	
		
		findAll.forEach(teacher->{
			List<TicketDTO> ticketDTOs=new ArrayList<TicketDTO>();
			TeacherDTO teacherDTO=new TeacherDTO();
			BeanUtils.copyProperties(teacher, teacherDTO);
			
			System.out.println(teacher.getTicketsList());
//			retreieve ticket
			List<Ticket> ticketsList = teacher.getTicketsList();
			ticketsList.forEach(ticket->{
				TicketDTO ticketDTO=new TicketDTO();
				BeanUtils.copyProperties(ticket, ticketDTO);
				ticketDTOs.add(ticketDTO);
			});
			teacherDTO.setTicketList(ticketDTOs);
			teList.add(teacherDTO);
		});
		
		return teList;
	}

	@Transactional(readOnly=true)
	@Override
	public TeacherDTO findTeacher(String teacherId) {
		Teacher teacher = teacherRepository.findById(teacherId).get();
		TeacherDTO teacherDTO=new TeacherDTO();
		BeanUtils.copyProperties(teacher, teacherDTO);
		
		List<Ticket> ticketsList = teacher.getTicketsList();
		List<TicketDTO> ticketDTOs=new ArrayList<>();
		ticketsList.forEach(ticket->{
			
			
		TicketDTO ticketDTO=new TicketDTO();
			BeanUtils.copyProperties(ticket, ticketDTO);
			ticketDTOs.add(ticketDTO);
		});
		teacherDTO.setTicketList(ticketDTOs);
		return teacherDTO;
	}

	@Override
	public void saveTeacher(String teacherId, TeacherDTO teacherDTO) {
		System.out.println(teacherDTO);
		
		 if (!teacherId.equals(teacherDTO.getTeacherId())){
	            throw new RuntimeException("Teacher IDs are mismatched");
	        }
		Teacher teacher=new Teacher();
		BeanUtils.copyProperties(teacherDTO, teacher);
		
		//ticket save
		List<TicketDTO> ticketList = teacherDTO.getTicketList();
		List<Ticket> tickets=new ArrayList<Ticket>();
		int[] ticketNumber = new int[]{1};
		
		
		 
		ticketList.forEach(ticketDTO->{
			
			//ticket
			Ticket ticket=new Ticket();
			
			BeanUtils.copyProperties(ticketDTO, ticket);
		
		
			ticket.setTeacher(teacher);
			
			TicketId ticketId=new TicketId();
			String timeStamp = ticketId.timeStamp();
			ticket.setTicketId("TRN"+timeStamp+ticketNumber[0]++);
			
			//ticket_apparatus
			List<Ticket_ApparatusDTO> ticket_ApparatusDTOs = ticketDTO.getTicket_ApparatusDTOs();
			
			List<Ticket_Appratus> ticket_AppratusList=new ArrayList<>();
			ticket_ApparatusDTOs.forEach(ticket_appratusDTO->{
				Ticket_Appratus ticket_Appratus=new Ticket_Appratus();
				BeanUtils.copyProperties(ticket_appratusDTO, ticket_Appratus);
				
				ticket_Appratus.setTicket_Apparatus_PK(new Ticket_Apparatus_PK("TRN"+timeStamp+ticketNumber[0]++,ticket_appratusDTO.getApparatusId()));
				
				
				ticket_AppratusList.add(ticket_Appratus);
				
			});
			ticket.setTicket_Appratus(ticket_AppratusList);
			tickets.add(ticket);
		});
		
		teacher.setTicketsList(tickets);
		System.out.println(teacher);
		teacherRepository.save(teacher);
		
	}

	@Override
	public boolean updateTeacher(String teacherId, TeacherDTO teacherDTO) {

		 if (!teacherId.equals(teacherDTO.getTeacherId())){
	            throw new RuntimeException("Teacher IDs are mismatched");
	        }
		if( teacherRepository.existsById(teacherId)) {
			saveTeacher(teacherId, teacherDTO);
			return true;
		}
		else {
			return false;
		}
		 
		
	}

	@Override
	public boolean deleteTeacher(String teacherId) {
		teacherRepository.deleteById(teacherId);
		return true;
	}

}
