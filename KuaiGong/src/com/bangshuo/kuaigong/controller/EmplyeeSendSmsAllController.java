package com.bangshuo.kuaigong.controller;

/**
 *   需求：完成三天，7天连续登陆以及长时间不登陆发短信功能。
 *   思想：里面拿出距离当前时间连续的几天看是否连续，最重要一天内登陆的次数不管
 *       多少次取最大的，把满足的发送短信，发完记录发送时间和发送的用户名即电
 *       话号码，进入一个表，以便判断一个人一天发送多次，七天内如果只登陆一次
 *       就算长时间没登录，必须在器天时间里取。
 * @author 迟云秋
 *
 */
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import sun.misc.BASE64Decoder;

import com.bangshuo.kuaigong.po.EmployeeSendSms;
import com.bangshuo.kuaigong.po.EmployeeSendSmsCount;
import com.bangshuo.kuaigong.po.EmployeeUser;
import com.bangshuo.kuaigong.service.EmplyeeSendSmsAllService;
import com.bangshuo.kuaigong.utils.JpushWokerClientUtil;
import com.bangshuo.kuaigong.utils.SendSMS;
import com.bangshuo.kuaigong.utils.SendSMSSeven;

@Controller

public class EmplyeeSendSmsAllController {
	@Autowired
	private EmplyeeSendSmsAllService sendsmsservice ;
	/**
	 * 完成3,7，长时间未登录
	 * @param id
	 * @return
	 */
	@Scheduled(cron="0 0/50 0/1 * * ?")

	public void doWork(){

		//查询所有在七天内登陆的数量
		List<EmployeeSendSmsCount> allsevenday =sendsmsservice.selectAllCountSevenDay();

		EmployeeSendSms smsall = new EmployeeSendSms();
		//解码
		BASE64Decoder decoder = new BASE64Decoder() ;	
		System.out.println(allsevenday);
		//获取当前时间
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date(); 

		String date = sdf.format(now);

		for(int i = 0  ; i < allsevenday.size() ; i++){

			if( allsevenday.get(i).getCountall() == 7){//满足七天登录

				try {
					String username = new String(decoder.decodeBuffer(allsevenday.get(i).getUsername()), "UTF-8");

					smsall.setSendtimeseven(date);
					smsall.setUsername(username);
					List<EmployeeSendSms> querysmsday =sendsmsservice.selectAllSmsSevenDay(smsall);
					//一天只可以发送一次登录信息
					if(querysmsday.size() > 0){

						//System.out.println("7天不可以一天重复发送");
						break ;
					}else{
						//七天登录发送信息
						SendSMSSeven sms = new SendSMSSeven(username) ;
						sms.sendAuthCodeSeven();
						//发送完差插入数据库记录发送时间，便于判断重复发送问题

						int insertsmsall =sendsmsservice.insertAllSmsSevenDay(smsall);

					}

					System.out.println(username+"---"+date);

				} catch (IOException e) {

					e.printStackTrace();
				}
				//长时间没登录
			}else if(allsevenday.get(i).getCountall() == 1){
				EmployeeSendSms smsall2 = new EmployeeSendSms();
				String username3 ;
				try {
					//解码
					username3 = new String(decoder.decodeBuffer(allsevenday.get(i).getUsername()), "UTF-8");
					//设置需要的变量
					smsall2.setUsername(username3);
					smsall2.setSendtimelong(date);
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				//查询长时间没登陆的是否发过通知
				List<EmployeeSendSms> querysmslongday =sendsmsservice.selectAllSmsLongDay(smsall2);
				if(querysmslongday.size() > 0){

					System.out.println("短信已经发过一次了");
					
				}else{
					//极光推送通知类
					JpushWokerClientUtil   employeetime = new JpushWokerClientUtil();
					EmployeeUser empuser = new EmployeeUser();

					//不要再去解密因为数据库是加密的，因此容易出错
					String username4 = allsevenday.get(i).getUsername();
					empuser.setUsername(username4);

					//查询regid唯一以便于发送
					List<EmployeeUser> querysmsregid =sendsmsservice.selectAllSmsRegid(empuser);
					if(querysmsregid.size() > 0){
						//拿出个人唯一的regid码便于发送通知
						String regid = querysmsregid.get(0).getRegid();
						System.out.println(regid);
						//发送满足条件的
						employeetime.sendToRegistrationId(regid,
								"您已长时间没登录！", "kuaigong", "kuaigong", "");
						//发完把发送时间插入表以免一天发送重复了
						int inserttimelong =sendsmsservice.insertAllSmsLongDay(smsall2);
					}
				}
			}
		}

		//查询三天的登录信息数量
		List<EmployeeSendSmsCount> all =sendsmsservice.selectAllCountThreeDay();

		EmployeeSendSms smsall2 = new EmployeeSendSms();
		//满足三天登录
		System.out.println(all);
		for(int i = 0  ; i < all.size() ; i++){
			if( all.get(i).getCountall() == 3){

				try {

					String username2 = new String(decoder.decodeBuffer(all.get(i).getUsername()), "UTF-8");

					smsall2.setSendtimethird(date);
					smsall2.setUsername(username2);
					List<EmployeeSendSms> querysms =sendsmsservice.selectAllSmstThree(smsall2);
					//三天是否存在，发送完一天内，不可以重复发送
					if(querysms.size() > 0){
						//System.out.println("三天不可以一天重复发送");
						break ;
					}else{
						//满足三天发送信息
						SendSMS sms = new SendSMS(username2) ;
						sms.sendAuthCodeThree();
						//发送完差插入数据库记录发送时间，便于判断重复发送问题
						int insertsmsall =sendsmsservice.insertAllSmsThreeDay(smsall2);
					
					}

					System.out.println(username2+"---"+date);

				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}

	}

}
