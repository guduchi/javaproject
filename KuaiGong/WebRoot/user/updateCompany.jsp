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
	<script type="text/javascript" src="js/jquery.js"></script>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
		<script type="text/javascript" src="js/text.js"></script>
  </head>
  <script type="text/javascript">
function test(obj) {
                 var username= document.getElementById('username');
                if (obj.value == obj.defaultValue) {
                    obj.value = "";
                }
            }
            function test1(obj) {
                var username= document.getElementById('username');
                if (obj.value == "") {
                    obj.value = obj.defaultValue;
                }
  </script>
  <script type="text/javascript">
  function updatecompany(page) {
	var page=page;
	var id=$("#id").val();
	var name=$("#name").val();
	var principal=$("#principal").val();
	var tel=$("#tel").val();
	var address=$("#address").val();
	var content=$("#content").val();
	var time=$("#time").val();
	var flag = true;
	if (name == "" || name == null) {
		$("#f2").html("请输入姓名！");
		flag = false;
	} else {
		$("#f2").html("");
	}
	if (flag == true) {
		$.post("companyname/updateByPrimaryKey.action",{id:id,name:name,principal:principal,tel:tel,address:address,content:content,time:time}, function(
				data) {
			if (data != null) {
				alert("更新成功！");
				window.location.href="company.jsp?page="+page;
			}
		}, "json");
	}
}
  </script>
   <%

		int id = Integer.parseInt(request.getParameter("id"));
			
    	String name = request.getParameter("name");
    	name=new String(name.getBytes("iso8859-1"),"UTF-8");
    	
    	String principal = request.getParameter("principal");
      	 principal=new String(principal.getBytes("iso8859-1"),"UTF-8");
    	
    	String tel = request.getParameter("tel");
    	
    	String address = request.getParameter("address");
		address=new String(address.getBytes("iso8859-1"),"UTF-8");
    	
    	String content = request.getParameter("content");
 	 	content=new String(content.getBytes("iso8859-1"),"UTF-8");
 	 	
    	String time = request.getParameter("time");
    	
       String page1=request.getParameter("page");
    
	%>
  <body >
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="company.jsp">工人列表</a></li>
    <li>修改基本信息</li>
    </ul>
   </div>
    <form id="userInfo" method="post">
     <input type="hidden" id="id" value="<%=id%>">
	     <ul class="userInfo">
	     <li><pre></pre><input name="page" id="page" type="hidden" class="ID" value="<%=page1%>"  readonly="readonly"/></li>
	    	<li><pre>编号</pre><input name="ID" id="ID" type="text" class="ID" value="<%=id%>"  readonly="readonly"/></li>
	   		<li><pre>企    业</pre><input name="name" id="name" type="text" class="name" value="<%=name%>"  onclick="javascript:test2(this);" onblur="javascript:test3(this);"/><font color="red" id="f2"></font></li>
			<li><pre>负责人</pre><input name="principal" id="principal" type="text" class="principal" value="<%=principal%>" onclick="javascript:test4(this);" onblur="javascript:test5(this);"/> </li> 
			<li><pre>电    话</pre><input name="tel" id="tel" type="text" class="tel" value="<%=tel%>" onclick="javascript:test6(this);" onblur="javascript:test7(this);"/></li>
			<li><pre>地    址</pre><input name="address" id="address" type="text" class="address" value="<%=address%>"  onclick="javascript:test8(this);" onblur="javascript:test9(this);"/></li>
			<li><pre>留    言</pre><input name="content" id="content" type="text" class="content" value="<%=content%>"  onclick="javascript:test8(this);" onblur="javascript:test9(this);"/></li>
			<li><pre>时    间</pre><input name="time" id="time" type="text" class="time" value="<%=time%>"  onclick="javascript:test8(this);" onblur="javascript:test9(this);"/></li>
			<li><input id="update" name="update" type="button" class="update selectUser" value="更新" onclick="updatecompany(<%=page1%>)"/></li>
	    </ul>
    </form>
  </body>
</html>
