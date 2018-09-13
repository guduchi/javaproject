package com.bangshuo.kuaigong.mapper;

import java.util.List;

import com.bangshuo.kuaigong.po.CancelOrder;



public interface CancelOrderMapper {

	//添加到取消订单表
	int insertOrderByPrimaryKey(Integer orderid);
	//查询取消订单表
	List<CancelOrder>selectCancelOrder(Integer id);
}
