var n = 1;
var state = 2;
var liindex;
var page=1;
var pageSize=10;
var ss=true;
var totalpage=0;
$(function(){
	selectCommonAjax(1);
	$('.title-list li').click(function() {
		state = $(this).data("id");
		page=1;
		if(state==null){
			state=2;
		}
		if(state == 2)
			liindex = 0;
		if(state == 3)
			liindex = 1;
		if(state == 1)
			liindex = 2;
		if(state == 4)
			liindex = 3;
		var liWidth = $('.title-list li').width();
		$('.my_date_bt .title-list p').stop(false, true).animate({
			'left': liindex * liWidth + 'px'
		}, 300);
		$('.title-list li').removeClass('on').eq(liindex).addClass('on');
		ss=true;
		selectCommonAjax(page);
		
	});
	
	
	
	
	// $('.pagination').jqPagination({
	// 	  link_string : '/?page={page_number}',
	// 	  current_page: page, //设置当前页 默认为1
	// 	  max_page : maxPage, //设置最大页 默认为1
	// 	  page_string : '当前第{current_page}页,共{max_page}页',
	// 	  paged : function(n) {
	// 	      window.location.href = path + '/wap/goodsinfo/service/viewProviderService.html?page='+n+'&serviceState='+state;
	//       }
	// });


    $('body').bind('touchmove', function(e) {
        if($(window).scrollTop()>=$(document).height()-$(window).height()&ss){
                page++;
               selectCommonAjax(page);
        }
    });

	


});
function selectCommonAjax(pageNo){
	if(ss){
		ss=false;
	$.ajax({
			type : "post",
			url : path+'/wap/goodsinfo/service/getProviderService.html',
			dataType:'json',
			data:{
				'serviceState':state,
				'page':pageNo,
				'pageSize':pageSize
			},
			success:function(res){
				if(page==1){
					$(".personer_mes").html("");
				}
					if(res.success){
						if(res.obj.list.length>0){
							showDiv(res,pageNo);
							if(res.obj.list.totalSize>pageSize){
								ss=true;
							}
						}else{
							$(".personer_mes").html("");
							$('.jiaz').show();
							$('.jiaz').text("没有更多了");
						}

					}else{
						alert(res.errorMsg);
					}
					
			},error:function (XMLHttpRequest, textStatus, errorThrown) {
				alert("加载数据失败");
			}
	});
	}
}

function showDiv(res,pageNo){
	var serviceList=res.obj.list;
	for(var i in serviceList){
		var arr = serviceList[i];
		var serviceTitle = arr["serviceTitle"];
		var psetPrice = arr["psetPrice"];
		var serviceMeettime = arr["serviceMeettime"];
		var psetCreateTimeString = arr["psetCreateTimeString"];
		var servicePic = arr["servicePic"];
		var serviceId = arr["serviceId"];
		var serviceStateStr = arr["serviceStateStr"];
		var inner = '<ul class="my_date">'+
			'<li class="my_date_img"><img src="'+servicePic+'"></li>'+
			'<li class="my_date_title" style="width: 32%;padding-top:10px;">'+
				'<h3>'+serviceTitle+'</h3>'+'</li>'+
			'<li class="my_date_zt"><p>￥'+psetPrice+'</p></li>'+
			'<li class="my_date_zt">'+
				'<a href="'+path+'/wap/goodsinfo/service/viewModifyService.html?serviceId='+serviceId+'">编辑</a>'+
				'</li>'+
			'<li class="closed"><a href = "javascript:void(0);" onclick =delService("'+serviceId+'")><img src="'+path+'/images/wap/wrong.png"></a></li></ul>'
		$(".personer_mes").append(inner);
	 }
	if(pageNo>=res.obj.totalPage){
		$('.jiaz').text("没有更多了");
		ss=false;
	}else{
		$('.jiaz').text("加载更多");
		ss=true;
	}
	$('.jiaz').show();

}

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

function delService(id){
	alert("确认删除吗？","提示",function(){
		$.ajax({
			url: path + "/wap/goodsinfo/service/deleteService.html",
			type:'post',
			dataType:'json',
			data:{
				'serviceId':id
			},
			success:function(res){
				if(res.success){
					alert(res.errorMsg,"",function(){
						window.location.href = path + '/wap/goodsinfo/service/viewProviderService.html?page='+n+'&serviceState='+state;
					});
				} else {
					alert(res.errorMsg);
				}
			}
		});
	},function(){return false;});
}