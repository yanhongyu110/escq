$(function(){
	$('#srContent').click(function () {
        if ($(this).val() == '在此输入评价的内容...') {
            $(this).val('')
        }
    }).keyup(function () {
        if ($(this).val()=="") {
            $('.pj_ts').show();
        } else {
            $('.pj_ts').hide();
        }
    })

});
function sumbitRemake(){
	$('.confirm').unbind('click');
    var content = $('#srContent').val()
    var level = $('.fastComment01').attr("aa");
    //console.info(level)
    var star = $("#starnum").text();

    /*if (content.length < 10) {
        alert("长度过小")
        return;
    }*/

    var data = {}
    data.content = content;
    data.id = $('#osId').val();
    data.orderId = '${obj.orderInfo.orderId}';
    data.level = level;

    $.ajax({
        url: path + '/wap/goodsinfo/serviceRemake/addRemake.do',
        type: 'post',
        data: data,
        success: function (re) {
            //re=JSON.parse(re);
            if (re.success) {
                alert(re.errorMsg,'',function () {
                    window.history.go(-1);
                });
            } else {
                alert(re.errorMsg);
            }
        }
    })
}
