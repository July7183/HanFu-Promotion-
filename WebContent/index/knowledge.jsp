<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汉服知识</title>
</head>
<body>

<div class="wrap">

<s:action name="header" executeResult="true"/>

	<div class="main">
		<div class="content">
		<div class="content_bottom">
				<div class="heading">
					<h3>全部知识点</h3>
				</div>
				<div class="clear"></div>
			</div>
			
			<div class="fenlist">

			<ul>
						<!-- 用struts的iterator标签遍历knowledge集合, 并去处每一个name显示 -->
						<s:iterator value="#request.knowledgees">
						<li>						
							<a href="knowledgemodel.action?id=<s:property value="id"/>">
							<span><s:date name="time" format="yyyy-MM-dd hh:mm:ss"/></span>
							<s:property value="title"/></a>	
							
						</li>
						</s:iterator>
			</ul>
		<br>
				<div class="page-no">${pageHtml}</div>
				
				<div class="clear"></div>
			</div>	
				<div class="clear"></div>	
	</div>
    	
	</div>

<jsp:include page="footer.jsp"/>

</div>

</body>
</html>