window.onload=function(){
	if(logId!=""&&logId!=undefined){
		$.ajax({
	         type : "POST",
	         url : path+"/bizinfo/focusutop/judgeFocus.html",
	         data :{providerLogId:$("#logId").val()},
	         success : function(result) {//返回数据根据结果进行相应的处理
	       	  var ajaxobj=JSON.parse(result);
	             if(ajaxobj.success){
	            	/* alert(ajaxobj.errorMsg);*/
	            	 $(".addfocus").html("已关注");
	            	 $(".addfocus").unbind("click");
	            	 $(".addfocus").css("background","#aaaaaa");
	             }else {
	             	/* alert(ajaxobj.errorMsg);*/
	             	$(".addfocus").html("添加关注");
	         }
	         }
	})
	}
			$(".addfocus").click(function(){
				 $.ajax({
			         type : "POST",
			         url : path+"/bizinfo/focusutop/addFocus.html",
			         data :{providerLogId:$("#logId").val()},
			         success : function(result) {//返回数据根据结果进行相应的处理
			       	  var ajaxobj=JSON.parse(result);
			             if(ajaxobj.success){
			            	 alert(ajaxobj.errorMsg);
			            	 $(".addfocus").html("已关注");
			            	 $(".addfocus").unbind("click");
			            	 $(".addfocus").css("background","#aaaaaa");
			             }else {
			             	 alert(ajaxobj.errorMsg);
			         }
			         }
			     });
			})
	
}

$(function(){
	$('.serch_content').css({"display":"none"});
	
	//jQuery限定长度
	$('.class1_title').each(function(){
		$(this).html($(this).html().length>20?$(this).html().substring(0,20)+'...':$(this).html());
	})
	//$('.serch_content').html($('.serch_content').html().length>400?$('.serch_content').html().substring(0,400)+'...':$('.serch_content').html());
	$('.jianjie_idea').html($('.jianjie_idea').html());
	//$('.jianjie_content').html($('.jianjie_content').text().length>52?$('.jianjie_content').html().substring(0,52)+'...':$('.jianjie_content').html());
	
	$('#moreservice').click(function(){
		AjaxPaging();
	});
});
function $use(targetid, objN) {
	var d = $('#'+targetid);
	var sb = $('#'+objN);
	if ($(d).css('display') == "block") {
		$(sb).html('展开<img src="../../images/down.png">');
		$(d).slideUp(500);
	}else{
		$(sb).html('收起&nbsp;<img src="../../images/down-up.png">');
		$(d).slideDown(500);
	}
}

var page=1;
function AjaxPaging(){
	var logId = $('#logId').val();
	page=page+1;
	console.log(page);
	$.ajax({
		type : "post",
		url : path + '/userinfo/providerdetails/ajaxpaging.html',
		dataType : 'json',
		data : {
			'logId' : logId,
			'page' : page
		},
		success:function(res){
			LoadingService(res);
		}
		
	});
}

function LoadingService(res){
	if(res.length<6){
		$('#moreservice').remove();
		$('#dx').css({"display":"block"});
	}
	for(var i=0;i<res.length;i++){
		var dom = "<div class=\"class1\">"+
		"<div class=\"line\">"+
		"<div class=\"class1_title\" >"+res[i].serviceTitle+"</div>"+
		"<div class=\"class1_pay\">"+
		"<font>￥"+res[i].psetPrice+"</font>元/小时</div>"+
		"<a class=\"class1_btn\" onclick=\"window.location.href=path+'/goodsinfo/service/queryServiceDetails.html?serviceId="+res[i].serviceId+"&priceType=1' +'&comId='+g_comid  \">约TA见面</a>"+
		"<div class=\"serch_ss\" id=\"state"+i+525+"But\" onClick=\"$use('class"+i+525+"content','state"+i+525+"But')\">展开<img src=\"../../images/down.png\"></div>"+
		"<div class=\"serch_content\" id=\"class"+i+525+"content\" >"+
		"<div class=\"zs_list\">"+res[i].serviceBiref+"<a onclick=\"window.location.href=path+'/goodsinfo/service/queryServiceDetails.html?serviceId="+res[i].serviceTitle+"&priceType=1'+'&comId='+g_comid      \" href=\"javascript:void(0)\">查看详情>></a></div>"+
		"<div class=\"zs_detail\">"+
		"<span>发布于："+res[i].serviceCreatetimeStr+"</span>"+
		"<span><font>"+res[i].serviceMeetnum+"</font>人约过</span>"+
		"<span>约见"+
		"<font>"+res[i].serviceMeettime+"</font>小时</span>"+
		"<span><img src=\"../../images/zan.png\">"+
		"<font>123</font>个</span>"+
		"</div>"+
		"</div>"+
		"</div>"+
		"</div>"
		$('#service_list').append(dom);
	}
	$('.class1_title').each(function(){
		$(this).html($(this).html().length>20?$(this).html().substring(0,20)+'...':$(this).html());
	})
}