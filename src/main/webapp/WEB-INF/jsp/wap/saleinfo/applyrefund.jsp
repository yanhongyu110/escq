<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>申请退款</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<meta content="yes" name="apple-mobile-web-app-capable">
<!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
<meta name="apple-touch-fullscreen" content="yes">
<!-- 开启对web app程序的支持  -->
<meta content="telephone=no,email=no" name="format-detection">
<!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
<!--base css-->
<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
<link rel="stylesheet" href="${webtxc }/css/wap/reset.css" />
<link rel="stylesheet" href="${webtxc }/css/wap/personer.css?val=124" />
	<script type="text/javascript" src="${webtxc }/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="${webtxc}/jquery/jquery.cookie.js"></script>
	<script type="text/javascript" src="${webtxc}/jquery/jquery.md5.js"></script>

<script src="${webtxc }/js/wap/reset.js"></script>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
<script type="text/javascript" src="${webtxc }/myjs/wap/saleinfo/applyrefund.js?v=4"></script>
<style>
.personer_mes {padding-bottom: 10px;}
.service_content{margin-top:0;padding-bottom:0}

</style>
	
</head>
	<body>
	
		<!--wapper-->
		<div class="wapper">
			<!--page-->
			<div id="page">
				<div class="personer_top">
					<h3>申请退款</h3>
					<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
				</div>

				

				<div class="my_date_bt">
					<div class="service_content">
						<div class="service_content_pj show">
							<div class="personer_mes nomargin">
							<c:forEach items="${orderInfo.orderService }" var="orderService">
								<input type="hidden" class="serviceId">
								<input type="hidden" class="scartNum">
								<input type="hidden" class="scartSource">
								<ul class="my_date">
									<li class="my_date_img"><img src="${orderService.serviceInfo.servicePic}"></li>
									<li class="my_date_title">
										<h3>${orderService.serviceInfo.serviceTitle }</h3>
										<p>${orderService.osPrice } 元</p>
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
									<ul class="personer_mes_zl_ms">
										<li>服务描述</li>
										<li class="personer_js">
											<%-- <textarea id="orderRequest" value="${orderService.serviceInfo.serviceTitle }"></textarea> --%>
											${in.count }、${orderService.serviceInfo.serviceTitle }
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
							<!-- <div class="personer_excit">
				</div> -->
						</div>
						<!--end.service_content_pj-->
					</div>
					<!--end.service_content-->
				</div>
				
				<%-- 退款信息开始 --%>
				
					
						<div class="personer_mes_zl">
							<ul class="personer_mes_zl_ms">
								<li style="width: 35%;">实际退款金额:</li>
								<li class="mes_input" style="width: 60%;color: red;font-weight: bold;">
									${orderInfo.orderPrice}元
								</li>
							</ul>
							
							<ul class="tuk_reson" >
								<li >退款理由</li>
								<li class="tuk_reson_textarea">
									<textarea type="text" id="buyerrepaycontent" placeholder="请表明退款理由" value="${orderInfo.orderBuyerrepaycontent}" >${orderInfo.orderBuyerrepaycontent}</textarea>
								</li>
							</ul>
								<!-- <li class="zp_ts" id="buyerrepaycontentMsg"></li> -->

							


				
				</div>
				<%-- 退款信息结束 --%>
				<div class="btns_bottom">
				<c:if test="${orderInfo.orderRefundstate<1 }">
								<ul>
									<li class="mes_input" >
										<input type="hidden" id="orderNo" value="${orderInfo.orderNo}"/>
										<input type="hidden" id="refundprice" value="${orderInfo.orderPrice}"/>
										<div class="mes_btn_qd"   onclick="applyrefund()">申请退款</div>
									</li>
									<li class="mes_input">
										<div class="mes_btn_qx"  onclick="reset()">取消</div>
									</li>
								</ul>
							</c:if>
							</div>

			</div>
			
		</div>
		<!--wapper end-->
		<%-- <%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%> --%>
	
	</body>

</html>