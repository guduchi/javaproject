package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.EmployerLocationMapper;
import com.bangshuo.kuaigong.po.EmployerLocation;

public class EmployerLocationService {

	@Autowired
	EmployerLocationMapper employerLocationMapper;
	
public EmployerLocation selectNum(String query){
		
	EmployerLocation list = employerLocationMapper.selectNum(query);
	
	return list;
	}
	
	public List<EmployerLocation> queryAllDiTu() {
		List<EmployerLocation> list=employerLocationMapper.queryAllDiTu();
		return list;
	}
	
	//ģ���ѯ��ҳ����
	public List<EmployerLocation> selectNameOrUsername1(String name){
		List<EmployerLocation> list=employerLocationMapper.selectNameOrUsername1(name);
		return list;
	}
	
		//ģ���ѯ��ҳ����
	public List<EmployerLocation> selectNameOrUsername(String name){
		List<EmployerLocation> list=employerLocationMapper.selectNameOrUsername(name);
		return list;
	}
 	//ģ���ѯ��ҳ
	public List<EmployerLocation> selectNameOrUsernameByPaGe(int page,int pageSize,String name,String username){
		List<EmployerLocation> list=employerLocationMapper.selectNameOrUsernameByPaGe(page, pageSize, name, username);
		return list;
	}
	
	
	public List<EmployerLocation> selectLocation(int id){
		List<EmployerLocation> list=employerLocationMapper.selectLocation(id);
		return list;
	}
	
	public  List<EmployerLocation> selectByPrimaryKey(int id){
		List<EmployerLocation> list=employerLocationMapper.selectByPrimaryKey1(id);
		return list;
		}
	public List<EmployerLocation> selectPage(String query){
		List<EmployerLocation> list= employerLocationMapper.selectPage(query);
			 return list;
		 }
		 
		
		public  List<EmployerLocation> selectByPage(String query, int page,int pageSize){
		List<EmployerLocation> list=employerLocationMapper.selectByPage(query,page, pageSize);
		return list;
		}
		
	
	public List<EmployerLocation> query(){
		return employerLocationMapper.selectAll();
	}

public int insert(EmployerLocation employerLocation){
		
		int list = employerLocationMapper.insert(employerLocation);
		
		return list;
	}

	public int insertSelective(EmployerLocation employerLocation){
		
		 int list =employerLocationMapper.insertSelective(employerLocation);
		 
		 return list;
	}
	
	public int updateByPrimaryKey(EmployerLocation employerLocation){
		
		int list =employerLocationMapper.updateByPrimaryKey(employerLocation);
		
		return list;
	}
	
	public int updateByPrimaryKeySelective(EmployerLocation employerLocation){
		
		int list =employerLocationMapper.updateByPrimaryKeySelective(employerLocation);
		
		return list;
	}
	
	public int  deleteByPrimaryKey(int id){
		
		int list =employerLocationMapper.deleteByPrimaryKey(id);
		
		return list ;
	
	
	}

	public List<EmployerLocation> queryUserInfoLoccation(int erid, String longitude,
			String latitude) {
		
		List<EmployerLocation> employerLocation=employerLocationMapper.EmployerLocation(erid,longitude,latitude);
		return employerLocation;
	}
}
