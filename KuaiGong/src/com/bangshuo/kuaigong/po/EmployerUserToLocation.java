package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployerUserToLocation extends EmployerUser  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String longitude;
private String latitude;
private String credits;
private String grade;
private String presentintegral;
private String money;
private String  Mstatus;
private String starlevel;
private String payment;
public String getPresentintegral() {
	return presentintegral;
}
public void setPresentintegral(String presentintegral) {
	this.presentintegral = presentintegral;
}
public String getCredits() {
	return credits;
}
public void setCredits(String credits) {
	this.credits = credits;
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
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getMoney() {
	return money;
}
public void setMoney(String money) {
	this.money = money;
}
public String getStarlevel() {
	return starlevel;
}
public void setStarlevel(String starlevel) {
	this.starlevel = starlevel;
}




public String getMstatus() {
	return Mstatus;
}
public void setMstatus(String mstatus) {
	Mstatus = mstatus;
}
public String getPayment() {
	return payment;
}
public void setPayment(String payment) {
	this.payment = payment;
}

}
