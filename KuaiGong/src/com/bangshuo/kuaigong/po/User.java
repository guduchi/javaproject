package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class User   implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
    
    private int cjid;

    private String username;

    private String  password;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	public int getCjid() {
		return cjid;
	}

	public void setCjid(int cjid) {
		this.cjid = cjid;
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
		this.password = password;
	}




  

	
}