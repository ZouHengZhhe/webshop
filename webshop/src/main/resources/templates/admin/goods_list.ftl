
<!DOCTYPE html>
<html>
<head>
<title>商品列表</title>
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

	<div class="text-right"><a class="btn btn-warning" href="/admin/toGoodsAdd">添加商品</a></div>

	<br>
		
	<ul role="tablist" class="nav nav-tabs">
        <li <#if typeId==0>class="active"</#if> role="presentation"><a href="/admin/goods_list?typeId=0&pageNo=1">全部商品</a></li>
        <li <#if typeId==1>class="active"</#if>  role="presentation"><a href="/admin/goods_list?typeId=1&pageNo=1">条幅推荐</a></li>
        <li <#if typeId==2>class="active"</#if>  role="presentation"><a href="/admin/goods_list?typeId=2&pageNo=1">热销推荐</a></li>
        <li <#if typeId==3>class="active"</#if>  role="presentation"><a href="/admin/goods_list?typeId=3&pageNo=1">新品推荐</a></li>
    </ul>
    
    
    
    
	
	<br>

	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="10%">图片</th>
		<th width="10%">名称</th>
		<th width="20%">介绍</th>
		<th width="10%">价格</th>
		<th width="10%">类目</th>
		<th width="25%">操作</th>
	</tr>
	
		<#if page??>
			<#list page.list as goods>
				<tr>
                    <td><p>${goods.id}</p></td>
                    <td><p><a href="../index/detail.action?goodid=180" target="_blank"><img src="${goods.coverUrl}" width="100px" height="100px"></a></p></td>
                    <td><p><a href="../index/detail.action?goodid=180" target="_blank">${goods.name}</a></p></td>
                    <td><p>${goods.intro}</p></td>
                    <td><p>${goods.price}</p></td>
                    <td><p>${goods.typeName}</p></td>
                    <td>
                        <p>
                            <#if typeId==0>
                                <a class="btn btn-primary" href="/admin/goods_join?goodsId=${goods.id}&typeId=1">加入条幅</a>
                                <a class="btn btn-primary" href="/admin/goods_join?goodsId=${goods.id}&typeId=2">加入热销</a>
                                <a class="btn btn-primary" href="/admin/goods_join?goodsId=${goods.id}&typeId=3">加入新品</a>
                            <#elseif typeId==1>
                                <a class="btn btn-info" href="/admin/goods_remove?goodsId=${goods.id}&typeId=1">移出条幅</a>
                                <a class="btn btn-primary" href="/admin/goods_join?goodsId=${goods.id}&typeId=2">加入热销</a>
                                <a class="btn btn-primary" href="/admin/goods_join?goodsId=${goods.id}&typeId=3">加入新品</a>
                            <#elseif typeId==2>
                                <a class="btn btn-primary" href="/admin/goods_join?goodsId=${goods.id}&typeId=1">加入条幅</a>
                                <a class="btn btn-info" href="/admin/goods_remove?goodsId=${goods.id}&typeId=2">移出热销</a>
                                <a class="btn btn-primary" href="/admin/goods_join?goodsId=${goods.id}&typeId=3">加入新品</a>
                            <#elseif typeId==3>
                                <a class="btn btn-primary" href="/admin/goods_join?goodsId=${goods.id}&typeId=1">加入条幅</a>
                                <a class="btn btn-primary" href="/admin/goods_join?goodsId=${goods.id}&typeId=2">加入热销</a>
                                <a class="btn btn-info" href="/admin/goods_remove?goodsId=${goods.id}&typeId=3">移出新品</a>
                            </#if>

                        </p>
                        <a class="btn btn-success" href="/admin/toGoodsEdit?id=${goods.id}">修改</a>
                        <a class="btn btn-danger" href="/admin/goods_del?id=${goods.id}">删除</a>
                    </td>
                </tr>
			</#list>
		</#if>
     
     
</table>

<br>
<#--分页-->
        <#assign url="/admin/goods_list",param="&typeId=${typeId}">
        <#include "../page.ftl">
<br>
</div>
</body>
</html>