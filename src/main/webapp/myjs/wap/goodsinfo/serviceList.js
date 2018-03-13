var order = "SERVICE_SUCCESSNUM DESC";
var totalPage = Math.ceil(count / 4);
var pageNo=1;
$(function(){
	$(".content_list").empty();
	showDiv(jsonList,1);
	$('.nav_list_sai li').click(function(){
		$(this).addClass('ond');
		$(this).siblings().removeClass('ond');
		$(".content_list").empty();
		if($(this).text()=='综合排序'){
			order = 'SERVICE_SUCCESSNUM DESC';
		}else if($(this).text()=='约见最多'){
			order = 'SERVICE_MEETNUM DESC';
		}else if($(this).text()=='口碑最好'){
			order = 'SERVICE_MARK DESC';
		}else if($(this).text()=='价格最高'){
			order = 'PSET_PRICE DESC';
		}
		selectCommonAjax(pageNo);
	});
	$('.jiaz').click(function(){
		pageNo=pageNo+1;
		selectCommonAjax(pageNo);
	});
})
function selectCommonAjax(pageNo){
	$.ajax({
			type : "post",
			url : path+'/wap/goodsinfo/ServiceInfo/showServiceListByAjax.html',
			dataType:'json',
			data:{
				'order':order,
				'page':pageNo,
				'serviceTypetree':serviceTypetree
			},
			success:function(res){
				showDiv(res.serviceList,res.pageNo);
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
		var serviceTitle = arr["serviceTitle"];
		var serviceBiref = arr["serviceBiref"];
		var serviceMeetnum = arr["serviceMeetnum"];
		var serviceSuccessnum = arr["serviceSuccessnum"];
		var servicePic = arr["servicePic"];
		var serviceMark = arr["serviceMark"];
		var psetPrice = arr["psetPrice"];
		var serviceId = arr["serviceId"];
		if(serviceBiref.length>19){
			serviceBiref=serviceBiref.substring(0,12)+"...";
		}
		var inner = '<a href="'+path+'/wap/goodsinfo/service/queryServiceDetails.html?serviceId='+serviceId+'&priceType=1">'
			+'<div class="service_list">'
			+'<div class="service_list_img">'
			+'<img src="'+localhostPath+(servicePic||"")+'" />'
			+'</div>'
			+'<div class="service_list_title">'
			+'<h3 >'+(serviceTitle||"")+'</h3>'
			+'<font cut="10">'+(serviceBiref||"")+'</font>'
			+'<b >￥'+(psetPrice||0)+'元/次</b>'
			+'<span style="float: left">'+(serviceSuccessnum||0)+'人约见</span> <span style="float:left;padding-left:20px">评分：'+(serviceMark||0.0)+'分</span>'
			+'</div>'
			+'</div></a>'
		$(".content_list").append(inner);
		cut()
	 }

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