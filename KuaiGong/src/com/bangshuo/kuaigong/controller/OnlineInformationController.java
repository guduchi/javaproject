package com.bangshuo.kuaigong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bangshuo.kuaigong.po.EmployeeUserOnlineInfo;
import com.bangshuo.kuaigong.po.OnlineDetailInfo;
import com.bangshuo.kuaigong.po.OnlineInformation;
import com.bangshuo.kuaigong.po.Week;
import com.bangshuo.kuaigong.service.OnlineInformationService;
import com.google.gson.Gson;

@Controller
@RequestMapping("onlineInformation")
public class OnlineInformationController {
	
	@Autowired
	OnlineInformationService onlineInformationService;
	
	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String name =request.getParameter("name");
		String btu =request.getParameter("btu");
		String starttime =request.getParameter("starttime");
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
		
		if(name == null || name.equals("")){
			name =null;
		}
		if(btu == null || btu.equals("") || btu.equals("根据状态查询")){
			btu =null;
		}
		if(starttime == null || starttime.equals("")){
			starttime =null;
		}
		if(endtime == null || endtime.equals("")){
			endtime =null;
		}
		OnlineInformation list=onlineInformationService.selectNum(name, btu, starttime, endtime);
		 if(list!=null){
			 String json=list.getCount();
			 out.print(json);
		 }
		 else{
			 String json=null;
			 out.print(json);
		 }
	}
	
	@RequestMapping("timeCount")
	public void timeCount(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String name =request.getParameter("name");
		String btu =request.getParameter("btu");
		String starttime =request.getParameter("starttime");
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
		
		if(name == null || name.equals("")){
			name =null;
		}
		if(btu == null || btu.equals("") || btu.equals("根据状态查询")){
			btu =null;
		}
		if(starttime == null || starttime.equals("")){
			starttime =null;
		}
		if(endtime == null || endtime.equals("")){
			endtime =null;
		}
		List<OnlineInformation> list=onlineInformationService.timeCount(name, btu, starttime, endtime);
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
	
	@RequestMapping("queryInfomationByTime")
	public void queryInfomationByTime(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		String btu=request.getParameter("btu");
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		 List<OnlineInformation> list= onlineInformationService.queryInfomationByTime(starttime, endtime,btu);
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
	@RequestMapping("queryInfomationByTimePage")
	public void queryInfomationByTimePage(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		String btu=request.getParameter("btu");
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		page=(page-1)*pageSize;
		 List<OnlineInformation> list= onlineInformationService.queryInfomationByTimePage(starttime, endtime,btu,page,pageSize);
		
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
	//根据状态时间查询在线时间
	@RequestMapping("queryDate77")
	public void queryDate77(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
	
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
    List<OnlineInformation> list= onlineInformationService.queryDate77(starttime, endtime,id);
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

	//根据根据状态时间查询分页
	@RequestMapping("queryDatePaGe77")
	public void queryDatePaGe77(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
	
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		page=(page-1)*pageSize;
    List<OnlineInformation> list=onlineInformationService.queryDatePaGe77(starttime, endtime,page,pageSize,id);
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
	//����ģ���ѯ
		@RequestMapping("queryInfomation886")
		public void queryInfomation886(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String id=request.getParameter("id");
			String query = request.getParameter("query");
			String starttime=request.getParameter("starttime");
			String endtime=request.getParameter("endtime");
			List<OnlineInformation> list =  onlineInformationService.queryInfomation886(query ,"%" + id + "%",starttime,endtime);
			int pageNum=list.size();
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
		
		@RequestMapping("queryInfomation886PaGe")
		public void queryInfomation886PaGe(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int page=Integer.parseInt(request.getParameter("page"));
			int pageSize=Integer.parseInt(request.getParameter("pageSize"));
			String id=request.getParameter("id");
			String query = request.getParameter("query");
			String starttime=request.getParameter("starttime");
			String endtime=request.getParameter("endtime");
			page=(page-1)*pageSize;
			List<OnlineInformation> list =  onlineInformationService.queryInfomation886PaGe(query,"%" + id + "%",starttime,endtime,page,pageSize);
		
			PrintWriter out = response.getWriter();
			if (list.size()>0) {
				Gson gson = new Gson();
				String json = gson.toJson(list);
				out.print(json);
			} else {
				String json = null;
				out.print(json);
			}
		}
	
	//����ģ���ѯ
	@RequestMapping("queryInfomation8")
	public void queryInfomation8(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String query = request.getParameter("query");
		List<OnlineInformation> list =  onlineInformationService.queryInfomation8(query ,"%" + id + "%");
		int pageNum=list.size();
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
	@RequestMapping("queryInfomation8PaGe")
	public void queryInfomation8PaGe(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		String id=request.getParameter("id");
		String query = request.getParameter("query");
		page=(page-1)*pageSize;
		List<OnlineInformation> list =  onlineInformationService.queryInfomation8PaGe(page,pageSize,query,"%" + id + "%");
	
		PrintWriter out = response.getWriter();
		if (list.size()>0) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	 //��ݹ�����״̬��ѯ 
	   @RequestMapping("querystatus2")
		public void querystatus2(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String btu =request.getParameter("btu");
			List<OnlineInformation>list = onlineInformationService.selectstatus2(btu);
			int pageNum = list.size();
		request.getSession().setAttribute("pageNum", pageNum);
			PrintWriter out = response.getWriter();
			if(pageNum>0){
				Gson gson = new Gson();
				String json = gson.toJson(pageNum);
				out.print(json);
			} else {	
				String json = null;
				out.print(json);
			}
		}
		
		//��ݹ�����״̬��ѯ��ҳ
	   @RequestMapping("querystatusPage2")
		public void querystatusPage2(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			  String btu=request.getParameter("btu");
			  int page=Integer.parseInt(request.getParameter("page"));
			  int pageSize=Integer.parseInt(request.getParameter("pageSize"));

			  PrintWriter out = response.getWriter();
			  page = (page - 1) * pageSize;
			 List<OnlineInformation> list= onlineInformationService.selectstatusPage2(page, pageSize, btu);
			  if (list != null) {
					Gson gson = new Gson();
					String json = gson.toJson(list);
					out.print(json);
				} else {
					String json = null;
					out.print(json);
				}
			}

		

	 //���״̬��ѯ 
   @RequestMapping("querystatus1")
	public void querystatus1(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String btu =request.getParameter("btu");
		List<OnlineInformation>list = onlineInformationService.selectstatus1(btu);
		int pageNum = list.size();
	request.getSession().setAttribute("pageNum", pageNum);
		PrintWriter out = response.getWriter();
		if(pageNum>0){
			Gson gson = new Gson();
			String json = gson.toJson(pageNum);
			out.print(json);
		} else {	
			String json = null;
			out.print(json);
		}
	}
	
	//���״̬��ѯ��ҳ
   @RequestMapping("querystatusPage1")
	public void querystatusPage1(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		  String btu=request.getParameter("btu");
		  int page=Integer.parseInt(request.getParameter("page"));
		  int pageSize=Integer.parseInt(request.getParameter("pageSize"));

		  PrintWriter out = response.getWriter();
		  page = (page - 1) * pageSize;
		 List<OnlineInformation> list= onlineInformationService.selectstatusPage1(page, pageSize, btu);
		  if (list != null) {
				Gson gson = new Gson();
				String json = gson.toJson(list);
				out.print(json);
			} else {
				String json = null;
				out.print(json);
			}
		}

	
	
	
	 //查询在线时间
    @RequestMapping("querystatus")
	public void querystatus(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int pageNum;
		String radio=request.getParameter("radio");
		if(radio==null || radio.equals("")){
			radio=null;
		}
		String name=request.getParameter("name");
		if(name == null || name.equals("")){
			name=null;
		}
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
		String btu =request.getParameter("btu");
		if(btu==null || btu.equals("")|| btu.equals("根据状态查询")){
			btu=null;
		}
		if(radio != null){
			List<OnlineInformation>list = onlineInformationService.selectstatusSort(btu,name,starttime,endtime);
			 pageNum = list.size();
		request.getSession().setAttribute("pageNum", pageNum);
			PrintWriter out = response.getWriter();
			if(pageNum>0){
				Gson gson = new Gson();
				String json = gson.toJson(pageNum);
				out.print(json);
			} else {	
				String json = null;
				out.print(json);
			}
		}else{
		List<OnlineInformation>list = onlineInformationService.selectstatus(btu,name,starttime,endtime);
		 pageNum = list.size();
	request.getSession().setAttribute("pageNum", pageNum);
		PrintWriter out = response.getWriter();
		if(pageNum>0){
			Gson gson = new Gson();
			String json = gson.toJson(pageNum);
			out.print(json);
		} else {	
			String json = null;
			out.print(json);
		}
		}
	}
	
	//�������״̬��ѯ��ҳ
    @RequestMapping("querystatusPage")
	public void querystatusPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String radio=request.getParameter("radio");
		if(radio==null || radio==""){
			radio=null;
		}
		String name=request.getParameter("name");
		if(name == null || name.equals("")){
			name=null;
		}
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
		
		
		
		String btu =request.getParameter("btu");
		if(btu==null || btu.equals("") || btu.equals("根据状态查询")){
			btu=null;
		}
		  int page=Integer.parseInt(request.getParameter("page"));
		  int pageSize=Integer.parseInt(request.getParameter("pageSize"));
       if(radio !=null){
    		PrintWriter out = response.getWriter();
  		  page = (page - 1) * pageSize;
  		 List<OnlineInformation> list= onlineInformationService.selectstatusPageInfo(page, pageSize, btu,name,starttime,endtime);
  		  if (list != null) {
  				Gson gson = new Gson();
  				String json = gson.toJson(list);
  				out.print(json);
  			} else {
  				String json = null;
  				out.print(json);
  			}
       }else{
    	   	PrintWriter out = response.getWriter();
		  page = (page - 1) * pageSize;
		 List<OnlineInformation> list= onlineInformationService.selectstatusPage(page, pageSize, btu,name,starttime,endtime);
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

	//��ѯ��ҳ

		@RequestMapping("queryID")
		public void queryID2(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String query = request.getParameter("query");
			
			List<OnlineInformation> list =  onlineInformationService.selectByStartimeOrEndtime2("%" + query + "%");
			request.getSession().setAttribute("ss", query);
		
		int pageNum=list.size();
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
//��ѯ��ҳ

		@RequestMapping("queryInfomation1")
		public void queryInfomation1(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String query = request.getParameter("query");
			List<OnlineInformation> list =  onlineInformationService.queryInfomation1("%" + query + "%");
			int pageNum=list.size();
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
		@RequestMapping("queryInfomation1PaGe")
		public void queryInfomation1PaGe(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int page=Integer.parseInt(request.getParameter("page"));
			int pageSize=Integer.parseInt(request.getParameter("pageSize"));
			String query = request.getParameter("query");
			page=(page-1)*pageSize;
			List<OnlineInformation> list =  onlineInformationService.queryInfomation1PaGe(page,pageSize,"%" + query + "%");
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

	@RequestMapping("queryByid")
	public void queryByid(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String id=request.getParameter("id");
	PrintWriter out=response.getWriter();
	List<OnlineInformation> list=onlineInformationService.selectById(Integer.parseInt(id));
	System.out.println(id);
	System.out.println(list);
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
	         
	@RequestMapping("query")
	public void  query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		int eeid = Integer.parseInt(request.getParameter("eeid"));
		
		String startime = request.getParameter("startime");
		String endtime = request.getParameter("endtime");

		OnlineInformation onlineInformation = new OnlineInformation();
		onlineInformation.setId(id);
		onlineInformation.setEeid(eeid);
		onlineInformation.setStartime(startime);
		onlineInformation.setEndtime(endtime);
        
		int num = onlineInformationService.insertSelective(onlineInformation);
		PrintWriter out = response.getWriter();
		if (num > 0) {
			Gson gson = new Gson();
			String json = gson.toJson("1");
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	
	@RequestMapping("queryUserAll")
	public void queryUserAlld(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		if(username==null || username.equals("")){
			username=null;
		}
		List<OnlineInformation> list=onlineInformationService.queryAll(username);
		int num=list.size();
		
		if(num!=0){
			Gson gson=new Gson();
			String json=gson.toJson(num);
			out.print(json);
		}else{
			String json=null;
			out.print(json); 
		}
	}
	
	
	@RequestMapping("queryUserInfo")
	public void queryUserInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		String username=request.getParameter("username");
		if(username==null || username.equals("")){
			username=null;
		}
		page = (page - 1) * pageSize;
		List<OnlineInformation> list = onlineInformationService.selectByPage1(username,page, pageSize);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	@RequestMapping("updateByPrimaryKey")
	public void  updateByPrimaryKey(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		int eeid = Integer.parseInt(request.getParameter("eeid"));
		String startime = request.getParameter("startime");
		String endtime = request.getParameter("endtime");

		OnlineInformation onlineInformation = new OnlineInformation();
		onlineInformation.setId(id);
		onlineInformation.setEeid(eeid);
		onlineInformation.setStartime(startime);
		onlineInformation.setEndtime(endtime);
        
		int num = onlineInformationService.updateByPrimaryKey(onlineInformation);
		PrintWriter out = response.getWriter();
		if (num > 0) {
			Gson gson = new Gson();
			String json = gson.toJson("1");
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	@RequestMapping("delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		int list = onlineInformationService.deleteByPrimaryKey(id);

		PrintWriter out = response.getWriter();
		if (list > 0) {
			Gson gson = new Gson();
			String json = gson.toJson("1");
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}



/* 李奎写的代码 */
@RequestMapping("selectOnlineByYersday")
public void selectOnlineByYersday(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
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
	String name=request.getParameter("name");
	String btu=request.getParameter("btu");
	if(name==null || name.equals("")){
		name=null;
	}
	if(btu==null || btu.equals("") || btu.equals("根据状态查询")){
		btu=null;
	}
	List<OnlineInformation> list = onlineInformationService.selectOnlineInformationByTime(yesterday, now,name,btu);


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
 * 昨日在线人数分页
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */

@RequestMapping("selectOnlineByYersdayInfo")
public void selectOnlineByYersdayInfo(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
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
	String name=request.getParameter("name");
	String btu=request.getParameter("btu");
	if(name==null || name.equals("")){
		name=null;
	}
	if(btu==null || btu.equals("") || btu.equals("根据状态查询")){
		btu=null;
	}
	int page=Integer.parseInt(request.getParameter("page"));
	int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	page=(page-1)*pageSize;
	List<OnlineInformation> list = onlineInformationService.selectOnlineInformationByTimeInfo(yesterday, now,name,btu,page,pageSize);


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




@RequestMapping("selectOnlineByStatistics")
public void selectOnlineByStatistics(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	

	Calendar cal = Calendar.getInstance();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	SimpleDateFormat dfOld = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期
	String monday = df.format(cal.getTime());
	String modayOld = dfOld.format(cal.getTime());
	String name=request.getParameter("name");
	if(name==null || name.equals("")){
		name=null;
	}
	String btu=request.getParameter("btu");
	if(btu==null || btu.equals("")){
		btu=null;
	}
	List<OnlineInformation> mondayList = onlineInformationService.selectOnlineInformationByTime(monday, modayOld,name,btu);
	
	cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY); // 获取本周二的日期
	String tuesday = df.format(cal.getTime());
	String tuesdayOld = dfOld.format(cal.getTime());
	List<OnlineInformation> tuesdayList = onlineInformationService.selectOnlineInformationByTime(tuesday, tuesdayOld,name,btu);
	
	cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY); // 获取本周三的日期
	String wednesday = df.format(cal.getTime());
	String wednesdayOld = dfOld.format(cal.getTime());
	List<OnlineInformation> wednesdayList = onlineInformationService.selectOnlineInformationByTime(wednesday, wednesdayOld,name,btu);
	
	cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY); // 获取本周四的日期
	String thursday = df.format(cal.getTime());
	String thursdayOld = dfOld.format(cal.getTime());
	List<OnlineInformation> thursdayList = onlineInformationService.selectOnlineInformationByTime(thursday, thursdayOld,name,btu);
	
	cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY); // 获取本周五的日期
	String friday = df.format(cal.getTime());
	String fridayOld = dfOld.format(cal.getTime());
	List<OnlineInformation> fridayList = onlineInformationService.selectOnlineInformationByTime(friday, fridayOld,name,btu);
	
	cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY); // 获取本周六的日期
	String saturday = df.format(cal.getTime());
	String saturdayOld = dfOld.format(cal.getTime());
	List<OnlineInformation> saturdayList = onlineInformationService.selectOnlineInformationByTime(saturday, saturdayOld,name,btu);
	
	cal.add(Calendar.DATE, 7);
	cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);// 获取本周日的日期
	String sunday = df.format(cal.getTime());
	String sundayOld = dfOld.format(cal.getTime());
	List<OnlineInformation> sundayList = onlineInformationService.selectOnlineInformationByTime(sunday, sundayOld,name,btu);
	
	List<Week> list = new ArrayList<Week>();
	Week week = new Week();
	week.setMonday(mondayList.size());
	week.setTuesday(tuesdayList.size());
	week.setWednesday(wednesdayList.size());
	week.setThursday(thursdayList.size());
	week.setFriday(fridayList.size());
	week.setSaturday(saturdayList.size());
	week.setSunday(sundayList.size());
	list.add(week);
	PrintWriter out = response.getWriter();
	if (list.size() > 0) {
		Gson gson = new Gson();
		String json = gson.toJson(week);
		out.print(json);
	} else {
		String json = null;
		out.print(json);
	}
}




///在线统计

@RequestMapping("queryOnlineInfoByTime")
public void queryOnlineInfoByTime(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	String startTime = request.getParameter("start");
	String endTime = request.getParameter("end");
    String time = request.getParameter("time");
	String name = request.getParameter("name");
	String sort = request.getParameter("sort");

	int page = Integer.parseInt(request.getParameter("page"));
	int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	page = (page-1)*pageSize;
	List<EmployeeUserOnlineInfo> list = null;

	if(time.equals("total")){
		list = onlineInformationService.queryTotalOnlineInfo(name,sort, page, pageSize);
	}else if(time.equals("year")){
		list = onlineInformationService.queryYearOnlineInfo(name,sort, page, pageSize);
	}else if(time.equals("month")){
		list = onlineInformationService.queryMonthOnlineInfo(name,sort, page, pageSize);
	}else if(time.equals("week")){
		list = onlineInformationService.queryWeekOnlineInfo(name,sort, page, pageSize);
	}else if(time.equals("yesterday")){
		list = onlineInformationService.queryYesterdayOnlineInfo(name,sort, page, pageSize);
	}else if(time.equals("today")){
		list = onlineInformationService.queryTodayOnlineInfo(name,sort, page, pageSize);
	}else if(time.equals("timeSlot")){
		list = onlineInformationService.queryTimeSlotOnlineInfo(startTime, endTime, name, sort, page, pageSize);
	}
	if(list!=null){
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
	}else{
		out.print("null");
	}
}
@RequestMapping("queryOnlineInfoPage")
public void queryOnlineInfoPageByTime(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	String name = request.getParameter("name");
	List<EmployeeUserOnlineInfo> list = null;
	list = onlineInformationService.queryTotalOnlineInfoPage(name);
//	if(time.equals("total")){
//		list = onlineInformationService.queryTotalOnlineInfoPage(name);
//	}else if(time.equals("year")){
//		list = onlineInformationService.queryYearOnlineInfoPage(name);
//	}else if(time.equals("month")){
//		list = onlineInformationService.queryMonthOnlineInfoPage(name);
//	}else if(time.equals("week")){
//		list = onlineInformationService.queryWeekOnlineInfoPage(name);
//	}else if(time.equals("yesterday")){
//		list = onlineInformationService.queryYesterdayOnlineInfoPage(name);
//	}else if(time.equals("today")){
//		list = onlineInformationService.queryTodayOnlineInfoPage(name);
//	}
	if(list!=null){
		Gson gson = new Gson();
		String json = gson.toJson(list.size());
		out.print(json);
	}else{
		out.print("null");
	}
}
@RequestMapping("queryOnlineDetailInfo")
public void queryOnlineDetailInfo(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	int eeid = Integer.parseInt(request.getParameter("eeid"));
	OnlineDetailInfo result = onlineInformationService.queryTotalOnlineDetailInfo(eeid);
	if(result != null){
		Gson gson = new Gson();
		String json = gson.toJson(result);
		out.print(json);
	}else{
		out.print("null");
	}
}
@RequestMapping("queryNearlyAWeekOnlineDetailInfo")
public void queryNearlyAWeekOnlineDetailInfo(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	int eeid = Integer.parseInt(request.getParameter("eeid"));
	List<OnlineInformation> list = onlineInformationService.queryNearlyAWeekOnlineDetailInfo(eeid);
	if(list != null){
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
	}else{
		out.print("null");
	}
}
 
@RequestMapping("queryNearlyAWeekWorkDetailInfo")
public void queryNearlyAWeekWorkDetailInfo(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	int eeid = Integer.parseInt(request.getParameter("eeid"));
	List<OnlineInformation> list = onlineInformationService.queryNearlyAWeekWorkDetailInfo(eeid);
	if(list != null){
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
	}else{
		out.print("null");
	}
}

}

