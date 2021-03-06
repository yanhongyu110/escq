<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<head>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <link rel="stylesheet" href="${webtxc}/css/public.css"/>
    <link rel="stylesheet" href="${webtxc}/css/personal.css?v=13"/>
    <script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
    <script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
    <link rel="stylesheet" href="${webtxc}/css/public.css" />
    <script type="text/javascript">
    window.onload=function(){
    var cc='${content}';
    if(cc.indexOf('正在审核')>=0){
    	$("#tsimg").addClass('shen_zzsh_img');
    }
    if(cc.indexOf('已通过')>=0|cc.indexOf('成功')>=0){
    	$("#tsimg").addClass('shen_tg_img');
    }
    if(cc.indexOf('实名认证')>=0){
    	$("#tsimg").remove();
    }
    }
    </script>
</head>
<body>
<c:set var="istop" value="true"/>
<%@include file="/WEB-INF/jsp/common/top.jsp" %>
<div class="content">
<%@include file="/WEB-INF/jsp/common/left.jsp" %>
<div class="content-right" style=" ">
    <div class="expert_mes">
        <h2>${title}</h2>
            <!-- <div class="status_icon"> -->
            <div class="note_message">
                <div class="shenhe">
                <c:if test="${empty url}"> <h3>${content}</h3></c:if>
                  <div id="tsimg" ></div>
                  <c:if test="${!empty url}"><h3><Strong onclick="window.location.href=path+'${url}'">${content}</Strong><br></h3></c:if> 
                </div><!--end.shenhe-->
            </div>
            <!-- </div> -->
    </div>
</div>
    <!--end.content-right-->
</div>
<!--end.content-->
<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>
</body>
</html>
