<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>文章列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container">

	<%@include file="header.jsp" %>
	
	<br>
		<form class="form-inline" action="essaySearch.action" id="serchform" method="post">
		<div class="form-group">
			<label for="id">ID: </label>
			<input type="text" class="form-control" id="id" name="essay.id">
		</div>
		<a href="javascript:;" onclick="document.getElementById('serchform').submit();" type="submit" class="btn btn-default">点击搜索</a>
	</form>
	
		<div class="text-right">
					<a class="btn btn-success"href="essayAdd.action">添加文章</a>
 	   </div>
	
	<br>

	<table class="table table-bordered table-hover" style=“table-layout: fixed;”>

	<tr>
		<th width="5%">ID</th>
		<th width="15%">标题</th>
		<th width="50%">内容</th>
		<th width="10%">插图</th>
		<th width="10%">添加时间<br>修改时间</th>
		<th width="10%">操作</th>
	</tr>
	
	<c:forEach var="item" items="${essayList}">
         <tr>
         	<td>${item.id }</td>
         	<td>${item.title }</td>
         	<td>${item.content }</td>
         	<td><p><a href="../index/detail.action?essayid=${item.id}" target="_blank"><img src="../${item.imag}" width="100px"></a></p></td>
         	<td>${item.time }<br>${item.updatetime }</td>
			<td>
				<p><a class="btn btn-primary" href="essayEdit.action?id=${item.id }">修改</a></p>
				<p><a class="btn btn-danger" href="essayDelete.action?essay.id=${item.id }">删除</a></p>
			</td>
       	</tr>
     </c:forEach>
     
</table>

<br>${pageHtml}<br>
</div>
</body>
</html>