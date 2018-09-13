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
<script type="text/javascript" src="js/jquery.js"></script>
 
      <script type="text/javascript" src="js/login1.js"></script>
    <script type="text/javascript" src="js/updataPWD.js"></script>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
  </head>
  <script type="text/javascript">
	function test(obj){
	 var password = document.getElementById('password');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test1(obj) {
                var password = document.getElementById('password');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
	
	</script>
	
   <%
    	String id=request.getParameter("id");
    	String page1=request.getParameter("page1");
	 %>
  <body onload="queryUserPage(1)">
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="employeruser.jsp?page=<%=page1%>">雇主刷新列表</a></li>
    <li>修改密码</li>
    </ul>
    </div>
    <form id="userInfo" method="post">

     <input type="hidden" id="id" name="id" value="<%=id%>"/>
       <input type="hidden" id="page"  value="<%=page1%>"/>
    <ul class="userInfo">
    <li><pre>修改密码</pre><input name="password" id="password" type="text" class="name" onclick="JavaScript:test(this)"/> <font color="red" id="f2"></font></li>
    <li class="userInfoBut"><input class="selectUser"  id="update" type="button" value="提&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp交" onclick="updataPWD()"/><a class="selectUser" id="update"  href="queryPWD.jsp?id=<%=id %>"/>查看密码</a></li>
    </ul>
 
    
    </form>
  </body>
</html>
