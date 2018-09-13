$(function() {
	click();
	queryUserPage();
});
function click() {
	$("[name=queryByid]").bind("change",queryPage);
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}

function queryUserPage(){
	var page=$("#page").val();
	if(page=="null" || page==""){
		page=1;
	}else{
		page=page;
	}
	var pageSize =22;
	var b = new Base64();
	var salesmanName = $("#salesmanName").val();
	var username = $("#username").val();
	var starttime = $("#starttime").val();
	var endtime = $("#endtime").val();
	var status = $("#status").val();
	  var salesmanName=b.encode(salesmanName);
	  var username=b.encode(username);
$.post("SignIn/selectSalesmanSignIn.action",{page:page,pageSize:pageSize,salesmanName:salesmanName,username:username,starttime:starttime,endtime:endtime,status:status},
			function(data) {
				if (data != null) {
					selectSum(Math.ceil(data/22),page);
				}
			}, "json");
$.post("SignIn/count.action",{salesmanName:salesmanName,username:username,starttime:starttime,endtime:endtime,status:status},function(data){
	if(data!=null){
		$("#count").html(data);
	}
},"json");
$.post("SignIn/selectSalesmanSignInPage.action",{page:page,pageSize:pageSize,salesmanName:salesmanName,username:username,starttime:starttime,endtime:endtime,status:status},
		function(data) {
			if (data != null) {
				$("#table_tbody").empty();
				$.each(data,function() {
					$("#table_tbody").append("<tr>"
							+  "<td>"+ this.id+ "</td>"
							+  "<td>"+ this.salesmanId+ "</td>"
//							+ "<td>"+this.username+ "</td>"
//							+ "<td>"+this.salesmanName+ "</td>"
							+ "<td>"+b.decode(this.username)+ "</td>"
							+ "<td>"+b.decode(this.salesmanName)+ "</td>"
							+ "<td>"+test(this.site)+ "</td>"
							+ "<td>"+this.time+ "</td>"
							+ "<td>"+test(this.status)+ "</td>"
							+ "<td>" +"<button onclick='queryMAP("+this.longitude+","+this.latitude+")'>点击查看"+"</button>"+"</td>"
							+ "</tr>");
					});
}
}, "json");
}

function selectSalesmanSignInPage(page){
var salesmanName = $("#salesmanName").val();
var username = $("#username").val();
var starttime = $("#starttime").val();
var endtime = $("#endtime").val();
var status = $("status").val();
var page=page;
var pageSize =22;
var b =new Base64();
var salesmanName=b.encode(salesmanName);
var username=b.encode(username);
$.post("SignIn/selectSalesmanSignInPage.action",{page:page,pageSize:pageSize,salesmanName:salesmanName,username:username,starttime:starttime,endtime:endtime,status:status},
		function(data) {
			if (data != null) {
				$("#table_tbody").empty();
				$.each(data,function() {
					$("#table_tbody").append("<tr>"
							+  "<td>"+ this.id+ "</td>"
							+  "<td>"+ this.salesmanId+ "</td>"
//							+ "<td>"+this.username+ "</td>"
//							+ "<td>"+this.salesmanName+ "</td>"
							+ "<td>"+b.decode(this.username)+ "</td>"
							+ "<td>"+b.decode(this.salesmanName)+ "</td>"
							+ "<td>"+test(this.site)+ "</td>"
							+ "<td>"+this.time+ "</td>"
							+ "<td>"+test(this.status)+ "</td>"
							+ "<td>" +"<button onclick='queryMAP("+this.longitude+","+this.latitude+")'>点击查看"+"</button>"+"</td>"
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
$("[name=page]").html(page);
while (i <= pageNum) {
	$("[name=select]").append("<option >" + i + "</option>");
	i++;
}
}
//下拉选择页数
function selectNumber() {
page = $(this).children('option:selected').val();
$("[name=page]").html(page);
selectSalesmanSignInPage(page);
}
//下一页
function nextPage() {
var page = $("[name=page]").html();
var sum = $("[name=sum]").html();
if (parseInt(page) >= parseInt(sum)) {
	alert("已经是最后一页了！");
} else {
	var page1 = parseInt(page) + 1;
	$("[name=page]").html(page1);
	page = parseInt(page) + 1;
	selectSalesmanSignInPage(page);
	
// $("[name=select]").appendChild("<option selected>" + page + "</option>");
}

}
function lastPage() {
page = $("[name=page]").html();
if (page < 2) {
	alert("已经是第一页了！");
} else {
	var page1 = page - 1;
	$("[name=page]").html(page1);
	page -= 1;
// $("[name=select]").append("<option selected>" + page1 + "</option>");
	selectSalesmanSignInPage(page);
}
}
//跳转指定页面
function queryPage(){
var querypage=$("#querypage").val();
var sum = $("[name=sum]").html();

if(querypage<=0){
	alert("没有找到页数");
}
else if(querypage > parseInt(sum) ){
	alert("没有找到页数");
}
else{
var page=querypage;
$("[name=page]").html(page);
selectSalesmanSignInPage(page);
}
}

function queryMAP( longitude,latitude){
	window.location.href="/KuaiGong/user/GRmap.jsp?longitude="+longitude+"&&latitude="+latitude;
}

function test(str){

if(typeof(str)=="undefined"){ 

	return "";

	}else{
		return str;
	}
}