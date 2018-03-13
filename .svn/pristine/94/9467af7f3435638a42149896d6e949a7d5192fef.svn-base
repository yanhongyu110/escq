<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<meta charset="UTF-8">
		<title>我的账户</title>
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
		<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
		<link rel="stylesheet" type="text/css" href="${webtxc}/easyui/1.4.5/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${webtxc}/easyui/1.4.5/themes/icon.css" />
		<script type="text/javascript" src="${webtxc}/easyui/1.4.5/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${webtxc}/easyui/1.4.5/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript">
		var jsonList = ${jsonList};
		var count = ${count};
		</script>
		<script type="text/javascript" src="${webtxc}/myjs/details/pointPaymentDetails.js?v=2017010801"></script>
	</head>

	<body>
		<c:set value="true" var="istop"/>
		<%@include file="/WEB-INF/jsp/common/top.jsp"%>
			<%-- <div class=" personal">
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
			</div> --%>
			<!--end.personal-->
			<div class="content">
				<%@include file="/WEB-INF/jsp/common/left.jsp"%>
				<div class="content-right">
					<div class="expert_mes">
						<h2>我的账户</h2>
						<div class="my_zh">
							<div class="my_zh_title">
								<div class="my_zh_title_left">
									<c:if test="${!empty accList[0].accBalance}">
										<a>账户余额：<span>${accList[0].accBalance}</span>元</a>
									</c:if>
									<c:if test="${empty accList[0].accBalance}">
										<a>账户余额：<span>0</span>元</a>
									</c:if>
									<c:if test="${!empty accList[0].accPoint}">
										<a>积分：<span>${accList[0].accPoint}</span>分</a>
									</c:if>
									<c:if test="${empty accList[0].accPoint}">
										<a>积分：<span>0</span>分</a>
									</c:if>
									<div class="my_zh_title_right">
									<a class="btn">提现</a> <a class="cz">充值</a>
								    </div>
								</div>
								
							</div>
						</div><!--end.my_zh-->
						
						<div class="my_zh_list">
						<div >
							<span >一</span>
							<input name="startTime" id="startTime" type="text" class="easyui-datebox"/>
							<span >一</span>
							<input name="endTime" id="endTime" type="text" class="easyui-datebox"/>
							<span >一</span>
							<select id="cc" class="easyui-combobox" name="flag" >
							    <option value="d">请选择</option>
							    <option value="a">根据年</option>
							    <option value="b">根据月</option>
							    <option value="c">根据日</option>
							</select>
							<a href="javascript:void(0)" id="searchh" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="margin-right: 0px; margin-left: 5px;">确定</a>
						</div>
							<table id="mytable" cellpadding="0" cellspacing="0">
								<%-- <tr>
									<td style="width: 176px;">时间</td>
									<td style="width: 176px;">存入</td>
									<td style="width: 176px;">支出</td>
									<td style="width: 176px;">备注</td>
								</tr>
								<c:forEach items="${acDetailsList}" var="it">
									<tr>
										<td class="time">${it.apdCreatetimeStr}</td>
										<c:if test="${it.apdIotype==1}">
											<td class="cr">￥${it.apdAmount}</td>
											<td class="je">--</td>
										</c:if>
										<c:if test="${it.apdIotype==2}">
											<td class="cr">--</td>
											<td class="je">￥${it.apdAmount}</td>
										</c:if>
										<td class="bz">${it.apdComment}</td>
									</tr>
								</c:forEach> --%>
								
								<!-- <tr>
									<td class="time">2016-08-06 14：35：55</td>
									<td class="cr">￥1110</td>
									<td class="je">￥200</td>
									<td class="bz">订单返余额(原返返现) 订单号：19026371945,退款理由：, 审核备注：null, 返款金额：399.000, 退款途径：原返</td>
								</tr>
								<tr>
									<td class="time">2016-08-06 14：35：55</td>
									<td class="cr">￥1110</td>
									<td class="je">￥200</td>
									<td class="bz">订单返余额(原返返现) 订单号：19026371945,退款理由：, 审核备注：null, 返款金额：399.000, 退款途径：原返</td>
								</tr>
								<tr>
									<td class="time">2016-08-06 14：35：55</td>
									<td class="cr">￥1110</td>
									<td class="je">￥200</td>
									<td class="bz">订单返余额(原返返现) 订单号：19026371945,退款理由：, 审核备注：null, 返款金额：399.000, 退款途径：原返</td>
								</tr>
								<tr>
									<td class="time">2016-08-06 14：35：55</td>
									<td class="cr">￥1110</td>
									<td class="je">￥200</td>
									<td class="bz">订单返余额(原返返现) 订单号：19026371945,退款理由：, 审核备注：null, 返款金额：399.000, 退款途径：原返</td>
								</tr>
								<tr>
									<td class="time">2016-08-06 14：35：55</td>
									<td class="cr">￥1110</td>
									<td class="je">￥200</td>
									<td class="bz">订单返余额(原返返现) 订单号：19026371945,退款理由：, 审核备注：null, 返款金额：399.000, 退款途径：原返</td>
								</tr>
								<tr>
									<td class="time">2016-08-06 14：35：55</td>
									<td class="cr">￥1110</td>
									<td class="je">￥200</td>
									<td class="bz">订单返余额(原返返现) 订单号：19026371945,退款理由：, 审核备注：null, 返款金额：399.000, 退款途径：原返</td>
								</tr> -->
							</table>
							<p>系统仅保存近两年内明细信息</p>
						</div>
						
						
					</div><!--end.expert_mes-->
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
			<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
	</body>

</html>