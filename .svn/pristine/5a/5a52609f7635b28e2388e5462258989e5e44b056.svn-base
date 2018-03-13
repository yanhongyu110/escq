var tag=1;
/**
 * 获取参数
 * 
 * @param name
 * @returns
 */
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return decodeURI(r[2]); return null; 
}
/**
 * 获取openid
 */
function getOpenId() {
	var redirect_uri = encodeURIComponent("http://www.jindaoj.com/wap/userinfo/getWeichatOpenId.htm");
	window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd0c763640d4b8f08&redirect_uri="
		+ redirect_uri
			+ "&response_type=code&scope=snsapi_base&state="
			+ encodeURIComponent("http://jindaoj.com/wap/saleinfo/orderInfoBuyer/getAccount.html?orderId="+getQueryString("orderId")) + "#wechat_redirect";
}

function getOpenIdOnCk() {
	var cookies = document.cookie.split(";");
	if (cookies != null) {
		for ( var i = 0; i < cookies.length; i++) {
			var cs = cookies[i].split("=");
			if (cs[0].trim() == "weichatOpenId") {
				return cs[1];
			}
		}
	}
	return null;
}
$(function (){
	$("#btn_tx").click(function(){
		btn();
	})
	// 第三方支付  支付判断
	$('.zf_fs ul li').click(function(){
		$(this).siblings().css({"border":" 2px solid #ddd"});
		$(this).css({"border":" 2px solid #FB5A5A"});
		tag =$(this).attr('tag');
	});
	$('.zf_hj_money li a').click(function(e){
		console.log($(this));
		$(this).unbind(e);
		if(tag=='1'){
			yuePay();
		}else if(tag=='2'){
			wxPay();
		}
		else if(tag=='3'){
			zfbPay();
		}
	});
	
});

function pd(){
	var orderPrice = $("#orderPrice").html().substr(1);
	var accBalance = $("#accBalance").html().substr(1);
	if(parseInt(accBalance) < parseInt(orderPrice)){
		$("#checkbox").attr("disabled","disabled");
	}
}

function payResult(currentOrderId,isSuccess){
	location.href = path+"/wap/saleinfo/orderInfoBuyer/orderView.html";
}

function btn(){
	if(!$("#checkbox").is(':checked')) {
		alert("请选择付款方式");
	} else {
		var accPaypass = $("#accPaypass").val();
		var orderPrice = $("#orderPrice").html().substr(1);
		var accBalance = $("#accBalance").html().substr(1);
		var orderNo = $("#orderNo").html();
		accPaypass = $.md5(accPaypass);
		if(accPaypass == null || accPaypass == "请输入交易密码"){
			alert("请输入支付密码");
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
					alert(res.errorMsg);
					location.href=path+"/saleinfo/orderInfoBuyer/orderView.html";
				} else {
					alert(res.errorMsg);
				}
			}
		});
	}
	
	
	
}



/*****************第三方支付 支付开始**************************/
function yuePay(){
	console.log("余额"+orderNo);
	if(parseFloat(accBalance) < parseFloat($("#orderPrice").html())){
		alert("余额不足")
	} else {
        location.href=path+"/wap/saleinfo/orderInfoBuyer/ConfirmPayment.html?orderNo="+orderNo+"&flag=1";
    }
}

function wxPay(){
	var ua = navigator.userAgent.toLowerCase(); 
	if(ua.match(/MicroMessenger/i)=="micromessenger") { //微信公众号网页支付
//	if(true) { //微信公众号网页支付
//		var openId = getOpenIdOnCk();
		var openId = "o5tP4v2sRruivGVkBPjL5zvWQQnw";
//		alert(openId);
//		if(openId == null || openId.length == 0){
//			getOpenId();
//			return;
//		}
		var body='近到家微信支付';
		$.ajax({
			type : 'get',
			dataType : 'json',
			url : path+'/wap/saleinfo/wxPay.html',
			data:{
				openId:openId,
		        money:$("#orderPrice").html(),
//		        money:1,
		        body:body,
		        orderNo:orderNo,
			},
			success : function(msg){
				if(msg.success){
					var appid = msg.obj.appId;
					var prepayid = msg.obj.prepay_id;
					var nonce_str = msg.obj.nonceStr;
					var timestamp = msg.obj.timeStamp;
					var sign = msg.obj.paySign;
					var packageStr = msg.obj.packageStr;
					WeixinJSBridge.invoke('getBrandWCPayRequest', {
						"appId" : appid, // 公众号名称，由商户传入
						"timeStamp" : timestamp, // 时间戳，自1970年以来的秒数
						"nonceStr" : nonce_str, // 随机串
						"package" : packageStr,
						"signType" : "MD5", // 微信签名方式：
						"paySign" : sign // 微信签名
					}, function(res) {
						if (res.err_msg == "get_brand_wcpay_request:ok") {
//		                    location.href=path+"/wap/saleinfo/orderInfoBuyer/orderView.html";
//							window.location.href="wallet.html";
						} // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回
							// ok，但并不保证它绝对可靠。
					});
				}
			}
		});
	}else{
		console.log("微信"+orderId);
		var ua = navigator.userAgent.toLowerCase();	
		if (/iphone|ipad|ipod/.test(ua)) {
			share(orderId,"1","wx");			
		} else if (/android/.test(ua)) {
			window.android.submitPay(orderId,"1");
			console.log(orderId);
		}
	}
	//location.href=path+"/wap/saleinfo/orderInfoBuyer/orderView.html";
	
}
function zfbPay(){
	console.log("支付宝"+orderId);
	var ua = navigator.userAgent.toLowerCase();	
	if (/iphone|ipad|ipod/.test(ua)) {
		share(orderId,"2","zfb");	
	} else if (/android/.test(ua)) {
		window.android.submitPay(orderId,"2");
	}
	//location.href=path+"/wap/saleinfo/orderInfoBuyer/orderView.html";
	
}
/*****************第三方支付 支付结束**************************/


