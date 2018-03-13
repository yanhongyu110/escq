<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

	<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
	<link rel="stylesheet" href="${webtxc}/css/wap/personer.css?v=1231231e2" />
	<link rel="stylesheet" href="${webtxc}/css/wap/personerAdmin.css?v=1423" />
	<script src="${webtxc}/js/wap/reset.js"></script>
	<script src="${webtxc}/js/wap/TouchSlide.js"></script>
    <script type="text/javascript" src="${webtxc}/jquery/jquery-1.11.1.min.js"></script>


	<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
</head>

<body>
<!--wapper-->
<div class="wapper">
	<!--page-->
	<div id="page">
		<div class="personer_top">
				<h3>我的预约</h3>
				<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
		</div>
		<div class="personer_mes">

			<%--<ul class="list_mes have_margin have_border">--%>
				<%--<li class="home"><a href="personer_home.html">我的主页</a></li>--%>
				<%--<li class="mm"><img src="../images/more.png"></li>--%>
			<%--</ul>--%>

			<%-- 我的预约 --%>
			<ul class="list_mes clearfix" onclick="window.location.href=path+'/wap/saleinfo/orderInfoBuyer/orderView.html'"><li>发出的预约</li><li class="mm"><img src="${webtxc}/images/wap/more.png"></li></ul>
			<ul class="list_mes clearfix" onclick="window.location.href=path+'/wap/saleinfo/orderInfoSeller/viewOrder.html'"><li>收到的预约</li><li class="mm"><img src="${webtxc}/images/wap/more.png"></li></ul>


			<c:if test="${sessionScope.wxFlag==1}">
				<div class="personer_excit" >
					<div class="excit" id="logout1" onclick="window.location.href=path+'/wap/userinfo/logInfo/logOut.html'">退出登录</div>
				</div>
			</c:if>


			<%--<ul class="list_mes">--%>
				<%--<li class="souc">我的收藏</li>--%>
				<%--<li class="mm"><img src="../images/more.png"></li>--%>
			<%--</ul>--%>
            <%----%>

			<%--<ul class="list_mes">--%>
				<%--<li class="zp">我的作品</li>--%>
				<%--<li class="mm"><img src="../images/more.png"></li>--%>
			<%--</ul>--%>
			


			<%--<ul class="list_mes">--%>
				<%--<li class="news">系统消息</li>--%>
				<%--<li class="mm"><img src="../images/more.png"></li>--%>
			<%--</ul>--%>

			<%--<ul class="list_mes have_margin have_border">--%>
				<%--<li class="setting">系统设置</li>--%>
				<%--<li class="mm"><img src="../images/more.png"></li>--%>
			<%--</ul>--%>

		</div><!--end.personer_mes-->
	</div>
	<!--page end-->
</div>
<!--wapper end-->
<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%>
</body>

</html>