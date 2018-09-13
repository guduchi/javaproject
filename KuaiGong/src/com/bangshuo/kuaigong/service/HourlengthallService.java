package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.HourlengthallMapper;
import com.bangshuo.kuaigong.po.EmployeeHourLength;

public class HourlengthallService {

	
	@Autowired
	HourlengthallMapper employeeHourLengthMapper;
	
	
	public List<EmployeeHourLength>selectHourLength(String name,String username){
		
		List<EmployeeHourLength> list = employeeHourLengthMapper.selectHourLength(name, username);
		
		return list;
	}
	
	public List<EmployeeHourLength>selectHourLengthPgae(int page,int pageSize,String name,String username){
		
		List<EmployeeHourLength> list = employeeHourLengthMapper.selectHourLengthPgae(page, pageSize, name, username);
		
		return list;
	}
	
	public EmployeeHourLength selectNum(String name,String username){
		
		EmployeeHourLength	list=employeeHourLengthMapper.selectNum(name, username);
		
		return list;
	}
}
