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

import com.bangshuo.kuaigong.po.SalesmanSignIn;
import com.bangshuo.kuaigong.po.SalesmanWallet;
import com.bangshuo.kuaigong.service.SalesmanWalletService;
import com.google.gson.Gson;


@Controller
@RequestMapping("sales")

public class SalesmanWalletContorller {
	@Autowired
	SalesmanWalletService salesmanWalletService;
	
	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String salesmanName = request.getParameter("salesmanName");
		String username = request.getParameter("username");
		if(salesmanName == null || salesmanName.equals("")){
			salesmanName =null;
		}
		if(username == null || username.equals("")){
			username =null;
		}
		SalesmanWallet list=salesmanWalletService.selectNum(salesmanName,username);
		 if(list!=null){
			 String json=list.getCount();
			 out.print(json);
		 }
		 else{
			 String json=null;
			 out.print(json);
		 }
	}
	
	//查询业务员钱包
		@RequestMapping("selectSalesmanWallet")
		public void selectSalesman(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		
			String salesmanName = request.getParameter("salesmanName");
			String username = request.getParameter("username");
			if(salesmanName == null || salesmanName.equals("")){
				salesmanName =null;
			}
			if(username == null || username.equals("")){
				username =null;
			}
			System.out.println("+++++++++++++++++salesmanName"+salesmanName);
			System.out.println("+++++++++++++++++username"+username);
			List<SalesmanWallet>list = salesmanWalletService.selectWallet(salesmanName, username);
			  int pageNum=list.size();
				PrintWriter out = response.getWriter();
				if (pageNum > 0){
					Gson gson = new Gson();
					String json = gson.toJson(pageNum);
					out.print(json);
				} else {
					String json = null;
					out.print(json);
				}
			}
		 	//查询业务员钱包分页
			@RequestMapping("selectSalesmanWalletPage")
			public void selectSalesmanPage(HttpServletRequest request, HttpServletResponse response)
					throws IOException, ServletException {
				response.setContentType("textml");
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				
				String salesmanName = request.getParameter("salesmanName");
				String username = request.getParameter("username");
				int page=Integer.parseInt(request.getParameter("page"));
				int pageSize=Integer.parseInt(request.getParameter("pageSize"));
				page = (page - 1) * pageSize;
				if(salesmanName == null || salesmanName.equals("")){
					salesmanName =null;
				}
				if(username == null || username.equals("")){
					username =null;
				}
				PrintWriter out =response.getWriter();
				List<SalesmanWallet>list = salesmanWalletService.selectWalletPage(page, pageSize, salesmanName, username);
				 if (list!=null) {
						Gson gson = new Gson();
						String json = gson.toJson(list);
						out.print(json);
					} else {
						String json = null;
						out.print(json);
					}
				}
			//修改业务员钱包
			@RequestMapping("update")
			public void  update(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				response.setContentType("text/html");
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				
				int id = Integer.parseInt(request.getParameter("id"));
				double  balance=Double.parseDouble(request.getParameter("balance"));
				SalesmanWallet salesmanWallet = new SalesmanWallet();
				salesmanWallet.setId(id);
				salesmanWallet.setBalance(balance);
				 System.out.println("---------------------id"+id);
				 System.out.println("---------------------balance"+balance);
				int list = salesmanWalletService.updateBalance(salesmanWallet);
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
			//删除
			@RequestMapping("delete")
			public void delete(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				response.setContentType("text/html");
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");

				int id = Integer.parseInt(request.getParameter("id"));
				int list = salesmanWalletService.deleteByPrimaryKey(id);

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
