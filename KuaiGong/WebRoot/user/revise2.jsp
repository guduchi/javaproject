<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'revise1.jsp' starting page</title>
    
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
 

    <script type="text/javascript">
    
    function updateAdmin(){

	var userID=$("#userID").val();
	var cjid=$("#cjid").val();
	var username=$("#username").val();
	//var password=$("#password").val();
	alert(password);
	$.post("user/update.action",{userID:userID,cjid:cjid,username:username,password:password},function(data){
		if(data!=null){
			alert("更新成功!");
			window.location.href="updataUser.jsp";
		}
		else{
			alert("更新失败!");
		}
		
	},"post");
}
 
    </script>
  </head>
  
  <body>
   <%
   String userID=request.getParameter("userID");
   
   String username=request.getParameter("username");
   String password=request.getParameter("password");
   %>
   <form>
  <ul>
   <input type="hidden" id="cjid" value="<%=1%>"/>
    <li><input name="userID" id="userID" type="text" class="userID" value="<%=userID%>" readonly="readonly"/></li>
    <li><input name="username" id="username" type="text" class="loginuser" value="<%=username %>" onclick="JavaScript:this.value=''"/></li><div id="f2"></div>
    <li><input name="password" id="password" type="text" class="loginpwd" value="" onclick="JavaScript:this.value=''"/></li><div id="f4"></div>
    <li><input name="login1" type="button" class="loginbtn1" value="更新" onclick="updateAdmin()"/></li>
    </ul>  
    
   </form>
  </body>
</html>
