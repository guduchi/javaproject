<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/orderForm.js"></script>
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
</head>
<%
String id=request.getParameter("id");
 %>

<body  onload="queryEeuserToErUser()">

    	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><input type="hidden" id="id" name="id" value="<%=id%>" size="1"/></a></li>
    <li>雇主列表</li>
    <li>查看每个信息</li>
    <li>查看点单</li>
    </ul>
    </div>
    
<div class="rightinfo">
    <ul class="toolbar">
    <li>
    <select class="paginsel paginselFont"  id=btu onchange="btu()">
     <option>根据状态查询</option>
      <option value="待接受">待接受</option>
      <option value="赶往中">赶往中</option>
      <option value="等待中">等待中</option>
      <option value="干活中">干活中</option>
      <option value="待支付">待支付</option>
      <option value="已完成">已完成</option>
     </select>
     </li>
    <li>起</li><li><input class="query quee"  type="date" id="starttime" name="starttime" value=""/></li> 
    <li>至</li><li><input class="query quee" type="date" id="endtime" name="endtime" value=""/>
    <button id="toolbarBut" onclick="queryErOrderTime()">查询</button></li>
    
     <li><button id="toolbarBut" onclick="SendMoney()"/>发送优惠券</button></li>
      

   
       <li><input type="hidden" id="id" name="id" value=<%=id%>/></li>
       </ul>
 </div>
  
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;" id="Id">编号</th>
    <th>雇主ID</th>
    <th>雇主名</th> 
    <th width="100px">雇主电话</th>
    <th>工人名</th>
    <th width="100px">工人电话</th>
    <th width="100px">开始时间</th>
    <th width="100px">结束时间</th>
    <th>支付方式</th>
    <th>总费用</th>
    <th>状态</th>
    <th width="130px;"> 操作优惠券：<input  type="checkbox" name="checkbox1" id="checkAll" />全选 </th>
    <th>操作</th>
  <th width="100px">操作</th>
  <th>操作</th>


   </tr>
    
    </thead>
    



				<tbody id="table_tbody">
				
				</tbody>
	</table>

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
	
    
 <script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>

</html>
