<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>

		<meta charset="UTF-8">
		<title>专家服务评价</title>
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
		<link rel="stylesheet" href="${webtxc}/css/wap/personer.css?val=123" />
		<script src="${webtxc}/js/wap/reset.js"></script>
		<script src="${webtxc}/js/wap/TouchSlide.js"></script>
		<script src="${webtxc }/js/wap/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
		<script type="text/javascript" src="${webtxc}/myjs/wap/goodsinfo/animaremarkslist.js?value=12333243312"></script>


		<style type="text/css">

			:after, :before {
				-webkit-box-sizing: border-box;
				-moz-box-sizing: border-box;
				box-sizing: border-box;
			}
			.clearfix:after, .clearfix:before{
				display: table;
				content: " ";
			}
			.clearfix:after{
				clear: both;
			}

			.title-list.fr.cf li{
				width: 25%;
			}
			.title-list.fr.cf p{
				width: 25%;
			}
			.waiter_box.border_bottom  .waiter h1{
				
				overflow: hidden;
				white-space: nowrap;
				text-overflow: ellipsis;
				font-weight:600;
				    padding-bottom: 5px;
			}

			.waiter_box.border_bottom  .waiter p{
				width:100%;
				overflow: hidden;
				white-space: nowrap;
				text-overflow: ellipsis;
				color: #333;
			}
			.p_tan{
				left: 0;
				width: 100%;
			}

			.waiter_box{
				height: auto;
			}
			.remark_content {
			
   
    clear: both;
    width:100%;
    margin: 0 auto;
    font-size: 15px;
        padding-top: 10px;
        background: #f8f8f8;
        
}
		
			.remark_content_son1_repl{
			padding: 0px 15px 5px 15px;
			    font-size: 14px;
				
			}
			.remark_content_son1 {
    padding: 0;
    clear: both;
}
.remark_content_son1_repl a{color:#999}
.remark_content_son1_pl {
    clear: both;
    padding: 0px 15px 5px 15px;
    line-height: 25px;
    text-align: left;
    /* background: #eee; */
    margin-bottom: 10px;
    border-bottom: 1px solid #eee;
        font-size: 14px;
}
.remark_content_son1_pl span{color:#999;    display: block;font-size: 13px;}
		</style>
		<script type="text/javascript">
			var logId = '${logId}';
			//console.log(logId);
		</script>
		<script>
			$(function() {
				//设计案例切换
				$('.title-list li').click(function() {
					/*var liindex = $('.title-list li').index(this);
					$(this).addClass('on').siblings().removeClass('on');
					$('.service_content div.service_content_pj').eq(liindex).fadeIn(150).siblings('div.service_content_pj').hide();
					var liWidth = $('.title-list li').width();
					$('.my_date_bt .title-list p').stop(false, true).animate({
						'left': liindex * liWidth + 'px'
					}, 300);*/
				});

				//设计案例hover效果
				/*$('.service_content .service_content_pj li').hover(function() {
					$(this).css("border-color", "#ff6600");
					$(this).find('p > a').css('color', '#ff6600');
				}, function() {
					$(this).css("border-color", "#fafafa");
					$(this).find('p > a').css('color', '#666666');
				});*/
			});
		</script>
	</head>
	<body>
	<!--wapper-->
	<div class="wapper">
		<div id="page" style="margin-bottom: 56px;">
			<div class="personer_top" style="">
					<h3>服务评价</h3>
					<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
			</div>
			<div class="my_date_bt">
				<div class="title cf">
					<ul class="title-list fr cf ">
						<li  id="li1" class="on">全部(<span id="total0"></span>) <input type="hidden" value="0,1,2"/> </li>
						<li  id="li2">好评(<span id="total1"></span>) <input type="hidden" value="0"/></li>
						<li  id="li3">中评(<span id="total2"></span>) <input type="hidden" value="1"/></li>
						<li  id="li4">差评(<span id="total3"></span>) <input type="hidden" value="2"/></li>
						<p style="left: 0px;"></p>
					</ul>
				</div>
			</div>


			<c:if test="${providerRemarkcount[19]!=0 }">
			<div class="service_content_pj_list" style="padding-top: 0px;">
				<%--<div class="waiter_box border_bottom clearfix">
					<div class="waiter_img"><img src=""></div>
					<div class="waiter">
						<h1>服务标题</h1>
						<p>服务内容</p>
						<p>2014-09-12</p>
					</div>
					<div class="my_remark_right">
						<div class="star_box" style=" position:absolute; top:30px; right:10px;">
							<img src="./images/star.png">
							<img src="./images/star.png">
							<img src="./images/star.png">
							<img src="./images/star.png">
							<img src="./images/star_gray.png">
						</div>
					</div>
					<div class="remark_content" style="display: none;">
						<div class="remark_content_son1">
							<div class="remark_content_son1_pl"><a href="javascript:;">jdj1231 [评论]</a>&nbsp;<a href="javascript:;">[2017/02/50]</a>评啊回家睡大觉卡上的卡号是低级卡刷的卡号卡萨湖的咯几乎是大卡收大卡还是大喊大叫卡是大红色的卡号是低级卡和尚的啊是的咯叫啥空间</div>
							<div class="remark_content_son1_repl"><a href="javascript:;">我    [回复]</a>&nbsp;<a href="javascript:;">[2017/02/50]</a>评啊回家睡大觉卡上的卡号是低级卡刷的卡号卡萨湖的咯几乎是大卡收大卡还是大喊大叫卡是大红色的卡号是低级卡和尚的啊是的咯叫啥空间</div>

						</div>
						<div class="remark_content_son1">
							<div class="remark_content_son1_pl"><a href="javascript:;">jdj1314 [追加评论]</a>&nbsp;<a href="javascript:;">[2017/02/50]</a>评啊回家睡大觉卡上的卡号是低级卡刷的卡号卡萨湖的咯几乎是大卡收大卡还是大喊大叫卡是大红色的卡号是低级卡和尚的啊是的咯叫啥空间</div>
							<div class="remark_content_son1_repl"><a href="javascript:;">我    [追加回复]</a>&nbsp;<a href="javascript:;">[2017/02/50]</a>评啊回家睡大觉卡上的卡号是低级卡刷的卡号卡萨湖的咯几乎是大卡收大卡还是大喊大叫卡是大红色的卡号是低级卡和尚的啊是的咯叫啥空间</div>
						</div>
					</div>
				</div>--%>


			</div>
				<div class="jiaz" id="load_more"></div>
			</c:if>
			<c:if test="${providerRemarkcount[19]==0 }">
				<div class="note_message" >
					<h3 class="remark_fuw">暂无评价</h3><br>
				</div>
			</c:if>
	</div>
	<!--wapper end-->
	<%-- <%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%> --%>
</body>

</html>