<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汉服美文</title>
</head>
<body>

<div class="wrap">

<s:action name="header" executeResult="true"/>

	<div class="main">
		<div class="content">
		<div class="content_bottom">
				<div class="heading">
					<h3>详细内容</h3>
				</div>
				<div class="clear"></div>
			</div>
			<br>
			<div class="section group">			
						<table><!-- 使用struts标签来获取数据 -->
						
						<tr><th align="center"><font size="6"><s:property value="#request.essay.title"/></font></th></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td align="center"><s:date name="#request.essay.time" format="yyyy-MM-dd hh:mm:ss"/></td></tr>
						<tr><td>&nbsp;</td></tr>
						<tr><td><s:property value="#request.essay.content"/></td></tr>
						<tr><td>&nbsp;</td></tr>
						<td align="center"><p><a href="../index/detail.action?essayid=${essay.id}" target="_blank"><img src="../${essay.imag}" ></a></p></td>
					
					
					
					</table>
				
			
			</div>	
				<div class="clear"></div>	
	</div>
    	
	</div>

<jsp:include page="footer.jsp"/>

</div>

</body>
</html>