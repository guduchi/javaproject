$(function() {
	click();
	yesterday();
	online();
});
function click() {
    $("#yesterday").bind("click", yesterday);
	$("#week").bind("click", week);
	$("#month").bind("click", month);
	$("#year").bind("click", year);
}

$(document).ready(function() {
	var sbox_nav_d = $(".sbox_nav").find("div");
	sbox_nav_d.click(function() {
		var t_ind = $(this).index();
		sbox_nav_d.css({
			"line-height" : "52px",
			"border" : "1px solid rgb(96, 125, 165)"
		});// 全部nav标签行高为52px
		$(this).css({
			"line-height" : "59px",
			"border-bottom" : "1px solid #fff"
		});// 当前点击的nav标签行高为60px
	});
});

function online() {
	$("#chart_go").html("");
	$.post("onlineInformation/selectOnlineByYersday.action", null, function(
			data, status) {
		if (data != null && data != "") {
			$("#chart_go").append(data.length);
		} else {
			$("#chart_go").append("0");
		}
	}, "json");
}

function yesterday() {
	$(".sbox_contant_order .contant_txt").html("");
	$(".sbox_contant_order .contant_txt").append("昨日订单");
	

	$(".sbox_contant_income .contant_txt").html("");
	$(".sbox_contant_income .contant_txt").append("昨日进账");

	$(".sbox_contant_with .contant_txt").html("");
	$(".sbox_contant_with .contant_txt").append("昨日提现");

	getOrderByYesterday();
	getIncomeByYesterday();
	getWithdrawByYesterday();
}
function week() {
	$(".sbox_contant_order .contant_txt").html("");
	$(".sbox_contant_order .contant_txt").append("本周订单");

	$(".sbox_contant_income .contant_txt").html("");
	$(".sbox_contant_income .contant_txt").append("本周进账");

	$(".sbox_contant_with .contant_txt").html("");
	$(".sbox_contant_with .contant_txt").append("本周提现");
	getOrderByWeek();
	getIncomeByWeek();
	getWithdrawByWeek();
}
function month() {
	$(".sbox_contant_order .contant_txt").html("");
	$(".sbox_contant_order .contant_txt").append("本月订单");

	$(".sbox_contant_income .contant_txt").html("");
	$(".sbox_contant_income .contant_txt").append("本月进账");

	$(".sbox_contant_with .contant_txt").html("");
	$(".sbox_contant_with .contant_txt").append("本月提现");

	getOrderByMonth();
	getIncomeByMonth();
	getWithdrawByMonth();
}
function year() {
	$(".sbox_contant_order .contant_txt").html("");
	$(".sbox_contant_order .contant_txt").append("本年订单");

	$(".sbox_contant_income .contant_txt").html("");
	$(".sbox_contant_income .contant_txt").append("本年进账");

	$(".sbox_contant_with .contant_txt").html("");
	$(".sbox_contant_with .contant_txt").append("本年提现");
	getOrderByYear();
	getIncomeByYear();
	getWithdrawByYear();
}

function getOrderByYesterday() {
	$("#chart_order").html("");
	$.post("OrderForm/selectOrderByYesterday.action", null, function(data,
			status) {
		if (data != null && data != "") {
			$("#chart_order").append(data.length);
		} else {
			$("#chart_order").append("0");
		}

	}, "json");
}
function getOrderByWeek() {
	$("#chart_order").html("");
	$.post("OrderForm/selectOrderByWeek.action", null, function(data, status) {
		if (data != null && data != "") {
			$("#chart_order").append(data.length);
		} else {
			$("#chart_order").append("0");
		}
	}, "json");
}
function getOrderByMonth() {
	$("#chart_order").html("");
	$.post("OrderForm/selectOrderByMonth.action", null, function(data, status) {
		if (data != null && data != "") {
			$("#chart_order").append(data.length);
		} else {
			$("#chart_order").append("0");
		}
	}, "json");
}
function getOrderByYear() {
	$("#chart_order").html("");
	$.post("OrderForm/selectOrderByYear.action", null, function(data, status) {
		if (data != null && data != "") {
			$("#chart_order").append(data.length);
		} else {
			$("#chart_order").append("0");
		}
	}, "json");
}

function getIncomeByYesterday() {
	$("#chart_income").html("");
	var weixinCount = 0;
	var alipayCount = 0;
	var balanceCount = 0;
	var rechargeCount = 0;
	var count = 0;
	$.post("OrderForm/selectOrderFinishByYesterday.action", null, function(
			data, status) {
		$.each(data, function() {
			if (this.payment == "微信支付") {
				weixinCount = weixinCount + (this.actualcost) * 1;
			}
			if (this.payment == "支付宝支付") {
				alipayCount = alipayCount + (this.actualcost) * 1;
			}
			if (this.payment == "余额支付") {
				balanceCount = balanceCount + (this.actualcost) * 1;
			}
		});
		$("#chart_income").html("");
		count = rechargeCount + weixinCount + alipayCount + balanceCount;
		$("#chart_income").append(count);
	}, "json");
	$.post("Recharge/selectRechargeByYesterday.action", null, function(data,
			status) {
		if (data != null && data != "") {
			$.each(data, function() {
				rechargeCount = rechargeCount + (this.recharge) * 1;
			});
		} else {
			rechargeCount = 0;
		}
		$("#chart_income").html("");
		count = rechargeCount + weixinCount + alipayCount + balanceCount;
		$("#chart_income").append(count);
	}, "json");
}

function getIncomeByWeek() {
	$("#chart_income").html("");
	var weixinCount = 0;
	var alipayCount = 0;
	var balanceCount = 0;
	var rechargeCount = 0;
	var count = 0;
	$.post("OrderForm/selectOrderFinishByWeek.action", null, function(data,
			status) {
		$.each(data, function() {
			if (this.payment == "微信支付") {
				weixinCount = weixinCount + (this.actualcost) * 1;
			}
			if (this.payment == "支付宝支付") {
				alipayCount = alipayCount + (this.actualcost) * 1;
			}
			if (this.payment == "余额支付") {
				balanceCount = balanceCount + (this.actualcost) * 1;
			}
		});
		$("#chart_income").html("");
		count = rechargeCount + weixinCount + alipayCount + balanceCount;
		$("#chart_income").append(count);
	}, "json");
	$.post("Recharge/selectRechargeByWeek.action", null,
			function(data, status) {
				if (data != null && data != "") {
					$.each(data, function() {
						rechargeCount = rechargeCount + (this.recharge) * 1;
					});
				} else {
					rechargeCount = 0;
				}
				$("#chart_income").html("");
				count = rechargeCount + weixinCount + alipayCount
						+ balanceCount;
				$("#chart_income").append(count);
			}, "json");

}

function getIncomeByMonth() {
	$("#chart_income").html("");
	var weixinCount = 0;
	var alipayCount = 0;
	var balanceCount = 0;
	var rechargeCount = 0;
	var count = 0;
	$.post("OrderForm/selectOrderFinishByMonth.action", null, function(data,
			status) {
		$.each(data, function() {
			if (this.payment == "微信支付") {
				weixinCount = weixinCount + (this.actualcost) * 1;
			}
			if (this.payment == "支付宝支付") {
				alipayCount = alipayCount + (this.actualcost) * 1;
			}
			if (this.payment == "余额支付") {
				balanceCount = balanceCount + (this.actualcost) * 1;
			}
		});
		
	
		
		$("#chart_income").html("");
		count = rechargeCount + weixinCount + alipayCount + balanceCount;
		$("#chart_income").append(count);
	}, "json");
	
	$.post("Recharge/selectRechargeByMonth.action", null,
			function(data, status) {
				if (data != null && data != "") {
					$.each(data, function() {
						rechargeCount = rechargeCount + (this.recharge) * 1;
					});
				} else {
					rechargeCount = 0;
				}
				$("#chart_income").html("");
				count = rechargeCount + weixinCount + alipayCount
						+ balanceCount;
				$("#chart_income").append(count);
			}, "json");
}

function getIncomeByYear() {
	$("#chart_income").html("");
	var weixinCount = 0;
	var alipayCount = 0;
	var balanceCount = 0;
	var rechargeCount = 0;
	var count = 0;
	$.post("OrderForm/selectOrderFinishByYear.action", null, function(data,
			status) {
		$.each(data, function() {
			if (this.payment == "微信支付") {
				weixinCount = weixinCount + (this.actualcost) * 1;
			}
			if (this.payment == "支付宝支付") {
				alipayCount = alipayCount + (this.actualcost) * 1;
			}
			if (this.payment == "余额支付") {
				balanceCount = balanceCount + (this.actualcost) * 1;
			}
		});
		$("#chart_income").html("");
		count = rechargeCount + weixinCount + alipayCount + balanceCount;
		$("#chart_income").append(count);
	}, "json");

	$.post("Recharge/selectRechargeByYear.action", null,
			function(data, status) {
				if (data != null && data != "") {
					$.each(data, function() {
						rechargeCount = rechargeCount + (this.recharge) * 1;
					});
				} else {
					rechargeCount = 0;
				}
				$("#chart_income").html("");
				count = rechargeCount + weixinCount + alipayCount
						+ balanceCount;
				$("#chart_income").append(count);
			}, "json");
}

function getWithdrawByYesterday() {
	
	$("#chart_with").html("");
	var cash = 0;
	$.post("withdraw/selectWithdrawByYesterday.action", null, function(data,status) {
		$.each(data, function() {
		
			cash = cash + (this.cash) * 1;
			
		});
		$("#chart_with").html("");
		$("#chart_with").append(cash);
	}, "json");
	$("#chart_with").html("");
	$("#chart_with").append(cash);
}
function getWithdrawByWeek() {
	$("#chart_with").html("");
	var cash = 0;
	$.post("withdraw/selectWithdrawByWeek.action", null,
			function(data, status) {
				$.each(data, function() {
					cash = cash + (this.cash) * 1;
				});
				$("#chart_with").html("");
				$("#chart_with").append(cash);
			}, "json");
	$("#chart_with").html("");
	$("#chart_with").append(cash);
}
function getWithdrawByMonth() {
	$("#chart_with").html("");
	var cash = 0;
	$.post("withdraw/selectWithdrawByMonth.action", null,
			function(data, status) {
				$.each(data, function() {
					cash = cash + (this.cash) * 1;
				});
				$("#chart_with").html("");
				$("#chart_with").append(cash);
			}, "json");
	$("#chart_with").html("");
	$("#chart_with").append(cash);

}
function getWithdrawByYear() {
	var cash = 0;
	$.post("withdraw/selectWithdrawByYear.action", null,
			function(data, status) {
				$.each(data, function() {
					cash = cash + (this.cash) * 1;
				});
				$("#chart_with").html("");
				$("#chart_with").append(cash);
			}, "json");
	$("#chart_with").html("");
	$("#chart_with").append(cash);
}

$(function() {
	$.post("onlineInformation/selectOnlineByStatistics.action", null,
			function(data, status) {
		    var chart = iChart.create({
			render : "main",
			width : 1100,
			height : 200,
			background_color : "#fefefe",
			gradient : false,
			color_factor : 0.2,
			border : {
				color : "BCBCBC",
				width : 1
			},
			align : "center",
			offsetx : 0,
			offsety : 0,
			sub_option : {
				border : {
					color : "#BCBCBC",
					width : 1
				},
				label : {
					fontweight : 500,
					fontsize : 11,
					color : "#4572a7",
					sign : "square",
					sign_size : 12,
					border : {
						color : "#BCBCBC",
						width : 1
					},
					background_color : "#fefefe"
				}
			},
			shadow : true,
			shadow_color : "#666666",
			shadow_blur : 2,
			showpercent : false,
			column_width : "70%",
			bar_height : "70%",
			radius : "90%",
			title : {
				text : "在线人数统计",
				color : "#111111",
				fontsize : 20,
				font : "微软雅黑",
				textAlign : "center",
				height : 30,
				offsetx : 0,
				offsety : 0
			},
			subtitle : {
				text : "",
				color : "#111111",
				fontsize : 16,
				font : "微软雅黑",
				textAlign : "center",
				height : 20,
				offsetx : 0,
				offsety : 0
			},
			footnote : {
				text : "",
				color : "#111111",
				fontsize : 12,
				font : "微软雅黑",
				textAlign : "right",
				height : 20,
				offsetx : 0,
				offsety : 0
			},
			legend : {
				enable : false,
				background_color : "#fefefe",
				color : "#333333",
				fontsize : 12,
				border : {
					color : "#BCBCBC",
					width : 1
				},
				column : 1,
				align : "right",
				valign : "center",
				offsetx : 0,
				offsety : 0
			
			},
			coordinate : {
				width : "80%",
				height : "84%",
				background_color : "#ffffff",
				axis : {
					color : "#a5acb8",
					width : [ 1, "", 1, "" ]
				},
				grid_color : "#d9d9d9",
				label : {
					fontweight : 500,
					color : "#666666",
					fontsize : 11
				}
			},
			label : {
				fontweight : 500,
				color : "#666666",
				fontsize : 11
			},
			type : "column2d",
			
			data : [{
				name : "周一",
				value : data.monday,
				color : "#4572a7",
				//hover:onMouseDown(data)
					}, {
				name : "周二",
				value : data.tuesday,
				color : "#aa4643"
			}, {
				name : "周三",
				value : data.wednesday,
				color : "#89a54e"
			}, {
				name : "周四",
				value : data.thursday,
				color : "#0dd0f7"
			}, {
				name : "周五",
				value : data.friday,
				color : "#4be612"
			}, {
				name : "周六",
				value : data.saturday,
				color : "#e07c09"
			}, {
				name : "周日",
				value : data.sunday,
				color : "#0e7af5"	
					
			}]
		});
	            chart.draw();
	
			}, "json");
	

});

function QueryOrderForm(){
var orderValue=$(".sbox_contant_order .contant_txt").html();

window.location.href="QueryOrderFormToYesterday.jsp?orderValue="+orderValue;	


}
//查看收入
function QueryIncome(){
	var orderValue=$(".sbox_contant_income .contant_txt").html();
	window.location.href="QueryIncome.jsp?orderValue="+orderValue;	
}
function QueryWithdrawYesterday(){
	var orderValue=$(".sbox_contant_with .contant_txt").html();
	
	window.location.href="QueryWithdrawYesterday.jsp?orderValue="+orderValue;	
}
function OnlineNumberYesterday(){
	//var orderValue=$(".sbox_contant_with .contant_txt").html(); ?orderValue="+orderValue
	window.location.href="OnlineNumberYesterday.jsp";	
}

//function onMouseDown(data){
//if(data.name="周一"){
//	window.location.href="online.jsp";
//}
//}