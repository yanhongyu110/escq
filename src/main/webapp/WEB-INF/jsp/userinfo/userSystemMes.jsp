<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>系统消息</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<script type="text/javascript" src="${webtxc}/js/validate.js"></script>
<link rel="stylesheet" href="${webtxc}/css/public.css" />
<link rel="stylesheet" href="${webtxc}/css/login.css" />
<link rel="stylesheet" href="${webtxc}/css/personal.css" />
<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
<script type="text/javascript" src="${webtxc}/myjs/userinfo/systemMes.js?v=20053006"></script>
<script type="text/javascript">
	var smType = "${smType}";
	var total = "${count}";
</script>
</head>
<body>
	<c:set var="istop" value="true" />
	<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
	<div class="content">
		<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
		<div class="content-right">
			<div class="expert_mes">
				<c:choose>
					<c:when test="${smType==2}">
						<h2>系统消息</h2>
					</c:when>
					<c:when test="${smType==1}">
						<h2>平台消息</h2>
					</c:when>
				</c:choose>
				<%-- <c:choose>
				<c:when test="${empty }">
				
				</c:when>
				
				</c:choose> --%>
				<div id="mesBox" class="news">
					<%-- <ul>
						<c:forEach items="${list}" var="mes">
							<li>
								<div class="news_title">${mes.smTitle}</div>
								<div class="news_time">
									<a href="javascript:void(0)" onclick="del('${mes.smId}')"> 
										<img src="${webtxc}/images/wrong.jpg">
									</a>
								</div>
								<div class="news_content">
									<p style="word-break: break-all">${mes.smContent}</p>
									<p>
										<span>发出日期：${mes.smCreatetimeStr}</span>
									</p>
								</div>
							</li>
						</c:forEach>

					</ul> --%>

				</div>

			</div>
			<!--end.expert_mes-->
			<div id="pageDiv" class="jogger">
				<!-- <span class="disabled">&lt; </span> <span class="current">1</span>
					<a href="#?page=2">2</a> <a href="#?page=3">3</a> <a
						href="#?page=4">4</a> <a href="#?page=5">5</a> <a href="#?page=6">6</a>
					<a href="#?page=7">7</a>... <a href="#?page=199">199</a> <a
						href="#?page=200">200</a> <a href="#?page=2">&gt; </a> -->
			</div>

		</div>
	</div>
	<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>

	<!--end.contain-->
</body>

</html>