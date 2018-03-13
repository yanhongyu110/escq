<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">   
<title>注册</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<link rel="stylesheet" href="${webtxc}/css/public.css" />
<link rel="stylesheet" href="${webtxc}/css/login.css" />
<script type="text/javascript"
	src="${webtxc}/myjs/userinfo/register.js?v=20160542123123333004"></script>
	<script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" charset="utf-8"></script>  
	
</head>
<body>
	<%@include file="/WEB-INF/jsp/common/top.jsp"%>
	<div class="content">
		<div class="register">
			<div class="register_left">

				<div class="register_left_mes">
					<div class="register_left_phone">
						<label class="col-sm-1 ">手机号</label>
						<div class="col-sm-2">
							<input type="text" class="control-label" id="logCell" placeholder="请输入正确的手机号" />
							<div class="close"></div>
						</div>
						<div class="phone_ts" id="message1"></div>
					</div>
					<!--end.register_left_phone-->
					<div class="register_left_phone_yzm">
						<label class="col-sm-1 ">验证码</label>
						<div class="col-sm-2">
							<input type="text" id="checkcode" class="control-label"
								placeholder="请输入正确的手机验证码" /> <input type="button" id="button" style="height: 48px" class="code"
								value="获取验证码" />
							<div class="close"></div>
						</div>

						<div class="phone_ts" id="message2"></div>
					</div>
					<!--end.register_left_phone_yzm-->
					<div class="register_left_password">
						<label class="col-sm-3 ">密码</label>
						<div class="col-sm-4">
							<input type="password" id="logPass" class="control-label" placeholder="至少输入6个字符" />
							<div class="close"></div>
						</div>
						<div class="phone_ts" id="message3"></div>
					</div>
					<div class="register_left_querenpassword">
						<label class="col-sm-5 ">确认密码</label>
						<div class="col-sm-6">
							<input type="password" id="savelogPass" class="control-label" placeholder="至少输入6个字符" />
							<div class="close"></div>
						</div>
						<div class="phone_ts" id="message4"></div>
					</div>
					<div class="register_left_identifying" style="height: 70px">
						<label class="col-sm-7 ">验证码</label>
						<div class="col-sm-8">
							<input type="text" id="imagesCode" class="control-label"
									placeholder="图片验证码(点击图片更换)，不区分大小写" /> <a id="refresh"><img
									src="${webtxc}/userinfo/logInfo/getImagesCode.html" id="image" class="code"></a>
						</div>
						<div class="phone_ts" id="message5"></div>
					</div>
					<div class="agrees">
						<label><input type="checkbox" id="checkbox">我已阅读并同意</label> <a>《近到家互联网专家平台服务协议》</a>
					</div>
					<!--end.agrees-->
					<div class="register_btn">
						<a class="button" href="javascript:intoRegister()" id="register" style="background: #999">注 册</a>
					</div>
				</div>
			</div>
			<div class="register_right">
				<h2>
					已经注册过帐号？ 立即 <a onclick="login()">登录</a>
				</h2>
				<a class="register_right_btn" onclick="login()">登录账号</a>
				<div class="register_right_qt">
					<!-- <a><span>使用其他账号直接登录：</span></a> <a class="wx_dl">微信登录</a> <a
						class="qq_dl">QQ登录</a> -->
				</div>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
</body>
</html>