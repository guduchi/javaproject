$(function(){
	QueryIncome();
	click();
});
function click(){
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}
function QueryIncome(){
	var b=new Base64();
	var page=1;
	var pageSize=20;
	var btu=$("#btu").val();
	var workername=$("#eename").val();
	var workerName=b.encode(workername);
	var newname=$("#name").val();
	var name=b.encode(newname);
	var orderid=$("#id1").val();
    var orderValue=$("#orderValue").val();
    if(orderValue=="昨日进账"){
	$.post("OrderForm/selectOrderFinishByYesterday.action",{orderid:orderid,name:name,workerName:workerName,btu:btu},function(data){
		if(data!=null){
		//	alert(data.length);
			var pageNum=data.length;
			selectSum(Math.ceil(data.length/20));
			}
},"json");
	
    $.post("OrderForm/selectOrderFinishByYesterdayInfo.action",{orderid:orderid,name:name,workerName:workerName,btu:btu,page:page,pageSize:pageSize},function(data){
    	if(data!=null){
			$("#table_tbody").empty();
			$.each(data,function(){
				$("#table_tbody").append("<tr>"
						+"<td>" + this.id+ "</td>"
						+"<td>" + this.eeid+ "</td>" 
						+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
						+"<td>" +b.decode(this.employeeUser.username)+ "</td>" 
						+"<td>" + this.erid + "</td>"
					    +"<td>" +b.decode(this.employerUser.name)+ "</td>" 
					    +"<td>" + b.decode(this.employerUser.username)+ "</td>" 
						+"<td>" + test(this.starttime)+ "</td>"
						+"<td>" + test(this.endtime)+ "</td>"
						+"<td>" + test(this.payment)+ "</td>"
						+"<td>" + test(this.allcost)+ "</td>"
						+"<td>" + test(this.actualcost)+ "</td>"
						+"<td>" + this.status+ "</td>"
						+"<td>" + test(this.order_start_time)+"</td>"
					    +"</tr>");
			});
			
		}
    },"json");
}
    //本周进账
    if(orderValue=="本周进账"){
    
    	$.post("OrderForm/selectOrderFinishByWeek.action",{orderid:orderid,name:name,workerName:workerName,btu:btu},function(data){
    		if(data!=null){
    		//	alert(data.length);
    			var pageNum=data.length;
    			selectSum(Math.ceil(data.length/20));
    }
    	},"json");
    	
        $.post("OrderForm/selectOrderFinishByWeekInfo.action",{orderid:orderid,name:name,workerName:workerName,btu:btu,page:page,pageSize:pageSize},function(data){
        	if(data!=null){
    			$("#table_tbody").empty();
    			$.each(data,function(){
    				$("#table_tbody").append("<tr>"
    						+"<td>" + this.id+ "</td>"
    						+"<td>" + this.eeid+ "</td>" 
    						+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
    						+"<td>" +b.decode(this.employeeUser.username)+ "</td>" 
    						+"<td>" + this.erid + "</td>"
    					    +"<td>" +b.decode(this.employerUser.name)+ "</td>" 
    					    +"<td>" + b.decode(this.employerUser.username)+ "</td>" 
    						+"<td>" + test(this.starttime)+ "</td>"
    						+"<td>" + test(this.endtime)+ "</td>"
    						+"<td>" + test(this.payment)+ "</td>"
    						+"<td>" + test(this.allcost)+ "</td>"
    						+"<td>" + test(this.actualcost)+ "</td>"
    						+"<td>" + this.status+ "</td>"
    						+"<td>" + test(this.order_start_time)+"</td>"
    					    +"</tr>");
    			});
    			
    		}
        },"json");
    }
    
    //本月进账
    if(orderValue=="本月进账"){
    
    	$.post("OrderForm/selectOrderFinishByMonth.action",{orderid:orderid,name:name,workerName:workerName,btu:btu},function(data){
    		if(data!=null){
    		//	alert(data.length);
    			var pageNum=data.length;
    			selectSum(Math.ceil(data.length/20));
    }
    	},"json");
    	
        $.post("OrderForm/selectOrderFinishByMonthInfo.action",{orderid:orderid,name:name,workerName:workerName,btu:btu,page:page,pageSize:pageSize},function(data){
        	if(data!=null){
    			$("#table_tbody").empty();
    			$.each(data,function(){
    				$("#table_tbody").append("<tr>"
    						+"<td>" + this.id+ "</td>"
    						+"<td>" + this.eeid+ "</td>" 
    						+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
    						+"<td>" +b.decode(this.employeeUser.username)+ "</td>" 
    						+"<td>" + this.erid + "</td>"
    					    +"<td>" +b.decode(this.employerUser.name)+ "</td>" 
    					    +"<td>" + b.decode(this.employerUser.username)+ "</td>" 
    						+"<td>" + test(this.starttime)+ "</td>"
    						+"<td>" + test(this.endtime)+ "</td>"
    						+"<td>" + test(this.payment)+ "</td>"
    						+"<td>" + test(this.allcost)+ "</td>"
    						+"<td>" + test(this.actualcost)+ "</td>"
    						+"<td>" + this.status+ "</td>"
    						+"<td>" + test(this.order_start_time)+"</td>"
    					    +"</tr>");
    			});
    			
    		}
        },"json");
    }
    //本年进账
    if(orderValue=="本年进账"){
    	
    	$.post("OrderForm/selectOrderFinishByYear.action",{orderid:orderid,name:name,workerName:workerName,btu:btu},function(data){
    		if(data!=null){
    		//	alert(data.length);
    			var pageNum=data.length;
    			selectSum(Math.ceil(data.length/20));
    }
    	},"json");
    	
        $.post("OrderForm/selectOrderFinishByYearInfo.action",{orderid:orderid,name:name,workerName:workerName,btu:btu,page:page,pageSize:pageSize},function(data){
        	if(data!=null){
    			$("#table_tbody").empty();
    			$.each(data,function(){
    				$("#table_tbody").append("<tr>"
    						+"<td>" + this.id+ "</td>"
    						+"<td>" + this.eeid+ "</td>" 
    						+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
    						+"<td>" +b.decode(this.employeeUser.username)+ "</td>" 
    						+"<td>" + this.erid + "</td>"
    					    +"<td>" +b.decode(this.employerUser.name)+ "</td>" 
    					    +"<td>" + b.decode(this.employerUser.username)+ "</td>" 
    						+"<td>" + test(this.starttime)+ "</td>"
    						+"<td>" + test(this.endtime)+ "</td>"
    						+"<td>" + test(this.payment)+ "</td>"
    						+"<td>" + test(this.allcost)+ "</td>"
    						+"<td>" + test(this.actualcost)+ "</td>"
    						+"<td>" + this.status+ "</td>"
    						+"<td>" + test(this.order_start_time)+"</td>"
    					    +"</tr>");
    			});
    			
    		}
        },"json");
    }
}
function selectOrderFinishByYearInfo(page){
	var b=new Base64();
	var page=page;
	var pageSize=20;
	var btu=$("#btu").val();
	var workername=$("#eename").val();
	var workerName=b.encode(workername);
	var newname=$("#name").val();
	var name=b.encode(newname);
	var orderid=$("#id1").val();

	 $.post("OrderForm/selectOrderFinishByYearInfo.action",{orderid:orderid,name:name,workerName:workerName,btu:btu,page:page,pageSize:pageSize},function(data){
	    	if(data!=null){
				$("#table_tbody").empty();
				$.each(data,function(){
					$("#table_tbody").append("<tr>"
							+"<td>" + this.id+ "</td>"
							+"<td>" + this.eeid+ "</td>" 
							+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
							+"<td>" +b.decode(this.employeeUser.username)+ "</td>" 
							+"<td>" + this.erid + "</td>"
						    +"<td>" +b.decode(this.employerUser.name)+ "</td>" 
						    +"<td>" + b.decode(this.employerUser.username)+ "</td>" 
							+"<td>" + test(this.starttime)+ "</td>"
							+"<td>" + test(this.endtime)+ "</td>"
							+"<td>" + test(this.payment)+ "</td>"
							+"<td>" + test(this.allcost)+ "</td>"
							+"<td>" + test(this.actualcost)+ "</td>"
							+"<td>" + this.status+ "</td>"
							+"<td>" + test(this.order_start_time)+"</td>"
						    +"</tr>");
				});
				
			}
	    },"json");	
}
function selectOrderFinishByMonthInfo(page){
	var b=new Base64();
	var page=page;
	var pageSize=20;
	var btu=$("#btu").val();
	var workername=$("#eename").val();
	var workerName=b.encode(workername);
	var newname=$("#name").val();
	var name=b.encode(newname);
	var orderid=$("#id1").val();

	 $.post("OrderForm/selectOrderFinishByMonthInfo.action",{orderid:orderid,name:name,workerName:workerName,btu:btu,page:page,pageSize:pageSize},function(data){
	    	if(data!=null){
				$("#table_tbody").empty();
				$.each(data,function(){
					$("#table_tbody").append("<tr>"
							+"<td>" + this.id+ "</td>"
							+"<td>" + this.eeid+ "</td>" 
							+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
							+"<td>" +b.decode(this.employeeUser.username)+ "</td>" 
							+"<td>" + this.erid + "</td>"
						    +"<td>" +b.decode(this.employerUser.name)+ "</td>" 
						    +"<td>" + b.decode(this.employerUser.username)+ "</td>" 
							+"<td>" + test(this.starttime)+ "</td>"
							+"<td>" + test(this.endtime)+ "</td>"
							+"<td>" + test(this.payment)+ "</td>"
							+"<td>" + test(this.allcost)+ "</td>"
							+"<td>" + test(this.actualcost)+ "</td>"
							+"<td>" + this.status+ "</td>"
							+"<td>" + test(this.order_start_time)+"</td>"
						    +"</tr>");
				});
				
			}
	    },"json");	
}
function selectOrderFinishByWeekInfo(page){
	var b=new Base64();
	var page=page;
	var pageSize=20;
	var btu=$("#btu").val();
	var workername=$("#eename").val();
	var workerName=b.encode(workername);
	var newname=$("#name").val();
	var name=b.encode(newname);
	var orderid=$("#id1").val();

	 $.post("OrderForm/selectOrderFinishByWeekInfo.action",{orderid:orderid,name:name,workerName:workerName,btu:btu,page:page,pageSize:pageSize},function(data){
	    	if(data!=null){
				$("#table_tbody").empty();
				$.each(data,function(){
					$("#table_tbody").append("<tr>"
							+"<td>" + this.id+ "</td>"
							+"<td>" + this.eeid+ "</td>" 
							+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
							+"<td>" +b.decode(this.employeeUser.username)+ "</td>" 
							+"<td>" + this.erid + "</td>"
						    +"<td>" +b.decode(this.employerUser.name)+ "</td>" 
						    +"<td>" + b.decode(this.employerUser.username)+ "</td>" 
							+"<td>" + test(this.starttime)+ "</td>"
							+"<td>" + test(this.endtime)+ "</td>"
							+"<td>" + test(this.payment)+ "</td>"
							+"<td>" + test(this.allcost)+ "</td>"
							+"<td>" + test(this.actualcost)+ "</td>"
							+"<td>" + this.status+ "</td>"
							+"<td>" + test(this.order_start_time)+"</td>"
						    +"</tr>");
				});
				
			}
	    },"json");	
}
function selectOrderFinishByYesterdayInfo(page){
	var b=new Base64();
	var page=page;
	var pageSize=20;
	var btu=$("#btu").val();
	var workername=$("#eename").val();
	var workerName=b.encode(workername);
	var newname=$("#name").val();
	var name=b.encode(newname);
	var orderid=$("#id1").val();

	 $.post("OrderForm/selectOrderFinishByYesterdayInfo.action",{orderid:orderid,name:name,workerName:workerName,btu:btu,page:page,pageSize:pageSize},function(data){
	    	if(data!=null){
				$("#table_tbody").empty();
				$.each(data,function(){
					$("#table_tbody").append("<tr>"
							+"<td>" + this.id+ "</td>"
							+"<td>" + this.eeid+ "</td>" 
							+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
							+"<td>" +b.decode(this.employeeUser.username)+ "</td>" 
							+"<td>" + this.erid + "</td>"
						    +"<td>" +b.decode(this.employerUser.name)+ "</td>" 
						    +"<td>" + b.decode(this.employerUser.username)+ "</td>" 
							+"<td>" + test(this.starttime)+ "</td>"
							+"<td>" + test(this.endtime)+ "</td>"
							+"<td>" + test(this.payment)+ "</td>"
							+"<td>" + test(this.allcost)+ "</td>"
							+"<td>" + test(this.actualcost)+ "</td>"
							+"<td>" + this.status+ "</td>"
							+"<td>" + test(this.order_start_time)+"</td>"
						    +"</tr>");
				});
				
			}
	    },"json");	
}

	// 下拉的页数
	  function selectSum(pageNum) {
	  	$("[name=select]").empty();
	  	var i = 1;
	  	$("[name=sum]").html(pageNum);
	  //	$("[name=page]").html(page);
	  	while (i <= pageNum) {
	  		$("[name=select]").append("<option >" + i + "</option>");
	  		i++;
	  	}
	  }
	  // 下拉选择页数
	  function selectNumber() {
	  	page = $(this).children('option:selected').val();
	  	var orderValue=$("#orderValue").val();
	  	$("[name=page]").html(page);
	  	if(orderValue=="昨日进账"){
			selectOrderFinishByYesterdayInfo(page);
		}
		if(orderValue=="本周进账"){
			selectOrderFinishByWeekInfo(page);
		}
		if(orderValue=="本月进账"){
			selectOrderFinishByMonthInfo(page);
		}
		if(orderValue=="本年进账"){
			selectOrderFinishByYearInfo(page);
		}
	  }
	  // 下一页
	  function nextPage() {
			var page = $("[name=page]").html();
			var sum = $("[name=sum]").html();
			var orderValue=$("#orderValue").val();
			if (parseInt(page) >= parseInt(sum)){
				alert("已经是最后一页了！");
			} else {
				var page1=parseInt(page)+1;
				$("[name=page]").html(page1);
				page=parseInt(page)+1;
				if(orderValue=="昨日进账"){
					selectOrderFinishByYesterdayInfo(page);
				}
				if(orderValue=="本周进账"){
					selectOrderFinishByWeekInfo(page);
				}
				if(orderValue=="本月进账"){
					selectOrderFinishByMonthInfo(page);
				}
				if(orderValue=="本年进账"){
					selectOrderFinishByYearInfo(page);
				}
//$("[name=select]").append("<option selected>" + page1 + "</option>");
			}
		}
	 
	  function lastPage(){
		var orderValue=$("#orderValue").val();
	  	page = $("[name=page]").html();
	  	if (page < 2) {
	  		alert("已经是第一页了！");
	  	} else {
	  		var page1 = page - 1;
	  		$("[name=page]").html(page1);
	  		page -= 1;
//$("[name=select]").append("<option selected>" + page1 + "</option>");
	  		if(orderValue=="昨日进账"){
				selectOrderFinishByYesterdayInfo(page);
			}
			if(orderValue=="本周进账"){
				selectOrderFinishByWeekInfo(page);
			}
			if(orderValue=="本月进账"){
				selectOrderFinishByMonthInfo(page);
			}
			if(orderValue=="本年进账"){
				selectOrderFinishByYearInfo(page);
			}
	  	}

	  }
	 

function ZGcount(id) {

	$.post("orderForm/queryCount.action", {
		id : id
	}, function(data) {

		if (data != null) {
			window.location.href = "selecteeuser.jsp?id=" + id;
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
