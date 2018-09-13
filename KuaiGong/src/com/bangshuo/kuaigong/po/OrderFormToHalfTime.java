package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class OrderFormToHalfTime extends OrderForm   implements Serializable{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String starttime;

	  private String endtime;

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
	
}
