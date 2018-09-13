package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class OnlineToEmployeeUser1 extends EmployeeUser  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int eeid;
      public int getEeid() {
		return eeid;
	}

	public void setEeid(int eeid) {
		this.eeid = eeid;
	}

	private String startime;
      
      private String endtime;
      
      private String status;



	public String getStartime() {
		return startime;
	}

	public void setStartime(String startime) {
		this.startime = startime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
}
