

<!DOCTYPE html>
<html>
<head>
	<title>个人中心</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="../../static/fore/css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="../../static/fore/css/style.css">
	<script type="text/javascript" src="../../static/fore/js/jquery.min.js"></script>
	<script type="text/javascript" src="../../static/fore/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/simpleCart.min.js"></script>
</head>
<body>

	





	<!--header-->
	<#assign flag="0">
	<#include "header.ftl">
	<!--//header-->

	
	<!--account-->
	<div class="account">
		<div class="container">
			<div class="register">
				
				<form action="my.action" method="post"> 
					<input type="hidden" name="user.id" value="1">
					<div class="register-top-grid">
						<h3>个人中心</h3>
						
						<h4>收货信息</h4>
						<div class="input">
							<span>收货人<label></label></span>
							<input type="text" name="user.name" value="${user.name}" placeholder="请输入收货">
						</div>
						<div class="input">
							<span>收货电话</span>
							<input type="text" name="user.phone" value="${user.phone}" placeholder="请输入收货电话">
						</div>
						<div class="input">
							<span>收货地址</span>
							<input type="text" name="user.address" value="${user.address}" placeholder="请输入收货地址">
						</div>
						<div class="register-but text-center">
						   <input type="submit" value="提交">
						</div>	
						<hr>
						<h4>安全信息</h4>
						<div class="input">
							<span>原密码</span>
							<input type="text" name="user.password" placeholder="请输入原密码"> 
						</div>
						<div class="input">
							<span>新密码</span>
							<input type="text" name="user.passwordNew" placeholder="请输入新密码"> 
						</div>
						<div class="clearfix"> </div>
						<div class="register-but text-center">
						   <input type="submit" value="提交">
						</div>	
					</div>
				</form>
				<div class="clearfix"> </div>
			</div>
	    </div>
	</div>
	<!--//account-->

	




	<!--footer-->
	<div class="footer">
		<div class="container">
			<div class="text-center">
				<p>SiKi学院 www.sikiedu.com © All rights Reseverd</p>
	   		</div>
		</div>
	</div>
	<!--//footer-->

	
</body>
</html>