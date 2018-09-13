function addSuperUser(){
	var username=$("#username").val();
	var password=$("#password").val();
	var flag=true;
	if(username=="" || username=="null" || username.length>8 || username.length<5){
		$("#f1").html("用户名(5-8)位");
		return false;
	}
	else{
		$("#f1").html("");
	}
	if(password=="" || password=="null" || password.length>8 || password.length<5){
		$("#f2").html("密码(5-8)位");
		return false;
	}else{
		$("#f2").html("");
	}
	var b=new Base64();
	var usernamePash=b.encode(username);
	var passwordPash=b.encode(password);
	$.post("superUser/addSuperUser.action",{usernamePash:usernamePash,passwordPash:passwordPash},function(data){
		if(data=="1"){
			alert("添加成功");
			window.location.href="updeSuperUser.jsp";
		    
			
			}else{
				 $("#f1").html(data);
					return false;
		}
	},"json");
}