var pages = 1;
var state;
var orderTd1;//标号或标题
var orderStarttime1;
var orderEndtime1;
var orderIsbill1;
var fg;
var id;
var items = [];
var rows = 5;
var num;
//   falg = 0 (无条件查询) 1 (带状态查询) 2 (跳页查询) 3 (检索查询)
$(function(){
	$("#doSearch").click(function(){
		doSearch();
	})
	$('#startTime').datetimebox({
	    required: true,
	    height:"33",
	    
	    editable:false,
	    showSeconds: false
	});
	$('.textbox-icon').css({"width":"38px"});
	$('.textbox').css({"border-radius":"0px"});
	
	$('#endTime').datetimebox({
	    required: true,
	    height:"33",
	    
	    editable:false,
	    showSeconds: false
	});
	$('.textbox-icon').css({"width":"38px"});
	$('.textbox').css({"border-radius":"0px"});
	initOrderInfoSellerPage();
	
})

//确认订单
function confirmOrder(orderNo){
	window.location.href=path+"/saleinfo/order/viewProviderConfirm.html?orderNo="+orderNo+'&comId='+g_comid;
}   
///跳详情
function getDetail(orderId){
	window.location.href=path+"/saleinfo/orderInfoSeller/orderViewDetail.html?orderId="+orderId+'&comId='+g_comid;
	}
//确认提款
function confirmRefund(orderNo){
	window.location.href=path+"/saleinfo/orderInfoSeller/viewExpertConfirm.html?orderNo="+orderNo+'&comId='+g_comid;
}
//退款详情
function refundDetail(orderNo){
	window.location.href=path+"/saleinfo/orderInfoBuyer/viewRefunddetails.html?orderNo="+orderNo+'&comId='+g_comid;
}

//打开精确搜索
function openDosearch(){
	if(fg != true){
		fg = true
	}else{
	fg = false;
	clearFrm();
	}
}
//搜索
function doSearch(){
	 orderTd1 = $("#orderTd").val();
	 if(fg){
		 orderStarttime1 = $("#startTime").datebox('getValue');
		 orderEndtime1 = $("#endTime").datebox('getValue');
		 orderIsbill1 = $("#orderIsbill").combobox('getValue');
		 state = $("#orderState").combobox('getValue');
	 }
	 askAjax(3)
}
//初始化页面，查询所有数据
function initOrderInfoSellerPage(){
	askAjax(0);	
}

//根据状态查询数据
function orderState(states){
	$(".saixuan_lei").css('display','none');
	state = states;
	askAjax(1);
}

function getQueryById(i){
	getDetail(items[i].orderId);
}

function getDeleteId(i){
	deleteOrder(items[i].orderNo);
}

function deleteOrder(orderId){
	$.ajax({
		type:'POST',
		url:path+"/saleinfo/order/cancelOrder.html",
		dataType:'json',
		data:{
			'orderNo':orderId
		},
		success:function(result){
			if(result.success){
				alert(result.errorMsg,"系统提示",function(){
					window.location.reload();
				});
			}
		}
		
	})
}

function selectCommonAjax(currentPage){
	pages = currentPage;
	askAjax(2);
}
function askAjax(falg){
	var orderId = null;
	var orderState = null;
	var orderTd = null;
	var orderStarttime = null;
	var orderEndtime = null;
	var orderIsbill = null;
	if(falg == 0){
		page = 1;
	}else if(falg == 1){
		orderState = state;
		page = 1;
	}else if(falg == 2){
		page = pages;
		orderState = state;
	}else if(falg == 3){
		page = 1;
		orderState = state;
		orderTd = orderTd1;
		orderStarttime = orderStarttime1;
		orderEndtime = orderEndtime1;
		orderIsbill = orderIsbill1;
	}
		$.ajax({
			type:'post',
			url:path+"/saleinfo/orderInfoSeller/queryOrder.html",
			dataType:"json",
			data:$.param({
				'rows':rows,
				'page':page,
				'orderId':orderId,
				'orderState':orderState,
				'orderStarttime':orderStarttime,
				'orderEndtime':orderEndtime,
				'orderIsbill':orderIsbill,
				'osServiceTitle':orderTd
			},true),
			success:function(result){
				showOrder(result.rows);
				pageNum(result.total,rows,page,"pagediv");
				
			}
	})
	
	
}

function showOrder(orderList){
	ids = [];
	items = []; 
	$("#pe_dan_lists").empty();
	$.each(orderList,function(i,item){
		var str = '';
		var st = '';
		ids.push(item.orderId);
		items.push(item);
		num++;
		str	 =  str + ' <div class="pe_dan_list"><table cellpadding="0" cellspacing="0" >' 
					+'<tr>'
					+'	<td width="62%"><input type="checkbox" name="" id="" value="" /><b>'+item.orderCreatetimestr+'</b>订单号：'+item.orderNo+'</td>'
					+'	<td width="15%"></td>'
					+'	<td width="11%"></td>'
					+'  <td width="12%" align="center" class="delete_s"> </td>'
					/*if(item.orderState < 3){
		str  =  str +'	<a onclick="getDeleteId('+i+')"><img src="'+path+'/images/delate.png"></a>'
					}
					+'</td>'*/
		str = str +'	</tr><tr><td width="63%" >'
		$.each(item.orderService,function(n,m){
				var sersInfo = eval('(' + m.sersInfo + ')');
				str = str	+'		<div class="title_img_dd">'
						+'			<ul>'
						+'				<li><img src="'+localhostPath+sersInfo.servicePic+'" width="112" ></li>'
						+'				<li class="dingdan" style="width:170px">'+cutStr(sersInfo.serviceTitle)+'<br>'+cutStr(item.orderArea+item.orderAddr)+'<br><span>约见'+sersInfo.serviceMeettime+'小时</span></li>'
						+'				<li class="danjia" style="width:70px;">￥'+m.osPrice+'</li>'
						+'				<li class="shuliang" style="width:50px;line-height: 78px;">1</li>'
						+'			</ul>'
						+'		</div>'
				if(item.orderState>4){
					st = st +'		<div class="title_img_dd"><a class="pingjia" href="'+path+'/goodsinfo/remark/viewRemark.html?id='+m.osId+'&comId='+g_comid+'">评价详情</a></div>'
				}
			})	
			str = str +'</td><td width="15%" align="center">'+stateToString(item.orderState)+'<br><a onclick="getQueryById('+i+')">查看详情</a>'+serConfirm(item.orderState,item.orderNo)+refundstate(item.orderRefundstate,item.orderRefundstateStr,item.orderNo)+'</td>'
			+'<td width="11%" align="center" class="zongjia">￥'+item.orderPrice+'</td>'
			+'<td width="12%" align="center">'+st+'</td>'
		+'</tr>'
	+'</table></div>'	
	$("#pe_dan_lists").append(str);
	})
	
}

function stateToString(orderState){
	var stateStr
	$.ajax({
		type:'POST',
		url:path+"/saleinfo/orderInfoSeller/getStateStr.html",
		cache: false, 
		async: false, 
		data:{
			'orderState':orderState,
		},
		
		dataType:'json',
		success:function(result){
			stateStr = result;
		}
	})
		
		return stateStr.replace('"','');
}

function cutStr(abstr){
	if(abstr != undefined){
		var str = abstr ; 
		if(abstr.length >12){
			abstr = str.substring(0,9)+"...";
		}
	}
	return abstr;
}

function clearFrm(){
	 $("#startTime").datebox('setValue','');
	 $("#endTime").datebox('setValue','');
	 $("#orderIsbill").combobox("setValues",'');
	 $("#orderState").combobox("setValues",'');
	
	
}

function serConfirm(state,oid){
	var tab = "";
	var odid = "'"+oid+"'";
	if(state == 0){
		tab = '<br/><a onclick="confirmOrder('+odid+')">服务商确认</a>';
	}
	return tab;
}

function refundstate(state, v, odNo){
	var tab = "";
	var odid = "'"+odNo+"'";
	if(state > 0){
		if(state == 1){
			tab = '<br><a onclick="confirmRefund('+odid+')">专家确认退款</a>';
		} else if(state == 6){
			tab += '<br>已申请平台介入';
		} else if(state == 4 || state == 5){
			tab += '<br>退款完成';
		}
		tab += '<br><a onclick="refundDetail('+odid+')">退款详情</a>';
	}
	return tab;
}
$('.textbox-icon').css({"width":"38px"});
 $('.textbox').css({"border-radius":"0px"});

