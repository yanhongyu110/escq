<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<%@ include file="/WEB-INF/jsp/common/easyui.jsp"%>
<title>测试easyui</title>
</head>
<body>
<input type="text" id="startDate" />
<h2>Row Border in DataGrid</h2>
	<p>This sample shows how to change the row border style of datagrid.</p>
	<div style="margin:20px 0;">
		<span>Border:</span>
		<select onchange="changeBorder(this.value)">
			<option value="lines-both">Both</option>
			<option value="lines-no">No Border</option>
			<option value="lines-right">Right Border</option>
			<option value="lines-bottom">Bottom Border</option>
		</select>
		<span>Striped:</span>
		<input type="checkbox" onclick="$('#dg').datagrid({striped:$(this).is(':checked')})">
	</div>
	<table id="dg" class="easyui-datagrid" title="Row Border in DataGrid" style="width:700px;height:250px"
			data-options="singleSelect:true,fitColumns:true,url:'',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">Item ID</th>
				<th data-options="field:'productid',width:100">Product</th>
				<th data-options="field:'listprice',width:80,align:'right'">List Price</th>
				<th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
				<th data-options="field:'attr1',width:250">Attribute</th>
				<th data-options="field:'status',width:60,align:'center'">Status</th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
	$(function(){
		msgShow('系统提示','页面加载完成','info');
		$("#startDate").datebox({
			editable:false 
		})
	})
		function changeBorder(cls){
			$('#dg').datagrid('getPanel').removeClass('lines-both lines-no lines-right lines-bottom').addClass(cls);
		}
	</script>
	<style type="text/css">
		.lines-both .datagrid-body td{
		}
		.lines-no .datagrid-body td{
			border-right:1px dotted transparent;
			border-bottom:1px dotted transparent;
		}
		.lines-right .datagrid-body td{
			border-bottom:1px dotted transparent;
		}
		.lines-bottom .datagrid-body td{
			border-right:1px dotted transparent;
		}
	</style>
</body>
</html>