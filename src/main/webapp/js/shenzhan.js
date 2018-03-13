
$(function() {
				$('.serch_ss').click(function() {
					$('.serch_content').hide(':not(:animated)');
					$(this).next('.serch_content:not(:animated)').slideToggle();
				})
			})