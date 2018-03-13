<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>完成服务</title>
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		<script type="text/javascript" src="${webtxc}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
		<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/saleinfo/zf_wc.js"></script>
		
	</head>

	<body>
		<c:set var="istop" value="true" />
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>
			
			<!--end.personal-->
			<div class="content">
				<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
				
				<div class="content-right">
					<div class="mony_tg">
							<table cellpadding="0" cellspacing="0" border="0" >
								<tr>
									<td><f:formatDate value="${orderInfo.orderCreatetime }" pattern="yyyy-MM-dd"/> </td>
									<td>订单号：<span id="orderNo">${orderInfo.orderNo }</span></td>
									<td>状态</td>
									<td>金额</td>
									<td>备注</td>
								</tr>
								<c:forEach items="${orderInfo.orderService}" var="orderService">
									<tr>
										<td class="fw_pj_img"><img src="${orderService.serviceInfo.servicePic}" width="150"></td>
										<td class="fw_pj_title"><span id="title">${orderService.serviceInfo.serviceTitle }</span><br>${orderInfo.orderArea }<br>约${orderService.serviceInfo.serviceMeettime }小时</td>
										<td>待完成</td>
										<td><span>￥${orderService.osPrice }</span></td>
										<td class="bz"></td>
									</tr>
								</c:forEach>
							</table>
					</div><!--end.mony_tg-->
					<div class="money ">
						<h3>需支付金额：<span id="orderPrice">￥${orderInfo.orderPrice }</span></h3>
						<a>收款方：网站平台</a><br>
						
				    </div>
					<div class="expert_mes">
						
						
						<div class="my_zh_title" >
								<div class="my_zh_title_left">
									
									<h4>服务确认完成后，平台账户将托管资金<span>${orderInfo.orderPrice }</span>元转账到收款方，您也可以申请退款，专家同意退款后，平台将托管资金转入您的账户余额。</h4>
								</div>

							</div>
						
							
							
							<div class="my_zh_qtfs">
								
								<ul>
									<li>交易密码：</li>
									<li><input type="password" id="accPaypass" class="sr" placeholder="请输入交易密码"></li>
									<li><a href="${webtxc}/userinfo/accountInfo/jumpModifyPayPass.html&comId=${sessionScope.company.compId}">忘记密码?</a></li>
								</ul>
							</div>
							
							<div class="my_zh_bottom tx">
								<a class="btn_tx" id="btn_tx">确定完成</a>
								<a class="btn_qx" onclick="history.go(-1)">取消</a>
								
							</div>
							
						</div><!--end.my_zh_list-->
						
					</div><!--end.expert_mes-->
				</div>
				<!--end.content-right-->
			</div>
		<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
	</body>

</html>