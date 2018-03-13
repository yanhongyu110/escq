$(function(){

	if(null!=loginfo&''!=loginfo){
		$.ajax({
			type: "POST",
			url:path+ "/bizinfo/collectUtod/judgeCollect.html",
			data:{
				"demId":$("#demId").val()
			},
			success: function (data) {
				var temp=JSON.parse(data);
				console.log(temp)
				if(temp.success){
					$("#collect").text("已加入收藏夹");
					$("#collect").css("background","rgb(170,170,170)");
					$("#collect").unbind("click");
				}else{
					$("#collect").html("加入收藏");
				}
			}
		});
	}
	
	$("#collect").click(function(){
		if(loginfo==null||loginfo==''){
			alert("请先登陆后，再加入收藏！");
		}else{
		  
			$.ajax({
				type: "POST",
				url:path+ "/bizinfo/collectUtod/addCollect.html",
				data:{
					"demId":$("#demId").val()
				},
				success: function (data) {
					console.log(data)
					var temp=JSON.parse(data);
					alert(temp.errorMsg);
					$("#collect").text("已加入收藏夹");
					$("#collect").css("background","rgb(170,170,170)");
					$("#collect").unbind("click");
				}
			});
		}
		})
	
	
})