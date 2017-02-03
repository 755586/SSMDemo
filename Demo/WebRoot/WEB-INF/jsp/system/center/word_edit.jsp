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

<title>My JSP 'word.jsp' starting page</title>

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
	<div id="container"
		style="min-width: 300px; min-height: 400px; margin: 0 auto"></div>
	<script type="text/javascript">
		$(function() {
			var options = {
				chart : {
					plotBackgroundColor : null,
					plotBorderWidth : null,
					plotShadow : false,
					type : 'pie'
				},
				title : {
					text : '词汇统计饼状图'
				},
				tooltip : {
					pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
				},
				plotOptions : {
					pie : {
						allowPointSelect : true,
						cursor : 'pointer',
						dataLabels : {
							enabled : false
						},
						showInLegend : true
					}
				},
				credits: { enabled:false },
				exporting: { enabled:false },
				series:[]
			};
			$.ajax({
				url : 'system/center/word/chart?action=list',
				dataType : 'json',
				success : function(data) {
					console.log(data);
					if (data!=null) {
						options.series[0] = data;
						Highcharts.chart('container', options);
					}
				},
				error : function() {
					alert("获取词汇数据失败");
				}
			})
		});
	</script>
</body>
</html>
