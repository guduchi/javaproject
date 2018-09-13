package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.EmployeeHourLength;

public interface HourlengthallMapper {

	List <EmployeeHourLength>selectHourLength(@Param("name")String name,@Param("username")String username);
	
	List<EmployeeHourLength>selectHourLengthPgae(@Param("page")int page,@Param("pageSize")int pageSize,@Param("name")String name,@Param("username")String username);

	EmployeeHourLength selectNum(@Param("name")String name,@Param("username")String username);
}
