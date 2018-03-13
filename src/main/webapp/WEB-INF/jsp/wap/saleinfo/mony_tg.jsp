<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
	<head>

		<meta charset="UTF-8">
		<title>支付方式</title>
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<meta content="yes" name="apple-mobile-web-app-capable">
		<!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
		<meta name="apple-touch-fullscreen" content="yes">
		<!-- 开启对web app程序的支持  -->
		<meta content="telephone=no,email=no" name="format-detection">
		<!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
		<!--base css-->
		<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
		<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
		<link rel="stylesheet" href="${webtxc}/css/wap/personer.css?val=124" />
		<script src="${webtxc}/js/wap/reset.js"></script>
		<script src="${webtxc}/js/wap/public.js"></script>
		<script src="${webtxc}/js/wap/TouchSlide.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/wap/saleinfo/mony_tg.js?value=1147"></script>
		<script type="text/javascript">
			var serviceTypetree='${serviceTypetree}';
			var orderNo='${orderInfo.orderNo }';
			var orderId='${orderInfo.orderId }';
			var accBalance='${selectBalanceById.accBalance }';
		</script>
		<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
		<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
	</head>
	<body>
		<div class="wapper">
			<!--page-->
			<div id="page">

				<div class="my_date_bt">

					<div class="service_content">
						<div class="service_content_pj show">
							<div class="personer_mes" style="margin-bottom:0;padding-bottom:0;">
							<c:forEach items="${orderInfo.orderService}" var="orderService">
								<ul class="my_date have_border">
									<li class="my_date_img"><img src="${orderService.serviceInfo.servicePic}"></li>
									<li class="my_date_title">
										<h3>${orderService.serviceInfo.serviceTitle }</h3>
										<p>约${orderService.serviceInfo.serviceMeettime }小时</p>
									</li>
									<li class="my_date_zt">
										<p>待付款</p>
										<span><f:formatDate value="${orderInfo.orderCreatetime }" pattern="yyyy-MM-dd"/></span>
									</li>
								</ul>
								</c:forEach>
							</div>
							<!--end.personer_mes-->

						</div>
						<!--end.service_content_pj-->

					</div>
					<!--end.service_content-->

				</div>
				<!--end.my_date_bt-->
				<div class="zf_fs">
					<h3>选择支付方式：</h3>
					<ul>
					<li class="yue" tag="1"><img src="${webtxc}/images/wap/yue.png"></li>
					<li class="wx" tag="2"><img src="${webtxc}/images/wap/wxzf.png"></li>
					<li class="zfb" tag="3"><img src="${webtxc}/images/wap/zfbf.gif"></li>
					</ul>
				</div>
				<!--end.zf_fs-->
				<div class="zf_hj">
						<ul class="zf_hj_money">
							<li>合计：￥<b id="orderPrice">${orderInfo.orderPrice }</b>
							
							<li  class="sure"><a href="javascript:void(0);">确认</a></li>
						</ul>
					</div>

			</div>
			<!--page end-->
		</div>
		<!--wapper end-->
	</body>

</html>