<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>发布服务</title>
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
		<link href="${webtxc}/css/style.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${webtxc}/css/public.css" />
		<link rel="stylesheet" href="${webtxc}/css/service.css" />
</head>
<body>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>


<div class="content">
  <div class="service_fabu">
      <h2>发布服务</h2>
      <h3>发布您的需求，寻求附近专业人士的帮助。</h3>
       
        <ul>
         <li>
           <div class="xuqiu_img5"></div>
           <div class="xuqiu_title">
           <h3>发布服务</h3>
           <p>为您的服务提供更多展示空间</p>
           </div>
         </li>
         <li>
           <div class="xuqiu_img6"></div>
           <div class="xuqiu_title">
           <h3>服务描述</h3>
           <p>服务个性包装展示，让生意找上您</p>
           </div>
         </li>
         <li>
           <div class="xuqiu_img7"></div>
           <div class="xuqiu_title">
           <h3>服务推荐</h3>
           <p>设置展示客户最感兴趣的服务推荐</p>
           </div>
         </li>
         <li>
           <div class="xuqiu_img8"></div>
           <div class="xuqiu_title">
           <h3>发布案例</h3>
           <p>案例展示彰显实力，提高客户信任度</p>
           </div>
         </li>
        </ul>              
       </div>
       <div class="zbj-grid">
 <h2>发布需求流程</h2>
<div class="pub-steps ">
<ul class="list-unstyled clearfix">
<li id="pub-step-1-nav" class="header-step step-on ">
<span class="step-deco"></span>
<span class="step-val">1</span>
<span class="step-title">选择服务类目</span>
</li>
<li id="pub-step-2-nav" class="header-step  step-next">
<span class="step-deco"></span>
<span class="step-val">2</span>
<span class="step-title">填写服务信息</span>
</li>
<li id="pub-step-3-nav" class="header-step  step-next">
<span class="step-deco"></span>
<span class="step-val">3</span>
<span class="step-title">发布成功，等待审核</span>
</li>
<li id="pub-step-4-nav" class="header-step  step-next">
<span class="step-deco"></span>
<span class="step-val">4</span>
<span class="step-title">审核通过，等待约见</span>
</li>
</ul>
</div></div>
<div class="service_fabu_btn">
  <a class="service_fabu_btn_fb">立即发布服务</a>
</div>
</div>
<%@include file="/WEB-INF/jsp/common/bottom.jsp"%>

</body>
</html>