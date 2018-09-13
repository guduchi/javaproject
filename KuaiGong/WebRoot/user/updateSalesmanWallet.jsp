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
     <script type="text/javascript" src="js/SalesmanWallet.js"></script>
     <script type="text/javascript" src="js/Base64.js"></script>
      <script type="text/javascript" src="js/UpdateUserJiaoBen.js"></script>
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	 <script type="text/javascript">
	function updateSalesman(page){
	var id=$("#id").val();
	var balance=$("#balance").val();
	var flag=true;
	if(flag == true){
	$.post("sales/update.action",{id:id,balance:balance},function(data){
		if(data!=null){
			alert("更新成功！");
			window.location.href="SalesmanWallet.jsp?page="+page;
		}
			}, "json");
		}
	}
	
	function test(obj) {
                 var balance= document.getElementById('balance');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test1(obj) {
                var balance= document.getElementById('balance');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
	</script>
	<%
  int id =Integer.parseInt(request.getParameter("id"));
  String balance = request.getParameter("balance");
  String page1=request.getParameter("page");
	 %>
  </head>
    <body onload="queryUserPage(1)">
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="Salesman.jsp?page=<%=page1%>">业务员列表</a></li>
    <li>修改基本信息</li>
    </ul>
    </div>
    <form id="userInfo" method="post">
    <input type="hidden" id="id" value="<%=id%>">
    <ul>
      <li><pre></pre><input name="page" id="page" type="hidden" class="ID" value="<%=page1%>"  readonly="readonly"/></li>
    <li>修改余额为：</li><li><input name="balance" id="balance" type="text" class="salesmanId" value="<%=balance%>" onclick="javascript:test(this);" onblur="javascript:test1(this);"/></li>
	<li>
	<input id="update" class="selectUser" type="button" value="更新" onclick="updateSalesman(<%=page1%>)">
    </li>
    </ul>
    </form>
  </body>
</html>