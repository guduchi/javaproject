var imgUrl = "http://www.dkuaigong.com/KuaiGongEmplyerApp/images/";
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
        var erid=Request['erid'];
function showMap() {
	// 直接加载地图
	var geolocation = new qq.maps.Geolocation(
			"QHPBZ-HFKRW-GDZR4-OGOHU-HF3IT-GCFYR", "myapp");
	var positionNum = 0;
	var options = {
		timeout : 8000
	};
	
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

//		 获取雇主id
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
		$.post("erlocation/queryUserInfoLoccation.action",
				{
			erid:erid,longitude:longitude,latitude:latitude
				},
				function(data){
					$.each(data,function() {
										var center = new qq.maps.LatLng(
												this.latitude,
												this.longitude);
										var Label = function(opts) {
											qq.maps.Overlay
													.call(this, opts);
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
											if (d.onstatus ==null) {
												$(this.per)
														.css(
																"background-image",
																"url(\'images/per_white.png\')");
											}
											per_photo.className = "per_photo";
//											console.log(imgUrl + d.hand);
											per_photo.src = imgUrl + d.hand;   //头像
											var per_name = document.createElement("div");
											var per_username = document.createElement("div");
											per_name.className = "per_name";
											per_username.className = "per_username";
											var b = new Base64();
											per_name.innerHTML = b.decode(d.name);
											per_username.innerHTML = b.decode(d.username);
//											var per_star = document.createElement("div");
//											per_star.className = "per_star";
//											per_star.innerHTML = '<img src=\"images/starg.png\"/><img src=\"images/starg.png\"/><img src=\"images/starg.png\"/><img src=\"images/starg.png\"/><img src=\"images/starg.png\"/>';
//											per_star.innerHTML = '<img src=\"images/starg.png\"/><img src=\"images/starg.png\"/><img src=\"images/starg.png\"/><img src=\"images/starg.png\"/><img src=\"images/starg.png\"/>';
											$(this.per).append(per_photo,
													per_name,per_username);
											// star
//											var star = parseInt(d.starlevel) / 10;
//
//											var num_star = star / 2.0;// star的数量
//											var ex = /^\d+$/;
//											var num = 0;
//											if (ex.test(num_star)) {
//												num_star = num_star;
//											} else {
//												num = 1;
//												num_star = Math
//														.floor(num_star);
//											}
//											var num_star_img = $(per_star)
//													.children();
//											for ( var n = 0; n < num_star; n++) {
//												$(num_star_img).get(n).src = "images/starr.png";
//												if (num == 1) {
//													$(num_star_img).get(
//															n + 1).src = "images/starr_half.png";
//												}
//
//											}

											// 将dom添加到覆盖物层，overlayLayer的顺序为容器
											// 1，此容器中包含Polyline、Polygon、GroundOverlay等
											// this.getPanes().overlayLayer.appendChild(this.dom);
											// 将dom添加到覆盖物层，overlayMouseTarget的顺序容器
											// 5，此容器包含透明的鼠标相应元素，用于接收Marker的鼠标事件
											this.getPanes().overlayMouseTarget
													.appendChild(this.per);
											// 设置自定义覆盖物点击事件
											this.per.onclick = function() {
												alert("Hello world");
											};
										};
										// 绘制和更新自定义的dom元素
										Label.prototype.draw = function() {
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

}