<!DOCTYPE html>
<html>

<head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="../../static/fore/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="../../static/fore/css/style.css">
    <script type="text/javascript" src="../../static/fore/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/fore/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/simpleCart.min.js"></script>
    <script type="text/javascript" src="../../static/fore/layer/layer.js"></script>
    <script type="text/javascript" src="../../static/fore/js/cart.js"></script>
</head>

<body>
    <#assign flag="3">
      <#include "header.ftl">
<!--products-->
<div class="products">
    <div class="container">
        <h2>${name}</h2>
        <div class="col-md-12 product-model-sec">
              <#list page.list as g>
                <div class="product-grid">
                    <a href="/fore/goodsDetail?goodsId=${g.id}">
                        <div class="more-product">
                            <span></span>
                        </div>
                        <div class="product-img b-link-stripe b-animate-go  thickbox">
                            <img src="../../static/fore/${g.cover}" class="img-responsive" alt="${g.name}" width="240" height="240">
                            <div class="b-wrapper">
                                <h4 class="b-animate b-from-left  b-delay03">
                                    <button>查看详情</button></h4>
                            </div>
                        </div>
                    </a>
                    <div class="product-info simpleCart_shelfItem">
                        <div class="product-info-cust prt_name">
                            <h4>${g.name}</h4>
                            <span class="item_price">¥ ${g.price}</span>
                            <input type="button" class="item_add items" value="加入购物车" onclick="buy(${g.id})">
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
			  </#list>
            <div class="clearfix"></div>
        </div>
        <div>
            <div style='text-align:center;'>
                <#if page.pageNumber==1>
                  <a class='btn btn-info' disabled>首页</a>
				<#else>
                    <a class='btn btn-info' href="/fore/goodsRecommendList?pageNumber=1&typeId=${typeId}">首页</a></#if>
                <#if page.pageNumber==1>
                  <a class='btn btn-info' disabled>上一页</a>
				<#else>
                    <a class='btn btn-info' href="/fore/goodsRecommendList?pageNumber=${page.pageNumber-1}&typeId=${typeId}">上一页</a></#if>
                <h3 style='display:inline;'>[${page.pageNumber}/${page.totalPage}]</h3>
                <h3 style='display:inline;'>[${page.totalCount}]</h3>
                <#if page.pageNumber==page.totalPage>
                  <a class='btn btn-info' disabled>下一页</a>
				<#else>
                    <a class='btn btn-info' href="/fore/goodsRecommendList?pageNumber=${page.pageNumber+1}&typeId=${typeId}">下一页</a></#if>
                <#if page.pageNumber==page.totalPage>
                  <a class='btn btn-info' disabled>尾页</a>
				<#else>
                    <a class='btn btn-info' href="/fore/goodsRecommendList?pageNumber=${page.totalPage}&typeId=${typeId}">尾页</a></#if>
                <input type='text' class='form-control' style='display:inline;width:60px;' value='' />
                <a class='btn btn-info' href='javascript:void(0);' onclick='location.href="/fore/goodsRecommendList?typeId=${typeId}&pageNumber="+(this.previousSibling.value)'>GO</a></div>
        </div>
    </div>
</div>
<!--//products-->
        <#include "footer.html"></body>

</html>