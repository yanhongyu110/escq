<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<meta charset="UTF-8">
		<title>我的关注</title>
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
		<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
		<link rel="stylesheet" href="${webtxc}/css/wap/index.css" />
		<script src="${webtxc}/js/wap/reset.js"></script>
		<script src="${webtxc}/js/wap/TouchSlide.js"></script>
		<script src="${webtxc }/js/wap/jquery-1.9.1.min.js"></script>
		<script type="text/javascript">
		var serviceTypetree = '${serviceTypetree}';
		var jsonList = ${jsonList};
		var count = ${count};
		</script>
		<script type="text/javascript" src="${webtxc}/myjs/wap/bizinfo/myfocus.js?v=201712310901"></script>
		<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
</head>
<body>
<div class="wapper">
		<!--page-->
		<input id="thelogid" type="hidden" value="${sessionScope.logInfo.logId}"/>
		<div id="page" style="margin-bottom: 56px;">
			<div class="personer_top">
				
				<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
			</div>
			<div class="content_list"></div>
			<!--end.service_list-->
			<%--<div class="jiaz" >加载更多...</div>--%>
		</div>
		<!--end.content_list-->
	</div>
	<%-- <%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%> --%>
</body>
</html>
