
        var trim_Version = NaN
        try {
            var browser = navigator.appName;
            var b_version = navigator.appVersion;
            var version = b_version.split(";");
            trim_Version = parseInt(version[1].replace(/[ ]/g, "").replace(/MSIE/g, ""));
        } catch (e) {

        }
		
        $(function () {
        	
            if (window.PIE) {
                $('.steps').each(function () {
                    PIE.attach(this);
                });
            }
            $(".expert_mes:gt(0)").hide()
            $(".content-right").height($(".expert_mes:eq(0)").height())
            
            //职位验证
        	$('.piPosition').blur(function(){
        		var tt=$(this); 
        		if(tt.val()!=''&&tt.val()!=null){
          			tt.parents('ul').find('.tips').css({"display":"none"});
    	   		  }else{
    	   			  tt.parents('ul').find('.tips').css({"display":"inline"});
    	   			  tt.parents('ul').find('.tips').html('*必填');
    	   		  }
        	})
        	//工作年限验证
        	$('.piWorkyear').blur(function(){
        		  var tt=$(this); 
        		  var temp=$('.piWorkyear').val();
        		  var wyreg=/^([0-9]|([1-4]+[0-9]))$/;
        		  var res1=temp.match(wyreg);
        		  if(res1==null){
        			  tt.parents('ul').find('.tips').css({"display":"inline"});
        			  tt.parents('ul').find('.tips').html('工作年限的范围0-50');
        		  }else{
        			  tt.parents('ul').find('.tips').css({"display":"none"});
        		  }
        	});
        	
        	//电话号验证
        	$('.piCell').blur(function(){
      		  var tt=$(this); 
      		  var temp=$('.piCell').val();
      		  var res1=checkCell(temp);
      		  if(res1){
      			tt.parents('ul').find('.tips').css({"display":"none"});
      		  }else{
      			tt.parents('ul').find('.tips').css({"display":"inline"});
      			tt.parents('ul').find('.tips').html('手机格式不正确');
      		  }
      	});
        	
        	//邮箱验证
        	$('.piEmail').blur(function(){
        		  var tt=$(this); 
        		  var temp=$('.piEmail').val();
        		  var res1=checkEmail(temp);
        		  if(res1){
        			  tt.parents('ul').find('.tips').css({"display":"none"});
        		  }else{
        			  tt.parents('ul').find('.tips').css({"display":"inline"});
        			  tt.parents('ul').find('.tips').html('邮箱格式不正确');
        		  }
        	});
        	//关键字验证
        	$('.piKeywords').blur(function(){
        		var tt=$(this); 
      		  var temp=$('.piKeywords').val();
      		  temp= temp.replace(new RegExp("，","gm"), ",");
      		  var res= temp.replace(new RegExp(" ","gm"), "");
      		  var res1="";
      		  if(res.substr(res.length-1,1)==","){
      			 res=res.substring(0,res.length-1);
      		  }
      		  $('.piKeywords').val(res);
      		  var reg=/^(((\w||[\u4e00-\u9fa5])+[,])||(\w||[\u4e00-\u9fa5])+){0,5}$/;
      		  var res1=res.match(reg);
      		 if(res1){
      			tt.parents('ul').find('.tips').css({"display":"none"});
	   		  }else{
	   			  tt.parents('ul').find('.tips').css({"display":"inline"});
	   			  tt.parents('ul').find('.tips').html('关键字的数量最多5个');
	   		  }
      		  //$('.piKeywords').val(res);
      	});
        	//
        	
        	//相关链接
        		$('#addrow').click(function(){
					var ss=$("#link").clone(true)
					ss.show(0)
					ss.addClass("linktemp");
					ss.removeAttr("id");
					$('#links').append(ss);
					$('.content-right').css({height:'+=90px'});
				});
        		var confirm=function(tt){
        			tt.parent().parent().remove();
					$('.content-right').css({height:'-=90px'});
        		}
        		
				$('.delrow').click(function(){
					var ss=$(this);
					alert("确定删除这行吗？",null,function(tt){confirm(ss)},function(){});
				});
            	 var ph= $(".mes:contains('生活照片')").parent();
    	 		 var phs=ph.find('.piPhoto').val();
            	 var ph= ph.find('.imgUrl').attr("src",phs);
            	 
            	 var sp= $(".mes:contains('视频封面')").parent();
    	 		 var sps=sp.find('.piComment').val();
            	 var sp2= sp.find('.imgUrl').attr("src",sps);
           
           
            $(".mes_bc:contains('上一步')").click(function () {
            	//改变左边目录当前点
            	//console.log($("#expert").children('.select').children('a').val());
            	
            	
                var parent = $(this).parents(".expert_mes");
                var max = parent.parent().children(".expert_mes").size();
                var index = parent.index();
                if (index > 0) {
                   /*  if (trim_Version >= 10 || isNaN(trim_Version)) {
                        parent.doAnima($.animateType.fadeOutRight)
                        parent.prev().doAnima($.animateType.fadeInLeft)
                    } else { */
                        parent.hide()
                        parent.prev().show()
                    //}
                    $('.content-right').height(parent.prev().height())
                    $.ScrollToPoint($(".content-right").offset().top, 500)
                }
            })
            $(".mes_bc:contains('下一步')").click(function () {
            	  var parent = $(this).parents(".expert_mes");
            	  var validate=true;
            	  //验证基本信息页面input长度
            	
            	  if(parent.index()==0){
              		  parent.find("input").each(function(){
              			  if($(this).val().length>30){
              				var tt=$(this);
              				tt.parents('ul').find('.tips').css({"display":"inline"});
           	   			  	tt.parents('ul').find('.tips').html('字数不能30字');
    		              		validate=false;
              			  }		
              		  })
    		            	//验证工作年限
    		            	 var piWorkyear=$('.piWorkyear').val();
    		                 var wyreg=/^([0-9]|[1-4]+[0-9])$/;
    		                 if(piWorkyear.match(wyreg)==null){
    		                	 var tt=$('.piWorkyear');
    		          				tt.parents('ul').find('.tips').css({"display":"inline"});
    		       	   			  	tt.parents('ul').find('.tips').html('工作年限的范围0-50');
    		             		validate=false;
    		             	}
    		            	 
    		            	 	//验证手机号正确性
    		            	 	var phone=$('.piCell').val();
    		                 if(!checkCell(phone)){
    		                	 var tt=$('.piCell');
    		          				tt.parents('ul').find('.tips').css({"display":"inline"});
    		       	   			  	tt.parents('ul').find('.tips').html('手机格式不正确');
    		             		validate=false;
    		             		
    		             	} 
    		             	//邮箱验证
    		             	var email=$('.piEmail').val();
    		                 if(!checkEmail(email)){
    		                	 var tt=$('.piEmail');
    		          				tt.parents('ul').find('.tips').css({"display":"inline"});
    		       	   			  	tt.parents('ul').find('.tips').html('邮箱格式不正确');
    		             		validate=false;
    		             		
    		             	}  
    		             	 //关键字验证
    			              var temp=$('.piKeywords').val();
    			       		  var reg=/^(((\w||[\u4e00-\u9fa5])+[,])||(\w||[\u4e00-\u9fa5])+){0,5}$/;
    			       		  if(temp.match(reg)==null){
    			       			var tt=$('.piKeywords');
    	          				tt.parents('ul').find('.tips').css({"display":"inline"});
    	       	   			  	tt.parents('ul').find('.tips').html('关键字不能超过5个');
    		              		validate=false;
    		              	} 
              	  	}
                
              	
               //验证每个页面所填内容是否为空
       	 		var temp={};
                 	parent.find("input,textarea").each(function(){
                 		if($(this).attr('name')==undefined){
                 		return;
                 		}
                 		temp[$(this).attr('name')]=$(this).val();
                 		var value = $(this).val();
                 		if($(this).attr('name')=="pciEaducate"||$(this).attr('name')=="pciCredentials"||$(this).attr('name')=="pciOthers"||$(this).attr('name')=="pciImage"){
                 			
                		}else if(value==""||value==null||value==undefined){
                			var tt=$(this);
                			tt.parents('ul').find('.tips').html('*必填');
	          				tt.parents('ul').find('.tips').css({"display":"inline"});
	          				validate=false;
                 		}
                 	})
                
       	 		
                  //滑动效果
                  var max = parent.parent().children(".expert_mes").size();
                  var index = parent.index();
                  if(validate){
                  if (index < max - 1) {
                     /*  if (trim_Version >= 10 || isNaN(trim_Version)) {
                          parent.doAnima($.animateType.fadeOutLeft)
                          parent.next().show().doAnima($.animateType.fadeInRight)
                      } else { */
             		 	parent.hide()
                      parent.next().show()
                      $('.content-right').height(parent.next().height())
            	 		$.ScrollToPoint($(".content-right").offset().top, 500)
                      }    
                  }
              })
              var timeout=function(){
              	 $(".mes_bc:contains('保存')").attr("disabled","false");
              }
               //提交
               $(".mes_bc:contains('保存')").click(function (){
              	
              	 $(".mes_bc:contains('保存')").attr("disabled","true");
              	 setTimeout(timeout, 3000);
                
                	 var ph= $(".mes:contains('生活照片')").parent();
                	 var ph1= ph.find('.imgUrl').attr("src");
                	 ph.find('.piPhoto').val(ph1);
                	 
                	 var sp= $(".mes:contains('视频封面')").parent();
                	 var sp1= sp.find('.imgUrl').attr("src");
                	 sp.find('.piComment').val(sp1);
                	 
                	//将url地址整合为json数据
                  	 var urls=[];
                  	 var validate=true;
                  	
                  	 $('#links').find('.linktemp').each(function(){
                  		 var temp=[];
                  		 var i=$(this).index()-2; //
                  		 var linkname=$(this).find(".linkname").val();
                  		 var linkurl=$(this).find(".linkurl").val();
                  		 if(linkname!=""||linkurl!="")
                  		 {
                  		 if(!(linkurl.indexOf("http")>=0)){
                  			 linkurl="http://"+linkurl;
                  		 }
                  		 console.log(linkurl)
                  		var regurl=/^((ht|f)tps?):\/\/[\w\-]+(\.[\w\-]+)+([\w\-\.,@?^=%&:\/~\+#]*[\w\-\@?^=%&\/~\+#])?$/;
                  		try{
                  		if(linkurl.match(regurl)==null){
                  			throw new Error;
                  		 }else{
                  			 temp[0]=linkname;
                  			 temp[1]=linkurl;
                  			 urls[i]=temp;
                  		 }
                  		
                  		}
                  		catch(error){
                       		validate=false;
                       		alert("请确认第"+(i+1)+"个网址的正确性！");
                       	}
                  	  }
                  	 })
                  	 console.log(JSON.stringify(urls));
                  	 $('.piUrls').val(JSON.stringify(urls));
                 	
         	 		
          
          
            	//$('form').submit();
            	 var temp={};
            	 try{
                 	$("#form").find("input,textarea").each(function(){
                 		//将input框中的’ '去除
             			var qc=$(this).val();
             			qc=qc.replace(new RegExp("'","gm"), "");
             			$(this).val(qc);
                 		if($(this).attr('name')==undefined){
                 		return;
                 		}
                 		temp[$(this).attr('name')]=$(this).val();
                 		var value=$(this).val();
                 		if($(this).attr('name')=="piUrls"||$(this).attr('class')=="linkname"||$(this).attr('class')=="linkname"||
                 				$(this).attr('name')=="pciEaducate"||$(this).attr('name')=="pciCredentials"||$(this).attr('name')=="pciOthers"||$(this).attr('name')=="pciImage"||
                 				$(this).attr('name')=="piComment"||$(this).attr('name')=="piVideo"||$(this).attr('name')=="piBrief"){
                 		
                 		}else if(value==""||value==null||value==undefined){
                 			
                 			var mes=$(this).parent().prevAll('.mes').html();
                     		var res=mes.replace(new RegExp("：","gm"), "");
                 			alert(res+"不能为空，请确认填写完整后点击下一步");
                 			console.log(mes);
                 			throw new Error;
                 		}
                 	})
                 	}
                 	catch(error){
                 		validate=false;
                 	}
                 	if(temp.piUrls==null||temp.piUrls==''||temp.piUrls==undefined)
                 	{temp.piUrls=[];}
 				 temp.piCom=$('select[name=piCom]').val();
                  console.log(temp);

                 	if(validate){
	                  $.ajax({
	                      type : "POST",
	                      url : path+"/checkinfo/providerCheck/modifyBasic.html",
	                      data :temp,
	                      success : function(result) {//返回数据根据结果进行相应的处理
	                    	  var ajaxobj=JSON.parse(result);
	                              if(ajaxobj.success){
	                            	  alert(ajaxobj.errorMsg);
	                            	 // alert(ajaxobj.errorMsg,null,function(){window.location.href=path+ajaxobj.obj;},null);
	                              }else {
	                              	 alert(ajaxobj.errorMsg);
	                          }
	                      }
	                  });
                 	}
            	
             })
        })
        //上传图片
        $(function () {
            kindEditorImg();
        })
        function kindEditorImg() {
            KindEditor.ready(function (K) {
                var editor = K.editor({
                    uploadJson: path + '/kindEditor/4.1.10/jsp/upload_json.jsp',
                    fileManagerJson: path + '/kindEditor/4.1.10/jsp/file_manager_json.jsp',
                    allowFileManager: true,
                });
                $('.expert_mes').eq(1).find('.upload').unbind();
                //网络+本地
                K('.upload').click(function () {
                	var temp=$(this);
                    editor.loadPlugin('image', function () {
                        editor.plugin.imageDialog({
                            clickFn: function (url, title) {
                            	
                                K('#info_icon').val(url);
                                editor.hideDialog();
                                temp.find('.imgUrl').attr('src',url);
                               
                            },
                        });
                    });
                });
                
              //视频
                K('.media_click').click(function() {
                    editor.loadPlugin('media', function() {
                        editor.plugin.media.edit({
                        	
                        });
                    });
                });
            });
        }
