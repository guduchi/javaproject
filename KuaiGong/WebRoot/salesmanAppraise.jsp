<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
function AppraiseOrder(){
	var id=$("#id").val();
	var b = new Base64();
	$.post("app/selectOrderApp.action",{id:id},
			function(data) {
				if (data != null) {
					$("#table_tbody").empty();
					$.each(data, function() {
						$("#table_tbody").append("<tr>"
								+ "<td>"+this.orderid + "</td>"
								+ "<td>"+this.starlevel+ "</td>"
								+"<td>"+b.decode( this.Eeusername) + "</td>"
								+"<td>"+ b.decode(this.eename )+ "</td>"
								+"<td>"+ b.decode(this.name )+ "</td>"
								+"<td>"+ b.decode(this.username )+ "</td>"
								+ "</tr>");
					});
				}
			}, "json");
}
</script>
</head>
<%
String id=request.getParameter("id");
String page1=request.getParameter("page");
 %>

<body  onload="AppraiseOrder()">
        	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="selectSalesmanOrder.jsp?page=<%=page1%>">订单</a></li>
        <li><input type="hidden" id="id" value="<%=id %>"/></li>
     <li><input type="hidden" id="page" value="<%=page1%>"/></li>
    </ul>
    </div>
<div class="rightinfo">
    <table class="imgtable">
    <thead>
    <tr>
    <th>订单编号</th>
    <th>星级</th>
    <th>工人电话</th>
    <th>工人姓名</th>
    <th>雇主电话</th>
    <th>雇主姓名</th>
    </tr>
    </thead>
				<tbody id="table_tbody">
				</tbody>
	</table>
		</div>
    <div class="message">
    
				</div>
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    

<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>

</html>