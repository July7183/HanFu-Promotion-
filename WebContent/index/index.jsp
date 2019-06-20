<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

<title>汉服——古韵记</title>
</head>
<body>

<div class="wrap">
<s:action name="header" executeResult="true"/>
	<div class="main">
		<div class="content">
			<div class="section group">
			
			
			
<div class="container">
		<input type="radio" name="slides" id="slide1" checked>
		<input type="radio" name="slides" id="slide2">
		<input type="radio" name="slides" id="slide3">
		<input type="radio" name="slides" id="slide4">
		<input type="radio" name="slides" id="slide5">
		<input type="radio" name="slides" id="slide6">
		
		<div class="slider">
			<s:iterator value="#request.carouselList" status="st">
			<div class="img img${st.index+1}">
				<div class="frag frag1" style="background-image: url('../${imag}')"></div>
				<div class="frag frag2" style="background-image: url('../${imag}')"></div>
				<div class="frag frag3" style="background-image: url('../${imag}')"></div>
				<div class="frag frag4" style="background-image: url('../${imag}')"></div>
				<div class="frag frag5" style="background-image: url('../${imag}')"></div>
				<div class="frag frag6" style="background-image: url('../${imag}')"></div>
			</div>
			</s:iterator>
		</div> <!-- koniec slidera -->
		<div class="side-controls">
			<label for="slide1"></label>
			<label for="slide2"></label>
			<label for="slide3"></label>
			<label for="slide4"></label>
			<label for="slide5"></label>
			<label for="slide6"></label>
		</div>
		<div class="controls">
			<label for="slide1"></label>
			<label for="slide2"></label>
			<label for="slide3"></label>
			<label for="slide4"></label>
			<label for="slide5"></label>
			<label for="slide6"></label>
		</div>
	</div>
</div>
			
			
				<div class="content_top">
				<div class="heading">
					<h3>资讯推荐</h3>
				</div>
				<div class="clear"></div>
			</div>
		<div class="fenlist">

			<ul>
						<!-- 用struts的iterator标签遍历news集合, 并去处每一个name显示 -->
						<s:iterator value="#request.newses">
						<li>						
							<a href="newsmodel.action?id=<s:property value="id"/>">
							<span><s:date name="time" format="yyyy-MM-dd hh:mm:ss"/></span>
							<s:property value="title"/></a>	
							
						</li>
						</s:iterator>
			</ul>		
			</div>	
		
			
				<div class="content_bottom">
				<div class="heading">
					<h3>知识推荐</h3>
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
		
		
		<div class="content_bottom">
				<div class="heading">
					<h3>文章推荐</h3>
				</div>
				<div class="clear"></div>
			</div>
	      <div class="fenlist">
			<ul>
						<!-- 用struts的iterator标签遍历essay集合, 并去处每一个name显示 -->
						<s:iterator value="#request.essayes">
						<li>						
							<a href="essaymodel.action?id=<s:property value="id"/>">
							<span><s:date name="time" format="yyyy-MM-dd hh:mm:ss"/></span>
							<s:property value="title"/></a>	
							
						</li>
						</s:iterator>
			 </ul>
		     <br>
			 <div class="page-no">${pageHtml}</div>				
				<div class="clear"></div>
		</div>	
		
		
		
		
		
		
				<div class="content_bottom">
				<div class="heading">
					<h3>精品推荐</h3>
				</div>
				<div class="clear"></div>
			</div>
			
			<div class="section group">
			
				<s:iterator value="showList" status="status">
					<div class="listview_1_of_2 images_1_of_2" <s:if test="#status.count%4==1">style="margin-left: 0;"</s:if>>
						<div class="listimg listimg_2_of_1">
							 <a href="detail.action?productid=<s:property value="product.id"/>">
								<img src="../<s:property value="product.cover"/>" alt="<s:property value="product.name"/>"/>
							</a>
						</div>
						<div class="text list_2_of_1">
							<h3><a href="detail.action?productid=<s:property value="product.id"/>"><s:property value="product.name"/></a></h3>
							<p><s:property value="showtext"/></p>
							<p><span style="color:red;">￥<s:property value="product.price"/></span></p>
							<div class="button">
								<s:if test="product.stock>0"><span><a href="javascript:buy(<s:property value="product.id"/>);">加入购物车</a></span></s:if>
								<s:else><span><a style="background:#ccc;color:red;">库存不足</a></span></s:else>
							</div>
					   </div>
				   </div>	
				</s:iterator>
				<div class="clear"></div>
			</div>
		
		
    	</div>
	</div>

<jsp:include page="footer.jsp"/>

</div>

</body>
</html>