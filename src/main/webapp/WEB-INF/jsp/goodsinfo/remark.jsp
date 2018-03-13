<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html xmlns:ng="http://angularjs.org" id="ng-app" ng-app="optionalModuleName" class="ng-app:myApp">
<head>
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <link rel="stylesheet" href="${webtxc}/css/public.css"/>
    <link rel="stylesheet" href="${webtxc}/css/personal.css"/>
    <script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
    <script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
    <title>服务评价</title>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <script>
        $(function () {

            $('.pj_textarea textarea').click(function () {
                if ($(this).val() == '在此输入评价的内容...') {
                    $(this).val('')
                }
            }).keyup(function () {
                if ($(this).val().length < 1) {
                    $('.pj_ts').show();
                } else {
                    $('.pj_ts').hide();
                }
            })

            $('input[value=提交]').on('click', function () {
            	$('input[value=提交]').unbind('click');
                var star = $('.grade').eq(0).next().find('span').text();
                var content = $('.pj_textarea textarea').val()
                var level = $('.fastComment01').attr("aa");

               /*  if (content.length < 1) {
                    alert("长度过小")
                    return;
                } */

                var data = {}
                data.content = content;
                data.id = $('.__id').text();
                data.orderId = '${obj.orderInfo.orderId}';
                //data.star = parseInt(star);
                data.level = level;

                $.ajax({
                    url: path + '/goodsinfo/remark/add.html',
                    type: 'post',
                    data: data,
                    success: function (re) {
                        re=JSON.parse(re);
                        if (re.success) {
                            window.history.go(0)
                        } else {
                            alert(re.errorMsg)
                        }
                    }
                })


            })

            //星星变换
            $(".grade img").each(function () {
                $(this).bind("mouseover", function () {
                    var index = $(this).index()
                    $(this).attr("src", "${webtxc}/images/pj01.png").prevAll().attr("src", "${webtxc}/images/pj01.png")
                    $(this).nextAll().attr("src", "${webtxc}/images/pj_hui.png")
                    $(this).parents('.grade').eq(0).next().find('span').text(index + 1 + '.0')
                })
            })

            //等级变换
            $('.fastComment div').click(function () {
                $(this).removeClass().addClass("fastComment01");
                $(this).siblings().removeClass().addClass("fastComment02")
            })

        })
    </script>
</head>
<body>
<c:set var="istop" value="true" />
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!--end.personal-->
<div class="content">
    <div style="display: none" class="__id">${obj.osId}</div>
    <%@ include file="/WEB-INF/jsp/common/left.jsp"%>
    <div class="content-right">
        <div class="expert_mes">
            <h2>服务评价</h2>
            <div class="status_icon">
                <p class="progress_bar"></p>
                <div class="status_progress status_one ">
                    <div class="steps">1
                        <div class="stripeL"></div>
                        <div class="stripeR"></div>
                    </div>
                    <div class="status_text">申请预约</div>
                </div>
                <div class="status_progress status_two ">
                    <div class="steps">2
                        <div class="stripeL"></div>
                        <div class="stripeR"></div>
                    </div>
                    <div class="status_text">专家确认</div>
                </div>
                <div class="status_progress status_three">
                    <div class="steps">3
                        <div class="stripeL"></div>
                        <div class="stripeR"></div>
                    </div>
                    <div class="status_text">托管资金</div>
                </div>
                <div class="status_progress status_four">
                    <div class="steps">4
                        <div class="stripeL"></div>
                        <div class="stripeR"></div>
                    </div>
                    <div class="status_text">服务完成</div>
                </div>
                <div class="status_progress status_five on">
                    <div class="steps">5
                        <div class="stripeL"></div>
                        <div class="stripeR"></div>
                    </div>
                    <div class="status_text">服务评价</div>
                </div>
            </div>
            <!--end.status_icon-->
            <div class="my_zh hpadding">
                <div class="my_zh_title">
                    <div class="my_zh_title_left">
                        <a>订单号：${obj.orderInfo.orderNo}</a>
                        <a>
                            <span>${obj[orderInfo.orderStateStr]}</span>
                           <%--  <span style="display: ${obj.serviceRemark!=null?'inline':'none'}">已评价</span> --%>
                        </a>
                        <br>
                        <br>
                        <br>
                        <h4 style="display: ${obj.serviceRemark==null?'none':'inline'}">您已申请预约，请及时操作。申请预约并经专家确认后才可以付款，以保障服务的质量。</h4>
                    </div>
                </div>
            </div>
            <!--end.my_zh-->

            <div class="fw_pj">
                <table cellpadding="0" cellspacing="0" border="0">
                    <tr>
                        <td ><f:formatDate value="${obj.orderInfo.orderCreatetime}" pattern="yyyy-MM-dd"></f:formatDate></td>
                        <td></td>
                        <td>状态</td>
                        <td>价格</td>
                        <td>详情</td>
                    </tr>
                    <tr>
                        <td class="fw_pj_img" s><img  src="${obj.serviceInfo.servicePic}"></td>
                        <td class="fw_pj_title">${obj.serviceInfo.serviceTitle}<br>${obj.orderInfo.orderArea}<br>${obj.serviceInfo.serviceMeettime}</td>


                        <td>
                            <c:if test="${obj.orderInfo.orderState==0}">
                                待确认
                            </c:if>
                            <c:if test="${obj.orderInfo.orderState==1}">
                                服务商否定
                            </c:if>
                            <c:if test="${obj.orderInfo.orderState==2}">
                                待支付
                            </c:if>
                            <c:if test="${obj.orderInfo.orderState==3}">
                                已取消
                            </c:if>
                            <c:if test="${obj.orderInfo.orderState==4}">
                                待服务
                            </c:if>
                            <c:if test="${obj.orderInfo.orderState==5}">
                                待评价
                            </c:if>
                            <c:if test="${obj.orderInfo.orderState==6}">
                                已完成
                            </c:if>
                        </td>


                        <td><span>￥${obj.osPrice}</span></td>


                        <td  class="ckcc" onclick="window.location.href=path+'/saleinfo/orderInfoSeller/orderViewDetail.html?orderId=${obj.orderInfo.orderId}'+'&comId='+g_comid">查看详细</td>

                    </tr>
                </table>
            </div>



            <div  class="_b_tt_tt">

                <div class="conta" style="display: ${obj.serviceRemark.srContent==null?'none':'block'}">
                    <div class="le">
                        买家评价
                        
                        
                        <p class="po">分数${obj.serviceRemark.srRemark}</p>
                    </div>
                    <div class="ri">
                        <p>${obj.serviceRemark.srContent}</p>
                    </div>
                    <div class="lev">
                    
                   <span><f:formatDate value="${obj.serviceRemark.srCreatetime}" pattern="yyyy-MM-dd HH:mm" /></span>
                    等级：
                            <span><c:if test="${obj.serviceRemark.srLevel==0}">
                                非常棒
                            </c:if>
                            <c:if test="${obj.serviceRemark.srLevel==1}">
                                一般般
                            </c:if>
                            <c:if test="${obj.serviceRemark.srLevel==2}">
                                给差评
                            </c:if></span>
                    
                    </div>
                </div>


                <hr style="display: ${obj.serviceRemark.srContent==null?'none':'block'}">
                <div class="conta" style="display: ${obj.serviceRemark.srResponsecontent==null?'none':'block'}">
                    <div class="le">
                        卖家回复
                        
                    </div>
                    <div class="ri">
                        <p>${obj.serviceRemark.srResponsecontent}</p>
                    </div>
                    
                    <div class="tt"><f:formatDate value="${obj.serviceRemark.srResponsetime}" pattern="yyyy-MM-dd HH:mm" /></div>
                </div>



                <hr style="display: ${obj.serviceRemark.srResponsecontent==null?'none':'block'}">
                <div class="conta" style="display: ${obj.serviceRemark.srAppendcontent==null?'none':'block'}">
                    <div class="le">
                        买家评价
                        
                        
                        <p class="po">分数:${obj.serviceRemark.srRemark}</p>
                    </div>
                    <div class="ri">
                        <p>${obj.serviceRemark.srAppendcontent}</p>
                    </div>
                    <div class="lev">
                    <span>
                            <f:formatDate value="${obj.serviceRemark.srAppendtime}" pattern="yyyy-MM-dd HH:mm" />
                            </span>
                    <span>等级:
                            <c:if test="${obj.serviceRemark.srLevel==0}">
                                非常棒
                            </c:if>
                            <c:if test="${obj.serviceRemark.srLevel==1}">
                                一般般
                            </c:if>
                            <c:if test="${obj.serviceRemark.srLevel==2}">
                                给差评
                            </c:if>
                            </span>
                            
                        </div>
                </div>



                <hr style="display: ${obj.serviceRemark.srAppendcontent==null?'none':'block'}">
                <div class="conta" style="display: ${obj.serviceRemark.srResponseappendcontent==null?'none':'block'}">
                    <div class="le">
                        卖家回复
                        
                    </div>
                    <div class="ri">
                        <p>${obj.serviceRemark.srResponseappendcontent}</p>
                    </div>
                    <div class="tt"><f:formatDate value="${obj.serviceRemark.srResponseappendtime}" pattern="yyyy-MM-dd HH:mm" /></div>
                </div>
                <hr style="display: ${obj.serviceRemark.srResponseappendcontent==null?'none':'block'}">
            </div>




            <div class="fw_pj_list">
                <div class="fw_pj_list_title">
                    <c:if test="${log==obj.orderInfo.orderBuyer}">
                        <c:if test="${obj.serviceRemark==null||obj.serviceRemark.srContent==null||obj.serviceRemark.srAppendcontent==null}">
                            <ul>
                                <li>服务满意度</li>
                                <%-- <li class="grade"><img src="${webtxc}/images/pj01.png"><img src="${webtxc}/images/pj01.png"><img src="${webtxc}/images/pj01.png"><img src="${webtxc}/images/pj01.png">
                                    <img src="${webtxc}/images/pj01.png"></li>
                                <li><span>5.0</span></li> --%>
                            </ul>
                            <div class="fastComment" style="overflow: hidden">
                                <div title="非常棒" class="fastComment01" aa="0">非常棒</div>
                                <div title="一般般" class="fastComment02" aa="1">一般般</div>
                                <div title="给差评" class="fastComment03" aa="2">给差评</div>
                            </div>
                        </c:if>
                    </c:if>




                    <%--买家--%>
                    <c:if test="${log==obj.orderInfo.orderBuyer}">
                        <c:if test="${obj.serviceRemark.srContent==null||obj.serviceRemark.srAppendcontent==null}">
                            <div class="pj_text">
                                <h4>评价回复</h4>
                                <div class="pj_textarea">
                                    <textarea placeholder="在此输入评价的内容..."></textarea>
                                </div>
                                <div class="pj_ts">为增加后续服务的满意度，请如实评价。</div>
                                <div class="pj_button" >
                                    <input value="提交" type="button"/>
                                </div>
                            </div>
                        </c:if>
                    </c:if>

                    <%--卖家--%>
                    <c:if test="${log==obj.orderInfo.orderSeller}">
                        <c:if test="${
                        (obj.serviceRemark.srContent!=null&&obj.serviceRemark.srResponsecontent==null)
                        ||(obj.serviceRemark.srAppendcontent!=null&&obj.serviceRemark.srResponseappendcontent==null)
                        }">
                            <div class="pj_text">
                                <h4>评价回复</h4>
                                <div class="pj_textarea">
                                    <textarea placeholder="在此输入评价的内容..."></textarea>
                                </div>
                                <div class="pj_ts">为增加后续服务的满意度，请如实评价。</div>
                                <div class="pj_button">
                                    <input value="提交" type="button" style="margin-left: 300px;"/>
                                </div>
                            </div>
                        </c:if>
                    </c:if>

                </div>
                <!--end.fw_pj_list-->

            </div>
            <!--end.expert_mes-->

        </div>
        <!--end.content-right-->
    </div>
    </div>
    <!--end.content-->
    <jsp:include page="/WEB-INF/jsp/common/bottom.jsp"/>
</body>
</html>
