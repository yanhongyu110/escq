

$(function(){

	if(aBoolean){
		$("#zan").css('color','red');
		$("#zan img").attr("src", path + "/images/wap/dianzan_on.png");
	} else {
        $("#zan").css('color','black')
        $("#zan img").attr("src", path + "/images/wap/dianzan.png");
	}
    var flag = true
	$("#zan").click(function(){
		if (loginfo != '') {
			if(flag) {
				flag = false;
				$.ajax({
					url: path + '/goodsinfo/service/dianzan.html',
					type: 'post',
					dataType: 'json',
					data: {
						'serviceId': serviceId,
						'aBoolean': aBoolean
					},
					success: function (res) {
						flag = true
						if (res.success) {
							var zanNum = parseInt($('#zanNum').html());
							alert(res.errorMsg, '', function () {
								if (aBoolean) {
									$('#zanNum').html(zanNum - 1);
                                    $("#zan img").attr("src", path + "/images/wap/dianzan.png");
                                    $("#zan").css('color','black')
									aBoolean = false
								} else {
									$('#zanNum').html(zanNum + 1);
                                    $("#zan img").attr("src", path + "/images/wap/dianzan_on.png");
                                    $("#zan").css('color','red');
                                    aBoolean = true
								}
							});
						} else {
							alert(res.errorMsg);
						}
					}
				});
			}
        } else {
			alert("请先登陆后再点赞");
		}
    });

	if(loginfo!=null||loginfo!=''){
		$.ajax({
			type: "POST",
			url:path+ "/goodsinfo/cart/isExitCart.html",
			data:{
				"serviceId" :$('#serviceId').val(),
				"scartSource":$('.scartSource').val(),
			},
			success: function (data) {
				var temp=JSON.parse(data);
				console.log(temp)
				if(temp.success){
					$("#xinyuan").text("已加入心愿单");
					$("#xinyuan").css("background","rgb(170,170,170)");
					$("#xinyuan").unbind("click");
				}else{
					$("#xinyuan").html("加入心愿单");
				}
			}
		});
	}
	$("#yuejian").click(function(){
		if(loginfo==null||loginfo==''){
			alert("请先登陆后，再进行约见！");
		}else{
		   var cartList={};
		   cartList.serviceId=$('#serviceId').val();
		   cartList.scartNum=parseInt($('.scartNum').val());
		   console.log(cartList.scartNum);
		   cartList.scartSource=$('.scartSource').val();
		   console.log(cartList);
		   var temp=[];
		   temp.push(cartList);
		   var cart=JSON.stringify(temp);
		  
			$('.cartList').val(cart);
			$('#formsubmit').submit();
		}
		})
		$("#xinyuan").click(function(){
		if(loginfo==null||loginfo==''){
			alert("请先登陆后，再加入心愿！");
		}else{
		  
			$.ajax({
				type: "POST",
				url:path+ "/goodsinfo/cart/addCart.html",
				data:{
					"serviceId" :$('#serviceId').val(),
					"num":$('.scartNum').val(),
					"scartSource":$('.scartSource').val(),
				},
				success: function (data) {
					console.log(data)
					var temp=JSON.parse(data);
					alert(temp.errorMsg);
					$("#xinyuan").text("已加入心愿单");
					$("#xinyuan").css("background","rgb(170,170,170)");
					$("#xinyuan").unbind("click");
				}
			});
		}
		})
	
	//设计案例切换
	$('.title-list li').bind('click', function() {
		var liindex = $(this).index();
		$("input[name=service_pj]").css({"margin-left":"10px"})
		if(liindex==1){
			$.ajax({
				type: "POST",
				dataType: "json",
				url:path+ "/goodsinfo/service/queryCountRemark.html",
				data:{
					"serviceId" :$('#serviceId').val(),
				},
				success: function (data) {
					total0.innerHTML=data[0].remark0Count;
					total1.innerHTML=data[0].remark1Count;
					total2.innerHTML=data[0].remark2Count;
					total3.innerHTML=data[0].remark3Count;
				}
			});
			
			selectCommonAjax(1);
			$("input[name=service_pj]").bind('click',function(){
				selectCommonAjax(1);
			})
		}
		$(this).addClass('on').siblings().removeClass('on');
		$('.service_content div.service_content_pj').eq(liindex).fadeIn(150).siblings('div.service_content_pj').hide();
		var liWidth = $('.title-list li').width();
		
		$('.content_left_content .title-list p').stop(false,true).animate({'left' : liindex * liWidth + 'px'},300);
	});
	
	
	//设计案例hover效果
	$('.service_content .service_content_pj li').hover(function(){
		$(this).css("border-color","#ff6600");
		$(this).find('p > a').css('color','#ff6600');
		
	},function(){
		$(this).css("border-color","#fafafa");
		$(this).find('p > a').css('color','#666666');
	});
});


function selectCommonAjax(page){
	var srLevel= $("input[name=service_pj]:checked").val();
	var rows=3;//每页评论条数
	
		$.ajax({
			type: "POST",
			dataType: "json",
			url:path+ "/goodsinfo/service/queryServiceRemark.html",
			data:{
				"serviceId" :$('#serviceId').val(),
				"srLevel" : srLevel,
				"rows" : rows,
				"page" : page
			},
			success: function (data) {
				if(servicecount==0){
					$(".select_pj").css("display","none");
					$(".note_message").css({"display":"block"});
				}
					$(".sr_content").html("");
					for (var i = 0; i < data.list.length; i++) {
						pageNum(data.totalSize,rows,data.page,"fy");
						var date1 = new Date(data.list[i].srCreatetime).toLocaleDateString(); 
						var date2 = new Date(data.list[i].srCreatetime).toLocaleTimeString(); 
						var date=date1+=date2; 
						
						var Appenddate1 = new Date(data.list[i].srAppendtime).toLocaleDateString(); 
						var Appenddate2 = new Date(data.list[i].srAppendtime).toLocaleTimeString(); 
						var Appenddate=Appenddate1+=Appenddate2; 
						
						var responsedate1 = new Date(data.list[i].srResponsetime).toLocaleDateString(); 
						var responsedate2 = new Date(data.list[i].srResponsetime).toLocaleTimeString(); 
						var responsedate=responsedate1+=responsedate2; 
	
						var responseAppenddate1 = new Date(data.list[i].srResponseappendtime).toLocaleDateString(); 
						var responseAppenddate2 = new Date(data.list[i].srResponseappendtime).toLocaleTimeString(); 
						var responseAppenddate=responseAppenddate1+=responseAppenddate2; 
						
						
						var $p= $('<div class="service_content_pj_list"><div class="service_content_pj_list_zi remark"><div class="service_content_pj_list_img"><img src="'+data.list[i].userPhoto+'" alt="未加载图片" /></div><div class="service_content_pj_list_title"><div id="logname">'+data.list[i].logName+'</div><p>'+data.list[i].srContent+'</p><span>'+date+'</span> <span>源自：'+$("#servicetitle").val()+'</span> <span class="service_content_pj_list_zan">'+data.list[i].srRemark+'</span><div class="responseContent remark"><span><b>[回复]</b>:</span><p>'+data.list[i].srResponsecontent+'</p><span>'+responsedate+'</span></div><div class="appendcontent remark"><span><b>[追加评论]</b>:</span><p>'+data.list[i].srAppendcontent+'</p><span>'+Appenddate+'</span></div><div class="responseAppendContent remark"><span><b>[追加回复]</b>:</span><p>'+data.list[i].srResponseappendcontent+'</p><span>'+responseAppenddate+'</span></div></div></div></div>')
						
						$(".sr_content").append($p);
						$(".service_content_pj_list_title").css({"margin-left":"0px"});
						
						$(".responseContent").eq(i).css({"display":"none"});
						
						
						if(data.list[i].srResponsecontent!=null){
							$(".responseContent").eq(i).css("display","block");
						}
						
						$(".responseAppendContent").eq(i).css({"display":"none"});
						if(data.list[i].srResponseappendcontent!=null){
							$(".responseAppendContent").eq(i).css("display","block");
						}
						
						$(".appendcontent").eq(i).css({"display":"none"});
						if(data.list[i].srAppendcontent!=null){
							$(".appendcontent").eq(i).css("display","block");
						}
						
					}
					
			}
		})
}

