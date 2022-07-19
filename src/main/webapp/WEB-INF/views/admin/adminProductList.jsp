<%@page import="com.needle.FsoFso.admin.dto.AdminProductDto"%>
<%@page import="java.util.List"%>
<%@page import="com.needle.FsoFso.admin.dto.AdminProductListRequestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
AdminProductListRequestDto dtos = (AdminProductListRequestDto) request.getAttribute("dto");
List<AdminProductDto> memberList = dtos.getAdminProducts();
%>

<div id="admin-product-list" align="center">
	<table id="admin-product-list-table">
		<col width="50px">
		<col width="30px">
		<col width="100px">
		<col width="100px">
		<col width="100px">
		<col width="100px">
		<col width="100px">
		<tr>
			<th>상품번호</th>
			<th>이미지</th>
			<th>상품명</th>
			<th>재고 수</th>
			<th>판매 건수</th>
			<th>상품등록일</th>
			<th>상품수정일</th>
		</tr>
		<%
		for (AdminProductDto dto : memberList) {
		%>
		<tr>
			<td><%=dto.getProductId()%></td>
			<td><img src="<%=dto.getImgUrl()%>" width="30px"></td>
			<td><%=dto.getProductName()%></td>
			<td><%=dto.getStock()%></td>
			<td><%=dto.getSalesCount()%></td>
			<td><%=dto.getCreatedAt()%></td>
			<td><%=dto.getUpdatedAt()%></td>
		</tr>
		<%
		}
		%>

	</table>
</div>

<script type="text/javascript">
	
</script>
