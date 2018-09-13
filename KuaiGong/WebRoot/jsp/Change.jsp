<%@page import="com.bangshuo.kuaigong.po.EmployerUser"%>
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
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/Base64.js"></script>
	<link rel="stylesheet" href="css/style.css" type="text/css" />
	<link rel="stylesheet" href="css/add.css" type="text/css"  /><!-- media="screen" -->
<script type="text/javascript">
function updateSalesmanId() {
		var id=$("#id").val();
		var salesmanId = $("#salesmanId").val();
		var flag = true;
		if (flag == true) {
			$.post("eeuser/updateSalesmanId.action",{id:id,salesmanId:salesmanId}, function(
					data) {
				if (data != null) {
					alert("成功！");
					window.location.href="Salesman.jsp";
				}
			}, "json");
		}
	}
</script>
  </head>
  <body>
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li>更改业务员</li>
    </ul>
    </div>
    <form id="userInfo" method="post">
     <ul>
   <li>更改前业务员编号：</li> <li><input name="id" id="id" type="text" class="id"/></li>
  <li> 更改后业务员编号：</li> <li><input name="salesmanId" id="salesmanId" type="text" class="salesmanId"/></li>
    <li><input id="update" name="update" type="button" class="update selectUser" value="确定" onclick="updateSalesmanId()"/></li>
    </ul>
    </form>
  </body>
</html>