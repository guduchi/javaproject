package com.bangshuo.kuaigong.controller;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import sun.misc.BASE64Decoder;

import com.bangshuo.kuaigong.po.DiscountCouponSendTime;
import com.bangshuo.kuaigong.po.EmployerSendDiscount;
import com.bangshuo.kuaigong.po.EmployerSendDiscountFive;
import com.bangshuo.kuaigong.po.EmployerSendDiscountLong;
import com.bangshuo.kuaigong.po.EmployerSendDiscountStartTime;
import com.bangshuo.kuaigong.po.EmployerSendDiscountThree;
import com.bangshuo.kuaigong.po.SendDispountMoney;
import com.bangshuo.kuaigong.po.SendDispountTimeMessage;
import com.bangshuo.kuaigong.service.EmplyerSendDispountAllService;
import com.bangshuo.kuaigong.utils.AliSMS;
import com.bangshuo.kuaigong.utils.JpushClientUtil;
import com.bangshuo.kuaigong.utils.SendSMSCount;

@Controller
public class EmployerSendDiscountController {

	@Autowired 	
	private EmplyerSendDispountAllService senddispountservice ;

	/**
	 * 长时间使用每使用三次发送发送一次优惠券
	 */
	//@Scheduled(cron="0 0/1 0/1 * * ?")   
	public void sendDiscountLong(){
		//获取当前时间
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date(); 
		String date = sdf.format(now);
		//查询满足条件的雇主
		List<EmployerSendDiscountLong>  senddispountlongcount = senddispountservice.selectDiscountMessageLongCount();
		if(senddispountlongcount.size() > 0){
			//查询发送优惠卷的钱数
			List<SendDispountMoney>  selectsendmoney = senddispountservice.selectDiscountSendMoney();

			if(selectsendmoney.size() > 0){
				//满足多少次
				String number = selectsendmoney.get(0).getLongusenumber() ;
				int numberall = Integer.parseInt(number) ;
				//遍历
				for(int i = 0 ; i < senddispountlongcount.size() ; i++){

					//是否大于等于满足的次数
					if(senddispountlongcount.get(i).getSenddiscountall() >= numberall){
						//大于之后的次数
						int count = senddispountlongcount.get(i).getSenddiscountall() -  numberall ;

						if(count % 3 == 0){//满足了总使用每三次发一次

							//长期使用发送优惠券的钱数
							String longnumber = selectsendmoney.get(0).getMoneylong() ;
							String regid = senddispountlongcount.get(i).getRegid() ;
							//发送的名字
							String username = senddispountlongcount.get(i).getUsername() ;
							//最大满足次数的时间 
							String starttime = senddispountlongcount.get(i).getStarttime() ;
							String name = senddispountlongcount.get(i).getName() ;

							int eridall = senddispountlongcount.get(i).getErid() ;

							SendDispountTimeMessage  sdtm = new SendDispountTimeMessage();
							//设置值
							sdtm.setSendusername(username) ;
							sdtm.setSenddiscountlong(starttime) ;
							//查询便于判断重复发送
							List<SendDispountTimeMessage>  selectsenddispountfive = senddispountservice.selectDiscountSendMessageLong(sdtm);
							if(selectsenddispountfive.size() <=0){
							
								//没有插入判断重复插入表
								int  insertsenddispounttime = senddispountservice.insertDiscountSendMessageTimeOne(sdtm);
								DiscountCouponSendTime  dcs = new DiscountCouponSendTime();
								dcs.setErid(eridall);
								dcs.setEndtime(date);
								dcs.setMoney(longnumber);
								//插入优惠卷
								int  insertsenddispount = senddispountservice.insertDiscountSendMessageTime(dcs);

								System.out.println(insertsenddispount);
								if(insertsenddispount > 0){
						
									//解码
									BASE64Decoder decoder = new BASE64Decoder() ;	

									try {

										String username2 = new String(decoder.decodeBuffer(username), "UTF-8");
										String usename = new String(decoder.decodeBuffer(name), "UTF-8");

										System.out.println(username2);
										System.out.println("regid="+regid);
										if(username2!=null&&!"".equals(username2)){
											AliSMS sms = new AliSMS();
											try {
												sms.sendDiscountCoupon(username2, usename, "1张", longnumber);
												
											} catch (Exception e) {
												e.printStackTrace();
											}
											/*SendSMSCount sms = new SendSMSCount(username2) ;
											sms.sendAuthCodeThree();*/

											
										}if(!regid.equals("exit")){
											
											JpushClientUtil jcl = new JpushClientUtil();
											jcl.sendToRegistrationId(regid,
													"亲，您的优惠券已到达，请您注意查收！", "123456", "123", "");
											
										}
											
											
										

									} catch (UnsupportedEncodingException e) {
										e.printStackTrace();
									} catch (IOException e) {
										e.printStackTrace();
									}

								}

							}

						}

					}


				}

			}


		}else{

			System.out.println("没有满足条件的！");

		}

	}

	/**
	 * 超过5天没有订单发送优惠卷
	 */
	//	@Scheduled(cron="0 0/1 0/1 * * ?")   
	public void sendDiscountFive(){
		//获取当前时间
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date(); 
		String date = sdf.format(now);
		List<EmployerSendDiscountFive>  senddispountfivecount = senddispountservice.selectDiscountMessageFiveCount();
		if(senddispountfivecount.size() > 0){
			for(int i = 0 ; i < senddispountfivecount.size() ; i++ ){

				int  emperidfive = senddispountfivecount.get(i).getEmperidfive() ; //雇主id
				String empusername = senddispountfivecount.get(i).getEmpusername();
				String empregid = senddispountfivecount.get(i).getEmpregid();
				String empstarttime = senddispountfivecount.get(i).getEmpstarttime();
				String empname = senddispountfivecount.get(i).getEmpname();

				SendDispountTimeMessage  sdtm = new SendDispountTimeMessage();
				sdtm.setSendusername(empusername);
				sdtm.setSenddiscountfive(empstarttime);
				List<SendDispountTimeMessage>  selectsenddispountfive = senddispountservice.selectDiscountSendMessageFive(sdtm);
				if(selectsenddispountfive.size() <= 0){//没发送除了发送还要插入新数据

					int  insertsenddispounttime = senddispountservice.insertDiscountSendMessageTimeOne(sdtm);

					List<SendDispountMoney>  selectsendmoney = senddispountservice.selectDiscountSendMoney();
					if(selectsendmoney.size() > 0){

						String fivemoneyall = selectsendmoney.get(0).getMoneyfive() ;
						DiscountCouponSendTime  dcs = new DiscountCouponSendTime();
						dcs.setErid(emperidfive);
						dcs.setEndtime(date);
						dcs.setMoney(fivemoneyall);
						//插入优惠卷
						int  insertsenddispount = senddispountservice.insertDiscountSendMessageTime(dcs);

						if(insertsenddispount > 0){

							//解码
							BASE64Decoder decoder = new BASE64Decoder() ;	

							try {

								String username2 = new String(decoder.decodeBuffer(empusername), "UTF-8");
								String empnameuse = new String(decoder.decodeBuffer(empname), "UTF-8");

								System.out.println(username2);

								if(username2!=null&&!"".equals(username2)){

									AliSMS sms = new AliSMS();
									try {
										sms.sendDiscountCoupon(username2, empnameuse, "1张", fivemoneyall);
										
									} catch (Exception e) {
										e.printStackTrace();
									}
								}


								if(!empregid.equals("exit")){

									JpushClientUtil jcl = new JpushClientUtil();
									jcl.sendToRegistrationId(empregid,
											"亲，您的优惠券已到，请您注意查收！！", "123456", "123", "");
								}

							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}

						}

					}


				}


			}


		}else{


			System.out.println("没有满足条件的");


		}

	}

	//@Scheduled(cron="0 0/1 0/1 * * ?")   

	/**
	 * 完成注册后使用前三次每次都发优惠卷
	 */
	
	public void sendDiscountThree(){   

		List<EmployerSendDiscountThree>  senddispountthreecount = senddispountservice.selectDiscountMessageThreeCount();
		List<EmployerSendDiscountStartTime>  senddispountthreecounttime ;
		//获取当前时间
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date(); 
		String date = sdf.format(now);
		if(senddispountthreecount.size() > 0){
			for(int i = 0 ; i < senddispountthreecount.size() ;i++){
				//获取erid
				int erid = senddispountthreecount.get(i).getErid();
				String regid = senddispountthreecount.get(i).getRegid();
				String username = senddispountthreecount.get(i).getUsername();
				//第一次使用注册
				String name = senddispountthreecount.get(i).getName();

				if(senddispountthreecount.get(i).getSendcount() == 1){

					senddispountthreecounttime = senddispountservice.selectDiscountMessageThreeStartTime(erid);
					if(senddispountthreecounttime.size() > 0){
						//拿到第一次使用的时间通过erid查询到
						String starttime = senddispountthreecounttime.get(0).getStarttimesend();
						SendDispountTimeMessage  sdtm = new SendDispountTimeMessage();
						sdtm.setSendusername(username);
						sdtm.setSenddiscountthree(starttime) ;
						List<SendDispountTimeMessage>  selectsenddispount = senddispountservice.selectDiscountSendMessageThree(sdtm);
						if(selectsenddispount.size() <= 0){
							int  insertsenddispounttime = senddispountservice.insertDiscountSendMessageTimeOne(sdtm);

							List<SendDispountMoney>  selectsendmoney = senddispountservice.selectDiscountSendMoney();
							if(selectsendmoney.size() > 0){

								String threemoneyall = selectsendmoney.get(0).getMoneythree() ;
								DiscountCouponSendTime  dcs = new DiscountCouponSendTime();
								dcs.setErid(erid);
								dcs.setEndtime(date);
								dcs.setMoney(threemoneyall);
								//插入优惠卷
								int  insertsenddispount = senddispountservice.insertDiscountSendMessageTime(dcs);
								System.out.println(insertsenddispount);
								if(insertsenddispount > 0){

									//解码
									BASE64Decoder decoder = new BASE64Decoder() ;	

									try {

										String username2 = new String(decoder.decodeBuffer(username), "UTF-8");
										String usename = new String(decoder.decodeBuffer(name), "UTF-8");

										System.out.println(username2);

										if(username2!=null&&!"".equals(username2)){


											AliSMS sms = new AliSMS();
											try {
												sms.sendDiscountCoupon(username2, usename, "1张", threemoneyall);
												
											} catch (Exception e) {
												e.printStackTrace();
											}

										}


										if(!regid.equals("exit")){

											JpushClientUtil jcl = new JpushClientUtil();
											jcl.sendToRegistrationId(regid,
													"亲，您的优惠券已到，请您注意查收！", "123456", "123", "");
										}

									} catch (UnsupportedEncodingException e) {
										e.printStackTrace();
									} catch (IOException e) {
										e.printStackTrace();
									}

								}

							}
						}

					}


				}else if(senddispountthreecount.get(i).getSendcount() == 2){//注册第二次使用

					senddispountthreecounttime = senddispountservice.selectDiscountMessageThreeStartTime(erid);
					if(senddispountthreecounttime.size() > 0){
						//拿到第一次使用的时间通过erid查询到
						String starttime = senddispountthreecounttime.get(0).getStarttimesend();
						SendDispountTimeMessage  sdtm = new SendDispountTimeMessage();
						sdtm.setSendusername(username);
						sdtm.setSenddiscountthree(starttime) ;
						List<SendDispountTimeMessage>  selectsenddispount = senddispountservice.selectDiscountSendMessageThree(sdtm);
						if(selectsenddispount.size() <= 0){
							int  insertsenddispounttime = senddispountservice.insertDiscountSendMessageTimeOne(sdtm);

							List<SendDispountMoney>  selectsendmoney = senddispountservice.selectDiscountSendMoney();
							if(selectsendmoney.size() > 0){

								String threemoneyall = selectsendmoney.get(0).getMoneythree() ;
								DiscountCouponSendTime  dcs = new DiscountCouponSendTime();
								dcs.setErid(erid);
								dcs.setEndtime(date);
								dcs.setMoney(threemoneyall);
								//插入优惠卷
								int  insertsenddispount = senddispountservice.insertDiscountSendMessageTime(dcs);
								System.out.println(insertsenddispount);
								if(insertsenddispount > 0){

									//解码
									BASE64Decoder decoder = new BASE64Decoder() ;	

									try {
										String usename = new String(decoder.decodeBuffer(name), "UTF-8");
                                        String username2 = new String(decoder.decodeBuffer(username), "UTF-8");
										System.out.println(username2);

										if(username2!=null&&!"".equals(username2)){


											AliSMS sms = new AliSMS();
											try {
												sms.sendDiscountCoupon(username2, usename, "1张", threemoneyall);
												
											} catch (Exception e) {
												e.printStackTrace();
											}

										}


										if(!regid.equals("exit")){

											JpushClientUtil jcl = new JpushClientUtil();
											jcl.sendToRegistrationId(regid,
													"亲，您的优惠券已到，请您注意查收！", "123456", "123", "");
										}

									} catch (UnsupportedEncodingException e) {
										e.printStackTrace();
									} catch (IOException e) {
										e.printStackTrace();
									}

								}
							}
						}


					}

				}else if(senddispountthreecount.get(i).getSendcount() == 3){//注册第三次使用


					senddispountthreecounttime = senddispountservice.selectDiscountMessageThreeStartTime(erid);
					if(senddispountthreecounttime.size() > 0){
						//拿到第一次使用的时间通过erid查询到
						String starttime = senddispountthreecounttime.get(0).getStarttimesend();
						SendDispountTimeMessage  sdtm = new SendDispountTimeMessage();
						sdtm.setSendusername(username);
						sdtm.setSenddiscountthree(starttime) ;
						List<SendDispountTimeMessage>  selectsenddispount = senddispountservice.selectDiscountSendMessageThree(sdtm);
						if(selectsenddispount.size() <= 0){
							int  insertsenddispounttime = senddispountservice.insertDiscountSendMessageTimeOne(sdtm);

							List<SendDispountMoney>  selectsendmoney = senddispountservice.selectDiscountSendMoney();
							if(selectsendmoney.size() > 0){

								String threemoneyall = selectsendmoney.get(0).getMoneythree() ;
								DiscountCouponSendTime  dcs = new DiscountCouponSendTime();
								dcs.setErid(erid);
								dcs.setEndtime(date);
								dcs.setMoney(threemoneyall);
								//插入优惠卷
								int  insertsenddispount = senddispountservice.insertDiscountSendMessageTime(dcs);
								System.out.println(insertsenddispount);
								if(insertsenddispount > 0){

									//解码
									BASE64Decoder decoder = new BASE64Decoder() ;	

									try {
										String usename = new String(decoder.decodeBuffer(name), "UTF-8");
										String username2 = new String(decoder.decodeBuffer(username), "UTF-8");
										System.out.println(username2);

										if(username2!=null&&!"".equals(username2)){


											AliSMS sms = new AliSMS();
											try {
												sms.sendDiscountCoupon(username2, usename, "1张", threemoneyall);
												
											} catch (Exception e) {
												e.printStackTrace();
											}

										}


										if(!regid.equals("exit")){

											JpushClientUtil jcl = new JpushClientUtil();
											jcl.sendToRegistrationId(regid,
													"亲，您的优惠券已到，请您注意查收！", "123456", "123", "");
										}

									} catch (UnsupportedEncodingException e) {
										e.printStackTrace();
									} catch (IOException e) {
										e.printStackTrace();
									}

								}




							}
						}

					}


				}


			}

		}

	}

//注册
	//@Scheduled(cron="0 0/1 0/1 * * ?")   

	public void sendDiscount(){   

		List<EmployerSendDiscount>  senddispount = senddispountservice.selectDiscountMessage();

		if(senddispount.size() > 0){

			for(int i = 0 ; i < senddispount.size() ; i++){

				int erid = senddispount.get(i).getId();
				String senddiscountstart = senddispount.get(i).getTime();
				String sendusername = senddispount.get(i).getUsername();
				String regid = senddispount.get(i).getRegid();
				String name = senddispount.get(i).getName();

				SendDispountTimeMessage  sdtm = new SendDispountTimeMessage();
				sdtm.setSendusername(sendusername);
				sdtm.setSenddiscountstart(senddiscountstart);

				List<SendDispountTimeMessage>  selectsenddispount = senddispountservice.selectDiscountSendMessage(sdtm);

				if(selectsenddispount.size() <= 0){


					int  insertsenddispounttime = senddispountservice.insertDiscountSendMessageTimeOne(sdtm);

					List<SendDispountMoney>  selectsendmoney = senddispountservice.selectDiscountSendMoney();

					if(selectsendmoney.size() > 0){

						String money = selectsendmoney.get(0).getMoneyone();
						//获取当前时间
						SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date now = new Date(); 
						String date = sdf.format(now);

						DiscountCouponSendTime  dcs = new DiscountCouponSendTime();
						dcs.setErid(erid);
						dcs.setEndtime(date);
						dcs.setMoney(money);
						int  insertsenddispount = senddispountservice.insertDiscountSendMessageTime(dcs);
						System.out.println(insertsenddispount);
						if(insertsenddispount > 0){

							//解码
							BASE64Decoder decoder = new BASE64Decoder() ;	

							try {

								String username = new String(decoder.decodeBuffer(sendusername), "UTF-8");
								String usename = new String(decoder.decodeBuffer(name), "UTF-8");

								System.out.println(username);

								if(username!=null&&!"".equals(username)&&usename!=null){


									AliSMS sms = new AliSMS();
									try {
										
										sms.sendDiscountCoupon(username, usename, "1张", money);
										
									} catch (Exception e) {
										e.printStackTrace();
									}

								}
							if(!regid.equals("exit")){
								
								JpushClientUtil jcl = new JpushClientUtil();
								jcl.sendToRegistrationId(regid,
										"亲，您的优惠券已到，请您注意查收！", "123456", "123", "");
								
							}
							
								
							} catch (UnsupportedEncodingException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}

						}

					}else{

						break;

					}

				}


			}


		}


	}   

}
