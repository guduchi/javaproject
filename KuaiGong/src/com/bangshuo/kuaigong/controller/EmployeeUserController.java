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

import com.bangshuo.kuaigong.po.Blacklist;
import com.bangshuo.kuaigong.po.EmployeeUser;
import com.bangshuo.kuaigong.po.EmployerUser;
import com.bangshuo.kuaigong.po.OnlineInformation;

import com.bangshuo.kuaigong.service.BlacklistService;
import com.bangshuo.kuaigong.service.EmployeeUserService;
import com.bangshuo.kuaigong.service.OnlineInformationService;
import com.bangshuo.kuaigong.utils.Base64;
import com.bangshuo.kuaigong.utils.JpushClientUtil;
import com.bangshuo.kuaigong.utils.JpushWokerClientUtil;
import com.bangshuo.kuaigong.utils.SendSMSModle;

import com.google.gson.Gson;

@Controller
@RequestMapping("eeuser")
public class EmployeeUserController {

	@Autowired
	EmployeeUserService employeeUserService;
	
	@Autowired
	BlacklistService blacklistService;
	
	@Autowired
	OnlineInformationService onlineInformationService;

	//短信发送雇主
	@RequestMapping("sendSMS")
	public  void sendSMS(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		  String id=request.getParameter("erid");
		  Base64 base=new Base64();
		
	      String content=request.getParameter("txt");
		  String[] erid = id.split(",");
		
		 
		for(int i=0;i<erid.length;i++){
			  List<EmployeeUser>   list= employeeUserService.selectByusernameOrname(Integer.parseInt(erid[i]));
		 String username=base.decodeBase64(list.get(0).getUsername());
		SendSMSModle sms = new SendSMSModle(username);
	      sms.sendAuthCodeThree(content);
		 if(list.size()>0){
				Gson gson=new Gson();
				String json=gson.toJson(1);
				out.print(json);
			}else{
				String json=erid[i];
				out.print(json);
			
			}
		
		}
		
		
		
	}
	
	//极光发送雇主
	@SuppressWarnings("static-access")
	@RequestMapping("Jpush")
	public  void Jpush(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		  String id=request.getParameter("erid");
		  Base64 base=new Base64();
		
	      String content=request.getParameter("txt");
		  String[] erid = id.split(",");
		
		  int result = 0;
		 
		for(int i=0;i<erid.length;i++){
			
				  
			  
		 List<EmployeeUser> list= employeeUserService.selectEeuseregid(Integer.parseInt(erid[i]));
		if(list.size()>0){
			String   regid = list.get(0).getRegid();
		JpushWokerClientUtil jcl = new JpushWokerClientUtil();
			 result =jcl.sendToRegistrationId(regid.replace("\r\n",""),
					content, "123456", "123", "");
			 if(result>0){
				    Gson gson=new Gson();
					String json=gson.toJson(1);
					out.print(json);
			 }else{
				 String json=erid[i];
					out.print(json);
			}
		}
			
		
		
		}
		
	}
	
	//根据ID查询姓名
	@RequestMapping("selectByusernameOrname")
public void selectByusernameOrname(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		  String id=request.getParameter("erid");
		  List<EmployeeUser> list= employeeUserService.selectByusernameOrname(Integer.parseInt(id));
		  
		  if(list!=null){
			  Gson gson=new Gson();
			  String json=gson.toJson(list);
			  out.print(json);
		  }else{
			  String json="";
			  out.print(json);
		  }
	}
	
	//查询工人工作记录
	@RequestMapping("queryCountMoney")
	public void queryCountMoney(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
	   String id = request.getParameter("id");
	   String starttime = request.getParameter("starttime");
	   String endtime = request.getParameter("endtime");
		if(id == null || id.equals("")){
			id =null;
		}
		if(starttime == null || starttime.equals("")){
			starttime =null;
		}
		if(endtime == null || endtime.equals("")){
			endtime =null;
		}
	EmployeeUser list=employeeUserService.queryCountMoney(id, starttime, endtime);
	if(list!=null){
		String json = list.getWithdrawal();
		out.print(json);
	}
	else{
		String json=null;
		out.print(json);
	}
}
	//查询业务员下的工人个数
	@RequestMapping("salesemployeeuser")
	public void salesemployeeuser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		if(name==null || name==""){
			name=null;
		}
		if(username==null || username==""){
			username=null;
		}
		EmployeeUser list=employeeUserService.salesemployeeuser(id, name, username);
		if(list!=null){
			String json = list.getSalesemployeeuser();
			out.print(json);
		}
		else{
			String json=null;
			out.print(json);
		}
	}
	
	//查询工人个数
	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String eeid = request.getParameter("eeid");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String btu = request.getParameter("btu");
		if(eeid == null || eeid.equals("")){
			eeid =null;
		}
		if(name == null || name.equals("")){
			name =null;
		}
		if(phone == null || phone.equals("")){
			phone =null;
		}
		if(btu == null || btu.equals("") || btu.equals("状态查询")){
			btu =null;
		}
		EmployeeUser list=employeeUserService.selectNum(name, eeid, phone, btu);
		 PrintWriter out = response.getWriter();
 		if (list!=null) {
 			//Gson gson = new Gson();
 			String json =list.getCount();
 			out.print(json);
 		} else {
 			String json = null;
 			out.print(json);
 		}
 	}
		
	//转移
	@RequestMapping("updateSalesmanId")
	public void  updateSalesmanId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
			
		       int id=Integer.parseInt(request.getParameter("id"));
				int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));
			
				EmployeeUser employeeUser = new EmployeeUser();
				employeeUser.setId(id);
			    employeeUser.setSalesmanId(salesmanId);
				int num = employeeUserService.updateSalesmanId(employeeUser);
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
	//修改转移
	@RequestMapping("updateid")
	public void  updateid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));
		
		EmployeeUser employeeUser = new EmployeeUser();
		employeeUser.setId(id);
		employeeUser.setSalesmanId(salesmanId);
		int num = employeeUserService.updateid(employeeUser);
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
	
	//查询业务员管理的工人
	@RequestMapping("selectSalesman")
	public void selectSalesman(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id =Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		if(name==null || name==""){
			name=null;
		}
		if(username==null || username==""){
			username=null;
		}
		 System.out.println("++++++++++++++++++++name"+name);
		 System.out.println("++++++++++++++++++++username"+username);
		 List<EmployeeUser> list=employeeUserService.selectBySalesman(id,name,username);
		 int pageNum=list.size();
		    PrintWriter out=response.getWriter();
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
	//查询业务员管理的工人分页
	@RequestMapping("selectSalesmanPage")
	public void selectSalesmanPage(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		if(name==null || name==""){
			name=null;
		}
		if(username==null || username==""){
			username=null;
		}
		page=(page-1)*pageSize;
		PrintWriter out=response.getWriter();
		  List<EmployeeUser> list=employeeUserService.selectBySalesmanPage(page, pageSize,id,name,username);
		if(list!=null){
			Gson gson=new Gson();
			String json=gson.toJson(list);
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
	}
	
	
	//查看个人收益情况总数
	@RequestMapping("queryshouyi")
	public void queryshouyi(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		int id=Integer.parseInt(request.getParameter("id"));
		List<EmployeeUser> list=employeeUserService.queryshouyi(id,starttime,endtime);
		 int pageNum=list.size();
		    PrintWriter out=response.getWriter();
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
	//查看个人收益情况分页
	@RequestMapping("queryshouyiInfo")
	public void queryshouyiInfo(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		if(starttime==null || starttime==""){
			starttime=null;
		}
		if(endtime==null || endtime==""){
			endtime=null;
		}
		page=(page-1)*pageSize;
		PrintWriter out=response.getWriter();
		  List<EmployeeUser> list=employeeUserService.queryshouyiInfo(id,page,pageSize,starttime,endtime);
		if(list!=null){
			Gson gson=new Gson();
			String json=gson.toJson(list);
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
	}
	
	//��ݸ��״̬ʱ���ѯ��ҳ
			@RequestMapping("queryDatePaGe66")
			public void queryDatePaGe66(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
				response.setContentType("text/html");
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				int id=Integer.parseInt(request.getParameter("id"));
				String btu=request.getParameter("btu");
				int page=Integer.parseInt(request.getParameter("page"));
				int pageSize=Integer.parseInt(request.getParameter("pageSize"));
				String starttime=request.getParameter("starttime");
				String endtime=request.getParameter("endtime");
				page=(page-1)*pageSize;
		    List<EmployeeUser> list=employeeUserService.queryDatePaGe66(starttime, endtime,page,pageSize,btu,id);
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
	
	//��鿴��������
	@RequestMapping("querysouru1")
	public void queryshouru1(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String startime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		  List<EmployeeUser> list= employeeUserService.queryDatashouru1(startime,endtime);
		  request.getSession().setAttribute("startime", startime);
		    request.getSession().setAttribute("endtime", endtime);
		    PrintWriter out=response.getWriter();
		    int pageNum=list.size();
		    if(pageNum>0){
		   	 Gson gson=new Gson();
		   	 String json=gson.toJson(pageNum);
		   	 out.print(json);
		    } else {
		   	 String json=null;
		   	 out.print(json);
		    }
			}
	//�鿴��������
	@RequestMapping("queryshouru")
	public void queryshouru(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String btu=request.getParameter("btu");
		int id=Integer.parseInt(request.getParameter("id"));
		String startime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		  List<EmployeeUser> list= employeeUserService.queryDatashouru(startime, endtime,id,btu);
		  PrintWriter out=response.getWriter();
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
	//�鿴���������ҳ
	@RequestMapping("queryshouruPage")
	public void queryshouruPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String btu=request.getParameter("btu");
		int id=Integer.parseInt(request.getParameter("id"));
		String startime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		page=(page-1)*pageSize;
		 List<EmployeeUser> list= employeeUserService.queryDatashouruPage(startime, endtime, page, pageSize,id,btu);
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
	//���id��ѯ
	@RequestMapping("queryByID")
	public void queryByID(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		List<EmployeeUser> list =employeeUserService.selectByPrimaryKey(id);
		int pageSum=list.size();
		PrintWriter out = response.getWriter();
		if (pageSum > 0) {
				Gson gson = new Gson();
				String json = gson.toJson(pageSum);
				out.print(json);
			} else {
				String json = null;
				out.print(json);
			}
		}
      //���id��ѯ��ҳ
	@RequestMapping("queryByIDPage")
	public void queryByIDPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		PrintWriter out = response.getWriter();
		page = (page - 1) * pageSize;
		List<EmployeeUser> list = employeeUserService.selectByPrimaryPage(page, pageSize, id);
		if (list != null&&list.size()>0) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	//��ģ���ѯ
	@RequestMapping("queryID")
	public void queryID(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String query=request.getParameter("query1");
		request.getSession().setAttribute("ss", query);
		   List<EmployeeUser> list= employeeUserService.selectByName("%"+query+"%");
			int pageNum=list.size();
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
	//查询
		@RequestMapping("queryID1")
		public void queryID1(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String name=request.getParameter("name");
			String eeid = request.getParameter("eeid");
			String phone=request.getParameter("phone");
//			String salesmanName=request.getParameter("salesmanName");
			if(phone == null || phone.equals("")){
				phone =null;
			}
			if(name == null || name.equals("")){
				name =null;
			}
			if(eeid == null || eeid.equals("")){
				eeid =null;
			}
//			if(salesmanName == null || salesmanName.equals("")){
//				salesmanName =null;
//			}
		  String btu=request.getParameter("btu");
		  if(btu==null || btu.equals("") || btu.equals("状态查询")){
			  btu=null;
		  }
		  System.out.println("++++++++++++++name"+name);
		  System.out.println("++++++++++++++eeid"+eeid);
		  System.out.println("++++++++++++++phone"+phone);
//		  System.out.println("++++++++++++++salesmanName"+salesmanName);
			   List<EmployeeUser> list= employeeUserService.selectByName1(name,eeid,phone,btu);//salesmanName);
			//	int pageNum=list.size();
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
	//ģ���ѯ��ҳ
    @RequestMapping("queryIDByPage")
	public void queryIDByPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String eeid = request.getParameter("eeid");
		String phone=request.getParameter("phone");
//		String salesmanName =request.getParameter("salesmanName");
		if(phone == null || phone.equals("")){
			phone =null;
		}
		if(name == null || name.equals("")){
			name =null;
		}
		if(eeid == null || eeid.equals("")){
			eeid =null;
		}
//		if(salesmanName == null || salesmanName.equals("")){
//			salesmanName =null;
//		}
		  String btu=request.getParameter("btu");
		  if(btu==null || btu.equals("") || btu.equals("状态查询")){
			  btu=null;
		  }
		  int page=Integer.parseInt(request.getParameter("page"));
		  int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		
		  page = (page - 1) * pageSize;
		 List<EmployeeUser> list= employeeUserService.selectByNamePage(page, pageSize, name,eeid,phone,btu);//,salesmanName);
		 
		 if (list!=null) {
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
	} else {
		String json = null;
		out.print(json);
	}
}
	 //������
	@RequestMapping("queryUserPage")
	public void queryUserPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		List<EmployeeUser> list = employeeUserService.queryAll();
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
      //�������ҳ
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
		List<EmployeeUser> list = employeeUserService.selectByPage(page,
				pageSize);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
      //��������
	@RequestMapping("queryUserPageMoney")
	public void queryUserPageMoney(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String btu=request.getParameter("btu");
       int id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		List<EmployeeUser> list = employeeUserService.selectAllMoney(id,btu);
		
		if (list.size()>0) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	
	//��ϸ����
	
	@RequestMapping("queryUserPageMoney1")
	public void queryUserPageMoney1(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String btu=request.getParameter("btu");
       int id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		List<EmployeeUser> list = employeeUserService.selectAllMoney1(id,btu);
		int pageNum=list.size();
		if (pageNum!=0) {
			Gson gson = new Gson();
			String json = gson.toJson(pageNum);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	//查询提现条数
	@RequestMapping("queryCount")
	public void queryCount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String btu=request.getParameter("btu");
		int id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		List<EmployeeUser> list = employeeUserService.queryCount(id,btu);
		int pageNum=list.size();
		if (pageNum!=0) {
			Gson gson = new Gson();
			String json = gson.toJson(pageNum);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	
	
	// �����ҳ
	@RequestMapping("queryUserInfoMoney")
	public void queryUserInfoMoney(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String btu=request.getParameter("btu");
		int id=Integer.parseInt(request.getParameter("id"));
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		List<EmployeeUser> list = employeeUserService.selectBYPageMoney(page, pageSize, id,btu);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	//���ܹ�������
	@RequestMapping("queryUserPageWork")
	public void queryUserPageWork(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		List<EmployeeUser> list = employeeUserService.selectByWork(id);
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
	//���������ҳ
	@RequestMapping("queryUserInfoWork")
	public void queryUserInfoWork(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		List<EmployeeUser> list = employeeUserService.selectByPageWork(page, pageSize, id);
		if (list != null&&list.size()>0) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	//��������ʱ��
	@RequestMapping("queryUserPageOnline")
	public void queryUserPageOnline(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		PrintWriter out = response.getWriter();
		List<EmployeeUser> list = employeeUserService.selectAllOnline(id);
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
	//����ʱ���ҳ
	@RequestMapping("queryUserInfoOnline")
	public void queryUserInfoOnline(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		List<EmployeeUser> list = employeeUserService.selectByPaGeOnline(page, pageSize, id);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
		//查询工人详细信息分页
		 @RequestMapping("queryInfoAll")
		  public void  selectAllByPage(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			      response.setContentType("text/html");
			      request.setCharacterEncoding("UTF-8");
			      response.setCharacterEncoding("UTF-8");
			      
		      	PrintWriter out = response.getWriter();
				int id=Integer.parseInt(request.getParameter("id"));
				int page = Integer.parseInt(request.getParameter("page"));
				int pageSize = Integer.parseInt(request.getParameter("pageSize"));
				page = (page - 1) * pageSize;
				List<EmployeeUser> list = employeeUserService.selectAllByPage(page, pageSize, id);
				if (list != null&&list.size()>0) {
					Gson gson = new Gson();
					String json = gson.toJson(list);
					out.print(json);
				} else {
					String json = null;
					out.print(json);
				}
			}
	 	//查询工人详细信息
	  @RequestMapping("selectUserpage")
		public void selectUserpage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			int id=Integer.parseInt(request.getParameter("id"));
			PrintWriter out = response.getWriter();
			List<EmployeeUser> list = employeeUserService.selectUserLocation(id);
			int pageNum=list.size();
		if(pageNum>0){
		        Gson gson = new Gson();
				String json = gson.toJson(pageNum);
				out.print(json);
			} else {
				String json = null;
				out.print(json);
			}
			}
	  
	  //�޸�
	  
	  
	  @RequestMapping("updateByPrimaryKey1")
		public void  updateByPrimaryKey1(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
	       int id=Integer.parseInt(request.getParameter("id"));
			String password = request.getParameter("password");
		
			EmployeeUser employeeUser = new EmployeeUser();
			employeeUser.setId(id);
		    employeeUser.setPassword(password);
			int num = employeeUserService.updateByPrimaryKey1(employeeUser);
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
		   
	  
	  
	@RequestMapping("updateByPrimaryKey")
	public void  updateByPrimaryKey(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
        int id=Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("usernamePash");
	
		String name = request.getParameter("namePash");
		String sex = request.getParameter("sexPash");
		String age = request.getParameter("agePash");

		String address = request.getParameter("addressPash");
	
		String status = request.getParameter("status");
	
		EmployeeUser employeeUser = new EmployeeUser();
		employeeUser.setId(id);
		employeeUser.setUsername(username);
		
		employeeUser.setName(name);
		employeeUser.setSex(sex);
		employeeUser.setAge(age);
		
		employeeUser.setAddress(address);
	
		employeeUser.setStatus(status);
		List<Blacklist> list=blacklistService.queryBlacklist(name);
	     if(list.size()>0){
	     Blacklist deleteList = blacklistService. deleteBalcklist(name);
	     OnlineInformation updateOnline= onlineInformationService.updateOnlineInfomation(id);
	    int num = employeeUserService.updateByPrimaryKey(employeeUser);
		PrintWriter out = response.getWriter();
		if (num > 0) {
			Gson gson = new Gson();
			String json = gson.toJson("1");
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	   
	     }else{
	    	 int num = employeeUserService.updateByPrimaryKey(employeeUser);
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
	     
	}
	   
	//ɾ��
	@RequestMapping("delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		int list = employeeUserService.deleteByPrimaryKey(id);

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

//���ʱ�������ʱ��	
//	@RequestMapping("queryData")
//	public void queryData(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
//		response.setContentType("textml");
//		request.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		
//		String starttime=request.getParameter("starttime");
//		String endtime=request.getParameter("endtime");
//    List<EmployeeUser> list= employeeUserService.queryData(starttime, endtime);
//    PrintWriter out=response.getWriter();
//    if(list!=null){
//   	 Gson gson=new Gson();
//   	 String json=gson.toJson(list);
//   	 out.print(json);
//    }
//    else{
//   	 String json=null;
//   	 out.print(json);
//    }
//	}
//	
	//����ʱ���ѯ����ʱ��
	@RequestMapping("queryDate")
	public void queryDate(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
    List<EmployeeUser> list= employeeUserService.queryDate(starttime, endtime);
    request.getSession().setAttribute("startime", starttime);
    request.getSession().setAttribute("endtime", endtime);
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
	//���ʱ���ѯ��������
	@RequestMapping("queryDate1")
	public void queryDate1(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
    List<EmployeeUser> list= employeeUserService.queryDate1(starttime, endtime,id);
    PrintWriter out=response.getWriter();
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
	
	
	
	//���ʱ���ѯ��ҳ
		@RequestMapping("queryDatePaGe1")
		public void queryDatePaGe1(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int id=Integer.parseInt(request.getParameter("id"));
			int page=Integer.parseInt(request.getParameter("page"));
			int pageSize=Integer.parseInt(request.getParameter("pageSize"));
			String starttime=request.getParameter("starttime");
			String endtime=request.getParameter("endtime");
			page=(page-1)*pageSize;
	    List<EmployeeUser> list= employeeUserService.queryDatePaGe(starttime, endtime,page,pageSize,id);
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
	//���ʱ���ѯ��ҳ
	@RequestMapping("queryDatePaGe")
	public void queryDatePaGe(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		String startime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		page=(page-1)*pageSize;
    List<EmployeeUser> list= employeeUserService.queryDatePaGe(startime, endtime,page,pageSize,id);
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
	//����ʱ���ѯ�ɻ�ʱ��
	@RequestMapping("queryDato")
	public void queryDato(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String startime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		List<EmployeeUser> list= employeeUserService.queryDato(startime, endtime,id);
		 request.getSession().setAttribute("startime", startime);
		    request.getSession().setAttribute("endtime", endtime);
		PrintWriter out=response.getWriter();
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
	//���ʱ���ѯ�ɻ�ʱ��
		@RequestMapping("queryDatoo")
		public void queryDatoo(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int id=Integer.parseInt(request.getParameter("id"));
			String startime=request.getParameter("starttime");
			String endtime=request.getParameter("endtime");
			List<EmployeeUser> list= employeeUserService.queryDato(startime, endtime,id);
			PrintWriter out=response.getWriter();
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
		//���ʱ���ѯ�ɻ�ʱ���ҳ
				@RequestMapping("queryDatooPage")
				public void queryDatooPage(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
					response.setContentType("textml");
					request.setCharacterEncoding("UTF-8");
					response.setCharacterEncoding("UTF-8");
					int id=Integer.parseInt(request.getParameter("id"));
					int page=Integer.parseInt(request.getParameter("page"));
					int pageSize=Integer.parseInt(request.getParameter("pageSize"));
					String startime=request.getParameter("starttime");
					String endtime=request.getParameter("endtime");
					page=(page-1)*pageSize;
					List<EmployeeUser> list= employeeUserService.queryDatooPage(startime, endtime,page,pageSize,id);
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

	//���
	@RequestMapping("register")
	public void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String idcard = request.getParameter("idcard");
		String address = request.getParameter("address");
		String hand = request.getParameter("hand");
		String scan = request.getParameter("scan");
		String portrait = request.getParameter("portrait");
		String status = request.getParameter("status");
		String regid = request.getParameter("regid");
		
		EmployeeUser employeeUser = new EmployeeUser();
		employeeUser.setUsername(username);
		employeeUser.setPassword(password);
		employeeUser.setName(name);
		employeeUser.setSex(sex);
		employeeUser.setAge(age);
		employeeUser.setIdcard(idcard);
		employeeUser.setAddress(address);
		employeeUser.setHand(hand);
		employeeUser.setScan(scan);
		employeeUser.setPortrait(portrait);
		employeeUser.setStatus(status);
		employeeUser.setRegid(regid);

		int result = employeeUserService.insert(employeeUser);
		if (result != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(result);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	 
}