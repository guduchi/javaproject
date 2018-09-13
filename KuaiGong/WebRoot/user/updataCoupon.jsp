
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>
     <script type="text/javascript" src="js/discountcoupon.js"></script>
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
  </head>
  <script type="text/javascript">
	function test(obj) {
                 var money = document.getElementById('money');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test1(obj) {
                var money = document.getElementById('money');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
	function test2(obj) {
                 var status = document.getElementById('status');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test3(obj) {
                var status = document.getElementById('status');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
	function test4(obj) {
                 var endtime= document.getElementById('endtime');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
    function test5(obj) {
                var endtime = document.getElementById('endtime');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
            function test7(obj){
            var balance=document.getElementById('balance');
            if(obj.value==""){
            ob.value=obj.defaultValue;
            }
            }
            
            function test6(obj){
            var balance=document.getElementById('balance');
            if(obj.value==obj.defaultValue){
            obj.value="";
            }
            }
	</script>
	
   <%
   
    	String id = request.getParameter("id");
    	String money = request.getParameter("money");
    	money=new String(money.getBytes("iso8859-1"),"UTF-8");
    	String status=request.getParameter("status");
    	status=new String(status.getBytes("iso8859-1"),"UTF-8");
    	String endtime=request.getParameter("endtime");
    	endtime=new String(endtime.getBytes("iso8859-1"),"UTF-8");
    	String page1=request.getParameter("page");
    	String balance=request.getParameter("balance");
    	String erid=request.getParameter("erid");
	%>
  <body>
  <div  class="place">
      <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li>优惠券</li>
    <li>修改</li>
    <li><input type="hidden" id="id" value="<%=id%>"/></li>
    <li><input type="hidden" id="page" value="<%=page1%>"/></li>
   
    </ul>
    </div>
    <form id="userInfo" method="post">
    
     <ul class="userInfo">
    <li><pre>编    号</pre><input name="id" id="id" type="text" class="id" value="<%=id%>"  readonly="readonly"/></li>
    <li><pre>优 惠 券</pre><input name="money" id="money" type="text" class="money" value="<%=money%>" onclick="javascript:test(this);" onblur="javascript:test1(this);"/></li>
    <li><pre>状    态</pre><input name="status" id="status" type="text" class="status" value="<%=status%>"onclick="javascript:test2(this);" onblur="javascript:test3(this);"/></li>
    <li><pre>时    间</pre><input name="endtime"  id="endtime" type="date" class="endtime" value="<%=endtime%>" onclick="javascript:test4(this);" onblur="javascript:test5(this);"/></li>
     <li><pre>余额</pre><input name="balance"  id="balance" type="text" class="balance" value="<%=balance%>" onclick="javascript:test6(this);" onblur="javascript:test7(this);"/></li>
   <li><input type="hidden" id="erid" value="<%=erid%>"/></li>
    <li><input id="update" name="update" type="button" class="update selectUser" value="更新" onclick="updataCoupon()"/></li>
    </ul>    
    
    </form>
  </body>
</html>
