$(function(){
	click();
	queryUserPage();
	queryCount();
});

function click(){
	$("[name=queryByid]").bind("change",queryPage);
	$("[name=registers]").bind("click",register);
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}

function queryCount(){

	$.post("discount/count.action",function(data){
		if(data!=null){
			$("#count").html(data);
		}
	},"json");
}

function register() {
	var address = "/KuaiGong/discountCoupon/adddiscountCoupon.jsp";
	window.location.href = address;
}

function queryUserPage(){
	var query1=$("#query").val();
	var page=$("#page").val();
	if(page=="null" || page==""){
		page=1;
	}else{
		page=page;
	}
	 
	var pageSize =22;
	var b = new Base64();
    var query=b.encode(query1);
	
	//获取数量
	
	$.post("discount/queryUserPage.action",{page:page,pageSize:pageSize,query:query},
		function(data) {
			if (data != null) {
				selectSum(Math.ceil(data/22),page);
			}
		}, "json");
	$.post("discount/count.action",{query:query},function(data){
		if(data!=null){
			$("#count").html(data);
		}
	},"json");
	$.post("discount/queryUserInfo.action",{page:page,pageSize:pageSize,query:query},
			function(data) {
				if (data != null) {
					
					$("#table_tbody").empty();
					$.each(data, function() {
				
						$("#table_tbody").append("<tr>"
								+ "<td>" + this.id 

+ "</td>"
								
							+
							"<td>" + this.erid+ "</td>"
							+
							"<td>" +b.decode(this.username)+ "</td>" +
							"<td>" +b.decode(this.name 

)+ "</td>" +"<td>"
								+this.money+ "</td>"+
								"<td>"+(this.endtime>getNowFormatDate()?this.status:(this.status=="已使用"?"已使用":"已过期"))+ "</td>" 
										+"<td>"+this.endtime+ "</td>" 
										+"<td>"+this.balance+ "</td>" 
						    +"<td>"+ "<select id='btu"+this.id+"' onchange='btuuu("+this.id+","+this.money+",\""+this.status+"\",\""+this.endtime+"\","+page+","+this.balance+","+this.erid+")'>"
					        + "<option value='请选择'>请选择</option>"
							+ "<option  value='修改'>修改</option>"
							+ "<option  value='删除'>删除</option>"
						  + "<select/>"
							+ "</td>"+"</tr>");
							
					});
				}
			}, "json");
}
//没有加密 b.decode(this.username)
  function queryUserInfo(page){
	  var query1=$("#query").val();
	var page = page;
	var pageSize =22;
	var b = new Base64();
	var query=b.encode(query1);
	$.post("discount/queryUserInfo.action",{page:page,pageSize:pageSize,query:query},
			function(data) {
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function() {
            $("#table_tbody").append("<tr>"
						+ "<td>" + this.id+ "</td>"
						+"<td>" + this.erid+ "</td>"
						+"<td>" +b.decode(this.username)+ "</td>" 
						+"<td>" +b.decode(this.name)+ "</td>" +"<td>"
						+ this.money + "</td>" +
						"<td>"+(this.endtime>getNowFormatDate()?this.status:(this.status=="已使用"?"已使用":"已过期"))+ "</td>" 
						+"<td>"+this.endtime+ "</td>" 
						+"<td>"+this.balance+ "</td>" 
						 +"<td>"+ "<select id='btu"+this.id+"' onchange='btuuu("+this.id+","+this.money+",\""+this.status+"\",\""+this.endtime+"\","+page+","+this.balance+","+this.erid+")'>"
					        + "<option value='请选择'>请选择</option>"
							+ "<option  value='修改'>修改</option>"
							+ "<option  value='删除'>删除</option>"
						  + "<select/>"
							+ "</td>"+ "</tr>"
							
				);
					});
		}
	}, "json");
}
  
  
  function getNowFormatDate() {
	    var date = new Date();
	    var seperator1 = "-";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
	            + " " + date.getHours() + seperator2 + date.getMinutes()
	            + seperator2 + date.getSeconds();
	    return currentdate;
	}

  
  function btuuu(id,money,status,endtime,page,balance,erid){
	
	  var btu=$("#btu"+id).val();
	  if(btu=="修改"){
		  window.location.href="user/updataCoupon.jsp?id="+id+"&&money="+money+"&&status="+status+"&&endtime="+endtime+"&&page="+page+"&&balance="+balance+"&&erid="+erid;
	  }
	  if(btu=="删除"){
		  var ss = confirm("您确定要删除吗?");
			if (ss) {
				$.post("discount/delete.action", {
					id : id
				}, function(data, status) {
					if (data != null && data != "") {
						alert("删除成功！");
						window.location.href = "discountcoupon.jsp?page="+page;
					} else {
						alert("删除失败，请检查！");
					}
				}, "json");
				// }
				// });
			}
	  }
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
		//$("[name=select]").append("<option selected>" + page1 + "</option>");
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
		//$("[name=select]").append("<option selected>" + page1 + "</option>");
		queryUserInfo(page);
	}
	
}
//跳转指定页面
function queryPage(){
	var querypage=$("#querypage").val();
	var sum = $("[name=sum]").html();
	if(querypage>parseInt(sum)){
		alert("没有找到页数");
	}
	else{
	var page=querypage;
	$("[name=page]").html(page);
	queryUserInfo(page);
}
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
