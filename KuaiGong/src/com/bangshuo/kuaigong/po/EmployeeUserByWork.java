package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployeeUserByWork extends EmployeeUser  implements Serializable {
	
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer eeid;
      
      private String starttime;
      
      private String endtime;

	public Integer getEeid() {
		return eeid;
	}

	public void setEeid(Integer eeid) {
		this.eeid = eeid;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	
}
