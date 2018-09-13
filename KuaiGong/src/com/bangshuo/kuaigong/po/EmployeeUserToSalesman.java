package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployeeUserToSalesman extends EmployeeUser  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String salesmanName;

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
	
}
