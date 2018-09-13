package com.bangshuo.kuaigong.mapper;

import java.util.List;

import com.bangshuo.kuaigong.po.WechatNotice;

public interface WechatNoticeMapper {

List<WechatNotice> queryOpenid(int erid);
}
