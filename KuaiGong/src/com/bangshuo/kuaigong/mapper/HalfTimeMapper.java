package com.bangshuo.kuaigong.mapper;

import com.bangshuo.kuaigong.po.HalfTime;

public interface HalfTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HalfTime record);

    int insertSelective(HalfTime record);

    HalfTime selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HalfTime record);

    int updateByPrimaryKey(HalfTime record);
}