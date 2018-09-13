package com.bangshuo.kuaigong.mapper;	

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.Apply;

public interface ApplyMapper {
	Apply 	selectNum(@Param("username")String username,@Param("starttime")String starttime,@Param("endtime")String endtime);
	
	int deleteApply(int id);
     //今日报名总数
	List<Apply> selectAllToAll();
	  //查询报名表
	List<Apply>selectAll(@Param("username") String username,@Param("starttime") String starttime,@Param("endtime") String endtime);
	//查询报名表分页
	List<Apply>selectAllPage(@Param("username") String username,@Param("starttime") String starttime,@Param("endtime") String endtime, @Param("pageSize") int pageSize, @Param("page") int page);
}
