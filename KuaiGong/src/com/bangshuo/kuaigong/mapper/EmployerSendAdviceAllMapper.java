package com.bangshuo.kuaigong.mapper;

import java.util.List;

import com.bangshuo.kuaigong.po.EmployerSendAdvice;
import com.bangshuo.kuaigong.po.EmployerSendAdviceTime;
/**
 * 
 * @author 迟云秋
 *
 */
public interface EmployerSendAdviceAllMapper {
    /**
     * 查询满足条件的通知者
     * @return
     */
    
	List<EmployerSendAdvice> selectMessageAdviceEmployer();
	/**
     * 查询满足条件的发送时间
     * @return
     */
	List<EmployerSendAdviceTime> selectMessageAdviceTimeEmployer(
			EmployerSendAdviceTime timeall);
	/**
     * 插入进发送时间表便于判断重复发送
     * @return
     */
	int insertTimeAdvice(EmployerSendAdviceTime timeall);

}
