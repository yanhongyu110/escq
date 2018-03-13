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
<link rel="stylesheet" href="${webtxc }/css/public.css" />
<link rel="stylesheet" href="${webtxc }/css/personal.css" />
<script type="text/javascript" src="${webtxc }/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc }/js/personal_menu.js"></script>
<script type="text/javascript" src="${webtxc }/myjs/saleinfo/appointmentconfirm.js?v=2ss8"></script>
<script type="text/javascript">
	var orderNo  = '${obj.orderNo }';
</script>
</head>

	<body>
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>			
			<div class="content">
				<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
				<div class="content-right">

					<div class="my_apply">
						<h2>专家确认</h2>
						<div class="status_icon">
							<p class="progress_bar"></p>
							<div class="status_progress status_one on ">
								<div class="steps">1
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">申请预约</div>
							</div>
							<div class="status_progress status_two on ">
								<div class="steps">2
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">专家确认</div>
							</div>
							<div class="status_progress status_three ">
								<div class="steps">3
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">资金托管</div>
							</div>
							<div class="status_progress status_four">
								<div class="steps">4
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">服务完成</div>
							</div>
							<div class="status_progress status_five">
								<div class="steps">5
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">服务评价</div>
							</div>
						</div>
						<!--end.status_icon-->
						<div class="fw_pj">
							<table cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td>${obj.orderCreatetimestr } </td>
									<td style="min-width:260px;">订单号：${obj.orderNo }</td>
									<td style="min-width: 85px;">状态</td>
									<td style="min-width:140px;">金额</td>
									<td>备注</td>
								</tr>
								<c:forEach var="os" items="${obj.orderService}" varStatus="vs">
									<tr>
										<form class="fom">
											<input type="hidden" name="osId" value="${os.osId }" />
											<input type="hidden" name="osPrice" value="${os.osPrice }" />
											<input type="hidden" name="osPoint" value="${os.osPoint }" />
											<input type="hidden" name="osGoodsNum" value="${os.osGoodsNum }" />
										</form>
										<td class="fw_pj_img"><img src="${os.serviceInfo.servicePic}" width="150"></td>
										<td class="fw_pj_title"><span>${os.serviceInfo.serviceTitle}</span><br>${obj.orderArea}<br>${obj.orderAddr}</td>
										<td>${orderState }</td>
										<td>
											<span>￥</span>
											<input type="hidden" value="${os.osPrice}" >
											<input id="price${vs.index }" class="price xg_jg" type="number" disabled  value="${os.osPrice}0" style="width: 100px;"><br>
											<span onclick="pricemodify('price${vs.index }')" class="xxg">修改</span>
											<%-- <br><br>
											<span>积分</span>
											<input type="hidden" value="${os.osPoint}" >
											<input id="point${vs.index }" class="point xg_jg" type="number" disabled  value="${os.osPoint}0" style="width: 100px;"><br>
											<span onclick="pointmodify('point${vs.index }')" class="xxg">修改</span> --%>
										</td>
										<td class="bz">${os.serviceInfo.serviceComment}</td>
									</tr>
								</c:forEach>
							</table>
						</div>

						<div class="my_apply_clear"></div>
						<div class="note_message">
							<ul>
								<li class="mest">期望服务时间：</li>
								<li>
									<span class="mes">${obj.orderMeettimestr }</span>
								</li>
							</ul>
							<ul>
								<li class="mest">期望约定区域：</li>
								<li>
									<span class="mes">${obj.orderArea }</span>
								</li>
							</ul>
							<ul>
								<li class="mest">期望约定地点：</li>
								<li>
									<span class="mes">${obj.orderArea }</span>
								</li>
							</ul>
							<ul>
								<li class="mest">联系人：</li>
								<li>
									<span class="mes">${obj.orderPerson }</span>
								</li>
							</ul>
							<ul>
								<li class="mest">联系方式：</li>
								<li>
									<span class="mes">${obj.orderPersoncell }</span>
								</li>
							</ul>
							<ul>
								<li class="mest">发票信息：</li>
								<li>
									<c:if test="${obj.orderIsbill }">
										发票地址 : <span class="mes">${obj.orderBilladdr }</span><br>
										发票描述 : <span class="mes">${obj.orderBillcontent }</span>
									</c:if>
									<c:if test="${!obj.orderIsbill }">
										<span class="mes">无</span>
									</c:if>
								</li>
							</ul>
							<ul>
								<li class="mest">咨询问题描述：</li>
								<li class="maijia_mj">
									
										<c:forEach var="person" items="${parseArray }">
											
												<span>${person.type==0?"买家":"卖家" } : ${person.content }<font class="time">${person.time}</font></span>
												
											
										</c:forEach>
									
								</li>
							</ul>
							<input type="hidden" id="parseArray" value='${parseArray }'/>
							<ul>
								<li class="mest">服务商退回描述：</li>
								<li>
									<textarea id="orderRequest" cols="48" rows="4" placeholder="我想要咨询..."></textarea>
								</li>
								<li class="zp_ts">字数不超过<span>200</span>个字。</li>
							</ul>
							<ul class="hpadding">
								<li class="mest"></li>
								<li>
									<div class="mes_btn_wc nomargin-left" id="sub" style="cursor:pointer" onclick="agree('${obj.orderId}','${obj.orderSeller}')">同意约见</div>
									<div class="mes_btn_wc nomargin-left" style="cursor:pointer" onclick="returnedit('${obj.orderId}','${obj.orderSeller}')">退回修改</div>
									<div class="mes_btn_qx" style="cursor:pointer" onclick="cancelOrder();">取消约见</div>
								</li>

							</ul>
						</div>

					</div>
					<!--end.my_like-->
				</div>
				<!--end.content-right-->
			</div>
			<!--end.content-->
			<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
		<!--end.contain-->
	</body>

</html>