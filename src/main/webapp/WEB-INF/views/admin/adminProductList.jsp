<%@page import="java.time.ZoneId"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>
<%@page import="java.time.Instant"%>
<%@page import="com.needle.FsoFso.admin.dto.AdminProductDto"%>
<%@page import="com.needle.FsoFso.admin.dto.AdminProductListRequestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
AdminProductListRequestDto dtos = (AdminProductListRequestDto) request.getAttribute("productListDto");
List<AdminProductDto> productList = dtos.getAdminProducts();

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
									.withLocale(Locale.KOREA).withZone(ZoneId.of("UTC"));
%>

<div id="admin-product-list" align="center">
	<table id="admin-product-list-table" style="border: 1px solid;">
		<col width="100px">
		<col width="100px">
		<col width="300px">
		<col width="100px">
		<col width="100px">
		<col width="200px">
		<col width="200px">
		<tr>
			<th>상품번호</th>
			<th>이미지</th>
			<th>상품명</th>
			<th>재고 수</th>
			<th>판매건 수</th>
			<th>상품등록일</th>
			<th>상품수정일</th>
		</tr>
		<%
		for (AdminProductDto dto : productList) {
		%>
		<tr>
			<td><%=dto.getProductId()%></td>
			<td><img src="<%=dto.getImgUrl()%>" width="30px"></td>
			<td><%=dto.getProductName()%></td>
			<td><%=dto.getStock()%></td>
			<td><%=dto.getSalesCount()%></td>
			<td><%=formatter.format(dto.getCreatedAt())%></td>
			<td><%=formatter.format(dto.getUpdatedAt())%></td>
		</tr>
		<%
		}
		%>

	</table>
</div>

<script type="text/javascript">
	
</script>
