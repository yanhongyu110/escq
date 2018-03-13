function focuusers(page){
	if(page==null || page==''){
		page=1;
	}
	window.location.href = path+'/bizinfo/focusutop/focuUsers.html?page='+page+'&comId='+g_comid;
}

$(function(){
	try {
            pageNum(count, 10, pageNo, 'pageDiv');
        } catch (e) {
	}
});

function selectCommonAjax(pageNo){
	window.location.href=path+'/bizinfo/focusutop/focuUsers.html?page='+pageNo+'&pageSize=10'+'&comId='+g_comid;
}
if(foculen<10){
	$("#pageDiv").hide();}