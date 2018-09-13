package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class EmployeeUser  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String username;

    private String password;

    private String name;

    private String sex;

    private String age;

    private String idcard;

    private String address;

    private String hand;

    private String scan;

    private String portrait;

    private String status;
    
    private String time;

    private String regid;
 
    private String onlineStatus;
    
    private Integer salesmanId;
    
    private String count;
    
    private String withdrawal;
    
    private String salesemployeeuser;

	public String getSalesemployeeuser() {
		return salesemployeeuser;
	}

	public void setSalesemployeeuser(String salesemployeeuser) {
		this.salesemployeeuser = salesemployeeuser;
	}

	public String getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(String withdrawal) {
		this.withdrawal = withdrawal;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Integer getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(Integer salesmanId) {
		this.salesmanId = salesmanId;
	}

	public String getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(String onlineStatus) {
		this.onlineStatus = onlineStatus;
	}

	public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status== null ? null : status.trim();;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
       
    	this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand == null ? null : hand.trim();
    }

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan == null ? null : scan.trim();
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait == null ? null : portrait.trim();
    }

	public String getRegid() {
		return regid;
	}

	public void setRegid(String regid) {
		this.regid = regid;
	}
	
    
}