<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/login2.js"></script>
<script type="text/javascript" src="js/Base64.js"></script>
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
    <li><a href="employeeuser.jsp">工人列表</a></li>
    </ul>
    </div>
<div class="rightinfo">
    	<ul class="toolbar">
    		<li><select class="paginsel paginselFont" id=btu >
     <option>状态查询</option>
      <option value="可用">可用</option>
      <option value="不可用">不可用</option>
     </select></li>
      <li><input id ="page" class="query quee"  type="hidden" onload="queryUser(1)" value="<%=page1%>"/></li>
        <li><input name="id" id ="eeid" type="text" class="query quee"  onload="queryUser(1)" placeholder="工人编号"/>
        <input id = "name" type="text" class="query quee" onload="queryUser(1)" placeholder="工人姓名"/>
         <input id = "phone" type="text" class="query quee" onload="queryUser(1)" placeholder="工人电话"/>
       <!--  <input id = "salesmanName" type="text" class="query quee" onload="queryUser(1)" placeholder="业务员姓名"/> --> 
        <button type="button" onclick="queryUserPage()">查询</button></li>
       <!--  <li>
				<button type="button" id="ToSendMessage" /> 发送信息</button>
		</li>
		<li>
			<button type="button" name="ToSendMessageToBlackList" />点击</button>
		</li> -->
</ul>
</div>
 <table class="imgtable">
    <thead>
    <tr>
    <th width="100px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="checkbox1"
					id="checkAll" />全选</th>
    <th width="60px">工人编号</th>
    <th width="100px">用户名</th>
    <th width="60px">姓名</th>
    <th width="40px">性别</th>
    <th width="40px">年龄</th>
    <th width="140px">身份证号</th>
    <th width="120px">地址</th>
    <th width="60px">状态</th>
    <th width="60px">上线状态</th>
    <th width="120px">注册时间</th>
    <!--<th width="60px">业务员编号</th>
    <th width="60px">业务员姓名</th>  -->
   	 <th width="80px">综合操作</th>
    </tr>
	
    </thead>
				<tbody id="table_tbody">

				</tbody>
	</table>
	
    <div class="pagin">
    
			<div style="font-size: 13px" class="pagin_sum ">
				当前显示第&nbsp;<i name="page" class="blue">1&nbsp;</i>页&nbsp;&nbsp;共<i class="blue" name="sum">1256</i>页 &nbsp;总数：<i class="count blue" id="count"  name="count"></i>
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
				
				<select class="paginsel" style="height: 23px;width: 50px;text-align:center;" name="select">
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
    <div class="message">
				</div>

<div class="rightinfo">
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

<script type="text/javascript" src="js/text.js">
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
</body>
</html>