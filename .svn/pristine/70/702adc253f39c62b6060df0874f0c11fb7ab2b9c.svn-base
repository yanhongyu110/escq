	var pageSize=5;
	function mycollect(page){
		if(page==null || page==''){
			page=1;
		}
		window.location.href = path+'/bizinfo/collectutop/myCollects.html?page='+page+'&pageSize='+pageSize+'comId='+g_comid;
	}

	$(function(){
		try {
	            pageNum(count, pageSize, 1, 'pageDiv');
	        } catch (e) {
		}
	});
	var temp=function(tt){
		var hehe=tt.parents('.my_collect_lists').find(".cutdDemand").val();
		console.log(hehe);
		$.ajax({
			url:path+"/bizinfo/collectUtod/deleteCollect.html",
			data:{
				demId:tt.parents('.my_like_list').find(".cutdDemand").val(),
			},
			dataType:'json',
			type:'post',
			cache:false,
			success:function(data){
				alert(data.errorMsg,null,function(){window.location.reload();},null);
			},
			error:function(data){
				alert(data.errorMsg);
			}
		});
	}
	function del(src){
		var hehe=$(src);
		alert("请确定是否删除收藏！",null,function(tt){temp(hehe)},function(){});
	}	
	function selectCommonAjax(pageNo){
		window.location.href=path+'/bizinfo/collectutop/myCollects.html?page='+page+'&pageSize='+pageSize+'comId='+g_comid;
	}

