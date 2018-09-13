function sendSmS(){

var erid=$("#id").val();

var content=$("#content").val();
alert(content);
$.post("euser/sendSMS.action",{erid:erid,content:content},function(data){
	if(data!=null){
		alert("发送成功！");
	}else{
		alert("发送失败！");
	}
	
},"json");
}

function Jpush(){
  alert("");
	var erid=$("#id").val();
     alert(erid);
	var content=$("#content").val();
	alert(content);
	$.post("euser/Jpush.action",{erid:erid,content:content},function(data){
		if(data!=null){
			alert("发送成功！");
		}else{
			alert("发送失败！");
		}
		
	},"json");
	}