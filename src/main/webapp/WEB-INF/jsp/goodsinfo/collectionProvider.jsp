<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<html xmlns:ng="http://angularjs.org" id="ng-app" ng-app="optionalModuleName" class="ng-app:myApp">
<head>
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <%@ include file="/WEB-INF/jsp/common/angular.jsp" %>
    <link rel="stylesheet" href="${webtxc}/css/public.css"/>
    <link rel="stylesheet" href="${webtxc}/css/personal.css"/>
    <script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
    <script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
    <title>我的收藏</title>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/common/top.jsp"/>
<!--end.personal-->
<div class="content" ng-app="myApp" ng-controller="controller">
    <%@ include file="/WEB-INF/jsp/common/left.jsp" %>
    <div class="content-right" >
        <div class="expert_mes">
            <h2>我的收藏</h2>
            <div class="my_sc">
                <ul>
                    <li onclick="window.location.href=path+'/goodsinfo/collection/viewSCollection.html'">我收藏的服务</li>
                    <li class="my_sc_on" onclick="window.location.href=path+'/goodsinfo/collection/viewPCollection.html'">我收藏的专家</li>
                </ul>
            </div>

            <page-config url="${webtxc}/goodsinfo/collection/queryP.html" page-size="10" page="1" btn-size="7"  ></page-config>


            <div class="ck-product-list">

                <div ng-show="page.list.length==0" style="margin-left: 0px;">
                    没有添加
                </div>


                <div ng-repeat="i in page.list">
                    <div class="item-panel">
                        <div class="item-pic">
                            <a href="#" target="_blank">
                                <img src="${webtxc}/{{i.providerInfo}}">
                            </a>
                        </div>
                        <div class="item-title zj_tiele">
                            <a href="#" target="_blank">{{i.providerInfo.piRealname}}/{{i.providerInfo.piPosition}}</a>
                        </div>
                        <div class="zj_jianjie">
                            <div class="jianjie">
                                <p>{{i.providerInfo.piBrief}}<a>查看详细&gt;&gt;</a></p>
                            </div>
                        </div>
                    </div>
                </div>


            </div>


        </div>
        <!--end.expert_mes-->
        <div class="jogger" ng-show="page.list.length!=0">
            <span class="disabled">&lt; </span>
            <span ng-repeat="i in page.btnList" class="{{i.index==page.page?'current':''}}">{{i.index}}</span>
            <a href="#?page=2" next-page>&gt; </a>
        </div>


    </div>
</div>
<!--end.content-->
<jsp:include page="/WEB-INF/jsp/common/bottom.jsp"/>
<script>
    angular.module("myApp", ['fastPage']).controller('controller', function ($scope) {

    })
</script>
</body>
</html>
