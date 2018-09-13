<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.bangshuo.kuaigong.utils.Base64" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateSuperUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/Base64.js"></script>
  <script type="text/javascript">
  function updateSuperUser(){
  var id=$("#id").val();
  var username=$("#username").val();
  var flag=true;
  if(username=="" || username=="null"){
  $("#f1").html("请输入用户名");
  flag=false;
  }
  var password=$("#password").val();
  if(password==""||password=="null"){
  $("#f2").html("请输入密码");
  flag=false;
  }
  var  b = new Base64();
  var username= b.encode(username);
  var password = b.encode(password);
  if(flag){
  $.post("superUser/updateSuperUser.action",{id:id,username:username,password:password},function(
  data){
  if (data != null) {
				alert("修改成功！");
					window.location.href="updeSuperUser.jsp";
				}
  		},"json");
  	}
  }
  </script>
  <%
  String id=request.getParameter("id");
  String username=request.getParameter("username");
  String password=request.getParameter("password");
  Base64 b = new Base64();
 %>
  <body>
  <input type="hidden" id="id" value="<%=id%>">
  用户名：<input type="text" name="username" id="username" value=<%=b.decodeBase64(username)%>><font id="f1"></font><br>
 密码：<input type="text" name="password" id="password" value=<%=b.decodeBase64(password) %>><font id="f2"></font><br>
 <input type="submit" value="更新" onclick="updateSuperUser()">
  </body>
</html>
