<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updataLocation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/updateWlocation.js"></script>
<script type="text/javascript" src="js/updateGlotion.js"></script>
  </head>
 <!-- 
  <%
  
    	String id = request.getParameter("id");
    	
    	String username = request.getParameter("username	");
    	
    	String password = request.getParameter("password");
    	
    	String companyname = request.getParameter("companyname");
    	
    	String name = request.getParameter("name");
    	
    	String shielc = request.getParameter("shielc");
    	
    	String status = request.getParameter("status");
    	
    	String grade= request.getParameter("grade");
    	
    	String credits= request.getParameter("credits");
    	
    	String prsentintegral= request.getParameter("prsentintegral");
    	
    	String longitude= request.getParameter("longitude");
    	
    	String latitude= request.getParameter("latitude");
    	
    	String money= request.getParameter("money");
    	
       String starlevel=request.getParameter("starlevel");
       
       String payment=request.getParameter("payment");
   %>
 -->
    <body>
    
    
    <div class="rightinfo">
  

<table class="imgtable" border="1">
    
 <thead>
<tr>
<th>id<div><input name="id" id="id" type="text" class="id" value="<%=id%>"  readonly="readonly"/></div></th>
<th>用户名<div><input name="username" id="username" type="text" class="username" value="<%=username%>" onclick="JavaScript:this.value=''"   /></div></th>
<th>密码<div><input name="password" id="password" type="text" class="password" value="<%=password%>" onclick="JavaScript:this.value=''"   /></div></th>
<th>姓名<div><input name="name" id="name" type="text" class="name" value="<%=name%>" onclick="JavaScript:this.value=''"   /></div></th>
<th>屏蔽<div><input name="shielc" id="shielc" type="text" class="shielc" value="<%=shielc%>" onclick="JavaScript:this.value=''"   /></div></th>
<th>状态<div><input name="status" id="status" type="text" class="status" value="<%=status%>" onclick="JavaScript:this.value=''"   /></div></th>
</tr>
<tr>

<th>等级<div><input name="grade" id="id" type="text" class="grade" value="<%=grade%>" onclick="JavaScript:this.value=''"/></div></th>
<th>现积分<div><input name="credits" id="credits" type="text" class="credits" value="<%=credits%>" onclick="JavaScript:this.value=''"   /></div></th>
<th>总积分<div><input name="prsentintegral" id="prsentintegral" type="text" class="prsentintegral" value="<%=prsentintegral%>" onclick="JavaScript:this.value=''"   /></div></th>
<th>经度<div><input name="longitude" id="longitude" type="text" class="longitude" value="<%=longitude%>" onclick="JavaScript:this.value=''"   /></div></th>
<th>纬度<div><input name="latitude" id="latitude" type="text" class="latitude" value="<%=latitude%>" onclick="JavaScript:this.value=''"   /></div></th>
<th>优惠卷<div><input name="money" id="money" type="text" class="money" value="<%=money%>" onclick="JavaScript:this.value=''"   /></div></th>
</tr> 
<tr>
<th>星级<div><input name="starlevel" id="starlevel" type="text" class="starlevel" value="<%=starlevel%>" onclick="JavaScript:this.value=''"/></div></th>
<th>支付方式<div><input type="text" name="payment" id="payment" class="payment" value="<%= payment%>" onclick="JavaScript:this.value=''" ></div>
</tr>
<tr>
<th><input id="update" name="update" type="button" class="update" value="更新" onclick="updateEmployerUserToAll()"/></th>
</tr>
</table>
    
</div>
     
    
    
    
   
  </body>
 
</html>
