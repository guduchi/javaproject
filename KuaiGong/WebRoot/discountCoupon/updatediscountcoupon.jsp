
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery.js"></script>
     <script type="text/javascript" src="js/employeeuser.js"></script>
      <script type="text/javascript" src="js/login2.js"></script>
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
	
  </head>
  
   <%
    	String id = request.getParameter("id");
    	
    	String erid = request.getParameter("erid");
    	
    	String money = request.getParameter("money");
    	
	%>
  <body onload="queryUserPage(1)">
    <form id="userInfo" method="post">
     <ul>
    <li>id<input name="ID" id="ID" type="text" class="ID" value="<%=id%>"  readonly="readonly"/></li>
   
    <li>erid<input name="erid" id="erid" type="text" class="erid" value="<%=erid%>"  onclick="JavaScript:this.value=''"/></li>
     <div class="s">
   
     <div><li>金额<input name="money" id="money" type="text" class="money" value="<%=money%>" onclick="JavaScript:this.value=''"/></li><font color="red" id="f4"></font></div>
     </div>
        
    <li><input id="update" name="update" type="button" class="update" value="更新" onclick="updateUser()"/></li>
    </ul>    
    
    
    </form>
  </body>
</html>
