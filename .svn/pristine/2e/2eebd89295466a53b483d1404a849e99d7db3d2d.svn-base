<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<head>
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
<meta name="viewport"
	content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
<link rel="stylesheet" href="${webtxc}/css/wap/personer.css" />
<script src="${webtxc}/js/wap/reset.js"></script>
<script src="${webtxc}/js/wap/TouchSlide.js"></script>
<script>

	<%--window.location.href='${codeurl}'--%>

	//定时器每3秒访问后台是否支付完成	    
	$(document).ready(function() {
		setInterval("testState()", 5000);
	});

	var URL = path + "/pay/wxpay/payreturn.html"
	function testState() {
		if ($("#orderId").val() != 0) {
			$.ajax({
				type : "post",
				url : URL + "?orderId=${orderId}",
				success : function(data) {
					var temp = eval(data);
					if (temp == 1) { //订单状态为1表示支付成功
						alert("微信支付成功")
						window.location.href = path
								+ "/saleinfo/orderInfoBuyer/orderView.html"; //页面跳转
					}
				},
				error : function() {
					alert("请求订单状态出错");
				}
			});
		}

	}
</script>


<title>微信支付</title>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
</head>
<body>
	<div class="content">
		<div class="content-right" style="text-align: center">
			<div class="money" style="text-align: center">
				<h3>
					需支付金额：<span>￥ ${price}</span>
				</h3>
				<a>收款方：网站平台</a>
			</div>
			<div class="wx_zf">
				<h3>
					请扫描二维码进行支付，距离二维码过期还剩<span>32</span>秒，过期后请刷新页面重新获取二维码。
				</h3>
				<ul>
					<li style="padding-left: 100px;"><image id="codeurl"
							src="${webtxc}/wap/pay/orderpay/code.html?codeurl=${codeurl}"
							style="height:200px;width:200px;" />
						<p></p></li>
					<li class="zf_right" style="padding-left: 100px;"><img
						src="${webtxc}/images/sys.png"></li>
				</ul>
				<input type="hidden" id="orderId" value="${orderId}" />
			</div>
		</div>
		<!--end.content-right-->

	</div>

	<!--end.content-->


	<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%>
</body>

</html>
