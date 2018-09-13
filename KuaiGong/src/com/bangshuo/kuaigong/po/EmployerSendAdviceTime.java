package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployerSendAdviceTime implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usernameemployer ;
	private String timeemployer ;
	
	
	public String getUsernameemployer() {
		return usernameemployer;
	}
	public void setUsernameemployer(String usernameemployer) {
		this.usernameemployer = usernameemployer;
	}
	public String getTimeemployer() {
		return timeemployer;
	}
	public void setTimeemployer(String timeemployer) {
		this.timeemployer = timeemployer;
	}
	
    
}
