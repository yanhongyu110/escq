$(function(){
	$('#login').click(function(){
		login();
	})
	$('.close').click(function(){
		$(this).prev('input').val('');
	})
	$('#logCell').bind('input propertychange', function() {
		$('#message1').text('');
 	});
	$('#logPass').bind('input propertychange', function() {
		$('#message2').text('');
 	});
	checkCookie();
})
function checkCookie(){
	var coo = $.cookie('rmb');
	if($.cookie('rmb')){
		 $("#logCell").val($.cookie('logName')); 
		 $("#logPass").val($.cookie('logPass'));
		 $("#check").attr("checked","true");
	}
}
function register(){
	window.location.href = path+"/userinfo/logInfo/jumpRegister.html"+'?comId='+g_comid;
}
function login(){
	var logCell = $('#logCell').val();
	var logPass = $('#logPass').val();
	if(checkNull(logCell)){
		$('#message1').text('账号不能为空');
	}else if(checkNull(logPass)){
		$('#message2').text('密码不能为空');
	}else{
		var name = $.cookie('logName');
		var pass = $.cookie('logPass');
		if(logCell != name || logPass != pass){
			logPass = $.md5(logPass);
		}
		var checked = $("#check").is(":checked");
		if (checked){ 
			 $.cookie('rmb', true, { expires: 7, path: '/' });
			 $.cookie('logName', logCell, { expires: 7, path: '/' });
			 $.cookie('logPass', logPass, { expires: 7, path: '/' });
		}else{  
			 $.cookie('rmb', false, { expires: -1, path: '/' });
			 $.cookie('logName', '', { expires: -1, path: '/' });
			 $.cookie('logPass', '', { expires: -1, path: '/' });
		}
		$.post(path+'/userinfo/logInfo/login.html',$.param({
			'logName':logCell,
			'logPass':logPass
			},true),function(result){
			if (result.success){
				alert("登录成功","登录",function(){
					window.location.href=path+"/goodsinfo/ServiceInfo/homeShow.html"+'?comId='+g_comid;
				})
			}else{
				if(result.errorCode == "1"){
					$('#message1').text(result.errorMsg);
				}else if(result.errorCode == "2"){
					$('#message2').text(result.errorMsg);
				}
			}
		},'json');
	}
}

