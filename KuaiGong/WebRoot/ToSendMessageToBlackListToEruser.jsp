<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ToSendMessageToBlackList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/ToSendMessageToBlackListToEruser.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<style>

</style>
  </head>
  
  <body>
  <form action="">
   雇主拒单次数： <input type="text" name="Count"  id="Count"><br>
 <input type="button" name="Count" value="提交" onclick="QueryCount()">
 <input type="submit" value="重置">
   </form>
      </body>
</html>
