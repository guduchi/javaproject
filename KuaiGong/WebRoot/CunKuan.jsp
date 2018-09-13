<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CunKuan.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="css/add.css" type="text/css" media="screen" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
function ChongZhi11(){

	var id=$("#id").val();
	var flag=true;
	var query=$("#query").val();
	if(query==""||query==null){
	$("#f2").html("请输入金额！");
	flag=false;
	}else{
	$("#f2").html("");
	}
	if(flag==true){
	$.post("wallet1/chongzhi1.action",{id:id,query:query},function(data){
		if(data!=null){
	      alert("充值成功");
			window.location.href="EmployerUserWallet.jsp";
				
			}
			else{
				alert("充值失败");
			}
			
		},"json");
	}
	}
	</script>
<script type="text/javascript" src="js/text.js"></script>

  </head>
    <%
  String id=request.getParameter("id");
  String page1=request.getParameter("page");
   %>
  <body>
    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="employeruser.jsp?page=<%=page1%>">雇主列表</a></li>
    </ul>
    </div>
  
  <form action="" id="userInfo">
   <input type="hidden" id="id" value="<%=id%>">
    <input type="hidden" id="page" value="<%=page1%>">

   <div class="passText">金额</div>
  <ul class="userInfo">
   
 <li><input name="query" id = "query"  type="text" class="query quee" onload="queryUser(1)"  value=""/><font color="red" id="f2"></font></li>
  
 <li><input type="button"  onclick="ChongZhi11()" value="雇主充值" id="update" class="selectUser"/></li>
  </ul>
  </form>
  </body>
</html>
