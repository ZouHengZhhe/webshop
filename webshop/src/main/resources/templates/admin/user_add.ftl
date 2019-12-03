

<!DOCTYPE html>
<html>
<head>
<title>客户添加</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="../../static/admin/css/bootstrap.css" />
</head>
<body>
<div class="container-fluid">

	<#include "header.html">
	<#if msg??><div class="alert alert-success">${msg}</div></#if>
	<#if failMsg??><div class="alert alert-danger">${failMsg}!</div></#if>
	<br><br>
	<form class="form-horizontal" action="/admin/user_add" method="post">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">用户名</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="username" required="required" <#if u??>value="${u.username}"</#if>>
			</div>
		</div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">邮箱</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="email" required="required" <#if u??>value="${u.email}"</#if>>
            </div>
        </div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">密码</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="password" required="required" <#if u??>value="${u.password}"</#if>>
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">收货人</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="name" <#if u??>value="${u.name}"</#if>>
			</div>
		</div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">电话</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="phone" <#if u??>value="${u.phone}"</#if>>
            </div>
        </div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">地址</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="address" <#if u??>value="${u.address}"</#if>>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交保存</button>
			</div>
		</div>
	</form>
	
	<span style="color:red;"></span>
</div>
</body>
</html>