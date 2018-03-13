<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>发现</title>
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
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes"/>
    <link rel="stylesheet" href="${webtxc}/css/wap/reset.css"/>
    <link rel="stylesheet" href="${webtxc}/css/wap/index.css"/>
    <script src="${webtxc }/js/wap/reset.js"></script>
    <script src="${webtxc }/js/wap/jquery-1.9.1.min.js"></script>
    <script src="${webtxc }/js/wap/TouchSlide.js"></script>
    <script src="${webtxc}/js/template-web.js"></script>
    <script type="text/javascript" src="${webtxc }/myjs/wap/goodsinfo/recommend.js"></script>
    <script type="text/javascript" src="${webtxc }/js/wap/common.js?v=1212"></script>
    <script type="text/javascript">
        var business = '${business}';
        document.addEventListener('plusready', function () {
            //console.log("所有plus api都应该在此事件发生后调用，否则会出现plus is undefined。"
        });
    </script>
</head>

<body>
<div class="wapper">
    <div class="fond_all">
        <ul>
            <li><a id="all" href="#" onclick="getAll();return false;">全部</a></li>
            <li><select id="city">
                <option value="北京">北京</option>
                <option value="上海">上海</option>
                <option value="天津">天津</option>
                <option value="重庆">重庆</option>
                <option value="河北">河北</option>
                <option value="山西">山西</option>
                <option value="河南">河南</option>
                <option value="辽宁">辽宁</option>
                <option value="吉林">吉林</option>
                <option value="黑龙江">黑龙江</option>
                <option value="内蒙古">内蒙古</option>
                <option value="江苏">江苏</option>
                <option value="山东">山东</option>
                <option value="安徽">安徽</option>
                <option value="浙江">浙江</option>
                <option value="福建">福建</option>
                <option value="湖北">湖北</option>
                <option value="湖南">湖南</option>
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="江西">江西</option>
                <option value="四川">四川</option>
                <option value="海南">海南</option>
                <option value="贵州">贵州</option>
                <option value="云南">云南</option>
                <option value="西藏">西藏</option>
                <option value="陕西">陕西</option>
                <option value="甘肃">甘肃</option>
                <option value="青海">青海</option>
                <option value="宁夏">宁夏</option>
                <option value="新疆">新疆</option>
                <option value="港澳">港澳</option>
                <option value="台湾">台湾</option>
                <option value="钓鱼岛">钓鱼岛</option>
                <option value="海外">海外</option>
            </select>
            </li>
            <li><select id="business">
                <option value="17053120030004">教育</option>
                <option value="17080209080001">近商</option>
                <option value="17061213550001">科技</option>
                <option value="17053120030002">婚介</option>
                <option value="17053120030001">家政</option>
                <option value="17080209060001">律师</option>
                <option value="17080209100002">美女</option>
                <option value="17070414530001">模特</option>
                <option value="17080210130001">招聘</option>
                <option value="17080209090001">餐饮</option>
                <option value="17080209090003">茶馆</option>
                <option value="17080209090002">车行</option>
                <option value="17053120030003">风水</option>
                <option value="17092610200001">房屋出租</option>
                <option value="17092610200002">房屋装修</option>
                <option value="17092610200003">校园创业</option>
                <option value="17092610200004">校园跑腿</option>
            </select></li>
        </ul>
    </div>
    <div class="fond_list">
        <div id="fond_list">
            <script id="fond_list1" type="text/html">
                {{each list value i}}
                <ul>
                    <li>
                        <h3>{{value.companyName}}</h3>
                        <p>经营范围：{{value.companyBusinissScope}}</p>
                        <p>电话：{{value.companyTel}}</p>
                        <p>所在城市：{{value.companyProvince}}{{value.companyCity}}</p>
                        <p>地址：{{value.companyAddress}}</p>
                    </li>
                </ul>
                {{/each}}
            </script>
        </div>
        <div id="loding" style="text-align: center;line-height: 50px;font-size: 16px;"></div>
    </div>
</div>
<!--wapper end-->
<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp" %>
</body>

</html>