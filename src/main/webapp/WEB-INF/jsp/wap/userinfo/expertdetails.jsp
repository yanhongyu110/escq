<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<meta charset="UTF-8">
<title>服务商主页</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<meta content="yes" name="apple-mobile-web-app-capable">
<!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
<meta name="apple-touch-fullscreen" content="yes">
<!-- 开启对web app程序的支持  -->
<meta content="telephone=no,email=no" name="format-detection">
<!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
<!--base css-->
<meta name="viewport"
	content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
<link rel="stylesheet" href="${webtxc }/css/wap/reset.css" />
<link rel="stylesheet" href="${webtxc }/css/wap/index.css" />
<script src="${webtxc }/js/wap/jquery-1.9.1.min.js"></script>
<script src="${webtxc }/js/wap/reset.js"></script>
<script src="${webtxc }/js/wap/TouchSlide.js"></script>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js"></script>
<script type="text/javascript" src="${webtxc }/myjs/wap/userinfo/expertdetails.js?v=1245"></script>
<script type="text/javascript">
var logId='${logInfo.logId}';
</script>
</head>
<body>
	<!--wapper-->
	<div class="wapper" style="border:0">
		<!--page-->
		<div id="page">
			<div class="content have_bg">
				<div class="expert_bg">
					<div class="expert_tx" style="position: relative">
						<img src="${info.userPhoto }" />
						<h3>${info.logName } <span>${info.piPosition }</span></h3>
						<h4>${info.piArea }</h4>
						<%--<div class="yue_bottom_left" style="background-color: transparent;width: 30px;height: 30px">--%>
							<%--<img style="border: none" src="${webtxc }/images/ilike.png" alt="喜欢">--%>
						<%--</div>--%>
					</div>

					<div class="_yue_bottom_left" style="width: 100%;margin-top: 10px;padding: 8px 0px;text-align: center;background: #f40;color: #fff;font-size: 16px;">关注</div>
					
					<%--<div class="gm">约TA见面</div>--%>
				</div>
				<!--end.expert_bg-->
				<div class="expert_lan">
					<ul>
					    <li><img src="${webtxc }/images/wap/fss.png" align="left"><span>粉丝</span><b>${count }人</b></li>
					    <li><img src="${webtxc }/images/wap/fb.png" align="left"><span>服务</span><b>${info.serviceNum }条</b></li>
						<li><img src="${webtxc }/images/wap/jy.png" align="left"><span>经验</span><b>${info.piWorkyear }年</b></li>
						
						<li><img src="${webtxc }/images/wap/myd.png" align="left"><span>评价</span><b>${info.piMark }</b></li>
					</ul>
				</div>
				<%-- <div class="expert_fs">
						<div class="fs_img"><a><img src="${webtxc }/images/tximg.jpg"></a><a><img src="${webtxc }/images/img01.jpg"></a><a><img src="${webtxc }/images/tximg.jpg"></a><a><img src="${webtxc }/images/img02.jpg"></a><a><img src="${webtxc }/images/txx.png"></a></div>
						<div class="fs_sl">453535人关注</div>
					</div> --%><!--end.expert_fs-->
				<!--end.expert_lan-->
				<%--<div class="expert_fs">--%>
					<%--<div class="fs_img">--%>
						<%--<a><img src="${webtxc }/images/wap/tximg.jpg"></a><a><img--%>
							<%--src="${webtxc }/images/wap/img01.jpg"></a><a><img--%>
							<%--src="${webtxc }/images/wap/tximg.jpg"></a><a><img--%>
							<%--src="${webtxc }/images/wap/img02.jpg"></a><a><img--%>
							<%--src="${webtxc }/images/wap/txx.png"></a>--%>
					<%--</div>--%>
					<%--<div class="fs_sl">453535人关注</div>--%>
				<%--</div>--%>
				<!--end.expert_fs-->
				<div class="expert_jl">
					<h2>关于我</h2>
					<div class="piContent">
						<p>${info.piContent }</p>
					</div>
				</div>
				<!--end.expert_jl-->
				<div class="expert_zp" id="service_list">
					<h2>我发布的服务</h2>
					<%-- <ul>
						<li><img src="${webtxc }/images/wap/fw_01.jpg">
							<h3>营销型网站策划</h3> <font>￥1200</font></li>
						<li><img src="${webtxc }/images/wap/fw_03.jpg">
							<h3>营销型网站策划</h3> <font>￥1200</font></li>
					</ul> --%>
					<input type="hidden" id="logId" value="${info.logId }">
					<c:forEach var="ss" items="${info.serviceInfos}" varStatus="vs">
						<div class="tt_zhu" onclick="window.location.href=path+'/wap/goodsinfo/service/queryServiceDetails.html?serviceId=${ss.serviceId}&priceType=1'+'&comId='+g_comid">
							<div class="tt_zhu_img"><img  src="${ss.servicePic }"></div>
							<h3 class="serviceTitle">${ss.serviceTitle }</h3> 
							
						</div>
					</c:forEach>
				</div>
				<br>
				<!--end.expert_zp-->
				<div  class="more" id="morezp">
					<a class="btn">更多服务</a>
				</div>
				<%--<div id="dx" class="dxx">我也是有底线的^_^</div>--%>
				
			</div>
			<!--content end-->
			<c:if test="${sessionScope.logInfo.logId!=info.logId }">

			<div class="yue_bottom">
	                <ul>

	                 <%--<li class="yue_bottom_right"><img src="${webtxc }/images/yuejian.png" > 立即约见</li>--%>
	                </ul>
	        </div>


	        </c:if>
		</div>
		<!--page end-->
		
	</div>
	<!--wapper end-->

	<div style="width: 100%;height: 40px;"></div>

	<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp" %>
	
</body>

</html>