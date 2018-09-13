package com.bangshuo.kuaigong.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @概述： 主要功能是封装了云短信发送验证码功能
 * @文件名： SendSMS.java
 * @作者： 李奎
 * @创建时间： 2017-7-4
 */
public class SendSMSSeven {
	private String mobile;

	/**
	 * 初始化手机号
	 * 
	 * @param mobile 需要发送验证码的手机号
	 */
	public SendSMSSeven(String mobile) {
		this.mobile = mobile;
	}



	public String getAuthCodeSeven() {

		String authCode = "已经连续登录七天了，再接再励！" ;
				
		return authCode;
	}
	
	
	
	/**
	 * 
	 * 发送手机验证码 创建时间：2017-07-04
	 * 100 发送成功 101 验证失败 102 短信不足 103 操作失败 104 非法字符 105
	 * 内容过多 106 号码过多 107 频率过快 108号码内容空 109 账号冻结 110 禁止频繁单条发送 111 系统暂定发送 112
	 * 有错误号码 113 定时时间不对 114 账号被锁，10分钟后登录 115 连接失败 116 禁止接口发送 117 绑定IP不正确 120
	 * 系统升级
	 * 
	 * @return
	 * @throws IOException
	 */

	@SuppressWarnings("deprecation")
	public String sendAuthCodeSeven() throws IOException {

		String authCode = getAuthCodeSeven();

		// 发送内容
		String content = "您" + authCode + "【快工】";

		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://http.yunsms.cn/tx/?");

		// 向StringBuffer追加用户名
		sb.append("uid=22011");

		// 向StringBuffer追加密码（密码采用MD5 32位 小写）
		sb.append("&pwd=0735805d37d6dab48e1d16c2a5a22c23");

		// 向StringBuffer追加手机号码
		sb.append("&mobile=" + mobile);

		// 向StringBuffer追加消息内容转URL标准码
		sb.append("&content=" + URLEncoder.encode(content,"gbk"));
		// System.out.println(sb.toString());
		// 创建url对象
		URL url = new URL(sb.toString());

		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");

		// 发送
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));

		// 返回发送结果
		String inputline = in.readLine();
		
		if(inputline.equals("100")){
			return authCode;
		}else{
			return "消息发送失败！";
		}
	}
	

}
