<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登录</title>
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
	<link rel="stylesheet" href="${webtxc}/css/wap/login.css" />
	<%-- <script src="${webtxc}/js/wap/reset.js"></script>
	<script src="${webtxc}/js/wap/TouchSlide.js"></script> --%>
	<script type="text/javascript" src="${webtxc}/myjs/wap/userinfo/login.js?v=2016356454463433003"></script>
	<style type="text/css">
		a{
			text-decoration: none;
		}
	</style>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
</head>
<body>
	<!--wapper-->
	<div class="wapper">
		<!--page-->
		<div id="page" >
		<!--  
			<div class="personer_top">
				<h3>登录</h3>
				<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
			</div>-->
			<!--end.personer_top-->
			<div class="login">
				<ul class="login_dl">
					<li>用户名</li>
					<li class="log_input">
						<input type="text" id="logCell" placeholder="请输入正确的用户名"/>
						<input type="text" />
					</li>
					<li class="de_wrong"><img src="${webtxc}/images/wap/wrong.png" onclick="$('#logCell').val('')"></li>
				</ul>
				<ul class="login_dl">
					<li>密码</li>
					<li class="log_input">
						<input type="password" id="logPass" placeholder="请输入正确的密码"/>
						
					</li>
					<li class="de_wrong"><img src="${webtxc}/images/wap/wrong.png" onclick="$('#logPass').val('')"></li>
				</ul>
				
			</div>
			<!--end.login-->
			<div class="login" style="padding:0">
			<ul class="login_dl" style="background:#f8f8f8;border:none;">
					<li class="login_dl_zd"><input type="checkbox" id="check" name="check"/><label for="check">记住密码</label></li>
					<li class="forget"><a  href="${webtxc}/wap/userinfo/logInfo/jumpForgetPass.html">忘记密码？</a></li>
				</ul>
				<span id="message" style="position:absolute;height:50px;width:100%;display:none;background:#fff;opacity:0.8;left:0;top:0;text-align:center;line-height:50px;font-size:14px;"></span>
				</div>
			<div class="personer_excit">
				<a href="javascript:void(0)" class="excit" id="login" style="display:block;">登录</a>
				<input type="hidden" value="${menuTag}" id="menuTag">
			</div>
			<!--end.personer_excit-->
			<div class="p_bttom">
				<p align="center">还没有帐号？ <a href="javascript:void(0)" onclick="register()">立即注册</a></p>

				<div class="dl_qt">
					<a class="qq_dl" style="margin-right:0;"></a>
					<a class="wx_dl"></a>
				</div>
			</div>
		</div>
		<!--page end-->
	</div>
	<!--wapper end-->
	<%-- <%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%> --%>
</body>
</html>