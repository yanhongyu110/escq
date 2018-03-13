<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>订单详情</title>
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		<script type="text/javascript" src="${webtxc}/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
		<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
		
	</head>

	<body>
		<c:set var="istop" value="true" />
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>
			
			<!--end.personal-->
			<div class="content">
				<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
				
				<div class="content-right">
					<div class="expert_mes">
						<h2>订单信息</h2>
							<div class="my_zh ">
								<div class="my_zh_title" >
									<div class="my_zh_title_left">
										<a>当前订单状态：<span>${orderDetail.orderStateStr }</span></a>
										<c:if test="${orderDetail.orderState == 6 }">
										<h4>交易已成功，如果买家提出售后要求，请积极与买家协商，做好售后服务。</h4>
										</c:if>
									</div>
	
								</div>
							</div>
						<div class="maijia_messages">
							<h4>买家信息</h4>
							<ul>
								<li>昵称：${logInfo1.logName }</li>
								<li>所在地区：${orderDetail.orderAddr}</li>
								<li>联系方式：${logInfo1.logCell}</li>
							</ul>
						</div>
						<div class="fw_pj">
							<table cellpadding="0" cellspacing="0" border="0">
								<tr>
									<td>${orderDetail.orderCreatetimeStr} </td>
									<td>订单号：${orderDetail.orderNo}</td>
									<td>数量</td>
									<td>状态</td>
									<td>价格</td>
									<td>备注</td>
								</tr>
								<c:forEach items="${orderDetail.orderService }" var="orderService">
									<tr>
										<td class="fw_pj_img"><img src="${orderService.serviceInfo.servicePic}" width="150"></td>
										<td class="fw_pj_title">${orderService.serviceInfo.serviceTitle }<br>${orderInfo.orderArea }<br>约${orderService.serviceInfo.serviceMeettime }小时</td>
										<td>1</td>
										<td>${orderDetail.orderStateStr }</td>
										<td><span>￥${orderService.osPrice }</span></td>
										<td>${orderService.osComment }</td>
									</tr>
								</c:forEach>
							</table>
							
							
							

						</div>
						<div class="money  ">
						    	<h3>实付金额：<span>${orderDetail.orderPrice }</span></h3>
						</div>
						
						<div class="ex_agree border_bottom">
							<ul>
								<li class="mes">订单编号：</li>
								<li>
									${orderDetail.orderNo}
								</li>
								
							</ul>
							<ul>
								<li class="mes">约见地点：</li>
								<li>
									${orderDetail.orderArea }
								</li>
								
							</ul>
							<ul>
								<li  class="mes">订单生成时间：</li>
								<li>
									${orderDetail.orderCreatetimestr }
								</li>
								
							</ul>
							<ul>
								<li  class="mes">约见人：</li>
								<li>
									${orderDetail.orderPerson }
								</li>
								
							</ul>
							<ul>
								<li  class="mes">约见人联系电话：</li>
								<li>
									${orderDetail.orderPersoncell }
								</li>
								
							</ul>
							<ul>
								<li  class="mes">约见时间：</li>
								<li>
									${orderDetail.orderMeettimestr }
								</li>
							</ul>
							<c:if test="${orderDetail.orderIsbill }">
								<ul>
									<li  class="mes">发票信息：</li>
									<li>发票地址:${orderDetail.orderBilladdr }<br/>发票描述:${orderDetail.orderBillcontent }</li>
								</ul>
							</c:if>
							<ul>
								<li  class="mes">咨询问题：</li>
								<li id="li1"></li>
							</ul>
							<c:if test="${orderDetail.orderState == 1 }">
								<ul>
									<li  class="mes">服务商退回信息：</li>
									<li id="li"></li>
								</ul>
							</c:if>
							</div>
						
					</div><!--end.expert_mes-->
					
					<script type="text/javascript">
						var content = '${orderDetail.orderRequest }';
						var str = eval("("+content+")");
						var val = "";
						var ll = "";
						$.each(str,function(i, v){
							if(v.type == 1){
								val +=  v.content +"\t";
							} else {
								ll += v.content +"\t";
							}
						});
						$("#li").html(val);
						$("#li1").html(ll);
					</script>
					
				</div>
				<!--end.content-right-->
			</div>
			<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
	</body>

</html>