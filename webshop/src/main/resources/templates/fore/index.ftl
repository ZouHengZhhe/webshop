<!DOCTYPE html>
<html>
<head>
	<title>商品列表</title>
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
	<#--头部-->
    <#assign flag="1">
	<#include "header.ftl">
	
	<!--banner-->
	
		<div class="banner">
			<div class="container">
				<h2 class="hdng"><a href="/fore/goodsDetail?goodsId=${scrollGoodsMap.id}">${scrollGoodsMap.name}</a><span></span></h2>
				<p>今日精选推荐</p>
				<a class="banner_a" href="javascript:;" onclick="buy(${scrollGoodsMap.id})">立刻购买</a>
				<div class="banner-text">		
					<a href="/fore/goodsDetail?goodsId=${scrollGoodsMap.id}">
						<img src="${scrollGoodsMap.coverUrl}" alt="${scrollGoodsMap.name}" width="350" height="350">
					</a>	
				</div>
			</div>
		</div>
				
	<!--//banner-->
	
	<div class="subscribe2"></div>
	
	<!--gallery-->
	<div class="gallery">
		<div class="container">
			<div class="alert alert-danger">热销推荐</div>
			<div class="gallery-grids">

				<#list hotGoodsList as item>
                    <div class="col-md-4 gallery-grid glry-two">
                        <a href="/fore/goodsDetail?goodsId=${item.id}">
                            <img src="${item.coverUrl}" class="img-responsive" alt="${item.name}" width="350" height="350"/>
                        </a>
                        <div class="gallery-info galrr-info-two">
                            <p>
                                <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                                <a href="/fore/goodsDetail?goodsId=${item.id}">查看详情</a>
                            </p>
                            <a class="shop" href="javascript:;" onclick="buy(${item.id})">立刻购买</a>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="galy-info">
                            <p>${item.typename} > ${item.name}</p>
                            <div class="galry">
                                <div class="prices">
                                    <h5 class="item_price">¥ ${item.price}</h5>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
				</#list>

			</div>
			
			<div class="clearfix"></div>
			<div class="alert alert-info">新品推荐</div>
			<div class="gallery-grids">	

				<#list newGoodsList as newGoods>
                    <div class="col-md-3 gallery-grid ">
                        <a href="/fore/goodsDetail?goodsId=${newGoods.id}">
                            <img src="${newGoods.coverUrl}" class="img-responsive" alt="${newGoods.name}"/>
                        </a>
                        <div class="gallery-info">
                            <p>
                                <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                                <a href="/fore/goodsDetail?goodsId=${newGoods.id}">查看详情</a>
                            </p>
                            <a class="shop" href="javascript:;" onclick="buy(${newGoods.id})">立刻购买</a>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="galy-info">
                            <p>${newGoods.typename} > ${newGoods.name}</p>
                            <div class="galry">
                                <div class="prices">
                                    <h5 class="item_price">¥ ${newGoods.price}</h5>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
				</#list>


			</div>	
		</div>
	</div>
	<!--//gallery-->
	
	<!--subscribe-->
	<div class="subscribe"></div>
	<!--//subscribe-->
	

	<#--尾部-->
	<#include "footer.html">

</body>
</html>