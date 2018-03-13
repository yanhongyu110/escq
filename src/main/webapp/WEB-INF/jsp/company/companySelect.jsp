<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <script src="${webtxc}/js/template-web.js"></script>
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <script>
        var stId = 123123123;
        var isSilde = false;
    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <title>校园服务-招聘-风水-近到家</title>
    <meta name="description" content="近到家服务，为你提供校园、招聘、婚介,风水,二手，家政、教育、科技、房屋、律师、转让等海量分类信息，充分满足您免费查看/发布信息的需求。近到家，就近服务，专业的分类信息服务网">
    <meta name="keywords" content="校园服务,婚介网,风水,二手，招聘,近到家">
    <link href="${webtxc}/css/style.css?val=123" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="${webtxc}/css/content.css?val=1323"/>
    <link rel="shortcut icon" href="${webtxc}/images/favicon.ico"/>
    <link rel="bookmark" href="${webtxc}/images/favicon.ico"/>

    <script src="${webtxc}/citypicker/js/city-picker.data.js"></script>
    <script src="${webtxc}/citypicker/js/city-picker.js?V=123111233232123"></script>
    <link rel="stylesheet" href="${webtxc}/citypicker/css/city-picker.css?v=1231122312123312323">

    <%--<script src="${webtxc}/js/wap/swiper.min.js"></script>--%>
    <%--<link rel="stylesheet" href="${webtxc}/css/wap/swiper.min.css">--%>

    <script src="${webtxc}/vue/vue.min.js"></script>
    <script src="${webtxc}/validator/jquery.form.min.js"></script>
    <%--<script src="${webtxc}/js/slide.js"></script>--%>
    <script type="text/javascript">
        $(document).ready(function () {

            $("#picLsy li").hover(function () {
                $(this).find('.text:not(:animated)').animate({
                    top: "0px"
                }, {
                    easing: "easeInOutExpo"
                }, 50, function () {
                });
            }, function () {
                $(this).find('.text').animate({
                    top: "200px"
                }, {
                    easing: "easeInOutExpo"
                }, 50, function () {
                });
            });

        });
    </script>

    <%--<link rel="stylesheet" href="${webtxc}/css/public.css" />--%>

    <script>

        var searchBody;
        var searchUrl = path + '/company/companyList.html';
        var searchVal = "";
        var gotoUrl = path + '/company/gotoCompany.html';

        function search() {
            searchVal = $('[name=search]').val();
//            if (searchVal == '')return;


            var $form = $('form');

//            var val = $('.select_option .selected').index() ;
//            var flag=0;
//            switch (val) {
//                case 0:
//                    flag='a';
//                    break;
//                case 1:
//                    flag='b';
//                    break;
//                case 2:
//                    flag='c';
//                    $('form').attr('action', path + '/demand/showList.html');
//                    break;
//                case 3:
//                    flag='d';
//                    $('form').attr('action', path + '/company/companyList.html');
//                    break;
//                default:
//                    break;
//            }
//            $('[name=flag]').val(flag);

            $form.submit();


//                $.post(
//                        searchUrl,
//                        {companyName:searchVal,pro:$('#ddd').val()},
//                        function(re){
//                            if (searchBody!=null)searchBody.remove();
//                            searchBody = $(template('test',{list:re}));
//                            searchBody.find("li").each(function(){
//                                $(this).click(function(){
//                                    var attr = $(this).attr('compid');
//                                    window.location.href=gotoUrl+'?companyId='+attr;
//                                })
//                            })
//                            $('[name=search]').after(searchBody)
//                        },
//                        'json'
//                )


        }

        $(function () {

            $('[name=submit]').click(function () {
                search();
            })
            $('[name=search]').blur(function () {
                if (searchBody != null) searchBody._remove();
            }).keyup(function (e) {
                if (e.keyCode == 13) {
                    search();
                }
            })
        })


    </script>


</head>

<body>
<%--<%@include file="/WEB-INF/jsp/common/top.jsp"%>--%>
<div class="page">
    <div class="header-top">
        <div class="header-top-nav">
            <div class="h_logo" style="margin-right: 0px;cursor: pointer" onclick="window.location.href=path+'/company/companyIndex.html'"></div>
            <%-- <a class="nav_homess" href="${webtxc}/company/companyIndex.html">首页</a> --%>
            <div  class="header-nav ">
                <%--<div class="swiper-button-prev" aria-disabled="false" tabindex="0" role="button" aria-label="Previous slide">&nbsp;</div>--%>
                <div class="nav_listt">
                	<c:forEach items="${types1 }" var="type1" >
                    <a  class="swiper-slide new_style"  href="${webtxc }/goodsinfo/ServiceInfo/homeShow.html?module=${type1.ctId}" >${type1.ctName }</a>
                	</c:forEach>
                    <div   class="modulehover"  style="padding: 0px">
                        <div class="o_more">+</div>
                        <div class="modulehover_list" >
                        
                	<c:forEach items="${types2 }" var="type2">
                        <a href="${webtxc }/goodsinfo/ServiceInfo/homeShow.html?module=${type2.ctId}">${type2.ctName }</a>
                	</c:forEach>
                        
                        </div>
                    </div>
                	
                    

                </div>




            </div>
            <%--<a id="more" style="font-size: 20px;line-height: 70px;display: inline-block;font-size: 18px;color: #333;text-decoration: none;cursor: pointer;padding: 0px;text-align: center;width: 60px;height: 70px;">+</a>--%>

            <!--end.header-nav-->

            <div class="h_nav rxdh">
                <div class="h_top">
                    <span class="call"></span>
                    <span class="call_tel">400-833-9068</span>
                   <!--  <a><span class="email"></span> 850564496@qq.com</a> -->
                    <a class="new_style" href="${webtxc}/userinfo/logInfo/jumpLogin.html">登录</a>
                    <a class="new_style" href="${webtxc}/userinfo/logInfo/jumpRegister.html">注册</a>

                </div>

                <%--<div class="n_bottom">--%>
                <%--登录 | 注册--%>
                <%--<a href="server/sq.html">申请为服务商</a>--%>
                <%--</div>--%>

            </div>
            <!--end.header-top-nav-->

        </div>
        <!--end.header-top-seach_z-->

    </div>
    <!--end.header-top-seach-->
</div>
<!--end.header-top-->
<div class="header">
    <div class="jindaoj_zpt">
       <div class="nayouhuo_logo"><img src="${webtxc}/images/zpt_text.png"/></div>
        <div class="search radius6">
            <form name="searchform" method="post" action="${webtxc}/search/view.html">
                <input type="hidden" value="a" name="flag"/>
                <input type="hidden" value="true" name="to"/>
                <input name='ecmsfrom' type='hidden' value='9'>
                <input type="hidden" name="show" value="title,newstext">
                <%--<select name="select" id="select">--%>
                <%--<option value="a">服务</option>--%>
                <%--<option value="b">专家</option>--%>
                <%--<option value="c">需求</option>--%>
                <%--<option value="d">公司</option>--%>
                <%--</select>--%>
                <div style="position: relative;width: 18%;display: inline-block;height: 56px;"><!-- container -->
                    <input name="province" data-province="重庆市" id="ddd" class="inp_srh" readonly type="text" data-toggle="city-picker" placeholder="请选择省/市" data-level="province" style="display: inline-block;line-height:54px;height: 54px;width: 80%;position: absolute">
                </div>
                <%--<div class="select_box">--%>
                <%--<div class="select_showbox" style="cursor: pointer;">找服务</div>--%>
                <%--<ul class="select_option">--%>
                <%--<li class="selected">找服务</li>--%>
                <%--<li>找专家</li>--%>
                <%--<li>找需求</li>--%>
                <%--<li>找公司</li>--%>
                <%--</ul>--%>
                <%--</div>--%>
                <div style="position: relative;width: 60%;display: inline-block">
                    <input style="width: 100%;padding-left: 13px" class="inp_srh" name="search" placeholder="请输入您要搜索的服务">
                </div>
                <input class="btn_srh" type="submit" name="submit" value="搜索" style="cursor: pointer">
            </form>
        </div>
        <%--<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>--%>
        <%--<script type="text/javascript" src="${webtxc}/js/jquery.select.js"></script>--%>
        

    </div>
</div>


<div class="content">
<div class="web-guide">
		<div class="column">
			<div class="guide">
				<div class="guide-item">
					<span class="guide-icon">
						<span class="icon icon-id"><img src="${webtxc}/images/fwrz.png"/></span>
					</span>
					<p>服务商认证</p>
				</div>
				<div class="guide-item">
					<span class="guide-icon">
						<span class="icon icon-talk-empty"><img src="${webtxc}/images/liuy.png"/></span>
					</span>
					<p>在线预约</p>
				</div>
				<div class="guide-item">
					<span class="guide-icon">
						<span class="icon icon-insurance"><img src="${webtxc}/images/jyy.png"/></span>
					</span>
					<p>安全交易</p>
				</div>
				<div class="guide-item">
					<span class="guide-icon">
						<span class="icon icon-insurance"><img src="${webtxc}/images/tuik.png"/></span>
					</span>
					<p>无忧退款</p>
				</div>
			</div>
		</div>
	</div>
    <!-- <div class="service_fabu">


        <ul>
            <li>
                <div class="xuqiu_img"></div>
                <div class="xuqiu_title">
                    <h3>需求发布后</h3>
                    <p>1小时内收到服务商响应</p>
                </div>
            </li>
            <li>
                <div class="xuqiu_img2"></div>
                <div class="xuqiu_title">
                    <h3>每个需求</h3>
                    <p>平均有10个服务商参与</p>
                </div>
            </li>
            <li>
                <div class="xuqiu_img3"></div>
                <div class="xuqiu_title">
                    <h3>95%以上的需求</h3>
                    <p>得到了圆满解决</p>
                </div>
            </li>
            <li>
                <div class="xuqiu_img4"></div>
                <div class="xuqiu_title">
                    <h3>所有需求</h3>
                    <p>平台不收取任何佣金</p>
                </div>
            </li>
        </ul>
    </div> -->
</div>





<div class="provid_zhuanjia">
    <h3><font>专家推荐</font><em>分享爱好，乐趣被几倍放大，你会发现更强的自己</em></h3>
    <div class="school_model">
        <ul>
        <c:forEach items="${providerVos }" var="provider" varStatus="status">
            <c:if test="${status.index lt 10 }">
            <li  style="float: left">
                <div class="view view-tenth">
                    <figure >
                    <c:if test="${not empty provider.prPhoto }">
                    <div class="thumb" style="width: 220px;height: 234px;background-position: center;background-size: cover;background-image: url(${webtxc}${provider.prPhoto })">
                        </div>
                    </c:if>
                    <c:if test="${empty provider.prPhoto }">
                    <div class="thumb" style="width: 220px;height: 234px;background-position: center;background-size: cover;background-image: url(${webtxc}${provider.piPhoto })">
                        </div>
                    </c:if>
                        <div class="mask">
                            <h2>${provider.logName} / ${provider.piPosition}</h2>
                            <p>${provider.prDetails}</p>
                            <a href="${webtxc }/userinfo/providerdetails/preproviderdetails.html?logId=${provider.piLogId}" class="links">查看详情</a>
                        </div>
                    </figure>
                </div>
            </li>
            </c:if>
            </c:forEach>
        </ul>
        <div class="index-btn">
            <a data-received="首页-发现更多专家" class="btn-default btn-hg" href="/search/view.html?flag=b&to=true">发现更多专家</a>
        </div>
    </div>
</div>
<div class="invester-row">
    <h3>31973位会员正在使用近到家</h3>
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/37978EC52E58914ABBE807D43382FE60/100" width="64" height="64" alt="qq   *^_^*" class="img-circle">
   
   
        <img src="http://www.youjiyouli.com/u/70/frontCover/149673092128601.jpg" width="64" height="64" alt="100果农" class="img-circle">
    
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/08CB6AE83C47C471CC7508878E156F9F/100" width="64" height="64" alt="qq爱尚气球创意室" class="img-circle">
    
   
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/9C2A32B6C7C317795707DF107A0B64FE/100" width="64" height="64" alt="qq秦瑟" class="img-circle">
    
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/90B461FDC657F6652D3D466F73F4982A/100" width="64" height="64" alt="qqJasmine" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/A4EAA0A54822329E237470E7D9B40291/100" width="64" height="64" alt="qq王刚" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/21533F788A26068EB0B2CAB386E5099D/100" width="64" height="64" alt="Eureka" class="img-circle">
    
        <img src="http://tvax3.sinaimg.cn/crop.0.0.996.996.180/006hBK1Bly8ffn87o0wwoj30ro0rpgn0.jpg" width="64" height="64" alt="weibo哎呀iye呀" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/CA10AA0942BB44B1CD8F19BE70A9C759/100" width="64" height="64" alt="qq大鹏展翅" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/FA63A46D4FA904AB6522F5BF07E60BF1/100" width="64" height="64" alt="qq我不是我" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/9D4B70E126EFAB8D0AC1BC3DDC47B808/100" width="64" height="64" alt="上官寒语" class="img-circle">
   
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/284CD9D35CB673DA476D9C09AD1CEA54/100" width="64" height="64" alt="qq耗子" class="img-circle">
   
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/0175132670E0F1252D6A757E9C6ABAC5/100" width="64" height="64" alt="qq行者吴伟" class="img-circle">
   
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/E837EE16443BF4DF5927625BA6BCAB4B/100" width="64" height="64" alt="qq冰海若蓝" class="img-circle">
   
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/AD740985BD94D242B87E935F569F81B4/100" width="64" height="64" alt="qq山峰" class="img-circle">
   
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/EE8E151730F7B25961E15924E0ECDD54/100" width="64" height="64" alt="qq耿大雷" class="img-circle">
    
        
   
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/133B76232C2793E83295C2C86F56D70B/100" width="64" height="64" alt="qq尘?" class="img-circle">
   
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/67FE6D9CBD867879AA81B60E4AF31B6C/100" width="64" height="64" alt="qq◡̈  凸逼男啵万" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/147023A8E9BD1A5B8EED0612EF1BA66E/100" width="64" height="64" alt="qq板栗/dy" class="img-circle">
   
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/E90A3F4527A339B5ED27B16814F44022/100" width="64" height="64" alt="qq知足常乐" class="img-circle">
   
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/0C804A1182AFD40FE01E6928933CBB76/100" width="64" height="64" alt="qqBill Pang" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/905D9AF8AF4D9B133DD3211D37E7C76A/100" width="64" height="64" alt="qq张应蓝莓" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/173269372358C95FBCBC668B1C85F999/100" width="64" height="64" alt="qq未奇" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/D4B0BF04F710EFF0F792DB414E95F136/100" width="64" height="64" alt="qq小汪" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/6167105FFD1AEF0D5B9E2AD253E45D97/100" width="64" height="64" alt="qq桐木关茶农" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/D88E3D491972E0266CCEC06AF194E029/100" width="64" height="64" alt="qq倾听丶所谓旳幸福%" class="img-circle">
    
        <img src="http://tva4.sinaimg.cn/crop.0.0.800.800.180/006z7XJljw8f8g7gg391jj30m80m8wl0.jpg" width="64" height="64" alt="weibo宝宇雪猪" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/8633F944842BB65EBC291D8AE30A1764/100" width="64" height="64" alt="Patrick" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/BF52D037F79E89BFCD121684A8006351/100" width="64" height="64" alt="qq533?" class="img-circle">
    
        <img src="http://www.youjiyouli.com/u/21/frontCover/149265431431878.png" width="64" height="64" alt="Micxy＇茶农小陈" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/BC094599494A17AFFFCD646B85036123/100" width="64" height="64" alt="qq正青春" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/D8EBF4DB313BF9B6234B6C790630823F/100" width="64" height="64" alt="qqせっしょうまる" class="img-circle">
   
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/4CE0A25671D68005C2F4782C09E6416B/100" width="64" height="64" alt="北京通州开心农场" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/D492A146F293FBB11B46B32FA0A90275/100" width="64" height="64" alt="qq     Amour-゜朝思" class="img-circle">
    
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/1BC847B1CC72257E696BE0A95F0CD73F/100" width="64" height="64" alt="qq眼成海.却未蓝" class="img-circle">
   
        <img src="http://qzapp.qlogo.cn/qzapp/101142329/2EEC770095E59CDC1A8C990FD758D4E5/100" width="64" height="64" alt="qq友间" class="img-circle">
    
        <img src="http://www.youjiyouli.com/u/10/frontCover/149130095043497.jpg" width="64" height="64" alt="蜜语蜂蜜" class="img-circle">
    
        <img src="http://tvax4.sinaimg.cn/default/images/default_avatar_male_180.gif" width="64" height="64" alt="，ccz123456789" class="img-circle">
   
    <div class="clear"></div>
</div>
<div class="ewm">
    <div class="ewm_zz">
        <div class="ewm_img">
        <%-- <img style="width: 100px;height: 100px;" src="${webtxc}/images/appapk.png"/> --%>
        <div class="download-btn-group">
			
			<a class="download-btn" href="https://itunes.apple.com/cn/app/%E8%BF%91%E5%88%B0%E5%AE%B6/id1240730322?mt=8" data-received="点击ios下载按钮" data-market="客户端下载页;下载客户端;iPhone版">
				<span class="app-ios-icon"></span>
				<span class="download-btn-text">下载iPhone版</span>
			</a>
			
			<a class="download-btn" href="http://www.jindaoj.com/wap/goodsinfo/home/toDownload.do" data-analyze="Download:done:zaihapp android download from pc" data-received="点击安卓下载按钮" data-market="客户端下载页;下载客户端;Android版">
				<span class="app-android-icon"></span>
				<span class="download-btn-text">下载Android版</span>
			</a>
		</div>
        </div>
       
    </div>
</div>
<!--end.ewm-->


<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>


</body>

</html>