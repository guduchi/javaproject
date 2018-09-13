package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.User;
import com.bangshuo.kuaigong.po.cjUser;


public interface cjUserMapper {

	cjUser login(cjUser cjuser);

	List<User> selectPage3();

	List<User> selectByPage3(@Param("page")int page, @Param("pageSize")int pageSize);


}
