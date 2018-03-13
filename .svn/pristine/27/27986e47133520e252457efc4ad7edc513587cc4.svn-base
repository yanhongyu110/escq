var pageNum = '';
var totalPage = '';

/**
 * @param {Object} total 总记录数
 * @param {Object} current_page 当前页
 * @param {Object} rows 每页显示数
 * @param {Object} divId 分页div的Id
 */
function paging(total,current_page,rows,divId){
	pageNum = current_page;
	totalPage = Math.ceil(total / rows); //总页数
	if(pageNum > totalPage){
		pageNum = totalPage
	}
	var addHtml = '<div class="paging">'+
			'<a href="javascript:jump(1);" class="first">&laquo;</a>'+
		    '<a href="javascript:jump(2);" class="previous">&lsaquo;</a>'+
		    '<input type="text" id="input" />'+
		    '<a href="javascript:jump(3);" class="next">&rsaquo;</a>'+
		    '<a href="javascript:jump(4);" class="last">&raquo;</a>'+
		'</div>';
	$("#"+divId).html(addHtml);
	
	var page_string = pageNum+'/'+totalPage;
	$('#input').val(page_string);
	
	$("#input").on('click',function (){
		click();
	});
	$("#input").blur(function (){
		mouse();
	});
}

function click(){
	$('#input').val('');
}

function mouse(){
	var value = $('#input').val();
	if(value == ''){
		value = pageNum;
	}
	if(value > totalPage){
		alert('请输入正确的页数');
		return;
	}
	$('#input').val(value+'/'+totalPage);
	selectCommonAjax(value);
	
}
function jump(i){
	switch (i){
		case 1:
			pageNum = 1;
			selectCommonAjax(pageNum);
			var page_string = pageNum+'/'+totalPage;
			$('#input').val(page_string);
			break;
		case 2:
			if(pageNum-1<1){
				pageNum = 1;
			} else {
				pageNum -= 1;
			}
			selectCommonAjax(pageNum);
			var page_string = pageNum+'/'+totalPage;
			$('#input').val(page_string);
			break;
		case 3:
			if(pageNum+1>totalPage){
				pageNum = totalPage;
			} else {
				pageNum += 1;
			}
			selectCommonAjax(pageNum);
			var page_string = pageNum+'/'+totalPage;
			$('#input').val(page_string);
			break;
		case 4:
			pageNum = totalPage;
			selectCommonAjax(pageNum);
			var page_string = pageNum+'/'+totalPage;
			$('#input').val(page_string);
			break;
		default:
			break;
	}	
}

