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
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		<link rel="stylesheet" href="${webtxc}/css/page.css" />
		<script type="text/javascript" src="${webtxc}/js/jquery-1.11.3.min.js"></script>
		<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
		<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
		<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/saleinfo/orderInfoSeller.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$(".saixuan").click(function() {
					openDosearch();
					$(".saixuan_lei").toggle();
				});
			});
		</script>
	</head>
	<body>
		<c:set var="istop" value="true" />
		<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
		<div class="content">
				<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
				<div class="content-right">
					<div class="personal_zhanshi">
						<a class="shoudao">收到的预约（${orderCount}）</a>
					</div>
					<div class="personal_zhanshi_tab">
						<div class="title cf">
							<ul class="title-list fr cf ">
								<li class="on" onclick="initOrderInfoSellerPage()">全部</li>
								<li onclick="orderState(0)">待确认</li>
								<li onclick="orderState(2)">待付款</li>
								<li onclick="orderState(4)">待完成</li>
								<li onclick="orderState(5)">待评价</li>
								<li onclick="orderState(6)">已完成</li>
								<p></p>
							</ul>
						</div>
					<div class="personal_zhanshi_tab_product">
						<div class="product_dd show">
								<div class="product_seach">
									<input type="text" placeholder="请输入订单编号" id="orderTd" class="sous" />
									<input type="button"  class="btn" id="doSearch"/>
									<a class="saixuan">精简筛选条件 <b></b></a>
									<div class="saixuan_lei">
										<div class="saixuan_lei_z">
											<div class="sx_time">
												<label >成交时间</label><input type="text" editable="false" class="sx_time_ks" id="startTime" /><span>  -  </span><input editable="false" class="sx_time_js " id="endTime" />
											</div>
											<div class="s_fuwu_lei">
											<label >交易状态</label>
												<select id="orderState" class="easyui-combobox s_fuwu_lei_select" style="height:33px;" data-options="panelHeight:'auto',editable:false,width:165">
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
												<select id="orderIsbill" class="easyui-combobox s_fuwu_lei_select" style="height:33px;" data-options="panelHeight:'auto',editable:false">
													<option value="">全部</option>
													<option value="1">是</option>
													<option value="0">否</option>
												</select>
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
									<div id="pe_dan_lists">
										
									</div>
									<%-- <div class="pe_dan_list">
										<table cellpadding="0" cellspacing="0" > 
											<tr>
												<td width="62%"><input type="checkbox" name="" id="" value="" /><b>2017-01-03</b>订单号：2016080623566</td>
												<td width="15%"></td>
												<td width="11%"></td>
												<td width="12%" align="center" class="delete_s"><img src="${webtxc}/images/delate.png"></td>
											</tr>
											<tr>
												<td width="62%" >
													<div class="title_img_dd">
														<ul>
															<li><img src="${webtxc}/images/fw_03.jpg" width="140" ></li>
															<li class="dingdan">互联网产品 项目运营实战<br>重庆/江北/观音桥<br><span>约见2小时</span></li>
															<li class="shuliang">1</li>
														</ul>
													</div>
													<div class="title_img_dd">
														<ul>
															<li><img src="${webtxc}/images/fw_01.jpg" width="140" ></li>
															<li class="dingdan">互联网产品 项目运营实战<br>重庆/江北/观音桥<br><span>约见2小时</span></li>
															<li class="shuliang">1</li>
														</ul>
													</div>
											</td>	
											<td width="15%" align="center">已付款<br><a>查看详情</a></td>
											<td width="11%" align="center" class="zongjia">￥299.00<br><a>修改价格</a></td>
											<td width="12%" align="center">暂无<a class="pingjia">评价</a></td>
										</tr>
									</table>
								</div><!--end.pe_dan_list-->
								<div class="pe_dan_list">	
									<table cellpadding="0" cellspacing="0" > 
										<tr>
											<td width="62%"><input type="checkbox" name="" id="" value="" /><b>2017-01-03</b>订单号：2016080623566</td>
											<td width="15%"></td>
											<td width="12%" align="center" class="delete_s"><img src="${webtxc}/images/delate.png"></td>
										</tr>	
										<tr>
											<td width="62%" >
												<div class="title_img_dd">
													<ul>
														<li><img src="${webtxc}/images/fw_02.jpg" width="140" ></li>
														<li class="dingdan">互联网产品 项目运营实战<br>重庆/江北/观音桥<br><span>约见2小时</span></li>
														<li class="danjia">￥155.00</li>
														<li class="shuliang">1</li>
													</ul>
												</div>
											</td>
											<td width="15%" align="center">已付款<br><a>查看详情</a></td>
											<td width="11%" align="center" class="zongjia">￥299.00<br><a>修改价格</a></td>
											<td width="12%" align="center">暂无<a class="pingjia">评价</a></td>
										</tr>
									</table>
								</div><!--end.pe_dan_list--> --%>
							</div>
							<!--end.pe_dan-->
						</div>	
						<!--end.product-->
					</div>
					<!--end.personal_zhanshi_tab_product-->
				</div>
				<!--end.personal_zhanshi_tab-->
				<div class="jogger">
						<div id="pagediv" style="display: inline-block;"></div>
				</div>
			</div>
			<!--end.content-right-->
			</div>
			<!--end.content-->
			
			<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
		</div>
<!--end.contain-->
	</body>

</html>