
$(function(){
	
})



function refundconfirm(flag){
	$(".submit1").unbind("click");
	var orderNo = $('#orderNo').val();
	var orderSellerrepaycontent = $('#sellerrepaycontent').val();
	var json = JSON.stringify({
		"isAgree":flag,
		"orderNo":orderNo,
		"orderSellerrepaycontent":orderSellerrepaycontent
	});
	if(flag){
		//同意退款
		refundAJAX(json);
	}else{
		//不同意退款
		if(orderSellerrepaycontent!=null && orderSellerrepaycontent != ''){
			refundAJAX(json);
		}else{
			$('#sellerrepaycontentMsg').css({"color":"red"});
			$('#sellerrepaycontentMsg').html(' ✖ 请说明不同意的理由哦^_^');
			$('#sellerrepaycontentMsg').focus();
		}
	}
}

function refundAJAX(json){
	$.ajax({
		url:path+"/saleinfo/orderInfoSeller/refundConfirm.html",
		type:"POST",
		dataType:"json",
		data:{
			"json":json
		},
		success:function(data){
			console.log(data.url);
			window.location.href = path+data.url;
		}
	});
}