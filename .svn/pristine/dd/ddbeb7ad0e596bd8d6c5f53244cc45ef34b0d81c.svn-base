$(function(){
	$("#refresh").click(function() {
		refresh();
	})
	$('.close').click(function(){
		$(this).prev('input').val('');
	})
	$('#button').click(function() {
		button();
	})
	$('#logCell').bind('input propertychange', function() {
		$('#message1').text('');
 	});
	$('#checkcode').bind('input propertychange', function() {
		$('#message2').text('');
 	});
	$('#logPass').bind('input propertychange', function() {
		$('#message3').text('');
 	});
	$('#savelogPass').bind('input propertychange', function() {
		$('#message4').text('');
 	});
	$('#imagesCode').bind('input propertychange', function() {
		$('#message5').text('');
 	});
	$('#checkbox').click(function(){
		if($('#checkbox').is(':checked')){
			$('#register').css('background','#FB5A5A');
			$('#register').click(function(){
				orz_register();
			})
		}else{
			$("#register").unbind("click");
			$('#register').css('background','#999');
		}
	})
})
function orz_register(){
	var logCell = $('#logCell').val();
	var checkcode = $('#checkcode').val();
	var logPass = $('#logPass').val();
	var savelogPass = $('#savelogPass').val();
	var imagesCode = $('#imagesCode').val();
	var provider=$.getUrlParam('provider');
	if(checkNull(logCell)){
		$('#message1').text('手机号不能为空');
	}else if(checkNull(checkcode)){
		$('#message2').text('验证码不能为空');
	}else if(checkNull(logPass)){
		$('#message3').text('密码不能为空');
	}else if(checkNull(savelogPass)){
		$('#message4').text('确认密码不能为空');
	}else if(checkNull(imagesCode)){
		$('#message5').text('图片验证码不能为空');
	}else if(!checkCell(logCell)){
		$('#message1').text('手机格式不对');
	}else if(checkLength(logPass)){
		$('#message5').text('密码必须在6-20位之间');
	}else if(logPass != savelogPass){
		$('#message4').text('密码不相同');
	}else{
		$("#register").unbind("click");
		$.post(path+'/userinfo/logInfo/register.html',$.param({
			'logCell':logCell,
			'checkCode':checkcode,
			'logPass':$.md5(logPass),
			'savelogPass':savelogPass,
			'imagesCode':imagesCode,
			'provider':provider
			},true),function(result){
			$('#register').click(function(){
				orz_register();
			})
			if (result.success){
				login();
			}else{
				if(result.errorCode == "2"){
					$('#message2').text(result.errorMsg);
				}else if(result.errorCode == "3"){
					$('#message3').text(result.errorMsg);
				}else if(result.errorCode == "5"){
					$('#message5').text(result.errorMsg);
				}
			}
		},'json');
	}
}
function button(){
	var logCell = $('#logCell').val();
	if(checkNull(logCell)){
		$('#message1').text('手机号不能为空');
	}else if(!checkCell(logCell)){
		$('#message1').text('输入有效手机号码');
	}else{
		$.ajax({
			type : "post",
			url : path+'/userinfo/logInfo/validateLoginName.html',
			dataType:'json',
			data:{'logCell':logCell},
			success:function(res){
				if(res.success){
					timeOut(60);
				}else{
					if(res.errorCode == "1"){
						$('#message1').text(res.errorMsg);
					}else if(res.errorCode == "2"){
						$('#message2').text(res.errorMsg);
					}
				}
			}
		});
	}
}
function timeOut(i){
	if(i != 0){
		$("#button").unbind("click");
		$('#button').val(i+'s可重新发送');
		$('#button').css({background:'#999',border:'0px'});
		setTimeout(function(){timeOut(i)},(1000));
	}else{
		$("#button").click(function() {
			button();
		})
		$('#button').val('获取验证码');
		$('#button').css({background:'#FB5A5A',border:'1px solid #FB5A5A'});
	}
	i--;
}
function login(){
	window.location.href = path+"/userinfo/logInfo/jumpLogin.html"+'?comId='+g_comid;
}
function refresh(){
	$("#image").attr("src", path+"/userinfo/logInfo/getImagesCode.html?v="+new Date); 
}
//自定义方法：从地址栏中获取数据
(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
})(jQuery);



$(function(){
    //qq登录  
    QC.Login({  
        btnId: "qqLoginBtn",    //插入按钮的节点id      
        //用户需要确认的scope授权项，可选，默认all  
        scope: "all",  
        //按钮尺寸，可用值[A_XL| A_L| A_M| A_S|  B_M| B_S| C_S]，可选，默认B_S  
        size: "A_M"  
    });  

    //从页面收集OpenAPI必要的参数。get_user_info不需要输入参数，因此paras中没有参数  
    var paras = {};  

    //用JS SDK调用OpenAPI  
    QC.api("get_user_info", paras)  
        //指定接口访问成功的接收函数，s为成功返回Response对象  
        .success(function (s) {  
            //成功回调，通过s.data获取OpenAPI的返回数据  
//            $.ajax({  
//                type: "POST",  
//                url: "../../../Ajax/WebServiceHandler.aspx/QQUserLogin", // 调动后台页面方法                                          
//                contentType: "application/json; charset=utf-8",  
//                dataType: "json",  
//                data: '{"strLoginName":"' + s.data.nickname + '"}',  
//                success: function (data) {  
//                    var strReturn = data.d;  
//                    if (strReturn == "fail") {  
//                        QC.Login.signOut();  
//                    }  
//                    else {  
//                        alert("QQ登录成功");   
//                    }  
//                },  
//                error: function (err) {  
//                    QC.Login.signOut();  
//                }  
//            });  
        })  
        //指定接口访问失败的接收函数，f为失败返回Response对象  
        .error(function (f) {  
            //失败回调  
            alert("获取用户信息失败！");  
        })  
        //指定接口完成请求后的接收函数，c为完成请求返回Response对象  
        .complete(function (c) {  
            //完成请求回调  
            //alert("获取用户信息完成！");  
        });  
})