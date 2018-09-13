package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.Salesman;

public interface SalesmanMapper {
	// 查询数据条数
	Salesman selectNum(@Param("id") String id,
			@Param("salesmanName") String salesmanName,
			@Param("username") String username,
			@Param("status") String status,
			@Param("position") String position,
			@Param("superiorId") String superiorId);

	// 查询详细信息
	List<Salesman> selectMany(int id);

	// 查询业务员
	List<Salesman> selectSalesman(
			@Param("id") String id,
			@Param("salesmanName") String salesmanName,
			@Param("username") String username,
			@Param("status") String status,
			@Param("position") String position,
			@Param("superiorId") String superiorId);

	// 查询业务员分页
	List<Salesman> selectSalesmanPage(
			@Param("page") int page,
			@Param("pageSize") int pageSize, 
			@Param("id") String id,
			@Param("salesmanName") String salesmanName,
			@Param("username") String username,
			@Param("status") String status,
			@Param("position") String position,
			@Param("superiorId") String superiorId);

	// 修改信息
	int updateByPrimaryKey(Salesman salesman);

	// 删除
	int deleteByPrimaryKey(Integer id);

	// 注册
	int insert(Salesman salesman);

	// 查看
	Salesman selectByUsername(String username);
}