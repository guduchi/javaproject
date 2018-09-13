function employeeuser() {
	var query = $("#query").val();
	
	$.post("eeuser/queryID.action", {query:query}, function(data,status) {
		
			
		$("#table_tbody").empty();
			$.each(data, function() {
				
				$("#table_tbody").append(
						"<tr>" + "<td>" +this.id +  "</td>" + "<td>"
						     	+ this.username + "</td>" + "<td>"
								+this.password+ "</td>" + "<td>"
								+this.name+ "</td>" + "<td>"
								+this.sex+ "</td>" + "<td>"
								+this.age+ "</td>"+"<td>"
								+this.idcard+ "</td>"+"<td>"
								+this.address+ "</td>"+"<td>"
								+this.hand+ "</td>"+"<td>"
								+this.scan+ "</td>"+"<td>"
								+this.portrait+ "</td>"+"<td>"
								+this.status+ "</td>"+"<td><a href='employeeuser/updataemployeeuser.jsp?id="+this.id+"&username="+this.username+"&password="+this.password+"&name="+this.name+"&sex="+this.sex+"&age="+this.age+"&idcard="+this.idcard+"&address="+this.address+"&hand="+this.hand+"&scan="+this.scan+"&portrait="+this.portrait+"&status="+this.status+"'>修改 </a>"+"</td>"+"<td><a href=javascript:void(0)  onclick =deleteByid("+this.id+") >删除</a>"+"</td>"+ "</tr>");
				
		});
			
		}, "json");
	
	function queryUserPage(page){
		var page = page;
		var pageSize = 8;
		var b = new Base64();
		//获取数量
		$.post("eeuser/queryUserPage.action",{page:page,pageSize:pageSize},
			function(data) {
				if (data != null) {
					selectSum(Math.ceil(data/8));
				}
			}, "json");
		$.post("eeuser/queryUserInfo.action",{page:page,pageSize:pageSize},
				function(data) {
					if (data != null) {
						$("#table_tbody").empty();
						$.each(data, function() {
							
							$("#table_tbody").append("<tr>"
									+ "<td>" + this.id+ "</td>"
									+ "<td>" +this.username+ "</td>" + "<td>"
									+ this.password + "</td>" + "<td>" + this.name+ "</td>"+"<td>" +  this.sex+ "</td>"+"<td>" + this.age+ "</td>" +"<td>" + this.idcard+ "</td>" +"<td>" + this.address+ "</td>" +"<td>" + this.hand+ "</td>" +"<td>" + this.scan+ "</td>" +"<td>" + this.portrait+ "</td>" +"<td>" + this.status+ "</td>" 
									+ "<td><a href='employeeuser/updataemployeeuser.jsp?id="+this.id+"&username="+this.username+"&password="+this.password+"&name="+this.name+"&sex="+this.sex+"&age="+this.age+"&idcard="+this.idcard+"&address="+this.address+"&hand="+this.hand+"&scan="+this.scan+"&portrait="+this.portrait+"&status="+this.status+"'>修改 </a>"+"</td>"+"<td><a href=javascript:void(0)  onclick =deleteByid("+this.id+") >删除</a>"+"</td>"+ "</tr>");
								});
					}
				}, "json");
	}
	  function queryUserInfo(page){
			var page = page;
			var pageSize = 8;
			var b = new Base64();
			$.post("eeuser/queryUserInfo.action",{page:page,pageSize:pageSize},
					function(data) {
				if (data != null) {
					$("#table_tbody").empty();
					$.each(data, function() {
						$("#table_tbody").append("<tr>"
								+ "<td>" + this.id+ "</td>"
								+ "<td>" +this.username+ "</td>" + "<td>"
								+ this.password + "</td>" + "<td>" + this.name+ "</td>"+"<td>" +  this.sex+ "</td>"+"<td>" + this.age+ "</td>" +"<td>" + this.idcard+ "</td>" +"<td>" + this.address+ "</td>" +"<td>" + this.hand+ "</td>" +"<td>" + this.scan+ "</td>" +"<td>" + this.portrait+ "</td>" +"<td>" + this.status+ "</td>" 
								+ "<td><a href='employeeuser/updataemployeeuser.jsp?id="+this.id+"&username="+this.username+"&password="+this.password+"&name="+this.name+"&sex="+this.sex+"&age="+this.age+"&idcard="+this.idcard+"&address="+this.address+"&hand="+this.hand+"&scan="+this.scan+"&portrait="+this.portrait+"&status="+this.status+"'>修改 </a>"+"</td>"+"<td><a href=javascript:void(0)  onclick =deleteByid("+this.id+") >删除</a>"+"</td>"+ "</tr>");
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
	  	if (parseInt(page) >= parseInt(sum)) {
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
	  
}