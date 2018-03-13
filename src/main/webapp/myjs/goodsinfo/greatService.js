var order = "SERVICE_SUCCESSNUM DESC";
$(function(){
	showDiv(jsonList,1);
	$('.sv_sx_zz a').click(function(){
		$(this).siblings().css("color","#999");
		$(this).siblings().css("border","none");
		$(this).siblings().css("background","url("+path+"/images/up.png) no-repeat 75px 5px");
		$('.no_bg').css("background","none");
		if($(this).text()=='综合排序'){
			order = 'SERVICE_SUCCESSNUM DESC';
			$(this).css("color","#FB5A5A");
			$(this).css("border","1px solid #FB5A5A");
		}else if($(this).text()=='约见最多'){
			order = 'SERVICE_MEETNUM DESC';
			$(this).css("color","#FB5A5A");
			$(this).css("background","url("+path+"/images/up_hover.png) no-repeat 75px 5px");
			$(this).css("border","1px solid #FB5A5A");
		}else if($(this).text()=='口碑最好'){
			order = 'SERVICE_MARK DESC';
			$(this).css("color","#FB5A5A");
			$(this).css("background","url("+path+"/images/up_hover.png) no-repeat 75px 5px");
			$(this).css("border","1px solid #FB5A5A");
		}else if($(this).text()=='价格最高'){
			order = 'PSET_PRICE DESC';
			$(this).css("color","#FB5A5A");
			$(this).css("background","url("+path+"/images/up_hover.png) no-repeat 75px 5px");
			$(this).css("border","1px solid #FB5A5A");
		}
		selectCommonAjax(1);
	});
	$('#typeull').on('click','li',function(){
		serviceTypetree = $(this).attr('val');
			jQuery('<form action="'+path+"/goodsinfo/ServiceInfo/showServiceList.html"+'" method="post">'
					+'<input type="hidden" name="serviceTypetree" value="'+ serviceTypetree +'" />'
					+'</form>').appendTo('body').submit().remove();
	})
})
function gotoServiceDetails(serviceId){
	var priceType = 1;
	jQuery('<form action="'+path+"/goodsinfo/service/queryServiceDetails.html"+'" method="get" target="_blank">'
			+'<input type="hidden" name="serviceId" value="'+ serviceId +'" />'
			+'<input type="hidden" name="priceType" value="'+ priceType +'" />'
			+'</form>').appendTo('body').submit().remove();
}
function selectCommonAjax(pageNo){
	$.ajax({
			type : "post",
			url : path+'/goodsinfo/ServiceInfo/showMorePageByAjax.html',
			dataType:'json',
			data:{
				'order':order,
				'page':pageNo,
				'serviceTypetree':serviceTypetree,
				'stId':stId
			},
			success:function(res){
				$('#allcount').empty();
				$('#allcount').append(res.count);
				count = res.count;
				$("#myuul").empty();
				$("#pageDiv").empty();
				showDiv(res.showList,res.pageNo);
			},error:function (XMLHttpRequest, textStatus, errorThrown) {
				alert("请求对象XMLHttpRequest: "+XMLHttpRequest);
				alert("错误类型textStatus: "+textStatus);
				alert("异常对象errorThrown: "+errorThrown);
			}
	});
}
function showDiv(res,pageNo){
	for(var i in res){
		var arr = res[i];
		var serviceTitle = arr["serviceTitle"];
		var serviceSuccessnum = arr["serviceSuccessnum"];
		var servicePic = arr["servicePic"];
		var serviceMark = arr["serviceMark"].toFixed(0);
		var psetPrice = arr["psetPrice"];
		var serviceId = arr["serviceId"];
		var inner = '<li>'
			+'<div style="height:255px;" class="item-panel">'
			+'<div class="item-pic">'
			+'<img src="'+localhostPath+(servicePic||"")+'" onclick="gotoServiceDetails(\''+(serviceId||"")+'\')">'
			+'</div>'
			+'<div class="item-title">'
			+'<a class="ittus" href="'+path+'/goodsinfo/service/queryServiceDetails.html?serviceId='+(serviceId||"")+'&comId='+g_comid+'&priceType=1" target="_blank">'+(serviceTitle||"")+'<em class="c_f60"></em></a>'
			+'</div>'
			+'<div style="height:60px;" class="item-addition">'
			+'<div class="clearfix">'
			+'<div class="price">'
			+'<span class="free">￥'+(psetPrice||0.0)+'</span>'
			+'</div>'
			+'</div>'
			+'<div class="satisfaction">'
			+'<span class="">'+(serviceSuccessnum||0)+'人约见</span>'
			+'</div>'
			+'<div class="number">'
			+'<span>评分：<em>'+(serviceMark||0)+'</em></span>'
			+'</div>'
			+'</div>'
			+'</div>'
			+'</li>'
			$('#myuul').append(inner);
		}
	pageNum(count,16 ,pageNo,'pageDiv');
}