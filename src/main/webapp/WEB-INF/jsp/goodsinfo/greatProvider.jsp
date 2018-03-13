<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>优质服务商</title>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <link rel="stylesheet" href="${webtxc}/css/public.css"/>
    <link rel="stylesheet" href="${webtxc}/css/service.css"/>
    <link rel="stylesheet" href="${webtxc}/css/page.css"/>
    <script type="text/javascript">
        var jsonList = ${jsonList};
        var count = ${count};
        var isFocuss = false;
        var thelogId = '${sessionScope.logInfo.logId}';
    </script>
    <script type="text/javascript" src="${webtxc}/myjs/goodsinfo/greatProvider.js?v=201712312041901"></script>
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
</head>
<style>.nav_dh .z_fl .b_nav{display:none}</style>
<body>

<c:if test="${sessionScope.module!=null}">
    <%@include file="/WEB-INF/jsp/common/top.jsp" %>
</c:if>
<c:if test="${sessionScope.module==null}">
    <%@include file="/WEB-INF/jsp/common/top.jsp" %>
</c:if>

<div class="bannerResource" ></div>
<div class="content">
    <div class="sv_sx">
        <ul>
            <li class="ss_gg">共搜到
                <font id="allcount">${count}</font>个结果！
            </li>
            <li class="sv_sx_zz">
                <a style="color: #FB5A5A;border: 1px solid #FB5A5A;" class="no_bg">综合排序</a>
                <a>约见最多</a>
                <a>口碑最好</a>
            </li>
        </ul>
    </div>
    <div class="ck-product-list">
        <ul style="width: 1130px;" id="showul">
            <%-- <li>
                <div class="item-panel">
                    <div class="server_tx">
                        <ul>
                            <li><img src="${webtxc}/images/fw_06.jpg"></li>
                            <li>
                                <p><span>木点子</span><span>关注</span></p>
                                <p>营销型网站策划</p>
                            </li>
                        </ul>

                    </div>
                    <div class="item-pic">
                        <a href="#" target="_blank">
                            <img  src="${webtxc}/images/fw_05.jpg">
                        </a>
                    </div>

                    <div class="item-addition">
                        <div class="clearfix">

                        </div>
                        <div class="satisfaction">
                            <span class="">11人约见</span>
                        </div>
                        <div class="number">
                            <span><em>3</em> 条评论</span>
                        </div>
                    </div>

                </div>
            </li>
            <li>
                <div class="item-panel">
                    <div class="server_tx">
                        <ul>
                            <li><img src="${webtxc}/images/fw_01.jpg"></li>
                            <li>
                                <p><span>木点子</span><span>关注</span></p>
                                <p>营销型网站策划</p>
                            </li>
                        </ul>

                    </div>
                    <div class="item-pic">
                        <a href="#" target="_blank">
                            <img  src="${webtxc}/images/fw_04.jpg">
                        </a>
                    </div>

                    <div class="item-addition">
                        <div class="clearfix">

                        </div>
                        <div class="satisfaction">
                            <span class="">11人约见</span>
                        </div>
                        <div class="number">
                            <span><em>3</em> 条评论</span>
                        </div>
                    </div>

                </div>
            </li>
            <li>
                <div class="item-panel">
                    <div class="server_tx">
                        <ul>
                            <li><img src="${webtxc}/images/fw_05.jpg"></li>
                            <li>
                                <p><span>木点子</span><span>关注</span></p>
                                <p>营销型网站策划</p>
                            </li>
                        </ul>

                    </div>
                    <div class="item-pic">
                        <a href="#" target="_blank">
                            <img  src="${webtxc}/images/fw_03.jpg">
                        </a>
                    </div>

                    <div class="item-addition">
                        <div class="clearfix">

                        </div>
                        <div class="satisfaction">
                            <span class="">11人约见</span>
                        </div>
                        <div class="number">
                            <span><em>3</em> 条评论</span>
                        </div>
                    </div>

                </div>
            </li>
            <li>
                <div class="item-panel">
                    <div class="server_tx">
                        <ul>
                            <li><img src="${webtxc}/images/fw_03.jpg"></li>
                            <li>
                                <p><span>木点子</span><span>关注</span></p>
                                <p>营销型网站策划</p>
                            </li>
                        </ul>

                    </div>
                    <div class="item-pic">
                        <a href="#" target="_blank">
                            <img  src="${webtxc}/images/fw_02.jpg">
                        </a>
                    </div>

                    <div class="item-addition">
                        <div class="clearfix">

                        </div>
                        <div class="satisfaction">
                            <span class="">11人约见</span>
                        </div>
                        <div class="number">
                            <span><em>3</em> 条评论</span>
                        </div>
                    </div>

                </div>
            </li> --%>

        </ul>
    </div>
    <div id="pageDiv" class="jogger"></div>
</div>
<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>

</body>
</html>