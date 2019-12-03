


<!DOCTYPE html>
<html>
<head>
<title>订单列表</title>
<link rel="stylesheet" href="../../static/admin/css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">

	
<#include "header.html">
	
	<br>
	
	<ul role="tablist" class="nav nav-tabs">
        <li <#if orderStatus==0>class="active"</#if> role="presentation"><a href="/admin/order_list?orderStatus=0">全部订单</a></li>
        <li <#if orderStatus==1>class="active"</#if>  role="presentation"><a href="/admin/order_list?orderStatus=1">未付款</a></li>
        <li <#if orderStatus==2>class="active"</#if>  role="presentation"><a href="/admin/order_list?orderStatus=2">已付款</a></li>
        <li <#if orderStatus==3>class="active"</#if>  role="presentation"><a href="/admin/order_list?orderStatus=3">配送中</a></li>
        <li <#if orderStatus==4>class="active"</#if>  role="presentation"><a href="/admin/order_list?orderStatus=4">已完成</a></li>
    </ul>
    
    <br>
	
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="5%">总价</th>
		<th width="15%">商品详情</th>
		<th width="20%">收货信息</th>
		<th width="10%">订单状态</th>
		<th width="10%">支付方式</th>
		<th width="10%">下单用户</th>
		<th width="10%">下单时间</th>
		<th width="10%">操作</th>
	</tr>

        <#if page??>
            <#list page.list as order>
                <tr>
    <td><p>${order.id}</p></td>
    <td><p>${order.total}</p></td>
    <td>
<#list order.itemList as item>
    <p>${item.goodsName}(${item.price}) x ${item.amount}</p>
</#list>
    </td>
    <td>
        ${order.address}
    </td>
    <td>
        <p>
            <#if order.status==1>
                <span style="color:burlywood;">未付款</span>
            <#elseif order.status==2>
                <span style="color:red;">已付款</span>
            <#elseif order.status==3>
                <span style="color:green;">配送中</span>
            <#elseif order.status==4>
                <span style="color:gray;">已完成</span>
            </#if>



        </p>
    </td>
    <td>
        <p>
            <#if order.paytype==1>
                微信
            <#elseif order.paytype==2>
                支付宝
            <#elseif order.paytype==3>
                货到付款
            </#if>
        </p>
    </td>
    <td><p>${order.username}</p></td>
    <td><p>${order.datetime}</p></td>
    <td>
        <#if order.status==1>
                <a class="btn btn-primary" href="/admin/order_status?id=${order.id}&orderStatus=2">待付</a>
        <#elseif order.status==2>
                <a class="btn btn-success" href="/admin/order_status?id=${order.id}&orderStatus=3">发货</a>
        <#elseif order.status==3>
                <a class="btn btn-warning" href="/admin/order_status?id=${order.id}&orderStatus=4">完成</a>
        </#if>

        <a class="btn btn-danger" href="/admin/order_del?id=${order.id}&pageNo=${page.pageNumber}&orderStatus=${orderStatus}">删除</a>
    </td>
</tr>
            </#list>
        </#if>



     
</table>

<br>

    <#--<div style='text-align:center;'>-->
<#--<a class='btn btn-info' href='/admin/order_list?pageNo=${page.pageNumber+1}&status=${status}'>首页</a>-->
<#--<a class='btn btn-info' href='http://localhost:8080/test_cakeshop_jsp/admin/orderList.action?page=3'>上一页</a>-->
<#--<h2 style='display:inline;'>[4/5]</h2>-->
<#--<h2 style='display:inline;'>[42]</h2>-->
<#--<a class='btn btn-info' href='http://localhost:8080/test_cakeshop_jsp/admin/orderList.action?page=5'>下一页</a>-->
<#--<a class='btn btn-info' href='http://localhost:8080/test_cakeshop_jsp/admin/orderList.action?page=5'>尾页</a>-->
<#--<input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="http://localhost:8080/test_cakeshop_jsp/admin/orderList.action?page="+(this.previousSibling.value)+""'>GO</a>-->
<#--</div>-->

        <#--分页-->
        <#assign url="/admin/order_list",param="&orderStatus=${orderStatus}">
        <#include "../page.ftl">
<br>
</div>
</body>
</html>