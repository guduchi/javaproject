function addScale1(){
	var id=$("#id").val();
	var erid=$("#erid").val();
	
	var credits=$("#credits").val();
	var presentintegral=$("#presentintegral").val();

	$.post("employeeScale/add.action",{id:id,erid:erid,credits:credits,presentintegral:presentintegral},function(data){
		if(data!=null){
			alert("添加成功");
			window.location.href="employer_scale.jsp";
		}
	},"json");

}