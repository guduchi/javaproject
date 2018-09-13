package com.bangshuo.kuaigong.po;

import java.io 

.Serializable;


public class EmployerSendDiscountLong implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int erid ;
	private String username ;
	private String name ;
	private String regid ;
	private String starttime ;
	private int senddiscountall ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name 

 = name;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public int getSenddiscountall() {
		return senddiscountall;
	}
	public void setSenddiscountall(int senddiscountall) {
		this.senddiscountall = senddiscountall;
	}

	public int getErid() {
		return erid;
	}
	public void setErid(int erid) {
		this.erid = erid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
}
