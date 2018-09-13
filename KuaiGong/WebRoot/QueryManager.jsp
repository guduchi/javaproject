<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/Scale.js"></script>
<script type="text/javascript" src="js/login1.js"></script>
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

<%String id=request.getParameter("id");%>
<%String page1=request.getParameter("page");%>
<body >
    	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><input type="hidden" id="id" name="id" value="<%=id%>" size="1"/></a></li>
    <li><input type="hidden" id="page"  value="<%=page1%>" size="1"/></a></li>
     <li><a href="employeruser.jsp?page=<%=page1%>">雇主列表</a></li>
    <li>查看每个信息</li>
    </ul>
    </div>
<div class="rightinfo">
 <input type="hidden" name="id" id="id" value=<%=id%> />
 <a class="selectUser selectUserClear" href= 'Scale.jsp?id=<%=id%>'>查看积分表</a>

  <input type="hidden" name="id" id="id" value=<%=id%> />
  <a class="selectUser selectUserClear" href='Appraise.jsp?id=<%=id%>'>查看评价</a>

  <input type="hidden" name="id" id="id" value=<%=id%> />
  <a class="selectUser selectUserClear" href='coupon.jsp?id=<%=id%>'>查看优惠券</a>

  <input type="hidden" name="id" id="id" value=<%=id%> />
  <a class="selectUser selectUserClear" href='orderForm.jsp?id=<%=id%>'>查看点单</a>

  <a class="selectUser selectUserClear" href="employeruser.jsp">返回上一层</a>
   

   <%-- <table class="imgtable">
    
    <thead>

 <tr>
  
  <th> <button type="text" name="id" id="id" value=<%=id%> />
 <button><a href= Scale.jsp?id="<%=id%>" >查看积分表</a></button></th>

  <th>
   <button type="text" name="id" id="id" value=<%=id%> />
  <button><a href=Appraise.jsp?id="<%=id%>">查看评价</button></th>

  <th>
   <button type="text" name="id" id="id" value=<%=id%> />
  
  <button><a href=Location.jsp?id="<%=id%>">查看地理位置表</button></th>
  <th>
  <button type="text" name="id" id="id" value=<%=id%> />
  <button><a href=coupon.jsp?id="<%=id%>">查看优惠券</button></th>

   <th>
    <input type="hidden" name="id" id="id" value=<%=id%> />
   <button ><a href=orderForm.jsp?id="<%=id%>">查看点单</button></th>

    <th>
      
    <button><a href="employeruser.jsp">返回上一层</a></button>
    </th>
  
   </tr>
 
   </thead> 
		
	</table> --%>
    
</div>
     
   

<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>

</html>
