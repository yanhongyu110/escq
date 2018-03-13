<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>

   <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <%--view转变量--%>
    <script type="text/javascript">
        var appDataConfig = {
            key: Math.random() + "",
            search: '${search}',
            name: "服务",
            flag: "${flag}",
            useType: true,
            useCitys: false,
            city: '${sessionScope.city}',
            area: '${sessionScope.area}',
            province: '${sessionScope.province}',
            typeList: [],
            contentList: [],
            contentCount: 0,
            order: 0,
            orderList: [],
            page: 1,
            type: '${type}',
            isAdd: true,
            module: '${sessionScope.module==null?'':sessionScope.module}',
            'to':${to==null?'null':to}
        }
    </script>

    <meta charset="UTF-8">
    <title>搜索列表</title>
    <meta content="yes" name="apple-mobile-web-app-capable">
    <!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
    <meta name="apple-touch-fullscreen" content="yes">
    <!-- 开启对web app程序的支持  -->
    <meta content="telephone=no,email=no" name="format-detection">
    <!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
    <!--base css-->
    <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes"/>
    <link rel="stylesheet" href="${webtxc}/css/wap/reset.css"/>
    <link rel="stylesheet" href="${webtxc}/css/wap/index.css?val=156"/>
    <script src="${webtxc}/js/wap/reset.js"></script>
    <script src="${webtxc}/js/wap/TouchSlide.js"></script>
    <script src="${webtxc }/js/wap/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${webtxc }/js/wap/common.js"></script>

    <script type="text/javascript" src="${webtxc}/js/jquery.citysh.js"></script>
    <script type="text/javascript" src="${webtxc}/myjs/wap/common/search.js?v=1213123312"></script>
    <script src="${webtxc}/vue/vue.min.js"></script>
    <script src="${webtxc }/js/wap/public.js?val=1234"></script>
    <script src="${webtxc }/js/wap/flexible.js"></script>
    <script src="${webtxc }/js/wap/swiper.js"></script>


    <link rel="stylesheet" type="text/css" href="${webtxc}/css/dialog.css">
    <link rel="stylesheet" type="text/css" href="${webtxc}/css/mobile-select-area.css">
    <script type="text/javascript" src="${webtxc}/js/dialog.js"></script>
    <script type="text/javascript" src="${webtxc}/js/mobile-select-area.js"></script>

    <style>
        div#demo {
            /*text-align: center;*/
        }

        div#demo > select {
            width: 30%;
        }
    </style>

    <style>

        #area {
            width: 60%;
            outline: 0px;
            border: 0px;
            background-color: #e5e5e5;
            display: inline-block;
            height: 26px;
            line-height: 26px;
            border-radius: 1px;
            padding-left: 1%;
            padding-right: 1%;
        }

        #area_btn {
            width: 14%;
            outline: 0px;
            border: 0px;
            background-color: #e5e5e5;
            display: inline-block;
            height: 26px;
            line-height: 26px;
            border-radius: 1px;
        }

        .service_list_img:before {
            content: "";
            display: inline-block;
            padding-bottom: 80%;
        }
    </style>

</head>
<body>
<c:set var="istop" value="true"/>
<!--wapper-->
<div class="wapper">
    <!--page-->
    <div id="page" style="margin-bottom: 56px;">
        <!--头部-->
        <%@ include file="/WEB-INF/jsp/wap/common/top.jsp" %>


        <%--滑动栏--%>
        <div class="swiper-container moveNav nav_list" id="moveNav" style="padding: 0px;height: 40px;width: 90%;float:left;">
            <ul id="ct" class="swiper-wrapper" style="width: auto;white-space: nowrap;height: 40px">
                <li v-on:click="changType(module)" class="swiper-slide"
                    style="height: 38px;padding: 0px;font-size: 16px;margin-right: 0px;width:60px;float: none;display: inline-block"
                    v-bind:class="(type==null||type==''||type=='0'||type==module)?'on1':''">全部
                </li>
                <li v-for="it in typeList" v-on:click="changType(it.ctId)" class="swiper-slide "
                    style="height: 38px;padding: 0px;font-size: 16px;margin-right: 0px;width:60px;float: none;display: inline-block"
                    v-bind:class="appDataConfig.type==it.ctId?'on1':''" v-text="it.ctName"></li>
            </ul>
        </div>
        <div id="more" class="more_ss">+</div>
        <div id="tipsWindown" class="more_list">
            <ul>
                <li @click="changType(it.ctId)" v-for="it in typeList" v-text="it.ctName" v-bind:class="appDataConfig.type==it.ctId?'on1':''"  class="more_style"></li>
            </ul>
        </div>
        <script>
            $(function(){
                $("#more").click(function () {
                    $("#tipsWindown").slideToggle("slow");
                });
                $("#tipsWindown").click(function () {
                    $("#tipsWindown").slideToggle("slow");
                });
            });
        </script>


        <div id="demo" class="sv_seach citys" v-show="useCitys" style="line-height: 40px">
            <div style="width: 90%;margin: 0px auto">
                <label for="area" style="    width: 20%;display: inline-block;white-space: nowrap;">地区筛选：</label>
                <input type="text" id="area" value="  ">
                <input id="area_btn" type="button" value="清空">
            </div>
        </div>


        <!--end.nav_list-->

        <div class="content_list" :key="key">

            <template v-if="flag == 'a' " 注释="服务的模板">
                <div class="nav_list_sai">
                    <ul>
                        <li v-for="(it,index) in orderList" v-bind:class="index==order?'ond':''"
                            v-on:click="changOrder(index)" v-text="it.name"></li>
                    </ul>
                </div>
                <a v-for="it in contentList" href="javascript:void(0)" @click="go(it)">

                    <div class="service_list">
                        <div class="service_list_img"
                             style="width: 30%;background-position: center;background-size: cover;overflow: hidden;padding: 0px;margin-left:5%;height:80px"
                             :style="'background-image: url(\''+path+it.servicePic+'\')'"
                        >
                            <%--<img />--%>
                        </div>
                        <div class="service_list_title" style="padding: 0px;margin-left: 5%">
                            <h3>{{it.serviceTitle}}</h3>
                            
                            <div class="jull"><i>{{it.serviceSuccessnum}}人约见</i> <i>{{it.serviceMark}}分</i></div>
                            <!-- <b>￥{{it.psetPrice}}</b> -->
                            <p v-if="it.distance>1000">{{it.distance/1000}}km</p>
                            <p v-if="it.distance<1000">{{it.distance}}m</p>
                           
                        </div>
                    </div>
                </a>
            </template>

            <template v-if="flag=='b'" 注释="专家的模板">
                <div class="nav_list_sai">
                    <ul>
                        <li v-for="(it,index) in orderList" v-bind:class="index==order?'ond':''"
                            v-on:click="changOrder(index)" v-text="it.name"></li>
                    </ul>
                </div>
                <a v-for="it in contentList" href="javascript:void(0)" @click="go(it)">
                    <div class="service_list" style="padding-top:20px;padding-bottom:10px">
                        <div class="service_list_img"
                             style="width: 25%;background-position: center;background-size: cover;overflow: hidden;padding: 0px;margin-left: 3%;"
                             style="width: 42%;background-position: center;background-size: cover;overflow: hidden;padding: 0px;margin-left: 3%;"
                             :style="'background-image: url(\''+path+it.piPhoto+'\')'">
                        </div>
                        <div class="service_list_title">
                        	<h3>{{it.logName}}<i>{{it.piPosition}}</i></h3>
                           
                           <!--  <font cut="10">{{it.piBrief | cut(10)}}</font> -->
                           <div class="zishu">{{it.piArea}}</div>
                            <div class="l_date">{{it.piDealnum}}人约见</div>
                        </div>
                    </div>
                </a>
            </template>

            <template v-if="flag == 'c' " 注释="需求的模板">
                <a v-for="it in contentList" href="javascript:void(0)" @click="go(it)">
                    <div class="service_list" style="padding-top:15px">
                        <div class="service_list_img" v-if ="it.demImage!=''"
                             style="width: 25%;background-position: center;background-size: cover;overflow: hidden;padding: 0px;margin-left: 3%;"
                             style="width: 42%;background-position: center;background-size: cover;overflow: hidden;padding: 0px;margin-left: 3%;"
                             :style="'background-image: url(\''+path+it.demImage+'\')'">
                        </div>
                        <div class="service_list_img" v-if ="it.demImage==''"
                             style="width: 25%;background-position: center;background-size: cover;overflow: hidden;padding: 0px;margin-left: 3%;"
                             style="width: 42%;background-position: center;background-size: cover;overflow: hidden;padding: 0px;margin-left: 3%;"
                             :style="'background-image: url(\''+path+'/images/wap/xq_picture.jpg\')'">
                        </div>
                        <div class="service_list_title" style="padding: 0px;margin-left: 5%">
                            <h3>{{it.demTitle}}</h3>
                            <div class="xuqiu_n_content">{{it.demContent}}</div>
                            <div class="xuqiu_n_time">{{it.demCreatetimeStr}}</div>
                            <!--  <font cut="10">{{it.demBrief | cut(10) }}</font> -->
                        </div>
                    </div>
                </a>
            </template>
            <div id="loding" style="text-align: center;line-height: 50px;font-size: 16px;"></div>
        </div>


        <script>

        </script>
        <!--end.service_list-->
        <%--<div v-show="Math.ceil(contentCount/10)>page" class="jiaz" v-on:click="more">加载更多...</div>--%>
    </div>
    <!--end.content_list-->
</div>
<!--page end-->
</div>
<!--wapper end-->
<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp" %>
</body>

</html>