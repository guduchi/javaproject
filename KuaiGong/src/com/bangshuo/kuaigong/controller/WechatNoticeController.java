package com.bangshuo.kuaigong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bangshuo.kuaigong.po.EmployerUser;
import com.bangshuo.kuaigong.po.WechatNotice;
import com.bangshuo.kuaigong.service.EmployerUserService;
import com.bangshuo.kuaigong.service.WechatNoticeService;
import com.google.gson.Gson;



@Controller
@RequestMapping("WechatNotice")
public class WechatNoticeController {
	@Autowired
	WechatNoticeService wechatNoticeService; 
	@RequestMapping("queryOpenid")
public void queryOpenid(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("erid");
		  String[] erid = id.split(",");
			for(int i=0;i<erid.length;i++){
			 List<WechatNotice> list= wechatNoticeService.queryOpenid(Integer.parseInt(erid[i]));
			int pageNum=list.size();

	if(pageNum>0){
		Gson gson=new Gson();
		String json=gson.toJson(list);
		out.print(json);
	}else{
		String json=null;
		out.print(erid[i]);
	}
	}
			
}
}