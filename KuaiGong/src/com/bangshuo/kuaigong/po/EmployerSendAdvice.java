package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployerSendAdvice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String usernameemployer ;
	private int countallemployer ;
	private String regidemployer ;
	public String getUsernameemployer() {
		return usernameemployer;
	}
	public void setUsernameemployer(String usernameemployer) {
		this.usernameemployer = usernameemployer;
	}
	public int getCountallemployer() {
		return countallemployer;
	}
	public void setCountallemployer(int countallemployer) {
		this.countallemployer = countallemployer;
	}
	public String getRegidemployer() {
		return regidemployer;
	}
	public void setRegidemployer(String regidemployer) {
		this.regidemployer = regidemployer;
	}
	
	

}
