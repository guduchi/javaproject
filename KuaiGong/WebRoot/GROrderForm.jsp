<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
 <script type="text/javascript" src="js/GROrderForm.js"></script>
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
String page1=request.getParameter("page");
 %>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href='employeeuser.jsp?page=<%=page1%>'>查看工作记录</a></li>
    
    </ul>
    </div>

<div class="rightinfo">

    	<div class="tools">
<ul class="toolbar toolbarRight">
<input type="hidden" id="id" value="<%=id%>"/>
<input type="hidden" id="page" value="<%=page1%>"/>
    <li><input name="id" id ="orderid" type="text" class="id query quee toolbarRightR"   value="" placeholder="输入订单编号"/>
<input name="query" id = "query"  type="text" class="query quee toolbarRightR" onload="queryUser(1)"  value="" placeholder="输入雇主姓名"/><button class="toolbarRightbor" onclick="queryMohuChaXun(1)">查询</button></li>
	
    </ul>
    	<ul class="toolbar toolbarLeft" >
    	 <li><select class="paginsel paginselFont" id=btu onchange="btu()">
     <option>状态查询</option>
      <option value="待支付">待支付</option>
      <option value="已完成">已完成</option>
      <option value="干活中">干活中</option>
      <option value="等待中">等待中</option>
       <option value="赶往中">赶往中</option>
     </select></li>
      <li>起</li><li><input type="date" id="starttime" size="10" value="" class="query quee toolbarLeftL"/></li> 
	<li>至</li><li><input type="date" id="endtime" size="10" value="" class="query quee toolbarLeftL"/></li>
  
    
    </ul>
    

</div>
    <table class="imgtable">

    <thead>
    <tr>
    <th width="70px;">订单编号</th>
    <th width="50px;">工人ID</th>
    <th width="100px;">工人电话</th> 
    <th width="80px;">工人姓名</th>
    <th width="50px;">雇主ID</th>
    <th width="100px;">雇主电话</th>
    <th width="80px;">雇主姓名</th>
    <th>开始时间</th>
    <th>结束时间</th>
    <th width="80px;">支付方式</th>
    <th width="60px;">全部费用</th>
    <th width="60px;">实收费用</th>
   <th width="50px;">状态</th>
    <th>订开时</th>
    <th width="80px;">操作</th>
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
