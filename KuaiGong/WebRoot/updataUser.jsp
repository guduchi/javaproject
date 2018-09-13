<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.bangshuo.kuaigong.utils.Base64"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/queryAdmin.js"></script>
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
String name=request.getParameter("name");
Base64 b=new Base64();
String name1=b.encryptBase64(name);
%>
<body  onload="queryAdmin(1)">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
     <li><input type="hidden" id="name" name="name" value="<%=name1%>" /></li>
    <li>管理员列表</li>
    </ul>
    </div>
<div class="rightinfo">
    <table class="imgtable">
    <thead>
    <tr>
    <th width="100px;" id="Id">编号</th>
    <th>用户名</th>
    <th>密码</th>
    <th>操作</th>
    
    </tr>
    </thead>
    



				<tbody id="table_tbody">
				
				</tbody>
	</table>
   

  
      
        
</div>
  
    

<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>

</html>
