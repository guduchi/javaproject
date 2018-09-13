$(function(){
		click();
		queryMohuChaXun(1);
	});
	function click(){
		
		$("[name=select]").bind("change", selectNumber);
		$("[name=last]").bind("click", lastPage);
		$("[name=next]").bind("click", nextPage);
	}
	
	function queryMohuChaXun(page){
		var id=$("#id").val();
		var OrderID=$("#orderid").val();
		var query=$("#query").val();
		var b=new Base64();
		var name=b.encode(query);
		var starttime=$("#starttime").val();
		var endtime=$("#endtime").val();
		var page = page;
		var pageSize = 8;
		var b = new Base64();
		$.post("OrderForm/GROrderFormPage.action",{page:page,pageSize:pageSize,id:id,OrderID:OrderID,name:name,starttime:starttime,endtime:endtime},
			function(data) {
				if (data != null) {
					selectSum(Math.ceil(data/8));
				}
			}, "json");
		$.post("OrderForm/selectWorkAll.action",{id:id,OrderID:OrderID,name:name,starttime:starttime,endtime:endtime},function(data){
			if(data!=null){
				$("#count").html(data);
			}
		},"json");
		$.post("OrderForm/GROrderFormInfo.action",{page:page,pageSize:pageSize,id:id,OrderID:OrderID,name:name,starttime:starttime,endtime:endtime},
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
									+"<td>"+"<select id='btu"+this.id+"' onchange='btuu("+this.id+",\""+b.decode(this.GRusername)+"\",\""+b.decode( this.eename)+"\",\""+b.decode( this.username)+"\",\""+b.decode(this.name)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\",\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\")'>"
							        + "<option value='请选择'>请选择</option>"
									+ "<option  value='查看地理位置'>查看地理位置</option>"
									+ "<option  value='查看评价'>查看评价</option>"
									+ "<option  value='修改订单'>修改订单</option>"
									+ "<option  value='订单详细'>订单详细</option>"
									+ "<option  value='取消订单'>取消订单</option>"
								    + "<select/>"
									+ "</td>"+"</tr>");
						});
					}
				}, "json");
	}
	 
	 function GROrderFormInfo(page){
		 	var id=$("#id").val();
			var OrderID=$("#orderid").val();
			var query=$("#query").val();
			var b=new Base64();
			var name=b.encode(query);
			var starttime=$("#starttime").val();
			var endtime=$("#endtime").val();
			var page = page;
			var pageSize = 8;
			var b = new Base64();
	 $.post("OrderForm/GROrderFormInfo.action",{page:page,pageSize:pageSize,id:id,OrderID:OrderID,name:name,starttime:starttime,endtime:endtime},
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
									 +"<td>"+ "<select id='btu"+this.id+"' onchange='btuu("+this.id+",\""+b.decode(this.GRusername)+"\",\""+b.decode( this.eename)+"\",\""+b.decode( this.username)+"\",\""+b.decode(this.name)+"\",\""+this.status+"\","+this.longitude+","+this.latitude+","+this.eeid+","+this.erid+",\""+this.starttime+"\",\""+this.endtime+"\",\""+this.payment+"\",\""+this.allcost+"\",\""+this.actualcost+"\",\""+this.order_start_time+"\",\""+this.estimatedTimeOfArrival+"\",\""+this.DDtime+"\",\""+this.DDTime+"\",\""+this.ChiDaoTime+"\")'>"
								        + "<option value='请选择'>请选择</option>"
										+ "<option  value='查看地理位置'>查看地理位置</option>"
										+ "<option  value='查看评价'>查看评价</option>"
										+ "<option  value='修改订单'>修改订单</option>"
										+ "<option  value='订单详细'>订单详细</option>"
										+ "<option  value='取消订单'>取消订单</option>"
									    + "<select/>"
										+ "</td>"+"</tr>");
						});
					}
				}, "json");
	}
	 
	 
	 
	 
	 function btuu(id,GRusername,eename,username,name,status,longitude,latitude,eeid,erid,starttime,endtime,payment,allcost,actualcost,order_start_time,estimatedTimeOfArrival,DDtime,DDTime,ChiDaoTime){
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
alert(id);
	if(btu=="查看地理位置"){
		window.location.href="/KuaiGong/user/GRmap.jsp?longitude="+longitude+"&&latitude="+latitude;
	}if(btu=="查看评价"){
		window.location.href="/KuaiGong/GROrderFormApp.jsp?id="+id;
	}if(btu=="取消原因"){
		window.location.href="Cancel.jsp?id="+id;
	}if(btu=="修改订单"){
		window.location.href="updateOrderForm.jsp?id="+id+"&&starttime="+starttime+"&&endtime="+endtime+"&&payment="+payment+"&&allcost="+allcost+"&&actualcost="+actualcost+"&&longitude="+longitude+"&&latitude="+latitude+"&&status="+status+"&&order_start_time="+order_start_time;
	}if(btu=="订单详细"){
		window.location.href="OrderFormDetailed.jsp?id="+id+"&&GRusername="+GRusername+"&&eename="+eename+"&&username="+username+"&&name="+name+"&&starttime="+starttime+"&&endtime="+endtime+"&&payment="+payment+"&&allcost="+allcost+"&&actualcost="+actualcost+"&&longitude="+longitude+"&&latitude="+latitude+"&&status="+status+"&&order_start_time="+order_start_time+"&&DDtime="+DDtime+"&&estimatedTimeOfArrival="+estimatedTimeOfArrival+"&&DDTime="+DDTime+"&&result="+result;
		}
	   }
		// 下拉的页数
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
		  // 下拉选择页数
		  function selectNumber() {
		  	page = $(this).children('option:selected').val();
		  	$("[name=page]").html(page);
		  	GROrderFormInfo(page);
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
					GROrderFormInfo(page);
//			$("[name=select]").append("<option selected>" + page1 + "</option>");
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
//		  		$("[name=select]").append("<option selected>" + page1 + "</option>");
		  		GROrderFormInfo(page);
		  	}

		  }
		  
		  
		  function queryMAP( longitude,latitude){
		 	//alert(portrait);
		 		window.location.href="/KuaiGong/user/GRmap.jsp?longitude="+longitude+"&latitude="+latitude;

		 	}
		  function test(str) {
		 		if(typeof(str)=="undefined"){ 

		 			return "";

		 			}else{
		 				return str;
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

	function Base64() {  
		   
	    // private property  
	    _keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";  
	   
	    // public method for encoding  
	    this.encode = function (input) {  
	        var output = "";  
	        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;  
	        var i = 0;  
	        input = _utf8_encode(input);  
	        while (i < input.length) {  
	            chr1 = input.charCodeAt(i++);  
	            chr2 = input.charCodeAt(i++);  
	            chr3 = input.charCodeAt(i++);  
	            enc1 = chr1 >> 2;  
	            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);  
	            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);  
	            enc4 = chr3 & 63;  
	            if (isNaN(chr2)) {  
	                enc3 = enc4 = 64;  
	            } else if (isNaN(chr3)) {  
	                enc4 = 64;  
	            }  
	            output = output +  
	            _keyStr.charAt(enc1) + _keyStr.charAt(enc2) +  
	            _keyStr.charAt(enc3) + _keyStr.charAt(enc4);  
	        }  
	        return output;  
	    };  
	   
	    // public method for decoding  
	    this.decode = function (input) {  
	        var output = "";  
	        var chr1, chr2, chr3;  
	        var enc1, enc2, enc3, enc4;  
	        var i = 0;  
	        input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");  
	        while (i < input.length) {  
	            enc1 = _keyStr.indexOf(input.charAt(i++));  
	            enc2 = _keyStr.indexOf(input.charAt(i++));  
	            enc3 = _keyStr.indexOf(input.charAt(i++));  
	            enc4 = _keyStr.indexOf(input.charAt(i++));  
	            chr1 = (enc1 << 2) | (enc2 >> 4);  
	            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);  
	            chr3 = ((enc3 & 3) << 6) | enc4;  
	            output = output + String.fromCharCode(chr1);  
	            if (enc3 != 64) {  
	                output = output + String.fromCharCode(chr2);  
	            }  
	            if (enc4 != 64) {  
	                output = output + String.fromCharCode(chr3);  
	            }  
	        }  
	        output = _utf8_decode(output);  
	        return output;  
	    }  
	   
	    // private method for UTF-8 encoding  
	    _utf8_encode = function (string) {  
	        string = string.replace(/\r\n/g,"\n");  
	        var utftext = "";  
	        for (var n = 0; n < string.length; n++) {  
	            var c = string.charCodeAt(n);  
	            if (c < 128) {  
	                utftext += String.fromCharCode(c);  
	            } else if((c > 127) && (c < 2048)) {  
	                utftext += String.fromCharCode((c >> 6) | 192);  
	                utftext += String.fromCharCode((c & 63) | 128);  
	            } else {  
	                utftext += String.fromCharCode((c >> 12) | 224);  
	                utftext += String.fromCharCode(((c >> 6) & 63) | 128);  
	                utftext += String.fromCharCode((c & 63) | 128);  
	            }  
	   
	        }  
	        return utftext;  
	    }  
	   
	    // private method for UTF-8 decoding  
	    _utf8_decode = function (utftext) {  
	        var string = "";  
	        var i = 0;  
	        var c = c1 = c2 = 0;  
	        while ( i < utftext.length ) {  
	            c = utftext.charCodeAt(i);  
	            if (c < 128) {  
	                string += String.fromCharCode(c);  
	                i++;  
	            } else if((c > 191) && (c < 224)) {  
	                c2 = utftext.charCodeAt(i+1);  
	                string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));  
	                i += 2;  
	            } else {  
	                c2 = utftext.charCodeAt(i+1);  
	                c3 = utftext.charCodeAt(i+2);  
	                string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));  
	                i += 3;  
	            }  
	        }  
	        return string;  
	    }  
	}
