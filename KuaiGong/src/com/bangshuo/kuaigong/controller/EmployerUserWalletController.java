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
import com.bangshuo.kuaigong.po.EmployerUserWallet;
import com.bangshuo.kuaigong.service.EmployerUserWalletService;
import com.google.gson.Gson;

@Controller
@RequestMapping("wallet1")
public class EmployerUserWalletController {
	@Autowired
	EmployerUserWalletService employerUserWalletService;

	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		PrintWriter out=response.getWriter();
		EmployerUserWallet list=employerUserWalletService.selectNum(name);
		if (list!=null) {
 			//Gson gson = new Gson();
 			String json =list.getCount();
 			out.print(json);
 		} else {
 			String json = null;
 			out.print(json);
 		}
 	}
	
	
	@RequestMapping("chongzhi1")
	public void chongzhi(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String query = request.getParameter("query");
		PrintWriter out = response.getWriter();
		int list = employerUserWalletService.chongzhi11(id, query);
		if (list > 0) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
/**
 * 查询个人的雇主钱包总数
 * @param request
 * @param response
 * @throws IOException
 * @throws ServletException
 */
	@RequestMapping("selectQueryWalletByid")
	public void selectQueryWalletByid(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		List<EmployerUserWallet> list = employerUserWalletService.selectQueryWalletByid(id);
		int pageNum=list.size();
		if(pageNum > 0){
			Gson gson=new Gson();
			String json=gson.toJson(pageNum);
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
		
	}
	
	/**
	 * 查询个人的雇主钱包总数分页
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping("selectQueryWalletByidPage")
	public void selectQueryWalletByidPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		page=(page-1)*pageSize;
		List<EmployerUserWallet> list = employerUserWalletService.selectQueryWalletByidPage(id,page,pageSize);
		
		if(list.size() > 0){
			Gson gson=new Gson();
			String json=gson.toJson(list);
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
		
	}
	
	
	
	@RequestMapping("selectQueryWallet")
	public void selectQueryWallet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int pageNum;
		String radio=request.getParameter("radio");
		if(radio==null || radio.equals("")){
			radio=null;
		}
		String id=request.getParameter("id");
		if(id==null || id.equals("")){
			id=null;
		}
		String name=request.getParameter("name");
		if(name==null || name.equals("")){
			
			name=null;
		}
		if(radio != null){
			List<EmployerUserWallet> list = employerUserWalletService.selectByWalletSort(name);
			pageNum = list.size();
			if (pageNum > 0) {
				Gson gson = new Gson();
				String json = gson.toJson(pageNum);
				out.print(json);
			} else {
				String json = null;
				out.print(json);
			}
		}else{
		List<EmployerUserWallet> list = employerUserWalletService.selectByWallet(name);
		pageNum = list.size();
		if (pageNum > 0) {
			Gson gson = new Gson();
			String json = gson.toJson(pageNum);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
		}
	}

	@RequestMapping("selectQueryWalletPage")
	public void selectQueryWalletPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
        String radio=request.getParameter("radio");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		String id=request.getParameter("id");
		if(radio==null || radio.equals("")){
			radio=null;
		}
		if(id==null || id.equals("")){
			id=null;
		}
		String name=request.getParameter("name");
		if(name==null || name.equals("")){
			
			name=null;
		}
		if(radio != null){
			page = (page - 1) * pageSize;
			PrintWriter out = response.getWriter();
			List<EmployerUserWallet> list = employerUserWalletService.selectByWalletPageInfo(page, pageSize,name);
			if (list != null) {
				Gson gson = new Gson();
				String json = gson.toJson(list);
				out.print(json);
			} else {
				String json = null;
				out.print(json);
			}
		}else{
		page = (page - 1) * pageSize;
		PrintWriter out = response.getWriter();
		List<EmployerUserWallet> list = employerUserWalletService.selectByWalletPage(page, pageSize,name);
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

	// 模糊查询
	@RequestMapping("MoHuChaXun")
	public void MoHuChaXun(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		PrintWriter out = response.getWriter();
		List<EmployerUserWallet> list = employerUserWalletService
				.MoHuChaXun("%" + query + "%");
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

	// 模糊查询分页
	@RequestMapping("MoHuChaXunPaGe")
	public void MoHuChaXunPaGe(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		List<EmployerUserWallet> list = employerUserWalletService
				.MoHuChaXunPaGe(page, pageSize, "%" + query + "%");
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
	@RequestMapping("updateWallet")
	public void updateWallet(HttpServletRequest request,
			HttpServletResponse response)throws IOException, ServletException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String balance=request.getParameter("balance");
		
		EmployerUserWallet employerUserWallet=new EmployerUserWallet();
		
		employerUserWallet.setId(id);
		employerUserWallet.setBalance(balance);
	int list=employerUserWalletService.updateWalletMoney(employerUserWallet);
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
}