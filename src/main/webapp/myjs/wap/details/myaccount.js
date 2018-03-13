var flag = "d";
var startTime = "";
var endTime = "";
$(function(){
	$('html').css({"background":"none"});
	$('#account_bill').removeAttr("style");
	$('#account_bill').css({"display":"none"});
	$('#bill').click(function(){
		$('#account_body').css({"display":"none"});
		$('#account_bill').css({"display":"block"});
		showDiv(jsonList,1,flag);
	});
	$('#account_edit_pay_pass_btn').click(function(){
		$('#account_body').css({"display":"none"});
		$('#account_edit_pay_pass').css({"display":"block"});
		$('#sub-btn').css({"display":"block"});
	});
	
	$('#searchh').click(function(){
		startTime = $('#startTime').datebox('getValue');
		endTime = $('#endTime').datebox('getValue');
		flag = $('#cc').combobox('getValue');
		selectCommonAjax(1);
	});
	
	$("#getvalidate").click(function() {
		getValidate();
	});
	$("#sub").click(function() {
        subMes();
	})
});


function selectCommonAjax(pageNo){
	$("#billlist").empty();
	$.ajax({
			type : "post",
			url : path+'/wap/details/AccountPaymentDetails/showIODetailsByAjax.html',
			dataType:'json',
			data:{
				'flag':flag,
				'startTime':startTime,
				'endTime':endTime,
				'page':pageNo
			},
			success:function(res){
				count = res.count;
				showDiv(res.acDetailsList,res.pageNo,res.flag);
			}
	});
}

function showDiv(res,pageNo,flag){
    var inner = '<ul class="zd_list haa">'
        /*+'<li class="b_time">时间</li>'
        +'<li class="b_time">收入</li>'
        +'<li class="b_time">支出</li>'*/
       /* +'<li class="b_time">备注</li>'*/
        +'</ul>'
	for(var i in res){
		var arr = res[i];
		if(flag=='d'){
			var apdCreatetimeStr = arr["apdCreatetimeStr"];
			var apdIotype = arr["apdIotype"];
			var apdAmountIn;
			var apdAmountOut;
			if(apdIotype==1){
				apdAmountIn = '+'+arr["apdAmount"].toFixed(2);
				apdAmountOut = '--';
			}else if(apdIotype==2){
				apdAmountOut = '-'+arr["apdAmount"].toFixed(2);
				apdAmountIn = '--';
			}
			var apdComment = arr["apdComment"];
			inner += '<ul class="zd_list">'
				+'<li class="shijian">'+(apdCreatetimeStr||"")+'</li>'
				+'<li class="b_time">'+(apdAmountIn)+'</li>'
				+'<li class="b_time">'+(apdAmountOut)+'</li>'
				+'<li class="b_time">'+(apdComment||"")+'</li>'
				+'</ul>'
		}else if(flag=='a'){
			var apdInamount = arr["APD_INAMOUNT"].toFixed(2);
			var apdOutamount = arr["APD_OUTAMOUNT"].toFixed(2);
			var apdCreatetime = arr["YEAR"];
			var apdComment = arr["apdComment"];
			inner += '<ul class="zd_list">'
				+'<li class="shijian">'+(apdCreatetime||"")+'</li>'
				+'<li class="b_time">'+(apdAmountIn)+'</li>'
				+'<li class="b_time">'+(apdAmountOut)+'</li>'
				+'<li class="b_time">'+(apdComment||"")+'</li>'
				+'</ul>'
		}else if(flag=='b'){
			var apdInamount = arr["APD_INAMOUNT"].toFixed(2);
			var apdOutamount = arr["APD_OUTAMOUNT"].toFixed(2);
			var apdCreatetime = arr["YEAR"]+'-'+arr["MONTH"];
			var apdComment = arr["apdComment"];
			inner += '<ul class="zd_list">'
				+'<li class="shijian">'+(apdCreatetime||"")+'</li>'
				+'<li class="b_time">'+(apdAmountIn)+'</li>'
				+'<li class="b_time">'+(apdAmountOut)+'</li>'
				+'<li class="b_time">'+(apdComment||"")+'</li>'
				+'</ul>'
		}else if(flag=='c'){
			var apdInamount = arr["APD_INAMOUNT"].toFixed(2);
			var apdOutamount = arr["APD_OUTAMOUNT"].toFixed(2);
			var apdCreatetime = arr["YEAR"]+'-'+arr["MONTH"]+'-'+arr["DAY"];
			var apdComment = arr["apdComment"];
			inner += '<ul class="zd_list">'
				+'<li class="shijian">'+(apdCreatetime||"")+'</li>'
				+'<li class="b_time">'+(apdAmountIn)+'</li>'
				+'<li class="b_time">'+(apdAmountOut)+'</li>'
				+'<li class="b_time">'+(apdComment||"")+'</li>'
				+'</ul>'
		}
	 }
    $("#billlist").append(inner);
	pageNum(count,10 ,pageNo, 'pageDiv');
}

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
	var newPass=$("#newPass").val();
	var confirmPass =$("#confirmPass").val();
	var pass=$.md5(newPass);
	var checkCode=$('#xfjcheck').val();
	if(newPass!=confirmPass){
		alert('两次输入密码不相同');
	}else	if(checkLength(newPass,6,20)){
		alert('密码必须在6到20位之间!');
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
				}
			}
		});
	}
}
