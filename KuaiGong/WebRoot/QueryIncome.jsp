<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/QueryIncome.js"></script>
<script type="text/javascript" src="js/Base64.js"></script>
<script type="text/javascript" src="js/text.js"></script>
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
</head >
<%
String id=request.getParameter("id");
String orderValue=request.getParameter("orderValue");
orderValue=new String(orderValue.getBytes("iso8859-1"),"UTF-8");
 %>

<body>

    	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><input type="hidden" id="id" name="id" value="<%=id%>" size="1"/></a></li>
    <li><input type="hidden" id="orderValue" name="orderValue" value="<%=orderValue%>" size="1"/></a></li>
    <li>雇主列表</li>
    <li>查看每个信息</li>
    <li>查看点单</li>
    </ul>
    </div>
    
<<div class="rightinfo">

    	<div class="tools">
<ul class="toolbar toolbarRight">
 <li>
    <li><input name="id" id ="id1" type="text" class="id query quee toolbarRightR"   value="" placeholder="订单编号"/>
	<input name="eename" id = "eename"  type="text" class="query quee toolbarRightR" onload="queryUser(1)"  value="" placeholder="工人姓名"/>
	<input name="name" id = "name"  type="text" class="query quee toolbarRightR" onload="queryUser(1)"  value="" placeholder="雇主姓名"/>
	<button class="toolbarRightbor" onclick="QueryIncome()">查询</button></li>
	
    </ul>
    	<ul class="toolbar toolbarLeft" >
    	<li><select class="paginsel paginselFont" id=btu >
     <option>状态查询</option>
      <option value="微信支付">微信支付</option>
      <option value="支付宝支付">支付宝支付</option>
      <option value="余额支付">余额支付</option>
     </select></li>
     
    </ul>
    
</div>
  
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;" id="Id">编号</th>
    <th>雇主ID</th>
    <th>雇主姓名</th> 
    <th width="100px">雇主电话</th>
    <th>工人ID</th>
    <th>工人姓名</th>
    <th width="100px">工人电话</th>
    <th width="100px">开始时间</th>
    <th width="100px">结束时间</th>
    <th>支付方式</th>
    <th>总费用</th>
    <th>实收费用</th>
    <th>状态</th>
    <th>订单开始时间</th>

 

   </tr>
    
    </thead>
    



				<tbody id="table_tbody">
				
				</tbody>
	</table>

   <div class="pagin">
			<div style="font-size: 13px" class="pagin_sum">
				共<i class="blue" name="sum">1256</i>页 &nbsp;&nbsp;&nbsp;当前显示第&nbsp;<i name="page" class="blue">1&nbsp;</i>页&nbsp;&nbsp;&nbsp;
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
	
    
 <script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>

</html>
