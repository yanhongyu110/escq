$(function(){
	var refundstate = $('#refundstate').val();
	console.log(refundstate);
	if(refundstate==1){
		$('#apply').addClass("on");
		$('#expert').addClass("on");
	}else if(refundstate==3 || refundstate==6){
		$('#apply').addClass("on");
		$('#expert').addClass("on");
		$('#platform').addClass("on");
	}else if(refundstate==4 || refundstate==5 || refundstate==2){
		$('#apply').addClass("on");
		$('#expert').addClass("on");
		$('#platform').addClass("on");
		$('#complete').addClass("on");
	}
});