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
<style>
.productList{width: 60%;height: 100%;margin: 0 auto;padding-top: 5%;}
.productWrapper{width: 20%;height: 40%;float: left;margin: 0 2.5%;margin-bottom: 2%;}
.productImage img{width: 100%;border-radius: 4px;}
.productCart{display: flex;justify-content: space-around;}
</style>
</head>
<body>
<div class="productList">
	<%
		for (int i = 0; i < productList.size(); i++) {
			ProductDto dto = productList.get(i);
	%>
		<div class="productWrapper">
			<div class="productImage">
				<a href="productDetail.do?id=<%=dto.getId()%>">
					<img alt="" src="<%=dto.getthumbnailUrl()%>">
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