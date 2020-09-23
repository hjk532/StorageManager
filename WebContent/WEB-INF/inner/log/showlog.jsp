<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>松鼠仓库管理系统</title>
<link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">松鼠仓库管理系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left"></ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item">
				<a href="${pageContext.request.contextPath}/Users/findUsers?account=${user.userAccount}">
				<img src="${pageContext.request.contextPath}/layui/images/head.jpg"
						class="layui-nav-img">${user.operator.optName }</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="${pageContext.request.contextPath}/Users/findUsers?account=${user.userAccount}">个人中心</a>
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
									href="${pageContext.request.contextPath}/Cargo/showCargo?userAccount=${user.userAccount}&opId=${user.opId}&optName=${user.operator.optName}&page=1">浏览仓库</a>
							</dd>
							<dd>
								<a
									href="${pageContext.request.contextPath}/Cargo/newCargo?userAccount=${user.userAccount}&opId=${user.opId}&optName=${user.operator.optName}">货物入库</a>
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
			<div style="padding: 20px; background-color: #F2F2F2;">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md8">
				<div class="layui-card">
					<div class="layui-card-body">日志编号：${log.logId}</div>
				</div>
			</div>
			<div class="layui-col-md8">
				<div class="layui-card">
					<div class="layui-card-body">生成时间：${log.generateTime}</div>
				</div>
			</div>
			<div class="layui-col-md8">
				<div class="layui-card">
					<div class="layui-card-body">操作员编号：${log.opId}</div>
				</div>
			</div>
			<div class="layui-col-md8">
				<div class="layui-card">
					<div class="layui-card-header">货单信息：</div>
					<div class="layui-card-body">${log.cargoList}</div>
				</div>
			</div>
			<div class="layui-col-md8">
				<div class="layui-card">
					<div class="layui-card-body">日志状态：${log.logStatus}</div>
				</div>
			</div>
		</div>
	</div>
		</div>

		<!-- -------------------------------------------------------------------------- -->
		<div class="layui-footer">
			<!-- 底部固定区域 -->
			开发者日志- github: <img
				src="${pageContext.request.contextPath}/layui/images/head.jpg"
				class="layui-nav-img"><a href="https://github.com/hjk532">@hjk532</a>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		function uncultivated() {
			window.alert("实现逻辑与货物操作相同，即将上线")
		}
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>
</body>
</html>