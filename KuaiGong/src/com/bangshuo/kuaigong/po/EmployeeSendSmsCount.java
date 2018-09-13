package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployeeSendSmsCount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer countall ;

	private String username ;

	public Integer getCountall() {
		return countall;
	}

	public void setCountall(Integer countall) {
		this.countall = countall;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "EmployeeCountAll [countall=" + countall + ", username=" + username + "]";
	}





}
