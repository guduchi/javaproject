package com.bangshuo.kuaigong.po;

import java.io 

.Serializable;

public class EmployeeHourLength implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int eeid ;
	private String hourlength ;
	private String flushtime ;
	private String count;
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getFlushtime() {
		return flushtime;
	}
	public void setFlushtime(String flushtime) {
		this.flushtime = flushtime;
	}
	public int getEeid() {
		return eeid;
	}
	public void setEeid(int eeid) {
		this.eeid = eeid;
	}
	public String getHourlength() {
		return hourlength;
	}
	public void setHourlength(String hourlength) {
		this.hourlength = hourlength;
	}
	

}
