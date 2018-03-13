<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改预约</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
<link rel="stylesheet" href="${webtxc }/css/public.css" />
<link rel="stylesheet" href="${webtxc }/css/personal.css" />
<script type="text/javascript" src="${webtxc }/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc }/js/personal_menu.js"></script>
<script type="text/javascript" src="${webtxc }/myjs/saleinfo/appointmentedit.js?v=30sd"></script>
<script type="text/javascript">
	var flag = ${obj.orderIsbill };
</script>
</head>

	<body>
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>			
			<div class="content">
				<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
				<div class="content-right">

					<div class="my_apply">
						<h2>修改预约</h2>
						<div class="status_icon">
							<p class="progress_bar"></p>
							<div class="status_progress status_one on ">
								<div class="steps">1
									<div class="stripeL"></div>
									<div class="stripeR"></div>
								</div>
								<div class="status_text">申请预约</div>
							</div>
							<div class="status_progress status_two ">
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
									<td style="min-width: 340px;">订单号：${obj.orderNo }</td>
									<td style="min-width: 45px;">状态</td>
									<td style="min-width:100px;">金额</td>
									<td>备注</td>
								</tr>
								<input type="hidden" id="orderId" value="${obj.orderId }"/>
								<input type="hidden" id="orderBuyer" value="${obj.orderBuyer }"/>
								<input type="hidden" id="orderSeller" value="${obj.orderSeller }"/>
								<c:forEach var="os" items="${obj.orderService}">
									<tr>
										<td class="fw_pj_img"><img src="${os.serviceInfo.servicePic}" width="150"></td>
										<td class="fw_pj_title"><span>${os.serviceInfo.serviceTitle}</span><br>${obj.orderArea}<br>约${os.serviceInfo.serviceMeettime }小时</td>
										<td>${orderState }</td>
										<td><span style="padding-right: 5px;font-weight: bold;">￥</span><span>${os.osPrice }</span><br>
										<%-- <span style="padding-right: 5px;">积分</span><span>${os.osPoint }</span> --%></td>
										<td class="bz">${os.serviceInfo.serviceComment}</td>
									</tr>
								</c:forEach>
							</table>
						</div>

						<div class="my_apply_clear"></div>
						<div class="note_message">
							<ul>
								<li class="mes">期望服务时间：</li>
								<li>
									<input id="orderMeettime" style="padding-left: 10px;" type="text" class="mees" value="${obj.orderMeettime }"/>
								</li>
								<!-- <li class="zp_ts">字数不超过<span>200</span>个字。</li> -->
							</ul>
							<ul>
								<li class="mes">期望约定区域：</li>
								<li>
									<input id="orderArea" type="text" placeholder="请输入约定的区域" maxlength="10" class="mees" value="${obj.orderArea }" />
								</li>
								<li class="zp_ts">字数不超过<span>10</span>个字。</li>
							</ul>
							<ul>
								<li class="mes">期望约定地点：</li>
								<li>
									<input id="orderAddr" type="text" placeholder="请输入约定的地点，如“江北区观音桥" maxlength="50" class="mees" value="${obj.orderAddr }" />
								</li>
								<li class="zp_ts">字数不超过<span>50</span>个字。</li>
							</ul>
							<ul>
								<li class="mes">联系人：</li>
								<li>
									<input id="orderPerson" type="text" placeholder="请输入联系人姓名" maxlength="5" class="mees" value="${obj.orderPerson }" />
								</li>
								<li id="orderPersonicon" class="zp_ts">字数不超过<span>5</span>个字。</li>
							</ul>
							<ul>
								<li class="mes">联系方式：</li>
								<li>
									<input id="orderPersoncell" type="text" placeholder="请输入手机号,固定电话请加区号(如:023-)" maxlength="13" class="mees" value="${obj.orderPersoncell }" />
								</li>
								<li id="orderPersoncellicon" class="zp_ts">字数不超过<span>13</span>个数字。</li>
							</ul>
							<ul>
								<li class="mes">咨询问题描述：</li>
								<li class="maijia_mj">
									
										<c:forEach var="person" items="${parseArray }">
											
												<span>${person.type==0?"买家":"卖家" } : ${person.content }<font class="time">${person.time}</font></span>
											
										</c:forEach>
									
								</li>
							</ul>
							<input type="hidden" id="parseArray" value='${parseArray }'/>
							<ul>
								<li class="mes">咨询问题描述：</li>
								<li>
									<textarea id="orderRequest" cols="50" rows="4" placeholder="我想要咨询..."></textarea>
								</li>
								<li class="zp_ts">字数不超过<span>200</span>个字。</li>
							</ul>
							<ul class="fp">
								<li class="mes">发票信息：</li>
								<li>
									<input type="hidden" id="orderIsbill" value="${obj.orderIsbill }" />
									<input type="radio" name="orderIsbill" onclick="invoice()" value="1" />开具发票
									<input type="radio" name="orderIsbill" onclick="noinvoice()" value="0" checked= "checked" />不开发票
								</li>

							</ul>
							<ul id="address" style="display:none;margin-bottom: 20px">
								<li class="mes">发票地址：</li>
								<li><textarea id="orderBilladdr" cols="48" rows="2" placeholder="邮寄发票的地址...">${obj.orderBilladdr }</textarea></li>
								<li id="orderBilladdricon" class="zp_ts"  style="line-height: 20px">发票费用：<span>1000.00X6% = 60元</span>，发票由平台开具，此费用由平台收取</li>
							</ul>
							<ul id="describe" style="display:none">
								<li class="mes">发票描述：</li>
								<li><textarea id="orderBillcontent" cols="50" rows="3" placeholder="请输入描述...">${obj.orderBillcontent }</textarea></li>
								<li class="zp_ts">字数不超过<span>100</span>个字。</li>
							</ul>
							<ul class="hpadding">
								<li class="mes"></li>
								<li>
									<div class="mes_btn_wc nomargin-left" id="sub" style="cursor:pointer" onclick="submit()">提交订单</div>
									<div class="mes_btn_qx" style="cursor:pointer" onclick="reset()">取消约见</div>
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