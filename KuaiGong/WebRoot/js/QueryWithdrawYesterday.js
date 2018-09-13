$(function(){
	QueryWithdrawYesterday();
	click();
});
function click(){
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}
function QueryWithdrawYesterday(){
	var chooseBtu=$("#btu").val();
    var page=1;
	var pageSize=20;
	var queryUsername=$("#query").val();
	var orderValue=$("#orderValue").val();
	
	var b=new Base64();
	var queryUserName=b.encode(queryUsername);
	//   昨日提现
	if(orderValue=="昨日提现"){
		$.post("withdraw/selectWithdrawByYesterday.action",{chooseBtu:chooseBtu,queryUserName:queryUserName},function(data){
		if(data != null){
			var pageNum=data.length;
			selectSum(Math.ceil(data.length/20));
		}
	},"json");
	$.post("withdraw/selectWithdrawByYesterdayInfo.action",{chooseBtu:chooseBtu,queryUserName:queryUserName,page:page,pageSize:pageSize},function(data){
		if(data!=null){
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append(
						"<tr>" + "<td>" +this.id +  "</td>" 
						+ "<td>"+ b.decode(this.name) + "</td>" 
						+ "<td>"+this.cash+ "</td>"
						+"<td>"+this.totalMoney+ "</td>"
						+ "<td>"+this.time+ "</td>"
						+ "<td>"+this.desc+ "</td>"
						+ "</tr>");
						});
}
}, "json");
	}
	// 本周提现
	if(orderValue=="本周提现"){
		$.post("withdraw/selectWithdrawByWeek.action",{chooseBtu:chooseBtu,queryUserName:queryUserName},function(data){
		if(data != null){
			var pageNum=data.length;
		
			selectSum(Math.ceil(data.length/20));
		}
	},"json");
	$.post("withdraw/selectWithdrawByWeekInfo.action",{chooseBtu:chooseBtu,queryUserName:queryUserName,page:page,pageSize:pageSize},function(data){
		if(data!=null){
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append(
						"<tr>" + "<td>" +this.id +  "</td>" 
						+ "<td>"+ b.decode(this.name) + "</td>" 
						+ "<td>"+this.cash+ "</td>"
						+"<td>"+this.totalMoney+ "</td>"
						+ "<td>"+this.time+ "</td>"
						+ "<td>"+this.desc+ "</td>"
						+ "</tr>");
						});
}
}, "json");
	}
	//本月提现
	
	if(orderValue=="本月提现"){
		$.post("withdraw/selectWithdrawByMonth.action",{chooseBtu:chooseBtu,queryUserName:queryUserName},function(data){
		if(data != null){
			var pageNum=data.length;
		
			selectSum(Math.ceil(data.length/20));
		}
	},"json");
	$.post("withdraw/selectWithdrawByMonthInfo.action",{chooseBtu:chooseBtu,queryUserName:queryUserName,page:page,pageSize:pageSize},function(data){
		if(data!=null){
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append(
						"<tr>" + "<td>" +this.id +  "</td>" 
						+ "<td>"+ b.decode(this.name) + "</td>" 
						+ "<td>"+this.cash+ "</td>"
						+"<td>"+this.totalMoney+ "</td>"
						+ "<td>"+this.time+ "</td>"
						+ "<td>"+this.desc+ "</td>"
						+ "</tr>");
						});
}
}, "json");
	}
	//本年提现
	
	if(orderValue=="本年提现"){
		$.post("withdraw/selectWithdrawByYear.action",{chooseBtu:chooseBtu,queryUserName:queryUserName},function(data){
		if(data != null){
			var pageNum=data.length;
		
			selectSum(Math.ceil(data.length/20));
		}
	},"json");
	$.post("withdraw/selectWithdrawByYearInfo.action",{chooseBtu:chooseBtu,queryUserName:queryUserName,page:page,pageSize:pageSize},function(data){
		if(data!=null){
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append(
						"<tr>" + "<td>" +this.id +  "</td>" 
						+ "<td>"+ b.decode(this.name) + "</td>" 
						+ "<td>"+this.cash+ "</td>"
						+"<td>"+this.totalMoney+ "</td>"
						+ "<td>"+this.time+ "</td>"
						+ "<td>"+this.desc+ "</td>"
						+ "</tr>");
						});
}
}, "json");
	}
}
function selectWithdrawByYearInfo(page){
	var chooseBtu=$("#btu").val();
	var page=page;
	var pageSize=20;
	var queryUsername=$("#query").val();
	var b=new Base64();
	var queryUserName=b.encode(queryUsername);
	$.post("withdraw/selectWithdrawByYearInfo.action",{chooseBtu:chooseBtu,queryUserName:queryUserName,page:page,pageSize:pageSize},function(data){
		if(data!=null){
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append(
						"<tr>" + "<td>" +this.id +  "</td>" 
						+ "<td>"+ b.decode(this.name) + "</td>" 
						+ "<td>"+this.cash+ "</td>"
						+"<td>"+this.totalMoney+ "</td>"
						+ "<td>"+this.time+ "</td>"
						+ "<td>"+this.desc+ "</td>"
						+ "</tr>");
						});
}
}, "json");
	
}

function selectWithdrawByMonthInfo(page){
	var chooseBtu=$("#btu").val();
	var page=page;
	var pageSize=20;
	var queryUsername=$("#query").val();
	var b=new Base64();
	var queryUserName=b.encode(queryUsername);
	$.post("withdraw/selectWithdrawByMonthInfo.action",{chooseBtu:chooseBtu,queryUserName:queryUserName,page:page,pageSize:pageSize},function(data){
		if(data!=null){
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append(
						"<tr>" + "<td>" +this.id +  "</td>" 
						+ "<td>"+ b.decode(this.name) + "</td>" 
						+ "<td>"+this.cash+ "</td>"
						+"<td>"+this.totalMoney+ "</td>"
						+ "<td>"+this.time+ "</td>"
						+ "<td>"+this.desc+ "</td>"
						+ "</tr>");
						});
}
}, "json");
	
}


function selectWithdrawByWeekInfo(page){
	var chooseBtu=$("#btu").val();
	var page=page;
	var pageSize=20;
	var queryUsername=$("#query").val();
	var b=new Base64();
	var queryUserName=b.encode(queryUsername);
	$.post("withdraw/selectWithdrawByWeekInfo.action",{chooseBtu:chooseBtu,queryUserName:queryUserName,page:page,pageSize:pageSize},function(data){
		if(data!=null){
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append(
						"<tr>" + "<td>" +this.id +  "</td>" 
						+ "<td>"+ b.decode(this.name) + "</td>" 
						+ "<td>"+this.cash+ "</td>"
						+"<td>"+this.totalMoney+ "</td>"
						+ "<td>"+this.time+ "</td>"
						+ "<td>"+this.desc+ "</td>"
						+ "</tr>");
						});
}
}, "json");
	
}
function selectWithdrawByYesterdayInfo(page){
	var chooseBtu=$("#btu").val();
	var page=page;
	var pageSize=20;
	var queryUsername=$("#query").val();
	var b=new Base64();
	var queryUserName=b.encode(queryUsername);
	$.post("withdraw/selectWithdrawByYesterdayInfo.action",{chooseBtu:chooseBtu,queryUserName:queryUserName,page:page,pageSize:pageSize},function(data){
		if(data!=null){
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append(
						"<tr>" + "<td>" +this.id +  "</td>" 
						+ "<td>"+ b.decode(this.name) + "</td>" 
						+ "<td>"+this.cash+ "</td>"
						+"<td>"+this.totalMoney+ "</td>"
						+ "<td>"+this.time+ "</td>"
						+ "<td>"+this.desc+ "</td>"
						+ "</tr>");
						});
}
}, "json");
	
}
//下拉的页数
function selectSum(pageNum,page) {
	$("[name=select]").empty();
	var i = 1;
	$("[name=sum]").html(pageNum);
//	$("[name=page]").html(page);
	while (i <= pageNum) {
		$("[name=select]").append("<option >" + i + "</option>");
		i++;
	}
}
//下拉选择页数
function selectNumber() {
	page= $(this).children('option:selected').val();
	var orderValue=$("#orderValue").val();
	$("[name=page]").html(page);
	if(orderValue=="昨日提现"){
		selectWithdrawByYesterdayInfo(page);
	}
	if(orderValue=="本周提现"){
		selectWithdrawByWeekInfo(page);
	}
	if(orderValue=="本月提现"){
		selectWithdrawByWeekInfo(page);
	}
	if(orderValue=="本年提现"){
		selectWithdrawByYearInfo(page);
	}
}
//下一页
function nextPage() {
	var page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	var orderValue=$("#orderValue").val();
	if (parseInt(page) >= parseInt(sum)) {
		alert("已经是最后一页了！");
	} else {
		var page1=parseInt(page)+1;
		$("[name=page]").html(page1);
		page=parseInt(page)+1;
 	if(orderValue=="昨日提现"){
		selectWithdrawByYesterdayInfo(page);
	}
	if(orderValue=="本周提现"){
		selectWithdrawByWeekInfo(page);
	}
	if(orderValue=="本月提现"){
		selectWithdrawByWeekInfo(page);
	}
	if(orderValue=="本年提现"){
		selectWithdrawByYearInfo(page);
	}
	//	$("[name=select]").append("<option selected>" + page1 + "</option>");
	}

}
function lastPage() {
	page = $("[name=page]").html();
	var orderValue=$("#orderValue").val();
	if (page < 2) {
		alert("已经是第一页了！");
	} else {
		var page1 = page - 1;
		$("[name=page]").html(page1);
		page-=1;
	//	$("[name=select]").append("<option selected>" + page1 + "</option>");
		if(orderValue=="昨日提现"){
			selectWithdrawByYesterdayInfo(page);
		}
		if(orderValue=="本周提现"){
			selectWithdrawByWeekInfo(page);
		}
		if(orderValue=="本月提现"){
			selectWithdrawByWeekInfo(page);
		}
		if(orderValue=="本年提现"){
			selectWithdrawByYearInfo(page);
		}
	}
	
}
