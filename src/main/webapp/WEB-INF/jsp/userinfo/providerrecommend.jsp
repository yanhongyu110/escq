<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推荐专家</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<script type="text/javascript" src="${webtxc}/jquery/jquery-1.11.1.js"></script>
<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
<%@ include file="/WEB-INF/jsp/common/kindeditor.jsp"%>
<link rel="stylesheet" href="${webtxc}/css/public.css" />
<link rel="stylesheet" href="${webtxc}/css/personal.css" />
<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
<script type="text/javascript"
	src="${webtxc}/myjs/userinfo/providerrecommend.js?tag=201212pm"></script>
<script type="text/javascript" src="${webtxc}/js/validate.js"></script>
</head>
<body>
	<c:set var="istop" value="true" />
	<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
	<div class="content">
		<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
		<div class="content-right">

			<!--end.status_icon-->


			<div class="my_apply_clear"></div>
			<c:choose>
				<c:when test="${empty providerRecommend}">
					<div class="my_apply">
						<h2>推荐资料</h2>
						<div class="status_icon">
							<p class="progress_bar"></p>
							<div class="status_progress status_one on ">
								<div class="steps">
									1
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">平台筛选</div>
							</div>
							<div class="status_progress status_two on">
								<div class="steps">
									2
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">专家确认</div>
							</div>
							<div class="status_progress status_three ">
								<div class="steps">
									3
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">平台审核</div>
							</div>
							<div class="status_progress status_four">
								<div class="steps">
									4
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">成功推荐</div>
							</div>

						</div>
						<div class="note_message">
							<ul>
								<li class="mes">个人说明：</li>
								<li><textarea cols="54" rows="7" id="providerDetails">请填写您的个人说明，文字尽量精练。...</textarea>
								</li>
								<li class="zp_ts">字数不超过<span>200</span>个字。
								</li>
							</ul>
							<ul class="havepadding">
								<li class="mes">展示照片：</li>
								<li class="expert_mp"><a id="imageKE"><img class="imgshow" /></a></li>
								<li class="fll">请上传代表您个人形象的生活照片，照片大小不超过<span>1M</span>，推荐尺寸：<span>100pxX200px</span>。
									<input type="hidden" id="info_icon" />
								</li>
							</ul>
							<ul class="hpadding">
								<li class="mes"></li>
								<li>
									<div class="mes_btn_wc nomargin-left" id="btn">提交审核</div>

								</li>

							</ul>
						</div>
				</c:when>
				<c:when test="${providerRecommend.prState==1}">
					<div class="my_apply">
						<h2>推荐资料</h2>
						<div class="status_icon">
							<p class="progress_bar"></p>
							<div class="status_progress status_one on ">
								<div class="steps">
									1
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">平台筛选</div>
							</div>
							<div class="status_progress status_two on">
								<div class="steps">
									2
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">专家确认</div>
							</div>
							<div class="status_progress status_three on">
								<div class="steps">
									3
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">平台审核</div>
							</div>
							<div class="status_progress status_four on">
								<div class="steps">
									4
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">成功推荐</div>
							</div>

						</div>
						<div class="mes_tg"><h3></h3></div>
						
				</c:when>
				<c:when test="${providerRecommend.prState==0}">
					<div class="my_apply">
						<h2>推荐资料</h2>
						<div class="status_icon">
							<p class="progress_bar"></p>
							<div class="status_progress status_one on ">
								<div class="steps">
									1
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">平台筛选</div>
							</div>
							<div class="status_progress status_two on">
								<div class="steps">
									2
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">专家确认</div>
							</div>
							<div class="status_progress status_three on">
								<div class="steps">
									3
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">平台审核</div>
							</div>
							<div class="status_progress status_four on">
								<div class="steps">
									4
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">成功推荐</div>
							</div>

						</div>
						<div class="mes_sh"></div>
				</c:when>
				<c:when test="${providerRecommend.prState==2}">
					<div class="my_apply">
						<h2>推荐资料</h2>
						<div class="status_icon">
							<p class="progress_bar"></p>
							<div class="status_progress status_one on ">
								<div class="steps">
									1
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">平台筛选</div>
							</div>
							<div class="status_progress status_two on">
								<div class="steps">
									2
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">专家确认</div>
							</div>
							<div class="status_progress status_three on">
								<div class="steps">
									3
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">平台审核</div>
							</div>
							<div class="status_progress status_four">
								<div class="steps">
									4
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">成功推荐</div>
							</div>

						</div>
						<div class="mes_sh">
							审核未通过<a href="javascript:void(0)" onclick="ret()">点击这里</a>重新填写资料
						</div>
				</c:when>
			</c:choose>


		</div>
		<!--end.my_like-->
	</div>
	<!--end.content-right-->
	</div>
	<!--end.content-->
	<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>
	<!--end.contain-->
</body>

</html>