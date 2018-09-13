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
<script type="text/javascript" src="js/text.js"></script>
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
function wallet(){
var id=$("#id").val();

	var starttime=$("#starttime").val()+" "+"00:00:00";
	var endtime=$("#endtime").val()+" "+"23:59:59";
	
	var b =new  Base64();
	$.post("eeuser/querysouru1.action",{starttime:starttime,endtime:endtime},function(data){
		if(data!=null){
		window.location.href="querysouru.jsp?id="+id;
		
		}
	},"json");
}
$(function(){
	click();
});

function click(){
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}

function queryUserPageMoney(page){
      var id=$("#id").val();
      var btu="提现";
	var page = page;
	var pageSize = 8;
	var b = new Base64();
	//获取数量
	$.post("eeuser/queryUserPageMoney1.action",{page:page,pageSize:pageSize,id:id,btu:btu},
		function(data) {
				if (data != null) {
				
					selectSum(Math.ceil(data/8));
				}
		},"json");		
				
	$.post("eeuser/queryUserInfoMoney.action",{page:page,pageSize:pageSize,id:id,btu:btu},
			function(data) {
			if(data!=null){
					$("#table_tbody").empty();
					$.each(data, function() {
						$("#table_tbody").append("<tr>"
							+ "<td>" + this.id+ "</td>"
								+ "<td>" + b.decode(this.username)+ "</td>" 
								+ "<td>" + b.decode(this.name) + "</td>" 
								+"<td>" + this.balance+ "</td>"
								+"<td>" + this.residue+ "</td>" 
								+"<td>" + test(this.cash)+ "</td>" 
								+"<td>" + test(this.totalMoney)+ "</td>" 
								+"<td>" + test(this.time)+ "</td>" 
								+"<td><a href='queryMoney.jsp?id="+this.id+"'>返回上一层</a>"+"</td>"
								+"</tr>");
							});
				}
			}, "json");
}
function queryUserInfoMoney(page){
      var id=$("#id").val();
      var btu="提现";
	var page = page;
	var pageSize = 8;
	var b =new Base64();
	$.post("eeuser/queryUserInfoMoney.action",{page:page,pageSize:pageSize,id:id,btu:btu},
			function(data) {
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data, function() {
				$("#table_tbody").append("<tr>"
						+ "<td>" + this.id+ "</td>"
								+ "<td>" + b.decode(this.username)+ "</td>" 
								+ "<td>" + b.decode(this.name) + "</td>" 
								+"<td>" + this.balance+ "</td>"
								+"<td>" + this.residue+ "</td>" 
								+"<td>" + test(this.cash)+ "</td>" 
								+"<td>" + test(this.totalMoney)+ "</td>" 
								+"<td>" + test(this.time)+ "</td>" 
			        	+"<td><a href='queryMoney.jsp?id="+this.id+"'>返回上一层</a>"+"</td>"
						+"</tr>");
					});
		}
	}, "json");
}

// 下拉的页数
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
// 下拉选择页数
function selectNumber() {
	page = $(this).children('option:selected').val();
	$("[name=page]").html(page);
	queryUserInfoMoney(page);
}
// 下一页
function nextPage() {
	var page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	if (parseInt(page) >= parseInt(sum)) {
		alert("已经是最后一页了！");
	} else {
		var page1 = parseInt(page) + 1;
		$("[name=page]").html(page1);
		page = parseInt(page) + 1;
		queryUserInfoMoney(page);
		$("[name=select]").append("<option selected>" + page1 + "</option>");
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
		$("[name=select]").append("<option selected>" + page1 + "</option>");
		queryUserInfoMoney(page);
	}

}
function test(str) {
	if(typeof(str)=="undefined"){ 

		return "";

		}else{
			return str;
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

</script>
</head>

<%
String id=request.getParameter("id");
 %>
<body  onload="queryUserPageMoney(1)">
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="employeeuser.jsp">工人列表</a></li>
    <li>最后一次提现时间</li>
    <li>详细提现记录</li>
    <input type="hidden" id="id" value="<%=id %>"/>
    </ul>
    </div>
    
<div class="rightinfo">
    <ul class="toolbar">
     <li> 开始日期：<input type="date" id="starttime" size="10" /></li> <li> 结束日期：<input type="date" id="endtime" size="10"/></li>
   <li><button onclick="wallet()">查看钱包</button></li>
    </ul>

    <table class="imgtable">

    <thead>
    <tr>
    <th width="100px;">编号</th>
    <th>工人电话</th>
    <th>工人姓名</th>
    <th>余额</th>
    <th>可提现余额</th>
    <th>金额</th>
     <th>总金额</th>
    <th>提现时间</th>
    <th>操作</th>
    </tr>
    </thead>
<tbody id="table_tbody">
</tbody>
	</table>
     <div class="pagin">
    
			<div style="font-size: 13px">
				共<i class="blue" name="sum">1256</i>页，当前显示第&nbsp;<i name="page" class="blue">2&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem"><a name="last" href="javascript:;"><span
						class="pagepre"></span>
				</a>
				</li>
				<li class="paginItem">
				
				<select style="height: 30px;width: 50px" name="select">
					<option>1</option>
					<option>1</option>
					<option>1</option>
					<option>1</option>
				</select>
				</li>
				<li class="paginItem"><a name="next" href="javascript:;"><span
						class="pagenxt"></span>
			</a>
				</li>
			</ul>
		</div>
		</div>
				 
    <div class="message">
				</div>
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>


<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>

</html>
