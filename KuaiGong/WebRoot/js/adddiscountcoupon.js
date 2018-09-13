function add() {
	var money = $("#money").val().toString();
	var bol = true;
	$.post("discount/add.action", null, function(data, status) {
		$.each(data, function(i, data) {
			var money = data.money.toString();
			if (kname == name) {
				bol = false;
			}
		});
		
		if (name != null && name != "" && bol) {

			// 获取限制条件的form表单
			var searchFrom = $("#addKindForm").serialize();
			$.post("discount/add.action", searchFrom, function(data, status) {
				if (data != null && data != "") {
					alert("添加成功！");
					window.location.href = "discountCoupon/adddiscountCoupon.jsp";
				} else {
					alert("添加失败，请检查！");
				}
			}, "json");

		} else {
			alert("请不要添加重复的数据！");
		}
	}, "json");
}

function pd(name) {
	
	
}