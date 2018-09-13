package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class OnlineInfomationToEmploUser extends  OnlineInformation  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
private String username;
private String ontime;
private String starttimeDay;
private String endTimeDay;
private String ChaDay;

public String getStarttimeDay() {
	return starttimeDay;
}
public void setStarttimeDay(String starttimeDay) {
	this.starttimeDay = starttimeDay;
}
public String getEndTimeDay() {
	return endTimeDay;
}
public void setEndTimeDay(String endTimeDay) {
	this.endTimeDay = endTimeDay;
}
public String getChaDay() {
	return ChaDay;
}
public void setChaDay(String chaDay) {
	ChaDay = chaDay;
}
public String getOntime() {
	return ontime;
}
public void setOntime(String ontime) {
	this.ontime = ontime;
}
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
}
