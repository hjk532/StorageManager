<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>仓库管理系统</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/layui/css/layui.css"
	media="all">
</head>
<body>
	<fieldset class="/layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>松鼠仓库管理系统</legend>
	</fieldset>

	<div style="padding: 150px; background-color: #F2F2F2;">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md4">
				<span class="layui-card"></span>
			</div>
			<div class="layui-col-md4">
				<div class="layui-card">
					<div class="layui-card-body">
						<fieldset class="layui-elem-field layui-field-title"
							style="margin-top: 20px;">
							<legend>用户登录</legend>
							<form name="user" class="layui-form"
								action="${pageContext.request.contextPath}/Users/login.action"
								method="post">
								<div class="layui-form-item">
									<label class="layui-form-label">账号</label>
									<div class="layui-input-block">
										<input type="text" name="userAccount"
											value="${user.userAccount }" autocomplete="off"
											placeholder="请输入账号" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">密码</label>
									<div class="layui-input-block">
										<input type="password" name="userPassword"
											value="${user.userPassword }" placeholder="请输入密码"
											autocomplete="off" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<div class="layui-input-block">
										<input type="submit" class="layui-btn" value="登录" />
										<h5>忘记密码请联系管理员</h5>
									</div>
								</div>
							</form>
						</fieldset>
					</div>
				</div>
			</div>
			<div class="layui-col-md4">
				<span class="layui-card"></span>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/layui/layui.js"
		charset="utf-8"></script>
</body>
</html>