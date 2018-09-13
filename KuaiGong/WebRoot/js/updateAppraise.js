
function updateAppraise(){
	var userInfo=$("#userInfo").serialize();
	var id=$("#id").val();
	var eeid=$("#eeid").val();
	var erid=$("#erid").val();
	var starlevel=$("#starlevel").val();
$.post("app/updateByPrimaryKey.action",userInfo,function(data,status){
	if(data!=null){
		
		alert("修改成功");
		window.location.href="employeruser.jsp";
	}
	else{
		alert("修改失败");
	}
},"json");
}

function deleteByid(id){
	
	var ss=confirm("你确定要删除吗？");
	if(ss){
		$.post("app/delete.action",{id:id},function(data,status){
		if(data!=null && data!=""){
			alert("删除成功!");
			window.location.href="employeruser.jsp";
			
		}	
		else{
			alert("删除失败!");
		}
		
		});
		
	}
			
			
		}
		
	

