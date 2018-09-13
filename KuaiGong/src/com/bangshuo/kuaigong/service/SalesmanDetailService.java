package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.SalesmanDetailMapper;
import com.bangshuo.kuaigong.po.SalesmanDetail;

public class SalesmanDetailService {
  
	@Autowired
	
	SalesmanDetailMapper salesmanDetailMapper;
	
	//查询信息条数
	public SalesmanDetail selectNum(String salesmanName,String username,String desc,String starttime,String endtime){
	
		SalesmanDetail list = salesmanDetailMapper.selectNum(salesmanName, username, desc, starttime, endtime);
		
		return list;
	}
	//查询业务员的钱
	public List<SalesmanDetail> selectMoney(String salesmanName,String username,String desc,String starttime,String endtime){
	
		List<SalesmanDetail> list =salesmanDetailMapper.selectMoney(salesmanName, username, desc, starttime, endtime);
	
		return list;
	}
	//查询业务员的钱分页
	public List<SalesmanDetail> selectMoneyPage(int page,int pageSize,String salesmanName,String username,String desc,String starttime,String endtime){
		
		List<SalesmanDetail> list =salesmanDetailMapper.selectMoneyPage(page, pageSize,salesmanName, username, desc, starttime, endtime);
	
		return list;
	}
}
