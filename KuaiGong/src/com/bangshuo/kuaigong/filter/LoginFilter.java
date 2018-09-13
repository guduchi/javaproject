package com.bangshuo.kuaigong.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bangshuo.kuaigong.po.User;
import com.bangshuo.kuaigong.po.superUser;



/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    public LoginFilter() {
    	
    }
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String[] url = req.getRequestURL().toString().split("/");
		String liwai = url[url.length-1];
		superUser superuser = (superUser)req.getSession().getAttribute("superuser");
	
		User user = (User)req.getSession().getAttribute("loginUser");
		if(superuser != null || user != null || liwai.equals("login.jsp") || user != null || liwai.endsWith(".css") || liwai.endsWith(".css") || liwai.endsWith(".js") || liwai.endsWith(".png") || liwai.endsWith(".gif") || liwai.endsWith(".action") || liwai.endsWith(".jpg")){
			chain.doFilter(request, response);
		}else{
			res.sendRedirect("/KuaiGong/login.jsp");
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}