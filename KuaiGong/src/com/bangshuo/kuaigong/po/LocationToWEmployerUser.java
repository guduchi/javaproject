package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class LocationToWEmployerUser extends EmployeeLocation  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id;
private String username;
private String name;
private String portrait;

public String getPortrait() {
	return portrait;
}
public void setPortrait(String portrait) {
	this.portrait = portrait;
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
