<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/queryOnlineInfoKW.js"></script>
<script type="text/javascript" src="js/echarts.simple.min.js.js"></script>
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
<!--  
<script type="text/javascript">
function btu(){
var id=$("#id").val();
	
	var btu=$("#btu").val();
		

if (btu=="在线"){
		window.location.href="ZaiXianOnline.jsp?btu="+btu+"&id="+id;
	}
	else if(btu=="完成"){
		window.location.href="ZaiXianOnline.jsp?btu="+btu+"&id="+id;
	}
	else if(btu=="工作中"){
		window.location.href="ZaiXianOnline.jsp?btu="+btu+"&id="+id;
	}
	
}
</script>
-->
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
    	 <li><input name="sort" type="radio" checked="checked"  value="time"/><font style="font-size: 12px">根据在线时间降序</font> </li> 
    	  <li><input name="sort" type="radio"  value="work"/><font style="font-size: 12px">根据工作时间降序</font> </li> 
  
 
	    <li>起</li><li><input type="date" id="starttime" size="10" value="" class="query quee toolbarLeftL"/></li> 
		<li>至</li><li><input type="date" id="endtime" size="10" value="" class="query quee toolbarLeftL"/></li>
	
       
     
        <li><input name="username" id = "username" type="text" class="query quee toolbarLeftL"  value=""  placeholder="输入工人姓名"/><button id="selectWorker">查询工人</button></li>
         </ul>
    
	<div class="tools_a">
	    <a  id="total" href="javascript:void(0)">总</a>
	    <a  id="year" href="javascript:void(0)">年</a>
	    <a  id="month" href="javascript:void(0)">月</a>
	    <a  id="week" href="javascript:void(0)">周</a>
	    <a  id="yesterday" href="javascript:void(0)">昨天</a>
	    <a  id="today" href="javascript:void(0)">日</a>
	 </div>
</div>
  
      
        
</div>
        

  
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;" id="Id">编号</th>
    <th>用户名</th>
    <th>名字</th>
    <th>在线时长</th>
    <th>工作时长</th>
    <th>状态</th>
    <th>操作</th>
    </tr>
    
    </thead>
    



				<tbody id="table_tbody">
				
				</tbody>
	</table>
	
	
	
    <div class="pagin">
			<div style="font-size: 13px" class="pagin_sum">
				共<i class="blue" name="sum">1256</i>页，当前显示第&nbsp;<i name="page" class="blue">2&nbsp;</i>页
			</div>
			<div class="pagin_jump">
				<input class="pagin_jump_inp quee" placeholder="跳转" type="text" name="queryByid" id="querypage" size="5"/><input id="selectPage" class="pagin_jump_but" type="button" value="确定">
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
