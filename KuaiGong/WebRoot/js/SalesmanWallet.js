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
	var b = new Base64();
	var page=$("#page").val();
	if(page=="null" || page==""){
		page=1;
	}else{
		page=page;
	}
	var pageSize =22;
	var salesmanName = $("#salesmanName").val();
	var username = $("#username").val();
	  var salesmanName=b.encode(salesmanName);
	  var username=b.encode(username);
$.post("sales/selectSalesmanWallet.action",{page:page,pageSize:pageSize,salesmanName:salesmanName,username:username},
			function(data) {
				if (data != null) {
					selectSum(Math.ceil(data/22),page);
				}
			}, "json");
$.post("sales/count.action",{salesmanName:salesmanName,username:username},function(data){
	if(data!=null){
		$("#count").html(data);
	}
},"json");
$.post("sales/selectSalesmanWalletPage.action",{page:page,pageSize:pageSize,salesmanName:salesmanName,username:username},
		function(data) {
			if (data != null) {
				$("#table_tbody").empty();
				$.each(data,function() {
							$("#table_tbody").append("<tr>"
									+  "<td>"+ this.id+ "</td>"
									+  "<td>"+ this.salesmanId+ "</td>"
//									+ "<td>"+this.username+ "</td>"
//									+ "<td>"+this.salesmanName+ "</td>"
									+ "<td>"+b.decode(this.username)+ "</td>"
									+ "<td>"+b.decode(this.salesmanName)+ "</td>"
									+ "<td>"+this.balance+ "</td>"
									+ "<td>"+this.latelyUse+ "</td>"
									+ "<td>"+this.time+ "</td>"
									+ "<td>"
									+ "<select id='btu"+this.id+"'  onchange='btuu(\""+ this.id+"\",\""+ this.balance+"\",\""+page+"\")'>"
									+ "<option value='请选择'>请选择</option>"
									+ "<option  value='修改余额'>修改余额</option>"
									+ "<option  value='删除'>删除</option>"
									+ "<select/>"
									+ "</td>"
							+ "</tr>");
					});
}
}, "json");
}

function selectSalesmanWalletPage(page){
	var b =new Base64();
	var page=page;
	var pageSize =22;
var salesmanName = $("#salesmanName").val();
var username = $("#username").val();
var salesmanName=b.encode(salesmanName);
var username=b.encode(username);
$.post("sales/selectSalesmanWalletPage.action",{page:page,pageSize:pageSize,salesmanName:salesmanName,username:username},
		function(data) {
			if (data != null) {
				$("#table_tbody").empty();
				$.each(data,function() {
							$("#table_tbody").append("<tr>"
									+  "<td>"+ this.id+ "</td>"
									+  "<td>"+ this.salesmanId+ "</td>"
//									+ "<td>"+this.username+ "</td>"
//									+ "<td>"+this.salesmanName+ "</td>"
									+ "<td>"+b.decode(this.username)+ "</td>"
									+ "<td>"+b.decode(this.salesmanName)+ "</td>"
									+ "<td>"+this.balance+ "</td>"
									+ "<td>"+this.latelyUse+ "</td>"
									+ "<td>"+this.time+ "</td>"
									+ "<td>"
									+ "<select id='btu"+this.id+"'  onchange='btuu(\""+ this.id+"\",\""+ this.balance+"\",\""+page+"\")'>"
									+ "<option value='请选择'>请选择</option>"
									+ "<option  value='修改余额'>修改余额</option>"
									+ "<option  value='删除'>删除</option>"
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
selectSalesmanWalletPage(page);
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
	selectSalesmanWalletPage(page);
	
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
	selectSalesmanWalletPage(page);
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
selectSalesmanWalletPage(page);
}
}

function btuu(id,balance,page){
	var btu = $("#btu"+id).val();
	var page=page;
	var balance= balance;
	if (btu == "修改余额"){
		 window.location.href="user/updateSalesmanWallet.jsp?id="+id+"&&balance="+balance+"&&page="+page;
	}else if(btu=="删除"){
		 var ss = confirm("您确定要删除吗?");
			if (ss) {
				$.post("sales/delete.action", {
					id : id
				}, function(data, status) {
					if (data != null && data != "") {
						alert("删除成功！");
						window.location.href = "SalesmanWallet.jsp";
					} else {
						alert("删除失败，请检查！");
					}
				}, "json");
			}
		}
}
function test(str){

if(typeof(str)=="undefined"){ 

	return "";

	}else{
		return str;
	}
//}
////修改
//function updateSalesman(){
//	var page=$("#page").val();
//	var userInfo = $("#userInfo").serialize();
//	var id=$("#ID").val();
//	var salesmanId=$("#salesmanId").val();
//	var balance=$("#balance").val();
//	var latelyUse=$("#latelyUse").val();
//	var time=$("#time").val();
//	alert(id);
//var requestData =id+"&&"+ salesmanId + "&&" + balance+ "&&" +latelyUse + "&&" +time;
//var flag = true;
//	if (flag == true){
//		$.post("sales/update.action", {requestData:requestData}, function(
//				data) {
//			if (data != null) {
//				alert("修改成功！");
//				window.location.href="SalesmanWallet.jsp?page="+page;
//			}
//		}, "json");
//	}
}