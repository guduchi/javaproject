package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.superUserMapper;
import com.bangshuo.kuaigong.po.superUser;

public class superUserService {
@Autowired
superUserMapper superuserMapper;
public superUser superLogin(superUser superuser){
	superUser list=superuserMapper.login(superuser);
	return list;
}
public List<superUser> selectPage() {
	List<superUser> list= superuserMapper.selectPage();
	 return list;
	
}
public List<superUser> selectByPage(int page, int pageSize) {
	List<superUser> list=superuserMapper.selectByPage(page, pageSize);
	return list;
}
public int updateSuperUser(superUser superuser) {
	 int list=superuserMapper.updateSuperUser(superuser);
	 return list;
	}

public int deleteSuperUser(int id) {
	int list=superuserMapper.deleteSuperUser(id);
	return list;
}
public int addSuperUser(superUser superuser) {
	int list=superuserMapper.addSuperUser(superuser);
	return list;
}
public List<superUser> selectSuperUser(String username) {
	List<superUser> list=superuserMapper.selectSuperUser(username);
	return list;
}
}
