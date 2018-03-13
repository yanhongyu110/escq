var times = 0;
var nameRegx = /^[\u4e00-\u9fa5]{2,4}$/;//验证用户名
var cellRegx = /^1[34578]\d{9}$/;//验证手机

function regx(r,s){
	if (r == null || r == ""){
		return false;
	}
	var patrn= new RegExp(r);
	if (patrn.exec(s))
		return true;
		return false;
}

$(function(){
	//富文本框设置
	var editor = KindEditor.create('textarea[name="demContent"]', {
		themeType: 'simple',
		resizeType: 1,
		autoHeightMode : true,
		cssPath: path + '/kindEditor/4.1.10/plugins/code/prettify.css',
		uploadJson: path + '/kindEditor/4.1.10/jsp/upload_json.jsp',
		fileManagerJson: path + '/kindEditor/4.1.10/jsp/file_manager_json.jsp',
		allowFileManager: false,
		afterCreate: function () {
			this.sync();
        },
        afterBlur : function() {
            this.sync();
        },
        minWidth:'300px',
        width:'615px',
        height:'250px'
    });
	
	
    KindEditor.ready(function (K) {

		var editor = K.editor({
			uploadJson: path + '/kindEditor/4.1.10/jsp/upload_json.jsp',
			fileManagerJson: path + '/kindEditor/4.1.10/jsp/file_manager_json.jsp',
			allowFileManager: true,
		});


		//网络+本地
		K('#image1').click(function () {
			var temp=$(this);
			editor.loadPlugin('image', function () {
				editor.plugin.imageDialog({
					clickFn: function (url, title) {
						$("#info_icon1").val(url);
						$('#image1').attr('src',url)
						editor.hideDialog();
					}
				});
			});
		});
    });
	
    //验证服务名称
	$('input[name=demTitle]').blur(function(){
		var titleval = $(this).val();
		
		if(!checktitle(titleval) && $('input[name=demTitle] ~ span').length < 1){
			$(this).after('<br><span style="color:#f00;">请保证在15字以内！</span>');
		};
	});
	//验证联系人
	$('input[name=demContact]').blur(function(){
		var flag = isEmpty($('input[name=demContact]').val());
		if(flag /*&& $('input[name=demContact] ~ span').length < 1*/){
			$(this).after('<br><span style="color:#f00;">您输入的姓名不能为空！</span>');
		};
	});
	//验证手机号
	$('input[name=demCell]').blur(function(){
		var titleval = $(this).val();
		var flag = regx(cellRegx,titleval);
		if(!flag && $('input[name=demCell] ~ span').length < 1){
			$(this).after('<br><span style="color:#f00;">您输入的联系方式有误！</span>');
		};
	});
	//验证关键词
	$('textarea[name=demKeyword]').blur(function(){
		 var temp=$(this).val();
 		  temp= temp.replace(new RegExp("，","gm"), ",");
 		  var res= temp.replace(new RegExp(" ","gm"), "");
 		  var res1="";
 		  if(res.substr(res.length-1,1)==","){
 			 res=res.substring(0,res.length-1);
 		  }
 		  $(this).val(res);
	});
	
	/*//验证主题简介
	$('textarea[name=demBrief]').blur(function(){
		var contentval = $(this).val();
		
		if(!checkcontent(contentval) && $('textarea[name=demBrief] ~ span').length < 1){
			$(this).after('<br><span style="color:#f00;">请按提示正确输入！</span>');
		};
	});*/
	
	$('#servicesave').click(function(){
		//$('#servicesave').unbind("click");
		var conval = $('#info_brief').val();
		if(isEmpty(conval) && $('#info_brief ~ span').length < 1){
			$('#info_brief').after('<br><span style="color:#f00;display:block;margin-top:-10px;">服务介绍不能为空！</span>');
            alert('需求介绍不能为空！');
			return;
		}
		/*if(isEmpty($('input[name=demImage]'))){
            alert('请选一张图片！');
			return;
		}*/

		if (isEmpty($('select[name=demType]'))){
			alert("请选择类型");
			return;
		}
		var demTitle = $('input[name=demTitle]').val();
		var demContact = $('input[name=demContact]').val();
		var demCell = $('input[name=demCell]').val();
		var demBrief = $('textarea[name=demBrief]').val();
		if(!checktitle(demTitle)){
			alert("需求名称不能超过15个字");
			return;
		}
		if(isEmpty($('input[name=demContact]').val())){
			alert("请确认用户名不为空");
			return;
		}
		if(!checkkeywords($('input[name=demKeyword]').val())){
			alert("请确认关键字格式，关键字可以为空");
			return;
		}
		if(!regx(cellRegx,demCell)){
			alert("请确认电话号码是否正确");
			return;
		}

		var demType = $('input[name=demType]').val();
		var demKeyword = $('textarea[name=demKeyword]').val().split(',');
		var model={
			demId:$('input[name=demId]').val(),
			demContact:$('input[name=demContact]').val(),
			demCell:$('input[name=demCell]').val(),
            demImage:$('input[name=demImage]').val(),
			demTitle : $('input[name=demTitle]').val(),
			demBrief : $('textarea[name=demBrief]').val(),
			demContent : $('#info_brief').val(),
			demKeyword : demKeyword,
			demType:demType,
		};
		$.ajax({
			url: path + '/demand/updateById.html',
			data:{
				demand:JSON.stringify(model),
			},
			dataType: 'json',
			type: 'post',
			cache: false,
			success:function(data){
				if(data.success){
					alert("修改成功",'成功',function(){
						location.href=path+"/demand/gotodemandAmind.html";
					});
				}else{
					alert("修改失败","失败");
				};
			}
		});
	});
	
	nextAllRemove($('input[name=demTitle]'));
	nextAllRemove($('textarea[name=demKeyword]'));
	nextAllRemove($('textarea[name=demContent]'));
	nextAllRemove($('textarea[name=demBrief]'));
	nextAllRemove($('input[name=demContact]'));
	nextAllRemove($('input[name=demCell]'));
});

//校验方法
function checktitle(value){
	if(isEmpty(value)){
		return false;
	}
	var reg =/^[\u4e00-\u9fa5a-zA-Z0-9]{1,15}$/;
	return reg.test(value);
}
function checkkeywords(value){
	if(isEmpty(value)){
		return true;
	}
	var keywords = value.split(/[,|，]/);
	if(keywords.length > 5){
		return false;
	}
	var reg =/^[\u4e00-\u9fa5a-zA-Z0-9]+$/;
	for ( var i=0;i<keywords.length;i++) {
		var keyword = keywords[i];
		if(isEmpty(keyword)){
			return false;
		}
		if(!reg.test(keyword)){
			return false;
		};
	}
	return true;
}
function checkcontent(value){
	if(isEmpty(value)){
		return false;
	}
	var reg = /^.{1,200}$/;
	return reg.test(value);
}
function checkprice(value){
	if(isEmpty(value)){
		return false;
	}
	var reg = /^(-?\d+)(\.\d+)?$/;
	return reg.test(value);

}

function checktl(value){
	if(isEmpty(value)){
		return false;
	}
	var reg = /^[0-9]+$/;
	return reg.test(value);

}

function isEmpty(value){
	value = $.trim(value);
	if(value == "" || value == null || value == undefined){
		return true;
	}
	return false;
}

function nextAllRemove(node){
	node.focus(function(){
		$(this).nextAll().remove();
	});
}

/*function clear(node){
	node.one('focus',function(){
		$(this).val("");
	})
}*/

//强制保留2位小数，如：2，会在2后面补上00.即2.00    
function toDecimal2(x) {    
    var f = parseFloat(x);    
    if (isNaN(f)) {    
        return false;    
    }    
    var f = Math.floor(x*100)/100;    
    var s = f.toString();    
    var rs = s.indexOf('.');    
    if (rs < 0) {    
        rs = s.length;    
        s += '.';    
    }    
    while (s.length <= rs + 2) {    
        s += '0';    
    }    
    return s;    
}    