<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<html>

	<head>
		<meta charset="UTF-8">
		<title>我的收藏</title>
		<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<script>
			var count=${infos.totalSize}
			var pageNo=${infos.page}
		</script>
		<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/bizinfo/mycollect.js?v=asx6x45dg"></script>

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
						<h2>我的收藏</h2>
						<c:forEach var="collect" items="${infos.list}">
							<div class="my_like_list"  >
								<input type="hidden" class="cutdUser" value="${collect.cutdUser}" />
								<input type="hidden" class="cutdDemand" value="${collect.cutdDemand}" />
								<input type="hidden" class="demId" value="${collect.demId}">
								<div class="my_like_list_img" >
									<img src="${webtxc}${collect.userPhoto}"  />
								</div>
								<div class="my_like_list_title">
									<h3>${collect.demTitle }</h3>
									<%-- <h3>简介：${collect.demBrief }</h3> --%>
									<p><span>联系人：${collect.demContact }</span></p>
									<p><span>电话：${collect.demCell}</span></p>
									<%-- <p cut="20"> 关键字：${collect.demKeyword}</p> --%>
								</div>
								<div class="my_like_list_delete">
									<a href="javascript:void(0)" onclick="del(this)" class="delete_btn">删除收藏</a>
									<a href="javascript:void(0)"  class="delete_yy" onclick="window.location.href=path+'/demand/queryById.html?id=${collect.cutdDemand}'+'&comId='+g_comid">查看详情</a>
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
//							$('.delete_yy').each(function(){
//								var obj=$(this)
//								obj.click(function(){
//									var pp=obj.parents(".my_collect_lists")
//									var demId=pp.find('.cutdDemand').val()
//									window.location.href=path+'/demand/queryById.html?id='+demId+'&comId='+g_comid;
//								})
//							})
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