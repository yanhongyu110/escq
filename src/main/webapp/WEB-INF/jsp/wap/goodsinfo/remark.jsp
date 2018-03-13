<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>评论详情</title>
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<meta content="yes" name="apple-mobile-web-app-capable">
		<!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
		<meta name="apple-touch-fullscreen" content="yes">
		<!-- 开启对web app程序的支持  -->
		<meta content="telephone=no,email=no" name="format-detection">
		<!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
		<!--base css-->
		<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
		<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
		
		<link rel="stylesheet" href="${webtxc}/css/wap/personer.css?val=1423" />
		<link rel="stylesheet" href="${webtxc}/css/wap/remark.css?val=124" />
		<script src="${webtxc}/js/wap/reset.js"></script>
		<script src="${webtxc}/js/wap/TouchSlide.js"></script>
		<script type="text/javascript" src="${webtxc}/js/jquery-1.11.3.min.js" ></script>
		
		<script type="text/javascript" src="${webtxc }/js/wap/common.js"></script>
		<script type="text/javascript" src="${webtxc}/myjs/wap/goodsinfo/remake.js?v=20170613" ></script>
	</head>
	<body>
	<div class="personer_top">
		<h3>评价</h3>
		<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
	</div>
		<input id="osId" type="hidden" value="${obj.osId}" name="osId">
		<div class="waiter_box">
			<div class="border_top"></div>
			<div class="waiter_img"><img src="${obj.serviceInfo.servicePic}"></div>
			<div class="waiter">
				<h1>订单号：${obj.orderInfo.orderNo}</h1>
				<h2>${obj.serviceInfo.serviceTitle}
	        	<%-- <div class="star_box" style=" position:absolute; top:0; right:-85px; margin-top:0">
	                <img src="${webtxc}/wap/images/star.png">
	                <img src="${webtxc}/wap/images/star.png">
	                <img src="${webtxc}/wap/images/star.png">
	                <img src="${webtxc}/wap/images/star.png">
	                <img src="${webtxc}/wap/images/star_gray.png">
	            </div> --%>
	               <%--  <span>好评(${remarkCount.remark1Count })&nbsp;&nbsp;</span>
	                <span>中评(${remarkCount.remark2Count })&nbsp;&nbsp;</span>
	                <span>差评(${remarkCount.remark3Count })</span> --%>
        		</h2>
				<p>￥${obj.osPrice}</p>
			</div>
			<!--<p class="waiter_id">工号：370601001</p>-->
			<!--<div class="border_bottom"></div>-->
		</div>
		<c:if test="${log==obj.orderInfo.orderBuyer && obj.serviceRemark.srAppendcontent==null}">
		<div class="evaluate">
			
			<!--  
			<div style="display: block;height: 50%;width:100%;">
				<p style="width:20%;display: inline-block;margin-top:4px;font-size:12px;">服务评分：</p>
				<div class="star_box fastComment" id="oimg" style="padding-top:8px;margin-top:0;display: inline-block;width:80%;box-sizing:border-box;">
	                <img src="${webtxc}/images/star.png">
	                <img src="${webtxc}/images/star.png">
	                <img src="${webtxc}/images/star.png">
	                <img src="${webtxc}/images/star.png">
	                <img src="${webtxc}/images/star.png">
	                <span id="starnum" style="margin-left: 20px;font-size: 16px;font-weight: bold;color: #f57e16;">5.0</span>
				</div>
			</div>
			-->
			<div class="service_pingjias">
				
				<div class="star_box fastComment" style="display: inline-block;width:80%;">
	                <div title="非常棒" class="fastComment01" aa="0">非常棒</div>
	                <div title="一般般" class="fastComment02" aa="1">一般般</div>
	                <div title="给差评" class="fastComment02" aa="2">给差评</div>
				</div>
			</div>
			<div class="border_bottom"></div>
		</div>
		</c:if>
		<div class="say_more1">
			
				<div class="conta" style="display: ${obj.serviceRemark.srContent==null?'none':'block'}">
                    <div class="le">买家评价
                        <p class="po">分数${obj.serviceRemark.srRemark}</p>
                    </div>
                    <div class="ri">
                        <p>${obj.serviceRemark.srContent}</p>
                         <div class="lev">
                    
                   <span><f:formatDate value="${obj.serviceRemark.srCreatetime}" pattern="yyyy-MM-dd HH:mm" /></span>
                   			 等级：
                            <span>
                            	<c:if test="${obj.serviceRemark.srLevel==0}">非常棒</c:if>
                            	<c:if test="${obj.serviceRemark.srLevel==1}"> 一般般</c:if>
                            	<c:if test="${obj.serviceRemark.srLevel==2}"> 给差评</c:if>
                            </span>
                    </div>
                    </div>
                   
                </div>
                <!--  <hr style="display: ${obj.serviceRemark.srContent==null?'none':'block'}">-->
                <div class="conta" style="display: ${obj.serviceRemark.srResponsecontent==null?'none':'block'}">
                    <div class="le">卖家回复</div>
                    <div class="ri">
                        <p>${obj.serviceRemark.srResponsecontent}</p>
                        <div class="tt"><f:formatDate value="${obj.serviceRemark.srResponsetime}" pattern="yyyy-MM-dd HH:mm" /></div>
                    </div>
                    
                </div>
                <!--  <hr style="display: ${obj.serviceRemark.srResponsecontent==null?'none':'block'}">-->
                <div class="conta" style="display: ${obj.serviceRemark.srAppendcontent==null?'none':'block'}">
                    <div class="le">买家评价
                        <p class="po">分数:${obj.serviceRemark.srRemark}</p>
                    </div>
                    <div class="ri">
                        <p>${obj.serviceRemark.srAppendcontent}</p>
                        <div class="lev">
                    <span>
                        <f:formatDate value="${obj.serviceRemark.srAppendtime}" pattern="yyyy-MM-dd HH:mm" />
                    </span>
                    <span>等级:
                        <c:if test="${obj.serviceRemark.srLevel==0}">非常棒</c:if>
                        <c:if test="${obj.serviceRemark.srLevel==1}">一般般</c:if>
                        <c:if test="${obj.serviceRemark.srLevel==2}">给差评</c:if>
                    </span>
                            
                 </div>
                    </div>
                    
                </div>
               
                <div class="conta" style="display: ${obj.serviceRemark.srResponseappendcontent==null?'none':'block'}">
                    <div class="le">卖家回复
                    </div>
                    <div class="ri">
                        <p>${obj.serviceRemark.srResponseappendcontent}</p>
                        <div class="tt"><f:formatDate value="${obj.serviceRemark.srResponseappendtime}" pattern="yyyy-MM-dd HH:mm" /></div>
                    </div>
                    
                </div>
                <%-- <hr style="display: ${obj.serviceRemark.srResponseappendcontent==null?'none':'block'}"> --%>
				<!-- <textarea id="srContent" style="border-radius:2px;" placeholder="还想说点什么（文字输入限制10-225个字符）" maxlength=225 name="srContent"></textarea> -->
				<%--买家--%>
                   
            </div>
             <c:if test="${log==obj.orderInfo.orderBuyer}">
                        <c:if test="${obj.serviceRemark.srContent==null||obj.serviceRemark.srAppendcontent==null}">
                            <div class="pj_text">
                                <h4>评价内容：</h4>
                                <div class="pj_textarea">
                                    <textarea id="srContent" placeholder="在此输入评价的内容..."></textarea>
                                </div>
                                <div class="pj_ts" >为增加后续服务的满意度，请如实评价。</div>
                            </div>
							<!--提交-->
							<div class="confirm_box">
								<div class="confirm" onclick="sumbitRemake();">提交</div>
							</div>
                        </c:if>
                    </c:if>

                    <%--卖家--%>
                    <c:if test="${log==obj.orderInfo.orderSeller}">
                        <c:if test="${
                        (obj.serviceRemark.srContent!=null&&obj.serviceRemark.srResponsecontent==null)
                        ||(obj.serviceRemark.srAppendcontent!=null&&obj.serviceRemark.srResponseappendcontent==null)
                        }">
                            <div class="pj_text">
                                <h4>评价回复</h4>
                                <div class="pj_textarea">
                                    <textarea id="srContent" placeholder="在此输入评价的内容..."></textarea>
                                </div>
                                <div class="pj_ts">为增加后续服务的满意度，评价需多余10字，请如实评价。</div>
                            </div>
							<!--提交-->
							<div class="confirm_box" style="margin-bottom: 100px;">
								<div class="confirm" onclick="sumbitRemake();">提交</div>
							</div>
                        </c:if>
                        <div class="tissw"><c:if test="${obj.serviceRemark.srContent==null}">暂无评价</c:if></div>
                    </c:if>
			<!-- <div class="border_bottom"></div> -->
		<div class="success">
			<h1>评价成功！</h1>
			<h2>感谢您使用本次服务</h2>
		</div>
		<!--评价成功，弹出分享框-->
		<div class="black"></div>
		<div class="share_box">
			<div class="share_title">分享给好友
				<img src="${webtxc}/wap/images/close_share.png" class="close_share">
				<div class="border_bottom"></div>
			</div>
			<div class="share">
				<img src="${webtxc}/wap/images/weixin3.png">
				<p>微信好友</p>
			</div>
			<div class="share1">
				<img src="${webtxc}/wap/images/friend.png">
				<p style="text-align:left;">朋友圈</p>
			</div>
		</div>
		<%-- <%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%> --%>
		<script>
			//五星评价:服务态度
			var oimg = document.getElementById("oimg");
			$("#oimg img").click(function() { //图片点击时改变图片路径
					$("#oimg img").attr('src', '${webtxc}'+'/images/star.png');
					$(this).nextAll().attr('src', '${webtxc}'+'/images/star_gray.png');
					$("#starnum").text($(this).index()+1+".0");
				})

			//点击提交，显示评价成功
			$(".success").hide();
			/* $(".confirm").click(
					function() {
						$(".success").show();
						$(".confirm_box").remove();
						setTimeout(function() {
							$(".black").show();
							$(".share_box").show();
							$(".share_box").animate({
								bottom: '0'
							}, 200);
						}, 300)
					}

				) */
				//点击提交，显示评价成功:弹出分享
			$(".black").hide();
			$(".share_box").hide();
			$(".close_share").click(function() {
				$(".black").hide();
				$(".share_box").hide();
			})
			//等级变换
            $('.fastComment div').click(function () {
                $(this).removeClass().addClass("fastComment01");
                $(this).siblings().removeClass().addClass("fastComment02")
            })
		</script>
	</body>
</html>
