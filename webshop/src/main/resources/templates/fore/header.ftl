<!--header-->
<div class="header">
    <div class="container">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <h1 class="navbar-brand">
                    <a href="/fore/index">蛋糕店</a></h1>
            </div>
            <!--navbar-header-->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/fore/index" <#if flag="1">class="active"</#if>>首页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle <#if flag=" 2 ">active</#if>" data-toggle="dropdown">商品分类
                            <b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-2">
                            <li>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <h4>商品分类</h4>
                                        <ul class="multi-column-dropdown">
                                            <a class="list" href="/fore/goodsList">全部系列</a></li>
              <#list typesList as list>
                <li>
                    <a class="list" href="/fore/goodsList?id=${list.id}&pageNo=1">${list.name}</a></li>
              </#list>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="/fore/goodsRecommendList?typeId=2&pageNumber=1" <#if flag=="3" &&typeId==2>class="active"</#if>>热销</a></li>
                    <li>
                        <a href="/fore/goodsRecommendList?typeId=3&pageNumber=1" <#if flag=="3" &&typeId==3>class="active"</#if>>新品</a></li>
          <#if user??>
            <li><a href="/fore/orderCenter" <#if flag=="6">class="active"</#if>>我的订单</a></li>
            <li><a href="/fore/toCenter" <#if flag=="4">class="active"</#if>>个人中心</a></li>
            <li><a href="/fore/logout" <#if flag=="5">class="active"</#if>>退出</a></li>
          <#else>
            <li>
                <a href="/fore/toRegister" <#if flag=="4">class="active"</#if>>注册</a></li>
            <li>
                <a href="/fore/toLogin" <#if flag=="5">class="active"</#if>>登录</a></li>
          </#if>
            <#if user??&&user.isadmin==true>
              <li>
                  <a href="../admin.jsp" target="_blank">后台管理</a></li>
            </#if>
                </ul>
                <!--/.navbar-collapse--></div>
            <!--//navbar-header--></nav>
        <div class="header-info">
            <div class="header-right search-box">
                <a href="javascript:;">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </a>
                <div class="search">
                    <form class="navbar-form" action="search.action">
                        <input type="text" class="form-control" name="name">
                        <button type="submit" class="btn btn-default" aria-label="Left Align">搜索</button></form>
                </div>
            </div>
            <div class="header-right cart">
                <a href="/fore/toGoodsCart">
          <#--<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true">-->
            <#--<span class="card_num"><#if order??>${order.amount}<#else>0</#if></span>-->
          <#--</span>-->
              <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true">
                  <span class="card_num"><#if order??>${order.amount}<#else>0</#if></span>
              </span>
                </a>
            </div>
            <div class="header-right login">
                <a href="my.action">
                    <span class="glyphicon" aria-hidden="true"></span>
                </a>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>

<!--//header-->