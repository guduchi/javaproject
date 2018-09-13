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

import com.bangshuo.kuaigong.po.Company;
import com.bangshuo.kuaigong.po.EmployeeHourLength;
import com.bangshuo.kuaigong.service.HourlengthallService;
import com.google.gson.Gson;

@Controller
@RequestMapping("Hour")

public class HourlengthallController {
	@Autowired
	HourlengthallService employeeHourLengthService;
	
	@RequestMapping("HourLength")
	public void HourLength(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		if(username== null || username.equals("")){
			username =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
		List<EmployeeHourLength> list=employeeHourLengthService.selectHourLength(name, username);
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

	@RequestMapping("HourLengthPage")
	public void HourLengthPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		if(username== null || username.equals("")){
			username =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		page=(page-1)*pageSize;
		List <EmployeeHourLength> list=employeeHourLengthService.selectHourLengthPgae(page, pageSize, name, username);
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
	
	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		if(username== null || username.equals("")){
			username =null;
		}
		if(name== null || name.equals("")){
			name =null;
		}
		EmployeeHourLength list=employeeHourLengthService.selectNum(name, username);
		 if(list!=null){
			 String json=list.getCount();
			 out.print(json);
		 }
		 else{
			 String json=null;
			 out.print(json);
		 }
	}
	
}
