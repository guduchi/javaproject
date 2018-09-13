
$(function() {
	CompanynamePage(1);
	click();
});

function click() {
	$("[name=queryByid]").bind("change",queryPage);
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}

function CompanynamePage(page){
	var query=$("#query").val();
	var b=new Base64();
	var page=page;
	var pageSize=22;
	$.post("companyname/queryAll.action",{page:page,pageSize:pageSize,query:query},function(data){
		if(data!=null){
			selectSum(Math.ceil(data/22));
		}
	},"json");
	$.post("companyname/count.action",{query:query},function(data){
		if(data!=null){
			$("#count").html(data);
		}
	},"json");
$.post("companyname/queryAllPage.action",{page:page,pageSize:pageSize,query:query},function(data){
	if(data!=null){
		$("#table_tbody").empty();
		$.each(data, function(){
			$("#table_tbody").append("<tr>"
					+ "<td>" + this.id+ "</td>"
					+ "<td>" + this.name+ "</td>" 
					+ "<td>" + this.principal + "</td>" 
					+ "<td>" +this.tel+ "</td>" 
					+ "<td>" +this.address+ "</td>" 
					+ "<td>" + this.content+ "</td>"
					+ "<td>" + this.time+ "</td>"
					+"<td>"
					+ "<select id='btu"+this.id+"'  onchange='btu("+ this.id+",\""+this.name+"\",\""+this.principal+"\",\""+ this.tel+"\",\""+this.address+"\",\""+this.content+"\",\""+this.time+"\",\""+page+"\")'>"
			        +"<option value='1'>请选择</option>"
			        + "<option  value='修改基本信息'>修改基本信息</option>"
			    	+ "<option  value='删除'  onclick =deleteByid("+this.id+","+page+")>删除</option>"
					+"<select/>"
					+"</td>"
					+"</tr>");
		});
		}
},"json");
}
function queryAllPage(page){
	var query=$("#query").val();
	var b=new Base64();
	var page=page;
	var pageSize=22;
	$.post("companyname/queryAllPage.action",{page:page,pageSize:pageSize,query:query},function(data){
			if(data!=null){
				$("#table_tbody").empty();
				$.each(data, function(){
					$("#table_tbody").append("<tr>"
							+ "<td>" + this.id+ "</td>"
							+ "<td>" + this.name+ "</td>" 
							+ "<td>" + this.principal + "</td>" 
							+ "<td>" +this.tel+ "</td>" 
							+ "<td>" +this.address+ "</td>" 
							+ "<td>" + this.content+ "</td>"
							+ "<td>" + this.time+ "</td>"
							+"<td>"
							+ "<select id='btu"+this.id+"'  onchange='btu("+ this.id+",\""+this.name+"\",\""+this.principal+"\",\""+ this.tel+"\",\""+this.address+"\",\""+this.content+"\",\""+this.time+"\",\""+page+"\")'>"
					        +"<option value='1'>请选择</option>"
					        + "<option  value='修改基本信息'>修改基本信息</option>"
					    	+ "<option  value='删除'  onclick =deleteByid("+this.id+","+page+")>删除</option>"
							+"<select/>"
							+"</td>"
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
	queryAllPage(page);
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
		queryAllPage(page);
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
		queryAllPage(page);
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
	queryAllPage(page);
}
}

function btu(id,name,principal,tel,address,content,time,page) {
    var page=page;
  var name=name;
  var principal=principal;
  var tel=tel;
  var address=address;
  var content=content;
  var time=time;
	var id = id;
	var btu = $("#btu"+id).val();
	if(btu=="修改基本信息"){
		window.location.href="user/updateCompany.jsp?id="+id+"&&name="+name+"&&principal="+principal+"&&tel="+tel+"&&address="+address+"&&content="+content+"&&time="+time+"&&page="+page;
}else if(btu=="删除"){
	 var ss = confirm("您确定要删除吗?");
		if (ss) {
			$.post("companyname/delete.action", {
				id : id
			}, function(data, status) {
				if (data != null && data != "") {
					alert("删除成功！");
					window.location.href = "company.jsp?page="+page;
				} else {
					alert("删除失败，请检查！");
				}
			}, "json");
		}
}
}
