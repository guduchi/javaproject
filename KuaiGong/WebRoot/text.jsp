<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/Base64.js"></script>
<script type="text/javascript" src="js/text.js"></script>
<script type="text/javascript">
function queryUserPage(){
	$.post("euser/selectByAll.action",{},
			function(data) {
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data,function() {
				$("#table_tbody").append("<tr>"
						+ "<td><input type='checkbox' name='checkbox' value="+ this.id+ ">" + "</td>"
						+  "<td>"+ this.id+ "</td>"
						+ "<td>"+b.decode(this.username)+ "</td>"
						+ "<td>"+b.decode(this.name)+ "</td>"
						+ "<td>"+b.decode(this.status)+ "</td>"
						+ "<td>"+b.decode(this.companyname)+ "</td>"
						+ "<td>"+b.decode(this.grade)+ "</td>"
						+ "<td>"+test(this.time)+ "</td>"
						+ "<td>"+this.regid+ "</td>"
						+ "</tr>");
			});
		}
	}, "json");
}
</script>
</head>
<%
	String id = request.getParameter("id");
	String page1 = request.getParameter("page");
	String username = request.getParameter("username");
	String regid = request.getParameter("regid");
%>
<body onload="queryUserPage">
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="index.jsp">首页</a>
			</li>
			<li><a href="employeruser.jsp">雇主列表</a>
			</li>
		</ul>
	</div>
	<table class="imgtable">

		<thead>
			<tr>
				<th width="130px">操作优惠券：<input type="checkbox" name="checkbox1"
					id="checkAll" />全选</th>
				<th width="100px;" id="Id">编号</th>
				<th >用户名</th>
				<th>名字</th>
				<th>状态</th>
				<th>公司名</th>
				<th>等级</th>
				<th>注册时间</th>
				<th >推送</th>
				<th>综合操作</th>
			</tr>
		</thead>
		<tbody id="table_tbody">
		</tbody>
	</table>
	<div class="message"></div>
</body>
</html>