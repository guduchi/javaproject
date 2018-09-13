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

import com.bangshuo.kuaigong.po.EmployeeUser;
import com.bangshuo.kuaigong.po.Wallet;
import com.bangshuo.kuaigong.service.WalletService;
import com.google.gson.Gson;

@Controller
@RequestMapping("wallet")
public class WalletController {
	
	@Autowired
	WalletService walletService;	
	//查询出个人钱包
	@RequestMapping("selectWorkerWalletPage")
	public void selectWorkerWalletPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		List<Wallet> list=walletService.selectWorkerWalletPage(id);
		int pageNum=list.size();
		if(pageNum>0){
			Gson gson=new Gson();
			String json=gson.toJson(pageNum);
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
	}
	//查询出跟人钱包分页
	@RequestMapping("selectWorkerWalletInfo")
	public void selectWorkerWalletInfo(HttpServletResponse response,HttpServletRequest request)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		page=(page-1)*pageSize;
		List<Wallet> list=walletService.selectWorkerWalletInfo(id,page,pageSize);
		if(list != null){
			Gson gson=new Gson();
			String json=gson.toJson(list);
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
	}
	//查询钱包条数
	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		 Wallet list=walletService.selectNum(name);
		 PrintWriter out=response.getWriter();
		 if (list!=null) {
	 			String json =list.getCount();
	 			out.print(json);
	 		} else {
	 			String json = null;
	 			out.print(json);
	 		}
	 	}
	
	
	
	@RequestMapping("chongzhi")
	public void chongzhi(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String query = request.getParameter("query");
		PrintWriter out=response.getWriter();
		int list =walletService.chongzhi(id,query);
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
	//��ݹ�������ģ���ѯ
		@RequestMapping("selectByName")
		public void selectByName(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String query = request.getParameter("query");
		PrintWriter out=response.getWriter();
		List<Wallet> list =walletService.selectByName("%" + query + "%");
		 int pageNum=list.size();
		  if(pageNum>0){
			  Gson gson=new Gson();
			  String json=gson.toJson(pageNum);
			  out.print(json);
		  }
		  else{
			  String json=null;
			  out.print(json);
		  }
			}
		//��ݹ�������ģ���ѯ��ҳ
		@RequestMapping("selectByNamePage")
		public void selectByNamePage(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	 
		String  query = request.getParameter("query");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page=(page-1)*pageSize;
		PrintWriter out=response.getWriter();
		List<Wallet> list=walletService.selectByNamePage(page, pageSize, "%" + query + "%");
		if(list!=null){
			Gson gson=new Gson();
			String json=gson.toJson(list);
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
	}
		@RequestMapping("query")
		public void query(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String query = request.getParameter("ID");
			request.getSession().setAttribute("ss", query);
			List<Wallet>  list =null; 
			if(query!=null){
				list= walletService.selectByName("%" + query + "%");
			}
			
			PrintWriter out = response.getWriter();
			if (list.size() > 0) {
				Gson gson = new Gson();
				String json = gson.toJson(list);
				out.print(json);
			} else {
				String json = null;
				out.print(json);
			}
		}

	//���ʱ��β�ѯȡǮ��¼
	@RequestMapping("queryData")
	public void queryData(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
     List<Wallet> list= walletService.queryData(starttime, endtime);
     PrintWriter out=response.getWriter();
     if(list!=null){
    	 Gson gson=new Gson();
    	 String json=gson.toJson(list);
    	 out.print(json);
     }
     else{
    	 String json=null;
    	 out.print(json);
     }
	}
	/**
	 * 查询工人钱包列表
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping("queryWalletAll")
	public void queryWalletAll(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	String radio=request.getParameter("radio");
	String Newradio=request.getParameter("Newradio");
	int pageNum;
	if(radio==null || radio.equals("")){
		radio=null;
	}
	if(Newradio==null || Newradio.equals("")){
		Newradio=null;
	}
	String name=request.getParameter("name");
	if(name==null || name.equals("")){
		name=null;
	}
	if(radio != null){
		List<Wallet> list=walletService.querybalance(name);
		PrintWriter out=response.getWriter();
		   pageNum=list.size();
		  if(pageNum>0){
			  Gson gson=new Gson();
			  String json=gson.toJson(pageNum);
			  out.print(json);
		  }
		  else{
			  String json=null;
			  out.print(json);
		  }
	}else if(Newradio != null){
	
   List<Wallet> list=walletService.Newquerybalance(name);
	PrintWriter out=response.getWriter();
	   pageNum=list.size();
	  if(pageNum>0){
		  Gson gson=new Gson();
		  String json=gson.toJson(pageNum);
		  out.print(json);
	  }
	  else{
		  String json=null;
		  out.print(json);
	  }
	}
	
	else{
List<Wallet> list=walletService.selectpageAll(name);
PrintWriter out=response.getWriter();
   pageNum=list.size();
  if(pageNum>0){
	  Gson gson=new Gson();
	  String json=gson.toJson(pageNum);
	  out.print(json);
  }
  else{
	  String json=null;
	  out.print(json);
  }
	}
	}
	@RequestMapping("queryPaGeAll")
	public void queryPaGeAll(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		String radio=request.getParameter("radio");
		String Newradio=request.getParameter("Newradio");
		if(Newradio==null || Newradio.equals("")){
			Newradio=null;
		}
		if(radio==null || radio.equals("")){
			radio=null;
		}
		if(name==null || name.equals("")){
			name=null;
		}
		if(radio != null){
			page=(page-1)*pageSize;
			PrintWriter out=response.getWriter();
			List<Wallet> list=walletService.querybalanceInfo(page, pageSize,name);
			if(list!=null){
				Gson gson=new Gson();
				String json=gson.toJson(list);
				out.print(json);
			}else{
				String json=null;
				out.print(json);
			}
		}else if(Newradio != null){
				page=(page-1)*pageSize;
				   List<Wallet> list=walletService.NewquerybalanceInfo(page, pageSize,name);
					PrintWriter out=response.getWriter();
					  
					  if(list!=null){
						  Gson gson=new Gson();
						  String json=gson.toJson(list);
						  out.print(json);
					 }
		}else{
		page=(page-1)*pageSize;
		PrintWriter out=response.getWriter();
		List<Wallet> list=walletService.selectPaGe(page, pageSize,name);
		if(list!=null){
			Gson gson=new Gson();
			String json=gson.toJson(list);
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
		}
	}
	
	
	
	@RequestMapping("queryID")
	public void queryID(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String query = request.getParameter("query");
		List<Wallet> list = null;
		if (query != null) {
			 list = walletService.selectByBalance("%" + query + "%");
		}
		PrintWriter out = response.getWriter();
		if (list.size() > 0) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
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
		List<Wallet> list = walletService.queryAll();
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
		List<Wallet> list = walletService.selectByPage(page,pageSize);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
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
		int list = walletService.deleteByPrimaryKey(id);

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
	@RequestMapping("updateWallet")
	public void updateWallet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
//		String username=request.getParameter("username");
//		String name=request.getParameter("name");
		String balance=request.getParameter("balance");
	//	String residue=request.getParameter("residue");
		PrintWriter out=response.getWriter();
		Wallet wallet=new Wallet();
		wallet.setId(id);
		wallet.setBalance(balance);
	    //wallet.setResidue(residue);
		int list=walletService.updateWallet(wallet);
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