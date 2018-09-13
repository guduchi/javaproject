package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployeeUserOnlineInfo extends EmployeeUser  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String time;
	private String worktime;
	private String status;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
