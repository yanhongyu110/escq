var totalPage = Math.ceil(count / 4);
var pageNo=1;
var s = true;
$(function(){

    $('body').bind('touchmove', function(e) {
        if($(window).scrollTop()>=$(document).height()-$(window).height()){
            if(s) {
                pageNo=pageNo+1;
                selectCommonAjax(pageNo);
                s = false;
            }
        }
    });

	$(".content_list").empty();
	showDiv(jsonList,1);
	/*$('.jiaz').click(function(){
		pageNo=pageNo+1;
		selectCommonAjax(pageNo);
	});*/
	if(!$(".content_list").html()){
		$(".content_list").html('<div class="jiaz" >没有添加关注哟...</div>');
	}
})
function selectCommonAjax(pageNo){
	$.ajax({
			type : "post",
			url : path+'/wap/bizinfo/focus/showFocusListByAjax.html',
			dataType:'json',
			data:{
				'page':pageNo,
				'logId':$('#thelogid').val()
			},
			success:function(res){
				showDiv(res.focusList,res.pageNo);
			},error:function (XMLHttpRequest, textStatus, errorThrown) {
				alert("请求对象XMLHttpRequest: "+XMLHttpRequest);
				alert("错误类型textStatus: "+textStatus);
				alert("异常对象errorThrown: "+errorThrown);
			}
	});
}
function showDiv(res,pageNo){
	/*if(pageNo>=totalPage){
		$('.jiaz').hide();
	}*/
	for(var i in res){
		var arr = res[i];
		var piPhoto = arr["piPhoto"];
		var piRealname = arr["piRealname"];
		var logName= arr["logName"];
		var piWorkyear = arr["piWorkyear"];
		var piMeetnum = arr["piMeetnum"];
		var piDealnum = arr["piDealnum"];
		var piArea = arr["piArea"];
		var piKeywords = arr["piKeywords"];
		var futpProvider = arr['futpProvider'];
		var inner = '<a href="'+path+'/wap/userinfo/providerdetails/preproviderdetails.html?logId='+(futpProvider||"")+'">'
			+'<div class="service_list">'
			+'<div class="service_list_img">'
			+'<img src="'+localhostPath+(piPhoto||"")+'" />'
			+'</div>'
			+'<div class="service_list_title" style="width:49%">'
			+'<h3 >'+(logName||"")+'</h3>'
		    +'<span>'+(piArea||"")+'</span>'
			+'<b style="padding-top:2px;padding-bottom:2px;font-size:12px;font-weight:500;color:#999;clear:both">'+(piMeetnum||0)+'人约见 <font style="padding-left:8px;color:#999;font-size:12px">服务'+(piDealnum||0)+'次</font></b>'
			+'<p class="con_collect" ></p>'
			
			
			
			
			+'</div>'
			+'<div style="float:right;width: 20%;margin-top:10px;margin-right:2%;text-align: right;">'
			+'<a href="javascript:void(0)" onclick="del(\''+(futpProvider||"")+'\')" style="color: #fff;background: #f40;float:right;font-size: 16px;padding:5px 10px;width: 100%;text-align: center;">取消关注</a>'
			
			+'</div>'
			+'</div></a>'
		$(".content_list").append(inner);
		cut()
	 }
	s = true;
}

function del(futpProvider){
	alert("请确定是否删除关注！",null,function(){temp(futpProvider)},function(){});
}	

function temp(futpProvider){
	$.ajax({
		url:path+"/wap/bizinfo/focus/deleteFocus.html",
		data:{
			providerLogId:futpProvider
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