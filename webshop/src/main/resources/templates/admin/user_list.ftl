
<!DOCTYPE html>
<html>
<head>
<title>客户列表</title>
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
	<div class="text-right"><a class="btn btn-warning" href="/admin/toUserAdd">添加客户</a></div>
		
	<br>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="10%">用户名</th>
        <th width="10%">邮箱</th>
        <th width="10%">收货人</th>
		<th width="10%">电话</th>
		<th width="10%">地址</th>
		<th width="10%">操作</th>
	</tr>
	
	<#if page??>
        <#list page.list as user>
            <tr>
                <td><p>${user.id}</p></td>
                <td><p>${user.username}</p></td>
                <td><p>${user.email}</p></td>
                <td><p>${user.name}</p></td>
                <td><p>${user.phone}</p></td>
                <td><p>${user.address}</p></td>
                <td>
                    <a class="btn btn-info" href="/admin/toResetPwd?username=${user.username}&email=${user.email}">重置密码</a>
                    <a class="btn btn-primary" href="/admin/toUserEdit?username=${user.username}&name=${user.name}&phone=${user.phone}&address=${user.address}">修改</a>
                    <a class="btn btn-danger" href="/admin/user_del?id=${user.id}">删除</a>
                </td>
            </tr>
        </#list>
    </#if>


     
     
</table>

<br>
<#--分页-->
        <#assign url="/admin/user_list",param="">
        <#include "../page.ftl">
<br>
</div>
</body>
</html>