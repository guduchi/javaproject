$(function() {
	click();
});

function click() {
	
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}

function queryInfomation111(page){
	   var page=page;
	   var pageSize=8;
		var b=new Base64();
		var query=$("#id").val();
		$.post("onlineInformation/queryInfomation1.action",{query:query,page:page,pageSize:pageSize},
				function(data){
		if(data!=null){
			selectSum(Math.ceil(data/8));
		}
		},"json");
		$.post("onlineInformation/queryInfomation1PaGe.action",{query:query,page:page,pageSize:pageSize},
				function(data){
		if(data!=null){
		$("#table_tbody").empty();
		$.each(data,function(){
			$("#table_tbody").append("<tr>"
					+ "<td>" + this.id 

+ "</td>"
					+ "<td>" +b.decode(this.username)+ "</td>" 
					+"<td>" + b.decode( this.name 

)+ "</td>"
					+"<td>" + this.startime+ "</td>" 
					+"<td>" +test( this.endtime)+ "</td>" 
					+"<td>" + this.status+ "</td>"
					+"</tr>");
				});
	}
}, "json");
}
function queryInfomation1PaGe(page){
	 var page=page;
	   var pageSize=8;
		var b=new Base64();
		var query=$("#id").val();
		$.post("onlineInformation/queryInfomation1PaGe.action",{query:query,page:page,pageSize:pageSize},function(data){
			if(data!=null){
			$("#table_tbody").empty();
			$.each(data,function(){
				$("#table_tbody").append("<tr>"
						+ "<td>" + this.id 

+ "</td>"
						+ "<td>" +b.decode(this.username)+ "</td>" 
						+"<td>" + b.decode( this.name 

)+ "</td>"
						+"<td>" + this.startime+ "</td>" 
						+"<td>" + test(this.endtime)+ "</td>" 
						+"<td>" + this.status+ "</td>"
						+"</tr>");
					});
		}
	}, "json");
}

  function test(str) {
		if(typeof(str)=="undefined"){ 

			return "";

			}else{
				return str;
			}
	}

// 下拉的页数
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
// 下拉选择页数
function selectNumber() {
	page = $(this).children('option:selected').val();
	$("[name=page]").html(page);
	queryInfomation1PaGe(page);
}
// 下一页
function nextPage() {
	var page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	if (parseInt(page) >= parseInt(sum)) {
		alert("已经是最后一页了！");
	} else {
		var page1 = parseInt(page) + 1;
		$("[name=page]").html(page1);
		page = parseInt(page) + 1;
		queryInfomation1PaGe(page);
	//	$("[name=select]").append("<option selected>" + page1 + "</option>");
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
	//	$("[name=select]").append("<option selected>" + page1 + "</option>");
		queryInfomation1PaGe(page);
	}

}
function SendMoney() {
	// jquery获取复选框值

	var id = [];

	$('input[name="checkbox"]:checked').each(function() {
		id.push($(this).val());
	});

	// alert(chk_value.length==0 ?'你还没有选择任何内容！':chk_value);
	if (id.length == 0) {
		alert("你还没有选择任何内容");
		// window.location.href="employeruser.jsp";
		return false;
	} else {

		window.location.href = "SendMoney.jsp?id=" + id;

	}
}
function sendMoney() {

	var id = $("#id").val();

	var money = $("#money").val();
	$.post("discount/InsertDisCount1.action", {
		money : money,
		id : id
	}, function(data) {
		if (data != null) {
			alert("发送成功");
		}

	}, "json");
}
