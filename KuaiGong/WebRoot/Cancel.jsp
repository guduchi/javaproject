<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/text.js"></script>
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
function queryCancel(){
	var id=$("#id").val();
	var b=new Base64();
	$.post("Cancel/selectCancelOrder.action",{id:id},function(data){
		if(data!=null){
			$("#table_tbody_div").empty();
			$.each(data, function() {
				$("#table_tbody_div").append(	
						"<div>" + this.id+ "</div>"
						+ "<div>" +this.eeid+ "</div>" 
						+ "<div>" +b.decode(this.eename)+ "</div>"
						+ "<div>" +b.decode(this.eeusername)+ "</div>"
						+ "<div>" +this.erid+ "</div>"
						+ "<div>" +b.decode(this.name)+ "</div>"
						+ "<div>" +b.decode(this.username)+ "</div>"
						+ "<div>"+ test(this.payment) + "</div>" 
						+ "<div>"+ test(this.time) + "</div>" 
						+ "<div>"+ test(this.type) + "</div>" 
						+"</div>");
					});
		}
	}, "json");
}

 function test(str) {
		if(typeof(str)=="undefined"){ 
			return "";
			}else{
				return str;
			}
	}

</script>
</head>
<%
int id=Integer.parseInt(request.getParameter("id"));
System.out.println("!!!!!!!!!!!!!!!!!!!!!!!"+id);
 %>
<body onload="queryCancel(1)">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><input id = "id" type="hidden" class=" query quee" onload="queryUser(1)" value="<%=id %>" />
    </ul>
    </div>

<div class="rightinfo">
<div class="table_tbody_box">
<div class="table_tbody_divText">
    <div>订单编号</div>
    <div>工人编号</div>
    <div>工人电话</div>
    <div>工人姓名</div> 
    <div>雇主编号</div> 
    <div>雇主电话</div> 
    <div>雇主姓名</div> 
    <div>支付方式</div>
  	<div>取消时间</div>
  	<div>取消原因</div>
</div>
<div id="table_tbody_div" class="table_tbody_div">
</div>
</div>
</div>

<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>