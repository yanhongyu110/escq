<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">

<%@ include file="/WEB-INF/jsp/common/header.jsp"%>

<link rel="stylesheet" href="${webtxc}/css/public.css" />
<link rel="stylesheet" href="${webtxc}/css/personal.css" />
<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
<script type="text/javascript" src="${webtxc}/js/validate.js"></script>
<script type="text/javascript"
	src="${webtxc}/myjs/userinfo/modifyPass.js?v=2016053004"></script>
<!-- <link rel="stylesheet" href="../css/public.css" />
<link rel="stylesheet" href="../css/personal.css" />
<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="../js/personal_tab.js"></script>
<script type="text/javascript" src="../js/personal_menu.js"></script>
-->
</head> 
<body>
	<c:set var="istop" value="true" />
	<%@include file="/WEB-INF/jsp/common/top.jsp"%>
		<!--end.personal-->
		<div class="content">
			<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
			<div class="content-right">
				<div class="expert_mes">
					<h2>修改密码</h2>

					<div class="my_zl_gr">

						<ul>
							<li class="mc">手机号码：</li>
							<li><input type="text" id="logCell" class="gr_input" value="${logInfo.logCell}"disabled="true"　readOnly="true"/></li>
							<li class="hq_yzm" id="getvalidate">获取验证码</li>

						</ul>
						<ul>
							<li class="mc">手机验证码：</li>
							<li><input type="text" id="gbcheck" placeholder="请输入正确的验证码" class="gr_input" /></li>
						</ul>
						<ul>
							<li class="mc">新密码：</li>
							<li><input type="password" class="gr_input" id="newPass"
								placeholder="至少输入8个字符"/></li>

						</ul>
						<ul>
							<li class="mc">确认密码：</li>
							<li><input type="password" class="gr_input" id="confirmPass"
								placeholder="至少输入8个字符"/></li>

						</ul>


						<ul>
							<li class="mc"></li>
							<li class="my_zl_bc" id="sub">修改</li>


						</ul>

					</div>
					<!--end.my_zl_gr-->


				</div>
				<!--end.expert_mes-->



			</div>
			<!--end.content-right-->
		</div>
		<!--end.content-->
		<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
	<!--end.contain-->
</body>

</html>