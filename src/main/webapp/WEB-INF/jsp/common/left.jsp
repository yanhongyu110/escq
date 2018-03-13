<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<%--<script src="${webtxc}/anima/jcake.js"></script>--%>
			<div class="content-left">
				<h2>个人主页</h2>
				<div class="personal_left_list">
					<div class="vtitle">
						<em class="v"></em>我的预约
					</div>
					<div class="vcon" style="display: none;">
						<ul class="vconlist clearfix">
							<li><a href="${webtxc}/saleinfo/orderInfoBuyer/orderView.html">发出的预约</a></li>
							<c:if test="${sessionScope.logInfo.logType == 2}">
								<li><a href="${webtxc}/saleinfo/orderInfoSeller/viewOrder.html">收到的预约</a></li>
							</c:if>
						</ul>	
					</div>
					<div class="vtitle">
						<em class="v"></em>我的账户
					</div>
					<div class="vcon" style="display: none;">
						<ul class="vconlist clearfix">
							<li><a href="${webtxc}/details/AccountPaymentDetails/showIODetails.html">我的账户</a></li>
							<li><a href="${webtxc}/goodsinfo/service/queryAllCountServiceRemarkByTime.html">我的评价</a></li>
							<%-- <li><a href="${webtxc}/details/PointPaymentDetails/showPointIODetails.html">积分账户</a></li> --%>
							<li><a href="${webtxc}/userinfo/accountInfo/jumpModifyPayPass.html">修改支付密码</a></li>
						</ul>
					</div>
					<c:if test="${sessionScope.logInfo.logType == 2}">
						<div class="vtitle">
							<em class="v"></em>专家资料
						</div>
						<div class="vcon" style="display: none;">
							<ul class="vconlist clearfix">
								<li><a href="${webtxc}/checkinfo/providerCheck/getCheck.html">认证资料</a></li>
								<li><a href="${webtxc}/checkinfo/providerCheck/getBasic.html">基本信息</a></li>
								<li><a href="${webtxc}/goodsinfo/service/viewProviderService.html">我发布的服务</a></li>
								<%-- <li><a href="${webtxc}/goodsinfo/service/viewAddService.html">发布服务</a></li> --%>
								<li><a href="${webtxc}/userinfo/providerRecommend/jumpProviderRecommend.html">推荐资料</a></li>
								<li><a href="${webtxc}/userinfo/arrangement/jumparrangement.html">档期管理</a></li>
								<li><a href="${webtxc}/goodsinfo/service/queryServiceRemarkByLogId.html">服务评价</a></li>
								<li><a href="${webtxc}/bizinfo/focusutop/focuUsers.html">查看关注</a></li>
								<li><a href="${webtxc}/bizinfo/recommendptop/myRecommend.html">我的推荐</a></li>
							</ul>
						</div>
					</c:if>
					<div class="vtitle"><em class="v"></em>系统消息</div>
					<div class="vcon" style="display: none;">
						<ul class="vconlist clearfix">
							<li>
								<a href="${webtxc}/userinfo/queryAllSystemMes.html?smType=2">系统消息</a>
							</li>
							<li>
								<a href="${webtxc}/userinfo/queryAllSystemMes.html?smType=1">平台消息</a>
							</li>
						</ul>
					</div>
					<!-- <div class="vcon" style="display: none;"></div> -->
					<div class="vtitle">
						<em class="v"></em>我的关注
					</div>
					<div class="vcon" style="display: none;">
						<ul class="vconlist clearfix">
							<li><a href="${webtxc}/goodsinfo/cart/viewCart.html">心愿单</a></li>
							<li><a href="${webtxc}/bizinfo/focusutop/myFocus.html">关注表</a></li>
							<li><a href="${webtxc}/bizinfo/collectUtod/myCollects.html">收藏夹</a></li>
						</ul>

					</div>
					<div class="vtitle">
						<em class="v"></em>基本设置
					</div>
					<div class="vcon" style="display: none;">
						<ul class="vconlist clearfix">
							<li><a href="${webtxc}/userinfo/jumpmodifyUserInfo.html">个人资料</a></li>
							<li><a href="${webtxc}/checkinfo/perosonCheckName/viewAddPersonCheck.html">实名认证</a></li>
							<li><a href="${webtxc}/userinfo/jumpModifyPass.html">修改密码</a></li>

						</ul>
					</div>
					<div class="vtitle">
						<em class="v"></em>用户需求
					</div>
					<div class="vcon" style="display: none;">
						<ul class="vconlist clearfix">
							<li><a href="${webtxc}/demand/gotodemandAmind.html">需求列表</a></li>
							<li><a href="${webtxc}/demand/sa.html">需求发布</a></li>
						</ul>
					</div>

				</div>
			</div>

<%--<script>--%>
	<%--$(function(){--%>

		<%--$('.content').css({height:"auto",overflow:'hidden',position:"relative"})--%>

		<%--$.ScrollPoint($(".content-left").offset().top,function(){--%>
			<%--$(".content-left").css({position:'fixed',top:'0px',bottom:"auto"})--%>
		<%--},function(){--%>
			<%--$(".content-left").css("position","static")--%>
		<%--})--%>


		<%--$.ScrollPoint($(".footer").offset().top-$('.content-left').height(),function(){--%>
			<%--$(".content-left").css({position:'absolute',bottom:'0px',top:'auto'})--%>
		<%--},function(){--%>
			<%--$(".content-left").css({position:'fixed',top:'0px',bottom:"auto"})--%>
		<%--})--%>
	<%--})--%>
<%--</script>--%>