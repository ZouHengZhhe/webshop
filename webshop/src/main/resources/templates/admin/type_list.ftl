
<!DOCTYPE html>
<html>
<head>
<title>类目列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="../../static/admin/css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">

	
<#include "header.html">

	    <#if RequestParameters["msg"]??>
                <div class="alert alert-success">${RequestParameters["msg"]}</div></#if>
              <#if failMsg??>
                <div class="alert alert-danger">${failMsg}!</div></#if>

	<br>
	
	<div>
		<form class="form-inline" method="post" action="/admin/type_add">
			<input type="text" class="form-control" id="input_name" name="name" placeholder="输入类目名称" required="required" style="width: 500px">
			<input type="submit" class="btn btn-warning" value="添加类目"/>
		</form>
	</div>
	
	<br>

	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="10%">名称</th>
		<th width="10%">操作</th>
	</tr>

		<#if typeList??>
			<#list typeList as type>
			<tr>
                <td><p>${type.id}</p></td>
                <td><p>${type.name}</p></td>
                <td>
                    <a class="btn btn-primary" href="/admin/toTypeEdit?id=${type.id}&name=${type.name}">修改</a>
                    <a class="btn btn-danger" href="/admin/type_del?id=${type.id}">删除</a>
                </td>
            </tr>
			</#list>
		</#if>
</table>

</div>
</body>
</html>