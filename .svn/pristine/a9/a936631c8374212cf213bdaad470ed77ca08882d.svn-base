<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>档期管理</title>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<script type="text/javascript" src="${webtxc}/jquery/jquery-1.11.1.js"></script>
<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
<%@ include file="/WEB-INF/jsp/common/kindeditor.jsp"%>
<link rel="stylesheet" href="${webtxc}/css/public.css" />
<link rel="stylesheet" href="${webtxc}/css/personal.css" />
<link rel="stylesheet" href="${webtxc}/calendar/css/bootstrap.css" />
<link rel="stylesheet" href="${webtxc}/calendar/css/bootstrap_datetimepicker.css" />
<link rel="stylesheet" href="${webtxc}/calendar/css/simple_calendar.css" />
<link rel="stylesheet" href="${webtxc}/calendar/mycss/arrange.css" />
<script type="text/javascript" src="${webtxc}/js/personal_tab.js"></script>
<script type="text/javascript" src="${webtxc}/js/personal_menu.js"></script>
<script type="text/javascript"
	src="${webtxc}/myjs/userinfo/providerrecommend.js?tag=20161212pm"></script>
<script type="text/javascript" src="${webtxc}/calendar/js/bootstrap.js"></script>
<script type="text/javascript" src="${webtxc}/calendar/js/bootstrap_datetimepicker.js"></script>
<script type="text/javascript" src="${webtxc}/calendar/js/simple_calendar.js"></script>
<script type="text/javascript" src="${webtxc}/calendar/myjs/arrange.js"></script>
</head>
<body>
		<div class="content-right">
			<div class="my_apply_clear"></div>
			<div class="my_apply">
			
				<!--日历-->
				<div id='container'></div>
				<!--日历end-->
			</div>
		</div>
	
	<!--查看档期模态框-->
		<div id="Modal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
						<h4 id="modal-title" class="modal-title"></h4>
					</div>
					<div class="modal-body">
					    <table class="table table-hover text-center">
					        <tr class="success">
					            <td>#</td>
					            <td>备注信息</td>
					            <td>开始时间</td>
					            <td>结束时间</td>
					            <td>操作</td>
					        </tr>
					    </table>
					</div>
					<div class="modal-footer">
						<button id="modal-add-btn" type="button" class="btn btn-primary">新增</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
		<!--查看档期模态框end-->
		
		<!-- 编辑模态框 -->
		<div id="editModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			    <div class="modal-content">
			    <div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
						<h4 id="editModal-title" class="modal-title"></h4>
					</div>
					<div class="modal-body">
						<form>
						    <input id="arrId"   type="hidden" >
							<div id="content-div" class="form-group">
								<div class="input-group">
									<div class="input-group-addon">备注信息</div>
									<input id="content-ipt"  class="form-control" type="text" placeholder="请输入备注信息" >
								</div>
							</div>
							<div id="startTime-div" class="form-group">
								<div class="input-group date form_time" data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" data-link-format="hh:ii">
									<div class="input-group-addon">开始时间</div>
									<input id="startTime-ipt" class="form-control" size="16" type="text" value="" placeholder="请点击选择开始时间" readonly>
									<span id="time-sp" class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
								</div>
							</div>
							<div id="endTime-div" class="form-group">
								<div class="input-group date form_time" data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" data-link-format="hh:ii">
									<div class="input-group-addon">结束时间</div>
									<input id="endTime-ipt" class="form-control" size="16" type="text" value="" placeholder="请点击选择结束时间" readonly>
									<span id="time-sp" class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button id="modal-save-btn" type="button" class="btn btn-primary">保存</button>
					</div>
			    </div>
			</div>
		</div>
		<!-- 编辑模态框end -->
		
		<!-- 提示模态框 -->
		<div id="messageModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
			    <div class="modal-content">
				    <div class="modal-header" style="background-color: #464857"></div>
					<div class="modal-body" style="18px;" align="center">
						<h3 id="messageH3">添加成功！</h3>
						<button type="button" class="btn btn-danger" data-dismiss="modal">确定</button>
					</div>
			    </div>
			</div>
		</div>
		<!-- 提示模态框end -->
	
	<script>
		var myCalendar = new SimpleCalendar('#container');
	</script>
</body>

</html>