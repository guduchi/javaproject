package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.Blacklist;

public interface BlacklistMapper {
	int insertToBlacklist(Blacklist blacklist);

	List<Blacklist> selectToBlacklist(@Param("username") String username);

	List<Blacklist> BlacklistToList(@Param("query") String query);

	List<Blacklist> BlacklistToListInfo(@Param("query") String query, @Param("page") int page,@Param("pageSize") int pageSize);

	List<Blacklist> queryBlacklist(@Param("name") String name);

	Blacklist deleteBalcklist(@Param("name") String name);
}
