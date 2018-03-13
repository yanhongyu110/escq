//从session中获取logId
var logId;

$(function(){
	//更改日期按钮变手指
	$("div.sc-yleft,div.sc-yright,div.sc-mleft,div.sc-mright,span.sc-return-today").css("cursor","pointer");
	
	//获取session中的logId
	$.post(""+path+"/userinfo/arrangement/getlogid.html",function(data){
		logId=JSON.parse(data).obj.logId;
	});
	
//	初始化选择器
	setTimeout("myreload()",50);
//	日历刷新时跟新选择器
	$(".sc-return-today").click(function(){
		setTimeout("myreload()",100);
	});
	$(".sc-yleft").click(function(){
		setTimeout("myreload()",100);
	});
	$(".sc-yright").click(function(){
		setTimeout("myreload()",100);
	});
	$(".sc-mleft").click(function(){
		setTimeout("myreload()",100);
	});
	$(".sc-mright").click(function(){
		setTimeout("myreload()",100);
	});
	$(".sc-select-year").change(function(){
		setTimeout("myreload()",100);
	});
	$(".sc-select-month").change(function(){
		setTimeout("myreload()",100);
	});
	
	
	//	点击弹出模态框
	$(".sc-item").click(function(){
		//初始化编辑化模态框
		initEditModal();
		$("#content-ipt").val("");
		$("#startTime-ipt").val("");
		$("#endTime-ipt").val("");
		$("#arrId").val("");
		$("tr[valign='middle']").remove();
		var date = getDate($(this));
		$("#modal-title").text(date);
		$("#editModal-title").html(date);
		$.ajax({
			url:""+path+"/userinfo/arrangement/selectarrangebydate.html",
			data:{
				"arrCurday":date,
				"arrSeverid":logId
				},
			dataType:"json",
			success:function(sucResult){
				if (sucResult['success']==true) {
					var length = sucResult['obj'].length;
					var dateResult = sucResult['obj']['0'];
					if (length>0) {
						for(var i=0;i<length;i++){
							var id = sucResult['obj'][i]['arrId'];
							var content = sucResult['obj'][i]['arrContent'];
							var startTime = sucResult['obj'][i]['arrStarttime'];
							var endTime = sucResult['obj'][i]['arrEndtime'];
							$(".table").append("<tr valign='middle'>"+
									"<td>"+(i+1)+"</td>"+
									"<td>"+content+"</td>"+
									"<td>"+startTime+"</td>"+
									"<td>"+endTime+"</td>"+
									"<td><button onclick='remove("+i+",this)' class='btn btn-danger btn-xs'>删除</button>"+
									"<input id="+("hide"+i)+" value="+id+" type="+"hidden"+" />"+
									"<button onclick='updateBTN("+i+")' class='btn btn-primary btn-xs'>修改</button></td></tr>");
						}
						$('#Modal').modal('show');
					}
				}else{
					if (sucResult['errorMsg']=="没有预约") {
						$('#editModal').modal('show');
					}
					
				}
			},
			error:function(errResult){
				console.info(Msg);
			}
		});
	});
	
	//点击新增按钮弹出编辑模态框
	$("#modal-add-btn").click(function(){
		//初始化编辑化模态框
		initEditModal();
		$("#editModal").modal('show');
	});
	
	//点击保存判断添加OR更新档期
	$("#modal-save-btn").on("click",bindAddAndUpdate);
	/*$("#modal-save-btn").click(function(){
		alert("请确定是否保存！",null,function(){
			if ($("#content-ipt").val()==null||$("#content-ipt").val()==""||
					$("#endTime-ipt")==null||$("#endTime-ipt").val()==""||
					$("#startTime-ipt").val()==null||$("#startTime-ipt").val()=="") {
				$('#messageH3').html("内容未填写完整！");
				$('#messageModal').modal('show');
			}else if ($("#startTime-ipt").val()>$("#endTime-ipt").val()) {
				$('#messageH3').html("请选择正确的时间");
				$('#messageModal').modal('show');
			}else{
				if ($("#arrId").val()==null||$("#arrId").val()=="") {
					add();
				} else {
					update();
				}
			}
		},function(){});
	});*/
	
//	表单失去焦点判断是否为空值,是否超出长度
	$("#content-ipt").blur(function(){
		if($("#content-ipt").val().length>45) {
			$("#content-div").addClass("has-error");
			$('#messageH3').html("备注请勿超过45个字符！");
			$('#messageModal').modal('show');
		} else if($("#content-ipt").val()==null||$("#content-ipt").val()=="") {
			$("#content-div").addClass("has-error");
			$("#content-ipt").attr("placeholder","备注信息必须填写！");
		}else{
			$("#content-div").removeClass("has-error");
			$("content-ipt").attr("placeholder","请输入备注信息！");
		}
	});
	
//	选择时间插件
	$('.form_time').datetimepicker({
        language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 1,
		minView: 0,
		maxView: 1,
		forceParse: 0
   });
});

//TODO 绑定  添加 或者 更新要执行的代码 ： 解决  重复提交  js端
function bindAddAndUpdate(){
	//马上解绑点击事件
	$("#modal-save-btn").off("click",bindAddAndUpdate);
	alert("请确定是否保存!",null,function(){
		if ($("#content-ipt").val()==null||$("#content-ipt").val()==""||
				$("#endTime-ipt")==null||$("#endTime-ipt").val()==""||
				$("#startTime-ipt").val()==null||$("#startTime-ipt").val()=="") {
			$('#messageH3').html("内容未填写完整！");
			$('#messageModal').modal('show');
			$("#modal-save-btn").on("click",bindAddAndUpdate);
		}else if ($("#startTime-ipt").val()>$("#endTime-ipt").val()) {
			$('#messageH3').html("请选择正确的时间");
			$('#messageModal').modal('show');
			$("#modal-save-btn").on("click",bindAddAndUpdate);
		}else{
			if ($("#arrId").val()==null||$("#arrId").val()=="") {
				add();
			} else {
				update();
			}
		}
	},function(){
		$("#modal-save-btn").on("click",bindAddAndUpdate);
	});
}

//更新选择器
function myreload(){
	var daysElement = $(".sc-days").find(".sc-item");//遍历日历表格
	var daylists = new Array();
	var date=null;
	for (var i = 0;i<daysElement.size();i++) {
		var dayElement = daysElement[i];
		$(dayElement).attr("id","id"+i);
		date = getDate(dayElement);
		daylists[i]=date;
		$(dayElement).attr("title","");
		$(dayElement).removeClass("sc-mark");
		$.ajax({
			url:""+path+"/userinfo/arrangement/selectarrangebydate.html",
			data:{
				"arrCurday":date,
				"arrSeverid":logId
				},
			dataType:"json",
			success:function(sucResult){
				if (sucResult['success']==true) {
					var dateResult = sucResult['obj']['0']['arrCurday'];
					for (var int = 0; int < daylists.length; int++) {
						if (daylists[int]==dateResult) {
							$("#id"+int).addClass("sc-mark");
						}
					}
				}
			},
			error:function(errResult){
				console.info(errResult);
			}
		});
	}
}


//获取当前日历格子日期
function getDate(dayElement){
	var year = $(".sc-select-year").val();
	var month = $(".sc-select-month").val();
	var day = $(dayElement).find(".day").text();
	var day = day.length==2?day:("0"+day);
	if ($(dayElement).hasClass("sc-othermenth")) {
		if (day>20) {
			if ($(".sc-select-month").val()==1) {
				year=$(".sc-select-year").val()-1;
				month=12;
			}else{
				year=$(".sc-select-year").val();
				month=$(".sc-select-month").val()-1;
			}
		}else{
			if ($(".sc-select-month").val()==12) {
				year=$(".sc-select-year").val()-1+2;
				month=1;
			}else{
				year=$(".sc-select-year").val();
				month=$(".sc-select-month").val()-1+2;
			}
		}
	}
	var month = month>9?month:("0"+month);
	var date =year+"-"+month+"-"+day;
	return date;
}


//点击修改按钮弹出编辑模态框
function updateBTN(i){
	var arrId = $("#hide"+i).val();
	$.ajax({
		url:""+path+"/userinfo/arrangement/selectarrangebyid.html",
		data:{
			"arrId":arrId
		},
		dataType:"json",
		type:"post",
		success:function(sucResult){
			if (sucResult['success']==true) {
				$("#content-ipt").val(sucResult['obj']['arrContent']);
				$("#startTime-ipt").val(sucResult['obj']['arrStarttime']);
				$("#endTime-ipt").val(sucResult['obj']['arrEndtime']);
				$("#arrId").val(sucResult['obj']['arrId']);
				$("#editModal").modal('show');
			}else{
				$('#messageH3').html(sucResult['errorMsg']);
				$('#messageModal').modal('show');
			}
		},
		error:function(errResult){
			$('#messageH3').html(errResult);
			$('#messageModal').modal('show');
		}
	});
}

//删除档期方法  //  thisEl   表示当前被点击的按钮
function remove(i,thisEl){
	 //console.log(thisEl);
	  $el = $(thisEl);
	  $el.attr("onclick","");
	 alert("请确定是否删除档期！",null,function(){temp(i)},function(){
		 // 添加绑定事件   便于取消后 下一次 依然可以点击
		 $el.attr("onclick","remove("+i+",this)");
	 });
}
function temp(i){
	var arrId = $("#hide"+i).val();
	$('#Modal').modal('hide');
	  $.ajax({
		url:""+path+"/userinfo/arrangement/removearrangebyid.html",
		data:{
			"arrId":arrId
			},
		dataType:"json",
		type:"post",
		success:function(sucResult){
			if (sucResult['success']==true) {
				$('#messageH3').html("删除成功！");
				$('#messageModal').modal('show');
				setTimeout("myreload()",100);
			}else{
				$('#messageH3').html(sucResult['errorMsg']);
				$('#messageModal').modal('show');
			}
		},
		error:function(errResult){
			$('#messageH3').html(errResult);
			$('#messageModal').modal('show');
		}
	});
}

//添加档期
function add(){
	$.ajax({
		url:""+path+"/userinfo/arrangement/addarrange.html",
		data:{
			"arrSeverid":logId,
			"arrContent":$("#content-ipt").val(),
			"arrStarttime":$("#startTime-ipt").val(),
			"arrEndtime":$("#endTime-ipt").val(),
			"arrCurday":$("#editModal-title").text()
		},
		dataType:"json",
		type:"post",
		success:function(sucResult){
			if (sucResult['success']==true) {
				$('#messageH3').html("保存成功！");
				$('#messageModal').modal('show');
				$('#Modal').modal('hide');
				$("#editModal").modal('hide');
				setTimeout("myreload()",100);
			}else{
				$('#messageH3').html(sucResult['errorMsg']);
				$('#messageModal').modal('show');
			}
			$("#modal-save-btn").on("click",bindAddAndUpdate);
		},
		error:function(errResult){
			$('#messageH3').html(errResult);
			$('#messageModal').modal('show');
			$("#modal-save-btn").on("click",bindAddAndUpdate);
		}
	});
}

//修改档期
function update(){
	$.ajax({
		url:""+path+"/userinfo/arrangement/updatearrange.html",
		data:{
			"arrContent":$("#content-ipt").val(),
			"arrStarttime":$("#startTime-ipt").val(),
			"arrEndtime":$("#endTime-ipt").val(),
			"arrId":$("#arrId").val()
		},
		dataType:"json",
		type:"post",
		success:function(sucResult){
			if (sucResult['success']==true) {
				$('#messageH3').html("保存成功！");
				$('#messageModal').modal('show');
				$('#Modal').modal('hide');
				$("#editModal").modal('hide');
				setTimeout("myreload()",100);
			}else{
				$('#messageH3').html(sucResult['errorMsg']);
				$('#messageModal').modal('show');
			}
			$("#modal-save-btn").on("click",bindAddAndUpdate);
		},
		error:function(errResult){
			$('#messageH3').html(errResult);
			$('#messageModal').modal('show');
			$("#modal-save-btn").on("click",bindAddAndUpdate);
		}
	});
}

//初始化编辑模态框方法
function initEditModal(){
	$("#content-div").removeClass("has-error");
	$("startTime-div").removeClass("has-error");
	$("endTime-div").removeClass("has-error");
}

