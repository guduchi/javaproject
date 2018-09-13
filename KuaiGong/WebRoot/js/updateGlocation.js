
$(function(){
		click();
	});
	function click(){
		
		$("[name=select]").bind("change", selectNumber);
		$("[name=last]").bind("click", lastPage);
		$("[name=next]").bind("click", nextPage);
	}


function Glocation1(){
		var queryByid = $("#queryByid").val();
		$.post("erlocation/queryG.action", {queryByid:queryByid}, function(data,status) {
			$("#table_tbody").empty();
				$.each(data, function() {
					$("#table_tbody").append("<tr>" 
							+ "<td>" +this.id +  "</td>" 
							+ "<td>"+ this.erid + "</td>" 
							+ "<td>"+this.longitude+ "</td>" 
							+ "<td>"+this.latitude+ "</td>" 
						+"<td><a href='user/updataLocation.jsp?id="+this.id+"&erid="+this.erid+"&longitude="+this.longitude+"&latitude="+this.latitude+"'>修改 </a>"+"</td>"+"<td><a href=javascript:void(0)  onclick =deleteByid("+this.id+") >删除</a>"+"</td>"+ "</tr>");
			});
			}, "json");
			
		function queryUserPage(page){
			var page = page;
			var pageSize = 8;
			//var b = new Base64();
			//获取数量
			$.post("erlocation/queryG.action",{page:page,pageSize:pageSize},
				function(data) {
					if (data != null) {
						selectSum(Math.ceil(data/8));
					}
				}, "json");
			$.post("erlocation/queryUserInfo.action",{page:page,pageSize:pageSize},
					function(data) {
						if (data != null) {
							$("#table_tbody").empty();
							$.each(data, function() {
								
								$("#table_tbody").append("<tr>"
										+ "<td>" + this.id+ "</td>"
										+ "<td>" +this.erid+ "</td>" + "<td>"
										+ this.longitude + "</td>" + "<td>" + this.latitude+ "</td>"
										+ "<td><a href='user/updataLocation.jsp?id="+this.id+"&erid="+this.erid+"&longitude="+this.longitude+"&latitude="+this.latitude+"'>修改 </a>"+"</td>"+"<td><a href=javascript:void(0)  onclick =deleteByid("+this.id+") >删除</a>"+"</td>"+ "</tr>");
									});
						}
					}, "json");
		}


		//没有加密 b.decode(this.username)
		  function queryUserInfo(page){
			var page = page;
			var pageSize = 8;
			var b = new Base64();
			$.post("erlocation/queryUserInfo.action",{page:page,pageSize:pageSize},
					function(data) {
				if (data != null) {
					$("#table_tbody").empty();
					$.each(data, function() {
						$("#table_tbody").append("<tr>"
								+ "<td>" + this.id+ "</td>"
								+ "<td>" +this.erid+ "</td>" + "<td>"
								+ this.longitude + "</td>" + "<td>" + this.latitude+ "</td>"+ "</td>" 
								+ "<td><a href='user/updataLocation.jsp?id="+this.id+"&erid="+this.erid+"&longitude="+this.longitude+"&latitude="+this.latitude+"'>修改 </a>"+"</td>"+"<td><a href=javascript:void(0)  onclick =deleteByid("+this.id+") >删除</a>"+"</td>"+ "</tr>");
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
				page-=1;
			//	$("[name=select]").append("<option selected>" + page1 + "</option>");
				queryUserInfo(page);
			}
			
		}
	}



function deleteByid(id){
	var ss=confirm("确定要删除吗？");
	if(ss)
		{
		$.post("erlocation/delete.action",{id:id},function(data){
			if(data!=null){
				
				alert("删除成功！");
				window.location.href="Gposition.jsp";
			}
			else{
				alert("删除失败!");
			}
			
			
		});
		
		}
	
}






