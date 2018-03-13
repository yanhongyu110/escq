var state = "";
var page;
var s = true;

$(function(){
	queryDemand(2, 10);

    $('body').bind('touchmove', function(e) {
        if($(window).scrollTop()>=$(document).height()-$(window).height()){
            if(s) {
                queryDemand(state, page + 10);
                s = false;
            }
        }
    });

	$(".cf li").on("click",function(){
		state = $(this).data("id");
		$("#service_content_pj").html("");
		/*$("#more").on("click",function(){
			queryDemand(state, page + 10);
		});*/

		queryDemand(state, 10);
	});
	
	/*$("#more").on("click",function(){
		queryDemand(state, page + 10);
	});*/
	
	$(document).on("click",".del",function(){
		var id = $(this).parent().find("span").html();
		del(id);
	});
});


function queryDemand(st,n){
	$.ajax({
		url: path + "/wap/demand/queryDemandAmind.html",
		type: 'post',
		dataType:"json",
		data:{
			'demState':st,
			'page':n
		},
		success:function(res){
			var taotalPage = res.taotalPage;
			state = res.demand.demState;
			page = res.page;
			var demand = res.list;
			var html = "";
			$.each(demand,function(i, v){
				html += '<div class="personer_mest">'+
									'<ul class="my_date have_border">'+
									'<li class="my_date_img">';
				if(v.demImage == null || v.demImage == ''){
					html +='<img src="'+path+'/images/wap/xq_picture.jpg"></li>';
				}else{
					html +='<img src="'+v.demImage+'"></li>';
				}
				html+='<li class="my_date_title">'+
										'<h3>'+v.demTitle+'</h3>'+
										'<span>'+v.demCreatetimeStr+'</span>'+
										/*'<p style="width: 180px;height: 25px;overflow: hidden;color:black;">'+v.demBrief+'</p>'+*/
									'</li>'+
									'<li class="closed"><span style="display:none;">'+v.demId+'</span><a class="del"><img src="'+path +'/images/wap/wrong.png" width="19"></a></li>'+
									'<li class="my_date_zt">'+
										'<p><a href="'+path+'/wap/demand/gotoUpdateDemand.html?id='+v.demId+'">修改</a></p>'+
										
									'</li>'+
									
								'</ul>'+
							'</div>';
			});
			$("#service_content_pj").html(html);
			if(n >= taotalPage){
				$("#more").html("没有更多了");
				/*$("#more").off("click");*/
			} else {
                $("#more").html("查看更多");
				s = true;
			}
		}
	});
}

function del(id){
	alert("确认删除吗？","提示",function(){
		$.ajax({
			url: path + "/wap/demand/deleteById.html",
			type:'post',
			dataType:'json',
			data:{
				'demId':id,
				'demIsdelete':true
			},
			success:function(res){
				alert("删除成功","",function(){
					queryDemand(state, page);
				});
			}
		});
	},function(){return false;})
}