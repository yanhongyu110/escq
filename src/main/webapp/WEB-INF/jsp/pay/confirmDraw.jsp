<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<head>
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <link rel="stylesheet" href="${webtxc}/css/public.css"/>
    <link rel="stylesheet" href="${webtxc}/css/personal.css?v=123"/>
    <script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
    <script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
    <title>余额提现</title>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
</head>
<body>
	<c:set var="istop" value="true" />
    <%@include file="/WEB-INF/jsp/common/top.jsp" %>
    <div class="content">
        <%@include file="/WEB-INF/jsp/common/left.jsp" %>
        <div class="content-right">
					<div class="expert_mes">
						<h2>我的账户  >> 余额提现</h2>
						<div class="my_zh">
							<div class="my_zh_title">
								<div class="my_zh_title_left">
									<a>账户余额：<span>1000</span>元</a>
									
									<h4>请确认提现信息，确认提现后，请注意查看系统通知。</h4>
								</div>
								
							</div>
						</div><!--end.my_zh-->
						<div class="my_zh_list">
							
							<div class="my_zh_qtfs momargin">
								<ul>
									<li>支付宝账户：</li>
									<li>行**</li>
								</ul>
								<ul>
									<li>提现金额：</li>
									<li><span>￥50000.00元</span></li>
								</ul>
								<ul>
									<li>交易密码：</li>
									<li><input type="text" class="sr" value="请输入密码"></li>
									<li class="forgot">忘记密码？</li>
								</ul>
							</div>
							
							<div class="my_zh_bottom tx">
								<div class="btn_tx">确认提现</div>
								<h3>如提现失败，提现金额会返回到账户余额，请注意查看系统通知。</h3>
								
							</div>
							
						</div><!--end.my_zh_list-->
						
						
					</div><!--end.expert_mes-->
					
					
					
				</div>
            
        
        <!--end.content-->
</div>
    <%@include file="/WEB-INF/jsp/common/bottom.jsp" %>



</body>

</html>
