		//将imgurl 付给input框
$(document).ready(function(){ 
	//将url地址分离并赋给img的src
	$('.imgUrls').each(function(){
		//每个 .urls 的父节点
		var temp=$(this).parent();
		var urls=temp.find('.imgUrls').val();
		if(urls!=""&&urls!=null){
		var arr=new Array();
 		 arr=urls.split(',');
    	 var url1= temp.find('.imgUrl').eq(0).attr('src', arr[0]);
    	 var url2= temp.find('.imgUrl').eq(1).attr('src', arr[1]);
		}
	})
	/*$('.imgUrl').each(function(){
		var tt=$(this);
		if(tt.attr('src')==""||tt.attr('src')==undefined){
			// tt.css("display","none");
		}
	})*/
	/*$('.imgUrls').each(function(){
		var tt=$(this);
		if(tt.val()==""||tt.val()==undefined){
			// tt.parent().css("display","block");
		}
	})*/
	
	})
                    