<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/onlineinformation.js"></script>
<script type="text/javascript" src="js/onlineinformation2.js"></script>
<script type="text/javascript" src="js/DatePicker/WdatePicker.js" defer="defer"></script> 
<script type="text/javascript" src="js/Base64.js"></script>
<script type="text/javascript" src="js/MD5.js"></script>
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
<body  onload="queryUserPage(1)">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="">在线时间列表</a></li>
    </ul>
    </div>
    <input type="text" readonly onclick="WdatePicker()"> 
<div class="rightinfo">
    
<div class="tools">
       
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t02.png" /></span>添加</li>
        <li  class="click"><span><img src="images/t03.png" /></span>修改</li>
        <li class="click"><span><img src="images/t04.png" /></span>删除</li>
        <li><input name="query" id = "query" type="text" class="query" onload="queryUser(1)" /><button onclick="onlineinformation()">查询在线时间</button></li>
    </ul>
      
        
</div>
  
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">编号</th>
    <th>工人编号</th>
    <th>开始在线时间</th>
     <th>结束在线时间</th>
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
