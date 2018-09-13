<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CunKuan.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />

<script type="text/javascript" src="js/text.js"></script>
<script type="text/javascript" src="js/chonzhi.js"></script>


<script type="text/javascript" src="js/jquery.js"></script>
  </head>
<%
  String id=request.getParameter("id");
  String page1=request.getParameter("page");
%>
  <body>
  <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>	
    <li><a href="employeeuser.jsp?page=<%=page1%>">工人列表</a></li>
    <li>充值</li>
    </ul>
    </div>
  <form action="" id="userInfo">
 	<input type="hidden" id="id" value="<%=id%>" />
 		<input type="hidden" id="page" value="<%=page1%>" />
 	<div class="passText">金额</div>
 	<ul class="userInfo ">
		  <li><input name="query" id = "query"  type="text" class="query quee" onload="queryUser(1)"  value="" /><font color="red" id="f2" ></font></li>
		  <li><input type="button"  id="update"  onclick="ChongZhi()" class="selectUser"  value="工人充值"/></li>
 	 </ul>
  </form>
  </body>
</html>

