$(function() {
	Hourleng(1);
	click();
});

function click() {
	$("[name=queryByid]").bind("change",queryPage);
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}

function Hourleng(page){
	var name=$("#name").val();
	var username=$("#username").val();
	var b=new Base64();
	var page=page;
	var pageSize=22;
	var name=b.encode(name);
	var username=b.encode(username);
	$.post("Hour/HourLength.action",{page:page,pageSize:pageSize,name:name,username:username},function(data){
		if(data!=null){
			selectSum(Math.ceil(data/22));
		}
	},"json");
	$.post("Hour/count.action",{name:name,username:username},function(data){
		if(data!=null){
			$("#count").html(data);
		}
	},"json");
$.post("Hour/HourLengthPage.action",{page:page,pageSize:pageSize,name:name,username:username},function(data){
	if(data!=null){
		$("#table_tbody").empty();
		$.each(data, function(){
			$("#table_tbody").append("<tr>"
					+ "<td>" + this.id+ "</td>"
					+ "<td>" + this.eeid+ "</td>" 
					+ "<td>" + b.decode(this.name) + "</td>" 
					+ "<td>" +b.decode(this.username)+ "</td>" 
					+ "<td>" +this.hourlength+ "</td>" 
					+ "<td>" +this.flushtime+ "</td>" 
					+"</tr>");
		});
	}
}, "json");
}
function HourLengthPage(page){
	var name=$("#name").val();
	var username=$("#username").val();
	var b=new Base64();
	var page=page;
	var pageSize=22;
	var name=b.encode(name);
	var username=b.encode(username);
	$.post("Hour/HourLengthPage.action",{page:page,pageSize:pageSize,name:name,username:username},function(data){
			if(data!=null){
				$("#table_tbody").empty();
				$.each(data, function(){
					$("#table_tbody").append("<tr>"
							+ "<td>" + this.id+ "</td>"
							+ "<td>" + this.eeid+ "</td>" 
							+ "<td>" + b.decode(this.name) + "</td>" 
							+ "<td>" +b.decode(this.username)+ "</td>" 
							+ "<td>" +this.hourlength+ "</td>" 
							+ "<td>" +this.flushtime+ "</td>" 
							+"</tr>");
				});
				}
		},"json");
	}
function selectSum(pageNum) {
	$("[name=select]").empty();
	var i = 1;
	$("[name=sum]").html(pageNum);
	$("[name=page]").html(1);
	while (i <= pageNum) {
		$("[name=select]").append("<option >" + i + "</option>");
		i++;
	}
}
//下拉选择页数
function selectNumber() {
	page= $(this).children('option:selected').val();
	$("[name=page]").html(page);
	HourLengthPage(page);
}
//下一页
function nextPage(){
	var page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	if (parseInt(page) >= parseInt(sum)) {
		alert("已经是最后一页了！");
	} else {
		var page1=parseInt(page)+1;
		$("[name=page]").html(page1);
		page=parseInt(page)+1;
		HourLengthPage(page);
		//$("[name=select]").append("<option selected>" + page1 + "</option>");
	}

}
function lastPage(){
	page = $("[name=page]").html();
	if (page < 2) {
		alert("已经是第一页了！");
	} else {
		var page1 = page - 1;
		$("[name=page]").html(page1);
		page-=1;
		//$("[name=select]").append("<option selected>" + page1 + "</option>");
		HourLengthPage(page);
	}
	
}
function queryPage(){
	var querypage=$("#querypage").val();
	var sum = $("[name=sum]").html();
	if(querypage>parseInt(sum)){
		alert("没有找到页数");
	}
	else{
	var page=querypage;
	$("[name=page]").html(page);
	HourLengthPage(page);
}
}
