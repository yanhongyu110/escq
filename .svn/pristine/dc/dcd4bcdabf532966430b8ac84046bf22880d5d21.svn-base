<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有实例</title>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
<%@ include file="/WEB-INF/jsp/common/kindeditor.jsp"%>
<script type="text/javascript" >

$(function(){
	kindEditorImg();
})
function kindEditorImg(){
    KindEditor.ready(function (K) {
        var editor = K.editor({
            uploadJson :path+'/kindEditor/4.1.10/jsp/upload_json.jsp',
            fileManagerJson : path+'/kindEditor/4.1.10/jsp/file_manager_json.jsp',
            allowFileManager: true,
        });
      //视频
        K('#media').click(function() {
            editor.loadPlugin('media', function() {
                editor.plugin.media.edit({
                	
                });
            });
        });
        
        
        //网络+本地
        K('#imageKE').click(function() {
            editor.loadPlugin('image', function() {
                editor.plugin.imageDialog({
                    clickFn: function (url, title) {
                        K('#info_icon').val(url);
                        editor.hideDialog();
                        var str = url.substring(url.indexOf("Public"));
                        $("#imgsShow").html("");
                        var imgsShow ='<img style="width:270px;height:220px;" src="'+path+'/'+str+'"/>';
                        $("#imgsShow").append(imgsShow);
                    },
                });
            });
        });
        //单图片上传
        var uploadbutton = K.uploadbutton({
            button : K('#imgBtn')[0],
            fieldName : 'imgFile',
            url : path+'/kindEditor/4.1.10/jsp/upload_json.jsp',
            afterUpload : function(data) {
                    if (data.error === 0) {
                          $("#info_icon1").val(data.url);
                    }
            }
    	});
    	uploadbutton.fileBox.change(function(e) {
           	 uploadbutton.submit();
   		});
    	
    	//多图片上传
    	var urlImage = '';
    	K('#imageKE1').click(function() {
    		editor.loadPlugin('multiimage', function() {
    			editor.plugin.multiImageDialog({
    				clickFn : function(urlList) {
    					var imgsShow = "";
    					var imageInput = K('#imageInput1');
    					K.each(urlList, function(i, data) {
    						if(i != data.length-1){
    							urlImage+=data.url+",";
    						}else{
    							urlImage+=data.url;
    						}
    						
    						imgsShow+='<img style="width:270px;height:220px;" src="'+path+'/'+data.url.substring(data.url.indexOf("files"))+'" width="270" height="220" />';
    					});
    					$("#imgsShow1").append(imgsShow);
    					imageInput.val(urlImage);
    					editor.hideDialog();
    				}
    			});
    		});
    	});
    });
    
  //富文本框设置
    var editor = KindEditor.create('textarea[name="info_brief"]', {
        themeType: 'simple',
        resizeType: 1,
        cssPath : path+'/kindEditor/4.1.10/plugins/code/prettify.css',
        uploadJson :path+'/kindEditor/4.1.10/jsp/upload_json.jsp',
        fileManagerJson : path+'/kindEditor/4.1.10/jsp/file_manager_json.jsp',
        allowFileManager: false,
        afterCreate : function() {
            this.sync();
        },
        afterBlur : function() {
            this.sync();
        },
        minWidth:'300px',
        width:'615px',
        height:'250px'
    });
}
</script>
</head>
<body>
<span>视频上传:</span>
<input type="text" readonly="readonly" style="width: 277px" id="mediaUpload" name="mediaUpload" rows="5"/>
<a href="javascript:void(0)" id="media"><img src="${webtxc}/images/m-img05.jpg" style="vertical-align:middle;margin-top:-3px;width: 65px;height: 23px;" /></a>
<em>注：大小为1M以内</em>
<div id="mediadiv" style="display:balck;">

</div>
<br/>


<span>网络图片+本地图片上传:</span>
<input type="text" readonly="readonly" style="width: 277px" id="info_icon" name="info_icon" rows="5"/>
<a href="javascript:void(0)" id="imageKE"><img src="${webtxc}/images/m-img05.jpg" style="vertical-align:middle;margin-top:-3px;width: 65px;height: 23px;" /></a>
<em>注：大小为1M以内</em>

<span>日期选择框:</span>
<input id="datebox" name="datebox" type="text" class="easyui-datebox" editable="false" style="width: 90px;" />
<br/>

<span>本地图片上传:</span>
<input type="text" readonly="readonly" style="width: 277px" id="info_icon1" name="info_icon1" rows="5"/>
<input type="button" class="button" id="imgBtn" value="选择图片" /></td>
<em>注：大小为1M以内</em><br/>	


<p><label>多图片上传：</label>
<input style="background:#eee;" id="imageInput1" readonly="readonly" type="text" value="" />
<a class="M-SZ" href="javascript:void(0)" id="imageKE1"><img src="${webtxc}/images/m-img05.jpg" style="vertical-align:middle;margin-top:-3px;" width="83" /></a>
<em>注：格式为.JPG，大小为300KB以内</em>
</p>
<div id="imgsShow1" class="M-SZimg" style="margin-bottom:25px;">

</div><br/>

<span>富文本:</span>
<textarea style="width: 610px" id="info_brief" name="info_brief" rows="5"></textarea>						
</body>
</html>