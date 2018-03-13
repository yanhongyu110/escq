<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>实名认证</title>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<%@ include file="/WEB-INF/jsp/common/kindeditor.jsp"%>
<link rel="stylesheet" href="${webtxc }/css/public.css" />
<link rel="stylesheet" href="${webtxc }/css/personal.css" />
<script type="text/javascript" src="${webtxc }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${webtxc }/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc }/js/personal_menu.js"></script>
<script type="text/javascript" src="${webtxc }/myjs/checkinfo/personcheck.js?v=32123221233122343334"></script>

</head>

	<body>
	<c:set var="istop" value="true" />
			<%@include file="/WEB-INF/jsp/common/top.jsp" %>
			<div class="content">
				<%@include file="/WEB-INF/jsp/common/left.jsp" %>
				<div class="content-right">
					<div class="expert_mes">
						<h2>实名认证</h2>
						<p class="ts_messages" id="msg_con">${content}</p>
						<div class="my_zl_gr">							
							<ul>
								<li class="mc">真实姓名：</li>
								<li><input type="text" id="name" class="gr_input" placeholder="请输入真实姓名" value="${personCheckname1.pcnRelname }"  ></li>
								<span style="margin-left: 120px" id="nameicon" ></span>
							</ul>
							<ul>
								<li class="mc">身份证号：</li>
								<li><input type="text" class="gr_input" id="idcard" placeholder="请输入身份证号码" value="${personCheckname1.pcnIdnumber }"></li>
								<span style="margin-left: 120px" id="idcardicon" ></span>
							</ul>
							
							
							<ul>
								<li class="mc">身份证：</li>
								<input id="sfzimg" type="hidden" value='${personCheckname1.pcnFrontid }' />
								<li class="tx_sc" id="image1"><img  alt="" src=""></li>
								<li class="tx_sc"  id="image2"><img  alt="" src=""></li>
								<li class="tts">请上传真实有效的<font>身份证正反照</font>，单个照片大小不超过<font>1M</font>。</li>

								<%--<li style="width:80%;clear:left;margin-left: 120px" class="tts">--%>
									<%--<input type="button" id="idCardBtnJust" value="&nbsp;&nbsp;&nbsp; 上传身份证正面  &nbsp;&nbsp;&nbsp;&nbsp;" />&nbsp;&nbsp;&nbsp;&nbsp;--%>
									<%--<input type="button" id="idCardBtnBack" value="&nbsp;&nbsp;&nbsp; 上传身份证反面 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" />--%>
								<%--</li>--%>

							</ul>
							<ul>
								<li class="mc">手持身份证：</li>
								<li class="tx_sc"  id="image3"><img  alt="" src="${personCheckname1.pcnReverseid }"></li>
								<li class="tts">请上传真实有效的<font>手持身份证</font>照片，单个照片大小不超过<font>1M</font>。</li>
								<%--<li style="clear: left;margin-left: 120px" class="tts">--%>
									<%--<input type="button" id="idCardBtnHold" value="&nbsp;&nbsp;&nbsp;&nbsp; 上传手持身份证 &nbsp;&nbsp;&nbsp;&nbsp;" />--%>
								<%--</li>--%>
								<li style="width:80%;clear:left;margin-left: 120px;margin-top: 10px" class="tts"><span id="sfwarning">&nbsp;</span></li>
							</ul>
							<ul>
								<li class="mc"></li>
								<li class="my_zl_bc" style="cursor:pointer" onclick="submit(${content==null})">提交</li>
							</ul>
							
						</div><!--end.my_zl_gr-->
						
						
					</div><!--end.expert_mes-->
					
					
					
				</div>
				<!--end.content-right-->
			</div>
			<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>
	</body>

</html>