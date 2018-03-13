
$(function(){
	showDiv(jsonList1,1);
	showDiv(jsonList2,2);
	
	initCommonType11();
	       
});

function sub(){
	$('#myformm').submit();
}

function initCommonType11(){
	  $.ajax({
		  async:false,
		  type:'post',
		  dataType:'json',
		  data:{fid:module},
		  url:path+'/search/types.html',
		  success:function(data){
			  var type =data;
			  var typeList = data;
			  console.info(data)
              for(var i =0 ;i<typeList.length;i++){
                  var commonType = typeList[i].ctName;
                  console.info(typeList[i].ctComment)
                  var commonImg = typeList[i].ctComment;
                  var id = typeList[i].ctId;
                  var num = i+ 1;
                  $("#d1").append('<a class="swiper-slide" style="text-align: center;" href="'+path+'/wap/search/view.html?type='+id+'"><img style="width: 85%;" src="'+commonImg+'" alt="" /><br/><span style="font-size: 16px;">'+commonType+'</span></a>');
                  /*if(i < 4){
                  } else if(i < 8){
                      $("#d2").append('<a href="'+path+'/wap/search/view.html?type='+id+'"><img src="'+commonImg+'" alt="" /><span>'+commonType+'</span></a>');
                  }*/
              }
              $("#d1").append('<a class="swiper-slide" style="text-align: center;" href="'+path+'/wap/search/view.html"><img style="width: 85%;" src="'+path+'/images/wap/lisimg8'+'.png" alt="" /><br/><span style="font-size: 16px;">更多</span></a>');
              var mySwiper = new Swiper ('#app02', {
                  observer:true,//修改swiper自己或子元素时，自动初始化swiper
                  observeParents:true,
                  slidesPerView:5,
                  freeMode: true,
                  slidesPerGroup: 5,
                  slidesOffsetBefore: 0,
              })
			  
		  }
	  })
}

function showDiv(res,ul){
	for(var i in res){
		if(i < 2){
			var arr = res[i];
			var serviceTitle = arr["serviceTitle"];
			var serviceSuccessnum = arr["serviceSuccessnum"];
			var servicePic = arr["servicePic"];
			var serviceMark = arr["serviceMark"];
			var psetPrice = arr["psetPrice"];
			var serviceId = arr["serviceId"];
			var inner = null;
			if(i == 0){
				inner = '<li class="img_right">'
					+'<div class="img_right_iim"><img src="'+localhostPath+(servicePic||"")+'" onclick="gotoServiceDetails(\''+(serviceId||"")+'\')"></div>'
					+'<h3>'+(serviceTitle||"")+'</h3>'
					
					+'</li>'
			} else {
				inner = '<li class="img_right">'
					+'<div class="img_right_iim"><img src="'+localhostPath+(servicePic||"")+'" onclick="gotoServiceDetails(\''+(serviceId||"")+'\')"></div>'
					+'<h3>'+(serviceTitle||"")+'</h3>'
					
					+'</li>'
			}
			if(ul==1){
				$('#myul1').append(inner);
			}else if(ul==2){
				$('#myul2').append(inner);
			}
		}
	}
}

function gotoServiceDetails(serviceId){
	var priceType = 1;
	jQuery('<form action="'+path+"/wap/goodsinfo/service/queryServiceDetails.html"+'" method="get" target="_blank">'
			+'<input type="hidden" name="serviceId" value="'+ serviceId +'" />'
			+'<input type="hidden" name="priceType" value="'+ priceType +'" />'
			+'</form>').appendTo('body').submit().remove();
}