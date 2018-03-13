<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<meta charset="UTF-8">
		<title>正在支付</title>
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
		<script src="${webtxc}/js/wap/reset.js"></script>
		<script src="${webtxc}/js/wap/TouchSlide.js"></script>
		<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
		<script type="text/javascript">
		 <script>
			//定时器每3秒访问后台是否支付完成	    
		    $(document).ready(function () {
			    setInterval("testState()", 3000);
			  
			    //定时器  120秒后跳转至选择支付方式页面
			    var exittime=120;
			   tt(exittime);
			    function tt(i){
		    		$(".wxtime").html(i);
			    	if(i==0){
			    		window.location.href="javascript:history.back(-1);";
			    	}else{
			    		i--;
			    		setTimeout(function() {
			    			tt(i)
			    		}, (1000));
			    		
			    	}
			    }
			});
			var URL=path+"/pay/wxpay/payreturn.html"
			function testState() {
			    if ($("#orderId").val() != 0) {
			        $.ajax({
			        	type: "post",
			            url: URL+"?orderId=${orderId}",
			            success: function (data) {
			            	var temp=eval(data);
			                if (temp==1) { //订单状态为1表示支付成功
			                	alert("微信支付成功！",null,function(tt){window.location.href = path+"/wap/saleinfo/orderInfoBuyer/orderView.html";},null);
			                    //页面跳转
			                }
			            },
			            error: function () {
			                 alert("请求订单状态出错"); 
			            }
			        });
			    }
			
			}

		  
		    </script>
		
		</script>
</head>
<body>
<div class="wapper">
		<!--page-->
		<div id="page" style="margin-bottom: 56px;">
			<div class="content_list"></div>
			<!--end.service_list-->
			<div class="jiaz" >正在支付...</div>
		</div>
		<!--end.content_list-->
	</div>
	<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%>
</body>
</html>
