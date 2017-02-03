<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>词汇管理</title>

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
<script type="text/javascript" src="js/jquery-easyui-1.5/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
</head>

<body onselectstart="return false">
	<table id="dgWord"></table>
	<div id="wordDialog" class="easyui-dialog" style="width:400px"
		closed="true" buttons="#dlg-buttons">
		<form id="wordForm" method="post" novalidate
			style="margin:0;padding:20px 50px">
			<div
				style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">
				词汇信息</div>

			<div style="margin-bottom:10px">
				<input name="english" class="easyui-textbox" required="true"
					label="英文:" style="width:100%">
			</div>
			<div style="margin-bottom:10px">
				<input name="chinese" class="easyui-textbox" required="true"
					label="中文:" style="width:100%">
			</div>
			<div style="margin-bottom:10px">
				<input name="rank" class="easyui-textbox" required="true"
					label="等级:" style="width:100%">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="saveWord()" style="width:90px">Save</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel"
			onclick="javascript:$('#wordDialog').dialog('close')"
			style="width:90px">Cancel</a>
	</div>
	<script type="text/javascript">
		$('#dgWord').datagrid({
			url : 'system/center/word/wordEdit?action=list',
			queryParams : {
				code : "123456"
			},
			method : 'post',
			nowrap : false,//单行显示
			pageSize : 10,//每页显示的记录条数，默认为10
			pageList : [ 5, 10, 20, 30, 50 ],//可以设置每页记录条数的列表
			showFooter : true,//显示页脚
			singleSelect : true,//是否单选
			pagination : true,//分页控件
			rownumbers : false,//行号
			remoteSort : false,//进行服务器端全局排序方式
			idField : 'id', //主键
			loadMsg : '正在加载数据，请稍等...',
			fitColumns : true,
			fit : true,
			sortName : 'type_name',//Defines which column can be sorted.
			sortOrder : 'asc',//Defines the column sort order,can only be 'asc'升序 or 'desc'降序.
			columns : [ [ {
				field : 'id',
				title : 'ID',
				width : 100,
				hidden : true
			}, {
				field : 'num',
				title : '编号',
				width : 100,
				sortable : true,
				checkbox : true
			}, {
				field : 'english',
				title : '英文',
				width : 100
			}, {
				field : 'chinese',
				title : '中文',
				width : 100,
				align : 'center'
			}, {
				field : 'type_name',
				title : '类型',
				width : 100,
				align : 'center'
			}, {
				field : 'rank',
				title : '等级',
				width : 100,
				align : 'center'
			} ] ],
			toolbar : [ {
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					preadd();
				}
			}, '-', {
				text : '修改',
				iconCls : 'icon-edit',
				handler : function() {
					preupdate();
				}
			}, '-', {
				text : '删除',
				iconCls : 'icon-remove',
				handler : function() {
					predelete();
				}
			} ],
		});
	</script>
	<script type="text/javascript">
		var action;
		function preadd() {
			$('#wordDialog').dialog('open').dialog('center').dialog('setTitle',
					'新增词汇');
			$('#wordForm').form('clear');
			action = "add";
		}
		function preupdate() {
			var row = $('#dgWord').datagrid('getSelected');
			if (row) {
				$('#wordDialog').dialog('open').dialog('center').dialog(
						'setTitle', '编辑词汇');
				$('#wordForm').form('load', row);
				action = 'update&id=' + row.id;
			}
		}
		function saveWord() {
			$('#wordForm').form('submit', {
				url : 'system/center/word?action=' + action,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					console.log(result)
					var result = eval('(' + result + ')');
					if (result.errorMsg) {
						$.messager.show({
							title : '操作失败',
							msg : result.errorMsg
						});
					} else {
						$('#wordDialog').dialog('close'); // close the dialog
						$('#dgWord').datagrid('reload'); // reload the user data
					}
				}
			});
		}
		function predelete() {
			var row = $('#dgWord').datagrid('getSelected');
			if (row) {
				$.messager.confirm('提示', '您确认删除此词汇吗?', function(r) {
					if (r) {
						$.post('system/center/word', {
							action : 'delete',
							id : row.id
						}, function(result) {
							console.log(result)
							if (result.success) {
								$('#dgWord').datagrid('reload'); // reload the user data
							} else {
								$.messager.show({ // show error message
									title : '删除失败',
									msg : result.errorMsg
								});
							}
						}, 'json');
					}
				});
			}
		}
	</script>
</body>
</html>
