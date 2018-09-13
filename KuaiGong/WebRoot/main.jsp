<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>快工管理系统界面</title>
	<link rel="stylesheet" type="css/text" href="css/style.css" />
	<style>
	/* ToSendMessage */
	*{
		margin:0;
		padding:0;
	}
	ul li{
		list-style:none;
	}
	.BigBox{
		width: 100%;
		height: 100%;
		position: absolute;
		top: 0;
		background-color: rgba(0,0,0,0.5);
	}
	.SmallBox{
		width:90%;
		height:70%;
		background-color:#fff;
		margin:0 auto;
		margin-top:50px;
		margin-bottom:15px;
		padding-top:10px;
	}
	.tableListBox{
		float:left;
		width:35%;
		height:95%;
		background-color:#eee;
		margin: 0px 20px;
		box-sizing:border-box;
		-website-box-sizing:border-box;
		-moz-box-sizing:border-box;
		overflow:hidden;
	}
	.listBTit{
		font-size:20px;
		text-align:center;
		line-height: 35px;
		
	}
	.listTit{
		background-color:#B0C4E1;
		color:#fff;
		text-align:center;
	}
	.listTit div{
		
		display: inline-block;
		line-height:30px;
		margin:0 2px;
		text-align:center;
		box-sizing:border-box;
		-website-box-sizing:border-box;
		-moz-box-sizing:border-box;
	}
	.tableList{
		height:78%;
		margin-top: 5px;
		overflow:hidden;
		overflow-y:scroll;
	}
	.tableList li{
		float:left;
		width:100%;
		margin-bottom:5px;
	}
	.tableList li div{
	
		float:left;
		line-height:30px;
		margin:0 2px;
		text-align:center;
		box-sizing:border-box;
		-website-box-sizing:border-box;
		-moz-box-sizing:border-box;
		
	}
	.listTitId,.listId{
		width:25%;
	}
	.listUsername{
		width:45%;
	
		border-left:1px dashed #c7c7c7;
		border-right:1px dashed #c7c7c7;
	}
	.listTitName,.listName{
		width:25%;
	}
	.listTitUsername{
		width:45%;
		padding-right: 30px;
	}
	.listTitName{
		padding-right: 30px;
	}
	.sendMessage{
		float:left;
		width:60%;
		height:95%;
		background-color:#eee;
		box-sizing:border-box;
		-website-box-sizing:border-box;
		-moz-box-sizing:border-box;
		
	}
	.textarea{
		display: block;
		width: 98%;
		height: 80%;
		margin: 0 auto;
		margin-top: 10px;
		margin-bottom: 10px;
		padding:5px;
		resize:none;
		overflow-y:scroll;
		font-size:16px;
	}
	.sendMessage button{
		float:right;
		padding:5px 20px;
		background-color:#FFC600;
		color:#fff;
		border-radius:3px;
		cursor: pointer;
		border: 0;
		text-align: center;
		margin-right: 8px;
		font-size: 16px;
	}
	.sendMessage button:hover{
		background-color:#FFA200;
		
	}
	.btnCancel{
		padding:5px 20px;
		background-color:#3d7bc7;
		color:#fff;
		border-radius:3px;
		cursor: pointer;
		border: 0;
		text-align: center;
		font-size: 16px;
		margin: 0 auto;
		display: block;
	}
	.btnCancel:hover{
		background-color:#295fa1;
		
	}
	</style>
</head>
<frameset rows="70px,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
    <frame src="left.jsp" name="leftFrame" scrolling="auto" noresize="noresize" id="leftFrame" title="leftFrame" style=' overflow-x : hidden; '/>
    <frame src="index.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
  </frameset>
</frameset>
<body>
<noframes></noframes>
</body>
</html>
