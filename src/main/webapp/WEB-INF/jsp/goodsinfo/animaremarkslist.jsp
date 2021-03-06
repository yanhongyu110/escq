<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
<link rel="stylesheet" href="${webtxc}/css/public.css" />
<link rel="stylesheet" href="${webtxc}/css/personal.css" />
<script type="text/javascript" src="${webtxc}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
<script type="text/javascript" src="${webtxc}/myjs/goodsinfo/animaremarkslist.js?value=12333243312"></script>

<title>对我的评价</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<script type="text/javascript">
var logId = '${logId}';
	$(function() {
		
		$('#test1 td').click(function() {
			console.log($(this).index());
			console.log($(this).parent().index());
		});
	});
</script>
</head>
<body>
<c:set var="istop" value="true" />
<%@include file="/WEB-INF/jsp/common/top.jsp" %>
<!-- start.content -->
<div class="content">
    <%@ include file="/WEB-INF/jsp/common/left.jsp" %>
    <div class="content-right">
        <div class="expert_mes">
				<h2>对我的评价</h2>
				<div class="fw_pj_list">
					<div class="fw_pj_list_title">
						<ul>
							<li>服务商平均评分：<span><f:formatNumber pattern="#" type="number" value="${providerInfo.piMark}"/></span></li>
							<c:if test="${providerRemarkcount[19]==0 }">
							<li>好评率：<span>100%</span></li>
							</c:if>
							<c:if test="${providerRemarkcount[19]!=0 }">
							<li>好评率：<span><f:formatNumber type="PERCENT" maxFractionDigits="2" value="${(providerRemarkcount[4]/providerRemarkcount[19])}"/></span></li>
							</c:if>
						</ul>
					</div>

					<!--end.fw_pj_list_title-->
				</div>
				<!--end.fw_pj_list-->
				<div class="admin_pl_table">
					<table>
						<tr>
							<td>全部评价</td>
							<td>最近1周</td>
							<td>最近1个月</td>
							<td>最近6个月</td>
							<td>6个月前</td>
							<td>总计</td>
						</tr>
						<tr>
							<td>好评<br></td>
							<td>${providerRemarkcount[0] }</td>
							<td>${providerRemarkcount[1] }</td>
							<td>${providerRemarkcount[2] }</td>
							<td>${providerRemarkcount[3] }</td>
							<td>${providerRemarkcount[4] }</td>
						</tr>
						<tr>
							<td>中评<br></td>
							<td>${providerRemarkcount[5] }</td>
							<td>${providerRemarkcount[6] }</td>
							<td>${providerRemarkcount[7] }</td>
							<td>${providerRemarkcount[8] }</td>
							<td>${providerRemarkcount[9] }</td>
						</tr>
						<tr>
							<td>差评<br></td>
							<td>${providerRemarkcount[10] }</td>
							<td>${providerRemarkcount[11] }</td>
							<td>${providerRemarkcount[12] }</td>
							<td>${providerRemarkcount[13] }</td>
							<td>${providerRemarkcount[14] }</td>
						</tr>
						<tr>
							<td>总计</td>
							<td>${providerRemarkcount[15] }</td>
							<td>${providerRemarkcount[16] }</td>
							<td>${providerRemarkcount[17] }</td>
							<td>${providerRemarkcount[18] }</td>
							<td>${providerRemarkcount[19] }</td>
						</tr>
					</table>
				</div>
				<c:if test="${providerRemarkcount[19]!=0 }">
				<div class="service_content_pj_list">
				
					<div class="select_pj">
						<input type="radio" name="service_pj" value="0,1,2" checked/>全部(<span id="total0"></span>)<input type="radio" name="service_pj" value="0"/>好评(<span id="total1"></span>)<input type="radio" name="service_pj" value="1"/>中评(<span id="total2"></span>)<input type="radio" name="service_pj" value="2"/>差评(<span id="total3"></span>)
					</div>
								
					<div class="sr_content"></div>
								
					<div class="jogger">
						<div id="fy" style="display: inline-block;">
											
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${providerRemarkcount[19]==0 }">
				<div class="note_message" >
							<h3><Strong>暂无评价</Strong></h3><br>
							</div>
				</c:if>

			</div>
			<!--end.expert_mes-->
			<div class="jogger weizhi">
			<!-- 分页 -->
			</div>

		</div>
		<!--end.content-right-->
	</div>

	<jsp:include page="/WEB-INF/jsp/common/bottom.jsp" />
</body>
</html>