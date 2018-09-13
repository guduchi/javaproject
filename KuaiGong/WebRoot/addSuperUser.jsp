<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addSuperUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/Base64.js"></script>
    <script type="text/javascript" src="js/addSuperUser.js"></script>
  </head>
  <Style>
  body{
  text-align: center;
  padding: 50px;
  line-height: 30px;
 
 }
 .button{
 background-color: #B8860B;
 }
  </Style>
  <body>
用户名：<input type=text onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" name="username" id="username"><font id="f1"></font><br>
密&nbsp;码：<input type="password" onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" name="password" id="password"><font id="f2"></font><br>
<input type="button" class="button" value="注册" onclick="addSuperUser()">
  </body>
</html>
