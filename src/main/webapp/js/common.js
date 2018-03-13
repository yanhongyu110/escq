var currentPagepath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos
if (pathName == "/") {
    pos = currentPagepath
} else {
    pos = currentPagepath.indexOf(pathName);
}

var localhostPath = currentPagepath.substring(0, pos);
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
if (projectName == '/escq') {
    var path = localhostPath + projectName;
} else {
    var path = localhostPath;
}




/**
 *  分页
 * @param total 总条数
 * @param pageNo 当前页
 * @param pageDiv 分页div的ID
 * @param rows 每页显示的条数
 */
function pageNum(total, rows, pageNo, pageDiv) {
    var totalPage = Math.ceil(total / rows);
    var addHtml = '';//要显示的内容
    var pageNumSize = 5;//表示最多一页显示多少条页码号
    var pageNo = pageNo; //表示当前的页数
    var totalPages = totalPage; //表示一共要显示多少页的数据
    var startPageNo = '';
    var endPageNo = '';
    $('#' + pageDiv).css("text-align", "right");
    $('#' + pageDiv).html('');
    if (pageNo % pageNumSize == 0) {
        startPageNo = (pageNo - pageNumSize) + 1;
        endPageNo = pageNo;
    } else {
        startPageNo = (Math.floor((pageNo / pageNumSize))) * pageNumSize + 1;//开始页码数
        endPageNo = (Math.floor((pageNo + pageNumSize - 1) / pageNumSize)) * pageNumSize;//结束页码数
    }
    if (totalPage != 0) {
        addHtml = '<a href="javascript:void(0)" onclick="selectCommonAjax(1)">首页</a><a href="javascript:void(0)" onclick="selectCommonAjax(' + (pageNo - 1) + '<1?1:' + (pageNo - 1) + ')">上一页</a>';
        for (var i = startPageNo; i <= (endPageNo > totalPages ? totalPages : endPageNo); i++) {
            if (i == pageNo) {
                addHtml += '<a href="javascript:void(0)" style="border:1px solid #FB5A5A;background-color:#FB5A5A; color:#fff;" class="x_xzxg" onclick="selectCommonAjax(' + i + ')">' + i + '</a>';
            } else {
                addHtml += '<a href="javascript:void(0)" onclick="selectCommonAjax(' + i + ')">' + i + '</a>';
            }
        }
        addHtml += '<a href="javascript:void(0)" onclick="selectCommonAjax(' + (pageNo + 1) + '>' + totalPage + '?' + totalPage + ':' + (pageNo + 1) + ')">下一页</a><a href="javascript:void(0)" onclick="selectCommonAjax(' + totalPage + ')">最后页</a>'
            + '<span class="x_tiao">共' + totalPages + '页跳至<span class="x_ip"><input style="width: 30px;height:25px;text-align: center;margin-left:5px;padding:0;" type="text" value="' + pageNo + '" id="pagevalue"/></span>'
            + '<span class="x_goo"><input style="width: 30px;height:25px;line-height:25px;margin-left:5px;padding:0;border:0;text-align: center; background-color:#464857;color:#fff" type="button" value="go" onclick="selectCommonAjax(' + totalPage + '<$(\'#pagevalue\').val()?' + pageNo + ':$(\'#pagevalue\').val())"/></span></span>';
        $('#' + pageDiv).html(addHtml);
    }
}
//操作cookie 添加cookie time :时间  天数
function setCookie(name,value,time)
{
	var Days = time;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days*24*60*60*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}
//获取cookie
function getCookie(name)
{
	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	if(arr=document.cookie.match(reg))
	return unescape(arr[2]);
	else
	return null;
}
//删除cookie
function delCookie(name)
{
	var exp = new Date(0);
	var cval=getCookie(name);
	if(cval!=null)
	document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}

