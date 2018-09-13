package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.bangshuo.kuaigong.mapper.EmplyeeSendSmsAllMapper;
import com.bangshuo.kuaigong.po.EmployeeSendSms;
import com.bangshuo.kuaigong.po.EmployeeSendSmsCount;
import com.bangshuo.kuaigong.po.EmployeeUser;
import com.bangshuo.kuaigong.po.EmplyeeSendSmsAll;
/**
 * 功能：用于3,7天登录与长时间没登录用
 * @author 迟云秋
 *
 */
public class EmplyeeSendSmsAllService {
	
    @Autowired
    EmplyeeSendSmsAllMapper  emplyeeSendSmsAllMapper ;
    
    /**
     * 查询连续登陆7天的天数计算查询
     * @return
     */
	public List<EmployeeSendSmsCount> selectAllCountSevenDay() {
		return emplyeeSendSmsAllMapper.selectAllCountSevenDay();
	}
	/**
	 * 查询连续登陆3天的天数计算查询
	 * @return
	 */
	
	public List<EmployeeSendSmsCount> selectAllCountThreeDay() {
		return emplyeeSendSmsAllMapper.selectAllCountThreeDay();
	}
	/**
	 * 查询连续登陆7天查询
	 * @param smsall 发短信po类
	 * @return
	 */
	
	public List<EmployeeSendSms> selectAllSmsSevenDay(EmployeeSendSms smsall) {
		return emplyeeSendSmsAllMapper.selectAllSmsSevenDay(smsall);
	}
	/**
	 * 查询连续登陆3天查询
	 * @param smsall2 发短信po类
	 * @return
	 */
	
	public List<EmployeeSendSms> selectAllSmstThree(EmployeeSendSms smsall2) {
		return emplyeeSendSmsAllMapper.selectAllSmstThree(smsall2);
	}
	/**
	 * 插入对于登录7天的
	 * @param smsall 发短信po类
	 * @return
	 */
	
	public int insertAllSmsSevenDay(EmployeeSendSms smsall) {
		return emplyeeSendSmsAllMapper.insertAllSmsSevenDay(smsall);
	}
	/**
	 * 插入对于登录3天的
	 * @param smsall2  发短信po类
	 * @return
	 */
	
	public int insertAllSmsThreeDay(EmployeeSendSms smsall2) {
		return emplyeeSendSmsAllMapper.insertAllSmsThreeDay(smsall2);
	}
	/**
	 * 查询长时间没登陆的
	 * @param smsall 发短信po类
	 * @return
	 */
	
	public List<EmployeeSendSms> selectAllSmsLongDay(EmployeeSendSms smsall) {
		return emplyeeSendSmsAllMapper.selectAllSmsLongDay(smsall);
	}
	/**
	 * 插入对于长时间没登陆的
	 * @param smsall 发短信po类
	 * @return
	 */
	 
	public int insertAllSmsLongDay(EmployeeSendSms smsall) {
		return emplyeeSendSmsAllMapper.insertAllSmsLongDay(smsall);
	}
	
	/**
	 * 查询发送通知的唯一regid码
	 * @param smsall2 员工po类
	 * @return
	 */
	public List<EmployeeUser> selectAllSmsRegid(EmployeeUser smsall2) {
		return emplyeeSendSmsAllMapper.selectAllSmsRegid(smsall2);
	}

}
