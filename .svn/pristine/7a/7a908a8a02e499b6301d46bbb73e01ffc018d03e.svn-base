<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<html xmlns:ng="http://angularjs.org" id="ng-app" ng-app="optionalModuleName" class="ng-app:myApp">
<head>
    <title>需求编辑</title>
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
    <script type="text/javascript" src="${webtxc}/myjs/demand/updatedemand.js?v=4"></script>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/top.jsp" %>
<!-- start.content -->
<div class="content">
    <%@ include file="/WEB-INF/jsp/common/left.jsp" %>
    <div class="content-right">
    	<input id="serviceId" name="demId" type="hidden" value="${demand.demId}"/>
        <div class="expert_mes">
            <h2>需求编辑</h2>
            <ul class="note_message ">
                <ul>
                    <li class="mes">需求名称：</li>
                    <li><input class="mees" name="demTitle" placeholder="请输入相关信息" value="${demand.demTitle}"></li>

                    <li class="zp_ts"><span>*选填&nbsp;</span>字数不低于<span>5</span>个字</li>
                </ul>
                <ul>
                    <li class="mes">联系人：</li>
                    <li><input class="mees" name="demContact" placeholder="请输入相关信息" value="${demand.demContact}"></li>
                </ul>
                <ul>
                    <li class="mes">电话：</li>
                    <li><input class="mees" name="demCell" placeholder="请输入相关信息" value="${demand.demCell}"></li>
                </ul>
                <ul>
                    <li class="mes">需求关键字：</li>
                    <script>
	                    $(function(){
	                    	var keywords = ${demand.demKeyword};
	                    	var kw = '';
	                    	for ( var i =0;i< keywords.length;i++) {
								kw += keywords[i] + ',';
							}
	                    	$('textarea[name=demKeyword]').val(kw.substr(0,kw.length-1));
	                    })
                    	
                    </script>
                    <li>
                        <textarea name="demKeyword" cols="48" rows="4"></textarea>
                    </li>

                    <li class="zp_ts" ><span>*选填&nbsp;</span>请填写此需求的关键字，以逗号（，）分隔，最多<span>5</span>个关键字，如：话题咨询，互联网产品</li>
                </ul>
                <ul>
                    <li class="mes">需求简介：</li>
                    <li>
                        <textarea name="demBrief" cols="48" rows="9">${demand.demBrief}</textarea>
                    </li>
                    <li class="zp_ts"><span>*选填&nbsp;</span>字数不超过<span>200</span>个字。</li>
                    <li class="qt_more">
                        <a><b>看看别人家都怎么写文案</b></a>
                        <a>【荐】王小二 互联网产品经理..</a>
                        <a>【荐】王小二 互联网产品经理..</a>
                        <a>【荐】王小二 互联网产品经理..</a>
                        <a>【荐】王小二 互联网产品经理..</a>
                    </li>
                </ul>
                <ul>
                    <li class="mes">需求介绍：</li>
                    <li>
                        <textarea id="info_brief" name="demContent" cols="48" rows="9">${demand.demContent}</textarea>
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
                        <input class="mees" id="info_icon1" name="demImage" type="hidden" value="${demand.demImage}"/>
                        <img id="image1" alt="" src="${demand.demImage}" ></li>
                    <li>

                        <%--<input type="button" class="button" id="imgBtn" value="选择图片" style="width:72px"/>--%>
                        <%--</li>--%>

                    <li class="zp_ts"><span>*选填&nbsp;</span>注：大小为1M以内</li>

                </ul>


                <ul>
                    <li class="mes">类型：</li>
                    <li>
                    	<input type="hidden" id="demType" value="${demand.demType}"/>
                        <select class="mess" name="demType"   id="tree" disabled="true">
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
                                        var vId = ${demand.demType};
                                        $(ff).each(function(i,e){
                                        	if(e.ctId == $.trim(vId)){
                                        		$('input[name=demType]').prev().val(e.ctName);
                                        	}else{
	                                        	$(e.children).each(function(i1,e1){
	                                        		if(e1.ctId == $.trim(vId)){
	                                        			$('input[name=demType]').prev().val(e1.ctName);
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