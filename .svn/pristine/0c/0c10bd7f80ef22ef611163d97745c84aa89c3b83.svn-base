$(function(){
	//格式化日期
	var date = new Date();
	var times = $('.time');
	$(times).each(function(){
		date.setTime($(this).html());
		$(this).html(format(date));
	});
});

//格式化时间
function format(datetime){
	var year = datetime.getFullYear();
	var month = datetime.getMonth()+1;
	var day = datetime.getDate();
	var hours = datetime.getHours();
	var moiutes = datetime.getMinutes();
	var seconds = datetime.getSeconds();
	month = month<10?"0"+month:month;
	day = day<10?"0"+day:day;
	hours = hours<10?"0"+hours:hours;
	moiutes = moiutes<10?"0"+moiutes:moiutes;
	seconds = seconds<10?"0"+seconds:seconds;
	return year+"-"+month+"-"+day+" "+hours+":"+moiutes+":"+seconds;
}

//服务商同意约见
function agree(orderId,orderSeller){
	$("#sub").unbind("click");
	var orderObj = {
		"orderId":orderId,
		"orderSeller":orderSeller,
		//订单商品信息
		"orderService":getOrderService(false),
		"box":true
	};
	var order = JSON.stringify(orderObj);
	$.ajax({
		url:path+"/wap/saleinfo/order/provideCheck.html",
		type:"POST",
		dataType:"json",
		data:{
			"order":order
		},
		success:function(result){
			window.location.href=path+result.obj;
		}
	});
	
}

// 取消约见
function cancelOrder(){
	$.ajax({
		url:path+ '/saleinfo/order/cancelOrder.html',
		type:'post',
		dataType:'json',
		data:{
			'orderNo':orderNo
		},
		success:function(res){
			alert(res.errorMsg,"系统提示",function(){
				window.history.back(-1);
			});
		}
	});
}

/**
 * 获取订单商品信息
 * @param isbox 是否确认约见 true 确认 false 退回
 */
function getOrderService(isbox){
	var prices = $('.price');
	var points = $('.point');
	var orderServices = new Array();
	$('.fom').each(function(index){
		var orderService={}; 
		var $aaa= $(this).serializeArray();
		$.each($aaa , function() {
			orderService[this.name]=this.value; 
		});
		orderService.osPrice=$(prices[index]).html().trim();
		orderService.osPoint=0.1;
		orderServices[index]=orderService;
	});
	console.log(orderServices);
	return orderServices;
}

function returnedit(orderId,orderSeller){
	var orderRequest=null;
	var reqcontent = $('#orderRequest').val();
	var jsonstr = $('#parseArray').val();
	if(reqcontent!=null&&reqcontent!=''){
		var jsonArray = eval('('+jsonstr+')');
		var reqobj = {
				"type":1,
				"time":Date.parse(new Date()),
				"content":reqcontent,
				"sendId":orderSeller
		}
		
		jsonArray.push(reqobj);
		orderRequest = JSON.stringify(jsonArray);
	}
	console.log(orderRequest);
	
	var orderObj = {
			"orderId":orderId,
			"orderSeller":orderSeller,
			"orderRequest":orderRequest,
			//订单商品信息
			"orderService":getOrderService(false),
			"box":false
		};
		var order = JSON.stringify(orderObj);
		console.log(order);
		$.ajax({
			url:path+"/wap/saleinfo/order/provideCheck.html",
			type:"POST",
			dataType:"json",
			data:{
				"order":order
			},
			success:function(result){
				window.location.href=path+result.obj;
			}
		});
}