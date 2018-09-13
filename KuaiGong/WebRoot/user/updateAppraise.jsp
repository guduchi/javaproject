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
    
    <title>My JSP 'updateAppraise' starting page</title>

	<link href="css/style.css" rel="stylesheet" type="text/css">
	<link href="css/add.css" rel="stylesheet" type="text/css" >

  </head>
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/updateAppraise.js"></script>
  <script type="text/javascript" src="js/queryaAppraise.js"></script>
  <script type="text/javascript">
  function test(obj){
  var starlevel=document.getElementById('starlevel');
 if(obj.value==obj.defaultValue){
  obj.value = "";
 }
  }
  
  function test1(obj){
 var starlevel=document.getElementById('starlevel');
 if(obj.value==""){
  obj.value =obj.defaultValue;
 }
  }
  </script>
  <%
  String id=request.getParameter("id");
  
  String orderid=request.getParameter("orderid");
  
  String username=request.getParameter("username");
  username=new String(username.getBytes("iso8859-1"),"UTF-8");
  
  String Eeusername=request.getParameter("Eeusername");
  Eeusername=new String(Eeusername.getBytes("iso8859-1"),"UTF-8");
 
  String starlevel=request.getParameter("starlevel");
  starlevel=new String(starlevel.getBytes("iso8859-1"),"UTF-8");
  Base64 b = new Base64();
  %>
  
  <body>
          	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="">雇主刷新列表</a></li>
    <li><input type="hidden" id="id" value="<%=id %>"/></li>
    <li><a href="">查看评价记录</a></li>
    <li><a href="">更新</a></li>
    </ul>
    </div>
    <form id="userInfo" method="post">
    
     <ul class="userInfo userInfoPre" >
    <li><pre>编       号</pre><input name="id" id="id" type="text" class="id" value="<%=id%>"  readonly="readonly"/></li>
   
    <li><pre>订 单 编 号</pre><input name="orderid" id="orderid" type="text" class="orderid" value="<%=orderid%>"  readonly="readonly"/></li>
    <li><pre>雇主用户名</pre><input name="username" id="username" type="text" class="username" value="<%=b.decodeBase64(username)%>"  readonly="readonly"/></li>
      <li><pre>工人用户名</pre><input name="Eeusername" id="Eeusername" type="text" class="Eeusername" value="<%=b.decodeBase64(Eeusername)%>"  readonly="readonly"/></li>
       
     
     <li><pre>星       级</pre><input name="starlevel" id="starlevel" type="text" class="starlevel" value="<%=starlevel%>" onclick="javascript:test(this);"onblur="javascript:test1(this);"/></li>
    <li><input  id="update" name="updates" type="button"  class="update selectUser" value="更新" onclick="updateAppraise()" /></li>
    
    </ul>    
    
    
    </form>
  </body>
</html>
