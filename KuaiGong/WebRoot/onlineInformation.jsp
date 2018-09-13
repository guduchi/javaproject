<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/queryInfomation1.js"></script>
<script type="text/javascript" src="js/echarts.simple.min.js.js"></script>
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
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="">工人在线列表</a></li>
    </ul>
    </div>
    
<div class="rightinfo">

<div class="tools">
    
    	<ul class="toolbar">
    	<li><input type="radio" name="ssradio" id="radio" value="1"><font  style="font-size: 12px">按照在线时长排序</font></li>
         <li>
      <select class="paginsel paginselFont" id="btu"> 
      <option>根据状态查询</option>
      <option value="在线">在线/总数</option>
      <option value="完成">完成/总数</option>
      <option value="工作中">工作中/总数</option>
     </select>
     </li>
    	
    	<li>起</li><li><input name="id" id = "starttime" type="date" class="id query quee" onload="queryUser(1)" value="" placeholder=""/></li>
    	<li>至</li><li><input name="id" id = "endtime" type="date" class="id query quee" onload="queryUser(1)" value="" placeholder=""/></li>
     <li><input name="id" id = "username" type="text" class="id query quee" onload="queryUser(1)" value="" placeholder="输入姓名"/>
      <button onclick="queryInfomation(1)" name="queryAllMan">查询在线工人</button></li>
      
    </ul>
</div>
  
      
        
</div>
        

  
    <table class="imgtable">
    
    <thead>
    <tr>
    <th >编号</th>
    <th>用户名</th>
    <th>名字</th>
    <th>开始时间</th>
    <th>结束时间</th>
    <th>状态</th>
    <th>当天的工作时长</th>
    <th>末天的工作时长</th>
    <th>相隔天数</th>
   <!-- <th>离线时长</th> --> 
    </tr>
    </thead>
    



				<tbody id="table_tbody">
				
				</tbody>
	</table>
	
	
	
    <div class="pagin">
			<div style="font-size: 13px"  class="pagin_sum">
		当前显示第&nbsp;<i name="page" class="blue">1&nbsp;</i>页&nbsp;	共<i class="blue" name="sum">1256</i>页 &nbsp;总数：<i class="count blue" id="count"  name="count"></i>&nbsp;时长：<i class="timeCount blue" id="timeCount"  name="timeCount"></i>
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
	

     
   
	
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>

</html>
