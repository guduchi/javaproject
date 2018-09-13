function ChongZhi(){
	var flag=true;
	var id=$("#id").val();
	var query=$("#query").val();
	if(query==""||query==null){
	$("#f2").html("请输入金额！");
   return false;
	}else{
	$("#f2").html("");
	}
	if(flag=true){
	$.post("wallet/chongzhi.action",{id:id,query:query},function(data){
		if(data!=null){
	      alert("充值成功");
			window.location.href="discountcoupon.jsp";
				
			}
			else{
				alert("更新失败");
			}
			
		},"json");
	}
}