package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class SalesmanToMany extends Salesman  implements Serializable{
   
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double balance;
	 
	 private String latelyUse;
	 
	 private String time;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getLatelyUse() {
		return latelyUse;
	}

	public void setLatelyUse(String latelyUse) {
		this.latelyUse = latelyUse;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

 }
