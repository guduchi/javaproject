package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.EmployerScale;


public interface EmployerScaleMapper {
	EmployerScale selectNum();
	
    int deleteByPrimaryKey(Integer id);

    int insert(EmployerScale record);

    int insertSelective(EmployerScale record);

    EmployerScale selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployerScale record);

    int updateByPrimaryKey(EmployerScale record);
    
        List<EmployerScale> selectPage1(@Param("username") String username);
      List<EmployerScale> selectByPage1(@Param("username") String username, @Param("page") int page,@Param("pageSize") int pageSize);

    List<EmployerScale> selectByPrimaryKeyScanle (Integer id);

   List<EmployerScale> selectById(Integer id);

  
   
  //�����۷�ҳ
   List<EmployerScale> queryByID(@Param("name") String name);
   
   //�����۷�ҳ
    List<EmployerScale> queryByID1(@Param("name") String name);


	List<EmployerScale> queryByIDPagGe(@Param("page")int page, @Param("pageSize")int pageSize, @Param("name") String name);


List<EmployerScale> queryByPage(@Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id);
//���۷�ҳ����
List<EmployerScale> queryPage(int id);


}