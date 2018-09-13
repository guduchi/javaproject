package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployeeUserToLocation  extends EmployeeUser  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int eeid;
     
	private double balance;
	
	private double residue;
	
	private String cash;
	
	private String totalMoney;
	
	private String desc;
	
	private String time;
	
	private String starttime;
	
	private String endtime;
	
	private String  status;
	
	private String longitude;
	
	private String latitude;
	
	private String starlevel;

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(String starlevel) {
		this.starlevel = starlevel;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getResidue() {
		return residue;
	}

	public void setResidue(double residue) {
		this.residue = residue;
	}

	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEeid() {
		return eeid;
	}

	public void setEeid(int eeid) {
		this.eeid = eeid;
	}

	
}