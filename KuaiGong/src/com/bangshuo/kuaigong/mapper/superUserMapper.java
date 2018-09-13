package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.superUser;

public interface superUserMapper {
	superUser login(superUser superuser);

	List<superUser> selectPage();

	List<superUser> selectByPage(
			@Param("page") int page,
			@Param("pageSize") int pageSize);

	int updateSuperUser(superUser superuser);

	int deleteSuperUser(int id);

	int addSuperUser(superUser superuser);

	List<superUser> selectSuperUser(String username);
}
