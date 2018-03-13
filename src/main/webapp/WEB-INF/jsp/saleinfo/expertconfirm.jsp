<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>专家确认</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
<link rel="stylesheet" href="${webtxc }/css/public.css" />
<link rel="stylesheet" href="${webtxc }/css/personal.css" />
<script type="text/javascript" src="${webtxc }/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc }/js/personal_menu.js"></script>
<script type="text/javascript" src="${webtxc }/myjs/saleinfo/expertconfirm.js?v=3245"></script>
</head>
	<body>
		<%@include file="/WEB-INF/jsp/common/top.jsp"%>			
			<div class="content">
				<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
				<div class="content-right">
					<div class="expert_mes">
						<h2>专家确认</h2>
						<div class="status_icon">
							<p class="progress_bar max-line"></p>
							<div class="status_progress status_one on">
								<div class="steps">1
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">申请退款</div>
							</div>
							<div class="status_progress status_two on ">
								<div class="steps">2
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">专家同意</div>
							</div>
							<div class="status_progress status_three">
								<div class="steps">3
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">平台处理</div>
							</div>
							<div class="status_progress status_four">
								<div class="steps">4
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">退款完成</div>
							</div>
						</div><!--end.status_icon-->
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
									<td style="min-width: 340px;">订单号：${obj.orderNo }</td>
									<td style="min-width: 45px;">状态</td>
									<td style="min-width:100px;">金额</td>
									<td>备注</td>
								</tr>
								<input type="hidden" id="orderNo" value="${obj.orderNo }" />
								<c:forEach var="os" items="${obj.orderService}">
									<tr>
										<td class="fw_pj_img"><img src="${os.serviceInfo.servicePic}" width="150"></td>
										<td class="fw_pj_title"><span>${os.serviceInfo.serviceTitle}</span><br>${obj.orderArea }<br>约${os.serviceInfo.serviceMeettime }小时</td>
										<td>${orderState }</td>
										<td><span style="padding-right: 5px;font-weight: bold;">￥</span><span>${os.osPrice }</span><br>
										<%-- <span style="padding-right: 5px;">积分</span><span>${os.osPoint }</span></td> --%>
										<td class="bz">${os.serviceInfo.serviceComment}</td>
									</tr>
								</c:forEach>
							</table>
						    </div>
						    <div class="money ">
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
									<textarea id="sellerrepaycontent" cols="48" rows="4" placeholder="退款理由..."></textarea>
								</li>
								<li class="fll" id="sellerrepaycontentMsg">专家同意退款时，可不填写说明，当专家不同意的时候，必须填写专家说明。</li>
							</ul>
							<c:if test="${obj.orderRefundstate<2 }">
							<ul>
								<li>
									<div class="mes_btn_wc submit1" style="cursor:pointer" onclick="refundconfirm(true)">同意退款</div>
									<div class="mes_btn_qx submit1" style="cursor:pointer" onclick="refundconfirm(false)">不同意退款</div>
								</li>
							</ul>
							</c:if>
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