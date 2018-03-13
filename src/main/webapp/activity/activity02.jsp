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
	.active_sf img{width:100%;}
	body{background:#fff}
	.fbxq{background:#f8f8f8;padding:15px;border:3px solid #2e85ce}
	.fbxq span{color:#f40;font-size:16px;font-weight:bold;}
	.fbxq p{line-height:30px;font-size:18px;}
	.hdxq{margin-top:10px;font-size:15px;color:#999}
	.hdxq p{line-height:25px;}
	.hdxq h4{margin-bottom:5px;}
	.fbxq h4{margin-bottom:10px;}
	.fbxq h3{color:#6c9dd8;margin-bottom:10px;}
	.xx_img{width:70px;margin:20px auto 30px auto;clear:both;display: block;}
	.xx_img img{width:70px}
	</style>
</head>
<body>
   <div class="active_sf">
     <h2>一个诡异的读心测试，谁能告诉我这是怎么一回事？</h2>
     <span>2018-01-24</span><font>近到家服务平台</font>
     
     <img src="${webtxc}/images/wap/act01.png" style="margin-top:20px;"/>
     <img src="${webtxc}/images/wap/ks.png" />
     <img src="${webtxc}/images/wap/cs.jpg" />
     <img src="${webtxc}/images/wap/kz.jpg" />
     <div class="xx_img"><img src="${webtxc}/images/wap/1.png"   /></div>
     <div class="xx_img"><img src="${webtxc}/images/wap/2.png"  /></div>
     <div class="xx_img"><img src="${webtxc}/images/wap/3.png"   /></div>
     <img src="${webtxc}/images/wap/jjg.jpg"  />
     <img src="${webtxc}/images/wap/sdd.jpg" />
     <img src="${webtxc}/images/wap/ggz.png"/>
   </div>
</body>
</html>