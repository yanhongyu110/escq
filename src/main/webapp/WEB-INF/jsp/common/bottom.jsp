<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!--end.content-->


<c:if test="${1!=1}">
	<div class="footer">
		<div class="footer_top">
			<div class="footer_logo">
				<div style="width: 119px;height: 60px;background-image: url('${sessionScope.company.compLog}');background-size: cover"></div>
				<h2>${sessionScope.company.compBrier}</h2>
			</div>
			<div class="footer_contact">
				<p>
					咨询电话：

						${sessionScope.company.compViewcell}
						<%--０２３－４５６７７７--%>
					<br>
					邮箱：${sessionScope.company.compViewemail}
					<br>
					邮编：${sessionScope.company.compViewzip}
					<br>
					地址：${sessionScope.company.compViewaddr}
				</p>
				
			</div>
			<div class="footer_ewm">

				<div style="float: right;margin-top:20px;width: 111px;height: 111px;background-image: url('${sessionScope.company.compViewqr}');background-size: cover"></div>
				 
					<%--<img src="${webtxc}/images/ewm.jpg" align="right" />--%>
			</div>
		</div>
	</div>
	<div class="footer_bottom">
		<div class="footer_bottom_about">
			<ul>
				<li><span onclick="window.location.href='${webtxc}/goodsinfo/ServiceInfo/homeShow.html'+'?comId='+g_comid">首页 </span> | <span>App下载 </span> | <span>关于我们  </span> | <span onclick="window.location.href='${webtxc}/goodsinfo/home/direct.html?stId=311'">操作指南</span></li>
				<li class="dz">重庆捷路科技有限公司 Copyright © 2015 ECJia(ecjia.com)
					版权所有，并保留所有权利。</li>
			</ul>
		</div>
	</div>
	</div>
</c:if>
<c:if test="${1==1}">
	<div class="footer">
		<div class="footer_top">
			<div class="footer_logo">
				<div style="width: 119px;height: 60px;background-image: url('/images/20170527143623_609.png');background-size: cover"></div>
				<h2>近到家，领先的知识技能共享平台</h2>
			</div>
			<div class="footer_contact">
				<p>
					咨询电话：

					023-68883908
						<%--０２３－４５６７７７--%>
					<br>
					邮箱：v-jero@jero.168.com
					<br>
					邮编：400000
					<br>
					地址：重庆市北部新区水星科技大厦南翼B1区厂房4楼7-10
				</p>
			</div>
			<div class="footer_ewm">

				<div style="float: right;margin-top: 40px;width: 111px;height: 111px;background-image: url('/images/appapk.png');background-size: cover"></div>
					<%--<img src="${webtxc}/images/ewm.jpg" align="right" />--%>
			</div>
		</div>
	</div>
	<div class="footer_bottom">
		<div class="footer_bottom_about">
			<ul>
				<li><span onclick="window.location.href='${webtxc}/goodsinfo/ServiceInfo/homeShow.html'+'?comId='+g_comid">首页 </span> | <span>App下载 </span> | <span>关于我们  </span> | <span onclick="window.location.href='${webtxc}/goodsinfo/home/direct.html?stId=311'">操作指南</span></li>
				<li class="dz">重庆捷路科技有限公司 Copyright © 2015 ECJia(ecjia.com)版权所有，并保留所有权利。</li>				
		        <li style="float:right">
                <a target="_blank" href="http://www.miitbeian.gov.cn" ><img src="${webtxc}/images/icons_5859e57.png" style="padding-top:7px;float:left">渝ICP备13003919号-12</a>
                </li>
			</ul>
		</div>
	</div>
	</div>
</c:if>










	<!--end.contain-->
