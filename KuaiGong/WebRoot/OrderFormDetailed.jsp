<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/Base64.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected");
		$(this).addClass("selected");
	});	
});
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});
});
</script>
<script type="text/javascript">
function selectDetailed(){
    var estimatedTimeOfArrival1;
	var id=$("#id").val();
	var b=new Base64();
    $.post("OrderForm/selectDetailed.action",{id:id},function(data){
		if (data != null) {
			$("#table_tbody_div").empty();
			$.each(data, function(){
				$("#table_tbody_div").append(
						"<div>" + this.id+ "</div>"
						+ "<div>" +this.eeid+ "</div>" 
						+ "<div>" +b.decode(this.eename)+ "</div>"
						+ "<div>" +b.decode(this.GRusername)+ "</div>"
						+ "<div>" +this.erid+ "</div>"
						+ "<div>" +b.decode(this.name)+ "</div>"
						+ "<div>" +b.decode(this.username)+ "</div>"
						+ "<div>" +this.starttime+ "</div>"
						+ "<div>" +have(this.endtime)+ "</div>"
						+ "<div>" +have(this.payment)+ "</div>"
						+ "<div>" +have(this.allcost)+ "</div>"
						+ "<div>" +have(this.actualcost)+ "</div>"
						+ "<div>" +this.status+ "</div>"
						+"<div>" +"<button onclick='queryMAP("+this.longitude+","+this.latitude+")'>点击查看"+"</button>"+"</div>"
						+ "<div>" +this.order_start_time+ "</div>"	
						+ "<div>" +this.DDtime+ "</div>"
						+ "<div>" +testwatime(this.watime)+"</div>"
						+ "<div>" +test1(this.estimatedTimeOfArrival)+"</div>"
						+ "<div>"+testChiDaoTime(this.ChiDaoTime)+"</div>"
						//+ "<div>" +this.miao+"</div>"
						+"</div>");
					});
		}
	}, "json");
}
function testwatime(str9){
str=Math.abs(str9);
	 var theTime = parseInt(str);// 秒 
	 var theTime1 = 0;// 分 
	 var theTime2 = 0;// 小时 
	 // alert(theTime); 
	 if(theTime > 60) { 
	 theTime1 = parseInt(theTime/60); 
	 theTime = parseInt(theTime%60); 
	 // alert(theTime1+"-"+theTime); 
	 if(theTime1 > 60) { 
	 theTime2 = parseInt(theTime1/60); 
	 theTime1 = parseInt(theTime1%60); 
	 } 
	 } 
	 var result = ""+parseInt(theTime)+"秒"; 
	 if(result=="NaN秒"){
		 result=0+"秒";
	 }
	 if(theTime1 > 0) { 
	 result = ""+parseInt(theTime1)+"分"+result; 
	 } 
	 if(theTime2 > 0) { 
	 result = ""+parseInt(theTime2)+"小时"+result; 
	 } 
	 return result;

 }

 function have(str) {
		if(typeof(str)=="undefined"){ 

			return "";

			}else{
				return str;
			}
	}

	 function testChiDaoTime(str1){
	      str2=Math.abs(str1);
	           
           var belate=str2-estimatedTimeOfArrival1; 
		   
		     if(belate<1){
		 	//  str=Math.abs(str1);
		 	Newbelate=Math.abs(belate);
		 	  var theTime = parseInt(Newbelate);// 秒
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
		 	    var result = ""+parseInt(theTime)+"秒"+"     " +"<font color='green'>(没迟到)</font>";
		 	    if(theTime1 >=0) {
		 	    result = ""+parseInt(theTime1)+"分"+result;
		 	    }
		 	    if(theTime2 >=0) {
		 	    result = ""+parseInt(theTime2)+"小时"+result;
		 	 result="<font color='green'>提前到达</font>"+"   "+(result);
		 	
		 	        }
		 	        return result;
		 	    
		 }else{
		 
		 	  var theTime = parseInt(belate);// 秒
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
		 	  
		 	    var result = ""+parseInt(theTime)+"秒"+"     " +"<font color='red'>迟到</font>";
		 	    if(theTime1 >=0) {
		 	    result = ""+parseInt(theTime1)+"分"+result;
		 	    }
		 	    if(theTime2 >=0) {
		 	    result = ""+parseInt(theTime2)+"小时"+result;
		 	 
		   }
		   return result;
		 }
		 }
		 

  function test1(str){
  if(str!=null){
	 estimatedTimeOfArrival1=str*60;
    
    var theTime = parseInt(estimatedTimeOfArrival1);// 秒
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
    var result1 = ""+parseInt(theTime)+"秒";
    if(theTime1 >=0) {
    result1 = ""+parseInt(theTime1)+"分"+result1;
    }
    if(theTime2 >=0) {
    result1 = ""+parseInt(theTime2)+"小时"+result1;
 
        }
          return result1;
          }
          else{
          return "";
          
          }
}

function queryMAP( longitude,latitude){
		window.location.href="/KuaiGong/user/GRmap.jsp?longitude="+longitude+"&&latitude="+latitude;
	}
	
	
	
</script>
<!--  
function test(str){
var miao = $("#miao").val();
    	var estimatedTimeOfArrival1=$("#estimatedTimeOfArrival").val();
    	
	var chidaoTime=str-estimatedTimeOfArrival1;

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
	    var result = ""+parseInt(theTime)+"秒"+"     " +"<font color='green'>(没迟到)</font>";
	    if(theTime1 >=0) {
	    result = ""+parseInt(theTime1)+"分"+result;
	    }
	    if(theTime2 >=0) {
	    result = ""+parseInt(theTime2)+"小时"+result;
	 result="<font color='green'>提前到达</font>"+"   "+(result);
	
	        }
	        return result;
	    
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
	  
	    var result = ""+parseInt(theTime)+"秒"+"     " +"<font color='red'>迟到</font>";
	    if(theTime1 >=0) {
	    result = ""+parseInt(theTime1)+"分"+result;
	    }
	    if(theTime2 >=0) {
	    result = ""+parseInt(theTime2)+"小时"+result;
	 
  }
  return result;
}
}
  -->
</head>
<%
String id = request.getParameter("id");
String estimatedTimeOfArrival=request.getParameter("estimatedTimeOfArrival");
String page1=request.getParameter("page");
 %>
<body onload="selectDetailed()">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li>订单列表</li>
    <!--  ?page=<%=page1%>-->
    <li>订单详细情况</li>
    </ul>
    </div>
    <li> <input type="hidden" id="id" value="<%=id%>"/></li>
     <li> <input type="hidden" id="page" value="<%=page1%>"/></li>
     <li> <input type="hidden" id="estimatedTimeOfArrival" value="<%=estimatedTimeOfArrival%>"/></li>
<div class="rightinfo">
<div class="table_tbody_box">
<div class="table_tbody_divText">
	<div>订单编号:</div>
	<div>工人编号:</div>
	<div>工人姓名:</div>
	<div>工人电话:</div>
	<div>雇主编号:</div>
	<div>雇主姓名:</div>
	<div>雇主电话:</div>
	<div>开始时间:</div>
	<div>结束时间:</div>
	<div>支付方式:</div> 
	<div>全部费用:</div>
	<div>实收费用:</div>
	<div>状态:</div>
	<div>查看位置:</div>
    <div>开始订单时间:</div>
    <div>等待时长:</div>
     <div>实际到达时间</div>
    <div>预计到达时长:</div>
	 <div>迟到时间:</div>
</div>
<div id="table_tbody_div" class="table_tbody_div">
</div>
</div>
    <div class="message">
				</div>
    </div>
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>