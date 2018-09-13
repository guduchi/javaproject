$(function(){
		click();
		querywalletPage();
	});
	function click(){
		$("[name=radio]").bind("click",querybalance);
		$("[name=Newradio]").bind("click",Newquerybalance);
		$("[name=queryByid]").bind("change",queryPage);
		$("[name=select]").bind("change", selectNumber);
		$("[name=last]").bind("click", lastPage);
		$("[name=next]").bind("click", nextPage);
	}
	var radio;
	var Newradio;
	function Newquerybalance(){
		Newradio=$("#Newradio").val();
		querywalletPage(Newradio);
	}
	function querybalance(){
		radio=$("#radio").val();
		Newradio=$("#Newradio").val();
		querywalletPage(Newradio);
	}
function querywalletPage(radio,Newradio){
	
	var name=$("#name").val();
		var b=new Base64();
		var name=b.encode(name);
		var page=$("#page").val();
		if(page=="null" || page==""){
			page=1;
		}else{
			page=page;
		}
		var pageSize =22;
		//获取数量
		$.post("wallet/queryWalletAll.action",{page:page,pageSize:pageSize,name:name,radio:radio,Newradio:Newradio},
			function(data) {
				if (data != null) {
					selectSum(Math.ceil(data/22),page);	
				}
			}, "json");
		$.post("wallet/count.action",{name:name},function(data){
			if(data!=null){
				$("#count").html(data);
			}
		},"json");
		$.post("wallet/queryPaGeAll.action",{page:page,pageSize:pageSize,name:name,radio:radio},
				function(data) {
					if (data != null) {
						$("#table_tbody").empty();
						$.each(data, function() {
							$("#table_tbody").append("<tr>"	
									+ "<td>" + this.id+ "</td>"
									+ "<td>" +b.decode(this.username)+ "</td>" 
									+ "<td>" +b.decode(this.name )+ "</td>" 
									+ "<td>"+ this.balance + "</td>" 
									+ "<td>" + this.residue+ "</td>"+"<td>"
									+  "<select id='btu"+this.id+"' onchange='btuu("+this.id+",\""+b.decode(this.username)+"\",\""+b.decode(this.name)+"\","+this.balance+","+this.residue+","+page+")'>"
							        + "<option value='请选择'>请选择</option>"
									+ "<option  value='修改钱包'>修改钱包</option>"
									+ "<select/>"
									+ "</td>"+"</tr>");
								});
					}
				}, "json");
	}
	  function queryPaGeAll(page,radio){
		    var name=$("#name").val();
			var b=new Base64();
			var name=b.encode(name);
			var page = page;
			var pageSize =22;
		$.post("wallet/queryPaGeAll.action",{page:page,pageSize:pageSize,name:name,radio:radio},
				function(data) {
					if (data != null) {
						$("#table_tbody").empty();
						$.each(data, function() {
							$("#table_tbody").append("<tr>"	
									+ "<td>" + this.id+ "</td>"
									+ "<td>" +b.decode(this.username)+ "</td>" 
									+ "<td>" +b.decode(this.name )+ "</td>" 
									+ "<td>"+ this.balance + "</td>" 
									+ "<td>" + this.residue+ "</td>"+"<td>"
									+  "<select id='btu"+this.id+"' onchange='btuu("+this.id+",\""+b.decode(this.username)+"\",\""+b.decode(this.name)+"\","+this.balance+","+this.residue+","+page+")'>"
							        + "<option value='请选择'>请选择</option>"
									+ "<option  value='修改钱包'>修改钱包</option>"
									+ "<select/>"
									+ "</td>"+"</tr>");
								});
					}
				}, "json");
	}
	  function btuu(id,username,name,balance,residue,page){

		  var btu=$("#btu"+id).val();
		  if(btu=="修改钱包"){
			  window.location.href="user/GRupdateWallet.jsp?id="+id+"&&username="+username+"&&name="+name+"&&balance="+balance+"&&residue="+residue+"&&page="+page;
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
		queryPaGeAll(page,radio);
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
			
			queryPaGeAll(page,radio);
		//	$("[name=select]").append("<option selected>" + page1 + "</option>");
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
			queryPaGeAll(page,radio);
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
		queryPaGeAll(page,radio);
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
	
