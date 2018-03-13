
var flagg = "d";
var startTime = "";
var endTime = "";
$(function(){
	showDiv(jsonList,1,flagg);
	$('#searchh').click(function(){
		startTime = $('#startTime').datebox('getValue');
		endTime = $('#endTime').datebox('getValue');
		flagg = $('#cc').combobox('getValue');
		selectCommonAjax(1);
	});
	$('#startTime').datetimebox({
	    required: true,
	    height:33,
	    width:180,
	    editable:false,
	    showSeconds: false
	});
	$('.textbox-icon').css({"width":"38px"});
	$('.textbox').css({"border-radius":"0px"});
	$('#endTime').datetimebox({
	    required: true,
	    height:33,
	    width:180,
	    editable:false,
	    showSeconds: false
	});
	$('.textbox-icon').css({"width":"38px"});
	$('.textbox').css({"border-radius":"0px"});
})
function selectCommonAjax(pageNo){
	$.ajax({
			type : "post",
			url : path+'/details/AccountPaymentDetails/showIODetailsByAjax.html',
			dataType:'json',
			data:{
				'flag':flagg,
				'startTime':startTime,
				'endTime':endTime,
				'page':pageNo
			},
			success:function(res){
				count = res.count;
				$("#mytable").empty();
				$("#pageDiv").empty();
				showDiv(res.acDetailsList,res.pageNo,res.flag);
			}
	});
}
function showDiv(res,pageNo,flag){
	var innerTitle = '<tr>'
		+'<td style="width: 176px;">时间</td>'
		+'<td style="width: 176px;">存入</td>'
		+'<td style="width: 176px;">支出</td>'
		+'<td style="width: 176px;">备注</td>'
		+'</tr>'
	$('#mytable').append(innerTitle);
	for(var i in res){
		var arr = res[i];
		if(flag=='d'){
			var apdCreatetimeStr = arr["apdCreatetimeStr"];
			var apdIotype = arr["apdIotype"];
			var apdAmountIn;
			var apdAmountOut;
			if(apdIotype==1){
				apdAmountIn = arr["apdAmount"].toFixed(2);
				apdAmountOut = undefined;
			}else if(apdIotype==2){
				apdAmountOut = arr["apdAmount"].toFixed(2);
				apdAmountIn = undefined;
			}
			var apdComment = arr["apdComment"];
			var inner = '<tr>'
				+'<td class="time">'+(apdCreatetimeStr||"")+'</td>'
				+'<td class="cr">'+(apdAmountIn||"0.00")+'</td>'
				+'<td class="je">'+(apdAmountOut||"0.00")+'</td>'
				+'<td class="bz">'+(apdComment||"")+'</td>'
				+'</tr>'
			$("#mytable").append(inner);
		}else if(flag=='a'){
			var apdInamount = arr["APD_INAMOUNT"].toFixed(2);
			var apdOutamount = arr["APD_OUTAMOUNT"].toFixed(2);
			var apdCreatetime = arr["YEAR"];
			var apdComment = arr["apdComment"];
			var inner = '<tr>'
				+'<td class="time">'+(apdCreatetime||"")+'</td>'
				+'<td class="cr">'+(apdInamount||"0.00")+'</td>'
				+'<td class="je">'+(apdOutamount||"0.00")+'</td>'
				+'<td class="bz">'+(apdComment||"")+'</td>'
				+'</tr>'
			$("#mytable").append(inner);
		}else if(flag=='b'){
			var apdInamount = arr["APD_INAMOUNT"].toFixed(2);
			var apdOutamount = arr["APD_OUTAMOUNT"].toFixed(2);
			var apdCreatetime = arr["YEAR"]+'-'+arr["MONTH"];
			var apdComment = arr["apdComment"];
			var inner = '<tr>'
				+'<td class="time">'+(apdCreatetime||"")+'</td>'
				+'<td class="cr">'+(apdInamount||"0.00")+'</td>'
				+'<td class="je">'+(apdOutamount||"0.00")+'</td>'
				+'<td class="bz">'+(apdComment||"")+'</td>'
				+'</tr>'
			$("#mytable").append(inner);
		}else if(flag=='c'){
			var apdInamount = arr["APD_INAMOUNT"].toFixed(2);
			var apdOutamount = arr["APD_OUTAMOUNT"].toFixed(2);
			var apdCreatetime = arr["YEAR"]+'-'+arr["MONTH"]+'-'+arr["DAY"];
			var apdComment = arr["apdComment"];
			var inner = '<tr>'
				+'<td class="time">'+(apdCreatetime||"")+'</td>'
				+'<td class="cr">'+(apdInamount||"0.00")+'</td>'
				+'<td class="je">'+(apdOutamount||"0.00")+'</td>'
				+'<td class="bz">'+(apdComment||"")+'</td>'
				+'</tr>'
			$("#mytable").append(inner);
		}
	 }
	pageNum(count,10 ,pageNo, 'pageDiv');
}