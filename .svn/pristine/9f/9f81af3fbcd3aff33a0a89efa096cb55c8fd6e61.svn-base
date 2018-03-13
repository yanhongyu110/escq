$(function(){
	$('body').css({"background":"none"});
	//jQuery限定长度
	$('.serviceTitle').each(function(){
		$(this).html($(this).html().length>10?$(this).html().substring(0,10)+'...':$(this).html());
	});
	$('.piContent>p').html($('.piContent>p').html().length>52?$('.piContent>p').html().substring(0,52)+'...':$('.piContent>p').html());
	
	$('#morezp').click(function(){
		AjaxPaging();
	});
	if($("#logId").val()!=""&$("#logId").val()!=undefined&logId!=''&logId!=undefined){
		$.ajax({
	         type : "POST",
	         url : path+"/wap/bizinfo/focus/judgeFocus.html",
	         data :{providerLogId:$("#logId").val()},
	         success : function(result) {//返回数据根据结果进行相应的处理
	       	  var ajaxobj=JSON.parse(result);
	             if(ajaxobj.success){
	            	/* alert(ajaxobj.errorMsg);*/
	            	 $("._yue_bottom_left").css('background','#cccccc').text("已关注");
	            	 $("._yue_bottom_left").unbind("click");
	             }else {
	             	/* alert(ajaxobj.errorMsg);*/
	             	$("._yue_bottom_left").css('background','#f40')
	         }
	         }
		})
	}
	$("._yue_bottom_left").click(function(){
		 $.ajax({
	         type : "POST",
	         url : path+"/wap/bizinfo/focus/addFocus.html",
	         data :{providerLogId:$("#logId").val()},
	         success : function(result) {//返回数据根据结果进行相应的处理
	       	  var ajaxobj=JSON.parse(result);
	             if(ajaxobj.success){
                     $("._yue_bottom_left").css('background','#ccc').text("已关注");
                     $("._yue_bottom_left").unbind("click");
	            	 alert(ajaxobj.errorMsg);
	             }else {
	             	 alert(ajaxobj.errorMsg);
	         }
	         }
	     });
	})
})

var page=1;
function AjaxPaging(){
	var logId = $('#logId').val();
	page=page+1;
	console.log(page);
	$.ajax({
		type : "post",
		url : path + '/wap/userinfo/providerdetails/ajaxpaging.html',
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
		$('#morezp').remove();
		$('#dx').css({"display":"block"});
	}
	for(var i=0;i<res.length;i++){
		var dom = "<div class=\"tt_zhu\" onclick=\"window.location.href=path+'/wap/goodsinfo/service/queryServiceDetails.html?serviceId="+res[i].serviceId+"&priceType=1'     \">"+
		"<div class=\"tt_zhu_img\" ><img style=\"width: 100%;\" src=\""+res[i].servicePic+"\"></div>"+
		"<h3 class=\"serviceTitle\">"+res[i].serviceTitle+"</h3> "+
		"<font style=\"color: #FB5A5A; font-size: 18px; font-weight: bold; font-family: arial;\">￥"+res[i].psetPrice+"</font>"+
		"</div>";
		$('#service_list').append(dom);
	}
	$('.serviceTitle').each(function(){
		$(this).html($(this).html().length>10?$(this).html().substring(0,10)+'...':$(this).html());
	})
}