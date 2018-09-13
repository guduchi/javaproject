<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/registerUser.js"></script>
<script type="text/javascript" src="js/text.js"></script>
<script type="text/javascript" src="js/Base64.js"></script>

</head>
    <Style>
  body{
  text-align: center;
  padding: 50px;
  line-height: 30px;
 
 }
 ul {
 list-style-type: none;
 }
 .button{
 background-color: #B8860B;
 }
  </Style>
  <body>
    <form class="register" method="post">
<ul>
    <li>用户名：<input name="username" onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" id="username" type="text" class="loginuser"  onclick="JavaScript:this.value=''"/></li>
    <li>密&nbsp;码：<input name="password" onkeyup="value=value.replace(/[\W]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"  id="password" type="password" class="loginpwd"  onclick="JavaScript:this.value=''"/></li>
    <li><input name="login" type="button" class="button" value="注册"   /></li>
    <div id="result"> </div>
</ul>  
    
    </form>
  </body>
</html>
