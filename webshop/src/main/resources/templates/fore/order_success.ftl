

<!DOCTYPE html>
<html>
<head>
	<title>支付成功</title>
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
			<#if msg??>
				<div class="alert alert-success">${msg}</div>
			</#if>

			
			<p><a class="btn btn-success" href="/fore/orderCenter">查看我的订单</a></p>
		</div>
	</div>
	<!--//cart-items-->






<!--footer-->
        <#include "footer.html">
<!--//footer--></body>


</body>
</html>