$(function(){
	$("#form").validate({
		rules : {
			telephone : {
				required : true,
				isPhone : true
			},
			checkCode :{
				required : true,
			},
			pwd :{
				required : true,
				rangelength:[6,20],
			},
			pwdRe :{
				required : true,
				rangelength:[6,20],
				equalTo : "#pwd",
			},
		},
		messages : {
			telephone : {
				required : "<em style='color: red;font-size: 12px;font-style:normal'>必填</em>",
			},
			checkCode :{
				required : "<em style='color: red;font-size: 12px;font-style:normal'>必填</em>",
			},
			pwd :{
				required : "<em style='color: red;font-size: 12px;font-style:normal'>必填</em>",
				rangelength :"<em style='color: red;    font-size: 12px;font-style:normal'>请输入6至20位的密码</em>",
			},
			pwdRe :{
				required : "<em style='color: red;font-size: 12px;font-style:normal'>必填</em>",
				rangelength :"<em style='color: red;    font-size: 12px;font-style:normal'>请输入6至20位的密码</em>",
				equalTo : "<em style='color: red;    font-size: 12px;font-style:normal'>两次输入的密码不一致</em>",
			},
		},
		onfocusout : function(element) {
			$(element).valid();
		},
		invalidHandler : function(form, validator) {
			return false;
		},
		errorPlacement: function(error, element) { //错误信息位置设置方法
			if(element.is('#telephone')){
				error.appendTo($('#telephone1'));
			}else if(element.is('#code')){
				error.appendTo($('#checkCode1'));
			}else if(element.is('#pwd')){
				error.appendTo($('#pwd1'));
			}else if(element.is('#pwdRe')){
				error.appendTo($('#pwdRe1'));
			}
		},
	});
	
	$.validator.addMethod("isPhone",function(value, element) {
	    var length = value.length;  
	    var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;  
	    return this.optional(element) || (length == 11 && mobile.test(value));  
	}, "<em style='color: red;font-size: 12px;font-style:normal'>手机格式有误</em>");
	
});

/** 绑定手机 */
function toSubmit(){
	$("#submit").attr("href","javascript:;");
	var flag;
	if(phoneIsTrue ==0){
		flag = $("#form").validate().element($("#telephone")) && $("#form").validate().element($("#code"));
	}else{
		flag = $("#form").validate().form();
	}
	if(flag){
		var pwd=$.md5($("#pwd").val());
		$.ajax({
			type : "post",
			url : path + '/userinfo/weiXinLog.html',
			dataType : 'json',
			data : {
				logCell : $('#telephone').val(),
				type :  $('#type').val(),
				nickname : $("#nickname").val(),
				headimgurl : $("#headimgurl").val(),
				openid : $("#openid").val(),
				checkCode : $("#code").val(),
				password : pwd
			},
			success : function(res) {
				if (res.success) {
//                    if (document.URL == path + '/userinfo/logInfo/logout.html') {
//                        window.location.href = path + "/goodsinfo/ServiceInfo/homeShow.html" + '?comId=' + g_comid;
//                    } else {
//                        window.location.reload();
//                    }
					window.location.href = path + "/company/companyIndex.html";
				}else{
					alert(res.errorMsg);
					$("#submit").attr("href","javascript:toSubmit();");
				}
			},
			error : function(){
				alert("网络异常,请检查网络");
				$("#submit").attr("href","javascript:toSubmit();");
			}
		});
	}else{
		$("#submit").attr("href","javascript:toSubmit();");
	}
}
/** 手机号是否已存在 */
var phoneIsTrue = 0;
/** 发送手机验证码 */
function validat(){
	var boolean = $("#form").validate().element($("#telephone"));  
	if(boolean){
		$.ajax({
			type : "post",
			url : path + '/userinfo/accountInfo/sendMes.html',
			dataType : 'json',
			data : {
				'logCell' : $('#telephone').val(),
				type : '1'
			},
			success : function(res) {
				if (res.success) {
					onOff = 1; // 把开关打开，函数变为可用
					Countdown(); // 调用Countdown函数
					var errorCode = res.errorCode;
					if(errorCode == 1){//手机号码不存在  设置手机登录密码
						phoneIsTrue = 1;
						$("#setPwd").show();
					}else{//手机号码存在,则直接绑定
						phoneIsTrue = 0;
						$("#setPwd").hide();
					}
				}else{
					alert(res.errorMsg);
				}
			},
			error : function(){
				alert("网络异常,请检查网络");
			}
		});
	}
}

listenerGetValidateCode();// 初始化时就加载此函数

var delayMins = 60; // 全局时间变量（秒数）;与后台的delayMins要相同
var onOff = 0;// 为0时次函数不可用，为1时可用
function Countdown() { // 计时函数
	if (delayMins > 0 && onOff == 1) { // 如果不到零秒且onOff为1可用
		--delayMins; // 时间变量自减1
		$("#getValidateCode").html(parseInt(delayMins) + "秒后重新获取"); // 写入秒数
		$("#getValidateCode").attr("href", "javascript:;"); // 按钮设置为不可用
		setTimeout("Countdown()", 1000); // 设置1000毫秒以后执行一次本函数
	}
};

// 设置个监听， timerc归零时，把getValidateCode按钮上的：值恢复默认；再变为可用
function listenerGetValidateCode() {
	if (delayMins <= 0) {
		$("#getValidateCode").html("获取验证码");
		$("#getValidateCode").attr("href", "javascript:validat();");
		onOff = 0;// 关闭函数，禁用上面的方法
		delayMins = 60;
	}
	setTimeout("listenerGetValidateCode()", 500);
};