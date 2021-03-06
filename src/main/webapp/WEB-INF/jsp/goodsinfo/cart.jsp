<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<html> 

	<head>
		<meta charset="UTF-8">
		<title>我的心愿</title>
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<script>
			var count=${infos.totalSize};
			var pageNo=${infos.page};
		</script>
		<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>

		<script type="text/javascript" src="${webtxc}/myjs/goodsinfo/cartlist.js?v=2s3z44gfg"></script>
		
	</head>

	<body>
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>
			<%-- <input id="serviceId" type="hidden" value="${info.list[0].serviceId}" />
			<input id="logId" type="hidden" value="${info.list[0].logId}" />
			<input id="jso" type="hidden" value="${info.list[0].scartComment}" />
			<input id="cartId" type="hidden" value="${info.list[0].scartId}" />  --%>
			
			<div class="content">
				<!-- <div class="content-left">
					<h2>个人主页</h2>
					<div class="personal_left_list">
						<div class="vtitle"><em class="v"></em>我的预约</div>
						<div class="vcon" style="display: none;">
							<ul class="vconlist clearfix">
								<li class="select">
									<a href="javascript:;">我的预约</a>
								</li>
								<li>
									<a href="javascript:;">资金托管</a>
								</li>
								<li>
									<a href="javascript:;">退款详情</a>
								</li>
								<li>
									<a href="javascript:;">服务评价</a>
								</li>

							</ul>
						</div>
						<div class="vtitle"><em class="v"></em>我的账户</div>
						<div class="vcon" style="display: none;">
							<ul class="vconlist clearfix">
								<li>
									<a href="javascript:;">提现方式</a>
								</li>
								<li>
									<a href="javascript:;">余额提现</a>
								</li>

							</ul>
						</div>
						<div class="vtitle"><em class="v"></em>专家资料</div>
						<div class="vcon" style="display: none;">
							<ul class="vconlist clearfix">
								<li>
									<a href="javascript:;">基本资料</a>
								</li>
								<li>
									<a href="javascript:;">认证资料</a>
								</li>
								<li>
									<a href="javascript:;">个人介绍</a>
								</li>
								<li>
									<a href="javascript:;">咨询主题</a>
								</li>
								<li>
									<a href="javascript:;">审核结果</a>
								</li>
								<li>
									<a href="javascript:;">实名提示</a>
								</li>
								<li>
									<a href="javascript:;">添加主题</a>
								</li>
								<li>
									<a href="javascript:;">推荐资料</a>
								</li>

							</ul>
						</div>
						<div class="vtitle"><em class="v"></em>系统消息</div>
						<div class="vcon" style="display: none;">

						</div>
						<div class="vtitle"><em class="v"></em>我的心愿</div>
						<div class="vcon" >
							<ul class="vconlist clearfix">
								<li class="select">
									<a href="javascript:;">我的心愿</a>
								</li>
							</ul>

						</div>
						<div class="vtitle"><em class="v"></em>基本资料</div>
						<div class="vcon" style="display: none;">
							<ul class="vconlist clearfix">
								<li>
									<a href="javascript:;">个人信息</a>
								</li>
								<li>
									<a href="javascript:;">实名认证</a>
								</li>
								<li>
									<a href="javascript:;">修改密码</a>
								</li>
								<li>
									<a href="javascript:;">咨询主题</a>
								</li>

							</ul>
						</div>
					</div>
				</div> -->
				
				<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
				<div class="content-right">
				
					<div class="my_like">
						<h2>我的心愿</h2>
						<c:forEach var="cart" items="${infos.list}">
							<div class="my_like_list"  style="overflow: hidden">
								<input type="hidden" id="scartId" value="${cart.scartId}" />
								<input type="hidden" id="logId" value="${cart.logId}" />
								<input type="hidden" name="service" value="${cart.serviceId}">
								<input type="hidden" name="type" value="${cart.scartSource}">
								<input type="hidden" name="num" value="${cart.scartNum}">
								<div class="my_like_list_img" onclick="window.location.href=path+'/goodsinfo/service/queryServiceDetails.html?serviceId=${cart.serviceId}&priceType=1'+'&comId='+g_comid">
									<img src="${cart.serviceSnapshot.serviceInfo.servicePic}"   />
								</div>
								<div class="my_like_list_title">
									<h3>${cart.serviceSnapshot.serviceInfo.serviceTitle}</h3>
									<p><span>${cart.providerName.piRealname }</span></p>
									<p cut="20"> 	${cart.serviceSnapshot.serviceInfo.serviceBiref }</p>
								</div>
								<div class="my_like_list_pay">
									<span>￥${cart.scartPrice}</span>
								</div>
								<div class="my_like_list_delete">
									<a href="javascript:void(0)" onclick="del(this)" class="delete_btn">删除心愿</a>
									<a href="javascript:void(0)"  class="go delete_yy">立即预约</a>
								</div>
							</div><!--end.my_like_list-->
						
						</c:forEach>

						<script>
							$('p[cut]').each(function(){
									var text = $(this).text();
									if (text.length > 80){
										$(this).text($(this).text().substring(0,80)+"...")
									}
							})
							$('.go').each(function(){
								var obj=$(this)
								obj.click(function(){
									var pp=obj.parents(".my_like_list")
									var serviceId=pp.find('input[name=service]').val()
									var num=pp.find('input[name=num]').val()
									var source=pp.find('input[name=type]').val()
									var catr=[{
										serviceId:serviceId,
										scartNum:num,
										scartSource:source
									}]
									window.location.href=encodeURI(path+'/saleinfo/order/viewAddOrder.html?cartList='+JSON.stringify(catr));
								})
							})
						</script>
						
						
					</div><!--end.my_like-->

					<div id="pageDiv" class="jogger">
						<!-- <span class="disabled">&lt; </span>
                        <span class="current">1</span>
                        <a href="#?page=2">2</a>
                        <a href="#?page=3">3</a>
                        <a href="#?page=4">4</a>
                        <a href="#?page=5">5</a>
                        <a href="#?page=6">6</a>
                        <a href="#?page=7">7</a>...
                        <a href="#?page=199">199</a>
                        <a href="#?page=200">200</a>
                        <a href="#?page=2">&gt; </a> -->
					</div>
				</div>

				<!--end.content-right-->
			</div>
			<!--end.content-->
			
			<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
		<!--end.contain-->
	</body>

</html>