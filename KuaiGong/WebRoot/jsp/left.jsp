<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){
	//默认首页样式
		$(".menuson li.active").removeClass("active");
		$("#active").addClass("active");
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active");
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
});	
</script>


</head>

<body style="background:#f0f9fd;">
	<!-- <div class="lefttop"><span></span>菜单</div> -->
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <!-- <span><img src="images/leftico03.png" width="16px" height="16px"/></span> -->管理信息
    </div>
    	<ul class="menuson">
       <li id="active"><!-- <cite></cite> --><a href="index.jsp" target="rightFrame">首页</a><i></i></li>
        <li><!-- <cite></cite> --><a href="employeeuser.jsp" target="rightFrame">工人后台管理</a><i></i></li>
        <li><!-- <cite></cite> --><a href="employeruser.jsp" target="rightFrame">雇主后台管理</a><i></i></li>
        </ul>    
    </dd>
    
     <dd><div class="title"><!-- <span><img src="images/leftico03.png"  width="16px" height="16px"/></span> -->订单管理</div>
    <ul class="menuson">
         
        
        <li><!-- <cite></cite> --><a href="OrderrFormm.jsp" target="rightFrame">查看订单</a><i></i></li>
      
    </ul>    
    </dd>  
     
   
    
    <dd><div class="title"><!-- <span><img src="images/leftico03.png"  width="16px" height="16px"/></span> -->钱包管理</div>
    <ul class="menuson">
         
        
        <li><!-- <cite></cite> --><a href="wallet.jsp" target="rightFrame">查看工人钱包</a><i></i></li>
         <li><!-- <cite></cite> --><a href="EmployerUserWallet.jsp" target="rightFrame">查看雇主钱包</a><i></i></li>
        <li><!-- <cite></cite> --><a href="withdrawdeposit.jsp" target="rightFrame">提现情况</a><i></i></li>
        <li><!-- <cite></cite> --><a href="discountcoupon.jsp" target="rightFrame">优惠券</a><i></i></li>
    </ul>    
    </dd>  
    
    
    
    
      
    <dd><div class="title"><!-- <span><img src="images/leftico03.png"  width="16px" height="16px"/></span> -->工人时间</div>
    <ul class="menuson">
         <li><!-- <cite></cite> --><a href="onlineInformation.jsp" target="rightFrame">工人在线时间</a><i></i></li>
         <li><!-- <cite></cite> --><a href="queryOnlineAll.jsp" target="rightFrame">工人在线时长统计</a><i></i></li>
       
       </ul>    
    </dd>  
    <!--  
    <dd><div class="title"><span><img src="images/leftico03.png"  width="16px" height="16px"/></span>工人在线统计</div>
    <ul class="menuson">
    <li><cite></cite><a href="TJstatistics.jsp" target="rightFrame">查看统计</a><i></i></li>
    </ul>    
    </dd>  
    -->
   
   <dd><div class="title"><!-- <span><img src="images/leftico03.png" width="16px" height="16px" /></span> -->位置管理</div>
   <ul class="menuson">
   <li><!-- <cite></cite> --><a href="employeeuserMap1.jsp"  target="rightFrame">查看全部工人位置</a><i></i></li>
   <li><!-- <cite></cite> --><a href="map1.jsp" target="rightFrame">查看全部雇主位置</a><i></i></li>
   <li><!-- <cite></cite> --><a href="Wposition.jsp" target="rightFrame">工人位置</a><i></i></li>
   <li><!-- <cite></cite> --><a href="Gposition.jsp" target="rightFrame">雇主位置</a><i></i></li>
   </ul>    
   </dd>  
    
   <dd><div class="title"><!-- <span><img src="images/leftico03.png"  width="16px" height="16px"/></span> -->积分管理</div>
   <ul class="menuson">
   <li><!-- <cite></cite> --><a href="employer_scale.jsp" target="rightFrame">查看雇主积分</a><i></i></li>
   </ul>    
   </dd>  
     <dd><div class="title"><!-- <span><img src="images/leftico03.png" width="16px" height="16px" /></span> -->报名管理</div>
   <ul class="menuson">
   <li><!-- <cite></cite> --><a href="Apply.jsp" target="rightFrame">查看报名统计</a><i></i></li>
   </ul>    
   </dd>
     <dd><div class="title"><!-- <span><img src="images/leftico03.png" width="16px" height="16px" /></span> -->企业管理</div>
   <ul class="menuson">
   <li><!-- <cite></cite> --><a href="company.jsp" target="rightFrame">点击查看</a><i></i></li>
   </ul>    
   </dd>
   <dd><div class="title"><!-- <span><img src="images/leftico03.png" width="16px" height="16px" /></span> -->业务员</div>
   <ul class="menuson">
   <li><!-- <cite></cite> --><a href="Salesman.jsp" target="rightFrame">业务员列表</a><i></i></li>
   <li><!-- <cite></cite> --><a href="SalesmanWallet.jsp" target="rightFrame">业务员钱包</a><i></i></li>
   <li><!-- <cite></cite> --><a href="SalesmanSignIn.jsp" target="rightFrame">签到列表</a><i></i></li>
   <li><!-- <cite></cite> --><a href="Change.jsp" target="rightFrame">转移数据</a><i></i></li>
   <li><!-- <cite></cite> --><a href="manager.jsp" target="rightFrame">经理注册</a><i></i></li>
   </ul>    
   </dd>
   <dd><div class="title"><!-- <span><img src="images/leftico03.png" width="16px" height="16px" /></span> -->短信</div>
   <ul class="menuson">
   <li><!-- <cite></cite> --><a href="manager.jsp" target="rightFrame">短信提醒</a><i></i></li>
   </ul>    
   </dd>
  <!-- 
<dd><div class="title"><span><img src="images/leftico03.png" /></span>公司收益</div>
   <ul class="menuson">
   <li><cite></cite><a href="Rearnings.jsp" target="rightFrame">查看收益</a><i></i></li>
   </ul>    
</dd>  
    
   <dd><div class="title"><span><img src="images/leftico03.png" /></span>查看资金</div>
   <ul class="menuson">
   <li><cite></cite><a href="ZJfund.jsp" target="rightFrame">资金去向</a><i></i></li>
   </ul>    
   </dd>  
    -->   
   </dl>
    
</body>
</html>
