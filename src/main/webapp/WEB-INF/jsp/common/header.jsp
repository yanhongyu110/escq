<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta content="always" name="referrer"><%-- webkit|ie-comp|ie-stand --%>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script type="text/javascript" src="${webtxc}/jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${webtxc}/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="${webtxc}/jquery/jquery.md5.js"></script>
<script type="text/javascript" src="${webtxc}/js/validate.js"></script>
<script type="text/javascript" src="${webtxc}/js/common.js?v=123123123123123"></script>
<link rel="stylesheet" href="${webtxc}/css/tankuang.css"/>
<link rel="shortcut icon" type="image/x-icon" href="${webtxc}/favicon.ico"/>
<link rel="stylesheet" href="${webtxc}/css/public.css"/>

<c:if test="${sessionScope.wap!=null&&sessionScope.wap==true}">
    <script>

        $(function () {
            $.post(path+'/wap/map/position.html',{},function (r) {
                if ( r == '' ){
                    loadJScript();
                }else {
                }
            },'text');
        });

        //实现异步加载
        function loadJScript() {
            var script = document.createElement("script");
            script.type = "text/javascript";
            script.src = "http://api.map.baidu.com/api?v=2.0&ak=ZKdaE3UIUmMVnZLl9IxLU5gsFTQAGaMV&callback=init";
            document.body.appendChild(script);
        }
        function init() {
            var geolocation = new BMap.Geolocation();
            geolocation.getCurrentPosition(function (r) {   //定位结果对象会传递给r变量
                    if (this.getStatus() == BMAP_STATUS_SUCCESS) {  //通过Geolocation类的getStatus()可以判断是否成功定位。
                        var pt = r.point;
                    	//console.info(pt.lng)
                        var geocoder = new BMap.Geocoder();
                        geocoder.getLocation(pt, function(rs){
                            var addrStr='';
                            var pointStr = '';
                            pointStr = rs.point.lng+","+rs.point.lat;
                            console.info(pointStr)
                            addrStr += rs.addressComponents.province + '-';
                            if ( rs.addressComponents.city != rs.addressComponents.province ){
                                addrStr += rs.addressComponents.city + '-';
                            }
                            addrStr += rs.addressComponents.district;

                            console.log(addrStr);
                            $.post(path+'/wap/map/position.html', {position:addrStr,point:pointStr}, function (r) {}, 'text');
                        });
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
                }, {enableHighAccuracy: true}
            );
        }

    </script>

</c:if>


<script>
    var isApp =${sessionScope.wap==null?false:sessionScope.wap};
    var g_comid = '${sessionScope.company.compId}';
    function alert(content, title, callback, callback1) {
        var elementById = document.getElementById(isApp ? "alert__app" : 'alert__').innerHTML;
        var aler = $(elementById);
        aler.find('[data=title]').text(title == null ? "提示" : title)
        aler.find('[data=content]').text(content)
        aler.find('[data=close]').click(function () {
            if (callback != null)
                callback(aler)
            aler.remove()
        })
        aler.find('.t_title_right').click(function () {
            aler.remove();
        })
        if (callback1 != null) {
            aler.find('[data=cancel]').click(function () {
                callback1(aler)
                aler.remove()
            });
        } else {
            aler.find('[data=cancel]').parent().remove();
        }
        $('body').append(aler);
    }
</script>

<script>
    var isApp =${sessionScope.wap==null?false:sessionScope.wap};
    var g_comid = '${sessionScope.company.compId}';
    function alert(content, title, callback, callback1) {
        var elementById = document.getElementById(isApp ? "alert__app" : 'alert__').innerHTML;
        var aler = $(elementById);
        aler.find('[data=title]').text(title == null ? "提示" : title)
        aler.find('[data=content]').text(content)
        aler.find('[data=close]').click(function () {
            if (callback != null)
                callback(aler)
            aler.remove()
        })
        aler.find('.t_title_right2').click(function () {
            aler.remove();
        })
        if (callback1 != null) {
            aler.find('[data=cancel]').click(function () {
                callback1(aler)
                aler.remove()
            });
        } else {
            aler.find('[data=cancel]').parent().remove();
        }
        $('body').append(aler);
    }
</script>

<script type="text/html" id="alert__" charset="utf-8">
    <div class="t_kuang">
    </div>
    <div class="p_tan" style="z-index:1200000;">
        <div class="t_title">
            <div class="t_title_left" data="title">qued</div>
            <div class="t_title_right"></div>
        </div>
        <div class="ts_icon"></div>
        <div class="t_content" data="content">
        </div>
        <div class="t_sure" style="display: inline-block;">
            <div class="btns" data="close">确认</div>
        </div>
        <div class="t_sure" style="display: inline-block;">
            <div class="btns" data="cancel">取消</div>
        </div>
        <div></div>
    </div>
</script>


<script type="text/html" id="alert__app" charset="utf-8">
    <div class="t_kuang2" style="z-index: 10001">
    </div>
    <div class="p_tan2" style="z-index:1200000;    bottom: 0%;
    margin: auto;
    left: 0%;
    top: 0%;
    right: 0%;
    width: 80%;
    height: 45%;    border-radius: 6px;">
        <div class="t_title2">
            <div class="t_title_left2" data="title">qued</div>
            <div class="t_title_right2"></div>
        </div>
        <div class="ts_icon2"></div>
        <div class="t_content2" data="content">
        </div>
        <div class="t_sure2" style="display: inline-block;">
            <div class="btns2" data="close">确 认</div>
        </div>
        <div class="t_sure" style="display: inline-block;">
            <div class="btns" data="cancel">取 消</div>
        </div>
        <div></div>
    </div>
</script>