<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<html xmlns:ng="http://angularjs.org" id="ng-app" ng-app="optionalModuleName" class="ng-app:myApp">
<html>
<head>
	<title>需求管理</title>
	<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
	<%@ include file="/WEB-INF/jsp/common/header.jsp" %>
	<%@ include file="/WEB-INF/jsp/common/easyui.jsp" %>
	<link rel="stylesheet" href="${webtxc}/css/public.css"/>
    <link rel="stylesheet" href="${webtxc}/css/personal.css"/>
	<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
    <script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
    <script type="text/javascript" src="${webtxc}/myjs/demand/demandAdminList.js?v=3"></script>
    <script type="text/javascript">
		$(document).ready(function() {
			$(".saixuan").click(function() {
				$(".saixuan_lei").toggle();
			});
		});
	</script>
	
</head>
<body>
<c:set var="istop" value="true" />
	<%@include file="/WEB-INF/jsp/common/top.jsp" %>
	<div class="content">
		<%@ include file="/WEB-INF/jsp/common/left.jsp" %>
		<div class="content-right" style="font-family:微软雅黑;">
			<div class="personal_zhanshi">
				<a class="fachu" style="text-decoration:none;" href="${webtxc}/demand/sa.html">发布的需求（${total}）</a>
				
			</div>
			<div class="personal_zhanshi_tab">
				<div class="personal_zhanshi_tab_product">
					<div class="product_dd show">
						<div class="product_seach">
							<form id="fom" action="${webtxc}/demand/gotodemandAmind.html" method="post">
								<input type="hidden" name="page" value="1">
								<input type="hidden" name="pageSize" value="10">
								<input type="text" placeholder="请输入您要搜索的关键词" class="sous"  id="demKeyword" name="demKeyword" value="${demand.demKeyword}" />
								<a class="btn" href="javascript:void (0)"></a>
								<a class="saixuan">精简筛选条件 <b ></b></a>
								<div class="saixuan_lei"  style="display: ${(demand.starttime!=null||demand.endtime!=null||info.serviceType!=null)?'block':'none'}">
									<div class="saixuan_lei_z" >
										<div class="sx_time" >
											<label>开始时间</label><input type="text" editable="false" class="sx_time_ks"  id="publicDate1" name="starttime" value="${demand.starttime}"/>
											<label>结束时间</label><input type="text" editable="false" class="sx_time_ks"  id="publicDate2" name="endtime" value="${demand.endtime}"/>
										</div>
										<div class="s_fuwu_lei">
											<label>服务类型</label>
											<select class="s_fuwu_lei_select" name="demType" id="tree" value="${demand.demType}">
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
					                                    height: "33",
					                                    width:269,
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
					                                                    var c = genList(it.children, it);
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
					                                        console.info(ff)
					                                        return ff;
					                                    }
					                                })
					                                $('.textbox-icon').css({"width":"38px"});
					                            	$('.textbox').css({"border-radius":"0px"});
					                            })
					                        </script>
										</div>
									</div>
									<!--end.saixuan_lei_z-->
								</div>
								<!--end.saixuan_lei-->
							</form>
						</div>
						<!--end.product_seach-->
						<div class="pe_dan" >
							<table cellpadding="0" cellspacing="0" class="pe_dan_title"> 
								<tr>
									<td width="38%">服务名称</td>
									
									<td width="10%"><!-- 单价 --></td>
									<td width="22%">发布时间</td>
									<td width="16%">操作</td>
									
								</tr>
							</table>
						<c:forEach var="demand" items="${list}">
							<div class="pe_dan_list">
								<table cellpadding="0" cellspacing="0" > 
									<tr>
										<td width="60%">
											<b>${demand.demTitle}</b>
											<c:if test="${demand.demState==1}">
												<b class="sh_ing">(审核中)</b>
											</c:if>
											<c:if test="${demand.demState==3}">
												<b class="sh_nopass">(未通过)</b>
											</c:if>
											<c:if test="${demand.demState==2}">
												<b class="sh_pass">(通过)</b>
											</c:if>
										</td>
										<td width="20%"></td>
										<td width="20%" align="center" class="delete_s">
											<img src="${webtxc}/images/delate.png" class="delBtn" alt="${demand.demId}"/>
										</td>
									</tr>
									<tr>
										<td width="60%" >
											<div class="title_img_dd b_j">
												<ul>
													<li>
													<c:if test="${not empty demand.demImage}"><img  src="${demand.demImage}"  /></c:if>
													<c:if test="${empty demand.demImage}"><img  src="${webtxc}/images/wap/xq_picture.jpg"  /></c:if>
													</li>
													<li class="dingdan">
														<span>${demand.demTitle}</span><br>
														${demand.demBrief}<br>
														<%-- <font>约见${serviceinfo.serviceMeettime}小时</font> --%>
													</li>
													<li class="danjia" >
														<%-- <span >￥${serviceinfo.psetPrice}</span> --%>
													</li>
													
												</ul>
											</div>
										</td>
										<td width="20%" align="center">${demand.demCreatetimeStr}</td>
										<td width="20%" align="center" class="b_j">
											<a class="bianji" id="editBtn" href="${webtxc}/demand/gotoUpdateDemand.html?id=${demand.demId}" style="background:url(${webtxc}/images/bianji_wu.png) no-repeat right;padding-right:23px;text-decoration:none;">编辑</a>
										</td>
									</tr>
								</table>
							</div><!--end.pe_dan_list-->
						</c:forEach>
						
						</div>
						<!--end.pe_dan-->

					</div>
					<!--end.product-->
				</div>
				<!--end.personal_zhanshi_tab_product-->
			</div>
			<!--end.personal_zhanshi_tab-->
			
			<div class="jogger" id="ggggg"></div>
			
			
		</div>
		<!--end.content-right-->
	</div>
	<!--end.content-->
	<%@include file="/WEB-INF/jsp/common/bottom.jsp" %>
</body>
<script>
	$(function(){
		pageNum(${total},10,${page},'ggggg');
	});

	function selectCommonAjax(num){
		$('input[name=page]').val(num);
		$('#publicDate1').attr('name','');
		$('#publicDate2').attr('name','');
		$('input[name=demType]').attr('name','');
		$('#fom').submit();
	}


</script>
</html>