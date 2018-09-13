package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.EmployerScaleMapper;
import com.bangshuo.kuaigong.po.EmployeeUser;
import com.bangshuo.kuaigong.po.EmployerScale;
import com.bangshuo.kuaigong.po.EmployerUser;
import com.bangshuo.kuaigong.po.OnlineInformation;

public class EmployerScaleService {
	
	@Autowired
	EmployerScaleMapper EmployerScaleMapper;
	
public EmployerScale selectNum(){
		
		return EmployerScaleMapper.selectNum();
	}
	
	//��ģ���ѯ
	public List<EmployerScale> queryByID(String query) {
		List<EmployerScale> list =EmployerScaleMapper.queryByID(query);
		return list;
	}
	//ģ���ѯ
	public List<EmployerScale> queryByID1(String query) {
		List<EmployerScale> list =EmployerScaleMapper.queryByID1(query);
		return list;
	}
	public List<EmployerScale>	queryByIDPagGe(int page,int pageSize,String query){
		List<EmployerScale> list =EmployerScaleMapper.queryByIDPagGe(page,pageSize,query);
		return list;
	}
	
	//���۷�ҳ����
	public  List<EmployerScale> selectPage(int id){
		List<EmployerScale> list =EmployerScaleMapper.queryPage(id);
		return list;
	}
	
	
	public  List<EmployerScale> selectByPage1(int id,int page,int pageSize){
		List<EmployerScale> list =EmployerScaleMapper.queryByPage(page, pageSize, id);
		return list;
	}
	
	
	public List<EmployerScale> selectById(int id){
		List<EmployerScale> list = EmployerScaleMapper.selectById(id);
		return list;
	}
	
	public List<EmployerScale> selectPage1(String username){
		List<EmployerScale> list= EmployerScaleMapper.selectPage1(username);
			 return list;
		 }
		 
		
		public  List<EmployerScale> selectByPage(String username,int page,int pageSize){
		List<EmployerScale> list=	EmployerScaleMapper.selectByPage1(username,page, pageSize);
		return list;
		}
		

		public  List<EmployerScale> queryById(int id){
			List<EmployerScale> list = EmployerScaleMapper.selectByPrimaryKeyScanle(id);
      	
    	return list;
    }
    
    public int insert(EmployerScale employerScale){
    	
		int list = EmployerScaleMapper.insert(employerScale);
		
		return list;
    }
    
    public int insertSelective(EmployerScale employerScale){
    	
    	int list = EmployerScaleMapper.insertSelective(employerScale);
    	
    	return list;
    }
    
    public int updateByPrimaryKeySelective(EmployerScale employerScale){
    	
    	int list = EmployerScaleMapper.updateByPrimaryKeySelective(employerScale);
    	
    	return list;
    }
    
    public  int deleteByPrimaryKey(int id){
    	int list = EmployerScaleMapper.deleteByPrimaryKey(id);
    	
    	return list;
    }
}
