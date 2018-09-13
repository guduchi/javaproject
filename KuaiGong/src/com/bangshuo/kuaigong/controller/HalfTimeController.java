package com.bangshuo.kuaigong.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bangshuo.kuaigong.po.HalfTime;
import com.bangshuo.kuaigong.service.HalfTimeService;
import com.google.gson.Gson;

@Controller
@RequestMapping("half")
public class HalfTimeController {
	
	@Autowired
	HalfTimeService halfTimeService;

	
	@RequestMapping("add")
	public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{	
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		String starttime =request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		
		HalfTime halfTime = new HalfTime();
		halfTime.setId(id);
		halfTime.setOrderid(orderid);
		halfTime.setStarttime(starttime);
		halfTime.setEndtime(endtime);
		
		PrintWriter out = response.getWriter();
		int ss = halfTimeService.insert(halfTime);
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
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		String starttime =request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		
		HalfTime halfTime = new HalfTime();
		halfTime.setId(id);
		halfTime.setOrderid(orderid);
		halfTime.setStarttime(starttime);
		halfTime.setEndtime(endtime);
		
		int num = halfTimeService.updateByPrimaryKeySelective(halfTime);
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
		int num = halfTimeService.deleteByPrimaryKey(id);
		
		halfTimeService.deleteByPrimaryKey(id);
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
}
