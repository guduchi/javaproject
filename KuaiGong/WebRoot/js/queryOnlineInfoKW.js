$(function() {
	clickKW();
	queryPage();
});

function clickKW(){
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
	$("#total").bind("click", selectTotal);
	$("#year").bind("click", selectYear);
	$("#month").bind("click", selectMonth);
	$("#week").bind("click", selectWeek);
	$("#yesterday").bind("click", selectYesterday);
	$("#today").bind("click", selectToday);
	$("#selectWorker").bind("click",selectWorker);
	$("[name=sort]").bind("click",sortWorker);
	$("#selectPage").bind("click",skip);
}
var time = "total";
var page = 1;
var pageSize = 22;
var pageNum = 0;
var username = "null";
var sort = "null";
var starttime = "null";
var endtime = "null";
function selectTotal(){
	time = "total";
	page = 1;
	username = $("[name=username]").val();
	var b = new Base64();
	if(username != null && username !=""){
		username = b.encode(username);
	}else{
		username = "null";
	}
	queryOnlineByTime();
}

function selectYear(){
	time = "year";
	page = 1;
	var b = new Base64();
	username = $("[name=username]").val();
	if(username != null && username !=""){
		username = b.encode(username);
	}else{
		username = "null";
	}
	queryOnlineByTime();
}

function selectMonth(){
	time = "month";
	page = 1;
	var b = new Base64();
	username = $("[name=username]").val();
	if(username != null && username !=""){
		username = b.encode(username);
	}else{
		username = "null";
	}
	queryOnlineByTime();
}

function selectWeek(){
	time = "week";
	page = 1;
	var b = new Base64();
	username = $("[name=username]").val();
	if(username != null && username !=""){
		username = b.encode(username);
	}else{
		username = "null";
	}
	queryOnlineByTime();
}

function selectYesterday(){
	time = "yesterday";
	page = 1;
	var b = new Base64();
	username = $("[name=username]").val();
	if(username != null && username !=""){
		username = b.encode(username);
	}else{
		username = "null";
	}
	queryOnlineByTime();
}
//今天
function selectToday(){
	time = "today";
	page = 1;
	var b = new Base64();
	username = $("[name=username]").val();
	if(username != null && username !=""){
		username = b.encode(username);
	}else{
		username = "null";
	}
	queryOnlineByTime();
}

function selectWorker(){
//
//	starttime = $("#starttime").val();
//	endtime = $("#endtime").val();
//
//	endtime = getNewDay(endtime,1);
	if(starttime!=null && starttime !=""){
		time = "timeSlot";	
	}
	username = $("[name=username]").val();
	if(username != null && username !=""){
		var b = new Base64();
		page = 1;
		username = b.encode(username);
		queryPage();
	}else{
		page = 1;
		username = "null";
		queryPage();
	}
}

//日期加上天数得到新的日期  
//dateTemp 需要参加计算的日期，days要添加的天数，返回新的日期，日期格式：YYYY-MM-DD  
//function getNewDay(dateTemp, days) {  
//  var dateTemp = dateTemp.split("-");  
//  var nDate = new Date(dateTemp[1] + '-' + dateTemp[2] + '-' + dateTemp[0]); //转换为MM-DD-YYYY格式    
//  var millSeconds = Math.abs(nDate) + (days * 24 * 60 * 60 * 1000);  
//  var rDate = new Date(millSeconds);  
//  var year = rDate.getFullYear();  
//  var month = rDate.getMonth() + 1;  
//  if (month < 10) month = "0" + month;  
//  var date = rDate.getDate();  
//  if (date < 10) date = "0" + date;  
//  return (year + "-" + month + "-" + date);  
//}  


function sortWorker(){
	var str = $("[name=sort]:checked").val();
	if(str == "work"){
		sort = "work";
	}else{
		sort = "null";
	}
}

function queryOnlineByTime(){
	var b = new Base64();
	$.post("onlineInformation/queryOnlineInfoByTime.action",{time:time,page:page,pageSize:pageSize,name:username,sort:sort,start:starttime,end:endtime},function(data){

		$("#table_tbody").empty();
		
		$.each(data,function(){
			$("#table_tbody").append("<tr>" + "<td>" +this.id +  "</td>" + "<td>"+b.decode(this.username)+ "</td>" + "<td>"
					+b.decode(this.name)+"</td>"+"<td>"+this.time+ "</td>"+"<td>"+this.worktime+ "</td>"+ "<td>"+this.status+ "</td>"+ "<td><a style=\"color:blue;\" href=\"onlineDetailKW.jsp?eeid="+this.id+"\">详细信息</a></td>"+"</tr>");
		});
	},"json");
}

function queryPage(){
	$.post("onlineInformation/queryOnlineInfoPage.action",{name:username},function(data){
		if (data != null) {
			selectSum(Math.ceil(data/pageSize));
		}
	},"json");
	queryOnlineByTime();
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
	queryOnlineByTime(page);
}
//下一页
function nextPage() {
	page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	if (parseInt(page) >= parseInt(sum)) {
		alert("已经是最后一页了！");
	}else {
		var page1=parseInt(page)+1;
		$("[name=select]").val(page1);
		$("[name=page]").html(page1);
		page= page1;
		queryOnlineByTime();
	}

}
function lastPage() {
	page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	if (page < 2) {
		alert("已经是第一页了！");
	} else {
		var page1 = page - 1;
		$("[name=page]").html(page1);
		$("[name=select]").val(page1);
		page-=1;
//		$("[name=select]").append("<option selected>" + page1 + "</option>");
		queryOnlineByTime();
	}
	
}

function skip(){
	var skipPage = $("#querypage").val();
	var sum = $("[name=sum]").html();
	console.log(skipPage);
	if(isNumber(skipPage)){
		if(skipPage>sum||skipPage<1){
			alert("没有该页数");
		}else{
			page = skipPage;
			$("[name=page]").html(skipPage);
			$("[name=select]").val(skipPage);
			queryOnlineByTime();
		}
	}else{
		alert("非法输入！");
	}
}
//判断是否为数字
function isNumber(value) {
    var patrn = /^[0-9]*$/;
    if (patrn.exec(value) == null || value == "") {
        return false
    } else {
        return true
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


