$(function(){
	$("#btn_tx").click(function (){
		ConfirmPayment();
	})
	$('#accPaypass').focus(function(){
		$(this).val('')
	})
})

function ConfirmPayment(){
	var accPaypass = $("#accPaypass").val();
	var orderPrice = $("#orderPrice").text()!=""?$("#orderPrice").text().substring(0,$("#orderPrice").text().length):'';
	var orderNo = $("#orderNo").text();
	var serviceTitle = $("#title").html();
	accPaypass = $.md5(accPaypass);
	if(accPaypass == null || accPaypass == "请输入交易密码"){
		alert("请输入支付密码");
		return;
	}
	$.ajax({
		url:path+'/saleinfo/orderInfoBuyer/validate.html?flag='+flag,
		type:'post',
		dataType:'json',
		data:{
			'orderPrice':orderPrice,
			'accPaypass':accPaypass,
			'orderNo':orderNo,
			'serviceTitle':serviceTitle
		},
		success:function(res){
			if(res.success){
                alert(res.errorMsg,'',function () {
                    location.href=path+"/wap/saleinfo/orderInfoBuyer/orderView.html";
                });
            } else {
				alert(res.errorMsg);
			}
		}
	});
}
