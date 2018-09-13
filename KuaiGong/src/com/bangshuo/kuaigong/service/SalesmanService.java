package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.SalesmanMapper;
import com.bangshuo.kuaigong.po.Salesman;

public class SalesmanService {
	@Autowired
	SalesmanMapper salesmanMapper;

	public Salesman selectNum(String id, String salesmanName,String username, String status, String position, String superiorId) {
      
		Salesman list = salesmanMapper.selectNum(id, salesmanName, username, status, position, superiorId);
		
		return list;
	}

	// 查询详细信息
	public List<Salesman> selectmany(int id) {

		List<Salesman> list = salesmanMapper.selectMany(id);

		return list;
	}

	// 查询业务员
	public List<Salesman> selectSalesman(String id, String salesmanName,
			String username, String status, String position, String superiorId) {

		List<Salesman> list = salesmanMapper.selectSalesman(id, salesmanName,
				username, status, position, superiorId);

		return list;
	}

	// 查询业务员分页
	public List<Salesman> selectSalesmanPage(int page, int pageSize, String id,
			String salesmanName, String username, String status,
			String position, String superiorId) {

		List<Salesman> list = salesmanMapper.selectSalesmanPage(page, pageSize,
				id, salesmanName, username, status, position, superiorId);

		return list;
	}

	// 修改
	public int updateByPrimaryKey(Salesman salesman) {

		int list = salesmanMapper.updateByPrimaryKey(salesman);

		return list;
	}

	// 删除
	public int deleteByPrimaryKey(int id) {

		int list = salesmanMapper.deleteByPrimaryKey(id);

		return list;
	}

	// 添加
	public int insert(Salesman salesman) {

		int list = salesmanMapper.insert(salesman);

		return list;
	}

	public Salesman selectByUsername(String username) {
		Salesman result = salesmanMapper.selectByUsername(username);
		return result;
	}

}
