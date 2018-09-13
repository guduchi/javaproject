<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/QueryManagerr.js"></script>
<script type="text/javascript" charset="utf-8" src="js/text.js"></script>
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
<body onload="QueryManagerr(1)" >

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><input type="hidden" id="id" name="id" value="<%=id%>" size="1"/></a></li>
     <li><input type="hidden" id="page" name="id" value="<%=page1%>" size="1"/></a></li>
      <li><a href="employeruser.jsp?page=<%=page1%>">雇主列表</a></li>
    <li>查看详细信息</li>
    </ul>
    </div>
    
<div class="rightinfo">
<div class="table_tbody_box">
<div class="table_tbody_divText">
	<div>雇主ID</div>  
	<div>用户名</div>
	<div>密码</div>
	<div>公司名</div>
	<div>姓名</div>  
	<div>状态</div>
	<div>现积分</div>  
	<div>总积分</div>
	<div>位置</div>
	<div>等级</div>
	<div>星级</div>
	
</div>
<div id="table_tbody_div" class="table_tbody_div">
</div>
<div class="table_tbody_divText_pho">头像</div>
<div id="table_tbody_div2" class="table_tbody_div2">
</div>
</div>

     <div class="pagin">
			<div style="font-size: 13px">
				共<i class="blue" name="sum">1256</i>页，当前显示第&nbsp;<i name="page" class="blue">2&nbsp;</i>页
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
