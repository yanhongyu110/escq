<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<html> 

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<title>我的推荐</title>
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<script>
			var count=${infos.totalPage};
			var pageNo=${infos.page};
			var recommend=${infos.list};
		</script>
		<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/personal.css" />
		<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/bizinfo/myrecommend.js?v=23sadf4sdfg"></script>
		<script type="text/javascript">
		window.onload=function(){
			var codeurl="https%3a%2f%2fopen.weixin.qq.com%2fconnect%2foauth2%2fauthorize%3fappid%3dwx67be5c6d09c33f01%26redirect_uri%3dhttp%253A%252F%252Fbblazh.tunnel.qydev.com%252Fesc%252Foauth2%252Foauth2Return.html%26response_type%3dcode%26scope%3dsnsapi_userinfo%26state%3d${sessionScope.logInfo.logId}%26connect_redirect%3d1%23wechat_redirect"
				$("#codeurl").attr("src","${webtxc}/pay/orderpay/code.html?codeurl="+codeurl);
			$("#clickcopy").click(function(){
				var Url2=document.getElementById("recUrl");
				Url2.select(); // 选择对象
				document.execCommand("Copy"); // 执行浏览器复制命令
				alert("已复制好，可直接贴粘！");
			})
			$(".tis_no").hide();
			if(recommend.length<=5){
				$("#pageDiv").hide();
			}
			if(${empty infos.list[0].rptpPresenter}){
				$(".tis_no").show();
			}
		}
		</script>
	</head>
	<body>
			<c:set var="istop" value="true" />
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>
			<div class="content">
				<%@ include file="/WEB-INF/jsp/common/left.jsp"%>
				<div class="content-right">
				
					<div class="my_like">
						<h2>我的推荐</h2>
						<div class="my_tuijian">
						推荐网址：<input type="text" id="recUrl" value="http://www.jindaoj.com/userinfo/logInfo/jumpRegister.html?provider=${sessionScope.logInfo.logId}&comId=${sessionScope.company.compId}" />
						<button id="clickcopy">点击复制</button>
						</div>
						<div class="wx_sm">
						<div class="wx_sm_title">微信扫一扫：</div>
						<div class="wx_sm_img"><image id="codeurl"  /></div>
						</div>
						
						<div id="ts" class="tis_no">暂无推荐服务商，快去推荐分享吧!</div>
						
						<c:forEach var="recommend" items="${infos.list}">
							<div class="my_recommend_list"  style="overflow: hidden">
								<input type="hidden" class="rptpPresenter" value="${recommend.rptpPresenter}" />
								<input type="hidden" class="rptpPresentee" value="${recommend.rptpPresentee}" />
								<input type="hidden" class="piId" value="${recommend.piId}">
								<div class="my_recommend_list_img" onclick="window.location.href=path+'/userinfo/providerdetails/preproviderdetails.html?logId=${recommend.rptpPresenter}'+'&comId='+g_comid">
									<img src="${recommend.piPhoto}"  />
								</div>
								<div class="my_recommend_list_title">
									<h3>${recommend.piRealname }</h3>
									<p><span>职位：${recommend.piPosition }</span></p>
									<span>工作年限：${recommend.piWorkyear}</span>
									<span>约见次数：${recommend.piMeetnum}</span>
									<span>服务次数：${recommend.piDealnum}</span>
									<span>平均响应时间：${recommend.piResponsetime}</span>
									<span>平均评分：${recommend.piMark}</span>
									<span>所在地区：${recommend.piArea}</span>
									<p class="gjz"> 关键字：${recommend.piKeywords}</p>
								</div>
							</div><!--end.my_like_list-->
						
						</c:forEach>
					</div><!--end.my_like-->
					
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
			<!--end.content-->
			
			<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
		<!--end.contain-->
	</body>

</html>