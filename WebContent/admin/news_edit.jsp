<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>资讯编辑</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container">

	<%@include file="header.jsp"%>

	<br><br>
	<form class="form-horizontal" action="newsUpdate.action" method="post" enctype="multipart/form-data">
		
		<input type="hidden" name="page" value="${param.page}"/>
		<input type="hidden" name="news.id" value="${news.id}">
		<input type="hidden" name="news.imag" value="${news.imag}"/>			
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">标题</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="news.title" value="${news.title}" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="input_content" class="col-sm-1 control-label">内容</label>
			<div class="col-sm-6">
				<textarea class="form-control" rows="3" name="news.content">${news.content}</textarea>
			</div>
		</div>
			<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">插图</label> 
			<div class="col-sm-6"><img src="../${news.imag}" class="img-responsive"/>
				<input type="file" name="photo"  id="input_file">
			</div>
		</div>
	
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">提交</button>
			</div>
		</div>
	</form>
</div>	
</body>
</html>