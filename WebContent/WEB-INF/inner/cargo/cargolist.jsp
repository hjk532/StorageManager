<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 50px;">
				<legend>浏览货物</legend>
			</fieldset>
			<form name="query" class="layui-form layui-form-pane"
				action="${pageContext.request.contextPath}/Cargo/showCargo">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">货单号</label>
						<div class="layui-input-inline">
							<input type="text" name="orderId" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">货物名</label>
						<div class="layui-input-inline">
							<input type="text" name="cargoName" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">类型编号</label>
						<div class="layui-input-inline">
							<input type="text" name="tNum" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">操作员号</label>
						<div class="layui-input-inline">
							<input type="text" name="oNum" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<input type="submit" value="检索" class="layui-btn layui-btn-normal" />
				</div>
				<input type="text" name="userAccount" value="${user.userAccount}" hidden="hidden"/>
				<input type="text" name="page" value="1" hidden="hidden"/>
			</form>
			<table class="layui-table" id="test" width="600">
				<colgroup>
					<col width="150">
					<col width="150">
					<col width="200">
					<col>
				</colgroup>
				<tr>
					<th width="60">货单编号</th>
					<th width="60">货物名</th>
					<th width="60">货物数量</th>
					<th width="60">操作员编号</th>
					<th width="60">类型编号</th>
					<th width="60">生产日期</th>
					<th width="60">货单更新日期</th>
				</tr>

				<c:forEach items="${cargos}" var="cargoVo">
					<tr>
						<td>${cargoVo.orderId}</td>
						<td>${cargoVo.cargoName}</td>
						<td>${cargoVo.cargoAmount}</td>
						<td>${cargoVo.oNum}</td>
						<td>${cargoVo.tNum}</td>
						<td>${cargoVo.productDate}</td>
						<td>${cargoVo.lastOptime}</td>

					</tr>
				</c:forEach>
			</table>
			<div>
				共${cargos.size()}条数据 -
				<button type="button" class="layui-btn layui-btn-sm">
					<i class="layui-icon"></i>
				</button>
				<input form="query" name="page" value="1" type="button" class="layui-btn layui-btn-sm"/>
				<c:forEach begin="1" end="${cargos.size()}" var="i">
					<c:if test="${i}%10 == 0">
						<input form="query" name="page" value="${(id.value/10)+1}" type="button" class="layui-btn layui-btn-sm"/>
					</c:if>
				</c:forEach>
				<button type="button" class="layui-btn layui-btn-sm">
					<i class="layui-icon"></i>
				</button>
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
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript">
				function uncultivated() {
						window.alert("实现逻辑与货物操作相同，即将上线")
					}
				layui.use('element', function() {
					var element = layui.element;
				});
	</script>
</body>
</html>