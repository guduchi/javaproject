<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
	
		<link rel="stylesheet" href="css/main.css" />
		<title>点快工</title>
		<style type="text/css">
*{
	text-shadow:none;
	}
.per {
	width: 190px;
    height: 70px;
    position: absolute;
    /* background-image: url(images/per_blue.png); */
    background-size: 175px 70px;
    background-repeat: no-repeat;
}

.per_photo {
	float: left;
    width: 32px;
    height: 32px;
    border-radius: 50%;
    margin-left: 30px;
    margin-top: 17px;
    margin-right: 4px;
    border-radius: 50%;
}
.per_name{
    margin-top: 18px;
    font-size: 0.9em;
}
.per_username{
    font-size: 0.9em;
    margin-top: 6px;
}
</style>
	<script>
			/*页面加载完成再显示*/
			document.onreadystatechange = function () {
				if (document.readyState == "complete") {
				    document.body.style.display = "block";
				} else {
				    document.body.style.display = "none";
				};
			};
		</script>
	</head>

	<body onload="showMap()">

		<div class="container_box">
			<div class="container" id="container">

				
				<div class="map" id="map">

				</div>
			</div>
			<%
				String erid = request.getSession().getAttribute("erid") + "";
				if (erid == null || erid.equals("")) {
					response.sendRedirect("login.jsp");
				}
			%>
			
			<div class="search">
				<input type="search" style="disabled="disabled";padding-top: 0px;float: left;width: 80%;" name="search" id="search" placeholder="搜索内容...">
				<input type="text" style="display: none;" id="erid" value="<%=erid%>" />
			</div>
			<div class="go">
				<button  style="background-color:#4f9df3;color: #FFFFFF;text-shadow: none;">搜索</button>
			</div>

			
		</div>
	
	
		<script src="js/jquery.js"></script>
		<script src="js/Base64.js"></script>

		<script type="text/javascript"
			src="https://3gimg.qq.com/lightmap/components/geolocation/geolocation.min.js"></script>
		<script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp"></script>
		<script type="text/javascript" src="js/main1.js"></script>
	    <script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>  
		
	</body>

</html>
