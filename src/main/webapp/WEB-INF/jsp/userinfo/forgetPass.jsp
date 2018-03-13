<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>忘记密码</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<link rel="stylesheet" href="${webtxc}/css/public.css" />
<link rel="stylesheet" href="${webtxc}/css/login.css" />
<script type="text/javascript"
	src="${webtxc}/js/validate.js"></script>
<script type="text/javascript"
	src="${webtxc}/myjs/userinfo/forgetPass.js?v=20161sd26"></script>
<style>
.col-sm-2{
cursor: pointer;
}
</style>
</head>
<body>
	<div class="contain">
		<%@include file="/WEB-INF/jsp/common/top.jsp"%>
		<div class="content">
			<div class="forgetpassword">
				<h2>忘记密码</h2>
				<div class="forgetpassword_mes">
					<div class="forgetpassword_phone">
						<label class="col-sm-1 ">手机号</label>
						<div class="col-sm-2">
							<input type="text" id="logCell" class="control-label"  placeholder="请输入正确的手机号" />
							<!-- <div class="close"></div> -->
						</div>
						<div class="phone_ts" id="message1"></div>
					</div>
					<!--end.forgetpassword_phone-->
					<div class="forgetpassword_code">
						<label class="col-sm-1 ">验证码</label>
						<div class="col-sm-2">
							<input type="text" class="control-label" id="check" placeholder="请输入正确的验证码"  />
							<input type="button" class="code" id="getvalidate" value="获取验证码" />
						</div>
						<div class="phone_ts"></div>
					</div>
					<div class="forgetpassword_new">
						<label class="col-sm-3 ">重置密码</label>
						<div class="col-sm-4">
							<input type="password" class="control-label" id="newPass" placeholder="至少输入6个字符" />
							<div class="close"></div>
						</div>
						<div class="phone_ts"></div>
					</div>
					<div class="forgetpassword_new_sure">
						<label class="col-sm-5 ">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="control-label" id="confirmPass" placeholder="至少输入6个字符" />
							<div class="close" id="close"></div>
						</div>
						<div class="phone_ts"></div>
					</div>
					<div class="forgetpassword_btn">
						<a class="button" id="sub">确 定</a>
					</div>
					<div class="forgetpassword_fh">
						<a href="${webtxc}/userinfo/logInfo/jumpLogin.html?comId=${sessionScope.company.compId}">登录</a> | <a href="${webtxc}/userinfo/logInfo/jumpRegister.html?comId=${sessionScope.company.compId}">注册</a>
					</div>
				</div>
			</div>
		</div>
		<!--end.content-->
		<jsp:include page="/WEB-INF/jsp/common/bottom.jsp" />
	</div>
	<!--end.contain-->
</body>
</html>
