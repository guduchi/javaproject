package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployerScaleToUser extends EmployerScale  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int eid;
private String username;
private String name;


public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
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
