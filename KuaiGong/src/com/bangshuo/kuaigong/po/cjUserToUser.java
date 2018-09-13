package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class cjUserToUser extends cjUser  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int userID;
private String username;
private String password;

public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
