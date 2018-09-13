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

import com.bangshuo.kuaigong.po.EmployerLocation;
import com.bangshuo.kuaigong.service.EmployerLocationService;
import com.google.gson.Gson;

@Controller
@RequestMapping("erlocation")
public class EmployerLocationController {
     
	@Autowired
	EmployerLocationService employerLocationService;
	
	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String query = request.getParameter("query");
		EmployerLocation list=employerLocationService.selectNum(query);
		 if(list!=null){
			 String json=list.getCount();
			 out.print(json);
		 }
		 else{
			 String json=null;
			 out.print(json);
		 }
	}
	
	
	@RequestMapping("queryAllDiTu")
	public void queryAllDiTu1(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<EmployerLocation> list =employerLocationService.queryAllDiTu();
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	
	@RequestMapping("selectNameOrUsername1")
	public void selectNameOrUsername1(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query=request.getParameter("query");
				List<EmployerLocation> list=employerLocationService.selectNameOrUsername1("%"+query+"%");
		int pageSum=list.size();
		 PrintWriter out=response.getWriter();
		 if(pageSum>0){
			 Gson gson=new Gson();
			 String json=gson.toJson(pageSum);
			 out.print(json);
		 }
		 else{
			 String json=null;
			 out.print(json);
		 }
	}
	//ģ���ҳ��ѯ����
	@RequestMapping("selectNameOrUsername")
	public void selectNameOrUsername(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query=request.getParameter("queryPash");
		request.getSession().setAttribute("ss", query);

		List<EmployerLocation> list=employerLocationService.selectNameOrUsername("%"+query+"%");
		int pageSum=list.size();
		 PrintWriter out=response.getWriter();
		 if(pageSum>0){
			 Gson gson=new Gson();
			 String json=gson.toJson(pageSum);
			 out.print(json);
		 }
		 else{
			 String json=null;
			 out.print(json);
		 }
	}
	//ģ���ѯ��ҳ
	@RequestMapping("selectNameOrUsernameByPaGe")
	public void selectNameOrUsernameByPaGe(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int page=Integer.parseInt(request.getParameter("page"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		String query=request.getParameter("query");
		page=(page-1)*pageSize;
 List<EmployerLocation> list=employerLocationService.selectNameOrUsernameByPaGe(page, pageSize, "%"+query+"%","%"+query+"%");
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
	@RequestMapping("queryLocation")
	public void queryLocation(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
	List<EmployerLocation>  list=employerLocationService.selectLocation(id);
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
	@RequestMapping("queryG")
	 public void query2(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{	
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			String queryByid = request.getParameter("queryByid");
			List<EmployerLocation> list = null;
			if (queryByid != null) {
				
				 list = employerLocationService.selectByPrimaryKey(Integer.parseInt(queryByid));
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
		String query=request.getParameter("query");
		if(query == null || query==""){
			query=null;
		}
		
		PrintWriter out = response.getWriter();
		List<EmployerLocation> list =employerLocationService.selectPage(query);

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
		if(query == null || query==""){
			query=null;
		}
	//String test = request.getParameter("page");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		List<EmployerLocation> list = employerLocationService.selectByPage(query,page, pageSize);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	
	
	
	
	
	@RequestMapping("queryW")
	 public void query(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{	
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

			String queryByid = request.getParameter("queryByid");
			List<EmployerLocation> list = null;
			if (queryByid != null) {
				System.out.println(queryByid);
				 list = employerLocationService.selectByPrimaryKey(Integer.parseInt(queryByid));
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
	
	@RequestMapping("add")
	public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{	
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		int erid = Integer.parseInt(request.getParameter("erid"));
		String longitude = request.getParameter("longitude");
	    String latitude=request.getParameter("latitude");
	
		EmployerLocation employerLocation = new EmployerLocation();
		employerLocation.setId(id);
		employerLocation.setErid(erid);
		employerLocation.setLongitude(longitude);
		employerLocation.setLatitude(latitude);
		
		PrintWriter out = response.getWriter();
		int zz = employerLocationService.insert(employerLocation);
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
	     * 修改雇主位置
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
		String latitude = request.getParameter("latitude");
		 
		EmployerLocation employerLocation = new EmployerLocation();
		employerLocation.setId(id);
	
		employerLocation.setLongitude(longitude);
		employerLocation.setLatitude(latitude);
		
		int num = employerLocationService.updateByPrimaryKeySelective(employerLocation);
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
	     * 删除雇主位置
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
			int list = employerLocationService.deleteByPrimaryKey(id);
			
			employerLocationService.deleteByPrimaryKey(id);
			PrintWriter out = response.getWriter();
			if(list>0){
				Gson gson  = new Gson();		
				String json=gson.toJson("1");
				out.print(json);
			}else{
				String json=null;
				out.print(json);
			}
		}
	    /**
	     * 
	     * 根据id经度纬度查询姓名
	     * 
	     * 
	     */
	    @RequestMapping("queryUserInfoLoccation")
	    public void queryUserInfoLoccation(HttpServletRequest request,
				HttpServletResponse response)throws ServletException,IOException{
	    	response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			int erid=Integer.parseInt(request.getParameter("erid"));
			String longitude=request.getParameter("longitude");
			String latitude=request.getParameter("latitude");
			List<EmployerLocation> employerLocation=employerLocationService.queryUserInfoLoccation(erid,longitude,latitude);
	    	if(employerLocation!=null){
	    		Gson gson  = new Gson();		
				String json=gson.toJson(employerLocation);
				out.print(json);
	    	}else{
	    		String json=null;
				out.print(json);
	    	}
	    }
	    }
