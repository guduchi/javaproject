<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@page import="com.bangshuo.kuaigong.utils.Base64"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'intercalate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />

  </head>
<%	
Base64 b=new Base64();

 %>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li><a href="index.jsp">首页</a></li>
	    </ul>
	</div>
 
  <a class="selectUser" href=updataUser.jsp?name=<%=session.getAttribute("name")%>>查询账号</a><br>
</body>
</html>
