$(function(){
	click();
	queryInfomation(1);
	});


function click(){
	
	$("[name=ssradio]").bind("click",querySort);
	$("[name=queryByid]").bind("change",queryPage);
	//$("[name=queryByid]").bind("change",queryPage);
	$("[name=select]").bind("change",selectNumber);
	$("[name=last]").bind("click",lastPage);
	$("[name=next]").bind("click",nextPage);
	
}
var radio;
function querySort(){
	radio=$("#radio").val();
	queryInfomation();
}
function queryInfomation(){

    var starttime=$("#starttime").val();
	var endtime=$("#endtime").val();
    var username=$("#username").val();
	var page=1;
	var pageSize=22;
	var btu=$("#btu").val();
	var b = new  Base64();
  var name=b.encode(username);
	$.post("onlineInformation/querystatus.action",{page:page,pageSize:pageSize,btu:btu,name:name,starttime:starttime,endtime:endtime,radio:radio},function(data){
		if(data!=null){
			selectSum(Math.ceil(data / 22));
		}
	},"json");
	$.post("onlineInformation/count.action",{btu:btu,name:name,starttime:starttime,endtime:endtime},function(data){
		if(data!=null){
			$("#count").html(data);
		}
	},"json");
	$.post("onlineInformation/timeCount.action",{btu:btu,name:name,starttime:starttime,endtime:endtime},function(data){
		DataArr=data;
		for(var z=0 in DataArr){
		var ss=	AllID.push(DataArr[z].starttimeDay);
			console.log(ss);
		}
	},"json");
	$.post("onlineInformation/querystatusPage.action",{page:page,pageSize:pageSize,btu:btu,name:name,starttime:starttime,endtime:endtime,radio:radio},function(data){
		$("#table_tbody").empty();
		$.each(data,function(){
			$("#table_tbody").append("<tr>" 
					+ "<td>" +this.id +  "</td>" 
					+ "<td>"+b.decode(this.username)+ "</td>"
					+ "<td>"+b.decode(this.name)+"</td>"
					+"<td>"+this.startime+ "</td>"
					+"<td>"+test(this.endtime)+ "</td>"
					+ "<td>"+this.status+ "</td>"
					+ "<td>"+testStarttime(this.starttimeDay)+ "</td>"
					+ "<td>"+testEndTimeDay(this.endTimeDay)+ "</td>"	
					+ "<td>"+testChaDay(this.ChaDay)+ "</td>"	
				//	+ "<td>"+testOffLine(this.offLine)+ "</td>"	
					+"</tr>");
		});
	},"json");
}

function querystatusPage(page,radio){
    var starttime=$("#starttime").val();
	var endtime=$("#endtime").val();
    var username=$("#username").val();
	var page=page;
	var pageSize=22;
	var btu=$("#btu").val();
	var b = new  Base64();
  var name=b.encode(username);
	$.post("onlineInformation/querystatusPage.action",{page:page,pageSize:pageSize,btu:btu,name:name,starttime:starttime,endtime:endtime,radio:radio},function(data){
		$("#table_tbody").empty();
		$.each(data,function(){
			$("#table_tbody").append("<tr>" 
					+ "<td>" +this.id +  "</td>" 
					+ "<td>"+b.decode(this.username)+ "</td>"
					+ "<td>"+b.decode(this.name)+"</td>"
					+"<td>"+this.startime+ "</td>"
					+"<td>"+test(this.endtime)+ "</td>"
					+ "<td>"+this.status+ "</td>"
					+ "<td>"+testStarttime(this.starttimeDay)+ "</td>"
					+ "<td>"+testEndTimeDay(this.endTimeDay)+ "</td>"	
					+ "<td>"+testChaDay(this.ChaDay)+ "</td>"
					//+ "<td>"+testOffLine(this.offLine)+ "</td>"	
					+"</tr>");
		});
	},"json");
}
//function testOffLine(testOffLineValue){
//	if(typeof(testOffLineValue)=="undefined"){
//		return "";
//	}else{
//		 var theTime = parseInt(testOffLineValue);// 秒
//		    var theTime1 = 0;// 分
//		    var theTime2 = 0;// 小时
//		    if(theTime > 60) {
//		        theTime1 = parseInt(theTime/60);
//		        theTime = parseInt(theTime%60);
//		            if(theTime1 > 60) {
//		            theTime2 = parseInt(theTime1/60);
//		            theTime1 = parseInt(theTime1%60);
//		            }
//		    }
//		        var result = ""+parseInt(theTime)+"秒";
//		        if(theTime1 > 0) {
//		        result = ""+parseInt(theTime1)+"分"+result;
//		        }
//		        if(theTime2 > 0) {
//		        result = ""+parseInt(theTime2)+"小时"+result;
//		        }
//		        
//		    return result;
//			
//			
//		}	
//	}
//





function testStarttime(StrValue){

	if(typeof(StrValue)=="undefined"){
		return "";
	}else{
	    var theTime = parseInt(StrValue);// 秒
	    var theTime1 = 0;// 分
	    var theTime2 = 0;// 小时
	    if(theTime > 60) {
	        theTime1 = parseInt(theTime/60);
	        theTime = parseInt(theTime%60);
	            if(theTime1 > 60) {
	            theTime2 = parseInt(theTime1/60);
	            theTime1 = parseInt(theTime1%60);
	            }
	    }
	        var result = ""+parseInt(theTime)+"秒";
	        if(theTime1 > 0) {
	        result = ""+parseInt(theTime1)+"分"+result;
	        }
	        if(theTime2 > 0) {
	        result = ""+parseInt(theTime2)+"小时"+result;
	        }
	        
	    return result;
		
		
	}
}
function testEndTimeDay(StrValue1){
	if(typeof(StrValue1)=="undefined"){
		return "";
	}else{
		var theTime = parseInt(StrValue1);// 秒
	    var theTime1 = 0;// 分
	    var theTime2 = 0;// 小时
	    if(theTime > 60) {
	        theTime1 = parseInt(theTime/60);
	        theTime = parseInt(theTime%60);
	            if(theTime1 > 60) {
	            theTime2 = parseInt(theTime1/60);
	            theTime1 = parseInt(theTime1%60);
	            }
	    }
	        var result = ""+parseInt(theTime)+"秒";
	        if(theTime1 > 0) {
	        result = ""+parseInt(theTime1)+"分"+result;
	        }
	        if(theTime2 > 0) {
	        result = ""+parseInt(theTime2)+"小时"+result;
	        }
	        
	    return result;
	}
	
}
function testChaDay(StrValue2){
	if(typeof(StrValue2)=="undefined"){
		return "";
	}else{
		return StrValue2+"天";
	}
}



function formatSeconds(value) {
if(typeof(value)=="undefined"){
	value=0;
}
		var theTime = parseInt(value);// 秒
	    var theTime1 = 0;// 分
	    var theTime2 = 0;// 小时
	    if(theTime > 60) {
	        theTime1 = parseInt(theTime/60);
	        theTime = parseInt(theTime%60);
	            if(theTime1 > 60) {
	            theTime2 = parseInt(theTime1/60);
	            theTime1 = parseInt(theTime1%60);
	            }
	    }
	        var result = ""+parseInt(theTime)+"秒";
	        if(theTime1 > 0) {
	        result = ""+parseInt(theTime1)+"分"+result;
	        }
	        if(theTime2 > 0) {
	        result = ""+parseInt(theTime2)+"小时"+result;
	        }
	        
	    return result;
	   
	 
}

function test(str) {
		if(typeof(str)=="undefined"){ 

			return "";

			}else{
				return str;
			}
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

function selectNumber() {
	page = $(this).children('option:selected').val();
	$("[name=page]").html(page);
	querystatusPage(page,radio);
}

function nextPage() {

	var page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	if (parseInt(page) >= parseInt(sum)) {
		alert("已经是最后一页！");
	} else {
		var page1 = parseInt(page) + 1;
		$("[name=page]").html(page1);
		page = parseInt(page) + 1;
		querystatusPage(page,radio);
	//	$("[name=select]").append("<option selected>" + page1 + "</option>");
	}

}
function lastPage() {
	page = $("[name=page]").html();
	if (page < 2) {
		alert("已经是第一页！");
	} else {
		var page1 = page - 1;
		$("[name=page]").html(page1);
		page -= 1;
	//	$("[name=select]").append("<option selected>" + page1 + "</option>");
		querystatusPage(page,radio);
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
	querystatusPage(page,radio);
}
}
