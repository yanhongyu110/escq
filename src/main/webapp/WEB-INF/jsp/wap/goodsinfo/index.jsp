<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>近到家</title>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
    <meta name="apple-touch-fullscreen" content="yes">
    <!-- 开启对web app程序的支持  -->
    <meta content="telephone=no,email=no" name="format-detection">
    <!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
    <!--base css-->
    <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes"/>
    <meta name="description" content="近到家，是全国最贴近生活的大众平台，当你遇到任何领域的问题或者是个性化的服务需求，都可以就近找到“对”的人，为你提供帮助，定制服务。达人专家按需约见，在线交流。">
    <meta name="keywords" content="房屋、家政，律师，近商,招聘,教育,婚介,科技,校园,招聘,风水,近到家">
    <link rel="stylesheet" href="${webtxc }/css/wap/reset.css"/>
    <link rel="stylesheet" href="${webtxc }/css/wap/index.css?val=123sd"/>
    <script src="${webtxc }/js/wap/reset.js"></script>
    <script src="${webtxc }/js/wap/jquery-1.9.1.min.js"></script>
    <script src="${webtxc }/js/wap/bd.js"></script>
    <script src="${webtxc }/js/wap/TouchSlide.js"></script>
    <script>
        var jsonList1 =
        ${jsonList1};
        var jsonList2 =
        ${jsonList2};
        var module = '${sessionScope.module==null?'':sessionScope.module}';
    </script>
    <script type="text/javascript" src="${webtxc }/myjs/wap/goodsinfo/index.js?v=121312"></script>
    <link rel="stylesheet" href="${webtxc }/css/wap/swiper.min.css"/>
    <script type="text/javascript" src="${webtxc }/js/wap/swiper.min.js"></script>
    <script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
    <script src="${webtxc}/vue/vue.min.js"></script>
    <!--no base js end -->


    <script type="text/javascript" src="${webtxc}/js/wap/slider/jquery.bxslider.js"></script>
    <link rel="stylesheet" href="${webtxc}/css/wap/jquery.bxslider.css"/>
    <style type="text/css">
        .swiper-container {
            width: 100%;
        }

        .ul {
            width: 100% !important;
        }
    </style>
    <script>
        $(function () {
            $.ajax({
                url: path + '/pubinfo/getTree.html',
                dataType: 'json',
                success: function (r) {
//                    appDate.typeList = r;
                    var app = new Vue({
                        el: '#type1',
                        data: {
                        	current_module:module,
                            typeList: r
                        },
                        methods: {
                            typeGo: function (input) {
                                location.href = path + '/wap/goodsinfo/ServiceInfo/homeShow.html?module=' + input;
                            }
                        },
                        updated: function () {

                        }
                    });
                    new Swiper('.nav_jindaojia', {
                        slidesPerView: 6,
                        freeMode: true,
                        slidesPerGroup: 6,
                        slidesOffsetBefore: 0,
                    });
                    $("#more").click(function () {
                        $("#tipsWindown").slideToggle("slow");
                    });
                }
            });


        });
    </script>
</head>

<body>
<!--wapper-->
<div class="wapper">
    <!--page-->
    <div id="page">

        <%@ include file="/WEB-INF/jsp/wap/common/top.jsp" %>
        <div id="type1">
            <div class="nav_jindaojia  swiper-container"
                 style="margin-top: 0px;height:38px;font-weight: 600;font-family: serif;float: left;width: 90%;">
                <ul class="swiper-wrapper" style="white-space: nowrap;width: auto" >
                    <%--<li  class="le_dan " style="width: 50px;height: 40px;display: inline-block">首页</li>--%>
                    <li class="swiper-slide" v-for="it in typeList" >
                    	<div v-if="current_module!=null&&current_module==it.ctId" @click="typeGo(it.ctId)"  class="on"  v-text="it.ctName"></div>
                        <div v-else @click="typeGo(it.ctId)"    v-text="it.ctName"></div>
                    </li>
                    <!--  <li v-else @click="typeGo(it.ctId)"  class="swiper-slide  on"  v-text="it.ctName"
                        style="width: 50px;height: 40px;display: inline-block"></li> -->
                    <!-- <li @click="typeGo(it.ctId)" class="swiper-slide" v-for="it in typeList" v-text="it.ctName"
                        style="width: 50px;height: 40px;display: inline-block"></li> -->
               </ul>
            </div>
            <div id="more"
                 style="font-size: 30px;color:#f40;width: 10%;height: initial;background-color: white;z-index: 20;text-align: center;float: right;height: 38px;">
                +
            </div>
            <div id="tipsWindown" style="position: absolute;background-color: white;display: none;top: 90px;z-index: 10000;padding-bottom: 20px;border-bottom: 1px solid #eee;">
                <ul>
                    <li @click="typeGo(it.ctId)" v-for="it in typeList" v-text="it.ctName" class="more_style"></li>
                </ul>
            </div>
        </div>
        <script>
            $(function () {

            });
        </script>

        <!--头部-->
        <%--<div class="header">--%>
        <%--<div class="loimg"></div>--%>
        <%--<form id="myformm" action="${webtxc}/wap/goodsinfo/ServiceInfo/searchService.html" method="post">--%>
        <%--<div class="seach" style="position: relative;"><input name="search" type="text" value="搜索服务 如：“产品经理” " class="sou"><a href="javascript:sub();" style="position: absolute;top: 15px;right: -18px;width: 17px;height: 18px;"></a></div>--%>
        <%--</form>--%>
        <%--<div class="new">--%>
        <%--<a>12</a>--%>
        <%--</div>--%>
        <%--</div>--%>

        <!--头部 end-->
        <!--content-->
        <div class="content have_bg">
            <!--slide-->
            <div id="focus" class="focus" style="max-height: 240px;">
                <div class="bd">
                    <ul id="Gallery" class="gallery mysliderBanner">
                        <%--<c:forEach items="${siList}" var="siList">
                            <li>
                                <a href="${siList.switchUrl }"><img src="${siList.url }"></a>
                                    &lt;%&ndash; <a href="${siList.switchUrl }"><img src="${webtxc }/images/wap/ind1.jpg"></a> &ndash;%&gt;
                            </li>
                        </c:forEach>--%>
                        <c:forEach items="${siList}" var="itemSI">
                            <li class="slide">
                                <a href="${itemSI.switchUrl}"><img src="${itemSI.url}"></a>
                            </li>
                        </c:forEach>
                        <%-- <li>
                            <a href=""><img src="${webtxc }/images/wap/ind2.jpg">
                            </a>
                        </li>
                        <li>
                            <a href=""><img src="${webtxc }/images/wap/ind5.jpg">
                            </a>
                        </li>
                        <li>
                            <a href=""><img src="${webtxc }/images/wap/ind4.jpg">
                            </a>
                        </li> --%>
                    </ul>
                </div>
                <div class="hd">
                    <ul>
                    </ul>
                </div>
            </div>
            <script>
                /*banner滚动图片*/
                /*TouchSlide({
                    slideCell: "#focus",
                    titCell: ".hd ul", // 开启自动分页 autoPage:true ，此时设置 titCell 为导航元素包裹层
                    mainCell: ".bd ul",
                    effect: "leftLoop",
                    autoPlay: true, // 自动播放
                    autoPage: true, // 自动分页
                    delayTime: 200, // 毫秒；切换效果持续时间（执行一次效果用多少毫秒）
                    interTime: 2500, // 毫秒；自动运行间隔（隔多少毫秒后执行下一个效果）
                    switchLoad: "_src" // 切换加载，真实图片路径为"_src"
                });*/
                $(function () {
                    var screenWidth = $(window).width();
                    var indexSlider = $('.mysliderBanner').bxSlider({
                        slideWidth: screenWidth,
                        adaptiveHeight: true,
                        minSlides: 1,
                        maxSlides: 1,
                        moveSlides: 1,
                        startSlide: 0,
                        slideMargin: 0,
                        pager: true,
                        controls: false
                    });
                });
            </script>
            <!--slide end-->
            <!--list-img-->

            <script>
                Vue.filter('cutFormat', function (value, lang) {
                    if (value.length > lang ? lang : 15) {
                        return value.substring(0, lang ? lang : 15) + '...';
                    } else {
                        return value;
                    }
                });
                $(function () {
                	$.ajax({
                        type: "post",
                        url: path + '/demand/home.html',
                        dataType: 'json',
                        data: {},
                        success: function (re) {
                            if (re.success) {
                                var result = re.result, r1 = [], r2 = [];
                                for (var i = 0; i < result.length; i++) {
                                    var obj = result[i];
                                    if (i <= 4) r1.push(obj);
                                    else r2.push(obj);
                                }
                                var app = new Vue({
                                    el: '#app01',
                                    data: {list: r1, path: path},
                                    methods: {
                                        dataFormat: function (value) {
                                            var date = new Date(value), result = "";
                                            result = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDay();
                                            return result;
                                        },
                                        cut: function (value) {
                                            var result=value.length>8?value.substring(0,8)+"···":value;
                                            return result;
                                        },
                                        go: function (input) {
                                            location.href = path + '/wap/demand/queryById.html?id=' + input;
                                        }
                                    },
                                    updated: function () {

                                    }
                                });

                                new Swiper('#app01', {
                                    direction: 'vertical',
                                    autoplay: 3000
                                });
                            }
                        },
                        error:function(res){
                        	alert("数据加载失败");
                        }
                	}
                    );
                })
            </script>


            <div class="pt_messages swiper-container" id="app01" style="overflow: hidden;height: 80px">
                <div class="hott_img"><img src="${webtxc }/images/wap/hott.png" width="50" height="50"></div>
                <div class="f_xuqiu" style="z-index:9999;position: absolute;top: 20px;right: 12px;margin-top: 0px"
                     onclick="location.href=path+'/wap/search/view.html?flag=c'">更多需求
                </div>
                <div class="swiper-wrapper" style="width: 100%">
                    <ul class="swiper-slide ul" style="height: 80px;padding-left:30px" v-for="iteam in list"
                        @click="go(iteam.demId)">
                        <li style="padding-top: 16px;margin-left: 0" class="pt_messages_img">
                            <img v-bind:src="iteam.userPhoto">
                        </li>
                        <li style="padding-top: 16px;width: 48%" class="pt_messages_title">
                            <p v-text="cut(iteam.demTitle)"></p>
                            <p><span v-text="dataFormat(iteam.demCreatetime) "></span></p>
                        </li>

                    </ul>
                </div>

            </div>


            <%--<div class="zy_fuwu">--%>
            <%--<h3>专业服务</h3>--%>
            <%--<ul>--%>
            <%--<li class="fabu"><a href="${webtxc}/wap/demand/gotoAddDemand.html"><img src="${webtxc}/images/xq_01.png"></a></li>--%>
            <%--<li class="baoz"><img src="${webtxc}/images/baz.png"><img src="${webtxc}/images/jin.png"></li>--%>
            <%--</ul>--%>
            <%--<ul>--%>

            <%--<li class="fuwua"><img src="${webtxc}/images/fuwu.png"></li>--%>
            <%--<li class="baoz"><img src="${webtxc}/images/cy.png"></li>--%>
            <%--</ul>--%>
            <%--</div>--%>


            <div id="app02" style="height:100px;" class="list-img p-t-35 p-b-35 bag-fff swiper-container">
                <div id="d1" style="width:auto;" class="swiper-wrapper">
                    <%-- <a href=""><img src="${webtxc }/images/wap/lisimg1.png" alt="" /><span>策划</span></a>
                    <a href="peixun_list.html"><img src="${webtxc }/images/wap/lisimg2.png" alt="" /><span>市场调研</span></a>
                    <a href="daoshi_list.html"><img src="${webtxc }/images/wap/lisimg3.png" alt="" /><span>产品设计</span></a> --%>

                </div>
                <%-- <div id="d2" class="list-imgone">
                    <a href="zige_list.html"><img src="${webtxc }/images/wap/lisimg4.png" alt="" /><span>美工设计</span></a>
                    <a href="video_page.html"><img src="${webtxc }/images/wap/lisimg5.png" alt="" /><span>技术开发</span></a>
                    <a href="about.html"><img src="${webtxc }/images/wap/lisimg6.png" alt="" /><span>网站运营</span></a>
                </div> --%>


            </div>
            <!--list-img end-->

            <!--图
					<div class="m-t-20 m-b-35">
						<a href="daoshi_page.html"><img src="${webtxc }/images/wap/001.jpg" alt="" width="100%" /></a>
					</div>-->
            <%--<div class="inslide bag-f8f8f8">--%>
            <%--<div class="swiper-container">--%>
            <%--<div class="swiper-wrapper">--%>
            <%--<c:forEach begin="0" end="1" items="${proList }" step="1" var="it" varStatus="no">--%>

            <%--<div class="swiper-slide" style="background-image:url('${it.piPhoto}')">--%>
            <%--<div class="tff">--%>
            <%--<p>${it.piBrief}</p>--%>

            <%--<a class="ck_xq" href="${webtxc}/wap/userinfo/providerdetails/preproviderdetails.html?logId=${it.piLogId}">点击查看详情</a>--%>
            <%--</div>--%>
            <%--</div>--%>

            <%--</c:forEach>--%>
            <%--</div>--%>
            <%--<!-- Add Pagination -->--%>

            <%--<!-- Add Arrows -->--%>
            <%--<div class="swiper-button-prev swiper-button-black"></div>--%>
            <%--<div class="swiper-button-next swiper-button-black"></div>--%>
            <%--</div>--%>
            <%--</div>--%>

            <%--<script>--%>
            <%--var swiper = new Swiper('.swiper-container', {--%>
            <%--effect: 'flip',--%>
            <%--grabCursor: true,--%>
            <%--nextButton: '.swiper-button-next',--%>
            <%--prevButton: '.swiper-button-prev'--%>
            <%--});--%>
            <%--</script>--%>
            <!--图 end-->

            <!--end.b_title-->

            <style>
                .service_zj > ul > li > a {
                    display: inline-block;
                    width: 100%;
                    overflow: hidden;
                }

                .service_zj > ul > li > a > img {
                    min-height: 200px;
                    max-width: 100%;
                }
            </style>

            <div class="service_zj">
                <div class="b_title">
                    <h2>专家推荐</h2>
                    <h4>超过8千位行业达人专属服务，求教专家达人解惑或与达人切磋</h4>
                </div>
                <ul>
                    <c:forEach begin="0" end="1" items="${proList }" step="1" var="it" varStatus="no">
                        <c:if test="${no.count == 1 }">
                            <li>
                                <a href="${webtxc}/wap/userinfo/providerdetails/preproviderdetails.html?logId=${it.piLogId}">
                                    <div class="whimg"
                                         style="width: 100%;background-size: cover;background-position: center;height:160px;background-image: url('${it.piPhoto}')"></div>
                                        <%--<img src=""/>--%>
                                </a>
                                <%-- <h3>${it.logName}</h3> --%>
                                <p>${it.piPosition}</p>
                            </li>
                        </c:if>
                        <c:if test="${no.count == 2 }">
                            <li class="img_right">
                                <a href="${webtxc}/wap/userinfo/providerdetails/preproviderdetails.html?logId=${it.piLogId}">
                                    <div class="whimg"
                                         style="width: 100%;background-size: cover;background-position: center;height:160px;background-image: url('${it.piPhoto}')"></div>
                                </a>
                                <%-- <h3>${it.logName}</h3> --%>
                                <p>${it.piPosition}</p>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
                <ul>
                    <c:forEach begin="2" end="3" items="${proList }" step="1" var="it" varStatus="no">
                        <c:if test="${no.count == 1 }">
                            <li>
                                <a href="${webtxc}/wap/userinfo/providerdetails/preproviderdetails.html?logId=${it.piLogId}">
                                    <div class="whimg"
                                         style="width: 100%;background-size: cover;background-position: center;height: 160px;background-image: url('${it.piPhoto}')"></div>
                                </a>
                                <%-- <h3>${it.piRealname}</h3> --%>
                                <p>${it.piPosition}</p>
                            </li>
                        </c:if>
                        <c:if test="${no.count == 2 }">
                            <li class="img_right">
                                <a href="${webtxc}/wap/userinfo/providerdetails/preproviderdetails.html?logId=${it.piLogId}">
                                    <div class="whimg"
                                         style="width: 100%;background-size: cover;background-position: center;height: 160px;background-image: url('${it.piPhoto}')"></div>
                                </a>
                                <%-- <h3>${it.piRealname}</h3> --%>
                                <p>${it.piPosition}</p>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>

            </div>
            <!--end.service_zj-->
            <div class="more">
                <a class="btn" href="${webtxc}/wap/search/view.html?flag=b">发现更多专家</a>
            </div>

            <!--end.b_title-->
            <div class="service">
                <div class="b_title">
                    <h2>服务推荐</h2>
                    <h4>有效满足个性化需求 , 让服务响应更及时！</h4>
                </div>
                <ul id="myul1">
                    <%-- <li>
                        <img src="${webtxc }/images/wap/fw_01.jpg">
                        <h3>营销型网站策划</h3>
                        <font>￥1200</font>
                    </li>
                    <li class="img_right">
                        <img src="${webtxc }/images/wap/fw_03.jpg">
                        <h3>营销型网站策划</h3>
                        <font>￥1200</font>
                    </li> --%>
                </ul>
                <ul id="myul2">
                    <%-- <li>
                        <img src="${webtxc }/images/wap/fw_01.jpg">
                        <h3>营销型网站策划</h3>
                        <font>￥1200</font>
                    </li>
                    <li class="img_right">
                        <img src="${webtxc }/images/wap/fw_03.jpg">
                        <h3>营销型网站策划</h3>
                        <font>￥1200</font>
                    </li> --%>
                </ul>
            </div>
            <!--end.service-->

            <div class="more">
                <a class="btn" href="${webtxc}/wap/search/view.html?flag=a">发现更多服务</a>
            </div>


            <div style="width: 100%;height: 60px">
            </div>

            <!--
					<div class="contact">
						
						<div class="btns">联系我们</div>
						<h2>首页 / 关于我们 / 常见问题 / 服务保障</h2>
						<%--<h1>登录 | 注册</h1>--%>
						<p>重庆捷路科技有限公司 Copyright © 2015 ECJia(ecjia.com) <br> 地址：重庆市渝北区文一西路崇义路口公元里7幢6楼
						</p>
					</div>
					 -->
            <!-- <div class="footer">
                <ul class="footer_nav">
                    <li class="footer-home">主页</li>

                    <li class="footer-like">发现</li>
                    <li class="footer-gr">我的</li>
                </ul>
            </div> -->

        </div>
        <!--content end-->

    </div>
    <!--page end-->
</div>
<!--wapper end-->

<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp" %>

</body>

</html>