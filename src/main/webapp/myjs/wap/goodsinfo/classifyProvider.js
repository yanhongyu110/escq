var order = "PI_DEALNUM DESC";
var province = "";
var city = "";
var area = "";
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
			order = 'PI_DEALNUM DESC';
		}else if($(this).text()=='约见最多'){
			order = 'PI_MEETNUM DESC';
		}else if($(this).text()=='口碑最好'){
			order = 'PI_MARK DESC';
		}else if($(this).text()=='价格最高'){
			order = 'PSET_PRICE DESC';
		}
		selectCommonAjax(1);
	});
	$('.jiaz').click(function(){
		pageNo=pageNo+1;
		selectCommonAjax(pageNo);
	});
})
function cut(){
	$('*[cut]').each(function(){
		var length=parseInt($(this).attr('cut'))
		var text = $(this).text();
		if (text.length>length){
			$(this).text(text.substring(0,length)+"...");
		}
	})
}
function selectCommonAjax(pageNo){
	$.ajax({
			type : "post",
			url : path+'/wap/goodsinfo/ProviderInfo/classifyProviderByAjax.html',
			dataType:'json',
			data:{
				'order':order,
				'province':province,
				'city':city,
				'area':area,
				'page':pageNo
			},
			success:function(res){
				showDiv(res.proList,res.pageNo);
			}
	});
}
function showDiv(res,pageNo){
	if(pageNo>=totalPage){
		$('.jiaz').hide();
	}
	for(var i in res){
		var arr = res[i];
		var piPhoto = arr["piPhoto"];
		var piPosition = arr["piPosition"];
		var piRealname = arr["piRealname"];
		var piWorkyear = arr["piWorkyear"];
		var piBrief = arr["piBrief"];
		var piDealnum = arr["piDealnum"];
		var piMeetnum = arr["piMeetnum"];
		var piRek = arr["piRek"];
		var psetPrice = arr["psetPrice"];
		var piLogId = arr["piLogId"];
		var inner = '<a href="'+path+'/wap/userinfo/providerdetails/preproviderdetails.html?logId='+piLogId+'">'
			+'<div class="service_list">'
			+'<div class="service_list_img">'
			+'<img src="'+localhostPath+(piPhoto||"")+'" />'
			+'</div>'
			+'<div class="service_list_title">'
			+'<h3>'+(piPosition||"")+'</h3>'
			+'<font cut="10">'+(piBrief||"")+'</font>'
			+'<b>￥'+(psetPrice||0)+'</b>'
			+'<span style="float: left">'+(piDealnum||0)+'人约见</span>'
			
			+'</div>'
			+'</div></a>'
		$(".content_list").append(inner);
		cut()
	}
}