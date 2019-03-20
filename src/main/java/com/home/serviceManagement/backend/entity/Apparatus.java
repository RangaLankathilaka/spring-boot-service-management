package com.home.serviceManagement.backend.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Apparatus implements Serializable {
	
	@Id
	private String apparatusId;
	private String apparatusName;
	private int apparatusCount;
	private String apparatusType;
	private BigDecimal apparatusPrice;
	
	@OneToMany(mappedBy="apparatus",cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<Ticket_Appratus> ticket_Appratus=new ArrayList<>();
	
	
	
	public List<Ticket_Appratus> getTicket_Appratus() {
		return ticket_Appratus;
	}
	public void setTicket_Appratus(List<Ticket_Appratus> ticket_Appratus) {
		this.ticket_Appratus = ticket_Appratus;
	}
	public Apparatus() {
		super();
	}
	public Apparatus(String apparatusId, String apparatusName, int apparatusCount, String apparatusType,
			BigDecimal apparatusPrice) {
		super();
		this.apparatusId = apparatusId;
		this.apparatusName = apparatusName;
		this.apparatusCount = apparatusCount;
		this.apparatusType = apparatusType;
		this.apparatusPrice = apparatusPrice;
	}
	public String getApparatusId() {
		return apparatusId;
	}
	public void setApparatusId(String apparatusId) {
		this.apparatusId = apparatusId;
	}
	public String getApparatusName() {
		return apparatusName;
	}
	public void setApparatusName(String apparatusName) {
		this.apparatusName = apparatusName;
	}
	public int getApparatusCount() {
		return apparatusCount;
	}
	public void setApparatusCount(int apparatusCount) {
		this.apparatusCount = apparatusCount;
	}
	public String getApparatusType() {
		return apparatusType;
	}
	public void setApparatusType(String apparatusType) {
		this.apparatusType = apparatusType;
	}
	public BigDecimal getApparatusPrice() {
		return apparatusPrice;
	}
	public void setApparatusPrice(BigDecimal apparatusPrice) {
		this.apparatusPrice = apparatusPrice;
	}
	@Override
	public String toString() {
		return "Apparatus [apparatusId=" + apparatusId + ", apparatusName=" + apparatusName + ", apparatusCount="
				+ apparatusCount + ", apparatusType=" + apparatusType + ", apparatusPrice=" + apparatusPrice + "]";
	}
	
	
	
	

}
