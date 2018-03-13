/**
 * Created by blazh on 2016/12/13.
 */



function initMap() {




    var scope = angular.element($("#baiduMap")[0]).scope();

    var map = new BMap.Map(scope.baiduMap.mapId, {enableMapClick: false});//构造底图时，关闭底图可点功能
    scope.baiduMap.map = map;
    map.enableScrollWheelZoom();
    map.addControl(new BMap.NavigationControl({type: BMAP_NAVIGATION_CONTROL_LARGE}));
    var point = new BMap.Point(116.404, 39.915);
    map.centerAndZoom(point, 15)


    scope.baiduMap.isDirty = false;
    var marker = new BMap.Marker();
    scope.baiduMap.marker = marker;
    marker.setPosition(map.getCenter())
    map.addOverlay(marker)
    marker.enableDragging()


    var resetMarker = scope.baiduMap.resetMarker = function () {
        var bounds = scope.baiduMap.map.getBounds();
        if (!bounds.containsPoint(scope.baiduMap.marker.getPosition()) || !scope.baiduMap.isDirty) {
            if (scope.baiduMap.marker.getLabel() == null) {
                //var label=new BMap.Label("拖动确定详细位置", {offset: new BMap.Size(-40, -25)})
                var label = null
                //label.setStyle({borderRadius: "2%",border: "1px solid #b1a7a7",boxShadow: "0px 0px 6px 3px #c5c5c5",backgroundColor:"rgb(232, 232, 232)"})
                scope.baiduMap.marker.setLabel(label)
            }
            scope.baiduMap.isDirty = false;
            //scope.baiduMap.marker.setAnimation(BMAP_ANIMATION_BOUNCE)跳动动画
            scope.baiduMap.marker.setPosition(map.getCenter())
            scope.$apply()
            //    var northEast = bounds.getNorthEast();
            //    var southWest = bounds.getSouthWest();
            //    var offlng=(southWest.lng-northEast.lng)/12
            //    var offlat=(southWest.lat-northEast.lat)/8
            //    marker.setPosition(new BMap.Point(northEast.lng+offlng,northEast.lat+offlat))
        }
    }


    map.addEventListener("movestart", function () {
        //marker.hide()
    })

    map.addEventListener("zoomstart", function () {
        //marker.hide()
    })

    map.addEventListener("zoomend", function () {
        resetMarker()
        marker.show()
    })


    map.addEventListener("moveend", function () {
        resetMarker()
        marker.show()
    })

    marker.addEventListener("dragend", function () {
        point = this.getPosition();    //获取标注的地理位置
        var lat = point.lat;
        var lng = point.lng;
        map.panTo(point);
    })

    marker.addEventListener("dragstart", function () {
        map.removeOverlay(marker.getLabel());
        marker.setLabel(null)
        scope.baiduMap.isDirty = true;
        marker.setAnimation(null)
        scope.$apply()
    })


    //ip定位
    var localCity = new BMap.LocalCity();
    localCity.get(function (r) {
        map.centerAndZoom(r.name, r.level)
        scope.baiduMap.mapBox.localCity = r.name
        resetMarker()
        scope.baiduMap.isOk = true;
    })


    ////搜索事件
    //$('#cc').click(function(){
    //    map.centerAndZoom($("#c").val(),15);
    //})

    //$('#de').click(function(){
    //    console.log( marker.getPosition());
    //})
}

angular.module("baiduMap", []).directive("baiduMap", function () {
    return {
        restrict: "E",
        replace: true,
        template: '<div  id="baiduMap"></div>',
        link: function (scope, element, attrs) {
            scope.baiduMap.mapBox = {};
            scope.baiduMap.isOk = false;
            scope.baiduMap.mapBox.detail = "";
            scope.baiduMap.mapId = attrs.id;



            //实现异步加载
            var script = document.createElement("script");
            script.type = "text/javascript";
            script.src = "http://api.map.baidu.com/api?v=2.0&ak=5sZ6zjTO7AM51rzQSWharEaKXiGrveGp&callback=initMap";
            document.body.appendChild(script);












            scope.baiduMap.canClick = true;





            ////三级联动事件
            //scope.$watch("baiduMap.mapBox", function (val) {
            //    if (scope.baiduMap.canClick) {
            //        if (val != null && val != {} && val.localStr != null && val.localStr != '') {
            //            scope.baiduMap.map.centerAndZoom(val.localStr, 15)
            //        }
            //        scope.baiduMap.canClick = false;
            //        setTimeout(function () {
            //            scope.baiduMap.canClick = true;
            //        }, 1500)
            //    }
            //}, true)

            scope.baiduMap.onload = {

                add: function (callback) {
                    this.func.push(callback)
                }
            }


            //启动完成事件
            scope.$watch("baiduMap.isOk", function (val) {
                if (val == true) {
                    console.log(attrs)

                    //是否启用设备定位
                    if (attrs.useGps == undefined || attrs.useGps == 'true') {
                        var geolocation = new BMap.Geolocation();
                        geolocation.getCurrentPosition(function (r) {
                            if (this.getStatus() == BMAP_STATUS_SUCCESS) {
                                //var mk = new BMap.Marker(r.point);
                                //map.addOverlay(mk);
                                scope.baiduMap.map.panTo(r.point);
                            }
                            else {
                                alert('failed' + this.getStatus());
                            }
                        }, {enableHighAccuracy: true})
                    }

                    //是否启用定位控件
                    if (attrs.useGpsCtr == undefined || attrs.useGpsCtr == 'true') {
                        // 添加定位控件
                        var geolocationControl = new BMap.GeolocationControl();
                        geolocationControl.addEventListener("locationSuccess", function (e) {
                            // 定位成功事件


                        });
                        //geolocationControl.addEventListener("locationError",function(e){
                        //    // 定位失败事件
                        //});
                        scope.baiduMap.map.addControl(geolocationControl);
                    }


                    //是否启用城市控件
                    if (attrs.useCityCtr == undefined || attrs.useCityCtr == 'true') {
                        scope.baiduMap.map.addControl(new BMap.CityListControl({
                            anchor: BMAP_ANCHOR_TOP_RIGHT,
                            offset: 0,
                            // 切换城市之间事件
                            // onChangeBefore: function(){
                            //    alert('before');
                            // },
                            // 切换城市之后事件
                            // onChangeAfter:function(){
                            //   alert('after');
                            // }
                        }));

                    }


                }


            }, true)


            scope.baiduMap.searchCould = function () {
                if (scope.baiduMap.couldStr != undefined && scope.baiduMap.couldStr != "") {

                    var localSearch = new BMap.LocalSearch(scope.baiduMap.map, {
                        renderOptions: {
                            map: scope.baiduMap.map
                        },
                        onSearchComplete: function (results) {
                            console.log(results)
                            scope.baiduMap.map.clearOverlays();
                            var oval = new BMap.Circle(scope.baiduMap.map.getCenter(), parseInt(scope.baiduMap.range), {fillColor: "blue", strokeWeight: 1, fillOpacity: 0.3, strokeOpacity: 0.3});
                            scope.baiduMap.map.addOverlay(oval);
                            //可添加自定义回调函数
                        }
                    });


                    localSearch.setInfoHtmlSetCallback(function (poi, html) {
                        console.log(poi)
                        var tem = scope.baiduMap.infoTemplate;
                        var model = {}
                        for (var k in poi) {
                            if (k != "point" && k != "marker") {
                                tem = tem.replace('#' + k + '#', poi[k]);
                                model[k] = poi[k];
                            }
                        }
                        //console.log(poi)
                        //tem = tem.replace("####",JSON.stringify($.extend({},model)))
                        var tt = $(html).html(tem)
                        tt.find("[click]").unbind().click(function () {
                            eval($(this).attr("click") + '(model)')
                        })
                    })
                    localSearch.searchNearby(scope.baiduMap.couldStr, scope.baiduMap.map.getCenter(), scope.baiduMap.range, {
                        customData: {
                            geotableId: 160206
                        }
                    });
                }
            }


        }
    }
}).directive("mapBody", function () {
        return {
            restrict: "E",
            replace: true,
            template: '<div  id="mapBody"></div>',
            //require:"^baiduMap",
            link: function (scope, element, attrs) {
                //scope.$apply()
            }
        }
    })
    //    .directive("mapCitys", function () {
    //    return {
    //        restrict: 'E',
    //        replace: true,
    //        scope: false,
    //        //require:"^baiduMap",
    //        template: '<div style="display: inline-block"><div id="mapCitys" class="citys" style="display: inline-block"> <p  > <select name="province"  map-search></select> <select name="city" map-search></select><select name="area" map-search></select></p></div></div>',
    //        link: function (scope, ele, attr) {
    //            // 事件处理
    //            scope.baiduMap.doCitys = function () {
    //                $('#mapCitys').citys({
    //                    required: false,
    //                    nodata: 'disabled',
    //                    onChange: function (data) {
    //                        var text = data['direct'] ? '(直辖市)' : '';
    //                        console.log(1)
    //                        scope.baiduMap.mapBox["localStr"] = data['province'] + data['city'] + data['area'];
    //                        scope.$apply()
    //                    }
    //                });
    //            }
    //            scope.baiduMap.doCitys()
    //        }
    //    }
    //})
    .directive("mapDetail", function () {
        return {
            restrict: "E",
            scope: false,
            replace: true,
            //require:"^baiduMap",
            template: '<textarea style="overflow: hidden;resize: none"></textarea>',
            link: function (scope, ele, attrs) {
                ele.bind("keyup", function () {
                    scope.baiduMap.addDetail = ele.val()
                    scope.$apply()
                })
            }
        }
    }).directive("mapSearchBtn", function () {
    return {
        restrict: "E",
        scope: false,
        replace: true,
        //require:"^baiduMap",
        template: '<input type="button" value="搜索">',
        link: function (scope, ele, attrs) {
            ele.bind("click", function () {
                scope.baiduMap.mapBox.detail = scope.baiduMap.addDetail;
                scope.$apply()
            })
        }
    }
}).directive("mapSearchInput", function () {
    return {
        restrict: "E",
        scope: false,
        replace: true,
        //require:"^baiduMap",
        template: '<input type="text" map-search id="_inputSerch">',
        link: function (scope, ele, attrs) {
            scope.$watch("baiduMap.isOk", function (val) {
                if (val == true) {
                    //只能输入
                    var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
                        {
                            "input": "_inputSerch"
                            , "location": scope.baiduMap.map
                        });
                    ac.addEventListener("onconfirm", function (e) {    //鼠标点击下拉列表后的事件
                        var _value = e.item.value;
                        var myValue = _value.province + _value.city + _value.district + _value.street + _value.business;
                        //map.clearOverlays();    //清除地图上所有覆盖物

                        var local = new BMap.LocalSearch(scope.baiduMap.map, { //智能搜索
                            onSearchComplete: function () {
                                var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
                                scope.baiduMap.map.centerAndZoom(pp, 18);
                                //map.addOverlay(new BMap.Marker(pp));    //添加标注
                            }
                        });
                        local.search(myValue);
                    });
                }
            })

            ele.bind("change", function () {
                console.log(ele[0].value)
                scope.baiduMap.addDetail = ele[0].value;
                scope.$apply()
            })
        }
    }
}).directive("mapResetSearch", function () {
    return {
        restrict: "E",
        scope: false,
        replace: true,
        //require:"^baiduMap",
        template: '<input type="button" >',
        link: function (scope, ele, attrs) {
            ele.bind("click", function () {
                $("[map-search]").val("")
                scope.baiduMap.doCitys()
            })
        }
    }
}).directive("mapGetPosition", function () {
    return {
        restrict: "E",
        scope: false,
        replace: true,
        //require:"^baiduMap",
        template: '<input type="button"  ng-click="getPoint()">',
        link: function (scope, ele, attrs) {
            scope.getPoint = function () {
                var gc = new BMap.Geocoder();//地址解析类
                gc.getLocation(scope.baiduMap.marker.getPosition(), function (rs) {
                    eval(attrs.fuc + "(rs)")
                });
            }
        }
    }
}).directive("mapInforTemp", function () {
    return {
        restrict: "A",
        link: function (scope, ele, attrs) {
            var tem = ele[0].innerHTML
            $(ele[0]).hide()
            scope.baiduMap.infoTemplate = tem;
        }
    }
}).directive("mapShowDataBtn", function () {
    return {
        restrict: "E",
        scope: false,
        replace: true,
        //require:"^baiduMap",
        template: "<input type='button'>",
        link: function (scope, ele, attrs) {
            ele.bind("click", function () {
                $.ajax({
                    url: attrs.url,
                    dataType: "json",
                    type: "post",
                    success: function (_r) {
                        scope.baiduMap.map.clearOverlays()
                        scope.baiduMap.map.setCenter(_r.center);
                        var r = _r.data;
                        for (var i in r) {
                            var tem = scope.baiduMap.infoTemplate;
                            for (var k in r[i]) {
                                tem = tem.replace('#' + k + '#', r[i][k]);
                            }
                            tem = tem.replace("'####'", "'" + JSON.stringify(r[i]) + "'")
                            var infoWindow = new BMap.InfoWindow(tem);
                            var marker = new BMap.Marker(new BMap.Point(r[i].lng, r[i].lat));
                            scope.baiduMap.map.addOverlay(marker)
                            //marker.setAnimation(BMAP_ANIMATION_DROP)跳动动画
                            marker.addEventListener("click", (function (infoWindow) {
                                return function () {
                                    this.openInfoWindow(infoWindow);
                                    //图片加载完毕重绘infowindow
                                    //document.getElementById('imgDemo').onload = function (){
                                    //    infoWindow.redraw();   //防止在网速较慢，图片未加载时，生成的信息框高度比图片的总高度小，导致图片部分被隐藏
                                    //}
                                }
                            })(infoWindow))
                        }
                    }, error: function (r) {
                        console.log(r)
                    }
                })
            })
        }
    }
}).directive("mapShowPositionMarkerBtn", function () {
    return {
        restrict: "E",
        scope: false,
        replace: true,
        //require:"^baiduMap",
        template: '<input type="button" >',
        link: function (scope, ele, attrs) {
            ele.bind("click", function () {
                scope.baiduMap.map.clearOverlays()
                scope.baiduMap.map.addOverlay(scope.baiduMap.marker)
                scope.baiduMap.resetMarker()
            })
        }
    }
}).directive("mapClearOverBtn", function () {
    return {
        restrict: "E",
        scope: false,
        replace: true,
        //require:"^baiduMap",
        template: '<input type="button" >',
        link: function (scope, ele, attrs) {
            ele.bind("click", function () {
                scope.baiduMap.map.clearOverlays()

                //var customLayer = new BMap.CustomLayer({
                //
                //    geotableId: 160206,//换成你自己的数据表geotableId
                //
                //    q: '', //检索关键字
                //
                //    tags: '', //空格分隔的多字符串
                //
                //    filter: '' //过滤条件
                //
                //});
                //scope.baiduMap.map.addTileLayer(customLayer);
                //
                //customLayer.addEventListener('hotspotclick', function (e) {
                //    var customPoi = e.customPoi,str = [];
                //    str.push("address = " + customPoi.address);
                //    str.push("phoneNumber = " + customPoi.phoneNumber);
                //    var content = '<p style="width:280px;margin:0;lineheight:20px;">地址：' + customPoi.address + '<br>电话： ' + customPoi.phoneNumber + '</p>';
                //    var searchInfoWindow = new BMapLib.SearchInfoWindow(scope.baiduMap.map, content, {
                //        title: customPoi.title,
                //        width: 290,
                //        height: 40,
                //        panel: "panel",
                //        enableAutoPan: true,
                //        enableSendToPhone: true,
                //        searchTypes: [
                //        ]
                //    });
                //    var point = new BMap.Point(customPoi.point.lng, customPoi.point.lat);
                //    searchInfoWindow.open(point);
                //})





            })
        }
    }
}).directive("mapDrawingManager", function () {
}).directive("mapNearbyBtn", function () {
    return {
        restrict: "E",
        scope: false,
        replace: true,
        //require:"^baiduMap",
        template: '<input type="button" >',
        link: function (scope, ele, attrs) {
            scope.baiduMap.range = attrs.range;
            ele.bind("click", function () {

                scope.baiduMap.searchCould();
                scope.$apply()
            })
        }
    }
}).directive("mapCouldSearchInput", function () {
    return {
        restrict: "E",
        scope: false,
        replace: true,
        //require:"^baiduMap",
        template: '<input type="text" map-search>',
        link: function (scope, ele, attrs) {
            ele.bind("change", function () {
                console.log(ele[0].value)
                scope.baiduMap.couldStr = this.value;
                scope.$apply()
            })
        }
    }
}).directive("mapCouldSearchBtn", function () {
    return {
        restrict: "E",
        scope: false,
        replace: true,
        //require:"^baiduMap",
        template: '<input type="button" value="搜索">',
        link: function (scope, ele, attrs) {
            ele.bind("click", function () {
                scope.$apply()
            })
        }
    }
})