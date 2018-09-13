<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title></title>

	<link rel="stylesheet" href="css/index.css" type="text/css" media="screen" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/discountcoupon2.js"></script>
<script type="text/javascript" src="js/discountcoupon.js"></script>
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="utilLib/bootstrap.min.css" type="text/css" media="screen" />
  </head>
  
  <body>
    <div class="div_from_aoto" style="width: 500px;">
    <FORM id="userInfo" method="post">
        <DIV class="control-group">
            <label class="laber_from">用户名</label>
            <DIV  class="controls" ><INPUT class="input_from" name="username" id="username"type="text" placeholder=" 请输入用户名"><font id="f1" color="red"></font></DIV>
        </DIV>
        <DIV class="control-group">
            <LABEL class="laber_from">密码</LABEL>
            <DIV  class="controls" ><INPUT class="input_from" name="password"id="password"type="password" placeholder=" 请输入密码"><font id="f2" color="red"></font></DIV>
        </DIV>
         <DIV class="control-group">
            <LABEL class="laber_from" >姓名</LABEL>
            <DIV  class="controls" ><INPUT class="input_from" name="name"id="name"type="text" placeholder=" 请输入姓名"><font id="f4" color="red"></font></DIV>
        </DIV>
         <div style="padding-left: 50px;float: left;padding-bottom: 20px">
		          <input id="btn1" type="button" onclick="addDiscountcoupon()" class="btn btn-success" style="width:120px;" value="添加"/>
		       </div>
    </FORM>
</div>
  </body>
</html>
