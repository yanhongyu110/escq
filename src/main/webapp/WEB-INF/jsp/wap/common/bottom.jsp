<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="${webtxc }/css/wap/index.css?val=123" />
<link rel="stylesheet" href="${webtxc }/css/wap/indexBottom.css" />
    <c:if test="${sessionScope.logInfo!=null}">
        <div class="footer_nav" style="z-index: 10000">
            <li class="footer-home" onclick="window.location.href=path+'/wap/main/view.html'">主页</li>
            <li class="footer-fuwu" onclick="window.location.href=path+'/wap/goodsinfo/company/showRecommend.html'">发现</li>           
             <li class="footer-fab" id="fabuEvent" ></li>
             <li class="footer-like" onclick="window.location.href=path+'/wap/goodsinfo/service/queryServiceProvider.html'">推荐</li>
            <li class="footer-gr" onclick="window.location.href=path+'/wap/userinfo/personalAdmin.html'" >个人中心</li>
        </div>
    </c:if>


    <%--<c:if test="${sessionScope.logInfo==null}">--%>
        <%--<ul class="footer_nav"  style="z-index: 10000">--%>
            <%--<li class="footer-home" onclick="window.location.href=path+'/wap/main/view.html'">主页</li>--%>
            <%--<li class="footer-like" onclick="window.location.href=path+'/wap/map/search.html'">发现</li>--%>
            <%--<c:if test="${sessionScope.wxFlag==0}">--%>
                <%--<li class="footer-gr" onclick="window.location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx67be5c6d09c33f01&redirect_uri=http%3A%2F%2Fbblazh.tunnel.qydev.com%2Fesc%2Foauth2%2Foauth2Return.html&response_type=code&scope=snsapi_userinfo&state=asas&connect_redirect=1#wechat_redirect'">登录</li>--%>
            <%--</c:if>--%>
            <%--<c:if test="${sessionScope.wxFlag==1}">--%>
                <%--<li class="footer-gr" onclick="window.location.href=path+'/wap/userinfo/logInfo/jumpLogin.html'">登录</li>--%>
            <%--</c:if>--%>
            <%--&lt;%&ndash;<li class="footer-gr" onclick="window.location.href=path+'/wap/userinfo/logInfo/jumpRegister.html'">注册</li>&ndash;%&gt;--%>
        <%--</ul>--%>
    <%--</c:if>--%>


<c:if test="${sessionScope.logInfo==null}">
    <div class="footer_nav"  style="z-index: 10000">
        <li class="footer-home" onclick="window.location.href=path+'/wap/main/view.html'">近到家</li>
        <li class="footer-fuwu" onclick="window.location.href=path+'/wap/goodsinfo/company/showRecommend.html'">发现</li>
        <li class="footer-fab" id="fabuEvent" ></li>
        
        <li class="footer-like" onclick="window.location.href=path+'/wap/goodsinfo/service/queryServiceProvider.html'">推荐</li>
        <%--<c:if test="${sessionScope.wxFlag==0}">
            <li class="footer-gr" onclick="window.location.href='https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx67be5c6d09c33f01&redirect_uri=http%3A%2F%2Fbblazh.tunnel.qydev.com%2Fesc%2Foauth2%2Foauth2Return.html&response_type=code&scope=snsapi_userinfo&state=asas&connect_redirect=1#wechat_redirect'">登录</li>
        </c:if>
        <c:if test="${sessionScope.wxFlag==null||sessionScope.wxFlag==1}">--%>
            <li class="footer-gr" onclick="window.location.href=path+'/wap/userinfo/logInfo/jumpLogin.html'">我的</li>
        <%--</c:if>--%>
            <%--<li class="footer-gr" onclick="window.location.href=path+'/wap/userinfo/logInfo/jumpRegister.html'">注册</li>--%>
    </div>
</c:if>
<div id="fabu_Layer">
    <div id="fabu_select">
        <span class="closeFabu"></span>
        <ul>
            <li class="fabu_select_li fa_xuqiu"><img src="${webtxc}/images/wap/xuqiu.png" onclick="window.location.href=path+'/wap/demand/gotoAddDemand.html'"><a href="javascript:;" >发布需求</a><span onclick="window.location.href=path+'/wap/goodsinfo/home/serviceEnsure.html?flag=5'">如何发布需求？</span></li>
            <li class="fabu_select_li fa_fuwua"><img src="${webtxc}/images/wap/fuwua.png" onclick="window.location.href=path+'/wap/goodsinfo/service/viewAddService.html'"><a href="javascript:;" >发布服务</a><span onclick="window.location.href=path+'/wap/goodsinfo/home/serviceEnsure.html?flag=4'">如何发布服务？</span></li>
            <li class="fabu_select_li fa_fuwua"><img src="${webtxc}/images/wap/fuwua.png" onclick="window.location.href=path+'/wapVideo/toVideo.html'"><a href="javascript:;" >发布视频</a><!-- <span onclick="window.location.href=path+'/wap/goodsinfo/home/serviceEnsure.html?flag=4'">如何发布服务？</span> --></li>
            <!-- <li class="fabu_select_li"><a href="javascript:;" onclick="window.location.href=path+'/wap/goodsinfo/Consult/showAddConsultView.do'">问答</a></li>
            <li class="fabu_select_li"><a href="javascript:;" onclick="window.location.href=path+'/wap/goodsinfo/fbFiles.do'">论文</a></li> -->
        </ul>
    </div>
</div>


<script type="text/javascript">
var logId="${sessionScope.logInfo.logId}";
    $(function () {
        (function ($) {
            $.getUrlParam = function (name) {
                var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
                var r = window.location.search.substr(1).match(reg);
                if (r != null) return unescape(r[2]); return null;
            }
        })(jQuery);

        console.log($.getUrlParam("menuTag"));
        //  页面每一次刷新完成就检测当前是哪一个页面点击了
        var menuTag  = $.getUrlParam("menuTag");
        if(menuTag==null || menuTag==0){
            $(".footer_nav li:eq("+0+")").addClass("on").siblings().removeClass("on");
        }else{
            $(".footer_nav li:eq("+menuTag+")").addClass("on").siblings().removeClass("on");

        }
		
    	//  发布   先检测是否登录
        //  已登陆 直接弹出 可选菜单
        //  没登陆 进登陆页面 斜带参数 menuTag=3 表示 是从发布按钮跳到登陆界面的  注意修改controller
        $("#fabuEvent").on("click",function () {
            if(logId==null || logId=="" || logId==undefined){
                // -->login
                window.location.href = path + "/wap/userinfo/logInfo/jumpLogin.html";
            }else{
                $("#fabu_Layer").show();
                $("#fabu_select").show(500);
            }
        });

        // 关闭 发布选项框
        $(".closeFabu").on("click",function () {
            $("#fabu_Layer").hide();
            $("#fabu_select").hide();
        });

        //  每一次点击 需要添加 一个标记 表示 底部 当前是第几个按钮被点击了
        $(document).on("click",".footer_nav li",function () {
            var $currLi = $(this);
            var onclickStr  = $currLi.attr("onclick");
            var  onclickStrSon  = onclickStr.substr(onclickStr.indexOf("/"),onclickStr.length-1);
            var nextLocationStr  = path+onclickStrSon;
            var indexTagStar=nextLocationStr.indexOf("menuTag");
            var indexTagEnd=nextLocationStr.indexOf("'");
            console.log(indexTagEnd);
            if(indexTagStar!=-1){  //  有 替换等号后边 的值
                var sonLocationStr = nextLocationStr.substr(0,nextLocationStr.length-1);
                window.location.href = sonLocationStr + $currLi.index();
            }else {
                window.location.href =  nextLocationStr.substr(0,indexTagEnd) +"?menuTag="+$currLi.index();
            }

        });
    });
</script>