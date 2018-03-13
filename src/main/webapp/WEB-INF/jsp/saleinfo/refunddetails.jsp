<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>退款详情</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
<link rel="stylesheet" href="${webtxc }/css/public.css" />
<link rel="stylesheet" href="${webtxc }/css/personal.css" />
<script type="text/javascript" src="${webtxc }/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc }/js/personal_menu.js"></script>
<script type="text/javascript" src="${webtxc }/myjs/saleinfo/refunddetails.js?v=27"></script>
</head>
	<body>
		<%@include file="/WEB-INF/jsp/common/top.jsp"%>			
			<div class="content">
				<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
				<div class="content-right">
					<div class="expert_mes">
						<h2>退款详情</h2>
						<div class="status_icon">
							<p class="progress_bar max-line"></p>
							<div id="apply" class="status_progress status_one on">
								<div class="steps">1
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">申请退款</div>
							</div>
							<div id="expert" class="status_progress  status_three ">
								<div class="steps">2
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">专家处理</div>
							</div>
							<div id="platform" class="status_progress status_two">
								<div class="steps">3
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<c:if test="${obj.orderRefundstate == 3 || obj.orderRefundstate == 6}">
									<div class="status_text">平台处理</div>
								</c:if>
								<c:if test="${obj.orderRefundstate == 2 }">
									<div class="status_text">待退款</div>
								</c:if>
							</div>
							<div id="complete" class="status_progress status_four">
								<div class="steps">4
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">退款完成</div>
							</div>
						</div><!--end.status_icon-->
						<input id="refundstate" type="hidden" value="${obj.orderRefundstate }" />
						<div class="my_zh">
							<div class="my_zh_title" >
								<div class="my_zh_title_left">
									<h4>专家同意退款后，平台将托管资金转入您的账户余额，如专家不同意，平台将干预处理</h4>
								</div>
							</div>
						</div>
						<!--end.my_zh-->
						<div class="note_message refound">
							<div class="fw_pj">
							<table cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td>${obj.orderCreatetimestr } </td>
									<td style="min-width:340px;">订单号：${obj.orderNo }</td>
									<td style="min-width: 45px;">状态</td>
									<td style="min-width:120px;">金额</td>
									<td>备注</td>
								</tr>
								<c:forEach var="os" items="${obj.orderService}">
									<tr>
										<td class="fw_pj_img"><img src="${os.serviceInfo.servicePic}" width="150"></td>
										<td class="fw_pj_title">${os.serviceInfo.serviceTitle}<br>${obj.orderArea }<br>约${os.serviceInfo.serviceMeettime }小时</td>
										<td>${orderState }</td>
										<td><span>￥</span><span>${os.osPrice }</span><br>
										<%-- span>积分</span><span>${os.osPoint }</span> --%></td>
										<td class="bz">${os.serviceInfo.serviceComment}</td>
									</tr>
								</c:forEach>
							</table>
						    </div>
						    <div class="money ">
						    	<h3>订单金额：<span>￥${obj.orderPrice }</span></h3>
						    	<h3>退款金额：<span>￥${obj.orderRefundprice }</span></h3>
						    </div>
							
							<ul>
								<li>退款理由：</li>
								<li>
									<span>${obj.orderBuyerrepaycontent }</span>
								</li>
							</ul>
							<ul>
								<li>专家说明：</li>
								<li>
									<span>${obj.orderSellerrepaycontent }</span>
								</li>
							</ul>
							<ul>
								<li>平台说明：</li>
								<li>
									<span>${obj.orderAdminrepaycontent }</span>
								</li>
							</ul>
						</div>
					</div><!--end.expert_mes-->
				</div>
				<!--end.content-right-->
			</div>
			<!--end.content-->
			<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
		<!--end.contain-->
	</body>

</html>