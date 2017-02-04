<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>地鼠游戏后台管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.5/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-portal/portal.css">
<script type="text/javascript" src="js/jquery-easyui-1.5/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-portal/jquery.portal.js"></script>
<script type="text/javascript"
	src="js/highcharts-5.0.6/highcharts.js"></script>
<script type="text/javascript"
	src="js/highcharts-5.0.6/modules/exporting.js"></script>
</head>

<body id="box" class="easyui-layout" onselectstart="return false">
	<div id="panel_north"
		data-options="region:'north',title:'North Title',split:true"
		style="height:100px;"></div>
	<div id="panel_south"
		data-options="region:'south',title:'South Title',split:true"
		style="height:100px;"></div>
	<div id="panel_east"
		data-options="region:'east',title:'East',split:true"
		style="width:300px;"></div>
	<div id="panel_west"
		data-options="region:'west',title:'West',split:true"
		style="width:200px;"></div>
	<div id="panel_center"
		data-options="region:'center',title:'center title'"
		style="padding:5px;background:#eee;"></div>
	<script type="text/javascript">
		$(function() {
			$('#panel_west').panel({
				title : "菜单导航",
				href : 'system/west/menu',
				onLoad : function() {
					console.log("加载用户信息成功");
				},
				onLoadError : function() {
					console.log("加载用户信息失败");
				}
			});
		})
	</script>
</body>
</html>
