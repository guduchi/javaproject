package com.bangshuo.kuaigong.po;

import java.io 

.Serializable;

public class EmployerSendDiscountFive implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int emperidfive ;
	private String empusername ;
	private String empstarttime ;
	private String empregid ;
	private String empname ;
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getEmperidfive() {
		return emperidfive;
	}
	public void setEmperidfive(int emperidfive) {
		this.emperidfive = emperidfive;
	}
	public String getEmpusername() {
		return empusername;
	}
	public void setEmpusername(String empusername) {
		this.empusername = empusername;
	}
	public String getEmpstarttime() {
		return empstarttime;
	}
	public void setEmpstarttime(String empstarttime) {
		this.empstarttime = empstarttime;
	}
	public String getEmpregid() {
		return empregid;
	}
	public void setEmpregid(String empregid) {
		this.empregid = empregid;
	}

}
