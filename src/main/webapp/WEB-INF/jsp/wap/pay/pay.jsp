<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<html>
<head>
    <title>支付页面</title>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <script type="text/javascript" src="${webtxc}/jquery/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
    <%--<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"></script>--%>
    <%--<script src="${webtxc}/js/wx/wx-util.js?v=123123198723"></script>--%>
    <script>
        $(function(){
            $.ajax({
                url: path + "/pay/GzPay.html",
                type: "post",
                data: {orderId: '${orderId}'},
                success: function (re) {
                    if (re == '失败') {
                        alert("失败")
                    } else {
                        var obj = JSON.parse(re);
                        function onBridgeReady() {
                            WeixinJSBridge.invoke(
                                    'getBrandWCPayRequest', {
                                        "appId": obj.appId,     //公众号名称，由商户传入
                                        "timeStamp": obj.timeStamp,         //时间戳，自1970年以来的秒数
                                        "nonceStr": obj.nonceStr, //随机串
                                        "package": obj.package,
                                        "signType": obj.signType,         //微信签名方式：
                                        "paySign": obj.paySign //微信签名
                                    },
                                    function (res) {
                                        window.history.go(-1)
                                        if (res.err_msg == "get_brand_wcpay_request：ok") {
                                        }     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
                                    }
                            );
                        }

                        if (typeof WeixinJSBridge == "undefined") {
                            if (document.addEventListener) {
                                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
                            } else if (document.attachEvent) {
                                document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
                            }
                        } else {
                            onBridgeReady();
                        }


                    }
                }
            })
        })
    </script>
</head>
<body>

</body>
</html>
