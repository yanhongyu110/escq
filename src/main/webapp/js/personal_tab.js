
$(function(){		
	//设计案例切换
	$('.title-list li').click(function(){
		var liindex = $('.title-list li').index(this);
		$(this).addClass('on').siblings().removeClass('on');
		$('.personal_zhanshi_tab_product div.product').eq(liindex).fadeIn(150).siblings('div.product').hide();
		var liWidth = $('.title-list li').width();
		$('.personal_zhanshi_tab .title-list p').stop(false,true).animate({'left' : liindex * liWidth + 'px'},300);
	});
	
	//设计案例hover效果
	$('.personal_zhanshi_tab_product .product li').hover(function(){
		$(this).css("border-color","#ff6600");
		$(this).find('p > a').css('color','#ff6600');
	},function(){
		$(this).css("border-color","#fafafa");
		$(this).find('p > a').css('color','#666666');
	});
	});
	
	/* deng lu 下拉*/
	
	$(document).ready(function(){		   
	
	$('.dropdown').hover(function() {
		$(this).addClass('dropdown-hover');
		$(".dropdown-sub").show('slow');
	}, function() {
		$(this).removeClass('dropdown-hover');
	});
	
	
});
	
	
	
	


