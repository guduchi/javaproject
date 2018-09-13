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



import com.bangshuo.kuaigong.po.Blacklist;
import com.bangshuo.kuaigong.po.EmployerUser;
import com.bangshuo.kuaigong.service.BlacklistService;
import com.bangshuo.kuaigong.service.EmployerUserService;
import com.bangshuo.kuaigong.utils.Base64;
import com.bangshuo.kuaigong.utils.JpushClientUtil;
import com.bangshuo.kuaigong.utils.JpushWokerClientUtil;
import com.bangshuo.kuaigong.utils.SendSMSModle;
import com.google.gson.Gson;

@Controller
@RequestMapping("euser")
public class EmployerUserController {

	@Autowired
	EmployerUserService employerUserService; 
	@Autowired
	BlacklistService blacklistService;
	
	//查询姓名和用户名
	@RequestMapping("selectByusernameOrname")
	public void selectByusernameOrname(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		  String id=request.getParameter("erid");
		  System.out.println("================="+id);
		  List<EmployerUser> list= employerUserService.selectByusernameOrname(Integer.parseInt(id));
		  
		  if(list!=null){
			  Gson gson=new Gson();
			  String json=gson.toJson(list);
			  out.print(json);
		  }else{
			  String json="";
			  out.print(json);
		  }
	}
	
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
			  List<EmployerUser>   list= employerUserService.employerUserUsername(Integer.parseInt(erid[i]));
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
		  int a=0;
		for(int i=0;i<erid.length;i++){
		 List<EmployerUser> list= employerUserService.employerUserUsername(Integer.parseInt(erid[i]));
		if(list.size()>0){
			String   regid = list.get(0).getRegid();
		JpushClientUtil jcl = new JpushClientUtil();
		 result = jcl.sendToRegistrationId(regid.replace("\r\n",""),content, "123456", "123", "");
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
	
	//查询雇主人数
	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String erid = request.getParameter("erid");
		String name = request.getParameter("un");
		String username = request.getParameter("us");
		String btu = request.getParameter("btu");
		if(erid == null || erid.equals("")){
			erid =null;
		}
		if(name == null || name.equals("")){
			name =null;
		}
		if(username == null || username.equals("")){
			username =null;
		}
		if(btu == null || btu.equals("") || btu.equals("54q25oCB5p+l6K+i")){
			btu =null;
		}
		 EmployerUser list=employerUserService.selectNum(name, username, erid, btu);
		 PrintWriter out=response.getWriter();
			if (list!=null) {
	 			//Gson gson = new Gson();
	 			String json =list.getCount();
	 			out.print(json);
	 		} else {
	 			String json = null;
	 			out.print(json);
	 		}
	 	}
	

	//查询
		@RequestMapping("selectByAll")
		public void selectByAll(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String btu=request.getParameter("btu");
			String erid = request.getParameter("erid");
			String name=request.getParameter("un");
			String username= request.getParameter("us");
			if(erid == null || erid.equals("")){
				erid =null;
			}
			
			if(name == null || name.equals("")){
				name =null;
			}
			if(username == null || username.equals("")){
				username =null;
			}
			if(btu==null || btu.equals("") || btu.equals("54q25oCB5p+l6K+i")){
				btu=null;
			}
			
			   List<EmployerUser> list= employerUserService.selectByAll(name,username, erid,btu);
				//int pageNum=list.size();
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
		
		// 查询分页
		@RequestMapping("selectByAllPage")
		public void selectByAllPage(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out = response.getWriter();
			String btu=request.getParameter("btu");
			String erid = request.getParameter("erid");
			String name=request.getParameter("un");
			String username=request.getParameter("us");
			if(erid == null || erid.equals("")){
				erid =null;
			}
			if(name == null || name.equals("")){
				name =null;
			}
			if(username == null || username.equals("")){
				username =null;
			}
			if(btu==null || btu.equals("") || btu.equals("54q25oCB5p+l6K+i") ){
				btu=null;
			}
			  int page=Integer.parseInt(request.getParameter("page"));
			  request.getSession().setAttribute("page",page);
			  int pageSize=Integer.parseInt(request.getParameter("pageSize"));
			  page = (page - 1) * pageSize;
			 List<EmployerUser> list= employerUserService.selectByAllPage(page, pageSize, name,username,erid,btu);
			 if (list!=null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	
	//��ѯ����
	@RequestMapping("selectPWD")
public void selectPWD(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		
		List<EmployerUser> list=employerUserService.selectPWD(id);
		
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
	//��������
	@RequestMapping("updataPWD")
	public void updataPWD(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("passwordPash");
		EmployerUser employerUser = new EmployerUser();
		employerUser.setId(id);
		employerUser.setPassword(password);
	int list=employerUserService.updataPWD(employerUser);
	
	PrintWriter out=response.getWriter();
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
	
	
@RequestMapping("InsertDisCount")
	public void InsertDisCount(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{

	
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
  
	String money=request.getParameter("money");
	 int list= employerUserService.insetToDisCount(money);
 PrintWriter out=response.getWriter();
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
	
	
	
	
@RequestMapping("queryByID")
public void queryByID(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
		
		int id=Integer.parseInt(request.getParameter("id"));
		List<EmployerUser> list = null;
		if (id >0) {
			
			 list =  employerUserService.selectByPrimaryKey(id);
		
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
	


	
	
	
	
	//ģ���ѯ
	@RequestMapping("queryID")
	
	public void queryID(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String query = request.getParameter("query");
		List<EmployerUser> list = null;
		if (query != null) {
			 list =  employerUserService.selectByUsernmaeOrName("%" + query + "%");
		
		}
		
		PrintWriter out = response.getWriter();
		int pageNum=list.size();
		if (pageNum > 0) {
			Gson gson = new Gson();
			String json = gson.toJson(pageNum);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}
	
	//ģ���ѯ
	@RequestMapping("MHqueryUserPaGe")
	public void MHqueryUserPaGe(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
  int page=Integer.parseInt(request.getParameter("page"));
  int pageSize=Integer.parseInt(request.getParameter("pageSize"));
  String query=request.getParameter("query");
  PrintWriter out = response.getWriter();
  page = (page - 1) * pageSize;
 List<EmployerUser> list= employerUserService.MHselectEmployerUser(page, pageSize, "%" +query+"%","%"+query+"%");
  if (list != null) {
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
		List<EmployerUser> list = employerUserService.queryAll();
		
		System.out.println(list);
		
		int pagenum = list.size();
		if (pagenum != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(pagenum);
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
		List<EmployerUser> list = employerUserService.selectByPage(page,
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

	@RequestMapping("register")
	public void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String companyname = request.getParameter("companyname");
		String name = request.getParameter("name");
		String shielc = request.getParameter("shielc");
		String status = request.getParameter("status");
		EmployerUser employerUser = new EmployerUser();
	
		employerUser.setUsername(username);
		employerUser.setPassword(password);
		employerUser.setName(name);
		employerUser.setCompanyname(companyname);
		employerUser.setShielc(shielc);
		employerUser.setStatus(status);
		
		
		
		int result = employerUserService.insert(employerUser);
		if (result != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(result);
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
		String requestData=request.getParameter("requestData");
		int id = Integer.parseInt(requestData.split("&&")[0]);
		String username=requestData.split("&&")[1];
		String name=requestData.split("&&")[2];
		String companyname = requestData.split("&&")[3];
		String status = requestData.split("&&")[4];
		String grade = requestData.split("&&")[5];
	
		EmployerUser employerUser = new EmployerUser();
		employerUser.setId(id);
		employerUser.setUsername(username);
		employerUser.setCompanyname(companyname);
		employerUser.setName(name);
        employerUser.setStatus(status);
        employerUser.setGrade(grade);
        List<Blacklist> list=blacklistService.queryBlacklist(name);
	     if(list.size()>0){
	    Blacklist deleteList = blacklistService. deleteBalcklist(name);
		int num = employerUserService.updateByPrimaryKey(employerUser);
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
	    	 int num = employerUserService.updateByPrimaryKey(employerUser);
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

	@RequestMapping("delete")
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		int list = employerUserService.deleteByPrimaryKey(id);

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


//查询详细信息
@RequestMapping("selectUserpage")
public void selectUserpage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	int id=Integer.parseInt(request.getParameter("id"));
	PrintWriter out = response.getWriter();
	List<EmployerUser> list = employerUserService.selectUserLocation(id);
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
//查询详细信息分页
@RequestMapping("selectLocationPaGe")
public void selectLocationPaGe(HttpServletResponse response,HttpServletRequest request)throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
	int id=Integer.parseInt(request.getParameter("id"));
	int page=Integer.parseInt(request.getParameter("page"));
	int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	page=(page-1)*pageSize;
	List<EmployerUser> list=employerUserService.selectUserLocationPaGe(page, pageSize, id);
	
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

@RequestMapping("selectLocation")
public void selectLocation(HttpServletResponse response,HttpServletRequest request)throws ServletException,IOException{
	response.setContentType("text/html");
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out=response.getWriter();
	List<EmployerUser> list =employerUserService.selectByPageLocation();
	
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




