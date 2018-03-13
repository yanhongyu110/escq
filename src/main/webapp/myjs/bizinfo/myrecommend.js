var pagesize=5;

function recommend(page){
	if(page==null || page==''){
		page=1;
	}
	window.location.href = path+'/bizinfo/recommendptop/myRecommend.html?page='+page+'&comId='+g_comid;
}

$(function(){
	try {
            pageNum(count, pagesize, pageNo, 'pageDiv');
        } catch (e) {
	}
});

function selectCommonAjax(pageNo){
	window.location.href=path+'/bizinfo/focusutop/focuUsers.html?page='+pageNo+'&pageSize='+pagesize+'&comId='+g_comid;
}

