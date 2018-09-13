package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.bangshuo.kuaigong.po.recharge;

public interface rechargeMapper {
List<recharge> select(int id);
List<recharge> selectpage(@Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id);
List<recharge> selectRechargeByTime(@Param("starttime") String starttime,@Param("endtime") String endtime);
//充值记录
int selectSum(int id);
}
