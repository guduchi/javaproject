package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.DiscountCoupon;
import com.bangshuo.kuaigong.po.EmployerMessageById;
import com.bangshuo.kuaigong.po.SendCouponMessage;

public interface DiscountCouponMapper {
	
	
	DiscountCoupon selectNum(@Param("query")String query);
	
	//selectCoupon selectNum selectDisCountToUserInfo selectDisCountToUser selectAll selectByPage
	
	//查询每个信息中的优惠券表
	DiscountCoupon selectCoupon(int id);
	/*删除*/
    int deleteByPrimaryKey(Integer id);
    /*查询*/
    List<DiscountCoupon> selectAll(@Param("query") String query);
    /*修改*/
    int updateByPrimaryKeySelective(DiscountCoupon record);
    int updateByPrimaryKey(DiscountCoupon record);
   /*查看每个信息中 优惠券*/
    List<DiscountCoupon> selectDisCountToUser(Integer id);
   /*查询*/
    List<DiscountCoupon> selectDisCountToUserInfo(@Param("page") int page,@Param("pageSize") int pageSize,@Param("id") int id);
    /*查询*/
    List<DiscountCoupon> selectByPage(@Param("query") String query, @Param("page") int page,@Param("pageSize") int pageSize);
    //发送优惠券
    int insertDisCount(DiscountCoupon discountCoupon);
    
	List<EmployerMessageById> selectEmplyerById(EmployerMessageById message);
	/**
     * 查询优惠卷需要发送的数量
     * @return
     */
	List<SendCouponMessage> selectSendCouponMessage();
	/**
	 * 更改发送优惠卷数量
	 * @param scm
	 * @return
	 */
	int updateSendCouponMessage(SendCouponMessage scm);
	/**
	 * 插入需要发的数量
	 * @param scm
	 * @return
	 */
	int insertSendCouponMessage(SendCouponMessage scm);



}