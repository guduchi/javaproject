package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class SalesmanToDetail extends SalesmanDetail implements Serializable{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String salesmanName;
	
	private String username;



	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	 
}
