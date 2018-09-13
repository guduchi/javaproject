<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/querySuperUser.js"></script>
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
<script type="text/javascript">

function deleteByid(userID) {
	// mizhu.confirm('温馨提醒', '是否要删除？', function(flag) {
	// if(flag) {

	var ss = confirm("您确定要删除吗?");
	if (ss) {
		$.post("user/delete.action", {
			userID : userID
		}, function(data, status) {
			if (data != null && data != "") {
				alert("删除成功！");
				window.location.href = "revise1.jsp";
			} else {
				alert("删除失败，请检查！");
			}
		}, "json");
		// }
		// });
	}
}


</script>
</head>
<%
String username=request.getParameter("username");
String password=request.getParameter("password");
%>

<body  onload="querySuperUser(1)">
<input type="hidden" id="username" value="<%=username%>" />
<input type="hidden" id="password" value="<%=password%>"/>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="">管理员列表</a></li>
    </ul>
    </div>
    
<div class="rightinfo">
    
<ul class="toolbar">
    
    	
        <li><input name="query" id ="query" type="text" class="query quee" onload="queryUser(1)" /><div>根据名字查询</div><button onclick="queryUser1()">查询管理员</button></li>
        </ul>

</div>
  
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">雇主编号</th>
    
    <th>用户名</th>
    <th>密码</th>
    <th>操作</th>
   <th>操作</th>	
    </tr>
    
    </thead>
    



				<tbody id="table_tbody">
				
				</tbody>
	</table>
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
				<select style="height: 30px;width: 50px" name="select">
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
