<!DOCTYPE html>
<html>

<head>
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="../../static/fore/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="../../static/fore/css/style.css">
    <script type="text/javascript" src="../../static/fore/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/fore/js/bootstrap.min.js"></script>
<#--<script type="text/javascript" src="js/simpleCart.min.js"></script>--></head>

<body>
<!--header-->
    <#assign flag="5">
      <#include "header.ftl">
<!--//header-->
<!--account-->
<div class="account">
    <div class="container">
        <div class="register">
              <#if msg??>
                <div class="alert alert-success">${msg}</div></#if>
              <#if failMsg??>
                <div class="alert alert-danger">${failMsg}!</div></#if>
            <form action="/fore/login" method="post">
                <div class="register-top-grid">
                    <h3>用户登录</h3>
                    <div class="input">
                    <span>用户名/邮箱
                      <label style="color:red;">*</label></span>
                        <input type="text" name="ue" placeholder="请输入用户名" required="required"></div>
                    <div class="input">
                    <span>密码
                      <label style="color:red;">*</label></span>
                        <input type="text" name="password" placeholder="请输入密码" required="required"></div>
                    <div class="clearfix"></div>
                </div>
                <div class="register-but text-center">
                    <input type="submit" value="提交">
                    <div class="clearfix"></div>
                </div>
            </form>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--//account-->
<!--footer-->
        <#include "footer.html">
<!--//footer--></body>

</html>