package com.bangshuo.kuaigong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bangshuo.kuaigong.po.Apply;
import com.bangshuo.kuaigong.service.ApplyService;
import com.google.gson.Gson;

@Controller
@RequestMapping("apply")
public class ApplyController {
	@Autowired
	ApplyService applyService;

	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime = new SimpleDateFormat(
				"yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime = new SimpleDateFormat(
				"yyyy-MM-dd 23:59:59");
		try {
			starttime = simpleStarttime.format(simple.parse(starttime));
			endtime = simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		if (starttime == null || starttime.equals("")) {
			starttime = null;
		}
		if (endtime == null || endtime.equals("")) {
			endtime = null;
		}
		if (username == null || username.equals("")) {
			username = null;
		}
		PrintWriter out = response.getWriter();
		Apply list = applyService.selectNum(username, starttime, endtime);
		if (list != null) {
			String json = list.getCount();
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
		response.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		int list = applyService.deleteApply(id);
		PrintWriter out = response.getWriter();
		if (list > 0) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	// 今日报名总数
	@RequestMapping("selectAllToAll")
	public void selectAllToAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<Apply> list = applyService.selectAllToAll();
		int pageNum = list.size();
		if (pageNum > 0) {
			Gson gson = new Gson();
			String json = gson.toJson(pageNum);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	@RequestMapping("queryApplyPage")
	public void queryApplyPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime = new SimpleDateFormat(
				"yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime = new SimpleDateFormat(
				"yyyy-MM-dd 23:59:59");
		try {
			starttime = simpleStarttime.format(simple.parse(starttime));
			endtime = simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		if (starttime == null || starttime.equals("")) {
			starttime = null;
		}
		if (endtime == null || endtime.equals("")) {
			endtime = null;
		}
		String username = request.getParameter("username");
		if (username == null || username.equals("")) {
			username = null;
		}
		PrintWriter out = response.getWriter();
		List<Apply> list = applyService.selectAll(username, starttime, endtime);
		int pageNum = list.size();
		if (pageNum > 0) {
			Gson gson = new Gson();
			String json = gson.toJson(pageNum);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	// 鏌ヨ鎶ュ悕琛ㄥ垎椤�
	@RequestMapping("queryApplyInfo")
	public void queryApplyInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleStarttime = new SimpleDateFormat(
				"yyyy-MM-dd 00:00:00");
		SimpleDateFormat simpleEndtime = new SimpleDateFormat(
				"yyyy-MM-dd 23:59:59");
		try {
			starttime = simpleStarttime.format(simple.parse(starttime));
			endtime = simpleEndtime.format(simple.parse(endtime));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		if (starttime == null || starttime.equals("")) {
			starttime = null;
		}
		if (endtime == null || endtime.equals("")) {
			endtime = null;
		}
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		if (username == null || username.equals("")) {
			username = null;
		}
		page = (page - 1) * pageSize;
		List<Apply> list = applyService.selectAllPage(username, starttime,
				endtime, page, pageSize);
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