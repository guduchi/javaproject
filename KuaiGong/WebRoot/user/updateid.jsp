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
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
  </head>
  <script type="text/javascript">
	function test(obj){
	 var salesmanId = document.getElementById('salesmanId');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test1(obj) {
                var salesmanId = document.getElementById('salesmanId');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
	function updateid(page) {
		var id=$("#id").val();
		var salesmanId = $("#salesmanId").val();
		var flag = true;
		if (flag == true) {
			$.post("eeuser/updateid.action",{id:id,salesmanId:salesmanId}, function(
					data) {
				if (data != null) {
					alert("成功！");
					window.location.href="employeeuser.jsp?page="+page;
				}
			}, "json");
		}
	}
	</script>
	
   <%
    	String id=request.getParameter("id");
    	String page1=request.getParameter("page");
    	String salesmanId =request.getParameter("salesmanId");
	 %>
  <body>
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="employeruser.jsp?page=<%=page1%>">工人列表</a></li>
    <li>修改密码</li>
    </ul>
    </div>
    <form id="userInfo" method="post">
     <input type="hidden" id="id" name="id" value="<%=id%>"/>
    <ul class="userInfo">
    <li><pre></pre><input name="page" id="page" type="hidden" class="ID" value="<%=page1%>"  readonly="readonly"/></li>
    <li><pre>修改业务员</pre><input name="salesmanId" id="salesmanId" type="text" class="salesmanId"  value="<%=salesmanId %>" /></li>
    <li ><input id="update" type="button"   class="update selectUser"  value="提&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp交" onclick="updateid(<%=page1%>)"/></li>
    </ul>
    </form>
  </body>
</html>
