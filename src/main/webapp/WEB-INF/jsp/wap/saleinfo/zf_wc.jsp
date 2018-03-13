<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>完成服务</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	<script>
		var serviceTypetree="";
	</script>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta content="always" name="referrer"><%-- webkit|ie-comp|ie-stand --%>
	<meta charset="utf-8">
	<script type="text/javascript" src="${webtxc}/jquery/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${webtxc}/jquery/jquery.cookie.js"></script>
	<script type="text/javascript" src="${webtxc}/jquery/jquery.md5.js"></script>
	<script type="text/javascript" src="${webtxc}/js/validate.js"></script>
	<script type="text/javascript" src="${webtxc}/js/common.js?v=20160111"></script>
	<link rel="stylesheet" href="${webtxc}/css/tankuang.css" />
	<link rel="shortcut icon" type="image/x-icon" href="${webtxc}/favicon.ico" />
	<link rel="stylesheet" href="${webtxc}/css/public.css"/>
<meta content="yes" name="apple-mobile-web-app-capable">
<!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
<meta name="apple-touch-fullscreen" content="yes">
<!-- 开启对web app程序的支持  -->
<meta content="telephone=no,email=no" name="format-detection">
<!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
<!--base css-->
<meta name="viewport"
	content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
    <%--<script type="text/javascript" src="${webtxc}/jquery/jquery-1.11.1.min.js"></script>--%>
    <%--<script type="text/javascript" src="${webtxc}/jquery/jquery.md5.js"></script>--%>
    <%--<script type="text/javascript" src="${webtxc}/js/validate.js"></script>--%>
    <%--<script type="text/javascript" src="${webtxc}/js/common.js?v=20160111"></script>--%>
<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
<link rel="stylesheet" href="${webtxc}/css/wap/personer.css" />
<script src="${webtxc}/js/wap/reset.js"></script>
<script src="${webtxc}/js/wap/TouchSlide.js"></script>
<script type="text/javascript"
	src="${webtxc}/myjs/wap/saleinfo/zf_wc.js?v=1231231"></script>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
	<script>
		var flag = '${flag}';
	</script>
</head>

<body>
	<!--wapper-->
	<div class="wapper">
		<!--page-->
		<div id="page">
			<div class="zh_zf">
				<ul>
					<%--<li>账户余额：<span>￥${selectBalanceById.accBalance }</span></li>--%>
					<li>订单号：<b id="orderNo">${orderInfo.orderNo }</b></li>
				</ul>
				<c:forEach items="${orderInfo.orderService}" var="orderService">
					<span style="display: none;" id="title">${orderService.serviceInfo.serviceTitle }</span>
				</c:forEach>
			</div>
			<div class="my_zh_qtfs">

				<ul>
					<li>交易密码：</li>
					<li class="sr"><input type="password" id="accPaypass" ></li>
					<li class="forget-password" onclick="window.location.href=path+'/wap/details/AccountPaymentDetails/showIODetails.html?logId=${orderInfo.orderBuyer}'">忘记密码？</li>
				</ul>
			</div>

			<div class="zf_hj">
				<ul class="zf_hj_money">
					<li>合计：￥<b id="orderPrice">${orderInfo.orderPrice }</b>
					<li id="btn_tx" class="sure">确认</li>
				</ul>
			</div>

		</div>
		<!--page end-->
	</div>
	<!--wapper end-->

</body>

</html>