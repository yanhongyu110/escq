<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<script type="text/javascript" src="${webtxc}/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="${webtxc}/jquery/jquery.md5.js"></script>
<script type="text/javascript" src="${webtxc }/js/wap/common.js"></script>
<SCRIPT type=text/javascript>
    var selectListShow = 0;
    $(function () {
        $("#type,.searchselectbtn").click(function () {
            if (selectListShow) {
                $("#selectTypeList").slideUp("fast");
                selectListShow = 0;
            } else {
                $("#selectTypeList").slideDown("fast");
                selectListShow = 1;
            }
            return false;
        });
        $("body").click(function () {
            if (selectListShow) {
                $("#selectTypeList").slideUp("fast");
                selectListShow = 0;
            }
        });

    });
</SCRIPT>

<script type="text/javascript">
    var serviceTypetree = '${serviceTypetree}';
</script>

<%
    if (request.getAttribute("flag")==null){
        request.setAttribute("flag","a");
    }



%>



<form id="myformm" action="${webtxc}/wap/search/view.html" method="post">
    <div class="box-lanrenzhijia">

        <div class="searchContainer">

            <div style="margin: 0px auto;width: 95%;overflow: visible;white-space: nowrap">
                <div class="searchselect" style="padding-left: 0px">
                    <span id="type">
                        <span style="width:70%">${flag=='a'?'找服务':(flag=='b'?'找专家':'找需求')}</span>
                        <i class="allow_down" style="margin-left: 0px"></i>
                    </span>
                    <a class="searchselectbtn" href="javascript:;"></a>
                    <ul id="selectTypeList">
                        <li typename="song"><a href="javascript:void (0);">找专家</a></li>
                        <li typename="singer"><a href="javascript:void (0)">找服务</a></li>
                        <li typename="demand"><a href="javascript:void (0)">找需求</a></li>
                         <!-- <input name="to" value="${to}">-->
                        <input type="hidden" name="flag" value="${empty flag ?'b':flag}">
                        <script>
                            $(function () {
                                $('li[typename=song]').on('click', function () {
                                    $("#type").find('span').text($(this).text());
                                    $('input[name=flag]').val('b');
                                    $('#key').attr('placeholder', '服务商名称');
                                });
                                $('li[typename=singer]').click(function () {
                                    $("#type").find('span').text($(this).text());
                                    $('input[name=flag]').val('a');
                                    $('#key').attr('placeholder', '产品经理');
                                })
                                $('li[typename=demand]').click(function () {
                                    $("#type").find('span').text($(this).text());
                                    $('input[name=flag]').val('c');
                                    $('#key').attr('placeholder', '需求名字');
                                })
                            })

                        </script>
                        <!--  <li class="last"></li>-->
                    </ul>
                </div>
                <div class="sous_inputs">
                <input id="key" class="k_ss sou" type="text" placeholder="${flag=='a'?'请输入搜索关键词':(flag=='输入专家'?'找专家':'输入需求')}" name="search">
                <a style="position: absolute;right: 16%" class="searchbtn" id="searchbtn" href="javascript:void(0);">
                    <img style="right: 10%" src="${webtxc}/images/wap/seaicon.png" onclick="$('#myformm').submit()">
                </a>
                </div>
                 <c:if test="${not empty logInfo &&logInfo>0}">
	                <div class="news_xin">
		                <img onclick="window.location.href='${webtxc}/wap/userinfo/queryAllSystemMes.html?smType=2'" src="${webtxc}/images/wap/nes.png" >
		                <span></span>
	                </div>
                </c:if>
                <c:if test="${not empty logInfo && logInfo==0}">
	                <div class="news_xin">
		                <img onclick="window.location.href='${webtxc}/wap/userinfo/queryAllSystemMes.html?smType=2'"  src="${webtxc}/images/wap/nes.png" >
	                </div>
                </c:if>
                <c:if test="${not empty logInfo && logInfo== -1}">
	                <div class="news_xin">
		                <img onclick="window.location.href='${webtxc}/wap/userinfo/logInfo/jumpLogin.html?menuTag=4'"  src="${webtxc}/images/wap/nes.png" >
	                </div>
                </c:if>
            </div>

        </div>
    </div>
</form>


<%--<c:if test="${istop == true}">--%>
<%--</c:if>--%>
