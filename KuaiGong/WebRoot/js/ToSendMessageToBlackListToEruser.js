function QueryCount(){
	var Count=$("#Count").val();
	$.post("",{Count:Count},function(data){
		if(data != null){
			alert("发送成功!");
		}else{
			alert("发送失败!");
		}
	},"json");
	
}