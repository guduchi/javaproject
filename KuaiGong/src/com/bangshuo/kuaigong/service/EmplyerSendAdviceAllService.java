package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.EmployerSendAdviceAllMapper;
import com.bangshuo.kuaigong.po.EmployerSendAdvice;
import com.bangshuo.kuaigong.po.EmployerSendAdviceTime;
/**
 * 
 * @author 迟云秋
 *
 */

public class EmplyerSendAdviceAllService {

    @Autowired
    EmployerSendAdviceAllMapper  emplyerSendAdviceAllMapper ;
    /**
     * 查询满足条件的通知者
     * @return
     */
	public List<EmployerSendAdvice> selectMessageAdviceEmployer() {
		
		return emplyerSendAdviceAllMapper.selectMessageAdviceEmployer();
	}
	/**
     * 查询满足条件的发送时间
     * @return
     */
	public List<EmployerSendAdviceTime> selectMessageAdviceTimeEmployer(EmployerSendAdviceTime timeall) {
		return emplyerSendAdviceAllMapper.selectMessageAdviceTimeEmployer(timeall);
	}
	/**
     * 插入进发送时间表便于判断重复发送
     * @return
     */
	public int insertTimeAdvice(EmployerSendAdviceTime timeall) {
		return emplyerSendAdviceAllMapper.insertTimeAdvice(timeall);
	}


	
	

}
