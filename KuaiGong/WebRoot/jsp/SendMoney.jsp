<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SendMoney.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/login1.js"></script>
<script type="text/javascript" src="js/orderForm.js"></script>
  </head>
<!--  
<%
 String id=request.getParameter("id");
%>
-->
<!-- 
<
String id[]=request.getParameterValues("id");
 

        for (int i = 0;i < id.length;i ++)
        {
          
        }
 %>
 -->
  <body>
<form action="">
<input 	type="hidden" id="id" value="<%=id%>">
优&nbsp;&nbsp;惠&nbsp;&nbsp;券：<div><input type="text" id="money" name="money"><br><font color="red" id="f2"></font></div>
结束时间：<div><input type="date" id="endtime" name="endtime"><br><font color="red" id="f1"></font></div>
<input type="button" id="but" value="发送" onclick="sendMoney()">
</form>
  </body>
</html>
