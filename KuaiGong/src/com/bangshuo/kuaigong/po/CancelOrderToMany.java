package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class CancelOrderToMany extends CancelOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	private Integer id;
	
	private Integer eeid;
	 
	 private Integer erid;
	 
	 private String payment;
	 
	 private String status;
	 
	 private String eename;
	 
	 private String eeusername;
	 
	 private String name;
	 
	 private String username;

	 public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	 
	public Integer getEeid() {
		return eeid;
	}

	public void setEeid(Integer eeid) {
		this.eeid = eeid;
	}

	public Integer getErid() {
		return erid;
	}

	public void setErid(Integer erid) {
		this.erid = erid;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEename() {
		return eename;
	}

	public void setEename(String eename) {
		this.eename = eename;
	}

	public String getEeusername() {
		return eeusername;
	}

	public void setEeusername(String eeusername) {
		this.eeusername = eeusername;
	}

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
