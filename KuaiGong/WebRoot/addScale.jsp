 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery.js"></script>
     <script type="text/javascript" src="js/addScale.js"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
	
  </head>
 
  <body >
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="">雇主积分列表</a></li>
    <li>添加积分</li>
    </ul>
    </div>
    <form id="userInfo" method="post">
    
     <ul class="userInfo">
    <li><pre>编    号</pre><input name="id" id="id" type="text" class="query id" value="" onclick="JavaScript:this.value=''"/></li>
    
    <li><pre>雇主编号</pre><input name="erid" id="erid" type="text" class="erid query" value=""  onclick="JavaScript:this.value=''"/><font color="red" id="f1"></font></li>
   
   <li><pre>现 积 分</pre><input name="credits" id="credits" type="text" class="credits query" value="" onclick="JavaScript:this.value=''"/><font color="red" id="f2"></font></li>

    
     <li><pre>总 积 分</pre><input name="presentintegral" id="presentintegral" type="text" class="presentintegral query" value="" onclick="JavaScript:this.value=''"/></li>
    
   
        
    <li><input id="addScale" name="addScale" type="button" class="addScale selectUser" value="添加" onclick="addScale1()"/></li>
    </ul>    
    
    
    </form>
  </body>
</html>
