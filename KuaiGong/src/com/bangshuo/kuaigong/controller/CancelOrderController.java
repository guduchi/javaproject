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

import com.bangshuo.kuaigong.po.CancelOrder;
import com.bangshuo.kuaigong.service.CancelOrderService;
import com.google.gson.Gson;

@Controller
@RequestMapping("Cancel")
public class CancelOrderController {
	@Autowired
	CancelOrderService cancelOrderService;	

	@RequestMapping("selectCancelOrder")
	public void selectCancelOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("xxxxxxxxxxxxxxxxxxxx"+id);
		List<CancelOrder> list = cancelOrderService.selectCancelOrder(id);
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
