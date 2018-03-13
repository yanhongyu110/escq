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
<title>需求详情展示</title>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<link rel="stylesheet" href="${webtxc}/css/public.css" />
<link rel="stylesheet" href="${webtxc}/css/personal.css?val=45" />
<link rel="stylesheet" href="${webtxc}/css/service.css" />
<link rel="stylesheet" type="text/css" href="${webtxc}/css/ishare/iconfont.css">
<link rel="stylesheet" type="text/css" href="${webtxc}/css/ishare/ishare.css">
<script type="text/javascript" src="${webtxc}/myjs/demand/demanddetails.js?value=1sasf4"></script>
<script type="text/javascript">
var loginfo='${sessionScope.logInfo}';
</script>
</head>
<body>
		<c:set var="istop" value="false" />


		<c:if test="${sessionScope.module!=null}">
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>
		</c:if>
		<c:if test="${sessionScope.module==null}">
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>
		</c:if>


		
		<div class="content">
		<div class="sv_position">
					<h3><a href="${webtxc}/goodsinfo/ServiceInfo/homeShow.html?comId=${sessionScope.company.compId}">首页</a> >> ${demand.demTitle }</h3>
				</div>
			<form>

					<input type="hidden" id="demId"
						value="${demand.demId }">
				<div class="content_top">
					<div class="content_top_left">
						<c:if test="${not empty demand.demImage}"><img  src="${webtxc}${demand.demImage}"  /></c:if>
						<c:if test="${empty demand.demImage}"><img  src="${webtxc}/images/wap/xq_picture.jpg"  /></c:if>
					</div>
					<div class="content_top_right">

						<h1>${demand.demTitle }</h1>
						
						<div class="content_top_riht_pay"></div>
						<div class="fuw_my">联系人：${demand.demContact }</div>
						<div class="fuw_my">联系电话：${demand.demCell }</div>
						
						<div class="content_right_share_fx">
						分享到： <a class="iShare iShare-24 iShare3"></a>
					</div>
					<a id="collect" class="content_top_riht_btn">加入收藏</a>
					</div>
					<div class="xuqiu_xq">
					<img class="user_photo" src="${webtxc}${demand.userPhoto}" />
					<h4>${demand.logName }</h4>
					<p>发布时间：${demand.demCreatetimeStr }</p>
					
                </div>
				</div>
			</form>
	
		<div class="content_main"  >
			<div class="content_main_left">
				<div class="content_left_content">
					<div class="title cf">
						<ul class="title-list fr cf ">
							<li class="on">需求详情</li>
						</ul>
					</div>
					<div class="service_content">
						<div class="service_content_pj show">
							<div class="service_content_jianjie">
								<%-- <h3>需求简介</h3>
								<p>${demand.demBrief }</p> --%>
								<div class="service_content_img">
									<h3>需求展示</h3>
									${demand.demContent }
								</div>

							</div>

						</div>
					</div>
				</div>
			</div>
			<!--end.content_main_left-->
			<div class="content_main_right">
				<div class="content_main_right_qt">
					<h3>其他相关需求</h3>
					<c:if test="${empty others}"><span>暂无相关需求</span></c:if>
					<c:forEach var="demand" items="${others}">
							<div  class="fw_xg">
								<span onclick="window.location.href=path+'/demand/queryById.html?id=${demand.demId }'">${demand.demTitle }</span>
								</div>
					</c:forEach>
				</div>
				
			</div>
			
		</div>
	</div>	
	<jsp:include page="/WEB-INF/jsp/common/bottom.jsp" />
	
		<script type="text/javascript">
	var url=window.location.href;
	
	var iShare_config = {
			container:'.iShare',config:{
				title: '${demand.demTitle}',
				url: url,
				isAbroad: false,
				isTitle: true,
				initialized: true
			}
	}
	</script>
<script type="text/javascript" src="${webtxc}/js/ishare/iShare.js?value=134"></script>
</body>

</html>