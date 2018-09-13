<%@page import="com.bangshuo.kuaigong.po.EmployerUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bangshuo.kuaigong.utils.Base64" %>
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
	<script type="text/javascript" src="js/jquery.js"></script>
     <script type="text/javascript" src="js/employeeuser.js"></script>
      <script type="text/javascript" src="js/UpdataEEuser.js"></script>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
		<script type="text/javascript" src="js/text.js"></script>
  </head>
  <script type="text/javascript">
function test(obj) {
                 var username= document.getElementById('username');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test1(obj) {
                var username= document.getElementById('username');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
            function test2(obj) {
                 var name= document.getElementById('name');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test3(obj) {
                var name= document.getElementById('name');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
                function test4(obj) {
                 var sex= document.getElementById('sex');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test5(obj) {
                var sex= document.getElementById('sex');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
            
            function test6(obj) {
                 var age= document.getElementById('age');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test7(obj) {
                var age= document.getElementById('age');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
            
               function test8(obj) {
                 var address= document.getElementById('address');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test9(obj) {
                var address= document.getElementById('address');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
            
                           function test11(obj) {
                 var status= document.getElementById('status');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test12(obj) {
                var status= document.getElementById('status');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
            
            function getSltValue() {
  var status = document.getElementById("status").options[0].status;
  }
  </script>
   <%
    	String id = request.getParameter("id");
    	
    	String username = request.getParameter("username");
  		username=new String(username.getBytes("iso8859-1"),"UTF-8");

    	String name = request.getParameter("name");
    	name =name.replaceAll(" ", "+");
    	name=new String(name.getBytes("iso8859-1"),"UTF-8");
    	
    	String sex = request.getParameter("sex");
      	 sex=new String(sex.getBytes("iso8859-1"),"UTF-8");
    	
    	String age = request.getParameter("age");
 		age=new String(age.getBytes("iso8859-1"),"UTF-8");
    	
    	String address = request.getParameter("address");
    	address = address.replaceAll(" ", "+");
    	 	System.out.println(address);
		address=new String(address.getBytes("iso8859-1"),"UTF-8");
    	
    	String status = request.getParameter("status");
 	 	status=new String(status.getBytes("iso8859-1"),"UTF-8");
       String page1=request.getParameter("page");
    
         Base64 b=new Base64();
	%>
  <body >
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="employeeuser.jsp">工人列表</a></li>
    <li>修改基本信息</li>
    </ul>
   </div>
    <form id="userInfo" method="post">
     <input type="hidden" id="id" value="<%=id%>">
	     <ul class="userInfo">
	     <li><pre></pre><input name="page" id="page" type="hidden" class="ID" value="<%=page1%>"  readonly="readonly"/></li>
	    	<li><pre>工人编号</pre><input name="ID" id="ID" type="text" class="ID" value="<%=id%>"  readonly="readonly"/></li>
	  		<li><pre>用 户 名</pre><input name="username" id="username" type="text" class="username" value="<%=username%>" onclick="javascript:test(this);" onblur="javascript:test1(this);"/></li><font color="red" id="f1"></font>
	   		<li><pre>名    字</pre><input name="name" id="name" type="text" class="name" value="<%=name%>"  onclick="javascript:test2(this);" onblur="javascript:test3(this);"/><font color="red" id="f2"></font></li>
			<li><pre>性    别</pre><input name="sex" id="sex" type="text" class="sex" value="<%=sex%>" onclick="javascript:test4(this);" onblur="javascript:test5(this);"/> </li> 
			<li><pre>年    龄</pre><input name="age" id="age" type="text" class="age" value="<%=age%>" onclick="javascript:test6(this);" onblur="javascript:test7(this);"/></li>
			<li><pre>地    址</pre><input name="address" id="address" type="text" class="address" value="<%=address%>"  onclick="javascript:test8(this);" onblur="javascript:test9(this);"/></li>
			<li><pre>状    态</pre><select class="paginsel paginselFont" id="status">
<option ><%=status%></option>
<option value="可用">可用</option>
<option value="不可用">不可用</option>
</select>
<input type="hidden" id="status"  class="status" value="<%=status%>" onclick="getSltValue()"/></li>
			<li><input id="update" name="update" type="button" class="update selectUser" value="更新" onclick="updateEmployeeUser(<%=page1%>)"/></li>
	    </ul>    
    </form>
  </body>
</html>
