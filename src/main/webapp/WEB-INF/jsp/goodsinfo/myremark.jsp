<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
<link rel="stylesheet" href="${webtxc}/css/public.css" />
<link rel="stylesheet" href="${webtxc}/css/personal.css" />
<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
<title>我的评价</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<script type="text/javascript">
	var logId = '${logId}';
	$(function() {
		$('.vconlist li>a').click(function() {
			if ($(this).html().trim() == "我的评价") {
				selectallbytim(null, 3, 4);
			}
		});
		$('#test1 td').click(function() {
			console.log($(this).index());
			console.log($(this).parent().index());
		});
		function selectallbytim(logId, srLevel, createtime) {
			$
					.ajax({
						type : "POST",
						dataType : "json",
						url : path
								+ "/goodsinfo/service/querycountserviceremarkbytime.html",
						data : {
							"logId" : logId,
							"srLevel" : srLevel,
							"createtime" : createtime
						},
						success : function(data) {
							var k = 0;
							for (var i = 2; i <= srLevel + 2; i++) {
								for (var j = 2; j <= createtime + 2; j++) {
									$(
											".admin_pl_table tr:nth-child(" + i
													+ ") td:nth-child(" + j
													+ ")").html(data[k]);
									if (k < data.length) {
										k++;
									}
								}
							}
						}
					})
		}
	});
</script>
<script type="text/javascript" src="${webtxc}/myjs/goodsinfo/myremark.js?value=12333243312"></script>
</head>
<body>
<c:set var="istop" value="true" />
	<%@include file="/WEB-INF/jsp/common/top.jsp"%>
	<div class="content">
		<jsp:include page="/WEB-INF/jsp/common/left.jsp" />
		<div class="content-right">
			<div class="expert_mes">
				<h2>我的评价</h2>
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
							<td>好评<br> </td>
							<td>${serviceRemarkcount[0] }</td>
							<td>${serviceRemarkcount[1] }</td>
							<td>${serviceRemarkcount[2] }</td>
							<td>${serviceRemarkcount[3] }</td>
							<td>${serviceRemarkcount[4] }</td>
						</tr>
						<tr>
							<td>中评<br> </td>
							<td>${serviceRemarkcount[5] }</td>
							<td>${serviceRemarkcount[6] }</td>
							<td>${serviceRemarkcount[7] }</td>
							<td>${serviceRemarkcount[8] }</td>
							<td>${serviceRemarkcount[9] }</td>
						</tr>
						<tr>
							<td>差评<br></td>
							<td>${serviceRemarkcount[10] }</td>
							<td>${serviceRemarkcount[11] }</td>
							<td>${serviceRemarkcount[12] }</td>
							<td>${serviceRemarkcount[13] }</td>
							<td>${serviceRemarkcount[14] }</td>
						</tr>
						<tr>
							<td>总计</td>
							<td>${serviceRemarkcount[15] }</td>
							<td>${serviceRemarkcount[16] }</td>
							<td>${serviceRemarkcount[17] }</td>
							<td>${serviceRemarkcount[18] }</td>
							<td>${serviceRemarkcount[19] }</td>
						</tr>
					</table>
				</div>
				<c:if test="${serviceRemarkcount[19]!=0 }">
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
				<c:if test="${serviceRemarkcount[19]==0 }">
				<div class="note_message" >
							<h3 ><Strong>暂无评价</Strong></h3><br>
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