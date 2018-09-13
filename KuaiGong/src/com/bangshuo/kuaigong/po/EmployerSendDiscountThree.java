

package com.bangshuo.kuaigong.po;

import java.io 

.Serializable;


public class EmployerSendDiscountThree implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int erid ;
	private String username ;
	private String regid ;
	private String name ;
	private int sendcount ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name 

 = name;
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
	public int getSendcount() {
		return sendcount;
	}
	public void setSendcount(int sendcount) {
		this.sendcount = sendcount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
}
