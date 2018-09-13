package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.EmployeeLocationMapper;
import com.bangshuo.kuaigong.po.EmployeeLocation;

public class EmployeeLocationService {

		@Autowired
		EmployeeLocationMapper employeeLocationMapper;
		
		public EmployeeLocation selectNum(String query){
			
			EmployeeLocation list = employeeLocationMapper.selectNum(query);
			
			return list;
		}
		
//		查询工人状态和地图
		public List<EmployeeLocation> queryAllDiTu() {
			
			List<EmployeeLocation> list=employeeLocationMapper.queryAllDiTu();
			
			return list;
		}
		
		public List<EmployeeLocation> queryUserInfoLoccation(int eeid,
				String longitude, String latitude) {
			List<EmployeeLocation> employeeLocation=employeeLocationMapper.EmployeeLocation(eeid,longitude,latitude);
			return employeeLocation;
		}
		
				public List<EmployeeLocation> eeselectNameORusername1(String name){
					List<EmployeeLocation> list=employeeLocationMapper.selectNameORusername1(name);
					return list;
				}
				//ģ���ѯ��ҳ
				public List<EmployeeLocation> selectNameORusernamepage (int page,int pageSize,String name,String username){
					List<EmployeeLocation> list=employeeLocationMapper.selectNameORusernamepage(page, pageSize, name, username);
					return list;
				}
		
	//��ģ���ѯ
		public List<EmployeeLocation> selectNameORusername(String name){
			List<EmployeeLocation> list=employeeLocationMapper.selectNameORusername(name);
			return list;
		}
		public List<EmployeeLocation> selectPage(String query){
			List<EmployeeLocation> list=employeeLocationMapper.selectPage(query);
				 return list;
			 }
			 
			
			public  List<EmployeeLocation> selectByPage(String query, int page,int pageSize){
			List<EmployeeLocation> list=employeeLocationMapper.selectByPage(query,page, pageSize);
					
			return list;
			}
			
		
		public  List<EmployeeLocation> selectByPrimaryKey(String name){
		List<EmployeeLocation> list=employeeLocationMapper.selectByPrimaryKey(name);
		return list;
		}
	    
	    public int insert(EmployeeLocation employeeLocation){
	    	
			int list = employeeLocationMapper.insert(employeeLocation);
			
			return list;
	    }
	    
	    public int insertSelective(EmployeeLocation employeeLocation){
	    	int list = employeeLocationMapper.insertSelective(employeeLocation);
	    	
	    	return list;
	    }
	    
	    public int updateByPrimaryKeySelective(EmployeeLocation employeeLocation){
	    	
	    	int list = employeeLocationMapper.updateByPrimaryKeySelective(employeeLocation);
	    	
	    	return list;
	    }
	    
	    public  int deleteByPrimaryKey(int id){
	    	int list = employeeLocationMapper.deleteByPrimaryKey(id);
	    	
	    	return list;
	    }
	}
