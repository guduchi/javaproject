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

import com.bangshuo.kuaigong.po.Appraise;
import com.bangshuo.kuaigong.service.AppraiseService;
import com.google.gson.Gson;

@Controller
@RequestMapping("app")
public class AppraiseController {
	@Autowired
	AppraiseService appraiseService;

	//查询订单下的评价
		@RequestMapping("selectOrderApp")
		public void selectOrderApp(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("id"));
			List<Appraise> list = appraiseService.selectOrderApp(id);
			if (list != null) {
				Gson gson = new Gson();
				String json = gson.toJson(list);
				out.print(json);
			} else {
				String json = null;
				out.print(json);
			}
		}
	
	// 查看每个信息中查看雇主评价
	@RequestMapping("selectStar")
	public void selectStar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		Appraise list = appraiseService.selectStar(id);
		if (list != null) {
			String json = list.getStar();
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	//查询业务员下工人的评价
	@RequestMapping("selectAppCount")
	public void selectAppCount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String ername = request.getParameter("ername");
		String erid = request.getParameter("erid");
		if (ername == null || ername.equals("")) {
			ername = null;
		}
		if (erid == null || erid.equals("")) {
			erid = null;
		}
		Appraise list = appraiseService.selectAppCount(id, ername, erid);
		if(list!=null){
			String json = list.getAppcount();
			out.print(json);
		}else{
			String json = null;
			out.print(json);
		}
	}
	
	// 查询业务员管理的工人评价记录
	@RequestMapping("selectBySalesApp")
	public void selectBySalesApp(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String ername = request.getParameter("ername");
		String erid = request.getParameter("erid");
		if (ername == null || ername.equals("")) {
			ername = null;
		}
		if (erid == null || erid.equals("")) {
			erid = null;
		}
		System.out.println("+++++++++++++++++id" + id);
		System.out.println("+++++++++++++++++erid" + erid);
		System.out.println("+++++++++++++++++ername" + ername);
		List<Appraise> list = appraiseService
				.selectBySalesApp(id, ername, erid);
		int pageNum = list.size();
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

	// 查询业务员管理的工人评价记录分页
	@RequestMapping("selectBySalesAppPage")
	public void selectBySalesAppPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String ername = request.getParameter("ername");
		String erid = request.getParameter("erid");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		if (ername == null || ername.equals("")) {
			ername = null;
		}
		if (erid == null || erid.equals("")) {
			erid = null;
		}
		System.out.println("+++++++++++++++++++++page" + page);
		System.out.println("+++++++++++++++++++++pageSize" + pageSize);
		PrintWriter out = response.getWriter();
		List<Appraise> list = appraiseService.selectBySalesAppPage(page,
				pageSize, id, ername, erid);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	// 查询评价
	@RequestMapping("QueryAll")
	public void QueryAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		List<Appraise> list = appraiseService.QueryUserAll(id);
		int pagnum = list.size();
		PrintWriter out = response.getWriter();
		if (pagnum > 0) {
			Gson gson = new Gson();
			String json = gson.toJson(pagnum);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	// 查询评价条数
	@RequestMapping("queryTheCount")
	public void queryCount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		Appraise list = appraiseService.queryTheCount(id);
		System.out.println("++++++++++++++++++++++++++++++++=======" + list);
		if (list != null) {
			String json = list.getCount();
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	@RequestMapping("QueryUserPaGe")
	public void QueryUserPaGe(HttpServletResponse response,
			HttpServletRequest request) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		PrintWriter out = response.getWriter();
		List<Appraise> list = appraiseService.QueryUserPaGe(page, pageSize, id);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}

	}

	// 查询每个信息中的评价
	@RequestMapping("selectAppraise1")
	public void selectAppraise1(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		List<Appraise> list = appraiseService.selectAppraise9(id);
		PrintWriter out = response.getWriter();
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

	// 查询每个信息中的评价分页
	@RequestMapping("selectAppraisePAGe")
	public void selectAppraisePAGe(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int id = Integer.parseInt(request.getParameter("id"));
		page = (page - 1) * pageSize;
		List<Appraise> list = appraiseService.selectAppraisePAGe(page,
				pageSize, id);
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

	@RequestMapping("updateByPrimaryKey")
	public void updateByPrimaryKey(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		int orderid = Integer.parseInt(request.getParameter("orderid"));
		String starlevel = request.getParameter("starlevel");

		Appraise appraise = new Appraise();
		appraise.setOrderid(orderid);
		appraise.setId(id);
		appraise.setStarlevel(starlevel);

		int num = appraiseService.updateByPrimaryKey(appraise);
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
		int list = appraiseService.deleteByPrimaryKey(id);

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

}