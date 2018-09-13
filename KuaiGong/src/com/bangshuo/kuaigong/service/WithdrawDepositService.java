package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.WithdrawDepositMapper;
import com.bangshuo.kuaigong.po.WithdrawDeposit;

public class WithdrawDepositService {
	
	@Autowired
	WithdrawDepositMapper withdrawDepositMapper;
	
public WithdrawDeposit selectNum(String query,String btu1, String btu2,String starttime,String endtime){
		
	WithdrawDeposit list=withdrawDepositMapper.selectNum(query, btu1, btu2,starttime, endtime);
	
	return list;
	}
	
	public List<WithdrawDeposit> queryTime(String Starttime,String endTime){
	List<WithdrawDeposit> list=withdrawDepositMapper.queryTime(Starttime, endTime);
				return list;
		
		
	}
	
	public List<WithdrawDeposit> selectPage(){
		
		List<WithdrawDeposit> list= withdrawDepositMapper.selectPage();
	
		return list;
	
	}
	 //查询提现分页
	public  List<WithdrawDeposit> selectByPage(String query, String starttime, String endtime, int page,int pageSize, String btu1,  String btu2){
	
		List<WithdrawDeposit> list=	withdrawDepositMapper.selectByPage(query,starttime,endtime,page, pageSize,btu1,btu2);
	
		return list;
	
	}
	//查询提现
	public List<WithdrawDeposit> queryAll(String query, String starttime, String endtime, String btu1,String btu2){
		List<WithdrawDeposit> list=withdrawDepositMapper.selectAll(query,starttime,endtime,btu1,btu2);
		
		return list;
	
	}
	
	public List<WithdrawDeposit> query(WithdrawDeposit withdrawDeposit){
	   	 
		List<WithdrawDeposit> list = withdrawDepositMapper.selectByPrimaryKey(withdrawDeposit);
    	
    	return list;
    }
    
	public List<WithdrawDeposit> selectByBalance(String user){
	   	 
		List<WithdrawDeposit> list = withdrawDepositMapper.selectByBalance(user);
    	
    	return list;
    	
	}
    
    public  int deleteByPrimaryKey(int id){
 
    	int list = withdrawDepositMapper.deleteByPrimaryKey(id);
    	
    	return list;
    }

	public List<WithdrawDeposit> queryWithdraw(String query) {
		List<WithdrawDeposit> list =withdrawDepositMapper.queryWithdraw(query);
		return list;
	}

	public List<WithdrawDeposit> queryWithdrawPaGe(int page, int pageSize,
			String query) {
		List<WithdrawDeposit> list =withdrawDepositMapper.queryWithdrawPaGe(page,pageSize,query);
		return list;
	}

	public List<WithdrawDeposit> queryByTime6(String starttime, String endtime) {
		List<WithdrawDeposit> list =withdrawDepositMapper.queryByTime6(starttime,endtime);
		return list;
	}

	public List<WithdrawDeposit> queryByTime6Page(String starttime,
			String endtime, int page, int pageSize) {
		List<WithdrawDeposit> list =withdrawDepositMapper.queryByTime6Page(starttime,endtime,page,pageSize);
		return list;
	}
	public List<WithdrawDeposit> selectByTime6(String starttime, String endtime,String query){
		List<WithdrawDeposit> list =withdrawDepositMapper.selectByTime6(starttime,endtime,query);
		return list;
	}

	public List<WithdrawDeposit> selectByTime6Page(String starttime, String endtime,String query,int page,int pageSize){
		

	List<WithdrawDeposit> list =withdrawDepositMapper.selectByTime6Page(starttime,endtime,query,page,pageSize);
	  return list;
	}

	public List<WithdrawDeposit> queryAllShouYi(String btu, String query, String starttime, String endtime) {
		List<WithdrawDeposit> list =withdrawDepositMapper.queryAllShouYi(btu,query,starttime,endtime);
		return list;
	}

	public List<WithdrawDeposit> selectByPageShouYi(String btu,String query, String starttime, String endtime, int page, int pageSize) {
		List<WithdrawDeposit> list =withdrawDepositMapper.selectByPageShouYi(btu,query,starttime,endtime,page,pageSize);
		return list;
	}

	public List<WithdrawDeposit> queryWithdrawTimeMoHuchaxun(String name,
			String btu) {
		List<WithdrawDeposit> list =withdrawDepositMapper.queryWithdrawTimeMoHuchaxun(name,btu);
		return list;
	}

	public List<WithdrawDeposit> queryWithdrawPaGeTimeMoHuchaxun(String name,String btu, int page,int pageSize) {
		List<WithdrawDeposit> list =withdrawDepositMapper.queryWithdrawPaGeTimeMoHuchaxun(name,btu,page,pageSize);
		return list;
	}

	public List<WithdrawDeposit> queryByTime6ShouYi(String starttime,
			String endtime, String btu) {
		List<WithdrawDeposit> list =withdrawDepositMapper.queryByTime6ShouYi(starttime,endtime,btu);
		return list;
	}

	public List<WithdrawDeposit> queryByTime6PageShouYi(String starttime,
			String endtime, int page, int pageSize, String btu) {
		List<WithdrawDeposit> list =withdrawDepositMapper.queryByTime6PageShouYi(starttime,endtime,btu,page,pageSize);
		return list;
	}
	
	//查询收益
	public List<WithdrawDeposit>selectIncome(String name,String starttime,String endtime){
	
		List<WithdrawDeposit>list = withdrawDepositMapper.selectIncome(name, starttime, endtime);
		
		return list;
	}

	public WithdrawDeposit queryusername(String queryusername,String starttime,String endtime,String btu1,String btu2) {
		
		WithdrawDeposit list = withdrawDepositMapper.queryusername(queryusername, starttime, endtime,btu1,btu2);
		
		return list;
	}
	
	 //全部收益
		public WithdrawDeposit queryEarningsAll(){
			WithdrawDeposit withdrawDeposit=withdrawDepositMapper.queryEarningsAll();
			return withdrawDeposit;
		}

	
	
	/*李奎写的代码*/
	public List<WithdrawDeposit> selectWithdrawDepositByTime(String starttime,String endtime, String chooseBtu, String queryUserName){
		
		return withdrawDepositMapper.selectWithdrawDepositByTime(starttime, endtime,chooseBtu,queryUserName);
	}
//收益和工资到账分页
	public List<WithdrawDeposit> selectByStatus(String btu1, String btu2) {
		return withdrawDepositMapper.selectByStatus(btu1,btu2);
	}
//收益和工资到账分页
	public List<WithdrawDeposit> selectByPageStatus(int page,int pageSize,String btu1,String btu2) {
		return withdrawDepositMapper.selectByPageStatus(page,pageSize,btu1,btu2);
	}

	public List<WithdrawDeposit> selectWithdrawByYesterdayInfo(String yesterday,
			String now, String chooseBtu, String queryUserName, int page, int pageSize) {
		return withdrawDepositMapper.selectWithdrawByYesterdayInfo(yesterday,now,chooseBtu,queryUserName,page,pageSize);
	}

	public List<WithdrawDeposit> queryAllSort(String query, String starttime,String endtime, String btu1, String btu2) {
		
		return withdrawDepositMapper.queryAllSort(query,starttime,endtime,btu1,btu2);
	}

	public List<WithdrawDeposit> selectByPageInfo(String query,String starttime, String endtime,String btu1, String btu2,int page, int pageSize) {
		// TODO Auto-generated method stub
		return withdrawDepositMapper.selectByPageInfo(query,starttime,endtime,btu1,btu2,page,pageSize);
	}

}
	
