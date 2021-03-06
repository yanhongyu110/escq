<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>完善资料</title>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta content="telephone=no,email=no" name="format-detection">
    <!--base css-->
    <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes"/>
    <link rel="stylesheet" href="${webtxc }/css/wap/reset.css"/>
    <link rel="stylesheet" href="${webtxc }/css/wap/personer.css"/>
    <script src="${webtxc }/js/wap/reset.js"></script>
    <script src="${webtxc }/js/wap/TouchSlide.js"></script>
    <script type="text/javascript" src="${webtxc }/js/jquery-1.11.3.min.js"></script>
    <%@ include file="/WEB-INF/jsp/common/kindeditor.jsp" %>

    <script type="text/javascript" src="${webtxc}/jquery/jquery.cookie.js"></script>
    <script type="text/javascript" src="${webtxc}/jquery/jquery.md5.js"></script>
    <script type="text/javascript" src="${webtxc }/js/wap/common.js"></script>

    <script type="text/javascript" src="${webtxc }/myjs/wap/checkinfo/personcheck.js?v=1"></script>

    <style type="text/css">
        .personer_sc {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .personer_sc img {
            /*	width: 100%;*/
            height: 100%;
        }

        .shen_tg_img {
            background: url(${webtxc}/images/shenh.png) no-repeat center;
            display: block;
            height: 172px
        }

        .shen_zzsh_img {
            background: url(${webtxc}/images/shenhs.png) no-repeat center;
            display: block;
            height: 172px
        }

    </style>
    <script type="text/javascript">
        window.onload = function () {
            var cc = '${content}';
            if (cc.indexOf('正在审核') >= 0) {
                $("#tsimg").addClass('shen_zzsh_img');
                $(".personer_mes,.personer_excit").hide();
            }
            if (cc.indexOf('已通过') >= 0 | cc.indexOf('成功') >= 0) {
                $("#tsimg").addClass('shen_tg_img');
                $(".personer_mes,.personer_excit").hide();
            }
            if (cc.indexOf('实名认证') >= 0) {
                $("#tsimg").remove();
                $(".personer_mes,.personer_excit").show();
            }
        }
    </script>


    <style>
        .upli {
            text-align: center;
            border: 1px solid #a4a4a4;
            border-radius: 3px;
            margin: 10px 0px;
            line-height: 110px;
            position: relative;
            background-position: center;
            background-size: contain;
            background-repeat: no-repeat;
        }

        .upli:before {
            content: "";
            float: left;
            display: inline-block;
            padding-bottom: 70%;
        }

        .upli span {
            line-height: 10px;
            position: absolute;
            left: 0px;
            right: 0px;
            top: 71%;
        }
    </style>
    <script>
        $(function () {
            $('.list_mes textarea').each(function () {
                $(this).css({"line-height": "19px", "padding": "5%", "width": '90%'});
            });
//			    $('.list_mes > li:nth-child(2)').css({"line-height": "2"})
            $('.upli').each(function () {
                var li = $(this);
                li.css({
                    "width": "64%",
                    "line-height": "110px",
                    "background-image": "inherit",
                    backgroundColor: "white",
                    height:'auto',
                    display:'block',
                    "background-repeat":"no-repeat",
                    "background-size":"contain",
                    "background-position":"center"
                });
                li.find('img').css({"vertical-align": "middle","text-align":"center","display":"inline-block","width": "50px","height": "50px","border-radius":"0"})
            });

            $(".personer_zp").css({
                height:'auto',
                overflow:'hidden'
            })
        });
    </script>


</head>

<body>
<!--wapper-->
<div class="wapper">
    <!--page-->
    <div id="page">
        <div class="personer_top">
            <h3>实名认证</h3>
            <span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>
        </div>
        <div id="tsimg"></div>
        
        <div class="personer_mes">
            <!--end.personer_mes_phto-->
            <p class="ts_messages" id="msg_con">${content}</p>
            <div class="personer_mes_zl" id="errorMsg"></div>
            <div class="personer_mes_zl">
                <ul class="personer_mes_zl_ms">
                    <li>真实姓名</li>
                    <li class="mes_input">
                        <input type="text" id="name" placeholder="请输入真实姓名" value="${personCheckname1.pcnRelname }"/>
                    </li>
                </ul>
                <ul class="personer_mes_zl_ms">
                    <li>身份证号：</li>
                    <li class="mes_input">
                        <input type="text" id="idcard" placeholder="请输入身份证号码" value="${personCheckname1.pcnIdnumber }"/>
                    </li>
                </ul>

                <%-- <ul class="personer_zp">
                    <input id="sfzimg" type="hidden" value='${personCheckname1.pcnFrontid }'/>
                    <li>身份证:(正)</li>
                    <li class="personer_sc upli" id="image1">
                        <img src="${webtxc }/images/zp.png"/>
                        <br>
                        <span>上传封面</span>
                        <input type="hidden">
                    </li>
                </ul>
                <ul class="personer_zp">
                    <li>身份证:(反)</li>
                    <li class="personer_sc upli" id="image2">
                        <img src="${webtxc }/images/zp.png"/>
                        <br>
                        <span>上传封面</span>
                        <input type="hidden">
                    </li>
                </ul>

                <ul class="personer_zp">
                    <li>手持身份证:</li>
                    <li class="personer_sc upli" id="image3">
                        <img src="${webtxc }/images/zp.png"/>
                        <br>
                        <span>上传封面</span>
                        <input type="hidden">
                    </li>
                </ul> --%>

            </div>
        </div>
        <!--end.personer_mes-->
        <div class="personer_excit">
            <div class="excit" style="cursor:pointer" onclick="submit(${content==null})">保存</div>
        </div>
        <!--end.personer_excit-->
    </div>
    <!--page end-->
</div>
<!--wapper end-->
<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp" %>
</body>

</html>