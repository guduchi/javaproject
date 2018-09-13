package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.EmployeeSendSms;
import com.bangshuo.kuaigong.po.EmployeeSendSmsCount;
import com.bangshuo.kuaigong.po.EmployeeUser;
import com.bangshuo.kuaigong.po.EmployerLocation;
/**
 * 功能：用于3,7天登录与长时间没登录用
 * @author 迟云秋
 *
 */
public interface EmplyeeSendSmsAllMapper {
	//查询连续登陆7天的天数计算查询
	public List<EmployeeSendSmsCount> selectAllCountSevenDay() ;
	//查询连续登陆3天的天数计算查询
	public List<EmployeeSendSmsCount> selectAllCountThreeDay();
	//查询长时间没登陆的
	public List<EmployeeSendSms> selectAllSmsLongDay(EmployeeSendSms smsall);

	//查询连续登陆3天查询
	public List<EmployeeSendSms> selectAllSmstThree(EmployeeSendSms smsall2);
	//查询连续登陆7天查询

	public List<EmployeeSendSms> selectAllSmsSevenDay(EmployeeSendSms smsall);
	//插入对于登录7天的
	public int insertAllSmsSevenDay(EmployeeSendSms smsall);
	//插入对于登录3天的
	public int insertAllSmsThreeDay(EmployeeSendSms smsall2);
    //插入对于长时间没登陆的
	public int insertAllSmsLongDay(EmployeeSendSms smsall);
    //查询发送通知的唯一regid码
	public List<EmployeeUser> selectAllSmsRegid(EmployeeUser smsall2);

}