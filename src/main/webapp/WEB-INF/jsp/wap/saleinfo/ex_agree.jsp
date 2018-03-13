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
		<meta content="yes" name="apple-mobile-web-app-capable">
		<!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
		<meta name="apple-touch-fullscreen" content="yes">
		<!-- 开启对web app程序的支持  -->
		<meta content="telephone=no,email=no" name="format-detection">
		<!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
		<!--base css-->
		<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
		<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
		<link rel="stylesheet" href="${webtxc }/css/wap/reset.css" />
		<link rel="stylesheet" href="${webtxc }/css/wap/personer.css" />
		<style type="text/css">
			.personer_mes_zl_ms{overflow: hidden;height: auto!important;}
		</style>
		<script src="${webtxc }/js/wap/reset.js"></script>
		<script src="${webtxc }/js/wap/TouchSlide.js"></script>
		<script src="${webtxc }/myjs/wap/saleinfo/ex_agree.js"></script>
		<script type="text/javascript">
			var orderNo  = '${obj.orderNo }';
		</script>
	</head>

	<body>
		<!--wapper-->
		<div class="wapper">
			<!--page-->
			<div id="page">
				<div class="personer_top">
					<h3>专家确认</h3>
					<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
				</div>

				<div class="my_date_bt">

					<div class="service_content">
						<div class="service_content_pj show">
							
								<!-- <div class="my_zh_title_left nomargin">	
									<h4>您已申请预约<span>caoxudong</span>，请及时操作。<br>申请预约并经专家确认后才可以付款，以保障服务的质量。<span>同意约见</span></h4>
							</div> -->
							<c:forEach var="os" items="${obj.orderService}" varStatus="vs">
							<div class="personer_mes" style="padding-bottom:10px;">
								<form class="fom">
									<input type="hidden" name="osId" value="${os.osId }" />
									<input type="hidden" name="osPrice" value="${os.osPrice }" />
									<input type="hidden" name="osPoint" value="${os.osPoint }" />
									<input type="hidden" name="osGoodsNum" value="${os.osGoodsNum }" />
								</form>
								<ul class="my_date have_border">
									<li class="my_date_img"><img src="${os.serviceInfo.servicePic}"></li>
									<li class="my_date_title">
										<h3>${os.serviceInfo.serviceTitle}</h3>
										<p id="price${vs.index }" class="price">${os.osPrice} </p>
									</li>
									<li class="my_date_zt">
										<p>${orderState }</p>
										<span>${obj.orderCreatetimestr }</span>
									</li>

								</ul>

							</div>
							</c:forEach>
							<!--end.personer_mes-->

					
							<div class="personer_mes_zl">
								<ul class="personer_mes_zl_ms have_border">
									<li>预约时间</li>
									<li class="mes_input">
										${obj.orderMeettimestr }
									</li>
									
								</ul>
								<ul class="personer_mes_zl_ms">
									<li>联系人</li>
									<li class="mes_input">
										${obj.orderPerson }
									</li>
								</ul>
								<ul class="personer_mes_zl_ms">
									<li>联系方式</li>
									<li class="mes_input">
										${obj.orderPersoncell }
									</li>
								</ul>
								<ul class="personer_mes_zl_ms xinzeng_css">
									<li>服务描述</li>
									<li class="order_confirm">
										<c:forEach var="person" items="${parseArray }">
												<p>${person.type==0?"买家":"卖家" } : ${person.content }<font class="time">${person.time}</font></p>
										</c:forEach>
									</li>
								</ul>
								<input type="hidden" id="parseArray" value='${parseArray }'/>
								<ul class="personer_mes_zl_ms xinzeng_css">
									<li>退回描述</li>
									<li class="tuihui_textarea"><textarea id="orderRequest"  placeholder="退回描述..." ></textarea></li>
								</ul>
								
								<c:if test="${obj.orderIsbill }">
									<ul class="personer_fb">
										<li>发票信息</li>
										<li>
										开具发票
									</li>
									</ul>
									<ul class="personer_mes_zl_ms">
										<li>发票地址</li>
										<li class="mes_xq">
											${obj.orderBilladdr }
										</li>
									</ul>
								</c:if>
							</div>
							<div class="personer_excit">
					<div id="sub" class="excit" style="margin-bottom:10px;" onclick="agree('${obj.orderId}','${obj.orderSeller}')">同意约见</div>
					<div id="sub" class="excit" onclick="returnedit('${obj.orderId}','${obj.orderSeller}')">退回修改</div>
					<div class="cz" onclick="cancelOrder();">取消约见</div>
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