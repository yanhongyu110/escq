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
		<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
		<link rel="stylesheet" href="${webtxc}/css/wap/personer.css?val=1d3" />
		  <script type="text/javascript">
		    window.onload=function(){
		    var cc='${content}';
		    if(cc.indexOf('正在审核')>=0){
		    	$("#tsimg").addClass('shen_zzsh_img');
		    }
		    if(cc.indexOf('已通过')>=0|cc.indexOf('成功')>=0){
		    	$("#tsimg").addClass('shen_tg_img');
		    }
		    if(cc.indexOf('实名认证')>=0){
		    	$("#tsimg").remove();
		    }
		    }
    </script>
	</head>
   
	<body style="background:#fff">
		<!--wapper-->
		<div class="wapper">
			<!--page-->
			<div id="page">
				
				
				<div class="personer_mes">
					
					<div class="personer_mes_zl">
							
					            <!-- <div class="status_icon"> -->
					            <div class="note_message">
					                <div class="shenhe">
					                <c:if test="${empty url}"> <h3>${content}</h3><p>${contentTwo}</p></c:if>
					                  <div id="tsimg" ></div>
					                  <c:if test="${!empty url}"><h3><Strong onclick="window.location.href=path+'${url}'">${content}</Strong><br></h3><p>${contentTwo}</p></c:if> 
					                </div><!--end.shenhe-->
					            </div>
					            <!-- </div> -->
						
					</div>
					
				</div>
				<!--end.personer_mes-->
				
				<!--end.personer_excit-->
			</div>
			<!--page end-->
		</div>
		<!--wapper end-->
<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%>
	</body>

</html>