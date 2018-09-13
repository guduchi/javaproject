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

import com.bangshuo.kuaigong.po.User;
import com.bangshuo.kuaigong.po.cjUser;
import com.bangshuo.kuaigong.service.cjUserService;
import com.google.gson.Gson;

@Controller
@RequestMapping("cjUser")
public class cjUserController {
	@Autowired
	cjUserService cjuserservice;

	@RequestMapping("login")
	public void logincjUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		cjUser cjuser = new cjUser();
		cjuser.setUsername(username);
		cjuser.setPassword(password);

		cjUser list = cjuserservice.login(cjuser);

		request.getSession().setAttribute("loginUser", cjuser);
		request.getSession().setAttribute("name", username);
		PrintWriter out = response.getWriter();
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	@RequestMapping("CJqueryUserPage")
	public void queryUserPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		List<User> list = cjuserservice.selectPage();
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

	@RequestMapping("CJqueryUserInfo")
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
		List<User> list = cjuserservice.selectByPage(page, pageSize);

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