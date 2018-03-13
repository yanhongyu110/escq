var order = "SERVICE_SUCCESSNUM DESC";
var province = '';
var city = "";
var area = "";
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
	$('#demo').on('click','a',function(){
		if($(this).parent().parent('ul').attr('name')=='province'){
			province = $(this).text();
			city = '';
			area = '';
			if(province=='全部'){
				province = '';
			}
		}else if($(this).parent().parent('ul').attr('name')=='city'){
			city = $(this).text();
			area = '';
			if(city=='全部'){
				city = '';
			}
		}else if($(this).parent().parent('ul').attr('name')=='area'){
			area = $(this).text();
			if(area=='全部'){
				area = '';
			}
		}
		console.info(province+'--'+city+'--'+area);
		selectCommonAjax(1);
	});
	$('#typeull').on('click','li',function(){
		serviceTypetree = $(this).attr('val');
			jQuery('<form action="'+path+"/goodsinfo/ServiceInfo/showServiceList.html"+'" method="post">'
					+'<input type="hidden" name="serviceTypetree" value="'+ serviceTypetree +'" />'
					+'</form>').appendTo('body').submit().remove();
	})
})
function selectCommonAjax(pageNo){
	$.ajax({
			type : "post",
			url : path+'/goodsinfo/ServiceInfo/showServiceListByAjax.html',
			dataType:'json',
			data:{
				'order':order,
				'page':pageNo,
				'serviceTypetree':serviceTypetree,
				'province':province,
				'city':city,
				'area':area
			},
			success:function(res){
				$('#allcount').empty();
				$('#allcount').append(res.count);
				count = res.count;
				$("#myexpert").empty();
				$("#pageDiv").empty();
				showDiv(res.serviceList,res.pageNo);
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
		var serviceBiref = arr["serviceBiref"];
		var serviceMeetnum = arr["serviceMeetnum"];
		var serviceSuccessnum = arr["serviceSuccessnum"];
		var servicePic = arr["servicePic"];
		var serviceMark = arr["serviceMark"];
		if(serviceMark!=null){
			serviceMark = arr["serviceMark"].toFixed(0);
		}
		var psetPrice = arr["psetPrice"].toFixed(2);
		var serviceId = arr["serviceId"];
		var inner = '<div class="sv_zj">'
			+'<div class="sv_zj_img">'
			+'<img  src="'+localhostPath+(servicePic||"")+'" onclick="window.location.href=\''+path+'/goodsinfo/service/queryServiceDetails.html?serviceId='+serviceId+'&priceType=1\'+\'&comId=\'+g_comid" />'
			+'</div>'
			+'<div class="sv_zj_title">'
			+'<h3>'+(serviceTitle||"")+'</h3>'
			+'<p>'+(serviceBiref||"")+'</p>'
			+'<p><a><font>'+(serviceSuccessnum||0)+'</font>人约见</a> <a><font>'+(serviceMeetnum||0)+'</font>人想见</a> <a>评分：<font>'+(serviceMark||0.0)+'</font>分</a></p>'
			+'</div>'
			+'<div class="sv_zj_btn">'
			+'<a class="ex_pay">￥'+(psetPrice||0)+'</a> 元/次'
			+'<a  href="'+path+'/goodsinfo/service/queryServiceDetails.html?serviceId='+serviceId+'&comId='+g_comid+'&priceType=1" class="ex_yj">查看详情</a>'
			+'</div>'
			+'</div>'
		$("#myexpert").append(inner);
	 }
	pageNum(count,10 ,pageNo,'pageDiv');
}