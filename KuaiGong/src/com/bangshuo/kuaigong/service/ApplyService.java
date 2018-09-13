package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.ApplyMapper;
import com.bangshuo.kuaigong.po.Apply;

public class ApplyService {

	@Autowired
	ApplyMapper applyMapper;

	public Apply selectNum(String username,String starttime,String endtime) {

		Apply list = applyMapper.selectNum(username, starttime, endtime);
		
		return list;
	}

	public int deleteApply(int id) {
		int list = applyMapper.deleteApply(id);
		return list;
	}

	// ���ձ�������
	public List<Apply> selectAllToAll() {
		List<Apply> list = applyMapper.selectAllToAll();
		return list;
	}

	public List<Apply> selectAll(String username, String starttime,
			String endtime) {

		List<Apply> list = applyMapper.selectAll(username, starttime, endtime);

		return list;
	}

	public List<Apply> selectAllPage(String username, String starttime,
			String endtime, int pageSize, int page) {

		List<Apply> list = applyMapper.selectAllPage(username, starttime,
				endtime, page, pageSize);

		return list;
	}

}
