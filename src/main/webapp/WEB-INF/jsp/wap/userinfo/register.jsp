<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <!-- 这meta的作用就是删除默认的苹果工具栏和菜单栏允许全屏模式浏览-->
    <meta name="apple-touch-fullscreen" content="yes">
    <!-- 开启对web app程序的支持  -->
    <meta content="telephone=no,email=no" name="format-detection">
    <!-- iPhone会自动把你这个文字加链接样式、并且点击这个数字还会自动拨号！telephone=no就忽略页面中的数字识别为电话号码 ,email=no 忽略识别邮箱 -->
    <!--base css-->
    <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes"/>
    <%-- <link rel="stylesheet" href="${webtxc}/css/wap/reset.css" /> --%>
    <link rel="stylesheet" href="${webtxc}/css/wap/login.css"/>
    <%-- <script src="${webtxc}/js/wap/reset.js"></script>
    <script src="${webtxc}/js/wap/TouchSlide.js"></script> --%>
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <script type="text/javascript" src="${webtxc}/myjs/wap/userinfo/register.js?v=2014"></script>
    <style type="text/css">
        a {
            text-decoration: none;
        }
        .resetPass{
            display: block;
            width: 55px;
            height: 55px;
            position: absolute;
            right: 0; bottom: 0; top:0;
            margin: auto 0 ;

            display:flex;  /*子元素居中*/
            justify-content:center;
            align-items:center;
        }
        .resetPass img{
            display: none;
        }
        .login{padding-bottom:0}
    </style>
    <script type="text/javascript" src="${webtxc }/js/wap/common.js?v=12312"></script>
    <script src="${webtxc}/vue/vue.min.js"></script>

</head>
<body>
<!--wapper-->
<div class="wapper">
    <!--page-->
    <div id="page">
    <!--  
        <div class="personer_top">
            <h3>注册</h3>
            <%--<span onclick="history.go(-1)" style="width:40px;height:50px;display:block;position:absolute;left:0;top:0;"></span>--%>
        </div>-->
        <!--end.personer_top-->
        <div class="login">
            <ul class="login_dl">
                <li>手机号码</li>
                <li class="log_input"><input type="text" id="logCell" placeholder="+86"></li>
            </ul>
            <ul class="login_dl">
                <li>验证码</li>
                <li class="yyz"><input type="text" id="checkcode" placeholder="输入你收到的验证码"></li>
                <li class="yzm"><input class="hq" type="button" id="button" value="获取验证码"></li>
            </ul>

            <ul class="login_dl">
                <li>密码</li>
                <li class="log_input" style="position: relative;width:75%"><input disabled type="password" id="logPass" placeholder="密码不少于6个字">
                    <span class="resetPass"><img src="${webtxc}/images/wap/wrong.png" width="20" alt=""></span>
                </li>
            </ul>
            
            <input type="hidden" id="hiddenOpenId" value="${openId }"/>
            <ul class="login_dl">
                <li>确认密码</li>
                <li class="log_input" style="position: relative;"><input disabled type="password" id="savelogPass" placeholder="密码（6-20数字，字母，非空格）">
                    <span class="resetPass"><img src="${webtxc}/images/wap/wrong.png" width="20" alt=""></span>
                </li>
            </ul>
            <ul class="login_dl">
                <li>验证码</li>
                <li class="yyz"><input type="text" id="imagesCode" placeholder="请输入正确的验证码"></li>
                <li class="yzm"><a id="refresh"><img src="${webtxc}/wap/userinfo/logInfo/getImagesCode.html" id="image"></a></li>
            </ul>


            <div class="agrees_zc">
                <label >
                    <input type="checkbox" v-model="isAgree" id="checkbox"  >我已阅读并同意</label>
                <a @click="showMes()" style="color: red">《近到家平台服务协议》</a>


                <transition name="fade">
                    <div v-show="isShow" style="top: 0px;left: 0px;position: fixed;width: 100%;height: 100%;background: white">
                        <div style="height: 90%;overflow: auto;overflow-x: hidden" v-on:scroll="scroll">
                            <div style="margin: 10px 20px" >
                                <h2>近到家用户协议</h2>
                                <h4>欢迎您使用近到家！</h4>
                                <p>为使用近到家服务，您应当遵守《近到家免责声明》、《近到家隐私保护协议》、《近到家版权声明》等相关协议、业务规则。请您务必审慎阅读、充分理解各条款内容，特别是限制或免除责任的相应条款，以及开通或使用某项服务的单独协议，并选择接受或不接受。</p>
                                <p>除非您已阅读并接受本协议所有条款，否则您无权使用本平台提供的任何服务，（以下简称“本服务”）。您对本服务的登陆、查看、发布信息等行为，包括申请成为注册用户的行为，即视为您已阅读并同意受本协议的约束。</p>
                                <h4>一、【协议的范围】</h4>
                                <p>本协议是您与近到家平台关于使用本服务所订立的协议。</p>
                                <h4>二、【用户个人信息保护】</h4>
                                <h4>2.1 保有您提供的信息</h4>
                                <p>近到家平台会在您自愿选择服务或提供信息的情况下收集您的个人信息，并将这些信息进行整合，以便向您提供更好的用户服务。请您在注册时及时、详尽及准确的提供个人资料，并不断更新注册资料，符合及时、详尽准确的要求。所有原始键入的资料将引用为注册资料。如果因注册信息不真实而引起的问题，由您自行承担相应的后果。请您不要将您的帐号、密码转让或出借予他人使用。如您发现您的帐号遭他人非法使用，应立即通知近到家平台。因黑客行为或用户的保管疏忽导致帐号、密码遭他人非法使用，近到家平台不承担责任。</p>
                                <p>本平台上的用户信息包括但不限于：（1）注册用户提供的信息；（2）政府部门已公开的信息，包括工商登记信息等相关信息（3）用户（包括其他注册用户）提供的评价信息；（4）本网站通过技术手段和统一标准对前述信息进一步整理、分析、评价后所获得的信息。您在此不可撤销的同意并授权本网站及其再授权人获得、展示并使用您的用户信息。</p>
                                <h4>2.2 cookies等技术的使用</h4>
                                <p>近到家平台网站使用cookies，以便您能登录我们的服务，并允许设定您特定的服务选项。运用cookies技术，近到家平台网站能够为您提供更加周到的个性化服务。您可以选择接受或拒绝cookies。您可以通过修改浏览器设置的方式拒绝cookies。如果您选择拒绝cookies，则您可能无法登录或使用依赖于cookies的近到家平台服务或功能。</p>
                                <h4>2.3 保有您的使用记录</h4>
                                <p>当您使用近到家平台的服务时，服务器会自动记录一些信息，包括URL、IP地址、浏览器的类型和使用的语言以及访问日期和时间等。</p>
                                <p>在如下情况下，近到家平台会遵照您的意愿或法律的规定披露您的个人信息，由此引发的问题将由您个人承担：（1）事先获得您的授权；（2）只有透露你的个人资料，才能提供你所要求的产品和服务；（3）根据有关的法律法规要求；（4）按照相关政府主管部门的要求；（5）为维护近到家平台的合法权益；（6）您同意让第三方共享资料；（7）我们发现您违反了近到家平台公司服务条款或任何其他产品服务的使用规定；（8）我们需要向代表我们提供产品或服务的公司提供资料（除非我们另行通知你，否则这些公司无权使用你的身份识别资料）。</p>
                                <h4>2.4 隐私权政策的修订：</h4>
                                <p>近到家平台可能会对隐私权政策进行修改。如果在使用用户个人信息政策方面有修改时，我们会在网页中显著的位置发布相关规定以便及时通知用户。</p>
                                <h4>2.5 问题与建议：</h4>
                                <p>如果您还有其他问题和建议，请告知我们。近到家平台始终致力于在充分保护您隐私的前提下，为您提供更优质的服务。</p>
                                <h4>三、【使用规范】</h4>
                                <p>本服务仅供您个人以非商业目的使用，除非经近到家平台书面许可，您不得进行以下行为：</p>
                                <p>3.1 为实现恶意（包括但不限于超出正常平台人员沟通、交流等非法、不正当目的）传播推广、骚扰等任何信息的目的，通过自己添加或诱导他人添加等任何方式使自己与其他用户形成好友关系（好友关系包括但不限于单向好友关系和双向好友关系，下同）；</p>
                                <p>3.2 以发送留言等任何方式或利用本服务的评论、个人动态、访客等任何功能，发布、传播包含广告、宣传、促销等内容的信息；</p>
                                <p>3.3 将本服务再次许可他人使用；</p>
                                <p>3.4 其他未经近到家平台书面许可的行为。</p>
                                <h4>四、【风险与免责】</h4>
                                <p>基于互联网的开放性和社交网络服务的传播特殊性，近到家特别提醒您谨慎注意：</p>
                                <p>4.1 访问者在从事与本平台相关的所有行为（包括但不限于访问浏览、利用、转载、宣传介绍）时，必须以善意且谨慎的态度行事；访问者不得故意或者过失的损害或者弱化本平台的各类合法权利与利益，不得利用本平台以任何方式直接或者间接的从事违反中国法律、国际公约以及社会公德的行为，且访问者应当恪守下述承诺：</p>
                                <p>（1）传输和利用信息符合中国法律、国际公约的规定、符合公序良俗；<br>（2）不将本平台以及与之相关的网络服务用作非法用途以及非正当用途；<br>（3）不干扰和扰乱本平台以及与之相关的网络服务；<br>（4）遵守与本平台以及与之相关的网络服务的协议、规定、程序和惯例等。</p>
                                <p>4.2 除我们另有明确说明或者中国法律有强制性规定外，本平台用户原创的作品，本平台及作者共同享有版权，其他网站及传统媒体如需使用，须取得本平台的书面授权，未经授权严禁转载或用于其它商业用途。</p>
                                <p>4.3 访问者在本平台发布任何作品（包括但不限于各类文章、案例、咨询以及评论等），须遵守本平台制定的规章制度以及发布说明，如违反发布，则相关责任发布者自负，与近到家平台无关。</p>
                                <p>4.4 本平台各类作品（包括但不限于各类文章、评论、用户答复、公众留言等）仅代表作者本人的观点，不代表本平台的观点和看法，与本平台立场无关，因其使用近到家平台网络服务而产生的一切后果由用户自己承担，近到家平台不承担任何相关责任。</p>
                                <p>4.5 本平台有权将在本平台内发表的作品用于其他用途，包括网站、电子杂志等，作品有附带版权声明者除外。</p>
                                <p>4.6 未经近到家平台和作者共同同意，其他任何机构不得以任何形式侵犯其作品著作权，包括但不限于：擅自复制、链接、非法使用或转载，或以任何方式建立作品镜像。</p>
                                <p>4.7 本平台所刊载的各类形式（包括但不仅限于文字、图片、图表）的作品仅供参考使用，并不代表本平台同意其说法或描述。对于访问者根据本平台提供的信息所做出的一切行为，除非另有明确的书面承诺文件，否则本平台不承担任何形式的责任。本网站所有刊登的信息内容，，以及所提供的信息资料，目的是更好地服务我们的访问者，本网站不保证所有信息、文本、图形、链接、及其它项目绝对准确性和完整性，故仅供访问者参考使用。</p>
                                <p>4.8 当本平台以链接形式推荐其他网站内容时，本平台并不对这些网站或资源的可用性负责，且不保证从这些网站获取的任何内容、产品、服务或其他材料的真实性、合法性，对于任何因使用或信赖从此类网站或资源上获取的内容、产品、服务或其他材料而造成（或声称造成）的任何直接或间接损失，本平台均不承担任何责任。</p>
                                <p>4.9 当政府部门、司法机关等依照法定程序要求本平台披露个人资料时，本平台将根据执法单位之要求或为公共安全之目的提供个人资料。在此情况下之任何披露，本平台均得免责。</p>
                                <p>4.10 由于用户将个人密码告知他人或与他人共享注册账户，由此导致的任何个人资料泄露，本平台不负任何责任。</p>
                                <p>4.11 任何由于计算机问题、黑客攻击、计算机病毒侵入或发作、因政府管制而造成的暂时性关闭等影响网络正常经营的不可抗力而造成的个人资料泄露、丢失、被盗用或被窜改等，本平台均得免责。</p>
                                <p>4.12 由于与本平台链接的其他网站所造成之个人资料泄露及由此而导致的任何法律争议和后果，本平台均得免责。</p>
                                <p>4.13 本平台若因线路及非本公司控制范围外的硬件故障或其它不可抗力而导致暂停服务，于暂停服务期间造成的一切不便与损失，本平台不负任何责任。</p>
                                <p>4.14 除本平台注明之服务条款外，其他一切因使用本平台而引致之任何意外、疏忽、诽谤、版权或知识产权侵犯及其所造成的损失（包括因下载而感染电脑病毒），本平台概不负责，亦不承担任何法律责任。</p>
                                <h4>五、【其他】</h4>
                                <p>5.1 若因本平台产生任何诉诸于诉讼程序的法律争议，将以本平台所有者所在地法院为管辖法院，除非中国法律对此有强制性规定。</p>
                                <p>5.2 本平台之声明以及其修改权、更新权、最终解释权及其技术相关知识产权均属重庆捷路科技有限公司所有。</p>
                                <p>5.3 兹有以上平台免责声明于2017年5月1日公布并生效，访问者须仔细阅读并同意本声明。</p>
                                <p>5.4 如您（单位或个人）认为本网站某部分内容有侵权嫌疑，敬请立即通知我们，我们将在第一时间予以更改或删除。</p>
                            </div>
                        </div>
                        <div style="height: 10%">
                            <div class="personer_excit" style="margin-top: 10px">
                                <a v-on:click="close()" v-bind:style="ss" style="color:white;display: inline-block;width: 100%;width: 100%" class="excit">确认完毕</a>
                            </div>
                        </div>
                    </div>
                </transition>
            </div>

            <%--<script src="${webtxc}/tis/sweetalert.min.js"></script>--%>
            <%--<link rel="stylesheet" href="${webtxc}/tis/sweetalert.css">--%>
            <%--<script src="${webtxc}/js/template-web.js"></script>--%>

            <style>
                .fade-enter-active, .fade-leave-active {
                    transition: opacity .5s
                }
                .fade-enter, .fade-leave-active {
                    opacity: 0
                }

                .test{
                    background-color: #8f8e90;
                }

            </style>

            <script>
                var app = new Vue({
                    el: '.agrees_zc',
                    data: {isAgree:false,isShow: false, ss: {'background-color':'#8f8e90'},canClick:false},
                    methods: {
                        showMes: function () {
                            this.isShow = true;
                        },
                        close: function () {
                            if(this.canClick){
                                this.isShow = false;
                                this.isAgree=true;
                                $('#register').css('background','#FB5A5A');
                                $('#register').click(function(){
                                    register();
                                })
                            }
                        },
                        scroll:function (event) {
                            var srcElement = $(event.target).children('div:eq(0)');
                             this.canClick=(Math.abs(srcElement.offset().top)+srcElement.parent().height())>= srcElement.height();
                             if (this.canClick) this.ss = {};
                             else this.ss = {'background-color':'#8f8e90'};
                        }
                    }
                })

            </script>


            <span id="message" style="position:absolute;height:50px;width:100%;display:none;background:#fff;opacity:0.8;left:0;top:0;text-align:center;line-height:50px;font-size:14px;"></span>
        </div>
        <!--end.login-->
        <div class="personer_excit">
            <a href="javascript:void(0)" style="display:block;" class="excit" id="register">注册</a>
        </div>
        <!--end.personer_excit-->

        <%--<div class="p_bttom">--%>
        <%--<p align="center">已有账号？ <a href="javascript:void(0)" onclick="login()">立即登录</a></p>--%>
        <%--<div class="dl_qt">--%>
        <%--<a class="qq_dl" style="margin-right:0;"></a>--%>
        <%--<a class="wx_dl"></a>--%>
        <%--</div>--%>
        <%--</div>--%>

    </div>
    <!--page end-->
</div>
<!--wapper end-->
<%--<%@ include file="/WEB-INF/jsp/wap/common/bottom.jsp"%>--%>
</body>
</html>