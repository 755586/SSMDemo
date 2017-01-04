$(function() {
	
	$('#panel_west').panel({
		title:"菜单导航",
		href:'system/menu',
		onLoad:function(){
			console.log("加载用户信息成功~~");
		},
		onLoadError:function(){
			console.log("加载用户信息失败");
		}
	});
})