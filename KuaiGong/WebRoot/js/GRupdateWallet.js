function GRupdateWallet(){
	var page=$("#page1").val();

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
//	var residue=$("#residue").val();
//	if(residue==null || residue=="" ){
//		$("#str1").html("请输入金额");
//		return false;
//	}else{
//		$("#str1").html("");
//	}
	if(flag){
	$.post("wallet/updateWallet.action",{id:id,balance:balance},function(data){
		if(data!=null){
			alert("更新成功！");
			window.location.href="wallet.jsp?page="+page;
		}
		else{
			alert("更新失败！");
		}
	},"json");
}
}