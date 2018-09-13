$(function() {
	click();
	queryUserPage(1);
});
function click() {
	$("[name=queryByid]").bind("change",queryPage);
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}

function queryUserPage(page){
	var b = new Base64();
	var page = page;
	var pageSize =22;
	var id = $("#id").val();
	var name = $("#name").val();
	var username = $("#username").val();
	  var name=b.encode(name);
	  var username=b.encode(username);
$.post("eeuser/selectSalesman.action",{page:page,pageSize:pageSize,id:id,name:name,username:username},
			function(data) {
				if (data != null) {
					selectSum(Math.ceil(data/22),page);
				}
			}, "json");
$.post("eeuser/salesemployeeuser.action",{id:id,name:name,username:username},function(data){
	if(data!=null){
		$("#count").html(data);
	}
},"json");
$.post("eeuser/selectSalesmanPage.action",{page:page,pageSize:pageSize,id:id,name:name,username:username},
		function(data) {
			if (data != null) {
				$("#table_tbody").empty();
				$.each(data,function() {
					$("#table_tbody").append("<tr>"
							+  "<td>"+ this.id+ "</td>"
							+ "<td>"+b.decode(this.username)+ "</td>"
							+"<td>" +b.decode(this.name)+"</td>"
							+ "<td>"+b.decode(this.age)+ "</td>"
							+ "<td>"+b.decode(this.idcard)+ "</td>"
							+ "<td>"+b.decode(this.address)+ "</td>"
							+ "<td>"+this.status+ "</td>"
							+ "<td>"+this.time+ "</td>"
							+ "<td>"+this.salesmanId+ "</td>"
							+ "<td>"
							+ "<select id='btu"+this.id+"'  onchange='btuu(\""+page+"\","+ this.id+",\""+b.decode (this.username)+"\",\""+b.decode (this.name)+"\",\""+ b.decode(this.age)+"\",\""+b.decode (this.idcard)+"\",\""+b.decode (this.address)+"\",\""+this.status+"\",\""+this.time+"\")'>"
							+ "<option value='请选择'>请选择</option>"
							+ "<option  value='查看订单'>查看订单</option>"
							+ "<option  value='查看评价'>查看评价</option>"
							+ "<select/>"
							+ "</td>"
							+ "</tr>");
					});
}
}, "json");
}

function selectSalesmanPage(page){
var id = $("#id").val();
var name = $("#name").val();
var username = $("#username").val();
var page=page;
var pageSize = 22;
var b =new Base64();
var name=b.encode(name);
var username=b.encode(username);
$.post("eeuser/selectSalesmanPage.action",{page:page,pageSize:pageSize,id:id,name:name,username:username},
		function(data){
			if (data != null) {
				$("#table_tbody").empty();
				$.each(data,function() {
					$("#table_tbody").append("<tr>"
							+  "<td>"+ this.id+ "</td>"
							+ "<td>"+b.decode(this.username)+ "</td>"
							+"<td>" +b.decode(this.name)+"</td>"
							+ "<td>"+b.decode(this.age)+ "</td>"
							+ "<td>"+b.decode(this.idcard)+ "</td>"
							+ "<td>"+b.decode(this.address)+ "</td>"
							+ "<td>"+this.status+ "</td>"
							+ "<td>"+this.time+ "</td>"
							+ "<td>"+this.salesmanId+ "</td>"
							+ "<td>"
							+ "<select id='btu"+this.id+"'  onchange='btuu(\""+page+"\","+ this.id+",\""+b.decode (this.username)+"\",\""+b.decode (this.name)+"\",\""+ b.decode(this.age)+"\",\""+b.decode (this.idcard)+"\",\""+b.decode (this.address)+"\",\""+this.status+"\",\""+this.page+"\",\""+this.time+"\")'>"
							+ "<option value='请选择'>请选择</option>"
							+ "<option  value='查看订单'>查看订单</option>"
							+ "<option  value='查看评价'>查看评价</option>"
							+ "<select/>"
							+ "</td>"
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
selectSalesmanPage(page);
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
	selectSalesmanPage(page);
	
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
	selectSalesmanPage(page);
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
selectSalesmanPage(page);
}
}

function btuu(page,id,username,name,age,idcard,idcard,address,status,time){
	var b =Base64();
	var page=page;
	var id = id;
	var username=username;
	var name = name;
	var age=age;
	var idcard = idcard;
	var address = address;
	var status=status;
	var time = time;
	var btu = $("#btu"+id).val();
	if (btu == "查看订单") {
		window.location.href = "selectSalesmanOrder.jsp?id=" + id+"&&page="+page;
	}	else if(btu=="查看评价"){
		window.location.href="selectAppBySalesman.jsp?id="+id+"&&page="+page;
	}
}
function test(str){

if(typeof(str)=="undefined"){ 

	return "";

	}else{
		return str;
	}
}