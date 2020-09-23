<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>松鼠仓库管理系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">松鼠仓库管理系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left"></ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a
					href="${pageContext.request.contextPath}/Users/findUsers?account=${user.userAccount}">
						<img
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
								<a href="javascript:;" onclick="uncultivated()"
									>浏览货物类型</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="uncultivated()"
									>新增类型</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="uncultivated()"
									>修改类型</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="uncultivated()"
								    >删除类型</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">人员变更</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" onclick="uncultivated()"
								 	>查看人员信息</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="uncultivated()"
									>添加人员信息</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="uncultivated()"
									">修改人员信息</a>
							</dd>
							<dd>
								<a href="javascript:;" onclick="uncultivated()"
									>注销人员信息</a>
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
				style="margin-top: 20px;">
				<legend>操作员 - ${operator.optName} - 的个人中心</legend>
			</fieldset>

			<form class="layui-form layui-form-pane"
				action="${pageContext.request.contextPath}/Users/update"
				method="post">
				<input type="text" name="optNum" value="${operator.optNum }"
					hidden="hidden" />
				<div style="padding: 20px; background-color: #F2F2F2;">
					<div class="layui-row layui-col-space15">
						<div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
							<div class="layui-card">
								<div class="layui-card-body">
									<div class="layui-form-item">
										<div class="layui-card-header">操作员编号：${operator.optNum }</div>
									</div>
									<div class="layui-form-item">
										<div class="layui-inline">
											<label class="layui-form-label">姓名</label>
											<div class="layui-input-inline">
												<input type="text" name="optName" autocomplete="off"
													value="${operator.optName }" class="layui-input">
											</div>
										</div>
										<div class="layui-inline">
											<label class="layui-form-label">性别</label>
											<div class="layui-input-inline">
												<input type="text" name="optGender" autocomplete="off"
													value="${operator.optGender }" class="layui-input">
											</div>
										</div>
									</div>
									<div class="layui-form-item">
										<div class="layui-inline">
											<label class="layui-form-label">年龄</label>
											<div class="layui-input-inline">
												<input type="text" name="optAge" autocomplete="off"
													value="${operator.optAge }" class="layui-input">
											</div>
										</div>
										<div class="layui-inline">
											<label class="layui-form-label">工资</label>
											<div class="layui-input-inline">
												<input type="text" name="optSalary" autocomplete="off"
													value="${operator.optSalary }" class="layui-input">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<input type="text" name="userId" value="${user.userId }"
							hidden="hidden" />
						<div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
							<div class="layui-card">
								<div class="layui-card-body">
									<div class="layui-form-item">
										<div class="layui-inline">
											<label class="layui-form-label">账号</label>
											<div class="layui-input-inline">
												<input type="text" name="userAccount" autocomplete="off"
													value="${user.userAccount }" class="layui-input">
											</div>
										</div>
									</div>
									<div class="layui-form-item">
										<label class="layui-form-label">密码</label>
										<div class="layui-input-inline">
											<input type="password" name="userPassword"
												placeholder="请输入密码" value="${user.userPassword }"
												autocomplete="off" class="layui-input">
										</div>
									</div>
									<div class="layui-form-item">
										<label class="layui-form-label">权限等级</label>
										<div class="layui-input-inline">
											<input type="number" name="userAuthority" max="1" min="0"
												value="${user.userAuthority }" autocomplete="off"
												class="layui-input">
										</div>
										<span class="layui-line">（注：0级为管理员，1级为普通操作员）</span>
									</div>
								</div>
							</div>
						</div>
						<div class="layui-col-xs12 layui-col-sm12 layui-col-md12">
							<div class="layui-card">
								<div class="layui-card-body">
									<div class="layui-form-item">
										<input type="submit" class="layui-btn" lay-filter="demo2"
											value="保存修改">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
			<script src="${pageContext.request.contextPath}/layui/layui.js"
				charset="utf-8"></script>

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