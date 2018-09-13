package com.bangshuo.kuaigong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bangshuo.kuaigong.po.CancelOrder;
import com.bangshuo.kuaigong.po.OrderForm;
import com.bangshuo.kuaigong.service.CancelOrderService;
import com.bangshuo.kuaigong.service.OnlineInformationService;
import com.bangshuo.kuaigong.service.OrderFormService;
import com.bangshuo.kuaigong.service.WaitTimeService;
import com.bangshuo.kuaigong.utils.DateCommonUtils;
import com.google.gson.Gson;

@Controller
@RequestMapping("OrderForm")
public class OrderFormController {
	
	@Autowired
	OrderFormService orderFormService;
	@Autowired
	WaitTimeService waitTimeService;
	@Autowired
	OnlineInformationService onlineInformationService;
	@Autowired
	CancelOrderService cencelOrderService;


	//查询工人工作记录
			@RequestMapping("selectWorkAll")
			public void selectWorkAll(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				response.setContentType("text/html");
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out=response.getWriter();
				String id =request.getParameter("id");
				String name = request.getParameter("name");
				String OrderID = request.getParameter("OrderID");
				String starttime = request.getParameter("starttime");
				String endtime = request.getParameter("endtime");
				SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
				SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
				try {
					starttime=simpleStarttime.format(simple.parse(starttime));
					endtime=simpleEndtime.format(simple.parse(endtime));
				} catch (ParseException e) {
				
					e.printStackTrace();
				}
				if(starttime==null || starttime==""){
					starttime=null;
				}
				if(endtime==null || endtime==""){
					endtime=null;
				}
				if(OrderID== null || OrderID.equals("")){
					OrderID =null;
				}
				if(name== null || name.equals("")){
					name =null;
				}
				if(starttime== null || starttime.equals("")){
					starttime =null;
				}
				if(endtime== null || endtime.equals("")){
					endtime =null;
				}
			OrderForm list=orderFormService.selectWorkAll(id, name, OrderID, starttime, endtime);
			if(list!=null){
				String json = list.getOrderAll();
				out.print(json);
			}
			else{
				String json=null;
				out.print(json);
			}
		}
			//查每个信息中点单
			@RequestMapping("selectSingle")
			public void selectSingle(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				response.setContentType("text/html");
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out=response.getWriter();
				int id = Integer.parseInt(request.getParameter("id"));
				OrderForm list=orderFormService.selectSingle(id);
				if(list!=null){
					String json = list.getSingle();
					out.print(json);
				}
				else{
					String json=null;
					out.print(json);
				}
			}
			//查每个信息中点单
			@RequestMapping("salesorder")
			public void salesorder(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				response.setContentType("text/html");
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out=response.getWriter();
				int id = Integer.parseInt(request.getParameter("id"));
				String name=request.getParameter("name");
				String username=request.getParameter("username");
				String status=request.getParameter("status");
				if(name==null || name.equals("")){
					name=null;
				}
				if(username==null || username==""){
					username=null;
				}
				if(status==null || status.equals("") || status.equals("状态查询")){
					status=null;
				}
				OrderForm list=orderFormService.salesorder(id, name, username, status);
				if(list!=null){
					String json = list.getSalesorder();
					out.print(json);
				}
				else{
					String json=null;
					out.print(json);
				}
			}
			//查看招工次数
			@RequestMapping("selectWorks")
			public void selectWorks(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				response.setContentType("text/html");
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out=response.getWriter();
				String id = request.getParameter("id");
				String eeid=request.getParameter("ee");
				String eename = request.getParameter("ern");
				String GRusername=request.getParameter("erun");
				String status = request.getParameter("status");
				String starttime = request.getParameter("starttime");
				String endtime=request.getParameter("endtime");
				SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		        SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		        
		        try {
					starttime=simpleStarttime.format(simple.parse(starttime));
					endtime=simpleEndtime.format(simple.parse(endtime));
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
		        
				if(eeid == null || eeid.equals("")){
					eeid =null;
				}
				if(eename == null || eename.equals("")){
					eename =null;
				}
				if(GRusername == null || GRusername.equals("")){
					GRusername =null;
				}
				if(status == null || status.equals("") || status.equals("请选择")) {
					status =null;
				}
				if(starttime == null || starttime.equals("")){
					starttime =null;
				}
				if(endtime == null || endtime.equals("")){
					endtime =null;
				}
				OrderForm list=orderFormService.selectWorks(id, eename, GRusername, status, starttime, endtime);
				if(list!=null){
					String json = list.getWorks();
					out.print(json);
				}
				else{
					String json=null;
					out.print(json);
				}
			}
			
	//查询订单个数
		@RequestMapping("count")
		public void count(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String id =request.getParameter("id");
			String eename = request.getParameter("eename");
			String name = request.getParameter("name");
			String btu = request.getParameter("btu");
			String starttime = request.getParameter("starttime");
			String endtime = request.getParameter("endtime");
			String payment = request.getParameter("payment");
			SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	        SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	        
	        try {
				starttime=simpleStarttime.format(simple.parse(starttime));
				endtime=simpleEndtime.format(simple.parse(endtime));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
			if(id == null || id.equals("")){
				id =null;
			}
			if(name == null || name.equals("")){
				name =null;
			}
			if(eename == null || eename.equals("")){
				eename =null;
			}
			if(btu == null || btu.equals("") || btu.equals("状态查询")){
				btu =null;
			}
			if(payment == null || payment.equals("") || payment.equals("支付方式")){
				payment =null;
			}
			if(starttime == null || starttime.equals("")){
				starttime =null;
			}
			if(endtime == null || endtime.equals("")){
				endtime =null;
			}
			 OrderForm list=orderFormService.selectNum(id, eename, name, btu, starttime, endtime,payment);
			 PrintWriter out=response.getWriter();
			 if(list!=null){
				 String json=list.getCount();
				 out.print(json);
			 }
			 else{
				 String json=null;
				 out.print(json);
			 }
		}
	
	//查询所有订单总数!------------------全部查询总数
		@RequestMapping("selectSalesmanOrder")
		public void selectSalesmanOrder(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String username=request.getParameter("username");
			String status=request.getParameter("status");
			if(name==null || name.equals("")){
				name=null;
			}
			if(username==null || username==""){
				username=null;
			}
			if(status==null || status.equals("") || status.equals("状态查询")){
				status=null;
			}
			List<OrderForm> list=orderFormService.selectSalesmanOrder(id,name,username,status);
			int pageNum=list.size();
			PrintWriter out=response.getWriter();
			if(pageNum>0){
				Gson gson=new Gson();
				String json=gson.toJson(pageNum);
				out.print(json);
			}
			else{
				String json=null;
			  out.print(json);	
			}
		}

		//查询所有订单总数!------------------全部查询分页
		@RequestMapping("selectSalesmanOrderPage")
		public void selectSalesmanOrderPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int id =Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String username=request.getParameter("username");
			String status=request.getParameter("status");
			int page=Integer.parseInt(request.getParameter("page"));
			int pageSize=Integer.parseInt(request.getParameter("pageSize"));
			page=(page-1)*pageSize;
			if(name==null || name.equals("")){
				name=null;
			}
			if(username==null || username==""){
				username=null;
			}
			if(status==null || status.equals("") || status.equals("状态查询")){
				status=null;
			}

			List<OrderForm> list=orderFormService.selectSalesmanOrderPage(page,pageSize,id,name,username,status);
			PrintWriter out=response.getWriter();
			if(list!=null){
				Gson gson=new Gson();
				String json=gson.toJson(list);
				out.print(json);
			}
			else{
				String json=null;
				out.print(json);
			}
		}
	
	//查询招工
		@RequestMapping("selectOrderForm")
		public void selectOrderForm(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String id = request.getParameter("id");
			String eeid=request.getParameter("ee");
			String eename = request.getParameter("ern");
			String GRusername=request.getParameter("erun");
			String status = request.getParameter("status");
			String starttime = request.getParameter("starttime");
			String endtime=request.getParameter("endtime");
			SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	        SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	        
	        try {
				starttime=simpleStarttime.format(simple.parse(starttime));
				endtime=simpleEndtime.format(simple.parse(endtime));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			if(eeid == null || eeid.equals("")){
				eeid =null;
			}
			if(eename == null || eename.equals("")){
				eename =null;
			}
			if(GRusername == null || GRusername.equals("")){
				GRusername =null;
			}
			if(status == null || status.equals("") || status.equals("请选择")) {
				status =null;
			}
			if(starttime == null || starttime.equals("")){
				starttime =null;
			}
			if(endtime == null || endtime.equals("")){
				endtime =null;
			}
			   List<OrderForm> list= orderFormService.selectOrderForm(eeid, eename,GRusername,status,starttime, endtime,id);
			   int pageNum=list.size();
			PrintWriter out = response.getWriter();
			if (pageNum > 0){
				Gson gson = new Gson();
				String json = gson.toJson(pageNum);
				out.print(json);
			} else {
				String json = null;
				out.print(json);
			}
		}
		//查询招工分页
		@RequestMapping("selectOrderFormPage")
		public void selectOrderFormPage(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out = response.getWriter();
			String id = request.getParameter("id");
			String eeid=request.getParameter("ee");
			String eename = request.getParameter("ern");
			String GRusername=request.getParameter("erun");
			String status = request.getParameter("status");
			String starttime = request.getParameter("starttime");
			String endtime=request.getParameter("endtime");
			
			SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfStart  = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
			SimpleDateFormat sdfEnd  = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
			
			try {
				starttime = sdfStart.format(sdf.parse(starttime));
				endtime = sdfEnd.format(sdf.parse(endtime));
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int page=Integer.parseInt(request.getParameter("page"));
			int pageSize=Integer.parseInt(request.getParameter("pageSize"));
			page = (page - 1) * pageSize;
			if(eeid == null || eeid.equals("")){
				eeid =null;
			}
			if(eename == null || eename.equals("")){
				eename =null;
			}
			if(GRusername == null || GRusername.equals("")){
				GRusername =null;
			}
			if(status == null || status.equals("") || status.equals("请选择")){
				status =null;
			}
			if(starttime == null || starttime.equals("")){
				starttime =null;
			}
			if(endtime == null || endtime.equals("")){
				endtime =null;
			}
			 List<OrderForm> list= orderFormService.selectOrderFormPage(page, pageSize,eeid,eename,GRusername,status,starttime,endtime,id);
			 if (list!=null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	
	//全部查询工人的工作记录 总数
	@RequestMapping("GROrderFormPage")
	public void GROrderFormPage(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String OrderID=request.getParameter("OrderID");
		String name=request.getParameter("name");
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(OrderID== null || OrderID.equals("")){
			OrderID =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
		if(starttime== null || starttime.equals("")){
			starttime =null;
		}
		if(endtime== null || endtime.equals("")){
			endtime =null;
		}
		List<OrderForm> list= orderFormService.GROrderFormPage(id, OrderID, name,starttime,endtime);
		PrintWriter out=response.getWriter();
		int pageNum=list.size();
		if(pageNum>0){
			Gson gson=new Gson();
			String json=gson.toJson(pageNum);
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
				
	}
	//全部查询工人的工作记录 总数 分页
	@RequestMapping("GROrderFormInfo")
	public void GROrderFormInfo(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		
		int id=Integer.parseInt(request.getParameter("id"));
		String OrderID=request.getParameter("OrderID");
		String name=request.getParameter("name");
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(OrderID== null || OrderID.equals("")){
			OrderID =null;
		}
	
		if(name== null || name.equals("")){
			name =null;
		}
		if(starttime== null || starttime.equals("")){
			starttime =null;
		}
		if(endtime== null || endtime.equals("")){
			endtime =null;
		}
		PrintWriter out=response.getWriter();
		page=(page-1)*pageSize;
		List<OrderForm> list= orderFormService.GROrderFormPageInfo(id, OrderID, name,starttime,endtime,page,pageSize);
	if(list!=null){
		Gson gson=new Gson();
		String json=gson.toJson(list);
		out.print(json);
	}else{
		String json=null;
		out.print(json);
	}
	
	}

	//更新表单
	@RequestMapping("updateByPrimaryKey1")
	public void updateByPrimaryKey1(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		String payment=request.getParameter("payment");
		String allcost=request.getParameter("allcost");
		String actualcost=request.getParameter("actualcost");
		String latitude=request.getParameter("latitude");
		String longitude=request.getParameter("longitude");
		String status=request.getParameter("status");
		String order_start_time=request.getParameter("order_start_time");
		OrderForm orderForm=new OrderForm();
		orderForm.setId(id);
	
		orderForm.setStarttime(starttime);
		orderForm.setEndtime(endtime);
		orderForm.setPayment(payment);
		orderForm.setAllcost(allcost);
		orderForm.setActualcost(actualcost);
		orderForm.setLatitude(latitude);
		orderForm.setLongitude(longitude);
		orderForm.setStatus(status);
		orderForm.setOrder_start_time(order_start_time);
		int list=orderFormService.updateByPrimaryKey1(orderForm);
		PrintWriter out=response.getWriter();
		if(list>0){
			Gson gson=new Gson();
			String json=gson.toJson(1);
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
				
		
	}
	

	//查询所有订单总数!------------------全部查询总数
	@RequestMapping("selectAll")
	public void selectAll(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int pageNum;
		String radio=request.getParameter("radio");
		String btu=request.getParameter("btu");
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String eename=request.getParameter("eename");
		String payment = request.getParameter("payment");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        
        try {
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id==null || id.equals("")){
			id=null;
		}
		if(name==null || name.equals("")){
			name=null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(payment==null || payment.equals("") || payment.equals("支付方式")){
			payment=null;
		}
		if(eename==null || eename==""){
			eename=null;
		}
		if(radio==null || radio==""){
			radio=null;
		}
		if(radio!=null){
			List<OrderForm> list=orderFormService.sortTime(id, name, starttime, endtime, btu, eename,payment);
			pageNum=list.size();
			PrintWriter out=response.getWriter();
			if(pageNum>0){
				Gson gson=new Gson();
				String json=gson.toJson(pageNum);
				out.print(json);
			}
			else{
				String json=null;
			  out.print(json);	
			
			}
		}else{
			
		
		List<OrderForm> list=orderFormService.selectAlll6(id, name, starttime, endtime, btu, eename,payment);
		pageNum=list.size();
		System.out.println("================================"+pageNum);
		System.out.println("================================"+pageNum);
		System.out.println("================================"+pageNum);
		System.out.println("================================"+pageNum);
		System.out.println("================================"+pageNum);
		PrintWriter out=response.getWriter();
		if(pageNum>0){
			Gson gson=new Gson();
			String json=gson.toJson(pageNum);
			out.print(json);
		}
		else{
			String json=null;
		  out.print(json);	
		
		}
		}
	}




	//查询所有订单总数!------------------全部查询分页
	@RequestMapping("selectByPage1")
	public void selectByPage1(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String radio=request.getParameter("radio");
		String eename=request.getParameter("eename");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String btu=request.getParameter("btu");
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		String payment = request.getParameter("payment");
				SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        try {
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
       
			if(eename==null || eename==""){
				eename=null;
			}
		
        if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		if(id==null || id.equals("")){
			id=null;
		}
		if(name==null || name.equals("")){
			name=null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(payment==null || payment.equals("") || payment.equals("支付方式")){
			payment=null;
		}
		if(radio==null || radio==""){
			radio=null;
		}
		if(radio!=null){
			page=(page-1)*pageSize;
			List<OrderForm> list=orderFormService.sortTimeInfo(page,pageSize,id,name,starttime,endtime,btu,eename,payment);
			PrintWriter out=response.getWriter();
			
			if(list!=null){
				Gson gson=new Gson();
				String json=gson.toJson(list);
				out.print(json);
			}
			else{
				String json=null;
				out.print(json);
			}
		}else{
		page=(page-1)*pageSize;
		List<OrderForm> list=orderFormService.selectByPagee6(page,pageSize,id,name,starttime,endtime,btu,eename,payment);
		PrintWriter out=response.getWriter();
		
		if(list!=null){
			Gson gson=new Gson();
			String json=gson.toJson(list);
			out.print(json);
		}
		else{
			String json=null;
			out.print(json);
		}
		}
	}
		
	//跳根据时间段查询数据
	@RequestMapping("queryByTime")
	public void queryByTime(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		request.getSession().setAttribute("id", id);
		request.getSession().setAttribute("starttime", starttime);
		request.getSession().setAttribute("endtime", endtime);
		List<OrderForm> list=orderFormService.selectByTime(starttime, endtime,id);
		PrintWriter out=response.getWriter();
		if(list.size()>0){
			Gson gson=new Gson();
			String json=gson.toJson(list);
			out.print(json);
		}
		else{
			String json=null;
			out.print(json);
		}
	}
	
	
	@RequestMapping("queryCount")
	public void queryCount(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out=response.getWriter();
	List<OrderForm> list=orderFormService.selectCountOrderForm(id);
	int pageNum=list.size();

	if(pageNum>0){
		Gson gson=new Gson();
		String json=gson.toJson(pageNum);
		out.print(json);
	}
	else{
		String json=null;
		out.print(json);
	}
	}
	
	@RequestMapping("add")
	public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{	
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		int eeid = Integer.parseInt(request.getParameter("eeid"));
		int erid = Integer.parseInt(request.getParameter("erid"));
		String starttime = request.getParameter("startime");
		String endtime = request.getParameter("endtime");
		String payment = request.getParameter("payment");
		String allcost = request.getParameter("allcost");
		String actualcost = request.getParameter("actualcost");
		
		OrderForm orderForm = new OrderForm();
		orderForm.setId(id);
		orderForm.setEeid(eeid);
		orderForm.setErid(erid);
		orderForm.setStarttime(starttime);
		orderForm.setEndtime(endtime);
		orderForm.setPayment(payment);
		orderForm.setAllcost(allcost);
		orderForm.setActualcost(actualcost);
		
		
		PrintWriter out = response.getWriter();
		int ss = orderFormService.insert(orderForm);
		if(ss>0){
		Gson gson  = new Gson();		
		String json=gson.toJson(1);
		out.print(json);
		}else{
			String json = null;
			out.print(json);
			
		}
	}
	    @RequestMapping("update")
	    public void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{	
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
	    
			int id = Integer.parseInt(request.getParameter("id"));
			int eeid = Integer.parseInt(request.getParameter("eeid"));
			int erid = Integer.parseInt(request.getParameter("erid"));
			String starttime = request.getParameter("startime");
			String endtime = request.getParameter("endtime");
			String payment = request.getParameter("payment");
			String allcost = request.getParameter("allcost");
			String actualcost = request.getParameter("actualcost");
			
			OrderForm orderForm = new OrderForm();
			orderForm.setId(id);
			orderForm.setEeid(eeid);
			orderForm.setErid(erid);
			orderForm.setStarttime(starttime);
			orderForm.setEndtime(endtime);
			orderForm.setPayment(payment);
			orderForm.setAllcost(allcost);
			orderForm.setActualcost(actualcost);
			
			int num = orderFormService.updateByPrimaryKeySelective(orderForm);
	        PrintWriter out = response.getWriter();
			if(num>0){
				Gson gson  = new Gson();		
				String json=gson.toJson("1");
				out.print(json);
			}else{
				String json=null;
				out.print(json);
			}
		}    
	    @RequestMapping("delete")
		public void delete(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			int id = Integer.parseInt(request.getParameter("id"));
			int num = orderFormService.deleteByPrimaryKey(id);
			
			orderFormService.deleteByPrimaryKey(id);
			PrintWriter out = response.getWriter();
			if(num>0){
				Gson gson  = new Gson();		
				String json=gson.toJson("1");
				out.print(json);
			}else{
				String json=null;
				out.print(json);
			}
		}
		
	    /*	添加代码*/
	    	
	    	/**
	    	 * 查询昨天的订单总数
	    	 * @param request
	    	 * @param response
	    	 * @throws ServletException
	    	 * @throws IOException
	    	 */
	    	@RequestMapping("selectOrderByYesterday")
	    	public void selectOrderByYesterday(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
              
	    		String eename=request.getParameter("workerName");
	    		String id=request.getParameter("id");
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
	    	
	    		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
	    		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	            SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	            
	    			if(eename==null || eename==""){
	    				eename=null;
	    			}
	    		
	           
//	    		int page=Integer.parseInt(request.getParameter("page"));
//	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		if(id==null || id.equals("")){
	    			id=null;
	    		}
	    		if(name==null || name.equals("")){
	    			name=null;
	    		}
	    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
	    			btu=null;
	    		}
	    		
	    		Date nowDate = new Date();
	    		nowDate.setHours(0);
	    		nowDate.setMinutes(0);
	    		nowDate.setSeconds(0);
	    		Date yesterdayDate = new Date(nowDate.getTime() - 86400000L);
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    		String now = sdf.format(nowDate);
	    		String yesterday = sdf.format(yesterdayDate);
	  
	    		List<OrderForm> list = orderFormService.selectOrderByTime(yesterday,now,id,eename,name,btu);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	
	    	
	    	
	    	
	    	/**
	    	 *  查询昨天的订单分页
	    	 * 
	    	 * 
	    	 */
	    	
	    	@RequestMapping("selectOrderByYesterdayInfo")
	    	public void selectOrderByYesterdayInfo(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
                int page=Integer.parseInt(request.getParameter("page"));
                int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		String eename=request.getParameter("workerName");
	    		String id=request.getParameter("id");
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
	    	
	    		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
	    		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	            SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	            
	    			if(eename==null || eename==""){
	    				eename=null;
	    			}
	    		
	           
//	    		int page=Integer.parseInt(request.getParameter("page"));
//	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		if(id==null || id.equals("")){
	    			id=null;
	    		}
	    		if(name==null || name.equals("")){
	    			name=null;
	    		}
	    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
	    			btu=null;
	    		}
	    		
	    		Date nowDate = new Date();
	    		nowDate.setHours(0);
	    		nowDate.setMinutes(0);
	    		nowDate.setSeconds(0);
	    		Date yesterdayDate = new Date(nowDate.getTime() - 86400000L);
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    		String now = sdf.format(nowDate);
	    		String yesterday = sdf.format(yesterdayDate);
	            page=(page-1)*pageSize;
	    		List<OrderForm> list = orderFormService.selectOrderByTimeInfo(yesterday,now,id,eename,name,btu,page,pageSize);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	
	    	
	    	
	    	
	    	/**
	    	 * 查询本周的订单
	    	 * @param request
	    	 * @param response
	    	 * @throws ServletException
	    	 * @throws IOException
	    	 */
	    	@RequestMapping("selectOrderByWeek")
	    	public void selectOrderByWeek(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		String eename=request.getParameter("eename");
	    		String id=request.getParameter("id");
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
//	    		String starttime=request.getParameter("starttime");
//	    		String endtime=request.getParameter("endtime");
//	    				SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
//	    		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
//	            SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
//	            try {
//	    			starttime=simpleStarttime.format(simple.parse(starttime));
//	    			endtime=simpleEndtime.format(simple.parse(endtime));
//	    		} catch (ParseException e) {
//	    			
//	    			e.printStackTrace();
//	    		}
	           
	    			if(eename==null || eename==""){
	    				eename=null;
	    			}
//	    		
//	            if(starttime==null || starttime==""){
//	    			starttime=null;
//	    		}
//	    		if(endtime==null || endtime==""){
//	    			endtime=null;
//	    		}
	    		
//	    		int page=Integer.parseInt(request.getParameter("page"));
//	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		if(id==null || id.equals("")){
	    			id=null;
	    		}
	    		if(name==null || name.equals("")){
	    			name=null;
	    		}
	    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
	    			btu=null;
	    		}
	    		
	    		Map<String, String> map = DateCommonUtils.getWeekDay();
	    		String now = map.get("sun");
	    		String oldDate = map.get("mon");
	    		List<OrderForm> list = orderFormService.selectOrderByTime(oldDate,now,id,eename,name,btu);
	    	
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	
	    	/**
	    	 * 
	    	 * 查看本周订单分页
	    	 */
	    	
	    	@RequestMapping("selectOrderByWeekInfo")
	    	public void selectOrderByWeekInfo(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		String eename=request.getParameter("eename");
	    		String id=request.getParameter("id");
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
//	    		String starttime=request.getParameter("starttime");
//	    		String endtime=request.getParameter("endtime");
//	    				SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
//	    		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
//	            SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
//	            try {
//	    			starttime=simpleStarttime.format(simple.parse(starttime));
//	    			endtime=simpleEndtime.format(simple.parse(endtime));
//	    		} catch (ParseException e) {
//	    			
//	    			e.printStackTrace();
//	    		}
//	           
//	    			if(eename==null || eename==""){
//	    				eename=null;
//	    			}
//	    		
//	            if(starttime==null || starttime==""){
//	    			starttime=null;
//	    		}
//	    		if(endtime==null || endtime==""){
//	    			endtime=null;
//	    		}
//	    		
//	    		int page=Integer.parseInt(request.getParameter("page"));
//	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		if(id==null || id.equals("")){
	    			id=null;
	    		}
	    		if(name==null || name.equals("")){
	    			name=null;
	    		}
	    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
	    			btu=null;
	    		}
	    		
	    		Map<String, String> map = DateCommonUtils.getWeekDay();
	    		int page=Integer.parseInt(request.getParameter("page"));
	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		String now = map.get("sun");
	    		String yesterday = map.get("mon");
	    		page=(page-1)*pageSize;
	    		List<OrderForm> list = orderFormService.selectOrderByTimeInfo(yesterday,now,id,eename,name,btu,page,pageSize);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	
	    	
	    	
	    	/**
	    	 * 查询本月的订单
	    	 * @param request
	    	 * @param response
	    	 * @throws ServletException
	    	 * @throws IOException
	    	 */
	    	@RequestMapping("selectOrderByMonth")
	    	public void selectOrderByMonth(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		String eename=request.getParameter("eename");
	    		String id=request.getParameter("id");
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
//	    		String starttime=request.getParameter("starttime");
//	    		String endtime=request.getParameter("endtime");
//	    				SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
//	    		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
//	            SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
//	            try {
//	    			starttime=simpleStarttime.format(simple.parse(starttime));
//	    			endtime=simpleEndtime.format(simple.parse(endtime));
//	    		} catch (ParseException e) {
//	    			
//	    			e.printStackTrace();
//	    		}
//	           
//	    			if(eename==null || eename==""){
//	    				eename=null;
//	    			}
//	    		
//	            if(starttime==null || starttime==""){
//	    			starttime=null;
//	    		}
//	    		if(endtime==null || endtime==""){
//	    			endtime=null;
//	    		}
//	    		
//	    		int page=Integer.parseInt(request.getParameter("page"));
//	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		if(id==null || id.equals("")){
	    			id=null;
	    		}
	    		if(name==null || name.equals("")){
	    			name=null;
	    		}
	    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
	    			btu=null;
	    		}
	    		
	    		Map<String, String> map = DateCommonUtils.getMonthDate();
	    		String now = map.get("monthL");
	    		String oldDate = map.get("monthF");
	    		List<OrderForm> list = orderFormService.selectOrderByTime(oldDate,now,id,eename,name,btu);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	
	    	/**
	    	 * 
	    	 * 查询本月的订单的分页  	 * 
	    	 */
	    	@RequestMapping("selectOrderByMonthInfo")
	    	public void selectOrderByMonthInfo(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		String eename=request.getParameter("eename");
	    		String id=request.getParameter("id");
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
//	    		String starttime=request.getParameter("starttime");
//	    		String endtime=request.getParameter("endtime");
//	    				SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
//	    		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
//	            SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
//	            try {
//	    			starttime=simpleStarttime.format(simple.parse(starttime));
//	    			endtime=simpleEndtime.format(simple.parse(endtime));
//	    		} catch (ParseException e) {
//	    			
//	    			e.printStackTrace();
//	    		}
//	           
	    			if(eename==null || eename==""){
	    				eename=null;
	    			}
//	    		
//	            if(starttime==null || starttime==""){
//	    			starttime=null;
//	    		}
//	    		if(endtime==null || endtime==""){
//	    			endtime=null;
//	    		}
	    		
//	    		int page=Integer.parseInt(request.getParameter("page"));
//	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		if(id==null || id.equals("")){
	    			id=null;
	    		}
	    		if(name==null || name.equals("")){
	    			name=null;
	    		}
	    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
	    			btu=null;
	    		}
	    		int page=Integer.parseInt(request.getParameter("page"));
	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		page=(page-1)*pageSize;
	    		Map<String, String> map = DateCommonUtils.getMonthDate();
	    		String now = map.get("monthL");
	    		String oldDate = map.get("monthF");
	    		List<OrderForm> list = orderFormService.selectOrderByTimeInfo(oldDate,now,id,eename,name,btu,page,pageSize);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	/**
	    	 * 
	    	 * 查询本年的订单分页
	    	 */
	    	@RequestMapping("selectOrderByYearInfo")
	    	public void selectOrderByYearInfo(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		Map<String, String> map = DateCommonUtils.getYearDate();
	    		String eename=request.getParameter("eename");
	    		String id=request.getParameter("id");
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
//	    		String starttime=request.getParameter("starttime");
//	    		String endtime=request.getParameter("endtime");
//	    				SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
//	    		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
//	            SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
//	            try {
//	    			starttime=simpleStarttime.format(simple.parse(starttime));
//	    			endtime=simpleEndtime.format(simple.parse(endtime));
//	    		} catch (ParseException e) {
//	    			
//	    			e.printStackTrace();
//	    		}
//	           
	    			if(eename==null || eename==""){
	    				eename=null;
	    			}
	    		
//	            if(starttime==null || starttime==""){
//	    			starttime=null;
//	    		}
//	    		if(endtime==null || endtime==""){
//	    			endtime=null;
//	    		}
	    		
//	    		int page=Integer.parseInt(request.getParameter("page"));
//	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		if(id==null || id.equals("")){
	    			id=null;
	    		}
	    		if(name==null || name.equals("")){
	    			name=null;
	    		}
	    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
	    			btu=null;
	    		}
	    		int page=Integer.parseInt(request.getParameter("page"));
	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		String now = map.get("yearL");
	    		String oldDate = map.get("yearF");
	    		page=(page-1)*pageSize;
	    		List<OrderForm> list = orderFormService.selectOrderByTimeInfo(oldDate,now,id,eename,name,btu,page,pageSize);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	/**
	    	 * 查询本年的订单
	    	 * @param request
	    	 * @param response
	    	 * @throws ServletException
	    	 * @throws IOException
	    	 */
	    	@RequestMapping("selectOrderByYear")
	    	public void selectOrderByYear(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		Map<String, String> map = DateCommonUtils.getYearDate();
	    		String eename=request.getParameter("eename");
	    		String id=request.getParameter("id");
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
//	    		String starttime=request.getParameter("starttime");
//	    		String endtime=request.getParameter("endtime");
//	    				SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
//	    		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
//	            SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
//	            try {
//	    			starttime=simpleStarttime.format(simple.parse(starttime));
//	    			endtime=simpleEndtime.format(simple.parse(endtime));
//	    		} catch (ParseException e) {
//	    			
//	    			e.printStackTrace();
//	    		}
	           
	    			if(eename==null || eename==""){
	    				eename=null;
	    			}
	    		
//	            if(starttime==null || starttime==""){
//	    			starttime=null;
//	    		}
//	    		if(endtime==null || endtime==""){
//	    			endtime=null;
//	    		}
	    		
//	    		int page=Integer.parseInt(request.getParameter("page"));
//	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		if(id==null || id.equals("")){
	    			id=null;
	    		}
	    		if(name==null || name.equals("")){
	    			name=null;
	    		}
	    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
	    			btu=null;
	    		}
	    		
	    		String now = map.get("yearL");
	    		String oldDate = map.get("yearF");
	    		List<OrderForm> list = orderFormService.selectOrderByTime(oldDate,now,id,eename,name,btu);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	/**
	    	 * 查询昨天的完成订单分页
	    	 * selectOrderFinishByYesterdayInfo
	    	 * 
	    	 */
	    	@RequestMapping("selectOrderFinishByYesterdayInfo")
	    	public void selectOrderFinishByYesterdayInfo(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		  int page=Integer.parseInt(request.getParameter("page"));
	                int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		    		String eename=request.getParameter("workerName");
		    		String orderid=request.getParameter("orderid");
		    		if(orderid==null || orderid.equals("")){
		    			orderid=null;
		    		}
		    		String name=request.getParameter("name");
		    		String btu=request.getParameter("btu");
		    	
		    		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		    		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		            SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		            
		    			if(eename==null || eename==""){
		    				eename=null;
		    			}
		    	
		    		if(name==null || name.equals("")){
		    			name=null;
		    		}
		    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
		    			btu=null;
		    		}
		    		
	    		Date nowDate = new Date();
	    		nowDate.setHours(0);
	    		nowDate.setMinutes(0);
	    		nowDate.setSeconds(0);
	    		Date yesterdayDate = new Date(nowDate.getTime() - 86400000L);
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    		String now = sdf.format(nowDate);
	    		String yesterday = sdf.format(yesterdayDate);
	    		page=(page-1)*pageSize;
	    		List<OrderForm> list = orderFormService.selectOrderFinishByYesterdayInfo(yesterday,now,orderid,eename,name,btu,page,pageSize);
	    
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	/**
	    	 * 查询昨天的完成订单
	    	 * @param request
	    	 * @param response
	    	 * @throws ServletException
	    	 * @throws IOException
	    	 */
	    	@RequestMapping("selectOrderFinishByYesterday")
	    	public void selectOrderFinishByYesterday(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    	        String eename=request.getParameter("workerName");
		    		String orderid=request.getParameter("orderid");
		    		if(orderid==null || orderid.equals("")){
                		orderid=null;
		    		}
		    		String name=request.getParameter("name");
		    		String btu=request.getParameter("btu");
		    	    if(eename==null || eename==""){
		    				eename=null;
		    			}
                	
		    		if(name==null || name.equals("")){
		    			name=null;
		    		}
		    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
		    			btu=null;
		    		}
		    		
	    		Date nowDate = new Date();
	    		nowDate.setHours(0);
	    		nowDate.setMinutes(0);
	    		nowDate.setSeconds(0);
	    		Date yesterdayDate = new Date(nowDate.getTime() - 86400000L);
	    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    		String now = sdf.format(nowDate);
	    		String yesterday = sdf.format(yesterdayDate);
	    		List<OrderForm> list = orderFormService.selectOrderFinishByTime(yesterday,now,orderid,eename,name,btu);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	/**
	    	 * 查看本周的完成订单分页
	    	 * 
	    	 * 
	    	 */
	    	@RequestMapping("selectOrderFinishByWeekInfo")
	    	public void selectOrderFinishByWeekInfo(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
// String orderid, String eename, String name, String btu
	    		String eename=request.getParameter("workerName");
	    		String orderid=request.getParameter("orderid");
	    		if(orderid==null || orderid.equals("")){
	    			orderid=null;
	    		}
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
	    		if(eename==null || eename==""){
    				eename=null;
    			}
    	
    		if(name==null || name.equals("")){
    			name=null;
    		}
    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
    			btu=null;
    		}
	    		Map<String, String> map = DateCommonUtils.getWeekDay();
	    		String now = map.get("sun");
	    		String oldDate = map.get("mon");
	    		int page=Integer.parseInt(request.getParameter("page"));
	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		page=(page-1)*pageSize;
	    		List<OrderForm> list = orderFormService.selectOrderFinishByYesterdayInfo(oldDate,now,orderid,eename,name,btu,page,pageSize);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	
	    	
	    	
	    	/**
	    	 * 查询本周的完成订单
	    	 * @param request
	    	 * @param response
	    	 * @throws ServletException
	    	 * @throws IOException
	    	 */
	    	@RequestMapping("selectOrderFinishByWeek")
	    	public void selectOrderFinishByWeek(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
// String orderid, String eename, String name, String btu
	    		String eename=request.getParameter("workerName");
	    		String orderid=request.getParameter("orderid");
	    		if(orderid==null || orderid.equals("")){
	    			orderid=null;
	    		}
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
	    		if(eename==null || eename==""){
    				eename=null;
    			}
    	
    		if(name==null || name.equals("")){
    			name=null;
    		}
    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
    			btu=null;
    		}
	    		Map<String, String> map = DateCommonUtils.getWeekDay();
	    		String now = map.get("sun");
	    		String oldDate = map.get("mon");
	    		List<OrderForm> list = orderFormService.selectOrderFinishByTime(oldDate,now,orderid,eename,name,btu);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	
	    	/**
	    	 * 
	    	 * 
	    	 * 查询本月完成订单分页
	    	 */
	    	@RequestMapping("selectOrderFinishByMonthInfo")
	    	public void selectOrderByFinishMonthInfo(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		Map<String, String> map = DateCommonUtils.getMonthDate();
	    		String eename=request.getParameter("workerName");
	    		String orderid=request.getParameter("orderid");
	    		if(orderid==null || orderid.equals("")){
	    			orderid=null;
	    		}
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
	    		if(eename==null || eename==""){
    				eename=null;
    			}
    	
    		if(name==null || name.equals("")){
    			name=null;
    		}
    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
    			btu=null;
    		}
	    		String now = map.get("monthL");
	    		String oldDate = map.get("monthF");
	    		int page=Integer.parseInt(request.getParameter("page"));
	    		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	    		page=(page-1)*pageSize;
	    		List<OrderForm> list = orderFormService.selectOrderFinishByYesterdayInfo(oldDate,now,orderid,eename,name,btu,page,pageSize);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	
	    	
	    	
	    	
	    	/**
	    	 * 查询本月的完成订单
	    	 * @param request
	    	 * @param response
	    	 * @throws ServletException
	    	 * @throws IOException
	    	 */
	    	@RequestMapping("selectOrderFinishByMonth")
	    	public void selectOrderByFinishMonth(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		Map<String, String> map = DateCommonUtils.getMonthDate();
	    		String eename=request.getParameter("workerName");
	    		String orderid=request.getParameter("orderid");
	    		if(orderid==null || orderid.equals("")){
	    			orderid=null;
	    		}
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
	    		if(eename==null || eename==""){
    				eename=null;
    			}
    	
    		if(name==null || name.equals("")){
    			name=null;
    		}
    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
    			btu=null;
    		}
	    		String now = map.get("monthL");
	    		String oldDate = map.get("monthF");
	    		List<OrderForm> list = orderFormService.selectOrderFinishByTime(oldDate,now,orderid,eename,name,btu);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	/**
	    	 * 
	    	 * 
	    	 * 查询本年的完成订单分页
	    	 */
	    	@RequestMapping("selectOrderFinishByYearInfo")
	    	public void selectOrderFinishByYearInfo(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		Map<String, String> map = DateCommonUtils.getYearDate();
	    		String now = map.get("yearL");
	    		String oldDate = map.get("yearF");
	    		String eename=request.getParameter("workerName");
	    		String orderid=request.getParameter("orderid");
	    		if(orderid==null || orderid.equals("")){
	    			orderid=null;
	    		}
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
	    		if(eename==null || eename==""){
    				eename=null;
    			}
    	
    		if(name==null || name.equals("")){
    			name=null;
    		}
    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
    			btu=null;
    		}
    		 int page=Integer.parseInt(request.getParameter("page"));
    		 int pageSize=Integer.parseInt(request.getParameter("pageSize"));
    		 page=(page-1)*pageSize;
	    		List<OrderForm> list = orderFormService.selectOrderFinishByYesterdayInfo(oldDate,now,orderid,eename,name,btu,page,pageSize);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	
	    	/**
	    	 * 查询本年的完成订单
	    	 * @param request
	    	 * @param response
	    	 * @throws ServletException
	    	 * @throws IOException
	    	 */
	    	@RequestMapping("selectOrderFinishByYear")
	    	public void selectOrderFinishByYear(HttpServletRequest request, HttpServletResponse response)
	    			throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		Map<String, String> map = DateCommonUtils.getYearDate();
	    		String now = map.get("yearL");
	    		String oldDate = map.get("yearF");
	    		String eename=request.getParameter("workerName");
	    		String orderid=request.getParameter("orderid");
	    		if(orderid==null || orderid.equals("")){
	    			orderid=null;
	    		}
	    		String name=request.getParameter("name");
	    		String btu=request.getParameter("btu");
	    		if(eename==null || eename==""){
    				eename=null;
    			}
    	
    		if(name==null || name.equals("")){
    			name=null;
    		}
    		if(btu==null || btu.equals("") || btu.equals("状态查询")){
    			btu=null;
    		}
	    		List<OrderForm> list = orderFormService.selectOrderFinishByTime(oldDate,now,orderid,eename,name,btu);
	    		PrintWriter out = response.getWriter();
	    		if (list.size() > 0) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	/*
	    	 * 订单取消
	    	 */
	    	@RequestMapping("cancelOrder")
	    	public void cancelOrder(HttpServletRequest request,
	    			HttpServletResponse response) throws ServletException, IOException {
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		PrintWriter out = response.getWriter();
	    		int id = Integer.parseInt(request.getParameter("id"));
	    		int eeid= Integer.parseInt(request.getParameter("eeid"));
	    		String status = request.getParameter("status");
	    		OrderForm orderForm = new OrderForm();
	    		orderForm.setId(id);
	    		int result = orderFormService.updateOrderByPrimaryKey(orderForm);
	    		
				result = result+cencelOrderService.insertOrderByPrimaryKey(id);
	    		
				if(status.equals("等待中")){
	    			result = result + waitTimeService.updateByOrderid(id);
	    		}
	    		result = result + onlineInformationService.updateOnlineStatusByEeid(eeid);
	    		if(status.equals("等待中")&&result==3){
	    			out.print("success");
	    		}else if(!status.equals("等待中")&&result==2){
	    			out.print("success");
	    		}else{
	    			out.print("null");
	    		}
	    	}
	    	
	    	//查看订单详细信息
	    	@RequestMapping("selectDetailed")
	    	public void selectDetailed(HttpServletRequest request, HttpServletResponse response)
	    			throws IOException, ServletException{
	    		response.setContentType("text/html");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		
	    		int id = Integer.parseInt(request.getParameter("id"));
	    		List<OrderForm> list = orderFormService.selectDetailed(id);
	    	    PrintWriter out = response.getWriter();
	    		if (list!=null) {
	    			Gson gson = new Gson();
	    			String json = gson.toJson(list);
	    			out.print(json);
	    		} else {
	    			String json = null;
	    			out.print(json);
	    		}
	    	}
	    	
	    	@RequestMapping("queryAll2")
	    	public void queryAll2(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
	    		response.setContentType("textml");
	    		request.setCharacterEncoding("UTF-8");
	    		response.setCharacterEncoding("UTF-8");
	    		String btu=request.getParameter("btu");
	    		if(btu==null || btu.equals("")|| btu.equals("状态查询") ){
	    			btu=null;
	    		}
	    		String id=request.getParameter("id");
	    		String name = request.getParameter("name");
	    		String eename = request.getParameter("eename");
	    		String starttime = request.getParameter("starttime");
	    		String endtime = request.getParameter("endtime");
	    		String payment = request.getParameter("payment");
	    		if(payment==null || payment.equals("")|| payment.equals("支付方式") ){
	    			payment=null;
	    		}
	    		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
	    		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	            SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	            try {
	    			starttime=simpleStarttime.format(simple.parse(starttime));
	    			endtime=simpleEndtime.format(simple.parse(endtime));
	    		} catch (ParseException e) {
	    			
	    			e.printStackTrace();
	    		}
	    		if(id == null || id.equals("")){
	    			id =null;
	    		}
	    		if(name == null || name.equals("")){
	    			name =null;
	    		}
	    		if(eename == null || eename.equals("")){
	    			eename =null;
	    		}
	    		if(starttime == null || starttime.equals("")){
	    			starttime =null;
	    		}
	    		if(endtime == null || endtime.equals("")){
	    			endtime =null;
	    		}
	    		List<OrderForm> list = orderFormService.queryAll(id, name,  eename, starttime, endtime,btu,payment);
	    		  PrintWriter out = response.getWriter();
		    		if (list!=null) {
		    			Gson gson = new Gson();
		    			String json = gson.toJson(list);
		    			out.print(json);
		    		} else {
		    			String json = null;
		    			out.print(json);
		    		}
		    	}

	    	
//	    	//全部收益
//	    	@RequestMapping("queryOrderCost")
//	    	  public void queryEarningsAll(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
//	    	response.setContentType("text ml");
//	    	request.setCharacterEncoding("UTF-8");
//	    	response.setCharacterEncoding("UTF-8");
//	    	PrintWriter out=response.getWriter();
//	    	OrderForm list = orderFormService.queryOrderCost();
//	    	if(list!=null){
//	    	String json=list.getOrdercost();
//	    	out.print(json);
//	    	}else{
//	    	String json=null;
//	    	out.print(json);
//	    	}
//
//	    	}
	 
//查询微信订单金额
@RequestMapping("WeiXinMoney")
public void WeiXinMoney(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	List<OrderForm> list=orderFormService.WeiXinMoney();
	 PrintWriter out = response.getWriter();
		if (list!=null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
//查询支付宝订单金额
@RequestMapping("ZhiFuBaoMoney")
public void ZhiFuBaoMoney(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	List<OrderForm> list=orderFormService.ZhiFuBaoMoney();
	PrintWriter out = response.getWriter();
	if (list!=null) {
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
	} else {
		String json = null;
		out.print(json);
	}
}
//查询余额订单金额
@RequestMapping("YueMoney")
public void YueMoney(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	List<OrderForm> list=orderFormService.YueMoney();
	PrintWriter out = response.getWriter();
	if (list!=null) {
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
	} else {
		String json = null;
		out.print(json);
	}
}

//微信查询支付的订单
@RequestMapping("selectPaymentWeiXin")
public void selectPaymentWeiXin(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {	
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id== null || id.equals("")){
			id =null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(eename== null || eename.equals("")){
			eename =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
	List<OrderForm> list=orderFormService.selectPaymentWeiXin(eename, name, id, btu, starttime, endtime);
		int pageNum=list.size();
		PrintWriter out=response.getWriter();
		if(pageNum>0){
			Gson gson=new Gson();
			String json=gson.toJson(pageNum);
			out.print(json);
		}
		else{
			String json=null;
		  out.print(json);	
		}
	}


//查询微信支付的订单
@RequestMapping("selectPaymentWeiXinPage")
public void selectPaymentWeiXinPage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
	if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id== null || id.equals("")){
			id =null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(eename== null || eename.equals("")){
			eename =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
	int page=Integer.parseInt(request.getParameter("page"));
	int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	page=(page-1)*pageSize;
List <OrderForm> list=orderFormService.selectPaymentWeiXinPage(page, pageSize,id, eename, name, btu, starttime, endtime);
if(list!=null){
	Gson gson=new Gson();
	String json=gson.toJson(list);
	out.print(json);
}
else{
	String json=null;
	out.print(json);
}
}
//查询微信支付的订单数量
@RequestMapping("selectPaymentWeiXinCount")
public void selectPaymentWeiXinCount(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id== null || id.equals("")){
			id =null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(eename== null || eename.equals("")){
			eename =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
	 OrderForm list=orderFormService.selectPaymentWeiXinCount(eename, name, id, btu, starttime, endtime);

	 PrintWriter out=response.getWriter();
	 if(list!=null){
		String json =list.getPaymentWeiXinCount();
		out.print(json);
	}
	else{
		String json=null;
		out.print(json);
	}
}


//微信查询支付的订单金额
@RequestMapping("selectPaymentWeiXinMoney")
public void selectPaymentWeiXinMoney(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {	
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id== null || id.equals("")){
			id =null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(eename== null || eename.equals("")){
			eename =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
	OrderForm list=orderFormService.selectPaymentWeiXinMoney(eename, name, id, btu, starttime, endtime);
	PrintWriter out = response.getWriter();
	if (list!=null) {
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
	} else {
		String json = null;
		out.print(json);
	}
}
//支付宝查询支付的订单
@RequestMapping("selectPaymentZhiFuBao")
public void selectPaymentZhiFuBao(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {	
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id== null || id.equals("")){
			id =null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(eename== null || eename.equals("")){
			eename =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
	List<OrderForm> list=orderFormService.selectPaymentZhiFuBao(eename, name, id, btu, starttime, endtime);
	int pageNum=list.size();
	PrintWriter out=response.getWriter();
	if(pageNum>0){
		Gson gson=new Gson();
		String json=gson.toJson(pageNum);
		out.print(json);
	}
	else{
		String json=null;
		out.print(json);
	}
}

//查询支付的订单
@RequestMapping("selectPaymentZhiFuBaoPage")
public void selectPaymentZhiFuBaoPage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e){
		
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id== null || id.equals("")){
			id =null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(eename== null || eename.equals("")){
			eename =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
	int page=Integer.parseInt(request.getParameter("page"));
	int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	page=(page-1)*pageSize;
	List <OrderForm> list=orderFormService.selectPaymentZhiFuBaoPage(page, pageSize,id, eename, name, btu, starttime, endtime);
	if(list!=null){
		Gson gson=new Gson();
		String json=gson.toJson(list);
		out.print(json);
	}
	else{
		String json=null;
		out.print(json);
	}
}
//查询支付的订单数量
@RequestMapping("selectPaymentZhiFuBaoCount")
public void selectPaymentZhiFuBaoCount(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {	
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id== null || id.equals("")){
			id =null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(eename== null || eename.equals("")){
			eename =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
		OrderForm list=orderFormService.selectPaymentZhiFuBaoCount(id, eename, name, btu, starttime, endtime);
		if(list!=null){
			String json =list.getPaymentZhiFuBaoCount();
			out.print(json);
		}
		else{
			String json=null;
			out.print(json);
		}
	}
//查询支付的订单金额
@RequestMapping("selectPaymentZhiFuBaoMoney")
public void selectPaymentZhiFuBaoMoney(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {	
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id== null || id.equals("")){
			id =null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(eename== null || eename.equals("")){
			eename =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
	OrderForm list=orderFormService.selectPaymentZhiFuBaoMoney(eename, name, id, btu, starttime, endtime);
	PrintWriter out = response.getWriter();
	if (list!=null) {
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
	} else {
		String json = null;
		out.print(json);
	}
}
//余额查询支付的订单
@RequestMapping("selectPaymentYue")
public void selectPaymentYue(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {	
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id== null || id.equals("")){
			id =null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(eename== null || eename.equals("")){
			eename =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
	List<OrderForm> list=orderFormService.selectPaymentYue(eename, name, id, btu, starttime, endtime);
	int pageNum=list.size();
	PrintWriter out=response.getWriter();
	if(pageNum>0){
		Gson gson=new Gson();
		String json=gson.toJson(pageNum);
		out.print(json);
	}
	else{
		String json=null;
		out.print(json);
	}
}


//余额查询支付的订单
@RequestMapping("selectPaymentYuePage")
public void selectPaymentPage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {	
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id== null || id.equals("")){
			id =null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(eename== null || eename.equals("")){
			eename =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
	int page=Integer.parseInt(request.getParameter("page"));
	int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	page=(page-1)*pageSize;
	List <OrderForm> list=orderFormService.selectPaymentYuePage(page, pageSize,id, eename, name, btu, starttime, endtime);
	if(list!=null){
		Gson gson=new Gson();
		String json=gson.toJson(list);
		out.print(json);
	}
	else{
		String json=null;
		out.print(json);
	}
}
//余额查询支付的订单数量
@RequestMapping("selectPaymentYueCount")
public void selectPaymentYueCount(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {	
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id== null || id.equals("")){
			id =null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(eename== null || eename.equals("")){
			eename =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
		OrderForm list=orderFormService.selectPaymentYueCount( id, eename, name, btu, starttime, endtime);
		if(list!=null){
			String json =list.getPaymentYueCount();
			out.print(json);
		}
		else{
			String json=null;
			out.print(json);
		}
	}
//余额查询支付的订单金额
@RequestMapping("selectPaymentYueMoney")
public void selectPaymentYueMoney(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {	
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		if(id== null || id.equals("")){
			id =null;
		}
		if(btu==null || btu.equals("") || btu.equals("状态查询")){
			btu=null;
		}
		if(eename== null || eename.equals("")){
			eename =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
	OrderForm list=orderFormService.selectPaymentYueMoney( eename, name, id, btu, starttime, endtime);
	PrintWriter out = response.getWriter();
	if (list!=null) {
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
	} else {
		String json = null;
		out.print(json);
	}
}

//取消的订单数
@RequestMapping("cancelCount")
public void cancelCount(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	List<OrderForm> list=orderFormService.cancelCount();
	PrintWriter out = response.getWriter();
	if (list!=null) {
		Gson gson = new Gson();
		String json =gson.toJson(list);
		out.print(json);
	} else {
		String json = null;
		out.print(json);
	}
}
//取消的订单
@RequestMapping("paymentcancelOrder")
public void paymentcancelOrder(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
	SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	try {	
		starttime=simpleStarttime.format(simple.parse(starttime));
		endtime=simpleEndtime.format(simple.parse(endtime));
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	if(starttime==null || starttime==""){
		starttime=null;
	}
	if(endtime==null || endtime==""){
		endtime=null;
	}
	if(id== null || id.equals("")){
		id =null;
	}
	if(btu==null || btu.equals("") || btu.equals("状态查询")){
		btu=null;
	}
	if(eename== null || eename.equals("")){
		eename =null;
	}
	if(name== null || name.equals("")){
		name =null;
	}

	List<OrderForm> list=orderFormService.cancelOrder(eename, name, id, btu, starttime, endtime);
	int pageNum=list.size();
	PrintWriter out=response.getWriter();
	if(pageNum>0){
		Gson gson=new Gson();
		String json=gson.toJson(pageNum);
		out.print(json);
	}
	else{
		String json=null;
		out.print(json);
	}
}


//取消的订单分页
@RequestMapping("cancelOrderPage")
public void cancelOrderPage(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
	SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	try {	
		starttime=simpleStarttime.format(simple.parse(starttime));
		endtime=simpleEndtime.format(simple.parse(endtime));
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	if(starttime==null || starttime==""){
		starttime=null;
	}
	if(endtime==null || endtime==""){
		endtime=null;
	}
	if(id== null || id.equals("")){
		id =null;
	}
	if(btu==null || btu.equals("") || btu.equals("状态查询")){
		btu=null;
	}
	if(eename== null || eename.equals("")){
		eename =null;
	}
	if(name== null || name.equals("")){
		name =null;
	}
	int page=Integer.parseInt(request.getParameter("page"));
	int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	page=(page-1)*pageSize;
	List <OrderForm> list=orderFormService.cancelOrderPage(page, pageSize,id, eename, name, btu, starttime, endtime);
	if(list!=null){
		Gson gson=new Gson();
		String json=gson.toJson(list);
		out.print(json);
	}
	else{
		String json=null;
		out.print(json);
	}
}
//取消的订单数量
@RequestMapping("cancelOrderCount")
public void cancelOrderCount(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
	String eename = request.getParameter("eename");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String btu = request.getParameter("btu");
	String  starttime = request.getParameter("starttime");
	String endtime = request.getParameter("endtime");
	SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	try {	
		starttime=simpleStarttime.format(simple.parse(starttime));
		endtime=simpleEndtime.format(simple.parse(endtime));
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	if(starttime==null || starttime==""){
		starttime=null;
	}
	if(endtime==null || endtime==""){
		endtime=null;
	}
	if(id== null || id.equals("")){
		id =null;
	}
	if(btu==null || btu.equals("") || btu.equals("状态查询")){
		btu=null;
	}
	if(eename== null || eename.equals("")){
		eename =null;
	}
	if(name== null || name.equals("")){
		name =null;
	}
	OrderForm list=orderFormService.cancelOrderCount( id, eename, name, btu, starttime, endtime);
	if(list!=null){
		String json =list.getPaymentCancelCount();
		out.print(json);
	}
	else{
		String json=null;
		out.print(json);
	}
}

}