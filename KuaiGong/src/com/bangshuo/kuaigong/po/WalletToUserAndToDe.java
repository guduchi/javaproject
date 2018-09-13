package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class WalletToUserAndToDe extends Wallet  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String username;
private String name;
private String cash;
private String time;
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

}
