package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class WechatNotice  implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String openid;
	private int erid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getErid() {
		return erid;
	}
	public void setErid(int erid) {
		this.erid = erid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
