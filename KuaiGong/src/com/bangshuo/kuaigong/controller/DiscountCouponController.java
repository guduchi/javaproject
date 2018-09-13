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

import sun.misc.BASE64Decoder;

import com.bangshuo.kuaigong.po.DiscountCoupon;
import com.bangshuo.kuaigong.po.EmployerMessageById;
import com.bangshuo.kuaigong.po.SendCouponMessage;
import com.bangshuo.kuaigong.service.DiscountCouponService;
import com.bangshuo.kuaigong.service.EmployerUserWalletService;
import com.bangshuo.kuaigong.utils.AliSMS;
import com.bangshuo.kuaigong.utils.JpushClientUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping("discount")
public class DiscountCouponController {
	@Autowired
	DiscountCouponService discountCouponService;
	@Autowired
	EmployerUserWalletService employerUserWalletService;

	@RequestMapping("selectCoupon")
	public void selectWorkAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		DiscountCoupon list=discountCouponService.selectCoupon(id);
		if(list!=null){
			String json = list.getCoupon();
			out.print(json);
		}
		else{
			String json=null;
			out.print(json);
		}
	}

	//查优惠券数
	@RequestMapping("count")
	public void count(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		PrintWriter out=response.getWriter();
		DiscountCoupon list=discountCouponService.selectNum(query);
		if(list!=null){
			String json=list.getCount();
			out.print(json);
		}
		else{
			String json=null;
			out.print(json);
		}
	}

	//查询每个信息中的优惠券
	@RequestMapping("DisCount")
	public void DisCount(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {  
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		List<DiscountCoupon> list=discountCouponService.selectDisCount(id);
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

	//查询每个信息中的优惠券
	@RequestMapping("selectDisCountToUserInfo")
	public void selectDisCountToUserInfo(HttpServletResponse response,HttpServletRequest request)throws ServletException,IOException{
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		PrintWriter out=response.getWriter();
		List<DiscountCoupon> list=discountCouponService.selectDisCountToUserInfo(page, pageSize, id);
		if(list!=null){
			Gson gson=new Gson();
			String json=gson.toJson(list);
			out.print(json);
		}else{
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
		if(query==null || query==""){
			query=null;
		}
		PrintWriter out = response.getWriter();
		List<DiscountCoupon> list = discountCouponService.queryAll(query);
		System.out.println(list);
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
		if(query==null || query==""){
			query=null;
		}
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		page = (page - 1) * pageSize;
		List<DiscountCoupon> list = discountCouponService.selectByPage(query,page,
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
	//修改优惠券
	@RequestMapping("updateByPrimaryKey")
	public void  updateByPrimaryKey(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
        int erid=Integer.parseInt(request.getParameter("erid"));
		String money = request.getParameter("money");
		String status=request.getParameter("status");
		String endtime=request.getParameter("endtime");
		String balance=request.getParameter("balance");
//		EmployerUserWallet employerUserWallet=new EmployerUserWallet();
//		employerUserWallet.setBalance(balance);
//		employerUserWallet.setErid(id);
		int updateWalletMoney = employerUserWalletService.NewupdateWalletMoney(erid,balance);
		DiscountCoupon discountCoupon = new DiscountCoupon();
		discountCoupon.setId(id);
        discountCoupon.setMoney(money);
		discountCoupon.setStatus(status);
		discountCoupon.setEndtime(endtime);
		int num = discountCouponService.updateByPrimaryKeySelective(discountCoupon);
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
	/**
	 * 自动发送优惠卷
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("AutoSendCoupon")
	public void autosend(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		BASE64Decoder decoder = new BASE64Decoder();
		String moneyone=request.getParameter("moneyone");
		String moneythree=request.getParameter("moneythree");
		String moneyfive=request.getParameter("moneyfive");
		String moneylong=request.getParameter("moneylong");
		String longusenumber=request.getParameter("longusenumber");
		SendCouponMessage scm = new SendCouponMessage();
		scm.setMoneyone(moneyone);
		scm.setMoneythree(moneythree);
		scm.setMoneyfive(moneyfive);
		scm.setMoneylong(moneylong);
		scm.setLongusenumber(longusenumber);
		int insertcouponmessage = 0;
		List<SendCouponMessage> selectcouponmessage =discountCouponService.selectSendCouponMessage();
		if(selectcouponmessage.size() > 0){
			scm.setId(1);
			int updatecouponmessage =discountCouponService.updateSendCouponMessage(scm);
			System.out.println(updatecouponmessage);
			}else{
            insertcouponmessage =discountCouponService.insertSendCouponMessage(scm);
            }
		PrintWriter out=response.getWriter();
		if(insertcouponmessage>0){
			Gson gson=new Gson();
			String json=gson.toJson(insertcouponmessage);
			out.print(json);
			}
		else{
			String json=null;
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
		int list = discountCouponService.deleteByPrimaryKey(id);

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
	//发送优惠券
		@RequestMapping("InsertDisCount1")
		public void InsertDisCount(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			response.setContentType("text/html");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			BASE64Decoder decoder = new BASE64Decoder() ;
			String id=request.getParameter("id");
			String[] erid = id.split(",");
			for(int i=0;i<erid.length;i++){
				String money=request.getParameter("money");
				String endtime=request.getParameter("endtime");
				String[] findmoney = money.split(",");
				request.getSession().setAttribute("ss", id);
				EmployerMessageById message = new EmployerMessageById();
				message.setErid(erid[i]);
				List<EmployerMessageById> employerMessageById =discountCouponService.selectEmplyerById(message);
				int list = 0 ; 
				int count =  findmoney.length ;//数量
				for(int j = 0 ; j < findmoney.length ; j++ ){
					DiscountCoupon discountCoupon = new DiscountCoupon();
					discountCoupon.setErid(Integer.parseInt(erid[i]));
					discountCoupon.setMoney(findmoney[j]);//钱数
					discountCoupon.setEndtime(endtime);
					list = discountCouponService.insetToDisCount(discountCoupon);
					
				}
				//看是否存在雇主
				if(employerMessageById.size() > 0){
					for(int j = 0 ; j < employerMessageById.size() ; j++){

						System.out.println(employerMessageById.size());
						String   regid = employerMessageById.get(j).getRegid();
						String   name = employerMessageById.get(j).getName();
						System.out.println("regid="+regid);
						String   usernameemplyor = new String(decoder.decodeBuffer(employerMessageById.get(j).getUsername()), "UTF-8");
						String   usename = new String(decoder.decodeBuffer(name), "UTF-8");

						System.out.println("usernameemplyor="+usernameemplyor);

						if(!"".equals(usernameemplyor)&&usernameemplyor!=null){
	                    
							AliSMS sms = new AliSMS();
							try {
								
								sms.sendDiscountCoupon(usernameemplyor, usename,count+"张", money+"元");
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
	                        if(!"".equals(regid)&&regid!=null&&!regid.equals("exit")){
	                        JpushClientUtil jcl = new JpushClientUtil();
							jcl.sendToRegistrationId(regid,"亲，您的优惠券已到，请您注意查收！", "123456", "123", "");
						}

					}


				}          
				//	

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


	//	public String doubleSpread(String all_select, String now_selected, String no_selected) {  
	//        //获取当前选中的项目加入al  
	//        List al = new ArrayList();  
	//        if(all_select != "" && all_select != null)  
	//        {  
	//            String[] all_select_str = all_select.split(",");  
	//            for(int a=0;a<all_select_str.length;a++)  
	//            {  
	//                al.add(all_select_str[a]);  
	//            }  
	//        }  
	//          
	//        //将当前选中项目加入列表  
	//        if (now_selected != "" && now_selected != null) {  
	//            String[] all_now_select = now_selected.split(",");  
	//            for (int i = 1; i < all_now_select.length; i++) {  
	//                if (!al.contains(all_now_select[i])) {  
	//                    al.add(all_now_select[i]);  
	//                }  
	//            }  
	//        }  
	//          
	//        //将当前未选中项目从列表中删除  
	//        if (no_selected != "" && no_selected != null) {  
	//            String[] all_now_no_select = no_selected.split(",");  
	//            for (int i = 1; i < all_now_no_select.length; i++) {  
	//                if (al.contains(all_now_no_select[i])) {  
	//                    al.remove(all_now_no_select[i]);  
	//                }  
	//            }  
	//        }  
	//          
	//        all_select=al.toString().replaceAll(" +","");;  
	//        all_select=all_select.substring(1,all_select.length()-1)+",";  
	//          
	//        return all_select;  
	//    }  
	//	
	//	
}

