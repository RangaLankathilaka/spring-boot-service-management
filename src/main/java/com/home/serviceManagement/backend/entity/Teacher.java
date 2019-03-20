package com.home.serviceManagement.backend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher implements Serializable {

	@Id
	private String teacherId;
	private String teacherName;
	private String teacherAddress;

	@OneToMany(mappedBy="teacher",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<Ticket> ticketsList = new ArrayList<>();
	
	

	public List<Ticket> getTicketsList() {
		return ticketsList;
	}

	public void setTicketsList(List<Ticket> ticketsList) {
		this.ticketsList = ticketsList;
	}

	public Teacher() {
		super();
	}

	public Teacher(String teacherId, String teacherName, String teacherAddress) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherAddress = teacherAddress;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherAddress=" + teacherAddress
				+ "]";
	}

}