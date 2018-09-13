package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class CancelOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	private Integer id;
	
	private Integer orderid;
	
	private String time;
	
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

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
	
}
