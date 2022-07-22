<%@ page import="com.needle.FsoFso.admin.dto.AdminOrderProductDto" %>
<%@ page import="com.needle.FsoFso.admin.dto.AdminOrderProductListRequestDto" %>
<%@ page import="com.needle.FsoFso.common.util.CurrencyFormatter" %>

<%@ page import="java.time.ZoneId" %>
<%@ page import="java.time.Instant" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- 폰트 -->
<link href="https://webfontworld.github.io/Jalpullineun/JalpullineunOneul.css" rel="stylesheet">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/adminOrderProductList.css" />
<%
AdminOrderProductListRequestDto dtos = (AdminOrderProductListRequestDto) request.getAttribute("orderProductListDto");
List<AdminOrderProductDto> orderProductList = dtos.getAdminOrders();

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
									.withLocale(Locale.KOREA).withZone(ZoneId.of("UTC"));

AdminOrderProductDto sampleDto = orderProductList.get(0);
long memberId = sampleDto.getMemberId();
long orderId = sampleDto.getOrderId();
Instant orderedAt = sampleDto.getOrderedAt();
Instant updatedAt = sampleDto.getUpdatedAt();
%>

<div id="admin-product-list" align="center">
<h2 style="margin-top: 8px;">주문상세정보</h2>
<h4>주문번호 : <%=orderId%> / 사용자ID : <%=memberId%></h4>
	<table id="admin-order-product-list-table" class="table table-hover">
		<col width="100px">
		<col width="100px">
		<col width="300px">
		<col width="200px">
		<col width="200px">
		<col width="200px">
		<col width="200px">
		<col width="200px">
		<thead>
		<tr style="color: #35C5F0; text-align: center;" >
			<th>주문상세번호</th>
			<th>제품번호</th>
			<th>제품이름</th>
			<th>이미지</th>
			<th>주문개수</th>
			<th>제품가격</th>
			<th>주문일시</th>
			<th>주문수정일시</th>
		</tr>
		</thead>
		<tbody style="font-family: 'JalpullineunOneul';">
		<%
		for (AdminOrderProductDto dto : orderProductList) {
		%>
		<tr>
			<td style="text-align: center;"><%=dto.getId()%></td>
			<td style="text-align: center;"><%=dto.getProductId()%></td>
			<td><%=dto.getProductName()%></td>
			<td style="text-align: center;"><img src="<%=dto.getProductThumbnailUrl()%>" width="30px" height="30px"></td>
			<td style="text-align: right;"><%=dto.getQuantity()%>EA</td>
			<td style="text-align: right;"><%=CurrencyFormatter.toCurrencyFormat(dto.getUnitPrice())%>원</td>
			<td style="text-align: center;"><%=formatter.format(dto.getOrderedAt())%></td>
			<td style="text-align: center;"><%=formatter.format(dto.getUpdatedAt())%></td>
		</tr>
		<%
		}
		%>
</tbody>
	</table>
</div>

<script type="text/javascript">
	
</script>
