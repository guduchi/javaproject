function updateGlocation(){

	var userInfo=$("#userInfo").serialize();
	var id=$("#id").val();

	var longitude=$("#longitude").val();
	var latitude=$("#latitude1").val();

	$.post("erlocation/update.action",{id:id,longitude:longitude,latitude:latitude},function(data){
		if(data!=null){
		
			alert("更新成功");
			window.location.href="Gposition.jsp";
			
		}
		else{
			alert("更新失败");
		}
		
		
	});
}