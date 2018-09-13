package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class WithdrawDeposit  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer eeid;

    private String cash;

    private String time;

    private String desc;
    
    private String totalMoney;
    
    private String queryCount;
    
    private String count;
    
    private String queryEarningsAll;
    private String  withdrawConunt;
    
    public String getWithdrawConunt() {
		return withdrawConunt;
	}

	public void setWithdrawConunt(String withdrawConunt) {
		this.withdrawConunt = withdrawConunt;
	}

	public String getQueryEarningsAll() {
		return queryEarningsAll;
	}

	public void setQueryEarningsAll(String queryEarningsAll) {
		this.queryEarningsAll = queryEarningsAll;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getQueryCount() {
		return queryCount;
	}

	public void setQueryCount(String queryCount) {
		this.queryCount = queryCount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEeid() {
        return eeid;
    }

    public void setEeid(Integer eeid) {
        this.eeid = eeid;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash == null ? null : cash.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}