var url = "";

/*
*  根据类型获取图片并展示
* @returns
*/
function getCommonTypeImg(id){
	$.ajax({
		url: path + '/wap/pubinfo/commonType/findCommonTypeImgById',
		data:{
			id : id
		},
		dataType: 'json',
		type: 'post',
		cache: false,
		success:function(msg){
			if(msg.success){
				Ceng();
				var path1 = msg.obj.path;
//				$('#image1').attr("src",path1).css('paddingTop','0px').css('height','100%');
//				$('#info_icon1').val(path1);
				
				var arrayPath = msg.obj.path.split(',');
				var html = "";
				for(i in arrayPath){
					html+= "<div class='picture_nimgs'><img id='img"+i+"' src="+arrayPath[i]+" onclick=\"doubleClick('"+i+"')\"" +
							"style='width:100%;'></div>";
				}
				html += "";
				$('#insertPicture').append(html);
			}else{
				alert(msg.errorMsg);
			}
		}
	});
}
$(function(){
	if(flag == 1){
		url = '/wap/goodsinfo/service/updateService.html';
	} else {
		url = '/wap/goodsinfo/service/addService.html';
	}
	
	KindEditor.ready(function (K) {

		var editor = K.editor({
			uploadJson: path + '/kindEditor/4.1.10/jsp/upload_json.jsp',
			fileManagerJson: path + '/kindEditor/4.1.10/jsp/file_manager_json.jsp',
			allowFileManager: true,
		});


		//网络+本地
		K('#image1').click(function () {
          	$.messager.confirm('确认', '使用系统默认图片吗', function(r){
           		if(r){
           			var typeId = $("input[name='serviceType']").val();
           			if(typeId == ''){
           				alert("请选择类型");
           			}else{
           				getCommonTypeImg(typeId);
           			}
           		}else{
        			var temp=$(this);
        			editor.loadPlugin('image', function () {
        				editor.plugin.imageDialog({
        					clickFn: function (url, title) {
        						$("#info_icon1").val(url);
        						$('#image1').attr('src',url).css('paddingTop','0px')
        						editor.hideDialog();
        					}
        				});
        			});
           		}
			});
		});
    });
	
	//验证主题名称
	$('input[name=servicetitle]').blur(function(){
		var titleval = $(this).val();
		
		if(!checktitle(titleval) && $('input[name=servicetitle] ~ span').length < 1){
			$(this).after('<br><span style="color:#f00;">请按提示正确输入！</span>');
		}
	});
	
	//验证关键词
	$('textarea[name=servicekeywords]').blur(function(){
		var kwval = $(this).val();
		
		if(!checkkeywords(kwval) && $('textarea[name=servicekeywords] ~ span').length < 1){
			$(this).after('<br><span style="color:#f00;">请按提示正确输入！</span>');
		}
	});
	
	/*//验证主题简介
	$('textarea[name=servicecontent]').blur(function(){
		var contentval = $(this).val();
		
		if(!checkcontent(contentval) && $('textarea[name=servicecontent] ~ span').length < 1){
			$(this).after('<br><span style="color:#f00;">请按提示正确输入！</span>');
		}
	});*/
	/*$('#info_brief').blur(function(){
		var contentval = $(this).val();
		
		if(!checkcontent(contentval) && $('#info_brief ~ span').length < 1){
			$(this).after('<br><span style="color:#f00;">请按提示正确输入！</span>');
		}
	});*/
	
	//验证咨询费用
	$('input[name=psetprice]').blur(function(){
		var priceval = $(this).val();
		
		if(!checkprice(priceval) && $('input[name=psetprice] ~ span').length < 1){
			$(this).after('<span class="msg" style="color:#f00;display:block;margin-top:-18px;">请正确输入价格！</span>');
		}else{
			$(this).val(toDecimal2(priceval));
		}
	});
	
	$('#servicesave').click(function(){
		$('#servicesave').unbind("click");
		var conval = $('#info_brief').val();
		if(isEmpty(conval) && $('#info_brief ~ span').length < 1){
			$('#info_brief').after('<br><span style="color:#f00;display:block;margin-top:-10px;">服务介绍不能为空！</span>');
            alert('服务介绍不能为空！');
			return;
		}
		if(isEmpty($('#info_icon1').val())){
            alert('请选一张图片！');
			return;
		}

		if (isEmpty($('select[name=serviceType]'))){
			alert("请选择类型")
			return;
		}
		var serviceTitle = $('input[name=servicetitle]').val();
		var serviceBiref = "";
		if(!checktitle(serviceTitle) /*|| !checkcontent(serviceBiref)*/){
			alert("请正确填写服务标题");
			return;
		}

		var priceSetsarr = [];
		var ppsets= $('.ppset')
		for (var i = 0; i < ppsets.size(); i++) {
			priceSetsarr.push({
				psetDiscountType : $('select[name=psetdiscounttype]').val(),
				psetPrice : $('input[name=psetprice]').val(),
				psetPoint : $('input[name=psetpoint]').val()
			});
		}


		var paramarr = [];
		for (var i = 1; i < $('.param').size(); i++) {
			var pval = [];
			var pv = $($('.param')[i]).find('.pval').find('input[name=paramval]');
			var len = pv.size();
			for(var j=0;j<len;j++){
				pval.push(pv[j].value);
			}
			paramarr.push({
					name:$('input[name=param]')[i].value,
					value:pval
				})
		}
		
		var stype = $('input[name=serviceType]').val();
		//var keywords = $('textarea[name=servicekeywords]').val().split(',');
		var model={
			serviceId:$('#serviceId').html(),
            servicePic:$('input[name=servicepic]').val(),
			serviceTitle : $('input[name=servicetitle]').val(),
			/*serviceBiref : "",*/
			serviceContent : $('#info_brief').val(),
			priceSets : priceSetsarr,
			serviceMeettime : $('input[name=servicemeettime]').val(),					
			//serviceKeywords : keywords,
			serviceAttrinfo : paramarr,
			serviceType:$('input[name=serviceType]').val(),
			serviceSteps:[{
				ssName: $('input[name=ssname]').val(),
				ssPrice: priceSetsarr,
				ssDescribe: $('textarea[name=ssdescribe]').val()
				}]
		};
		$.ajax({
			url: path + url,
			data:{
				service:JSON.stringify(model)
			},
			dataType: 'json',
			type: 'post',
			cache: false,
			success:function(data){
				if(data.success){
					alert("成功",'添加成功',function(){
						window.location.href=path+data.obj;
					})
				}else{
					alert(data.errorMsg,'添加失败');
				}
			},
			error:function(data){
				
			}
		});
	});
	
	nextAllRemove($('input[name=servicetitle]'));
	//nextAllRemove($('textarea[name=servicekeywords]'));
	//nextAllRemove($('textarea[name=servicecontent]'));
	nextAllRemove($('textarea[name=servicebireref]'));
	$('input[name=psetprice]').focus(function(){
		$('.msg').remove();
	});
});

//校验方法
function checktitle(value){
	if(isEmpty(value)){
		return false;
	}
	var reg =/^[\u4e00-\u9fa5a-zA-Z0-9]{1,}$/;
	return reg.test(value);
}
function checkkeywords(value){
//	if(isEmpty(value)){
//		return false;
//	}
	var keywords = value.split(/[,|，]/);
	if(keywords.length > 5){
		return false;
	}
	var reg =/^[\u4e00-\u9fa5a-zA-Z0-9]+$/;
	for ( var i=0;i<keywords.length;i++) {
		var keyword = keywords[i];
//		if(isEmpty(keyword)){
//			return false;
//		}
		if(keyword!=""){
			if(!reg.test(keyword)){
				return false;
			}
		}
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


/* 弹出层 */
function Ceng() {
	$('#ceng').css("display","block");
	$('#close').css("display","block");
    return false;
}
function closeCeng() {
	$('#ceng').css("display","none");
	$('#close').css("display","none");
    $('#insertPicture').empty();;
    return false;
}
function doubleClick(i){
	var src = $("#img"+i).attr("src");
	$('#image1').attr("src",src).css('marginTop','0px').css('width',"100%");
	$('#info_icon1').val(src);
	$('#updateSpan').empty();
	closeCeng();
	var temp = $('.upli');
    temp.children('span').remove();
}