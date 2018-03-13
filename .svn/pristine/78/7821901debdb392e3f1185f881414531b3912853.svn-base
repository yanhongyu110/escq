$(function(){
	//限定长度
	var fwTitle = $(".fw_pj_title span");
	$(fwTitle).each(function(){
		$(this).css({'color':'black'});
		$(this).html($(this).html().length>16?$(this).html().substring(0,16)+'...':$(this).html());
	});
	
	var zprice = $('#refundprice').val();
	$('#refundprice').blur(function(){
		var refundprice = $('#refundprice').val();
		if(refundprice>zprice){
			$('#refundprice').val(zprice);
		}
		$('#refundprice').attr({"disabled":true});
		$('#refundprice').css({"border":"0px"});
	});
});

//修改价格
function pricemodify(){
	$('#refundprice').css({"border":"1px solid #ddd","border-radius":"3px"});
	$('#refundprice').attr({"disabled":false});
	$('#refundprice').focus();
}

function applyrefund(){
	var orderNo = $('#orderNo').val();
	$.ajax({
		url:path+"/wap/saleinfo/orderInfoBuyer/queryState.html",
		type:"POST",
		dataType:"text",
		data:{
			"id":orderNo
		},
		success:function(data){
			console.log(data);
			if(data=="no"){
				var orderRefundprice = $('#refundprice').val();
				var orderBuyerrepaycontent = $('#buyerrepaycontent').val();
				if(orderBuyerrepaycontent!=null&&orderBuyerrepaycontent!=''){
					var orderObj = {
							"orderNo":orderNo,
							"orderRefundprice":orderRefundprice,
							"orderBuyerrepaycontent":orderBuyerrepaycontent
					}
					var orderJson = JSON.stringify(orderObj);
					$.ajax({
						url:path+"/wap/saleinfo/orderInfoBuyer/buyerApplyRefund.html",
						type:"POST",
						dataType:"json",
						data:{
							"orderJson":orderJson
						},
						success:function(data){
							console.log(data.url);
							window.location.href = path+data.url;
						}
						
					});
				}else{
					alert(' ✖ 请说明退款理由哦^_^');
//					$('#buyerrepaycontentMsg').css({"color":"red"});
//					$('#buyerrepaycontentMsg').html(' ✖ 请说明退款理由哦^_^');
//					$('#buyerrepaycontentMsg').focus();
				}
			}else{
				alert("你已经申请过了!");
			}
		}
	});
	
}


function reset(){
	history.go(-1);
}
/*function queryState(id){
	$.ajax({
		url:path+"/saleinfo/orderInfoBuyer/queryState.html",
		type:"POST",
		dataType:"text",
		data:{
			"id":id
		},
		success:function(data){
			return data;
		}
		
	});
}*/
