<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>轮播图列表</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container">

	<%@include file="header.jsp" %>
	
	
	<br>
	<br>
	<br>

	<table class="table table-bordered table-hover" style=“table-layout: fixed;”>

	<tr align="center">
		<th width="5%">ID</th>
		<th width="75%">插图</th>
		<th width="20%">编辑</th>
		 
	</tr>
	
	<c:forEach var="item" items="${carouselList}">
         <tr>
         	<td>${item.id }</td>
         	<td><p><a href="../index/detail.action?carouselid=${item.id}" target="_blank"><img src="../${item.imag}" width="710"></a></p></td>
         	<td>
         	<form class="form-horizontal" action="carouselUpdate.action" method="post" enctype="multipart/form-data">
			 <p>  <input type="hidden" name="id" value="${item.id}">
			 <input type="file" name="photo" id="input_file" required="required"></p>
			 <p>  <button type="submit" class="btn btn-success" >提交保存</button></p>
			</form>
			</td>
			
       	</tr>
     </c:forEach>
     
</table>

<br>${pageHtml}<br>
</div>
</body>
</html>