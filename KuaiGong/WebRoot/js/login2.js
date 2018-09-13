$(function(){
	click();
	queryUserPage();
});
function click(){
	$("[name=queryByid]").bind("change",queryPage);
	$("[name=select]").bind("change", selectNumber);
	$("[name=last]").bind("click", lastPage);
	$("[name=next]").bind("click", nextPage);
	$("[name=ToSendMessageToBlackList]").bind("click", ToSendMessageToBlackList);
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
	if(page=="null" || page=="" || page=="undefined"){
		page=1;
	}
	else{
		page=page;
	}
   var phone1=$("#phone").val();
    var btu=$("#btu").val();
    $("[name=page]").html(page);
	var pageSize = 22;
	var b = new Base64();
	var name = $("#name").val();
	var eeid = $("#eeid").val();
	var salesmanName=$("#salesmanName").val();
	// salesmanName=b.encode(salesmanName);
	name = b.encode(name);
	 var phone=b.encode(phone1);
	 if(checkAllState!=1){
			$.post("eeuser/queryID1.action",{page:page,pageSize:pageSize,name:name,eeid:eeid,phone:phone,btu:btu},//,salesmanName:salesmanName},
					function(data) {
						if (data != null) {
							var pageNum=data.length;
							
							selectSum(Math.ceil(pageNum/22),page);
							 /****获取到全部ID*****/
							console.log(data);
							DataArr=data;
							for(var z=0 in DataArr){
								AllID.push(DataArr[z].id);
							}
//							AllI=AllID;
//							console.log(AllID);
							/***end****/

							
						
						}
					}, "json");
			 }else{

					alert('嘿！在全选过的状态下不可以进行查询哦！再点一点全选试试 ~');
					return false;
				}

	$.post("eeuser/queryIDByPage.action",{page:page,pageSize:pageSize,name:name,eeid:eeid,phone:phone,btu:btu},//,salesmanName:salesmanName},
			function(data) {
				if (data != null) {
					$("#table_tbody").empty();
					$.each(data, function() {
						$("#table_tbody").append("<tr>"
								+ "<td><input type='checkbox' id='checkbox'   name='checkbox' value="+this.id+','+page+" "+testFlag()+"/>" + "</td>"
						+ "<td>" + this.id+ "</td>"
						+ "<td>" + b.decode (this.username)+ "</td>" 
						+ "<td>" + b.decode (this.name)+ "</td>"
						+"<td>"  + b.decode (this.sex)+ "</td>"
						+"<td>"  + b.decode (this.age)+ "</td>" 
						+"<td>"  + b.decode (this.idcard)+ "</td>" 
						+"<td>"  + b.decode (this.address)+ "</td>" 
						+"<td>"  +test(this.status)+ "</td>"
						+"<td>"  +this.onlineStatus+ "</td>"
						+"<td>"  +test(this.time)+ "</td>"
//						+ "<td>"+this.salesmanId+ "</td>"
//						+ "<td>"+this.salesmanName+ "</td>"
					    +"<td>"
//					    + "<select id='btu"+this.id+"'  onchange='btu("+ this.id+",\""+b.decode (this.username)+"\",\""+b.decode (this.name)+"\",\""+ b.decode (this.sex)+"\",\""+b.decode (this.age)+"\",\""+b.decode (this.address)+"\",\""+test(this.status)+"\",\""+this.salesmanId+"\",\""+this.salesmanName+"\",\""+page+"\")'>"
					    + "<select id='btu"+this.id+"'  onchange='btu("+ this.id+",\""+b.decode (this.username)+"\",\""+b.decode (this.name)+"\",\""+ b.decode (this.sex)+"\",\""+b.decode (this.age)+"\",\""+b.decode (this.address)+"\",\""+test(this.status)+"\",\""+page+"\")'>"
// + "<select id='btu"+this.id+"' onchange='btu("+ this.id+",\""+b.decode
// (this.username)+"\",\""+b.decode (this.name)+"\",\""+ b.decode
// (this.sex)+"\",\""+b.decode (this.age)+"\",\""+b.decode
// (this.address)+"\",\""+test(this.status)+"\",\""+this.salesmanId+"\",\""+b.encode(this.salesmanName)+"\",\""+page+"\")'>"
				        +"<option value='1'>请选择</option>"
				        + "<option  value='修改基本信息'>修改基本信息</option>"
				        +"<option value='查看详细信息'>查看详细信息</option>"
						+"<option value='查看提现记录'>查看提现记录</option>"
						+"<option value='查看收益记录'>查看收益记录</option>"
						+"<option value='查看工作记录'>查看工作记录</option>"
						+ "<option  value='查看工人钱包'>查看工人钱包</option>"
						+ "<option  value='充值'>充值</option>"
						+ "<option  value='禁用'>禁用</option>"
//						+ "<option  value='修改业务员'>修改业务员</option>"
						+ "<option  value='修改密码'>修改密码</option>"
					
						+"<select/>"
						+"</td>"+"</tr>");	
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

function queryIDByPage(page){
	 var phone1=$("#phone").val();
	 var btu=$("#btu").val();
    var page=page;
	
	var pageSize = 22;
	var b = new Base64();
	 var phone=b.encode(phone1);
	var name = $("#name").val();
	var eeid = $("#eeid").val();
	var salesmanName=$("#salesmanName").val();
	name = b.encode(name);
// salesmanName=b.encode(salesmanName);
	$.post("eeuser/queryIDByPage.action",{page:page,pageSize:pageSize,name:name,eeid:eeid,phone:phone,btu:btu},//,salesmanName:salesmanName},
			function(data) {
				if (data != null) {
					$("#table_tbody").empty();
					$.each(data, function() {
						$("#table_tbody").append("<tr>"
								+ "<td><input type='checkbox' id='checkbox'   name='checkbox' value="+this.id+','+page+" "+testFlag()+"/>" + "</td>"
						+ "<td>" + this.id+ "</td>"
						+ "<td>" + b.decode (this.username)+ "</td>" 
						+ "<td>" + b.decode (this.name)+ "</td>"
						+"<td>"  + b.decode (this.sex)+ "</td>"
						+"<td>"  + b.decode (this.age)+ "</td>" 
						+"<td>"  + b.decode (this.idcard)+ "</td>" 
						+"<td>"  + b.decode (this.address)+ "</td>" 
						+"<td>"  +test(this.status)+ "</td>"
						+"<td>"  +this.onlineStatus+ "</td>"
						+"<td>"  +test(this.time)+ "</td>"
//						+ "<td>"+this.salesmanId+ "</td>"
//						+ "<td>"+this.salesmanName+ "</td>"
					    +"<td>"
					    + "<select id='btu"+this.id+"'  onchange='btu("+ this.id+",\""+b.decode (this.username)+"\",\""+b.decode (this.name)+"\",\""+ b.decode (this.sex)+"\",\""+b.decode (this.age)+"\",\""+b.decode (this.address)+"\",\""+test(this.status)+"\",\""+page+"\")'>"
//					    + "<select id='btu"+this.id+"'  onchange='btu("+ this.id+",\""+b.decode (this.username)+"\",\""+b.decode (this.name)+"\",\""+ b.decode (this.sex)+"\",\""+b.decode (this.age)+"\",\""+b.decode (this.address)+"\",\""+test(this.status)+"\",\""+this.salesmanId+"\",\""+this.salesmanName+"\",\""+page+"\")'>"
// + "<select id='btu"+this.id+"' onchange='btu("+ this.id+",\""+b.decode
// (this.username)+"\",\""+b.decode (this.name)+"\",\""+ b.decode
// (this.sex)+"\",\""+b.decode (this.age)+"\",\""+b.decode
// (this.address)+"\",\""+test(this.status)+"\",\""+this.salesmanId+"\",\""+b.encode(this.salesmanName)+"\",\""+page+"\")'>"
				        +"<option value='1'>请选择</option>"
				        + "<option  value='修改基本信息'>修改基本信息</option>"
				        +"<option value='查看详细信息'>查看详细信息</option>"
// +"<option value='数据转移'>数据转移</option>"查看工人钱包
						+"<option value='查看提现记录'>查看提现记录</option>"
						+"<option value='查看收益记录'>查看收益记录</option>"
						+"<option value='查看工作记录'>查看工作记录</option>"
						+"<option value='查看工人钱包'>查看工人钱包</option>"
						+ "<option  value='充值'>充值</option>"
						+ "<option  value='禁用'>禁用</option>"
//						+ "<option  value='修改业务员'>修改业务员</option>"
						+ "<option  value='修改密码'>修改密码</option>"
						+"<select/>"
						+"</td>"+"</tr>");	
					});
				}
			}, "json");
}
// ,"+b.decode (this.username)+","+b.decode(this.sex)+","+b.decode
// (this.name)+","+b.decode (this.age)+","+b.decode (this.idcard)+","+b.decode
// (this.address)+","+this.status+","+this.time+"
function test(str) {
	if(typeof(str)=="undefined"){ 

		return "";

		}else{
			return str;
		}
}


function btu(id,username,name,sex,age,address,status,page){//salesmanId,salesmanName) {
      var page=page;
    var name=name;
    var username=username;
    var sex=sex;
    var age=age;
    var idcard=idcard;
    var address=address;
    var status=status;
    var time=time;
//    var salesmanId=salesmanId;
//    var salesmanName=salesmanName;
	var id = id;
	var btu = $("#btu"+id).val();
	if(btu=="修改基本信息"){
		window.location.href="user/updateEmployeeuser.jsp?id="+id+"&&username="+username+"&&name="+name+"&&sex="+sex+"&&age="+age+"&&address="+address+"&&status="+status+"&&page="+page;
 }
	else if (btu == "查看详细信息") {
		window.location.href = "querymany.jsp?id=" + id+"&&page="+page;
// } else if(btu=="数据转移"){
// window.location.href="Change.jsp?id="+id+"&&page="+page;
	}else if(btu=="查看提现记录"){
		window.location.href="queryMoney.jsp?id="+id+"&&page="+page;
	}else if(btu=="查看收益记录"){
		window.location.href="GRshouyi.jsp?id="+id+"&&page="+page;
 }else if(btu=="查看工作记录"){
		window.location.href="GROrderForm.jsp?id="+id+"&&page="+page;
 }else if(btu=="查看工人钱包"){
		window.location.href="workerWallet.jsp?id="+id+"&&page="+page;
 }
 
 else if(btu=="充值"){
		window.location.href="RChonZhi.jsp?id="+id+"&&page="+page;
 }else if(btu=="修改密码"){
		window.location.href="updateEmployeePassword.jsp?id="+id+"&&page="+page;
 }
	else if(btu=="禁用"){
		
		$.post("Blacklist/BlacklistToinsertToeeuser.action",{id:id,name:name,username:username},function(data){
				if(data =="1"){
					alert("禁用成功!");
					window.location.href="employeeuser.jsp";
				} else if(data =="2"){
					alert("黑名单已存在!");
				}else{
					alert("禁用失败!");
				}
			},"json");
		}	
 
 else if(btu=="修改业务员"){
	 window.location.href="user/updateid.jsp?id="+id+"&&page="+page+"&&salesmanId="+salesmanId;
 }
}

// 下拉的页数
function selectSum(pageNum,page) {
	$("[name=select]").empty();
	var i = 1;

	$("[name=sum]").html(pageNum);
	$("[name=page]").html(page);
	while (i <= pageNum) {
		$("[name=select]").append("<option >" + i + "</option>");
		i++;
	}
}
// 下拉选择页数
function selectNumber() {
	page= $(this).children('option:selected').val();
	$("[name=page]").html(page);
	queryIDByPage(page);

}
// 下一页
function nextPage() {
	var page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	if (parseInt(page) >= parseInt(sum)) {
		alert("已经是最后一页了！");
	} else {
		var page1=parseInt(page)+1;
		$("[name=page]").html(page1);
		page=parseInt(page)+1;
		queryIDByPage(page);
		getChecked();
	// $("[name=select]").append("<option selected>" + page1 + "</option>");
	}

}
function lastPage() {
	page = $("[name=page]").html();
	
	if (page < 2) {
		alert("已经是第一页了！");
	} else {
		var page1 = page - 1;
		$("[name=page]").html(page1);
		page-=1;
// $("[name=select]").append("<option selected>" + page1 + "</option>");
		queryIDByPage(page);
		getChecked();
	}
	
}

// 跳转指定页面
function queryPage(){
	var querypage=$("#querypage").val();
	var sum = $("[name=sum]").html();
	if(querypage>parseInt(sum)){
		alert("没有找到页数");
	}
	else if(querypage<=0){
		alert("没有找到页数");
	}
	else{
	var page=querypage;
	$("[name=page]").html(page);
	queryIDByPage(page);
	
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
	
			$.post("eeuser/selectByusernameOrname.action",{erid:erid},function(data){
				
			
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
		
//		var btn1=document.createElement('button');
//		btn1.type='button';
//		btn1.className='btn1';
//		btn1.innerHTML='微信通知';
		
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
		
		//$(sendMessage).append(textarea,btn1,btn2,btn3);
		$(sendMessage).append(textarea,btn2,btn3);
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
			var a=1;
			var txt=$(this).parent().find('.textarea').val();
   
   for(var i=0;i<EndArr.length;i++){
				var erid=EndArr[i];
			
			
  
   $.post("eeuser/sendSMS.action",{erid:erid,txt:txt},function(data){
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
				
				
	  
	   $.post("eeuser/Jpush.action",{erid:erid,txt:txt},function(data){
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

	

//console.log($('frameset',window.parent.document)[0].next());
$('window',window.parent.document).on('click','.BigBox',function(){
	console.log(111);
});
	
});
function ToSendMessageToBlackList(){
	window.location.href="ToSendMessageToBlackList.jsp";
}