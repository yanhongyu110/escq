var flag = "d";
var startTime = "";
var endTime = "";
$(function(){
	showDiv(jsonList,1,flag);
	$('#searchh').click(function(){
		startTime = $('#startTime').datebox('getValue');
		endTime = $('#endTime').datebox('getValue');
		flag = $('#cc').combobox('getValue');
		selectCommonAjax(1);
	});
})
function selectCommonAjax(pageNo){
	$("#mytable").empty();
	$.ajax({
			type : "post",
			url : path+'/details/PointPaymentDetails/showPointIODetailsByAjax.html',
			dataType:'json',
			data:{
				'flag':flag,
				'startTime':startTime,
				'endTime':endTime,
				'page':pageNo
			},
			success:function(res){
				count = res.count;
				console.info(res)
				showDiv(res.ppdList,res.pageNo,res.flag);
			}
	});
}
function showDiv(res,pageNo,flag){
	var innerTitle = '<tr>'
		+'<td>时间</td>'
		+'<td >存入</td>'
		+'<td>支出</td>'
		+'<td>备注</td>'
		+'</tr>'
	$('#mytable').append(innerTitle);
	for(var i in res){
		var arr = res[i];
		if(flag=='d'){
			var ppdCreatetimeStr = arr["ppdCreatetimeStr"];
			var ppdIotype = arr["ppdIotype"];
			var ppdAmountIn;
			var ppdAmountOut;
			if(ppdIotype==1){
				ppdAmountIn = arr["ppdAmount"];
				ppdAmountOut = undefined;
			}else if(ppdIotype==2){
				ppdAmountOut = arr["ppdAmount"];
				ppdAmountIn = undefined;
			}
			var ppdComment = arr["ppdComment"];
			var inner = '<tr>'
				+'<td class="time">'+(ppdCreatetimeStr||"")+'</td>'
				+'<td class="cr">'+(ppdAmountIn||"--")+'</td>'
				+'<td class="je">'+(ppdAmountOut||"--")+'</td>'
				+'<td class="bz">'+(ppdComment||"")+'</td>'
				+'</tr>'
			$("#mytable").append(inner);
		}else if(flag=='a'){
			var ppdInamount = arr["PPD_INAMOUNT"];
			var ppdOutamount = arr["PPD_OUTAMOUNT"];
			var ppdCreatetime = arr["YEAR"];
			var ppdComment = arr["ppdComment"];
			var inner = '<tr>'
				+'<td class="time">'+(ppdCreatetime||"")+'</td>'
				+'<td class="cr">'+(ppdInamount||"--")+'</td>'
				+'<td class="je">'+(ppdOutamount||"--")+'</td>'
				+'<td class="bz">'+(ppdComment||"")+'</td>'
				+'</tr>'
			$("#mytable").append(inner);
		}else if(flag=='b'){
			var ppdInamount = arr["PPD_INAMOUNT"];
			var ppdOutamount = arr["PPD_OUTAMOUNT"];
			var ppdCreatetime = arr["YEAR"]+'-'+arr["MONTH"];
			var ppdComment = arr["ppdComment"];
			var inner = '<tr>'
				+'<td class="time">'+(ppdCreatetime||"")+'</td>'
				+'<td class="cr">'+(ppdInamount||"--")+'</td>'
				+'<td class="je">'+(ppdOutamount||"--")+'</td>'
				+'<td class="bz">'+(ppdComment||"")+'</td>'
				+'</tr>'
			$("#mytable").append(inner);
		}else if(flag=='c'){
			var ppdInamount = arr["PPD_INAMOUNT"];
			var ppdOutamount = arr["PPD_OUTAMOUNT"];
			var ppdCreatetime = arr["YEAR"]+'-'+arr["MONTH"]+'-'+arr["DAY"];
			var ppdComment = arr["ppdComment"];
			var inner = '<tr>'
				+'<td class="time">'+(ppdCreatetime||"")+'</td>'
				+'<td class="cr">'+(ppdInamount||"--")+'</td>'
				+'<td class="je">'+(ppdOutamount||"--")+'</td>'
				+'<td class="bz">'+(ppdComment||"")+'</td>'
				+'</tr>'
			$("#mytable").append(inner);
		}
	 }
	pageNum(count,10 ,pageNo, 'pageDiv');
}