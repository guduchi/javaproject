<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updataLocation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/add.css" rel="stylesheet" type="text/css" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/updateWlocation.js"></script>
  </head>
  <%
    	String id = request.getParameter("id");
    	
    	String longitude = request.getParameter("longitude");
    	
    	String latitude = request.getParameter("latitude");
   %>

    <body>
    	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="">工人位置列表刷新</a></li>
    <li><a href="">修改</a></li>
    </ul>
    </div>
    <form id="userInfo" method="post">
    
     <ul class="userInfo">
    <li><pre>编    号</pre><input name="id" id="id" type="text" class="id query" value="<%=id%>"  readonly="readonly"/></li>
   
  
     
   
   <li><pre>经    度</pre><input name="longitude" id="longitude" type="text" class="longitude query" value="<%=longitude%>" onclick="JavaScript:this.value=''"/><font color="red" id="f4"></font></li>
   
     <li><pre>纬    度</pre><input name="latitude" id="latitude" type="text" class="latitude querys" value="<%=latitude %>" onclick="JavaScript:this.value=''"/></li>
    
   
        
    <li><input id="update" name="update" type="button" class="update selectUser" value="更新" onclick="updateWlocation1()"/></li>
    </ul>    
    
    
    </form>
  </body>
 
</html>
