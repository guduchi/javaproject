package com.bangshuo.kuaigong.mapper;

import java.util.List;

import com.bangshuo.kuaigong.po.DiscountCouponSendTime;
import com.bangshuo.kuaigong.po.EmployeeHourLength;
import com.bangshuo.kuaigong.po.EmployerSendDiscount;
import com.bangshuo.kuaigong.po.EmployerSendDiscountFive;
import com.bangshuo.kuaigong.po.EmployerSendDiscountLong;
import com.bangshuo.kuaigong.po.EmployerSendDiscountStartTime;
import com.bangshuo.kuaigong.po.EmployerSendDiscountThree;
import com.bangshuo.kuaigong.po.SendDispountMoney;
import com.bangshuo.kuaigong.po.SendDispountTimeMessage;

public interface EmployerSendDispountMapper {

	List<EmployerSendDiscount> selectDiscountMessage();

	List<SendDispountTimeMessage> selectDiscountSendMessage(SendDispountTimeMessage sdtm);

	List<SendDispountMoney> selectDiscountSendMoney();

	int insertDiscountSendMessageTimeOne(SendDispountTimeMessage sdtm);

	int insertDiscountSendMessageTime(DiscountCouponSendTime dcs);
	/**
	 * 查询满足使用前三次的满足量
	 * @return
	 */
	List<EmployerSendDiscountThree> selectDiscountMessageThreeCount();
	/**
	 * 查询erid对应的时间避免重复发送
	 * @param erid 
	 * @return
	 */
	List<EmployerSendDiscountStartTime> selectDiscountMessageThreeStartTime(
			int erid);
	/**
	 * 查询出是否存在发送一次三天每次都是用的值
	 * @param sdtm
	 * @return
	 */
	List<SendDispountTimeMessage> selectDiscountSendMessageThree(
			SendDispountTimeMessage sdtm);
	/**
	 * 查询出满足条件的五天没使用的
	 * @return
	 */
	List<EmployerSendDiscountFive> selectDiscountMessageFiveCount();
	/**
	 * 查询5天没登录是否发送过优惠券
	 * @param esdf
	 * @return
	 */
	List<SendDispountTimeMessage> selectDiscountSendMessageFive(
			SendDispountTimeMessage esdf);

	/**
	 * 查询满足长时间登陆的次数个数
	 * @return
	 */
	List<EmployerSendDiscountLong> selectDiscountMessageLongCount();
	/**
	 * 查询是否同一时间发送过优惠卷
	 * @param sdtm
	 * @return
	 */
	List<SendDispountTimeMessage> selectDiscountSendMessageLong(
			SendDispountTimeMessage sdtm);

	/**
	 * 固定刷新看是否满足工作时长
	 * @return
	 */
	public List<EmployeeHourLength> selectHourLength();
	/**
	 * 查询是否多次插入
	 * @param ehl
	 * @return
	 */
	public List<EmployeeHourLength> selectHourLengthTime(EmployeeHourLength ehl) ;
		
	
	public int insertHourLength(EmployeeHourLength ehl);


}
