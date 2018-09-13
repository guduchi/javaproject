$(function() {
	click();
	selectPay();
});

function click() {
	$("[name=queryByid]").bind("change",queryPage);
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}
function selectPay(){
	var page=$("#page").val();
	if(page=="null" || page=="" || page=="undefined"){
		page=1;
	}else{
		page=page;
	}
	var pageSize = 22;
	var b = new Base64();
	var id = $("#id").val();
	var eename = $("#eename").val();
	var name = $("#name").val();
	var btu = $("#btu").val();
	var starttime=$("#starttime").val();
	var endtime =$("#endtime").val();
	var name=b.encode(name);
	var eename=b.encode(eename);
	$.post("OrderForm/selectPaymentWeiXin.action",{page:page,pageSize:pageSize,id:id,eename:eename,name:name,btu:btu,starttime:starttime,endtime:endtime},
			function(data) {
		if (data != null){
			selectSum(Math.ceil(data/22),page);
		}
	}, "json");
	$.post("OrderForm/selectPaymentWeiXinMoney.action",{id:id,name:name,eename:eename,starttime:starttime,endtime:endtime,btu:btu},function(data){
		if(data!=null){
		$("#fontCount").html(data.paymentWeiXinMoney);
	}
},"json");
	$.post("OrderForm/selectPaymentWeiXinCount.action",{id:id,name:name,eename:eename,starttime:starttime,endtime:endtime,btu:btu},function(data){
		if(data!=null){
			$("#count").html(data);
		}
	},"json");
	$.post("OrderForm/selectPaymentWeiXinPage.action",{page:page,pageSize:pageSize,id:id,eename:eename,name:name,btu:btu,starttime:starttime,endtime:endtime},
			function(data) {
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data,function() {
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
						+"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id 

+",\""+b.decode(this.GRusername)+"\",\""+b.decode( this.eename)+"\",\""+b.decode( this.username)+"\",\""+b.decode(this.name 

)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\",\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\",\""+page+"\")'>"
				        + "<option value='请选择'>请选择</option>"
						+ "<option  value='查看地理位置'>查看地理位置</option>"
						+ "<option  value='查看评价'>查看评价</option>"
						+ "<option  value='修改订单'>修改订单</option>"
						+ "<option  value='订单详细'>订单详细</option>"
						+ "<option  value='取消订单'>取消订单</option>"
					    + "<select/>"
						+ "</td>"
					    +"</tr>");
			});
		}
	}, "json");
}

function selectPaymentWeiXinPage(page){
	var page=page;
	var pageSize = 22;
	var b = new Base64();
	var id = $("#id").val();
	var eename = $("#eename").val();
	var name = $("#name").val();
	var btu = $("#btu").val();
	var starttime=$("#starttime").val();
	var endtime =$("#endtime").val();
	var name=b.encode(name);
	var eename=b.encode(eename);
	$.post("OrderForm/selectPaymentWeiXinPage.action",{page:page,pageSize:pageSize,id:id,eename:eename,name:name,btu:btu,starttime:starttime,endtime:endtime},
			function(data) {
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append("<tr>"
						+"<td>" + this.id+ "</td>"
						+"<td>" + this.eeid+ "</td>" 
						+"<td>" +b.decode(this.GRusername)+ "</td>" 
						+"<td>" +b.decode(this.eename)+ "</td>" 
						+"<td>" + this.erid + "</td>" 
						+"<td>" +b.decode(this.username)+ "</td>" 
						+"<td>" +b.decode(this.name)+ "</td>" 
						+"<td>" + test(this.starttime)+ "</td>"
						+"<td>" + test(this.endtime)+ "</td>"
						+"<td>" + test(this.payment)+ "</td>"
						+"<td>" + test(this.allcost)+ "</td>"
						+"<td>" + test(this.actualcost)+ "</td>"
						+"<td>" + this.status+ "</td>" 
						+"<td>" + test(this.order_start_time)+"</td>"
						+"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id+",\""+b.decode(this.GRusername)+"\",\""+b.decode( this.eename)+"\",\""+b.decode( this.username)+"\",\""+b.decode(this.name)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\",\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\",\""+this.miao+"\",\""+page+"\")'>"
				        + "<option value='请选择'>请选择</option>"
						+ "<option  value='查看地理位置'>查看地理位置</option>"
						+ "<option  value='查看评价'>查看评价</option>"
						+ "<option  value='修改订单'>修改订单</option>"
						+ "<option  value='订单详细'>订单详细</option>"
						+ "<option  value='取消订单'>取消订单</option>"
					    + "<select/>"
						+ "</td>"
					    +"</tr>");
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
	selectPaymentWeiXinPage(page);
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
		selectPaymentWeiXinPage(page);
	
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
		selectPaymentWeiXinPage(page);
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
		selectPaymentWeiXinPage(page);
	}
}
function test(str) {
	if(typeof(str)=="undefined"){ 
		return "";
		}else{
			return str;
		}
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
}if(btu=="查看评价"){
	window.location.href="/KuaiGong/AppraiseOrder.jsp?id="+id+"&&page="+page;
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
