function ApplyAllToAll(){
	var starttime=$("#starttime").val();
	var endtime=$("#endtime").val();
	var username=$("#username").val();
	var page = page;
	var pageSize = 8;
	$.post("apply/selectAllToAll.action",{page:page,pageSize:pageSize,username:username,starttime:starttime,endtime:endtime},function(data){
		if(data!=null){
			$("#ApplyAllToAll3").html("今日报名总数："+data);
		}
		
	},"json");
}

$(function(){
	click();
	ApplyAllToAll();
	queryApplyPage();
});

function click(){
	$("[name=queryByid]").bind("change",queryPage);
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}

function queryApplyPage(){
	var starttime=$("#starttime").val();
	var endtime=$("#endtime").val();
	var username=$("#username").val();
	var page=$("#page").val();
	if(page=="null" || page==""){
		page=1;
	}else{
		page=page;
	}
	var pageSize =22;
	$.post("apply/queryApplyPage.action",{page:page,pageSize:pageSize,username:username,starttime:starttime,endtime:endtime},
		function(data) {
			if (data != null) {
				selectSum(Math.ceil(data/22),page);
			}
		}, "json");
	$.post("apply/count.action",{username:username,starttime:starttime,endtime:endtime},function(data){
		if(data!=null){
			$("#count").html(data);
		}
	},"json");
	$.post("apply/queryApplyInfo.action",{page:page,pageSize:pageSize,username:username,starttime:starttime,endtime:endtime},
			function(data) {
				if (data != null) {
					$("#table_tbody").empty();
					$.each(data, function() {
						$("#table_tbody").append("<tr>"
						+ "<td>" + this.id+ "</td>"
						+ "<td>" + this.name+ "</td>" 
						+ "<td>" + this.idcard + "</td>" 
						+ "<td>" +test(this.referrername)+ "</td>" 
						+ "<td>" +test(this.referrertel)+ "</td>" 
						+ "<td>" + this.address+ "</td>"
						+"<td>"  + this.tel+ "</td>"
						+"<td>"  + this.time+ "</td>" 
					    +"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id+","+page+")'>"
					        + "<option value='请选择'>请选择</option>"
							+ "<option  value='删除'>删除</option>"
						
						    + "<select/>"
							+ "</td>"
						+"</tr>");	
					});
				}
			}, "json");
}


function queryApplyInfo(page){
	var username=$("#username").val();
    var starttime=$("#starttime").val();
    var endtime=$("#endtime").val();
	var page = page;
	var pageSize =22;
	$.post("apply/queryApplyInfo.action",{page:page,pageSize:pageSize,username:username,starttime:starttime,endtime:endtime},
			function(data) {
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append("<tr>"
						+ "<td>" + this.id+ "</td>"
						+ "<td>" + this.name+ "</td>" 
						+ "<td>" + this.idcard + "</td>" 
						+ "<td>" +test(this.referrername)+ "</td>" 
						+ "<td>" +test(this.referrertel)+ "</td>" 
						+ "<td>" + this.address+ "</td>"
						+"<td>"  + this.tel+ "</td>"
						+"<td>"  + this.time+ "</td>" 
				 	    +"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id+","+page+")'>"
					        + "<option value='请选择'>请选择</option>"
							+ "<option  value='删除'>删除</option>"
						    + "<select/>"
							+ "</td>"
						+"</tr>");	
					});
			}
	}, "json");
}
function btuu(id,page){

	var btu=$("#btu").val();
	var ss = confirm("您确定要删除吗?");
	if (ss) {
		$.post("apply/delete.action", {
			id : id
		}, function(data, status) {
			if (data != null && data != "") {
				alert("删除成功！");
				window.location.href = "Apply.jsp?page="+page;
			} else {
				alert("删除失败，请检查！");
			}
		}, "json");
	}
}
function test(str){
	if(typeof(str)=="undefined"){
		return " ";
	}else{
		return str;
	}
}
//������ҳ��
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
//����ѡ��ҳ��
function selectNumber() {
	page= $(this).children('option:selected').val();
	$("[name=page]").html(page);
	queryApplyInfo(page);
}
//��һҳ
function nextPage() {
	var page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	if (parseInt(page) >= parseInt(sum)) {
		alert("已经是最后一页了！");
	} else {
		var page1=parseInt(page)+1;
		$("[name=page]").html(page1);
		page=parseInt(page)+1;
		queryApplyInfo(page);
		//$("[name=select]").append("<option selected>" + page1 + "</option>");
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
		//$("[name=select]").append("<option selected>" + page1 + "</option>");
		queryApplyInfo(page);
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
	queryApplyInfo(page);
}
}
