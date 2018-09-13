package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.Company;


public interface CompanyMapper {

	Company selectNum(@Param("query")String query);
	
		//查询
		List<Company>selectAll(@Param("query") String query);
		//查询分页
		List<Company>selectAllPage(@Param("query") String query, @Param("page") int page,@Param("pageSize") int pageSize);
		//根据姓名查询
		List<Company>selectName(String name);
		//根据姓名查询分页
        List<Company>selectNamePage(@Param("page")int page,@Param("pageSize")int pageSize,@Param("name")String name);
      //删除
        int deleteByPrimaryKey(Integer id);
        //修改
        int updateByPrimaryKey(Company company);
}
