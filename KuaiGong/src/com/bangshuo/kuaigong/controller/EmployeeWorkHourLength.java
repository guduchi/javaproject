package com.bangshuo.kuaigong.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.bangshuo.kuaigong.po.EmployeeHourLength;
import com.bangshuo.kuaigong.service.EmplyerSendDispountAllService;

@Controller
public class EmployeeWorkHourLength {

	@Autowired 	
	private EmplyerSendDispountAllService sendhourlengthservice ;


	@Scheduled(cron="0 58 23 * * ?")   
//	@Scheduled(cron="0 58 23 * * ?")   

	public void workHourLength(){
		
		List<EmployeeHourLength>   selecthourlength = sendhourlengthservice.selectHourLength();
		//获取当前时间
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date now = new Date(); 
		String date = sdf.format(now);
		EmployeeHourLength  ehl = new EmployeeHourLength();
		if(selecthourlength.size() > 0){
			
			for(int i = 0 ; i < selecthourlength.size() ; i++){
				ehl.setEeid(selecthourlength.get(i).getEeid());
				ehl.setHourlength(selecthourlength.get(i).getHourlength());
			
				
				List<EmployeeHourLength>   selecthourlengthtime  = sendhourlengthservice.selectHourLengthTime(ehl);
				if(selecthourlengthtime.size() <= 0){
					ehl.setFlushtime(date);
					
				    int inserthourlength = sendhourlengthservice.insertHourLength(ehl);
				    System.out.println(inserthourlength);
					
				}
				
			
			}
			
		}

		
	}
	
     

}
