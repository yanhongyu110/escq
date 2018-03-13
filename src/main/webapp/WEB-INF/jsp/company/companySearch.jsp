<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <meta charset="UTF-8">
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <title>公司列表</title>
    <link rel="stylesheet" href="${webtxc}/css/public.css"/>
    <link rel="stylesheet" href="${webtxc}/css/service.css"/>
    <link rel="stylesheet" href="${webtxc}/css/page.css"/>
    <script type="text/javascript">
        var jsonList = ${jsonList};
        var count = ${count};
        var search = '${search}';
        var orz_flag = 'a'
    </script>
    <script type="text/javascript" src="${webtxc}/js/jquery.citys.js"></script>
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
    </style>
    <script type="text/javascript" src="${webtxc}/myjs/company/companySearch.js?v=201701232342122131232132134232213122131232131231321321312123213213211001"></script>
    <script src="${webtxc}/vue/vue.min.js"/>
</head>

<body>

<c:if test="${sessionScope.company!=null}">
    <%@include file="/WEB-INF/jsp/common/top1.jsp" %>
</c:if>
<c:if test="${sessionScope.company==null}">
    <%@include file="/WEB-INF/jsp/common/top.jsp" %>
</c:if>

<div class="bannerResource"></div>
<div class="content">
    <div class="sv_position">
        <h3>首页 >> <a>服务列表</a></h3>
    </div>
    <div class="cc_list">
        <div class="cc_list_left">
            <ul id="typeull">
                <li val=""   ${(serviceTypetree==null||serviceTypetree=='')?'class="active"':''}     >全部</li>
                <c:forEach var="it" items="${commonTypeList}">
                    <li val="${it.id}"  ${serviceTypetree==it.id?'class="active"':''}  >${it.text}</li>
                </c:forEach>
            </ul>
        </div>
        <div class="sv_expert">
            <div id="demo" class="sv_seach citys">
                <ul name="province">
                </ul>
                <%--<ul name="city">--%>
                <%--</ul>--%>
                <%--<ul name="area">--%>
                <%--</ul>--%>
            </div>
            <!-- <div class="map_s" ><a href="${webtxc}/map/search.html">地图搜索</a></div> -->
            <script type="text/javascript">
                $('#demo').citys({province: '', city: '', area: '', required: false});
            </script>
            <%--<div class="sv_sx">--%>
                <%--<ul>--%>
                    <%--<li class="ss_gg">共搜到--%>
                        <%--<font id="allcount">${count}</font>个结果！--%>
                    <%--</li>--%>
                    <%--<li class="sv_sx_zz">--%>
                        <%--<a style="color: #FB5A5A;border: 1px solid #FB5A5A;" class="no_bg">综合排序</a>--%>
                        <%--<a>约见最多</a>--%>
                        <%--<a>口碑最好</a>--%>
                        <%--<a>价格最高</a>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
            <div id="myexpert" v-bind:key="key">


                <div class="sv_zj" v-for="it in list" >
                    {{it.key}}
                    <div class="sv_zj_img">
                        <img v-bind:src="it.compLog" />
                    </div>
                    <div class="sv_zj_title">
                        <h3>{{it.compName}}</h3>
                        <p>{{it.compType}}&nbsp;&nbsp;&nbsp;&nbsp;
                            <%--工作年限：{{it.piWorkyear}}--%>
                        </p>
                        <p style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;">{{it.compBrier}}</p>
                        <%--<p><a><font>{{it.piDealnum}}</font>人约见</a> <a><font>{{it.piMeetnum}}</font>人想见</a> <a>评分：<font>{{it.piRek}}</font>分</a></p>--%>
                    </div>
                    <div class="sv_zj_btn" style="margin-top: 72px;">
                        <%--<a class="ex_pay">￥{{it.psetPrice}}</a> 元/次--%>
                        <a class="ex_yj" v-on:click="gogo(it)">进入瞧瞧</a>
                    </div>
                </div>


            </div>

            <script>
                var app=new Vue({
                    el: '#myexpert',
                    data: {
                        list: [],
                        key: "213123"
                    },
                    methods: {
                        gogo: function (it) {
                            window.location.href=path+'/goodsinfo/ServiceInfo/homeShow.html?comId='+it.compId;
                        }
                    }
                })
            </script>


        </div>
    </div><!-- end.cc_list -->
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
    <!--end.sv_expert-->

</div>
<!--end.content-->
<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>
</body>

</html>