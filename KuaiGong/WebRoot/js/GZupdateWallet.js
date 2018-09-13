function GZupdateWallet(){
	var page=$("#page").val();
	var id=$("#id").val();
	var username=$("#username").val();
	var name=$("#name").val();
	var balance=$("#balance").val();
	var flag=true;
	if(balance==null || balance==""){
		$("#str").html("请输入金额");
		return false;
	}else{
		$("#str").html("");
	}
	
	if(flag){
	$.post("wallet1/updateWallet.action",{id:id,balance:balance},function(data){
		if(data!=null){
			alert("更新成功！");
			window.location.href="EmployerUserWallet.jsp?page="+page;
		}
		else{
			alert("更新失败！");
		}
	},"json");
}
}