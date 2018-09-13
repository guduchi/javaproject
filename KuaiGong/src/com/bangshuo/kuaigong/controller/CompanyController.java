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

import com.bangshuo.kuaigong.po.Company;
import com.bangshuo.kuaigong.po.EmployeeUser;
import com.bangshuo.kuaigong.service.CompanyService;
import com.google.gson.Gson;
@Controller
@RequestMapping("companyname")
public class CompanyController {
	@Autowired
	CompanyService companyService;
	
	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String query = request.getParameter("query");
		Company list=companyService.selectNum(query);
		 if(list!=null){
			 String json=list.getCount();
			 out.print(json);
		 }
		 else{
			 String json=null;
			 out.print(json);
		 }
	}
	
	//查询
	@RequestMapping("queryAll")
	public void queryAll(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query=request.getParameter("query");
		if(query==null || query.equals("")){
			query=null;
		}
		PrintWriter out = response.getWriter();
		List<Company> list = companyService.selectAll(query);
		int pageNum=list.size();
		if (pageNum > 0) {
			Gson gson = new Gson();
			String json = gson.toJson(pageNum);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	  //查询分页
	@RequestMapping("queryAllPage")
	public void queryAllPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query=request.getParameter("query");
		if(query==null || query.equals("")){
			query=null;
		}
		PrintWriter out = response.getWriter();
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		List<Company> list = companyService.selectAllPage(query,page, pageSize);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	
	//查询名字
	@RequestMapping("CompanynameMoHuChaXun")
	public void CompanynameMoHuChaXun(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String query=request.getParameter("query");
		   List<Company> list= companyService.selectName("%"+query+"%");
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
	  
	//查询名字分页
	@RequestMapping("CompanynameMoHuChaXunPage")
	public void CompanynameMoHuChaXunPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String query =request.getParameter("query");
		  int page=Integer.parseInt(request.getParameter("page"));
		  int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		  page = (page - 1) * pageSize;
		 List<Company> list= companyService.selectNamePage(page, pageSize, "%" +query+"%");
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
	//删除
	@RequestMapping("delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		int list = companyService.deleteByPrimaryKey(id);

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
	/*
	 * 修改
	 */
	@RequestMapping("updateByPrimaryKey")
	public void  updateByPrimaryKey(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
       int id=Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String principal = request.getParameter("principal");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String content = request.getParameter("content");
		
		Company company = new Company();
		company.setId(id);
		company.setName(name);
		company.setPrincipal(principal);
		company.setTel(tel);
		company.setAddress(address);
		company.setContent(content);
		
		System.out.println("++++++++++++++++++++name"+name);
		System.out.println("++++++++++++++++++++principal"+principal);
		System.out.println("++++++++++++++++++++tel"+tel);
		System.out.println("++++++++++++++++++++address"+address);
		System.out.println("++++++++++++++++++++content"+content);
		
		int num = companyService.updateByPrimaryKey(company);
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
	
}
