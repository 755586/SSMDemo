<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-easyui-1.5/jquery.min.js"></script>
</head>

<body>
	<!--   
        声明： 此div应该在允许使用webcam，网络摄像头之后动态生成  
        宽高： 640 *480,当然，可以动态控制啦!  
        -->
	<!--  
    Ideally these elements aren't created until it's confirmed that the   
    client supports video/camera, but for the sake of illustrating the   
    elements involved, they are created with markup (not JavaScript)  
        -->
	<video id="video" width="640" height="480" autoplay></video>
	<button id="snap">Snap Photo</button>
	<canvas id="canvas" width="640" height="480"></canvas>
	<script type="text/javascript">
		// 设置事件监听，DOM内容加载完成，和jQuery的$.ready() 效果差不多。  
		window.addEventListener("DOMContentLoaded", function() {
			// canvas 元素将用于抓拍  
			var canvas = document.getElementById("canvas"), context = canvas
					.getContext("2d"),
			// video 元素，将用于接收并播放摄像头 的数据流  
			video = document.getElementById("video"), videoObj = {
				"video" : true
			},
			// 一个出错的回调函数，在控制台打印出错信息  
			errBack = function(error) {
				if ("object" === typeof window.console) {
					console.log("Video capture error: ", error.code);
				}
			};

			// Put video listeners into place  
			// 针对标准的浏览器  
			if (navigator.getUserMedia) { // Standard  
				navigator.getUserMedia(videoObj, function(stream) {
					video.src = stream;
					video.play();
				}, errBack);
			} else if (navigator.webkitGetUserMedia) { // WebKit-prefixed  
				navigator.webkitGetUserMedia(videoObj, function(stream) {
					video.src = window.webkitURL.createObjectURL(stream);
					video.play();
				}, errBack);
			}
			// 对拍照按钮的事件监听  
			document.getElementById("snap").addEventListener("click",
					function() {
						// 画到画布上  
						context.drawImage(video, 0, 0, 640, 480);
					});

		}, false);
	</script>
</body>
</html>
