package com.bangshuo.kuaigong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangshuo.kuaigong.mapper.OrderFormMapper;
import com.bangshuo.kuaigong.po.OrderForm;

public class OrderFormService {

	@Autowired
	OrderFormMapper orderFormMapper;

	//订单位置
	public List<OrderForm> OrderFormPosition(String id,String latitude,String longitude){
		
		List<OrderForm> list = orderFormMapper.OrderFormPosition(id, latitude, longitude);
		
		return list;
	}

	// 查看每个信息中点单
	public OrderForm selectSingle(int id) {

		OrderForm list = orderFormMapper.selectSingle(id);

		return list;
	}

	// 查看工人干活记录
	public OrderForm selectWorkAll(String id,String name,String OrderID,String starttime,String endtime) {

		OrderForm list = orderFormMapper.selectWorkAll(id,name,OrderID,starttime,endtime);

		return list;
	}
	// 查看工人干活记录
	public OrderForm salesorder(int id,String name,String username,String status){
		
		OrderForm list = orderFormMapper.salesorder(id, name, username, status);
		
		return list;
	}

	// 查看招工次数
	public OrderForm selectWorks(String id,String eename,String GRusername,String status,String starttime,String endtime) {

		OrderForm list = orderFormMapper.selectWorks(id, eename, GRusername, status, starttime, endtime);

		return list;
	}

	// 查询工人个数
	public OrderForm selectNum(String id,String eename,String name,String btu,String starttime,String endtime,String payment) {

		OrderForm list = orderFormMapper.selectNum(id, eename, name, btu, starttime, endtime,payment);
		
		return list;
	}

	// 查询订单
	public List<OrderForm> selectSalesmanOrder(int id, String name,
			String username, String status) {
		List<OrderForm> list = orderFormMapper.selectSalesmanOrder(id, name,
				username, status);
		return list;
	}

	// 查询订单分页
	public List<OrderForm> selectSalesmanOrderPage(int page, int pageSize,
			int id, String name, String username, String status) {
		List<OrderForm> list = orderFormMapper.selectSalesmanOrderPage(page,
				pageSize, id, name, username, status);
		return list;
	}

	// 查询招工
	public List<OrderForm> selectOrderForm(String eeid, String eename,
			String GRusername, String status, String starttime, String endtime,
			String id) {

		List<OrderForm> list = orderFormMapper.selectOrderForm(eeid, eename,
				GRusername, status, starttime, endtime, id);

		return list;
	}

	// 查询招工分页
	public List<OrderForm> selectOrderFormPage(int page, int pageSize,
			String eeid, String eename, String GRusername, String status,
			String starttime, String endtime, String id) {

		List<OrderForm> list = orderFormMapper.selectOrderFormPage(page,
				pageSize, eeid, eename, GRusername, status, starttime, endtime,
				id);

		return list;
	}

	// 全部查询查询分页总数
	public List<OrderForm> GROrderFormPage(int id, String OrderID, String name,
			String starttime, String endtime) {
		List<OrderForm> list = orderFormMapper.GROrderFormPage(id, OrderID,
				name, starttime, endtime);
		return list;
	}

	// 全部查询查询分页

	public List<OrderForm> GROrderFormPageInfo(int id, String OrderID,
			String name, String starttime, String endtime, int page,
			int pageSize) {
		List<OrderForm> list = orderFormMapper.GROrderFormInfo(id, OrderID,
				name, starttime, endtime, page, pageSize);
		return list;
	}

	// ��ѯ��������
	public List<OrderForm> selectAlll6(String id, String name,
			String starttime, String endtime, String btu, String eename,String payment) {
		List<OrderForm> list = orderFormMapper.selectAlll6(id, name, 
				starttime, endtime, btu, eename,payment);
		return list;
	}

	// ��ѯ���������ҳ
	public List<OrderForm> selectByPagee6(int page, int pageSize, String id,
			String name,String starttime, String endtime,
			String btu, String eename,String payment) {
		List<OrderForm> list = orderFormMapper.selectByPagee6(page, pageSize,
				id, name,starttime, endtime, btu, eename,payment);
		return list;
	}

	// ���ʱ���ѯ
	public List<OrderForm> selectByTime(String starttime, String endtime, int id) {
		List<OrderForm> list = orderFormMapper.selectByTime(starttime, endtime,
				id);
		return list;
	}


	public List<OrderForm> selectCountOrderForm(int id) {
		List<OrderForm> list = orderFormMapper.selectCount(id);
		return list;
	}


	public int insert(OrderForm orderForm) {

		int list = orderFormMapper.insert(orderForm);

		return list;
	}

	public int insertSelective(OrderForm orderForm) {
		int list = orderFormMapper.insertSelective(orderForm);

		return list;
	}

	public int updateByPrimaryKeySelective(OrderForm orderForm) {

		int list = orderFormMapper.updateByPrimaryKeySelective(orderForm);

		return list;
	}

	public int deleteByPrimaryKey(int id) {
		int list = orderFormMapper.deleteByPrimaryKey(id);

		return list;
	}

	/* 李奎的代码 */

	public List<OrderForm> selectOrderByTime(String yesterday, String now,String id,String eename,String name,String btu) {
		List<OrderForm> list = orderFormMapper.selectOrderByTime(yesterday,now,id,eename,name,btu);
		return list;
	}

	/* 李奎的代码 */

	public List<OrderForm> selectOrderFinishByTime(String starttime,
			String endtime, String orderid, String eename, String name, String btu) {
		List<OrderForm> list = orderFormMapper.selectOrderFinishByTime(
				starttime, endtime,orderid,eename,name,btu);
		return list;
	}

	// ========================kw
	public int updateOrderByPrimaryKey(OrderForm orderForm) {
		int result = orderFormMapper.updateOrderByPrimaryKey(orderForm);
		return result;
	}

	// 查询订单详细信息
	public List<OrderForm> selectDetailed(int id) {
        System.out.print(id);
		List<OrderForm> list = orderFormMapper.selectDetailed(id);
        System.out.print(list.get(0).getCost());

		return list;
	}
	//查询雇主总支出
	public List<OrderForm> queryAll(String id,String name,String eename,String starttime,String endtime,String btu,String payment) {
	
		List<OrderForm> list = orderFormMapper.queryAll(id,name,eename,starttime, endtime,btu,payment);
		
		return list;
	}

	public List<OrderForm> selectOrderByTimeInfo(String yesterday, String now,
			String id, String eename, String name, String btu, int page,
			int pageSize) {
		List<OrderForm> list = orderFormMapper.selectOrderByTimeInfo(yesterday,now,id,eename,name,btu,page,pageSize);
		return list;
	}

	public List<OrderForm> selectOrderFinishByYesterdayInfo(String yesterday,
			String now, String id, String eename, String name, String btu,
			int page, int pageSize) {
		List<OrderForm> list = orderFormMapper.selectOrderFinishByYesterdayInfo(yesterday,now,id,eename,name,btu,page,pageSize);
		return list;
	}

//查询微信订单钱数
	public List<OrderForm> WeiXinMoney() {
		
		List<OrderForm> list = orderFormMapper.WeiXinMoney();
		
		return list;
	}
	//查询支付宝订单钱数
	public List<OrderForm> ZhiFuBaoMoney() {
		
		List<OrderForm> list = orderFormMapper.ZhiFuBaoMoney();
		
		return list;
	}
	//查询余额订单钱数
	public List<OrderForm> YueMoney() {
		
		List<OrderForm> list = orderFormMapper.YueMoney();
		
		return list;
	}
	
	//微信查询支付方式
	public  List< OrderForm> selectPaymentWeiXin(String eename,String name,String id,String btu,String starttime,String endtime){
		
	List	<OrderForm> list =orderFormMapper.selectPaymentWeiXin(eename, name, id, btu, starttime,endtime);
		
		return list;
	}
	//微信查询支付方式分页page, pageSize,id, eename, name, btu, starttime, endtime
	public List<OrderForm> selectPaymentWeiXinPage(int page,int pageSize,String id,String eename,String name,String btu,String starttime,String endtime){
		
		List<OrderForm> list = orderFormMapper.selectPaymentWeiXinPage(page,pageSize,eename, name, id, btu, starttime,endtime);
		
		return list;
	}
	//微信查询支付方式数量
	public OrderForm selectPaymentWeiXinCount(String eename,String name,String id,String btu,String starttime,String endtime){
		
		OrderForm list = orderFormMapper.selectPaymentWeiXinCount(eename, name, id, btu, starttime, endtime);
		
		return list;
	}
	//微信查询支付方式金额
	public OrderForm selectPaymentWeiXinMoney(String eename,String name,String id,String btu,String starttime,String endtime){
		
		OrderForm list = orderFormMapper.selectPaymentWeiXinMoney(eename, name, id, btu, starttime, endtime);
		
		return list;
	}
	//支付宝查询支付方式
	public  List< OrderForm> selectPaymentZhiFuBao(String eename,String name,String id,String btu,String starttime,String endtime){
		
		List	<OrderForm> list =orderFormMapper.selectPaymentZhiFuBao(eename, name, id, btu, starttime,endtime);
		
		return list;
	}
	//支付宝查询支付方式分页
	public List<OrderForm> selectPaymentZhiFuBaoPage(int page,int pageSize,String id,String eename,String name,String btu,String starttime,String endtime){
		
		List<OrderForm> list = orderFormMapper.selectPaymentZhiFuBaoPage(page,pageSize,id, eename, name, btu, starttime,endtime);
		
		return list;
	}
	//支付宝查询支付方式数量
	public OrderForm selectPaymentZhiFuBaoCount(String id,String eename,String name,String btu,String starttime,String endtime){
		
		OrderForm list = orderFormMapper.selectPaymentZhiFuBaoCount( id, eename, name,btu, starttime, endtime);
		
		return list;
	}
	//支付宝查询支付方式金额
	public OrderForm selectPaymentZhiFuBaoMoney(String eename,String name,String id,String btu,String starttime,String endtime){
		
		OrderForm list = orderFormMapper.selectPaymentZhiFuBaoMoney(eename, name, id, btu, starttime, endtime);
		
		return list;
	}
	//余额查询支付方式
	public  List< OrderForm> selectPaymentYue(String eename,String name,String id,String btu,String starttime,String endtime){
		
		List	<OrderForm> list =orderFormMapper.selectPaymentYue(eename, name, id, btu, starttime,endtime);
		
		return list;
	}
	//余额查询支付方式分页
	public List<OrderForm> selectPaymentYuePage(int page,int pageSize,String id,String eename,String name,String btu,String starttime,String endtime){
		
		List<OrderForm> list = orderFormMapper.selectPaymentYuePage(page,pageSize, id,eename, name, btu, starttime,endtime);
		
		return list;
	}
	//余额查询支付方式数量
	public OrderForm selectPaymentYueCount(String id,String eename,String name,String btu,String starttime,String endtime){
		
		OrderForm list = orderFormMapper.selectPaymentYueCount(id, eename, name, btu, starttime, endtime);
		
		return list;
	}
	//余额查询支付方式金额
	public OrderForm selectPaymentYueMoney(String eename,String name,String id,String btu,String starttime,String endtime){
		
		OrderForm list = orderFormMapper.selectPaymentYueMoney(eename, name, id, btu, starttime, endtime);
		
		return list;
	}
	public int updateByPrimaryKey1(OrderForm orderForm) {
		int list = orderFormMapper.updateByPrimaryKey1(orderForm);
		return list;
	}

	public List<OrderForm> sortTime(String id, String name, String starttime, String endtime, String btu, String eename, String payment) {
		List<OrderForm> list=orderFormMapper.sortTime(id,name,starttime,endtime,btu,eename,payment);
		return list;
	}

	public List<OrderForm> sortTimeInfo(int page, int pageSize, String id, String name, String starttime, String endtime, String btu, String eename, String payment) {
		List<OrderForm> list=orderFormMapper.sortTimeInfo(page,pageSize,id,name,starttime,endtime,btu,eename,payment);
		return list;
	}
	
	//订单取消
	public  List< OrderForm> cancelOrder(String eename,String name,String id,String btu,String starttime,String endtime){
		
		List	<OrderForm> list =orderFormMapper.cancelOrder(eename, name, id, btu, starttime,endtime);
		
		return list;
	}
	//订单取消分
	public List<OrderForm> cancelOrderPage(int page,int pageSize,String id,String eename,String name,String btu,String starttime,String endtime){
		
		List<OrderForm> list = orderFormMapper.cancelOrderPage(page,pageSize, id,eename, name, btu, starttime,endtime);
		
		return list;
	}
	//订单取消数
	public OrderForm cancelOrderCount(String id,String eename,String name,String btu,String starttime,String endtime){
		
		OrderForm list = orderFormMapper.cancelOrderCount(id, eename, name, btu, starttime, endtime);
		
		return list;
	}
	//取消订单的订单数
	public List<OrderForm> cancelCount(){
		
		List<OrderForm> list = orderFormMapper.cancelCount();
		
		return list;
	}
	
}