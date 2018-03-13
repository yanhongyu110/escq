<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>需求管理</title>
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
    	<%@ include file="/WEB-INF/jsp/common/easyui.jsp" %>
    	<%@ include file="/WEB-INF/jsp/common/kindeditor.jsp" %>
		<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
		<link rel="stylesheet" href="${webtxc}/css/wap/personer.css"/>
		<script src="${webtxc}/js/wap/reset.js"></script>
		<script src="${webtxc}/js/wap/TouchSlide.js"></script>
		<script src="${webtxc}/myjs/wap/demand/demandList.js?v=12"></script>
		<script>
			$(function() {
				//设计案例切换
				$('.title-list li').click(function() {
					var liindex = $('.title-list li').index(this);
					$(this).addClass('on').siblings().removeClass('on');
					$('.service_content div.service_content_pj').eq(liindex).fadeIn(150).siblings('div.service_content_pj').hide();
					var liWidth = $('.title-list li').width();
					$('.my_date_bt .title-list p').stop(false, true).animate({
						'left': liindex * liWidth + 'px'
					}, 300);
				});

			});
		</script>
	</head>
    <style>.more{text-align: center;padding-top: 20px;}</style>
	<body>
		<!--wapper-->
		<div class="wapper" style="padding-bottom: 60px;">
			<!--page-->
			<div id="page">
				<div class="personer_top">
					<h3>需求列表</h3>
					<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
				</div>
				<div class="my_date_bt">
					<div class="title cf">
						<ul class="title-list fr cf ">
							<li class="on" data-id="2">通过</li>
							<li data-id="3">未通过</li>
							<li data-id="1">审核中</li>
							<p></p>
						</ul>
					</div>
					<div class="service_content">
						<div class="service_content_pj show" id="service_content_pj">
							<!--end.personer_mes-->
						</div>
						<!--end.service_content_pj-->
						<div class="more"><a id="more" class="btn"></a></div>
					</div>
					<!--end.service_content-->
				</div>
				<!--end.wap_service_xq-->
			</div>
			<!--page end-->
		</div>
		<!--wapper end-->
	<%-- <%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%> --%>
	</body>

</html>