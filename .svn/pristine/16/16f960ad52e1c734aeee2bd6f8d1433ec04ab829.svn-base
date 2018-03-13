<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<html>
<head>
    <title>咨询主题</title>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <%@ include file="/WEB-INF/jsp/common/kindeditor.jsp" %>
    <%@ include file="/WEB-INF/jsp/common/easyui.jsp" %>
    <link rel="stylesheet" href="${webtxc}/css/public.css"/>
    <link rel="stylesheet" href="${webtxc}/css/personal.css"/>
    <link rel="stylesheet" href="${webtxc}/css/goodsinfo/goodsinfo.css"/>
    <script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
    <script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
    <link rel="stylesheet" type="text/css" href="${webtxc}/mapsearch/map.css">
    <script type="text/javascript" src="${webtxc}/mapsearch/jquery.tmpl.js"></script>
    <script type="text/javascript" src="${webtxc}/mapsearch/map.js"></script>
    <script id="infoWindowData" type="text/x-jquery-tmpl" style="width: 310px;height: auto;">
		<div class="infoWindow_main" style="width: 100%;height: auto">
			<ul class="infoWindow_left">
				<li>地址：{{= address}}</li>
				<li>区域：{{= district}}</li>
				<li>简介：{{= brief}}</li>
				<li>标签：{{= tags}}</li>
				<li>距离：{{= distance}}(米)</li>
				<li>
					<input type="button" value="点击查看"  onclick="window.location.href=path+'/userinfo/providerdetails/preproviderdetails.html?logId={{= provider}}'+'&comId='+g_comid">
				</li>
				<!--<li>服务商主键：{{= provider}}</li>-->
			</ul>
			<div class="infoWindow_right" ><img src="{{= img}}" style="width:100px;height:100px;" /></div>
		</div>
	</script>
	<script id="infoData" type="text/x-jquery-tmpl">
		<span style="float:left;width:150px;display:block;">
			{{= title}} <br> 
			{{= address}} <br>
			{{= brief}} <br>
			{{= tags}}<br>
			{{= distance}}(米)
		</span>
		<img style="width:100px;height:100px;margin-top:-10px;float:right;margin-right:15px;" src="{{= img}}">
	</script>
</head>
<body>

<%--<div>--%>
    <%--<div style="height: 100%;border: 0px;width: 40%"></div>--%>
    <%--<div style="height: 100%;border: "></div>--%>
<%--</div>--%>


<%@include file="/WEB-INF/jsp/common/top.jsp" %>
<!-- start.content -->
<div class="content"  style="width: 100%;margin-top: 0px">
    <div class="searchInput">
        <div class="searchPanel">
            <input type="text" id="txtContent" class="txtContent" placeholder="请输入关键词检索" style="margin-left: 6px;"/>
            <a href="javascript:void(0)" id="searchBtn" class="searchBtn" >搜索</a>
        </div>
        <div id="resultPanel" class="resultPanel"></div>
    </div>
    <div id="allmap"></div>
</div>
<!--end.content-->
<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>
</body>
<script>
    $(function(){
        $('html,body').scrollTop($('.content').offset().top)
        console.log($('.content').offset().top)
    })
</script>
</html>