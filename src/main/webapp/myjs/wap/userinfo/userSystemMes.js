function del(id) {
	alert("请确定是否删除平台消息！",null,function(){
		$.ajax({
			url : path + '/userinfo/removeMesByPrimaryKey.html',
			type : 'post',
			dataType : 'json',
			data : {
				smId : id
			},
			success : function(mes) {
				alert(mes,"删除",function(){
					window.location.reload();	
				})
			}
		})
	},function(){});
	
}
var rows = 10;
var pageDiv = 'pageDiv';
var clickSwitch = true;
$(function() {
	selectCommonAjax(1,$("#smType").val());
    $('body').bind('touchmove', function(e) {
        if($(window).scrollTop()>=$(document).height()-$(window).height()){
            if(clickSwitch){
                clickSwitch = false;
                $(".loading").text("加载中...");
                var pageNo = ($("#ms"+$(".on").data('type')+" ul").length)/10+1;
                selectCommonAjax(pageNo,$(".on").data('type'));
            }
        }
    });
	/*$(".loading").click(function(){
		if(clickSwitch){
			clickSwitch = false;
			$(".loading").text("加载中...");
			var pageNo = ($("#ms"+$(".on").data('type')+" ul").length)/10+1;
			selectCommonAjax(pageNo,$(".on").data('type'));
		}
	})*/
});
function selectCommonAjax(pageNo,smType) {
	$.ajax({
		type : "post",
		url : path + '/userinfo/queryAllSystemMesByAjax.html',
		dataType : 'json',
		data : {
			'smType' : smType,
			'page' :pageNo
		},
		success : function(res) {
			showDiv(res.list,pageNo);
			if(res.list.length<10){
				clickSwitch = false;
				$(".loading").text("");
			}else{
				clickSwitch = true;
				/*$(".loading").text("加载更多");*/
			}
		}
	});
}
function showDiv(res,pageNo) {
	if(pageNo==1 && res.length>0){
		$("#ms"+res[0]['smType']).empty();
	}
	for ( var i in res) {
		var arr = res[i];
		var smTitle = arr['smTitle'];
		var operatorId = arr['operatorId'];
		var operatorType = arr['operatorType'];
		var mdType = arr['mdType'];
		//3e41e815f02f4efca415b5790172ea72
		var smId = arr['smId'];
		var smContent = arr['smContent'];
		var smCreatetimeStr=arr['smCreatetimeStr'];
		var innerTitle = '<ul>' + '<li>' + '<div class="news_title">' + '<img src="'+path+'/images/wap/pt_l.png">'
				+ '</div>' + '<div class="news_time">'
				+ '<a href="javascript:;" onclick="del(\'' + smId + '\')">'
				+ '<img src="'+path+'/images/wap/wrong.png">' + '</a>' + '</div>';
		if(mdType==1 || mdType==3){
			if(operatorId == null || operatorId == ''){
				innerTitle += '<div class="news_content">' + '<p style="word-break:break-all">'+smContent+'</p>';
			}else{
				innerTitle += '<div class="news_content">' + '<p style="word-break:break-all"><a href="javascript:toInfo(\''+operatorId+'\',\''+operatorType+'\')">'+smContent+'</a></p>';
			}
		}else if(mdType==2){
			if(operatorId == null || operatorId == ''){
				innerTitle += '<div class="news_content">' + '<p style="word-break:break-all">'+smContent+'</p>';
			}else{
				innerTitle += '<div class="news_content">' + '<p style="word-break:break-all"><a href="javascript:toServiceInfo(\''+operatorId+'\')">'+smContent+'</a></p>';
			}
		}else if(mdType==4){
			innerTitle += '<div class="news_content">' + '<p style="word-break:break-all"><a href="javascript:toyuejian()">'+smContent+'</a></p>';
		}else{
			innerTitle += '<div class="news_content">' + '<p style="word-break:break-all">'+smContent+'</p>';
		}
		innerTitle +='</div>' + '</li>' + '</ul>'
				+'<div class="f_times">' + '<span>'+smCreatetimeStr+'</span>' + '</div>';
		$("#ms"+arr['smType']).append(innerTitle);
	}
}

function toInfo(logId, type){           
	if(type == 2){
		window.location.href = path + "/wap/userinfo/providerdetails/preproviderdetails.html?logId="+logId;
	}else{
		window.location.href = path + "/wap/userinfo/providerdetails/preProviderForXuqiu.html?logId="+logId;
	}
}

function toServiceInfo(serviceId){
	window.location.href = path + "/wap/goodsinfo/service/queryServiceDetails.html?serviceId="+serviceId+"&priceType=1";
}

function toyuejian(){
	window.location.href = path + "/wap/saleinfo/orderInfoSeller/viewOrder.html";
}