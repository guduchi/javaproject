package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployerUserToDisCount extends DiscountCoupon   implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String money;

public String getMoney() {
	return money;
}

public void setMoney(String money) {
	this.money = money;
}
}
