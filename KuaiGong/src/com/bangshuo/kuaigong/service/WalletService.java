package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.WalletMapper;
import com.bangshuo.kuaigong.po.Wallet;

public class WalletService {
	
	@Autowired
	WalletMapper walletMapper;
	
	//查询钱包条数
		public Wallet selectNum(String name){
			
			Wallet list = walletMapper.selectNum(name);
			
			return list;
		}
	
	
	//��ݹ�������ģ���ѯ
	public List<Wallet>selectByName(String name){
		
		List<Wallet>list = walletMapper.selectByName(name);
		
		return list;
	}
	//��ݹ�������ģ���ѯ��ҳ
   public List<Wallet>selectByNamePage(int page,int pageSize,String name){
	   
	   List<Wallet> list = walletMapper.selectByNamePage(page, pageSize, name);
	  
	   return list;
   }
	
	//���ʱ��β�ѯȡǮ��¼
	public List<Wallet> queryData(String starttime,String endtime){
	List<Wallet> list=walletMapper.queryData(starttime, endtime);
	return list;
	}
	
	
	
	//查询工人钱包
	public List<Wallet> selectpageAll(String name){
	List<Wallet> list=walletMapper.queryAll(name);
	return list;
	}
	
	public List<Wallet> selectPaGe(int page,int pageSize,String name){
	List<Wallet> list=	walletMapper.queryAllPaGe(page, pageSize,name);
	return list;
	}
	
	
	
	
	
	
	
	public List<Wallet> selectPage(){
		
		List<Wallet> list= walletMapper.selectPage();
	
		return list;
	
	}
	 
	public  List<Wallet> selectByPage(int page,int pageSize){
	
		List<Wallet> list=	walletMapper.selectByPage(page, pageSize);
	
		return list;
	
	}
	
	
	
	
	
	public List<Wallet> queryAll(){
		
		List<Wallet> list=walletMapper.selectAll();
		
		return list;
	
	}
	
	public List<Wallet> query(Wallet wallet){
	   	 
		List<Wallet> list = walletMapper.selectByPrimaryKey(wallet);
    	
    	return list;
    }
    
	public List<Wallet> selectByBalance(String user){
	   	 
		List<Wallet> list = walletMapper.selectByBalance(user);
    	
    	return list;
    	
	}
    
    public  int deleteByPrimaryKey(int id){
 
    	int list = walletMapper.deleteByPrimaryKey(id);
    	
    	return list;
    }
    
	public int chongzhi(int id, String query) {
		int list=walletMapper.chongzhi(id,query);
		return list;
	}
	public int updateWallet(Wallet wallet) {
		int list=walletMapper.updateByPrimaryKeySelective(wallet);
		return list;
	}


	public List<Wallet> selectWorkerWalletPage(int id) {
		List<Wallet> list = walletMapper.selectWorkerWalletPage(id);
		return list;
	}


	public List<Wallet> selectWorkerWalletInfo(int id, int page, int pageSize) {
		List<Wallet> list = walletMapper.selectWorkerWalletInfo(id,page,pageSize);
		return list;
	}


	public List<Wallet> querybalance(String name) {
		List<Wallet> list = walletMapper.querybalance(name);
		return list;
	}


	public List<Wallet> querybalanceInfo(int page, int pageSize, String name) {
		List<Wallet> list = walletMapper.querybalanceInfo(page,pageSize,name);
		return list;
	}


	public List<Wallet> Newquerybalance(String name) {
		List<Wallet> list = walletMapper.Newquerybalance(name);
		return list;
	}


	public List<Wallet> NewquerybalanceInfo(int page,int pageSize,String name) {
		List<Wallet> list = walletMapper.NewquerybalanceInfo(page,pageSize,name);
		return list;
		
	}
	
}
