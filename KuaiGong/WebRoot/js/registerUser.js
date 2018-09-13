$(function(){
register1();
});
function register1(){
	$("[name=login]").bind("click",registerr);
}
function registerr(){
 var b=new Base64();
	var username=$("#username").val();
	var usernamepash=b.encode(username);
	var password=$("#password").val();
	var passwordpash=b.encode(password);
	var requestData=usernamepash+"&&"+passwordpash;
	var flag=true;
	if(usernamepash==""|| usernamepash==null){
		alert("请输入用户名");
		flag=false;
	}else if(usernamepash.length<=5){
		
		alert("用户名长度不可以小于5");
		flag=false;
	}
	
	
	
	if(passwordpash==""||passwordpash==null){
		alert("请输入密码");
		flag=false;
		}else if(passwordpash.length<=5){
		alert("密码长度不可以小于5");
		flag=false;
	}if(flag){
	$.post("user/register.action",{requestData:requestData},function(data,status){
		if(data!=null){
			alert("添加成功");
			window.location.href="revise1.jsp";
		}
		else{
			alert("添加失败");
		}
	},"json");
}
}