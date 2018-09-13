package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class orderFormToEeUserAndErUser extends OrderForm  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
private String eename;
private String  username;
private String GRusername;
private String order_start_time;
private String hand;
private String portrait;
private String DDtime;
private String CDtime;
private String watime;
private String ChiDaoTime;
private String cost;
private String actualcost;
private String miao;
private String workingHours;
private String time;
private String type;


public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getWorkingHours() {
	return workingHours;
}
public void setWorkingHours(String workingHours) {
	this.workingHours = workingHours;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public String getWatime() {
	return watime;
}
public void setWatime(String watime) {
	this.watime = watime;
}
public String getMiao() {
	return miao;
}
public void setMiao(String miao) {
	this.miao = miao;
}
public String getActualcost() {
	return actualcost;
}
public void setActualcost(String actualcost) {
	this.actualcost = actualcost;
}
public String getCost() {
	return cost;
}
public void setCost(String cost) {
	this.cost = cost;
}
public String getChiDaoTime() {
	return ChiDaoTime;
}
public void setChiDaoTime(String chiDaoTime) {
	ChiDaoTime = chiDaoTime;
}
public String getCDtime() {
	return CDtime;
}
public void setCDtime(String cDtime) {
	CDtime = cDtime;
}
public String getDDtime() {
	return DDtime;
}
public void setDDtime(String dDtime) {
	DDtime = dDtime;
}
public String getPortrait() {
	return portrait;
}
public void setPortrait(String portrait) {
	this.portrait = portrait;
}
public String getHand() {
	return hand;
}
public void setHand(String hand) {
	this.hand = hand;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


public String getEename() {
	return eename;
}
public void setEename(String eename) {
	this.eename = eename;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getGRusername() {
	return GRusername;
}
public void setGRusername(String gRusername) {
	GRusername = gRusername;
}
public String getOrder_start_time() {
	return order_start_time;
}
public void setOrder_start_time(String order_start_time) {
	this.order_start_time = order_start_time;
}

}
