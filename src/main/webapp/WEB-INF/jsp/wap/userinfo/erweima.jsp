<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

	<meta charset="UTF-8">
	<title>我的二维码</title>
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

	<link rel="stylesheet" href="${webtxc}/css/wap/personer.css?v=1234" />
    <script type="text/javascript" src="${webtxc}/jquery/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
	<script type="text/javascript" src="${webtxc }/js/wap/jquery.qrcode.js" ></script>
    <script type="text/javascript" src="${webtxc }/js/wap/qrcode.js" ></script> 
    <script type="text/javascript" src="${webtxc }/js/wap/utf.js" ></script>
</head>
<style>
.s_ewm_phto{width:70%;margin:20% auto;clear:both;}
.s_ewm_phto_img {float:left;width:20%;}
.s_ewm_phto_img img{width: 50px;border-radius: 6px;border: 2px solid #ccc;height:50px;    margin-bottom: 20px;}
.s_ewm_phto_title{float:left;width:70%;color:#fff;margin-left:5%}
</style>

<body style="background: url(../../images/wap/2zrdI1g.jpg) no-repeat left;">
        <div class="s_ewm_phto">
		 <div class="s_ewm_phto_img"><img src="${user.userPhoto}"></div>
		 <div class="s_ewm_phto_title">${user.logName}</div>
		 </div>  
		 <div id="qrcodeCanvas" class="s_ewm">
		
		 </div>
</div>
		 <script type="text/javascript">
		  	var redirect_uri = encodeURIComponent("http://www.jindaoj.com/wap/userinfo/logInfo/jumpJdjerweima.htm?parentId=${user.logId}");
	var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd0c763640d4b8f08&redirect_uri="
+ redirect_uri
+ "&response_type=code&scope=snsapi_base&state="
+ encodeURIComponent("http://www.jindaoj.com/wap/userinfo/personerErweima.html")+"#wechat_redirect";
		 		/**
				 *  生成二维码
				 */
				jQuery('#qrcodeCanvas').qrcode({
					render    : "canvas",
					text    : url,
					width : "200",               //二维码的宽度
					height : "200",              //二维码的高度
				   
					background : "#ffffff",       //二维码的后景色
					foreground : "#000000",        //二维码的前景色
					src: '${user.userPhoto} '       //二维码中间的图片
				});   



function convertCanvasToImage(canvas) {
    //新Image对象，可以理解为DOM
    var image = new Image();
    // canvas.toDataURL 返回的是一串Base64编码的URL，当然,浏览器自己肯定支持
    // 指定格式 PNG
    image.src = canvas.toDataURL("image/png");
    return image;
}

//获取网页中的canvas对象

var mycanvas1=document.getElementsByTagName('canvas')[0];

//将转换后的img标签插入到html中

var img=convertCanvasToImage(mycanvas1);
$('#qrcodeCanvas').html(img); 
 $('#qrcodeCanvas').append("<p>分享我的二维码给好友</p>");


		 </script>
		</div><!--end.personer_mes-->
	</div>
	<!--page end-->
</div>
<!--wapper end-->
<%-- <%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%> --%>
</body>

</html>