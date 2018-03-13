<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>绑定账号</title>
<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<link rel="stylesheet" href="${webtxc}/css/public.css" />
<link rel="stylesheet" href="${webtxc}/css/login.css" />
	<script type="text/javascript" src="${webtxc }/js/wap/common.js"></script>
	<script type="text/javascript" src="${webtxc }/js/wap/jquery.validate.js"></script>
	<script type="text/javascript" src="${webtxc }/myjs/userinfo/bd_phone.js"></script>
	<script type="text/javascript" src="${webtxc}/jquery/jquery.cookie.js"></script>
</head>
<style>
.bd_phone{padding:30px 20px;text-align:center}
.bd_phone h1{text-align:center;margin-bottom:50px;}
.bd_phone ul{width:50%;margin:10px auto;overflow: hidden;}
.bd_phone .bd_phone_input{width:99.5%;height:40px;margin-bottom: 10px;border:1px solid #eee;color:#999;font-size:15px;float:left;}
.bd_phone .bd_phone_yzm{width:50%;float:left;height:40px;border:1px solid #eee;color:#999;font-size:15px;}
.bd_phone .bd_phone_yzms{width:47%;float:right;height:40px;line-height: 40px;border:1px solid #eee;color:#999;font-size:15px;}
.phone_bang{border: 1px solid #f40;clear: both;width: 50%;margin: 0 auto;height: 40px;line-height: 40px;color:#f40;font-size:18px;margin-top: 40px;width: 99%;}
.phone_bang a{color:#f40;}
.phone_s_ts{text-align:left;font-size:12px;width:20%;line-height: 30px;}
</style>
<body>
<%@include file="/WEB-INF/jsp/common/top.jsp"%>
<div class="content">
<div class="login">
	<form id="form">
		  <div class="bd_phone">
		    <h1>绑定手机号</h1>
		    <ul>
		    <li><input type="text" class="bd_phone_input" placeholder="手机号" id="telephone" name="telephone" />
		    	
		    </li>
		    <div id="telephone1" class="phone_s_ts"></div>
		    </ul>
		    <ul>
		    <li><input type="text" class="bd_phone_yzm" placeholder="验证码" id="code" name="checkCode"/>		    
		    </li>
		   
		    <li><a href="javascript:validat();" class="bd_phone_yzms" id="getValidateCode">获取验证码</a>
		    </li>
		    
		    
		   
		    <ul style="width:100%">
		    <li id="checkCode1" class="phone_s_ts"></li>
		    </ul>
		    <ul id="setPwd"  style="display : none;width:100%">
		    
   		    <li><input type="password" class="bd_phone_input" placeholder="新密码" id="pwd" name="pwd" />
		    	<div id="pwd1" class="phone_s_ts"></div>
		    </li>
   		    <li><input type="password" class="bd_phone_input" placeholder="重复密码" id="pwdRe" name="pwdRe" />
		    	<div id="pwdRe1" class="phone_s_ts"></div>
		    </li>
		    </ul>
		    <div class="phone_bang"><a href="javascript:toSubmit();" id="submit">绑定

</a></div>
		  </div>
  		  <input type="hidden" id="type" name="sex" value="${type }"/>
		  <input type="hidden" id="sex" name="sex" value="${sex }"/>
		  <input type="hidden" id="nickname" name="nickname" value="${nickname }"/>
		  <input type="hidden" id="headimgurl" name="headimgurl" value="${headimgurl }"/>
		  <input type="hidden" id="openid" name="openid" value="${openid }"/>
	</form>
  
  </div>
  </div>
</body>
</html>