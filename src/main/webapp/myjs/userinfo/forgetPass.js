$(function() {
	$("#getvalidate").click(function() {
		getValidate();
	});
	$("#sub").click(function() {
		subMes();

	})

});
function getValidate() {
	var logCell = $('#logCell').val();
	if (checkNull(logCell)) {
		$('#message1').text('手机号不能为空');
	} else if (!checkCell(logCell)) {
		$('#message1').text('输入有效手机号码');
	} else {
		$.ajax({
			type : "post",
			url : path + '/userinfo/logInfo/validateLoginCell.html',
			dataType : 'json',
			data : {
				'logCell' : logCell
			},
			success : function(jr) {
				if (jr.success) {
					timeOut(60);
				} else {
					if (jr.errorCode == "1") {
						alert(jr.errorMsg); 
					} else if (jr.errorCode == "2") {
						alert(jr.errorMsg);
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
			background : '#FB5A5A',
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
	if (newPass != confirmPass) {
		alert('两次输入密码不相同');
	} else if (checkLength(newPass, 6, 20)) {
		alert('密码必须在6到20位之间');
	} else if (checkNull(logCell)) {
		$('#message1').text('手机号不能为空');
	} else if (!checkCell(logCell)) {
		$('#message1').text('输入有效手机号码');
	} else {
		$.ajax({
			type : "post",
			url : path+'/userinfo/logInfo/modifyPassByCell.html',
			dataType : 'json',
			data : {
				'logCell' : logCell,
				'newPass' : newPass,
				'logPass' : pass,
				'checkCode' : checkCode
			},
			success : function(jr) {
				if (jr.errorCode == '2') {
					alert("手机验证码出错！");
				} else if (jr.errorCode == '3') {
					alert('密码格式出错！');
				} else if (jr.errorCode == '1') {
					alert('手机格式出错！');
				}else {
					alert("修改成功！",null,function(){window.location.href = path+ "/userinfo/logInfo/jumpLogin.html"+'?comId='+g_comid;},null);
				}
			}
		});
	}

}
