function cartlist(page){
	if(page==null || page==''){
		page=1;
	}
	window.location.href = path+'/goodsinfo/cart/viewCart.html?page='+page+'&comId='+g_comid;
}

$(function(){
	try {
            pageNum(count, 10, pageNo, 'pageDiv');
        } catch (e) {
	}
});

function del(src){
	var hehe=$(src);
	alert("请确定是否删除关注！",null,function(tt){temp(hehe)},function(){});
}	

var temp=function(tt){
	$.ajax({
		url:path+"/goodsinfo/cart/deletecart.html",
		data:{
			scartId:tt.parents('.my_like_list').find("#scartId").val(),
			logId:tt.parents('.my_like_list').find("#logId").val(),
		},
		dataType:'json',
		type:'post',
		cache:false,
		success:function(data){
			alert(data,null,function(){window.location.reload();},null);
			//console.info(data);
		},
		error:function(data){
			console.info(data);
		}
	});
}
function add(){
	$.ajax({
		url:path+"/goodsinfo/cart/insertcart.html",
		data:{
			sId:$("#serviceId").val(),
			lId:$("#logId").val(),
			ajso:$("#jso").val()
		},
		datatype:'json',
		type:'post',
		success:function(res){
			var j = JSON.parse(res);
			if(j.success){
			alert("预约成功");
			}else{
				alert(res.errorMsg);
			}
		},
		error:function(data){
			console.info(data);
		}
	});

}
function selectCommonAjax(pageNo){
	window.location.href=path+'/goodsinfo/cart/viewCart.html?page='+pageNo+'&pageSize=10'+'&comId='+g_comid;
}
