package com.bangshuo.kuaigong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bangshuo.kuaigong.po.WithdrawDeposit;
import com.bangshuo.kuaigong.service.WithdrawDepositService;
import com.bangshuo.kuaigong.utils.DateCommonUtils;
import com.google.gson.Gson;

@Controller
@RequestMapping("withdraw")
public class WithdrawDepositController {

	@Autowired
	WithdrawDepositService withdrawDepositService;

	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String btu =request.getParameter("btu");
		
		String btu1=null;
		String btu2=null;
		if(btu.equals("null")){
			btu1=null;
			btu2=null;
		}
		else if(btu.contains("&&")){
			btu1=btu.split("&&")[0];
			btu2=btu.split("&&")[1];
		}
		else {
			btu1=btu;
			btu2=btu;
		}
	
		String query = request.getParameter("query");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		if(!starttime.equals("")||!endtime.equals("")){
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleStarttime = new SimpleDateFormat(
					"yyyy-MM-dd 00:00:00");
			SimpleDateFormat simpleEndtime = new SimpleDateFormat(
					"yyyy-MM-dd 23:59:59");
			try {
				starttime = simpleStarttime.format(simple.parse(starttime));
				endtime = simpleEndtime.format(simple.parse(endtime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		if (query == null || query == "") {
			query = null;
		}
		if (starttime == null || starttime == "") {
			starttime =null;
		}
		if (endtime == null || endtime == "") {
			endtime = null;
		}
		if (btu == null || btu.equals("") || btu.equals("null")) {
			btu = null;
		}

		PrintWriter out = response.getWriter();
		WithdrawDeposit list = withdrawDepositService.selectNum(query, btu1,btu2 ,starttime, endtime);
		if (list != null) {
			String json = list.getCount();
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	// 根据状态时间查询分页
	@RequestMapping("queryByTime6ShouYi")
	public void queryByTime6ShouYi(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String btu = request.getParameter("btu");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		PrintWriter out = response.getWriter();
		List<WithdrawDeposit> list = withdrawDepositService.queryByTime6ShouYi(
				starttime, endtime, btu);
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

	// 根据状态时间查询分页
	@RequestMapping("queryByTime6PageShouYi")
	public void queryByTime6PageShouYi(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String btu = request.getParameter("btu");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		PrintWriter out = response.getWriter();
		page = (page - 1) * pageSize;
		List<WithdrawDeposit> list = withdrawDepositService
				.queryByTime6PageShouYi(starttime, endtime, page, pageSize, btu);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	@RequestMapping("queryByTime6")
	public void queryByTime6(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		PrintWriter out = response.getWriter();
		List<WithdrawDeposit> list = withdrawDepositService.queryByTime6(
				starttime, endtime);
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

	@RequestMapping("queryByTime6Page")
	public void queryByTime6Page(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		PrintWriter out = response.getWriter();
		page = (page - 1) * pageSize;
		List<WithdrawDeposit> list = withdrawDepositService.queryByTime6Page(
				starttime, endtime, page, pageSize);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	@RequestMapping("queryWithdraw1")
	public void queryWithdraw1(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		String query = request.getParameter("ID");
		List<WithdrawDeposit>

		list = withdrawDepositService.selectByTime6(starttime, endtime, "%"
				+ query + "%");

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

	@RequestMapping("queryWithdrawPaGe1")
	public void queryWithdrawPaGe1(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		PrintWriter out = response.getWriter();
		List<WithdrawDeposit> list = withdrawDepositService.selectByTime6Page(
				starttime, endtime, "%" + query + "%", page, pageSize);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	// 根据状态查询
	@RequestMapping("queryWithdrawTimeMoHuchaxun")
	public void queryWithdrawTimeMoHuchaxun(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String btu = request.getParameter("btu");
		String query = request.getParameter("query");
		List<WithdrawDeposit> list = null;
		if (query != null) {
			list = withdrawDepositService.queryWithdrawTimeMoHuchaxun("%"
					+ query + "%", btu);
		}
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

	// 根据状态查询
	@RequestMapping("queryWithdrawPaGeTimeMoHuchaxun")
	public void queryWithdrawPaGeTimeMoHuchaxun(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		String btu = request.getParameter("btu");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		PrintWriter out = response.getWriter();
		List<WithdrawDeposit> list = withdrawDepositService
				.queryWithdrawPaGeTimeMoHuchaxun("%" + query + "%", btu, page,
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

	@RequestMapping("queryWithdraw")
	public void queryWithdraw(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		List<WithdrawDeposit> list = null;
		if (query != null) {
			list = withdrawDepositService.queryWithdraw("%" + query + "%");
		}
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

	// ������ֲ�ѯ��ҳ
	@RequestMapping("queryWithdrawPaGe")
	public void queryWithdrawPaGe(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("textml");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		PrintWriter out = response.getWriter();
		List<WithdrawDeposit> list = withdrawDepositService.queryWithdrawPaGe(
				page, pageSize, "%" + query + "%");
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
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
		List<WithdrawDeposit> list = withdrawDepositService.queryWithdraw("%"
				+ query + "%");
		request.getSession().setAttribute("ss", query);
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

	@RequestMapping("queryTime")
	public void queryTime(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String Starttime = request.getParameter("Starttime");
		String endTime = request.getParameter("endTime");
		PrintWriter out = response.getWriter();
		List<WithdrawDeposit> list = withdrawDepositService.queryTime(
				Starttime, endTime);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	@RequestMapping("queryID")
	public void queryID(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String query1 = request.getParameter("query1");
		List<WithdrawDeposit> list = null;
		if (query1 != null) {
			list = withdrawDepositService.selectByBalance("%" + query1 + "%");
		}
		request.getSession().setAttribute("ss", query1);
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

	// 根据状态查询
	@RequestMapping("queryUserPageShouYi")
	public void queryUserPageShouYi(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
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
		if (query == null || query == "") {
			query = null;
		}
		if (starttime == null || starttime == "") {
			starttime = "";
		}
		if (endtime == null || endtime == "") {
			endtime = null;
		}
		String btu = request.getParameter("btu");
		PrintWriter out = response.getWriter();
		List<WithdrawDeposit> list = withdrawDepositService.queryAllShouYi(btu,
				query, starttime, endtime);
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

	@RequestMapping("queryUserInfoShouYi")
	public void queryUserInfoShouYi(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String query = request.getParameter("query");
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
		if (query == null || query == "") {
			query = null;
		}
		if (starttime == null || starttime == "") {
			starttime = "";
		}
		if (endtime == null || endtime == "") {
			endtime = null;
		}
		String btu = request.getParameter("btu");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		List<WithdrawDeposit> list = withdrawDepositService.selectByPageShouYi(
				btu,query,starttime,endtime,page,pageSize);
		if (list != null) {
			Gson gson = new Gson();
			String json = gson.toJson(list);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

	
	//全部收益
		@RequestMapping("queryEarningsAll")
	  public void queryEarningsAll(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			response.setContentType("textml");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out=response.getWriter();
			WithdrawDeposit list = withdrawDepositService.queryEarningsAll();
			if(list!=null){
				String json=list.getQueryEarningsAll();
				out.print(json);
			}else{
				String json=null;
				out.print(json);
			}
			
		}
	
	//根据时间和工人姓名查询收益
	@RequestMapping("selectIncome")
	public void selectIncome(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServerException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String starttime = request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfStart  = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat sdfEnd  = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		
		try {
			starttime = sdfStart.format(sdf.parse(starttime));
			endtime = sdfEnd.format(sdf.parse(endtime));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(name == null || name.equals("")){
			name =null;
		}
		if(starttime == null || starttime.equals("")){
			starttime =null;
		}
		if(endtime == null || endtime.equals("")){
			endtime =null;
		}
		System.out.println("+++++++++++++++++++++name"+name);
		System.out.println("+++++++++++++++++++++starttime"+starttime);
		System.out.println("+++++++++++++++++++++endtime"+endtime);
		List<WithdrawDeposit>list = withdrawDepositService.selectIncome(name, starttime, endtime);
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
		int list = withdrawDepositService.deleteByPrimaryKey(id);

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

	/* 李奎写的代码 */
	/**
	 * 查询昨天的完成提现
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("selectWithdrawByYesterday")
	public void selectWithdrawByYesterday(HttpServletRequest request,
			HttpServletResponse response) throws ServerException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Date nowDate = new Date();
		nowDate.setHours(0);
		nowDate.setMinutes(0);
		nowDate.setSeconds(0);
		Date yesterdayDate = new Date(nowDate.getTime() - 86400000L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(nowDate);
		String yesterday = sdf.format(yesterdayDate);
         String chooseBtu=request.getParameter("chooseBtu");
         if(chooseBtu==null || chooseBtu.equals("null") ||chooseBtu=="null"){
        	 chooseBtu=null;
         }
         String queryUserName=request.getParameter("queryUserName");
         if(queryUserName==null || queryUserName.equals("")){
        	 queryUserName=null;
         }
		List<WithdrawDeposit> list = withdrawDepositService.selectWithdrawDepositByTime(yesterday, now,chooseBtu,queryUserName);
		
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
 * 
 *查询昨天完成的分页
 * 
 * 
 */
	@RequestMapping("selectWithdrawByYesterdayInfo")
	public void selectWithdrawByYesterdayInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServerException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Date nowDate = new Date();
		nowDate.setHours(0);
		nowDate.setMinutes(0);
		nowDate.setSeconds(0);
		Date yesterdayDate = new Date(nowDate.getTime() - 86400000L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(nowDate);
		String yesterday = sdf.format(yesterdayDate);
         String chooseBtu=request.getParameter("chooseBtu");
         if(chooseBtu==null || chooseBtu.equals("null") || chooseBtu=="null"){
        	 chooseBtu=null;
         }
         String queryUserName=request.getParameter("queryUserName");
         if(queryUserName==null || queryUserName.equals("")){
        	 queryUserName=null;
         }
         int page=Integer.parseInt(request.getParameter("page"));
         int pageSize=Integer.parseInt(request.getParameter("pageSize"));
         page=(page-1)*pageSize;
		List<WithdrawDeposit> list = withdrawDepositService.selectWithdrawByYesterdayInfo(yesterday, now,chooseBtu,queryUserName,page,pageSize);
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
	 * 
	 * 查询本周的完成提现分页
	 * 
	 */
	
	@RequestMapping("selectWithdrawByWeekInfo")
	public void selectWithdrawByWeekInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServerException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Map<String, String> map = DateCommonUtils.getWeekDay();
		String now = map.get("sun");
		String oldDate = map.get("mon");
		 String chooseBtu=request.getParameter("chooseBtu");
         if(chooseBtu==null || chooseBtu.equals("null") || chooseBtu=="null"){
        	 chooseBtu=null;
         }
         String queryUserName=request.getParameter("queryUserName");
         if(queryUserName==null || queryUserName.equals("")){
        	 queryUserName=null;
         }
         int page=Integer.parseInt(request.getParameter("page"));
         int pageSize=Integer.parseInt(request.getParameter("pageSize"));
         page=(page-1)*pageSize;
		List<WithdrawDeposit> list = withdrawDepositService
				.selectWithdrawByYesterdayInfo(oldDate, now,chooseBtu,queryUserName,page,pageSize);
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
	 * 查询本周的完成提现
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("selectWithdrawByWeek")
	public void selectWithdrawByWeek(HttpServletRequest request,
			HttpServletResponse response) throws ServerException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Map<String, String> map = DateCommonUtils.getWeekDay();
		String now = map.get("sun");
		String oldDate = map.get("mon");
		 String chooseBtu=request.getParameter("chooseBtu");
         if(chooseBtu==null || chooseBtu.equals("null") || chooseBtu=="null"){
        	 chooseBtu=null;
         }
         String queryUserName=request.getParameter("queryUserName");
         if(queryUserName==null || queryUserName.equals("")){
        	 queryUserName=null;
         }
		List<WithdrawDeposit> list = withdrawDepositService
				.selectWithdrawDepositByTime(oldDate, now,chooseBtu,queryUserName);
	//	System.out.println("============================================="+list.size());
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
	 * 
	 * 
	 * 查询本月的完成提现分页
	 * 
	 * 
	 */
	
	
	@RequestMapping("selectWithdrawByMonthInfo")
	public void selectWithdrawByMonthInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServerException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Map<String, String> map = DateCommonUtils.getMonthDate();
		String now = map.get("monthL");
		String oldDate = map.get("monthF");
		 String chooseBtu=request.getParameter("chooseBtu");
         if(chooseBtu==null || chooseBtu.equals("null") || chooseBtu=="null"){
        	 chooseBtu=null;
         }
         String queryUserName=request.getParameter("queryUserName");
         if(queryUserName==null || queryUserName.equals("")){
        	 queryUserName=null;
         }
         int page=Integer.parseInt(request.getParameter("page"));
         int pageSize=Integer.parseInt(request.getParameter("pageSize"));
         page=(page-1)*pageSize;
		List<WithdrawDeposit> list = withdrawDepositService
				.selectWithdrawByYesterdayInfo(oldDate, now,chooseBtu,queryUserName,page,pageSize);
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
	 * 查询本月的完成提现
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("selectWithdrawByMonth")
	public void selectWithdrawByMonth(HttpServletRequest request,
			HttpServletResponse response) throws ServerException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Map<String, String> map = DateCommonUtils.getMonthDate();
		String now = map.get("monthL");
		String oldDate = map.get("monthF");
		 String chooseBtu=request.getParameter("chooseBtu");
         if(chooseBtu==null || chooseBtu.equals("null") || chooseBtu=="null"){
        	 chooseBtu=null;
         }
         String queryUserName=request.getParameter("queryUserName");
         if(queryUserName==null || queryUserName.equals("")){
        	 queryUserName=null;
         }
		List<WithdrawDeposit> list = withdrawDepositService
				.selectWithdrawDepositByTime(oldDate, now,chooseBtu,queryUserName);
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
	 * 
	 * 查询本年的完成提现分页
	 * 
	 * 
	 * 
	 */
	
	
	@RequestMapping("selectWithdrawByYearInfo")
	public void selectWithdrawByYearInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServerException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Map<String, String> map = DateCommonUtils.getYearDate();
		String now = map.get("yearL");
		String oldDate = map.get("yearF");
		 String chooseBtu=request.getParameter("chooseBtu");
         if(chooseBtu==null || chooseBtu.equals("null") || chooseBtu=="null"){
        	 chooseBtu=null;
         }
         String queryUserName=request.getParameter("queryUserName");
         if(queryUserName==null || queryUserName.equals("")){
        	 queryUserName=null;
         }
         int page=Integer.parseInt(request.getParameter("page"));
	       int pageSize=Integer.parseInt(request.getParameter("pageSize"));
	       page=(page-1)*pageSize;
		List<WithdrawDeposit> list = withdrawDepositService.selectWithdrawByYesterdayInfo(oldDate, now,chooseBtu,queryUserName,page,pageSize);
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
	 * 查询本年的完成提现
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("selectWithdrawByYear")
	public void selectWithdrawByYear(HttpServletRequest request,
			HttpServletResponse response) throws ServerException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Map<String, String> map = DateCommonUtils.getYearDate();
		String now = map.get("yearL");
		String oldDate = map.get("yearF");
		 String chooseBtu=request.getParameter("chooseBtu");
         if(chooseBtu==null || chooseBtu.equals("null") || chooseBtu=="null"){
        	 chooseBtu=null;
         }
         String queryUserName=request.getParameter("queryUserName");
         if(queryUserName==null || queryUserName.equals("")){
        	 queryUserName=null;
         }
		List<WithdrawDeposit> list = withdrawDepositService
				.selectWithdrawDepositByTime(oldDate, now,chooseBtu,queryUserName);
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
		String radio=request.getParameter("radio");
		if(radio=="" || radio=="null"){
			radio=null;
		}
		String btu =request.getParameter("btu");
		String btu1=null;
		String btu2=null;
		if(btu.equals("null")){
			btu1=null;
			btu2=null;
		}
		else if(btu.contains("&&")){
			btu1=btu.split("&&")[0];
			btu2=btu.split("&&")[1];
		}
		else {
			btu1=btu;
			btu2=btu;
		}
		
		String query = request.getParameter("query");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		if(!starttime.equals("")||!endtime.equals("")){
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleStarttime = new SimpleDateFormat(
					"yyyy-MM-dd 00:00:00");
			SimpleDateFormat simpleEndtime = new SimpleDateFormat(
					"yyyy-MM-dd 23:59:59");
			try {
				starttime = simpleStarttime.format(simple.parse(starttime));
				endtime = simpleEndtime.format(simple.parse(endtime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		if (query == null || query == "") {
			query = null;
		}
		if (starttime == null || starttime == "") {
			starttime =null;
		}
		if (endtime == null || endtime == "") {
			endtime = null;
		}
		if (btu == null || btu.equals("") || btu.equals("null")) {
			btu = null;
		}
		int pageNum;
        if(radio!=null){
        	   List<WithdrawDeposit> list = withdrawDepositService.queryAllSort(query,starttime, endtime, btu1,btu2);
        	   pageNum= list.size();
       		if (pageNum != 0) {
       			Gson gson = new Gson();
       			String json = gson.toJson(pageNum);
       			out.print(json);
       		} else {
       			String json = null;
       			out.print(json);
       		}
        }else{
        List<WithdrawDeposit> list = withdrawDepositService.queryAll(query,starttime, endtime, btu1,btu2);
        pageNum= list.size();
		if (pageNum != 0) {
			Gson gson = new Gson();
			String json = gson.toJson(pageNum);
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
        }
	}

	@RequestMapping("queryUserInfo")
	public void queryUserInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String radio=request.getParameter("radio");
		String btu =request.getParameter("btu");
		if(radio=="null" || radio==""){
			radio=null;
		}
		String btu1=null;
		String btu2=null;
		if(btu.equals("null")){
			btu1=null;
			btu2=null;
		}
		else if(btu.contains("&&")){
			btu1=btu.split("&&")[0];
			btu2=btu.split("&&")[1];
		}
		else {
			btu1=btu;
			btu2=btu;
		}
		String query = request.getParameter("query");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		if(!starttime.equals("")||!endtime.equals("")){
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleStarttime = new SimpleDateFormat(
					"yyyy-MM-dd 00:00:00");
			SimpleDateFormat simpleEndtime = new SimpleDateFormat(
					"yyyy-MM-dd 23:59:59");
			try {
				starttime = simpleStarttime.format(simple.parse(starttime));
				endtime = simpleEndtime.format(simple.parse(endtime));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (query == null || query == "") {
			query = null;
		}
		if (starttime == null || starttime == "") {
			starttime =null;
		}
		if (endtime == null || endtime == "") {
			endtime = null;
		}
		if (btu == null || btu.equals("") || btu.equals("null")) {
			btu = null;
		}
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		if(radio != null){
			
			page = (page - 1) * pageSize;
			List<WithdrawDeposit> list = withdrawDepositService.selectByPageInfo(query,
					starttime, endtime,btu1,btu2,page, pageSize);
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
			List<WithdrawDeposit> list = withdrawDepositService.selectByPage(query,
					starttime, endtime, page, pageSize, btu1,btu2);
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

	@RequestMapping("querywithdrawdepositPageShouYi")
	public void querywithdrawdepositPageShouYi(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServerException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String btu =request.getParameter("btu");
	
		String btu1=null;
		String btu2=null;
		if(btu.equals("null")){
			btu1=null;
			btu2=null;
		}
		else if(btu.contains("&&")){
			btu1=btu.split("&&")[0];
			btu2=btu.split("&&")[1];
		}
		else {
			btu1=btu;
			btu2=btu;
		}
	
		String queryusername = request.getParameter("query");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfStart  = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat sdfEnd  = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		try {
			starttime = sdfStart.format(sdf.parse(starttime));
			endtime = sdfEnd.format(sdf.parse(endtime));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(queryusername == null || queryusername.equals("")){
			queryusername =null;
		}
		if(starttime == null || starttime.equals("")){
			starttime =null;
		}
		if(endtime == null || endtime.equals("")){
			endtime =null;
		}
		WithdrawDeposit list = withdrawDepositService.queryusername(queryusername, starttime, endtime, btu1, btu2);
		
		if (list != null) {
			//Gson gson = new Gson();
			String json = list.getQueryCount();
			out.print(json);
		} else {
			String json = null;
			out.print(json);
		}
	}

}
