package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.SalesmanSignIn;

public interface SalesmanSignInMapper {

	SalesmanSignIn selectNum(@Param("salesmanName") String salesmanName,
			@Param("username") String username,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime,
			@Param("status") String status);

	// 查询业务员签到
	List<SalesmanSignIn> selectSignIn(
			@Param("salesmanName") String salesmanName,
			@Param("username") String username,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime,
			@Param("status") String status);

	// 查询业务员签到
	List<SalesmanSignIn> selectSignInPage(
			@Param("page") int page,
			@Param("pageSize") int pageSize,
			@Param("salesmanName") String salesmanName,
			@Param("username") String username,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime,
			@Param("status") String status);

	int deleteByPrimaryKey(Integer id);

	int insert(SalesmanSignIn record);

	int insertSelective(SalesmanSignIn record);

	SalesmanSignIn selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SalesmanSignIn record);

	int updateByPrimaryKey(SalesmanSignIn record);
}