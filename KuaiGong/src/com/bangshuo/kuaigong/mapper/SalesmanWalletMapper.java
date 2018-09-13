package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.SalesmanWallet;

public interface SalesmanWalletMapper {

	SalesmanWallet selectNum(@Param("salesmanName")String salesmanName,@Param("username")String username);
	
	//查询业务员钱包
	List<SalesmanWallet>selectWallet(@Param("salesmanName")String salesmanName,@Param("username")String username);
	
	//查询业务员钱包
	List<SalesmanWallet>selectWalletPage(@Param("page")int page,@Param("pageSize")int pageSize,@Param("salesmanName")String salesmanName,@Param("username")String username);
	
	//修改业务员钱包
	 int updateBalance(SalesmanWallet salesmanWallet);
	
	int deleteByPrimaryKey(Integer id);

    int insert(SalesmanWallet record);

    int insertSelective(SalesmanWallet record);

    SalesmanWallet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalesmanWallet record);

   
}