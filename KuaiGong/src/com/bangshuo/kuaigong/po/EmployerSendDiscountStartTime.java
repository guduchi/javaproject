package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployerSendDiscountStartTime implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int erid ;
	private String starttimesend ;
	public int getErid() {
		return erid;
	}
	public void setErid(int erid) {
		this.erid = erid;
	}
	public String getStarttimesend() {
		return starttimesend;
	}
	public void setStarttimesend(String starttimesend) {
		this.starttimesend = starttimesend;
	}
	
}
