<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>发布视频</title>
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
		<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
		<meta name="description" content="近到家，是全国最贴近生活的大众平台，当你遇到任何领域的问题或者是个性化的服务需求，都可以就近找到“对”的人，为你提供帮助，定制服务。达人专家按需约见，在线交流。">
        <meta name="keywords" content="帮助他人，分享技能，提供帮助，赚钱回报，“0”元创业，发布服务，解决问题，一对一，面对面">
		<link rel="stylesheet" href="${webtxc}/css/wap/index.css"/>
		<link rel="stylesheet" href="${webtxc}/css/wap/personer.css"/>
		
		<script type="text/javascript" src="${webtxc}/js/wap/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="${webtxc}/js/wap/TouchSlide.1.1.js"></script>
		<script type="text/javascript" src="${webtxc}/jquery/jquery.cookie.js"></script>
		<script type="text/javascript" src="${webtxc }/js/wap/common.js"></script>
		<script type="text/javascript" src="${webtxc }/js/wap/jquery.validate.js"></script>
		<script type="text/javascript" src="${webtxc }/myjs/wap/goodsinfo/add_sp.js"></script>
	</head>
	<style>
	body{background:#fff}
	.add_sp{width:90%;margin:30px auto 10px auto;}
	.add_sp_title{width:100%;clear:both;margin-bottom:10px;overflow: hidden;color: #999;}
	.sp_miaoshu{color: #999;height:50px}
	.add_sp_title .sp_bt{float:left;width:20%;height: 30px;line-height: 30px;}
	.add_sp_title .sp_input{float:left;width:100%;font-size: 15px;border-style: none; -webkit-appearance: none;outline:none}
	ul,li{list-style:none;}
	.sp_input{border:0;height:50px;font-family: Helvetica, Microsoft YaHei, sans-serif;}
	.add_sp_title .sp_shangchuan{float:left;width:100%;height:150px;background:#f8f8f8;}
	.add_sp_title .sp_shangchuan span{color:#999;text-align:center;display: block;}
	.add_sp_title .sp_shangchuan b{color:#999;text-align:center;display: block;font-size:60px;font-weight: normal;}
	.add_sp_title_ts{clear:both;font-size: 12px;color: #f40;display:none}
	.md_sp{padding-top: 10%;}
	.sp_shangchuan{width: 90%;margin: 0 auto;}
	.sp_shangchuan .scs{background:#f60;color:#fff;padding:5px 20px;border-radius: 4px;font-size: 15px;}
	</style>
<body>
 <div class="add_sp">
		 <form id="form">
			   <div class="add_sp_title">
			      <!-- <ul>
			        <li class="sp_bt">标题</li>
			        <li><input name="videoTitle" id="title"  type="text" class="sp_input" /></li>
			        	<input type="hidden" id="videoUrl" name="videoUrl"/>
			      </ul>
			      <div id="title1"></div>
			      <div class="add_sp_title_ts">标题必填</div> -->
			           <div class="sp_miaoshu"><input name="videoTitle" placeholder="请对视频进行描述" id="title"  type="text" class="sp_input" /></div> 
			   </div>
		 </form>
	   <div class="add_sp_title">
	      
	        <video id="videoSrc" controls="controls" hidden="true" style="width:100%">
	        </video>
	        <div class="sp_shangchuan" id="addVideo">
	            <div class="md_sp">
	            <b>+</b>
	            <span>添加视频</span>
	            </div>
	        </div>
	  
	   </div>
	 </div>
	 <div id="textEle" hidden="true">
		 <input type="text" readonly="readonly" id="readonly" style="display:none"/>
		 <div class="sp_shangchuan"><a href="javascript:addVideo()" class="scs">上传</a></div>
	 </div>
	 <form id="uploadVideo" method="post" enctype="multipart/form-data">
	<input type="file" name="file" id="videoAdd" hidden="true" onchange="judgeVideo(this.value);"/></br> 
	<!-- <input type="submit" value="上传"> -->
	 </form>
 <div class="personer_excit">
		<div class="excit" id="videoSave">发布</div>
 </div>
</body>
</html>