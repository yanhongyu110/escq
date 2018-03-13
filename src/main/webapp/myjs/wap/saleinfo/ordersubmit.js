var date = new Date();
var nameRegx = /^[\u4e00-\u9fa5]{2,4}$/;
var cellRegx = /^1[34578]\d{9}$/;//验证手机
var emptyRegx = /\S/;
var orderPersonIsSuccess;
var orderPersoncellIsSuccess;
var orderAreaIsEmpty;
var orderAddrIsEmpty;
var orderBilladdrIsEmpty;

$(function(){
	$('.my_date_title>h3').each(function(){
		$(this).html($(this).html().length>10?$(this).html().substring(0,10)+'...':$(this).html());
	});
	
	$('#orderMeettime').datetimebox({
		value: date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes(),
	    required: true,
	    editable:false,
	    border:false,
	    showSeconds: false
	});
	$('.textbox-addon>a').remove();
	$('.textbox-text').css({"padding-left":"0","font-size":"14px"});
	$('.datebox').css({"border":"0"});
	
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
	
	
});

function regx(r,s){
	if (r == null || r == ""){
		return false;
	}
	var patrn= new RegExp(r);
	if (patrn.exec(s))
		return true
		return false
}

function invoice(){
	$('#address').css({"display":"block"});
	$('#describe').css({"display":"block"});
}
function noinvoice(){
	$('#address').css({"display":"none"});
	$('#describe').css({"display":"none"});
}

function submit(){
	$("#sub").unbind("click");
	if(orderPersonIsSuccess){
		if(orderAreaIsEmpty){
			if(orderAddrIsEmpty){
				if(orderPersoncellIsSuccess){
					var cartList = cartListdata();
					var orderJson = orderJsondata();
					console.log(cartList);
					console.log(orderJson);
					console.log(path);
					var isbill = JSON.parse(orderJson).orderIsbill;
					if((isbill==1 && orderBilladdrIsEmpty) || isbill==0 ){
						$.ajax({
							url:path+"/wap/saleinfo/order/addOrder.html",
							type:"POST",
							dataType:"json",
							data:{
								"cartList":cartList,
								"orderJson":orderJson
							},
							success:function(result){
								if(result.success){
									window.location.href=path+result.obj;
								}else{
									alert(result.obj);
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


function cartListdata(){
	var serviceIds = $(".serviceId");
	var scartNums = $(".scartNum");
	var scartSources = $(".scartSource");
	var cartObjects = new Array();
	for(var i=0;i<serviceIds.length;i++){
		var cartObject = {
				"serviceId":$(serviceIds[i]).val(),
				"scartNum":parseInt($(scartNums[i]).val()),
				"scartSource":$(scartSources[i]).val()
		};
		cartObjects[i]=cartObject;
	}
	return JSON.stringify(cartObjects);
}

function orderJsondata(){
	var orderMeettime = $("#orderMeettime").datetimebox('getValue');
	var orderArea = $("#orderArea").val();
	var orderAddr = $("#orderAddr").val();
	var orderPerson = $("#orderPerson").val();
	var orderPersoncell = $("#orderPersoncell").val();
	var orderRequest = $("#orderRequest").val();
	var orderIsbill = parseInt($('input[name=orderIsbill]:checked').val());
	var orderBilladdr = null;
	var orderBillcontent = null;
	if(orderIsbill==1){
		orderBilladdr = $("#orderBilladdr").val();
		orderBillcontent = $("#orderBillcontent").val();
	}
	var orderObject = {
			"orderMeettime":orderMeettime,
			"orderArea":orderArea,
			"orderAddr":orderAddr,
			"orderPerson":orderPerson,
			"orderPersoncell":orderPersoncell,
			"orderRequest":orderRequest,
			"orderIsbill":orderIsbill,
			"orderBilladdr":orderBilladdr,
			"orderBillcontent":orderBillcontent
	};
	
	return JSON.stringify(orderObject);
}