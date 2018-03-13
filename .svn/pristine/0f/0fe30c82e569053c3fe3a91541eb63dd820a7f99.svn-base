var date = new Date();
var nameRegx = /^[\u4e00-\u9fa5]{2,4}$/;
//var cellRegx = /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/;//验证手机
var cellRegx = /^1[34578]\d{9}$/;//验证手机
var emptyRegx = /\S/;
var orderPersonIsSuccess = true;
var orderPersoncellIsSuccess = true;
var orderBilladdrIsEmpty = true;
var orderAreaIsEmpty = true;
var orderAddrIsEmpty = true;

function regx(r,s){
	if (r == null || r == ""){
		return false;
	}
	var patrn= new RegExp(r);
	if (patrn.exec(s))
		return true
		return false
}

$(function(){
	var isbill = $('#orderIsbill').val();
	if(isbill){
		invoice();
		$('input[name=orderIsbill]:odd').attr({"checked":"true"});
		$('input[name=orderIsbill]:even').attr({"checked":"true"});
	}
	
	$('#orderPerson').blur(function(){
		orderPersonIsSuccess = regx(nameRegx,$('#orderPerson').val());
		if(!orderPersonIsSuccess){
			$('#orderPersonicon').css({"color":"red"});
			$('#orderPersonicon').html(' ✖ 姓名非法');
		}else{
			$('#orderPersonicon').css({"color":"green"});
			$('#orderPersonicon').html(' ✔ ');
		}
	});
	$('#orderPersoncell').blur(function(){
		orderPersoncellIsSuccess = regx(cellRegx,$('#orderPersoncell').val());
		if(!orderPersoncellIsSuccess){
			$('#orderPersoncellicon').css({"color":"red"});
			$('#orderPersoncellicon').html(' ✖ 非法号码');
		}else{
			$('#orderPersoncellicon').css({"color":"green"});
			$('#orderPersoncellicon').html(' ✔ ');
		}
	});
	$('#orderArea').blur(function(){
		orderAreaIsEmpty = regx(emptyRegx,$('#orderArea').val());
		if(!orderAreaIsEmpty){
			$('#orderAreaicon').css({"color":"red"});
			$('#orderAreaicon').html(' ✖ 区域为空');
		}else{
			$('#orderAreaicon').css({"color":"green"});
			$('#orderAreaicon').html(' ✔ ');
		}
	});
	$('#orderAddr').blur(function(){
		orderAddrIsEmpty = regx(emptyRegx,$('#orderAddr').val());
		if(!orderAddrIsEmpty){
			$('#orderAddricon').css({"color":"red"});
			$('#orderAddricon').html(' ✖ 地点为空');
		}else{
			$('#orderAddricon').css({"color":"green"});
			$('#orderAddricon').html(' ✔ ');
		}
	});
	$('#orderBilladdr').blur(function(){
		orderBilladdrIsEmpty = regx(emptyRegx,$('#orderBilladdr').val());
		if(!orderBilladdrIsEmpty){
			$('#orderBilladdricon').css({"color":"red"});
			$('#orderBilladdricon').html(' ✖ 地址为空');
		}else{
			$('#orderBilladdricon').css({"color":"green"});
			$('#orderBilladdricon').html(' ✔ ');
		}
	});
	
	//限定长度
	$('.my_date_title>h3').each(function(){
		$(this).html($(this).html().length>10?$(this).html().substring(0,10)+'...':$(this).html());
	});
	
	$('#orderMeettime').datetimebox({
		value: $('#orderMeettime').val(),
	    required: true,
	    height:40,
	    editable:false,
	    showSeconds: false
	});
	$('.textbox-addon>a').remove();
	$('.textbox-text').css({"padding-left":"0","font-size":"14px"});
	$('.datebox').css({"border":"0"});
	//格式化日期
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


function invoice(){
	$('#address').css({"display":"block"});
	$('#describe').css({"display":"block"});
}
function noinvoice(){
	$('#address').css({"display":"none"});
	$('#describe').css({"display":"none"});
}

function reset(){
	$("#orderMeettime").val('');
	$("#orderArea").val('');
	$("#orderAddr").val('');
	$("#orderPerson").val('');
	$("#orderPersoncell").val('');
	$("#orderRequest").val('');
	$($('input[name=orderIsbill]')[1]).attr({'checked':"checked"});
	$("#orderBilladdr").val('');
	$("#orderBillcontent").val('');
}
$('.textbox-icon').css({"width":"30px"});
$('.textbox').css({"border-radius":"0px"});

function submit(){
	if(orderPersonIsSuccess){
		if(orderAreaIsEmpty){
			if(orderAddrIsEmpty){
				if(orderPersoncell){
					var orderJson = orderJsondata();
					var isbill = JSON.parse(orderJson).orderIsbill;
					if((isbill==1 && orderBilladdrIsEmpty) || isbill==0 ){
						$.ajax({
							url:path+"/wap/saleinfo/order/userModifyOrder.html",
							type:"POST",
							dataType:"json",
							data:{
								"order":orderJson
							},
							success:function(result){
								console.log(result);
								if(result.success){
									window.location.href=path+result.obj;
								}else{
									alert(result.errorMsg);
								}
							}
						});
					}else{
						$('#orderBilladdricon').css({"color":"red"});
						$('#orderBilladdricon').html(' ✖ 地址为空');
						$('#orderBilladdr').focus();
					}
				}else{
					$('#orderPersoncellicon').css({"color":"red"});
					$('#orderPersoncellicon').html(' ✖ 非法号码');
					$('#orderPersoncell').focus();
				}
			}else{
				$('#orderAddricon').css({"color":"red"});
				$('#orderAddricon').html(' ✖ 地点为空');
				$('#orderAddr').focus();
			}
		}else{
			$('#orderAreaicon').css({"color":"red"});
			$('#orderAreaicon').html(' ✖ 区域为空');
			$('#orderArea').focus();
		}
	}else{
		$('#orderPersonicon').css({"color":"red"});
		$('#orderPersonicon').html(' ✖ 姓名非法');
		$('#orderPerson').focus();
	}
}



function orderJsondata(){
	var orderId = $('#orderId').val();
	var orderMeettime = $("#orderMeettime").datetimebox('getValue');
	var orderArea = $("#orderArea").val();
	var orderAddr = $("#orderAddr").val();
	var orderPerson = $("#orderPerson").val();
	var orderPersoncell = $("#orderPersoncell").val();
	var orderSeller = $('#orderSeller').val();
	var orderBuyer = $('#orderBuyer').val();
	var orderRequest=null;
	var orderIsbill = parseInt($('input[name=orderIsbill]:checked').val());
	var orderBilladdr = null;
	var orderBillcontent = null;
	if(orderIsbill==1){
		orderBilladdr = $("#orderBilladdr").val();
		orderBillcontent = $("#orderBillcontent").val();
	}
	
	var reqcontent = $('#orderRequest').val();
	var jsonstr = $('#parseArray').val();
	if(reqcontent!=null&&reqcontent!=''){
		var jsonArray = eval('('+jsonstr+')');
		var reqobj = {
				"type":0,
				"time":Date.parse(new Date()),
				"content":reqcontent,
				"sendId":orderBuyer
		}
		
		jsonArray.push(reqobj);
		orderRequest = JSON.stringify(jsonArray);
	}
	
	var orderObject = {
			"orderId":orderId,
			"orderMeettime":orderMeettime,
			"orderArea":orderArea,
			"orderAddr":orderAddr,
			"orderPerson":orderPerson,
			"orderPersoncell":orderPersoncell,
			"orderRequest":orderRequest,
			"orderIsbill":orderIsbill,
			"orderBilladdr":orderBilladdr,
			"orderBuyer":orderBuyer,
			"orderSeller":orderSeller,
			"orderBillcontent":orderBillcontent
	};
	
	console.log(JSON.stringify(orderObject));
	return JSON.stringify(orderObject);
}