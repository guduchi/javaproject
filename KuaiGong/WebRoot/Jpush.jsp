<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SendSMS.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	
	
	<script type="text/javascript" src="js/SendSMS.js"></script>
	
	<script type="text/javascript" src="js/jquery.js"></script>
 
  </head>
   <style type="text/css">
  #content{
  text-align: center;
  
  }
  
  </style>
  <%
 String erid=request.getParameter("erid");
 String oldPage=request.getParameter("page");
 String  newPage=oldPage.split(",")[oldPage.split(",").length-1];
 
%>
  <body>
  <form action="">
  
  <input type="hidden" id="id"    name ="id "  value="<%=erid%>">
   <input type="hidden" id="page" name="page" value="<%=newPage%>">
   <textarea cols="50" rows="10" id="content" name="content">在这里输入内容...</textarea>  
  
    <input type="submit" value="重置"  name="reset"/>
      <input type="button" value="确定"  name="submit" onclick="Jpush()"/><br/>  
     </form>
  </body>
</html>
