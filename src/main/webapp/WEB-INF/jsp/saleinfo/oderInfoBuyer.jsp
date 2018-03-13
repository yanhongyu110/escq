<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的预约</title>
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<script type="text/javascript" src="${webtxc}/js/jquery-1.11.3.min.js"></script>
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		<link rel="stylesheet" href="${webtxc}/css/page.css" />
		
		
		<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
		<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/saleinfo/orderInfoBuyer.js?v=20171sd701"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$(".saixuan").click(function() {
					$(".saixuan_lei").toggle();
				});
			});
		</script>
	</head>

	<body>
		<c:set var="istop" value="true" />
		<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
			
			<!--end.personal-->
			<div class="content">
			<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
				
				<div class="content-right">
					<div class="personal_zhanshi">
						<a class="fachu">发出的预约（<span id="totalNum"></span>）</a>
						<!-- <a class="shoudao">收到的预约（12）</a> -->
					</div>
					<div class="personal_zhanshi_tab">
						<div class="title cf">
							<ul class="title-list fr cf ">
								<li id="li1" class="on">全部</li>
								<li id="li2">待确认</li>
								<li id="li3">待付款</li>
								<li id="li4">待完成</li>
								<li id="li5">待评价</li>
								<li id="li6">已完成</li>
								<p></p>
							</ul>
						</div>
						<div class="personal_zhanshi_tab_product">
							<div class="product_dd show">
								<div class="product_seach">
									<input type="text" placeholder="请输入订单编号" id="title" class="sous" />
									<input type="button"  class="btn" onclick="sub(-1);" />
									<a class="saixuan">精简筛选条件 <b></b></a>
									<div class="saixuan_lei">
										<div class="saixuan_lei_z">
											<div class="sx_time">
												<label>成交时间</label><input type="text" editable="false" class="sx_time_ks" id="startDate" /><span> - </span><input editable="false" class="sx_time_js " id="endDate" />
											</div>
											<div class="s_fuwu_lei">
											    <label>交易状态</label>
												<select id="orderState" editable="false" style="height:33px" class="easyui-combobox s_fuwu_lei_select" data-options="panelHeight:'auto'">
													<option value="">全部</option>
													<option value="0">待确认</option>
													<option value="1">服务商否定</option>
													<option value="2">待支付</option>
													<option value="3">已取消</option>
													<option value="4">待服务</option>
													<option value="5">待评价</option>
													<option value="6">已完成</option>
												</select>
												<label>是否开发票</label>
												<select id="orderIsbill" editable="false" style="height:33px;" class="easyui-combobox s_fuwu_lei_select" data-options="panelHeight:'auto'">
													<option value="">全部</option>
													<option value="1">是</option>
													<option value="0">否</option>
												</select>
												
												<!-- <label>评价状态</label>
												<select class="s_fuwu_lei_select">
													<option>暂无评价</option>
													<option></option>
													<option></option>
												</select> -->
											</div>
										</div>
										<!--end.saixuan_lei_z-->
									</div>
									<!--end.saixuan_lei-->
								</div>
								<!--end.product_seach-->
								<div class="pe_dan">
									<table cellpadding="0" cellspacing="0" class="pe_dan_title"> 
										<tr>
											<td width="35%">约单详情</td>
											<td width="10%">商品总价</td>
											<td width="10%">数量</td>
											<td width="10%">交易状态</td>
											<td width="10%">总价</td>
											<td width="10%">评价</td>
										</tr>
									</table>
									<div id="pe_dan_list" class="pe_dan_list">
										
									</div>
								</div>
								<!--end.pe_dan-->

							</div>
							<!--end.product-->
						</div>
						<!--end.personal_zhanshi_tab_product-->
					</div>
					<!--end.personal_zhanshi_tab-->
					<div class="jogger">
						<div id="fy"></div>
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