        var trim_Version = NaN
        try {
            var browser = navigator.appName;
            var b_version = navigator.appVersion;
            var version = b_version.split(";");
            trim_Version = parseInt(version[1].replace(/[ ]/g, "").replace(/MSIE/g, ""));
        } catch (e) {

        }
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

                //网络+本地
                K('.upload').click(function () {
                	var temp=$(this);
                    editor.loadPlugin('image', function () {
                        editor.plugin.imageDialog({
                            clickFn: function (url, title) {
                            	
                                K('#info_icon').val(url);
                                editor.hideDialog();
                                temp.attr('src',url);
                               
                            },
                        });
                    });
                });
                
                
                //视频
                K('#media').click(function() {
                    editor.loadPlugin('media', function() {
                        editor.plugin.media.edit({
                        	
                        });
                    });
                });
            });
        }
      
  
        $(function () {

        	//工作年限验证
        	$('.piWorkyear').blur(function(){
        		  var tt=$(this); 
        		  var temp=$('.piWorkyear').val();
        		  var wyreg=/^([0-9]|([1-4]+[0-9]))$/;
        		  var res1=temp.match(wyreg);
        		  var mes=tt.parents(".item").find(".personer_mes_ts");
        		  if(res1==null){
        			  mes.css({"display":"block;"});
        			  mes.html("工作年限不能超过50");
        		  }else{
        			  mes.css({"display":"none"});
        		  }
        	});
        	
        	//电话号验证
        	$('.piCell').blur(function(){
      		  var tt=$(this); 
      		  var temp=$('.piCell').val();
      		  var res1=checkCell(temp);
      		  if(res1){
      			  tt.parent().next().css({"display":"none"});
      			  
      		  }else{
      			  tt.parent().next().css({"display":"block"});
      			tt.parent().next().html("手机格式错误");
      		  }
      	});
        	
        	//邮箱验证
        	$('.piEmail').blur(function(){
        		  var tt=$(this); 
        		  var temp=$('.piEmail').val();
        		  var res1=checkEmail(temp);
        		  if(res1){
        			  tt.parent().next().css({"display":"none"});
        		  }else{
        			  tt.parent().next().css({"display":"block"});
        			  tt.parent().next().html("邮箱格式错误");
        		  }
        	});
        	//关键字验证
        	$('.piKeywords').blur(function(){
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
    			 tt.parent().next().css({"display":"none"});
   		  }else{
   			  tt.parent().next().css({"display":"block"});
   			  tt.parent().next().html("关键字最多5个");
	   		  }
      		  //$('.piKeywords').val(res);
      	});
/*        	//将url地址分离并赋给img的src
    		$('.imgUrls').each(function(){
    			//每个 .urls 的父节点
    			var temp=$(this).parent();
    			var urls=temp.find('.imgUrls').val();
    			if(urls!=null&&urls!=""){
    			var arr=new Array();
    	 		 arr=urls.split(',');
            	 var url1= temp.find('.imgUrl').eq(0).attr("src",arr[0]);
            	 var url2= temp.find('.imgUrl').eq(1).attr("src",arr[1]);
    			}
    		})
        	 var ph= $('.piPhoto').parent();
	 		 var phs=ph.find('.piPhoto').val();
        	 var ph= ph.find('.imgUrl').attr("src",phs);
        	 
        	 var sp= $('.piComment').parent();
	 		 var sps=sp.find('.piComment').val();
        	 var sp2= sp.find('.imgUrl').attr("src",sps);
        	*/
        /*    if (window.PIE) {
                $('.steps').each(function () {
                    PIE.attach(this);
                });
            }*/
            $(".personer_mes_zl:gt(0)").hide()
            $(".personer_mes").height($(".personer_mes_zl:eq(0)").height())
            $(".excit:contains('上一步')").click(function () {
                var parent = $(this).parents(".personer_mes_zl");
                var max = parent.parent().children(".personer_mes_zl").size();
                var index = parent.index();
                if (index > 0) {
                        parent.hide()
                        parent.prev().show()
                    $('.personer_mes').height(parent.prev().height())
                    $.ScrollToPoint($(".personer_mes").offset().top, 500)
                }
            })
            $(".excit:contains('下一步')").click(function(){
                var parent = $(this).parents(".personer_mes_zl");
                var validate=true;
              //将imgurl 付给input框
                parent.find('.imgUrls').each(function(){
            		var hehe=$(this);
            		var urls="";
            		hehe.parent().find('.imgUrl').each(function(){
            			var url=$(this).attr('src');
            			if(url!=undefined&url!=""){
            			urls=urls+url+",";}
            		})
            		if(urls!=""){
            			urls=urls.substring(0,urls.length-1);
            		}
            		hehe.val(urls);
           	 })
          	  
          		//验证每个页面所填内容是否为空
         	 		var temp={};
                   	parent.find("input,textarea").each(function(){
                   		if($(this).attr('name')==undefined){
                   		return;
                   		}
                   		temp[$(this).attr('name')]=$(this).val();
                   		var value = $(this).val();
                   		if($(this).attr('name')=="pciEaducate"||$(this).attr('name')=="pciCredentials"||$(this).attr('name')=="pciOthers"){
                   			$(this).parents(".item").find(".personer_mes_ts").html("*选填");
                  		}else if(value==""||value==null||value==undefined){
                       		$(this).parents(".item").find(".personer_mes_ts").html("*必填");
                       		validate=false;
                   		}
                   	})
                 if(parent.index()==0){
                 if(validate){
		            	//验证工作年限
          		  		if(!workYear($('.piWorkyear').val())){
          		  			$(".piWorkyear").parents(".item").find(".personer_mes_ts").html("工作年限不能超过50");
          		  			validate=false;
		            	 	}else{
		            	 		$(".piWorkyear").parents(".item").find(".personer_mes_ts").html("");
		            	 	}
		            	 //验证手机号正确性
          		  		if(!checkCell($('.piCell').val())){
          		  			$(".piCell").parents(".item").find(".personer_mes_ts").html("手机格式错误");
          		  			validate=false;
	            	 	}else{
	            	 		$(".piCell").parents(".item").find(".personer_mes_ts").html("");
	            	 	}
		             	//邮箱验证
          		  		if(!checkEmail($('.piEmail').val())){
          		  			$(".piEmail").parents(".item").find(".personer_mes_ts").html("邮箱格式错误");
          		  			validate=false;
	            	 	}else{
	            	 		$(".piEmail").parents(".item").find(".personer_mes_ts").html("");
	            	 	}
		             	 //关键字验证
          		  		if(!keyWords($('.piKeywords').val())){
          		  			$(".piKeywords").parents(".item").find(".personer_mes_ts").html("关键字不能超过5个");
          		  			validate=false;
	            	 	}else{
	            	 		$(".piKeywords").parents(".item").find(".personer_mes_ts").html("");
	            	 	}
          		  		$("#piArea").val($("#piArea").val().replace(/ /gm,'-'));
                 	}
                 }
	              
	                var max = parent.parent().children(".personer_mes_zl").size();
	                var index = parent.index();
	                if(validate){
	                if (index < max - 1) {
	                   /*  if (trim_Version >= 10 || isNaN(trim_Version)) {
	                        parent.doAnima($.animateType.fadeOutLeft)
	                        parent.next().show().doAnima($.animateType.fadeInRight)
	                    } else { */
	           		 	parent.hide();
	                    parent.next().show();
	                    $('.personer_mes').height(parent.next().height());
	          	 		$.ScrollToPoint($(".personer_mes").offset().top, 500);
	          	 		
	                    }    
                 	}
            })
            var timeout=function(){
            	 $(".excit:contains('提交')").attr("disabled","false");
            }
             //提交
             $(".excit:contains('保存')").click(function (){
            	var validate=true;
            	 $(".excit:contains('提交')").attr("disabled","true");
            	 setTimeout(timeout, 3000);
            	 
            	 var ph= $('.piPhoto').parent();
            	 var ph1= ph.find('.imgUrl').attr("src");
            	 ph.find('.piPhoto').val(ph1);
            	 //console.log(ph.find('.piPhoto').val());
            	 
            	 var sp= $('.piComment').parent();
            	 var sp1= sp.find('.imgUrl').attr("src");
            	 sp.find('.piComment').val(sp1);
            	 
            	/* var piBrief=$("#piBrief").val();
            	 if(piBrief.length>30){
            		 
            	 }*/
            	 
            	 //验证页面字段是否为空
            	 var temp={};
            	 var parent=$(".personer_mes");
                	parent.find("input,textarea").each(function(){
                		if($(this).attr('name')==undefined){
                		return;
                		}
                		temp[$(this).attr('name')]=$(this).val();
                		var value = $(this).val();
                		if($(this).attr('name')=="pciEaducate"||$(this).attr('name')=="pciCredentials"||$(this).attr('name')=="pciOthers"){
                			$(this).parents(".item").find(".personer_mes_ts").html("*选填");
               		}else if(value==""||value==null||value==undefined){
                    		$(this).parents(".item").find(".personer_mes_ts").html("*必填");
                    		validate=false;
                		}
                	})
      
            	if(temp.piUrls==null||temp.piUrls==''||temp.piUrls==undefined)
                	{temp.piUrls=[];}
                	temp.piCom=$('select[name=piCom]').val();
                	temp.pciImage='';
                	temp.pciEaducate='';
                	temp.pciCredentials='';
                	temp.pciOthers='';
                	temp.piBrief='';
                	temp.piComment='';
                	temp.piVideo='';
             	console.log(temp)

             	if(validate){
                  $.ajax({
                      type : "POST",
                      url : path+"/wap/checkinfo/providerCheck/modifyBasic.html",
                      data :temp,
                      success : function(result) {//返回数据根据结果进行相应的处理
                    	  var ajaxobj=JSON.parse(result);
                          
                          if(ajaxobj.success){
                        	  alert(ajaxobj.errorMsg,null,function(){window.location.href=path+ajaxobj.obj;},null);
                        	  
                          }else {
                          	 alert(ajaxobj.errorMsg);
                      }
                      }
                  });
             	}
             })
        })
