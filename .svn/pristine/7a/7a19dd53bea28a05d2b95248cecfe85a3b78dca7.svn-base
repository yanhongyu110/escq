var totalPage = Math.ceil(count / 4);
var pageNo=1;
$(function(){
	$(".personer_mes").empty();
	showDiv(jsonList,1);
	$('.jiaz').click(function(){
		pageNo=pageNo+1;
		selectCommonAjax(pageNo);
	});
	if(!$(".personer_mes").html()){
		$(".personer_mes").html('<div class="jiaz" >没有添加关注哟...</div>');
	}
})
function selectCommonAjax(pageNo){
	$.ajax({
			type : "post",
			url : path+'/wap/bizinfo/focus/focuUsersByAjax.html',
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
	if(pageNo>=totalPage){
		$('.jiaz').hide();
	}
	for(var i in res){
		var arr = res[i];
		var logName = arr["logName"];
		var userPhoto = arr["userPhoto"];
		var userWechat = arr["userWechat"];
		var logEmail = arr["logEmail"];
		var inner = '<ul class="my_date">'
		+'<li class="my_date_img" style="width:40%;"><img style="width:50px;height:50px;" src="'+localhostPath+userPhoto+'"></li>'
		+'<li class="my_date_title">'
		+'<h3 style="font-size:16px;">'+(logName||"")+'</h3>'
		+'<p style="font-size:16px;padding-top:10px">'+(userWechat||"")+'</p>'
		+'</li>'
		+'</ul>'
		$(".personer_mes").append(inner);
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