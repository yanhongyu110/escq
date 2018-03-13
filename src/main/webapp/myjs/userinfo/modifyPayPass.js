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
			url : path + '/userinfo//accountInfo/sendMes.html',
			dataType : 'json',
			data : {
				'logCell' : logCell
			},
			success : function(res) {
				if (res.success) {
					timeOut(60);
				} else {
					if (res.errorCode == "1") {
						$('#message1').text(res.errorMsg);
					} else if (res.errorCode == "2") {
						$('#message2').text(res.errorMsg);
					}
				}
			}
		});
	}
}
function timeOut(i) {
	if (i != 0) {
		$("#getvalidate").unbind("click");
		$('#getvalidate').html(i + 's可重新发送');
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
		$('#getvalidate').html('获取验证码');
		$('#getvalidate').css({
			background : '#73C3ED',
			border : '1px solid #73C3ED',
			cursor: 'pointer'
		});
	}
	i--;
}
function subMes(){
	var href = window.location.href;
	var flag = href.substr(href.indexOf('?flag=')+6,1);
	var orderId = href.substring(href.indexOf('&orderId=')+9);
	
	var newPass=$("#newPass").val();
	var confirmPass =$("#confirmPass").val();
	var pass=$.md5(newPass);
	var checkCode=$('#xfjcheck').val();
	if(newPass!=confirmPass){
		alert('两次输入密码不相同');
	}else	if(checkLength(newPass,6,20)){
		alert('密码必须在6到20位之间');
	}else{
		$.ajax({
			type : "post",
			url : path + '/userinfo/accountInfo/modifyPassById.html',
			dataType : 'json',
			data : {
				'newPass' : newPass,
				'logPass':pass,
				'checkCode':checkCode
			},
			success : function(jr) {
				if(jr.errorCode=='2'){
					alert("手机验证码出错！");
				}else if(jr.errorCode=='3'){
					alert('密码格式出错！');
				}else{
					alert('支付密码修改成功！');
					if(flag == 1){
						setTimeout(function(){return window.location.href=path+'/saleinfo/orderInfoBuyer/getAccount.html?orderId='+orderId+'&comId='+g_comid;},"1000");
					}
				}
			}
		});
	}

	
}
