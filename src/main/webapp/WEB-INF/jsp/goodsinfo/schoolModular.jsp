<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>首页</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<link rel="stylesheet" href="${webtxc}/css/common.css" />
<link rel="stylesheet" href="${webtxc}/css/schoolStyle.css?val=413" />
<script>
    var siList =${siList};
</script>
<script type="text/javascript" src="${webtxc}/js/schoolSlide.js"></script>
<script type="text/javascript" src="${webtxc}/myjs/goodsinfo/schoolModule.js"></script>
<script src="${webtxc}/vue/vue.min.js"></script>
</head>
<body>
<c:if test="${empty sessionScope.logInfo}">
    <div id="dialogBg"></div>
    <div id="dialog" class="animated">
        <div class="dialogTop">
            <a href="javascript:;" class="claseDialogBtn"><img
                    src="${webtxc}/images/wrong.jpg"></a>
        </div>
        <div class="lanrenzhijia">
            <div class="title cf">
                <ul class="title-list fr cf ">
                    <li id="li2" class="on">登录</li>
                    <li id="li1">注册</li>
                    <p>
                        <b></b>
                    </p>
                </ul>
            </div>
            <div class="product-wrap">
                <!--案例1-->
                <div class="product show">
                    <input type="text" placeholder="请用手机号、邮箱或者昵称登录"
                           class="login_btn cellPhone"/> <input type="password"
                                                                class="login_btn logPassWord" placeholder="至少输入8个字符"/> <input
                        type="checkbox" class="zd checkLog">自动登录 <a
                        class="forget_password"
                        href="${webtxc}/userinfo/logInfo/jumpForgetPass.html?comId=${sessionScope.company.compId}">忘记密码？</a> <input
                        type="button" class="dl_btn" onclick="logUser()" value="登录"/>
                    <div class="p_bttom">

                        <!-- <div class="dl_qt">
                            <a class="dl_fs">使用第三方帐号登录</a> <a class="qq_dl"></a> <a
                                class="wx_dl"></a>
                        </div> -->
                    </div>
                </div>
                <!--案例2-->
                <div class="product">
                    <input type="text" placeholder="请输入正确的手机号"
                           class="login_btn registerCell"/> <input type="text"
                                                                   id="checkCode" style="margin-right: 0px" placeholder="验证码"
                                                                   class="login_yz registerCode"/> <input type="button"
                                                                                                          style="height: 42px; margin-left: 0px" onclick="buttonregister()"
                                                                                                          value="获取验证码" class="login_yzm registerButton"/> <input
                        type="password" placeholder="8-20位密码，区分大小写，不能为空格"
                        class="login_btn registerPass"/>
                    <div class="agrees_zc">

                        <label><input type="checkbox" id="cb">我已阅读并同意</label><a href="${webtxc}/goodsinfo/home/agreement.html?comId=${sessionScope.company.compId}">《近到家互联网专家平台服务协议》</a>
                    </div>
                    <!--end.agrees-->
                    <input type="button" style="background: #999; border: #999"
                           class="dl_btn registerBtn" id="registerBtn" value="注册"/>
                </div>

            </div>
            <!--end.product-wrap-->
        </div>
    </div>
    <div id="dialogBg"></div>
</c:if>
<div class="xy_header_nav">
			<ul class="orz_app1">
				<li class="logo_jdj"><img src="${webtxc}/images/jdj_logo.png" height="50" alt=""></li>
				<li class="nav_hover thenav">首页</li>
				<li class="thenav" style="cursor: pointer;" v-for="( it,index ) in list"  v-text="it.ctName" v-on:click="go(it.ctId)"></li>
				<!-- <li>跑腿</li>
				<li>电竞</li>
				<li>转让</li>
				<li>模特</li>
				<li>创业</li> -->
	<c:if test="${empty sessionScope.logInfo}">			
				<li id="regidest" class="school_login_btn bounceInDown" style="width: 44px;cursor: pointer;">注册</li>
				<li id="log" class="school_login_btn bounceInDown" style="width: 44px;cursor: pointer;">登录</li>
	</c:if>	
		<c:if test="${!empty sessionScope.logInfo}">	
				<div class="global-nav-right">
                <div class="dropdown ">
                    <a href="#" style="height: 30px;float: left;position: relative;z-index: 10;color: #FB5A5A;" class="dropdown-main"><span style="margin-top: 8px;">${logInfo.logName}</span>
                        <i class="allow_down"></i> </a>
                    <div class="dropdown-sub" style="display: none;">
                        <div class="dropdown-sub_box">
                            <div class="dropdown_mes">
                                <div class="dropdown_mes_left">
                                    <a href="${webtxc}/userinfo/jumpmodifyUserInfo.html"><img src="${logInfo.userPhoto}"></a>
                                </div>
                                <div class="dropdown_mes_right">
                                    <h3>${logInfo.logName}</h3>
                                    <!-- <a>等级(0)</a> <a>积分(0)分</a> -->
                                    <h3>余额：${logInfo.accBalance}</h3>
                                    <div class="service_rz">
                                        <c:if test="${empty sessionScope.logInfo.userRealname}"><a class="service_nojp"></a><span>暂未实名认证</span></c:if>
                                        <c:if test="${not empty sessionScope.logInfo.userRealname}"><a class="service_jp"></a><span>已实名认证</span></c:if>
                                        <c:if test="${logInfo.logType==1}"> <a class="service_noqy"></a><span>暂未进行服务商认证</span></c:if>
                                        <c:if test="${logInfo.logType==2}"> <a class="service_qy"></a><span>已完成服务商认证</span></c:if>
                                    </div>
                                </div>
                            </div>
                            <div style="margin-left: 15px;" class="dropdown_mes_list">
                                <ul>
                                    <a class="sz"
                                       href="${webtxc}/userinfo/jumpmodifyUserInfo.html"
                                    >
                                        <li style="font-size: 10px;">个人设置</li>
                                    </a>
                                    <a class="sc" href="${webtxc}/goodsinfo/cart/viewCart.html"
                                    >
                                        <li style="font-size: 10px;">我的心愿</li>
                                    </a>
                                </ul>
                                <ul>
                                    <a class="zh"
                                       href="${webtxc}/details/AccountPaymentDetails/showIODetails.html"
                                    >
                                        <li style="font-size: 10px;">我的账户</li>
                                    </a>
                                    <a class="xx"
                                       href="${webtxc}/userinfo/queryAllSystemMes.html?smType=1"
                                    >
                                        <li style="font-size: 10px;">我的消息</li>
                                    </a>
                                </ul>
                                <div class="height_h"></div>
                                <div style="background-color: #e05931" class="tc" id="logout">安全退出</div>
                            </div>
                        </div>
                    </div>

                </div>
                </c:if>
			</ul>
		</div>

		<div class="banner">
			<ul></ul>
			<ol></ol>
			<i class="left"></i><i class="right"></i>
		</div>
		<div class="school_sou">
			<div class="school_sou_z">
				<div class="search radius6">
						<input name='ecmsfrom' type='hidden' value='9'>
						<input type="hidden" name="show" value="title,newstext">
						<select class="orz_app0" name="classid" id="choose">
							<option value="">搜索全部</option>
							<option v-bind:value="it.ctId" v-for="( it,index ) in list" v-text="it.ctName"></option>
						</select>
						<input id="searchText" class="inp_srh" name="keyboard" placeholder="请输入您要搜索的服务/专家">
						<input class="btn_srh sub" type="submit" name="submit" value="搜索">
				</div>
				<script type="text/javascript">
				$.ajax({
		            async: false,
			        type: 'post',
			        dataType: 'json',
			        data: {type: 5,
			        	id:17070414520001
			        },
			        url: path + '/pubinfo/getTree.html',
			        success: function (data) {
			            var typeList = data;
			            var app = new Vue({
			                el: '.orz_app0',
			                data: {list: typeList}
			            })
	
			            var app2 = new Vue({
			                el: '.orz_app1',
			                data: {list: typeList},
			                methods: {
			                    go: function (input) {
			                    	var flag = 'a';
			                    	jQuery('<form action="' + path + '/search/view.html"  method="post">'
			                                + '<input type="hidden" name="flag" value="' + flag + '" />'
			                                + '<input type="hidden" name="type" value="' + input + '" />'
			                                + '</form>').appendTo('body').submit().remove();
			                    }
			                }
			            })
	
	
	
			        }
		   		 })
				</script>
				<script type="text/javascript" src="${webtxc}/js/jquery.select.js"></script>
				<div class="school_rx"><img src="${webtxc}/images/rxx.png" alt=""></div>
			</div>
		</div>
		<%-- <div class="content01_school">
			<div class="school_content_jiaoyou">
				<h3><font>校园热门</font><em>分享爱好，乐趣被几倍放大，你会发现更强的自己</em></h3>
				<div class="hot_school_leix">
					<ul class="picL" id="picLsy">
						<li>
							<a href="#"><img src="${webtxc}/images/jiaoyou.jpg" alt=""></a>
							<div class="text">
								<b>交友</b>
								<p>
									<a href="#">和你心中的男神女神在一起...</a>
								</p>
							</div>
						</li>
						<li>
							<a href="#"><img src="${webtxc}/images/paotui.jpg" alt=""></a>
							<div class="text">
								<b>跑腿</b>
								<p>
									<a href="#">如果能有一个人为你送上美味的零食午餐，帮你买上期待已久的电影票……</a>
								</p>
							</div>
						</li>
						<li>
							<a href="#"><img src="${webtxc}/images/jianzhi.jpg" alt=""></a>
							<div class="text">
								<b>转让</b>
								<p>
									<a href="#">节能环保，让资源继续延续下去..</a>
								</p>
							</div>
						</li>
						<li>
							<a href="#"><img src="${webtxc}/images/002.jpg" alt=""></a>
							<div class="text">
								<b>电竞</b>
								<p>
									<a href="#">既不耽误学习，又可以和女神游戏</a>
								</p>
							</div>
						</li>
						<li>
							<a href="#"><img src="${webtxc}/images/jiaojiao.jpg" alt=""></a>
							<div class="text">
								<b>模特</b>
								<p>
									<a href="#">施展你的才华，赚取回报。</a>
								</p>
							</div>
						</li>
						<li>
							<a href="#"><img src="${webtxc}/images/paotui.jpg" alt=""></a>
							<div class="text">
								<b>创业</b>
								<p>
									<a href="#">校园创业，提前体验生活。</a>
								</p>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div> --%>
		<div class="school_neibaner">时尚、摄影、搭配、宠物、植物、彩妆、插画——关注达人，也许就会遇见另一个自己。</div>
		<div class="school_content_jiaoyou">
			<h3><font>模特</font><em>分享爱好，乐趣被几倍放大，你会发现更强的自己</em><span style="cursor: pointer;" onclick="location.href='${webtxc}/search/view.html?type=${map.serList1[0].serviceType}&flag=a'">发现更多精彩>></span></h3>
			<div class="school_001_content">
				<div class="school_001_content_left">
					<img src="${webtxc}/images/004.jpg" alt="" />
				</div>
				<div class="school_model">
					<ul>
					<c:forEach items="${map.serList1}" var="it">
						<li>
							<div class="view view-tenth">
								<figure>
									<div class="thumb"><img  src="${it.servicePic}" alt="" /></div>
									<div class="mask">
										<h2>${it.serviceTitle}</h2>
										<p>${fn:substring(it.serviceBiref,0,30)}</p>
										<a href="${webtxc}/goodsinfo/service/queryServiceDetails.html?serviceId=${it.serviceId}&priceType=1" class="link">查看全文</a>
									</div>
								</figure>
							</div>
						</li>
					</c:forEach>
						<%-- <li>
							<div class="view view-tenth">
								<figure>
									<div class="thumb"><img src="${webtxc}/images/m_02.jpg" alt="" /></div>
									<div class="mask">
										<h2>Wonder Girls</h2>
										<p>Wonder Girls一向以青春活力的形象展现在观众面前，先后在韩国和...</p>
										<a href="#" class="link">查看全文</a>
									</div>
								</figure>
							</div>
						</li>
						<li>
							<div class="view view-tenth">
								<figure>
									<div class="thumb"><img src="${webtxc}/images/m_03.jpg" alt="" /></div>
									<div class="mask">
										<h2>Wonder Girls</h2>
										<p>Wonder Girls一向以青春活力的形象展现在观众面前，先后在韩国和...</p>
										<a href="#" class="link">查看全文</a>
									</div>
								</figure>
							</div>
						</li> --%>
					</ul>
				</div>
			</div>
		</div>
		<div class="school_content_jiaoyou">
			<h3><font>交友</font><em>分享爱好，乐趣被几倍放大，你会发现更强的自己</em><span style="cursor: pointer;" onclick="location.href='${webtxc}/search/view.html?type=${map.serList2[0].serviceType}&flag=a'">发现更多精彩>></span></h3>
			<div class="school_001_content">
				<div class="school_001_content_left">
					<img src="${webtxc}/images/003.jpg" alt="" />
				</div>
				<div class="school_001_content_right">
					<ul>
					<c:forEach items="${map.serList2}" var="it">
						<li>
							<div class="jy_img">
								<img src="${it.servicePic}" style="width: 120px;height: 151px;" alt="" />
							</div>
							<div class="jy_title">
								<h4>${it.serviceTitle}</h4>
								<p>${fn:substring(it.serviceBiref,0,30)}<a href="${webtxc}/goodsinfo/service/queryServiceDetails.html?serviceId=${it.serviceId}&priceType=1">查看详细>></a></p>
							</div>
						</li>
					</c:forEach>
						<%-- <li>
							<div class="jy_img">
								<img src="${webtxc}/images/expert02.jpg" width="120" alt="" />
							</div>
							<div class="jy_title">
								<h4>李俊基/重庆工商大学</h4>
								<span>24岁</span>
								<p>我喜翻的欧巴我喜翻的欧巴我喜翻的欧巴...<a>查看详细>></a></p>
								<span><font>20</font>人关注</span>
							</div>
						</li> --%>

					</ul>
					<%-- <ul>
						<li>
							<div class="jy_img">
								<img src="${webtxc}/images/expert04.jpg" width="120" alt="" />
							</div>
							<div class="jy_title">
								<h4>王迅/重庆工商大学</h4>
								<span>24岁</span>
								<p>我喜翻的欧巴我喜翻的欧巴我喜翻的欧巴...<a>查看详细>></a></p>
								<span><font>20</font>人关注</span>
							</div>
						</li>
						<li>
							<div class="jy_img">
								<img src="${webtxc}/images/expert03.jpg" width="120" alt="" />
							</div>
							<div class="jy_title">
								<h4>芝兰/重庆工商大学</h4>
								<span>24岁</span>
								<p>我喜翻的欧巴我喜翻的欧巴我喜翻的欧巴...<a>查看详细>></a></p>
								<span><font>20</font>人关注</span>
							</div>
						</li>

					</ul> --%>
				</div>
			</div>
		</div>

		<div class="school_content_jiaoyou">
			<h3><font>跑腿</font><em>如果能有一个人为你送上美味的零食午餐，帮你买上期待已久的电影票……</em><span style="cursor: pointer;" onclick="location.href='${webtxc}/search/view.html?type=${map.serList3[0][0].serviceType}&flag=a'">发现更多精彩>></span></h3>
			<div class="school_001_content">
				<div class="school_001_content_left">
					<img src="${webtxc}/images/005.jpg" alt="" />
				</div>
				<div class="school_paotui">
					<ul>
						<li style="width:250px;">
							<img src="${webtxc}/images/sq.jpg" alt="">
							<c:forEach items="${map.serList3[0]}" var="it">
								<p style="cursor: pointer;" onclick="location.href='${webtxc}/goodsinfo/service/queryServiceDetails.html?serviceId=${it.serviceId}&priceType=1'">${it.serviceTitle}</p>
							</c:forEach>
						</li>
						<li style="width:250px;">
							<img src="${webtxc}/images/dm.jpg" alt="">
							<c:forEach items="${map.serList3[1]}" var="it">
								<p style="cursor: pointer;" onclick="location.href='${webtxc}/goodsinfo/service/queryServiceDetails.html?serviceId=${it.serviceId}&priceType=1'">${it.serviceTitle}</p>
							</c:forEach>
						</li>
						<li style="width:250px;">
							<img src="${webtxc}/images/db.jpg" alt="">
							<c:forEach items="${map.serList3[2]}" var="it">
								<p style="cursor: pointer;" onclick="location.href='${webtxc}/goodsinfo/service/queryServiceDetails.html?serviceId=${it.serviceId}&priceType=1'">${it.serviceTitle}</p>
							</c:forEach>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="school_content_jiaoyou">
			<h3><font>转让</font><em>节能环保，让资源继续延续下去..</em><span style="cursor: pointer;" onclick="location.href='${webtxc}/search/view.html?type=${map.serList4[0].serviceType}&flag=a'">发现更多精彩>></span></h3>
			<div class="school_001_content">
				<div class="school_001_content_left">
					<img src="${webtxc}/images/004.jpg" alt="" />
				</div>
				<div class="school_zhuanrang">
					<ul>
					<c:forEach items="${map.serList4}" var="it">
						<li>
							<img style="width: 250px;height: 120px;" src="${it.servicePic}" alt="" onclick="location.href='${webtxc}/goodsinfo/service/queryServiceDetails.html?serviceId=${it.serviceId}&priceType=1'">
							<p>${it.serviceTitle}</p>
							<p>${fn:substring(it.serviceBiref,0,30)}</p>

						</li>
					</c:forEach>
						<%-- <li>
							<img src="${webtxc}/images/jiaoyou.jpg" alt="">
							<p>标题的内容，包括描述</p>
							<p><span>重庆西南大学</span><span>20人关注</span></p>

						</li>
						<li>
							<img src="${webtxc}/images/paotui.jpg" alt="">
							<p>标题的内容，包括描述</p>
							<p><span>重庆西南大学</span><span>20人关注</span></p>

						</li>

					</ul>
					<ul>
						<li>
							<img src="${webtxc}/images/jiaojiao.jpg" alt="">
							<p>标题的内容，包括描述</p>
							<p><span>重庆西南大学</span><span>20人关注</span></p>

						</li>
						<li>
							<img src="${webtxc}/images/002.jpg" alt="">
							<p>标题的内容，包括描述</p>
							<p><span>重庆西南大学</span><span>20人关注</span></p>

						</li>
						<li>
							<img src="${webtxc}/images/002.jpg" alt="">
							<p>标题的内容，包括描述</p>
							<p><span>重庆西南大学</span><span>20人关注</span></p>

						</li>

					</ul> --%>
				</div>
			</div>
		</div>
		<div style="margin-bottom: 35px;" class="school_content_jiaoyou">
			<h3><font>电竞</font><em>能与女神一起玩电竞，那是多么美好的事情...</em><span style="cursor: pointer;" onclick="location.href='${webtxc}/search/view.html?type=${map.serList5[0].serviceType}&flag=a'">发现更多精彩>></span></h3>
			<div class="school_001_content">
				<div class="school_001_content_left">
					<img src="${webtxc}/images/006.jpg" alt="" />
				</div>
				<div class="school_dianjing">
					<ul>
					<c:forEach items="${map.serList5}" var="it">
						<li>
							<div class="jy_img">
								<img src="${it.servicePic}" style="width: 120px;height: 151px;" alt="" />
							</div>
							<div class="jy_title">
								<p>
									<font>${it.serviceTitle}</font>
								</p>
								<p>${fn:substring(it.serviceBiref,0,30)}
									<a href="${webtxc}/goodsinfo/service/queryServiceDetails.html?serviceId=${it.serviceId}&priceType=1">查看详细>></a>
								</p>
							</div>
						</li>
					</c:forEach>
						<%-- <li>
							<div class="jy_img">
								<img src="${webtxc}/images/expert02.jpg" width="120" alt="" />
							</div>
							<div class="jy_title">
								<p>
									<font>何静/魔兽传奇大师级别</font>
								</p>
								<p> 聪荟教育科技公司联合创始人，咨询师...
									<a>查看详细>></a>
								</p>
								<p><span>20人关注</span></p>
							</div>
						</li>

					</ul>
					<ul>
						<li>
							<div class="jy_img">
								<img src="${webtxc}/images/expert04.jpg" width="120" alt="" />
							</div>
							<div class="jy_title">
								<p>
									<font>何静/魔兽传奇大师级别</font>
								</p>
								<p> 聪荟教育科技公司联合创始人，咨询师...
									<a>查看详细>></a>
								</p>
								<p><span>20人关注</span></p>
							</div>
						</li>
						<li>
							<div class="jy_img">
								<img src="${webtxc}/images/expert03.jpg" width="120" alt="" />
							</div>
							<div class="jy_title">
								<p>
									<font>何静/魔兽传奇大师级别</font>
								</p>
								<p> 聪荟教育科技公司联合创始人，咨询师...
									<a>查看详细>></a>
								</p>
								<p><span>20人关注</span></p>
							</div>
						</li>

					</ul> --%>
				</div>
			</div>
		</div>
		<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>

		<script type="text/javascript" src="${webtxc}/js/jquery.easing.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {

				$("#picLsy li").hover(function() {
					$(this).find('.text:not(:animated)').animate({
						top: "0px"
					}, {
						easing: "easeInOutExpo"
					}, 50, function() {});
				}, function() {
					$(this).find('.text').animate({
						top: "200px"
					}, {
						easing: "easeInOutExpo"
					}, 50, function() {});
				});

			});
		</script>
	</body>
</html>