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
    <#--<script type="text/javascript" src="js/simpleCart.min.js"></script>-->
    <script type="text/javascript" src="../../static/fore/layer/layer.js"></script>
    <script type="text/javascript" src="../../static/fore/js/cart.js"></script>
</head>

<body>
    <#assign flag="2">
      <#include "header.ftl">
<!--products-->
<div class="products">
    <div class="container">
        <h2>${typeName}</h2>
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

        <#--分页-->
        <#assign url="/fore/goodsList",param="&id=${id}">
        <#include "../page.ftl">
    </div>
</div>


<!--//products-->
        <#include "footer.html">
</body>

</html>