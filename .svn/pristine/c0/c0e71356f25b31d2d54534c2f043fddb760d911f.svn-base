var currentPagepath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos
if (pathName=="/"){
	pos= currentPagepath
}else {
	pos= currentPagepath.indexOf(pathName);
}

var localhostPath = currentPagepath.substring(0,pos);
var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
if (projectName=='/esc'){
	var path = localhostPath + projectName;
}else {
	var path = localhostPath;
}
var pageNo = 1;
$(function() {

	$("#yuejian").click(function() {
		var cartList = {};
		cartList.serviceId = $('#serviceId').val();
		cartList.scartNum = parseInt($('.scartNum').val());
		console.log(cartList.scartNum);
		cartList.scartSource = $('.scartSource').val();
		console.log(cartList);
		var temp = [];
		temp.push(cartList);
		var cart = JSON.stringify(temp);
		$('.cartList').val(cart);
		$('#formsubmit').submit();
	})
	
	$(".pl").click(function(){
		console.info(111)
		if(loginfo==null||loginfo==''){
			alert("请先登陆后，再加入心愿！");
		}else{
			$.ajax({
				type: "POST",
				url:path+ "/wap/goodsinfo/cart/addCart.html",
				data:{
					"serviceId" :$('#serviceId').val(),
					"num":$('.scartNum').val(),
					"scartSource":$('.scartSource').val(),
				},
				success: function (data) {
					var temp=JSON.parse(data);
					alert(temp.errorMsg);
				}
			});
		}
	})

	$('.service_content_pj_list').empty();
	// 设计案例切换
	$('.title-list li').click(
			function() {
				var liindex = $('.title-list li').index(this);
				$(this).addClass('on').siblings().removeClass('on');
				$('.service_content div.service_content_pj').eq(liindex)
						.fadeIn(150).siblings('div.service_content_pj').hide();
				var liWidth = $('.title-list li').width();
				$('.wap_service_xq .title-list p').stop(false, true).animate({
					'left' : liindex * liWidth + 'px'
				}, 300);
			});

	// 设计案例hover效果
	$('.service_content .service_content_pj li').hover(function() {
		$(this).css("border-color", "#ff6600");
		$(this).find('p > a').css('color', '#ff6600');
	}, function() {
		$(this).css("border-color", "#fafafa");
		$(this).find('p > a').css('color', '#666666');
	});
	$('.jiaz').hide();
	selectCommonAjax(pageNo);
	$('.jiaz').click(function() {
		pageNo = pageNo + 1;
		selectCommonAjax(pageNo);
	});
});

function selectCommonAjax(pageNo) {
	var srLevel = '';
	var rows = 2;//
	$.ajax({
		type : "POST",
		dataType : "json",
		url : path + "/wap/goodsinfo/service/queryServiceRemark.html",
		data : {
			"serviceId" : $('#serviceId').val(),
			"srLevel" : srLevel,
			"rows" : rows,
			"page" : pageNo
		},
		success : function(data) {
			showDiv(data);
		}
	})
}
function showDiv(data) {
	pageNo = data.page;
	if(data.list.length>0){
		$('.jiaz').show();
	}
	if (data.page >= data.totalPage||data.list.length<=0) {
		$('.jiaz').hide();
	}
	for (var i = 0; i < data.list.length; i++) {
		var date1 = new Date(data.list[i].srCreatetime).toLocaleDateString();
		var date2 = new Date(data.list[i].srCreatetime).toLocaleTimeString();
		var date = date1 += date2;
		var Appenddate1 = new Date(data.list[i].srAppendtime)
				.toLocaleDateString();
		var Appenddate2 = new Date(data.list[i].srAppendtime)
				.toLocaleTimeString();
		var Appenddate = Appenddate1 += Appenddate2;

		var inner = '<div class="service_content_pj_list">'
				+ '<div class="service_content_pj_list_img">' + '<img src="'
				+ data.list[i].userPhoto + '" />' + '</div>'
				+ '<div class="service_content_pj_list_title">' + '<h3>'
				+ data.list[i].logName + '</h3>' + '<p>'
				+ data.list[i].srContent + '</p>' + '<span>时间：' + date
				+ '</span>';
		if (data.list[i].srAppendcontent!=null&&data.list[i].srResponseappendcontent!=null) {
			inner = inner + '<div class="appendcontent remark">'
					+ '<span><b>[追加评论]</b>:</span><p>'
					+ (data.list[i].srAppendcontent) + '</p><span>'
					+ Appenddate + '</span>' + '</div></div>';
		}
		$(".service_content_pj_list").append(inner);
	}
}
