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
		<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		
		<script type="text/javascript" src="${webtxc}/js/jquery-1.11.3.min.js"></script>
		<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
		<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/saleinfo/orderInfoSeller.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$(".saixuan").click(function() {
					$(".saixuan_lei").toggle();
				});
			});
		</script>
	</head>

	<body>
		<!-- <div class="contain"> -->
		<c:set var="istop" value="true" />
		<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
			<%-- <div class="global-nav">
				<div class="container">
					<div class="global-nav-left">欢迎来到近到家互联网专家平台！</div>
					<div class="global-nav-right">

						<div class="dropdown ">
							<a href="#" class="dropdown-main"><span>18602365305</span> <i class="allow_down"></i> </a>

							<div class="dropdown-sub" style="display:none;">
								<div class="dropdown-sub_box">
									<div class="dropdown_mes">
										<div class="dropdown_mes_left"><img src="${webtxc}/images/tximg.jpg"></div>
										<div class="dropdown_mes_right">
											<h3>18602365305</h3>
											<a class="service_jp">金牌</a>
											<a class="service_qy">签约</a>
										</div>
									</div>
									<div class="dropdown_mes_list">
										<a class="sz">个人设置</a>
										<a class="sc">我的收藏</a>
										<a class="zh">我的账户</a>
										<a class="xx">我的消息</a>
										<a class="tc">退出</a>
									</div>

								</div>
							</div>

						</div>
						<a class="global-nav-right_a" href="#">服务商认证</a>
					</div>
				</div>
			</div>
			<div class="seach">
				<div class="s_left">
					<img src="${webtxc}/images/logo.png" />
				</div>
				<div class="s_center">
					<div class="s_center_top">
						<div class="header-search">
							<div class="search-select">
								<label class="J-Search-Label">
                            <select>
                            	<option>北京</option>
                            	<option>重庆</option>
                            	<option>上海</option>
                            	<option>天津</option>
                            </select>
							</label>
								<ul class="J-Type-List" style="display: none;">
									<li>找小区</li>
									<li>装修知识</li>
									<li>效果图</li>
								</ul>
							</div>
							<input class="header-search-input J-Search-Input" placeholder="大家都在搜“产品经理”" type="text"><span class="header-search-submit J-Search-Btn">搜 索</span>
						</div>
					</div>
					<!--end.s_center_top-->
					<div class="s_center_bottom">
						<h4>热搜：<a class="a_dq">服务</a>  <a>专家</a></h4>
					</div>
				</div>
				<div class="s_right">
					<img src="${webtxc}/images/400.png" />
				</div>
			</div>
			<!--end.seach-->
			<div class="navi">
				<div class="nav_dh">
					<ul>
						<li>
							<a class="nav_dh_face">首页</a>
						</li>
						<li>需求策划</li>
						<li>市场调研</li>
						<li>产品设计</li>
						<li>美工设计</li>
						<li>技术开发</li>
						<li>网站测试</li>
						<li>产品运营</li>
					</ul>
				</div>
			</div> --%>
			<%-- <div class=" personal">
				<div class="content_top">
					<div class="content_top_message">
						<div class="content_top_left">
							<img src="${webtxc}/images/fw_01.jpg" width="90" />
						</div>
						<div class="content_top_center">
							<a>下午好，王小二</a>
							<span>高级网站策划/重庆江北</span> <span><font>手机：156833338999</font></span>
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
										<p><span>￥983.36</span> </p>
									</li>
								</ul>
							</div>
						</div>
					</div>

				</div>
			</div> --%>
			<!--end.personal-->
			<div class="content">
				<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
				<!-- <div class="content-left">
					<h2>个人主页</h2>
					<div class="personal_left_list">
						<div class="vtitle"><em class="v v02"></em>我的预约</div>
						<div class="vcon">
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
				</div> -->
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
							<div class="product_dd show">
								<div class="product_seach">
									<input type="text" value="请输入您要搜索的关键词" id="orderTd" class="sous" />
									<input type="button" style="position:relative;top:13px;" class="btn" id="doSearch"/>
									<a class="saixuan">精简筛选条件 <b></b></a>
									<div class="saixuan_lei">
										<div class="saixuan_lei_z">
											<div class="sx_time">
												<label>成交时间</label><input type="text" value="开始时间" class="sx_time_ks" /> <input type="text" value="结束日期" class="sx_time_js" />
											</div>
											<div class="s_fuwu_lei">
												<label>服务类型</label>
												<select class="s_fuwu_lei_select">
													<option></option>
													<option></option>
													<option></option>
												</select>
												<label>交易状态</label>
												<select class="s_fuwu_lei_select">
													<option>已付款</option>
													<option>代付款</option>
													<option></option>
												</select>
												<label>评价状态</label>
												<select class="s_fuwu_lei_select">
													<option>暂无评价</option>
													<option></option>
													<option></option>
												</select>
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
										<div>价格</div>
										<div>状态</div>
										<div>总价</div>
										<div>操作</div>
									</div>
									<!--end.pe_dan_title-->

									<div class="pe_dan_list">
										<div class="xq_title">
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

									</div>
									<!--end.pe_dan_list-->
									<div class="pe_dan_list">
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

										</div>
										<!--end.pe_dan_list_xq-->

									</div>
									<!--end.pe_dan_list-->

								</div>
								<!--end.pe_dan-->

							</div>
							<!--end.product-->
						</div>
						<!--end.personal_zhanshi_tab_product-->
					</div>
					<!--end.personal_zhanshi_tab-->
					<div class="jogger">
						<span class="disabled">&lt; </span>
						<span class="current">1</span>
						<a href="#?page=2">2</a>
						<a href="#?page=3">3</a>
						<a href="#?page=4">4</a>
						<a href="#?page=5">5</a>
						<a href="#?page=6">6</a>
						<a href="#?page=7">7</a>...
						<a href="#?page=199">199</a>
						<a href="#?page=200">200</a>
						<a href="#?page=2">&gt; </a>
					</div>
				</div>
				<!--end.content-right-->
			</div>
			<!--end.content-->
			<div class="footer">
				<div class="footer_top">
					<div class="footer_logo"><img src="${webtxc}/images/logo2.png"></div>
					<div class="footer_contact">
						<p>咨询电话：(周一至周五9:00-18:00)
							<br>０２３－４５６７７７
							<br>邮箱：biz@iyenei.com
							<br>邮编：310000
							<br>地址：重庆市渝北区文一西路崇义路口公元里7幢6楼</p>
					</div>
					<div class="footer_ewm">
						<img src="${webtxc}/images/ewm.jpg" align="right" /> <img src="${webtxc}/images/ewm.jpg" align="right" />
					</div>
				</div>
			</div>
			<div class="footer_bottom">
				<div class="footer_bottom_about">
					<ul>
						<li>首页 | 关于我们 | 常见问题 | 服务保障</li>
						<li class="dz">重庆捷路科技有限公司 Copyright © 2015 ECJia(ecjia.com) 版权所有，并保留所有权利。</li>
					</ul>
				</div>
			</div>
		</div>
		<!--end.contain-->
	</body>

</html>