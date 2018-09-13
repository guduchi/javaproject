package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class Apply  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	  
	private String name;
	
	private String idcard;
	
	private String address;
	
	private String tel;
	
	private String time;
	private String referrername;
	private String referrertel;
	
	private String count;

	
	
	
	
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getReferrername() {
		return referrername;
	}

	public void setReferrername(String referrername) {
		this.referrername = referrername;
	}

	public String getReferrertel() {
		return referrertel;
	}

	public void setReferrertel(String referrertel) {
		this.referrertel = referrertel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
