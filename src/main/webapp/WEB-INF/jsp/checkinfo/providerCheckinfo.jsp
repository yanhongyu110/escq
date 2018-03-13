<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <link rel="stylesheet" href="${webtxc}/css/public.css?v=123"/>
    <link rel="stylesheet" href="${webtxc}/css/personal.css?v=123"/>
    <script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
    <script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
    <script type="text/javascript" src="${webtxc}/myjs/checkinfo/providercheck.js?val=15s678"></script>
    <title>服务商认证资料</title>
</head>
<body>

<c:set var="istop" value="true"/>
<%@include file="/WEB-INF/jsp/common/top.jsp" %>
<div class="content">
    <%@include file="/WEB-INF/jsp/common/left.jsp" %>
    <div class="content-right">
        <div class="expert_mes ">
            <div class="expert_mes ">
                <h2>认证资料</h2>
                <div class="status_icon">
                    <p class="progress_bar"></p>
                    <div class="status_progress status_one ">
                        <div class="steps">1
                            <div class="stripeL"></div>
                            <div class="stripeR"></div>
                        </div>
                        <div class="status_text">基本信息</div>
                    </div>
                    <div class="status_progress status_two on">
                        <div class="steps">2
                            <div class="stripeL"></div>
                            <div class="stripeR"></div>
                        </div>
                        <div class="status_text">认证资料</div>
                    </div>
                    <div class="status_progress status_three">
                        <div class="steps">3
                            <div class="stripeL"></div>
                            <div class="stripeR"></div>
                        </div>
                        <div class="status_text">个人介绍</div>
                    </div>

                </div><!--end.status_icon-->
                <div class="note_message">
                    <ul>
                        <li class="mes">上传名片：</li>
                        <li class="expert_xl">
                            <a class="upload"><img class="imgUrl"/></a>
                            <a class="upload"><img class="imgUrl"/></a>
                            <input type="hidden" class="imgUrls" name="pciImage" value="${providerCheckInfo.pciImage}"/>
                        </li>


                        <li class="zp_ts"><span>（选填）</span></br>请上传清晰可见的名片正反面，文件单个大小不超过<span>1M</span>。</li>
                    </ul>
                    <ul>
                        <li class="mes">学历资料：</li>
                        <li class="expert_xl">
                            <a class="upload"><img class="imgUrl"/></a>
                            <a class="upload"><img class="imgUrl"/></a>
                            <input type="hidden" class="imgUrls" name="pciEaducate" value="${providerCheckInfo.pciEaducate}"/>
                        </li>


                        <li class="zp_ts"><span>（选填）</span></br>请上传清晰可见的资料图片，文件单个大小不超过<span>1M</span>，请尽量多的提供专家能力证明的资料。</li>
                    </ul>
                    <ul>
                        <li class="mes">专业资格证书：</li>
                        <li class="expert_xl">
                            <a class="upload"><img class="imgUrl"/></a>
                            <a class="upload"><img class="imgUrl"/></a>
                            <input type="hidden" class="imgUrls" name="pciCredentials" value="${providerCheckInfo.pciCredentials}"/>
                        </li>


                        <li class="zp_ts"><span>（选填）</span></br>请上传清晰可见的资料图片，文件单个大小不超过<span>1M</span>，请尽量多的提供专家能力证明的资料。</li>
                    </ul>
                    <ul>
                        <li class="mes">上传各种有关专家认证的其它有力证明资料：</li>
                        <li class="expert_xl">
                            <a class="upload"><img class="imgUrl"/></a>
                            <a class="upload"><img class="imgUrl"/></a>
                            <input type="hidden" class="imgUrls" name="pciOthers" value="${providerCheckInfo.pciOthers}"/>
                        </li>


                        <li class="zp_ts"><span>（选填）</span></br>请上传清晰可见的资料图片，文件单个大小不超过<span>1M</span>，请尽量多的提供专家能力证明的资料。</li>
                    </ul>


                </div>

            </div><!--end.expert_mes-->


            <div></div>


            <!--end.content-right-->
        </div>
    </div>

    <!--end.content-->
</div>
<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>


</body>
</html>
