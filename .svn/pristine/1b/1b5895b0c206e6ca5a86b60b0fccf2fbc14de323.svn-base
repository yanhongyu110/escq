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
<script type="text/javascript" src="${webtxc}/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="${webtxc}/jquery/jquery.md5.js"></script>
<script src="${webtxc }/js/wap/reset.js"></script>
<%-- <script src="${webtxc }/js/wap/jquery.min.js"></script> --%>
<script type="text/javascript" src="${webtxc }/myjs/wap/saleinfo/orderedit.js?v=2212"></script>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
</head>
	<body>
		<!--wapper-->
		<div class="wapper">
			<!--page-->
			<div id="page">
				<div class="personer_top">
					<h3>修改预约</h3>
					<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
				</div>

				<div class="my_date_bt">

					<div class="service_content">
						<div class="service_content_pj show">
							<div class="personer_mes">
								<div class="ddhao">
									<span style="margin-left: 10px">订单号:${obj.orderNo }</span>
									<span style="margin-left: 10px">${obj.orderCreatetimeStr }</span>
								</div>
								<input type="hidden" id="orderId" value="${obj.orderId }"/>
								<input type="hidden" id="orderBuyer" value="${obj.orderBuyer }"/>
								<input type="hidden" id="orderSeller" value="${obj.orderSeller }"/>
							<c:forEach var="os" items="${obj.orderService}">
								<ul class="my_date">
									<li class="my_date_img"><img src="${webtxc }${os.serviceInfo.servicePic}"></li>
									<li class="my_date_title">
										<h3>${os.serviceInfo.serviceTitle}</h3>
										<p>${os.osPrice } </p>
									</li>
									<li class="my_date_zt">
										<p>${orderState }</p>
									</li>
								</ul>
							</c:forEach>
							</div>
							<!--end.personer_mes-->
							<div class="personer_mes_zl">
								<ul class="personer_mes_zl_ms have_border">
									<li>预约时间</li>
									<li class="mes_input">
										<input id="orderMeettime" value="${obj.orderMeettime }" style="padding-left: 10px;width:100%;" type="text" />
									</li>
								</ul>
								<ul class="personer_mes_zl_ms">
									<li>联系人</li>
									<li class="mes_input">
										<input id="orderPerson" value="${obj.orderPerson }" type="text" placeholder="请输入姓名"  />
									</li>
									<li id="orderPersonicon"></li>
								</ul>
								<ul class="personer_mes_zl_ms">
									<li>约定区域</li>
									<li class="mes_input">
										<input id="orderArea" value="${obj.orderArea }" type="text" placeholder="约定区域" />
									</li>
									<li id="orderAreaicon"></li>
								</ul>
								<ul class="personer_mes_zl_ms">
									<li>约定地点</li>
									<li class="mes_input">
										<input id="orderAddr" value="${obj.orderAddr }" type="text" placeholder="约定地点" />
									</li>
									<li id="orderAddricon"></li>
								</ul>
								<ul class="personer_mes_zl_ms">
									<li>联系方式</li>
									<li class="mes_input">
										<input id="orderPersoncell" value="${obj.orderPersoncell }" type="text" placeholder="联系方式" />
									</li>
									<li id="orderPersoncellicon"></li>
								</ul>
								<div class="describe_list">
									<div class="zixun_wenti">咨询问题</div>
									<div class="zixun_wenti_xq">
									<c:forEach var="person" items="${parseArray }">
										
										<span>
											${person.type==0?"买家":"卖家" }(<span class="time">${person.time}</span>) : 
										</span>
										<div class="maijia_liuyan">
											<p>${person.content }</p>
										</div>
									</c:forEach>
									</div>
								</div>
								<input type="hidden" id="parseArray" value='${parseArray }'/>
								<ul class="personer_zp">
									<li>服务描述</li>
									<li class="personer_js"><textarea id="orderRequest" placeholder="对自己进行简单的介绍..." ></textarea></li>
								</ul>
								<ul class="personer_fb">
									<li>发票信息</li>
										<input type="hidden" id="orderIsbill" value="${obj.orderIsbill }" />
										<li><input type="radio" name="orderIsbill" onclick="invoice()" value="1" /> 开具发票</li>
										<li><input type="radio" name="orderIsbill" onclick="noinvoice()" value="0" checked="checked" /> 不开发票
									</li>
								</ul>
								<ul id="describe" class="personer_zp" style="display:none">
									<li>发票描述</li>
									<li class="personer_js"><textarea id="orderBillcontent" placeholder="发票描述..." >${obj.orderBillcontent }</textarea></li>
								</ul>
								<ul id="address" class="personer_mes_zl_ms" style="display:none">
									<li>发票地址</li>
									<li class="mes_input">
										<input id="orderBilladdr" type="text" placeholder="发票地址" value="${obj.orderBilladdr }"/>
									</li>
									<li id="orderBilladdricon"></li>
								</ul>
							</div>
							<div class="personer_excit">
					<div class="excit" style="cursor:pointer" onclick="submit()">确认修改</div>
				</div>
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
	</body>
</html>