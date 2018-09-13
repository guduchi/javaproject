
$(document).ready(function(){
	//input焦点交互
	$(".quee").focus(function(){
		$(this).css("color","#0b0b0b");
			
	});

	$(".quee").blur(function(){
		$(this).css("color","#ababab");
	});
	
	//身份证放大
	$(".table_tbody_divText_pho").next().click(function(){
		var $imgS=$(this).find("img").attr("src");
		$("body").append("<div class='popBox'></div>");
		var $imgSrc=$(".popBox").append("<img class='popBoxImg' />");
		$(".popBoxImg").attr("src",$imgS);
	});
	$("body:last").dblclick(function(){
		$(".popBox").remove();
	});
	
	$(".table_tbody_divText_pho").next().mouseover(function(){
		$(this).append("<div class='phoText'>点击放大</div>");
	});
	$(".table_tbody_divText_pho").next().mouseout(function(){
		$(".phoText").remove();
	});
	
	//总年月。。。工人在线时长选择
	$(".tools_a").find("a").click(function(){
		$(".tools_a").find("a").css({"background-color":"rgba(0,0,0,0)","border-color":"#D3DBDE","color":"#000"});
		$(this).css({"background-color":"#B0C4E1","border-color":"#B0C4E1","color":"#fff"});
	});
});