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

function queryUserPage(){
	var b = new Base64();
	var page=$("#page").val();
	if(page=="null" || page=="" || page=="undefined"){
		page=1;
	}else{
		page=page;
	}
	var pageSize =22;
	var id = $("#id").val();
	var salesmanName = $("#salesmanName").val();
	var username = $("#username").val();
	var status = $("#status").val();
	var position = $("#position").val();
	var superiorId = $("#superiorId").val();
	  var salesmanName=b.encode(salesmanName);
	  var username=b.encode(username);
$.post("salesman/selectSalesman.action",{page:page,pageSize:pageSize,id:id,salesmanName:salesmanName,username:username,status:status,position:position,superiorId:superiorId},
			function(data) {
				if (data != null) {
					selectSum(Math.ceil(data/22),page);
				}
			}, "json");
$.post("salesman/count.action",{id:id,salesmanName:salesmanName,username:username,status:status,position:position,superiorId:superiorId},function(data){
	if(data!=null){
		$("#count").html(data);
	}
},"json");
$.post("salesman/selectSalesmanPage.action",{page:page,pageSize:pageSize,id:id,salesmanName:salesmanName,username:username,status:status,position:position,superiorId:superiorId},
		function(data) {
			if (data != null) {
				$("#table_tbody").empty();
				$.each(data,function() {
					$("#table_tbody").append("<tr>"
							+"<td>"+ this.id+ "</td>"
							+"<td>"+ test(this.superiorId)+ "</td>"
							+"<td>"+ teat(this.supername)+ "</td>"
							+ "<td>"+b.decode(this.username)+ "</td>"
							+ "<td>"+b.decode(this.salesmanName)+ "</td>"
							+ "<td>"+b.decode(this.address)+ "</td>"
							+ "<td>"+b.decode(this.sex)+ "</td>"
							+ "<td>"+b.decode(this.position)+ "</td>"
							+ "<td>"+b.decode(this.idCard)+ "</td>"
							+ "<td>"+test(this.regtime)+ "</td>"
							+ "<td>"+this.status+ "</td>"
							+ "<td>"
							+ "<select id='btu"+this.id+"'  onchange='btuu(\""+page+"\","+ this.id+",\""+b.decode (this.username)+"\",\""+b.decode (this.password)+"\",\""+ b.decode(this.salesmanName)+"\",\""+b.decode (this.address)+"\",\""+b.decode (this.sex)+"\",\""+this.superiorId+"\",\""+b.decode (this.position)+"\",\""+b.decode (this.idCard)+"\",\""+this.status+"\")'>"
							+ "<option value='请选择'>请选择</option>"
							+ "<option  value='修改基本信息'>修改基本信息</option>"
							+ "<option  value='查看详细信息'>查看详细信息</option>"
							+ "<option  value='删除'>删除</option>"
							+ "<option  value='查看工人'>查看工人</option>"
							+ "<select/>"
							+ "</td>"
							+ "</tr>");
					});
}
}, "json");
}

function selectSalesmanPage(page){
var id = $("#id").val();
var salesmanName = $("#salesmanName").val();
var username = $("#username").val();
var status =$("status").val();
var position = $("position").val();
var superiorId = $("superiorId").val();
var page=page;
var pageSize =22;
var b =new Base64();
var salesmanName=b.encode(salesmanName);
var username=b.encode(username);
$.post("salesman/selectSalesmanPage.action",{page:page,pageSize:pageSize,id:id,salesmanName:salesmanName,username:username,status:status,position:position,superiorId:superiorId},
		function(data){
			if (data != null) {
				$("#table_tbody").empty();
				$.each(data,function() {
					$("#table_tbody").append("<tr>"
							+ "<td>"+this.id+"</td>"
							+ "<td>"+test(this.superiorId)+ "</td>"
							+"<td>"+ teat(this.supername)+ "</td>"
							+ "<td>"+b.decode(this.username)+ "</td>"
							+ "<td>"+b.decode(this.salesmanName)+ "</td>"
							+ "<td>"+b.decode(this.address)+ "</td>"
							+ "<td>"+b.decode(this.sex)+ "</td>"
							+ "<td>"+b.decode(this.position)+ "</td>"
							+ "<td>"+b.decode(this.idCard)+ "</td>"
							+ "<td>"+test(this.regtime)+ "</td>"
							+ "<td>"+this.status+ "</td>"
							+ "<td>"
							+ "<select id='btu"+this.id+"'  onchange='btuu(\""+page+"\","+ this.id+",\""+b.decode (this.username)+"\",\""+b.decode (this.password)+"\",\""+ b.decode(this.salesmanName)+"\",\""+b.decode (this.address)+"\",\""+b.decode (this.sex)+"\",\""+this.superiorId+"\",\""+b.decode (this.position)+"\",\""+b.decode (this.idCard)+"\",\""+this.status+"\")'>"
							+ "<option value='请选择'>请选择</option>"
							+ "<option  value='修改基本信息'>修改基本信息</option>"
							+ "<option  value='查看详细信息'>查看详细信息</option>"
							+ "<option  value='删除'>删除</option>"
							+ "<option  value='查看工人'>查看工人</option>"
							+ "<select/>"
							+ "</td>"
							+ "</tr>");
					});
}
}, "json");
}

function teat(str){
	var b = new Base64();
	if(typeof(str)=="undefined"){ 
		return "";
		}else{
			return b.decode(str);
		}
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

function btuu(page,id,username,password,salesmanName,address,sex,superiorId,position,idCard,status){
var b =Base64();
var page=page;
var id = id;
var username=username;
var password = password;
var salesmanName=salesmanName;
var address = address;
var sex = sex;
var superiorId=superiorId;
var position=position;
var idCard = idCard;
var status=status;
var btu = $("#btu"+id).val();
if (btu == "查看工人") {
	window.location.href = "selectBySalesman.jsp?id=" + id+"&&page="+page;
}	else if(btu=="查看详细信息"){
	window.location.href="SalesmanMany.jsp?id="+id+"&&page="+page;
//}	else if(btu=="数据转移"){
//	window.location.href="Change.jsp?id="+id+"&&page="+page;
}	else if(btu=="修改基本信息"){
 window.location.href="user/updateSalesman.jsp?id="+id+"&&page="+page+ "&&username="+username+ "&&password="+password+ "&&salesmanName="+salesmanName+ "&&address="+address+ "&&sex="+sex+ "&&superiorId="+superiorId+"&&position="+position+"&&idCard="+idCard+ "&&status="+status;
}		else if(btu=="删除"){
 var ss = confirm("您确定要删除吗?");
	if (ss) {
		$.post("salesman/delete.action", {
			id : id
		}, function(data, status) {
			if (data != null && data != "") {
				alert("删除成功！");
				window.location.href = "Salesman.jsp?page="+page;
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
}

//function updateSalesman(){
//	var b=new Base64();
//	var page=$("#page").val();
//	var userInfo = $("#userInfo").serialize();
//	var id=$("#ID").val();
//	var username=$("#username").val();
//	var password=$("#password").val();
//	var salesmanName=$("#salesmanName").val();
//	var address=$("#address").val();
//	var sex=$("#sex").val();
//	var superiorId=$("#superiorId").val();
//	var position=$("#position").val();
//	var idCard=$("#idCard").val();
//	var status=$("#status").val();
//	var username=b.encode(username);
//	var password=b.encode(password);
//	var salesmanName=b.encode(salesmanName);
//	var address=b.encode(address);
//	var sex=b.encode(sex);
//	var position=b.encode(position);
//	var idCard=b.encode(idCard);
//	var flag = true;
//	if (salesmanName == "" || salesmanName == null) {
//		$("#f2").html("姓名不为空！");
//		flag = false;
//	} else {
//		$("#f2").html("");
//	}
//	if (flag == true) {
//	
//		$.post("salesman/update.action", {id:id,username:username,password:password,salesmanName:salesmanName,address:address,sex:sex,superiorId:superiorId,position:position,idCard:idCard,status:status}, function(
//				data) {
//			if (data != null) {
//				alert("修改成功！");
//				window.location.href="Salesman.jsp?page="+page;
//			}
//		}, "json");
//	}
//}