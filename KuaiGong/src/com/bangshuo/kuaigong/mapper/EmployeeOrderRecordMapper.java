package com.bangshuo.kuaigong.mapper;

import com.bangshuo.kuaigong.po.EmployeeOrderRecord;

public interface EmployeeOrderRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeOrderRecord record);

    int insertSelective(EmployeeOrderRecord record);

    EmployeeOrderRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployeeOrderRecord record);

    int updateByPrimaryKey(EmployeeOrderRecord record);
}