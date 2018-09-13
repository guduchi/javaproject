<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/OrderFormS.js"></script>
<script type="text/javascript" src="js/text.js"></script>
<script type="text/javascript" src="js/Base64.js"></script>
<script type="text/javascript">
$(function(){
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active");
		$(this).addClass("active");
	});
	

});	
</script>

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
String id = request.getParameter("id");
String page1=request.getParameter("page");
 %>
<body>
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="employeruser.jsp?page=<%=page1%>">雇主列表</a></li>
 <li><input type="hidden" id="id" value="<%=id %>"/></li>
  <li><input type="hidden" id="page" value="<%=page1%>"/></li>
    <li><a href="">招工统计</a></li>
    </ul>
    </div>
<div class="rightinfo">
<div class="tools">
    	<ul class="toolbar">
      <li><select id = "status" class="paginsel paginselFont" >
					<option>请选择</option>
					<option value="已完成"><div>已完成</div></option>
					<option value="待支付"><div>待支付</div></option>
					<option value="干活中"><div>干活中</div></option>
					<option value="等待中"><div>等待中</div></option>
					<option value="赶往中"><div>赶往中</div></option>
				</select></li>
				<li>起</li><li><input id = "starttime" type="date" class="query quee" onload="queryUser(1)"  value="" /> </li>
        <li>至</li><li><input id = "endtime" type="date" class="query quee" onload="queryUser(1)"  value="" /></li>
        <li><input id = "eename" type="text" class="query quee" onload="queryUser(1)"  value="" placeholder="输入工人姓名"/>
       <input id = "GRusername" type="text" class="query quee" onload="queryUser(1)"  value="" placeholder="输入工人电话号码"/><button type="button" onclick="queryUserPage(1)">查询</button></li>
  </ul>
 </div>
        
</div>
  
    <table class="imgtable">
    <thead>
    <tr>		
    <th width="80px">编号</th>
    <th width="80px">工人ID</th>
    <th>工人电话</th>
    <th width="80px">工人姓名</th>
    <th width="80px">雇主ID</th>
    <th>雇主电话</th>
    <th width="80px">工人姓名</th>
    <th>开始时间</th>
    <th>结束时间</th>
    <th>支付方式</th>
    <th width="60px">全部费用</th>
    <th width="60px">实收费用</th>
    <th width="80px">状态</th>
    <th>订单开始时间	</th>
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

