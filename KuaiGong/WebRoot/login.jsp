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
<script type="text/javascript" src="js/Base64.js"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    });
});
</script> 
<script type="text/javascript">
  function changeImg() { 
    var imgSrc = $("#imgObj");  
      
        var src = imgSrc.attr("src");  
    
        imgSrc.attr("src", chgUrl(src)); 
      
    }  
    //时间戳     
    //为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳     
    function chgUrl(url) {  
        var timestamp = (new Date()).valueOf();  
        url = url.substring(0, 20);  
        if ((url.indexOf("&") >= 0)) {  
            url = url + "×tamp=" + timestamp;  
        } else {  
            url = url + "?timestamp=" + timestamp;  
        }  
        return url;  
    }  
</script>
<style type="text/css">
#imgObj{
width: 100px;
height:40px;
text-align:left
}
input,img {vertical-align:middle;}
#position{
text-align: left;
}
h2{
 font-size: 20px;
 margin:0 auto;
}
</style>
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
    <li>帮助</li>
    <li>关于</li>
    </ul>
    </div>
    
    <div class="loginbody">
    <div class="loginbox2">
    <div class="loginbox_ul_img"></div>
    <div class="loginbox_ul">
    <ul class="logintop_ul">
    
    <li><h2 >点快工后台登录</h2>    </li> 
  
    <li><input name="username" id="username" type="text" class="loginuser quee" value="" onclick="JavaScript:this.value=''"  autocomplete="off"  placeholder="用户名"/></li>
    <li><input name="password" id="password" type="password" class="loginpwd quee" value="" onclick="JavaScript:this.value=''"  autocomplete="off" placeholder="密码"/></li>
   

    <li><input id="index_code" class="loginVocode" name="code" type="text" placeholder="验证码" onclick="JavaScript:this.value=''"/>
   
       <img id="imgObj" alt="验证码" src="SecCode/code.action" />  
       
        <a id="voimgObj"  onclick="changeImg()">换一张</a>
       </li>
    <li > 
    <input name="login2" type="button" class="loginbtn" value="登录"   />
    <select class="loginsel"  id="position" name="position" >
										<option>管理员</option>
										<option>超级管理员</option>
									</select> </li>
    </li>
    <li></li>
    </ul> 
    </div>
    </div>
    </div>
</form>
</body>
</html>