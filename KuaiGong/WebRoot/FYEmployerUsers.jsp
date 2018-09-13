<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/FenemployerUser.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/login1.js"></script>


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
String id=request.getParameter("id");
 %>
 
<body  onload="queryUserPage(1)">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="">雇主列表</a></li>
    </ul>
    </div>
    
<div class="rightinfo">
    
<div class="tools">
    
    	<ul class="toolbar">
       
        <li><input name="query" id = "query" type="text" class="query" onload="queryUser(1)" /><button onclick="employeruser()">查询雇主</button><i>(<font color="red">支持名字，电话模糊查询</font>)</i></li>
        <li><input name="id" id = "id" type="text" class="id" onload="queryUser(1)" /><button onclick="employeruser1()">查询雇主</button><i>(<font color="red">根据id查询</font>)</i></li>
        <!-- 
        <li><a href="addGG.jsp">添加雇主</a></li>
        -->
         <button onclick="SendMoney()"/> <li>发送优惠券</li></button>
       
</div>
  
    </ul>
      
        
</div>
  
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;" id="Id">编号</th>
    <th>用户名</th>
    <th>名字</th>
    <th>屏蔽</th>
    <th>状态</th>
    <th>公司名</th>
     <th>等级</th>
    <th>手持身份证</th>
    <th>操作</th>
    <th>操作</th>
    <th>综合操作</th>
    <th> 操作优惠券：<input  type="checkbox" name="checkbox1" id="checkAll" />全选

</th>

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
