<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.5/themes/icon.css">
  	<script type="text/javascript" src="js/jquery-easyui-1.5/jquery.min.js"></script>
  	<script type="text/javascript" src="js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
  </head>
  
  <body onselectstart="return false">
  		<table id="dg_user"></table>
  		<script type="text/javascript">
  			$('#dg_user').datagrid({
			    url:'system/user?action=list',
			    queryParams:{name:"qiuqing"},
			    method : 'post',
				nowrap : false,//单行显示
				pageSize : 5,//每页显示的记录条数，默认为10
				pageList : [ 1, 2, 3, 5, 10 ],//可以设置每页记录条数的列表
				showFooter : true,//显示页脚
				singleSelect : false,//是否单选
				pagination : true,//分页控件
				rownumbers:false,//行号
				remoteSort:false,//进行服务器端全局排序方式
				idField: 'id', //主键
				loadMsg : '正在加载数据，请稍等...',
				fitColumns : true,
				fit : true,
				sortName:'name',//Defines which column can be sorted.
				sortOrder:'asc',//Defines the column sort order,can only be 'asc'升序 or 'desc'降序.
			    columns:[[
			    	{field: 'id', title: 'ID', width:100, hidden:true },
			    	{field: 'num', title: '编号', width:100, sortable: true, checkbox: true },
			        {field:'name',title:'用户名',width:100},
			        {field:'password',title:'密码',width:100,align:'center'}
			    ]],
			    toolbar:[{
					text : '添加',
					iconCls : 'icon-add',
					handler : function() {
				    	preadd();
		    		}},'-',
					{text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
				    	preupdate();
					}},'-',
					{text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
				    	predelete();
					}}],
				});
  		</script>
  </body>
</html>
