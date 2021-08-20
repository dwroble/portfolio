package com.employee;

import java.util.Date;

public class Employee {
	private boolean managerFlag, partTimeFlag;
	private String name;
	private Date dateHired;
	private int id;
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id + "";
	}
	
	public Date getDateHired() {
		return dateHired;
	}
	
	public boolean isManager() {
		return managerFlag;
	}
	
	public boolean isPartTime() {
		return partTimeFlag;
	}
	

}
