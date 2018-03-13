var idCardRegx = /^\d{15}|\d{18}$/;
var nameRegx = /^[\u4e00-\u9fa5]{2,4}$/;


var idCardIsRepeat;
var nameIsSuccess;
var idCardIsSuccess;

$(function(){
	if($('#msg_con').html()!=null&&$('#msg_con').html()!=''){
		idCardIsRepeat=false;
		nameIsSuccess=true;
		idCardIsSuccess=true;
	}
	
	$('#name').blur(function(){
		nameIsSuccess = regx(nameRegx,$('#name').val());
		if(!nameIsSuccess){
			$('#nameicon').css({"color":"red"});
			$('#nameicon').html(' ✖ 您输入的姓名有误^_^');
		}else{
			$('#nameicon').css({"color":"green"});
			$('#nameicon').html(' ✔ ');
		}
	});
	$('#idcard').blur(function(){
		idCardIsSuccess = regx(idCardRegx,$('#idcard').val());
		if(!idCardIsSuccess){
			$('#idcardicon').css({"color":"red"});
			$('#idcardicon').html(' ✖ 您输入的身份证有误^_^');
		}else{
			$.ajax({
				url:path+"/checkinfo/perosonCheckName/queryPcnIdnumberIsEquals.html",
				type:'post',
				dataType:'json',
				data:{
					"pcnIdnumber":$('#idcard').val()
				},
				success:function(result){
					idCardIsRepeat = result;
					if(!idCardIsRepeat){
						$('#idcardicon').css({"color":"green"});
						$('#idcardicon').html(' ✔ ');
					}else{
						$('#idcardicon').css({"color":"red"});
						$('#idcardicon').html(' ✖ 该身份证已实名^_^');
					}
				}
			});
			
		}
	});
	
	var sfzimgjson = $('#sfzimg').val();
	if(sfzimgjson!=null&&sfzimgjson!=''){
		var sfzimgobj = eval( '(' + sfzimgjson + ')' );
		//var sfzimgobj = JSON.parse(sfzimgjson);
		var before = sfzimgobj.pcnFrontidJust;
		var back = sfzimgobj.pcnFrontidBack;
		$('#image1').find('img').attr({"src":before});
		$('#image2').find('img').attr({"src":back});
	}
	
})


function regx(r,s){
	if (r == null || r == ""){
		return false;
	}
	var patrn= new RegExp(r);
	if (patrn.exec(s))
		return true
		return false
}

function submit(ii){
	
	pcnFrontidJust = $('#image1').find('img').attr('src');
	pcnFrontidBack = $('#image2').find('img').attr('src');
	pcnReverseid = $('#image3').find('img').attr('src');
		if(!idCardIsRepeat /*&& nameIsSuccess && idCardIsSuccess && pcnFrontidJust!='' && pcnFrontidBack!='' && pcnReverseid!=''*/){
			if(nameIsSuccess){
				if(idCardIsSuccess){
					if(pcnFrontidJust!='' || pcnFrontidBack!='' || pcnReverseid!=''){
						var pcnFrontid = '{"pcnFrontidJust":"'+pcnFrontidJust+'","pcnFrontidBack":"'+pcnFrontidBack+'"}';
						console.info(pcnFrontid);
					}else{
						var pcnFrontid='';
					}
						$.ajax({
							url:path+(!ii?"/checkinfo/perosonCheckName/reAddPersonCheck.html":"/checkinfo/perosonCheckName/addPersonCheck.html"),
							type:'post',
							dataType:'json',
							data:{
								"pcnRelname":$('#name').val(),
								"pcnIdnumber":$('#idcard').val(),
								"pcnFrontid":pcnFrontid,
								"pcnReverseid":pcnReverseid
							},
							success:function(result){
								if(result.success){
									location.href=path+result.obj;
								}else{
									alert(result.errorMsg);
								}
							}
						});
					/*}else{
						$('#sfwarning').css({"color":"red"});
						$('#sfwarning').html(' ✖ 您必须上传身份证信息后才能进行实名认证^_^');
					}*/
				}else{
					$('#idcardicon').html(' ✖ 您输入的身份证有误^_^');
					$('#idcard').focus();
				}
			}else{
				$('#nameicon').html(' ✖ 您输入的姓名有误^_^');
				$('#name').focus();
			}
		}else{
			$('#idcardicon').html(' ✖ 该身份证已实名^_^');
			$('#idcard').focus();
		}
	
}


KindEditor.ready(function(K) {
	doUpload(K,'idCardBtnJust','image1');
	doUpload(K,'idCardBtnBack','image2');
	doUpload(K,'idCardBtnHold','image3');
});

function doUpload(K,btn,val){

		var editor = K.editor({
			uploadJson: path + '/kindEditor/4.1.10/jsp/upload_json.jsp',
			fileManagerJson: path + '/kindEditor/4.1.10/jsp/file_manager_json.jsp',
			allowFileManager: true,
		});

		//网络+本地
		K('#'+val).click(function () {
			var temp=$(this);
			editor.loadPlugin('image', function () {
				editor.plugin.imageDialog({
					clickFn: function (url, title) {
                        $('#'+val).find('img').attr({"src":url});
                        editor.hideDialog();
					}
				});
			});
		});






    //
	//uploadbutton.fileBox.change(function(e) {
	//   	 uploadbutton.submit();
	//});
}




