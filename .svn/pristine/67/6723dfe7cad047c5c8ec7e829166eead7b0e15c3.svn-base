var page = 1;
var pageSize = 10;
var companyProvince = "";
var companyType = "";

var s = false;
var isAjax = false;
$(function () {

    initCompany(1);
    $('body').bind('touchmove', function (e) {
        if (($(window).scrollTop() >= $(document).height() - $(window).height()) && s) {
            var img = "<img src='" + path + "/images/wap/1.gif' style='width: 50px;height: 50px;' />";
            $("#loding").html(img);
            initCompany(page++);
            s = false;
        }
    });
    $("select#city").change(function () {
        companyProvince = $(this).val();
        companyType = $("#business").val();
        initCompany(1);
        isAjax = true;
    });
    $("select#business").change(function () {
        companyProvince = $("#city").val();
        companyType = $(this).val();
        initCompany(1);
        isAjax = true;
    });

})

function getAll() {
    companyProvince = "";
    companyType = "";
    initCompany(1);
}

function initCompany(pageNo) {
    $.ajax({
        type: "post",
        url: path + '/wap/goodsinfo/company/queryCompanyDetails.html',
        data: {
            'page': pageNo,
            'pageSize': pageSize,
            'companyProvince': companyProvince,
            'companyType': companyType
        },
        success: function (result) {
            if (result != null && result != "") {
                var res = JSON.parse(result);

                if (res.totalSize == 0) {
                    $(".fond_list").html('<p class="tishi">暂无相关信息  </p>');
                } else {
                    var datas = res.list;
                    var data = {
                        list: datas
                    };
                    var html = template('fond_list1', data);
                    if (isAjax) {
                        $("#fond_list").html(html);
                    } else {
                        $("#fond_list").append(html);
                    }
                    isAjax = false;
                    s = true;
                    $("#loding").html("");
                }
            } else {
                $(".fond_list").html('<p class="tishi">暂无相关信息  </p>');
                $("#loding").html("");
            }

        }, error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("请求对象XMLHttpRequest: " + XMLHttpRequest);
            alert("错误类型textStatus: " + textStatus);
            alert("异常对象errorThrown: " + errorThrown);
        }
    });
}