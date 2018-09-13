function online1(){
var id=$("#id").val();

var starttime=$("#starttime").val()+" "+"00:00:00";
var endtime=$("#endtime").val()+" "+"23:59:59";

	var b =new Base64();
	$.post("eeuser/queryDate.action",{starttime:starttime,endtime:endtime,id:id},function(data){
		if(data!=null){
		window.location.href="onlines.jsp?id="+id;
			
				}
			}, "json");
}	
