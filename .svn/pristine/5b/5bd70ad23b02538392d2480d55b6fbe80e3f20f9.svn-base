<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<html> 

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
		<title>我的关注</title>
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<script>
			var count=${infos.totalSize}
			var pageNo=${infos.page}
		</script>
		<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/bizinfo/myfocus.js?v=asx6xcasf45dg"></script>
		
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
						<h2>我的关注</h2>
						<c:forEach var="focus" items="${infos.list}">
							<div class="my_focus_lists"  >
								<input type="hidden" class="futpUser" value="${focus.futpUser}" />
								<input type="hidden" class="futpProvider" value="${focus.futpProvider}" />
								<input type="hidden" class="piId" value="${focus.piId}">
								<div class="my_focus_lists_img" onclick="window.location.href=path+'/userinfo/providerdetails/preproviderdetails.html?logId=${focus.futpProvider}'+'&comId='+g_comid">
									<img src="${focus.piPhoto}"  />
								</div>
								<div class="my_focus_lists_title fo_da">
									<h3>${focus.piRealname }<i>${focus.piArea}</i></h3>
									<p>${focus.piPosition }</p>
									<span>工作${focus.piWorkyear}年</span>
									<span>约见${focus.piMeetnum}次</span>
									<span>服务${focus.piDealnum}次</span>
									<%-- <span>平均响应时间：${focus.piResponsetime}</span> --%>
									<span>评分${focus.piMark}</span>
									
									<%-- <p cut="20"> 关键字：${focus.piKeywords}</p> --%>
								</div>
								<div class="my_focus_lists_delete">
									<a href="javascript:void(0)" onclick="del(this)" class="delete_btn">删除关注</a>
									<a href="javascript:void(0)"  class="delete_yy">查看详情</a>
								</div>
							</div><!--end.my_like_list-->
						
						</c:forEach>

						<script>
							$('p[cut]').each(function(){
									var text = $(this).text();
									if (text.length > 50){
										$(this).text($(this).text().substring(0,50)+"...")
									}
							})
							$('.delete_yy').each(function(){
								var obj=$(this)
								obj.click(function(){
									var pp=obj.parents(".my_focus_lists")
									var logId=pp.find('.futpProvider').val()
									window.location.href=path+'/userinfo/providerdetails/preproviderdetails.html?logId='+logId+'&comId='+g_comid;
								})
							})
						</script>
						
						
					</div><!--end.my_like-->

					<div id="pageDiv" class="jogger">
						<!-- <span class="disabled">&lt; </span>
                        <span class="current">1</span>
                        <a href="#?page=2">2</a>
                        <a href="#?page=3">3</a>
                        <a href="#?page=4">4</a>
                        <a href="#?page=5">5</a>
                        <a href="#?page=6">6</a>
                        <a href="#?page=7">7</a>...
                        <a href="#?page=199">199</a>
                        <a href="#?page=200">200</a>
                        <a href="#?page=2">&gt; </a> -->
					</div>
				</div>

				<!--end.content-right-->
			</div>
			<!--end.content-->
			
			<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
		<!--end.contain-->
	</body>

</html>