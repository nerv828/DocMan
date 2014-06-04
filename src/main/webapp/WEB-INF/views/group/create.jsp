<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>创建群组</title>
	
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#name").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate({
				rules: {
					name: {
						remote: "${ctx}/group/checkName"
					}
				},
				messages: {
					loginName: {
						remote: "群组已存在"
					}
				}
			});
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/group/create" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>创建群组</small></legend>
			<div class="control-group">
				<label for="name" class="control-label">群组名称:</label>
				<div class="controls">
					<input type="text" id="name" name="name" class="input-large required" minlength="2"/>
				</div>
			</div>
			<div class="control-group">
				<label for="desc" class="control-label">描述:</label>
				<div class="controls">
					<input type="text" id="desc" name="desc" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="users" class="control-label">群组用户:</label>
				<div class="controls">
					<input type="text" id="users" name="users" class="input-large"/>
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>
