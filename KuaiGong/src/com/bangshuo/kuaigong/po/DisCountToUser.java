package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class DisCountToUser extends  DiscountCoupon  implements Serializable{


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id;
private String username;
private String name;
private String balance;


public String getBalance() {
	return balance;
}
public void setBalance(String balance) {
	this.balance = balance;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public Integer getId() {
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
