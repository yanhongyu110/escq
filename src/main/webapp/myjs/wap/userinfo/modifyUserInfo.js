$(function(){
	kindEditorImg();
	if($('#index').val()==1){
		$('.nicheng').css({
			height:'auto'
		});
		$('.imgs').click(function(){
			var ii = $($('.imgs')[0]).attr('src');
			$($('.imgs')[0]).attr('src',$(this).attr('src'));
			//$(this).attr('src',ii);
		})
		$('#save').click(function(){
			$.ajax({
				url:path+'/wap/userinfo/modifyUserinfo.html',
				data:{
					val: $($('.imgs')[0]).attr('src'),
					i: $('#index').val()
				},
				type:'post',
				dataType:'json',
				cache:false,
				success:function(jr){
					if(jr.errorCode=='1'){
						alert("传入信息为空");
					}else if(jr.errorCode=='2'){
						alert("修改信息失败");
					}else{
						alert("修改成功");
						window.location.href=path+"/wap/userinfo/jumpmodifyUserInfo.html"
					}
				}
				
			})
		})
		
	}else{
		$('#save').click(function(){
			$.ajax({
				url:path+'/wap/userinfo/modifyUserinfo.html',
				data:{
					val:$('#info').val(),
					i:$('#index').val()
				},
				type:'post',
				dataType:'json',
				cache:false,
				success:function(jr){
					if(jr.errorCode=='1'){
						alert("传入信息为空");
					}else if(jr.errorCode=='2'){
						alert("修改信息失败");
					}else{
						alert("修改成功",null,function(){window.location.href=path+"/wap/userinfo/jumpmodifyUserInfo.html";},null);
					}
				}
				
			})
		})
	}
	
	
})
function kindEditorImg() {
	KindEditor.ready(function(K) {
		var editor = K.editor({
			uploadJson : path + '/kindEditor/4.1.10/jsp/upload_json.jsp',
			fileManagerJson : path
					+ '/kindEditor/4.1.10/jsp/file_manager_json.jsp',
			allowFileManager : true,
		});

		// 网络+本地
		K('.headimg').click(function() {
			var temp = $(this);
			editor.loadPlugin('image', function() {
				editor.plugin.imageDialog({
					clickFn : function(url, title) {

						//K('#info_icon').val(url);
						editor.hideDialog();
						$($('.imgs')[0]).attr('src',url);
					},
				});
			});
		});

	});
}