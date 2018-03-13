var times = 0;
$(function(){
	
	setTimeout(function(){
		$(".ke-button").css({ width: "96px","margin-top": "-3px","background":"transparent"})	
		$(".ke-upload-file").css({width: "96px",left: "0px"});
		$('.ke-form').css({width:'96px'});
	},1)
	
	
	//富文本框设置
	var editor = KindEditor.create('textarea[name="servicebiref"]', {
		themeType: 'simple',
		resizeType: 1,
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



        ////单图片上传
        //var uploadbutton = K.uploadbutton({
	     //   button : K('#imgBtn')[0],
	     //   fieldName : 'imgFile',
	     //   url : path+'/kindEditor/4.1.10/jsp/upload_json.jsp',
	     //   afterUpload : function(data) {
	     //           if (data.error === 0) {
	     //                 $("#info_icon1").val(data.url);
	     //           }
	     //   }
		//});
		//uploadbutton.fileBox.change(function(e) {
	     //  	 uploadbutton.submit();
		//});


    });


    
    //属性
	var k = 1;
	$('#addstep').click(function(){
		k++;
		var newStep = '<div class="servicestep">' + 
			'<span>阶段' + k +'</span><br>'+
			'名称：<input type="text" name="ssname" />'+
			'价格：<input type="text" name="ssprice" /><br>'+
			'描述：<br><textarea name="ssdescribe" ></textarea>'+
			'</div>';
		$('.step').append(newStep);
	});

	$('.addval').bind('click',function(){
		if($(this).parent().children('div').length < 6){
			times = $(this).parent().children('div').length;
		}
		addval($(this));
	});

	$('#addrow').click(function(){
		addrow($(this));

	});

	$('.delrow').click(function(){
		if(confirm('确定删除这行？')){
			$(this).parent().remove();
			$('.param-main').css({height:'-=60px'});
		}
	});
	
	function addrow(This){
		times = 0;
		var ss=$("#template").clone(true)
		ss.show(0)
		ss.addClass("ppset")
		$('.param-main').append(ss).css({height:'+=60px'});
	}

	//价格变更事件
	$('.steppset').css({height:'auto',overflow:'hidden'});
	$('.pset').keyup(function(){
		var ppsets= $('.ppset');
		$('.steppset').html("")
		for (var i=0;i<ppsets.size();i++){
			var c= ppsets.eq(i).clone()
			c.find('a').remove();
			c.removeClass("ppset");
			c.find('input').css("width","70px")
			$('.steppset').append(c)
		}
	})


	//价格
	$('#addrowpset').click(function(){
		var ss=$("#psetsg").clone(true)
		ss.show(0)
		ss.addClass("ppset");
		$('.pset').append(ss).css({height:'+=60px'});
	});
	$('.delrowpset').click(function(){
		if(confirm('确定删除这行？')){
			$(this).parent().remove();
			$('.pset').css({height:'-=60px'});
		}
	});
	
	//校验
	$('input[name=serviceprice]').blur(function(){
		var priceval = $(this).val();
		if(checkprice(priceval) && priceval.indexOf('.') < 0){
			$(this).val(priceval + '.00');
		}
	});
	$('input[name=ssprice]').blur(function(){
		var priceval = $(this).val();
		if(checkprice(priceval) && priceval.indexOf('.') < 0){
			$(this).val(priceval + '.00');
		}
	});
	
	
	var flag = false;
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
	//验证咨询费用
	$('input[name=psetprice]').blur(function(){
		var priceval = $(this).val();
		
		if(!checkprice(priceval) && $('input[name=psetprice] ~ span').length < 1){
			$('.pset').after('<span class="msg" style="color:#f00;display:block;margin-top:-18px;margin-left:170px;">请按提示正确输入！</span>');
		}else{
			$(this).val(toDecimal2(priceval));
		}
	});
	//验证咨询积分
	$('input[name=psetpoint]').blur(function(){
		var priceval = $(this).val();
		
		if(!checkprice(priceval) && $('input[name=psetpoint] ~ span').length < 1){
			$('.pset').after('<span class="msg" style="color:#f00;display:block;margin-top:-18px;margin-left:170px;">请按提示正确输入！</span>');
		}else{
			$(this).val(toDecimal2(priceval));
		}
	});
	//验证见面时长
	//$('input[name=servicemeetnum]').blur(function(){
	//	var tlval = $(this).val();
	//	if(flag != checktl(tlval)){
	//		flag = checktl(tlval);
	//	}
	//
	//	if(!flag && $('input[name=servicemeetnum] ~ span').length < 1){
	//		$(this).after('<br><span style="color:#f00;">请按提示正确输入！</span>');
	//	}
	//});


	//验证属性是否为空
	$('input[name=param]').blur(function(){
		for (var i = 1; i < $('input[name=param]').size(); i++) {
			var paramval = $('input[name=param]')[i].value;
			
			if(isEmpty(paramval) && $('.param-main ~ span').length < 1){
				$('.param-main').after('<span style="color:#f00;display:block;margin:-20px 160px 1px;">属性值不能为空！</span>');
			}
		}
	});
	
	$('input[name=ssname]').blur(function(){
		var titleval = $(this).val();
		
		if(!checktitle(titleval) && $('input[name=ssprice] ~ span').length < 1){
			$('input[name=ssprice]').after('<span style="color:#f00;margin-left:60px;font-weight:normal;font-size:12px;line-height:13px;">请输入名称！</span>');
		}
	});
	$('input[name=ssprice]').blur(function(){
		var priceval = $(this).val();
		
		if(!checkprice(priceval) && $('input[name=ssprice] ~ span').length < 1){
			$(this).after('<span style="color:#f00;font-weight:normal;font-size:12px;line-height:13px;margin-left:310px;">请按正确的价格！</span>');
		}
	});
	$('input[name=ssprice],input[name=ssname]').focus(function(){
		if($('input[name=ssprice] ~ span').length > 0){
			$('input[name=ssprice]').next().remove('span');
		}
	})
	
	var title = '';
	var m = 0;
	$('#servicesave').click(function(){
		$('#servicesave').unbind("click");
		var conval = $('#info_brief').val();
		if(isEmpty(conval) && $('#info_brief ~ span').length < 1){
			$('#info_brief').after('<br><span style="color:#f00;display:block;margin-top:-10px;">主题介绍不能为空！</span>');
            alert('主题介绍不能为空！');
			return;
		}
		if(isEmpty($('input[name=servicepic]'))){
            alert('请选一张图片！');
			return;
		}

		if (isEmpty($('select[name=serviceType]'))){
			alert("请选择类型")
			return;
		}
		var serviceTitle = $('input[name=servicetitle]').val();
		var serviceBiref = $('textarea[name=servicecontent]').val();
		/*if(!checktitle(serviceTitle) || !checkcontent(serviceBiref)){
			alert("请正确填写");
			return;
		}*/




		var priceSetsarr = [];
		var ppsets= $('.ppset')
		for (var i = 0; i < ppsets.size(); i++) {
			priceSetsarr.push({
				psetDiscountType : ppsets.eq(i).find('select[name=psetdiscounttype]').val(),
				psetPrice : ppsets.eq(i).find('input[name=psetprice]').val(),
				psetPoint : ppsets.eq(i).find('input[name=psetpoint]').val()
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
		var keywords = $('textarea[name=servicekeywords]').val().split(',');
		var model={
			serviceId:$('input[name=serviceId]').val(),
            servicePic:$('input[name=servicepic]').val(),
			serviceTitle : $('input[name=servicetitle]').val(),
			serviceBiref : $('textarea[name=servicecontent]').val(),
			serviceContent : $('#info_brief').val(),
			priceSets : priceSetsarr,
			serviceMeettime : $('input[name=servicemeettime]').val(),					
			serviceKeywords : keywords,
			serviceAttrinfo : paramarr,
			serviceType:$('#serviceType').val(),
			serviceSteps:[{
				ssName: $('input[name=ssname]').val(),
				ssPrice: priceSetsarr,
				ssDescribe: $('textarea[name=ssdescribe]').val()
				}]
		};
		$.ajax({
			url: path + '/goodsinfo/service/updateService.html',
			data:{
				service:JSON.stringify(model)
			},
			dataType: 'json',
			type: 'post',
			cache: false,
			success:function(data){
				if(data.success){
					alert('成功','修改成功',function(){
						location.href=path+"/goodsinfo/service/viewProviderService.html";
					})
				}else{
					alert(data.errorMsg,"修改失败")
				}
			}
		});
	});
	
	
	nextAllRemove($('input[name=servicetitle]'));
	nextAllRemove($('textarea[name=servicekeywords]'));
	nextAllRemove($('textarea[name=servicecontent]'));
	nextAllRemove($('textarea[name=servicebireref]'));
	nextAllRemove($('input[name=serviceprice]'));
	//nextAllRemove($('input[name=servicemeetnum]'));
	$('input[name=param]').focus(function(){
		$('.param-main').nextAll().remove();
	});
	
	
	
})
function delval(node){
	$(node).parent().remove();
	times--;
}

function addval(This){
	if(times++ < 5){
		var newval = '<div class="pval">'+
					 '<input type="text" name="paramval" />'+
					 '<a class="delval" id="delval" href="javascript:void(0)" onclick="delval(this)">×</a>'+
					 '</div>';
		This.before(newval);
	}else{
		times--;
	}
}

//校验方法
function checktitle(value){
	if(isEmpty(value)){
		return false;
	}
	var reg =/^[\u4e00-\u9fa5a-zA-Z0-9]{5,}$/;
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