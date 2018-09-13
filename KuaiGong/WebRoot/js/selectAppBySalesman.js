$(function(){
		click();
		orderform(1);
	});
	function click(){
		$("[name=queryByid]").bind("change",queryPage);
		$("[name=select]").bind("change", selectNumber);
		$("[name=last]").bind("click", lastPage);
		$("[name=next]").bind("click", nextPage);
	}
	
	function orderform(page){
		var b =new Base64();
		var ername=$("#ername").val();
		var erid=$("#erid").val();
		var ername=b.encode(ername);
		var id=$("#id").val();
		var page=page;
		var pageSize =22;
		var b = new Base64();
		$.post("app/selectBySalesApp.action",{page:page,pageSize:pageSize,id:id,ername:ername,erid:erid},
			function(data) {
				if (data != null) {
					selectSum(Math.ceil(data/22),page);
				}
			}, "json");
		 $.post("app/selectAppCount.action",{id:id,ername:ername,erid:erid},function(data){
				if(data!=null){
					$("#count").html(data);
				}
			},"json");
		$.post("app/selectBySalesAppPage.action",{page:page,pageSize:pageSize,id:id,ername:ername,erid:erid},
				function(data) {
					if (data != null) {
						$("#table_tbody").empty();
						$.each(data, function() {
							$("#table_tbody").append("<tr>"
									+"<td>" + this.id+ "</td>"
									+"<td>" + this.orderid+ "</td>"
									+"<td>" + this.erid+ "</td>" 
									+"<td>" +b.decode(this.ername)+ "</td>" 
									+"<td>" + this.eeid + "</td>" 
									+"<td>" + b.decode(this.eename)+ "</td>" 
									+"<td>" + this.starlevel+ "</td>" 
								    +"</tr>");
						});
					}
				}, "json");
	}
 function selectBySalesAppPage(page){
		var page = page;
		var pageSize = 22;
		var b = new Base64();
		var ername=$("#ername").val();
		var erid=$("#erid").val();
		var ername=b.encode(ername);
		var id=$("#id").val();
		$.post("app/selectBySalesAppPage.action",{page:page,pageSize:pageSize,id:id,ername:ername,erid:erid},
				function(data) {
					if (data != null) {
						$("#table_tbody").empty();
						$.each(data, function() {
									$("#table_tbody").append("<tr>"
											+"<td>" + this.id+ "</td>"
											+"<td>" + this.orderid+ "</td>"
											+"<td>" + this.erid+ "</td>" 
											+"<td>" +b.decode( this.ername)+ "</td>" 
											+"<td>" + this.eeid + "</td>" 
											+"<td>" + b.decode(this.eename)+ "</td>" 
											+"<td>" + this.starlevel+ "</td>" 
										    +"</tr>");
						});
					}
				}, "json");
	}
// function test(str) {
//		if(typeof(str)=="undefined"){ 
//
//			return "";
//
//			}else{
//				return str;
//			}
//	}
		// 下拉的页数
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
		  // 下拉选择页数
		  function selectNumber() {
		  	page = $(this).children('option:selected').val();
		  	$("[name=page]").html(page);
		  	selectBySalesAppPage(page);
		  }
		  // 下一页
		  function nextPage() {
				var page = $("[name=page]").html();
				var sum = $("[name=sum]").html();
				if (parseInt(page) >= parseInt(sum)){
					alert("已经是最后一页了！");
				} else {
					var page1=parseInt(page)+1;
					$("[name=page]").html(page1);
					page=parseInt(page)+1;
					selectBySalesAppPage(page);
// $("[name=select]").append("<option selected>" + page1 + "</option>");
				}
			}
		 
		  function lastPage(){
		  	page = $("[name=page]").html();
		  	if (page < 2) {
		  		alert("已经是第一页了！");
		  	} else {
		  		var page1 = page - 1;
		  		$("[name=page]").html(page1);
		  		page -= 1;
// $("[name=select]").append("<option selected>" + page1 + "</option>");
		  		selectBySalesAppPage(page);
		  	}

		  }
		  
		  function queryPage(){
				var querypage=$("#querypage").val();
				var sum = $("[name=sum]").html();
				if(querypage>parseInt(sum)){
					alert("没有找到页数");
				}
				else if(querypage<=0){
					alert("没有找到页数");
				}
				else{
				var page=querypage;
				$("[name=page]").html(page);
				selectBySalesAppPage(page);
			}
			}