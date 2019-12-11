

<!DOCTYPE html>
<html>
<head>
<title>商品编辑</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="../../static/admin/css/bootstrap.css" />
</head>
<body>
<div class="container-fluid">
	
<#include "header.html">

	<br><br>
	<form class="form-horizontal" action="/admin/goods_edit" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${goods.id}"/>
		<input type="hidden" name="good.cover" value="/picture/14-1.jpg"/>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">名称</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="name" value="${goods.name}" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">价格</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="price" value="${goods.price}">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">介绍</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="intro" value="${goods.intro}">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">库存</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="stock" value="${goods.stock}">
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">封面图片</label> 
			<div class="col-sm-6"><img src="${goods.coverUrl}" width="100" height="100"/>
				<input type="file" name="cover"  id="input_file">推荐尺寸: 500 * 500
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">详情图片1</label> 
			<div class="col-sm-6"><img src="${goods.img1Url}" width="100" height="100"/>
				<input type="file" name="image1"  id="input_file">推荐尺寸: 500 * 500
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">详情图片2</label> 
			<div class="col-sm-6"><img src="${goods.img2Url}" width="100" height="100"/>
				<input type="file" name="image2"  id="input_file">推荐尺寸: 500 * 500
			</div>
		</div>
		<div class="form-group">
			<label for="select_topic" class="col-sm-1 control-label">类目</label>
			<div class="col-sm-6">
				<select class="form-control" id="select_topic" name="typeId">

					<#list types as type>
						<option <#if type.id==goods.type_id>selected="selected"</#if> value="${type.id}">${type.name}</option>
					</#list>
					
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交修改</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>