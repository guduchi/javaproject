package com.bangshuo.kuaigong.po;

import java.io 

.Serializable;

public class EmployerSendDiscount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id ;
	private String username ;
	private String time ;
	private String name ;
	private String regid ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name 

 = name;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id 

 = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}

}
