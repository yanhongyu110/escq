var order = "SERVICE_SUCCESSNUM DESC";
var province = "";
var city = "";
var area = "";
$(function(){
    showDiv(jsonList,1);
    //$('.sv_sx_zz a').click(function(){
    //    $(this).siblings().css("color","#999");
    //    $(this).siblings().css("border","none");
    //    $(this).siblings().css("background","url("+path+"/images/up.png) no-repeat 75px 5px");
    //    $('.no_bg').css("background","none");
    //    if($(this).text()=='综合排序'){
    //        order = 'SERVICE_SUCCESSNUM DESC';
    //        $(this).css("color","#FB5A5A");
    //        $(this).css("border","1px solid #FB5A5A");
    //    }else if($(this).text()=='约见最多'){
    //        order = 'SERVICE_MEETNUM DESC';
    //        $(this).css("color","#FB5A5A");
    //        $(this).css("background","url("+path+"/images/up_hover.png) no-repeat 75px 5px");
    //        $(this).css("border","1px solid #FB5A5A");
    //    }else if($(this).text()=='口碑最好'){
    //        order = 'SERVICE_MARK DESC';
    //        $(this).css("color","#FB5A5A");
    //        $(this).css("background","url("+path+"/images/up_hover.png) no-repeat 75px 5px");
    //        $(this).css("border","1px solid #FB5A5A");
    //    }else if($(this).text()=='价格最高'){
    //        order = 'PSET_PRICE DESC';
    //        $(this).css("color","#FB5A5A");
    //        $(this).css("background","url("+path+"/images/up_hover.png) no-repeat 75px 5px");
    //        $(this).css("border","1px solid #FB5A5A");
    //    }
    //    selectCommonAjax(1);
    //});
    $('#demo').on('click','a',function(){
        if($(this).parent().parent('ul').attr('name')=='province'){
            province = $(this).text();
            city = '';
            area = '';
            if(province=='全部'){
                province = '';
            }
        }else if($(this).parent().parent('ul').attr('name')=='city'){
            city = $(this).text();
            area = '';
            if(city=='全部'){
                city = '';
            }
        }else if($(this).parent().parent('ul').attr('name')=='area'){
            area = $(this).text();
            if(area=='全部'){
                area = '';
            }
        }
        console.info(province+'--'+city+'--'+area);
        selectCommonAjax(1);
    });
    $('#typeull').on('click','li',function(){
        serviceTypetree = $(this).attr('val');
        jQuery('<form action="'+path+"/company/companyList.html?serviceTypetree"+'" method="post">'
            +'<input type="hidden" name="serviceTypetree" value="'+ serviceTypetree +'" />'
            +'</form>').appendTo('body').submit().remove();
    })
})
function selectCommonAjax(pageNo){
    $.ajax({
        type : "post",
        url : path+'/company/companyListAjax.html',
        dataType:'json',
        data:{
            'order':order,
            'page':pageNo,
            'flag':orz_flag,
            'search':search,
            'province':province
        },
        success:function(res){
            $('#allcount').empty();
            $('#allcount').append(res.count);
            count = res.count;
            $("#myexpert").empty();
            $("#pageDiv").empty();
            showDiv(res.list,res.pageNo);
        }
    });
}


function showDiv(res,pageNo){
    app.list.splice(0,app.list.length);
    for (var i = 0; i < res.length; i++) {
        app.list.push(res[i]);
    }
    app.key=Math.random()+"";
    pageNum(count,10 ,pageNo,'pageDiv');
}