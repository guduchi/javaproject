<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.bangshuo.kuaigong.utils.Base64"%>
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
	<meta http-equiv="keywords" content="keywo	rd1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>
     <script type="text/javascript" src="js/Base64.js"></script>
      <script type="text/javascript" src="js/UpdateUserJiaoBen.js"></script>
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<script type="text/javascript">
	function getSltValue() {
  var status = document.getElementById("status").options[0].status;
  }
  
  function test(str){
if(typeof(str)=="undefined"){ 
	return "";
	}else{
		return str;
	}
}
  
	</script>
	<!--  <script type="text/javascript">
	function updateSalesman(){
	var b=new Base64();
	var page=$("#page").val();
	var userInfo = $("#userInfo").serialize();
	var id=$("#ID").val();
	var username=$("#username").val();
	var password=$("#password").val();
	var salesmanName=$("#salesmanName").val();
	var address=$("#address").val();
	var sex=$("#sex").val();
	var superiorId=$("#superiorId").val();
	var headPortrait=$("#headPortrait").val();
	var position=$("#position").val();
	var idCard=$("#idCard").val();
	var status=$("#status").val();
	var username=b.encode(username);
	var password=b.encode(password);
	var salesmanName=b.encode(salesmanName);
	var address=b.encode(address);
	var sex=b.encode(sex);
	var position=b.encode(position);
	var idCard=b.encode(idCard);
	var flag = true;
	alert(id);alert(username);alert(password);alert(salesmanName);alert(address);alert(sex);alert(superiorId);
	alert(headPortrait);
	if (salesmanName == "" || salesmanName == null) {
		$("#f2").html("姓名不为空！");
		flag = false;
	} else {
		$("#f2").html("");
	}
	if (flag == true) {
	
		$.post("salesman/update.action", {id:id,username:username,password:password,salesmanName:salesmanName,address:address,sex:sex,superiorId:superiorId,headPortrait:headPortrait,position:position,idCard:idCard,status:status}, function(
				data) {
			if (data != null) {
				alert("修改成功！");
				window.location.href="Salesman.jsp?page="+page;
			}
		}, "json");
	}
	}
	</script>-->
  </head>
   <%
    	String id = request.getParameter("id");
    	
    	String username = request.getParameter("username");
    	username=new String(username.getBytes("iso8859-1"),"UTF-8");
    	
    	String password = request.getParameter("password");
    	password=new String(password.getBytes("iso8859-1"),"UTF-8");
    
    	String salesmanName = request.getParameter("salesmanName");
    	salesmanName =salesmanName.replaceAll(" ", "+");
    	salesmanName=new String(salesmanName.getBytes("iso8859-1"),"UTF-8");
    	
    	String address = request.getParameter("address");
    	address = address.replaceAll(" ", "+");
    	System.out.println(address);
		address=new String(address.getBytes("iso8859-1"),"UTF-8");
    	
		 String sex = request.getParameter("sex");
      	 sex=new String(sex.getBytes("iso8859-1"),"UTF-8");
	
		String superiorId=request.getParameter("superiorId");
	
   		String position=request.getParameter("position");
		position=new String(position.getBytes("iso8859-1"),"UTF-8");
	
		String idCard=request.getParameter("idCard");
		idCard=new String(idCard.getBytes("iso8859-1"),"UTF-8");
	 
		String status = request.getParameter("status");
 	 	status=new String(status.getBytes("iso8859-1"),"UTF-8");
	
		Base64 b=new Base64();
	 %>
  <body>
  	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="Salesman.jsp">业务员列表</a></li>
    <li>修改基本信息</li>
    </ul>
    </div>
    
    <form id="userInfo" action="salesman/update.action" method="post" enctype="multipart/form-data">
					<ul class="userInfo">
					<li><input type="hidden" id="id" value="<%=id%>"></li>
				<!-- 	</ul>
					</form> 	
    <form id="userInfo" method="post">
    <input type="hidden" id="id" value="<%=id%>">
    <ul class="userInfo"> -->
    
    <li>
	    <pre>业务员编号</pre>
	      <input name="ID" id="page" type="hidden" class="ID" value="<%=request.getSession().getAttribute("page")%>"  readonly="readonly"/>
	    <input name="ID" id="ID" type="text" class="ID" value="<%=id%>"  readonly="readonly"/>
   	</li>
   
    <li>
    	<pre>电     话</pre>
 	   <input name="username" id="username" type="text" class="username" value="<%=username%>" />
    </li>
    
    <li>
    	<pre>密     码</pre>
		<input name="password" id="password" type="text" class="password" value="<%=password%>" /> <font color="red" id="f2"></font>
    </li>
    
    <li>
	    <pre>姓     名</pre>
	 <input name="salesmanName" id="salesmanName" type="text" class="salesmanName" value="<%=salesmanName%>"  /> 
    </li>  
    
	<li>
	     <pre>地     址</pre>
	   <input name="address" id="address" type="text" class="address" value="<%=address%>" />
    </li>
    
	<li>
	     <pre>性     别</pre>
	   <input name="sex" id="sex" type="text" class="sex" value="<%=sex%>" />
    </li>
	<li>
	     <pre>上级编号</pre>
	   <input name="superiorId" id="superiorId" type="text" class="superiorId" value="<%=superiorId%>" />
    </li>
    <li>
	     <pre>身 份 证</pre>
	   <input name="idCard" id="idCard" type="text" class="idCard" value="<%=idCard%>"/>
    </li>
	<li>
	     <pre>职     务</pre>
    <select  name="position"  id="position"  class="position paginsel paginselFont" >
<option value="经理"  >经理</option>
<option value="业务员">业务员</option>
</select>
<script>
	 	console.log("123");
		/* 	if(1==1){
			console.log("222");
				console.log(document.getElementById("pos")[1].value);
				 var s = document.getElementById('pos').options[1].selected = true;
			}else{
				 var s = document.getElementById('position');
				 s.options[2].selected = true;
			} */
			var s1 = document.getElementById('position');
			var a = 1;
			s1[a].selected = true;
			</script>
<input type="hidden" id="position"  class="position" value="<%=position%>" onclick="getSltValue()"/>
</li>
	
       <li><pre>状    态</pre>
	<select name="status" id="status" class="status paginsel paginselFont">
<option value="可用">可用</option>
<option value="不可用">不可用</option>
</select>
<script>
	 	console.log("123");
		/* 	if(1==1){
			console.log("222");
				console.log(document.getElementById("pos")[1].value);
				 var s = document.getElementById('pos').options[1].selected = true;
			}else{
				 var s = document.getElementById('position');
				 s.options[2].selected = true;
			} */
			var ss = document.getElementById('status');
			var a = 1;
			ss[a].selected = true;
			</script>
<input type="hidden" id="status"  class="status" value="<%=status%>" onclick="getSltValue()"/>
</li>
<li>
<pre>头     像</pre>
<li><input type="file" name="headPortrait" value="上传文件"/></li>
					<li><input type="hidden" name="id" value="<%=id%>"/></li>
    <li>
   <li><input type="submit" value="确定"/></li>
   
    </ul>
    </form>
    
    <!--  <form action="salesman/update.action" method="post" enctype="multipart/form-data">
					<ul class="userInfo">
					<li><input type="file" name="headPortrait" value="上传文件"/></li>
					<li><input type="submit" value="上传头像"/></li>
					</ul>
					</form> -->
    
  </body>
</html>