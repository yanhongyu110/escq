$(function() {
	kindEditorImg();
	$("#sub").click(function() {
		var photourl=$("#info_icon").val();
		var logCell = $("#logCell1").val();
		var logName = $("#logName1").val();
		var userRealName = $("#userRealName1").val();
		var userWechat = $("#userWechat1").val();
		var userPhoto = photourl;
		
		if(validate(logName,userWechat,userPhoto)){
			$.ajax({
				url :path+ '/userinfo/modifyUserinfo.html',
				type : 'post',
				dataType : 'json',
				data : {
					logName : logName,
					userWechat : userWechat,
					userPhoto : userPhoto
				},
				success : function(jr) {
					if(jr.errorCode=='1'){
						alert("传入信息为空");
					}else if(jr.errorCode=='2'){
						alert("修改信息失败");
					}else if(!jr.success){
						alert(jr.errorMsg);
					}else{
						alert("修改成功","修改信息",function(){
							window.location.reload();	
						})	
						
					}
				}
		})
		}
	});
	function validate(logName,userWechat,userPhoto) {
		if (checkNull(logName)) {
			alert("请输入昵称！");
			return false;
		}
		if (checkLength(logName,1,9)) {
			alert("昵称长度为1-9位！");
			return false;
		}
		if (checkNull(userWechat)) {
			alert("请输入微信！");
			return false;
		}
		if (checkLength(userWechat,1,20)) {
			alert("微信号长度位1-20位！");
			return false;
		}
		if (checkNull(userPhoto)) {
			alert("请添加照片！");
			return false;
		}
		return true;
	}

})
function kindEditorImg(photourl) {
	KindEditor
			.ready(function(K) {
				var editor = K.editor({
					uploadJson : path
							+ '/kindEditor/4.1.10/jsp/upload_json.jsp',
					fileManagerJson : path
							+ '/kindEditor/4.1.10/jsp/file_manager_json.jsp',
					allowFileManager : true,
				});
				/*
				 * // 单图片上传 var uploadbutton = K.uploadbutton({ button :
				 * K('#imgBtn')[0], fieldName : 'imgFile', url :
				 * path+'/kindEditor/4.1.10/jsp/upload_json.jsp', afterUpload :
				 * function(data) { if (data.error === 0) {
				 * $("#info_icon1").val(data.url); var imgShow=""; imgsShow+='<img
				 * style="width:100px;height:100px;float:left;"
				 * src="'+path+'/'+data.url.substring(data.url.indexOf("files"))+'"
				 * width="100" height="100" />';
				 * $("#imgsShow").append(imgsShow); } } });
				 */
				// 网络+本地
				K('.upload').click(
								function() {
									var tt=$(this);
									editor.loadPlugin('image',function(){
										editor.plugin.imageDialog({
										clickFn : function(url,title) {
										$('#info_icon').val(url);
										editor.hideDialog();
										$(".imgshow").attr('src',url);
																	},
																});
													});
								});
				/*
				 * uploadbutton.fileBox.change(function(e) {
				 * uploadbutton.submit(); });
				 */

			})

}
/*
 * $(function() {
 * 
 * });
 */