<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta charset="UTF-8">
	<title>提现</title>
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
	<link rel="stylesheet" href="${webtxc }/css/wap/personer.css"/>
	<script type="text/javascript" src="${webtxc }/js/wap/common.js"></script>
	<script type="text/javascript" src="${webtxc }/js/wap/jquery.validate.js"></script>
	<script type="text/javascript" src="${webtxc }/myjs/wap/userinfo/withDraw.js"></script>
	<script type="text/javascript" src="${webtxc}/jquery/jquery.cookie.js"></script>
	<script type="text/javascript">
	var loginfo='${sessionScope.logInfo.logId}';
	</script>
</head>
<body>
	<div id="tixianDiv" class="tixian_yue">
	<form id="form">
	  <ul>
	    <li class="tixian_yue_title">提现金额</li>
	    <li class="tixian_yue_xiang"><input class="tixian_input" type="text" name="money" id="money" placeholder="请输入提现金额（元）"></li>
	  	<li id="money1"></li>
	  </ul>
	  <ul>
	    <li class="tixian_yue_title">交易密码</li>
	    <li class="tixian_yue_xiang"><input class="tixian_input" type="password" name="tranPwd" id="tranPwd" placeholder="请输入交易密码"></li>
	  	<li id="tranPwd1"></li>
	  </ul>
	    <div class="wsmm"><a href="javascript:forgetPassword();">忘记密码？</a></div>
	  <%-- <ul>
	    <li class="tixian_yue_title">提现到</li>
	    <li class="tixian_yue_xiang"><span><img src="${webtxc}/images/zfb.png"></span><span><img src="${webtxc }/images/wxx.png" ></span></li>
	  </ul> --%>
	</form>
	<div class="tixian_btn"><a id="tixian" href="javascript:tixian()">提 现</a></div>
	</div>
		  <form id="formPwd">
        <div id="account_edit_pay_pass" class="personer_mes_zl" style="display:none">
            <ul class="personer_mes_zl_ms">
                <h3>设置支付密码</h3>
            </ul>
            <ul class="personer_mes_zl_ms">
                <li>手机号</li>
                <li class="mes_input">
                    <input id="logCell" style="color:black" type="text" value="${sessionScope.logInfo.logCell}"
                           disabled="true" 　readOnly="true"/>
                </li>
            </ul>
            <ul class="personer_mes_zl_ms">
                <li>验证码</li>
                <li class="mes_input" style="width:90px;">
                    <input id="xfjcheck" placeholder="请输入验证码" type="text" name="xfjcheck"/>
                </li>
                <li class="hq_yzm" style="margin-top: 0;float:right" id="getvalidate" onclick="getValidate();">获取验证码</li>
                <div style="clear:both"><ul style="    line-height: 15px;"><li id="xfjcheck1"></li></ul></div>
                
            </ul>
            <ul class="personer_mes_zl_ms">
                <li>新密码</li>
                <li class="mes_input">
                    <input id="newPass" placeholder="至少输入6个字符" type="password" name="newPass"/>
                </li>
                 <div style="clear:both"><ul style="    line-height: 15px;"><li id="newPass1" style="width: 100%;"></li></ul></div>
                <li id="newPassicon"></li>
            </ul>
            <ul class="personer_mes_zl_ms">
                <li>确认密码</li>
                <li class="mes_input">
                    <input id="confirmPass" placeholder="至少输入6个字符" type="password" name="confirmPass"/>
                </li>
                <li id="confirmPass1" style="width: 100%;line-height: 15px;"></li>
                <li id="confirmPassicon"></li>
            </ul>
        </div>
        </form>
          <div id="sub-btn" class="personer_excit" style="display: none;">
            <div id="sub" class="excit" style="cursor:pointer" onclick="subMes();">修改</div>
            <div class="cz" onclick="history.go(0)">返回</div>
        </div>
	<%-- <%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%> --%>
	<!--wapper end-->
	
</body>
</html>
