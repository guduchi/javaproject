package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.SalesmanSignInMapper;
import com.bangshuo.kuaigong.po.SalesmanSignIn;

public class SalesmanSignInService {
	@Autowired
	SalesmanSignInMapper salesmanSignInMapper;
	
public SalesmanSignIn selectNum(String salesmanName,String username,String starttime,String endtime,String status){
		
	SalesmanSignIn list = salesmanSignInMapper.selectNum(salesmanName, username,starttime,endtime,status);
	
	return list;
	}
	
	//查询业务员签到
	public List<SalesmanSignIn>selectSignIn(String salesmanName,String username,String starttime,String endtime,String status){
		
		List<SalesmanSignIn> list =salesmanSignInMapper.selectSignIn(salesmanName, username,starttime,endtime,status);
		
		return list;
	}
	//查询业务员签到分页
	public List<SalesmanSignIn>selectSignInPage(int page,int pageSize,String salesmanName,String username,String starttime,String endtime,String status){
		
		List<SalesmanSignIn> list =salesmanSignInMapper.selectSignInPage(page, pageSize, salesmanName, username,starttime,endtime,status);
		
		return list;
	}

}
