package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class LocationToEmployerUser extends EmployerUser  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private  int id;
private int erid;
private String username;
private String name;
private String  longitude;
private String latitude;
private String hand;

public String getHand() {
	return hand;
}
public void setHand(String hand) {
	this.hand = hand;
}
public Integer getId() {
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
