<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="OrderForm/css/style.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/Base64.js"></script>
<script src='http://www.ichartjs.com/ichart.latest.min.js'></script>
</head>
<script type="text/javascript">
$(function(){
click();
WeiXin() ;
 ZhiFuBao() ;
 Yuee();
 Quxiao();
});
function click() {
	$("#WeiXin").bind("click", WeiXin);
	$("#ZhiFuBao").bind("click", ZhiFuBao);
	$("#Yuee").bind("click", Yuee);
	$("#Quxiao").bind("click", Quxiao);
}
function WeiXin() {
	$.post("OrderForm/WeiXinMoney.action",null, function(data){
		if(data!=null && data != ""){
			$("#fontCount").html(data[0].weiXinMoney);
		}
	},"json");
}
function ZhiFuBao() {
	$.post("OrderForm/ZhiFuBaoMoney.action", null, function(data){
		if(data!=null && data != ""){
			$("#fontCount1").html(data[0].zhiFuBaoMoney);
		}
	},"json");
}
function Yuee() {
	$.post("OrderForm/YueMoney.action",null, function(data){
		if(data!=null && data != ""){
			$("#fontCount2").html(data[0].yueMoney);
		}
	},"json");
}
function Quxiao(){
	$.post("OrderForm/cancelCount.action",null,function(data){
		if(data!=null && data != ""){
			$("#count2").html(data[0].cancelOrderCount);
		}
	},"json");
}
</script>
<script type="text/javascript">
function Wei(){
window.location.href="OrderWeiXin.jsp";
}
function Zhi(){
window.location.href="OrderZhiFuBao.jsp";
}
function Yu(){
window.location.href="OrderYueZhiFu.jsp";
}
function qu(){
window.location.href="OrderCancel.jsp";
}
</script>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="index.jsp">订单</a>
			</li>
		</ul>
	</div>
	<div class="main_box">
	<div class="sbox_contant">
			<div class="sbox_contant_yes sbox_c">
				<div class="sbox_contant_order ">
				<div class="contant_txt">微信支付总金额</div>
					<div  class="contant_chart" style="background-color: #1485F9"
					 id="fontCount"class="fontCount"  name="fontCount"
					 onclick="Wei()"></div>	
				</div> 
				
				<div class="sbox_contant_income">
				<div class="contant_txt">支付宝支付总金额</div>
					<div class="contant_chart" style="background-color: #DE5427"
					 class="fontCount1" id="fontCount1"  name="fontCount1"
						onclick="Zhi()"></div>
				</div>
				
				<div class="sbox_contant_with">
				<div class="contant_txt">余额支付总金额</div>	
					<div class="contant_chart" style="background-color: #ECC700"
					class="fontCount2" id="fontCount2" name="fontCount2"
						onclick="Yu()"></div>
						</div>
						
							<div class="sbox_contant_go">
					<div class="contant_txt">取消的订单数</div>
					<div class="contant_chart" style="background-color: #00CD00"
					class="count2" id="count2" name="count2"
						onclick="qu()" ></div>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>