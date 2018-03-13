$(function (){
	pd();
	$("#btn_tx").click(function(){
		btn();
		$('#btn_tx').unbind("click"); //移除click
	});
	// 第三方支付  支付判断
	$("#my_zh_list_txd ul li").click(function(){
		//console.log($(this).attr('tag'));
		var tag =$(this).attr('tag');
		if(tag=='1'){
			zfbPay();
		}else if(tag=='2'){
			wxPay();
		}else{
			$(this).siblings().hide();
			$("a.cancel_jdpay").show();
			jdPay();
		}
	});
	
	// 如果选择京东支付的 时候  取消按钮就显示  并且绑定 取消的点击事件
	$("a.cancel_jdpay").on("click",function(){
		
		$("#bank_list").hide();
		$("#my_zh_list_txd ul li").each(function(){
			if($(this).is(":hidden")){
				$(this).show();
			}
		});
		$(this).hide();
	});
	
	// 给每一个银行的接口 图标添加点击事件
	$("#bank_list ul li").on("click",function(){
		jdPay();
	});
	
});

function pd(){
	var orderPrice = parseFloat($("#orderPrice").html().substr(1));
	var accBalance = parseFloat($("#accBalance").html().substr(1));
	if(accBalance < orderPrice){
		$("#checkbox").attr("disabled","disabled");
	}
}

function btn(){
	if(!$("#checkbox").is(':checked')) {
		alert('请选择付款方式',"系统提示",function(){
			
		});
	} else {
		var accPaypass = $("#accPaypass").val();
		var orderPrice = $("#orderPrice").html().substr(1);
		var accBalance = $("#accBalance").html().substr(1);
		var orderNo = $("#orderNo").html();
		accPaypass = $.md5(accPaypass);
		if(accPaypass == null || accPaypass == "请输入交易密码"){
			alert('请输入支付密码',"系统提示",function(){
				
			});
			return;
		}
		$.ajax({
			url:path+'/saleinfo/orderInfoBuyer/validate.html?flag='+1,
			type:'post',
			dataType:'json',
			data:{
				'orderPrice':orderPrice,
				'accBalance':accBalance,
				'accPaypass':accPaypass,
				'orderNo':orderNo
			},
			success:function(res){
				if(res.success){
					alert(res.errorMsg,"系统提示",function(){
						location.href=path+"/saleinfo/orderInfoBuyer/orderView.html";
					});
				} else {
					alert(res.errorMsg);
				}
			}
		});
	}
	
	
	
}



/*****************第三方支付 支付开始**************************/
function zfbPay(){
	console.log("支付宝"+$("#orderNumber").val());
	location.href=path+"/pay/alipay/paystart.html?orderId="+$("#orderId").val()+"&orderNo="+$("#orderNumber").val();
}

function wxPay(){
	console.log("微信"+$("#orderId").val());
	location.href=path+"/pay/wxpay/paystart.html?orderId="+$("#orderId").val()+"&orderNo="+$("#orderNumber").val();
}


function jdPay(){
	
	if($("#bank_list").is(":hidden")){ // 表示当前的银行列表 隐藏了
		// 只需要 显示  银行列表  既可
		$("#bank_list").show(500);
		return;
	}
	//console.log("京东"+$("#orderId").val());
	//  确认 有一个银行被选择 
	var bankCode=$('input:radio[name="bank"]:checked').val();
	if(bankCode==null || bankCode==undefined){
		//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
		alert("请选择一个银行");
		return;
	}
	//  构造响应的网络地址
	location.href=path+"/pay/jdpay/paystart.html?orderId="+$("#orderId").val()+"&orderNo="+$("#orderNumber").val()+"&bankNo="+bankCode;
	
}
/*****************第三方支付 支付结束**************************/


