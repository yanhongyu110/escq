<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
	<head>

		<meta charset="UTF-8">
		<title>我的预约</title>
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

		<link rel="stylesheet" href="${webtxc }/css/wap/personer.css" />
		<link rel="stylesheet" href="${webtxc}/css/page.css" />
		<link rel="stylesheet" href="${webtxc}/css/wap/paging.css" />

		
		<script src="${webtxc }/js/wap/reset.js"></script>
		<script src="${webtxc }/js/wap/jquery.min.js"></script>
		<script src="${webtxc }/js/wap/TouchSlide.js"></script>
		<script type="text/javascript">
			var serviceTypetree = '${serviceTypetree}';
			var serviceId = '${serviceVo.serviceId}';
		</script>
		<script type="text/javascript" src="${webtxc }/js/wap/common.js"></script>
		<script src="${webtxc }/myjs/wap/saleinfo/my_date.js?v=123123188823123"></script>
		<script src="${webtxc }/js/wap/paging.js"></script>

		<script>
			$(function() {
				//设计案例切换
				$('.title-list li').click(function() {
					var liindex = $('.title-list li').index(this);
					$(this).addClass('on').siblings().removeClass('on');
					/* $('.service_content div.service_content_pj').eq(liindex).fadeIn(150).siblings('div.service_content_pj').hide(); */
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
		<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
	</head>

	<body>
		<!--wapper-->
		<div class="wapper">
			<!--page-->
			<div id="page">
				
				<div class="my_date_bt">
					<div class="title cf">
						<ul class="title-list fr cf ">
							<li id="li1" class="on">全部</li>
							<li id="li3">代付款</li>
							<li id="li5">待评价</li>
							<p></p>
						</ul>
					</div>
					<div class="service_content">
						<div class="service_content_pj show">
							<div id="personer_mes" class="personer_mes">
							</div>
							<!--end.personer_mes-->

						</div>


					</div>
					<!--end.service_content-->

				</div>
				<!--end.wap_service_xq-->
			<div id="gengduo"></div>
			</div>
			<!--page end-->
		</div>
		<!--wapper end-->
		<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%>
	</body>

</html>