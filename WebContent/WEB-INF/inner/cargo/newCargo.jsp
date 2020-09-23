<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
				<legend>新增货物</legend>
			</fieldset>
			<form name="cargo" class="layui-form layui-form-pane"
				action="${pageContext.request.contextPath}/Cargo/addCargo.action">
				<div class="layui-form-item">
					<label class="layui-form-label">货物名称</label>
					<div class="layui-input-block">
						<input type="text" name="cargoName" autocomplete="off"
							placeholder="请输入货物名称" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">货物数量</label>
					<div class="layui-input-inline">
						<input type="number" name="cargoAmount" lay-verify="required"
							placeholder="0" autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid layui-word-aux">件</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">操作员</label>
					<div class="layui-input-inline">
						<input type="text" name="oName" lay-verify="required"
							value="${user.operator.optName}" readonly="readonly"
							class="layui-input"> <input type="text" name="oNum"
							value="${user.operator.optNum}" readonly="readonly"
							hidden="hidden" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">货物类型</label>
					<div class="layui-input-block">
						<select name="tNum" lay-filter="aihao">
							<option value="" selected=""></option>
							<c:forEach items="${types}" var="type">
								<option value="${type.typeNum}">${type.typeName}</option>
							</c:forEach>
						</select>
					</div>
					<h4>货物类型取决于数据库中的type表</h4>
				</div>

				<div class="layui-form-item">

					<div class="layui-inline">
						<label class="layui-form-label">生产日期</label>
						<div class="layui-input-block">
							<input type="text" name="productDate" id="date1"
								autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<div class="layui-form-item">
					<input type="submit" class="layui-btn" value="提交">
				</div>
			</form>
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 30px;">
				<legend>上传Excel文件</legend>
			</fieldset>

			<button type="button" class="layui-btn layui-btn-danger" id="test7">
				<i class="layui-icon"></i>上传
			</button>
			<div class="layui-inline layui-word-aux">文件不得大于3M</div>
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
		layui.use(['form', 'layedit', 'laydate','upload'], function(){
				  var form = layui.form
				  ,layer = layui.layer
				  ,layedit = layui.layedit
				  ,laydate = layui.laydate;
				  var $ = layui.jquery
				  ,upload = layui.upload;
				  //日期
				  laydate.render({
				    elem: '#date'
				  });
				  laydate.render({
				    elem: '#date1'
				  });
				  upload.render({
					    elem: '#test7'
					    ,url: 'https://httpbin.org/post' //改成您自己的上传接口
					    ,size: 60 //限制文件大小，单位 KB
					    ,done: function(res){
					      layer.msg('上传成功');
					      console.log(res)
					    }
					  });
				  //监听指定开关
				  form.on('switch(switchTest)', function(data){
				    layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
				      offset: '6px'
				    });
				    layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
				  });
				  
				  //表单取值
				  layui.$('#LAY-component-form-getval').on('click', function(){
				    var data = form.val('example');
				    alert(JSON.stringify(data));
				  });
				  
				});
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>
</body>
</html>