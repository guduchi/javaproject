package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class WaitTime  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer orderid;

    private String starttime;

    private String endtime;
    
    private String waitStartTime;
    
    private String waitEndTime;

    public String getWaitStartTime() {
		return waitStartTime;
	}

	public void setWaitStartTime(String waitStartTime) {
		this.waitStartTime = waitStartTime;
	}

	public String getWaitEndTime() {
		return waitEndTime;
	}

	public void setWaitEndTime(String waitEndTime) {
		this.waitEndTime = waitEndTime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

}