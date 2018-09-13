$(function(){
		click();
		SalesmanOrder(1);
	});
	function click(){
		$("[name=queryByid]").bind("change",queryPage);
		$("[name=select]").bind("change", selectNumber);
		$("[name=last]").bind("click", lastPage);
		$("[name=next]").bind("click", nextPage);
	}
	
	function SalesmanOrder(page){
		var b =new Base64();
		var page=page;
		var pageSize = 22;
		var id=$("#id").val();
		var name=$("#name").val();
		var username=$("#username").val();
		var status=$("#status").val();
		var name=b.encode(name);
		var username=b.encode(username);
		$.post("OrderForm/selectSalesmanOrder.action",{page:page,pageSize:pageSize,id:id,name:name,username:username,status:status},
			function(data) {
				if (data != null) {
					selectSum(Math.ceil(data/22),page);
				}
			}, "json");
		 $.post("OrderForm/salesorder.action",{id:id,name:name,username:username,status:status},function(data){
				if(data!=null){
					$("#count").html(data);
				}
			},"json");
		$.post("OrderForm/selectSalesmanOrderPage.action",{page:page,pageSize:pageSize,id:id,name:name,username:username,status:status},
				function(data) {
					if (data != null) {
						$("#table_tbody").empty();
						$.each(data, function() {
							$("#table_tbody").append("<tr>"
									+"<td>" + this.id+ "</td>"
									+"<td>" + this.eeid+ "</td>" 
									+"<td>" +b.decode(this.GRusername)+ "</td>" 
									+"<td>" +b.decode( this.eename)+ "</td>" 
									+"<td>" + this.erid + "</td>" 
									+"<td>" +b.decode( this.username)+ "</td>" 
									+"<td>" + b.decode(this.name)+ "</td>" 
									+"<td>" + test(this.starttime)+ "</td>"
									+"<td>" + test(this.endtime)+ "</td>"
									+"<td>" + test(this.payment)+ "</td>"
									+"<td>" + test(this.allcost)+ "</td>"
									+"<td>" + test(this.actualcost)+ "</td>"
									+"<td>" + this.status+ "</td>" 
									+"<td>" + test(this.order_start_time)+"</td>"
									+"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id+",\""+b.decode(this.GRusername)+"\",\""+b.decode( this.eename)+"\",\""+b.decode( this.username)+"\",\""+b.decode(this.name)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\",\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+page+"\")'>"
									+ "<option value='请选择'>请选择</option>"
									+ "<option  value='查看地理位置'>查看地理位置</option>"
									+ "<option  value='查看评价'>查看评价</option>"
									+ "<option  value='订单详细'>订单详细</option>"
									+ "<option  value='取消原因'>取消原因</option>"
//									+ "<option  value='取消订单'>取消订单</option>"
								    + "<select/>"
									+ "</td>"
								    +"</tr>");
						});
					}
				}, "json");
	}
 function selectSalesmanOrderPage(page){
		var b = new Base64();
	 var page = page;
		var pageSize = 22;
		var name=$("#name").val();
		var username=$("#username").val();
		var status=$("#status").val();
		var name=b.encode(name);
		var username=b.encode(username);
		var id=$("#id").val();
		$.post("OrderForm/selectSalesmanOrderPage.action",{page:page,pageSize:pageSize,id:id,name:name,username:username,status:status},
				function(data) {
					if (data != null) {
						$("#table_tbody").empty();
						$.each(data, function() {
							$("#table_tbody").append("<tr>"
									+"<td>" + this.id+ "</td>"
									+"<td>" + this.eeid+ "</td>" 
									+"<td>" +b.decode(this.GRusername)+ "</td>"
									+"<td>" +b.decode(this.eename)+ "</td>"
									+"<td>" + this.erid+"</td>"
									+"<td>" +b.decode(this.username)+ "</td>" 
									+"<td>" +b.decode(this.name)+ "</td>" 
									+"<td>" + test(this.starttime)+ "</td>"
									+"<td>" + test(this.endtime)+ "</td>"
									+"<td>" + test(this.payment)+ "</td>"
									+"<td>" + test(this.allcost)+ "</td>"
									+"<td>" + test(this.actualcost)+ "</td>"
									+"<td>" + this.status+ "</td>" 
									+"<td>" + test(this.order_start_time)+"</td>"
									+"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id+",\""+b.decode(this.GRusername)+"\",\""+b.decode( this.eename)+"\",\""+b.decode( this.username)+"\",\""+b.decode(this.name)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\",\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+page+"\")'>"
							         + "<option value='请选择'>请选择</option>"
									+ "<option  value='查看地理位置'>查看地理位置</option>"
									+ "<option  value='查看评价'>查看评价</option>"
									+ "<option  value='订单详细'>订单详细</option>"
									+ "<option  value='取消原因'>取消原因</option>"
//									+ "<option  value='取消订单'>取消订单</option>"
								    + "<select/>"
									+ "</td>"
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
 function btuu(id,GRusername,eename,username,name,status,longitude,latitude,eeid,erid,starttime,endtime,payment,allcost,actualcost,order_start_time,estimatedTimeOfArrival,DDtime,DDTime,ChiDaoTime,page){
		var btu = $("#btu"+id).val();
		var chidaoTime=ChiDaoTime-estimatedTimeOfArrival;
		var estimatedTimeOfArrival1=estimatedTimeOfArrival*60;
		var ChiDaoTime=chidaoTime*60;
		var ChiDaoTime1=ChiDaoTime;
		if(ChiDaoTime<-1){
	  ChiDaoTime1=Math.abs(ChiDaoTime);
	  var theTime = parseInt(ChiDaoTime1);// 秒
	    var theTime1 = 0;// 分
	    var theTime2 = 0;// 小时
	    if(theTime >= 60) {
	        theTime1 = parseInt(theTime/60);
	        theTime = parseInt(theTime%60);
	            if(theTime1 > 60) {
	            theTime2 = parseInt(theTime1/60);
	            theTime1 = parseInt(theTime1%60);
	            }
	    }
	    var result = ""+parseInt(theTime)+"秒";
	    if(theTime1 >=0) {
	    result = ""+parseInt(theTime1)+"分"+result;
	    }
	    if(theTime2 >=0) {
	    result = ""+parseInt(theTime2)+"小时"+result;
	 result="提前到达"+(result);
	        }
 }else{
	  ChiDaoTime1=ChiDaoTime1;
	  var theTime = parseInt(ChiDaoTime1);// 秒
	    var theTime1 = 0;// 分
	    var theTime2 = 0;// 小时
	    if(theTime >= 60) {
	        theTime1 = parseInt(theTime/60);
	        theTime = parseInt(theTime%60);
	            if(theTime1 > 60) {
	            theTime2 = parseInt(theTime1/60);
	            theTime1 = parseInt(theTime1%60);
	            }
	    }
	    var result = ""+parseInt(theTime)+"秒";
	    if(theTime1 >=0) {
	    result = ""+parseInt(theTime1)+"分"+result;
	    }
	    if(theTime2 >=0) {
	    result = ""+parseInt(theTime2)+"小时"+result;
 }
 }
if(btu=="查看地理位置"){
	window.location.href="/KuaiGong/user/GRmap.jsp?longitude="+longitude+"&&latitude="+latitude;
}if(btu=="查看评价"){
	window.location.href="/KuaiGong/salesmanAppraise.jsp?id="+id;
}if(btu=="取消原因"){
	window.location.href="Cancel.jsp?id="+id;
}if(btu=="修改订单"){
	window.location.href="updateOrderForm.jsp?id="+id+"&&starttime="+starttime+"&&endtime="+endtime+"&&payment="+payment+"&&allcost="+allcost+"&&actualcost="+actualcost+"&&longitude="+longitude+"&&latitude="+latitude+"&&status="+status+"&&order_start_time="+order_start_time+"&&page="+page;
}if(btu=="订单详细"){
	window.location.href="OrderFormDetailed.jsp?id="+id+"&&GRusername="+GRusername+"&&eename="+eename+"&&username="+username+"&&name="+name+"&&starttime="+starttime+"&&endtime="+endtime+"&&payment="+payment+"&&allcost="+allcost+"&&actualcost="+actualcost+"&&longitude="+longitude+"&&latitude="+latitude+"&&status="+status+"&&order_start_time="+order_start_time+"&&DDtime="+DDtime+"&&estimatedTimeOfArrival="+estimatedTimeOfArrival+"&&DDTime="+DDTime+"&&result="+result+"&&page="+page;
}if(btu=="取消订单"){
	var ss = confirm("您确定要取消吗?");
	if (ss) {
		 $.post("OrderForm/cancelOrder.action",{id:id,eeid:eeid,status:status},function(data){
			 if(data!="null"){  
				 alert("取消成功"); 
				 orderform(1);
			  }else{
					 alert("取消失败！");
				 }
			  },"json");
	}
	}
   }
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
		  	selectSalesmanOrderPage(page);
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
					selectSalesmanOrderPage(page);
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
		  		selectSalesmanOrderPage(page);
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
				selectSalesmanOrderPage(page);
			}
			}