package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class SendDispountMoney implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id ;

	private String moneyone ;
	private String moneythree ;
	private String moneyfive ;
	private String moneylong ;
	private String longusenumber ;

	public String getLongusenumber() {
		return longusenumber;
	}
	public void setLongusenumber(String longusenumber) {
		this.longusenumber = longusenumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoneyone() {
		return moneyone;
	}
	public void setMoneyone(String moneyone) {
		this.moneyone = moneyone;
	}
	public String getMoneythree() {
		return moneythree;
	}
	public void setMoneythree(String moneythree) {
		this.moneythree = moneythree;
	}
	public String getMoneyfive() {
		return moneyfive;
	}
	public void setMoneyfive(String moneyfive) {
		this.moneyfive = moneyfive;
	}
	public String getMoneylong() {
		return moneylong;
	}
	public void setMoneylong(String moneylong) {
		this.moneylong = moneylong;
	}


}
