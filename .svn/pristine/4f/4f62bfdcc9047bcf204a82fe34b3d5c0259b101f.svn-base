$(function(){
	if(null!=loginfo&''!=loginfo){
		$.ajax({
			type: "POST",
			url:path+ "/bizinfo/collectUtod/judgeCollect.html",
			data:{
				"demId":$("#demId").val()
			},
			success: function (data) {
				var temp=JSON.parse(data);
				console.log(temp)
				if(temp.success){
					$("#collect").removeClass("guanzhu");
					$("#collect").addClass("guanzhu_on");
					$("#collect").html("已收藏");
				}else{
					$("#collect").html("收藏");
				}
			}
		});
	}
	$("#collect").click(function(){
		if(loginfo==null||loginfo==''){
			alert("请先登陆后，再加入收藏！");
		}else{
			$.ajax({
				type: "POST",
				url:path+ "/wap/bizinfo/collectUtod/addCollect.html",
				data:{
					"demId" :$('#demId').val()
				},
				success: function (data) {
					var temp=JSON.parse(data);
					alert(temp.errorMsg,'',function () {
						window.location.reload();
                    });
				}
			});
		}
	})
});


/**
 *
 * @param type  1 -微信好友、2-微信朋友圈、3-qq好友、4-qq空间、5-微博
 * @param title
 * @param content
 * @param url 分享的链接地址
 * @param imgurl 分享的图片url
 */
function wapShare(type,title,content,url,imgurl) {
    var ua = navigator.userAgent.toLowerCase();
    if (/iphone|ipad|ipod/.test(ua)) {
        fxshare(type,title,content,url,imgurl);
    } else if (/android/.test(ua)) {
        window.android.fxShare(type,title,content,url,imgurl);
    }
}