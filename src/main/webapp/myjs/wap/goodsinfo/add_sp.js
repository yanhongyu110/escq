$(function(){
	$("#form").validate({
		rules : {
			videoTitle : {
				required : true,
				rangelength : [2,20]
			},
		},
		messages : {
			videoTitle : {
				required : "<em style='color: red;font-size: 12px;font-style:normal'>必填</em>",
				rangelength : "<em style='color: red;font-size: 12px;font-style:normal'>请输入2到20个字的标题</em>",
			},
		},
		onfocusout : function(element) {
			$(element).valid();
		},
		invalidHandler : function(form, validator) {
			return false;
		},
		errorPlacement: function(error, element) { //错误信息位置设置方法
			if(element.is('#title')){
				error.appendTo($('#title1'));
			}
		},
	});
	
	//发布视频
	$('#videoSave').click(function(){
		var flag = $("#form").validate().form();
		if(flag){
			if($('#videoUrl').val() == '' || $('#videoUrl').val() == null){
				alert("请上传视频");
			}else{
				$.ajax({
					type : "post",
					url : path + "/wapVideo/addVideo.html",
					dataType : "json",
					data : {
						logId : "3e41e815f02f4efca415b5790172ea72",
						videoTitle : $('#title').val(),
						videoUrl : $('#videoUrl').val()
					},
					success : function (msg){
						if(msg.success){
							alert("上传成功,跳转页面");
						}else{
							alert(msg.errorMsg);
						}
					},
					error : function(){
						alert("请检查网络");
					}
				});
			}
		}
	});
	
	//添加视频
	$('#addVideo').click(function(){
		openBrowse1();
	});
})
/**
 * 点击选择文件
 */
function openBrowse1(){ 
	var ie=navigator.appName=="Microsoft Internet Explorer" ? true : false; 
	if(ie){ 
	document.getElementById("videoAdd").click(); 
//	document.getElementById("filename").value=document.getElementById("file").value;
	}else{
	var a=document.createEvent("MouseEvents");//FF的处理 
	a.initEvent("click", true, true);  
	document.getElementById("videoAdd").dispatchEvent(a); 
	} 
}

/**
 * 选择文件后事件
 * @param url
 */
function judgeVideo(url){
	//获取文件后缀名
	index = url.lastIndexOf(".");
	ext = url.substr(index+1);
	//判断文件格式是否是视频格式
    arrExt = new Array('3gp','rmvb','flv','wmv','avi','mkv','mp4','mp3','wav');
    flag = false;
    for(var item in arrExt){
    	if(ext == arrExt[item]){
    		flag = true;
    		break;
    	}
    }
    if(flag){
    	$('#readonly').val(url);
    	$('#textEle').show();
    }else{
    	alert("视频文件只能为: '3gp','rmvb','flv','wmv','avi','mkv','mp4'");
    }
}
/**
 * 上传视频事件
 */
function addVideo(){
	readonlyUrl = $('#readonly').val();
	if(readonlyUrl == '' || readonlyUrl == null){
		alert("请选择视频文件");
	}else{
		
		var formData = new FormData($("#uploadVideo")[0]);
		$.ajax({
			type : "post",
			url : path + "/wapVideo/uploadVideo.html",
			jsonp : 'callback',
			contentType : false,
			processData : false,
			dataType : "json",
			data : formData,
			success : function (msg){
				if(msg.success){
					videoPath = msg.obj;
					html = "<video controls='controls'height='300px' width='300px'><source src='"+path + videoPath+"'/></video>";
					$('#videoSrc').html(html);
					$('#videoSrc').show();
					$('#textEle').hide();
					$("#videoUrl").val(videoPath);
				}else{
					alert("上传视频失败");
				}
			}
		});
	}
}