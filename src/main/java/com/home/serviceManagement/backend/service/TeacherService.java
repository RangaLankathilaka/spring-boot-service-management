package com.home.serviceManagement.backend.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.home.serviceManagement.backend.dto.TeacherDTO;

public interface TeacherService {
	
	List<TeacherDTO> findAllTeacher(int pageNumber,int pageElemenr,String sortType);
	
	TeacherDTO findTeacher(String teacherId);
	
	void saveTeacher(String teacherId,TeacherDTO teacherDTO);
	
	boolean updateTeacher(String teacherId,TeacherDTO teacherDTO);
	
	boolean deleteTeacher(String teacherId);
	
	

}
