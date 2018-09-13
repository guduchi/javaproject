package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.AppraiseMapper;
import com.bangshuo.kuaigong.po.Appraise;
public class AppraiseService {
  
	@Autowired
	AppraiseMapper appraiseMapper;
	
	//查询业务员管理的工人评价记录
	public List<Appraise>selectBySalesApp(int id,String ername,String erid){
		List<Appraise>list = appraiseMapper.selectBySalesApp(id,ername,erid);
		return list;
	}
	//查询业务员管理的工人评价记录分页
	public List<Appraise>selectBySalesAppPage(int page,int pageSize,int id,String ername,String erid){
		List<Appraise>list = appraiseMapper.selectBySalesAppPage(page,pageSize,id,ername,erid);
		return list;
	}
	
	//查询订单下的评价
		public List<Appraise>selectOrderApp(int id){
			
			List<Appraise>list = appraiseMapper.selectOrderApp(id);
			
			return list;
		}
	
	//查看每个信息中 查看雇主评价
public  Appraise selectStar(int id){
		
	Appraise list=appraiseMapper.selectStar(id);
		
		return list;
	}
//查看业务员下工人的评价
public Appraise selectAppCount(int id,String ername,String erid){
	
	Appraise list=appraiseMapper.selectAppCount(id,ername,erid);
	
	return list;
}
	
//查询雇主评价次数

public Appraise appraiseCount(int id){
	
	Appraise list = appraiseMapper.appraiseCount(id);
	
	return list;
}

	//查询评价
	public List<Appraise> QueryUserAll(int id){
  List<Appraise>	list=appraiseMapper.QueryUserAll(id);
   return list;
	}
	//查询评价条数
	public Appraise queryTheCount(int id){
		Appraise 	list=appraiseMapper.queryTheCount(id);
		return list;
	}
	
	public List<Appraise> QueryUserPaGe(int page,int pageSize,int id){
		List<Appraise> list=appraiseMapper.QueryUserPaGe(page, pageSize, id);
		return list;
	}
	
	public int updateByPrimaryKey(Appraise appraise){
		
		int list =appraiseMapper.updateByPrimaryKey(appraise);
		
		return list;
		
	}
	
	public int  deleteByPrimaryKey(int id){
		
		int list =appraiseMapper.deleteByPrimaryKey(id);
		
		return list ;
		
	}

	public List<Appraise> selectAppraisePAGe(int page, int pageSize, int id) {
		List<Appraise> list=appraiseMapper.selectAppraisePAGe( page,pageSize,id);
		return list;
	}

	public List<Appraise> selectAppraise9(int id) {
		List<Appraise> list=appraiseMapper.selectAppraise9( id);
		return list;
	}
	
}
