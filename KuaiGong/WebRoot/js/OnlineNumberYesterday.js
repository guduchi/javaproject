$(function(){
	OnlineNumberYesterday();
	click();
});
function click(){
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
}
function OnlineNumberYesterday(){
	   var username=$("#username").val();
		var page=1;
		var pageSize=20;
		var btu=$("#btu").val();
		var b = new  Base64();
	  var name=b.encode(username);

	var orderValue=$("#orderValue").val();
	//alert(orderValue);
	  $.post("onlineInformation/selectOnlineByYersday.action",{name:name,btu:btu},function(data){
		  if(data!=null){
			  var pageNum=data.length;
			
			  selectSum(Math.ceil(data.length/20));
		  }
	  },"json");
	   $.post("onlineInformation/selectOnlineByYersdayInfo.action",{name:name,btu:btu,page:page,pageSize:pageSize},function(data){
			$("#table_tbody").empty();
			$.each(data,function(){
				$("#table_tbody").append("<tr>" 
						+ "<td>" +this.id +  "</td>" 
						+ "<td>"+b.decode(this.username)+ "</td>"
						+ "<td>"+b.decode(this.name)+"</td>"
						+"<td>"+this.startime+ "</td>"
						+"<td>"+test(this.endtime)+ "</td>"
						+ "<td>"+this.status+ "</td>"
						+ "<td>"+formatSeconds(this.ontime)+ "</td>"
						+"</tr>");
			});
		},"json");
	}
function selectOnlineByYersdayInfo(){
	var username=$("#username").val();
	var page=1;
	var pageSize=20;
	var btu=$("#btu").val();
	var b = new  Base64();
  var name=b.encode(username);
  $.post("onlineInformation/selectOnlineByYersdayInfo.action",{name:name,btu:btu,page:page,pageSize:pageSize},function(data){
		$("#table_tbody").empty();
		$.each(data,function(){
			$("#table_tbody").append("<tr>" 
					+ "<td>" +this.id +  "</td>" 
					+ "<td>"+b.decode(this.username)+ "</td>"
					+ "<td>"+b.decode(this.name)+"</td>"
					+"<td>"+this.startime+ "</td>"
					+"<td>"+test(this.endtime)+ "</td>"
					+ "<td>"+this.status+ "</td>"
					+ "<td>"+formatSeconds(this.ontime)+ "</td>"
					+"</tr>");
		});
	},"json");
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
// 下拉选择页数
function selectNumber() {
	page = $(this).children('option:selected').val();
	$("[name=page]").html(page);
	selectOnlineByYersdayInfo(page);
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
 //      var hasChk =($('#checkAll').is(':checked'));
		selectOnlineByYersdayInfo(page);
		
	
		
//		if(hasChk){
//		
//			selectAll();
//}
		
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
//var hasChk =($('#checkAll').is(':checked'));
		
		selectOnlineByYersdayInfo(page);
		
//	if(hasChk){
//	
//			selectAll();
//}
	}

}
function test(str){

	if(typeof(str)=="undefined"){ 

		return "";

		}else{
			return str;
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
