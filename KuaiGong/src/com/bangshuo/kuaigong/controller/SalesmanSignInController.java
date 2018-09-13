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

import com.bangshuo.kuaigong.po.SalesmanSignIn;
import com.bangshuo.kuaigong.service.SalesmanSignInService;
import com.google.gson.Gson;

@Controller
@RequestMapping("SignIn")
public class SalesmanSignInController {
	@Autowired
	SalesmanSignInService salesmanSignInService;

	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String salesmanName = request.getParameter("salesmanName");
		String username = request.getParameter("username");
		String status = request.getParameter("status");
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
		if (salesmanName == null || salesmanName.equals("")) {
			salesmanName = null;
		}
		if (username == null || username.equals("")) {
			username = null;
		}
		if (starttime == null || starttime.equals("")) {
			starttime = null;
		}
		if (endtime == null || endtime.equals("")) {
			endtime = null;
		}
		if (status == null || status.equals("") || status.equals("状态查询")) {
			status = null;
		}
		SalesmanSignIn list = salesmanSignInService.selectNum(salesmanName,username,starttime,endtime,status);
		if (list != null) {
			String json = list.getCount();
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	// 查询业务员钱包
	@RequestMapping("selectSalesmanSignIn")
	public void selectSalesman(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String salesmanName = request.getParameter("salesmanName");
		String username = request.getParameter("username");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String status = request.getParameter("status");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfStart = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd 23:59:59");

		try {
			starttime = sdfStart.format(sdf.parse(starttime));
			endtime = sdfEnd.format(sdf.parse(endtime));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (salesmanName == null || salesmanName.equals("")) {
			salesmanName = null;
		}
		if (username == null || username.equals("")) {
			username = null;
		}
		if (starttime == null || starttime.equals("")) {
			starttime = null;
		}
		if (endtime == null || endtime.equals("")) {
			endtime = null;
		}
		if (status == null || status.equals("") || status.equals("状态查询")) {
			status = null;
		}
		System.out.println("+++++++++++++++++salesmanName" + salesmanName);
		System.out.println("+++++++++++++++++username" + username);
		List<SalesmanSignIn> list = salesmanSignInService.selectSignIn(
				salesmanName, username, starttime, endtime, status);
		int pageNum = list.size();
		PrintWriter out = response.getWriter();
		if (pageNum > 0) {
			Gson gson = new Gson();
			String json = gson.toJson(pageNum);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	// 查询业务员钱包分页
	@RequestMapping("selectSalesmanSignInPage")
	public void selectSalesmanPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String salesmanName = request.getParameter("salesmanName");
		String username = request.getParameter("username");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String status = request.getParameter("status");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfStart = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd 23:59:59");

		try {
			starttime = sdfStart.format(sdf.parse(starttime));
			endtime = sdfEnd.format(sdf.parse(endtime));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		if (salesmanName == null || salesmanName.equals("")) {
			salesmanName = null;
		}
		if (username == null || username.equals("")) {
			username = null;
		}
		if (starttime == null || starttime.equals("")) {
			starttime = null;
		}
		if (endtime == null || endtime.equals("")) {
			endtime = null;
		}
		if (status == null || status.equals("") || status.equals("状态查询")) {
			status = null;
		}
		PrintWriter out = response.getWriter();
		List<SalesmanSignIn> list = salesmanSignInService.selectSignInPage(
				page, pageSize, salesmanName, username, starttime, endtime,
				status);
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
