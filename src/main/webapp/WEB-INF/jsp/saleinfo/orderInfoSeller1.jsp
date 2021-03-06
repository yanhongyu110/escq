<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<title>我的预约</title>
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		<script type="text/javascript" src="${webtxc}/myjs/saleinfo/personal_tab.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/saleinfo/personal_menu.js"></script>
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
		<div class="contain">
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>
			<div class=" personal">
				<div class="content_top">
					<div class="content_top_message">
						<div class="content_top_left">
							<img src="${webtxc}/images/fw_01.jpg" width="90" />
						</div>
						<div class="content_top_center">
							<a>下午好，王小二</a>
							<span>高级网站策划/重庆江北</span> <span>手机：156833338999</span>
							<div class="service_rz">
								<a class="service_jp">金牌</a>
								<a class="service_qy">签约</a>
							</div>
						</div>
						<div class="content_top_right">
							<div class="messages">
								<ul>
									<li>
										<p>您的等级</p>
										<p><b>银牌（3156/10000）</b> </p>
									</li>
									<li>
										<p>您的积分</p>
										<p>
											<font>23333分</font>
										</p>
									</li>
									<li>
										<p>您的余额</p>
										<p><span>￥966183.36</span> </p>
									</li>
								</ul>
							</div>
						</div>
					</div>

				</div>
			</div> 
			
			<!--end.personal-->
			<div class="content">
				<div class="content-left">
					<h2>个人主页</h2>
					<div class="personal_left_list">
						<div class="vtitle"><em class="v v02"></em>我的预约</div>
						<div class="vcon">
							<ul class="vconlist clearfix">
								<li class="select">
									<a href="javascript:selectCommonAjax(1);">我的预约</a>
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
						<div class="vcon" style="display: none;">

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
				</div>
				<div class="content-right">
					<div class="personal_zhanshi">
						<a class="fachu">收到的预约（${orderCount} ）</a>
					</div>
					<div class="personal_zhanshi_tab">
						<div class="title cf">
							<ul class="title-list fr cf ">
								<li class="on" onclick="initOrderInfoSellerPage()">全部</li>
								<li onclick="orderState(1)">待确认</li>
								<li onclick="orderState(2)">待付款</li>
								<li onclick="orderState(3)">待完成</li>
								<li onclick="orderState(4)">待评价</li>
								<li onclick="orderState(5)">已完成</li>
								<p></p>
							</ul>
						</div>
						<div class="personal_zhanshi_tab_product">
							<div class="product show">
								<div class="product_seach">
									<input type="text" value="请输入标题或订单编号" id="title" class="sous" />
									<input type="button"  class="btn" id="doSearch"/>
									<a class="saixuan" >精简筛选条件 <b></b></a>
									<div class="saixuan_lei">
										<div class="saixuan_lei_z">
											<div class="sx_time">
												<label style="margin-right:12px;">成交时间</label><input type="text" editable="false" class="sx_time_ks" id="startTime" /><span> - </span><input editable="false" class="sx_time_js " id="endTime" />
											</div>
											<div class="s_fuwu_lei">
												<label style="margin-right:8px;">是否开发票</label>
												<select id="orderIsbill" class="easyui-combobox s_fuwu_lei_select" data-options="panelHeight:'auto',editable:false">
													<option value="">全部</option>
													<option value="1">是</option>
													<option value="0">否</option>
												</select>
												<label style="margin-left:34px;">交易状态</label>
												<select id="orderState" class="easyui-combobox s_fuwu_lei_select" data-options="panelHeight:'auto',editable:false">
													<option value="">全部</option>
													<option value="1">已付款</option>
													<option value="0">未付款</option>
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
									<div class="pe_dan_title">
										<div>约单详情</div>
										<div>数量</div>
										<div>状态</div>
										<div>价格</div>
									</div>
									<!--end.pe_dan_title-->

			
									<div id="pe_dan_lists" class="pe_dan_list">
										<%-- <div class="xq_title">
											<b>2016-12-14</b><span>订单号: 2841874685416455</span>
										</div>
										<div class="pe_dan_list_xq">
											<div class="xq_img">
												<div class="xq_img_left"><img src="${webtxc}/images/fw_01.jpg" width="150"></div>
												<div class="xq_img_right">
													<a><b>互联网产品 项目运营实战</b></a><br>
													<a>重庆市/江北区/大石坝</a><br>
													<a><span>2016-08-09 14:30  约2小时</span></a>
												</div>
											</div>
											<!--end.xq_img-->
											<div class="pe_dan_list_jg">
												<div>￥1000.00</div>
											</div>
											<div class="pe_dan_list_jg">
												<div>交易成功</div>
											</div>
											<div class="pe_dan_list_jg">
												<div><b>￥1000.00</b></div>
											</div>
											<div class="pe_dan_list_jg">
												<div class="delete">
													<p>
														<a>详情</a>
													</p>
													<p>
														<a>编辑</a>
													</p>
													<p>
														<a>评价</a>
													</p>
													<p>
														<a>删除</a>
													</p>
												</div>
											</div>
										</div>
										<!--end.pe_dan_list_xq-->
										<div class="pe_dan_list_xq">

											<div class="xq_img">
												<div class="xq_img_left"><img src="${webtxc}/images/fw_03.jpg" width="150"></div>
												<div class="xq_img_right">
													<a><b>互联网产品 项目运营实战</b></a><br>
													<a>重庆市/江北区/大石坝</a><br>
													<a><span>2016-08-09 14:30  约2小时</span></a>
												</div>

											</div>
											<!--end.xq_img-->

											<div class="pe_dan_list_jg" >
												<div >￥1000.00</div>
											</div>
											<div class="pe_dan_list_jg">
												<div >交易成功</div>
											</div>
											<div class="pe_dan_list_jg">
												<div><b>￥1000.00</b></div>
											</div>
											<div class="pe_dan_list_jg">
												<div class="delete">
													<p>
														<a>详情</a>
													</p>
													<p>
														<a>编辑</a>
													</p>
													<p>
														<a>评价</a>
													</p>
													<p>
														<a>删除</a>
													</p>
												</div>
											</div>
											

										</div> --%>
										<!--end.pe_dan_list_xq-->
										

									</div><!--end.pe_dan_list-->
									<%-- <div class="pe_dan_list">
										<div class="xq_title">
											<b>2016-12-14</b><span>订单号: 2841874685416455</span>
										</div>
										<div class="pe_dan_list_xq">

											<div class="xq_img">
												<div class="xq_img_left"><img src="${webtxc}/images/fw_02.jpg" width="150"></div>
												<div class="xq_img_right">
													<a><b>互联网产品 项目运营实战</b></a><br>
													<a>重庆市/江北区/大石坝</a><br>
													<a><span>2016-08-09 14:30  约2小时</span></a>
												</div>

											</div>
											<!--end.xq_img-->

											<div class="pe_dan_list_jg">
												<div>￥1000.00</div>
											</div>
											<div class="pe_dan_list_jg">
												<div>交易成功</div>
											</div>
											<div class="pe_dan_list_jg">
												<div><b>￥1000.00</b></div>
											</div>
											<div class="pe_dan_list_jg">
												<div class="delete">
													<p>
														<a>详情</a>
													</p>
													<p>
														<a>编辑</a>
													</p>
													<p>
														<a>评价</a>
													</p>
													<p>
														<a>删除</a>
													</p>
												</div>
											</div>
											

										</div><!--end.pe_dan_list_xq-->
										
										

									</div> --%><!--end.pe_dan_list-->
									

								</div><!--end.pe_dan-->

							</div>
							<!--end.product-->
						</div>
						<!--end.personal_zhanshi_tab_product-->
					</div>
					<!--end.personal_zhanshi_tab-->
					<div class="jogger">
						<div id="pagediv" style="display: inline-block;">
							<!-- <span class="disabled">上一页 </span>
							<span class="current">1</span>
							<a href="javascript:selectCommonAjax(2);">2</a>
							<a href="#?page=3">3</a>
							<a href="#?page=4">4</a>
							<a href="#?page=5">5</a>																												
							<a href="#?page=200">末页</a>
							<a href="#?page=2">下一页 </a>
							<input type="text"  id="" value="" placeholder="1" />
							<a href="#">跳转到</a> -->
						</div>
					</div>
				</div>
				<!--end.content-right-->
			</div>
			<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
		<!--end.contain-->
		</div>
	</body>

</html>