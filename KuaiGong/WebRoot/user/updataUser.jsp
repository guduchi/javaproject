
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.bangshuo.kuaigong.utils.Base64"%>
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
     <script type="text/javascript" src="js/employerUser.js"></script>
      <script type="text/javascript" src="js/login1.js"></script>
      <script type="text/javascript" src="js/UpdateUserJiaoBen.js"></script>
      
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<script type="text/javascript">
	function getSltValue() {
  var status = document.getElementById("status").options[0].status;
  }
	</script>
  </head>
  
   <%
    	String id = request.getParameter("id");
    	
    	String username = request.getParameter("username");
    	username=new String(username.getBytes("iso8859-1"),"UTF-8");
    
    	String companyname = request.getParameter("companyname");
    	companyname=new String(companyname.getBytes("iso8859-1"),"UTF-8");
    	String name = request.getParameter("name");
    	name=new String(name.getBytes("iso8859-1"),"UTF-8");
    	
	   String status=request.getParameter("status");
	   status=new String(status.getBytes("iso8859-1"),"UTF-8");
	
	String grade=request.getParameter("grade");
	grade=new String(grade.getBytes("iso8859-1"),"UTF-8");
  // String hand=request.getParameter("hand");
	// hand=new String(hand.getBytes("iso8859-1"),"UTF-8");
	Base64 b=new Base64();
	 %>
  <body onload="queryUserPage(1)">
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="employeruser.jsp">雇主列表</a></li>
    <li>修改基本信息</li>
    </ul>
    </div>
    <form id="userInfo" method="post">
    <ul class="userInfo">
    
    <li>
	    <pre>雇主编号</pre>
	      <input name="ID" id="page" type="hidden" class="ID" value="<%=request.getSession().getAttribute("page")%>"  readonly="readonly"/>
	    <input name="ID" id="ID" type="text" class="ID" value="<%=id%>"  readonly="readonly"/>
   	</li>
   
    <li>
    	<pre>用 户 名</pre>
 	   <input name="username" id="username" type="text" class="username" value="<%=username%>"   onclick="javascript:test1(this);" onblur="javascript:test2(this);"/>
    </li>
    
    <li>
    	<pre>姓    名</pre>
		<input name="name" id="name" type="text" class="name" value="<%=name%>" onclick="javascript:test3(this);" onblur="javascript:test4(this);"/> <font color="red" id="f2"></font>
    </li>
    <li>
	    <pre>公 司 名</pre>
	 <input name="companyname" id="companyname" type="text" class="companyname" value="<%=companyname%>" onclick="javascript:test5(this);" onblur="javascript:test6(this);" /> 
    </li>  
	<li>
	     <pre>等    级</pre>
	   <input name="grade" id="grade" type="text" class="grade" value="<%=grade%>" onclick="javascript:test13(this);" onblur="javascript:test14(this);"/>
    
    </li>
       <li><pre>状    态</pre>
				<li><select id="status" class="paginsel paginselFont">
<option value=""><%=status%></option>
<option value="可用">可用</option>
<option value="不可用">不可用</option>
</select>
<input type="hidden" id="status"  class="status" value="<%=status%>" onclick="getSltValue()"/></li>
    <li>
    
    <input id="update" class="selectUser" type="button" value="更新" onclick="updateUser()">
    </li>
   
    </ul>
    
    
    </form>
  </body>
</html>
