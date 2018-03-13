$(function(){
	$('body').css({"background":"none"});
	//jQuery限定长度
	$('.serviceTitle').each(function(){
		$(this).html($(this).html().length>10?$(this).html().substring(0,10)+'...':$(this).html());
	});
	
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
		url : path + '/wap/userinfo/providerdetails/queryDemandByPage.html',
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
		var dom = "<div class=\"tt_zhu\" onclick=toDeals('"+res[i].demId+"')>"+
		"<div class=\"tt_zhu_img\" >";
		alert(res[i].demImage);
		if(res[i].demImage == null || res[i].demImage =='' || res[i].demImage=='undefined'){
			dom += "<img style=\"width: 100%;\" src='/images/wap/xq_picture.jpg'></div>";
		}else{
			dom += "<img style=\"width: 100%;\" src=\""+res[i].demImage+"\"></div>";
		}
		dom += "<h3 class=\"serviceTitle\">"+res[i].demTitle+"</h3> "/*+
		"<font style=\"color: #FB5A5A; font-size: 18px; font-weight: bold; font-family: arial;\">￥"+res[i].psetPrice+"</font>"+*/
		"</div>";
		$('#service_list').append(dom);
	}
	$('.serviceTitle').each(function(){
		$(this).html($(this).html().length>10?$(this).html().substring(0,10)+'...':$(this).html());
	})
}
/**
 * 查看详情
 * @param id 需求id
 */
function toDeals(id){
	window.location.href=path+"/wap/demand/queryById.html?id="+id;
}