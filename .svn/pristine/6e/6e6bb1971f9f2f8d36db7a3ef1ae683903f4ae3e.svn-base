//从地址栏中获取logId
var logId;

//获取引用src传递的项目根目录
var webtxc;

$(function(){
	//更改日期按钮变手指
	$("div.sc-yleft,div.sc-yright,div.sc-mleft,div.sc-mright,span.sc-return-today").css("cursor","pointer");
	
	//弹出日历
	$('#ckdq-btn').click(function(){
		$('#calendar_div').fadeIn();
	});
	//关闭日历
	$('.claseDialogBtn').click(function(){
		$('#calendar_div').fadeOut();
	});

	
	//从地址栏中获取logId
	logId=$.getUrlParam('logId');
	
	//向iframe中传递logId
	var scripts = document.scripts;
	for (var int = 0; int < scripts.length; int++) {
		var src = scripts[int].src;
		if (scripts[int].src.indexOf("customer")>=0) {
			webtxc=$.trim(src.substring(src.indexOf("webtxc=")+"webtxc=".length));
		}
	}
	$('#calendar_div iframe').attr("src",webtxc+'/calendar/myres_customer.jsp?logId='+logId);
	
//	初始化选择器
	setTimeout("myreload()",50);
	
//	日历刷新时跟新选择器
	$(".sc-return-today").click(function(){
		setTimeout("myreload()",100);
	});
	$(".sc-yleft").click(function(){
		setTimeout("myreload()",100);
	});
	$(".sc-yright").click(function(){
		setTimeout("myreload()",100);
	});
	$(".sc-mleft").click(function(){
		setTimeout("myreload()",100);
	});
	$(".sc-mright").click(function(){
		setTimeout("myreload()",100);
	});
	$(".sc-select-year").change(function(){
		setTimeout("myreload()",100);
	});
	$(".sc-select-month").change(function(){
		setTimeout("myreload()",100);
	});
	
//	点击查看档期弹出日历模态框
	$("#ckdq-btn").click(function(){
		$('#Modal').modal('show');
	});
	
//	点击弹出模态框
	$(".sc-item").click(function(){
		$("tr[valign='middle']").remove();
		var date = getDate($(this));
		$("#modal-title").text(date);
		$.ajax({
			url:""+path+"/userinfo/arrangement/selectarrangebydate.html",
			data:{
				"arrCurday":date,
				"arrSeverid":logId
				},
			dataType:"json",
			success:function(sucResult){
				if (sucResult['success']==true) {
					var length = sucResult['obj'].length;
					var dateResult = sucResult['obj']['0'];
					if (length>0) {
						for(var i=0;i<length;i++){
							var id = sucResult['obj'][i]['arrId'];
							var content = sucResult['obj'][i]['arrContent'];
							var startTime = sucResult['obj'][i]['arrStarttime'];
							var endTime = sucResult['obj'][i]['arrEndtime'];
							$(".table").append("<tr valign='middle'>"+
									"<td>"+(i+1)+"</td>"+
									"<td>"+startTime+"</td>"+
									"<td>"+endTime+"</td>"+
									"<td>已预约</td>");
						}
						$('#tableModal').modal('show');
					}
				}
			},
			error:function(errResult){
				console.info(Msg);
			}
		});
	});
	
});

//更新日历
function myreload(){
	var daysElement = $(".sc-days").find(".sc-item");//遍历日历表格
	var daylists = new Array();
	var date=null;
	for (var i = 0;i<daysElement.size();i++) {
		var dayElement = daysElement[i];
		$(dayElement).attr("id","id"+i);
		date = getDate(dayElement);
		daylists[i]=date;
		$(dayElement).attr("title","");
		$(dayElement).removeClass("sc-mark");
		$.ajax({
			url:""+path+"/userinfo/arrangement/selectarrangebydate.html",
			data:{
				"arrCurday":date,
				"arrSeverid":logId
				},
			dataType:"json",
			success:function(sucResult){
				if (sucResult['success']==true) {
					var dateResult = sucResult['obj']['0']['arrCurday'];
					for (var int = 0; int < daylists.length; int++) {
						if (daylists[int]==dateResult) {
							$("#id"+int).addClass("sc-mark");
						}
					}
				}
			},
			error:function(errResult){
				console.info(Msg);
			}
		});
	}
}


//获取当前日历格子日期
function getDate(dayElement){
	var year = $(".sc-select-year").val();
	var month = $(".sc-select-month").val();
	var day = $(dayElement).find(".day").text();
	var day = day.length==2?day:("0"+day);
	if ($(dayElement).hasClass("sc-othermenth")) {
		if (day>20) {
			if ($(".sc-select-month").val()==1) {
				year=$(".sc-select-year").val()-1;
				month=12;
			}else{
				year=$(".sc-select-year").val();
				month=$(".sc-select-month").val()-1;
			}
		}else{
			if ($(".sc-select-month").val()==12) {
				year=$(".sc-select-year").val()-1+2;
				month=1;
			}else{
				year=$(".sc-select-year").val();
				month=$(".sc-select-month").val()-1+2;
			}
		}
	}
	var month = month>9?month:("0"+month);
	var date =year+"-"+month+"-"+day;
	return date;
}

//自定义方法：从地址栏中获取数据
(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
})(jQuery);
