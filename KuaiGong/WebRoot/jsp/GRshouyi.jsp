<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/QueryGeRenShouYi.js"></script>
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

</head>
<%
String id=request.getParameter("id");
String page1=request.getParameter("page");
 %>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="employeeuser.jsp?page=<%=page1%>">提现列表</a></li>
    </ul>
    </div>
    
<div class="rightinfo">
    
<div class="tools">
    <input name="btu" id = "id" type="hidden" value=<%=id%>>
    	<ul class="toolbar">
      <li>起</li>
	<li><input name="starttime" id = "starttime" type="date" class=" query query quee" /></li>
	  <li>至</li>
	  <li><input name="endtime" id = "endtime" type="date" class=" query query quee" /><button type="button" onclick="QueryGeRenShouYi(1)" >查询</button></li>
    </ul>

</div>
  
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">编号</th>
    <th>工人电话</th>
    <th>工人姓名</th>
    <th>金额</th>
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
			共<i class="blue" name="sum">1256</i>页 &nbsp;&nbsp;&nbsp;当前显示第&nbsp;<i name="page" class="blue">1&nbsp;</i>页&nbsp;&nbsp;&nbsp;总数：<i class="count blue" id="count"  name="count"></i>
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

