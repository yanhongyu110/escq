$(function(){
	$.ajax({
		type: "POST",
		dataType: "json",
		url:path+ "/goodsinfo/service/queryCountRemarkLogIdServiceId.html",
		data:{
			"logId" : logId,
		},
		success: function (data) {
			$('#total0').html(data[0].remark0Count);
			$('#total1').html(data[0].remark1Count);
			$('#total2').html(data[0].remark2Count);
			$('#total3').html(data[0].remark3Count);
		}
	});
	selectCommonAjax(1);
	$("input[name=service_pj]").bind('click',function(){
		selectCommonAjax(1);
	})
})

function selectCommonAjax(page){
	$(".sr_content").html("");
	var srLevel= $("input[name=service_pj]:checked").val();
	var rows=5;//每页显示评论
		$.ajax({
			type: "POST",
			dataType: "json",
			url:path+ "/goodsinfo/service/queryServiceRemarkByLogIdServiceId.html",
			data:{
				"logId" : logId,
				"srLevel" : srLevel,
				"rows" : rows,
				"page" : page
			},
			success: function (data) {
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
						
						var $p= $('<div class="service_content_pj_list"><div class="service_content_pj_list_img"><img src="'+data.list[i].userPhoto+'" /><h3>'+data.list[i].logName+'</h3></div><div class="service_content_pj_list_title"><h3>'+data.list[i].serviceTitle+'</h3><p>'+data.list[i].srContent+'</p><span>'+date+'</span><div class="responseContent remark"><span><b>[回复]</b>:</span><p>'+data.list[i].srResponsecontent+'</p><span>'+responsedate+'</span></div><div class="appendcontent1 remark"><span><b>[追加评论]</b>:</span><p>'+data.list[i].srAppendcontent+'</p><span>'+Appenddate+'</span></div><div class="responseAppendContent remark"><span><b>[追加回复]</b>:</span><p>'+data.list[i].srResponseappendcontent+'</p><span>'+responseAppenddate+'</span></div></div><div class="fu_pj"><span class="fu_pj1"></span><span class="fu_pj2"></span><p>'+data.list[i].srRemark+'.0分</p></div></div>');
						$(".sr_content").append($p);
						/*for (var j = 0; j < data.list[i].srRemark; j++) {
							var $img= $('<img src="../../images/icon_start_red.png"/>');
							$(".fu_pj1").eq(i).append($img);
						}
						for (var k = 0; k < 5-data.list[i].srRemark; k++) {
							var $img1= $('<img src="../../images/icon_start.png"/>');
							$(".fu_pj2").eq(i).append($img1);
						}*/
						
						$(".appendcontent1").eq(i).css({"display":"none","padding":""});
						if(data.list[i].srAppendcontent!=null){
							$(".appendcontent1").eq(i).css("display","block");
						}
						
						$(".responseContent").eq(i).css({"display":"none"});
						if(data.list[i].srResponsecontent!=null){
							$(".responseContent").eq(i).css("display","block");
						}
						
						$(".responseAppendContent").eq(i).css({"display":"none"});
						if(data.list[i].srResponseappendcontent!=null){
							$(".responseAppendContent").eq(i).css("display","block");
						}
					}
			}
		})
}
