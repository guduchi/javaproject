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
	<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/updateWlocation.js"></script>
<script type="text/javascript" src="js/updateGlotion.js"></script>
  </head>
  <script type="text/javascript">

function test(obj) {
                 var longitude = document.getElementById('longitude');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test1(obj) {
                var longitude= document.getElementById('longitude');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
            function test2(obj) {
                 var latitude= document.getElementById('latitude');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
           function test3(obj) {
                var latitude= document.getElementById('latitude');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
</script>
  <%
  
    	String id = request.getParameter("id");
    	
    	String longitude = request.getParameter("longitude");
    	
    	String latitude = request.getParameter("latitude");
   %>

    <body>
    	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="">雇主位置列表刷新</a></li>
    <li>修改</li>
    </ul>
    </div>
    <form id="userInfo" method="post">
    
     <ul class="userInfo">
   	 <li><pre>编    号</pre><input name="id" id="id" type="text" class="id query" value="<%=id%>"  readonly="readonly"/></li>
     <li><pre>经    度</pre><input name="longitude" id="longitude" type="text" class="longitude query" value="<%=longitude%>" onclick="javascript:test(this);" onblur="javascript:test1(this);"/></li>
     <li><pre>纬    度</pre><input name="latitude" id="latitude1" type="text" class="latitude1 query" value="<%=latitude%>" onclick="javascript:test2(this);" onblur="javascript:test3(this);"/></li>
    <li><input id="update" name="update" type="button" class="update selectUser" value="更新" onclick="updateGlocation()"/></li>
    </ul>    
    
    
    </form>
  </body>
 
</html>
