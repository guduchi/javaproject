package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployerUserToScale extends EmployerUser  implements Serializable{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String grade;
	private String credits;
	private String 	presentintegral;
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
	public String getPresentintegral() {
		return presentintegral;
	}
	public void setPresentintegral(String presentintegral) {
		this.presentintegral = presentintegral;
	}
	
}
