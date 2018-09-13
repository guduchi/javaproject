package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployerUserWallet   implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id;
private int erid;
private String balance;
private String count;
public String getCount() {
	return count;
}
public void setCount(String count) {
	this.count = count;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public int getErid() {
	return erid;
}
public void setErid(int erid) {
	this.erid = erid;
}
public String getBalance() {
	return balance;
}
public void setBalance(String balance) {
	this.balance = balance;
}

}
