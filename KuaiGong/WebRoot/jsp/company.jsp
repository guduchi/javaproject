<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/company.js"></script>
<script type="text/javascript" src="js/text.js"></script>
<script type="text/javascript" src="js/Base64.js"></script>
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
function updatecompany(page) {
	var page=page;
	var id=$("#id").val();
	var name=$("#name").val();
	var principal=$("#principal").val();
	var tel=$("#tel").val();
	var address=$("#address").val();
	var content=$("#content").val();
	var time=$("#time").val();
	alert(name);
	alert(principal);
	alert(tel);
	alert(address);
	alert(content);
	alert(time);
	var flag = true;
	if (name == "" || name == null) {
		$("#f2").html("请输入姓名！");
		flag = false;
	} else {
		$("#f2").html("");
	}
	if (flag == true) {
		$.post("companyname/updateByPrimaryKey.action",{id:id,name:name,principal:principal,tel:tel,address:address,content:content,time:time}, function(
				data) {
			if (data != null) {
				alert("更新成功！");
				window.location.href="company.jsp?page="+page;
			}
		}, "json");
	}
}
</script>
</head>

<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="company.jsp">企业报名</a></li>
    </ul>
    </div>
<div class="rightinfo">
    	<ul class="toolbar">
	<li><input name="query" id = "query" type="text" class="query quee" onload="queryUser(1)" value="" placeholder="输入负责人姓名"/><button id="toolbarBut" onclick="CompanynamePage(1)">查询</button></li>

        </ul>
</div>
  
    <table class="imgtable">

    <thead>
    <tr>
    <th width="100px;">编号</th>
    <th>企业名称</th>
    <th>负责人</th>
    <th>负责人人电话</th>
    <th>地址</th>
    <th>语术</th>
    <th>注册时间</th>
    <th>综合操作</th>
   
   
    </tr>
    
    </thead>
				<tbody id="table_tbody">
				
				</tbody>
	</table>
	
    <div class="pagin">
			<div style="font-size: 13px" class="pagin_sum">
			共<i class="blue" name="sum">1256</i>页 &nbsp;&nbsp;&nbsp;当前显示第&nbsp;<i name="page" class="blue">1&nbsp;</i>页&nbsp;&nbsp;&nbsp;总数：<i class="count blue" id="count"  name="count"></i>
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
