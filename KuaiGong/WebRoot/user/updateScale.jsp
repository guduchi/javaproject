
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <script type="text/javascript" src="js/jquery.js"></script>
     <script type="text/javascript" src="js/employer_scale.js"></script>
  <script type="text/javascript" src="js/employer_scale6.js"></script>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
	
  </head>
  <script type="text/javascript">
	
	function test(obj){
	var credits=document.getElementById('credits');
	 if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
         function test1(obj) {
                var credits= document.getElementById('credits');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
	function test2(obj){
	var presentintegral=document.getElementById('presentintegral');
	 if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
         function test3(obj) {
                var presentintegral= document.getElementById('presentintegral');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
            }
	</script>
   <%
    	String id = request.getParameter("id");
    	
    	
    	String credits = request.getParameter("credits");
    	
    	String presentintegral = request.getParameter("presentintegral");
    	
	%>
  <body onload="queryUserPage(1)">
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="">雇主积分列表刷新</a></li>
    <li><a href="">修改</a></li>
    </ul>
    </div>
  
    <form id="userInfo" method="post">
    
     <ul class="userInfo">
    <li><pre>编    号</pre><input name="id" id="id" type="text" class="id" value="<%=id%>"  readonly="readonly"/></li>
  
     <li><pre>现 积 分</pre><input name="credits" id="credits" type="text" class="credits" value="<%=credits%>" onclick="javascript:test(this);" onblur="javascript:test1(this);"/></li>
    
    <li><pre>总 积 分</pre> <input name="presentintegral" id="presentintegral" type="text" class="presentintegral" value="<%=presentintegral%>" onclick="javascript:test2(this);" onblur="javascript:test3(this);"onclick="javascript:test2(this);" onblur="javascript:test3(this);"/> <font color="red" id="f2"></font> </li>
    
    <li><input id="update" name="update" type="button" class="update selectUser" value="更新" onclick="updateScale()"/></li>
    </ul>    
    
    
    </form>
  </body>
</html>
