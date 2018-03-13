var app;

$(function () {


//appDataConfig设置
    if (appDataConfig.flag=='a'){
        appDataConfig.name='服务';
        appDataConfig.orderList=[
            {name:"综合排序", order:"SERVICE_SUCCESSNUM DESC",isActive:true},
            {name:"约见最多", order:"SERVICE_MEETNUM DESC",isActive:false},
            {name:"口碑最好", order:"SERVICE_MARK DESC",isActive:false},
            {name:"价格最高", order:"PSET_PRICE DESC",isActive:false}
        ];
    }else if (appDataConfig.flag=='b'){
        appDataConfig.name='专家';
        appDataConfig.orderList=[
            {name:"综合排序", order:"PI_DEALNUM DESC",isActive:true},
            {name:"约见最多", order:"PI_MEETNUM DESC",isActive:false},
            {name:"口碑最好", order:"PI_MARK DESC",isActive:false},
            {name:"价格最高", order:"PSET_PRICE DESC",isActive:false}
        ];
    }else if (appDataConfig.flag=='c'){
        appDataConfig.name='需求';
    }

//排序设置

    appDataConfig.order=0;


    //类型列表
    if (appDataConfig.module!=''&&appDataConfig.type=='')appDataConfig.type=appDataConfig.module;
    $.post(path+'/search/types.html',{fid:appDataConfig.module},function (r) {
        appDataConfig.typeList=r;
    },'json');

    app=new Vue({
        el:'.content',
        data:appDataConfig,
        methods:{
            changOrder:function (index) {
                app.order=index;
                selectCommonAjax(app.page);
            },
            changType:function (id) {
                app.type=id;
                app.page=1;
                selectCommonAjax(app.page);
            },
            go:function (input) {
                var url=path;
                switch (this.flag){
                    case "a":
                        url+='/goodsinfo/service/queryServiceDetails.html?serviceId='+input.serviceId+"&priceType=1&comId=111";
                        break;
                    case "b":
                        url+='/userinfo/providerdetails/preproviderdetails.html?logId='+input.piLogId+'&comId=111';
                        break;
                    case "c":
                        url+='/demand/queryById.html?id='+input.demId;
                        break;
                    default:
                        break;
                }
                location.href=url;
            }
        }
    });


    if (appDataConfig.useCitys) $('#demo').citys({province: appDataConfig.province, city: appDataConfig.city, area: appDataConfig.area, required: false});


    $('#demo').on('click', 'a', function () {
        if ($(this).parent().parent('ul').attr('name') == 'province') {
            appDataConfig.province = $(this).text();
            appDataConfig.city = '';
            appDataConfig.area = '';
            if (appDataConfig.province == '全部') {
                appDataConfig.province = '';
            }
        } else if ($(this).parent().parent('ul').attr('name') == 'city') {
            appDataConfig.city = $(this).text();
            appDataConfig.area = '';
            if (appDataConfig.city == '全部') {
                appDataConfig.city = '';
            }
        } else if ($(this).parent().parent('ul').attr('name') == 'area') {
            appDataConfig.area = $(this).text();
            if (appDataConfig.area == '全部') {
                appDataConfig.area = '';
            }
        }
        selectCommonAjax(1);
    });

    selectCommonAjax(1);

});


function selectCommonAjax(pageNo) {

    $('body').animate({'scrollTop':$('.content').offset().top},100);

    appDataConfig.page=pageNo;

    var url=path;
    switch (appDataConfig.flag){
        case "a":
            url+='/goodsinfo/ServiceInfo/searchServiceByAjax.html';
            break;
        case "b":
            url+='/goodsinfo/ServiceInfo/searchServiceByAjax.html';
            break;
        case "c":
            appDataConfig.useCitys=false;
            url+='/demand/showListAjax.html';
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
            appDataConfig.key=Math.random()+"";
            app.contentCount = res.count;
            $("#pageDiv").empty();
             app.contentList=res.list;
            pageNum(appDataConfig.contentCount, 10, res.pageNo, 'pageDiv');
            
        },
        error:function(res){
        	alert("加载数据失败")
        }
    });
}
