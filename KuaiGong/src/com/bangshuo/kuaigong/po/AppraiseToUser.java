package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class AppraiseToUser extends Appraise   implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int GID;
private int erid;
private int eeid;
private String grade;
private String credits;
private String starlevel;
private String username;
private String name;
private String Eeusername;
private String eename;
private String ername;
private String count;

public String getCount() {
	return count;
}
public void setCount(String count) {
	this.count = count;
}
public String getEename() {
	return eename;
}
public void setEename(String eename) {
	this.eename = eename;
}
public String getErname() {
	return ername;
}
public void setErname(String ername) {
	this.ername = ername;
}
public int getGID() {
	return GID;
}
public void setGID(int gID) {
	GID = gID;
}
public Integer getErid() {
	return erid;
}
public void setErid(int erid) {
	this.erid = erid;
}
public Integer getEeid() {
	return eeid;
}
public void setEeid(int eeid) {
	this.eeid = eeid;
}
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
public String getStarlevel() {
	return starlevel;
}
public void setStarlevel(String starlevel) {
	this.starlevel = starlevel;
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
public String getEeusername() {
	return Eeusername;
}
public void setEeusername(String eeusername) {
	Eeusername = eeusername;
}

}
