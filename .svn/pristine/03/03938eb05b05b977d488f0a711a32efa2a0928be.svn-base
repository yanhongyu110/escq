var order = "PI_DEALNUM DESC";
$(function(){
	showDiv(jsonList1,jsonList2,jsonList3,jsonList4,1);
	$('.sv_sx_zz a').click(function(){
		$(this).siblings().css("color","#999");
		$(this).siblings().css("border","none");
		$(this).siblings().css("background","url("+path+"/images/up.png) no-repeat 75px 5px");
		$('.no_bg').css("background","none");
		if($(this).text()=='综合排序'){
			order = 'PI_DEALNUM DESC';
			$(this).css("color","#FB5A5A");
			$(this).css("border","1px solid #FB5A5A");
		}else if($(this).text()=='约见最多'){
			order = 'PI_MEETNUM DESC';
			$(this).css("color","#FB5A5A");
			$(this).css("background","url("+path+"/images/up_hover.png) no-repeat 75px 5px");
			$(this).css("border","1px solid #FB5A5A");
		}else if($(this).text()=='口碑最好'){
			order = 'PI_MARK DESC';
			$(this).css("color","#FB5A5A");
			$(this).css("background","url("+path+"/images/up_hover.png) no-repeat 75px 5px");
			$(this).css("border","1px solid #FB5A5A");
		}
		selectCommonAjax(1);
	});
	$(".expert_sp").on('mouseenter mouseleave','ul li',function(event){
		if(event.type=='mouseenter'){
			$(this).find(".sp_mes").stop().animate({height:"167px"},400);
			$(this).find(".sp_mes h3").stop().animate({paddingTop:"20px"},400);
		}else if(event.type=='mouseleave'){
			$(this).find(".sp_mes").stop().animate({height:"45px"},400);
			$(this).find(".sp_mes h3").stop().animate({paddingTop:"0px"},400);
		}
	});
})
function selectCommonAjax(pageNo){
	$.ajax({
			type : "post",
			url : path+'/goodsinfo/ServiceInfo/showVideoListByAjax.html',
			dataType:'json',
			data:{
				'page':pageNo,
				'order':order
			},
			success:function(res){
				$('#allcount').empty();
				$('#allcount').append(res.count);
				count = res.count;
				$("#mmyul1").empty();
				$("#mmyul2").empty();
				$("#mmyul3").empty();
				$("#mmyul4").empty();
				$("#pageDiv").empty();
				showDiv(res.videoList1,res.videoList2,res.videoList3,res.videoList4,res.pageNo);
			},error:function (XMLHttpRequest, textStatus, errorThrown) {
				alert("请求对象XMLHttpRequest: "+XMLHttpRequest);
				alert("错误类型textStatus: "+textStatus);
				alert("异常对象errorThrown: "+errorThrown);
			}
	});
}
function showDiv(res1,res2,res3,res4,pageNo){
	console.info(res3)
	console.info(res4)
	for(var i in res1){
		var arr = res1[i];
		var piRealname = arr["piRealname"];
		var piCompany = arr["piCompany"];
		var piPosition = arr["piPosition"];
		var piBrief = arr["piBrief"].substring(0,60);
		if(arr["piBrief"].length>60){
			piBrief = piBrief +"...";
		}
		var piVideo = arr["piVideo"];
		var piMark = arr["piMark"].toFixed(0);
		var piId = arr["piId"];
		var piComment = path+arr['piComment'];
		var inner = '<li style="float:left;">'
		+'<img width="252px" height="168px" src="'+(piComment||"")+'" />'
		+'<div class="sp_mes">'
		+'<h3>'+(piRealname||"")+'</h3>'
		+'<p>'+(piBrief||"")+'</p>'
		+'</div>'
		+'<div class="bf_btn" onclick="showVideo(\''+(piVideo||"")+'\')"></div>'
		+'</li>'
		$("#mmyul1").append(inner);
	 }
	for(var i in res2){
		var arr = res2[i];
		var piRealname = arr["piRealname"];
		var piCompany = arr["piCompany"];
		var piPosition = arr["piPosition"];
		var piBrief = arr["piBrief"].substring(0,60);
		if(arr["piBrief"].length>60){
			piBrief = piBrief +"...";
		}
		var piVideo = arr["piVideo"];
		var piMark = arr["piMark"].toFixed(0);
		var piId = arr["piId"];
		var piComment = path+arr['piComment'];
		var inner = '<li style="float:left;">'
			+'<img width="252px" height="168px" src="'+(piComment||"")+'" />'
			+'<div class="sp_mes">'
			+'<h3>'+(piRealname||"")+'</h3>'
			+'<p>'+(piBrief||"")+'</p>'
			+'</div>'
			+'<div class="bf_btn" onclick="showVideo(\''+(piVideo||"")+'\')"></div>'
			+'</li>'
		$("#mmyul2").append(inner);
	 }
	for(var i in res3){
		var arr = res3[i];
		var piRealname = arr["piRealname"];
		var piCompany = arr["piCompany"];
		var piPosition = arr["piPosition"];
		var piBrief = arr["piBrief"].substring(0,60);
		if(arr["piBrief"].length>60){
			piBrief = piBrief +"...";
		}
		var piVideo = arr["piVideo"];
		var piMark = arr["piMark"].toFixed(0);
		var piId = arr["piId"];
		var piComment = path+arr['piComment'];
		var inner = '<li style="float:left;">'
			+'<img width="252px" height="168px" src="'+(piComment||"")+'" />'
			+'<div class="sp_mes">'
			+'<h3>'+(piRealname||"")+'</h3>'
			+'<p>'+(piBrief||"")+'</p>'
			+'</div>'
			+'<div class="bf_btn" onclick="showVideo(\''+(piVideo||"")+'\')"></div>'
			+'</li>'
		$("#mmyul3").append(inner);
	 }
	for(var i in res4){
		var arr = res4[i];
		var piRealname = arr["piRealname"];
		var piCompany = arr["piCompany"];
		var piPosition = arr["piPosition"];
		var piBrief = arr["piBrief"].substring(0,60);
		if(arr["piBrief"].length>60){
			piBrief = piBrief +"...";
		}
		var piVideo = arr["piVideo"];
		var piMark = arr["piMark"].toFixed(0);
		var piId = arr["piId"];
		var piComment = path+arr['piComment'];
		var inner = '<li style="float:left;">'
			+'<img width="252px" height="168px" src="'+(piComment||"")+'" />'
			+'<div class="sp_mes">'
			+'<h3>'+(piRealname||"")+'</h3>'
			+'<p>'+(piBrief||"")+'</p>'
			+'</div>'
			+'<div class="bf_btn" onclick="showVideo(\''+(piVideo||"")+'\')"></div>'
			+'</li>'
		$("#mmyul4").append(inner);
	 }
	pageNum(count,16 ,pageNo,'pageDiv');
}
function showVideo(src){
	showDialog();
	$('#myvideoo').attr("src",src||"");
	$('#myvideodiv').show();
}
function hideVideo(){
	closeDialog();
	$('#myvideodiv').hide();
	$('#myvideoo').attr("src","");
}
function showDialog() {
    document.getElementById('popWindow').style.display = 'block';
    document.getElementById('popWindow').style.height = document.body.offsetHeight;
}
function closeDialog() {
    document.getElementById('popWindow').style.display = 'none';
}