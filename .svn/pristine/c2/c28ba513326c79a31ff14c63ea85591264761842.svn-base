/**
 * 获取参数
 * 
 * @param name
 * @returns
 */
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return decodeURI(r[2]); return null; 
}
var parentId = "";
$(function(){
	parentId = getQueryString("parentId");
});

function getopenid(){
	var redirect_uri = encodeURIComponent("http://www.jindaoj.com/wap/userinfo/logInfo/jumpJdjerweima.html");
	window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd0c763640d4b8f08&redirect_uri="
		+ redirect_uri
		+ "&response_type=code&scope=snsapi_base&state="
		+ encodeURIComponent("http://www.jindaoj.com/wap/userinfo/logInfo/jumpJdjerweima.html)+"#wechat_redirect";
}
//function getopenid(){
//	var redirect_uri = encodeURIComponent("http://www.jindaoj.com/activity/weiXinRedPacket/payWeiXinAction.htm");
//	window.location.href = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd0c763640d4b8f08&redirect_uri="
//		+ redirect_uri
//		+ "&response_type=code&scope=snsapi_base&state="
//		+ encodeURIComponent("http://www.jindaoj.com/wap/userinfo/logInfo/jumpJdjerweima.html?parentId="+parentId)+"#wechat_redirect";
//}