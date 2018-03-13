var order = "SERVICE_SUCCESSNUM DESC";
var province = "";
var city = "";
var area = "";
var demType = '';
$(function(){
	//showDiv(jsonList,1);
	selectCommonAjax(1);
	/*$('.sv_sx_zz a').click(function(){
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
	});*/
	$('#typeull').on('click','li',function(){
		var demType = $(this).attr('val');
			jQuery('<form action="'+path+"/demand/gotodemandList.html"+'" method="post">'
					+'<input type="hidden" name="demType" value="'+ demType +'" />'
					+'</form>').appendTo('body').submit().remove();
	});
});
function selectCommonAjax(pageNo){
	$.ajax({
			type : "post",
			url : path+'/demand/demandList.html',
			dataType:'json',
			data:{
				'page':pageNo,
				'demType':demType1
			},
			success:function(res){
				$('#allcount').empty();
				$('#allcount').append(res.total);
				total = res.total;
				$("#myexpert").empty();
				$("#pageDiv").empty();
				showDiv(res.list,res.page);
			},error:function(XMLHttpRequest,textStatus,errorThrown){
				alert("请求对象XMLHttpRequest: "+XMLHttpRequest);
				alert("错误类型textStatus: "+textStatus);
				alert("异常对象errorThrown: "+errorThrown);
			}
	});
}

function showDiv(res,pageNo){
	for(var i in res){
		var arr = res[i];
		var demTitle = arr["demTitle"];
		var demBrief = arr["demBrief"];
		var demKeyword = arr["demKeyword"];
		var userPhoto = arr["userPhoto"];
		var demImage = arr["demImage"];
		var demId = arr["demId"];
		var inner = '<div class="sv_zj">'
			+'<div class="sv_zj_img">'
		if(demImage == null || demImage == ''){
			inner +='<img src="'+path+'/images/wap/xq_picture.jpg" onclick="window.location.href=\''+path+'/goodsinfo/service/queryServiceDetails.html?serviceId='+demId+'\'+\'&comId=\'+g_comid" />';
		}else{
			inner +='<img src="'+demImage+'" onclick="window.location.href=\''+path+'/goodsinfo/service/queryServiceDetails.html?serviceId='+demId+'\'+\'&comId=\'+g_comid  "  />';
		}
			
		inner +='</div>'
			+'<div class="sv_zj_title">'
			+'<h3>'+(demTitle||"")+'</h3>'
			+'<p>'+(demBrief||"")+'</p>'
			+'<p>关键字：'+(aa(demKeyword)||"")+'</p>'
			+'</div>'
			+'<div class="sv_zj_btn">'
			
			+'<a  href="'+path+'/goodsinfo/service/queryServiceDetails.html?serviceId='+demId+'&comId='+g_comid+'" class="ex_yj">查看详情</a>'
			+'</div>'
			+'</div>';
		$("#myexpert").append(inner);
	 }
	pageNum(total,10 ,pageNo,'pageDiv');
}

function aa(val){
	val = val.substring(2,val.length-2);
	val = val.split();
	return val;
}
