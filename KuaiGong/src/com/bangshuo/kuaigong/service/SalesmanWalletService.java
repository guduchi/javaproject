package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.SalesmanWalletMapper;
import com.bangshuo.kuaigong.po.EmployeeUser;
import com.bangshuo.kuaigong.po.SalesmanWallet;

public class SalesmanWalletService {
	@Autowired
	SalesmanWalletMapper salesmanWalletMapper;
	
public SalesmanWallet selectNum(String salesmanName,String username){
		
	SalesmanWallet list=salesmanWalletMapper.selectNum(salesmanName, username);
	
	return list;
	}
	
	//查询业务员钱包
	public List<SalesmanWallet>selectWallet(String salesmanName,String username){
		
		List<SalesmanWallet> list =salesmanWalletMapper.selectWallet(salesmanName, username);
		
		return list;
	}
	//查询业务员钱包分页
	public List<SalesmanWallet>selectWalletPage(int page,int pageSize,String salesmanName,String username){
		
		List<SalesmanWallet> list =salesmanWalletMapper.selectWalletPage(page, pageSize, salesmanName, username);
		
		return list;
	}
	//修改业务员钱包
		public int updateBalance(SalesmanWallet salesmanWallet){
			
			int  list =salesmanWalletMapper.updateBalance(salesmanWallet);
			
			return list;
		}
		//删除
		public int  deleteByPrimaryKey(int id){
			
			int list =salesmanWalletMapper.deleteByPrimaryKey(id);
			
			return list ;
		}
}
