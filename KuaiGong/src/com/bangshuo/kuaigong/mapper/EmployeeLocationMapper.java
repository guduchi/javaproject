package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.EmployeeLocation;

public interface EmployeeLocationMapper {
	
	EmployeeLocation	 selectNum(@Param("query")String query);
	 
	//查询工人状态和地图
		List<EmployeeLocation> queryAllDiTu();

		List<EmployeeLocation> EmployeeLocation(@Param("eeid")int eeid, @Param("longitude")String longitude,@Param("latitude")String latitude);
	//ģ���ѯ��ҳ����
	List<EmployeeLocation> selectNameORusername1(String name);
	//��ģ���ѯ��ҳ����
	List<EmployeeLocation> selectNameORusername(String name);
  //ģ���ѯ��ҳ
	List<EmployeeLocation> selectNameORusernamepage(@Param("page") int page,@Param("pageSize") int pageSize,@Param("name") String name,@Param("username") String username);
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeLocation record);

    int insertSelective(EmployeeLocation record);
    
    

   List<EmployeeLocation>selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(EmployeeLocation record);

    int updateByPrimaryKey(EmployeeLocation record);
    
 
   List<EmployeeLocation> selectPage(@Param("query") String query);
   List<EmployeeLocation> selectByPage(@Param("query") String query, @Param("page") int page,@Param("pageSize") int pageSize);
}