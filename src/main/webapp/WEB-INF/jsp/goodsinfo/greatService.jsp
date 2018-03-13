<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>优质服务</title>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <link rel="stylesheet" href="${webtxc}/css/public.css"/>
    <link rel="stylesheet" href="${webtxc}/css/service.css"/>
    <link rel="stylesheet" href="${webtxc}/css/page.css"/>
    <script type="text/javascript">
        var jsonList = ${jsonList};
        var count = ${count};
    </script>
    <script type="text/javascript" src="${webtxc}/myjs/goodsinfo/greatService.js?v=2017042101"></script>
</head>
<style>.nav_dh .z_fl .b_nav{display:none}</style>
<body>


<c:if test="${sessionScope.module!=null}">
    <%@include file="/WEB-INF/jsp/common/top.jsp" %>
</c:if>
<c:if test="${sessionScope.module==null}">
    <%@include file="/WEB-INF/jsp/common/top.jsp" %>
</c:if>

<div class="bannerResource"></div>
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
        <ul style="width: 1130px;" id="myuul">
        </ul>
    </div>
    <div id="pageDiv" class="jogger"></div>
</div>
<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>

</body>
</html>