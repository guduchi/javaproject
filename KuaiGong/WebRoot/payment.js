function queryUserPage(){
	var page=$("#page").val();
	if(page=="null" || page==""){
		page=1;
	}else{
		page=page;
	}
	var pageSize = 22;
	var b = new Base64();
	$.post("OrderForm/selectWeiXin.action",{},
			function(data) {
		if (data != null) {
			selectSum(Math.ceil(data/22),page);
		}
	}, "json");
//	$.post("euser/count.action",{un:name,us:username,erid:erid,btu:btu},function(data){
//		if(data!=null){
//			$("#count").html(data);
//		}
//	},"json");
	$.post("OrderForm/selectWeiXinPage.action",{page:page,pageSize:pageSize,un:name,us:username,erid:erid,btu:btu},
			function(data) {
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data,function() {
				$("#table_tbody").append("<tr>"
						+ "<td><input type='checkbox' name='checkbox' value="+ this.id+ ">" + "</td>"
						+  "<td>"+ this.id+ "</td>"
						+ "<td>"+b.decode(this.username)+ "</td>"
						+ "<td>"+b.decode(this.name)+ "</td>"
						+ "<td>"+b.decode(this.status)+ "</td>"
						+ "<td>"+b.decode(this.companyname)+ "</td>"
						+ "<td>"+b.decode(this.grade)+ "</td>"
						+ "<td>"+test(this.time)+ "</td>"
						+ "<td>"+this.regid+ "</td>"
						+ "<td>"
						+ "<select id='btu"+this.id+"'  onchange='btuu(\""+page+"\","+ this.id+",\""+b.decode (this.username)+"\",\""+b.decode (this.name)+"\",\""+ b.decode(this.status)+"\",\""+b.decode (this.companyname)+"\",\""+b.decode (this.grade)+"\")'>"
						+ "<option value='请选择'>请选择</option>"
						+ "<option  value='修改基本信息'>修改基本信息</option>"
						+ "<option  value='查看详细信息'>查看详细信息</option>"
						+ "<option  value='查看每个信息'>查看每个信息</option>"
						+ "<option value='查看充值记录'>查看充值记录</option>"
						+ "<option  value='查看评价记录'>查看评价记录</option>"
						+ "<option  value='招工统计'>招工统计</option>"
						+ "<option  value='充值'>充值</option>"
						+ "<option  value='修改密码'>修改密码</option>"
						+ "<select/>"
						+ "</td>"
						+ "</tr>");
			});
		}
	}, "json");
}

function selectWeiXinPage(page){
	var page=page;
	
	var pageSize = 22;
	var b = new Base64();
	var erid = $("#erid").val();
	var name = $("#name").val();
	var username = $("#username").val();
	var btu=$("#btu").val();
	var  btu=b.encode(btu);
	var name=b.encode(name);
	var username=b.encode(username);
	$.post("OrderForm/selectWeiXinPage.action",{page:page,pageSize:pageSize,un:name,us:username,erid:erid,btu:btu},
			function(data) {
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data,function() {
				$("#table_tbody").append("<tr>"
						+ "<td><input type='checkbox' name='checkbox' value="+ this.id+ ">"+ "</td>"
						+  "<td>"+ this.id+ "</td>"
						+ "<td>"+b.decode(this.username)+ "</td>"
						+ "<td>"+b.decode(this.name)+ "</td>"
						+ "<td>"+b.decode(this.status)+ "</td>"
						+ "<td>"+b.decode(this.companyname)+ "</td>"
						+ "<td>"+b.decode(this.grade)+ "</td>"
						+ "<td>"+test(this.time)+ "</td>"
						+ "<td>"+this.regid+ "</td>"
						+ "<td>"
						+ "<select id='btu"+this.id+"'  onchange='btuu(\""+page+"\","+ this.id+",\""+b.decode (this.username)+"\",\""+b.decode (this.name)+"\",\""+ b.decode(this.status)+"\",\""+b.decode (this.companyname)+"\",\""+b.decode (this.grade)+"\")'>"
						+ "<option value='1'>请选择</option>"
						+ "<option  value='修改基本信息'>修改基本信息</option>"
						+ "<option  value='查看详细信息'>查看详细信息</option>"
						+ "<option  value='查看每个信息'>查看每个信息</option>"
						+ "<option value='查看充值记录'>查看充值记录</option>"
						+ "<option  value='查看评价记录'>查看评价记录</option>"
						+ "<option  value='招工统计'>招工统计</option>"
						+ "<option  value='充值'>充值</option>"
						+ "<option  value='修改密码'>修改密码</option>"
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
	selectWeiXinPage(page);
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
		selectWeiXinPage(page);
	
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
		selectWeiXinPage(page);
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
		selectWeiXinPage(page);
	}

}