package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class SalesmanWallet   implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer salesmanId;

    private Double balance;

    private String latelyUse;

    private String time;
    
    private String count;

    public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getLatelyUse() {
		return latelyUse;
	}

	public void setLatelyUse(String latelyUse) {
		this.latelyUse = latelyUse;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(Integer salesmanId) {
		this.salesmanId = salesmanId;
	}

	public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}