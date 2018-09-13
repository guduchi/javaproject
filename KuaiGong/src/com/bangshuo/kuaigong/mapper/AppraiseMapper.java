package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.Appraise;

public interface AppraiseMapper {

	// 查询业务员管理的工人评价记录
	List<Appraise> selectBySalesApp(@Param("id") int id,
			@Param("ername") String ername, @Param("erid") String erid);

	// 查询业务员管理的工人评价记录分页
	List<Appraise> selectBySalesAppPage(@Param("page") int page,
			@Param("pageSize") int pageSize, @Param("id") int id,
			@Param("ername") String ername, @Param("erid") String erid);

	//查询订单下的评价
		List<Appraise>selectOrderApp(int id);
	
	// 查看每个信息中 查看雇主评价
	Appraise selectStar(int id);

	// 查看业务员下工人的评价
	Appraise selectAppCount(@Param("id")int id,@Param("ername")String ername,@Param("erid")String erid);

	//查询雇主评价次数
	Appraise appraiseCount(int id);
	
	// 删除评价
	int deleteByPrimaryKey(Integer id);

	// 修改评价
	int updateByPrimaryKey(Appraise record);

	// 查询评价分页
	List<Appraise> QueryUserPaGe(@Param("page") int page,
			@Param("pageSize") int pageSize, @Param("id") int id);

	// QueryUserPaGe
	// QueryUserAll selectAppraise9 selectAppraisePAGe

	// 查询评价
	List<Appraise> QueryUserAll(int id);

	// 查询评价条数
	Appraise queryTheCount(int id);

	// 查询每个信息中评价分页
	List<Appraise> selectAppraisePAGe(@Param("page") int page,
			@Param("pageSize") int pageSize, @Param("id") int id);

	// 查询每个信息中的评价
	List<Appraise> selectAppraise9(int id);
}