package com.bangshuo.kuaigong.po;

import java.io.Serializable;

public class SalesmanDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private Integer id;
		
		private Integer salesmanId;
		
		private String money;
		
		private String time;
		
		private String desc;
		
		private String totalMoney;
		
		private String count;
		
		private Salesman salesman;

		public Salesman getSalesman() {
			return salesman;
		}

		public void setSalesman(Salesman salesman) {
			this.salesman = salesman;
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

		public Integer getSalesmanId() {
			return salesmanId;
		}

		public void setSalesmanId(Integer salesmanId) {
			this.salesmanId = salesmanId;
		}

		public String getMoney() {
			return money;
		}

		public void setMoney(String money) {
			this.money = money;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
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
	    
	
}
