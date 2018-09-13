<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript"  src="js/text.js"></script>
<script type="text/javascript"  src="js/SalesmanDetail.js"></script>
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
String page1=request.getParameter("page");
 %>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li>列表</li>
    </ul>
    </div>
<div class="rightinfo">
	<div class="tools">
    	<ul class="toolbar">
   <li>   <input id = "page" type="hidden" class="query quee" onload="queryUser(1)"  value="<%=page1%>" />
         <input  id = "salesmanName" type="text" class="query quee" onload="queryUser(1)" value=""  placeholder="业务员姓名"/>
                  <input  id = "username" type="text" class="query quee" onload="queryUser(1)" value=""  placeholder="业务员电话"/>
         <li>起</li><li><input type="date" id="starttime" size="10" value="" class="query quee toolbarLeftL" placeholder="开始日期"/></li>
	 <li>至</li><li><input type="date" id="endtime" size="10" value="" class="query quee toolbarLeftL" placeholder="结束日期"/></li>
	 <li><select class="paginsel paginselFont" id=desc >
     <option>状态查询</option>
      <option value="提现">提现</option>
      <option value="提现手续费">提现手续费</option>
       <option value="收益">收益</option>
        <option value="存款收益">存款收益</option>
         <option value="转入存款">转入存款</option>
          <option value="存款转出">存款转出</option>
           <option value="奖励">奖励</option>
     </select></li>
         <button type="button" onclick="queryUserPage()">查询</button></li>
          </ul>
</div>
</div>
    <table class="imgtable">
    
    <thead>
    <tr>
    <th >编号</th>
    <th >业务员电话</th>
    <th >业务员姓名</th>
    <th>金额</th>
    <th>状态</th>
    <th >全部金额</th>
    <th >时间</th>
   </tr>
    
    </thead>
    

		<tbody id="table_tbody">
				
				</tbody>
	</table>
	
    <div class="pagin">
			<div style="font-size: 13px" class="pagin_sum">
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
