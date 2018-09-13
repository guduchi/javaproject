package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.WechatNoticeMapper;

import com.bangshuo.kuaigong.po.WechatNotice;

public class WechatNoticeService {
	@Autowired
	WechatNoticeMapper wechatNoticeMapper;
	public List<WechatNotice> queryOpenid(int erid){
		 List<WechatNotice> list=wechatNoticeMapper.queryOpenid(erid);
		 return list;
	}
}
