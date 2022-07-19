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
</body>
</html>