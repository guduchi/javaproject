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

import com.bangshuo.kuaigong.po.EmployeeUser;
import com.bangshuo.kuaigong.po.EmployerScale;
import com.bangshuo.kuaigong.po.OnlineInformation;


import com.bangshuo.kuaigong.service.EmployerScaleService;

import com.google.gson.Gson;

@Controller
@RequestMapping("employeeScale")
public class EmployerScaleController {

	@Autowired
	EmployerScaleService emloyeeScaleService;
	
	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		EmployerScale list=emloyeeScaleService.selectNum();
		 if(list!=null){
			 String json=list.getCount();
			 out.print(json);
		 }
		 else{
			 String json=null;
			 out.print(json);
		 }
	}
	
	
	//���ѯ��ҳ����
		@RequestMapping("queryByID")
		public void queryByID1(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String queryScale1=request.getParameter("query");
			List<EmployerScale> list =emloyeeScaleService.queryByID("%" +queryScale1+ "%");
			request.getSession().setAttribute("list", queryScale1);
			PrintWriter out=response.getWriter();
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
		//��ѯ��ҳ����
				@RequestMapping("queryByID1")
				public void queryByID2(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
					response.setContentType("text/html");
					request.setCharacterEncoding("UTF-8");
					response.setCharacterEncoding("UTF-8");
					String queryScale1=request.getParameter("queryScale1");
					List<EmployerScale> list =emloyeeScaleService.queryByID1("%" +queryScale1+ "%");
					PrintWriter out=response.getWriter();
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
	//��ѯ��ҳ
		@RequestMapping("queryByIDPagGe")
		public void queryByIDPagGe(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String queryScale1=request.getParameter("queryScale1");
			int page=Integer.parseInt(request.getParameter("page"));
			int pageSize=Integer.parseInt(request.getParameter("pageSize"));
			page=(page-1)*pageSize;
			List<EmployerScale> list =emloyeeScaleService.queryByIDPagGe(page,pageSize,"%"+queryScale1+"%");
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
	
//��ѯ��������
	@RequestMapping("queryPage")
	public void queryPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		List<EmployerScale> list=emloyeeScaleService.selectPage(id);
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
	
//��ѯ���۷�ҳ
	@RequestMapping("queryByPage")
	public void queryByPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		List<EmployerScale> list =emloyeeScaleService.selectByPage1(id, page, pageSize);
				PrintWriter out=response.getWriter();
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	
	
	
	
	@RequestMapping("queryByid")
	public void queryById(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		 int id=Integer.parseInt(request.getParameter("id"));
		
		List<EmployerScale> list=emloyeeScaleService.selectById(id);
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
	
	@RequestMapping("queryBByID")
	public void queryByID(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
			
			String queryScale1 = request.getParameter("queryScale1");
			
			List<EmployerScale> list = null;
			if (queryScale1 != null) {
				
				 list =emloyeeScaleService.queryById(Integer.parseInt(queryScale1));
				
			}
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
	@RequestMapping("add")
	public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{	
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		int erid = Integer.parseInt(request.getParameter("erid"));
		
		String credits = request.getParameter("credits");
		String presentintegral = request.getParameter("presentintegral");
		
		EmployerScale employerScale = new EmployerScale();
		employerScale.setId(id);
		employerScale.setErid(erid);
	
		employerScale.setCredits(credits);
		employerScale.setPresentintegral(presentintegral);
		
		PrintWriter out = response.getWriter();
		int zz = emloyeeScaleService.insert(employerScale);
		if(zz>0){
		Gson gson = new Gson(); 
		String json = gson.toJson(1);
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
		
	    String credits = request.getParameter("credits");
		String presentintegral = request.getParameter("presentintegral");
		
		EmployerScale employerScale = new EmployerScale();
		employerScale.setId(id);
		
        employerScale.setCredits(credits);
		employerScale.setPresentintegral(presentintegral);
		
		int num = emloyeeScaleService.updateByPrimaryKeySelective(employerScale);
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
			int num = emloyeeScaleService.deleteByPrimaryKey(id);
			
			emloyeeScaleService.deleteByPrimaryKey(id);
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
	 
	 

		@RequestMapping("queryUserPage")
		public void queryUserPage(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
	    
	      String username=request.getParameter("username");
	      if(username==null || username.equals("")){
	    	  username=null;
	      }
		   List<EmployerScale> list =emloyeeScaleService.selectPage1(username);
	   
			PrintWriter out = response.getWriter();
			int pageNum = list.size();
	 
			
			if (pageNum != 0) {
				Gson gson = new Gson();
				String json = gson.toJson(pageNum);
				out.print(json);
			} else {
				String json = null;
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
			String username=request.getParameter("username");
			if(username==null || username.equals("")){
				username=null;
			}
		
			int page = Integer.parseInt(request.getParameter("page"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			page = (page - 1) * pageSize;
			List<EmployerScale> list =emloyeeScaleService.selectByPage(username,page, pageSize);
			System.out.println(list);
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

