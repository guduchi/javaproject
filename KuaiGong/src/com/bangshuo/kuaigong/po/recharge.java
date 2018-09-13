package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class recharge   implements Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	  private int erid;
	  private String recharge;
	  private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getErid() {
		return erid;
	}
	public void setErid(int erid) {
		this.erid = erid;
	}
	public String getRecharge() {
		return recharge;
	}
	public void setRecharge(String recharge) {
		this.recharge = recharge;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	  
	
}
