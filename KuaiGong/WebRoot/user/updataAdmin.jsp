<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<%@page import="com.bangshuo.kuaigong.utils.Base64"%>
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
   <script type="text/javascript" src="js/jquery.js"></script>
     <script type="text/javascript" src="js/updataAdminUser.js"></script>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
  </head>
    <script type="text/javascript">

  function test (obj) {
                 var username = document.getElementById('username');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test1(obj) {
                var username = document.getElementById('username');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
         
  }
  
  
  
  </script>
   <%
    	String id = request.getParameter("id");
    	
    	String username = request.getParameter("username");
    	username=new String(username.getBytes("iso8859-1"),"UTF-8");
    
    	String password = request.getParameter("password");
    	password=new String(password.getBytes("iso8859-1"),"UTF-8");
    	Base64 b=new Base64();
    	String username1=b.decodeBase64(username);
    	String password1=b.decodeBase64(password);
	 %>
  <body>
    <form id="userInfo" method="post">
    
     <ul class="userInfo">
  <li><pre>编    号</pre><input name="id" id="id" type="text" class="id" value="<%=id%>"  readonly="readonly"/></li>
   
    <li><pre>用 户 名</pre><input name="username" id="username" type="text" class="username" value="<%=username1%>"  readonly="readonly"/></li>
     <div class="s">
    <div>
    
     <li><pre>密    码</pre><input name="password" id="password" type="text" class="password" value="<%=password1%>" onclick="javascript:test(this);" onblur="javascript:test1(this);"/></li>
    
    
        
    <li><input id="update" name="update" type="button" class="update selectUser" value="更新" onclick="updateAdmin()"/></li>
    </ul>    
    
    
    </form>
  </body>
</html>
