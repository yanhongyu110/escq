var gIndex = 0;
var gTitle = '';
$(function () {
    loadJScript();


})


function alert(str) {
    swal(str);
}

//实现异步加载
function loadJScript() {
    var script = document.createElement("script");
    script.type = "text/javascript";
    script.src = "http://api.map.baidu.com/api?v=2.0&ak=ZKdaE3UIUmMVnZLl9IxLU5gsFTQAGaMV&callback=init";
    document.body.appendChild(script);
}
var loc;
//初始化地图
function init() {
    var map = new BMap.Map('allmap', {enableMapClick: false});
    map.centerAndZoom('重庆', 10);
    map.addControl(new BMap.CityListControl({
        anchor: BMAP_ANCHOR_TOP_LEFT,
        offset: new BMap.Size(20, 30), //偏移
        onChangeAfter: function () {
        }
    }));

    map.enableScrollWheelZoom();
    map.enableInertialDragging();
    map.enableContinuousZoom();

    $('#searchBtn').click((function (m, gi) {
        return function () {
            m.clearOverlays();
            var content = $("#txtContent").val();
            //if (content == '') {
            //    alert("请输入关键字")
            //    return;
            //}
            setMarker(m, gi, content);
            $('#resultPanel').css({display: 'block'});
            //setMarker(m, gi, content);

        }
    })(map, gIndex));

    var geolocation = new BMap.Geolocation();
    var gc = new BMap.Geocoder();
    geolocation.getCurrentPosition(function (r) {   //定位结果对象会传递给r变量

            if (this.getStatus() == BMAP_STATUS_SUCCESS) {  //通过Geolocation类的getStatus()可以判断是否成功定位。
                var pt = r.point;
                console.log(pt)
                loc = pt;
                var marker = new BMap.Marker(pt);
                marker.disableMassClear();
                //marker.setIcon(new BMap.Icon("../../map/wap/myjs/123123.png",new BMap.Size(50,50)))
                marker.setAnimation(BMAP_ANIMATION_BOUNCE)
                map.addOverlay(marker);
                map.panTo(loc)
            } else {
                switch (this.getStatus()) {
                    case 2:
                        alert('位置结果未知 获取位置失败.');
                        break;
                    case 3:
                        alert('导航结果未知 获取位置失败.');
                        break;
                    case 4:
                        alert('非法密钥 获取位置失败.');
                        break;
                    case 5:
                        alert('对不起,非法请求位置  获取位置失败.');
                        break;
                    case 6:
                        alert('对不起,当前 没有权限 获取位置失败.');
                        break;
                    case 7:
                        alert('对不起,服务不可用 获取位置失败.');
                        break;
                    case 8:
                        alert('对不起,请求超时 获取位置失败.');
                        break;
                }
            }

        },
        {
            enableHighAccuracy: true
        });
}


//添加标注
function setMarker(map, index, title) {
    var pageSize = 5;
    var point = new Array(); //存放标注点经纬信息的数组
    var marker = new Array(); //存放标注点对象的数组
    var info = new Array(); //存放提示信息窗口对象的数组
    var infoWindow = new Array();//存放检索信息窗口对象的数组
    $.ajax({
        url: 'http://api.map.baidu.com/geosearch/v3/nearby?location=' + loc.lng + ',' + loc.lat,
        data: {
            geotable_id: 160206,
            ak: 'ZKdaE3UIUmMVnZLl9IxLU5gsFTQAGaMV',
            page_index: index,   //分页索引
            page_size: pageSize,   //分页数目
            tags: title,
            radius: parseInt($('#rrr').val())
        },
        dataType: "jsonp",
        type: 'GET',
        success: function (data) {
            console.info(data)
            if (data.message == '成功' || data.status == 0) {
                map.clearOverlays();

                //画圆
                var circle = new BMap.Circle(loc,parseInt($('#rrr').val()),{fillColor:"blue", strokeWeight: 1 ,fillOpacity: 0.3, strokeOpacity: 0.3});
                map.addOverlay(circle);


                $('#resultPanel').html('');
                var pois = data.contents;
                var pageList = '';
                if (data.size > 0) {
                    var pageTotal = '<div class="addrTotal">' +
                        '<span id="tot">共<b>' + data.total + '</b>个地址,第<b>' + (gIndex + 1) + '</b>页,共<b>' + Math.ceil(data.total / pageSize) + '</b>页</span>' +
                        '<a href="javascript:void(0)" id="cal"   style="text-align: center;;width: 50px;;margin-right: 0px;position: fixed;right: 0px;display: inline-block;background: white;">切换</a>' +
                        '</div>';
                    var ul = $('<ul class="resultMap" style="height:' + ($(document).height() - 130) + 'px;"></ul>');
                    var li = null;
                    for (var i = 0; i < data.size; i++) {
                        var p0 = pois[i].location[0]; //
                        var p1 = pois[i].location[1]; //按照原数组的point格式将地图点坐标的经纬度分别提出来
                        point[i] = new window.BMap.Point(p0, p1); //循环生成新的地图点
                        marker[i] = new window.BMap.Marker(point[i]); //按照地图点坐标生成标记
                        map.addOverlay(marker[i]);
                        // 创建信息窗口对象
                        info[i] = [{
                            address: pois[i].address,
                            district: pois[i].district,
                            brief: pois[i].brief,
                            provider: pois[i].provider,
                            tags: pois[i].tags,
                            img: pois[i].img,
                            distance: pois[i].distance
                        }];
                        var tmpl = $('<div></div>');
                        $('#infoWindowData').tmpl(info[i]).appendTo(tmpl);
                        //创建百度样式检索信息窗口对象
                        infoWindow[i] = new BMap.InfoWindow(tmpl.html(), {
                            title: pois[i].title,      //标题
                            width: $('#infoWindowData').width(),             //宽度
                            height: $('#infoWindowData').height(),              //高度
                            offset: new BMap.Size(0, -20)
                        });
                        //搜索结果
                        var datas = [{
                            title: pois[i].title,
                            address: pois[i].address,
                            brief: pois[i].brief,
                            tags: pois[i].tags,
                            img: pois[i].img,
                            distance: pois[i].distance
                        }];
                        li = $('<li style="height: 100px"></li>');
                        $('#infoData').tmpl(datas).appendTo(li);
                        li.click((function (m) {
                            return function () {
                                map.openInfoWindow(infoWindow[m], point[m]);
                                $('#resultPanel').css({left: '100%'});
                            }
                        })(i));
                        ul.append(li);
                        //添加点击事件
                        marker[i].addEventListener('click',
                            (function (k) {
                                // js 闭包
                                return function () {
                                    map.openInfoWindow(infoWindow[k], point[k]);
                                }
                            })(i)
                        );
                        if (0 == i) {
                            map.openInfoWindow(infoWindow[i], point[i]);
                        }
                    }
                    $('#resultPanel').append(pageTotal);
                    $('#resultPanel').append(ul);
                    var pageNum = Math.ceil(data.total / pageSize);

                    if (pageNum > 1) {
                        li = $('<li class="pageList"></li>');
                        var up = $('<a href ="javascript:void(0)">上一页</a>');
                        var down = $('<a href ="javascript:void(0)">下一页</a>')
                        up.click(function () {
                            if (gIndex > 0) {
                                console.log(gIndex)
                                gIndex--;
                                setMarker(map, gIndex, title);
                            } else {
                                gIndex = 0;
                            }
                        })
                        down.click(function () {
                            if (gIndex < pageNum - 1) {
                                console.log(gIndex)
                                gIndex++;
                                setMarker(map, gIndex, title);
                            } else {
                                gIndex = pageNum - 1;
                            }
                        })
                        li.append(up);
                        li.append(down);
                        /*for (var i = 0; i < pageNum; i++) {
                         var j = i + 1;
                         if (i != index) {
                         aA =$('<a href ="javascript:void(0)">' + j + '</a>');
                         li.append(aA);
                         } else {
                         aA = $('<a>' + j + '</a>');
                         li.append(aA);
                         }
                         aA.click((function(k){
                         return function(){
                         setMarker(map,k,title);
                         }
                         })(i));
                         }*/
                        //li.html(pageList);
                        ul.append(li);
                    }

                } else {
                    $('#resultPanel').html(
                        '<div class="addrTotal">' +
                        '<span id="tot">共<b>' + data.total + '</b>个地址</span>' +
                        '<a href="javascript:void(0)" id="cal"   style="text-align: center;width: 50px;;margin-right: 0px;position: fixed;right: 0px;display: inline-block;background: white;">切换</a>' +
                        '</div>' +
                        '<div class="failResult">' +
                        '<h4>未找到相关地址：</h4>' +
                        '<p>1.请核对地址拼写正确。<br>' +
                        '2.请尝试其他关键字。</p>' +
                        '</div>'
                    );
                }

                var changeFlag=0;

                $('#cal').click(function () {
                    if (changeFlag==1){
                        $('#resultPanel').css({'left': '0%'})
                        changeFlag=0;
                    }else {
                        $('#resultPanel').css({'left': '100%'})
                        changeFlag=1;
                    }

                })
            } else {
                alert('查询失败')
            }

        }
    })
}


/*'<p style="width:280px;margin:0;line-height:20px;">'+
 '地址：' + pois[i].address +
 '<br>区域：' + pois[i].district +
 '<br>图片：' + pois[i].img +
 '<br>自定义地址：' +pois[i].addr +
 '<br>简介：' + pois[i].brief +
 '<input type=button value=搜索>' +
 '<br>服务商主键:' + pois[i].provider +'</p>';*/
