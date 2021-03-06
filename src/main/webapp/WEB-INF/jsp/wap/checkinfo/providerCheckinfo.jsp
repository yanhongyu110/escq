<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>专家认证</title>
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
		<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    	<%@ include file="/WEB-INF/jsp/common/anima.jsp" %>
    	<script type="text/javascript" src="${webtxc}/myjs/wap/checkinfo/providercheck.js?val=12123312"></script>
		<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
		<link rel="stylesheet" href="${webtxc}/css/wap/personer.css?val=1ddd3" />


		<style>
			.upli{
				text-align: center;
				border: 1px solid #a4a4a4;
				border-radius: 3px;
				margin: 10px 15px;
				
				position: relative;
				background-position: center;
				background-size: contain;
			}
			.upli:before{
				content: "";
				float: left;
				display: inline-block;
				padding-bottom: 70%;
			}
			.upli span{
				line-height: 10px;
				position: absolute;
				left: 0px;
				right: 0px;
				top: 71%;
			}
			.wapper{background:#fff}
		</style>
		<script>
            $(function () {
//                $('.list_mes textarea').each(function () {
//                    $(this).css({    "line-height": "19px","padding": "5%","width":'90%'});
//                });
//			    $('.list_mes > li:nth-child(2)').css({"line-height": "2"})
                $('.upli').each(function () {
                    var li = $(this);
                    li.css({});
//                    li.find('img').get(0).style='vertical-align: middle;text-align: center;display: inline-block;width: 50px;height: 50px;border-radius:0;'
                });

                $('.personer_zp').css({height:'auto',overflow:'hidden'})

				$('.item').each(function () {
				    $(this).children().eq(0).get(0).style=' ';
                })

            });
		</script>
		
	</head>

	<body>
		<!--wapper-->
		<div class="wapper">
			<!--page-->
			<div id="page">
				<div class="personer_top">
					<h3>专家认证</h3>
					<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
				</div>
				
				<div class="personer_mes">
					
					<div class="personer_mes_zl">
		
						<div class="personer_zp item">
						<ul>
							<li>上传名片<span class="personer_mes_ts">(选填)</span></li>
							<li class="add_demends upli" >
								<img class="imgUrl"/>
							</li>
							<li class="add_demends upli" >
								<img class="imgUrl"/>
							</li>
							<input type="hidden" class="pciImage imgUrls"  name="pciImage" value="${providerCheckInfo.pciImage}"/>
						</ul>
						<ul>
							<li>学历资料<span class="personer_mes_ts">(选填)</span></li>
							<li class="add_demends upli" >
								<img class="imgUrl"/>
							</li>
							<li class="add_demends upli" >
								<img class="imgUrl"/>
							</li>
							<input type="hidden" class="pciEaducate imgUrls"  name="pciEaducate" value="${providerCheckInfo.pciEaducate}"/>
						</ul>
						<ul>
							<li>专业证书<span class="personer_mes_ts">(选填)</span></li>
							<li class="add_demends upli" >
								<img class="imgUrl"/>
							</li>
							<li class="add_demends upli" >
								<img class="imgUrl"/>
							</li>
							<input type="hidden" class="pciCredentials imgUrls"  name="pciCredentials" value="${providerCheckInfo.pciCredentials}"/>
						</ul>
						<ul>
							<li>其他资料<span class="personer_mes_ts">(选填)</span></li>
							<li class="add_demends upli" >
								<img class="imgUrl"/>
							</li>
							<li class="add_demends upli" >
								<img class="imgUrl"/>
							</li>
							<input type="hidden" class="pciOthers imgUrls"  name="pciOthers" value="${providerCheckInfo.pciOthers}"/>
						</ul>
						</div>
						
						
					</div>
					
				</div>
				<!--end.personer_mes-->
				
				<!--end.personer_excit-->
			</div>
			<!--page end-->
		</div>

		<div style="height: 40px;width: 100%"></div>
		<!--wapper end-->
<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%>
	</body>

</html>