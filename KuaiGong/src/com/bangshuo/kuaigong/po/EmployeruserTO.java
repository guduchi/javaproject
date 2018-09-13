package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployeruserTO extends EmployerUser  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String grade;
private String credits;
private String 	presentintegral;
private String starlevel;
private String money;
private String longitude;
private String latitude;
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getCredits() {
	return credits;
}
public void setCredits(String credits) {
	this.credits = credits;
}
public String getPresentintegral() {
	return presentintegral;
}
public void setPresentintegral(String presentintegral) {
	this.presentintegral = presentintegral;
}
public String getStarlevel() {
	return starlevel;
}
public void setStarlevel(String starlevel) {
	this.starlevel = starlevel;
}
public String getMoney() {
	return money;
}
public void setMoney(String money) {
	this.money = money;
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
}
