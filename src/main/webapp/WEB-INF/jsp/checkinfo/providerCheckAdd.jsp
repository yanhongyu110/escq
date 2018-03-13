<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>

<html xmlns:ng="http://angularjs.org" id="ng-app" ng-app="optionalModuleName" class="ng-app:myApp">
<head>
    <%@ include file="/WEB-INF/jsp/common/header.jsp" %>
    <%@ include file="/WEB-INF/jsp/common/angular.jsp" %>
    <%@ include file="/WEB-INF/jsp/common/anima.jsp" %>
    <%@ include file="/WEB-INF/jsp/common/kindeditor.jsp" %>
    <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
    <link rel="stylesheet" href="${webtxc}/css/public.css"/>
    <link rel="stylesheet" href="${webtxc}/css/personal.css?v=123"/>
    <script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
    <script type="text/javascript" src="${webtxc}/js/jquery.citysh.js?val=14d3"></script>
    <script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
    <link rel="stylesheet" type="text/css" href="${webtxc}/map/map.css">
    <script type="text/javascript" src="${webtxc}/map/map.js?val=123"></script>
    <script type="text/javascript" src="${webtxc}/myjs/checkinfo/providercheckadd.js?val=12312312312312123123123"></script>
    <script src="${webtxc}/vue/vue.min.js"></script>
    <script>
        $(function () {
            $.post(path+'/company/companyListAjax.html',{},function (r) {
                var app=new Vue({
                    el:'#orz_com',
                    data:{
                        piCom:r.list[0].compId,
                        piCompany:r.list[0].compName,
                        list:r.list
                    },
                    methods:{
                        select:function (r) {
                            this.piCompany= r.compName;
                        }
                    }
                })
            },'json')
        })
    </script>
    
    <title>服务商认证信息添加</title>
</head>
<body>

	<c:set var="istop" value="true" />
   <%@include file="/WEB-INF/jsp/common/top.jsp" %>
    <div class="content">
  	 <%@include file="/WEB-INF/jsp/common/left.jsp" %>
            <div class="content-right" style="">
				<form id="form" action="${webtxc}/checkinfo/providerCheck/addCheckInfo.html" method="post" ng-app="myApp" ng-controller="controller" name="f" novalidate>
                <div class="expert_mes ">
                    <h2>基本信息</h2>
                    <div class="status_icon">
                        <p class="progress_bar"></p>
                        <div class="status_progress status_one on">
                            <div class="steps">1
                                <div class="stripeL"></div>
                                <div class="stripeR"></div>
                            </div>
                            <div class="status_text">基本信息</div>
                        </div>
                        <div class="status_progress status_two">
                            <div class="steps">2
                                <div class="stripeL"></div>
                                <div class="stripeR"></div>
                            </div>
                            <div class="status_text">认证资料</div>
                        </div>
                        <div class="status_progress status_three">
                            <div class="steps">3
                                <div class="stripeL"></div>
                                <div class="stripeR"></div>
                            </div>
                            <div class="status_text">个人介绍</div>
                        </div>

                    </div><!--end.status_icon-->
                    <div class="note_message">
                        <ul>
                            <li class="mes">真实姓名：</li>
                            <!-- 取消实名认证  若需加上实名认证 加上以下属性 -->
                            <!--value="${userInfoVo.userRealName}" readonly="true"  -->
                            <li><input class="mees piRealname" type="text"  name="piRealname"> <span class="tips">*必填</span></li>
                        </ul>
                        <ul id="orz_com">
                            <li class="mes">所属公司：</li>
                            <li>
                                <select name="piCom" style="width: 378px" v-model="piCom">
                                    <option v-for="it in list" :value="it.compId" v-text="it.compName" @click="select(it)"></option>
                                </select>
                                <input  class="mees" type="hidden" v-model="piCompany" name="piCompany" placeholder="请填写您的任职机构" ><span class="tips">*必填</span>
                            </li>
                        	<%--<li class="zp_ts">字数不超过<span>30</span>个字。</li>--%>
                        </ul>
                        <ul>
                            <li class="mes">任职职位/头衔：</li>
                            <li><input class="mees piPosition" type="text" value="" name="piPosition" placeholder="请填写您的任职职位" maxlength="30" required><span class="tips">*必填</span></li>
                        </ul>
                        <ul>
                            <li class="mes">工作年限：</li>
                            <li><input class="mees piWorkyear" type="text" name="piWorkyear"  maxlength="2" placeholder="请填写您的工作年限"><span class="tips">*必填</span></li>
                            <li class="zp_ts" style="display:none;"><span>请确认工作年限的范围0-50</span>
                            </li>
                        </ul>
                        <ul>
                            <li class="mes">联系方式：</li>
                            <li><input class="mees piCell" type="text" name="piCell" maxlength="11" placeholder="请填写您的联系方式"><span class="tips">*必填</span></li>
                            <li class="zp_ts" style="display:none;"><span>请填写正确的联系方式</span></li>
                        </ul>
                        <ul>
                            <li class="mes">邮箱：</li>
                            <li><input class="mees piEmail" type="text" name="piEmail" maxlength="30" placeholder="请填写您的邮箱地址"><span class="tips">*必填</span></li>
                            <li class="zp_ts" style="display:none;"><span>请填写正确的邮箱</span></li>
                        </ul>
                        <ul>
                            <li class="mes">关键字：</li>
                            <li><textarea  class="piKeywords" name="piKeywords" style="resize: none;margin-bottom: 15px" ng-model="piKeywords" rows="5" cols="48"  required ></textarea></li>
                            <li class="zp_ts"><span class="tips">*必填</span><br>请填写此主题的关键字，以逗号（，）分隔，最多<span>5</span>个关键字，如：话题咨询，互联网产品</li>
                        </ul>
                        <ul>
                            <li class="mes">常驻城市：</li>
                            <li>
				                <div id="city" class="citys">
				                <p>
				                    <select  class="province" name="province"></select>
				                    <select  class="city"  name="city"></select>
				                    <select  class="area" name="area"></select>
				                    <span class="tips">*必填</span>
				                </p>
				           		</div>
				            	<input type="hidden" class="piArea" name="piArea" />
				            <script type="text/javascript">
				           var dd={};
				                $('#city').citys({onChange:function(hehe){if(hehe.area==""){ $(".piArea").val(hehe.province+"-"+hehe.city)}else{ $(".piArea").val(hehe.province+"-"+hehe.city+"-"+hehe.area)};console.log(hehe);}},function(api){
				                    var info = api.getInfo();
				                    $(".piArea").val(info.province+"-"+info.city+"-"+info.area);console.log(info);
				                    console.log(info);
				                });
				                </script>
                            </li>
                        </ul>
                        <ul>
                            <li class="mes">详细地址：</li>
                            <li><input type="text" class="mees"  name="piAddr" ng-model="piAddr" placeholder="点击右边搜索框添加" readonly="readonly" ></li>
                            <li><input type="button" value="点击定位"  map-start map-click="sss"></li><span class="tips">*必填</span>
                           <!--  <li><input type="hidden" name="point"></li> -->
                        </ul>
                        <div class="mes_btn">

                            <a class="mes_bc">下一步</a>
                        </div>
                    </div>

                </div><!--end.expert_mes-->
                <div class="expert_mes ">
                    <h2>认证资料</h2>
                    <div class="status_icon">
                        <p class="progress_bar"></p>
                        <div class="status_progress status_one ">
                            <div class="steps">1
                                <div class="stripeL"></div>
                                <div class="stripeR"></div>
                            </div>
                            <div class="status_text">基本信息</div>
                        </div>
                        <div class="status_progress status_two on">
                            <div class="steps">2
                                <div class="stripeL"></div>
                                <div class="stripeR"></div>
                            </div>
                            <div class="status_text">认证资料</div>
                        </div>
                        <div class="status_progress status_three">
                            <div class="steps">3
                                <div class="stripeL"></div>
                                <div class="stripeR"></div>
                            </div>
                            <div class="status_text">个人介绍</div>
                        </div>

                    </div><!--end.status_icon-->
                     <div class="note_message">
                        <ul>
                            <li class="mes">上传名片：</li>
                            <li class="expert_xl">
                             	<a class="upload"><img class="imgUrl"/></a>
                                 <a class="upload"><img class="imgUrl" /></a>
                                 <input type="hidden" class="imgUrls" name="pciImage"/>
                            </li>
                         
                            
                            <li class="zp_ts"><span >（选填）</span></br>请上传清晰可见的名片正反面，文件单个大小不超过<span>1M</span>。</li>
                        </ul>
                        <ul >
                            <li class="mes">学历资料：</li>
                            <li class="expert_xl">                              
                            <a class="upload"><img class="imgUrl" /></a>
                            <a class="upload"><img class="imgUrl" /></a>
                             <input type="hidden" class="imgUrls" name="pciEaducate"/>
                            </li>
                            
                            
                            <li class="zp_ts"><span>（选填）</span></br>请上传清晰可见的资料图片，文件单个大小不超过<span>1M</span>，请尽量多的提供专家能力证明的资料。</li>
                        </ul>
                        <ul >
                            <li class="mes">专业资格证书：</li>
                            <li class="expert_xl">                              
                            <a class="upload"><img class="imgUrl" /></a>
                            <a class="upload"><img class="imgUrl" /></a>
                             <input type="hidden" class="imgUrls" name="pciCredentials"/>
                            </li>
                           
                            
                            <li class="zp_ts"><span>（选填）</span></br>请上传清晰可见的资料图片，文件单个大小不超过<span>1M</span>，请尽量多的提供专家能力证明的资料。</li>
                        </ul>
                        <ul >
                            <li class="mes">上传各种有关专家认证的其它有力证明资料：</li>
                            <li class="expert_xl">                              
                            <a class="upload"><img class="imgUrl" /></a>
                            <a class="upload"><img class="imgUrl" /></a>
                            <input type="hidden" class="imgUrls" name="pciOthers"  />
                            </li>
                            
                             
                            <li class="zp_ts"><span>（选填）</span></br>请上传清晰可见的资料图片，文件单个大小不超过<span>1M</span>，请尽量多的提供专家能力证明的资料。</li>
                        </ul>
                        
                        


                        <div class="mes_btn">
                            <a class="mes_bc">上一步</a>

                            <a class="mes_bc" >下一步</a>
                        </div>

                    </div>

                </div><!--end.expert_mes-->
                <div class="expert_mes ">
                    <h2>个人介绍</h2>
                    <div class="status_icon">
                        <p class="progress_bar"></p>
                        <div class="status_progress status_one ">
                            <div class="steps">1
                                <div class="stripeL"></div>
                                <div class="stripeR"></div>
                            </div>
                            <div class="status_text">基本信息</div>
                        </div>
                        <div class="status_progress status_two ">
                            <div class="steps">2
                                <div class="stripeL"></div>
                                <div class="stripeR"></div>
                            </div>
                            <div class="status_text">认证资料</div>
                        </div>
                        <div class="status_progress status_three on">
                            <div class="steps">3
                                <div class="stripeL"></div>
                                <div class="stripeR"></div>
                            </div>
                            <div class="status_text">个人介绍</div>
                        </div>
                    </div>
                    <!--end.status_icon-->
                    <div class="note_message">
                        <ul>
                            <li class="mes">生活照片：</li>
                            <li class="expert_xl">
                          	  <a class="upload"><img class="imgUrl"/></a>
                              <input type="hidden" class="piPhoto" name="piPhoto"  />
                            </li>

                            <li class="zp_ts">请上传代表您个人形象的生活照片，此照片将显示在个人简介中，照片大小不超过<span>10M</span>。</li>
                        </ul>
                        <ul>
                            <li class="mes">视频封面：</li>
                            <li class="expert_xl">
                          	  <a class="upload"><img class="imgUrl" /></a>
                              <input type="hidden" class="piComment" name="piComment"  />
                            </li>

                            <li class="zp_ts"><span>（选填）</span><br>请上传代表您的介绍视频的封面显示图片，照片大小不超过<span>10M</span>。</li>
                        </ul>
                        <ul class="media">
                            <li class="mes">介绍视频：</li>
                            <li class="expert_mp ex_sp" >
                            	<div id="mediadiv" class="ex_zxs"></div>
                                <a  id="media" ></a>
                               <input type="hidden"  readonly="readonly"  id="mediaUpload" class="piVideo" name="piVideo" value="${ providerInfo.piVideo}" rows="5"/>
                            </li>

                            <li class="zp_ts"><span>（选填）</span><br>注：大小为<span>100M</span>以内</li>
                        </ul>
                        <ul>
                            <li class="mes">一句话描述：</li>
                            <li>
                                <textarea name="piBrief" ng-model="piBrief"  style="resize: none;" ng-pattern="/^.{0,25}$/" maxlength="25"  cols="54" rows="2"></textarea>
                            </li>
                            <li class="zp_ts"><span>（选填）</span><br>字数不能超过<span>25</span>个字</li>
                        </ul>
                        <ul>
                            <li class="mes">个人介绍：</li>
                            <li>
                                <textarea name="piContent" ng-model="piContent" style="resize: none;" ng-pattern="/^.{0,200}$/" maxlength="200" cols="54" rows="9"></textarea>
                            </li>

                            <li class="zp_ts">字数不能超过<span>200</span>个字</li>
                            
                        </ul>

                        <ul>
                            <li class="mes">相关链接：</li>
                            <li class="xg_links">
                            <div class="links" id="links">
                            <a class="addrow" id="addrow" href="javascript:void(0)">添加</a>
                            <div class="link" style="display:none;" id="link">
                                  <div class="bo_wk">
                               		<span>标题：<input type="text" class="linkname" /></span>
                             		<span>网址：<input type="text" class="linkurl" /></span>
                                    <a class="delrow" href="javascript:void(0)">删除</a>
                                    </div>
                            </div>
                            <div class="link linktemp">
                                    <div class="bo_wk">
                               		<span> 标题：<input type="text" class="linkname"/></span>
                             		<span> 网址：<input type="text" class="linkurl"/></span>
                                </div>
                            </div>
                        </div>
                         <input class="piUrls" type="hidden" name="piUrls"  ng-model="piUrls"  />
                        </li>
                          <li class="zp_ts m_padding">相关链接<span>（选填）</span>请在此附上您的博客地址或网络上关于您的报道链接<br/>网址样式：http://www.baidu.com
                            </li>
						</ul>


                        <div class="mes_btn">
                            <a class="mes_bc">上一步</a>
							

							<button class="mes_bc" type="button" >提交</button>
                        </div>

                    </div>

                </div><!--end.expert_mes-->





                    <%--<div ng-show="!baiduMap.isHidden"  style=";overflow: hidden;border-radius: 2%;border: 1px solid #b1a7a7;box-shadow: 0px 0px 31px 1px #c5c5c5;text-align: center;margin-left: -400px;margin-top: -300px;;width: 800px;height:600px;background-color: #fdfcfc;position: fixed;top: 50%;left: 50%">--%>
                        <%--<div style="width: 200%;height: 35px;line-height: 35px;background-color: #dcdcdc;text-align: left;position: relative;z-index: 10000" id="ss">--%>
                            <%--<span style="font-size: 21px;margin-left: 10px;font-weight: bold;">百度地图</span>--%>
                        <%--</div>--%>
                        <%--<div style="width: 100%;height: 6%;line-height: 30px">--%>
            <%--<span style="text-align: left;width: 71%;display: inline-block;vertical-align: middle">--%>
                <%--<!--<map-citys style=""></map-citys>-->--%>
                <%--<map-search-input style="width: 200px" placeholder="请输入搜寻地址"></map-search-input>--%>
                <%--<map-search-btn></map-search-btn>--%>
            <%--</span>--%>
            <%--<span style="text-align: right;width: 25%;display: inline-block;vertical-align: middle">--%>
                <%--<map-reset-search value="重置"></map-reset-search>--%>
                <%--<map-get-position fuc="sss" value="得到点"></map-get-position>--%>
            <%--</span>--%>
                        <%--</div>--%>
                        <%--<div style="width: 100%;height: 88%">--%>
                            <%--<baidu-map style="height: 97%;width: 97%;display: inline-block" use-gps="true"></baidu-map>--%>
                            <%--<div map-infor-temp>--%>
                                <%--<h4>#city#</h4>--%>
                                <%--<input type="text" style="border: 1px solid red">--%>
                                <%--<button type="button" click="sss" >点击打出详情</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--&lt;%&ndash;<map-show-data-btn value="从后台获取数据" url="../data"></map-show-data-btn>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<map-show-position-marker-btn value="显示定位标符"></map-show-position-marker-btn>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<map-clear-over-btn value="清除所有标符"></map-clear-over-btn>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<map-could-search-input></map-could-search-input>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<map-nearby-btn value="搜商家" range="3000"></map-nearby-btn>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;所有信息在控制台&ndash;%&gt;--%>
                    <%--</div>--%>



                <input name="pointt" type="hidden" ng-model="point">



                </form>
                <!--end.content-right-->
            </div>
        
        <!--end.content-->

    </div>
    <%@include file="/WEB-INF/jsp/common/bottom.jsp" %>
    <%--<a class="dw" href="javascript:void(0)"  >定位</a>--%>
</body>
<script type="text/javascript">
    function sss(value) {
        $('[map]').hide()
        var scope = angular.element($("#form")[0]).scope();
//        scope.baiduMap.isHidden=true;
        //数据处理
        scope.piAddr=value.address;
        var m={}
        m.pointLat=value.point.lat;
        m.pointLng=value.point.lng
        $("[name=pointt]").val(JSON.stringify(m));
        console.log(value)
        scope.$apply()
    }


    angular.module("myApp", ['fastValidate']).controller("controller", function ($scope) {
//        $scope.baiduMap = {}
//        $scope.baiduMap.isHidden = true;
//        $scope.showMap = function () {
//            $scope.baiduMap.isHidden = false;
//        }
    })
</script>
</html>
