<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>修改资料</title>
	<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
	<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
	<%@ include file="/WEB-INF/jsp/common/kindeditor.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta content="yes" name="apple-mobile-web-app-capable">
	<!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
	<meta name="apple-touch-fullscreen" content="yes">
	<!-- 开启对web app程序的支持  -->
	<meta content="telephone=no,email=no" name="format-detection">
	<!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
	<!--base css-->
	<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
	<%-- <link rel="stylesheet" href="${webtxc}/css/wap/reset.css" /> --%>
	<link rel="stylesheet" href="${webtxc}/css/wap/personer.css?val=123sd" />
	<%-- <script src="${webtxc}/js/wap/reset.js"></script>
	<script src="${webtxc}/js/wap/TouchSlide.js"></script> --%>
	<script type="text/javascript" src="${webtxc}/myjs/wap/userinfo/modifyUserInfo.js?v=987"></script>
	<style type="text/css">
		img.imgs{margin-top:-15px;height:48px;width:48px;margin-right:5px;clear:both;}
		.fenghang{margin-top:25px}
		body{background:#fff}
	</style>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
</head>

<body>
	<!--wapper-->
	<div class="wapper">
		<!--page-->
		<div id="page">

			<div class="personer_top">
				<h3>修改资料</h3>
				<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
			</div>

			<div class="personer_mes" >
				<div class="nicheng tx-xiugai" >
					<input type="hidden" id="index" value="${param.info}">
					<c:choose>
					       <c:when test="${param.info==1}">
								<img class="imgs" src="${user.userPhoto}" />
								<div class="fenghang">
								<img class="imgs" src="${webtxc}/images/fw_01.jpg" />
								<img class="imgs" src="${webtxc}/images/fw_02.jpg" />
								<img class="imgs" src="${webtxc}/images/fw_03.jpg" />
								<img class="imgs" src="${webtxc}/images/fw_04.jpg" />
								<img class="imgs" src="${webtxc}/images/fw_05.jpg" />
								</div>
								<div class="headimg" >手动上传</div>
					       </c:when>
					       <c:when test="${param.info==2}">
					             <input type="text" id="info" value="${user.logName}"/>
					       </c:when>
					        <c:when test="${param.info==3}">
					             <input type="text" id="info" value="${user.userWechat}"/>
					       </c:when>
					</c:choose>
				</div>
			</div><!--end.personer_mes-->
			<div class="personer_excit">
				<div class="excit" id="save">保存</div>
			</div><!--end.personer_excit-->
		</div>
		<!--page end-->
	</div>
	<!--wapper end-->
	
</body>
	
</html>