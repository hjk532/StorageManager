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
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 50px;">
				<legend>货物出库</legend>
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
			<table class="layui-table" id="test">
				<colgroup>
					<col width="150">
					<col width="150">
					<col width="200">
					<col>
				</colgroup>
				<tr>
					<th>货单号</th>
					<th>货物名</th>
					<th>类型编号</th>
					<th>生产日期</th>
					<th>当前数量</th>
					<th>出库数量</th>
					<th>操作</th>
				</tr>

				<c:forEach items="${cargos}" var="cargoVo">
					<form name="cargos" class="layui-form layui-form-pane"
						action="${pageContext.request.contextPath}/Cargo/outCargo.action">
						<input type="text" name="orderId" value="${cargoVo.orderId}"
							hidden="hidden" /> <input type="text" name="oNum"
							value="${cargoVo.oNum}" hidden="hidden" /> <input type="text"
							name="lastOptime" value="${cargoVo.lastOptime}" hidden="hidden" />
						<tr>
							<td><input type="text" name="orderId" hidden="hidden"
								value="${cargoVo.orderId}" />${cargoVo.orderId}</td>
							<td><input type="text" name="cargoName" hidden="hidden"
								value="${cargoVo.cargoName}" />${cargoVo.cargoName}</td>
							<td><input type="text" name="tNum" hidden="hidden"
								value="${cargoVo.tNum}" />${cargoVo.tNum}</td>
							<td><input type="text" name="productDate"
								hidden="hidden" value="${cargoVo.productDate}" />${cargoVo.productDate}</td>
							<td><input type="text" name="cargoAmount"
								hidden="hidden" value="${cargoVo.cargoAmount}" />${cargoVo.cargoAmount}</td>
							<td><input type="number" name="account" placeholder="输入提取数量" />
							<td><input type="submit" class="layui-btn layui-btn"
								value="提交" /></td>
						</tr>
					</form>
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
			<script src="../layui/layui.js" charset="utf-8"></script>
			<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
			<script>
				function uncultivated() {
					window.alert("实现逻辑与货物操作相同，即将上线")
				}
				layui
						.use(
								[ 'form', 'layedit', 'laydate' ],
								function() {
									var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;
									//日期
									laydate.render({
										elem : '#date'
									});
									laydate.render({
										elem : '#date1'
									});

									//创建一个编辑器
									var editIndex = layedit
											.build('LAY_demo_editor');

									//表单取值
									layui.$('#LAY-component-form-getval').on(
											'click', function() {
												var data = form.val('example');
												alert(JSON.stringify(data));
											});

								});
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