package com.bangshuo.kuaigong.po;


import java.io.Serializable;

public class EmployeeSendSms implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id ;
	private String username ;
	private String sendtimethird ;
	private String sendtimeseven ;
	private String sendtimeone ;
    private String sendtimelong ;
	
	public String getSendtimelong() {
		return sendtimelong;
	}
	public void setSendtimelong(String sendtimelong) {
		this.sendtimelong = sendtimelong;
	}
	public String getSendtimethird() {
		return sendtimethird;
	}
	public void setSendtimethird(String sendtimethird) {
		this.sendtimethird = sendtimethird;
	}
	public String getSendtimeseven() {
		return sendtimeseven;
	}
	public void setSendtimeseven(String sendtimeseven) {
		this.sendtimeseven = sendtimeseven;
	}
	public String getSendtimeone() {
		return sendtimeone;
	}
	public void setSendtimeone(String sendtimeone) {
		this.sendtimeone = sendtimeone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	

}
