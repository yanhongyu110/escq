<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>

<html> 

	<head>
		<meta charset="UTF-8">
		<title>关于我们</title>
		<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/ty.css" />
		
		<script type="text/javascript">
			$(function(){
				$('li').click(function(){
					$(this).addClass('targeted').siblings().removeClass('targeted');
				});
			});
		</script>
	</head>

	<body>
			<%@include file="/WEB-INF/jsp/common/top.jsp"%>
			
			<div class="content">
			<div class="bannerResource"></div>
			<div class="content_about">

				<section class="demo">
					<div class="admin-panel clearfix">
						<div class="slidebar">
							<div class="logo">
								<a href=""></a>
							</div>
							<div class="fond_zj">
								<h2>关于近到家</h2>
								<h4>ABOUT US</h4>
							</div>
							<ul>
								<li class="targeted">
									<a href="#dashboard">关于我们</a>
								</li>
								<li>
									<a href="#posts">常见问题</a>
								</li>
								<li>
									<a href="#media">服务条款</a>
								</li>
								<li>
									<a href="#zhinan">操作指南</a>
								</li>
								<li>
									<a href="#panner">合作伙伴</a>
								</li>
								<li>
									<a href="#contact">联系我们</a>
								</li>

							</ul>
						</div><!--end.slidebar-->
						<div class="slidebar_right">
							<div class="mainContent clearfix">
								<div id="dashboard">
									<h2>关于我们 </h2>
									<p>上海爱福窝云技术有限公司（简称：爱福窝），创立于2013年1月，总部位于中国上海，是国内领先的家装云设计软件服务商，致力于家装3D云技术的开发，以在线装修设计产品服务为向导，打造国内领先的家居行业的O2O服务平台，2015年，获得6250万A轮融资。爱福窝获得中国最佳创新公司50强，迄今为止，凭借自身强大的技术研发能力，对整个家装行业进行深度融合，在为客户带来更好家装体验的同时，又积极推动整个家居行业“互联网+”的发展。 爱福窝家装平台（www.fuwo.com）是中国最专业的家居网站之一，公司秉承“以诚为本，送福至家”的经营理念，致力为广大业主打造一个开放、互动、共享、公平、公正、公开的在线家装平台。目前平台的日访问量突破100万，访问人数和页面访问量在国内家居行业网站中位居前列。 爱福窝云设计是公司倾力打造一款SaaS（Software-as-a-Service）家装设计和导购软件，用户可以在云软件中快速完成户型改造、自行设计新家，8秒生成高清效果图，30秒出360°全景图，5分钟生成装修方案和清单。爱福窝拥有全国50万小区的超过200万套3D户型数据，用户只需输入楼盘小区名称，即可立即获得自己需要的户型图，软件还支持海量风格样板间一键匹配，真正做到让人人都可以当室内设计师！
									</p>

								</div><!--end#dashboard-->
								<div id="posts">
									<h2>常见问题 </h2>

								</div><!--end#posts-->
								<div id="media">
									
										<div class="terms-center-text">
											<div class="exemption-clause ">免责声明</div>
											<p>1、本网站提供的模型、效果图及实景照片仅供学习交流，未经许可，请勿用于商业用途。浏览者依据本网站提供的信息、资料及图片进行评论及所发表文章持有的观点与本网站无关。参阅本网站上所发信息的人士，应被视为已认同上述立场。</p><br>
											<p>2、本网站部份文章、图片等信息为网络上转载，转载出于传递更多信息之目的，并不意味着赞同其观点或证实其内容的真实性。如对稿件内容有疑议或转载稿涉及版权等问题，请相关方及时与我们联系，我们将第一时间予以更改或删除（邮箱：service@fuwo.com），若有涉及版权费等问题，请及时提供相关证明等材料并与我们联系，通过友好协商公平公正原则处理纠纷。本网站已尽力确保所提供信息的真实性和准确性，但并不对使用本网站信息所造成的任何后果负责。</p><br>
											<p>3、本站部分言论由网友自由上传，对于此类言论本站仅提供交流平台，不为其言论负责。禁止一切违反现行政策法规的文章、图片等信息，一经发现将立即删除，并将相关数据提交给上级管理机关。因投稿人盗用他人信息或作品内容、文章而引发的侵权行为与本网站无关，一切法律责任均由投稿者承担。上传的作品内容本网站有修改、删除、转发等权利，转发将会注明投稿者的用户名，保留投稿人的作品权。</p><br>
											<p>4、对由于使用本网站所产生的任何直接、间接或偶然性的损失或破坏，本网站不承担任何责任，无论该损失或破坏是否源于疏忽、违约、诽谤、侵权甚至电脑病毒。</p><br>
											<p>5、当政府司法机关依照法定程序要求本网站披露个人资料时，我们将根据执法单位之要求或为公共安全之目的提供个人资料。在此情况下之任何披露，本网站均得免责。</p><br>
											<p>6、由于用户将个人密码告知他人或与他人共享注册帐户，由此导致的任何个人资料泄露，本网站不负任何责任。</p><br>
											<p>7、任何由于黑客攻击、计算机病毒侵入或发作、因政府管制而造成的暂时性关闭等影响网络正常经营的不可抗力而造成的个人资料泄露、丢失、被盗用或被窜改等，本网站均得免责。</p><br>
											<p>8、本网站如因系统维护或升级而需暂停服务时，将不事先公告。若因线路及非本站控制范围外的硬件故障或其它不可抗力而导致暂停服务，于暂停服务期间造成的一切不便与损失，本网站不负任何责任。</p><br>
											<p>9、凡以任何方式登录本网站或直接、间接使用本网站资料者，视为自愿接受本网站声明的约束。</p><br>
											<p>10、本网站之声明以及其修改权、更新权及最终解释权归上海爱福窝云技术有限公司所有。如有本声明未涉及的问题参见国家有关法律法规，当本声明与国家法律法规冲突时，以国家法律法规为准。</p><br> <strong class="exemption-clause ">用户协议</strong>
											<p>欢迎您注册成为爱福窝会员！ 请仔细阅读下面的协议，只有接受协议才能继续进行注册。</p><br>
											
										</div><!--end.terms-center-text-->
									

								</div><!--end#media-->
								<div id="zhinan">
									操作指南

								</div><!--end#zhinan-->
								<div id="panner">
									合作伙伴

								</div>
								<div id="contact">
									联系我们

								</div>

							</div><!--end.mainContent-->
						</div><!--end.slidebar_right-->
				</section>
				</div>
				<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>
				</div>
	</body>

</html>