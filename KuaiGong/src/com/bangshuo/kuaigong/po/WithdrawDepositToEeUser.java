package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class WithdrawDepositToEeUser extends WithdrawDeposit  implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String username;
 private String name;
 private String queryCount;
public String getQueryCount() {
	return queryCount;
}
public void setQueryCount(String queryCount) {
	this.queryCount = queryCount;
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
