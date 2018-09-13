package com.bangshuo.kuaigong.po;

import java.io.Serializable;
import java.util.List;

public class EmployerUser  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String password;
	private String companyname;
	private String name;
	private String shielc;
	private String status;
	private String grade;
	private String hand;
	   private String time;
	   private String regid;
    public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}

	private EmployerScale employerScale;
    private String count;
    public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	private List<EmployerUserToLocation> EmployerUserToLocations;

    
    
    public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname == null ? null : companyname.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getShielc() {
		return shielc;
	}

	public void setShielc(String shielc) {
		this.shielc = shielc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public EmployerScale getEmployerScale() {
		return employerScale;
	}

	public void setEmployerScale(EmployerScale employerScale) {
		this.employerScale = employerScale;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getHand() {
		return hand;
	}

	public void setHand(String hand) {
		this.hand = hand;
	}

	public List<EmployerUserToLocation> getEmployerUserToLocations() {
		return EmployerUserToLocations;
	}

	public void setEmployerUserToLocations(
			List<EmployerUserToLocation> employerUserToLocations) {
		EmployerUserToLocations = employerUserToLocations;
	}



}