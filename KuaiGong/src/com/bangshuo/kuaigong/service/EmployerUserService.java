package com.bangshuo.kuaigong.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.EmployerUserMapper;
import com.bangshuo.kuaigong.po.EmployerUser;


public class EmployerUserService {

	@Autowired
	EmployerUserMapper employerUserMapper;
	//查询雇主人数
	public EmployerUser selectNum(String name,String username,String erid,String btu){
			
		EmployerUser list = employerUserMapper.selectNum(name, username, erid, btu);
		
			return list;
		}
	
	//查询
		public List<EmployerUser>selectByAll(String name,String username,String erid, String btu){
			
			List<EmployerUser>list = employerUserMapper.selectByAll(name,username, erid,btu);
			
			return list;
		}
		//查询分页
		public List<EmployerUser>selectByAllPage(int page,int pageSize,String name,String username,String erid, String btu){
			
			List<EmployerUser>list = employerUserMapper.selectByAllPage(page, pageSize, name,username, erid,btu);
			
			return list;
		}

	
	//ģ���ѯ
	public List<EmployerUser> MHselectEmployerUser(int page,int pageSize,String name,String username){
		List<EmployerUser> list=employerUserMapper.MHselectByPage(page, pageSize, name,username);
		return list;
	}
	//��ѯ����
	public List<EmployerUser> selectPWD(int id){
		List<EmployerUser> list=employerUserMapper.selectPWD(id);
		return list;
	}
	
	//��������
	public int updataPWD(EmployerUser employerUser){
	int list=employerUserMapper.updataPWD(employerUser);
	return list;
	}
	
	
	public int insetToDisCount(String money){
		int i=employerUserMapper.insertToDisCount(money);
		return i;
	}
	
	
	public List<EmployerUser> selectPage(){
	List<EmployerUser> list= employerUserMapper.selectPage();
		 return list;
	 }
	 
	
	public  List<EmployerUser> selectByPage(int page,int pageSize){
	List<EmployerUser> list=	employerUserMapper.selectByPage(page, pageSize);
	return list;
	}
	
	
	
	public List<EmployerUser> selectByPrimaryKey(int id){
	List<EmployerUser> list=employerUserMapper.selectByPrimaryKey(id);
		return list;
	}
	
	
	public List<EmployerUser> queryAll(){
		List<EmployerUser> list=employerUserMapper.selectAll();
		return list;
	}
	
	
	public List<EmployerUser> selectByUsernmaeOrName(String user){
	   	 
		List<EmployerUser> list = employerUserMapper.selectByUsernmaeOrName(user);
    	
    	return list;
    	
	}
	
	
	public int insert(EmployerUser employerUser){
		
		int list = employerUserMapper.insert(employerUser);
		
		return list;
	}
	
	public int updateByPrimaryKey(EmployerUser employerUser){
		
		int list =employerUserMapper.updateByPrimaryKey(employerUser);
		
		return list;
	}
	
	public int updateByPrimaryKeySelective(EmployerUser employerUser){
		
		int list =employerUserMapper.updateByPrimaryKeySelective(employerUser);
		
		return list;
	}
	
	public int  deleteByPrimaryKey(int id){
		
		int list =employerUserMapper.deleteByPrimaryKey(id);
		
		return list ;
	}
	//查询详细信息
	public List<EmployerUser> selectUserLocation(int id){
		List<EmployerUser> list=employerUserMapper.selectUserLocation(id);
		return list;
	}
	//查询详细信息分页
	public List<EmployerUser> selectUserLocationPaGe(int page,int pageSize,int id){
		List<EmployerUser> list= employerUserMapper.selectUserLocationPaGe(page,pageSize,id);
		return list;
	}
	
	
	public  List<EmployerUser> selectByPageLocation(){
		List<EmployerUser> list=employerUserMapper.selectByPageLocation();
		return list;
	}

	public List<EmployerUser> employerUserUsername(int id) {
		List<EmployerUser> list=employerUserMapper.employerUserUsername(id);
		return list;
	}

	public List<EmployerUser> selectByusernameOrname(int id) {
		List<EmployerUser> list=employerUserMapper.selectByusernameOrname(id);
		return list;
	}

	public int updateStatus(String username,String status) {
		int list=employerUserMapper.updateStatus(username,status);
		return list;
	}

	
	}



