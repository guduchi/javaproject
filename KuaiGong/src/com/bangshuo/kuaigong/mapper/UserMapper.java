package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.bangshuo.kuaigong.po.User;

public interface UserMapper {

	User login(User user);

	List<User> selectByusername(User username);

	List<User> selectByID(String username);

	int insert(User record);

	// 注册
	int insertSelective(User record);

	int updateUser(User record);

	int deleteUser(int id);

	List<User> selectById(String name);

	List<User> selectPage3();

	List<User> selectByPage3(
			@Param("page") int page,
			@Param("pageSize") int pageSize);
}