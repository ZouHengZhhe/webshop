
<!DOCTYPE html>
<html>
<head>
<title>重置密码</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="../../static/admin/css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">

	<#include "header.html">

	<br><br>
	
	<form class="form-horizontal" action="/admin/user_reset" method="post">
		<input type="hidden" name="username" value="${username}">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">用户名</label>
			<div class="col-sm-5">${username}</div>
		</div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">邮箱</label>
            <div class="col-sm-5">${email}</div>
        </div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">密码</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="password" value="" required="required">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交修改</button>
			</div>
		</div>
	</form>
	
	<span style="color:red;"></span>
	
</div>	
</body>
</html>