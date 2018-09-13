package com.bangshuo.kuaigong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bangshuo.kuaigong.po.superUser;
import com.bangshuo.kuaigong.service.superUserService;
import com.bangshuo.kuaigong.utils.Base64;
import com.google.gson.Gson;


@Controller
@RequestMapping("superUser")
public class superUserController {
@Autowired
superUserService superuserService;
@RequestMapping("superLogin")
public void superLogin(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	 String index_code=request.getParameter("index_code");
		String sessionCode=(String) session.getAttribute("code");
		if(!sessionCode.equals(index_code.toUpperCase())){
		Gson gson=new Gson();
		String json=gson.toJson(2);
		out.print(json);
		}else{
		}
	String username=request.getParameter("usernamepash");
	String password=request.getParameter("passwordpash");
	superUser superuser=new superUser();
	superuser.setUsername(username);
	superuser.setPassword(password);
	
	String ss=Base64.decodeBase64(username);
	String bb=Base64.decodeBase64(password);
	request.getSession().setAttribute("name", ss);
    request.getSession().setAttribute("password",bb);
    request.getSession().setAttribute("superuser", superuser);
	superUser list=superuserService.superLogin(superuser);
	if(list!=null){
		Gson gson=new Gson();
		String json=gson.toJson(6);
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
	
	
	PrintWriter out = response.getWriter();
	List<superUser> list =superuserService.selectPage();
	System.out.println(list);
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
	
	int page = Integer.parseInt(request.getParameter("page"));
	int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	page = (page - 1) * pageSize;
	List<superUser> list =superuserService.selectByPage(page, pageSize);
			
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

@RequestMapping("updateSuperUser")
public void updateSuperUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	int id=Integer.parseInt(request.getParameter("id"));
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	PrintWriter out=response.getWriter();
	
	superUser superuser=new superUser();
	superuser.setId(id);
	superuser.setUsername(username);
	superuser.setPassword(password);
	int list=superuserService.updateSuperUser(superuser);
	if(list>0){
		Gson gson=new Gson();
		String json=gson.toJson(1);
		out.print(json);
	}else{
		String json=null;
		out.print(json);
	}
}
@RequestMapping("deleteSuperUser")
public void deleteSuperUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
	int id=Integer.parseInt(request.getParameter("id"));
	int list=superuserService.deleteSuperUser(id);
	if(list>0){
		Gson gson=new Gson();
		String json=gson.toJson(1);
		out.print(json);
	}else{
		String json=null;
		out.print(json);
	}
}
@RequestMapping("addSuperUser")
public void addSuperUser(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	response.setContentType("textml");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
   String username=request.getParameter("usernamePash");
   String password=request.getParameter("passwordPash");
   superUser superuser=new superUser();
   superuser.setUsername(username);
   superuser.setPassword(password);
   List<superUser> list=superuserService.selectSuperUser(username);
   if(list.size()>0){
	   String ss="用户名已被注册";
	   Gson gson=new Gson();
	   String json=gson.toJson(ss);
	 out.print(json);
	
   }
   else{
	
	   int list1=superuserService.addSuperUser(superuser);
	   if(list1>0){
		   Gson gson=new Gson();
		   String json=gson.toJson(list1);
		   out.print(json);
	   }else{
		   String json=null;
		   out.print(json);
	   }
   }
}

}