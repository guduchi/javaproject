$(function(){
	click();
});

function click(){
	$("[name=login]").bind("click",login);
	$("[name=registers]").bind("click",register);
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}

function queryUserPage(page){
	var page = page;
	var pageSize = 8;
	var b = new Base64();
	//获取数量
	$.post("onlineInformation/queryUserPage.action",{page:page,pageSize:pageSize},
		function(data) {
			if (data != null) {
				selectSum(Math.ceil(data/8));
			}
		}, "json");
	$.post("onlineInformation/queryUserInfo.action",{page:page,pageSize:pageSize},
			function(data) {
				if (data != null) {
					$("#table_tbody").empty();
					$.each(data, function() {
						
						$("#table_tbody").append("<tr>"
								+ "<td>" + this.id+ "</td>"
								+ "<td>" +this.eeid+ "</td>" + "<td>"
								+this.startime + "</td>" + "<td>" +this.endtime+ "</td>" 
								+ "<td><a href='onlineInformation/updataonlineInformation.jsp?id="+this.id+"&eeid="+this.eeid+"&startime="+this.startime+"&endtime="+this.endtime+"'>修改 </a>"+"</td>"+"<td><a href=javascript:void(0)  onclick =deleteByid("+this.id+") >删除</a>"+"</td>"+ "</tr>");
							});
				}
			}, "json");
}


//没有加密 b.decode(this.username)
  function queryUserInfo(page){
	var page = page;
	var pageSize = 8;
	var b = new Base64();
	$.post("onlineInformation/queryUserInfo.action",{page:page,pageSize:pageSize},
			function(data) {
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append("<tr>"
						+ "<td>" + this.id+ "</td>"
						+ "<td>" +this.eeid+ "</td>" + "<td>"
						+this.startime+ "</td>" + "<td>" +this.endtime+ "</td>" 
						+ "<td><a href='onlineInformation/updataonlineInformation.jsp?id="+this.id+"&eeid="+this.eeid+"&startime="+this.startime+"&endtime="+this.endtime+"'>修改 </a>"+"</td>"+"<td><a href=javascript:void(0)  onclick =deleteByid("+this.id+") >删除</a>"+"</td>"+ "</tr>");
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
function Base64() {  
	   
    // private property  
    _keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";  
   
    // public method for encoding  
    this.decode = function (input) {  
        var output = "";  
        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;  
        var i = 0;  
        input = _utf8_decode(input);  
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
    } 
   
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
    _utf8_decode = function (string) {  
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
