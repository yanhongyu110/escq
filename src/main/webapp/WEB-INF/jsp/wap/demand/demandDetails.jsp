<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>需求详情</title>
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<meta content="yes" name="apple-mobile-web-app-capable">
		<!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
		<meta name="apple-touch-fullscreen" content="yes">
		<!-- 开启对web app程序的支持  -->
		<meta content="telephone=no,email=no" name="format-detectservice_main_imgion">
		<!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
		<!--base css-->
		<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
    	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
		<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
		<link rel="stylesheet" href="${webtxc}/css/wap/index.css?val=1234" />
		<link rel="stylesheet" href="${webtxc}/css/wap/personer.css"/>

		<%-- wap分享样式 --%>
		<link rel="stylesheet" href="${webtxc}/css/wap/jqShare.css" />

		<script src="${webtxc}/js/wap/reset.js"></script>
		<script src="${webtxc}/js/wap/TouchSlide.js"></script>
		<script>
			var loginfo='${sessionScope.logInfo}';
			$(function() {
				//设计案例切换
				$('.title-list li').click(function() {
					var liindex = $('.title-list li').index(this);
					$(this).addClass('on').siblings().removeClass('on');
					$('.service_content div.service_content_pj').eq(liindex).fadeIn(150).siblings('div.service_content_pj').hide();
					var liWidth = $('.title-list li').width();
					$('.wap_service_xq .title-list p').stop(false, true).animate({
						'left': liindex * liWidth + 'px'
					}, 300);
				});

				//设计案例hover效果
				$('.service_content .service_content_pj li').hover(function() {
					$(this).css("border-color", "#ff6600");
					$(this).find('p > a').css('color', '#ff6600');
				}, function() {
					$(this).css("border-color", "#fafafa");
					$(this).find('p > a').css('color', '#666666');
				});
			});
		</script>
		<script type="text/javascript" src="${webtxc}/myjs/wap/demand/demandDetails.js"></script>


	</head>

	<body>
	<input id="demId" type="hidden" value="${demand.demId}"/>
		<!--wapper-->
		<div class="wapper" style="border:0">
			<!--page-->
			<div id="page" style="margin-bottom: 56px;">
				<div class="service_main">
					<div class="service_main_img">
						<c:if test="${empty demand.demImage}"><img src="${webtxc}/images/wap/xq_picture.jpg" /></c:if>
						<c:if test="${not empty demand.demImage}"><img src="${demand.demImage}" /></c:if>
						<!-- <div class="service_main_img_ms">
							 <span>关注300人</span> <span>约见200人</span> <span>900人想见</span>
						</div> -->
					</div> 
					<!--end.service_main_img-->
					<div class="service_main_introduce">

						<div class="wap_service_xq">
						<!-- 
							<div class="title cf">
								<ul class="title-list fr cf ">
									<li class="on">需求详情</li>
									
									
									<p></p>
								</ul>
							</div> -->
							<div class="service_content ">
								<div class="service_content_pj show " id="fxContent">
									<div class="service_content_jianjie ">
										<div class="service_main_introduce_img" onclick="window.location.href=path+'/wap/userinfo/providerdetails/preProviderForXuqiu.html?logId=${demand.demLogid }'">
										<img src="${demand.userPhoto }" style="width: 50px;height: 50px;border-radius: 50%;">
											
										</div>
										<div class="service_main_introduce_title">
											<h3>${demand.demTitle }</h3>
											<!-- <p id="keyword">关键字:${fn:substring(demand.demKeyword, 2, fn:length(demand.demKeyword)-2)}</p> -->
											<!-- <p><b>￥122.00</b></p> -->
											<div class="demand_contents">${demand.demContent }</div>
											<!--<div class="gm_xq">
												<span class="pay">购买服务</span>
												<span class="sc">收藏服务</span>
											</div>-->
										</div>
										<!--end.service_main_introduce_title-->

										<div class="s_jianjie">
											<!-- <p>需求介绍：${demand.demBrief }</p> -->
											
										</div>
										
									</div>
									<!--end.service_content_jianjie-->
									<c:if test="${sessionScope.logInfo.logId!=demand.demLogid }">
										<div class="service_content_img_pay">
											<div id="collect" class="guanzhu">收藏</div>
											
											<div class="fenx" onclick="fxClick();return false;">分享</div>
											
											
										</div>
									</c:if>
									<!--end.service_content_img_pay-->
									
									<div class="expert_qt"><h4>其他需求</h4></div>
									<c:forEach items="${others }" var="item" varStatus="i">
									<c:if test="${i.count < 6 }">
										<div class="service_content_jianjie hav_border">
											<div class="service_main_introduce_img">
												<a href="${webtxc}/wap/demand/queryById.html?id=${item.demId }"><img src="${item.demImage }" /></a>
											</div>
											<div class="service_main_introduce_title">
												<h3><a href="${webtxc}/wap/demand/queryById.html?id=${item.demId }">${item.demTitle }</a></h3>
												<!-- <p>${demand.demContent }</p>-->
												<!-- <p id="keyword${i.count }">关键字:${fn:substring(item.demKeyword, 2, fn:length(item.demKeyword)-2)}</p> -->
												
											</div>
											<!--end.service_main_introduce_title-->
	
											
											<!--end.s_jianjie-->
	
										</div>
									</c:if>
									</c:forEach>
									<script type="text/javascript">
										var others = ${others };
										$(function(){
											
										});
									</script>
									<!--end.service_content_jianjie-->
									
								</div>
								<!--end.service_content_pj-->
							</div>
							<!--end.service_content-->

						</div>
						<!--end.wap_service_xq-->
					</div>
					<!--end.service_main_introduce-->
				</div>
				<!--end.service_main-->

				

			</div>
			<!--page end-->
		</div>
		<!--wapper end-->

	<!--  分享模块开始 -->
	<div id="jqShareMT">
		<div id="jqShare" class="kePublic">
			<span class="shareClosed"  onclick="fxClose();return false;"></span>
			<!--效果html开始-->
			<style type="text/css">
				.bdsharebuttonbox a { width: 60px!important; height: 60px!important; margin: 0 auto 10px!important; float: none!important; padding: 0!important; display: block; }
				.bdsharebuttonbox a img { width: 60px; height: 60px; }
				.bdsharebuttonbox .bds_tsina { background: url(../../../images/wap/gbRes_6.png) no-repeat center center/60px 60px; }
				.bdsharebuttonbox .bds_qzone { background: url(../../../images/wap/gbRes_4.png) no-repeat center center/60px 60px; }
				.bdsharebuttonbox .bds_tqq { background: url(../../../images/wap/gbRes_5.png) no-repeat center center/60px 60px; }
				.bdsharebuttonbox .bds_weixin { background: url(../../../images/wap/gbRes_2.png) no-repeat center center/60px 60px; }
				.bdsharebuttonbox .bds_weixin2 { background: url(../../../images/wap/gbRes_7.png) no-repeat center center/60px 60px; }
				.bdsharebuttonbox .bds_sqq { background: url(../../../images/wap/gbRes_3.png) no-repeat center center/60px 60px; }
				.bdsharebuttonbox .bds_renren { background: url(../../../images/wap/gbRes_1.png) no-repeat center center/60px 60px; }
				.bd_weixin_popup .bd_weixin_popup_foot { position: relative; top: -12px; }
			</style>
			<div class="gb_resLay">
				<div class="gb_res_t"><span>分享到</span><i></i></div>
				<div class="bdsharebuttonbox">
					<ul class="gb_resItms">
						<li onclick="fxSelect(this); return fasle;"> <a title="分享到微信" href="#" class="bds_weixin"  ></a>微信好友 </li>
						<li onclick="fxSelect(this); return fasle;"> <a title="分享到微信" href="#" class="bds_weixin2"  ></a>微信朋友圈 </li>
						<li onclick="fxSelect(this); return fasle;"> <a title="分享到QQ好友" href="#" class="bds_sqq"  ></a>QQ好友 </li>
						<li onclick="fxSelect(this); return fasle;"> <a title="分享到QQ好友" href="#" class="bds_qzone"  ></a>QQ空间 </li>
						<li onclick="fxSelect(this); return fasle;"> <a title="分享到新浪微博" href="#" class="bds_tsina" ></a>新浪微博 </li>
					</ul>
				</div>
			</div>
			<!--效果html结束-->
			<div class="clear"></div>
		</div>
	</div>
	<script type="text/javascript">
	function fxClick(){
		$("#jqShareMT").show();
        $("#jqShare").css({bottom:"0px"});
	}
	function fxClose(){
		 $("#jqShareMT").hide();
         $("#jqShare").css({bottom:"170px"});
	}
	function fxSelect(e){
		var  type  = $(e).index()+1+"";
		//console.log(type);
        //var  $divInfo  = $(".artical_xqs");
        var  title = '${serviceVo.serviceTitle}';
        var  content = title;
        title=title.substring(0, 10)+"···";
        var  url  = window.location.href;
        var  imgUrl = path+"/images/logo.png";
        wapShare(type,title,content,url,imgUrl);
	}
        $(function () {
            /* $(document).on("click",".fenx",function () {
                $("#jqShareMT").show();
                $("#jqShare").css({bottom:"0px"});
            });
            $(document).on("click",".shareClosed",function () {
                $("#jqShareMT").hide();
                $("#jqShare").css({bottom:"170px"});
            });

            $(".gb_resItms li").on("click",function () {
                var  type  = $(this).index()+1;
                var  $divInfo  = $("#fxContent .service_content_jianjie:eq(0)");
                var  title = $divInfo.find(".service_main_introduce_title h3").html();
                var  content = $divInfo.find(".s_jianjie p").html();
                var  url  = window.location.href;
                var  imgUrl = localhostPath + $divInfo.find(".service_main_introduce_img img").attr("src");
                wapShare(type,title,content,url,imgUrl);
            }); */

        });
	</script>
	<!--  分享模块结束 -->

	<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%>
	</body>

</html>