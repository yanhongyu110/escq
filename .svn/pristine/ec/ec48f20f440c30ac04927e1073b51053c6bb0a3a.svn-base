/*$(function() {
	$("#getvalidate").click(function() {
		getValidate();
	});
	$("#sub").click(function() {
		subMes();

	})

});*/
window.onload = function(){
	$("#getvalidate").click(function() {
		getValidate();
	});
	$("#sub").click(function() {
		subMes();

	})
}
function getValidate() {
	console.info(path + '/wap/userinfo/logInfo/validateLoginCell.html')
	var logCell = $('#logCell').val();
	if (checkNull(logCell)) {
		$('#message').text('手机号不能为空').slideDown(300).delay(1000).slideUp(300);
	} else if (!checkCell(logCell)) {
		$('#message').text('输入有效手机号码').slideDown(300).delay(1000).slideUp(300);
	} else {
		$.ajax({
			type : "post",
			url : path + '/wap/userinfo/logInfo/validateLoginCell.html',
			dataType : 'json',
			data : {
				'logCell' : logCell
			},
			success : function(jr) {
				if (jr.success) {
					timeOut(60);
				} else {
					if (jr.errorCode == "1") {
						$('#message').text(jr.errorMsg).slideDown(300).delay(1000).slideUp(300);
					} else if (jr.errorCode == "2") {
						$('#message').text(jr.errorMsg).slideDown(300).delay(1000).slideUp(300);
					}
				}
			}
		});
	}
}
function timeOut(i) {
	if (i != 0) {
		$("#getvalidate").unbind("click");
		$('#getvalidate').val(i + 's可重新发送');
		$('#getvalidate').css({
			background : '#999',
			border : '0px'
		});
		setTimeout(function() {
			timeOut(i)
		}, (1000));
	} else {
		$("#getvalidate").click(function() {
			getValidate();
		})
		$('#getvalidate').val('获取验证码');
		$('#getvalidate').css({
			background : '#ccc',
			border : '1px solid #FB5A5A',
			cursor : 'pointer'
		});
	}
	i--;
}
function subMes() {
	var logCell = $("#logCell").val();
	var newPass = $("#newPass").val();
	var confirmPass = $("#confirmPass").val();
	var pass = $.md5(newPass);
	var checkCode = $('#check').val();
	if (checkNull(logCell)) {
		$('#message').text('手机号不能为空').slideDown(300).delay(1000).slideUp(300);
	} else if (!checkCell(logCell)) {
		$('#message').text('输入有效手机号码').slideDown(300).delay(1000).slideUp(300);
	} else if (newPass != confirmPass) {
		$('#message').text('两次输入密码不相同').slideDown(300).delay(1000).slideUp(300);
	} else if (checkLength(newPass, 6, 20)) {
		$('#message').text('密码必须在6到20位之间').slideDown(300).delay(1000).slideUp(300);
	} else {
		$.ajax({
			type : "post",
			url : path+'/wap/userinfo/logInfo/modifyPassByCell.html',
			dataType : 'json',
			data : {
				'logCell' : logCell,
				'newPass' : newPass,
				'logPass' : pass,
				'checkCode' : checkCode
			},
			success : function(jr) {
				if (jr.errorCode == '2') {
					$('#message').text("手机验证码出错！").slideDown(300).delay(1000).slideUp(300);
				} else if (jr.errorCode == '3') {
					$('#message').text('密码格式出错！').slideDown(300).delay(1000).slideUp(300);
				} else if(jr.errorCode == '1'){
					$('#message').text('手机格式出错！').slideDown(300).delay(1000).slideUp(300);
				} else{
					$('#message').text('修改成功！').slideDown(300).delay(1000).slideUp(300);
					window.location.href = path + "/wap/userinfo/logInfo/jumpLogin.html";
				}
			}
		});
	}

}
