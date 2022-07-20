<%@page import="com.needle.FsoFso.product.dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProductDto product = (ProductDto)request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Product</h2>
<table>
	<tr>
		<th>상품명</th>
		<td><%=product.getName() %></td>
	</tr>
	<tr>
		<th>이미지</th>
		<td><img src="<%=product.getthumbnailUrl() %>"></td>
	</tr>
	<tr>
		<th>가격</th>
		<td><%=product.getPrice() %></td>
	</tr>
	<tr>
		<th>생성일</th>
		<td><%=product.getcreatedAt() %></td>
	</tr>
	<tr>
		<th>수정일</th>
		<td><%=product.getupdatedAt() %></td>
	</tr>

</table>
</body>
</html>