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
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<link rel="stylesheet" href="${webtxc}/css/public.css" />
<link rel="stylesheet" href="${webtxc}/css/login.css" />
<script type="text/javascript" src="${webtxc}/myjs/userinfo/login.js?v=2016053003"></script>
</head>
<body>
	<c:set var="istop" value="false" />
	<%@include file="/WEB-INF/jsp/common/top.jsp"%>
	<div class="content">
		<div class="login">
			<div class="login_left">

				<div class="login_left_mes">
					<div class="login_left_phone">
						<label class="col-sm-1 ">账号</label>
						<div class="col-sm-2">
							<input type="text" class="control-label" id="logCell" placeholder="请用手机号、邮箱或者昵称登录" />
							<div class="close"></div>
						</div>
						<div class="phone_ts" id="message1"></div>
					</div>
					<!--end.register_left_phone-->
					<div class="login_left_password">
						<label class="col-sm-3 ">密码</label>
						<div class="col-sm-4">
							<input type="password" id="logPass" class="control-label" placeholder="至少输入8个字符" />
							<div class="close"></div>
						</div>
						<div class="phone_ts" id="message2"></div>
					</div>


					<div class="login_agrees">
						<label><input type="checkbox" id="check">记住密码</label> <a
							class="forget_password" href="${webtxc}/userinfo/logInfo/jumpForgetPass.html?comId=${sessionScope.company.compId}">忘记密码？</a>
					</div>
					<!--end.agrees-->
					<div class="login_btn_button">
						<a class="button" id="login">登 录</a>
					</div>
				</div>
			</div>
			<div class="login_right">
				<h2>
					还没有帐号？ 立即 <a onclick="register()">注册</a> 帐号
				</h2>

				<a class="login_right_btn" onclick="register()">注册账号</a>
				<div class="login_right_qt">
					<a><span>无需注册，直接用社交账号登录</span></a> <a class="wx_dl">微信登录</a> <a href="javascript:toLogin();"
						class="qq_dl">QQ登录</a>
				</div>
								<script type="text/javascript">
					$(function(){
						var redirect_uri = encodeURIComponent("http://www.jindaoj.com/weiXinLogin/getCode.html");
						var url = "https://open.weixin.qq.com/connect/qrconnect?appid=wxded1f8728c67ab10&redirect_uri="+redirect_uri+"&response_type=code&scope=snsapi_login&state=STATE#wechat_redirect";
						$('.wx_dl').attr("href",url);
					})
					
					/**
					 * qq登录
					 */
					function toLogin(){
						window.location.href = "${webtxc}/qqLogin/getCode.html";
					 } 
				</script>
			</div>
		</div>



	</div>
	<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
</body>
</html>