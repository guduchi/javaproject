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
function query(str1,str2){
var latitude=str2;
var longitude=str1;

window.location.href="/KuaiGong/user/GRmap.jsp?longitude="+longitude+"&&latitude="+latitude;
}
</script>
<script type="text/javascript">


</script>

  </head>
  
   <%
    	String id=request.getParameter("id");
    	
    	String GRusername = request.getParameter("GRusername");
    
    	
    	String eename = request.getParameter("eename");
    	eename=new String(eename.getBytes("iso8859-1"),"UTF-8");
    	
    	String username = request.getParameter("username");
    	
    	
    	String name = request.getParameter("name");
    	name=new String(name.getBytes("iso8859-1"),"UTF-8");
    	
    
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

    	String DDtime = request.getParameter("DDtime");
    	
  String DDTime = request.getParameter("DDTime");
    	
    	String result1=request.getParameter("result1");
    	result1=new String(result1.getBytes("iso8859-1"),"UTF-8");

        
   String result=request.getParameter("result");
   result=new String(result.getBytes("iso8859-1"),"UTF-8");
        if(result.equals("undefined")){
        result="";
        }
	%>
  <body>
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="OrderrFormm.jsp">订单列表</a></li>
    <li>修改订单</li>
    </ul>
    </div>
    <form id="UserInfo" method="post">
    <table>
    <input type="hidden" id="id" value="<%=id%>">
  
     <ul class="userInfo userInfoPrePre">
     <tr>
   <td>  <li><pre>订单编号</pre><input name="id" id="id" type="text" class="starttime" value="<%=id%>"  readonly="readonly"/></li></td>
    
    <td><li><pre>工人姓名</pre><input name="GRusername" id=GRusername type="text" class="starttime" value="<%=GRusername%>"  readonly="readonly"/></li></td> 
    
  <td><li><pre>工人电话</pre><input name="eename" id="eename" type="text" class="starttime" value="<%=eename%>"  readonly="readonly"/></li></td>   
   
 <td><li><pre>雇主姓名</pre><input name="username" id="username" type="text" class="starttime" value="<%=username%>"  readonly="readonly"/></li></td>    
   
  <td><li><pre>雇主电话</pre><input name="name" id="name" type="text" class="starttime" value="<%=name%>"  readonly="readonly"/></li></td>   
    
<td><li><pre>开始工作时间</pre><input name="starttime" id="starttime" type="text" class="starttime" value="<%=starttime%>"  readonly="readonly"/></li></td>    
      </tr>
      <tr>
 <td><li><pre>结束工作时间</pre><input name="endtime" id="endtime" type="text" class="endtime" value="<%=endtime%>"  readonly="readonly"/></li></td>   
   
  <td><li><pre>支  付 方 式</pre><input name="payment" id="payment" type="text" class="payment" value="<%=payment%>"  readonly="readonly"/></li></td>  
 
    
    <td> <li><pre>总   费   用</pre><input name="allcost" id="allcost" type="text" class="allcost" value="<%=allcost%>"  readonly="readonly"/></li></td>  
   
  <td>   <li><pre>实  收 费 用</pre><input name="actualcost" id="actualcost" type="text" class="actualcost" value="<%=actualcost%>"  readonly="readonly"/></li></td>  
 
   <td>   <li><pre>经        度</pre><input name="latitude" id="latitude" type="text" class="latitude" value="<%=latitude%>"  readonly="readonly"/></li></td>  
   
   <td>  <li><pre>纬        度</pre><input name="longitude" id="longitude" type="text" class="longitude" value="<%=longitude%>"  readonly="readonly"/></li></td>  
    </tr>
    
      <tr> 
  <td>  <li> <pre>订  单 状 态</pre><input name="status" id="status" type="text" class="status" value="<%=status%>"  readonly="readonly"/></li></td>  
   
  <td>  <li><pre>订单开始时间</pre><input name="order_start_times" id="order_start_time" type="text" class="order_start_time" value="<%=order_start_time%>"  readonly="readonly"/></li></td>  
      
  <td>  <li><pre>等待时间</pre><input name="DDtime" id="DDtime" type="text" class="starttime" value="<%=DDtime%>"  readonly="readonly"/></li></td>  
   
   <td> <li><pre>预计到达时间</pre><input name="estimatedTimeOfArrival" id="estimatedTimeOfArrival" type="text" class="starttime" value="<%=result1%>"  readonly="readonly"/></li></td>  
   
  <td> <li><pre>迟到时间</pre><input name="result" id="result" type="text" class="starttime" value="<%=result%>"  readonly="readonly"/></li></td>  
  
  <td> <li><pre>到达时间</pre><input name="DDTime" id="CDtime" type="text" class="starttime" value="<%=DDTime%>"  readonly="readonly"/></li></td> 
       </tr>
        <tr> 
  <td>  <li> <pre></pre><input name="status" id="status" type="button" class="status" value="查看地理位置" onclick="query(<%=latitude%>,<%=longitude%>)"/></li></td>  
   

       </tr>
    </li>
    </ul>    
   </table>
    </form>
  </body>
</html>
