<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>个人资料</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
<%@ include file="/WEB-INF/jsp/common/kindeditor.jsp"%>
<script type="text/javascript" src="${webtxc}/js/validate.js"></script>
<script type="text/javascript"
	src="${webtxc}/myjs/userinfo/showUserInfo.js?tag=2016212pm"></script>


<link rel="stylesheet" href="${webtxc}/css/public.css" />
<link rel="stylesheet" href="${webtxc}/css/login.css" />
<link rel="stylesheet" href="${webtxc}/css/personal.css" />

<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>

</head>

<body>
	<c:set var="istop" value="true" />
	<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
	<div class="content">
		<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
		<div class="content-right">
			<div class="expert_mes">
				<h2>个人资料</h2>

				<div class="my_zl_gr">

					<ul>
						<li class="mc">手机号：</li>
						<li><input  type="text" class="gr_input" id="logCell1"
							placeholder="请输入正确的手机号" value="${user.logCell}" disabled="true"　readOnly="true" /></li>
						<!-- <li class="xg">更改手机号</li> -->
					</ul>
					<ul>
						<li class="mc">昵称：</li>
						<li><input type="text" class="gr_input" id="logName1"
							placeholder="请输入昵称" value="${user.logName}" /></li>
					</ul>
					<ul>
						<li class="mc">真实姓名：</li>
						<li><input type="text" class="gr_input" id="userRealName1"
							value="${user.userRealName}"disabled="true"　readOnly="true" /></li>

					</ul>
					<ul>
						<li class="mc">微信号：</li>
						<li><input type="text" class="gr_input" id="userWechat1"
							placeholder="请输入微信号" value="${user.userWechat}"></li>

					</ul>
					<ul>
						<li class="mc">个人头像：</li>
						<li>
						<div id="imgsShow" class="tx_scs upload">
							<img class="imgshow" src="${user.userPhoto}" />
							</div>
							<div class="tts_gr">请上传尺寸为<font>100X100</font>的jpg\png照片
							</div>
						<input type="hidden" id="info_icon" value="${user.userPhoto}" />
						
						</li>

					</ul>
					<ul>
						<li class="mc"></li>
						<li class="my_zl_bc" id="sub">保存</li>


					</ul>

				</div>
				<!--end.my_zl_gr-->


			</div>
			<!--end.expert_mes-->



		</div>
		<!--end.content-right-->
	</div>
	<!--end.content-->
	<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%></div>
	<!--end.contain-->
</body>

</html>