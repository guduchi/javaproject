package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.Wallet;

public interface WalletMapper {
	
	Wallet  selectNum(@Param("name")String name);
	
    int deleteByPrimaryKey(Integer id);
    
    List<Wallet>selectByPrimaryKey(Wallet wallet);
    
    List<Wallet>selectByBalance(String name);

    List<Wallet> selectAll();

     Wallet selectByPrimaryKey(Integer id);
     
     List<Wallet> selectPage();
      
     List<Wallet> selectByPage(@Param("page") int page,@Param("pageSize") int pageSize);
//查询工人钱包
   List<Wallet> queryAll(@Param("name") String name);
 
   List<Wallet> queryAllPaGe(@Param("page") int page,@Param("pageSize") int pageSize,@Param("name") String name);
//���ʱ��β�ѯȡǮ��¼
   List<Wallet> queryData(@Param("starttime") String starttime,@Param("endtime") String endtime);


 //��ݹ�������ģ���ѯ
   List<Wallet>selectByName(String name);
   //��ݹ�������ģ���ѯ��ҳ
   List<Wallet>selectByNamePage(@Param("page")int page,@Param("pageSize")int pageSize,@Param("name")String name);
  
  int chongzhi(@Param("id") int id,@Param("balance") String balance);

   int updateByPrimaryKeySelective(Wallet wallet);

List<Wallet> selectWorkerWalletPage(@Param("eeid") int eeid);

List<Wallet> selectWorkerWalletInfo(@Param("eeid") int eeid,@Param("page") int page,@Param("pageSize") int pageSize);

List<Wallet> querybalance(@Param("name") String name);

List<Wallet> querybalanceInfo(@Param("page") int page,@Param("pageSize") int pageSize,@Param("name") String name);

List<Wallet> Newquerybalance(@Param("name") String name);

List<Wallet> NewquerybalanceInfo(@Param("page") int page,@Param("pageSize") int pageSize,@Param("name") String name);

   
}