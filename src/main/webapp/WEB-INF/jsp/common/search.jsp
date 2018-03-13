<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>

    <%--view转变量--%>
    <script type="text/javascript">
        var appDataConfig = {
            key: Math.random() + "",
            search: '${search}',
            name: "服务",
            flag: "${flag}",
            useType: true,
            useCitys: true,
            city: '',
            area: '',
            province: '',
            typeList: [],
            contentList: [],
            contentCount: 0,
            order: 0,
            orderList: [],
            page: 1,
            type: '${type}',
            module:'${sessionScope.module==null?'':sessionScope.module}',
            'to':${to==null?'null':to}
        }

    </script>

    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <meta charset="UTF-8">
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <title>搜索列表</title>
    <link rel="stylesheet" href="${webtxc}/css/public.css"/>
    <link rel="stylesheet" href="${webtxc}/css/service.css"/>
    <link rel="stylesheet" href="${webtxc}/css/page.css"/>
    <script src="${webtxc}/vue/vue.min.js"></script>
    <script type="text/javascript" src="${webtxc}/js/jquery.citys.js"></script>
    <script type="text/javascript" src="${webtxc}/myjs/common/search.js?v=12311231233"></script>

    <%--头部类型切换--%>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".click_all").click(function () {
                $(".sv_seach_zhanshi").toggle();
            });
        });
    </script>

    <style type="text/css">
        .sv_ms {
            border: none !important;
        }

        .sv_seach {
            min-height: 150px;
        }

        #demo ul li {
            margin-top: 5px;
        }

        .fade-enter-active, .fade-leave-active {
            transition: opacity .5s
        }

        .fade-enter, .fade-leave-active {
            opacity: 0
        }
    </style>

</head>

<body>

<c:if test="${sessionScope.module!=null}">
    <%@include file="/WEB-INF/jsp/common/top.jsp" %>
</c:if>
<c:if test="${sessionScope.module==null}">
    <%@include file="/WEB-INF/jsp/common/top.jsp" %>
</c:if>

<div class="bannerResource"></div>
<div class="content">
    <div class="sv_position">
        <h3>首页 >> <a>{{name}}列表</a></h3>
    </div>
    <div class="cc_list">
        <div class="cc_list_left" v-show="useType">
            <ul id="typeull" :key="key">
                <li :val="module" v-bind:style="(type==null||type==''||type=='0'||type==module)?'color:#fb5a5a':''" v-on:click="changType(module)">全部</li>
                <li :val="it.ctId" v-for="it in typeList" v-bind:style="appDataConfig.type==it.ctId?'color:#fb5a5a':''" v-on:click="changType(it.ctId)">{{it.ctName}}</li>
            </ul>
        </div>
        <div class="sv_expert">

            <div id="demo" class="sv_seach citys" v-show="useCitys" style="margin-bottom: 20px">
                <ul name="province"></ul>
                <ul name="city"></ul>
                <ul name="area"></ul>
            </div>

            <!-- <div class="map_s" ><a href="${webtxc}/map/search.html">地图搜索</a></div> -->
            <div class="sv_sx" style="margin-top: 0px">
                <ul>
                    <li class="ss_gg">
                        <template v-if="search!=null && search!=''">
                            {{'"'+search+'"'}}
                        </template>
                        共搜到
                        <font id="allcount">{{contentCount}}</font>个结果！
                    </li>
                    <li class="sv_sx_zz">
                        <a v-for="(it,index) in orderList" v-on:click="changOrder(index)" v-bind:style="index==order?'color: #FB5A5A;border: 1px solid #FB5A5A':'color:#999;border:none;background:url(\'/images/up.png\') no-repeat 75px 5px' ">{{it.name}}</a>
                    </li>
                </ul>
            </div>

            <div id="myexpert">
                <transaction name="fade">

                    <template v-if="flag == 'a' " 注释="这个是模板一">
                        <div class="sv_zj" v-for="(it,index) in contentList">
                            <div class="sv_zj_img">
                                <img v-bind:src="path+it.servicePic"/>
                            </div>
                            <div class="sv_zj_title">
                                <h3 style="font-weight:bold;">{{ it.serviceTitle }}</h3>
                                <p style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" v-html="it.serviceContent"></p>
                                <p>
                                    <a><font>{{ it.serviceSuccessnum }}</font>人约见</a>
                                    <a><font>{{ it.serviceMeetnum }}</font>人想见</a>
                                    <a>评分：<font>{{ it.serviceMark }}</font>分</a></p>
                            </div>
                            <div class="sv_zj_btn">
                                <div class="ex_pay"><span>￥</span>{{ it.psetPrice }} <span>元/次</span></div>
                                <a  href="javascript:void(0)" class="ex_yj" v-on:click="go(it)">查看详情</a>
                            </div>
                        </div>
                    </template>

                    <template v-if="flag == 'b' ">
                        <div v-for="(it,index) in contentList" class="sv_zj">
                            <div class="sv_zj_img">
                                <img v-bind:src=" path+ it.piPhoto "/>
                            </div>
                            <div class="sv_zj_title">
                                <h3><b>{{ it.piPosition}}</b><!-- <span>{{it.logName}}</span> --><span class="congye">从业{{it.piWorkyear}}年</span></h3>
                                <p></p>
                                <p style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;" v-html="it.piContent"></p>
                                <p><a><font>{{it.piDealnum}}</font>人约见</a> <a><font>{{it.piMeetnum}}</font>人想见</a> <a>评分：<font>{{it.piMark}}</font>分</a></p>
                            </div>
                            <div class="sv_zj_btn">
                                <!-- <a class="ex_pay">￥{{it.psetPrice}}</a> 元/次 -->
                                <a  v-on:click="go(it)" class="ex_yj">约TA见面</a>
                            </div>
                        </div>
                    </template>

                    <template v-if="flag=='c'">
                        <div class="sv_zj" v-for="(it,index) in contentList">
                            <div class="sv_zj_img" v-if ="it.demImage==''">
                                <img v-bind:src=" path+ it.userPhoto"  />
                            </div>
                            <div class="sv_zj_img" v-if ="it.demImage!=''">
                                <img v-bind:src=" path+ it.demImage"  />
                            </div>
                            <div class="sv_zj_title">
                                <h3>{{it.demTitle}}</h3>
                                <p v-html="it.demContent"></p>
                                <%--<p><a><font>'+(serviceSuccessnum||0)+'</font>人约见</a> <a><font>'+(serviceMeetnum||0)+'</font>人想见</a> <a>评分：<font>'+(serviceMark||0.0)+'</font>分</a></p>--%>
                            </div>
                            <div class="sv_zj_btn" style="position: relative;height: 70px">
                                <%--<a class="ex_pay">￥'+(psetPrice||0)+'</a> 元/次--%>
                                <a class="ex_yj" v-on:click="go(it)">查看详情</a>
                            </div>
                        </div>
                    </template>

                </transaction>
            </div>

        </div>
    </div>
    <div id="pageDiv" class="jogger"></div>

</div>
<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>
</body>

</html>