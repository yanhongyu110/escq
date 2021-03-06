<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>需求列表</title>
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
	</head>

	<body>
		<!--wapper-->
		<div class="wapper">
			<!--page-->
			<div id="page">
				<div class="personer_top">
					<h3>需求列表</h3>
					<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
				</div>
				<!--头部-->
				<div class="header">
					<div class="loimg"></div>
					<div class="seach"><input type="text" value="搜索服务 如：“产品经理” " class="sou"></div>
					<div class="new"><a>12</a></div>
				</div>
				<div class="nav_list">
					<ul>
						<li  class="on1">首页</li>
						<li>策划</li>
						<li>产品设计</li>
						<li>美工设计</li>
						<li>技术开发</li>
					</ul>
				</div>
				<!--end.nav_list-->
				<div class="nav_list_sai">
					<!-- <ul>
						<li>约见最多</li>
						<li class="ond">口碑最好</li>
						<li>价格最高</li>
					</ul> -->
				</div>
				<div class="content_list">
					<div class="service_list">
						<div class="service_list_img">
							<img src="images/fw_01.jpg" />
						</div>
						<div class="service_list_title">
							<h3>营销型网站策划</h3>
							<font>高级资深策划</font>
							<b>￥120.00</b>
							<span>112人约见</span>					
						</div>
					</div><!--end.service_list-->
					<div class="service_list">
						<div class="service_list_img">
							<img src="images/fw_02.jpg" />
						</div>
						<div class="service_list_title">
							<h3>营销型网站策划</h3>
							<font>高级资深策划</font>
							<b>￥120.00</b>
							<span>112人约见</span>					
						</div>
					</div><!--end.service_list-->
					<div class="service_list">
						<div class="service_list_img">
							<img src="images/fw_03.jpg" />
						</div>
						<div class="service_list_title">
							<h3>营销型网站策划</h3>
							<font>高级资深策划</font>
							<b>￥120.00</b>
							<span>112人约见</span>					
						</div>
					</div><!--end.service_list-->
					<div class="service_list">
						<div class="service_list_img">
							<img src="images/fw_04.jpg" />
						</div>
						<div class="service_list_title">
							<h3>营销型网站策划</h3>
							<font>高级资深策划</font>
							<b>￥120.00</b>
							<span>112人约见</span>					
						</div>
					</div><!--end.service_list-->
					<div class="service_list">
						<div class="service_list_img">
							<img src="images/fw_02.jpg" />
						</div>
						<div class="service_list_title">
							<h3>营销型网站策划</h3>
							<font>高级资深策划</font>
							<b>￥120.00</b>
							<span>112人约见</span>					
						</div>
					</div><!--end.service_list-->
					<div class="service_list">
						<div class="service_list_img">
							<img src="images/fw_03.jpg" />
						</div>
						<div class="service_list_title">
							<h3>营销型网站策划</h3>
							<font>高级资深策划</font>
							<b>￥120.00</b>
							<span>112人约见</span>					
						</div>
					</div><!--end.service_list-->
					<div class="jiaz">
					加载更多...
				</div>
				</div><!--end.content_list-->
				

				
				

			</div>
			<!--page end-->
		</div>
		<!--wapper end-->

	</body>

</html>