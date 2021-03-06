<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<html xmlns:ng="http://angularjs.org" id="ng-app" ng-app="optionalModuleName" class="ng-app:myApp">
<head>
    <title>咨询主题</title>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <%@ include file="/WEB-INF/jsp/common/kindeditor.jsp" %>
    <%@ include file="/WEB-INF/jsp/common/easyui.jsp" %>
    <link rel="stylesheet" href="${webtxc}/css/public.css"/>
    <link rel="stylesheet" href="${webtxc}/css/personal.css"/>
    <link rel="stylesheet" href="${webtxc}/css/goodsinfo/goodsinfo.css"/>
    <script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
    <script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
    <script type="text/javascript" src="${webtxc}/myjs/goodsinfo/updateservice.js?v=2226342221231231312254442133255444"></script>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/top.jsp" %>
<!-- start.content -->
<div class="content">
    <%@ include file="/WEB-INF/jsp/common/left.jsp" %>
    <div class="content-right">
    	<input id="serviceId" name="serviceId" type="hidden" value="${info.serviceId}"/>
        <div class="expert_mes">
            <h2>咨询主题</h2>
            <ul class="note_message ">
                <ul>
                    <li class="mes">主题名称：</li>
                    <li><input class="mees" name="servicetitle" placeholder="请输入相关信息" value="${info.serviceTitle}"></li>

                    <li class="zp_ts">字数不低于<span>5</span>个字</li>
                </ul>
                <ul>
                    <li class="mes">主题关键字：</li>
                    <script>
	                    $(function(){
	                    	var keywords = ${info.serviceKeywords};
	                    	var kw = '';
	                    	for ( var i =0;i< keywords.length;i++) {
								kw += keywords[i] + ',';
							}
	                    	$('textarea[name=servicekeywords]').val(kw.substr(0,kw.length-1));
	                    })
                    	
                    </script>
                    <li>
                        <textarea name="servicekeywords" cols="48" rows="4">${info.serviceKeywords}</textarea>
                    </li>

                    <li class="zp_ts" >请填写此主题的关键字，以逗号（，）分隔，最多<span>5</span>个关键字，如：话题咨询，互联网产品</li>
                </ul>
                <ul>
                    <li class="mes">主题简介：</li>
                    <li>
                        <textarea name="servicecontent" cols="48" rows="9">${info.serviceBiref}</textarea>
                    </li>
                    <li class="zp_ts">字数不超过<span>200</span>个字。</li>
                    <li class="qt_more">
                        <a><b>看看别人家都怎么写文案</b></a>
                        <a>【荐】王小二 互联网产品经理..</a>
                        <a>【荐】王小二 互联网产品经理..</a>
                        <a>【荐】王小二 互联网产品经理..</a>
                        <a>【荐】王小二 互联网产品经理..</a>
                    </li>
                </ul>
                <ul>
                    <li class="mes">主题介绍：</li>
                    <li>
                        <textarea id="info_brief" name="servicebiref" cols="48" rows="9">${info.serviceContent}</textarea>
                    </li>
                </ul>

                <%--<ul style="height:60px;">--%>
                <%--<li class="mes">见面时长：</li>--%>
                <%--<li>--%>
                <%--<input class="mees" name="servicemeetnum" value="请输入见面时长,如:12">--%>
                <%--</li>--%>

                <%--<li class="zp_ts">如小时左右/次</li>--%>

                <%--</ul>--%>


                <ul >
                    <li class="mes">咨询费用：</li>
                    
                    <li>
                        <div class="pset" style="overflow: hidden;height: auto;">
                            <a class="addrowpset" id="addrowpset" href="javascript:void(0)" style="display: none">添加</a>
                            <div class="psetsg" style="display:none;" id="psetsg">
                                来源：<select name="psetdiscounttype">
                                            <option selected value="1">普通服务</option>
                                            <option selected value="2">积分服务</option>
                                        </select>
                                价格：<input type="text" class="" name="psetprice"/>
                                积分：<input type="text" name="psetpoint"/>
                                <a class="delrowpset" href="javascript:void(0)">删除</a>
                            </div>
                             <c:forEach var="ss" items="${info.priceSets}">
                            <div class="psetsg ppset">
                                来源：<select name="psetdiscounttype">
                                            <option selected value="1">普通服务</option>
                                            <%--<option selected value="2">积分服务</option>--%>
                                        </select>
                            <script type="text/javascript">
                                $(function(){
                                    var v = ${ss.psetDiscountType};
                                    $('select[name=psetdiscounttype]').val(v)
                                })
                            </script>
                                价格：<input type="text" name="psetprice" value="${ss.psetPrice}"/>
                               <!--  积分： --><input type="hidden" name="psetpoint" value="${ss.psetPoint}"/>
                                <a class="delrowpset" href="javascript:void(0)" style="display: none                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ">删除</a>
                            </div>
                            </c:forEach>
                        </div>
                    </li>
                </ul>
                <ul >
                    <li class="mes">封面上传：</li>
                     <%-- <li class="sc_img">
			         <img src="${webtxc}/images/zp.png" id="image1" style="text-align: center;display: inline-block;margin-top: 30px;" />
			            <br>
			          <input class="mees" id="info_icon1" name="servicepic" type="hidden" value="${info.servicePic}"/>
			          <span  >上传封面</span>
			        </li> --%>
                    <li class="tx_sc">
                        <input class="mees" id="info_icon1" name="servicepic" type="hidden" value="${info.servicePic}"/>
                        <img id="image1" alt="" src="${info.servicePic}" ></li>
                    <li>

                        <%--<input type="button" class="button" id="imgBtn" value="选择图片" style="width:72px"/>--%>
                        <%--</li>--%>

                    <li class="zp_ts">注：大小为1M以内</li>

                </ul>

                <ul>
                    <li class="mes">服务时间：</li>
                    <li>
                        <input class="mees" name="servicemeettime" value="${info.serviceMeettime}">
                    </li>
                    <li class="zp_ts">（小时）</li>
                </ul>

                <ul>
                    <li class="mes">类型：</li>
                    <li>
                    	<input type="hidden" id="serviceType" value="${info.serviceType}"/>
                        <select class="mess" name="serviceType"   id="tree" disabled="true">
                        </select>
                        <script>
                            (function () {
                            	
                                if (!Array.prototype.map) {
                                    Array.prototype.map = function (callback, thisArg) {
                                        var T, A, k;
                                        if (this == null) {
                                            throw new TypeError(" this is null or not defined");
                                        }
                                        var O = Object(this);
                                        var len = O.length >>> 0;
                                        if (typeof callback !== "function") {
                                            throw new TypeError(callback + " is not a function");
                                        }
                                        if (thisArg) {
                                            T = thisArg;
                                        }
                                        A = new Array(len);
                                        k = 0;
                                        while (k < len) {
                                            var kValue, mappedValue;
                                            if (k in O) {
                                                kValue = O[k];
                                                mappedValue = callback.call(T, kValue, k, O);
                                                A[k] = mappedValue;
                                            }
                                            k++;
                                        }
                                        return A;
                                    };
                                }
                            })()
                            $(function () {
                                $('#tree').combotree({
                                    url: path + "/pubinfo/getTree.html?type=1",
                                    height: "30",
                                    width:279,
                                    onClick: function (node) {
                                        $('#tree').val(node.id);  // alert node text property when clicked
                                    },
                                    loadFilter: function (data) {
                                        var big = {}
                                        var genList = function (data, obj) {
                                            var l = []
                                            data.map(function (it, index) {
                                                if ( (obj.ctId == null&&it.ctFid=="0")  || obj.ctId == it.ctFid) {
                                                    it.id=it.ctId;
                                                    it.text=it.ctName;
                                                    var c = genList(data, it);
                                                    l.push(c)
                                                }
                                            })
                                            obj.state='open'
                                            if (l.length != 0) {
                                                obj.children = l;
                                                return obj;
                                            } else {
                                                obj.state='close'
                                                return obj;
                                            }
                                        };
                                        var ff = genList(data, big).children;
                                        console.log(ff)
                                        var vId = ${info.serviceType};
                                        $(ff).each(function(i,e){
                                        	if(e.ctId == $.trim(vId)){
                                        		$('input[name=serviceType]').prev().val(e.ctName);
                                        	}else{
	                                        	$(e.children).each(function(i1,e1){
	                                        		if(e1.ctId == $.trim(vId)){
	                                        			$('input[name=serviceType]').prev().val(e1.ctName);
	                                            	}
	                                        	})
                                        	}
                                        })
                                        return ff;
                                    }
                                })
                                
                            })
                        </script>

                    </li>
                </ul>
                <script>
                	$(function(){
                		var attrs = ${info.serviceAttrinfo};
                		console.info(attrs)
                		var len = [];
                		var val = [];
                		for(var i=0;i<attrs.length;i++){
                			len[i] = attrs[i].value.length;
                			val[i] = attrs[i].value;
                		}
                		for(var i=0;i<attrs.length-1;i++){
                			var ss=$("#template").clone(true)
                			ss.show(0)
                			$('.param-main').append(ss).css({height:'+=60px'});
                			
                		}
                		console.info(len)
                		
						for (var i = 1; i < $('.param').size(); i++) {
							console.info($('.param').size())
							for(var j=0;j<len[i-1];j++){
								var newval = '<div class="pval">'+
								 '<input type="text" name="paramval" />'+
								 '<a class="delval" id="delval" href="javascript:void(0)" onclick="delval(this)">×</a>'+
								 '</div>';
								$($('.addval')[i]).before(newval);
								var pv = $($('.param')[i]).find('.pval').find('input[name=paramval]');
								$(pv[j]).val(val[i-1][j]);
							} 
							$($('input[name=param]')[i]).val(attrs[i-1].name)
							
						}
                	})
                	
                	
                </script>
                <ul style="height:150px;display: none;">
                    <li class="mes">属性：</li>
                    <li>
                        <div class="param-main">
                            <a class="addrow" id="addrow" href="javascript:void(0)">属性添加</a>
                            <div class="param" style="display:none" id="template">
                                <input type="text" name="param"/>
                                <a class="addval" id="addval" href="javascript:void(0)">添加值</a>
                                <a class="delrow" id="delrow" href="javascript:void(0)">删除</a>
                            </div>
                            <div class="param">
                                <input type="text" name="param" value="" />
                                <a class="addval" id="addval" href="javascript:void(0)">添加值</a>
                                <a class="delrow" id="delrow" href="javascript:void(0)">删除</a>
                            </div>
                        </div>
                    </li>
                </ul>

                <ul style="display: none">
                    <li class="mes">服务阶段：</li>
                    <li class="step">
                        <!-- <a class="addstep" id="addstep" href="javascript:void(0)">添加</a> -->

                        <c:forEach var="ss" items="${info.serviceSteps}" varStatus="index">
                            <div class="servicestep">
                                <span>阶段${index.index+1}</span><br>
                                名称：<input type="text" name="ssname" value="${ss.ssName}"/><br>
                                价格：
                                <div class="ss steppset">

                                    <c:forEach var="dd" items="${ss.p}">
                                        <div class="psetst">
                                            来源：<select name="psetdiscounttype">
                                                            <option  value="1" ${dd.psetDiscountType==1?'selected':''}>普通服务</option>
                                                <%--<option selected value="2">积分服务</option>--%>
                                                        </select>
                                            价格：<input type="text" name="psetprice" readonly value="${dd.psetPrice}"/>
                                            积分：<input type="text" name="psetpoint" readonly value="${dd.psetPoint}"/>
                                        </div>
                                    </c:forEach>



                                </div>
                                描述：<br><textarea name="ssdescribe">${ss.ssDescribe}</textarea>
                            </div>
                        </c:forEach>






                    </li>

                    <li class="zp_ts"></li>

                </ul>


                <div class="mes_btn">
                    <a class="mes_bc" id="servicesave">保存</a>

                </div>

        </div>

    </div><!--end.expert_mes-->


</div>
<!--end.content-right-->
</div>
<!--end.content-->
<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>
</body>

</html>