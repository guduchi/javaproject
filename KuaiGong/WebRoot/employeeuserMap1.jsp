<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript">
var imgUrl = "http://www.dkuaigong.com/KuaiGongEmplyeeApp/image/";
function showMap() {
	// 直接加载地图
	var geolocation = new qq.maps.Geolocation(
			"QHPBZ-HFKRW-GDZR4-OGOHU-HF3IT-GCFYR", "myapp");
	var positionNum = 0;
	var options = {
		timeout : 8000
	};
	$.post("eelocation/queryAllDiTu.action", 
		null ,
	function(data) {
		latitude = data[0].latitude;
		longitude = data[0].longitude;
	//获取雇主位置信息
	
		// 定义map变量 调用 qq.maps.Map() 构造函数 获取地图显示容器
		var map = new qq.maps.Map(document.getElementById("map"), {
			center : new qq.maps.LatLng(latitude, longitude), // 地图的中心地理坐标。
			zoomControl : true,
			zoomControlOptions : {
				position : qq.maps.ControlPosition.RIGHT_CENTER
			// 设置地图控件位置靠近左侧
			},
			zoom : 13
		// 地图的中心地理坐标。
		});
		var anchor = new qq.maps.Point(6, 6), size = new qq.maps.Size(24, 24), origin = new qq.maps.Point(
				1, 1), icon = new qq.maps.MarkerImage('img/center.gif', size,
				origin, anchor);
		var marker = new qq.maps.Marker({
			icon : icon,
			origin : origin,
			position : map.getCenter()
		});
//		// 获取雇主id
//		var erid = $("#erid").val();

		var latLng = new qq.maps.LatLng(latitude, longitude);
		 //地址和经纬度之间进行转换服务
	    var geocoder = new qq.maps.Geocoder();
		// 对指定经纬度进行解析
		geocoder.getAddress(latLng);
		// 设置服务请求成功的回调函数
		geocoder.setComplete(function(result) {
			$(".address").html("工作地点："+result.detail.address+result.detail.addressComponents.street+result.detail.addressComponents.town);
		});
		// 若服务请求失败，则运行以下函数
		geocoder.setError(function() {
			alert("出错了，请输入正确的经纬度！！！");
		});
		$.post("eelocation/queryAllDiTu.action",null,
				function(data){
					$.each(data,function() {
					var center = new qq.maps.LatLng(this.latitude,this.longitude);
					var Label = function(opts) {
					qq.maps.Overlay.call(this, opts);
					};
					var d = this;
					
					
										// 继承Overlay基类
										Label.prototype = new qq.maps.Overlay();
										// 定义construct,实现这个接口来初始化自定义的Dom元素
										Label.prototype.construct = function() {
											this.per = document.createElement('div');
											this.per.className = "per";
											this.per.id = 'per';
											var per_photo = document.createElement("img");
											
											if (d.onstatus == "在线") {
														$(this.per).css(
																		"background-image",
																		"url(\'images/per_white.png\')");
													} else {
														$(this.per).css(
																		"background-image",
																		"url(\'images/per_blue.png\')");
													}
													
													
											per_photo.className = "per_photo";
											console
															.log(imgUrl
																	+ d.portrait);
											per_photo.src = imgUrl + d.portrait;   //头像
											var per_name = document.createElement("div");
											var per_username = document.createElement("div");
											per_name.className = "per_name";
											per_username.className = "per_username";
											var b = new Base64();
											per_name.innerHTML = b.decode(d.name);
											per_username.innerHTML = b.decode(d.username);
											$(this.per).append(per_photo,
													per_name,per_username);
											// 将dom添加到覆盖物层，overlayLayer的顺序为容器
											// 1，此容器中包含Polyline、Polygon、GroundOverlay等
											// this.getPanes().overlayLayer.appendChild(this.dom);
											// 将dom添加到覆盖物层，overlayMouseTarget的顺序容器
											// 5，此容器包含透明的鼠标相应元素，用于接收Marker的鼠标事件
											this.getPanes().overlayMouseTarget.appendChild(this.per);
											// 设置自定义覆盖物点击事件
											this.per.onclick = function(){
											alert("姓名:"+per_name.innerHTML);
											alert("电话号:"+per_username.innerHTML);
											};
										};
										// 绘制和更新自定义的dom元素
										Label.prototype.draw = function(){
											// 获取地理经纬度坐标
											var position = this
													.get('position');
											if (position) {
												var pixel = this
														.getProjection()
														.fromLatLngToDivPixel(
																position);
												this.per.style.left = pixel
														.getX()
														+ 'px';
												this.per.style.top = pixel
														.getY()
														+ 'px';
											}
										};

										Label.prototype.destroy = function() {
											// 移除dom
											this.per.parentNode
													.removeChild(this.per);
										};
										var label = new Label({
											map : map,
											origin : origin,
											position : center
										});

									});
				}, "json");

// 经纬度信息
map.panTo(new qq.maps.LatLng(latitude, longitude));
},"json");
}
</script>
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
			
		</div>
		<script src="js/jquery.js"></script>
		<script src="js/Base64.js"></script>

		<script type="text/javascript"
			src="https://3gimg.qq.com/lightmap/components/geolocation/geolocation.min.js"></script>
		<script charset="utf-8" src="http://map.qq.com/api/js?v=2.exp"></script>
	    <script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>  
		
	</body>

</html>
