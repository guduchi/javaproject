<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="initial-scale=1.0, user-scalable=no, width=device-width">
<title>自定义图标</title>
<link rel="stylesheet"
	href="http://cache.amap.com/lbs/static/main1119.css" />
<script type="text/javascript"
	src="http://webapi.amap.com/maps?v=1.3&key=780310951e569d25be9f81c465461676"></script>
<script type="text/javascript"
	src="http://cache.amap.com/lbs/static/addToolbar.js">
	
</script>

</head>
<script type="text/javascript" src="js/jquery.js"></script>
<body onload="ss()">
	<div id="container"></div>
	<script type="text/javascript">
		
	</script>
	<!--  
	function GetRequest() {
		var url = location.search; //获取url中"?"符后的字串 
			var theRequest = new Object();
	if (url.indexOf("?") != -1) {
			var str = url.substr(1);
				strs = str.split("&");
		for ( var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i]
		.split("=")[1]);
		}
		}
    return theRequest;
	}
     var Request = new Object();
		Request = GetRequest();
	var longitude = Request['longitude'];
		var latitude = Request['latitude'];
		-->
	<script type="text/javascript">
		//初始化地图对象，加载地图
		var map = new AMap.Map("container", {
			resizeEnable : true,
			center : [ 125.325187, 43.876943 ],//地图中心点
			zoom : 12
		//地图显示的缩放级别
		});

		function ss() {
			var btu = "在线";
			$
					.post(
							"eelocation/queryAllDiTu.action",
							{
								btu : btu
							},
							function(data) {
								if (data != null) {

									$
											.each(
													data,
													function() {
														//添加点标记，并使用自己的icon
														new AMap.Marker(
																{
																	map : map,
																	position : [
																			this.longitude,
																			this.latitude ],
																	icon : new AMap.Icon(
																			{
																				size : new AMap.Size(
																						40,
																						50), //图标大小
																				image : "http://webapi.amap.com/theme/v1.3/images/newpc/way_btn2.png",
																				imageOffset : new AMap.Pixel(
																						0,
																						-60)
																			})
																});
													});
								}
							}, "json");
		}
	</script>
</body>
</html>