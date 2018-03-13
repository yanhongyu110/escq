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
$(function() {
	selectCommonAjax(1);
});
function selectCommonAjax(pageNo) {

	$.ajax({
		type : "post",
		url : path + '/userinfo/queryAllSystemMesByAjax.html',
		dataType : 'json',
		data : {
			'smType' : smType,
			'page' : pageNo
		},
		success : function(res) {
			count = res.count;
			console.info(res);
			
			showDiv(res.list);
		}
	});

	pageNum(total, 10, pageNo, pageDiv);
}
function showDiv(res) {
	$("#mesBox").empty();
	for ( var i in res) {
		var arr = res[i];
		var smTitle = arr['smTitle'];
		var smId = arr['smId'];
		var smContent = arr['smContent'];
		var smCreatetimeStr=arr['smCreatetimeStr'];
		var operatorId = arr['operatorId'];
		var operatorType = arr['operatorType'];
		var mdType = arr['mdType'];
		var innerTitle = '<ul>' + '<li>' + '<div class="news_title">' + smTitle
				+ '</div>' + '<div class="news_time">'
				+ '<a href="javascript:;" onclick="del(\'' + smId + '\')">'
				+ '<img src="'+path+'/images/wrong.jpg">' + '</a>' + '</div>';
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
		innerTitle += '<p>' + '<span>发出日期：'+smCreatetimeStr+'</span>' + '</p>'
				+ '</div>' + '</li>' + '</ul>';
		$("#mesBox").append(innerTitle);
	}
}
function toInfo(logId, type){           
	if(type == 2){
		window.location.href = path + "/userinfo/providerdetails/preproviderdetails.html?logId="+logId;
	}else{
		window.location.href = path + "/userinfo/providerdetails/preProviderForXuqiu.html?logId="+logId;
	}
}
function toServiceInfo(serviceId){
	window.location.href = path + "/goodsinfo/service/queryServiceDetails.html?serviceId="+serviceId+"&priceType=1";
}
function toyuejian(){
	window.location.href = path + "/saleinfo/orderInfoSeller/viewOrder.html";
}