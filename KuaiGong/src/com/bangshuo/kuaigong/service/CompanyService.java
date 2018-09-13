package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.CompanyMapper;
import com.bangshuo.kuaigong.po.Company;

public class CompanyService {
      
	@Autowired
	CompanyMapper companyMapper;
	
public Company selectNum(String query){
	
	Company list = companyMapper.selectNum(query);
		
	return list;
	}
	
	//查询
	public List<Company>selectAll(String query){
		
		List<Company> list = companyMapper.selectAll(query);
	
		return list;
	}
	//查询分页
	public  List<Company> selectAllPage(String query, int page,int pageSize){
		
		List<Company> list = companyMapper.selectAllPage(query,page, pageSize);
	
		return list;
	}
	   //查询名字
	public List<Company>selectName(String name){
	
		List<Company>list = companyMapper.selectName(name);
		
		return list;
	}
	//查询名字分页
		public List<Company>selectNamePage(int page,int pageSize,String name){
			
			List<Company>list = companyMapper.selectNamePage(page, pageSize, name);
		  
			return list;
	}
		//删除
		public int deleteByPrimaryKey(int id) {
		
			int list=companyMapper.deleteByPrimaryKey(id);
			
			return list;
			} 
		//修改
		public int updateByPrimaryKey(Company company){
			
			int  list =companyMapper.updateByPrimaryKey(company);
			
			return list;
		}
}
