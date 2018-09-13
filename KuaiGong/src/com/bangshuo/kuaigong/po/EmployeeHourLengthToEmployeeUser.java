package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployeeHourLengthToEmployeeUser extends EmployeeHourLength implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  
	private String name;
	
	private String username;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	 
}
