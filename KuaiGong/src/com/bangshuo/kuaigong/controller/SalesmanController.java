package com.bangshuo.kuaigong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bangshuo.kuaigong.po.Salesman;
import com.bangshuo.kuaigong.service.SalesmanService;
import com.bangshuo.kuaigong.utils.Base64;
import com.bangshuo.kuaigong.utils.FileUploadTool;
import com.google.gson.Gson;

@Controller
@RequestMapping("salesman")
public class SalesmanController {
	@Autowired
	SalesmanService salesmanService;

	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String salesmanName = request.getParameter("salesmanName");
		String username = request.getParameter("username");
		String status = request.getParameter("status");
		String position = request.getParameter("position");
		String superiorId = request.getParameter("superiorId");
		if (id == null || id.equals("")) {
			id = null;
		}
		if (salesmanName == null || salesmanName.equals("")) {
			salesmanName = null;
		}
		if (username == null || username.equals("")) {
			username = null;
		}
		if (status == null || status.equals("") || status.equals("状态查询")) {
			status = null;
		}
		if (position == null || position.equals("")
				|| position.equals("6IGM5Yqh5p+l6K+i")) {
			position = null;
		}
		if (superiorId == null || superiorId.equals("")) {
			superiorId = null;
		}
		Salesman list = salesmanService.selectNum(id, salesmanName, username, status, position, superiorId);
		if (list != null) {
			String json = list.getCount();
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	// 查询详细信息
	@RequestMapping("selectMany")
	public void selectMany(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		List<Salesman> list = salesmanService.selectmany(id);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	// 查询业务员
	@RequestMapping("selectSalesman")
	public void selectSalesman(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String salesmanName = request.getParameter("salesmanName");
		String username = request.getParameter("username");
		String status = request.getParameter("status");
		String position = request.getParameter("position");
		String superiorId = request.getParameter("superiorId");
		if (id == null || id.equals("")) {
			id = null;
		}
		if (salesmanName == null || salesmanName.equals("")) {
			salesmanName = null;
		}
		if (username == null || username.equals("")) {
			username = null;
		}
		if (status == null || status.equals("") || status.equals("状态查询")) {
			status = null;
		}
		if (position == null || position.equals("")
				|| position.equals("6IGM5Yqh5p+l6K+i")) {
			position = null;
		}
		if (superiorId == null || superiorId.equals("")) {
			superiorId = null;
		}
		System.out.println("+++++++++++++++++id" + id);
		System.out.println("+++++++++++++++++salesmanName" + salesmanName);
		System.out.println("+++++++++++++++++username" + username);
		System.out.println("+++++++++++++++++status" + status);
		System.out.println("+++++++++++++++++position" + position);
		List<Salesman> list = salesmanService.selectSalesman(id, salesmanName,
				username, status, position, superiorId);
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

	// 查询业务员分页
	@RequestMapping("selectSalesmanPage")
	public void selectSalesmanPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String salesmanName = request.getParameter("salesmanName");
		String username = request.getParameter("username");
		String status = request.getParameter("status");
		String position = request.getParameter("position");
		String superiorId = request.getParameter("superiorId");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		if (id == null || id.equals("")) {
			id = null;
		}
		if (salesmanName == null || salesmanName.equals("")) {
			salesmanName = null;
		}
		if (username == null || username.equals("")) {
			username = null;
		}
		if (status == null || status.equals("") || status.equals("状态查询")) {
			status = null;
		}
		if (position == null || position.equals("")
				|| position.equals("6IGM5Yqh5p+l6K+i")) {
			position = null;
		}
		if (superiorId == null || superiorId.equals("")) {
			superiorId = null;
		}
		PrintWriter out = response.getWriter();
		List<Salesman> list = salesmanService.selectSalesmanPage(page,
				pageSize, id, salesmanName, username, status, position,
				superiorId);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	// //修改信息
	// @RequestMapping("update")
	// public void update(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	// response.setContentType("text/html");
	// request.setCharacterEncoding("UTF-8");
	// response.setCharacterEncoding("UTF-8");
	//
	// int id=Integer.parseInt(request.getParameter("id"));
	// String username=request.getParameter("username");
	// String password=request.getParameter("password");
	// String salesmanName = request.getParameter("salesmanName");
	// String address = request.getParameter("address");
	// String sex = request.getParameter("sex");
	// int superiorId=Integer.parseInt(request.getParameter("superiorId"));
	// String position = request.getParameter("position");
	// String idCard = request.getParameter("idCard");
	// String status = request.getParameter("status");
	//
	// Salesman salesman = new Salesman();
	// salesman.setId(id);
	// salesman.setUsername(username);
	// salesman.setPassword(password);
	// salesman.setSalesmanName(salesmanName);
	// salesman.setAddress(address);
	// salesman.setSex(sex);
	// salesman.setSuperiorId(superiorId);
	// salesman.setPosition(position);
	// salesman.setIdCard(idCard);
	// salesman.setStatus(status);
	//
	// System.out.println("---------------------id"+id);
	// System.out.println("---------------------username"+username);
	// System.out.println("---------------------password"+password);
	// System.out.println("---------------------salesmanName"+salesmanName);
	// System.out.println("---------------------address"+address);
	// System.out.println("---------------------sex"+sex);
	// System.out.println("---------------------superiorId"+superiorId);
	// System.out.println("---------------------position"+position);
	// System.out.println("---------------------idCard"+idCard);
	// System.out.println("---------------------status"+status);
	// int num = salesmanService.updateByPrimaryKey(salesman);
	// PrintWriter out = response.getWriter();
	// if (num > 0) {
	// Gson gson = new Gson();
	// String json = gson.toJson("1");
	// out.print(json);
	// } else {
	// String json = null;
	// out.print(json);
	// }
	// }

	// 修改信息
	@RequestMapping("update")
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		FileUploadTool ful = new FileUploadTool(request, "img");
		String headPortrait = ful.getParameter("headPortrait");
		int id = Integer.parseInt(ful.getParameter("id"));
		 String username=Base64.encryptBase64(ful.getParameter("username"));
		 String password=Base64.encryptBase64(ful.getParameter("password"));
		 String salesmanName
		 =Base64.encryptBase64(ful.getParameter("salesmanName"));
		 String address = Base64.encryptBase64(ful.getParameter("address"));
		 String sex = Base64.encryptBase64(ful.getParameter("sex"));
//		String username = ful.getParameter("username");
//		String password = ful.getParameter("password");
//		String salesmanName = ful.getParameter("salesmanName");
//		String address = ful.getParameter("address");
//		String sex = ful.getParameter("sex");
		int superiorId = Integer.parseInt(ful.getParameter("superiorId"));
//		String position = ful.getParameter("position");
//		String idCard = ful.getParameter("idCard");
		 String position = Base64.encryptBase64(ful.getParameter("position"));
		 String idCard = Base64.encryptBase64(ful.getParameter("idCard"));
		String status = ful.getParameter("status");

		Salesman salesman = new Salesman();
		salesman.setId(id);
		salesman.setUsername(username);
		salesman.setPassword(password);
		salesman.setSalesmanName(salesmanName);
		salesman.setAddress(address);
		salesman.setSex(sex);
		salesman.setSuperiorId(superiorId);
		salesman.setPosition(position);
		salesman.setHeadPortrait(headPortrait);
		salesman.setIdCard(idCard);
		salesman.setStatus(status);

		int num = salesmanService.updateByPrimaryKey(salesman);
		PrintWriter out = response.getWriter();
		if (num > 0) {
			JOptionPane.showMessageDialog(null, "修改成功");
			response.sendRedirect("../Salesman.jsp");
		} else {
			out.print("");
		}
	}

	// 删除
	@RequestMapping("delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		int list = salesmanService.deleteByPrimaryKey(id);
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

	// @RequestMapping("getAuthCode")
	// public void queryBalance(HttpServletRequest request,HttpServletResponse
	// response) throws ServletException, IOException{
	// response.setContentType("text/html");
	// request.setCharacterEncoding("UTF-8");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter out = response.getWriter();
	// String username = request.getParameter("username");
	// String password = request.getParameter("password");
	// String salesmanName = request.getParameter("salesmanName");
	// String address = request.getParameter("address");
	// String sex = request.getParameter("sex");
	// int superiorId = Integer.parseInt(request.getParameter("superiorId"));
	// String position = request.getParameter("position");
	// String idCard = request.getParameter("idCard");
	// String regid = request.getParameter("regid");
	// String headPortrait = request.getParameter("headPortrait");
	// String regtime = request.getParameter("regtime");
	// String status = request.getParameter("status");
	//
	// Salesman salesmaninsert = new Salesman();
	// salesmaninsert.setUsername(username);
	// salesmaninsert.setPassword(password);
	// salesmaninsert.setSalesmanName(salesmanName);
	// salesmaninsert.setAddress(address);
	// salesmaninsert.setSex(sex);
	// salesmaninsert.setSuperiorId(superiorId);
	// salesmaninsert.setPosition(position);
	// salesmaninsert.setIdCard(idCard);
	// salesmaninsert.setRegid(regid);
	// salesmaninsert.setHeadPortrait(headPortrait);
	// salesmaninsert.setRegtime(regtime);
	// salesmaninsert.setStatus(status);
	// System.out.println("+++++++++++++++++++++++++++++++++++++++username"+username);
	// System.out.println("+++++++++++++++++++++++++++++++++++++++password"+password);
	// System.out.println("+++++++++++++++++++++++++++++++++++++++salesmanName"+salesmanName);
	// System.out.println("+++++++++++++++++++++++++++++++++++++++address"+address);
	// System.out.println("+++++++++++++++++++++++++++++++++++++++sex"+sex);
	// System.out.println("+++++++++++++++++++++++++++++++++++++++superiorId"+superiorId);
	// System.out.println("+++++++++++++++++++++++++++++++++++++++position"+position);
	// System.out.println("+++++++++++++++++++++++++++++++++++++++idCard"+idCard);
	// System.out.println("+++++++++++++++++++++++++++++++++++++++regid"+regid);
	// System.out.println("+++++++++++++++++++++++++++++++++++++++regtime"+regtime);
	// System.out.println("+++++++++++++++++++++++++++++++++++++++status"+status);
	// Salesman salesman = salesmanService.selectByUsername(username);
	// if(salesman!=null){
	// out.print("null");
	// }else{
	// int result=salesmanService.insert(salesman);
	// if (result != 0) {
	// Gson gson = new Gson();
	// String json = gson.toJson(result);
	// out.print(json);
	// } else {
	// String json = null;
	// out.print(json);
	// }
	// }
	// }

	// //注册业务员
	// @RequestMapping("register")
	// public void register(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// response.setContentType("text/html");
	// request.setCharacterEncoding("UTF-8");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter out = response.getWriter();
	//
	// String username = request.getParameter("username");
	// String password = request.getParameter("password");
	// String salesmanName = request.getParameter("salesmanName");
	// String address = request.getParameter("address");
	// String sex = request.getParameter("sex");
	// int superiorId = Integer.parseInt(request.getParameter("superiorId"));
	// String position = request.getParameter("position");
	// String idCard = request.getParameter("idCard");
	// String regid = request.getParameter("regid");
	// String headPortrait = request.getParameter("headPortrait");
	// // String regtime = request.getParameter("regtime");
	// String status = request.getParameter("status");
	//
	// Salesman salesman = new Salesman();
	// salesman.setUsername(username);
	// salesman.setPassword(password);
	// salesman.setSalesmanName(salesmanName);
	// salesman.setAddress(address);
	// salesman.setSex(sex);
	// salesman.setSuperiorId(superiorId);
	// salesman.setPosition(position);
	// salesman.setIdCard(idCard);
	// salesman.setRegid(regid);
	// salesman.setHeadPortrait(headPortrait);
	// salesman.setStatus(status);
	//
	// int result=salesmanService.insert(salesman);
	// if (result != 0) {
	// Gson gson = new Gson();
	// String json = gson.toJson(result);
	// out.print(json);
	// } else {
	// String json = null;
	// out.print(json);
	// }
	// }
	// 注册业务员
	@RequestMapping("register")
	public void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		FileUploadTool ful = new FileUploadTool(request, "img");
		String headPortrait = ful.getParameter("headPortrait");
		 String username=Base64.encryptBase64(ful.getParameter("username"));
		 String password=Base64.encryptBase64(ful.getParameter("password"));
		 String salesmanName=Base64.encryptBase64(ful.getParameter("salesmanName"));
		 String address = Base64.encryptBase64(ful.getParameter("address"));
		 String sex = Base64.encryptBase64(ful.getParameter("sex"));
//		String username = ful.getParameter("username");
//		String password = ful.getParameter("password");
//		String salesmanName = ful.getParameter("salesmanName");
//		String address = ful.getParameter("address");
//		String sex = ful.getParameter("sex");
		int superiorId = Integer.parseInt(ful.getParameter("superiorId"));
//		String position = ful.getParameter("position");
//		String idCard = ful.getParameter("idCard");
		 String position = Base64.encryptBase64(ful.getParameter("position"));
		 String idCard = Base64.encryptBase64(ful.getParameter("idCard"));
		String status = ful.getParameter("status");

		Salesman salesman = new Salesman();
		salesman.setUsername(username);
		salesman.setPassword(password);
		salesman.setSalesmanName(salesmanName);
		salesman.setAddress(address);
		salesman.setSex(sex);
		salesman.setSuperiorId(superiorId);
		salesman.setPosition(position);
		salesman.setIdCard(idCard);
		salesman.setHeadPortrait(headPortrait);
		salesman.setStatus(status);

		int num = salesmanService.insert(salesman);
		PrintWriter out = response.getWriter();
		if (num > 0) {
			JOptionPane.showMessageDialog(null, "注册成功");
			response.sendRedirect("../Salesman.jsp");
		} else {
			out.print("");
		}
	}

	// @RequestMapping("uploadHandPortrait")
	// public void uploadHandPortrait(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// response.setContentType("text/html");
	// request.setCharacterEncoding("UTF-8");
	// response.setCharacterEncoding("UTF-8");
	//
	// FileUploadTool ful = new FileUploadTool(request,"img");
	// String headPortrait = ful.getParameter("headPortrait");
	// int id = Integer.parseInt(request.getParameter("id"));
	//
	// Salesman salesman = new Salesman();
	// salesman.setHeadPortrait(headPortrait);
	// salesman.setId(id);
	// int num = salesmanService.insert(salesman);
	// PrintWriter out = response.getWriter();
	// if (num > 0) {
	// out.print("success");
	//
	// } else {
	// out.print("");
	// }
	// }

}