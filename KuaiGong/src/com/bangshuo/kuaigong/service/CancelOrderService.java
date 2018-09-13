package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.CancelOrderMapper;
import com.bangshuo.kuaigong.po.CancelOrder;


public class CancelOrderService {

	@Autowired
	CancelOrderMapper cancelOrderMapper;
	
	//添加到取消订单表
	public int insertOrderByPrimaryKey(Integer orderid) {

		int result = cancelOrderMapper.insertOrderByPrimaryKey(orderid);

		return result;
	}
	
	//查询取消订单表
	public List<CancelOrder> selectCancelOrder(int id){
		
		List<CancelOrder> list = cancelOrderMapper.selectCancelOrder(id);
		
		return list;
		
	}
}
