package com.home.serviceManagement.backend.service;

import java.util.List;

import com.home.serviceManagement.backend.dto.TeacherDTO;

public interface TeacherService {
	
	List<TeacherDTO> findAllTeacher();
	
	TeacherDTO findTeacher(String teacherId);
	
	void saveTeacher(String teacherId,TeacherDTO teacherDTO);
	
	boolean updateTeacher(String teacherId,TeacherDTO teacherDTO);
	
	boolean deleteTeacher(String teacherId);
	
	

}
