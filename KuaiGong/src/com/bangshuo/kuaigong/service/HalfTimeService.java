package com.bangshuo.kuaigong.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.HalfTimeMapper;
import com.bangshuo.kuaigong.po.HalfTime;

public class HalfTimeService {
	
	@Autowired
	HalfTimeMapper halfTimeMapper;

	public HalfTime query(int id){
   	 
		HalfTime list = halfTimeMapper.selectByPrimaryKey(id);
    	
    	return list;
    }
    
    public int insert(HalfTime halfTime){
    	
		int list = halfTimeMapper.insert(halfTime);
		
		return list;
    }
    
    public int insertSelective(HalfTime halfTime){
    	int list = halfTimeMapper.insertSelective(halfTime);
    	
    	return list;
    }
    
    public int updateByPrimaryKeySelective(HalfTime halfTime){
    	 
    	int list = halfTimeMapper.updateByPrimaryKeySelective(halfTime);
    	
    	return list;
    }
    
    public  int deleteByPrimaryKey(int id){
    	int list = halfTimeMapper.deleteByPrimaryKey(id);
    	
    	return list;
    }
}
