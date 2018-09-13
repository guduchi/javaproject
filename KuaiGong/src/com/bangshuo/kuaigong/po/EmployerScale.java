package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployerScale  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer erid;

    private String credits;

    private String presentintegral;
   
    private  EmployerUser employeruser;
  
    private String count;
    public EmployerUser getEmployeruser() {
		return employeruser;
	}

	public void setEmployeruser(EmployerUser employeruser) {
		this.employeruser = employeruser;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getErid() {
        return erid;
    }

    public void setErid(Integer erid) {
        this.erid = erid;
    }

   

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits == null ? null : credits.trim();
    }

    public String getPresentintegral() {
        return presentintegral;
    }

    public void setPresentintegral(String presentintegral) {
        this.presentintegral = presentintegral == null ? null : presentintegral.trim();
    }

	public EmployerUser getEmployerUser() {
		return employeruser;
	}

	public void setEmployerUser(EmployerUser employerUser) {
		this.employeruser = employerUser;
	}
    
}