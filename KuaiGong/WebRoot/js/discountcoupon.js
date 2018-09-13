function updataCoupon() {
	var page=$("#page").val();
	var userInfo = $("#userInfo").serialize();
	var id = $.trim($("#id").val());
	var username=$.trim($("#username").val());
	var name=$.trim($("#name").val());
	var money = $.trim($("#money").val());
	var balance=$("#balance").val();
	var erid=$("#erid").val();
	var endtime=$("#endtime").val();
	var status=$("#status").val();
	var flag = true;
	 
	if (money == "" || money == null) {
		$("#f2").html("金额不能为0！");
		flag = false;
	} else {
		$("#f2").html("");
	}
	if (flag == true) {
	
		$.post("discount/updateByPrimaryKey.action", {page:page,id:id,username:username,name:name,money:money,balance:balance,erid:erid,endtime:endtime,status:status}, function(
				data) {
			if (data != null) {
				alert("修改成功！");
				window.location.href="discountcoupon.jsp?page="+page;
			}
		}, "json");
	}
}