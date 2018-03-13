<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>消息</title>
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
		<link rel="stylesheet" href="${webtxc }/css/wap/reset.css" />
		<link rel="stylesheet" href="${webtxc}/css/wap/personer.css" />
		<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
		<script src="${webtxc }/js/wap/reset.js"></script>
		<script src="${webtxc }/js/wap/TouchSlide.js"></script>
		<script type="text/javascript" src="${webtxc }/js/wap/common.js"></script>
		<link rel="stylesheet" href="${webtxc}/css/wap/userSystemMes.css?val=134" />
		<link rel="stylesheet" href="${webtxc}/css/wap/personer.css" />
		<script type="text/javascript" src="${webtxc }/myjs/wap/userinfo/userSystemMes.js"></script>
		<script>
			$(function() {
				if($("#smType").val()==1){
					$(".title-list li:eq(1)").addClass("on");
					$(".title-list li:eq(0)").removeClass("on");
					var liWidth = $('.title-list li').width();
					$(".title-list p").css({'left':liWidth + 'px'});
					
				}
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

				//设计案例hover效果
				$('.service_content .service_content_pj li').hover(function() {
					$(this).css("border-color", "#ff6600");
					$(this).find('p > a').css('color', '#ff6600');
				}, function() {
					$(this).css("border-color", "#fafafa");
					$(this).find('p > a').css('color', '#666666');
				});
			});
		</script>
	</head>

	<body>
		<input id="smType" type="hidden" name="smType" value="${smType}">
		<input id="pageNo" type="hidden" name="pageNo" value="${pageNo}">
		<!--wapper-->
		<div class="wapper">
			<div class="personer_top">
				<h3>消息</h3>
				<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
			</div>
			<!--page-->
			<div id="page" style="position: relative">


				
				<div class="my_date_bt">
					<div class="title cf" style="position: relative">
						<ul class="title-list fr cf ">
							<li class="on" style="width:50%;" data-type="2" onclick="selectCommonAjax(1,2)">系统消息</li>
							<li style="width:50%;" data-type="1" onclick="selectCommonAjax(1,1)">平台消息</li>
							<p style="width:50%;"></p>
						</ul>
					</div>
					<div class="service_content" >
						<!-- 系统消息 -->
						<div id="ms2" class="service_content_pj show">
							<div class="personer_mes">
							</div>
							<!--end.personer_mes-->
						</div>
						<!--end.service_content_pj-->
						<!-- 平台消息 -->
						<div id="ms1" class="service_content_pj">
							<div class="personer_mes">
							</div>
						</div>
						<!--end.service_content_pj-->
						<div class="loading"></div>
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