<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<html> 

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
		<title>关注我的用户</title>
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<script>
			var count=${infos.totalSize}
			var pageNo=${infos.page}
			var foculen=${fn:length(infos.list)};
		</script>
		<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/bizinfo/focuusers.js?v=234gfg"></script>
		
	</head>

	<body>
			<c:set var="istop" value="true" />
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>
			<%-- <input id="serviceId" type="hidden" value="${info.list[0].serviceId}" />
			<input id="logId" type="hidden" value="${info.list[0].logId}" />
			<input id="jso" type="hidden" value="${info.list[0].scartComment}" />
			<input id="cartId" type="hidden" value="${info.list[0].scartId}" />  --%>
			
			<div class="content">
				<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
				<div class="content-right">
				
					<div class="my_like">
						<h2>关注我的用户</h2>
						<c:forEach var="focus" items="${infos.list}">
							<div class="my_focus_list" >
								<input type="hidden" class="futpUser" value="${focus.futpUser}" />
								<input type="hidden" class="futpProvider" value="${focus.futpProvider}" />
								<div class="my_focus_list_img">
									<img src="${focus.userPhoto}" />
									<h3>${focus.logName }</h3>
								</div>
								
							</div><!--end.my_like_list-->
						
						</c:forEach>
						
						
					</div><!--end.my_like-->

					
				</div>

				<!--end.content-right-->
			</div>
			<!--end.content-->
			
			<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
		<!--end.contain-->
	</body>

</html>