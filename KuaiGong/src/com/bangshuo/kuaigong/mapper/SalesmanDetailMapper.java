package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.SalesmanDetail;

public interface SalesmanDetailMapper {
       
	//查询信息条数
	SalesmanDetail selectNum(
			   @Param("salesmanName")String salesmanName,@Param("username")String username,
			   @Param("desc")String desc,@Param("starttime")String starttime,@Param("endtime")String endtime);
	//查询业务员的钱
	   List<SalesmanDetail>selectMoney(
			   @Param("salesmanName")String salesmanName,@Param("username")String username,
			   @Param("desc")String desc,@Param("starttime")String starttime,@Param("endtime")String endtime);
	   //查询业务员的钱
	   List<SalesmanDetail>selectMoneyPage(@Param("page")int page,
			   @Param("pageSize")int pageSize,
			   @Param("salesmanName")String salesmanName,@Param("username")String username,
			   @Param("desc")String desc,@Param("starttime")String starttime,@Param("endtime")String endtime);
}
