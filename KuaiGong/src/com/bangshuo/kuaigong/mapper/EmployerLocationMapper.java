package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.EmployerLocation;

public interface EmployerLocationMapper {
	
	EmployerLocation	 	selectNum(@Param("query")String query);
	
	List<EmployerLocation> queryAllDiTu();
	List<EmployerLocation> selectNameOrUsername1(String name);
	//ģ���ѯ
	List<EmployerLocation> selectNameOrUsername(String name);
	//ģ���ѯ��ҳ
	List<EmployerLocation> selectNameOrUsernameByPaGe(@Param("page") int page,@Param("pageSize") int pageSize,@Param("name") String name,@Param("username") String username);
    
	int deleteByPrimaryKey(Integer id);

    int insert(EmployerLocation record);

    int insertSelective(EmployerLocation record);
    
    List<EmployerLocation> selectAll();

    List<EmployerLocation>selectByPrimaryKey1(Integer id);

    int updateByPrimaryKeySelective(EmployerLocation employerLocation);

    int updateByPrimaryKey(EmployerLocation record);
    
    List<EmployerLocation> selectLocation(int id);
    
     List<EmployerLocation> selectPage(@Param("query") String query);
    
     List<EmployerLocation> selectByPage(@Param("query") String query, @Param("page") int page,@Param("pageSize") int pageSize);

	List<com.bangshuo.kuaigong.po.EmployerLocation> EmployerLocation(@Param("erid") int erid,@Param("longitude") String longitude,
			@Param("latitude")	String latitude);
}