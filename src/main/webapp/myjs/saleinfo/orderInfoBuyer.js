$(function(){
	$("#li1").click(function(){
		cl();
		sub();
	});
	$("#li2").click(function(){
		cl();
		sub(0);
	});
	$("#li3").click(function(){
		cl();
		sub(2);
	});
	$("#li4").click(function(){
		cl();
		sub(4);
	});
	$("#li5").click(function(){
		cl();
		sub(5);
	});
	$("#li6").click(function(){
		cl();
		sub(6);
	});
	selectCommonAjax(1);
	$('#startDate').datetimebox({
	    required: true,
	    height:33,
	    editable:false,
	    showSeconds: false,
	    
	    
	});
	$('.textbox-icon').css({"width":"38px"});
	$('.textbox').css({"border-radius":"0px"});
	
	$('#endDate').datetimebox({
	    required: true,
	    height:33,
	    editable:false,
	    showSeconds: false
	});
	
	
	$('.textbox-icon').css({"width":"38px"});
	$('.textbox').css({"border-radius":"0px"});
});

/*function pageNum(totalPage,pageNo,pageDiv){
	var addHtml = '';//要显示的内容
	var pageNumSize = 5;//表示最多一页显示多少条页码号
	var pageNo = pageNo; //表示当前的页数
	var totalPages = totalPage; //表示一共要显示多少页的数据
	var startPageNo =  '';
	var endPageNo = '';
	$('#'+pageDiv).html('');
	if(pageNo % pageNumSize == 0){
		startPageNo = (pageNo - pageNumSize) + 1;
		endPageNo = pageNo;
	}else{
		startPageNo = (Math.floor((pageNo/pageNumSize)))*pageNumSize + 1;//开始页码数
		endPageNo = (Math.floor((pageNo + pageNumSize - 1)/pageNumSize))*pageNumSize;//结束页码数
	}
    if(totalPage != 0){
    	addHtml = '<a href="javascript:void(0)" onclick="selectCommonAjax(1)">首页</a><a href="javascript:void(0)" onclick="selectCommonAjax('+(pageNo-1)+'<1?1:'+(pageNo-1)+')">上一页</a>';
    	for(var i= startPageNo;i<=(endPageNo > totalPages ? totalPages : endPageNo);i++) {
    		if(i == pageNo){
    			addHtml += '<a href="javascript:void(0)" style="background-color:#00ffe7" class="x_xzxg" onclick="selectCommonAjax('+i+')">'+i+'</a>';
    		}else{
    			addHtml += '<a href="javascript:void(0)" onclick="selectCommonAjax('+i+')">'+i+'</a>';
    		}
    	}
    	addHtml+= '<a href="javascript:void(0)" onclick="selectCommonAjax('+(pageNo+1)+'>'+totalPage+'?'+totalPage+':'+(pageNo+1)+')">下一页</a><a href="javascript:void(0)" onclick="selectCommonAjax('+totalPage+')">最后页</a>' 
    	          +'<span class="x_tiao"><em>共'+totalPages+'页</em>跳至<span class="x_ip"><input style="width: 30px;height:25px;margin-left:5px;padding:0;" type="text" value="'+pageNo+'" id="pagevalue"/></span>'
    	          +'<span class="x_goo"><input style="width: 30px;height:25px;margin-left:5px;padding:0;border:0;" type="button" value="go" onclick="selectCommonAjax($(\'#pagevalue\').val())"/></span></span>';
    	$('#'+pageDiv).html(addHtml);
    }
}*/
var orderState = null;
function selectCommonAjax(no){
	$.ajax({
		url:path+'/saleinfo/orderInfoBuyer/getAllOrder.html?page='+no,
		type:'post',
		dataType:'json',
		data:{
			"orderState":orderState
		},
		success:function(res){
			if(res!=null){
				fy(res,no);
			}
		}
	});
	
}

var addH = "";
function sh(order){
	$("#pe_dan_list table").remove();
	addH = "";
	$.each(order,function(i,item){
		addH += '<table cellpadding="0" cellspacing="0" >'+
				'<tr>'+
					'<td width="62%"><input type="checkbox" name="" id="" value="" /><b>'+item.orderCreatetimestr+'</b>订单号：<span id="orderId'+i+'">'+item.orderNo+'</span></span></td>'+
					'<td width="15%"></td>'+
					'<td width="11%"></td>'+
					'<td width="12%" align="center" class="delete_s"></td>'+
				'</tr><tr><td width="62%" >';
		if(item.orderService.length>0){
			reveal(item.orderService,item.orderArea);
		}
		
		if(item.orderService.length>1){
			addH += '</td>'+
				'<td width="15%" align="center">'+judge(item.orderState)+'<br><a href="'+path+'/saleinfo/orderInfoBuyer/details.html?orderId='+item.orderNo+'&comId='+g_comid+'">查看详情</a><span id="td'+i+'"></span></td>'+
				'<td width="11%" align="center" class="zongjia">￥'+item.orderPrice+
				'<td width="12%" align="center">';
			pingjia(item.orderService);
			addH += '</td>'+
			'</tr>'+
			'</table>';
		} else if(item.orderService.length == 1){
			addH += '</td>'+
				'<td width="15%" align="center">'+judge(item.orderState)+'<br><a href="'+path+'/saleinfo/orderInfoBuyer/details.html?orderId='+item.orderNo+'&comId='+g_comid+'">查看详情</a><span id="td'+i+'"></span></td>'+
				'<td width="11%" align="center" class="zongjia">￥'+item.orderPrice+
				'<td width="12%" align="center"><span id="s'+i+'"></span><a href="'+path+'/goodsinfo/remark/viewRemark.html?id='+item.orderService[0].osId+'" style="text-decoration:none;" class="pingjia" id="p'+i+'">评价</a></td>'+
			'</tr>'+
			'</table>';
		} else {
			addH += '</tr>'+
			'</table>';
		}
		$("#pe_dan_list").html(addH);
		
	});
	$.each(order,function(i,item){
		var id = "d"+i;
		var p = "p"+i;
		var z = "z"+i;
		var s = "s"+i;
		var x = "x"+i;
		var qr = "qr"+i;
		var td = "td"+i;
		var html = '';
		if(item.orderState>2){
			$("#"+id).hide();
		}
		if(item.orderState==2){
			html += '<br><a href="javascript:shez('+$("#orderId"+i).html()+');" id="z'+i+'">支付</a>';
		}
		if(item.orderState==1){
			html += '<br><a href='+path+'/saleinfo/order/viewEditOrder.html?orderNo='+$("#orderId"+i).html()+' id="x'+i+'">修改订单</a>';
		}
		/*if(item.orderState==4){
		if(item.orderRefundstate == 0){
			html += '<br><a href='+path+'/saleinfo/orderInfoBuyer/ConfirmPayment.html?orderNo='+$("#orderId"+i).html()+' id="qr'+i+'">确认支付</a>';
		}
		}*/
		if(item.orderState==4){
			if(item.orderRefundstate == 0){
				html += '<br><a href='+path+'/saleinfo/orderInfoBuyer/ConfirmPayment.html?orderNo='+$("#orderId"+i).html()+' id="qr'+i+'">确认支付</a>';
				html += '<br><a href='+path+'/saleinfo/orderInfoBuyer/viewApplyRefund.html?orderNo='+$("#orderId"+i).html()+'>退款</a>';
			}
			/*if(item.orderRefundstate > 0){
				html += '<br><a href='+path+'/saleinfo/orderInfoBuyer/viewRefunddetails.html?orderNo='+$("#orderId"+i).html()+'>退款详情</a>';
			}*/
			if(item.orderRefundstate == 3){
				html += '<br><a href="javascript:orderInfoBuyerService('+$("#orderId"+i).html()+');">申请平台介入</a>';
			}
			if(item.orderRefundstate == 6){
				html += '<br>已申请平台介入';
			}
		}
		if(item.orderRefundstate >0){
			html += '<br><a href='+path+'/saleinfo/orderInfoBuyer/viewRefunddetails.html?orderNo='+$("#orderId"+i).html()+'>退款详情</a>';
		}
		$("#"+td).html(html);
		if(item.orderState != 5){
			$("#"+p).hide();
		} 
		if(item.orderState < 5){
			$("#"+s).html("");
		} else if(item.orderState = 5){
			$("#"+s).hide();
		} else {
			$("#"+s).html("已评价");
		}
		
	});
}
function shez(no){
	$.ajax({
		url:path+'/saleinfo/orderInfoBuyer/shez.html',
		type:'post',
		dataType:'json',
		success:function(res){
			if(res.success){
				window.location.href=path+'/saleinfo/orderInfoBuyer/getAccount.html?orderId='+no+'&comId='+g_comid;
			} else {
				alert(res.errorMsg,"系统提示",function(){
					window.location.href=path+'/userinfo/accountInfo/jumpModifyPayPass.html?flag=1&orderId='+no+'&comId='+g_comid;
				});
			}
		}
	});
}

function pingjia(str){
	$.each(str,function(i,item){
		var sersInfo = jQuery.parseJSON(item.sersInfo);
		if(str.length>1){
			addH += '<div style="border-bottom: 1px solid #DAF3FF;height: 91px;padding-top: 40px;"><span id="s'+i+'"></span><a href="'+path+'/goodsinfo/remark/viewRemark.html?id='+item.osId+'" style="text-decoration:none;" class="pingjia" id="p'+i+'">评价</a></div>';
		} 
	});
}

function reveal(str,addr){
	$.each(str,function(i,item){
		var sersInfo = eval('(' + item.sersInfo + ')');
		
		if(str.length>1){
			addH += '<div class="title_img_dd">'+
						'<ul>'+
							'<li><img src="'+localhostPath+sersInfo.servicePic+'" width="140" height="112" ></li>'+
							'<li class="dingdan" style="width:170px;">'+sersInfo.serviceTitle+'<br>'+addr+'<br><span>约见'+sersInfo.serviceMeettime+'小时</span></li>'+
							'<li class="danjia" style="width:90px;">￥'+item.osPrice+'</li>'+
							'<li class="shuliang" style="line-height: 78px;">1</li>'+
						'</ul>'+
					'</div>';
		} else {
			addH += '<div class="title_img_dd">'+
						'<ul>'+
							'<li><img src="'+localhostPath+sersInfo.servicePic+'" width="140" ></li>'+
							'<li class="dingdan" style="width:170px;">'+sersInfo.serviceTitle+'<br>'+addr+'<br><span>约见'+sersInfo.serviceMeettime+'小时</span></li>'+
							'<li class="danjia" style="width:90px;">￥'+item.osPrice+'</li>'+
							'<li class="shuliang" style="line-height: 78px;">1</li>'+
						'</ul>'+
					'</div>';
		}
	});
}

function judge(str){
	var state = '';
	if(str==0){
		state = '待确认';
	} else if(str==1){
		state = '服务商否定';
	} else if(str==2){
		state = '待付款';
	} else if(str==3){
		state = '已取消';
	} else if(str==4){
		state = '待完成';
	} else if(str==5){
		state = '待评价';
	} else if(str==6){
		state = '已完成';
	} 
	return state;
}

function ju(str){
	if(str=='请输入标题或订单编号'){
		str = '';
	}
	return str;
}

function sub(n){
	var title = $("#title").val();
	var startDate = $("#startDate").datebox("getValue");
	var endDate = $("#endDate").datebox("getValue");
	var orderIsbill = $("#orderIsbill").combobox("getValue");
	
	
	if(n==-1){
		orderState = $("#orderState").combobox("getValue");
	} else {
		orderState = n;
	}
	
	
	title = ju(title);
	$.ajax({
		url:path+'/saleinfo/orderInfoBuyer/getAllOrder.html?page='+1,
		type:'post',
		dataType:'json',
		data:{
			"title":title,
			"startDate":startDate,
			"endDate":endDate,
			"orderIsbill":orderIsbill,
			"orderState":orderState
		},
		success:function(res){
			if(res!=null){
				fy(res,1);
			}
		}
	});
	
	
}

function getOrderId(i){
	var id = "#orderId"+i;
	var orderNo = $(id).html();
	return orderNo;
}

function del(n){
	var orderNo = getOrderId(n);
	var no = $("#pagevalue").val();
	$.ajax({
		url:path+'/saleinfo/order/cancelOrder.html',
		type:'post',
		dataType:'json',
		data:{'orderNo':orderNo},
		success:function(res){
			if(res.success){
				alert(res.errorMsg);
				selectCommonAjax(no);
			}
		}
	});
}

function fy(res,no){
	var total = res.total
	$("#totalNum").html(total);
	/*var n = Math.ceil(total/2);
	if(no>n){
		no = no-1;
	}*/
	pageNum(total,5,no,'fy');
	var order = res.rows;
	if(order!=null){
		sh(order);
	}
}

function cl(){
	$("#title").val('');
	$("#startDate").datebox('setValue', '');
	$("#endDate").datebox('setValue', '');
	$("#orderIsbill").combobox('setValue','');
	
	$("#orderState").combobox('setValue','');
	
}


function orderInfoBuyerService(id){
	$.ajax({
		url:path+'/saleinfo/orderInfoBuyer/updateRefundStatusByOrderNo.html?orderId='+id,
		type:'post',
		dataType:'json',
		success:function(res){
			if(res.success){
				alert(res.errorMsg);
				window.location.reload();
			}
		}
	});
}

