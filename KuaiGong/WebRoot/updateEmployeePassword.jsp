<%@page import="com.bangshuo.kuaigong.po.EmployerUser"%>
<%@page import="com.bangshuo.kuaigong.utils.Base64"%>
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
     <script type="text/javascript" src="js/employeeuser.js"></script>
      <script type="text/javascript" src="js/login2.js"></script>
	<link rel="stylesheet" href="css/style.css" type="text/css" />
	<link rel="stylesheet" href="css/add.css" type="text/css"  /><!-- media="screen" -->
<script type="text/javascript">
function updateEmployeePassword() {
var b=new Base64();
		var userInfo = $("#userInfo").serialize();
		var id=$("#id").val();
		var password = $.trim($("#password").val());
	var passwordPash=b.encode(password);
		var flag = true;
		if (password == "" || password.length<5) {
			$("#f2").html("密码小于5位！");
			flag = false;
		} else {
			$("#f2").html("");
		}
		if (flag == true) {
			$.post("eeuser/updateByPrimaryKey1.action",{id:id,password:passwordPash}, function(
					data) {
				if (data != null) {
					alert("修改成功！");
					window.location.href="employeeuser.jsp";
				}
			}, "json");
		}
	}
function Base64() {  
	   
    // private property  
    _keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";  
   
    // public method for encoding  
    this.encode = function (input) {  
        var output = "";  
        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;  
        var i = 0;  
        input = _utf8_encode(input);  
        while (i < input.length) {  
            chr1 = input.charCodeAt(i++);  
            chr2 = input.charCodeAt(i++);  
            chr3 = input.charCodeAt(i++);  
            enc1 = chr1 >> 2;  
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);  
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);  
            enc4 = chr3 & 63;  
            if (isNaN(chr2)) {  
                enc3 = enc4 = 64;  
            } else if (isNaN(chr3)) {  
                enc4 = 64;  
            }  
            output = output +  
            _keyStr.charAt(enc1) + _keyStr.charAt(enc2) +  
            _keyStr.charAt(enc3) + _keyStr.charAt(enc4);  
        }  
        return output;  
    };  
   
    // public method for decoding  
    this.decode = function (input) {  
        var output = "";  
        var chr1, chr2, chr3;  
        var enc1, enc2, enc3, enc4;  
        var i = 0;  
        input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");  
        while (i < input.length) {  
            enc1 = _keyStr.indexOf(input.charAt(i++));  
            enc2 = _keyStr.indexOf(input.charAt(i++));  
            enc3 = _keyStr.indexOf(input.charAt(i++));  
            enc4 = _keyStr.indexOf(input.charAt(i++));  
            chr1 = (enc1 << 2) | (enc2 >> 4);  
            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);  
            chr3 = ((enc3 & 3) << 6) | enc4;  
            output = output + String.fromCharCode(chr1);  
            if (enc3 != 64) {  
                output = output + String.fromCharCode(chr2);  
            }  
            if (enc4 != 64) {  
                output = output + String.fromCharCode(chr3);  
            }  
        }  
        output = _utf8_decode(output);  
        return output;  
    }  
   
    // private method for UTF-8 encoding  
    _utf8_encode = function (string) {  
        string = string.replace(/\r\n/g,"\n");  
        var utftext = "";  
        for (var n = 0; n < string.length; n++) {  
            var c = string.charCodeAt(n);  
            if (c < 128) {  
                utftext += String.fromCharCode(c);  
            } else if((c > 127) && (c < 2048)) {  
                utftext += String.fromCharCode((c >> 6) | 192);  
                utftext += String.fromCharCode((c & 63) | 128);  
            } else {  
                utftext += String.fromCharCode((c >> 12) | 224);  
                utftext += String.fromCharCode(((c >> 6) & 63) | 128);  
                utftext += String.fromCharCode((c & 63) | 128);  
            }  
   
        }  
        return utftext;  
    }  
   
    // private method for UTF-8 decoding  
    _utf8_decode = function (utftext) {  
        var string = "";  
        var i = 0;  
        var c = c1 = c2 = 0;  
        while ( i < utftext.length ) {  
            c = utftext.charCodeAt(i);  
            if (c < 128) {  
                string += String.fromCharCode(c);  
                i++;  
            } else if((c > 191) && (c < 224)) {  
                c2 = utftext.charCodeAt(i+1);  
                string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));  
                i += 2;  
            } else {  
                c2 = utftext.charCodeAt(i+1);  
                c3 = utftext.charCodeAt(i+2);  
                string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));  
                i += 3;  
            }  
        }  
        return string;  
    }  
}
function test(obj) {
                 var username= document.getElementById('password');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test1(obj) {
                var username= document.getElementById('password');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }

</script>
  </head>
  
   <%
    	String password = request.getParameter("password");
    	String id=request.getParameter("id");
    	Base64 b=new Base64();
    	String page1=request.getParameter("page");
	%>
  <body onload="queryUserPage(1)">
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="employeeuser.jsp?page=<%=page1%>">工人列表</a></li>
    <li>修改密码</li>
    </ul>
    </div>
    <form id="userInfo" method="post">
    <input type="hidden" id="id" value="<%=id%>">
     <input type="hidden" id="page" value="<%=page1%>">
    <div class="passText passTextT">新密码</div>
     <ul>
     
    <li><input name="password" id="password" type="text" class="password"  onclick="javascript:test(this);" onblur="javascript:test1(this);"/><font color="red" id="f2"></font></li>

    <li><input id="update" name="update" type="button" class="update selectUser" value="更新" onclick="updateEmployeePassword()"/></li>
    </ul>    
    
    
    </form>
  </body>
</html>
