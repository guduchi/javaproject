package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.EmployerSendDispountMapper;
import com.bangshuo.kuaigong.po.DiscountCouponSendTime;
import com.bangshuo.kuaigong.po.EmployeeHourLength;
import com.bangshuo.kuaigong.po.EmployerSendDiscount;
import com.bangshuo.kuaigong.po.EmployerSendDiscountFive;
import com.bangshuo.kuaigong.po.EmployerSendDiscountLong;
import com.bangshuo.kuaigong.po.EmployerSendDiscountStartTime;
import com.bangshuo.kuaigong.po.EmployerSendDiscountThree;
import com.bangshuo.kuaigong.po.SendDispountMoney;
import com.bangshuo.kuaigong.po.SendDispountTimeMessage;

public class EmplyerSendDispountAllService {
	@Autowired
	EmployerSendDispountMapper  emplyerSendDispountAllMapper ;
	public List<EmployerSendDiscount> selectDiscountMessage() {
		return emplyerSendDispountAllMapper.selectDiscountMessage();
	}
	public List<SendDispountTimeMessage> selectDiscountSendMessage(
			SendDispountTimeMessage sdtm) {
		return emplyerSendDispountAllMapper.selectDiscountSendMessage(sdtm);
	}
	public List<SendDispountMoney> selectDiscountSendMoney() {
		return emplyerSendDispountAllMapper.selectDiscountSendMoney();
	}
	public int insertDiscountSendMessageTimeOne(SendDispountTimeMessage sdtm) {
		return emplyerSendDispountAllMapper.insertDiscountSendMessageTimeOne(sdtm);
	}
	public int insertDiscountSendMessageTime(DiscountCouponSendTime dcs) {
		return emplyerSendDispountAllMapper.insertDiscountSendMessageTime(dcs);
	}
	/**
	 * 查询满足使用前三次的满足量
	 * @return
	 */
	public List<EmployerSendDiscountThree> selectDiscountMessageThreeCount() {
		
		return emplyerSendDispountAllMapper.selectDiscountMessageThreeCount();
	}
	/**
	 * 查询erid对应的时间避免重复发送
	 * @param erid 
	 * @return
	 */
	public List<EmployerSendDiscountStartTime> selectDiscountMessageThreeStartTime(int erid) {
		// TODO Auto-generated method stub
		return emplyerSendDispountAllMapper.selectDiscountMessageThreeStartTime(erid);
	}
	/**
	 * 查询出是否存在发送一次三天每次都是用的值
	 * @param sdtm
	 * @return
	 */
	public List<SendDispountTimeMessage> selectDiscountSendMessageThree(
			SendDispountTimeMessage sdtm) {
		// TODO Auto-generated method stub
		return emplyerSendDispountAllMapper.selectDiscountSendMessageThree(sdtm);
	}
	/**
	 * 查询出满足条件的五天没使用的
	 * @return
	 */
	public List<EmployerSendDiscountFive> selectDiscountMessageFiveCount() {
		return emplyerSendDispountAllMapper.selectDiscountMessageFiveCount();
	}
	/**
	 * 查询5天没登录是否发送过优惠券
	 * @param esdf
	 * @return
	 */
	public List<SendDispountTimeMessage> selectDiscountSendMessageFive(
			SendDispountTimeMessage esdf) {
		return emplyerSendDispountAllMapper.selectDiscountSendMessageFive(esdf);
	}
	/**
	 * 查询满足长时间登陆的次数个数
	 * @return
	 */
	public List<EmployerSendDiscountLong> selectDiscountMessageLongCount() {
		return emplyerSendDispountAllMapper.selectDiscountMessageLongCount();
	}
	/**
	 * 查询是否同一时间发送过优惠卷
	 * @param sdtm
	 * @return
	 */
	public List<SendDispountTimeMessage> selectDiscountSendMessageLong(
			SendDispountTimeMessage sdtm) {
		return emplyerSendDispountAllMapper.selectDiscountSendMessageLong(sdtm);
	}

	/**
	 * 固定刷新看是否满足工作时长
	 * @return
	 */
	public List<EmployeeHourLength> selectHourLength() {
		return emplyerSendDispountAllMapper.selectHourLength() ;
	}
	/**
	 * 查询是否多次插入
	 * @param ehl
	 * @return
	 */
	public List<EmployeeHourLength> selectHourLengthTime(EmployeeHourLength ehl) {
		return emplyerSendDispountAllMapper.selectHourLengthTime(ehl);
	}
	public int insertHourLength(EmployeeHourLength ehl) {
		return emplyerSendDispountAllMapper.insertHourLength(ehl);
	}


}
