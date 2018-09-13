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
	<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/add.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/login1.js"></script>
<script type="text/javascript" src="js/orderForm.js"></script>
  </head>

<%
 String erid=request.getParameter("erid");
 String oldPage=request.getParameter("page");
 String  newPage=oldPage.split(",")[oldPage.split(",").length-1];
 
%>

<!-- 
<
String id[]=request.getParameterValues("id");
        for (int i = 0;i < id.length;i ++)
        {
          
        }
 %>
 -->
  <body>
<form id="userInfo" method="post">
<input type="hidden" id="id"    name ="id "  value="<%=erid%>">
<input type="hidden" id="page" name="page" value="<%=newPage%>">
<input type="hidden" id="page" name="page" value="<%=newPage%>">
<ul class="userInfo userInfoPre">

<li><pre>优  惠  券：</pre><input type="text" id="money" name="money" class="money query"><br><font color="red" id="f2"></font></li>
<li><pre>到期时间：</pre><input type="date" id="endtime" name="endtime" class="endtime query"><br><font color="red" id="f1"></font></li>
<li><input type="button" id="but"  value="发送" onclick="sendMoney()"></li>
</ul>
</form>
  </body>
</html>
