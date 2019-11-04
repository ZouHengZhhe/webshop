

<!DOCTYPE html>
<html>
<head>
	<title>商品详情</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="../../static/fore/css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="../../static/fore/css/style.css">
	<link type="text/css" rel="stylesheet" href="../../static/fore/css/flexslider.css">
	<script type="text/javascript" src="../../static/fore/js/jquery.min.js"></script>
	<script type="text/javascript" src="../../static/fore/js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="../../static/fore/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../../static/fore/layer/layer.js"></script>
	<script type="text/javascript" src="../../static/fore/js/cart.js"></script>
	<script>
		$(function() {
		  $('.flexslider').flexslider({
			animation: "slide",
			controlNav: "thumbnails"
		  });
		});
	</script>
</head>
<body>

	<!--header-->
	<#assign flag="1">
	<#include "header.ftl">
	
	<!--//single-page-->
	<div class="single">
		<div class="container">
			<div class="single-grids">				
				<div class="col-md-4 single-grid">		
					<div class="flexslider">
						
						<ul class="slides">
							<li data-thumb="../../static/fore/${goodsDetail.goods.cover}">
								<div class="thumb-image"> <img src="../../static/fore/${goodsDetail.goods.cover}" data-imagezoom="true" class="img-responsive"> </div>
							</li>
							<li data-thumb="../../static/fore/${goodsDetail.goods.image1}">
								 <div class="thumb-image"> <img src="../../static/fore/${goodsDetail.goods.image1}" data-imagezoom="true" class="img-responsive"> </div>
							</li>
							<li data-thumb="../../static/fore/${goodsDetail.goods.image2}">
							   <div class="thumb-image"> <img src="../../static/fore/${goodsDetail.goods.image2}" data-imagezoom="true" class="img-responsive"> </div>
							</li> 
						</ul>
					</div>
				</div>	
				<div class="col-md-4 single-grid simpleCart_shelfItem">		
					<h3>${goodsDetail.goods.name}</h3>
					<div class="tag">
						<p>分类 : <a href="goods.action?typeid=5">经典系列</a></p>
					</div>
					<p>${goodsDetail.goods.intro}</p>
					<div class="galry">
						<div class="prices">
							<h5 class="item_price">¥ ${goodsDetail.goods.price}</h5>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="btn_form">
						<a href="javascript:;" class="add-cart item_add" onclick="buy(6)">加入购物车</a>	
					</div>
				</div>
				<div class="col-md-4 single-grid1">
					<!-- <h2>商品分类</h2> -->
					<ul>
                        <a href="/fore/goodsList">全部系列</a></li>
							<#list typesList as list>
								<li><a href="/fore/goodsList?id=${list.id}&pageNo=1">${list.name}</a></li>
							</#list>
						
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	
	<!--related-products--><!-- 
	<div class="related-products">
		<div class="container">
			<h3>猜你喜欢</h3>
			<div class="product-model-sec single-product-grids">
				<div class="product-grid single-product">
					<a href="single.html">
					<div class="more-product"><span> </span></div>						
					<div class="product-img b-link-stripe b-animate-go  thickbox">
						<img src="images/m1.png" class="img-responsive" alt="">
						<div class="b-wrapper">
						<h4 class="b-animate b-from-left  b-delay03">							
						<button>View</button>
						</h4>
						</div>
					</div>
					</a>					
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>Product #1</h4>								
							<span class="item_price">$2000</span>
							<div class="ofr">
							  <p class="pric1"><del>$2300</del></p>
							  <p class="disc">[15% Off]</p>
							</div>
							<div class="clearfix"> </div>
						</div>												
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
 -->	<!--related-products-->

	<!--footer-->
	<#include "footer.html">


</body>
</html>