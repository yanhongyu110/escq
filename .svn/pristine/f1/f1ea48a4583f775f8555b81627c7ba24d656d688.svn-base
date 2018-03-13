var pagesize = 5;
function myfocus(page) {
    if (page == null || page == '') {
        page = 1;
    }
    window.location.href = path + '/bizinfo/focusutop/myFocus.html?page=' + page + '&comId=' + g_comid;
}


$(function () {
    try {
        pageNum(count, pagesize, pageNo, 'pageDiv');
    } catch (e) {
    }
});
var temp = function (tt) {
    var hehe = tt.parents('.my_focus_list').find(".futpProvider").val();
    console.log(hehe);
    $.ajax({
        url: path + "/bizinfo/focusutop/deleteFocus.html",
        data: {
            providerLogId: tt.parents('.my_focus_lists').find(".futpProvider").val(),
        },
        dataType: 'json',
        type: 'post',
        cache: false,
        success: function (data) {
            alert(data.errorMsg, null, function () {
                window.location.reload();
            }, null);
        },
        error: function (data) {
            alert(data.errorMsg);
        }
    });
}
function del(src) {
    var hehe = $(src);
    alert("请确定是否删除关注！", null, function (tt) {
        temp(hehe)
    }, function () {
    });
}
function selectCommonAjax(pageNo) {
    window.location.href = path + '/bizinfo/focusutop/myFocus.html?page=' + pageNo + '&pageSize=' + pagesize + '&comId=' + g_comid;
}

