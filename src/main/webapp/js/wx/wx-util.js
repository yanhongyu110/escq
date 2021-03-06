/**
 * Created by blazh on 2016/11/10.
 */

//获得JsApiConfig的url
var __JsApiConfigUrl = path+'/js/JsApi.html'
//是否启用debug模式
var __isDebug = true;
//是否使用
var __isUse = false;

$(function () {
    $.ajax({
        url: __JsApiConfigUrl,
        data: {url: location.href},
        success: function (re) {
            alert(re)
            if (re != undefined && re != null && re != '') {
                re = JSON.parse(re);
                wx.config({
                    debug: __isDebug, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                    appId: re['appId'], // 必填，公众号的唯一标识
                    timestamp: re['timestamp'], // 必填，生成签名的时间戳
                    nonceStr: re['nonceStr'], // 必填，生成签名的随机串
                    signature: re['signature'],// 必填，签名，见附录1
                    jsApiList: ["chooseWXPay"] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
                });
            } else {
                __isDebug ? alert("JsApi对象有问题") : '';
            }
        }
    })
})


// config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
wx.error(function (res) {
    alert(res)
});


// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
if (__isUse)
wx.ready(function () {

    //判断当前客户端版本是否支持指定JS接口
    wx.checkJsApi({
        jsApiList: ['chooseImage'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
        success: function (res) {
            // 以键值对的形式返回，可用的api值true，不可用为false
            // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
            __isDebug ? alert(res) : ""
        }
    });


    //用户分享朋友圈
    wx.onMenuShareTimeline({

        title: '你好', // 分享标题
        link: 'http://blazh.tunnel.qydev.com/uu/html/index.html', // 分享链接
        imgUrl: 'http://blazh.tunnel.qydev.com/uu/image/11.jpg', // 分享图标

        //以上的链接必须是备案的域

        //监听Menu中的按钮点击时触发的方法，该方法仅支持Menu中的相关接口。
        trigger: function (re) {
            __isDebug ? alert(re) : ''
        },

        //接口调用成功时执行的回调函数。
        success: function (re) {
            __isDebug ? alert(re) : ''
        },

        //用户点击取消时的回调函数，仅部分有用户取消操作的api才会用到。
        cancel: function (re) {
            __isDebug ? alert(re) : ''
        },

        //接口调用失败时执行的回调函数。
        fail: function (re) {
            __isDebug ? alert(re) : ''
        },

        //接口调用完成时执行的回调函数，无论成功或失败都会执行。
        complete: function (re) {
            __isDebug ? alert(re) : ''
        }

    });


    //获取“分享给朋友”按钮点击状态及自定义分享内容接口
    wx.onMenuShareAppMessage({
        title: '', // 分享标题
        desc: '', // 分享描述
        link: '', // 分享链接
        imgUrl: '', // 分享图标
        type: '', // 分享类型,music、video或link，不填默认为link
        dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
        success: function () {
            // 用户确认分享后执行的回调函数
        },
        cancel: function () {
            // 用户取消分享后执行的回调函数
        }
    });

    //获取“分享到QQ”按钮点击状态及自定义分享内容接口
    wx.onMenuShareQQ({
        title: '', // 分享标题
        desc: '', // 分享描述
        link: '', // 分享链接
        imgUrl: '', // 分享图标
        success: function () {
            // 用户确认分享后执行的回调函数
        },
        cancel: function () {
            // 用户取消分享后执行的回调函数
        }
    });

    //获取“分享到腾讯微博”按钮点击状态及自定义分享内容接口
    wx.onMenuShareWeibo({
        title: '', // 分享标题
        desc: '', // 分享描述
        link: '', // 分享链接
        imgUrl: '', // 分享图标
        success: function () {
            // 用户确认分享后执行的回调函数
        },
        cancel: function () {
            // 用户取消分享后执行的回调函数
        }
    });

    //获取“分享到QQ空间”按钮点击状态及自定义分享内容接口
    wx.onMenuShareQZone({
        title: '', // 分享标题
        desc: '', // 分享描述
        link: '', // 分享链接
        imgUrl: '', // 分享图标
        success: function () {
            // 用户确认分享后执行的回调函数
        },
        cancel: function () {
            // 用户取消分享后执行的回调函数
        }
    });


    //拍照或从手机相册中选图接口
    wx.chooseImage({
        count: 1, // 默认9
        sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
        success: function (res) {
            var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
        }
    });


    //预览图片接口
    wx.previewImage({
        current: '', // 当前显示图片的http链接
        urls: [] // 需要预览的图片http链接列表
    });


    //上传图片接口
    wx.uploadImage({
        localId: '', // 需要上传的图片的本地ID，由chooseImage接口获得
        isShowProgressTips: 1, // 默认为1，显示进度提示
        success: function (res) {
            var serverId = res.serverId; // 返回图片的服务器端ID
        }
    });
    //备注：上传图片有效期3天，可用微信多媒体接口下载图片到自己的服务器，此处获得的 serverId 即 media_id。


    //下载图片接口
    wx.downloadImage({
        serverId: '', // 需要下载的图片的服务器端ID，由uploadImage接口获得
        isShowProgressTips: 1, // 默认为1，显示进度提示
        success: function (res) {
            var localId = res.localId; // 返回图片下载后的本地ID
        }
    });


    //开始录音接口
    wx.startRecord();


    //停止录音接口
    wx.stopRecord({
        success: function (res) {
            var localId = res.localId;
        }
    });


    //监听录音自动停止接口
    wx.onVoiceRecordEnd({
        // 录音时间超过一分钟没有停止的时候会执行 complete 回调
        complete: function (res) {
            var localId = res.localId;
        }
    });


    //播放语音接口
    wx.playVoice({
        localId: '' // 需要播放的音频的本地ID，由stopRecord接口获得
    });


    //暂停播放接口
    wx.pauseVoice({
        localId: '' // 需要暂停的音频的本地ID，由stopRecord接口获得
    });


    //停止播放接口
    wx.stopVoice({
        localId: '' // 需要停止的音频的本地ID，由stopRecord接口获得
    });


    //监听语音播放完毕接口
    wx.onVoicePlayEnd({
        success: function (res) {
            var localId = res.localId; // 返回音频的本地ID
        }
    });


    //上传语音接口
    wx.uploadVoice({
        localId: '', // 需要上传的音频的本地ID，由stopRecord接口获得
        isShowProgressTips: 1, // 默认为1，显示进度提示
        success: function (res) {
            var serverId = res.serverId; // 返回音频的服务器端ID
        }
    });
    //备注：上传语音有效期3天，可用微信多媒体接口下载语音到自己的服务器，此处获得的 serverId 即 media_id，参考文档 .目前多媒体文件下载接口的频率限制为10000次/天，如需要调高频率，请登录微信公众平台，在开发 - 接口权限的列表中，申请提高临时上限。


    //下载语音接口
    wx.downloadVoice({
        serverId: '', // 需要下载的音频的服务器端ID，由uploadVoice接口获得
        isShowProgressTips: 1, // 默认为1，显示进度提示
        success: function (res) {
            var localId = res.localId; // 返回音频的本地ID
        }
    });


    //智能接口识别音频并返回识别结果接口
    wx.translateVoice({
        localId: '', // 需要识别的音频的本地Id，由录音相关接口获得
        isShowProgressTips: 1, // 默认为1，显示进度提示
        success: function (res) {
            alert(res.translateResult); // 语音识别的结果
        }
    });

    //获取网络状态接口
    wx.getNetworkType({
        success: function (res) {
            var networkType = res.networkType; // 返回网络类型2g，3g，4g，wifi
        }
    });

    //使用微信内置地图查看位置接口
    wx.openLocation({
        latitude: 0, // 纬度，浮点数，范围为90 ~ -90
        longitude: 0, // 经度，浮点数，范围为180 ~ -180。
        name: '', // 位置名
        address: '', // 地址详情说明
        scale: 1, // 地图缩放级别,整形值,范围从1~28。默认为最大
        infoUrl: '' // 在查看位置界面底部显示的超链接,可点击跳转
    });

    //获取地理位置接口
    wx.getLocation({
        type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
        success: function (res) {
            var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
            var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
            var speed = res.speed; // 速度，以米/每秒计
            var accuracy = res.accuracy; // 位置精度
        }
    });


    //开启查找周边ibeacon设备接口
    wx.startSearchBeacons({
        ticket: "",  //摇周边的业务ticket, 系统自动添加在摇出来的页面链接后面
        complete: function (argv) {
            //开启查找完成后的回调函数
        }
    });
    //备注：如需接入摇一摇周边功能，请参考：申请开通摇一摇周边关闭查找周边ibeacon设备接口
    wx.stopSearchBeacons({
        complete: function (res) {
            //关闭查找完成后的回调函数
        }
    });
    //监听周边ibeacon设备接口
    wx.onSearchBeacons({
        complete: function (argv) {
            //回调函数，可以数组形式取得该商家注册的在周边的相关设备列表
        }
    });
    //备注：上述摇一摇周边接口使用注意事项及更多返回结果说明，请参考：摇一摇周边获取设备信息

    //关闭当前网页窗口接口
    wx.closeWindow();
    //批量隐藏功能按钮接口
    wx.hideMenuItems({
        menuList: [] // 要隐藏的菜单项，只能隐藏“传播类”和“保护类”按钮，所有menu项见附录3
    });
    //批量显示功能按钮接口
    wx.showMenuItems({
        menuList: [] // 要显示的菜单项，所有menu项见附录3
    });
    //隐藏所有非基础按钮接口
    wx.hideAllNonBaseMenuItem();
    //显示所有功能按钮接口
    wx.showAllNonBaseMenuItem();


    //调起微信扫一扫接口
    wx.scanQRCode({
        needResult: 0, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
        scanType: ["qrCode", "barCode"], // 可以指定扫二维码还是一维码，默认二者都有
        success: function (res) {
            var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
        }
    });


    //微信小店
    //跳转微信商品页接口
    wx.openProductSpecificView({
        productId: '', // 商品id
        viewType: '' // 0.默认值，普通商品详情页1.扫一扫商品详情页2.小店商品详情页
    });


    //拉取适用卡券列表并获取用户选择信息
    wx.chooseCard({
        shopId: '', // 门店Id
        cardType: '', // 卡券类型
        cardId: '', // 卡券Id
        timestamp: 0, // 卡券签名时间戳
        nonceStr: '', // 卡券签名随机串
        signType: '', // 签名方式，默认'SHA1'
        cardSign: '', // 卡券签名
        success: function (res) {
            var cardList = res.cardList; // 用户选中的卡券列表信息
        }
    });
//shopId	否	string(24)	1234		门店ID。shopID用于筛选出拉起带有指定location_list(shopID)的卡券列表，非必填。
// cardType	否	string(24)	GROUPON	卡券类型，用于拉起指定卡券类型的卡券列表。当cardType为空时，默认拉起所有卡券的列表，非必填。
// cardId	否	string(32)		p1Pj9jr90_SQRaVqYI239Ka1erk	卡券ID，用于拉起指定cardId的卡券列表，当cardId为空时，默认拉起所有卡券的列表，非必填。
// timestamp	是	string(32)	14300000000	时间戳。
// nonceStr	是	string(32)	sduhi123	随机字符串。
// signType	是	string(32)	SHA1	签名方式，目前仅支持SHA1
// cardSign	是	string(64)	abcsdijcous123	签名。


    //批量添加卡券接口
    wx.addCard({
        cardList: [{
            cardId: '',
            cardExt: ''
        }], // 需要添加的卡券列表
        success: function (res) {
            var cardList = res.cardList; // 添加的卡券列表信息
        }
    });
//cardExt详见附录4，值得注意的是，这里的card_ext参数必须与参与签名的参数一致，格式为字符串而不是Object，否则会报签名错误。
// 建议开发者一次添加的卡券不超过5张，否则会遇到超时报错。


    //查看微信卡包中的卡券接口
    wx.openCard({
        cardList: [{
            cardId: '',
            code: ''
        }]// 需要打开的卡券列表
    });


    //发起一个微信支付请求
    wx.chooseWXPay({
        timestamp: 0, // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
        nonceStr: '', // 支付签名随机串，不长于 32 位
        package: '', // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=***）
        signType: '', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
        paySign: '', // 支付签名
        success: function (res) {
            // 支付成功后的回调函数
        }
    });
    // 备注：prepay_id 通过微信支付统一下单接口拿到，paySign 采用统一的微信支付 Sign 签名生成方法，注意这里 appId 也要参与签名，appId 与 config 中传入的 appId 一致，即最后参与签名的参数有appId, timeStamp, nonceStr, package, signType。



});