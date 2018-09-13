package com.bangshuo.kuaigong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
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

import com.bangshuo.kuaigong.po.recharge;
import com.bangshuo.kuaigong.service.RechargeService;
import com.bangshuo.kuaigong.utils.DateCommonUtils;
import com.google.gson.Gson;

@Controller
@RequestMapping("Recharge")
public class RechargeController {
@Autowired
RechargeService rechargeService;
//查询充值记录
@RequestMapping("Query")
public void QueryRecharge(HttpServletRequest request,HttpServletResponse response)throws ServerException,IOException{

	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	int id=Integer.parseInt(request.getParameter("id"));
	List<recharge> list = rechargeService.select(id);
	int pagenum=list.size();
	
	PrintWriter out = response.getWriter();
	if (pagenum > 0) {
		Gson gson = new Gson();
		String json = gson.toJson(pagenum);
		out.print(json);
	} else {
		String json = null;
		out.print(json);
	}
}
@RequestMapping("QueryPaGe")
public void QueryPaGe(HttpServletRequest request,HttpServletResponse response)throws ServerException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	int id=Integer.parseInt(request.getParameter("id"));
	int page=Integer.parseInt(request.getParameter("page"));
	int pageSize=Integer.parseInt(request.getParameter("pageSize"));
    page=(page-1)*pageSize;
    PrintWriter out=response.getWriter();
    		
   List<recharge> list=rechargeService.selectPage(id, page, pageSize);
    
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
//充值
@RequestMapping("selectSum")
public void selectSum(HttpServletRequest request,HttpServletResponse response)throws ServerException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	int id=Integer.parseInt(request.getParameter("id"));
int list=rechargeService.selectSum(id);
request.getSession().setAttribute("list", list);

PrintWriter out=response.getWriter();
if(list>0){
	Gson gson=new Gson();
	String json=gson.toJson(list);
	out.print(json);
}
else{
	String json=null;
	out.print(json);
}
}

/*	李奎写的代码*/
/**
 * 查询昨天的完成订单
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */
@RequestMapping("selectRechargeByYesterday")
public void selectRechargeByYesterday(HttpServletRequest request,
		HttpServletResponse response) throws ServerException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	Date nowDate = new Date();
	nowDate.setHours(0);
	nowDate.setMinutes(0);
	nowDate.setSeconds(0);
	Date yesterdayDate = new Date(nowDate.getTime() - 86400000L);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String now = sdf.format(nowDate);
	String yesterday = sdf.format(yesterdayDate);
	
	List<recharge> list = rechargeService.selectRechargeByTime(yesterday, now);
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
@RequestMapping("selectRechargeByWeek")
public void selectRechargeByWeek(HttpServletRequest request,
		HttpServletResponse response) throws ServerException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	Map<String, String> map = DateCommonUtils.getWeekDay();
	String now = map.get("sun");
	String oldDate = map.get("mon");
	
	
	List<recharge> list = rechargeService.selectRechargeByTime(oldDate, now);
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
@RequestMapping("selectRechargeByMonth")
public void selectRechargeByMonth(HttpServletRequest request,
		HttpServletResponse response) throws ServerException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	Map<String, String> map = DateCommonUtils.getMonthDate();
	String now = map.get("monthL");
	String oldDate = map.get("monthF");

	List<recharge> list = rechargeService.selectRechargeByTime(oldDate, now);
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
@RequestMapping("selectRechargeByYear")
public void selectRechargeByYear(HttpServletRequest request,
		HttpServletResponse response) throws ServerException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	Map<String, String> map = DateCommonUtils.getYearDate();
	String now = map.get("yearL");
	String oldDate = map.get("yearF");
	List<recharge> list = rechargeService.selectRechargeByTime(oldDate, now);
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
}

