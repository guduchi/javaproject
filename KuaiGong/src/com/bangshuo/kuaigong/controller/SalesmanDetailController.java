package com.bangshuo.kuaigong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bangshuo.kuaigong.po.SalesmanDetail;
import com.bangshuo.kuaigong.service.SalesmanDetailService;
import com.google.gson.Gson;

@Controller
@RequestMapping("Detail")
public class SalesmanDetailController {
	@Autowired
	SalesmanDetailService salesmanDetailService;
	
	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String salesmanName = request.getParameter("salesmanName");
		String username = request.getParameter("username");
		String desc = request.getParameter("desc");
		String starttime = request.getParameter("starttime");
		String endtime =request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        
        try {
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		if (salesmanName == null || salesmanName.equals("")) {
			salesmanName = null;
		}
		if (username == null || username.equals("")) {
			username = null;
		}
		if(desc==null || desc.equals("") || desc.equals("状态查询")){
			desc=null;
		}
		if (starttime == null || starttime.equals("")) {
			starttime = null;
		}
		if (endtime == null || endtime.equals("")) {
			endtime = null;
		}
		SalesmanDetail list=salesmanDetailService.selectNum(salesmanName, username, desc, starttime, endtime);
		PrintWriter out = response.getWriter();
		if (list != null) {
			String json = list.getCount();
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
		@RequestMapping("selectMoney")
	public void selectMoney(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String salesmanName = request.getParameter("salesmanName");
		String username = request.getParameter("username");
		String desc = request.getParameter("desc");
		String starttime = request.getParameter("starttime");
		String endtime =request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        
        try {
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		if (salesmanName == null || salesmanName.equals("")) {
			salesmanName = null;
		}
		if (username == null || username.equals("")) {
			username = null;
		}
		if(desc==null || desc.equals("") || desc.equals("状态查询")){
			desc=null;
		}
		if (starttime == null || starttime.equals("")) {
			starttime = null;
		}
		if (endtime == null || endtime.equals("")) {
			endtime = null;
		}
		List<SalesmanDetail>list=salesmanDetailService.selectMoney(salesmanName, username, desc, starttime, endtime);
		PrintWriter out = response.getWriter();
		int pageNum = list.size();
		if (pageNum > 0) {
			Gson gson = new Gson();
			String json = gson.toJson(pageNum);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	/*
	 * 查询业务员的钱分页
	 */
	@RequestMapping("selectMoneyPage")
	public void selectMoneyPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String salesmanName = request.getParameter("salesmanName");
		String username = request.getParameter("username");
		String desc = request.getParameter("desc");
		String starttime = request.getParameter("starttime");
		String endtime =request.getParameter("endtime");
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat simpleEndtime=new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        
        try {
			starttime=simpleStarttime.format(simple.parse(starttime));
			endtime=simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		if (salesmanName == null || salesmanName.equals("")) {
			salesmanName = null;
		}
		if (username == null || username.equals("")) {
			username = null;
		}
		if(desc==null || desc.equals("") || desc.equals("状态查询")){
			desc=null;
		}
		if (starttime == null || starttime.equals("")) {
			starttime = null;
		}
		if (endtime == null || endtime.equals("")) {
			endtime = null;
		}
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		PrintWriter out = response.getWriter();
		List<SalesmanDetail> list = salesmanDetailService.selectMoneyPage(page, pageSize,salesmanName, username, desc, starttime, endtime);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
}
