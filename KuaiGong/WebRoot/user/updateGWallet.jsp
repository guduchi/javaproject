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
    <script type="text/javascript" src="js/GZupdateWallet.js"></script>
  </head>
  <%
    	String id = request.getParameter("id");
    	
    	String username = request.getParameter("username");
    	
    	String name = request.getParameter("name");
    	name=new String(name.getBytes("iso8859-1"),"UTF-8");
    	String balance = request.getParameter("balance");
    	
    	String residue = request.getParameter("residue");
    	
    	String page1=request.getParameter("page");
    	
    	   %>
<script type="text/javascript">
function test1(obj){
	 var balance = document.getElementById('balance');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test2(obj) {
                var balance = document.getElementById('balance');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }

</script>
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
       <li><pre></pre><input id="page" type="hidden" class="id query" value="<%=page1%>"  readonly="readonly"/></li>
   
    <li><pre>编    号</pre><input name="id" id="id" type="text" class="id query" value="<%=id%>"  readonly="readonly"/></li>
   
  
     
   
   <li><pre>手 机 号</pre><input name="longitude" id="username" type="text" class="longitude query" value="<%=username%>" readonly="readonly"/><font color="red" id="f4"></font></li>
   
     <li><pre>工人姓名</pre><input name="latitude" id="name" type="text" class="latitude querys" value="<%=name %>" readonly="readonly"/></li>
    
    <li><pre>余    额</pre><input name="latitude" id="balance" type="text" class="latitude querys" value="<%=balance %>" onclick="javascript:test1(this);" onblur="javascript:test2(this);"/></li><div><font color="red" id="str"></font></div>
    
   
    
   
   <li><input id="update" name="update" type="button" class="update selectUser" value="更新" onclick="GZupdateWallet()"/></li>
    </ul>    
    
    
    </form>
  </body>
 
</html>
