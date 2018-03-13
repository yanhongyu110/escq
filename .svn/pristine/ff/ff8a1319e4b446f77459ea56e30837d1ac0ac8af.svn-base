
$(function(){
	var $slider = $('.expert ul');
	var $slider_child_l = $('.expert ul li').length;
	var $slider_width = $('.expert ul li').width();
	$slider.width($slider_child_l * ($slider_width+15));

	var slider_count = 0;

	if ($slider_child_l < 5) {
		$('#btn-right').css({cursor: 'auto'});
		$('#btn-right').addClass("dasabled");
	}

	$('#btn-right').click(function() {
		if ($slider_child_l < 5 || slider_count >= $slider_child_l - 4) {
			return false;
		}
		slider_count++;
		var swidth = $slider_width;
		swidth+=15;
		$slider.animate({left: '-=' + swidth + 'px'}, 'slow');
		slider_pic();
	});

	$('#btn-left').click(function() {
		if (slider_count <= 0) {
			return false;
		}
		slider_count--;
		var swidth = $slider_width;
		swidth+=15;
		$slider.animate({left: '+=' + swidth + 'px'}, 'slow');
		slider_pic();
	});
	function slider_pic() {
		if (slider_count >= $slider_child_l - 6) {
			$('#btn-right').css({cursor: 'auto'});
			$('#btn-right').addClass("dasabled");
		}
		else if (slider_count > 0 && slider_count <= $slider_child_l - 6) {
			$('#btn-left').css({cursor: 'pointer'});
			$('#btn-left').removeClass("dasabled");
			$('#btn-right').css({cursor: 'pointer'});
			$('#btn-right').removeClass("dasabled");
		}
		else if (slider_count <= 0) {
			$('#btn-left').css({cursor: 'auto'});
			$('#btn-left').addClass("dasabled");
		}
	}
	/*$('.expert a').hover(function() {
		if ($(this).find('img:animated').length) return;
		$(this).animate({marginTop: '0px'}, 370);
		$(this).find('img').animate({width: '240px'}, 370);
	}, function() {
		$(this).animate({marginTop: '20px'}, 370);
		$(this).find('img').animate({width: '240px'}, 370);
	});*/
})