<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>活动详情</title>
	<meta content="yes" name="apple-mobile-web-app-capable">
	<!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
	<meta name="apple-touch-fullscreen" content="yes">
	<!-- 开启对web app程序的支持  -->
	<meta content="telephone=no,email=no" name="format-detection">
	<!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
	<!--base css-->
	<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	<style>
	.active_sf{width:90%;margin:0 auto;padding:20px 0;}
	.active_sf h2{text-align:left;font-weight:normal;margin-bottom:10px;}
	.active_sf span{font-size:14px;color:#999;}
	.active_sf font{color:#6c9dd8;font-size:14px;padding-left:10px}
	.active_sf img{width:100%;margin-top:10px}
	body{background:#fff}
	.fbxq{background:#fcfbea;padding:10px;border:3px solid #2e85ce}
	.fbxq span{color:#f40;font-size:16px;font-weight:bold;}
	.fbxq p{line-height:30px;font-size:16px;}
	.hdxq{margin-top:20px;font-size:14px;color:#999}
	.hdxq p{line-height:25px;}
	</style>
</head>
<body>
   <div class="active_sf">
     <h2>首次发布服务/需求，即可赢大奖红包!</h2>
     <span>2018-01-23</span><font>近到家服务平台</font>
     
     <img src="${webtxc}/images/wap/fx.png"/>
     <div class="fbxq">
       <p>① 打开<span>“近到家”</span>微信公众平台，点击菜单栏的<span>“发布有奖”</span>；</p>
       <p>② 在“近到家”主页点击底部菜单<span>“个人中心”</span>，点击<span>服务商认证</span>，填写服务商基本信息即可。</p>
       <p>③ <span>“ + ”</span>号，选择发布服务/需求，填写发布的具体内容即可。</p>
     </div>
     <div class="hdxq">
       <h4>活动规则说明：</h4>
       <p>1、2018年1月1日09:00起至2018年1月31日24:00止，发布服务获得平台奖励，奖励金额随机发放，最多20元；</p>
       <p>2、获得的红包会自动存入到你“近到家”的个人账户中，可免费提现；</p>
       <p>3、发布的服务内容健康，无链接，描述尽量清楚；</p>
       <p>4、最终解释权归近到家平台所有；</p>
     </div>
     <img src="${webtxc}/images/wap/ggz.png"/>
   </div>
</body>
</html>