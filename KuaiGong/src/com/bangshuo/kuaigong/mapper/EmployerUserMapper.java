package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.EmployerUser;
import com.bangshuo.kuaigong.po.User;


public interface EmployerUserMapper {
	
	//查询雇主人数
	EmployerUser selectNum(@Param("name")String name,@Param("username")String username,@Param("erid")String erid,@Param("btu")String btu);
	//查询
	List<EmployerUser> selectByAll(@Param("name") String name,@Param("username") String username,@Param("erid") String erid, @Param("btu") String btu);
	//查询分页
	 List<EmployerUser> selectByAllPage(@Param("page") int page,@Param("pageSize") int pageSize,@Param("name")String name,@Param("username") String username,@Param("erid") String erid,@Param("btu") String btu);

	//��ѯ�û�����
	List<EmployerUser> selectPWD(Integer id);
	
	int updataPWD(EmployerUser employerUser);
	
	
	int insertToDisCount(String money);
	
	
	
	EmployerUser login(User user);
    
	int deleteByPrimaryKey(Integer id);

    int insert(EmployerUser record);

    int insertSelective(EmployerUser record);
    
    List<EmployerUser> selectByPrimaryKey(int id);
    //ģ���ѯ
    List<EmployerUser> selectByUsernmaeOrName(String name);

    List<EmployerUser> selectAll();

    int updateByPrimaryKeySelective(EmployerUser record);

    int updateByPrimaryKey(EmployerUser employerUser);
    //��ѯ��ҳ
    List<EmployerUser> selectUserLocation(int id);
    //��ѯ��ҳ
    List<EmployerUser> selectUserLocationPaGe(@Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id);
    
    List<EmployerUser> selectByPageLocation();
      
    List<EmployerUser> selectPage();
    
    List<EmployerUser> selectByPage(@Param("page") int page,@Param("pageSize") int pageSize);
  //ģ���ѯ
    List<EmployerUser> MHselectByPage(@Param("page") int page,@Param("pageSize") int pageSize,@Param("name") String name,@Param("username") String username);
	List<EmployerUser> employerUserUsername(@Param("id") int id);
	List<EmployerUser> selectByusernameOrname(@Param("id") int id);
	int updateStatus(@Param("username") String username,@Param("status") String status);

	
}