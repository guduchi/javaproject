$(function() {
	click();
	queryCount();
});

function click() {
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}

function queryCount(){
	var id=$("#id").val();
	$.post("OrderForm/selectSingle.action",{id:id},function(data){
		if(data!=null){
			$("#count").html(data);
		}
	},"json");
}

function queryEeuserToErUser(){
	var id=$("#id").val();

	var page=1;
	var pageSize=8;
	var b=new Base64();
	var id=$("#id").val();
	
	$.post("OrderForm/selectByIDpage.action",{id:id,page:page,pageSize:pageSize},function(data){
		if (data != null) {
			selectSum(Math.ceil(data / 8));
		}
	}, "json");
	$.post("OrderForm/selectByIDpageInfo.action",{id:id,page:page,pageSize:pageSize},function(data){
		if(data!=null){
		$("#table_tbody").empty();
		$.each(data,function(){
			$("#table_tbody").append("<tr>" 
					+ "<td>" +this.id +  "</td>" 
					+ "<td>" +this.erid +  "</td>" 
					+"<td>" +b.decode(this.name)+ "</td>"  
					+"<td>" +b.decode(this.username)+ "</td>" 
					+"<td>"+b.decode(this.eename)+"</td>"
					+"<td>"+b.decode(this.GRusername)+ "</td>" 
					+ "<td>"+test(this.starttime)+"</td>"
					+"<td>"+test(this.endtime)+ "</td>"
					+"<td>"+test(this.payment)+ "</td>"
					+"<td>"+test(this.allcost)+ "</td>" 
					+"<td>"+this.status+ "</td>"
					+"<td><input type='checkbox' name='checkbox' value="+this.id+" "+testFlag()+">"+"</td>"+"<td><a href=QueryManager.jsp?id="+this.erid+" >返回上一层</a>"+"</td>"+"<td><a href='queryOrderForm.jsp?id="+ this.id+ "'>查看详细信息</a>" 
					+ "<td><a href=javascript:void(0)  onclick =deleteByid("+ this.id+ ") >删除</a>"
					+ "</td>"
					+"</tr>");
		});
		}
		
	},"json ");
}
		
		
function selectByIDpageInfo(page){
	var id=$("#id").val();
	var page=page;
	var pageSize=8;
	var b=new Base64();
	var id=$("#id").val();
	$.post("OrderForm/selectByIDpageInfo.action",{id:id,page:page,pageSize:pageSize},function(data){
		if(data!=null){
		$("#table_tbody").empty();
		$.each(data,function(){
			$("#table_tbody").append("<tr>" 
					+ "<td>" +this.id +  "</td>" 
					+ "<td>" +this.erid +  "</td>" 
					+"<td>" +b.decode(this.name)+ "</td>"  
					+"<td>" +b.decode(this.username)+ "</td>" 
					+"<td>"+b.decode(this.eename)+"</td>"
					+"<td>"+b.decode(this.GRusername)+ "</td>" 
					+ "<td>"+test(this.starttime)+"</td>"
					+"<td>"+test(this.endtime)+"</td>"
					+"<td>"+test(this.payment)+"</td>"
					+"<td>"+test(this.allcost)+"</td>" 
					+"<td>"+this.status+ "</td>"
					+"<td><input type='checkbox' name='checkbox' value="+this.id+""+testFlag()+">"+"</td>"+"<td><a href=QueryManager.jsp?id="+this.erid+" >返回上一层</a>"+"</td>"+"<td><a href='queryOrderForm.jsp?id="+ this.id+ "'>查看详细信息</a>" 
					+ "<td><a href=javascript:void(0)  onclick =deleteByid("+ this.id+ ") >删除</a>"
					+ "</td>"
					+"</tr>");
		});
		}
		
	},"json ");
}
function testFlag(){
	if((a==1)?true:false){
		return "checked=";
	}else{
		return;
	}
}
function getChecked(){
	  var hasChk =($('#checkAll').is(':checked'));
	    if(hasChk==true){
      a=1;
       }else{
    	   a=0;
       }
	     
	      }
       	
//下拉的页数
function selectSum(pagenum) {
	$("[name=select]").empty();
	var i = 1;
	$("[name=sum]").html(pagenum);
	$("[name=page]").html(1);
	while (i <= pagenum) {
		$("[name=select]").append("<option >" + i + "</option>");
		i++;
	}
}
//下拉选择页数
function selectNumber() {
	page = $(this).children('option:selected').val();
	$("[name=page]").html(page);
	selectByIDpageInfo(page);
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
		selectByIDpageInfo(page);
		getChecked();
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
		page -= 1;
	//	$("[name=select]").append("<option selected>" + page1 + "</option>");
		selectByIDpageInfo(page);
		getChecked();
	}

}

function test(str){
	if(typeof(str)=="undefined"){
		return "";
	}else{
		return str;
	}
}








$(function() {
    $("#checkAll").click(function() {
         $('input[name="checkbox"]').attr("checked",this.checked);
        
     });
    
     var $checkbox1 = $("input[name='checkbox']");
     $checkbox1.click(function(){
         $("#checkAll").attr("checked",$checkbox1.length == $("input[name='checkbox']:checked").length ? true : false);
     });
});
function SendMoney(){
	 //jquery获取复选框值 

		var id1 =[]; 
		alert(id1);
        var username=$("input:checked").parents().next().next().next().html();
		 alert(username);
		$('input[name="checkbox"]:checked').each(function(){ 
		id1.push($(this).val()); 
		}); 
		
		
		
		//alert(chk_value.length==0 ?'你还没有选择任何内容！':chk_value); 
		if(id1.length==0){
			alert("你还没有选择任何内容");
			//window.location.href="employeruser.jsp";
			return false;
		}
		else{
			
			window.location.href="SendMoney.jsp?id="+id1;
			
		
		} 
}
function sendMoney(){
	 var pattern = new RegExp("[，]");   
  var flag=true;
  var page=$("#page").val();
  var id=$("#id").val();
 var money=$("#money").val();
 if(money==""||money==null){
	 if(pattern.test(money)){
		 flag="1";
	 }
	 $("#f2").html("金额不能为空！");
	 flag=false;
 }
 

 
 var endtime=$("#endtime").val();
 if(endtime==""||endtime==null){
	 $("#f1").html("时间不能为空");
	 flag=false;
 }
 
 if(flag){
	$.post("discount/InsertDisCount1.action",{money:money,id:id,endtime:endtime},function(data){
		if(data!=null){
			alert("发送成功");
			window.location.href="employeruser.jsp?page="+page;
		}
		
	},"json");}
}

function deleteByid(id){
	var ss = confirm("您确定要删除吗?");
	if (ss) {
		$.post("OrderForm/delete.action", {
			id : id
		}, function(data, status) {
			if (data != null && data != "") {
				alert("删除成功！");
				window.location.href = "employeruser.jsp";
			} else {
				alert("删除失败，请检查！");		}
		}, "json");
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
