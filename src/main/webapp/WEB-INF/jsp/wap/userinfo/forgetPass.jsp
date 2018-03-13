<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta charset="UTF-8">
	<title>重置密码</title>
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
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	<%-- <link rel="stylesheet" href="${webtxc}/css/wap/reset.css" /> --%>
	<link rel="stylesheet" href="${webtxc}/css/wap/login.css?val=123sd" />
	<%-- <script src="${webtxc}/js/wap/reset.js"></script>
	<script src="${webtxc}/js/wap/TouchSlide.js"></script> --%>
	<script type="text/javascript" src="${webtxc}/myjs/wap/userinfo/forgetPass.js?v=20136331226"></script>
	

	<style>
		.col-sm-2{
			cursor: pointer;
		}
		a{
			text-decoration: none;
		}
		.login{padding-bottom:0}
	
	</style>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
</head>
<body>
	<!--wapper-->
	<div class="wapper">
		<!--page-->
		<div id="page">
			<div class="personer_top">
				<h3>重置密码</h3>
				<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
			</div>
			<!--end.personer_top-->
			<div class="login">
				<ul class="login_dl">
					<li>手机号</li>
					<li class="log_input"><input type="text" id="logCell" placeholder="+86"></li>
				</ul>
				<ul class="login_dl">
					<li>验证码</li>
					<li class="yyz"><input type="text" id="check" placeholder="输入你收到的验证码"></li>
					<li class="yzm"><input  class="hq" style="height:30px;" id="getvalidate" type="button" value="获取验证码"></li>
				</ul>
				<ul class="login_dl">
					<li>重置密码</li>
					<li class="log_input"><input type="password" id="newPass" placeholder="请输入新密码"></li>
				</ul>
				<ul class="login_dl">
					<li>确认密码</li>
					<li class="log_input"><input type="password" id="confirmPass" placeholder="确认密码"></li>
				</ul>
				<div class="shis">密码由6-20位字符组成，区分大小写</div>
				<span id="message" style="position:absolute;height:50px;width:100%;display:none;background:#fff;opacity:0.8;left:0;top:0;text-align:center;line-height:50px;font-size:14px;"></span>
			</div>
			<!--end.login-->
			<div class="personer_excit">
				<a href="javascript:void(0)" style="display:block;" class="excit" id="sub">重置密码</a>
				
			</div>
			<!--end.personer_excit-->
			
		</div>
		<!--page end-->
	</div>
	
	<!--wapper end-->
</body>
</html>
