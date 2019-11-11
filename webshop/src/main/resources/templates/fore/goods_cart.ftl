<!DOCTYPE html>
<html>

<head>
    <title>购物车</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="../../static/fore/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="../../static/fore/css/style.css">
    <script type="text/javascript" src="../../static/fore/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/fore/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../static/fore/layer/layer.js"></script>
    <script type="text/javascript" src="../../static/fore/js/cart.js"></script>
</head>

<body>
<!--header-->
    <#assign flag="0">
      <#include "header.ftl">
<!--//header-->
<!--cart-items-->
<div class="cart-items">
    <div class="container">
        <h2>我的购物车</h2>
            <#if order??>
				<#if order.itemMap??>
					<#list order.itemMap?keys as key>
                  <div class="cart-header col-md-6">
                      <div class="cart-sec simpleCart_shelfItem">
                          <div class="cart-item cyc">
                              <a href="/fore/goodsDetail?goodsId=${order.itemMap[key].goods_id}">
                                  <img src="../../static/fore/${order.itemMap[key].goods.cover}" class="img-responsive"></a>
                          </div>
                          <div class="cart-item-info">
                              <h3>
                                  <a href="/fore/goodsDetail?goodsId=${order.itemMap[key].goods_id}">${order.itemMap[key].goods.name}</a></h3>
                              <h3>
                                  <span>单价: ¥ ${order.itemMap[key].goods.name}</span></h3>
                              <h3>
                                  <span>数量: ${order.itemMap[key].amount}</span></h3>
                              <a class="btn btn-info" href="javascript:buy(${order.itemMap[key].goods_id});">增加</a>
                              <a class="btn btn-warning" href="javascript:lessen(${order.itemMap[key].goods_id});">减少</a>
                              <a class="btn btn-danger" href="javascript:deletes(${order.itemMap[key].goods_id});">删除</a></div>
                          <div class="clearfix"></div>
                      </div>
                  </div>
					</#list>
				</#if>
			</#if>
        <div class="cart-header col-md-12">
            <hr>
            <h3>订单总金额: ¥
                <#if order??>${order.total}
				<#else>0</#if></h3>
            <a class="btn btn-success btn-lg" style="margin-left:74%" href="/fore/orderSubmit">提交订单</a></div>
    </div>
</div>
<!--//cart-items-->
<!--footer-->
        <#include "footer.html">
<!--//footer--></body>

</html>