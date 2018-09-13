package com.bangshuo.kuaigong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.net.www.content.text.plain;

import com.bangshuo.kuaigong.po.EmployerUser;
import com.bangshuo.kuaigong.po.User;
import com.bangshuo.kuaigong.service.UserService;
import com.bangshuo.kuaigong.utils.Base64;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;
	
	
		@RequestMapping("selectByID")
		public void selectByID(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		PrintWriter out=response.getWriter();
		List<User> list=userService.selectByID(name);
		if(list!=null){
			Gson gson=new Gson();
			String json=gson.toJson(list);
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
	}
	
		@RequestMapping("login")
		public void login(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{	
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
		
		String username=request.getParameter("usernamepash");
		String password=request.getParameter("passwordpash");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User list=userService.login(user);
		Base64 b=new Base64();
	   
	   String ss=b.decodeBase64(username);
	   request.getSession().setAttribute("loginUser", user);
	   request.getSession().setAttribute("name",ss);
	   request.getSession().setAttribute("password", user.getId());
	 
		if(list!=null){
			Gson gson  = new Gson();	
			String json=gson.toJson(1);
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
	}
	
	
		}

	@RequestMapping("register")
	public void register(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//int cjid=Integer.parseInt(request.getParameter("cjid"));
		String requestData=request.getParameter("requestData");
		String username=requestData.split("&&")[0];
		String password=requestData.split("&&")[1];
		User user=new User();
		//user.setCjid(cjid);
		user.setUsername(username);
		user.setPassword(password);
		
		List<User> list=userService.selectByusername(user);
		
		PrintWriter out=response.getWriter();
		if(list.size()>0){
			JOptionPane.showMessageDialog(null, "用户名已存在");  
		}
		else{
		int num=userService.insertSelective(user);
        if(num>0){
			Gson gson=new Gson();
			String json=gson.toJson(num);
			out.print(json);
		}
		else{
			String  json=null;
			out.print(json);
		}
		}
	}
@RequestMapping("delete")
public void delete(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("utf-8");
	int id=Integer.parseInt(request.getParameter("userID"));
	//request.getSession().setAttribute("id", id);
    int list= userService.deleteUser(id);
    PrintWriter out=response.getWriter();
    if(list>0){
    	Gson gson=new Gson();
    	String json=gson.toJson(list);
    	out.print(json);
    }else{
    	String json=null;
    	out.print(json);
    }
}

@RequestMapping("update")
public void update (HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{ 
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("utf-8");
int id=Integer.parseInt(request.getParameter("id"));
//int cjid=Integer.parseInt(request.getParameter("cjid"));
  // System.out.println(cjid);
	String username=request.getParameter("usernamePash");
 
    
   String password=request.getParameter("passwordPash");
	
   User user=new User();
	user.setId(id);
//	user.setCjid(cjid);
	user.setUsername(username);
	user.setPassword(password);

	int list=userService.updateUser(user);
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



@RequestMapping("queryUserById")
public void queryUserById(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
	String query=request.getParameter("query");
	List<User> list=userService.selectById("%"+query+"%");
	if(list!=null){
		Gson gson=new Gson();
		String json=gson.toJson(list);
		out.print(json);
	}
	else{
		String json="";
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
	List<User> list =userService.selectPage();
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
	String test = request.getParameter("page");
	int page = Integer.parseInt(request.getParameter("page"));
	int pageSize = Integer.parseInt(request.getParameter("pageSize"));
	page = (page - 1) * pageSize;
	List<User> list =userService.selectByPage(page, pageSize);
			
			
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
