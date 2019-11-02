

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
	<#include "header.ftl">
	
	<!--//single-page-->
	<div class="single">
		<div class="container">
			<div class="single-grids">				
				<div class="col-md-4 single-grid">		
					<div class="flexslider">
						
						<ul class="slides">
							<li data-thumb="picture/6-1.jpg">
								<div class="thumb-image"> <img src="../../static/fore/picture/6-1.jpg" data-imagezoom="true" class="img-responsive"> </div>
							</li>
							<li data-thumb="picture/6-2.jpg">
								 <div class="thumb-image"> <img src="../../static/fore/picture/6-2.jpg" data-imagezoom="true" class="img-responsive"> </div>
							</li>
							<li data-thumb="picture/6-3.jpg">
							   <div class="thumb-image"> <img src="../../static/fore/picture/6-3.jpg" data-imagezoom="true" class="img-responsive"> </div>
							</li> 
						</ul>
					</div>
				</div>	
				<div class="col-md-4 single-grid simpleCart_shelfItem">		
					<h3>夜礼服</h3>
					<div class="tag">
						<p>分类 : <a href="goods.action?typeid=5">经典系列</a></p>
					</div>
					<p>介绍: 空气中流动着的厚重巧克力气息,一切在夜色下坡上银装.可可野性的诱惑,加之朗姆酒的浪漫清冽,传递出来自神秘过度的魅惑与力量.
主口味:香浓巧克力 主要原料:黑巧克力,乳脂奶油,大黄油,朗姆酒,巧克力果仁脆,黑巧克力软糖 甜度:四星（满五星） 最佳食用温度：5-7摄氏度</p>
					<div class="galry">
						<div class="prices">
							<h5 class="item_price">¥ 299</h5>
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
						
							<li><a href="goods.action?typeid=5">经典系列</a></li>
						
							<li><a href="goods.action?typeid=4">法式系列</a></li>
						
							<li><a href="goods.action?typeid=3">儿童系列</a></li>
						
							<li><a href="goods.action?typeid=2">零食系列</a></li>
						
							<li><a href="goods.action?typeid=1">冰淇淋系列</a></li>
						
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