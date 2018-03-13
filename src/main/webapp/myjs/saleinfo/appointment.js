var date = new Date();
var nameRegx = /^[\u4e00-\u9fa5]{2,4}$/;
//var cellRegx = /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/;//验证手机
var cellRegx = /^1[34578]\d{9}$/;//验证手机
var emptyRegx = /\S/;
var orderPersonIsSuccess;
var orderPersoncellIsSuccess;
var orderBilladdrIsEmpty;

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
	$('#orderPerson').blur(function(){
		orderPersonIsSuccess = regx(nameRegx,$('#orderPerson').val());
		if(!orderPersonIsSuccess){
			$('#orderPersonicon').css({"color":"red"});
			$('#orderPersonicon').html(' ✖ 您输入的姓名有误^_^');
		}else{
			$('#orderPersonicon').css({"color":"green"});
			$('#orderPersonicon').html(' ✔ ');
		}
	});
	$('#orderPersoncell').blur(function(){
		orderPersoncellIsSuccess = regx(cellRegx,$('#orderPersoncell').val());
		if(!orderPersoncellIsSuccess){
			$('#orderPersoncellicon').css({"color":"red"});
			$('#orderPersoncellicon').html(' ✖ 您输入的联系方式有误^_^');
		}else{
			$('#orderPersoncellicon').css({"color":"green"});
			$('#orderPersoncellicon').html(' ✔ ');
		}
	});
	$('#orderBilladdr').blur(function(){
		orderBilladdrIsEmpty = regx(emptyRegx,$('#orderBilladdr').val());
		if(!orderBilladdrIsEmpty){
			$('#orderBilladdricon').css({"color":"red"});
			$('#orderBilladdricon').html(' ✖ 请输入发票地址^_^');
		}else{
			$('#orderBilladdricon').css({"color":"green"});
			$('#orderBilladdricon').html(' ✔ ');
		}
	});
	
	//限定长度
	var fwTitle = $(".fw_pj_title span");
	$(fwTitle).each(function(){
		$(this).css({'color':'black'});
		$(this).html($(this).html().length>16?$(this).html().substring(0,16)+'...':$(this).html());
	});
	$('#orderMeettime').datetimebox({
		value: date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes(),
	    required: true,
	    height:40,
	    editable:false,
	    showSeconds: false
	});
	$('.textbox-icon').css({"width":"38px"});
	$('.textbox').css({"border-radius":"0px"});
	
});

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
	window.history.back(-1);
}

var flag_z = true;
function submit(){
	if(flag_z){
		flag_z = false;
		if(orderPersonIsSuccess){
			if(orderPersoncell){
				var cartList = cartListdata();
				var orderJson = orderJsondata();
				var isbill = JSON.parse(orderJson).orderIsbill;
				if((isbill==1 && orderBilladdrIsEmpty) || isbill==0 ){
					$.ajax({
						url:path+"/saleinfo/order/addOrder.html",
						type:"POST",
						dataType:"json",
						data:{
							"cartList":cartList,
							"orderJson":orderJson
						},
						success:function(result){
							if(result.success){
								flag_z = true;
								window.location.href=path+result.obj;
							}else{
								flag_z = true;
								alert(result.errorMsg);
							}
						}
					});
				}else{
					$('#orderBilladdricon').css({"color":"red"});
					$('#orderBilladdricon').html(' ✖ 请输入发票地址^_^');
					$('#orderBilladdr').focus();	
					flag_z = true;
				}
			}else{
				$('#orderPersoncellicon').css({"color":"red"});
				$('#orderPersoncellicon').html(' ✖ 您输入的联系方式有误^_^');
				$('#orderPersoncell').focus();
				flag_z = true;
			}
		}else{
			$('#orderPersonicon').css({"color":"red"});
			$('#orderPersonicon').html(' ✖ 您输入的姓名有误^_^');
			$('#orderPerson').focus();
			flag_z = true;
		}
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