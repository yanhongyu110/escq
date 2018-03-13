<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<title>服务商详情</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<link rel="stylesheet" href="${webtxc }/css/public.css" />
<link rel="stylesheet" href="${webtxc }/css/service.css" />
	<link rel="stylesheet" type="text/css" href="${webtxc}/css/ishare/iconfont.css">
	<link rel="stylesheet" type="text/css" href="${webtxc}/css/ishare/ishare.css">
<%-- <script type="text/javascript" src="${webtxc }/js/shenzhan.js"></script> --%>
<script type="text/javascript" src="${webtxc }/myjs/userinfo/preproviderdetails.js?v=124a312236"></script>
<script type="text/javascript" src="${webtxc}/calendar/myjs/customer.js?webtxc=${webtxc}"></script>
<script type="text/javascript">
	var logId='${sessionScope.logInfo.logId}';
</script>
</head>
	<body>
		<div class="contain">
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>
			
			<div class="content">
				<div class="sv_position">
					<h3><a href="${webtxc}/goodsinfo/ServiceInfo/homeShow.html?comId=${sessionScope.company.compId}">首页</a> >>${info.logName }</h3>
				</div>
				<div class="service_xq">
					<div class="service_xq_left">
						<div class="service_xq_zj">
							<div class="service_xq_zj_img"><img src="${info.userPhoto }" /></div>
							
							<div class="service_jianjie">
							    
								<p><span class="jianjie_idea">${info.piContent }</span>
								</p>
							</div>
							<%--<div class="service_btn">--%>
								<%--<a>马上约见TA</a>--%>
							<%--</div>--%>
						</div>
						<div class="service_xq_g"><img src="${webtxc }/images/ps2.jpg" width="230"></div>
						<div class=" service_xq_tj">
							<h3>TA推荐的专家</h3>
							<ul class="service_xq_tjzj">
							<c:if test="${empty providers.list}"><li><span>暂无推荐</span></li></c:if>
							<c:if test="${!empty providers.list}">
							<c:forEach var="recommend" items="${providers.list}">
									<li>
										<img src="${recommend.piPhoto}" onclick="window.location.href=path+'/userinfo/providerdetails/preproviderdetails.html?logId=${recommend.rptpPresentee}'+'&comId='+g_comid">
										<p>${recommend.piPosition }</p>
									</li>
							</c:forEach>
							</c:if>		
								</ul>
					</div>
					</div>
					<div class="service_xq_right">
						<div class="service_right_top">
							<h3>${info.logName }/${info.piPosition }</h3>
							<h4>${info.piArea }</h4>
							<h5></h5>
							<div class="service_right_top_share">
								<ul>
									<li>
									<c:if test="${sessionScope.logInfo.logId!=info.logId}">
									    <a href="javascript:void(0)" class="add_foucs addfocus">添加关注</a>
									    </c:if>
										<span><font>${info.piDealnum }</font>人付款</span>
										<span><font>${info.piMeetnum }</font>人想见</span>
										<span><font>${info.piResponsetime }</font>小时内回见</span>
										<span class="ck_dq"><a id="ckdq-btn"  href="javascript:void(0)">查看档期</a></span>
										
									</li>

									<div class="content_right_share_fx mms" >分享到：
										<a class="iShare iShare-24 iShare3"></a>
									</div>


								</ul>
							</div>
						</div>
						<div class="service_list" id="service_list">
						<!-- 服务列表开始 -->
						<input type="hidden" id="logId" value="${info.logId }">
						<c:forEach var="ss" items="${info.serviceInfos}" varStatus="vs">
							<div class="class1 ">
								<div class="line">
									<div class="class1_title" onclick="window.location.href=path+'/goodsinfo/service/queryServiceDetails.html?serviceId=${ss.serviceId}&priceType=1'+'&comId='+g_comid" >${ss.serviceTitle }</div>
									<div class="class1_pay">
										￥<font>${ss.psetPrice }</font>元/次</div>
									<a class="class1_btn" onclick="window.location.href=path+'/goodsinfo/service/queryServiceDetails.html?serviceId=${ss.serviceId}&priceType=1'+'&comId='+g_comid">查看详细</a>
									<div class="serch_ss" id="state${vs.index+1}But" onClick="$use('class${vs.index+1}content','state${vs.index+1}But')">展开<img src="${webtxc }/images/down.png"></div>
									<div class="serch_content" id="class${vs.index+1}content" >
										<div class="zs_list">${ss.serviceContent }</div>
										<div class="zs_detail">
										<span>发布于：${ss.serviceCreatetimeStr }</span>
										<span><font>${ss.serviceMeetnum }</font>人约过</span>
										<span>约见
										<font>${ss.serviceMeettime }</font>小时</span>
										<%-- <span><img src="${webtxc }/images/zan.png">
										<font>123</font>个</span> --%>
										</div>
									</div>
								</div>
							</div>
						</c:forEach> 
						<!-- 服务列表结束 -->
						
						
					</div>
					<c:if test="${fn:length(info.serviceInfos)>4}">
						<div id="moreservice" class="l_more">查看更多</div>
						<div id="dx" class="mes_tss">已经到底儿啦^_^</div>
					</c:if>
					
					</div>
					<!--end.service_xq_right-->
				</div>
				<!--end.service_xq-->

			</div>
			<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
			
			<!-- 档期日历div -->
			<div id="calendar_div" style="position: fixed;height: 530px;width: 501px;top: 10%;left: 30%;z-index: 10;display: none;background-color: white;">
				<div class="dialogTop">
					<a href="javascript:;" class="claseDialogBtn"><img src="${webtxc }/images/wrong.jpg"></a>
				</div>
				<iframe height="100%" width="100%" scrolling="no" frameborder="0"></iframe>
			</div>
			
		<!--end.contain-->
				<script type="text/javascript">
					var url=window.location.href;

					var iShare_config = {
						container:'.iShare',config:{
							title: '${serviceVo.serviceTitle }',
							//description: '${serviceVo.serviceBiref }',
							url: url,
							isAbroad: false,
							isTitle: true,
							initialized: true,
							WXoptions:{
								evenType: 'click',
								isTitleVisibility: true,
								title: '二维码标题',
								isTipVisibility: true,
								tip: '二维码描述文本',
								qrcodeW: 140,
								qrcodeH: 140,
								qrcodeBgc: '#fff',
								qrcodeFgc: '#000',
								bgcolor: '#2BAD13'
							}
						}
					}
				</script>
				<script type="text/javascript" src="${webtxc}/js/ishare/iShare.js?value=134"></script>
	</body>

</html>