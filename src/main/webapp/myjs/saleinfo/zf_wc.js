$(function(){
	$("#btn_tx").click(function (){
		ConfirmPayment();
		$("#btn_tx").unbind("click");
	})
})

function ConfirmPayment(){
	var accPaypass = $("#accPaypass").val();
	var orderPrice = $("#orderPrice").html().substr(1);
	var orderNo = $("#orderNo").html();
	var serviceTitle = $("#title").html();
	accPaypass = $.md5(accPaypass);
	if(accPaypass == null || accPaypass == "请输入交易密码"){
		alert("请输入支付密码");
		return;
	}
	$.ajax({
		url:path+'/saleinfo/orderInfoBuyer/validate.html?flag='+2,
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
				alert(res.errorMsg,"系统提示",function(){
					location.href=path+"/saleinfo/orderInfoBuyer/orderView.html";
				});
			} else {
				alert(res.errorMsg,"系统提示",function(){

				});
			}
		}
	});
}