package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.DiscountCouponMapper;
import com.bangshuo.kuaigong.po.DiscountCoupon;
import com.bangshuo.kuaigong.po.EmployerMessageById;
import com.bangshuo.kuaigong.po.SendCouponMessage;

public class DiscountCouponService {

	@Autowired
	DiscountCouponMapper discountCouponMapper;



	//查询每个信息中的优惠券表
	public DiscountCoupon selectCoupon(int id){

		DiscountCoupon list=discountCouponMapper.selectCoupon(id);

		return list;
	}

	public DiscountCoupon selectNum(String query){

		DiscountCoupon list = discountCouponMapper.selectNum(query);

		return list;
	}

	//��ҳ��ѯ
	public  List<DiscountCoupon> selectDisCount(int id){
		List<DiscountCoupon> list=discountCouponMapper.selectDisCountToUser(id);
		return list;
	}
	//��ҳ��ѯ����
	public  List<DiscountCoupon> selectDisCountToUserInfo(int page,int pageSize,int id){
		List<DiscountCoupon> list=discountCouponMapper.selectDisCountToUserInfo(page, pageSize, id);
		return list;
	}

	public List<DiscountCoupon> selectByPage(String query, int page,int pageSize){

		List<DiscountCoupon> list = 	discountCouponMapper.selectByPage(query,page, pageSize);

		return list;

	}

	public List<DiscountCoupon> queryAll(String query){

		List<DiscountCoupon>list = discountCouponMapper.selectAll(query);

		return list;

	}

	public int updateByPrimaryKeySelective(DiscountCoupon discountCoupon){

		int list = discountCouponMapper.updateByPrimaryKeySelective(discountCoupon);

		return list;
	}

	public  int deleteByPrimaryKey(int id){
		int num = discountCouponMapper.deleteByPrimaryKey(id);

		return num;
	}
	//发送优惠券
	public int insetToDisCount(DiscountCoupon discountCoupon) {
		int list=discountCouponMapper.insertDisCount(discountCoupon);
		return list;
	}

	public List<EmployerMessageById> selectEmplyerById(EmployerMessageById message) {

		return discountCouponMapper.selectEmplyerById(message);
	}
	/**
	 * 查询优惠卷需要发送的数量
	 * @return
	 */
	public List<SendCouponMessage> selectSendCouponMessage() {

		return discountCouponMapper.selectSendCouponMessage();
	}

	/**
	 * 更改发送优惠卷数量
	 * @param scm
	 * @return
	 */
	public int updateSendCouponMessage(SendCouponMessage scm) {
		// TODO Auto-generated method stub
		return discountCouponMapper.updateSendCouponMessage(scm);
	}

	/**
	 * 插入需要发的数量
	 * @param scm
	 * @return
	 */
	public int insertSendCouponMessage(SendCouponMessage scm) {
		return discountCouponMapper.insertSendCouponMessage(scm);
	}

}