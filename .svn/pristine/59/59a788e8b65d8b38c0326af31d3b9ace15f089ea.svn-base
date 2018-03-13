var serviceTypetree=null;
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
if (projectName=='/escq'){
	var path = localhostPath + projectName;
}else {
	var path = localhostPath;
}
var liindex=0;
var index=0;


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

function initCommonType(){
	  $.ajax({
		  async:false,
		  type:'post',
		  dataType:'json',
		  url:path+'/pubinfo/commonType/getCommonType.html',
		  success:function(data){
			  var type = jQuery.parseJSON(data);
			  var typeList = type.saveValue;
			  for(var i =0 ;i<typeList.length;i++){
				   var commonType = typeList[i].text;
				   var id = typeList[i].id;
				   if(serviceTypetree!=''||serviceTypetree==undefined){
					   if(serviceTypetree==id){
						   $("#ct").append("<a class='swiper-slide on' val="+id+" style='width: 10%;'>"+commonType+"</a>");
					   }else{
						   $("#ct").append("<a class='swiper-slide' val="+id+" style='width: 10%;'>"+commonType+"</a>");
					   }
				   }else{
					   $("#ct").append("<a class='swiper-slide'  val="+id+" style='width: 10%;'>"+commonType+"</a>");
				   }
				   index=$('#ct a[class=on]').index();
				   liindex=$('#ct a').length;
			  }
		  }
	  })
}
/**
 * 分页
 * 
 * @param total
 *            总条数
 * @param pageNo
 *            当前页
 * @param pageDiv
 *            分页div的ID
 * @param rows
 *            每页显示的条数
 */
function pageNum(total,rows,pageNo,pageDiv){
	var totalPage = Math.ceil(total / rows);
	var addHtml = '';// 要显示的内容
	var pageNumSize = 5;// 表示最多一页显示多少条页码号
	var pageNo = pageNo; // 表示当前的页数
	var totalPages = totalPage; // 表示一共要显示多少页的数据
	var startPageNo =  '';
	var endPageNo = '';
	$('#'+pageDiv).css("text-align","center");
	$('#'+pageDiv).html('');
	if(pageNo % pageNumSize == 0){
		startPageNo = (pageNo - pageNumSize) + 1;
		endPageNo = pageNo;
	}else{
		startPageNo = (Math.floor((pageNo/pageNumSize)))*pageNumSize + 1;// 开始页码数
		endPageNo = (Math.floor((pageNo + pageNumSize - 1)/pageNumSize))*pageNumSize;// 结束页码数
	}
    if(totalPage != 0){
    	addHtml = '<a href="javascript:void(0)" onclick="selectCommonAjax(1)">首页</a><a href="javascript:void(0)" onclick="selectCommonAjax('+(pageNo-1)+'<1?1:'+(pageNo-1)+')">上一页</a>';
    	for(var i= startPageNo;i<=(endPageNo > totalPages ? totalPages : endPageNo);i++) {
    		if(i == pageNo){
    			addHtml += '<a href="javascript:void(0)" style="background-color:#00ffe7" class="x_xzxg" onclick="selectCommonAjax('+i+')">'+i+'</a>';
    		}else{
    			addHtml += '<a href="javascript:void(0)" onclick="selectCommonAjax('+i+')">'+i+'</a>';
    		}
    	}
    	addHtml+= '<a href="javascript:void(0)" onclick="selectCommonAjax('+(pageNo+1)+'>'+totalPage+'?'+totalPage+':'+(pageNo+1)+')">下一页</a><a href="javascript:void(0)" onclick="selectCommonAjax('+totalPage+')">最后页</a>' 
    	          +'<span class="x_tiao"><em>共'+totalPages+'页</em>跳至<span class="x_ip"><input style="width: 30px;height:25px;margin-left:5px;padding:0;" type="text" value="'+pageNo+'" id="pagevalue"/></span>'
    	          +'<span class="x_goo"><input style="width: 30px;height:25px;margin-left:5px;padding:0;border:0;" type="button" value="go" onclick="selectCommonAjax($(\'#pagevalue\').val())"/></span></span>';
    	$('#'+pageDiv).html(addHtml);
    }
}