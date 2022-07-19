<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.needle.FsoFso.product.dto.ProductDto"%>
<%
	List<ProductDto> productList = (List<ProductDto>) request.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
<%-- 
	<table border="1">
		<col width="100"><col width="100"><col width="100"><col width="100">
		<tr>
			<th>id</th><th>name</th><th>price</th><th>stock</th>
		</tr>
		<%
			for (int i = 0; i < productList.size(); i++) {
				ProductDto dto = productList.get(i);
		%>
		<tr>
 			<td><%=dto.getId()%></td> 
 			<td><%=dto.getName()%></td> 
 			<td><%=dto.getPrice()%></td> 
 			<td><%=dto.getStock()%></td>
		</tr>
		<%
			}
		%>
	</table>
	 --%>
	<style>
		.productList{
			width: 60%;
			height: 100%;
			margin: 0 auto;
			padding-top: 5%;
			/* 
			display: flex;
			justify-content: space-between;
			 */
		}
		
		.productWrapper{
			width: 20%;
			height: 40%;
			float: left;
			margin: 0 2.5%;
			margin-bottom: 2%;
			/* 
			display: flex;
			flex-wrap: wrap;
			align-content: space-around;
			 */
		}
		
		.productImage img{
			width: 100%;
			border-radius: 4px; 
		}
		
		.productCart{
			display: flex;
			justify-content: space-around;
			/* justify-content: space-between; */
		}
	
	</style>
	
	<div class="productList">
		<%
			for (int i = 0; i < productList.size(); i++) {
				ProductDto dto = productList.get(i);
		%>
	
			<div class="productWrapper">
				<div class="productImage">
					<a href="productDetail.do?id=<%=dto.getId()%>">
						<img alt="" src="<%=request.getContextPath()%>/images/product/gagu.jpg">
					</a>
				</div>
				<div class="productContent">
					<div class="productTitle">
						<a href="productDetail.do?id=<%=dto.getId()%>">
							<span><%=dto.getName()%></span>
						</a>
					</div>
					<div class="productCart">
						<span><%=dto.getPrice() %>원</span>
					</div>
					
				</div>
			</div>
		<%
			}
		%>
	</div>
	
	

	
</body>
</html>