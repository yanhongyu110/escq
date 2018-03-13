<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<title>档期</title>
<link rel="stylesheet" href="${webtxc}/calendar/css/bootstrap.css" />
<link rel="stylesheet" href="${webtxc}/calendar/css/bootstrap_datetimepicker.css" />
<link rel="stylesheet" href="${webtxc}/calendar/css/simple_calendar.css" />
<script type="text/javascript" src="${webtxc}/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${webtxc}/calendar/js/bootstrap.js"></script>
<script type="text/javascript" src="${webtxc}/calendar/js/bootstrap_datetimepicker.js"></script>
<script type="text/javascript" src="${webtxc}/calendar/js/simple_calendar.js"></script>
<script type="text/javascript" src="${webtxc}/calendar/myjs/customer.js"></script>
</head>
<body style="background-color: rgba(0,0,0,0);">
	<!--日历界面-->
	<div style="background-color: white;height: 500px;width: 500px">
		<!--日历-->
		<div id='container'></div>
		<!--日历end-->
	</div>
	<!--日历界面end-->

	<!--档期表格模态框-->
	<div id="tableModal" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 id="modal-title" class="modal-title">2016-12-12</h4>
				</div>
				<div class="modal-body">
					<table class="table table-hover text-center">
						<tr class="success">
							<td>#</td>
							<td>开始时间</td>
							<td>结束时间</td>
							<td>状态</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!--档期表格模态框end-->
	
	<script>
		var myCalendar = new SimpleCalendar('#container');
	</script>
	
</body>
</html>