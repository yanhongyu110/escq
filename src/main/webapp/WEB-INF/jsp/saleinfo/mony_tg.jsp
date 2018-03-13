<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>资金托管</title>
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		<script type="text/javascript" src="${webtxc}/myjs/saleinfo/personal_tab.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/saleinfo/personal_menu.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/saleinfo/mony_tg.js?value=123"></script>
	</head>

	<body>
	<c:set var="istop" value="true" />
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>
			
			<!--end.personal-->
			<div class="content">
			<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
			
				<div class="content-right">
					<div class="mony_tg fw_pj">
							<table cellpadding="0" cellspacing="0" border="0" >
								<tr>
									<td><f:formatDate value="${orderInfo.orderCreatetime }" pattern="yyyy-MM-dd"/></td>
									<td>订单号:<span id="orderNo">${orderInfo.orderNo }</span></td>
									<td>状态</td>
									<td>金额</td>
									<td>备注</td>
								</tr>
								<c:forEach items="${orderInfo.orderService}" var="orderService">
									<tr>
										<td class="fw_pj_img"><img src="${orderService.serviceInfo.servicePic}" width="150"></td>
										<td class="fw_pj_title">${orderService.serviceInfo.serviceTitle }<br>${orderInfo.orderArea }<br>约${orderService.serviceInfo.serviceMeettime }小时</td>
										<td>待付款</td>
										<td><span>￥${orderService.osPrice }</span></td>
										<td class="bz"></td>
									</tr>
								</c:forEach>
							</table>
					</div><!--end.mony_tg-->
					<div class="money ">
						<h3>需支付金额：<span id="orderPrice">￥${orderInfo.orderPrice }</span></h3>
				    </div>
					<div class="expert_mes">
						
						<div class="my_zh hborder">
							<div class="zh_zf">
								<ul>
									<li><input type="checkbox" id="checkbox" />我的账户</li>
									<li>余额：<span id="accBalance">￥${selectBalanceById.accBalance}</span></li>
								</ul>								
							</div>
						</div><!--end.my_zh-->
						<div class="my_zh_title" >
								<div class="my_zh_title_left">
									
									<h4>郑重承诺：您即将支付的费用将作为托管酬金，暂存平台账户。当您完成咨询，对咨询结果满意后确认服务完成，款项才会转至相应专家的账户之中。若您对专家的服务感到不满，您可以发起退款申请，当专家同意退款，钱数将原封不动原路返回，若专家不同意退款，平台会介入，直至问题解决。</h4>
								</div>

							</div>
						
							
							
							<div class="my_zh_qtfs">
								
								<ul>
									<li>交易密码：</li>
									<li><input id="accPaypass" type="password" class="sr" placeholder="请输入支付密码"></li>
									<li><a href="${webtxc}/userinfo/accountInfo/jumpModifyPayPass.html&comId=${sessionScope.company.compId}">忘记密码?</a></li>
								</ul>
							</div>
							
							<div class="my_zh_bottom tx">
								<a class="btn_tx" id="btn_tx">去付款</a>
								<a class="btn_qx" onclick="history.go(-1)">取消</a>
								
							</div>
							<div class="my_zh_list">
							<h2>其他支付方式（推荐） <a class="cancel_jdpay" href="javascript:;" style="color:blue;display:none;">取消银联支付</a>  </h2>
							<div class="my_zh_list_txd" id="my_zh_list_txd">
								<input type="hidden" value="${orderInfo.orderId }" id="orderId"/>
								<input type="hidden" value="${orderInfo.orderNo }" id="orderNumber"/>
								<ul>
									<li class="zfb" tag='1'>支付宝支付</li>
									<li class="wx" tag='2'>微信支付</li>
									<!-- <li class="yl" tag='3'>银联支付</li> -->
								</ul>
								
								
							</div>
							
						<%-- 	<div id="bank_list" style="display:none;">   <!-- 银行卡的列表div -->
								<ul> <!-- 银行卡图标列表  -->
									<li><input name="bank" id="banklist1" type="radio" value="3061" />&nbsp;&nbsp;<label for="banklist1"> <img src="${webtxc}/images/bank_gf_3061.gif"  alt="广发银行" align="middle" /></label></li>
									<li><input name="bank" id="banklist2" type="radio" value="1025" />&nbsp;&nbsp;<label for="banklist2"> <img src="${webtxc}/images/bank_gs_1025.gif"  alt="工商银行" align="middle" /></label></li>
									<li><input name="bank" id="banklist3" type="radio" value="1051" />&nbsp;&nbsp;<label for="banklist3"> <img src="${webtxc}/images/bank_js_1051.gif"  alt="建设银行" align="middle" /></label></li>
									<li><input name="bank" id="banklist4" type="radio" value="3407" />&nbsp;&nbsp;<label for="banklist4"> <img src="${webtxc}/images/bank_jt_3407.gif"  alt="交通银行" align="middle" /></label></li>
									<li><input name="bank" id="banklist5" type="radio" value="305" />&nbsp;&nbsp;<label for="banklist5"> <img src="${webtxc}/images/bank_ms_305.gif"  alt="民生银行" align="middle" /></label></li>
									<li><input name="bank" id="banklist6" type="radio" value="103" />&nbsp;&nbsp;<label for="banklist6"> <img src="${webtxc}/images/bank_ny_103.gif"  alt="农业银行" align="middle" /></label></li>
									<li><input name="bank" id="banklist7" type="radio" value="3230" />&nbsp;&nbsp;<label for="banklist7"> <img src="${webtxc}/images/bank_yz_3230.gif"  alt="邮政银行" align="middle" /></label></li>
									<li><input name="bank" id="banklist8" type="radio" value="104" />&nbsp;&nbsp;<label for="banklist8"> <img src="${webtxc}/images/bank_zg_104.gif"  alt="中国银行" align="middle" /></label></li>
									<li><input name="bank" id="banklist9" type="radio" value="3080" />&nbsp;&nbsp;<label for="banklist9"> <img src="${webtxc}/images/bank_zs_3080.gif"  alt="招商银行" align="middle" /></label></li>
	
								</ul>
							</div> --%>
							
							<div class="money ">
						     <h4>需支付金额：<span>￥${orderInfo.orderPrice }</span></h4>
				            </div>
							
							
							
						</div><!--end.my_zh_list-->
						
						
						
					</div><!--end.expert_mes-->
					
					
					
				</div>
				<!--end.content-right-->
			</div>
			
		<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
		<!--end.contain-->
	</body>

</html>