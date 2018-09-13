package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.EmployeeUser;

public interface EmployeeUserMapper {
	
	EmployeeUser queryCountMoney(@Param("id")String id,@Param("starttime")String starttime,@Param("endtime")String endtime);
	
	EmployeeUser salesemployeeuser(@Param("id")int id,@Param("name")String name,@Param("username")String username);
	
	//查询工人个数
	EmployeeUser selectNum(@Param("name")String name,@Param("eeid")String eeid,@Param("phone")String phone,@Param("btu")String btu);
	
	//转移
	int updateSalesmanId(EmployeeUser employeeUser);
	//修改转移
	int updateid(EmployeeUser employeeUser);
	
	//查询业务员管理的工人
	List<EmployeeUser>selectBySalesman(@Param("id")int id,@Param("name")String name,@Param("username")String username);
	//查询业务员管理的工人
	List<EmployeeUser>selectBySalesmanPage(@Param("page")int page,@Param("pageSize")int pageSize,@Param("id")int id,@Param("name")String name,@Param("username")String username);
	
	//删除
    int deleteByPrimaryKey(Integer id);
    //添加
    int insert(EmployeeUser record);
    //修改
    int updateByPrimaryKey(EmployeeUser employeeUser);
    int updateByPrimaryKey1(EmployeeUser employeeUser);
    //查个�?
    List<EmployeeUser> selectCount(Integer id);
    /*查询*/
	List<EmployeeUser> selectByName1(@Param("name") String name,@Param("eeid") String eeid, @Param("phone") String phone,@Param("btu") String btu);//,@Param("salesmanName")String salesmanName);
    /*分页*/
	List<EmployeeUser> selectByNamePage(@Param("page") int page,@Param("pageSize") int pageSize,@Param("name")String name,@Param("eeid") String eeid, @Param("phone") String phone, @Param("btu") String btu);//,@Param("salesmanName")String salesmanName);
	
    
    //根据ID查询
    List<EmployeeUser> selectByPrimaryKey(int id);
    //根据ID查询分页
    List<EmployeeUser>selectByPrimaryPage(@Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id);
    	
    //全查
    List<EmployeeUser> selectAll();
    //全查分页
    List<EmployeeUser> selectByPage(@Param("page") int page,@Param("pageSize") int pageSize);
    
    //查所有收�?   
    List<EmployeeUser> selectAllMoney( @Param("id")int id, @Param("desc") String desc);
    //查收入分�?    
    List<EmployeeUser> selectBYPageMoney(@Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id, @Param("desc") String desc);

    //查所有在线时�?    
    List<EmployeeUser> selectAllOnline(int id);
    //查所有在线时间分�?
    List<EmployeeUser> selectByPaGeOnline(@Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id);

    //查干活次�? 
    List<EmployeeUser>selectByWork(int id);
    //查询干活次数分页
    List<EmployeeUser>selectByPageWork(@Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id);
      
    //查询详细信息
    List<EmployeeUser> selectUserLocation(int id);
    //查询详细信息分页
    List <EmployeeUser>selectAllByPage(@Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id);
    //模糊查询总数
    List<EmployeeUser> selectByName(String name);
    //模糊查询分页

   //查提现时�?    List<EmployeeUser> queryData(@Param("starttime") String starttime,@Param("endtime") String endtime);
    
    List<EmployeeUser> queryDate(@Param("starttime") String starttime,@Param("endtime") String endtime);
    List<EmployeeUser> queryDate1(@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("id") int id);
   
    List<EmployeeUser> queryDatePaGe1(@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("page") int page,@Param("pageSize") int pageSize);
    
    List<EmployeeUser> queryDatePaGe(@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id);
    
    List<EmployeeUser> queryDato(@Param("startime") String startime,@Param("endtime") String endtime,@Param("id") int id);
    List<EmployeeUser> queryDatoo(@Param("startime") String startime,@Param("endtime") String endtime);
    List<EmployeeUser> queryDatooPage(@Param("startime") String startime,@Param("endtime") String endtime,@Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id);
	List<EmployeeUser> queryData(@Param("startime")String startime, @Param("endtime")String endtime, @Param("id")int id, @Param("desc") String desc);
	List<EmployeeUser> queryData1(@Param("startime")String startime, @Param("endtime")String endtime);
	
	List<EmployeeUser> queryDataPage(@Param("startime")String startime, @Param("endtime")String endtime,@Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id, @Param("desc") String desc);

	List<EmployeeUser> queryDatePaGe66(@Param("starttime")String starttime, @Param("endtime") String endtime, @Param("status") String status, @Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id);
	List<EmployeeUser> selectAllMoney1(@Param("id") int id,@Param("desc") String desc);
	//查提现记录条数
	List<EmployeeUser> queryCount(@Param("id") int id,@Param("desc") String desc);
	List<EmployeeUser> queryshouyi(@Param("id") int id, @Param("starttime") String starttime,@Param("endtime") String endtime);
	List<EmployeeUser> queryshouyiInfo(@Param("id") int id, @Param("page") int page, @Param("pageSize") int pageSize, @Param("starttime") String starttime,@Param("endtime") String endtime);

	List<EmployeeUser> selectByusernameOrname(int id);

	List<EmployeeUser> selectEeuseregid(int id);

	int updateStatus(@Param("username") String username,@Param("status") String status);


	
}