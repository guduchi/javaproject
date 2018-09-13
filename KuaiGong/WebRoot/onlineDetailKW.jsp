<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'onlineDetailKW.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/queryOnlineInfoDetailKW.js"></script>
	<script  type="text/javascript" src="js/echarts.simple.min.js"></script>
	 <style type="text/css">
        *{
            margin: 0;
            padding: 0;
        }
        .main{
            width: 100%;
            height:80%;
            position: absolute;
        }
        .quarter-div{
            width: 50%;
            height: 50%;
            float: left;
        }
        .white{
            background-color: #fff
        }
        .green{
            background-color: #fff;
        }
        .orange{
            background-color: #fff;
        }
        .yellow{
            background-color: #fff;
        }
    </style>

  </head>
  
  <body>
  <%
  	String eeid = request.getParameter("eeid");
   %>
  <input type="hidden" id="eeid" value="<%=eeid%>">
  
  
  
  <div class="place">
    <span>位置:</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="onlineInformation.jsp">工人在线列表</a></li>
     <li><a href="javascript:void(0);">详细信息</a></li>
    </ul>
    </div>
    <div class="main">
        <div id="first" class="quarter-div white"> 
     <!--   <script type="text/javascript">
       </script> -->
        </div>
        
        <div id="second"class="quarter-div white">
        </div>
        <div id="third"class="quarter-div white"><script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        </script></div>
        <div id="fourth"class="quarter-div white"> </div>
    </div>
  </body>
</html>
