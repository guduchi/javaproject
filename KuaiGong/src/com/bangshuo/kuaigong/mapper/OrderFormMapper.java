package com.bangshuo.kuaigong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bangshuo.kuaigong.po.OrderForm;

public interface OrderFormMapper {

	List<OrderForm> OrderFormPosition(@Param("id")String id,@Param("latitude")String latitude,@Param("longitude")String longitude);

	OrderForm selectWorkAll(@Param("id")String id,@Param("name")String name,@Param("OrderID")String OrderID,@Param("starttime")String starttime,@Param("endtime")String endtiime);

	// 查询招工次数
	OrderForm selectWorks(@Param("id")String id,@Param("eename")String eename,@Param("GRusername")String GRusername,@Param("status")String status,@Param("starttime")String starttime,@Param("endtime")String endtime);
	//查询业务员下工人的订单数
	OrderForm salesorder(@Param("id")int id,@Param("name")String name,@Param("username")String username,@Param("status")String status);
	// 查询每个信息中点单
	OrderForm selectSingle(int id);

	// 查询订单个数
	OrderForm selectNum(@Param("id")String id,@Param("eename")String eename,@Param("name")String name,@Param("btu")String btu,@Param("starttime")String starttime,@Param("endtime")String endtime,@Param("payment")String payment);

	// 查询订单
	List<OrderForm> selectSalesmanOrder(@Param("id") int id,
			@Param("name") String name, @Param("username") String username,
			@Param("status") String status);

	// 查询订单
	List<OrderForm> selectSalesmanOrderPage(@Param("page") int page,
			@Param("pageSize") int pageSize, @Param("id") int id,
			@Param("name") String name, @Param("username") String username,
			@Param("status") String status);

	int updateOrderByPrimaryKey(OrderForm orderForm);

	// 查询订单详细信息
	List<OrderForm> selectDetailed(int id);

	// 查询叫工
	List<OrderForm> selectOrderForm(@Param("eeid") String eeid,
			@Param("eename") String eename,
			@Param("GRusername") String Grusername,
			@Param("status") String status,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime, @Param("id") String id);

	// 查询叫工分页
	List<OrderForm> selectOrderFormPage(@Param("page") int page,
			@Param("pageSize") int pageSize, @Param("eeid") String eeid,
			@Param("eename") String eename,
			@Param("GRusername") String Grusername,
			@Param("status") String status,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime, @Param("id") String id);

	// 工人工作记录的全部 查询分页总数
	List<OrderForm> GROrderFormPage(@Param("id") int id,
			@Param("OrderID") String OrderID, @Param("name") String name,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime);

	// 工人工作记录的全部 查询分页
	List<OrderForm> GROrderFormInfo(@Param("id") int id,
			@Param("OrderID") String OrderID, @Param("name") String name,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime, @Param("page") int page,
			@Param("pageSize") int pageSize);


	List<OrderForm> selectCount(Integer id);

	int insert(OrderForm record);

	int insertSelective(OrderForm record);

	int updateByPrimaryKeySelective(OrderForm record);
	List<OrderForm> selectByTime(@Param("starttime") String starttime,
			@Param("endtime") String endtime, @Param("id") int id);

	int deleteByPrimaryKey(Integer id);

	int updateByPrimaryKey(OrderForm orderForm);

	List<OrderForm> selectCount(int id);

	List<OrderForm> selectAlll6(@Param("id") String id,
			@Param("name") String name,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime, @Param("btu") String btu,
			@Param("eename") String eename,@Param("payment")String payment);

	List<OrderForm> selectByPagee6(@Param("page") int page,
			@Param("pageSize") int pageSize, @Param("id") String id,
			@Param("name") String name,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime, @Param("btu") String btu,
			@Param("eename") String eename,@Param("payment")String payment);

	int updateByPrimaryKey1(OrderForm orderForm);


	/* 李奎的代码String yesterday, String now,String id,String btu,String starttime,String endtime,String name,String eename */
	
	List<OrderForm> selectOrderByTime(@Param("yesterday") String yesterday,@Param("now") String now,@Param("id") String id,@Param("eename") String eename,@Param("name") String name,@Param("btu") String btu);
	
	//查询消费
	List<OrderForm> queryAll(@Param("id")String id,@Param("name") String name,
			@Param("eename")String eename,@Param("starttime")String starttime,
			@Param("endtime")String endtime,@Param("btu")String btu,@Param("payment")String payment);
//	//查询总消费（收益）
//	OrderForm queryOrderCost();

	List<OrderForm> selectOrderByTimeInfo(@Param("yesterday") String yesterday,@Param("now") String now,@Param("id") String id,@Param("eename") String eename,@Param("name") String name,@Param("btu") String btu,@Param("page") int page,@Param("pageSize") int pageSize);

	List<OrderForm> selectOrderFinishByYesterdayInfo(@Param("yesterday") String yesterday,@Param("now")
			String now, @Param("orderid") String orderid,@Param("eename") String eename,@Param("name") String name,@Param("btu") String btu,
			@Param("page") int page,@Param("pageSize") int pageSize);

	List<OrderForm> selectOrderFinishByTime(@Param("yesterday") String yesterday,@Param("now") String now,@Param("orderid")
			String orderid,@Param("eename") String eename,@Param("name") String name,@Param("btu") String btu);

//查询微信订单钱数
List<OrderForm> WeiXinMoney();
//查询支付宝订单钱数
List<OrderForm> ZhiFuBaoMoney();
//余额微信订单钱数
List<OrderForm> YueMoney();
//微信支付的订单
List<OrderForm> selectPaymentWeiXin(@Param("eename")String eename,
		@Param("name")String name,@Param("id")String id,
		@Param("btu")String btu,@Param("starttime")String starttime,
		@Param("endtime")String endtime);
//微信支付的订单分页
List<OrderForm>selectPaymentWeiXinPage(@Param("page")int page,
		@Param("pageSize")int pageSize,@Param("eename")String eename,
		@Param("name")String name,@Param("id")String id,
		@Param("btu")String btu,@Param("starttime")String starttime,
		@Param("endtime")String endtime);
//微信支付方式数量
OrderForm selectPaymentWeiXinCount(@Param("eename")String eename,@Param("name")String name,@Param("id")String id,@Param("btu")String btu,@Param("starttime")String starttime,@Param("endtime")String endtime);
//微信支付的金额
OrderForm selectPaymentWeiXinMoney(@Param("eename")String eename,@Param("name")String name,@Param("id")String id,@Param("btu")String btu,@Param("starttime")String starttime,@Param("endtime")String endtime);

//支付宝支付的订单
List<OrderForm> selectPaymentZhiFuBao(@Param("id")String id,
		@Param("eename")String eename,
		@Param("name")String name,
		@Param("btu")String btu,@Param("starttime")String starttime,
		@Param("endtime")String endtime);
//支付宝支付的订单分页
List<OrderForm>selectPaymentZhiFuBaoPage(@Param("page")int page,
		@Param("pageSize")int pageSize,@Param("id")String id,
		@Param("eename")String eename,
		@Param("name")String name,
		@Param("btu")String btu,@Param("starttime")String starttime,
		@Param("endtime")String endtime);
//支付宝支付方式数量
OrderForm selectPaymentZhiFuBaoCount(@Param("id")String id,@Param("eename")String eename,@Param("name")String name,@Param("btu")String btu,@Param("starttime")String starttime,@Param("endtime")String endtime);
//支付宝支付的金额
OrderForm selectPaymentZhiFuBaoMoney(@Param("eename")String eename,@Param("name")String name,@Param("id")String id,@Param("btu")String btu,@Param("starttime")String starttime,@Param("endtime")String endtime);

//余额支付的订单
List<OrderForm> selectPaymentYue(@Param("eename")String eename,
		@Param("name")String name,@Param("id")String id,
		@Param("btu")String btu,@Param("starttime")String starttime,
		@Param("endtime")String endtime);
//余额支付的订单分页
List<OrderForm>selectPaymentYuePage(@Param("page")int page,
		@Param("pageSize")int pageSize,@Param("id")String id,
		@Param("eename")String eename,
		@Param("name")String name,
		@Param("btu")String btu,@Param("starttime")String starttime,
		@Param("endtime")String endtime);
//余额支付方式数量
OrderForm selectPaymentYueCount(@Param("id")String id,@Param("eename")String eename,@Param("name")String name,@Param("btu")String btu,@Param("starttime")String starttime,@Param("endtime")String endtime);
//余额支付的金额
OrderForm selectPaymentYueMoney(@Param("id")String id,@Param("eename")String eename,@Param("name")String name,@Param("btu")String btu,@Param("starttime")String starttime,@Param("endtime")String endtime);

List<OrderForm> sortTime(@Param("id")String id,@Param("name")String name,@Param("starttime")String starttime,@Param("endtime")String endtime,@Param("btu")String btu,@Param("eename")String eename,@Param("payment")String payment);

List<OrderForm> sortTimeInfo(@Param("page") int page,@Param("pageSize") int pageSize,@Param("id")String id,@Param("name")String name,@Param("starttime")String starttime,@Param("endtime")String endtime,@Param("btu")String btu,@Param("eename")String eename,@Param("payment")String payment);

//取消的订单
List<OrderForm> cancelOrder(@Param("eename")String eename,
		@Param("name")String name,@Param("id")String id,
		@Param("btu")String btu,@Param("starttime")String starttime,
		@Param("endtime")String endtime);
//取消的订单分页
List<OrderForm>cancelOrderPage(@Param("page")int page,
		@Param("pageSize")int pageSize,@Param("id")String id,
		@Param("eename")String eename,
		@Param("name")String name,
		@Param("btu")String btu,@Param("starttime")String starttime,
		@Param("endtime")String endtime);
//取消的订单数量
OrderForm cancelOrderCount(@Param("id")String id,@Param("eename")String eename,@Param("name")String name,@Param("btu")String btu,@Param("starttime")String starttime,@Param("endtime")String endtime);
//取消的订单数
List<OrderForm> cancelCount();
}