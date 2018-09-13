package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployerUserWalletToEruser  implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id;
 private int erid;
 private String username;
 private String name;
 
 private String balance;
 
public String getBalance() {
	return balance;
}
public void setBalance(String balance) {
	this.balance = balance;
}
public int getErid() {
	return erid;
}
public void setErid(int erid) {
	this.erid = erid;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
 
}
