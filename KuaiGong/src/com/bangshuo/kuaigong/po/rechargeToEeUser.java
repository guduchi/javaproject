package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class rechargeToEeUser extends EmployerUser  implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
private String username;
private String recharge;
private String time;
private Integer sumReCharge;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getRecharge() {
	return recharge;
}
public void setRecharge(String recharge) {
	this.recharge = recharge;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public Integer getSumReCharge() {
	return sumReCharge;
}
public void setSumReCharge(Integer sumReCharge) {
	this.sumReCharge = sumReCharge;
}




}
