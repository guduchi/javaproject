function querywithdrawdepositPageShouYi(){
	var b=new Base64();
	var queryUserName=$("#queryUserName").val();
	var queryusername=b.encode(queryUserName);
	$.post("withdraw/querywithdrawdepositPageShouYi.action",{queryusername:queryusername},function(data){
		if(data!=null){
			console.log(data);
			$("#fontCount").html("总共收益为:"+data);
		}
		
	},"json");
}
