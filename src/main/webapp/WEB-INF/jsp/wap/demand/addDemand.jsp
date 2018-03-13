<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
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
		<meta name="description" content="近到家，是全国最贴近生活的大众平台，当你遇到任何领域的问题或者是个性化的服务需求，都可以就近找到“对”的人，为你提供帮助，定制服务。达人专家按需约见，在线交流。">
        <meta name="keywords" content="找专家，发布需求，求职，职业规划，咨询，经验，解决问题，一对一，面对面">
    	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    	<%@ include file="/WEB-INF/jsp/common/easyui.jsp" %>
    	<%@ include file="/WEB-INF/jsp/common/kindeditor.jsp" %>
		<link rel="stylesheet" href="${webtxc}/css/wap/reset.css" />
		<link rel="stylesheet" href="${webtxc}/css/wap/personer.css?val=134"/>
		<link rel="stylesheet" href="${webtxc }/css/wap/layer.css" />		
		<script src="${webtxc}/js/wap/reset.js"></script>
		<script src="${webtxc}/js/wap/TouchSlide.js"></script>
		<script src="${webtxc}/js/wap/layer.js"></script>		
		<script type="text/javascript" src="${webtxc }/myjs/wap/demand/addDemand.js?v=8112312312323"></script>
		<script type="text/javascript">
			var flag = '${flag }';
		</script>
		<style>
			.upli{
				text-align: center;
				
				
				margin:0;
				/*line-height: 110px;*/
				position: relative;
				padding: 0!important;
			}
			.upli img{margin-top: 55px;}
			/*.upli:before{
				content: "";
				float: left;
				display: inline-block;
				padding-bottom: 70%;
			}*/
			.upli span{
				line-height: 20px;
				display: block;
				/*position: absolute;
				left: 0px;
				right: 0px;
				top: 61%;*/
			}
		</style>
		<script>
			$(function () {
			    $('.list_mes textarea').each(function () {
					$(this).css({});
                });
//			    $('.list_mes > li:nth-child(2)').css({"line-height": "2"})
                /*$('.upli').each(function () {
                    var li = $(this);
                    li.css({"width": "80%","line-height": "110px;"});
                    li.find('img').get(0).style='vertical-align: middle;text-align: center;display: inline-block;width: 50px;height: 50px;border-radius:0;'
                });*/
            });
			function openAllType(){
				layer.open({
					type: 2,
					  area: ['420px', '240px'], //宽高
					  shadeClose:true,
					  content: path+'/wap/goodsinfo/getAllType.html',
					  anim: 'up',
					  shadeClose: true,
					  shade: 'background-color: rgba(0,0,0,.3)'});
				
				$(".layui-layer").css({
					'z-index': '19891015',
					'overflow': 'scroll',
					'width': '100%',
					'height': '100%',
					'left':'0px',
					'top':'0%'
				});
				$(".layui-layer-content iframe").css({
					'min-height':'700px',
					'max-height':'700px'
				})
			}
		</script>
	</head>

	<body>
		<div class="wappers">
			<div class="personer_top">
				<h3>发布需求</h3>
				<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
			</div>
			
				<div class="personer_mes">
				<ul class="list_mes">
						<li class="demand_title">需求类型</li>					
						<c:if test="${demand.ctName !=null }"><li id="type" onclick="openAllType()" class="add_demends">${demand.ctName}</li></c:if>	
						<c:if test="${demand.ctName ==null }"><li id="type" onclick="openAllType()" class="add_demends">全部类型</li></c:if>
	                        <input  type="hidden" class="typeId" name="demType" value="${demand.demType }" />
					</ul>										
					<ul class="list_mes">
						<li style="display: none;" id="demId">${demand.demId }</li>
						<li class="demand_title">需求名称</li>						
						<li class="add_demends"><input name="demTitle" type="text" placeholder="我需要别人帮我做什么" value="${demand.demTitle }"></li>
					</ul>
					<ul class="list_mes">
						<li class="demand_title">联系人</li>						
						<li class="add_demends"><input name="demContact" type="text" placeholder="请输入联系人姓名" value="${demand.demContact }"></li>
					</ul>
					<ul class="list_mes">
						<li class="demand_title">联系电话</li>						
						<li class="add_demends"><input name="demCell" type="text" placeholder="请输入联系电话" value="${demand.demCell }"></li>
					</ul>
					<!-- <ul class="list_mes">
						<li class="demand_title">关键字</li>						
						<li class="add_demends"><textarea name="demKeyword"  placeholder="请输入需求关键字,并用'，'分隔" ></textarea></li>
					</ul> 
					<script>
						var demKeyword = '${demand.demKeyword }';
						demKeyword = demKeyword.substring(2,demKeyword.length-2);
						$("textarea[name='demKeyword']").html(demKeyword);
					</script>-->
					 
					<%--  <ul class="list_mes">
						<li class="demand_title">需求简介</li>						
						<li class="add_demends"><textarea name="demBrief"  placeholder="请输入需求简介">${demand.demBrief }</textarea></li>
					</ul>  --%>
					<ul class="list_mes text_height">
						<li class="demand_title">需求详情</li>						
						<li class="add_demends "><textarea id="demContent" placeholder="描述一下具体的求助内容，以便及时获得帮助" name="demContent">${demand.demContent }</textarea></li>
					</ul>
					<ul class="list_mes">
                    	<li class="demand_title">封面上传</li>
				        <li class="add_demends upli add_imgs" >
				        	<c:if test="${demand.demImage == null || demand.demImage==''}">
				        		<img src="${webtxc }/images/zp.png" id="image1" />
								<span>上传封面</span>
				        	</c:if>
				            <c:if test="${demand.demImage != null && demand.demImage != ''}">
				            	<img style="width: 100%;border-radius: 0" src="${demand.demImage }" id="image1" />
				            </c:if>
				            
				            <input class="mees" id="info_icon1" name="demImage" type="hidden" value="${demand.demImage }"/>
				        </li>
                	</ul>
					<div class="personer_excit ">
					<c:if test="${demand!=null }"><div class="excit" id="servicesave">保存</div></c:if>
					<c:if test="${demand==null }"><div class="excit" id="servicesave">发布</div></c:if>
				</div>
				
						
	<!-- 弹出层 -->
	<div id="ceng" style="position:absolute;z-index:2;left:0;top:0;right:0;filter:alpha(opacity=50);display:none;width:100%;height:100%;text-align:center;"> 
	</div>
	<div id="close" style="position:absolute !important;left:5%;right:5%;top:40%;z-index:3;border:1px solid #eee;background-color:#fff;padding:0px;display:none;width:90%;text-align:right;padding-bottom:20px">
		<a href="#" onclick="closeCeng()"><img src="${webtxc }/images/guanbi.png" width="20" /></a>
	<div>

	<div class="pictures">
	 <h3>精美配图内容由近到家平台提供</h3>
	 <div class="pictures_img" id="insertPicture">
<%-- 	 <ul>
	 <li><img src="${webtxc}/images/fw_01.jpg" ondblclick="doubleClick()"></li>
	 <li><img src="${webtxc}/images/fw_02.jpg" ></li>
	 <li><img src="${webtxc}/images/fw_03.jpg" ></li>
	 </ul>
	 <ul>
	 <li><img src="${webtxc}/images/fw_01.jpg" ></li>
	 <li><img src="${webtxc}/images/fw_02.jpg" ></li>
	 <li><img src="${webtxc}/images/fw_03.jpg" ></li>
	 </ul> --%>
	 </div>
	</div>

</div>	
				
				
				
				</div><!--end.personer_mes-->
		</div>
		<!--wapper end-->
	<%-- <%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%> --%>
	</body>

</html>