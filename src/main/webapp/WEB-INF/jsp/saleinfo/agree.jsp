<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>申请预约</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<link rel="stylesheet" href="${webtxc }/css/public.css" />
<link rel="stylesheet" href="${webtxc }/css/personal.css" />
<script type="text/javascript" src="${webtxc }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${webtxc }/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc }/js/personal_menu.js"></script>
<script type="text/javascript" src="${webtxc }/myjs/saleinfo/appointment.js?v=21"></script>
</head>

	<body>
			<c:set var="istop" value="true" />
			<%@include file="/WEB-INF/jsp/common/top.jsp" %>

			<!--end.personal-->
			<div class="content">
				<%@include file="/WEB-INF/jsp/common/left.jsp" %>
				<div class="content-right">
					<div class="expert_mes">
						<h2>申请退款</h2>

						<div class="status_icon">
							<p class="progress_bar max-line"></p>
							<div class="status_progress status_one ">
								<div class="steps">1
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">申请退款</div>
							</div>
							<div class="status_progress  tatus_two on ">
								<div class="steps">2

									<div class="stripeR"></div>
								</div>
								<div class="status_text">专家同意</div>
							</div>
							<div class="status_progress status_threes">
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
						<div class="my_zh hpadding">
							<div class="my_zh_title" >
								<div class="my_zh_title_left">
									<a>待专家确认</a>

									<h4>您已申请预约<span>caoxudong</span>，请及时操作。<br>申请预约并经专家确认后才可以付款，以保障服务的质量。<span>同意约见</span></h4>
								</div>

							</div>
						</div>

						
						<div class="note_message ">
							<div class="fw_pj">
								<table cellpadding="0" cellspacing="0" border="0">
									<tr>
										<td><f:formatDate value="${obj.orderCreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>订单号：${obj.orderNo}</td>
										<td>状态</td>
										<td>金额</td>
										<td>备注</td>
									</tr>
									<c:forEach items="${obj.orderService}" var="it">
										<tr>
											<td class="fw_pj_img"><img src="${webtxc}/${it.serviceInfo.servicePic}" width="150"></td>
											<td class="fw_pj_title">${webtxc}/${it.serviceInfo.serviceTitle}<br>${obj.orderArea }<br>约${it.serviceInfo.serviceMeettime }小时</td>
											<td>未确认</td>
											<td><span>￥${it.osPrice}</span></td>
											<td class="bz">2222</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>



						<div class="ex_agree">
							<ul>
								<li class="mes">期望服务时间：</li>
								<li>
									<f:formatDate value="${obj.orderMeettime}" pattern="yyyy-MM-dd HH:mm:ss"/>
								</li>

							</ul>
							<ul>
								<li  class="mes">期望约见地点：</li>
								<li>
									${obj.orderAddr}
								</li>

							</ul>
							<ul>
								<li  class="mes">联系人：</li>
								<li>
									${obj.orderPerson}
								</li>

							</ul>
							<ul>
								<li  class="mes">联系电话：</li>
								<li>
									${obj.orderPersoncell}
								</li>

							</ul>
							<ul>
								<li  class="mes">咨询的问题：</li>
								<li>
									${obj.orderRequest}
								</li>

							</ul>
							<c:if test="${obj.orderIsbill}">
								<ul>
									<li  class="mes">发票信息：</li>
									<li>
										开具发票
									</li>
									<li>发票费用：<span>1000.00X6% = 60</span>元，发票由平台开具，此费用由平台收取</li>

								</ul>
							</c:if>
							<div class="ex_agree_btton">
								<a class="mes_btn_wc nomargin-left" id="tongyi">同意约见</a>
								<a class="mes_btn_qx" id="quxiao">取消约见</a>
							</div>

						</div>

					</div><!--end.expert_mes-->


				</div>
				<!--end.content-right-->
				<!--end.content-right-->
			</div>
			<!--end.content-->
				<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>
		<!--end.contain-->
			<input type="hidden" id="oId" value="${obj.orderNo}">
			<input type="hidden" id="oNo" value="${obj.orderId}">
	<script>
		$(function(){
			$('#tongyi').click(function(){
				var obj={};
				obj.box=true;
				$.ajax({
					url:path+"/saleinfo/order/providerModifyOrder.html",
					data:{order:JSON.stringify(obj)},
					success:function(re){

					}
				})
			})
			$('#quxiao').click(function(){
				var obj={};
				obj.box=false;
				$.ajax({
					url:path+"/saleinfo/order/providerModifyOrder.html",
					data:{order:JSON.stringify(obj)},
					success:function(re){

					}
				})
			})
		})
	</script>
	</body>

</html>