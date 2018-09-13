package com.bangshuo.kuaigong.mapper;

import com.bangshuo.kuaigong.po.SalesmanVersion;

public interface SalesmanVersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SalesmanVersion record);

    int insertSelective(SalesmanVersion record);

    SalesmanVersion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SalesmanVersion record);

    int updateByPrimaryKey(SalesmanVersion record);
}