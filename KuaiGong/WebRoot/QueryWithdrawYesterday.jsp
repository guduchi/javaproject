<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/Base64.js"></script>
<script type="text/javascript" src="js/QueryWithdrawYesterday.js"></script>
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
String page1=request.getParameter("page");
String orderValue=request.getParameter("orderValue");
orderValue=new String(orderValue.getBytes("iso8859-1"),"UTF-8");
 %>
<body>
<style type="text/css">
#fontCount{
color: #FFA200;
font-style: normal;
}
</style>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="">提现列表</a></li>
    </ul>
    </div>
<div class="rightinfo">
    
<div class="tools">
    
    	<ul class="toolbar">
    	 <li> <select class="paginsel paginselFont"  id="btu" >
											<option value="null">请选择</option>
											<option  value='提现'>提现</option>
											<option  value='提现手续费'>提现手续费</option>
											
											<select></li>
         <li><input name="orderValue" id = "orderValue" type="hidden" value="<%=orderValue%>" />
        <li><input name="query" id = "query" type="text" class="query quee" onload="queryUser(1)" value="" placeholder="输入姓名"/>

         <li><input class="query quee" id = "page" type="hidden"  onload="queryUser(1)" value="<%=page1%>"/></li>
          <button id="toolbarBut" onclick="QueryWithdrawYesterday()">查询</button>
							</ul>				
</div>
    <table class="imgtable">
    <thead>
    <tr>
    <th width="100px;">编号</th>
     <th>工人姓名</th>
     <th width="100px;">金额</th>
     <th>总金额</th>
     <th>时间</th>
     <th>状态</th>
    </tr>
    
    </thead>
				<tbody id="table_tbody">
				
				</tbody>
	</table>
	
	
    <div class="pagin">
			<div style="font-size: 13px" class="pagin_sum">
				当前显示第&nbsp;<i name="page" class="blue">1&nbsp;</i>页&nbsp;共<i class="blue" name="sum">1256</i>页 &nbsp;
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
