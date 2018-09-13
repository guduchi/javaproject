<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/Base64.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected");
		$(this).addClass("selected");
	});	
});
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});
});
</script>
<script type="text/javascript">
function selectSalesman(){
	var id=$("#id").val();
	var b=new Base64();
    $.post("salesman/selectMany.action",{id:id},function(data){
		if (data != null) {
			$("#table_tbody_div").empty();
			$("#table_tbody_div2").empty();
			$.each(data, function(){
				$("#table_tbody_div").append(
						"<div>" + this.id+ "</div>"
						+ "<div>" +b.decode(this.username)+ "</div>"
						+ "<div>" +b.decode(this.password)+ "</div>"
						+ "<div>" +b.decode(this.salesmanName)+ "</div>"
						+ "<div>" +b.decode(this.address)+ "</div>"
						+ "<div>" +b.decode(this.sex)+ "</div>"
						+ "<div>" +this.superiorId+ "</div>"
						+ "<div>" +b.decode(this.position)+ "</div>"
						+ "<div>" +b.decode(this.idCard)+ "</div>"
						+ "<div>" +this.regtime+ "</div>"
						+ "<div>" +this.status+ "</div>"
						+ "<div>" +test(this.balance)+ "</div>"
						+ "<div>" +test(this.latelyUse)+ "</div>"
						+ "<div>" +test(this.time)+ "</div>"
						);
						$("#table_tbody_div2").append(
								 "<img src='img/"+this.headPortrait+ "'/>"
								);
					});
		}
	}, "json");
}	
function queryMAP( longitude,latitude){
		window.location.href="/KuaiGong/user/GRmap.jsp?longitude="+longitude+"&&latitude="+latitude;
	}
	
	function test(str){
if(typeof(str)=="undefined"){ 
	return "";
	}else{
		return str;
	}
}
</script>
</head>
<%
String id = request.getParameter("id");
String page1=request.getParameter("page");
 %>
<body onload="selectSalesman()">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="Salesman.jsp?page=<%=page1%>">业务员列表</a></li>
    <li>详细情况</li>
    </ul>
    </div>
    <li> <input type="hidden" id="id" value="<%=id%>"/></li>
     <li> <input type="hidden" id="page" value="<%=page1%>"/></li>
<div class="rightinfo">
<div class="table_tbody_box">
<div class="table_tbody_divText">
	<div>编号:</div>
	<div>电话:</div>
	<div>密码:</div>
	<div>姓名:</div>
	<div>地址:</div>
	<div>性别:</div>
	<div>上级编号:</div>
	<div>职务:</div>
	<div>身份证号:</div> 
	<div>注册时间:</div>
	<div>状态:</div>
    <div>余额:</div>
    <div>使用:</div>
     <div>时间:</div>	
</div>
<div id="table_tbody_div" class="table_tbody_div">
</div>
   <div class="table_tbody_divText_pho">头像</div>
<div id="table_tbody_div2" class="table_tbody_div2">
</div>
</div>
    <div class="message">
				</div>
    </div>
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>