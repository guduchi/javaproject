function queryUserPage9(page){
	var b=new Base64();
	var queryScale1=$("#queryScale1").val();
	$.post("onlineInformation/queryByID.action",{queryScale1:queryScale1},function(data,status){
		if(data!=null){
		selectSum(Math.ceil(data/8));
		}
	},"json");
	$.post("onlineInformation/queryByIDPagGe.action",{queryScale1:queryScale1} ,function(data){
if(data!=null){
		$("#table_tbody").empty();
		
		$.each(data,function(){
				$("#table_tbody").append("<tr>" 
						+ "<td>" +this.id +  "</td>" 
						+ "<td>"+b.decode(this.username)+ "</td>" 
						+ "<td>"+b.decode(this.name)+"</td>"
						+"<td>"+this.startime+ "</td>"
						+"<td>"+this.endtime+ "</td>"
						+ "<td>"+this.status+ "</td>"
						+"</tr>");
		
		});
}
	},"json");
}
function queryByIDPagGe(page){
	$.post("onlineInformation/queryByIDPagGe.action",{queryScale1:queryScale1} ,function(data){
		if(data!=null){
				$("#table_tbody").empty();
				
				$.each(data,function(){
						$("#table_tbody").append("<tr>" 
								+ "<td>" +this.id +  "</td>" 
								+ "<td>"+b.decode(this.username)+ "</td>" 
								+ "<td>"+b.decode(this.name)+"</td>"
								+"<td>"+this.startime+ "</td>"
								+"<td>"+this.endtime+ "</td>"
								+ "<td>"+this.status+ "</td>"
								+"</tr>");
				
				});
		}
			},"json");
}

function selectSum(pageNum) {
	$("[name=select]").empty();
	var i = 1;
	$("[name=sum]").html(pageNum);
	$("[name=page]").html(1);
	while (i <= pageNum) {
		$("[name=select]").append("<option >" + i + "</option>");
		i++;
	}
}
//����ѡ��ҳ��
function selectNumber() {
	page= $(this).children('option:selected').val();
	$("[name=page]").html(page);
	MHqueryUserPaGe(page);
}
//��һҳ
function nextPage() {
	var page = $("[name=page]").html();
	var sum = $("[name=sum]").html();
	if (parseInt(page) >= parseInt(sum)) {
		alert("�Ѿ������һҳ�ˣ�");
	} else {
		var page1=parseInt(page)+1;
		$("[name=page]").html(page1);
		page=parseInt(page)+1;
		MHqueryUserPaGe(page);
	//	$("[name=select]").append("<option selected>" + page1 + "</option>");
	}

}
function lastPage() {
	page = $("[name=page]").html();
	if (page < 2) {
		alert("�Ѿ��ǵ�һҳ�ˣ�");
	} else {
		var page1 = page - 1;
		$("[name=page]").html(page1);
		page-=1;
	//	$("[name=select]").append("<option selected>" + page1 + "</option>");
		MHqueryUserPaGe(page);
	}
	
}