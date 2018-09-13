<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="ntg/css/style.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script src='http://www.ichartjs.com/ichart.latest.min.js'></script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="index.jsp">首页</a>
			</li>
		</ul>
	</div>

	<div class="main_box">
		<!--小标题 -->
		<div class="sbox_nav" id="sbox_nav_value">
			<div class="sbox_nav_yes" id="yesterday">昨日</div>
			<div class="sbox_nav_week" id="week">本周</div>
			<div class="sbox_nav_month" id="month">本月</div>
			<div class="sbox_nav_year" id="year">本年</div>
		</div>
		<!-- 小标题相对应的内容 -->
		<div class="sbox_contant">
			<!-- 昨日内容 -->
			<div class="sbox_contant_yes sbox_c">
				<!-- 订单 -->
				<div class="sbox_contant_order ">
					<div class="contant_txt" >订单</div>
					<div class="contant_chart" style="background-color: #1485F9"
						id="chart_order" onclick="QueryOrderForm()"></div>
				</div>
				<!-- 进账 -->
				<div class="sbox_contant_income">
					<div class="contant_txt">进账</div>
					<div class="contant_chart" style="background-color: #DE5427"
						id="chart_income" onclick="QueryIncome()"></div>
				</div>
				<!-- 提现 -->
				<div class="sbox_contant_with">
					<div class="contant_txt">提现</div>
					<div class="contant_chart" style="background-color: #ECC700"
						id="chart_with" onclick="QueryWithdrawYesterday()">1</div>
				</div>
				<!-- 上线人数 -->
				<div class="sbox_contant_go">
					<div class="contant_txt">昨日在线人数</div>
					<div class="contant_chart" style="background-color: #00CD00"
						id="chart_go" onclick="OnlineNumberYesterday()">1</div>
				</div>
				<div id="main" class="sbox_chart">
				</div>
			</div>

		</div>
	</div>
</body>

</html>
