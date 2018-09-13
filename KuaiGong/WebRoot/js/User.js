//$(function(){
//	click();
//});
//
//function click(){
//	
//
//	$("[name=select]").bind("change", selectNumber);
//	$("[name=last]").bind("click", lastPage);
//	$("[name=next]").bind("click", nextPage);
//	
//}
function updateUser1(){
	
	
	var username=$("#username").val();
	var password=$("#password").val();
	
	var flag=true;
	if (password == "" || password == null || password.length <4) {
		$("#f4").html("密码不能为空或密码长度小于4");
		flag = false;
	} else {
		$("#f4").html("");
	}
	if (username == "" || username == null) {
		$("#f2").html("姓名不为空！");
		flag = false;
	} else {
		$("#f2").html("");
	}
	if (flag == true) {
	
		$.post("user/update.action",{username:username,password:password}, function(
				data) {
			if (data != null) {
				alert("修改成功！");
				window.location.href="revise.jsp";
			}
		}, "json");
	}
	
	
}















//查询分页




function queryUserPage(page){
	var page = page;
	var pageSize = 8;
	//var b = new Base64();
	//获取数量
	$.post("user/queryUserPage.action",{page:page,pageSize:pageSize},
		function(data) {
			if (data != null) {
				selectSum(Math.ceil(data/8));
			}
		}, "json");
	$.post("user/queryUserInfo.action",{page:page,pageSize:pageSize},
			function(data) {
				if (data != null) {
					$("#table_tbody").empty();
					$.each(data, function() {
						
						$("#table_tbody").append("<tr>"
								+ "<td>" + this.id+ "</td>"
								+ "<td>" +this.username+ "</td>" + "<td>"
								+ this.password + "</td>"
+ "<td><a href='user/revise1.jsp?id="+this.id+"&username="+this.username+"&password="+this.password+"'>修改 </a>"+"</td>"+"<td><a href=javascript:void(0)  onclick =deleteByid("+this.id+") >删除</a>"+"</td>"+ "</tr>");
							});
				}
			}, "json");
}


//没有加密 b.decode(this.username)
  function queryUserInfo(page){
	var page = page;
	var pageSize = 8;
//	var b = new Base64();
	$.post("user/queryUserInfo.action",{page:page,pageSize:pageSize},
			function(data) {
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append("<tr>"
						+ "<td>" + this.id+ "</td>"
						+ "<td>" +this.username+ "</td>" + "<td>"
						+ this.password +"</td>" 
						+ "<td><a href='user/updateUser.jsp?id="+this.id+"&username="+this.username+"&password="+this.password+"'>修改 </a>"+"</td>"+"<td><a href=javascript:void(0)  onclick =deleteByid("+this.id+") >删除</a>"+"</td>"+ "</tr>");
					});
		}
	}, "json");
}

//下拉的页数
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
	queryUserInfo(page);
}
//下一页
function nextPage() {
	var page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	if (page >= sum) {
		alert("已经是最后一页了！");
	} else {
		var page1=parseInt(page)+1;
		$("[name=page]").html(page1);
		page=parseInt(page)+1;
		queryUserInfo(page);
		$("[name=select]").append("<option selected>" + page1 + "</option>");
	}

}
function lastPage() {
	page = $("[name=page]").html();
	if (page < 2) {
		alert("已经是第一页了！");
	} else {
		var page1 = page - 1;
		$("[name=page]").html(page1);
		page-=1;
		$("[name=select]").append("<option selected>" + page1 + "</option>");
		queryUserInfo(page);
	}
	
}