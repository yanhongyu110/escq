$(function() {
	kindEditorImg();
	$("#btn")
			.click(
					function() {
						var providerDetails = $("#providerDetails").val();
						var photourl = $("#info_icon").val();
						if (checkNull(providerDetails)) {
							alert("个人说明不能为空！");
							return;
						} else if (checkNull(photourl)) {
							alert("照片不能为空！");
							return;
						} else if (checkLength(providerDetails, 0, 200)) {
							alert("个人说明在200字以内！");
							return;
						} else {
							$.ajax({
										url :path+ '/userinfo/providerRecommend/addProviderRecommend.html',
										type : 'post',
										dataType : 'json',
										data : {
											prDetails : providerDetails,
											prPhoto : photourl,
										},
										success : function(jr) {
											if (jr.errorCode == '1') {
												alert(jr.ErrorMsg);
											} else if (jr.errorCode == '2') {
												alert(jr.errorMsg);
											} else if (jr.errorCode == '3') {
												alert(jr.errorMsg);
											}else {
												alert(jr.errorMsg,null,function(){window.location.reload();},null);
											}
										}
									})
						}
					});
})
function kindEditorImg() {
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
				K('#imageKE').click(
						function() {
							var tt=$(this);
							editor.loadPlugin('image',function(){
								editor.plugin.imageDialog({
								clickFn : function(url,title) {
								$('#info_icon').val(url);
								editor.hideDialog();
								tt.find(".imgshow").attr('src',url);
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
function ret() {
	$.ajax({
		url :path+ '/userinfo/providerRecommend/modifyStateByLogId.html',
		type : 'post',
		dataType : 'json',
		success : function(jr) {
			if (jr.success) {
				console.log(jr.errorMsg);
				window.location.reload();
			} else{
				console.log(jr.errorMsg);
			}
		}
	})
}