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

import com.bangshuo.kuaigong.po.EmployeeLocation;
import com.bangshuo.kuaigong.service.EmployeeLocationService;
import com.google.gson.Gson;

@Controller
@RequestMapping("eelocation")
public class EmployeeLocationController {
	
	@Autowired
	EmployeeLocationService employeeLocationService;
	
	
	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String query = request.getParameter("query");
		EmployeeLocation list=employeeLocationService.selectNum(query);
		 if(list!=null){
			 String json=list.getCount();
			 out.print(json);
		 }
		 else{
			 String json=null;
			 out.print(json);
		 }
	}
	
//	查询工人状态和地图
	@RequestMapping("queryAllDiTu")
	public void queryAllDiTu(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
		List<EmployeeLocation> list = employeeLocationService.queryAllDiTu();
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	   @RequestMapping("queryUserInfoLoccation")
	    public void queryUserInfoLoccation(HttpServletRequest request,
				HttpServletResponse response)throws ServletException,IOException{
	    	response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			int eeid=Integer.parseInt(request.getParameter("eeid"));
			String longitude=request.getParameter("longitude");
			String latitude=request.getParameter("latitude");
			List<EmployeeLocation> employerLocation=employeeLocationService.queryUserInfoLoccation(eeid,longitude,latitude);
	    	if(employerLocation!=null){
	    		Gson gson  = new Gson();
				String json=gson.toJson(employerLocation);
				out.print(json);
	    	}else{
	    		String json=null;
				out.print(json);
	    	}
	    }
	
	//ģ���ѯ��ҳ����
	@RequestMapping("eeselectNameORusername1")
	public void selectNameORusername1(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query=request.getParameter("query");
		PrintWriter out = response.getWriter();
		List<EmployeeLocation> list=employeeLocationService.eeselectNameORusername1("%"+query+"%");
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
	//ģ���ѯ��ҳ
	@RequestMapping("selectNameORusernamepage")
	public void selectNameORusernamepage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query=request.getParameter("query");
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		page=(page-1)*pageSize;
		PrintWriter out=response.getWriter();
		List<EmployeeLocation> list=employeeLocationService.selectNameORusernamepage(page, pageSize, "%"+query+"%",  "%"+query+"%");
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
	
	//��ģ���ѯ��ҳ����
	@RequestMapping("selectNameORusername")
	public void selectNameORusername(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query=request.getParameter("query1");
		request.getSession().setAttribute("ss", query);
		PrintWriter out = response.getWriter();
		List<EmployeeLocation> list=employeeLocationService.selectNameORusername("%"+query+"%");
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
	
	@RequestMapping("queryUserPage")
	public void queryUserPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query=request.getParameter("query");
		if(query == null || query ==""){
			query=null;
		}
		PrintWriter out = response.getWriter();
		List<EmployeeLocation> list =employeeLocationService.selectPage(query);

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
		String query=request.getParameter("query");
		if(query == null || query ==""){
			query=null;
		}
	
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		List<EmployeeLocation> list = employeeLocationService.selectByPage(query,page, pageSize);
				
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	@RequestMapping("queryG")
	 public void query(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{	
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			String query = request.getParameter("query");
			List<EmployeeLocation> list = employeeLocationService.selectByPrimaryKey("%"+query+"%");
		
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
	/**
	 * 添加工人位置
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("add")
	public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{	
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		int eeid = Integer.parseInt(request.getParameter("eeid"));
		String longitude = request.getParameter("longitude");
		String latiude = request.getParameter("latiude");
		
		EmployeeLocation list = new EmployeeLocation();
		list.setId(id);
		list.setEeid(eeid);
		list.setLongitude(longitude);
		list.setLatitude(latiude);
		
		PrintWriter out = response.getWriter();
		int zz = employeeLocationService.insert(list);
		if(zz>0){
		Gson gson = new Gson(); 
		String json = gson.toJson(1);
		out.print(json);
		}else{
			String json = null;
			out.print(json);
		}
}         
	    /**
	     * 修改工人位置
	     * @param request
	     * @param response
	     * @throws ServletException
	     * @throws IOException
	     */
	    @RequestMapping("update")
	    public void update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{	
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
          
		int id = Integer.parseInt(request.getParameter("id"));
	
	String longitude = request.getParameter("longitude");
	String latitude=request.getParameter("latitude");
		
		EmployeeLocation list = new EmployeeLocation();
		list.setId(id);

		list.setLongitude(longitude);
		list.setLatitude(latitude);
		
		int num = employeeLocationService.updateByPrimaryKeySelective(list);
        PrintWriter out = response.getWriter();
		if(num>0){
			Gson gson  = new Gson();		
			String json=gson.toJson("1");
			out.print(json);
		}else{
			String json=null;
			out.print(json);
		}
	}    
	    /**
	     * 删除工人位置
	     * @param request
	     * @param response
	     * @throws ServletException
	     * @throws IOException
	     */
	    @RequestMapping("delete")
		public void delete(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			int id = Integer.parseInt(request.getParameter("id"));
			int num = employeeLocationService.deleteByPrimaryKey(id);
			
			employeeLocationService.deleteByPrimaryKey(id);
			PrintWriter out = response.getWriter();
			if(num>0){
				Gson gson  = new Gson();		
				String json=gson.toJson("1");
				out.print(json);
			}else{
				String json=null;
				out.print(json);
			}
		}
	    }