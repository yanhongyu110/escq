$(function(){
	$('.bianji').mouseover(function(){
		$(this).css({background:"url(" +path +"/images/bianji.png) no-repeat right",color:"#fb5a5a"});
	});
	$('.bianji').mouseout(function(){
		$(this).css({background:"url(" +path +"/images/bianji_wu.png) no-repeat right",color:"#000"});
	});
	
	$(".delBtn").click(function(){
		var val = $(this).attr('alt');
		alert("请确定是否删除?",null,function(){
			$.ajax({
				url:path + "/demand/deleteById.html",
				data:{
					demId : val
				},
				type:'post',
				cache:false,
				dataType:'json',
				success:function(data){
					if(data.success){
						alert("删除成功","成功",function(){
							window.location.reload();
						});
					} else {
						alert("删除成功","成功");
					}
				}
				
			});
		},function(){});
	});
	//模糊检索
	$('.btn').click(function(){
		$('#fom').submit();
	});
	$('#publicDate1').datetimebox({
	    required: true,
	    height:25,
	    editable:false,
	    showSeconds: false
	});

	$('#publicDate2').datetimebox({
		required: true,
		height:25,
		editable:false,
		showSeconds: false
	});
	
});


function serviceAdminList(page){
	if(page==null || page==''){
		page=1;
	}
	window.location.href = path+'/goodsinfo/service/viewProviderService.html?page='+page+'&comId='+g_comid;
}