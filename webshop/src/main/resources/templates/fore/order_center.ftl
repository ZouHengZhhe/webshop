<!DOCTYPE html>
<html>
<head>
	<title>我的订单</title>
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
    <#assign flag="6">
      <#include "header.ftl">
<!--//header-->

	
	<!--cart-items-->
	<div class="cart-items">
		<div class="container">
		
		
		
			<h2>我的订单</h2>
			
				<table class="table table-bordered table-hover">

				<tr>
					<th width="10%">ID</th>
					<th width="10%">总价</th>
					<th width="20%">商品详情</th>
					<th width="20%">收货信息</th>
					<th width="10%">订单状态</th>
					<th width="10%">支付方式</th>
					<th width="10%">下单时间</th>
					<th width="10%">操作</th>
				</tr>
					<#list orderList as order>
						<tr>
                            <td><p>${order.id}</p></td>
                            <td><p>${order.total}</p></td>
                            <td>
								<#list order.itemList as item>
									<p>${item.goods.name}(${item.price}) x ${item.amount}</p>
								</#list>
                            </td>
                            <td>
                                <p>${order.address}</p>
                            </td>
                            <td>
                                <p>
									<#if order.status==1>
										<span style="color:#46b8da;">未付款</span>
									<#elseif order.status==2>
										<span style="color:red;">已付款</span>
									<#elseif order.status==3>
										<span style="color:green;">已发货</span>
									<#elseif order.status==4>
										<span style="color:black;">已完成</span>
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
                            <td><p>${order.datetime}</p></td>
                            <td>

                            </td>
                        </tr>
					</#list>
			</table>
		</div>
	</div>
	<!--//cart-items-->	

	<!--footer-->
	<#include "footer.html">
	<!--//footer-->


</body>
</html>