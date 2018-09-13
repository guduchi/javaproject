package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.bangshuo.kuaigong.mapper.cjUserMapper;
import com.bangshuo.kuaigong.po.User;
import com.bangshuo.kuaigong.po.cjUser;

public class cjUserService{
	@Autowired
	cjUserMapper cjusermapper;
 public cjUser login(cjUser cjuser ){
cjUser list=cjusermapper.login(cjuser);
 
 return list;
 }
 public List<User> selectPage(){
		List<User> list= cjusermapper.selectPage3();
			 return list;
		 }
		 
		
		public  List<User> selectByPage(int page,int pageSize){
		List<User> list=cjusermapper.selectByPage3(page, pageSize);
		return list;
		}
 
 
}
