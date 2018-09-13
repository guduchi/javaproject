<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/Apply.js"></script>
<script type="text/javascript" src="js/ApplyTimeTime.js"></script>
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
String starttime= request.getParameter("starttime");
String endtime= request.getParameter("endtime");
String page1=request.getParameter("page");
 %>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="Apply.jsp">报名统计</a></li>
    </ul>
    </div>
<div class="rightinfo">
    	<ul class="toolbar">
    	<li><input type="hidden" id="page" size="10" value="<%=page1 %>" /></li>
	<li>起</li><li><input type="date" class="query quee" id="starttime" size="10" value="" placeholder="开始日期"/></li>
	<li>至</li><li><input type="date" id="endtime" class="query quee" size="10" value="" placeholder="开始日期"/></li>
  <li><input type="text" class="query quee" id="username" size="10" value=""  placeholder="输入姓名"/>
<button id="toolbarBut" onclick="queryApplyPage()">查询</button></li>
   <li>
   	<font id="ApplyAllToAll3" color="#607DA5"></font>
   </li>
        </ul>
</div>

    <table class="imgtable">

    <thead>
    <tr>
    <th width="100px;">编号</th>
    <th>姓名</th>
    <th>身份证号</th>
    <th>推荐人</th>
    <th>推荐人电话</th>
    <th>地址</th>
    <th>电话</th>
    <th>时间</th>
    <th>操作</th>
    </tr>
    
    </thead>
				<tbody id="table_tbody">
				
				</tbody>
	</table>
	
    <div class="pagin">
			<div style="font-size: 13px"  class="pagin_sum">
				当前显示第&nbsp;<i name="page" class="blue">1&nbsp;</i>页&nbsp;共<i class="blue" name="sum">1256</i>页 &nbsp;总数：<i class="count blue" id="count"  name="count"></i>
			</div>
			<div class="pagin_jump">
				<input class="pagin_jump_inp quee" placeholder="跳转" type="text" name="queryByid" id="querypage" size="5"/><input class="pagin_jump_but" type="button" onclick="queryByid()" value="确定">
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
