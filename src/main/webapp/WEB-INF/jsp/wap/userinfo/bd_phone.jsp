<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>绑定手机</title>
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
	<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js"></script>
	<script type="text/javascript" src="${webtxc }/js/wap/jquery.validate.js"></script>
	<script type="text/javascript" src="${webtxc }/myjs/wap/userinfo/bd_phone.js"></script>
	<script type="text/javascript" src="${webtxc}/jquery/jquery.cookie.js"></script>
</head>
<style>
.content{background:#fff;}
.bd_phone{padding:30px 20px;text-align:center}
.bd_phone h1{text-align:center;margin-bottom:50px;}
.bd_phone ul{width:100%;margin:10px auto;overflow: hidden;}
.bd_phone .bd_phone_input{width:98%;height:40px;border-style: none;border-bottom:1px solid #eee;color:#999;font-size:15px;float:left;-webkit-appearance: none;border-radius: 0;}
.bd_phone .bd_phone_yzm{width:51%;float:left;height:40px;border-style: none;border-bottom:1px solid #eee;color:#999;font-size:15px;-webkit-appearance: none;border-radius: 0;}
.bd_phone .bd_phone_yzms{width:40%;float:right;height:47px;line-height: 45px;border-style: none;background:#f8f8f8;color:#999;font-size:15px;-webkit-appearance: none;border-radius: 0;}
.phone_bang{clear: both;background:#f40;width: 100%;margin: 0 auto;height: 40px;line-height: 40px;font-size:18px;margin-top: 40px;}
.phone_bang a{color:#fff;}
.phone_s_ts{text-align:left;float:left;font-size:12px;width:100%;}
.tiss{font-size:12px;color:#999;margin-top:10px;}
</style>
<body>

<div class="content">
<div class="login">
	<form id="form">
		  <div class="bd_phone">
		    <ul>
		    <li><input type="text" class="bd_phone_input" placeholder="手机号" id="telephone" name="telephone" />
		    	<div id="telephone1" class="phone_s_ts"></div>
		    </li>
		    </ul>
		    <ul>
		    <li><input type="text" class="bd_phone_yzm" placeholder="验证码" id="code" name="checkCode"/>
		    
		    </li>
		    <li><a href="javascript:validat();" class="bd_phone_yzms" id="getValidateCode">获取验证码</a></li>
		    
		    </ul>
		    <ul>
		   <li id="checkCode1" class="phone_s_ts"></li>
		    </ul>
		    <ul id="setPwd" style="display:none;">
   		    <li><input type="password" class="bd_phone_input" placeholder="新密码" id="pwd" name="pwd" />
		    	<div id="pwd1" class="phone_s_ts" style="margin-bottom:10px;"></div>
		    </li>
   		    <li><input type="password" class="bd_phone_input" placeholder="重复密码" id="pwdRe" name="pwdRe" />
		    	<div id="pwdRe1" class="phone_s_ts"></div>
		    </li>
		    </ul>
		    
		    <div class="phone_bang"><a href="javascript:toSubmit();" id="submit">绑定</a></div>
		    <div class="tiss">为了您的账户安全，请绑定手机号。</div>
		  </div>
		  
		  <input type="hidden" id="sex" name="sex" value="${sex }"/>
		  <input type="hidden" id="nickname" name="nickname" value="${nickname }"/>
		  <input type="hidden" id="headimgurl" name="headimgurl" value="${headimgurl }"/>
		  <input type="hidden" id="openid" name="openid" value="${openid }"/>
	</form>
  
  </div>
  </div>
</body>
</html>