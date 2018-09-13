<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/discountcoupon.js"></script>
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
$(function() {
	click();
	queryCount();
});

function click() {

	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}
function queryCount(){
	var id=$("#id").val();
	$.post("discount/selectCoupon.action",{id:id},function(data){
		if(data!=null){
			$("#count").html(data);
		}
	},"json");
}

function coupon(){
var id=$("#id").val();
var b=new Base64();
var page=1;
var pageSize=8;
	$.post("discount/DisCount.action",{id:id,page:page,pageSize:pageSize},function(data){
		if (data != null) {
			selectSum(Math.ceil(data / 8));
		}
	}, "json");
	$.post("discount/selectDisCountToUserInfo.action",{id:id,page:page,pageSize:pageSize},function(data){
	if(data!=null){
	$("#table_tbody").empty();
			$.each(data,function(){
				$("#table_tbody").append("<tr>" + "<td>" +this.id +  "</td>" + "<td>" +this.erid +  "</td>"+
					  "<td>"+b.decode(this.username)+ "</td>" + "<td>"
						+b.decode(this.name)+"</td>"+"<td>"+this.money+"</td>"+"<td>" +this.status +"</td>"+"<td>" +this.endtime +"</td>"+"<td><a href=QueryManager.jsp?id="+this.erid+">返回上一页</a>"+"</td>"+"</td>"+"<td><a href='user/updataCoupon.jsp?id="
																		+ this.id
																		
																		+ "&money="
																		+ this.money
																		+ "&status="
																		+ this.status+ 
																		 "&endtime="
																		+ this.endtime
																		
																		+ "'>修改基本信息</a>" 
																		+ "<td><a href=javascript:void(0)  onclick =deleteByid("
																		+ this.id
																		+ ") >删除</a>"
																		+ "</td>"+"</tr>");
			});
	}
	},"json");
		}	
		function selectDisCountToUserInfo(){
		var id=$("#id").val();
        var page=1;
        var pageSize=8;
        var b=new Base64();
        $.post("discount/selectDisCountToUserInfo.action",{id:id,page:page,pageSize:pageSize},function(data){
	if(data!=null){
	$("#table_tbody").empty();
			$.each(data,function(){
				$("#table_tbody").append("<tr>" + "<td>" +this.id +  "</td>" +  "<td>" +this.erid +  "</td>"+
					  "<td>"+b.decode(this.username)+ "</td>" + "<td>"
						+b.decode(this.name)+"</td>"+"<td>"+b.decode(this.money)+"</td>"+"<td>" +this.status +"</td>"+"<td>" +this.endtime+"</td>"+"<td><a href=QueryManager.jsp?id="+this.erid+">返回上一页</a>"+"</td>"+"</td>"+"<td><a href='user/updataCoupon.jsp?id="
																		+ this.id
																		
																		+ "&money="
																		+ this.money
																		+ "&status="
																		+ this.status+ "&endtime="
																		+ this.endtime
																		
																		+ "'>修改基本信息</a>" 
																		+ "<td><a href=javascript:void(0)  onclick =deleteByid("
																		+ this.id
																		+ ") >删除</a>"
																		+ "</td>"+"</tr>");
			});
	}
	},"json");
		}
		function selectSum(pagenum) {
	$("[name=select]").empty();
	var i = 1;
	$("[name=sum]").html(pagenum);
	$("[name=page]").html(1);
	while (i <= pagenum) {
		$("[name=select]").append("<option >" + i + "</option>");
		i++;
	}
}
// 下拉选择页数
function selectNumber() {
	page = $(this).children('option:selected').val();
	$("[name=page]").html(page);
	selectDisCountToUserInfo(page);
}
// 下一页
function nextPage() {
	var page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	if (parseInt(page) >= parseInt(sum)) {
		alert("已经是最后一页了！");
	} else {
		var page1 = parseInt(page) + 1;
		$("[name=page]").html(page1);
		page = parseInt(page) + 1;
		selectDisCountToUserInfo(page);
		$("[name=select]").append("<option selected>" + page1 + "</option>");
	}

}
function lastPage() {
	page = $("[name=page]").html();
	if (page < 2) {
		alert("已经是第一页了！");
	} else {
		var page1 = page - 1;
		$("[name=page]").html(page1);
		page -= 1;
		$("[name=select]").append("<option selected>" + page1 + "</option>");
		selectDisCountToUserInfo(page);
	}

}
		
</script>
</head>

<%
String id=request.getParameter("id");
 %>
<body onload="coupon()">

    	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><input type="hidden" id="id" name="id" value="<%=id%>" size="1"/></a></li>
    <li>雇主列表</li>
    <li>查看每个信息</li>
    <li>查看优惠券</li>
    </ul>
    </div>
<div class="rightinfo">
    <table class="imgtable" >
    
    <thead >
    <tr>
    <th>编号</th>
    <th>僱主ID</th>
    <th>用户名</th>
    <th>姓名</th>
    <th>优惠券</th>
    <th>状态</th>
    <th>时间</th>
    <th>操作</th>
     <th>操作</th>
      <th>操作</th>
    </tr>
    </thead>

				<tbody id="table_tbody">
				
				</tbody>
	</table>
    
   
				 
    <div class="message">
     
				</div>
    
     <div class="pagin">
			<div style="font-size: 13px" class="pagin_sum">
		共<i class="blue" name="sum">1256</i>页 &nbsp;&nbsp;&nbsp;当前显示第&nbsp;<i name="page" class="blue">1&nbsp;</i>页&nbsp;&nbsp;&nbsp;总数：<i class="count blue" id="count"  name="count"></i>
			</div>
			<ul class="paginList">
				<li class="paginItem"><a name="last" href="javascript:;"><span
						class="pagepre"></span>
				</a>
				</li>
				<li class="paginItem">
				<select class="paginsel" style="height: 23px;width: 50px" name="select">
					<option>1</option>
					<option>1</option>
					<option>1</option>
					<option>1</option>
				</select>
				</li>
				<li class="paginItem"><a name="next" href="javascript:;"><span
						class="pagenxt"></span>
				</a>
				</li>
			</ul>
		</div>
    
  
    
    
        


    
</body>

</html>
