<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

  </head>
  
  
  <Style  type="text/css">
#bodyStyle {
text-align:center;
margin-top:20px;
line-height: 50px;
}
a{
text-decoration:none
}
a:link {color:#0000FF;}      
a:hover {color:#FF00FF;}  
 
 
</Style >
<body id="bodyStyle" > 
	
    <a href="revise1.jsp">查询管理员账号</a><br>
    <a href="register.jsp">注册管理员账号</a><br>
    <a href="updeSuperUser.jsp">查询超级管理员账号</a><br>
    <a href="addSuperUser.jsp">注册超级管理员账号</a>
</body>
</html>