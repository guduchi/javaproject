
$(function(){
	QueryOrderFormToYesterday();
	click();
});
function click(){
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}

function QueryOrderFormToYesterday(){
	var b=new Base64();
	var page=1;
	var pageSize=20;
	var btu=$("#btu").val();
    var starttime=$("#starttime").val();
	var endtime=$("#endtime").val();
	var workername=$("#eename").val();
	var workerName=b.encode(workername);
	var newname=$("#name").val();
	var name=b.encode(newname);
	
	var id=$("#id1").val();
	 var orderValue=$("#orderValue").val();
	 
	 
	 //昨日订单
	 
	 
	 
	 if(orderValue=="昨日订单"){
		 $.post("OrderForm/selectOrderByYesterday.action",{workerName:workerName,name:name,id:id,starttime:starttime,endtime:endtime,btu:btu,page:page,pageSize:pageSize},function(data){
		if (data != null) {
			selectSum(Math.ceil(data.length /20));
		
			var pageNum=data.length;
		
			
		}
	}, "json");
	$.post("OrderForm/selectOrderByYesterdayInfo.action",{workerName:workerName,name:name,id:id,starttime:starttime,endtime:endtime,btu:btu,page:page,pageSize:pageSize}, function(data){
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function(){
				$("#table_tbody").append("<tr>"
						+"<td>" + this.id+ "</td>"
						+"<td>" + this.eeid+ "</td>" 
						+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
					    +"<td>" +b.decode( this.employeeUser.username)+ "</td>" 
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
//,\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\"						
						+"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id +",\""+b.decode(this.employeeUser.name)+"\",\""+b.decode(this.employeeUser.username)+"\",\""+b.decode(this.employerUser.name)+"\",\""+b.decode(this.employerUser.username
)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\")'>"
				        + "<option value='请选择'>请选择</option>"
						+ "<option  value='查看地理位置'>查看地理位置</option>"
						+ "<option  value='修改订单'>修改订单</option>"
						+ "<option  value='订单详细'>订单详细</option>"
						+ "<option  value='取消订单'>取消订单</option>"
					    + "<select/>"
						+ "</td>" 
					    +"</tr>");
			});
		}
		
	},"json");
}
	 
	 //本周订单 
	 
	 
	 
	 if(orderValue=="本周订单"){
		 $.post("OrderForm/selectOrderByWeek.action",{workerName:workerName,name:name,id:id,starttime:starttime,endtime:endtime,btu:btu,page:page,pageSize:pageSize},function(data){
		if (data != null) {
			selectSum(Math.ceil(data.length /20));
		
			var pageNum=data.length;
			
			
		}
	}, "json");
	$.post("OrderForm/selectOrderByWeekInfo.action",{workerName:workerName,name:name,id:id,starttime:starttime,endtime:endtime,btu:btu,page:page,pageSize:pageSize}, function(data){
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function(){
				$("#table_tbody").append("<tr>"
						+"<td>" + this.id+ "</td>"
						+"<td>" + this.eeid+ "</td>" 
						+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
					    +"<td>" +b.decode( this.employeeUser.username)+ "</td>" 
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
//,\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\"						
						+"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id +",\""+b.decode(this.employeeUser.name)+"\",\""+b.decode(this.employeeUser.username)+"\",\""+b.decode(this.employerUser.name)+"\",\""+b.decode(this.employerUser.username
)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\")'>"
				        + "<option value='请选择'>请选择</option>"
						+ "<option  value='查看地理位置'>查看地理位置</option>"
						+ "<option  value='修改订单'>修改订单</option>"
						+ "<option  value='订单详细'>订单详细</option>"
						+ "<option  value='取消订单'>取消订单</option>"
					    + "<select/>"
						+ "</td>" 
					    +"</tr>");
			});
		}
		
	},"json");
}
	 
	 //本月订单 
	 
	 
	 if(orderValue=="本月订单"){
		 $.post("OrderForm/selectOrderByMonth.action",{workerName:workerName,name:name,id:id,starttime:starttime,endtime:endtime,btu:btu,page:page,pageSize:pageSize},function(data){
		if (data != null) {
			selectSum(Math.ceil(data.length /20));
		
			var pageNum=data.length;
			
			
		}
	}, "json");
	$.post("OrderForm/selectOrderByMonthInfo.action",{workerName:workerName,name:name,id:id,starttime:starttime,endtime:endtime,btu:btu,page:page,pageSize:pageSize}, function(data){
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function(){
				$("#table_tbody").append("<tr>"
						+"<td>" + this.id+ "</td>"
						+"<td>" + this.eeid+ "</td>" 
						+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
					    +"<td>" +b.decode( this.employeeUser.username)+ "</td>" 
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
//,\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\"						
						+"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id +",\""+b.decode(this.employeeUser.name)+"\",\""+b.decode(this.employeeUser.username)+"\",\""+b.decode(this.employerUser.name)+"\",\""+b.decode(this.employerUser.username
)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\")'>"
				        + "<option value='请选择'>请选择</option>"
						+ "<option  value='查看地理位置'>查看地理位置</option>"
						+ "<option  value='修改订单'>修改订单</option>"
						+ "<option  value='订单详细'>订单详细</option>"
						+ "<option  value='取消订单'>取消订单</option>"
					    + "<select/>"
						+ "</td>" 
					    +"</tr>");
			});
		}
		
	},"json");
}

	 
	 
	 
	 //本年订单 
	 
	 
	 if(orderValue=="本年订单"){
		 $.post("OrderForm/selectOrderByYear.action",{workerName:workerName,name:name,id:id,starttime:starttime,endtime:endtime,btu:btu,page:page,pageSize:pageSize},function(data){
		if (data != null) {
			selectSum(Math.ceil(data.length /20));
		
			var pageNum=data.length;
			
			
		}
	}, "json");
	$.post("OrderForm/selectOrderByYearInfo.action",{workerName:workerName,name:name,id:id,starttime:starttime,endtime:endtime,btu:btu,page:page,pageSize:pageSize}, function(data){
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function(){
				$("#table_tbody").append("<tr>"
						+"<td>" + this.id+ "</td>"
						+"<td>" + this.eeid+ "</td>" 
						+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
					    +"<td>" +b.decode( this.employeeUser.username)+ "</td>" 
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
//,\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\"						
						+"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id +",\""+b.decode(this.employeeUser.name)+"\",\""+b.decode(this.employeeUser.username)+"\",\""+b.decode(this.employerUser.name)+"\",\""+b.decode(this.employerUser.username
)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\")'>"
				        + "<option value='请选择'>请选择</option>"
						+ "<option  value='查看地理位置'>查看地理位置</option>"
						+ "<option  value='修改订单'>修改订单</option>"
						+ "<option  value='订单详细'>订单详细</option>"
						+ "<option  value='取消订单'>取消订单</option>"
					    + "<select/>"
						+ "</td>" 
					    +"</tr>");
			});
		}
		
	},"json");
}
}
function selectOrderByYearInfo(page){
	var b=new Base64();
	//alert(page);
	var page=page;
	var pageSize=20;
	var btu=$("#btu").val();
    var starttime=$("#starttime").val();
	var endtime=$("#endtime").val();
	var workername=$("#eename").val();
	var workerName=b.encode(workername);
	var newname=$("#name").val();
	var name=b.encode(newname);
	var id=$("#id1").val();
 
	
	$.post("OrderForm/selectOrderByYearInfo.action",{workerName:workerName,name:name,id:id,starttime:starttime,endtime:endtime,btu:btu,page:page,pageSize:pageSize}, function(data){
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function(){
				$("#table_tbody").append("<tr>"
						+"<td>" + this.id+ "</td>"
						+"<td>" + this.eeid+ "</td>" 
						+"<td>" +b.decode(this.employerUser.name)+ "</td>" 
					    +"<td>" +b.decode( this.employerUser.username)+ "</td>" 
						+"<td>" + this.erid + "</td>"
						+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
						+"<td>" + b.decode(this.employeeUser.username)+ "</td>" 
						+"<td>" + test(this.starttime)+ "</td>"
						+"<td>" + test(this.endtime)+ "</td>"
						+"<td>" + test(this.payment)+ "</td>"
						+"<td>" + test(this.allcost)+ "</td>"
						+"<td>" + test(this.actualcost)+ "</td>"
						+"<td>" + this.status+ "</td>"
						+"<td>" + test(this.order_start_time)+"</td>"
//,\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\"						
						+"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id +",\""+b.decode(this.employeeUser.name)+"\",\""+b.decode(this.employeeUser.username)+"\",\""+b.decode(this.employerUser.name)+"\",\""+b.decode(this.employerUser.username
)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\",\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\")'>"
				        + "<option value='请选择'>请选择</option>"
						+ "<option  value='查看地理位置'>查看地理位置</option>"
						+ "<option  value='修改订单'>修改订单</option>"
						+ "<option  value='订单详细'>订单详细</option>"
						+ "<option  value='取消订单'>取消订单</option>"
					    + "<select/>"
						+ "</td>" 
					    +"</tr>");
			});
		}
		
	},"json");
}


function selectOrderByMonthInfo(page){
	var b=new Base64();
	//alert(page);
	var page=page;
	var pageSize=20;
	var btu=$("#btu").val();
    var starttime=$("#starttime").val();
	var endtime=$("#endtime").val();
	var workername=$("#eename").val();
	var workerName=b.encode(workername);
	var newname=$("#name").val();
	var name=b.encode(newname);
	var id=$("#id1").val();
 
	
	$.post("OrderForm/selectOrderByMonthInfo.action",{workerName:workerName,name:name,id:id,starttime:starttime,endtime:endtime,btu:btu,page:page,pageSize:pageSize}, function(data){
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function(){
				$("#table_tbody").append("<tr>"
						+"<td>" + this.id+ "</td>"
						+"<td>" + this.eeid+ "</td>" 
						+"<td>" +b.decode(this.employerUser.name)+ "</td>" 
					    +"<td>" +b.decode( this.employerUser.username)+ "</td>" 
						+"<td>" + this.erid + "</td>"
						+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
						+"<td>" + b.decode(this.employeeUser.username)+ "</td>" 
						+"<td>" + test(this.starttime)+ "</td>"
						+"<td>" + test(this.endtime)+ "</td>"
						+"<td>" + test(this.payment)+ "</td>"
						+"<td>" + test(this.allcost)+ "</td>"
						+"<td>" + test(this.actualcost)+ "</td>"
						+"<td>" + this.status+ "</td>"
						+"<td>" + test(this.order_start_time)+"</td>"
//,\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\"						
						+"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id +",\""+b.decode(this.employeeUser.name)+"\",\""+b.decode(this.employeeUser.username)+"\",\""+b.decode(this.employerUser.name)+"\",\""+b.decode(this.employerUser.username
)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\",\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\")'>"
				        + "<option value='请选择'>请选择</option>"
						+ "<option  value='查看地理位置'>查看地理位置</option>"
						+ "<option  value='修改订单'>修改订单</option>"
						+ "<option  value='订单详细'>订单详细</option>"
						+ "<option  value='取消订单'>取消订单</option>"
					    + "<select/>"
						+ "</td>" 
					    +"</tr>");
			});
		}
		
	},"json");
}

function selectOrderByWeekInfo(page){
	var b=new Base64();
	//alert(page);
	var page=page;
	var pageSize=20;
	var btu=$("#btu").val();
    var starttime=$("#starttime").val();
	var endtime=$("#endtime").val();
	var workername=$("#eename").val();
	var workerName=b.encode(workername);
	var newname=$("#name").val();
	var name=b.encode(newname);
	var id=$("#id1").val();
 
	
	$.post("OrderForm/selectOrderByWeekInfo.action",{workerName:workerName,name:name,id:id,starttime:starttime,endtime:endtime,btu:btu,page:page,pageSize:pageSize}, function(data){
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function(){
				$("#table_tbody").append("<tr>"
						+"<td>" + this.id+ "</td>"
						+"<td>" + this.eeid+ "</td>" 
						+"<td>" +b.decode(this.employerUser.name)+ "</td>" 
					    +"<td>" +b.decode( this.employerUser.username)+ "</td>" 
						+"<td>" + this.erid + "</td>"
						+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
						+"<td>" + b.decode(this.employeeUser.username)+ "</td>" 
						+"<td>" + test(this.starttime)+ "</td>"
						+"<td>" + test(this.endtime)+ "</td>"
						+"<td>" + test(this.payment)+ "</td>"
						+"<td>" + test(this.allcost)+ "</td>"
						+"<td>" + test(this.actualcost)+ "</td>"
						+"<td>" + this.status+ "</td>"
						+"<td>" + test(this.order_start_time)+"</td>"
//,\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\"						
						+"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id +",\""+b.decode(this.employeeUser.name)+"\",\""+b.decode(this.employeeUser.username)+"\",\""+b.decode(this.employerUser.name)+"\",\""+b.decode(this.employerUser.username
)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\",\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\")'>"
				        + "<option value='请选择'>请选择</option>"
						+ "<option  value='查看地理位置'>查看地理位置</option>"
						+ "<option  value='修改订单'>修改订单</option>"
						+ "<option  value='订单详细'>订单详细</option>"
						+ "<option  value='取消订单'>取消订单</option>"
					    + "<select/>"
						+ "</td>" 
					    +"</tr>");
			});
		}
		
	},"json");
}
function selectOrderByYesterdayInfo(page){
	var b=new Base64();
	//alert(page);
	var page=page;
	var pageSize=20;
	var btu=$("#btu").val();
    var starttime=$("#starttime").val();
	var endtime=$("#endtime").val();
	var workername=$("#eename").val();
	var workerName=b.encode(workername);
	var newname=$("#name").val();
	var name=b.encode(newname);
	var id=$("#id1").val();
 
	
	$.post("OrderForm/selectOrderByYesterdayInfo.action",{workerName:workerName,name:name,id:id,starttime:starttime,endtime:endtime,btu:btu,page:page,pageSize:pageSize}, function(data){
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function(){
				$("#table_tbody").append("<tr>"
						+"<td>" + this.id+ "</td>"
						+"<td>" + this.eeid+ "</td>" 
						+"<td>" +b.decode(this.employerUser.name)+ "</td>" 
					    +"<td>" +b.decode( this.employerUser.username)+ "</td>" 
						+"<td>" + this.erid + "</td>"
						+"<td>" +b.decode(this.employeeUser.name)+ "</td>" 
						+"<td>" + b.decode(this.employeeUser.username)+ "</td>" 
						+"<td>" + test(this.starttime)+ "</td>"
						+"<td>" + test(this.endtime)+ "</td>"
						+"<td>" + test(this.payment)+ "</td>"
						+"<td>" + test(this.allcost)+ "</td>"
						+"<td>" + test(this.actualcost)+ "</td>"
						+"<td>" + this.status+ "</td>"
						+"<td>" + test(this.order_start_time)+"</td>"
//,\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\"						
						+"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id +",\""+b.decode(this.employeeUser.name)+"\",\""+b.decode(this.employeeUser.username)+"\",\""+b.decode(this.employerUser.name)+"\",\""+b.decode(this.employerUser.username
)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\",\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\")'>"
				        + "<option value='请选择'>请选择</option>"
						+ "<option  value='查看地理位置'>查看地理位置</option>"
						+ "<option  value='修改订单'>修改订单</option>"
						+ "<option  value='订单详细'>订单详细</option>"
						+ "<option  value='取消订单'>取消订单</option>"
					    + "<select/>"
						+ "</td>" 
					    +"</tr>");
			});
		}
		
	},"json");
}
function btuu(id,GRusername,eename,username,name,status,longitude,latitude,eeid,erid,starttime,endtime,payment,allcost,actualcost,order_start_time,estimatedTimeOfArrival,DDtime,DDTime,ChiDaoTime,miao,page){
	var miao = $("#miao").val();
  var btu = $("#btu"+id).val();
var chidaoTime=estimatedTimeOfArrival-ChiDaoTime;
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
}if(btu=="修改订单"){
window.location.href="updateOrderForm.jsp?id="+id+"&&starttime="+starttime+"&&endtime="+endtime+"&&payment="+payment+"&&allcost="+allcost+"&&actualcost="+actualcost+"&&longitude="+longitude+"&&latitude="+latitude+"&&status="+status+"&&order_start_time="+order_start_time+"&&page="+page;
}if(btu=="订单详细"){
window.location.href="OrderFormDetailed.jsp?id="+id+"&&GRusername="+GRusername+"&&eename="+eename+"&&username="+username+"&&name="+name+"&&starttime="+starttime+"&&endtime="+endtime+"&&payment="+payment+"&&allcost="+allcost+"&&actualcost="+actualcost+"&&longitude="+longitude+"&&latitude="+latitude+"&&status="+status+"&&order_start_time="+order_start_time+"&&DDtime="+DDtime+"&&estimatedTimeOfArrival="+estimatedTimeOfArrival+"&&DDTime="+DDTime+"&&result="+result+"&&page="+page;
}if(btu=="取消订单"){
	 $.post("OrderForm/cancelOrder.action",{id:id,eeid:eeid,status:status},function(data){
		 if(data!="null"){  
			 alert("修改成功"); 
			 orderform(1);
		  }else{
				 alert("修改失败！");
			 }
		  },"json");
}
}
//下拉的页数
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
	
	if(orderValue=="昨日订单"){
		selectOrderByYesterdayInfo(page);
	}
	
	if(orderValue=="本周订单"){
		selectOrderByWeekInfo(page);
	}
	if(orderValue=="本月订单"){
		selectOrderByMonthInfo(page);
	}
	if(orderValue=="本年订单"){
		selectOrderByYearInfo(page);
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
			if(orderValue=="昨日订单"){
				selectOrderByYesterdayInfo(page);
			}
			
			if(orderValue=="本周订单"){
				selectOrderByWeekInfo(page);
			}
			if(orderValue=="本月订单"){
				selectOrderByMonthInfo(page);
			}
			if(orderValue=="本年订单"){
				selectOrderByYearInfo(page);
			}
//$("[name=select]").append("<option selected>" + page1 + "</option>");
		}
	}

function lastPage(){
	var page = $("[name=page]").html();
	var orderValue=$("#orderValue").val();
	if (page < "1nbsp;") {
		alert("已经是第一页了！");
	} else {
		var page1 = page - 1;
		$("[name=page]").html(page1);
		page -= 1;
//$("[name=select]").append("<option selected>" + page1 + "</option>");
		if(orderValue=="昨日订单"){
			selectOrderByYesterdayInfo(page);
		}
		
		if(orderValue=="本周订单"){
			selectOrderByWeekInfo(page);
		}
		if(orderValue=="本月订单"){
			selectOrderByMonthInfo(page);
		}
		if(orderValue=="本年订单"){
			selectOrderByYearInfo(page);
		}
	}

}

function test(str) {
	if(typeof(str)=="undefined"){ 

		return "";

		}else{
			return str;
		}
}
