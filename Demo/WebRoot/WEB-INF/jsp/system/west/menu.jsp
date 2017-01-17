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

<title>My JSP 'menu.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<ul id="menu" class="easyui-tree"></ul>
	<script type="text/javascript">
		$('#menu').tree({
			url : 'system/west/menu?action=list',
			method : 'post',
			onClick : function(node) {
				menuClick(node);
			}
		})
		function menuClick(node) {
			var url = node.url;
			if (node.text == "首页") {
				$('#panel_center').panel({
					title : "首页",
					href : node.url,
					onLoad : function() {
						console.log("加载用户信息成功~");
					},
					onLoadError : function() {
						console.log("加载用户信息失败~");
					}
				});
			}else if(node.text == "词汇统计"){
				$('#panel_center').panel({
					title : "词汇统计",
					href : node.url,
					onLoad : function() {
						console.log("加载词汇信息成功~");
					},
					onLoadError : function() {
						console.log("加载词汇信息失败~");
					}
				});
			} else if (node.text == "用户管理") {
				$('#panel_center').panel({
					title : "用户管理",
					href : node.url,
					onLoad : function() {
						console.log("加载用户信息成功~");
					},
					onLoadError : function() {
						console.log("加载用户信息失败~");
					}
				});
				$('#panel_east').panel({
					title : "HCharts",
					href : 'system/east/hcharts',
					onLoad : function() {
						console.log("正在加载数据");
					},
					onLoadError : function() {
						console.log("加载数据失败");
					}
				});
			} else {//待更新
				$.messager.alert({
					title : "待更新",
					msg : node.text,
					fn : function() {
						console.log(node);
					}
				});
			}
		}
	</script>
</body>
</html>
