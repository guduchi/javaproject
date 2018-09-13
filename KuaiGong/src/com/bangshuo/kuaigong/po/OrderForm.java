package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class OrderForm  {
    /**
	 * 
	 */


	private Integer id;

    private Integer eeid;

    private Integer erid;

    private String starttime;

    private String endtime;

    private String payment;
    
    private String portrait;

    private String allcost;
    
    private String paymentCancelCount;
    
    private String cancelOrderCount;

    public String getPaymentCancelCount() {
		return paymentCancelCount;
	}

	public void setPaymentCancelCount(String paymentCancelCount) {
		this.paymentCancelCount = paymentCancelCount;
	}

	public String getCancelOrderCount() {
		return cancelOrderCount;
	}

	public void setCancelOrderCount(String cancelOrderCount) {
		this.cancelOrderCount = cancelOrderCount;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	private String actualcost;
    
    private String  status;
    
    private String order_start_time;
    
    private String latitude;
    
    private String longitude;
  
    private String estimatedTimeOfArrival;
    
    private String cost;
    
    private String actualcostSS;
    
    private String count;
    
    private String orderAll;
    
    private String works;
    
    private String single;
    
    private String salesorder;
    
    private String ordercost;
    
    private EmployeeUser employeeUser;
    
    private EmployerUser employerUser;
     
    private String DDtime;
    private String CDtime;
    private String watime;
    private String ChiDaoTime;
    private String miao;
    
    private String paymentWeiXinCount;
    private String paymentWeiXinMoney;
    private String paymentZhiFuBaoCount;
    private String paymentZhiFuBaoMoney;
    private String paymentYueCount;
    private String paymentYueMoney;
    
	private String weiXinMoney;
    private String yueMoney;
    private String zhiFuBaoMoney;

    
    
    
	public String getPaymentWeiXinCount() {
		return paymentWeiXinCount;
	}

	public void setPaymentWeiXinCount(String paymentWeiXinCount) {
		this.paymentWeiXinCount = paymentWeiXinCount;
	}

	public String getPaymentWeiXinMoney() {
		return paymentWeiXinMoney;
	}

	public void setPaymentWeiXinMoney(String paymentWeiXinMoney) {
		this.paymentWeiXinMoney = paymentWeiXinMoney;
	}

	public String getPaymentZhiFuBaoCount() {
		return paymentZhiFuBaoCount;
	}

	public void setPaymentZhiFuBaoCount(String paymentZhiFuBaoCount) {
		this.paymentZhiFuBaoCount = paymentZhiFuBaoCount;
	}

	public String getPaymentZhiFuBaoMoney() {
		return paymentZhiFuBaoMoney;
	}

	public void setPaymentZhiFuBaoMoney(String paymentZhiFuBaoMoney) {
		this.paymentZhiFuBaoMoney = paymentZhiFuBaoMoney;
	}

	public String getPaymentYueCount() {
		return paymentYueCount;
	}

	public void setPaymentYueCount(String paymentYueCount) {
		this.paymentYueCount = paymentYueCount;
	}

	public String getPaymentYueMoney() {
		return paymentYueMoney;
	}

	public void setPaymentYueMoney(String paymentYueMoney) {
		this.paymentYueMoney = paymentYueMoney;
	}

	public String getWeiXinMoney() {
		return weiXinMoney;
	}

	public void setWeiXinMoney(String weiXinMoney) {
		this.weiXinMoney = weiXinMoney;
	}

	public String getYueMoney() {
		return yueMoney;
	}

	public void setYueMoney(String yueMoney) {
		this.yueMoney = yueMoney;
	}

	public String getZhiFuBaoMoney() {
		return zhiFuBaoMoney;
	}

	public void setZhiFuBaoMoney(String zhiFuBaoMoney) {
		this.zhiFuBaoMoney = zhiFuBaoMoney;
	}

	public String getDDtime() {
		return DDtime;
	}

	public void setDDtime(String dDtime) {
		DDtime = dDtime;
	}

	public String getCDtime() {
		return CDtime;
	}

	public void setCDtime(String cDtime) {
		CDtime = cDtime;
	}

	public String getWatime() {
		return watime;
	}

	public void setWatime(String watime) {
		this.watime = watime;
	}

	public String getChiDaoTime() {
		return ChiDaoTime;
	}

	public void setChiDaoTime(String chiDaoTime) {
		ChiDaoTime = chiDaoTime;
	}

	public String getMiao() {
		return miao;
	}

	public void setMiao(String miao) {
		this.miao = miao;
	}


	public EmployeeUser getEmployeeUser() {
		return employeeUser;
	}

	public void setEmployeeUser(EmployeeUser employeeUser) {
		this.employeeUser = employeeUser;
	}

	public EmployerUser getEmployerUser() {
		return employerUser;
	}

	public void setEmployerUser(EmployerUser employerUser) {
		this.employerUser = employerUser;
	}

	public String getOrdercost() {
		return ordercost;
	}

	public void setOrdercost(String ordercost) {
		this.ordercost = ordercost;
	}

	public String getSalesorder() {
		return salesorder;
	}

	public void setSalesorder(String salesorder) {
		this.salesorder = salesorder;
	}

	public String getSingle() {
		return single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	public String getWorks() {
		return works;
	}

	public void setWorks(String works) {
		this.works = works;
	}

	public String getOrderAll() {
		return orderAll;
	}

	public void setOrderAll(String orderAll) {
		this.orderAll = orderAll;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getActualcostSS() {
		return actualcostSS;
	}

	public void setActualcostSS(String actualcostSS) {
		this.actualcostSS = actualcostSS;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getEstimatedTimeOfArrival() {
		return estimatedTimeOfArrival;
	}

	public void setEstimatedTimeOfArrival(String estimatedTimeOfArrival) {
		this.estimatedTimeOfArrival = estimatedTimeOfArrival;
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

    public Integer getErid() {
        return erid;
    }

    public void setErid(Integer erid) {
        this.erid = erid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    public String getAllcost() {
        return allcost;
    }

    public void setAllcost(String allcost) {
        this.allcost = allcost == null ? null : allcost.trim();
    }

    public String getActualcost() {
        return actualcost;
    }

    public void setActualcost(String actualcost) {
        this.actualcost = actualcost == null ? null : actualcost.trim();
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrder_start_time() {
		return order_start_time;
	}

	public void setOrder_start_time(String order_start_time) {
		this.order_start_time = order_start_time;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    
}