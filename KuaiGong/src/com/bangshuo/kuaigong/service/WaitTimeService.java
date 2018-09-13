package com.bangshuo.kuaigong.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.WaitTimeMapper;
import com.bangshuo.kuaigong.po.WaitTime;

public class WaitTimeService {
	@Autowired WaitTimeMapper waitTimeMapper;
	public int insertOrderidAndStartTime(int orderid){
		int result = waitTimeMapper.insertOrderidAndStartTime(orderid);
		return result;
	}
	public WaitTime selectByOrderid(Integer orderid){
		WaitTime waitTime = waitTimeMapper.selectByOrderid(orderid);
		return waitTime;
	}
	public int updateByOrderid(Integer orderid){
		int result = waitTimeMapper.updateByOrderid(orderid);
		return result;
	}
}
