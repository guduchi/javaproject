package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployerMessageById  implements Serializable {
	
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 private String  erid ;
	 
	 private String name ;
      
      public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getErid() {
		return erid;
	}

	public void setErid(String erid) {
		this.erid = erid;
	}

	private String username;
      
      private String regid;

	

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

	
}
