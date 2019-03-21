package com.home.serviceManagement.backend.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity 
@PrimaryKeyJoinColumn(name="apparatusId")  
public class Electrical_Apparatus extends Apparatus {
	
	/**Electrical_Apparatus.java - this entity expose the Electrical_Apparatus table
	 * @author Ranga Lankathilaka
	 * @version 1.0 
	 * @see Apparatus
	 */

	private boolean warrenty;
	private int warrentyPeriod;

	public Electrical_Apparatus() {
		super();
	}

	public Electrical_Apparatus(boolean warrenty, int warrentyPeriod) {
		super();
		this.warrenty = warrenty;
		this.warrentyPeriod = warrentyPeriod;
	}

	public boolean isWarrenty() {
		return warrenty;
	}

	public void setWarrenty(boolean warrenty) {
		this.warrenty = warrenty;
	}

	public int getWarrentyPeriod() {
		return warrentyPeriod;
	}

	public void setWarrentyPeriod(int warrentyPeriod) {
		this.warrentyPeriod = warrentyPeriod;
	}

	@Override
	public String toString() {
		return "Electrical_Apparatus [warrenty=" + warrenty + ", warrentyPeriod=" + warrentyPeriod + "]";
	}

}
