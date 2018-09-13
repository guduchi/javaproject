package com.bangshuo.kuaigong.mapper;

import com.bangshuo.kuaigong.po.WaitTime;

public interface WaitTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WaitTime record);
    
    int insertOrderidAndStartTime(int orderid);

    int insertSelective(WaitTime record);

    WaitTime selectByPrimaryKey(Integer id);
    
    WaitTime selectByOrderid(Integer orderid);

    int updateByPrimaryKeySelective(WaitTime record);

    int updateByPrimaryKey(WaitTime record);
    
    int updateByOrderid(Integer orderid);
}