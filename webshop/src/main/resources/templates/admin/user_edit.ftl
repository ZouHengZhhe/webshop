
<!DOCTYPE html>
<html>
<head>
<title>客户修改</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="../../static/admin/css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">


	<#include "header.html">

	<br><br>
	
	<form class="form-horizontal" action="/admin/user_edit" method="post">
		<input type="hidden" name="username" value="${username}">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">用户名</label>
			<div class="col-sm-5">${username}</div>
		</div>
        <div class="form-group">
            <label for="input_name" class="col-sm-1 control-label">收货人</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="input_name" name="name" value="${name}">
            </div>
        </div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">电话</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="phone" value="${phone}">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">地址</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="address" value="${address}">
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