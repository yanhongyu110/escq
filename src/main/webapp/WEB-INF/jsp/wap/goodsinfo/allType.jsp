<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>所有类型</title>
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<meta content="yes" name="apple-mobile-web-app-capable">
		<!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
		<meta name="apple-touch-fullscreen" content="yes">
		<!-- 开启对web app程序的支持  -->
		<meta content="telephone=no,email=no" name="format-detection">
		<!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
		<!--base css-->
		<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
    	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
		<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
		<link rel="stylesheet" href="${webtxc}/css/wap/personer.css"/>
		<script src="${webtxc}/js/wap/reset.js"></script>
		<script src="${webtxc}/js/wap/TouchSlide.js"></script>	
		<script type="text/javascript">
		$(function(){
		var saveValue=${saveValue};
		$.each( saveValue, function(i, n){
			var maintype='<div class="main_type" name="'+n.id+'">'+n.text+'<ul></ul></div>';
			$("#all_type").append(maintype);
			$.each( n.children, function(index, content){
				var html='<li class="sub_type" name="'+content.id+'" onclick="getType(this);return false;">'+content.text+'</li>';
				$(".main_type:eq("+i+") ul").append(html);
			})
			}); 
		});
		function getType(e){
			var temp=$(e);
			parent.$("#type").html($(e).html());
			parent.$(".typeId").val($(e).attr("name"));
			parent.layer.closeAll();
		}
		</script>
	</head>

	<body>
	<div id="all_type" class="all_type">	</div>
	</body>

</html>