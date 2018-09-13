<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'register.jsp' starting page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base target="_self">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/text.js"></script>
<script type="text/javascript" src="js/Base64.js"></script>
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
<script type="text/javascript">
	function check(temp){
		var re = /^1\d{10}$/
						
		if(!re.test(temp.value)){
			alert("手机号码格式不正确，请重新输入!");
			return;
		
		}
		
	}
</script>


<script type="text/javascript">

/* function isCardNo(card) 
{ 
  // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X 
  var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
  if(reg.test(card) === false) 
  { 
    alert("身份证输入不合法"); 
    return false; 
  } else if(reg.test(card) === true){
   return true;
  }
} */

</script>

<script type="text/javascript">
	//$(function(){ 
//$('#file').parents('form').attr('enctype', 'multipart/form-data'); 
//}); 

	function update(){
	var id=$("#id").val();
	var headPortrait=$("#headPortrait").val();
	var form = document.createElement('form'); 
	form.id="headPortrait"; 
	 form.action="salesman/uploadHandPortrait.action"; 
	 form.method='post'; 
	 form.name="headPortrait";
	 form.encding="multipart/form-data";
	var flag = true;
	alert(from);
	alert(id);
	alert(headPortrait);
		$.post("salesman/uploadHandPortrait.action", {id:id,headPortrait:headPortrait}, function(
				data) {
			if (data != null) {
				alert("成功！");
				window.location.href="Salesman.jsp";
			}
		}, "json");
	}
	
</script>
<!-- 
<script type="text/javascript">
$(function(){
$('#file').parents('form').attr('enctype', 'multipart/form-data'); 
});
function manager(){
 	//var b=new Base64();
	var username=$("#username").val();
	var password=$("#password").val();
	var salesmanName=$("#salesmanName").val();
	var address=$("#address").val();
	var sex=$("#sex").val();
	var superiorId=$("#superiorId").val();
	var position=$("#position").val();
	var idCard=$("#idCard").val();
	var regid=$("#regid").val();
	//var headPortrait=$("#headPortrait").val();
	//var regtime=$("#regtime").val();
	var status = $("#status").val();
	//var username=b.decode(username);
	//var password=b.decode(password);
	//var salesmanName=b.decode(salesmanName);
	//var address=b.decode(address);
	//var sex=b.decode(sex);
	//var position=b.decode(position);
	//var idCard=b.decode(idCard);
	$.post("salesman/register.action",{username:username,password:password,salesmanName:salesmanName,address:address,sex:sex,superiorId:superiorId,position:position,idCard:idCard,regid:regid,status:status},function(data,status){
		if(data!=null){
			alert("添加成功");
			window.location.href="Salesman.jsp";
		} 
	}, "json");
}
</script> -->
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="index.jsp">首页</a>
			</li>
			<li><a href="Salesman.jsp">业务员列表</a>
			</li>
			<li>添加</li>
		</ul>
	</div>
	<form id="userInfo" action="salesman/register.action" method="post"
		enctype="multipart/form-data">
		<ul class="userInfo">
			<li><pre>电    话</pre><input onblur="check(this)" maxlength="16"
				onkeyup="value=value.replace(/[^\d]/g,'') "
				onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
				name="username" id="username" type="text" class="username" value="" />
			</li>
			<li><pre>密    码</pre><input name="password"
				onkeyup="value=value.replace(/[\W]/g,'') "
				onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
				id="password" type="password" class="username" value="" />
			</li>
			<li><pre>名    字</pre><input name="salesmanName"
				id="salesmanName" type="text" class="salesmanName" value="" />
			</li>
			<li><pre>地    址</pre><input name="address" id="address"
				type="text" class="address" value="" /></li>
			<li><pre>性    别</pre><input name="sex" id="sex" type="text"
				class="sex" value="" />
			</li>
			<li><pre>上级编号</pre><input name="superiorId"
				onkeyup="value=value.replace(/[^\d]/g,'') "
				onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
				id="superiorId" type="text" class="superiorId" value="" />
			</li>
			<li><pre>身 份 证</pre><input onblur="isCardNo(this)" name="idCard" 
				onkeyup="value=value.replace(/[\W]/g,'') "
				onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
				id="idCard" type="text" class="idCard" value="" />
			</li>
			<!-- 	<li><pre></pre><input name="regid" id="regid" type="text" class="regid"  value=""  /></li> -->
			<li><pre>职    务</pre>
			<li><select name="position" id="position"
				class=" position paginsel paginselFont">
					<option value="经理">经理</option>
					<option value="业务员">业务员</option>
			</select></li>
			<li><pre>状    态</pre>
			<li><select name="status" id="status"
				class=" status paginsel paginselFont">
					<option value="可用">可用</option>
					<option value="不可用">不可用</option>
			</select></li>

			<li><pre>头     像</pre>
			<li><input type="file" name="headPortrait" value="上传文件" />
			</li>
			<li>
			<li><input type="submit" value="确定" />
			</li>
		</ul>
	</form>

	<!--   <form action="salesman/uploadHandPortrait.action" method="post" enctype="multipart/form-data">
					<ul class="userInfo">
					<li><input type="file" name="headPortrait" value="上传文件"/></li>
					<li><input type="submit" value="上传头像"/></li>
					</ul>
					</form>-->

</body>
</html>