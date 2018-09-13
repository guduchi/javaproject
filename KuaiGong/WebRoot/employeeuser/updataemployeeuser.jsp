
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
    	
    	String username = request.getParameter("username");
    	
    	String password = request.getParameter("password");
    	
    	String name = request.getParameter("name");
    	
    	String sex = request.getParameter("sex");
    	
    	String age = request.getParameter("age");
    	
    	String idcard = request.getParameter("idcard");
    	
    	String address = request.getParameter("address");
    	
    	String hand = request.getParameter("hand");
    	
    	String scan = request.getParameter("scan");
    	
    	String portrait = request.getParameter("portrait");
    	
    	String status = request.getParameter("status");
    	
	%>
  <body onload="queryUserPage(1)">
    <form id="userInfo" method="post">
     <ul>
    <li>id<input name="ID" id="ID" type="text" class="ID" value="<%=id%>"  readonly="readonly"/></li>
   
    <li>用户名<input name="username" id="username" type="text" class="username" value="<%=username%>"  onclick="JavaScript:this.value=''"/></li>
     <div class="s">
   
     <div><li>密码<input name="password" id="password" type="text" class="password" value="<%=password%>" onclick="JavaScript:this.value=''"/></li><font color="red" id="f4"></font></div>
     </div>
     <div>

    <div> <li>名字<input name="name" id="name" type="text" class="name" value="<%=name%>" onclick="JavaScript:this.value=''"/></li><font color="red" id="f2"></font></div>
    </div>
       <li>性别<input name="sex" id="sex" type="text" class="sex" value="<%=sex%>" onclick="JavaScript:this.value=''"/> </li> 
      
       <li>年龄<input name="age" id="age" type="text" class="age" value="<%=age%>" onclick="JavaScript:this.value=''"/></li>
       
       <li>身份证号<input name="idcard" id="idcard" type="text" class="idcard" value="<%=idcard%>" onclick="JavaScript:this.value=''"/></li>
       
       <li>地址<input name="address" id="address" type="text" class="address" value="<%=address%>" onclick="JavaScript:this.value=''"/></li>
       
       <li>手持<input name="hand" id="hand" type="text" class="hand" value="<%=hand%>" onclick="JavaScript:this.value=''"/></li>
       
       <li>身份证<input name="scan" id="scan" type="text" class="scan" value="<%=scan%>" onclick="JavaScript:this.value=''"/></li>
       
       <li>头像<input name="portrait" id="portrait" type="text" class="portrait" value="<%=portrait%>" onclick="JavaScript:this.value=''"/></li>
       
       <li>状态<input name="status" id="status" type="text" class="status" value="<%=status%>" onclick="JavaScript:this.value=''"/></li>
        
    <li><input id="update" name="update" type="button" class="update" value="更新" onclick="updateUser()"/></li>
    </ul>    
    
    
    </form>
  </body>
</html>
