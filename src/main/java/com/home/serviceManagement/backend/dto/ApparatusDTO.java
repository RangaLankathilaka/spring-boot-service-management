package com.home.serviceManagement.backend.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.home.serviceManagement.backend.entity.Ticket_Appratus;

public class ApparatusDTO {

	private String apparatusId;
	private String apparatusName;
	private int apparatusCount;
	private String apparatusType;
	private BigDecimal apparatusPrice;
	
	
	
	
	public ApparatusDTO() {
		super();
	}
	
	

	public ApparatusDTO(String apparatusId, String apparatusName, int apparatusCount, String apparatusType,
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
		return "ApparatusDTO [apparatusId=" + apparatusId + ", apparatusName=" + apparatusName + ", apparatusCount="
				+ apparatusCount + ", apparatusType=" + apparatusType + ", apparatusPrice=" + apparatusPrice + "]";
	}
	
	
	

	
}
