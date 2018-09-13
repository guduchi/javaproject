<%@page import="com.bangshuo.kuaigong.po.EmployerUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery.js"></script>

	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<script type="text/javascript" src="js/updataOrderFormOrderForm.js"></script>  
<script type="text/javascript">
	function updateOrderForm(){
	var page=$("#page").val();
		var userInfo  = $("#userInfo").serialize();
		var id 			 = $("#id").val();
		var eeid		 = $.trim($("#eeid").val());
		var erid			 =  $.trim($("#erid").val());
		var starttime =  $.trim($("#starttime").val());
		var endtime  =  $.trim($("#endtime").val());
		var payment =  $.trim($("#payment").val());
		var allcost		 =  $.trim($("#allcost").val());
		var actualcost = $.trim( $("#actualcost").val());
		var latitude   = $.trim( $("#latitude").val());
		var longitude = $.trim( $("#longitude").val());
		var status      =  $.trim($("#status").val());
		var order_start_time = $.trim( $("#order_start_time").val());
			$.post("OrderForm/updateByPrimaryKey1.action",{userInfo:userInfo,id:id,eeid:eeid,erid:erid,starttime:starttime,endtime:endtime,payment:payment,allcost:allcost,actualcost:actualcost,latitude:latitude,longitude:longitude,status:status,order_start_time:order_start_time}, function(
					data) {
				if (data != null) {
					alert("修改成功！");
					window.location.href="OrderrFormm.jsp?page="+page;
				}
			}, "json");
		}
</script>
  </head>
  
   <%
    	String id=request.getParameter("id");
    	
    
    	String starttime = request.getParameter("starttime");

    	String endtime = request.getParameter("endtime");

    	String payment = request.getParameter("payment");
    
    		payment=new String(payment.getBytes("iso8859-1"),"UTF-8");
    	
    	String allcost = request.getParameter("allcost");

    	String actualcost = request.getParameter("actualcost");

		String latitude = request.getParameter("latitude");
    	
    	String longitude= request.getParameter("longitude");

    	String status = request.getParameter("status");
    	
    	status=new String(status.getBytes("iso8859-1"),"UTF-8");

    	String order_start_time = request.getParameter("order_start_time");
     
      String page1=request.getParameter("page");
	%>
  <body >
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="OrderrFormm.jsp?page=<%=page1%>">订单列表</a></li>
    <li>修改订单</li>
    </ul>
    </div>
    <form id="UserInfo" method="post">
    <input type="hidden" id="id" value="<%=id%>">
  
     <ul class="userInfo userInfoPrePre">
      <li><pre></pre><input  id="page" type="hidden" class="starttime" value="<%=page1%>"  readonly="readonly"/></li>
        <li><pre>订单编号</pre><input name="id" id="id" type="text" class="starttime" value="<%=id%>"  readonly="readonly"/></li>
     <li><pre>开始工作时间</pre><input name="starttime" id="starttime" type="text" class="starttime" value="<%=starttime%>"  readonly="readonly"/></li>
    
    <li><pre>结束工作时间</pre><input name="endtime" id="endtime" type="text" class="endtime" value="<%=endtime%>"  readonly="readonly"/></li>
   
    <li><pre>支  付 方 式</pre><input name="payment" id="payment" type="text" class="payment" value="<%=payment%>" onclick="javascript:test(this);" onblur="javascript:test1(this);"/></li>
   
    <li><pre>总   费   用</pre><input name="allcost" id="allcost" type="text" class="allcost" value="<%=allcost%>" onclick="javascript:test2(this);" onblur="javascript:test3(this);"/></li>
   
    <li><pre>实  收 费 用</pre><input name="actualcost" id="actualcost" type="text" class="actualcost" value="<%=actualcost%>" onclick="javascript:test4(this);" onblur="javascript:test5(this);"/></li>
  
    <li><pre>经        度</pre><input name="latitude" id="latitude" type="text" class="latitude" value="<%=latitude%>"  readonly="readonly"/></li>
   
    <li><pre>纬        度</pre><input name="longitude" id="longitude" type="text" class="longitude" value="<%=longitude%>"  readonly="readonly"/></li>
     
   <li> <pre>订  单 状 态</pre><input name="status" id="status" type="text" class="status" value="<%=status%>" onclick="javascript:test11(this);" onblur="javascript:test12(this);"/></li>
   
    <li><pre>订单开始时间</pre><input name="order_start_times" id="order_start_time" type="text" class="order_start_time" value="<%=order_start_time%>" onclick="javascript:test13(this);" onblur="javascript:test14(this);"/></li>
  
   
    <li><input id="update" name="update" type="button" class="update selectUser" value="更新" onclick="updateOrderForm()"/>
    </li>
    </ul>    
   
    </form>
  </body>
</html>
