var totalPage = Math.ceil(count / 4);
var pageNo=1;
$(function(){

	$(".content_list").empty();
	showDiv(jsonList,1);
	$('.jiaz').click(function(){
		pageNo=pageNo+1;
		selectCommonAjax(pageNo);
	});
	console.info(!$(".content_list").html());
	if(!$(".content_list").html()){
		$(".content_list").html('<div class="jiaz" >没有添加关注哟...</div>');
	}
})
function selectCommonAjax(pageNo){
	$.ajax({
			type : "post",
			url : path+'/wap/goodsinfo/cart/showCartListByAjax.html',
			dataType:'json',
			data:{
				'page':pageNo,
				'logId':$('#thelogid').val()
			},
			success:function(res){
				showDiv(res.cartList,res.pageNo);
			},error:function (XMLHttpRequest, textStatus, errorThrown) {
				alert("请求对象XMLHttpRequest: "+XMLHttpRequest);
				alert("错误类型textStatus: "+textStatus);
				alert("异常对象errorThrown: "+errorThrown);
			}
	});
}
function showDiv(res,pageNo){
	if(pageNo>=totalPage){
		$('.jiaz').hide();
	}
	for(var i in res){
		var arr = res[i];
		var servicePic = arr["serviceSnapshot"].serviceInfo.servicePic;
		var serviceTitle = arr["serviceSnapshot"].serviceInfo.serviceTitle;
		var serviceBiref = arr["serviceSnapshot"].serviceInfo.serviceBiref;
		var scartPrice = arr["scartPrice"];
		var serviceId = arr["serviceId"];
		var scartId = arr["scartId"];
		var logId = arr["logId"];
		var inner = '<a href="'+path+'/wap/goodsinfo/service/queryServiceDetails.html?serviceId='+serviceId+'&priceType=1">'
			+'<div class="service_list">'
			+'<div class="service_list_img">'
			+'<img  src="'+localhostPath+(servicePic||"")+'" />'
			+'</div>'
			+'<div class="service_list_title">'
			+'<h3 >'+(serviceTitle||"")+'</h3>'
			+'<p class="con_collect" cut="35">'+(serviceBiref||"")+'<p>'
			+'<b >￥'+(scartPrice||0)+'元/次</b>'
			+'<div>'
			+'<a href="javascript:void(0)" onclick="del(\''+(scartId||"")+'\',\''+(logId||"")+'\')" style="width: 90px; border:1px solid #999;border-radius:10px; text-align: center; color: #999; display: block; margin-bottom: 10px; height:23px; line-height:23px;margin-top:15px;">删除心愿</a>'
			
			+'</div>'
			+'</div>'
			+'</div></a>'
		$(".content_list").append(inner);
		cut()
	 }

}

function del(scartId,logId){
	alert("请确定是否删除关注！",null,function(){temp(scartId,logId)},function(){});
}	

function temp(scartId,logId){
	$.ajax({
		url:path+"/wap/goodsinfo/cart/deletecart.html",
		data:{
			scartId:scartId,
			logId:logId,
		},
		dataType:'json',
		type:'post',
		cache:false,
		success:function(data){
			window.location.reload();
			//console.info(data);
		},
		error:function(data){
			console.info(data);
		}
	});
}


function cut(){
	$('*[cut]').each(function(){
		var length=parseInt($(this).attr('cut'))
		var text = $(this).text();
		if (text.length>length){
			$(this).text(text.substring(0,length)+"...");
		}
	})
}