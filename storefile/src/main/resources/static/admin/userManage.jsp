<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Custom DataGrid Pager - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/util/jquery-easyui-1.3.6/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/util/jquery-easyui-1.3.6/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/util/jquery-easyui-1.3.6/demo/demo.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.1.4.2-min.js"></script>
	<script type="text/javascript" src="<%=path %>/util/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/admin.user.manage.js"></script>
</head>
<body>
	
	
	<table id="dg" style="width:700px;height:250px"></table>
	
	<div id="dlg-save">
	用户名：<input id="un" ><br>
	密码：<input id="pw" ><br>
	邮箱：<input id="mail" ><br>
	
	</div>
	
</body>
</html>