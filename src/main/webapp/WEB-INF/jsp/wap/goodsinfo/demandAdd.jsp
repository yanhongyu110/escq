<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
	<head>

		<meta charset="UTF-8">
		<title>发布需求</title>
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
		<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
		<link rel="stylesheet" href="${webtxc}/css/wap/index.css" />
		
	</head>
	<body>
	<div class="wapper">

		<div class="personer_top">
			<h3>发布需求</h3>
			<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
		</div>
				
				
				<div class="personer_mes">										
					<ul class="list_mes have_border">
						<li class="demand_title">需求名称：</li>						
						<li class="add_demends"><input type="text" value="请输入需求名称"></li>
					</ul>
					<ul class="list_mes">
						<li class="demand_title">预约时间：</li>						
						<li class="add_demends">2017-05-26</li>
					</ul>
					<ul class="list_mes">
						<li class="demand_title">联系人：</li>						
						<li class="add_demends"><input type="text" value="请输入联系人姓名"></li>
					</ul>
					<ul class="list_mes">
						<li class="demand_title">联系电话：</li>						
						<li class="add_demends"><input type="text" value="请输入联系电话"></li>
					</ul>
					<ul class="list_mes text_height">
						<li class="demand_title">需求描述：</li>						
						<li class="add_demends "><textarea></textarea></li>
					</ul>
					<ul class="list_mes">
						<li class="demand_title">需求类型：</li>						
						<li class="add_demends"><select><option>技术开发</option></select></li>
					</ul>
				</div><!--end.personer_mes-->
				<div class="personer_excit">
					<div class="excit">提交需求</div>
					
				</div>
				
				
			
		</div>
		<!--wapper end-->
</body>

</html>