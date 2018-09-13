package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class OnlineToEmployeeUser extends EmployeeUser  implements Serializable{
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String starttime;
      
      private String endtime;
      
      private String status;


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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
}
