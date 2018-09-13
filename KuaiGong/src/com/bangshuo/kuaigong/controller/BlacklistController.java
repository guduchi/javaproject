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

import com.bangshuo.kuaigong.po.Blacklist;
import com.bangshuo.kuaigong.po.OnlineInformation;
import com.bangshuo.kuaigong.service.BlacklistService;
import com.bangshuo.kuaigong.service.EmployeeUserService;
import com.bangshuo.kuaigong.service.EmployerUserService;
import com.bangshuo.kuaigong.service.OnlineInformationService;
import com.bangshuo.kuaigong.utils.Base64;
import com.google.gson.Gson;

@Controller
@RequestMapping("Blacklist")
public class BlacklistController {
@Autowired
BlacklistService blacklistService;
@Autowired
EmployerUserService employerUserService;
@Autowired
EmployeeUserService employeeUserService;
@Autowired
OnlineInformationService onlineInformationService;
@RequestMapping("BlacklistToinsert")
public void insertToBlacklist(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	int id=Integer.parseInt(request.getParameter("id"));
	String name=request.getParameter("name");
	String username=request.getParameter("username");
	String category="6ZuH5Li7";
	//String companyname=request.getParameter("companyname");
	String status="5LiN5Y+v55So";
	
    Base64 base=new Base64();
    String Newusername=base.encryptBase64(username);
    String Newname=base.encryptBase64(name);
    //String Newcompanyname=base.encryptBase64(companyname);
	Blacklist blacklist=new Blacklist();
	blacklist.setName(Newname);
	blacklist.setUsername(Newusername);
	blacklist.setCategory(category);
	//blacklist.setCompanyname(Newcompanyname);
	List<Blacklist> list=blacklistService.selectToBlacklist(Newusername);
	if(list.size()>0){
		Gson gson=new Gson();
		System.out.println("黑名单已存在");
		String json=gson.toJson(2);
		out.print(json);
	}else{
	int updateStatus=employerUserService.updateStatus(Newusername,status);
	
	

	int insertToBlacklist = blacklistService.insertToBlacklist(blacklist);
	if(insertToBlacklist>0){
		Gson gson=new Gson();
		String json=gson.toJson(1);
		out.print(json);
	}else{
		String json=null;
		out.print(json);
	}
	}
}

@RequestMapping("BlacklistToinsertToeeuser")
public void insertToBlacklistToeeuser(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	int id=Integer.parseInt(request.getParameter("id"));
	String name=request.getParameter("name");
	String username=request.getParameter("username");
	String category="5bel5Lq6";
	//String companyname=request.getParameter("companyname");
	String status="不可用";
	String online="完成";
    Base64 base=new Base64();
    String Newusername=base.encryptBase64(username);
    String Newname=base.encryptBase64(name);
    //String Newcompanyname=base.encryptBase64(companyname);
	Blacklist blacklist=new Blacklist();
	blacklist.setName(Newname);
	blacklist.setUsername(Newusername);
	blacklist.setCategory(category);
	//blacklist.setCompanyname(Newcompanyname);
	List<Blacklist> list=blacklistService.selectToBlacklist(Newusername);
	if(list.size()>0){
		Gson gson=new Gson();
		System.out.println("黑名单已存在");
		String json=gson.toJson(2);
		out.print(json);
	}else{
		OnlineInformation updateOnline=onlineInformationService.updateOnline(id,online);
		int updateStatus=employeeUserService.updateStatus(Newusername,status);
		System.out.println("================================="+updateStatus);
	int insertToBlacklist = blacklistService.insertToBlacklist(blacklist);
	if(insertToBlacklist>0){
		Gson gson=new Gson();
		String json=gson.toJson(1);
		out.print(json);
	}else{
		String json=null;
		out.print(json);
	}
	}
}

/**
 * 李博
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 * 查看黑名单总数
 */
@RequestMapping("BlacklistToList")
public void BlacklistToList(HttpServletRequest request,
		HttpServletResponse response)throws ServletException, IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	String query=request.getParameter("query");
	if(query==null || query.equals("")){
		query=null;
	}
	List<Blacklist> list=blacklistService.BlacklistToList(query);
	if(list.size()>0){
		Gson gson=new Gson();
		String json=gson.toJson(list);
		out.print(json);
	}else{
		String json=null;
		out.print(json);
	}
}
/**
 * 李博
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 * 查看黑名单分页
 */
@RequestMapping("BlacklistToListInfo")
public void BlacklistToListInfo(HttpServletRequest request,
		HttpServletResponse response)throws ServletException, IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	String query=request.getParameter("query");
	if(query==null || query.equals("")){
		query=null;
	}
	int page=Integer.parseInt(request.getParameter("page"));
	int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	page=(page-1)*pageSize;
	List<Blacklist> list=blacklistService.BlacklistToListInfo(query,page,pageSize);
	if(list.size()>0){
		Gson gson=new Gson();
		String json=gson.toJson(list);
		out.print(json);
	}else{
		String json=null;
		out.print(json);
	}
}
}
