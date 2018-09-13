$(function() {
	click();
	queryUserPage();
});

function click() {
	$("[name=queryByid]").bind("change",queryPage);
	$("[name=login2]").bind("click", login);
	$("[name=registers]").bind("click", register);
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
	$("[name=ToSendMessageToBlackListToEruser]").bind("click", ToSendMessageToBlackListToEruser);
}

function ToSendMessageToBlackListToEruser(){
	window.location.href="ToSendMessageToBlackListToEruser.jsp";
}     		

function changeImg() { 
	var imgSrc = $("#imgObj");  

	var src = imgSrc.attr("src");  

	imgSrc.attr("src", chgUrl(src)); 

}
//时间戳     
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳     
function chgUrl(url) {  
	var timestamp = (new Date()).valueOf();  
	url = url.substring(0, 20);  

	if ((url.indexOf("&") >= 0)) {  
		url = url + "×tamp=" + timestamp;  
	} else {  
		url = url + "?timestamp=" + timestamp;  
	}  
	return url;  
}  
function register() {
	var address = "register.jsp";
	window.location.href = address;
}
function registerKKG() {
	var username = $("#username").val();
	var password = $("#password").val();
	$.post("euser/register1.action", {
		username : username,
		password : password
	}, function(data) {
		if (data != null) {
			alert("添加成功！");
		}
	}, "json");
}

function login() {
	
	
	if ($('[name=username]').val().length == 0) {
		alert('请填写姓名');
		return false;
	}
	if ($('[name=password]').val().length == 0) {
		alert('请填写密码');
		return false;
	}
	var index_code=$("#index_code").val();
	if(index_code=="" || index_code=="null"){
		alert('验证码不能为空');
		return false;
	}
	var username = $("#username").val();	
	var password = $("#password").val();
	var position1 = $("#position").val();
	var b=new Base64();
	var usernamepash=b.encode(username);
	var passwordpash=b.encode(password);

	if(position1=="管理员"){


		$.post("user/login.action",{usernamepash:usernamepash,passwordpash:passwordpash,index_code:index_code},function(data, status) {
			if (data =="2") {
				alert("验证码不符合！");
				changeImg();
			}else if(data=="1"){
				window.location.href="main.jsp";
			}else{
				alert("你输入的用户名与密码不匹配！");
				changeImg();
			}
		}, "json");
	}
	else{
		$.post("superUser/superLogin.action",{usernamepash:usernamepash,passwordpash:passwordpash,index_code:index_code},function(data, status) {
			if (data =="2") {
				alert("验证码不符合！");
				changeImg();
			}else if(data=="6"){
				window.location.href="main1.jsp";
			}else{
				alert("你输入的用户名与密码不匹配！");
				changeImg();
			}
		}, "json");
	}
}




var a=""; 
var p="";
var checkAllState="";
var b=0,c=0;
var arr=[];//取消选中数组
var arrIn=[];//被选中数组
var AllID=[];//储存全选状态下 被选中的全部ID
var DataArr;
var AllID2=[];//储存未全选状态下 被选中的全部ID
var arrLast=[];//未全选状态下
var arrLast2=[];//全选状态下
var EndArr=[];//最终全部ID值
function queryUserPage(){
	var page=$("#page").val();
	
	if(page=="null" || page==""){
		page=1;
	}else{
		page=page;
		
	}
	var pageSize = 22;
	var b = new Base64();
	var erid = $("#erid").val();
	var name = $("#name").val();
	var btu=$("#btu").val();
	var  btu=b.encode(btu);
	var username = $("#username").val();
	var name=b.encode(name);
	var username=b.encode(username);

	getChecked();
	if(checkAllState!=1){
$.post("euser/selectByAll.action",{page:page,pageSize:pageSize,un:name,us:username,erid:erid,btu:btu},
		function(data) {
	if (data != null) {
	    var pageAll=data.length;
	    selectSum(Math.ceil(pageAll/22),page);
	    
	    /****获取到全部ID*****/
		console.log(data);
		DataArr=data;
		for(var z=0 in DataArr){
			AllID.push(DataArr[z].id);
		}
//		AllI=AllID;
//		console.log(AllID);
		/***end****/

		
	}
}, "json");
	}else{
        alert('嘿！在全选过的状态下不可以进行查询哦！再点一点全选试试 ~');
		return false;
	}
	$.post("euser/count.action",{un:name,us:username,erid:erid,btu:btu},function(data){
		if(data!=null){
			$("#count").html(data);
		}
	},"json");
	$.post("euser/selectByAllPage.action",{page:page,pageSize:pageSize,un:name,us:username,erid:erid,btu:btu},
			function(data) {
		if (data != null) {
		
			$("#table_tbody").empty();
			$.each(data,function() {
				$("#table_tbody").append("<tr>"
						+ "<td><input type='checkbox' id='checkbox'   name='checkbox' value="+this.id+','+page+" "+testFlag()+"/>" + "</td>"
						+  "<td>"+ this.id+ "</td>"
						+ "<td>"+b.decode(this.username)+ "</td>"
						+ "<td>"+b.decode(this.name)+ "</td>"
						+ "<td>"+b.decode(this.status)+ "</td>"
						+ "<td>"+b.decode(this.companyname)+ "</td>"
						+ "<td>"+b.decode(this.grade)+ "</td>"
						+ "<td>"+test(this.time)+ "</td>"
					//	+ "<td>"+this.regid+ "</td>"
						+ "<td>"
						+ "<select id='btu"+this.id+"'  onchange='btuu(\""+page+"\","+ this.id+",\""+b.decode (this.username)+"\",\""+b.decode (this.name)+"\",\""+ b.decode(this.status)+"\",\""+b.decode (this.companyname)+"\",\""+b.decode (this.grade)+"\")'>"
						+ "<option value='请选择'>请选择</option>"
						+ "<option  value='修改基本信息'>修改基本信息</option>"
						+ "<option  value='查看详细信息'>查看详细信息</option>"
						+ "<option  value='查看优惠券'>查看优惠券</option>"
						+ "<option  value='查看积分'>查看积分</option>"
						+ "<option value='查看充值记录'>查看充值记录</option>"
						+ "<option  value='查看评价记录'>查看评价记录</option>"
						+ "<option  value='查看钱包'>查看钱包</option>"
						+ "<option  value='招工统计'>招工统计</option>"
						+ "<option  value='充值'>充值</option>"
						+ "<option  value='修改密码'>修改密码</option>"
						+ "<option  value='禁用'>禁用</option>"
						+ "<select/>"
						+ "</td>"
						+"<input type='hidden' id='oldpage' value="+page+">"+
						+"<input type='hidden' id='regid' value="+this.regid+">"+
						+ "</tr>");
			});
		}
	}, "json");
}

/*
 * 
 * 判断-全选框状态
 * 
 * 目的 ：是否选中当前页checked
 * 
 * */
	
function testFlag(){
	//根据全选框状态-判断每里-多选框的状态
	if((a==1)?true:false){
		return 'checked=';
		
	}else{
		//根据多选框状态-判断每里-多选框的状态
		if(p==1?true:false){
			if(checkAllState==1){//全选框-被选中后
				for(var i=0 in arr){
					var tval=arr[i].split(',');
					var pageNow=$('i[class=\'blue\']').html();
					if(pageNow==tval[1]){
						$('input[value=\"'+arr[i]+'\"]').removeAttr('checked');

		//			console.log(arr[i]);
					}
				}
				
//				console.log(AllID);
				return 'checked=';
			}else{//全选框-未被选中后
				for(var j=0 in arrIn){
					var tval=arrIn[j].split(',');
					var pageNow=$('i[class=\'blue\']').html();
					if(pageNow==tval[1]){
						$('input[value=\"'+arrIn[j]+'\"]').attr('checked',true);

				//	console.log(arrIn[j]);
					}
				}
				

			}
				
//			return 'checked=';
		}else{
			return ;
		}
		
	}
	
	
}



function selectByAllPage(page){
	var page=page;

	var pageSize = 22;
	var b = new Base64();
	var erid = $("#erid").val();
	var name = $("#name").val();
	var username = $("#username").val();
	var btu=$("#btu").val();
	var  btu=b.encode(btu);
	var name=b.encode(name);
	var username=b.encode(username);
	$.post("euser/selectByAllPage.action",{page:page,pageSize:pageSize,un:name,us:username,erid:erid,btu:btu},
			function(data) {
		if (data != null) {
			$("#table_tbody").empty();
			$.each(data,function() {
				$("#table_tbody").append("<tr>"
						+ "<td><input type='checkbox' name='checkbox' id='checkbox' value="+ this.id+','+page+" "+testFlag()+"/>"+ "</td>"
						+  "<td>"+ this.id+ "</td>"
						+ "<td>"+b.decode(this.username)+ "</td>"
						+ "<td>"+b.decode(this.name)+ "</td>"
						+ "<td>"+b.decode(this.status)+ "</td>"
						+ "<td>"+b.decode(this.companyname)+ "</td>"
						+ "<td>"+b.decode(this.grade)+ "</td>"
						+ "<td>"+test(this.time)+ "</td>"
					//	+ "<td>"+this.regid+ "</td>"
						+ "<td>"
						+ "<select id='btu"+this.id+"'  onchange='btuu(\""+page+"\","+ this.id+",\""+b.decode (this.username)+"\",\""+b.decode (this.name)+"\",\""+ b.decode(this.status)+"\",\""+b.decode (this.companyname)+"\",\""+b.decode (this.grade)+"\")'>"
						+ "<option value='1'>请选择</option>"
						+ "<option  value='修改基本信息'>修改基本信息</option>"
						+ "<option  value='查看详细信息'>查看详细信息</option>"
						+ "<option  value='查看优惠券'>查看优惠券</option>"
						+ "<option  value='查看积分'>查看积分</option>"
						+ "<option value='查看充值记录'>查看充值记录</option>"
						+ "<option  value='查看评价记录'>查看评价记录</option>"
						+ "<option  value='查看钱包'>查看钱包</option>"
						+ "<option  value='招工统计'>招工统计</option>"
						+ "<option  value='充值'>充值</option>"
						+ "<option  value='修改密码'>修改密码</option>"
						+ "<option  value='禁用'>禁用</option>"
						+ "<select/>"
						+ "</td>"
						+"<input type='hidden' id='oldpage' value="+page+">"+
						+"<input type='hidden' id='regid' value="+this.regid+">"+
						+ "</tr>");
			});
		}
	}, "json");
}
//下拉的页数
function selectSum(pageAll,page) {
	$("[name=select]").empty();
	var i = 1;
	$("[name=sum]").html(pageAll);
	$("[name=page]").html(page);
	while (i <= pageAll) {
		$("[name=select]").append("<option >" + i + "</option>");
		i++;
	}
}
//下拉选择页数
function selectNumber() {
	page = $(this).children('option:selected').val();
	$("[name=page]").html(page);
	selectByAllPage(page);
}
//下一页
function nextPage() {
	var page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	if (parseInt(page) >= parseInt(sum)) {
		alert("已经是最后一页了！");
	} else {
		var page1 = parseInt(page) + 1;
		$("[name=page]").html(page1);
		page = parseInt(page) + 1;
		selectByAllPage(page);
		 getChecked();
		// $("[name=select]").appendChild("<option selected>" + page + "</option>");
	}

}
//上一页
function lastPage() {
	page = $("[name=page]").html();
	if (page < 2) {
		alert("已经是第一页了！");
	} else {
		var page1 = page - 1;
		$("[name=page]").html(page1);
		page -= 1;
		// $("[name=select]").append("<option selected>" + page1 + "</option>");
		selectByAllPage(page);
		 getChecked();
	}

}
//跳转指定页面
function queryPage(){
	var querypage=$("#querypage").val();
	var sum = $("[name=sum]").html();

	if(querypage<=0){
		alert("没有找到页数");
	}
	else if(querypage > parseInt(sum) ){
		alert("没有找到页数");
	}
	else{
		var page=querypage;
		$("[name=page]").html(page);
		selectByAllPage(page);
	}
}


/*
 * 方法
 * 
 * 多选框被选中状态
 * 选中     - a=1
 * 未选中 - a=0
 * 
 * */
function getChecked(){
	  var hasChk =($('#checkAll').is(':checked'));
	    if(hasChk==true){
	    	a=1;
        }else{
        	a=0;
        }
	    p=b;
//	    if(checkAllState==1){//全选框-被选中后
//	    	for(var i2=0 in arrLast2){
//				var tval2=arrLast2[i2].split(',');
//				var pageNow2=$('i[class=\'blue\']').html();
//				if(pageNow2==tval2[1]){
//					$('input[value=\"'+arrLast2[i2]+'\"]').removeProp('checked');
//
//	//			console.log(arr[i]);
//				}
//			}
//	    }else{
//	    	for(var j2=0 in arrLast){
//				var tval2=arrLast[j2].split(',');
//				var pageNow2=$('i[class=\'blue\']').html();
//				if(pageNow2==tval2[1]){
//					$('input[value=\"'+arrLast2[j2]+'\"]').prop('checked',true);
//
//			//	console.log(arrIn[j]);
//				}
//			}
//	    }
}
         	
     
function btuu(page,id,username,name,status,companyname,grade,time) {
	var page=page;
	var b =Base64();
	var name=name;
	var username=username;
	var status=status;
	var companyname=companyname;
	var grade=grade;
	var time=time;
	var id = id;
	var btu = $("#btu"+id).val();
	if (btu == "查看详细信息") {
		window.location.href = "QueryManagerr.jsp?id=" + id+"&&page="+page;
	} else if (btu == "查看每个信息") {
		window.location.href = "QueryManager.jsp?id=" + id+"&&page="+page;
	} else if (btu == "查看充值记录") {
		window.location.href = "recharge.jsp?id=" + id+"&&page="+page;
	} else if (btu == "查看评价记录") {
		window.location.href = "Appraisee.jsp?id=" + id+"&&page="+page;
	}else if(btu == "查看优惠券"){
		window.location.href = "coupon.jsp?id=" + id+"&&page="+page;
	}else if(btu == "查看积分"){
	
	    window.location.href = "Scale.jsp?id=" + id+"&&page="+page;
	}else if(btu == "查看钱包"){
		window.location.href = "EmployerUserWalletByID.jsp?id=" + id+"&&page="+page;
		}
	else if (btu == "招工统计") {
		window.location.href = "selectCount.jsp?id=" + id+"&&page="+page;
	}	else if(btu=="修改密码"){
		window.location.href="user/updataErUserPWD.jsp?id="+id+"&&page="+page;
	}		else if(btu=="充值"){
		window.location.href="CunKuan.jsp?id=" + id+"&&page="+page;
	}
	
	else if(btu=="禁用"){
	
	$.post("Blacklist/BlacklistToinsert.action",{id:id,name:name,username:username},function(data){
			if(data =="1"){
				alert("禁用成功!");
				window.location.href="employeruser.jsp";
			} else if(data =="2"){
				alert("黑名单已存在!");
			}else{
				alert("禁用失败!");
			}
		},"json");
	}	
	
	
	
	else if(btu=="修改基本信息"){
		window.location.href="user/updataUser.jsp?id="+id
		+ "&&username="
		+username
		+ "&&name="
		+name
		+ "&&status="
		+status
		+ "&&companyname="
		+companyname
		+ "&&grade="
		+	grade;
	}		else if(btu=="删除"){
		var ss = confirm("您确定要删除吗?");
		if (ss) {
			$.post("euser/delete.action", {
				id : id
			}, function(data, status) {
				if (data != null && data != "") {
					alert("删除成功！");
					window.location.href = "employeruser.jsp?page="+page;
				} else {
					alert("删除失败，请检查！");
				}
			}, "json");
		}
	}
}

function test(str){

	if(typeof(str)=="undefined"){ 

		return "";

	}else{
		return str;
	}
}

function ZGcount(id) {
	$.post("OrderForm/queryCount.action", {id : id
	}, function(data) {
		if (data != null) {
			window.location.href = "selectCount.jsp?id=" + id;
		}
	}, "json");
}


$(function() {
	
	/*点击全选按钮*/
	$("#checkAll").click(function() {
		$('input[name="checkbox"]').attr("checked", this.checked);
//		 page.push(this.checked);
		if($(this).attr("checked")){
			$(this).attr('checked', 'true');
			checkAllState=1;
			arr=[];
			AllID=[];
			arrLast2=[];
				    /****获取到全部ID*****/
					for(var z=0 in DataArr){
						AllID.push(DataArr[z].id);
					}
					/***end****/
//			console.log('全部选中ID：'+AllID);//1111111111111
			EndArr=AllID;
			console.log('end：'+EndArr);
			//console.log(arr=[]);
		}else{
			$(this).removeAttr('checked');
			checkAllState=0;
			arrIn=[];
			AllID2=[];
			arrLast=[];
			EndArr=[];
			console.log('end：'+EndArr);
			
		}
	//	console.log(checkAllState);
		
		 
		 
	});
	
	/*
	 * 
	 * 多选框不选中
	 * 决定全选框状态
	 * 
	 * */
	//console.log($('#table_tbody'));
	$('#table_tbody').on('click','input[name=checkbox]',function(){
		var x=$(this).val();
		var xArr=x.split(',')[0];
//		console.log(xArr);
	   	var n=0,m=0,f=0,f2=0,f3=0;

		var thisIndex=$(this).parent().parent().index();
		var ttL=$('#table_tbody tr').length-1;
		
		if($(this).attr("checked")){
			/*input选中时*/
			$(this).attr("checked", 'true');
			//arr
			for(var i=0 in arr){
				if(arr[i]==x){
					arr.splice(i,1);
					break;
				}
			}
			//arrIn
			for(var j=0 in arrIn){
				if(arrIn[j]==x){
					m=1;
					break;
				}else{
					m=0;
				}
			}
			if(m==0){
				arrIn.push(x);
				AllID2.push(xArr);
			}
			
			for(var k=0 in AllID){
				if(AllID[k]==xArr){
					f=1;
					break;
				}else{
					f=0;
				}
			}
			if(f==0){ 
				AllID.push(parseInt(xArr));
			}
			

			                
			for(var k=0 in arrLast){
				if(arrLast[k]==x){
					f2=1;
					break;
				}else{
					f2=0;
				}
			}
			if(f2==0&&thisIndex==ttL){
				arrLast.push(x);
			}
			
			for(var p=0 in arrLast2){
				if(arrLast2[p]==x){
					arrLast2.splice(p,1);
					break;
				}
			}
			c=1;
		}else{
			/*input取消选中时*/
			$(this).removeAttr("checked");
			$('#checkAll').removeAttr("checked");
			thisValue=x;
			//arr
			for(var i=0 in arr){
				if(arr[i]==thisValue){
					n=1;
					break;
				}else{
					n=0;
				}
			}
			if(n==0){
				arr.push(thisValue);
			}
			
			//arrIn
			for(var j=0 in arrIn){
				if(arrIn[j]==thisValue){
					arrIn.splice(j,1);
					AllID2.splice(j,1);
					break;
				}
			}
			
			for(var AI=0 in AllID){
				if(AllID[AI]==xArr){
					AllID.splice(AI,1);
					break;
				}
			}
			
			for(var p=0 in arrLast){
				if(arrLast[p]==x){
					arrLast.splice(p,1);
					break;
				}
			}
			
			for(var k=0 in arrLast2){
				if(arrLast2[k]==x){
					f3=1;
					break;
				}else{
					f3=0;
				}
			}
			if(f3==0&&thisIndex==ttL){
				arrLast2.push(x);
			}
			c=0;
		}
		b=1;
		console.log('arrLast:'+arrLast);
		console.log('arrLast2:'+arrLast2);
//		console.log('arr:'+arr);
//		console.log('arrIn:'+arrIn);
		
		if(checkAllState==1){//全选框-被选中后
//			console.log('最后获取的ID：'+AllID);//2222222222222
			EndArr=AllID;
			console.log('end：'+EndArr);
		}else{//全选框-未被选中后
//			console.log('选中：'+AllID2);//33333333333333
			EndArr=AllID2;
			console.log('end：'+EndArr);
		}
		
		/***
		 * *
		 * 判断-列表中多选框-是否被全部选中
		 * 若全被选中 全选框状态变为选中状态
		 * 
		 * ****/ 
		var pageMax=$('#count').text();
		var EndLen=EndArr.length;
		if(EndLen==pageMax){
			$('#checkAll').attr('checked', 'true');
			
		}
		
		
		
		
	});
	
	
	
	/*
	 * 
	 * 判断-列表中多选框-是否被全部选中
	 * 
	 *  全被选中-全选按钮状态 设为 true
	 *  未全选中-全选按钮状态 设为 false
	 * 
	 * 
	 * */


});

function SendMoney(){
	//  queryUserPage();
	  var page=$("#oldpage").val();
      var erid2 = [];
      var username2 = [];
	  var regid2 = [];
	 if (EndArr.length ==0) {
		alert("你还没有选择任何内容");
		// window.location.href="employeruser.jsp";
		return false;
	}else{
		window.location.href = "SendMoney.jsp?erid="+EndArr+"&&page="+page;
	}
}


/**
 * 自动发送优惠卷
 * @returns {Boolean}
 */
function AutomaticSendMoney(){

		window.location.href ="AutomaticSendMoney.jsp";
	
}
/**
 * 自动发送优惠卷
 * @returns {Boolean}
 */
function AutomaticSendMoneyAll() {
	
	var moneyone = $("#moneyone").val();
	var moneythree = $("#moneythree").val();
	var moneyfive = $("#moneyfive").val();
	var moneylong = $("#moneylong").val();
	var longusenumber = $("#longusenumber").val();

	var ss = confirm("您确定要修改吗?");
	if (ss) {
	$.post("discount/AutoSendCoupon.action", {longusenumber:longusenumber,moneythree:moneythree,moneyfive:moneyfive,moneyone : moneyone,moneylong:moneylong
	}, function(data) {
		if (data == null ) {
			alert("修改成功");
		}
	}, "json");
}
}

function sendMoney(){
	 var pattern = new RegExp("[]");   
	  var flag=true;
	  var page=$("#page").val();
	  var id=$("#id").val();
	 var money=$("#money").val();
	 if(money==""||money==null){
		
		 $("#f2").html("金额不能为空！");
		 flag=false;
	 }
	
 
 
 var endtime=$("#endtime").val();
 if(endtime==""||endtime==null){
	 $("#f1").html("时间不能为空");
	 flag=false;
 }
 if(flag){
		$.post("discount/InsertDisCount1.action",{money:money,id:id,endtime:endtime},function(data){
			if(data!=null){
				alert("发送成功");
				window.location.href="employeruser.jsp?page="+page;
			}
			
		},"json");}
	}

function deleteByid(id) {
	var ss = confirm("您确定要删除吗?");
	if (ss) {
		$.post("euser/delete.action", {id : id}, function(data, status){
			if (data != null && data != "") {
				alert("删除成功！");
				window.location.href = "employeruser.jsp?page="+page;
			} else {
				alert("删除失败，请检查！");		}
		}, "json");
	}
}

function updateUser(){
	var page=$("#page").val();
	var b=new Base64();
	var userInfo = $("#userInfo").serialize();
	var id=$("#ID").val();
	var username=$("#username").val();
	var name=$("#name").val();
	var companyname=$("#companyname").val();
	var status=$("#status").val();
	var grade=$("#grade").val();
	var time=$("#time").val();
	var usernamepash=b.encode(username);
	var namepash=b.encode(name);
	var companynamepash=b.encode(companyname);
	var statuspash=b.encode(status);
	var gradepash=b.encode(grade);
	var timepash=grade;
	var requestData =id+"&&"+ usernamepash + "&&" + namepash
	+ "&&" +companynamepash + "&&" +statuspash+ "&&" +gradepash+"&&"+time;
	var name = $.trim($("#name").val());
	var flag = true;
	if (name == "" || name == null) {
		$("#f2").html("姓名不为空！");
		flag = false;
	} else {
		$("#f2").html("");
	}
	if (flag == true) {
		$.post("euser/updateByPrimaryKey.action", {requestData:requestData}, function(
				data) {
			if (data != null) {
				alert("修改成功！");
				window.location.href="employeruser.jsp?page="+page;
			}
		}, "json");
	}
}
function Base64() {  
	   
    // private property  
    _keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";  
   
    // public method for encoding  
    this.encode = function (input) {  
        var output = "";  
        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;  
        var i = 0;  
        input = _utf8_encode(input);  
        while (i < input.length) {  
            chr1 = input.charCodeAt(i++);  
            chr2 = input.charCodeAt(i++);  
            chr3 = input.charCodeAt(i++);  
            enc1 = chr1 >> 2;  
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);  
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);  
            enc4 = chr3 & 63;  
            if (isNaN(chr2)) {  
                enc3 = enc4 = 64;  
            } else if (isNaN(chr3)) {  
                enc4 = 64;  
            }  
            output = output +  
            _keyStr.charAt(enc1) + _keyStr.charAt(enc2) +  
            _keyStr.charAt(enc3) + _keyStr.charAt(enc4);  
        }  
        return output;  
    };  
   
    // public method for decoding  
    this.decode = function (input) {  
        var output = "";  
        var chr1, chr2, chr3;  
        var enc1, enc2, enc3, enc4;  
        var i = 0;  
        input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");  
        while (i < input.length) {  
            enc1 = _keyStr.indexOf(input.charAt(i++));  
            enc2 = _keyStr.indexOf(input.charAt(i++));  
            enc3 = _keyStr.indexOf(input.charAt(i++));  
            enc4 = _keyStr.indexOf(input.charAt(i++));  
            chr1 = (enc1 << 2) | (enc2 >> 4);  
            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);  
            chr3 = ((enc3 & 3) << 6) | enc4;  
            output = output + String.fromCharCode(chr1);  
            if (enc3 != 64) {  
                output = output + String.fromCharCode(chr2);  
            }  
            if (enc4 != 64) {  
                output = output + String.fromCharCode(chr3);  
            }  
        }  
        output = _utf8_decode(output);  
        return output;  
    };
   
    // private method for UTF-8 encoding  
    _utf8_encode = function (string) {  
        string = string.replace(/\r\n/g,"\n");  
        var utftext = "";  
        for (var n = 0; n < string.length; n++) {  
            var c = string.charCodeAt(n);  
            if (c < 128) {  
                utftext += String.fromCharCode(c);  
            } else if((c > 127) && (c < 2048)) {  
                utftext += String.fromCharCode((c >> 6) | 192);  
                utftext += String.fromCharCode((c & 63) | 128);  
            } else {  
                utftext += String.fromCharCode((c >> 12) | 224);  
                utftext += String.fromCharCode(((c >> 6) & 63) | 128);  
                utftext += String.fromCharCode((c & 63) | 128);  
            }  
   
        }  
        return utftext;  
    };
   
    // private method for UTF-8 decoding  
    _utf8_decode = function (utftext) {  
        var string = "";  
        var i = 0;  
        var c = c1 = c2 = 0;  
        while ( i < utftext.length ) {  
            c = utftext.charCodeAt(i);  
            if (c < 128) {  
                string += String.fromCharCode(c);  
                i++;  
            } else if((c > 191) && (c < 224)) {  
                c2 = utftext.charCodeAt(i+1);  
                string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));  
                i += 2;  
            } else {  
                c2 = utftext.charCodeAt(i+1);  
                c3 = utftext.charCodeAt(i+2);  
                string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));  
                i += 3;  
            }  
        }  
        return string;  
    };
}


/*
 * 
 * 发信息
 * 
 * */
var username;

$(function(){
	var b = new Base64();
	  $("#ToSendMessage").click(function(){
		  if(EndArr.length==0){
	    	  alert("请选择多选框");
	    	  return false;
	      }
		var BigBox=document.createElement('div');
		BigBox.className='BigBox';
		
		var SmallBox=document.createElement('div');
		SmallBox.className='SmallBox';
		
		var tableListBox=document.createElement('div');
		tableListBox.className='tableListBox';
		///
		var listBTit=document.createElement('div');
		listBTit.className='listBTit';
		listBTit.innerHTML='已选雇主列表';
		///
		var listTit=document.createElement('div');
		listTit.className='listTit';
		
		var listTitId=document.createElement('div');
		listTitId.className='listTitId';
		listTitId.innerHTML='编号';
		
		var listTitUsername=document.createElement('div');
		listTitUsername.className='listTitUsername';
		listTitUsername.innerHTML='用户名';
		
		var listTitName=document.createElement('div');
		listTitName.className='listTitName';
		listTitName.innerHTML='名字';
		
		$(listTit).append(listTitId,listTitUsername,listTitName);
		///
		var tableList=document.createElement('ul');
		tableList.className='tableList';
		///
		for(var i=0;i<EndArr.length;i++){
			var erid=EndArr[i];
	
			$.post("euser/selectByusernameOrname.action",{erid:erid},function(data){
				
			
			var li=document.createElement('li');
			li.className='tableList_li';
			
			var listId=document.createElement('div');
			listId.className='listId';
			listId.innerHTML=data[0].id;
			
			var listUsername=document.createElement('div');
			listUsername.className='listUsername';
			listUsername.innerHTML=b.decode(data[0].username);
			
			var listName=document.createElement('div');
			listName.className='listName';
			listName.innerHTML=b.decode(data[0].name);
			
			$(li).append(listId,listUsername,listName);
			$(tableList).append(li);
			},"json");	
		}
		var sendMessage=document.createElement('div');
		sendMessage.className='sendMessage';
		
		var textarea=document.createElement('textarea');
		textarea.className='textarea';
		textarea.placeholder='请输入您要发送的内容...';
		
		var btn1=document.createElement('button');
		btn1.type='button';
		btn1.className='btn1';
		btn1.innerHTML='微信通知';
		
		var btn2=document.createElement('button');
		btn2.type='button';
		btn2.className='btn2';
		btn2.innerHTML='极光推送';

		var btn3=document.createElement('button');
		btn3.type='button';
		btn3.className='btn3';
		btn3.innerHTML='短信发送';
		
		var btnCancel=document.createElement('button');
		btnCancel.type='button';
		btnCancel.className='btnCancel';
		btnCancel.innerHTML='稍等一下? 重新选择';
		
		$(sendMessage).append(textarea,btn1,btn2,btn3);
		$(tableListBox).append(listBTit,listTit,tableList);
		$(SmallBox).append(tableListBox,sendMessage);
		$(BigBox).append(SmallBox,btnCancel);
		var ind=$('frameset',window.parent.document)[0];
		$(ind).after(BigBox);
		

		
	});
	  
		var z=$('frameset',window.parent.document)[0];
		var zn=$(z).parent();
//		console.log($(zn)[0].tagName);
		
		//点击  ‘稍等一下? 重新选择’ 关闭遮罩层
		$(z).parent().on('click','.btnCancel',function(){
			
			$(this).parent().remove();
		});
		
		//点击  ‘短信发送’ 
		$(z).parent().on('click','.btn3',function(){
			var txt=$(this).parent().find('.textarea').val();
			var a=1;
           for(var i=0;i<EndArr.length;i++){
				var erid=EndArr[i];
			
			
  
   $.post("euser/sendSMS.action",{erid:erid,txt:txt},function(data){
	   if(data=="1"){
			
			
		}else{ 
			var id=data;
			
			var zlen=$('.tableList_li',window.parent.document).length;
			for(var i=0;i<zlen;i++){
				var h=$('.tableList_li',window.parent.document).eq(i);
				if($(h).find('.listId').text()==id){
					$(h).css('color','red');
				}
				console.log(i);
			}

			
	
		}
	},"json");
 
		
  }
		 if(a==1){
			 alert("发送成功!");
		 }
	
});
	
	
		
		//点击  ‘极光推送’ 
		$(z).parent().on('click','.btn2',function(){
			var a=1;
			var txt=$(this).parent().find('.textarea').val();
		
			 for(var i=0;i<EndArr.length;i++){
					var erid=EndArr[i];
				
			
	   $.post("euser/Jpush.action",{erid:erid,txt:txt},function(data){
		   if(data=="1"){
			
			
			}else{ 
				var id=data;
				
				var zlen=$('.tableList_li',window.parent.document).length;
				for(var i=0;i<zlen;i++){
					var h=$('.tableList_li',window.parent.document).eq(i);
					if($(h).find('.listId').text()==id){
						$(h).css('color','red');
					}
					console.log(i);
				}

				
		
			}
		},"json");
	  
			
	   }
			 if(a==1){
				 alert("发送成功!");
			 }
		
});
		
		
		
		
		
		//点击  ‘微信通知’ 
		$(z).parent().on('click','.btn1',function(){
			var newopenid;
			var a=1;
			var txt=$(this).parent().find('.textarea').val();
			 for(var i=0;i<EndArr.length;i++){
					var erid=EndArr[i];
				$.post("WechatNotice/queryOpenid.action",{erid:erid},function(data){
					if(data != null){
					    var id=data;
         				var zlen=$('.tableList_li',window.parent.document).length;
         				for(var i=0;i<zlen;i++){
         					var h=$('.tableList_li',window.parent.document).eq(i);
         					if($(h).find('.listId').text()==id){
         						$(h).css('color','red');
         					}
         					
         				}
         				newopenid=data[0].openid;
						
				 }
				 },"json");
                $.post("http://www.dkuaigong.com/KuaigongEmployerWx/wx/sendMsg.action",{newopenid:newopenid,txt:txt},function(data){
                	
         		},"json");
         	  
         			
         	   }
         			 if(a==1){
         				 alert("发送成功!");
         			 }
         		
         });


	

//console.log($('frameset',window.parent.document)[0].next());
$('window',window.parent.document).on('click','.BigBox',function(){
	console.log(111);
});
	
});
