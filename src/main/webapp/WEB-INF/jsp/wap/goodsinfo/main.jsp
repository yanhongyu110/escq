<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>近到家</title>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>

    <meta content="yes" name="apple-mobile-web-app-capable">
    <!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
    <meta name="apple-touch-fullscreen" content="yes">
    <!-- 开启对web app程序的支持  -->
    <meta content="telephone=no,email=no" name="format-detection">
    <!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
    <!--base css-->
    <meta name="description" content="近到家，是全国最贴近生活的大众平台，当你遇到任何领域的问题或者是个性化的服务需求，都可以就近找到“对”的人，为你提供帮助，定制服务。达人专家按需约见，在线交流。我们为你提供校园、招聘、婚介、风水、二手、家政、教育、科技、房屋、律师、转让等海量分类信息，充分满足您免费查看/发布信息的需求。近到家，就近服务，专业的分类信息服务网。">
    <meta name="keywords" content="找专家，发布需求，求职，职业规划，咨询，经验，解决问题，一对一，面对面">
    <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes"/>
    <link rel="stylesheet" href="${webtxc}/css/wap/reset.css"/>
    <link rel="stylesheet" href="${webtxc}/css/wap/index.css?val=asd"/>
    
    <script src="${webtxc}/js/wap/reset.js"></script>
    <script src="${webtxc}/js/wap/jquery-1.9.1.min.js"></script>
    <script src="${webtxc}/js/wap/bd.js"></script>
    <script src="${webtxc}/js/wap/TouchSlide.js"></script>
    <link rel="stylesheet" href="${webtxc}/css/wap/swiper.min.css"/>
    <script type="text/javascript" src="${webtxc}/js/wap/swiper.min.js"></script>
    <script src="${webtxc}/vue/vue.min.js"></script>
    <script type="text/javascript" src="${webtxc}/jquery/jquery.cookie.js"></script>


    <script type="text/javascript" src="${webtxc}/js/wap/slider/jquery.bxslider.js"></script>
    
    <link rel="stylesheet" href="${webtxc}/css/wap/jquery.bxslider.css"/>

    <SCRIPT type=text/javascript>
        //var bannerData = ${banner1};
        // var selectListShow = 0;
        //        $(function() {
        //            $("#type,.searchselectbtn").click(function() {
        //                if(selectListShow) {
        //                    $("#selectTypeList").slideUp("fast");
        //                    selectListShow = 0;
        //                } else {
        //                    $("#selectTypeList").slideDown("fast");
        //                    selectListShow = 1;
        //                }
        //                return false;
        //            });
        //            $("body").click(function() {
        //                if(selectListShow) {
        //                    $("#selectTypeList").slideUp("fast");
        //                    selectListShow = 0;
        //                }
        //            });
        //            $(".searchselect li").click(function() {
        //                $("#type").text($(this).text());
        //                $("#type").attr("typename", $(this).attr("typename"));
        //                $(this).parent().hide();
        //            });
        //
        //        });
    </SCRIPT>
    <style>
        .swiper-container {
            height: 7rem;
            margin-top:10px;
        }

        .swiper-slide {
            background-position: center;
            background-size: cover;
            height: 7rem;
        }

        .school_fl_list_bottom > .whimg:before {
            content: "";
            display: inline-block;
            padding-bottom: 50%;
        }

        .focus {
            max-height: 215px;
        }
    </style>

    <script>
    
        (function ($) {
        	var loginfo='${sessionScope.logInfo.logId}';
        	var isCookie=false;
        	if(loginfo==''){
        	//cookie 存储
        	if(window.localStorage){
        		isCookie=true;
        	}else{
        		isCookie=false;
        	}
        	var logUser=$.cookie('logUser');
        	var logToken=$.cookie('logToken');
        	delCookie('JSESSIONID');
        	$.cookie('JSESSIONID',logToken, { expires: 30, path: '/' });
        	if(logUser!=null&logUser!=''&logToken!=null&logToken!=''){
        		$.ajax({
            		url: path + '/wap/main/loginByToken.html',
                    async: true,//请求是否异步，默认为异步
                    type: 'POST',
                    data:{
                    	'user':logUser,
                    	'token':logToken
                    },
                    success: function (result) {
						/* alert(result+''); */

                    },
                    error: function (error) {
                        console.log(error);
                        //alert(error,"提示");
                    }
            	})
        	}
        	}

            Vue.filter('cut', function (value, lang) {
                if (value.length > lang) {
                    value = value.substring(0, lang) + '...';
                }
                return value;
            });
            var app;
            var appData = {
                typeList: [],
                proList: [],
                serList: [],
                initState: 0,
                initState1: 0,
            };
            $(function () {


                $.post(path + '/provider/recommend.html', {}, function (r) {
                    appData.proList = r;
                }, 'json');

                $.post(path + '/provider/indexService.html', {}, function (r) {
                    appData.serList = r;
                }, 'json');


                $.ajax({
                    url: path + '/pubinfo/getTree.html',
                    dataType: 'json',
                    success: function (r) {
                        appData.typeList = r;

                    }
                });

                app = new Vue({
                    el: '#page',
                    data: appData,
                    methods: {
                        typeGo: function (input) {
                            location.href = path + '/wap/goodsinfo/ServiceInfo/homeShow.html?module=' + input;
                        },
                        proGo: function (input) {
                            location.href = path + '/wap/goodsinfo/service/queryServiceDetails.html?serviceId=' + input + '&priceType=1';
                        },
                        providerGo: function (input) {
                            location.href = path + '/wap/userinfo/providerdetails/preproviderdetails.html?logId=' + input;
                        }
                    },
                    updated: function () {
                        if (this.initState1 == 0 && this.typeList.length > 0) {
                            new Swiper('.nav_jindaojia', {
                                slidesPerView: 6,
                                freeMode: true,
                                slidesPerGroup: 6,
                                slidesOffsetBefore: 0,
                            });
                            this.initState1 = 1;
                        }
                        if (this.initState == 0 && this.proList.length > 0) {
                            new Swiper('.orz_sss', {
                                effect: 'flip',
                                grabCursor: true,
                                nextButton: '.swiper-button-next',
                                prevButton: '.swiper-button-prev'
                            });
                            this.initState = 1;
                        }
                    }
                });

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


        })(jQuery);
    </script>
<script type="text/javascript">
$(document).ready(function() {
	  var blw=$("#myscrollbox li").width();
	  //获取单个子元素所需宽度
	  var liArr = $("#myscrollbox ul").children("li");
	  //获取子元素数量
	  var mysw = $("#myscroll").width();
	  //获取子元素所在区域宽度
	  var mus = parseInt(mysw/blw);
	  //计算出需要显示的子元素的数量
	  var length = liArr.length-mus;
	  //计算子元素可移动次数（被隐藏的子元素数量）
	  var i=0
	  $("#right").click(function(){
		  i++
		  //点击i加1
		  if(i<length){
		      $("#myscrollbox").css("left",-(blw*i));
			  //子元素集合向左移动，距离为子元素的宽度乘以i。
		  }else{
			  i=length;
			  $("#myscrollbox").css("left",-(blw*length));
			  //超出可移动范围后点击不再移动。最后几个隐藏的元素显示时i数值固定位已经移走的子元素数量。
	      }
      });
	  $("#left").click(function(){
		  i--
		  //点击i减1
		  if(i>=0){
		     $("#myscrollbox").css("left",-(blw*i));
			 //子元素集合向右移动，距离为子元素的宽度乘以i。
		  }else{
			 i=0;
			 $("#myscrollbox").css("left",0);
			 //超出可移动范围后点击不再移动。最前几个子元素被显示时i为0。
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


        <!--头部 end-->
        <div class="nav_jindaojia  swiper-container"
             style="margin-top: 0px;height:38px;font-weight: 600;font-family: serif;float: left;width: 90%;">
            <ul class="swiper-wrapper" style="white-space: nowrap;width: auto">
                <%--<li  class="le_dan " style="width: 50px;height: 40px;display: inline-block">首页</li>--%>
                <li @click="typeGo(it.ctId)" class="swiper-slide" v-for="it in typeList" v-text="it.ctName"
                    style="width: 50px;height: 38pxpx;display: inline-block"></li>
            </ul>
        </div>
        <div id="more"
             style="font-size: 30px;color:#f40;width: 10%;height: initial;background-color: white;z-index: 20;text-align: center;float: right;height: 38px;">
            +
        </div>
        <div id="tipsWindown" class="more_list">
            <ul>
                <li @click="typeGo(it.ctId)" v-for="it in typeList" v-text="it.ctName" class="more_style"></li>
            </ul>
        </div>
        <script>
            $(function () {
                $("#more").click(function () {
                    $("#tipsWindown").slideToggle("slow");
                });
            });
        </script>


        <!--content-->
        <div class="content ">
            <!--slide-->
            <div id="focus" class="focus">
                <div class="bd">
                    <ul id="Gallery" class="gallery mysliderBanner">
                        <%-- <li> <a href=""><img src="${webtxc}/images/wap/school01.jpg"></a></li>--%>
                        <c:forEach items="${banner1.switchImgObjArr}" var="imgDetails">
                            <li class="slide">
                                <a href="${imgDetails.switchUrl}"><img src="${imgDetails.url}"></a>
                            </li>
                        </c:forEach>

                    </ul>
                </div>
                <div class="hd" id="mySliderBannerPager">
                    <%--<ul>
                       <li class="on">1</li>
                    </ul>--%>
                </div>
            </div>
            <script type="text/javascript">
                /*banner滚动图片*/
                /* var  screenWidth = $(window).width();
                 var indexSlider = $('.mysliderBanner').bxSlider({
                     slideWidth: screenWidth,
                     adaptiveHeight: true,
                     minSlides: 1,
                     maxSlides: 1,
                     moveSlides: 1,
                     startSlide: 0,
                     slideMargin: 0,
                     pager:true,
                     controls: false
                 });*/

                /*
                                var swiper = new Swiper('.swiper-container', {
                                    pagination: '#mySliderBannerPager',
                                    paginationClickable: true
                                });
                */

            </script>
            <!--slide end-->
            <!--list-img-->
            <%--<div class="pt_messages">--%>
            <%--<ul>--%>
            <%--<li class="pt_messages_img"><img src="${webtxc}/images/wap/chuangye_img.png"></li>--%>
            <%--<li><p>寻求一名高级软件开发</p>--%>
            <%--<p><span>2017-5-23</span></p>--%>
            <%--</li>--%>
            <%--</ul>--%>
            <%--<div class="hott_img"><img src="${webtxc}/images/wap/hott.png" width="50" height="50"></div>--%>
            <%--</div>--%>

            <div class="tuijians_demand">
                <h3>需求推荐 <span onclick="window.location.href=path+'/wap/search/view.html?flag=c'">更多</span></h3>
                <c:forEach items="${demands }" var="demand">
                    <ul>
                        <li class="tuijians_demand_img" onclick="window.location.href=path+'/wap/userinfo/providerdetails/preProviderForXuqiu.html?logId=${demand.demLogid }'"><img src="${demand.userPhoto }"></li>
                        <li class="tuijians_demand_title" onclick="window.location.href=path+'/wap/demand/queryById.html?id=${demand.demId }'">
                            <p><span>${demand.ctName }</span>${demand.demTitle }</p>
                            <font>${demand.demCreatetimeStr }</font>
                        </li>
                    </ul>

                </c:forEach>

            </div>
            <div class="zy_fuwu">

                <ul>
                    <li onclick="window.location.href=path+'/wap/goodsinfo/home/serviceEnsure.html?flag=5'"
                        class="fabu"><img src="${webtxc}/images/wap/xq_01.png"></li>
                    <li class="baoz"><img
                            onclick="window.location.href=path+'/wap/goodsinfo/home/serviceEnsure.html?flag=4'"
                            src="${webtxc}/images/wap/xq_02.png">
                        <!--  <img onclick="window.location.href=path+'/wap/goodsinfo/home/serviceEnsure.html?flag=2'" src="${webtxc}/images/wap/jin.png">  -->
                    </li>
                </ul>
                <!-- 
                <ul>

                    <li class="fuwua" onclick="window.location.href=path+'/wap/goodsinfo/home/serviceEnsure.html?flag=4'"><img src="${webtxc}/images/wap/fuwu.png"></li>
                    <li class="baoz"><img onclick="window.location.href=path+'/wap/goodsinfo/home/serviceEnsure.html?flag=3'" src="${webtxc}/images/wap/cy.png"></li>
                </ul>
                 -->
            </div>
            <%-- <div class="tuijians_demand tu_sps">
             <h3>视频<span onclick="window.location.href=path+'/wap/search/view.html?flag=c'">更多</span></h3>
             <div class="sp_zzt">
               <ul>
                <li>
                 <div class="sp_zzt_img"><img src="${webtxc}/images/wap/expert01.jpg"></div>
                 <p>标题待会就说非进口国</p>
                </li>
                <li>
                 <div class="sp_zzt_img"><img src="${webtxc}/images/wap/expert02.jpg"></div>
                 <p>标题待会就说非进口国</p>
                </li>
                
               </ul>
             </div>
            </div> --%>
            
            
<div class="scrollpic">
	<div class="tuijians_demand tu_sps" >
             <h3 style="border:0">视频</h3></div>
	<div id="myscroll">
		<div id="myscrollbox" >
			<ul>
				<li>
					<a href="#">
						<img src="${webtxc}/images/wap/fw_01.jpg">
						<div class="intro">
							<h5>视频标题</h5>
							<p><img src="images/jia.png" width="70" height="70" /></p>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<img src="${webtxc}/images/wap/fw_04.jpg">
						<div class="intro">
							<h5>视频标题</h5>
							<p><img src="images/jia.png" width="70" height="70" /></p>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<img src="${webtxc}/images/wap/fw_02.jpg">
						<div class="intro">
							<h5>视频标题</h5>
							<p><img src="images/jia.png" width="70" height="70" /></p>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<img src="${webtxc}/images/wap/fw_01.jpg">
						<div class="intro">
							<h5>视频标题</h5>
							<p><img src="images/jia.png" width="70" height="70" /></p>
						</div>
					</a>
				</li>
				<li>
					<a href="#">
						<img src="${webtxc}/images/wap/fw_03.jpg">
						<div class="intro">
							<h5>视频标题</h5>
							<p><img src="images/jia.png" width="70" height="70" /></p>
						</div>
					</a>
				</li>
			</ul>
		</div>
		
	</div>
	<div id="mybtns"> <a href="javascript:;" id="right"><img src="${webtxc}/images/wap/jt_r.png " width="25"></a><a href="javascript:;" id="left"><img src="${webtxc}/images/wap/jt_l.png" width="25"></a>  </div>
</div>

            <%--<div class="inslide p-t-40 p-b-40 bag-f8f8f8">--%>
            <%--<h3>精品推荐</h3>--%>
            <%--<div class="swiper-container orz_sss">--%>
            <%--<div class="swiper-wrapper">--%>
            <%--<div class="swiper-slide" style="background-image:url('${webtxc}/images/wap/zs01.jpg')"></div>--%>
            <%--<div class="swiper-slide" style="background-image:url('${webtxc}/images/wap/zs02.jpg')"></div>--%>
            <%--<div class="swiper-slide" style="background-image:url('${webtxc}/images/wap/zs03.jpg')"></div>--%>
            <%--<div class="swiper-slide" style="background-image:url('${webtxc}/images/wap/zs04.jpg')"></div>--%>
            <%--</div>--%>
            <%--<!-- Add Pagination -->--%>
            <%--<!-- Add Arrows -->--%>
            <%--<div class="swiper-button-prev swiper-button-black"></div>--%>
            <%--<div class="swiper-button-next swiper-button-black"></div>--%>
            <%--</div>--%>
            <%--</div>--%>


            <div class="inslide p-t-40 p-b-40 bag-f8f8f8">
                <h3>达人推荐</h3>
                <div class="swiper-container orz_sss">
                    <div class="swiper-wrapper">
                        <div v-for="it in proList"
                             v-on:click="window.location.href=path+'/wap/userinfo/providerdetails/preproviderdetails.html?logId='+it.piLogId"
                             class="swiper-slide" :style="'background-image:url(\''+path+it.piPhoto+'\')'">
                            <div class="tff">
                                <p>{{it.piContent}}</p>
                                <!-- <a style="padding: 6px 10px" class="ck_xq" :href="path+'/wap/userinfo/providerdetails/preproviderdetails.html?logId='+it.piLogId">点击查看详情</a>-->
                            </div>
                        </div>
                    </div>
                    <!-- Add Pagination -->
                    <!-- Add Arrows -->
                    <div class="swiper-button-prev swiper-button-black"></div>
                    <div class="swiper-button-next swiper-button-black"></div>
                </div>
            </div>


            <div class="fujin">
                <h4>热门服务</h4>
                <div v-for="it in serList" class="school_fenlei">

                    <div class="school_fl_list">
                        <div class="school_fl_list_top">
                            <div class="school_fl_list_top_left">
                                <img :src="path+it.piPhoto" @click="providerGo(it.logId)"/>
                            </div>
                            <div class="school_fl_list_top_left" style="width: 44%">
                                <h3 @click="providerGo(it.logId)">{{it.logName}}</h3>
                                <p>{{it.piPosition}}</p>
                            </div>
                            <div class="school_fl_list_top_right">
                                <!--  <a class="btns" @click="proGo(it.serviceId)">查看</a> -->
                            </div>
                        </div>
                        <div class="school_fl_list_bottom">
                            <div class="whimg"
                                 style="width: 100%;background-position: center;background-size: cover;height:240px"
                                 :style="'background-image:url(\''+path+it.servicePic+'\')' "
                                 @click="proGo(it.serviceId)"></div>
                            <%--<img :src="path+it.piPhoto"/>--%>
                            <div class="school_fl_list_bottom_js">
                                <h2 @click="proGo(it.serviceId)">{{it.serviceTitle | cut(18)}}</h2>
                                <p><span>{{it.serviceSuccessnum}}人付款</span><span>{{it.serviceMeetnum}}人想见</span><span>{{it.serviceZanNum}}人点赞</span><span
                                        v-if="it.distance>=1000" class="ocation">{{it.distance/1000}}km</span><span
                                        v-if="it.distance<1000" class="ocation">{{it.distance}}m</span></p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="more">
                    <a class="btn" onclick="window.location.href=path+'/wap/search/view.html?flag=a'">发现更多服务</a>
                </div>
            </div>


            <div style="width: 100%;height: 40px"></div>

            <!--<div class="contact">

                <div class="btns">联系我们</div>
                <h2>首页 / 关于我们 / 常见问题 / 服务保障</h2>
                <h1>登录 | 注册</h1>
                <p>重庆捷路科技有限公司 Copyright © 2015 ECJia(ecjia.com) <br> 地址：重庆市渝北区文一西路崇义路口公元里7幢6楼
                </p>
            </div>-->


        </div>
        <!--content end-->

    </div>
    <!--page end-->
</div>
<!--wapper end-->

<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp" %>

</body>

</html>