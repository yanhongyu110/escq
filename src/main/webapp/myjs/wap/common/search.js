var app;
var selectArea
var s = true;


$(function () {

    $('body').bind('touchmove', function (e) {
        //console.log($(this).scrollTop()); // 计算你的屏幕高度
        if (($(window).scrollTop() >= $(document).height() - $(window).height()) && s) {
            app.isAdd = true;
            var img = "<img src='" + path + "/images/wap/1.gif' style='width: 50px;height: 50px;' />";
            $("#loding").html(img);
            // pageTop=$('body').scrollTop();
            app.page++;
            selectCommonAjax(app.page);
            s = false;
        }
    });

    Vue.filter('cut', function (value, input) {
        if (value.length > input) {
            return value.substring(0, input) + '...';
        } else return value;
    });


//appDataConfig设置
    if (appDataConfig.flag == 'a') {
        appDataConfig.name = '服务';
        appDataConfig.orderList = [
            {name: "综合排序", order: "SERVICE_SUCCESSNUM DESC", isActive: true},
            {name: "约见最多", order: "SERVICE_MEETNUM DESC", isActive: false},
            {name: "口碑最好", order: "SERVICE_MARK DESC", isActive: false},
            {name: "价格最高", order: "PSET_PRICE DESC", isActive: false}
        ];
    } else if (appDataConfig.flag == 'b') {
        appDataConfig.name = '专家';
        appDataConfig.orderList = [
            {name: "综合排序", order: "PI_DEALNUM DESC", isActive: true},
            {name: "约见最多", order: "PI_MEETNUM DESC", isActive: false},
            {name: "口碑最好", order: "PI_MARK DESC", isActive: false},
            {name: "价格最高", order: "PSET_PRICE DESC", isActive: false}
        ];
    } else if (appDataConfig.flag == 'c') {
        appDataConfig.name = '需求';
    }

//排序设置

    appDataConfig.order = 0;


    //类型列表
    if (appDataConfig.module != '' && appDataConfig.type == '') appDataConfig.type = appDataConfig.module;
    $.post(path + '/search/types.html', {fid: appDataConfig.module}, function (r) {
        appDataConfig.typeList = r;
    }, 'json');


    app = new Vue({
        el: '#page',
        data: appDataConfig,
        methods: {
            changOrder: function (index) {
                app.order = index;
                app.page = 1;
                app.isAdd = false;
                selectCommonAjax(app.page);
            },
            changType: function (id) {
                app.type = id;
                app.page = 1;
                app.isAdd = false;
                selectCommonAjax(app.page);
            },
            more: function () {
                app.isAdd = true;
                // pageTop=$('body').scrollTop();
                app.page++;
                selectCommonAjax(app.page);
            },
            go: function (input) {
                var url = path;
                switch (this.flag) {
                    case "a":
                        url += '/wap/goodsinfo/service/queryServiceDetails.html?serviceId=' + input.serviceId + "&priceType=1";
                        break;
                    case "b":
                        url += '/wap/userinfo/providerdetails/preproviderdetails.html?logId=' + input.piLogId;
                        break;
                    case "c":
                        url += '/wap/demand/queryById.html?id=' + input.demId;
                        break;
                    default:
                        break;
                }
                location.href = url;
            }
        },
        updated: function () {
            // if (pageTop!=0) {
            //     $('body').scrollTop(pageTop);
            //     pageTop = 0;
            // }
            if (appDataConfig.typeList.length != 0) {
                if (!window.dd) {
                    moveNav('#moveNav', 0);
                    window.dd = {};
                }
            }
        }
    });


    selectCommonAjax(1);


    if (appDataConfig.useCitys) {
        //地形初始化
        selectArea = new MobileSelectArea();
        selectArea.init({trigger: $('#area'), data: path + '/js/data.json', default: 0});
        var ss = selectArea.submit;
        selectArea.submit = function () {
            ss.call(selectArea);
            var text = selectArea.text;
            appDataConfig.province = text[0];
            appDataConfig.city = text[1];
            appDataConfig.area = text[2];
            app.page = 1;
            app.isAdd = false;
            selectCommonAjax(app.page);
        };
        $('#area_btn').on('click', function () {
            selectArea.oldvalue = selectArea.value.concat([]);
            selectArea.oldtext = selectArea.text.concat([]);
            if (selectArea.trigger[0].nodeType == 1) {
                //input
                selectArea.trigger.val('  ');
                selectArea.trigger.attr('data-value', '  ');
                appDataConfig.province = '';
                appDataConfig.city = '';
                appDataConfig.area = '';
                app.page = 1;
                app.isAdd = false;
                selectCommonAjax(app.page);
            }
        })
    }


});


function selectCommonAjax(pageNo) {

    appDataConfig.page = pageNo;

    var url = path;
    switch (appDataConfig.flag) {
        case "a":
            url += '/goodsinfo/ServiceInfo/searchServiceByAjax.html';
            break;
        case "b":
            url += '/goodsinfo/ServiceInfo/searchServiceByAjax.html';
            break;
        case "c":
            appDataConfig.useCitys = false;
            url += '/demand/showListAjax.html';
            break;
        default:
            break;
    }


    $.ajax({
        type: "post",
        url: url,
        dataType: 'text',
        data: {
            'order':appDataConfig.orderList.length!=0?appDataConfig.orderList[appDataConfig.order].order:'',
            'page': appDataConfig.page,
            'flag': appDataConfig.flag,
            'search': appDataConfig.search,
            'province': appDataConfig.province,
            'city': appDataConfig.city,
            'area': appDataConfig.area,
            'type':appDataConfig.type,
            'to':appDataConfig.to
        },
        success: function (result) {
        	res= eval('(' + result + ')');
            var tt = Math.ceil(res.count / 10);
            if (tt >= res.pageNo) {
                s = true;
                appDataConfig.key = Math.random() + "";

                if (app.isAdd) {
                    for (var i = 0; i < res.list.length; i++) {
                        var obj = res.list[i];
                        app.contentList.push(obj);
                    }
                    // app.contentList=app.contentList.concat(res.list);
                    // setTimeout(function () {
                    // },1000)

                } else {

                    app.contentList = res.list;
                }

                app.contentCount = res.count;
            } else {
                $("#loding").html("没有更多了")
            }

        },
        error:function(res){
        	alert("加载数据失败");
        }
    });
}



