package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.BlacklistMapper;
import com.bangshuo.kuaigong.po.Blacklist;

public class BlacklistService {
@Autowired
BlacklistMapper blacklistMapper;
public int insertToBlacklist(Blacklist blacklist){
	int insertToBlacklist = blacklistMapper.insertToBlacklist(blacklist);
	return insertToBlacklist;
}
public List<Blacklist> selectToBlacklist(String username) {
	List<Blacklist> list=blacklistMapper.selectToBlacklist(username);
	return list;
}
public List<Blacklist> BlacklistToList(String query) {
	List<Blacklist> list=blacklistMapper.BlacklistToList(query);
	return list;
}
public List<Blacklist> BlacklistToListInfo(String query, int page, int pageSize) {
	List<Blacklist> list=blacklistMapper.BlacklistToListInfo(query,page,pageSize);
	return list;
}
public List<Blacklist> queryBlacklist(String name) {
	List<Blacklist> list=blacklistMapper.queryBlacklist(name);
	return list;
}
public Blacklist deleteBalcklist(String name) {
	Blacklist deleteBalcklist=blacklistMapper.deleteBalcklist(name);
	return deleteBalcklist;
}
}
