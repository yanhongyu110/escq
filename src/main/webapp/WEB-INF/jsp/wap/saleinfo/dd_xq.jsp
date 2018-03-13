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
<%--<%@ include file="/WEB-INF/jsp/common/header.jsp"%>--%>
	<script type="text/javascript" src="${webtxc}/js/common.js?v=20160111"></script>
<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
<meta content="yes" name="apple-mobile-web-app-capable">
<!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
<meta name="apple-touch-fullscreen" content="yes">
<!-- 开启对web app程序的支持  -->
<meta content="telephone=no,email=no" name="format-detection">
<!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
<!--base css-->
<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
<link rel="stylesheet" href="${webtxc }/css/wap/reset.css" />
<link rel="stylesheet" href="${webtxc }/css/wap/personer.css" />
<script src="${webtxc }/js/wap/reset.js"></script>
<%-- <script src="${webtxc }/js/wap/jquery.min.js"></script> --%>
<%-- <script type="text/javascript" src="${webtxc }/myjs/wap/saleinfo/ordersubmit.js?v=2212"></script> --%>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
</head>
<style>
.personer_mes {
    padding-bottom: 10px;
    
}
.service_content{margin-top:0;}
</style>
	<body>
		<!--wapper-->
		<div class="wapper" style="margin-bottom: 60px;">
			<!--page-->
			<div id="page">
				<div class="personer_top">
					<h3>申请预约</h3>
					<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
				</div>
				<div class="my_date_bt">

					<div class="service_content">
						<div class="service_content_pj show">
							<div class="personer_mes">
							<c:forEach items="${orderInfo.orderService }" var="orderService">
								<input type="hidden" class="serviceId">
								<input type="hidden" class="scartNum">
								<input type="hidden" class="scartSource">
								<ul class="my_date">
									<li class="my_date_img"><img src="${orderService.serviceInfo.servicePic}"></li>
									<li class="my_date_title">
										<h3>${orderService.serviceInfo.serviceTitle }</h3>
										<p>${orderService.osPrice } </p>
									</li>
									<li class="my_date_zt">
										<c:if test="${orderInfo.orderState == 0 }"><p>待确认</p></c:if>
										<c:if test="${orderInfo.orderState == 1 }"><p>服务商否定</p></c:if>
										<c:if test="${orderInfo.orderState == 2 }"><p>待付款</p></c:if>
										<c:if test="${orderInfo.orderState == 3 }"><p>已取消</p></c:if>
										<c:if test="${orderInfo.orderState == 4 }"><p>待完成</p></c:if>
										<c:if test="${orderInfo.orderState == 5 }"><p>待评价</p></c:if>
										<c:if test="${orderInfo.orderState == 6 }"><p>已完成</p></c:if>
										<%-- <span>${orderInfo.orderCreatetimestr }</span> --%>
									</li>
								</ul>
							</c:forEach>
							</div>
							<!--end.personer_mes-->
							<div class="personer_mes_zl">
								<ul class="personer_mes_zl_ms have_border">
									<li>预约时间</li>
									<li class="mes_input">
										<%-- <input value="${orderInfo.orderCreatetimestr }" style="padding-left: 10px;width:100%;" type="text" /> --%>
										${orderInfo.orderCreatetimestr }
									</li>
								</ul>
								<ul class="personer_mes_zl_ms">
									<li>联系人</li>
									<li class="mes_input">
										<%-- <input value="${orderInfo.orderPerson }" type="text" /> --%>
										${orderInfo.orderPerson }
									</li>
									<li id="orderPersonicon"></li>
								</ul>
								<ul class="personer_mes_zl_ms">
									<li>约定区域</li>
									<li class="mes_input">
										<%-- <input value="${orderInfo.orderArea }" type="text" /> --%>
										${orderInfo.orderArea }
									</li>
									<li id="orderAreaicon"></li>
								</ul>
								<ul class="personer_mes_zl_ms">
									<li>约定地点</li>
									<li class="mes_input">
										<%-- <input value="${orderInfo.orderAddr }" type="text" /> --%>
										${orderInfo.orderAddr }
									</li>
									<li id="orderAddricon"></li>
								</ul>
								<ul class="personer_mes_zl_ms">
									<li>联系方式</li>
									<li class="mes_input">
										<%-- <input value="${orderInfo.orderPersoncell }" type="text" /> --%>
										${orderInfo.orderPersoncell }
									</li>
									<li id="orderPersoncellicon"></li>
								</ul>
								<c:forEach items="${orderInfo.orderService }" var="orderService" varStatus="in">
									<ul class="personer_zp" style="height: 40px;line-height: 40px;">
										<li>服务描述</li>
										<li class="personer_js">
											<%-- <textarea id="orderRequest" value="${orderService.serviceInfo.serviceTitle }"></textarea> --%>
											<p>${in.count }、${orderService.serviceInfo.serviceTitle }</p>
										</li>
									</ul>
								</c:forEach>
								<c:if test="${orderInfo.orderIsbill}">
									<!-- <ul class="personer_fb">
										<li>发票信息</li>
											<li><input type="radio" name="orderIsbill" onclick="invoice()" value="1" checked="checked" /> 开具发票</li>
											<li><input type="radio" name="orderIsbill" onclick="noinvoice()" value="0" /> 不开发票
										</li>
									</ul> -->
								
									<ul id="describe" class="personer_zp">
										<li>发票描述</li>
										<li class="personer_js">${orderInfo.orderBillcontent}</li>
									</ul>
									<ul id="address" class="personer_mes_zl_ms">
										<li>发票地址</li>
										<li class="mes_input">
											${orderInfo.orderBilladdr}
										</li>
										<li id="orderBilladdricon"></li>
									</ul>
								</c:if>
							</div>
							<!-- <div class="personer_excit"> -->
						</div>
						<!--end.service_content_pj-->
					</div>
					<!--end.service_content-->
				</div>
				<!--end.wap_service_xq-->
			</div>
			<!--page end-->
		</div>
		<!--wapper end-->
		<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%>
	</body>
</html>