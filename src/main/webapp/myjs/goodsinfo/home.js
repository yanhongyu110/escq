$(function () {


    $(".expert_sp ul li").hover(function () {
        $(this).find(".sp_mes").stop().animate({height: "198px"}, 400);
        $(this).find(".sp_mes h3").stop().animate({paddingTop: "60px"}, 400);
    }, function () {
        $(this).find(".sp_mes").stop().animate({height: "45px"}, 400);
        $(this).find(".sp_mes h3").stop().animate({paddingTop: "0px"}, 400);
    });


    template.defaults.imports.dataFormat = function (value, format) {
        var date = new Date(value), result = "";
        result = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDay();
        return result;
    };
    template.defaults.imports.cutFormat = function (value) {
        if (value.length > 15) {
            return value.substring(0, 15) + '...';
        } else {
            return value;
        }
    };
    $.post(
        path + '/demand/home.html',
        {},
        function (re) {
            if (re.success) {
                var result = re.result, r1 = [], r2 = [];
                for (var i = 0; i < result.length; i++) {
                    var obj = result[i];
                    if (i <= 4)r1.push(obj);
                    else r2.push(obj);
                }
                var template1 = template('d_temp', {list: r1});
                var template2 = template('d_temp', {list: r2});
                $('.xq_fabu').children().eq(0).append(template1);
                $('.xq_fabu').children().eq(1).append(template2);
            }
        },
        'json'
    );


    $(".b_nav").show();
    showDiv(jsonList1, 1);
    //showDiv(jsonList2, 2);
    console.info(siList);
    $(".slideInner").slide({
        slideContainer: $('.slideInner a'),
        effect: 'easeOutCirc',
        autoRunTime: 4000,
        slideSpeed: 1000,
        nav: true,
        autoRun: true,
        prevBtn: $('a.prev'),
        nextBtn: $('a.next')
    });

    for (var i in siList) {
        var inner = '<a href="' + (siList[i].switchUrl || 'javascript:void(0)') + '" class="banner_0' + (parseInt(i) + 1) + '" target="_blank"></a>'
        $('.slideInner').append(inner);
        $('.banner_0' + (parseInt(i) + 1)).css("background-image", "url(" + localhostPath + siList[i].url + ")");
        $('.banner_0' + (parseInt(i) + 1)).css("background-size", "auto");
        $('.banner_0' + (parseInt(i) + 1)).css("background-position", "0 0");
    }


    $('#mmysearh').click(function () {
        $('#theformm').submit();
    });
    $('.expert a').unbind('mouseenter').unbind('mouseleave');

    $('#typeul').on('click', 'li', function () {
        serviceTypetree = $(this).attr('val');
        jQuery('<form action="' + path + "/goodsinfo/ServiceInfo/showServiceList.html" + '" method="post">'
            + '<input type="hidden" name="serviceTypetree" value="' + serviceTypetree + '" />'
            + '</form>').appendTo('body').submit().remove();
    })
});

function gotoServiceDetails(serviceId) {
    var priceType = 1;
    jQuery('<form action="' + path + "/goodsinfo/service/queryServiceDetails.html" + '" method="get" target="_blank">'
        + '<input type="hidden" name="serviceId" value="' + serviceId + '" />'
        + '<input type="hidden" name="priceType" value="' + priceType + '" />'
        + '<input type="hidden" name="priceType" value="' + priceType + '" />'
        + '</form>').appendTo('body').submit().remove();
}
function gotoDemandDetails(id) {
    jQuery('<form action="' + path + "/demand/queryById.html" + '" method="get" target="_blank">'
        + '<input type="hidden" name="id" value="' + id + '" />'
        + '</form>').appendTo('body').submit().remove();
}
function showDiv(res, ul) {
    var template2 = template('orz_ul',{ulList:[jsonList1,jsonList2]});
    $('.ck-product-list').html('').append(template2);
}

function serviceTypeAjax(serviceTypetree) {
    $.ajax({
        type: "post",
        url: path + '/goodsinfo/ServiceInfo/homeShowByAjax.html',
        dataType: 'json',
        data: {
            'serviceTypetree': serviceTypetree
        },
        success: function (res) {
            $('#myul1').empty();
            $('#myul2').empty();
            jsonList1=res.serList1;
            jsonList2=res.serList2;
            showDiv();
        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("请求对象XMLHttpRequest: " + XMLHttpRequest);
            alert("错误类型textStatus: " + textStatus);
            alert("异常对象errorThrown: " + errorThrown);
        }
    });
}
function showVideo(src) {
    $('#myvideoo').attr("src", src || "");
    $('#myvideodiv').show();
    showDialog();
}
function hideVideo() {
    $('#myvideodiv').hide();
    $('#myvideoo').attr("src", "");
    closeDialog();
}
function showDialog() {
    document.getElementById('popWindow').style.display = 'block';
    document.getElementById('popWindow').style.height = document.body.offsetHeight;
}
function closeDialog() {
    document.getElementById('popWindow').style.display = 'none';
}
