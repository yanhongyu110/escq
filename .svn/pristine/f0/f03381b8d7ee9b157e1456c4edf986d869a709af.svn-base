var totalPage = Math.ceil(count / 4);
var pageNo=1;
var url;
var url1;
var index1;
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


    var liWidth = $('.title-list li').width();
    if(f == 1){
        index1 = 0;
        url = '/wap/bizinfo/collectUtod/showCollectListByAjax.html';
        url1 = '/wap/bizinfo/collectUtod/deleteCollect.html';
    } else {
        index1 = 1;
        url = '/wap/goodsinfo/cart/showCartListByAjax.html';
        url1 = '/wap/goodsinfo/cart/deletecart.html';
    }
    $('.my_date_bt .title-list p').stop(false, true).animate({
        'left': index1 * liWidth + 'px'
    }, 300);
    $('.title-list li').removeClass('on').eq(index1).addClass('on');

    $("#li1").on("click",function(){
        window.location.href = path + '/wap/bizinfo/collectUtod/myCollects.html';
    });

    $("#li3").on("click",function(){
        window.location.href = path + '/wap/goodsinfo/cart/showCartList.html';
    });

	$(".content_list").empty();
	if(index1 == 0){
        showDiv(jsonList,1);
    } else {
        showDiv1(jsonList,1);
	}

	/*$('.jiaz').click(function(){
        pageNo=pageNo+1;
        selectCommonAjax(pageNo);
    });*/

	if(!$(".content_list").html()){
		$(".content_list").html('<div class="jiaz" >没有添加收藏哟...</div>');
	}
	$('.go').each(function(){
		var obj=$(this)
		obj.click(function(){
			var pp=obj.parents(".my_like_list")
			var demId=$(".demId").val();
			window.location.href=path+'/wap/demand/queryById.html?id='+demId;
		})
	})
})
function selectCommonAjax(pageNo){
	$.ajax({
			type : "post",
			url : path+url,
			dataType:'text',
			data:{
				'page':pageNo,
				'logId':$('#thelogid').val()
			},
			success:function(res){
				s = true;
				if(index1 == 0){
                    showDiv(res.list,res.pageNo);
                } else {
                    showDiv1(res.list,res.pageNo);
				}
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
		var userPhoto = arr["userPhoto"];
		var demTitle = arr["demTitle"];
		var demBrief = arr["demBrief"];
		var demContact = arr["demContact"];
		var demCell = arr["demCell"];
		var demKeyword = arr["demKeyword"];
		var demId = arr['demId'];
		var inner = '<a href="'+path+'/wap/demand/queryById.html?id='+demId+'">'
			+'<div class="service_list">'
			+'<input type="hidden" class="demId" value="'+demId+'"  />'
			+'<div class="service_list_img">'
			+'<img src="'+path+(userPhoto||"")+'" />'
			+'</div>'
			+'<div class="service_list_title" style="width:49%">'
			+'<h3 >'+(demTitle||"")+'</h3>'
			
			+'<div class="con_collect">'+(demBrief||"")+'</div>'
			
			
			
			
			+'</div>'
			+'<div style="float:right;width:20%;margin-top:10px;margin-right:2%;text-align: right;">'
			+'<a href="javascript:void(0)" onclick="del(\''+(demId||"")+'\')" style="color: #fff;background: #f40;text-align: center;font-size: 16px;padding:5px 10px;float:right;width:100%">删除收藏</a>'
			
			+'</div>'
			+'</div></a>'
		$(".content_list").append(inner);
		cut()
	 }

}

function showDiv1(res,pageNo){
    if(pageNo>=totalPage){
        $('.jiaz').hide();
    }
    for(var i in res){
        var arr = res[i];
        var servicePic = arr["serviceSnapshot"].serviceInfo.servicePic;
        var serviceTitle = arr["serviceSnapshot"].serviceInfo.serviceTitle;
        var serviceBiref = arr["serviceSnapshot"].serviceInfo.serviceBiref;
        var scartPrice = arr["scartPrice"];
        var serviceId = arr["serviceId"];
        var scartId = arr["scartId"];
        var logId = arr["logId"];
        var inner = '<a href="'+path+'/wap/goodsinfo/service/queryServiceDetails.html?serviceId='+serviceId+'&priceType=1">'
            +'<div class="service_list">'
            +'<div class="service_list_img">'
            +'<img  src="'+localhostPath+(servicePic||"")+'" />'
            +'</div>'
            +'<div class="service_list_title" style="width:49%">'
            +'<h3 >'+(serviceTitle||"")+'</h3>'
            /*+'<div class="con_collect" cut="35">'+(serviceBiref||"")+'<div>'*/
            +'<span><b >'+(scartPrice||0)+'</b>元/次</span>'
           
            +'</div>'
            +'<div style="float:right;width: 20%;margin-top:10px;margin-right:2%;text-align: right;">'
            +'<a href="javascript:void(0)" onclick="del(\''+(scartId||"")+'\',\''+(logId||"")+'\')" style="color: #fff;background: #f40;text-align: center;font-size: 16px;padding:5px 10px;float:right;width:100%">删除收藏</a>'

            +'</div>'
            +'</div></a>'
        $(".content_list").append(inner);
        cut()
    }

}

function del(demId){
	alert("请确定是否删除收藏！",null,function(){temp(demId)},function(){});
}	

function temp(demId){
	$.ajax({
		url:path+url1,
		data:{
			'id':demId,
			'logId': $('#thelogid').val()
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