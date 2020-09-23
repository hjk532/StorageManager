<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>松鼠仓库管理系统</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">

	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">松鼠仓库管理系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a
					href="${pageContext.request.contextPath}/Users/findUsers?account=${user.userAccount}"><img
						src="${pageContext.request.contextPath}/layui/images/head.jpg"
						class="layui-nav-img">${user.operator.optName }</a>
					<dl class="layui-nav-child">
						<dd>
							<a
								href="${pageContext.request.contextPath}/Users/findUsers?account=${user.userAccount}">个人中心</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath}/Users/logout">登出</a>
						</dd>
					</dl></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree">
					<li class="layui-nav-item layui-nav-itemed">货物操作
						<dl class="layui-nav-child">
							<dd>
								<a
									href="${pageContext.request.contextPath}/Cargo/showCargo?page=1&userAccount=${user.userAccount}">浏览仓库</a>
							</dd>
							<dd>
								<a
									href="${pageContext.request.contextPath}/Cargo/newCargo?userAccount=${user.userAccount}">货物入库</a>
							</dd>
							<dd>
								<a
									href="${pageContext.request.contextPath}/Cargo/dooutCargo?userAccount=${user.userAccount}&opId=${user.opId}&optName=${user.operator.optName}&page=1">货物出库</a>
							</dd>
							<dd>
								<a
									href="${pageContext.request.contextPath}/Cargo/changeCargo?userAccount=${user.userAccount}&opId=${user.opId}&optName=${user.operator.optName}&page=1 ">修改货单</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">类型操作</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" onclick="uncultivated()">浏览货物类型</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="uncultivated()">新增类型</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="uncultivated()">修改类型</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="uncultivated()">删除类型</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">人员变更</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" onclick="uncultivated()">查看人员信息</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="uncultivated()">添加人员信息</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="uncultivated()">修改人员信息</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="uncultivated()">注销人员信息</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a
						href="${pageContext.request.contextPath}/Log/findLog?userAccount=${user.userAccount}&opId=${user.opId}&optName=${user.operator.optName}&page=1">浏览日志</a></li>
				</ul>
			</div>
		</div>

		<!-- 内容主体区域 -->
		<div class="layui-body layui-fluid">
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-header"></div>
				</div>
			</div>
			<form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/Cargo/query">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">指定货单号</label>
						<div class="layui-input-inline">
							<input type="text" name="orderId" autocomplete="off"
								class="layui-input">
						</div>
					</div><div class="layui-inline">
						<label class="layui-form-label">指定货物名</label>
						<div class="layui-input-inline">
							<input type="text" name="cargoName" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">指定类型编号</label>
						<div class="layui-input-inline">
							<input type="text" name="tNum" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">指定日期</label>
						<div class="layui-input-block">
							<input type="text" name="productDate" id="date1" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<input type="submit" value="检索" class="layui-btn layui-btn-normal"/>
				</div>
			</form>
			<table class="layui-hide" id="test" lay-filter="test"></table>
			<script type="text/html" id="toolbarDemo">
  				<div class="layui-btn-container"></div>
			</script>
			<script type="text/html" id="barDemo"></script>
			<script src="../layui/layui.js" charset="utf-8"></script>
			<script>
				layui.use('table', function(){
				  var table = layui.table;
				  table.render({
				    elem: '#test'
				    ,url:'<%=request.getContextPath()%>/Cargo/getList'
				    ,toolbar: '#toolbarDemo'
				    ,title: '货单数据表'
				    ,totalRow: true
				    ,cols: [[
				     
				      ,{field:'orderId', title:'货单编号', width:120, unresize: true, sort: true, totalRowText: '合计'}
				      ,{field:'cargoName', title:'货物名', width:120,}
				      ,{field:'cargoAmount', title:'货物数量', width:120, sort: true, totalRow: true}
				      ,{field:'oNum', title:'操作员编号', width:120, sort: true}
				      ,{field:'tNum', title:'类型编号', width:120, sort: true}
				      ,{field:'productDate', title:'生产日期', width:120}
				      ,{field:'lastOptime', title:'货单更新日期', width:160}
				
				    ]]
				    ,page: true
				  });
				});
			</script>
			<script type="text/javascript">
function uncultivated() {
	window.alert("实现逻辑与货物操作相同，即将上线")
}
layui.use('element', function() {
	var element = layui.element;

});
</script>
		</div>

		<!-- -------------------------------------------------------------------------- -->
		<div class="layui-footer">
			<!-- 底部固定区域 -->
			开发者日志- github: <img
				src="${pageContext.request.contextPath}/layui/images/head.jpg"
				class="layui-nav-img"><a href="https://github.com/hjk532">@hjk532</a>
		</div>
	</div>

</body>
</html>