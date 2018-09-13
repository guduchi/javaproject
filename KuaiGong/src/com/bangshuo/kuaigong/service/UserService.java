package com.bangshuo.kuaigong.service;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.bangshuo.kuaigong.mapper.UserMapper;
import com.bangshuo.kuaigong.po.User;

public class UserService {

    @Autowired
    UserMapper userMapper;
    public List<User> selectByID(String username){
    List<User> list=	userMapper.selectByID(username);
    return list;
    }
    public List<User> selectByusername(User username){
    	List<User> list=userMapper.selectByusername(username);
    	return list;
    }
    
    public List<User> selectById(String name){
   List<User> list= userMapper.selectById(name);
    	return list;
}

	public List<User> selectPage(){
	List<User> list= userMapper.selectPage3();
		 return list;
	 }
	 
	
	public  List<User> selectByPage(int page,int pageSize){
	List<User> list=userMapper.selectByPage3(page, pageSize);
	return list;
	}
	
	
	public User login(User user) {
	
		User list = userMapper.login(user);
		return list;
	}
	
	public int insertSelective(User user){
		
		int result = userMapper.insertSelective(user);
		return result;
	}

	public int updateUser(User record) {
	int list=userMapper.updateUser(record);
		return list;
	} 
	

	public int deleteUser(int id) {
	int list=userMapper.deleteUser(id);
		return list;
	} 
	
}
