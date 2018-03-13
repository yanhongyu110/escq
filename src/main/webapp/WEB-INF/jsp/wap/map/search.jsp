<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<html>
<head>

	<meta charset="UTF-8">
	<title>发现</title>
	<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
	<meta content="yes" name="apple-mobile-web-app-capable">
	<!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
	<meta name="apple-touch-fullscreen" content="yes">
	<!-- 开启对web app程序的支持  -->
	<meta content="telephone=no,email=no" name="format-detection">
	<!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
	<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
	<script type="text/javascript" src="${webtxc}/jquery/jquery-1.11.1.js"></script>
	<link rel="stylesheet" type="text/css" href="${webtxc}/mapsearch/wap/map.css">
    <script type="text/javascript" src="${webtxc}/mapsearch/jquery.tmpl.js"></script>
    <script type="text/javascript" src="${webtxc}/mapsearch/wap/map.js?v=121123312"></script>
	<script type="text/javascript" src="${webtxc}/tis/sweetalert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${webtxc}/tis/sweetalert.css">
	<script id="infoWindowData" type="text/x-jquery-tmpl" style="width: 310px;height: auto">
		<div class="infoWindow_main" style="width: 100%;height: auto">
			<ul class="infoWindow_left" style="width: 55%;height: auto;border: 0px">
				<li>地址：{{= address}}</li>
				<li>区域：{{= district}}</li>
				<li>简介：{{= brief}}</li>
				<!--<li>标签：{{= tags}}</li>-->
				<li>距离：{{= distance}}(米)</li>
				<li>
					<input type="button" value="点击查看"  onclick="window.location.href=path+'/wap/userinfo/providerdetails/preproviderdetails.html?logId={{= provider}}'">
				</li>
				<!--<li>服务商主键：{{= provider}}</li>-->
			</ul>
			<div class="infoWindow_right" ><img src="{{= img}}" style="width:100px;height:100px;" /></div>
		</div>
	</script>
	<script id="infoData" type="text/x-jquery-tmpl">
        <img style="width:50px;height:50px; float:left;   border-radius: 50%;" src="{{= img}}">
		<span style="float:left;margin-left:10%;width:70%;line-height:25px;overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
			{{= title}} <br> 
			{{= address}} <br>
			{{= brief}} <br>
			<!--{{= tags}}<br>-->
			{{= distance}}(米)
		</span>
		
	</script>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
</head>
<body>
	<div class="searchInput">
		<div class="searchPanel">
			<input style="width: 60%;margin-left: 5px" type="text" id="txtContent" class="txtContent" placeholder="请输入关键词检索"/>
			<a href="javascript:void(0)" id="searchBtn" class="searchBtn">附近搜索</a>
			<select id="rrr" style="height: 40px;width: 18%;border-color: #a6a6a6;margin: 5px 0px;">
				<option value="1000" selected>1公里</option>
				<option value="10000">10公里</option>
				<option value="50000">50公里</option>
			</select>
		</div>
		<div id="resultPanel" class="resultPanel"></div>
	</div>
	<div id="allmap"></div>
	<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%>
</body>

</html>