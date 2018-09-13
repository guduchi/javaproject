package com.bangshuo.kuaigong.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bangshuo.kuaigong.po.EmployerSendAdvice;
import com.bangshuo.kuaigong.po.EmployerSendAdviceTime;
import com.bangshuo.kuaigong.service.EmplyerSendAdviceAllService;
import com.bangshuo.kuaigong.utils.JpushWokerClientUtil;

/**  雇主：
 *   需求：完成三天连续有订单。
 *   
 * @author 迟云秋
 *
 */
@Controller
public class EmployerSendAdviceAllController {

	@Autowired
	private EmplyerSendAdviceAllService sendadviceservice ;

	public void doWorkEmployer(){
		//获取当前时间
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date(); 
		String date = sdf.format(now);
		//查询满足条件所需数据
		List<EmployerSendAdvice> emplyersendadvice =sendadviceservice.selectMessageAdviceEmployer();
		EmployerSendAdviceTime timeall = new EmployerSendAdviceTime();
		if(emplyersendadvice.size() > 0){
			for(int i = 0 ; i < emplyersendadvice.size() ; i++){
                //满足三天有订单
				if(emplyersendadvice.get(i).getCountallemployer() == 3){

					String regidemployer = emplyersendadvice.get(i).getRegidemployer();
					System.out.println(regidemployer);
					String usernameemployer = emplyersendadvice.get(i).getUsernameemployer();
					System.out.println(usernameemployer);
					//看有没有时间重复发送
					timeall.setTimeemployer(date);
					timeall.setUsernameemployer(usernameemployer);
					List<EmployerSendAdviceTime> emplyersendadvicetime =sendadviceservice.selectMessageAdviceTimeEmployer(timeall);
                    if(emplyersendadvicetime.size() > 0){
                    	
                    	System.out.println("同一时间已经发过一次了");
                    	
                    	break ;
                    	
                    }else{
                    	
                    	//极光推送通知类
                    	JpushWokerClientUtil   employeetime = new JpushWokerClientUtil();
    					employeetime.sendToRegistrationId(regidemployer,
								"您已连续三天有订单！", "kuaigong", "kuaigong", "");
    					timeall.setTimeemployer(date);
    					timeall.setUsernameemployer(usernameemployer);
						int inserttimelong =sendadviceservice.insertTimeAdvice(timeall);
					    
                    }

				}

			}


		}

	}

}
