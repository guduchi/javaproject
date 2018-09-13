<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>
<script src="js/login1.js" type="text/javascript"></script>
<script src="js/text.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  ;
});  
</script> 
</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
<form class="loginform">

    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop"> 
	<div class="loginbox_img"></div>
    <span>欢迎登录点快工后台管理系统</span>    
    <ul>
    <li><a href="index.jsp">回首页</a></li>
    <li><a href="help.jsp">帮助</a></li>
    <li><a href="about.jsp">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <!-- <span class="systemlogo"></span>  -->
       
    <div class="loginbox2">
    <div class="loginbox_ul_img"></div>
    <div class="loginbox_ul">
    
    <ul class="logintop_ul">
    
    <li>点快工后台登录</li>
    <li><input name="username" id="username" type="text" class="loginuser quee" value=""  autocomplete="off" onclick="JavaScript:this.value=''" placeholder="用户名"/></li>
    <li><input name="password" id="password" type="password" class="loginpwd quee" value=""  autocomplete="off" onclick="JavaScript:this.value=''" placeholder="密码"/></li>
    <li > <select class="loginsel"  id="position" name="position" >
										<option>管理员</option>
										<option>超级管理员</option>
									</select> </li>
    
    <!-- <li>
    
    
   
									<span class="icon icon-key margin-small"></span>
									</li> -->
    <li><input name="login2" type="button" class="loginbtn" value="登&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp录"   /></li>
    </ul>    
    </div>
    </div>
    
    </div>
    
    
    
  
	
</form>
    
</body>

</html>
