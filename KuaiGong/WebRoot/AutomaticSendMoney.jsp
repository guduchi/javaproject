<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SendMoney.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/add.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/login1.js"></script>
<script type="text/javascript" src="js/orderForm.js"></script>
  </head>



<!-- 
<
String id[]=request.getParameterValues("id");
        for (int i = 0;i < id.length;i ++)
        {
          
        }
 %>
 -->
  <body>
<form id="userInfo" method="post">

<ul class="userInfo userInfoPre">
<li><pre>首次注册使用发送优惠卷  ：</pre><input type="text" id="moneyone" name="moneyone" class="money query"><br><font color="red" id="f2"></font></li>
<li><pre>前三次使用发送优惠卷    ：</pre><input type="text" id="moneythree" name="moneythree" class="money query"><br><font color="red" id="f2"></font></li>
<li><pre>使用超过了5天发送优惠卷 ：</pre><input type="text" id="moneyfive" name="moneyfive" class="money query"><br><font color="red" id="f2"></font></li>
<li><pre>长期使用订单算的次数    ：</pre><input type="text" id="longusenumber" name=longusenumber class="money query"><br><font color="red" id="f2"></font></li>
<li><pre>长期使用每三次发送优惠卷：</pre><input type="text" id="moneylong" name="moneylong" class="money query"><br><font color="red" id="f2"></font></li>

<li><input type="button" id="but"  value="修改优惠卷数量" onclick="AutomaticSendMoneyAll()"></li>
</ul>
</form>
  </body>
</html>
