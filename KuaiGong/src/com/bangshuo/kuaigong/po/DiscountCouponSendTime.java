package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class DiscountCouponSendTime  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Integer erid;

    private String money;
    
    private String endtime;
    




	public Integer getErid() {
		return erid;
	}

	public void setErid(Integer erid) {
		this.erid = erid;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}


	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

 
}