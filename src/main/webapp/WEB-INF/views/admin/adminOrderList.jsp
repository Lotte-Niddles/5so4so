<%@ page import="com.needle.FsoFso.admin.dto.AdminOrderDto" %>
<%@ page import="com.needle.FsoFso.admin.dto.AdminOrderListRequestDto" %>
<%@ page import="com.needle.FsoFso.common.util.CurrencyFormatter" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>

<%@ page import="java.time.Instant" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- 폰트 -->
<link href="https://webfontworld.github.io/Jalpullineun/JalpullineunOneul.css" rel="stylesheet">

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin/adminOrderList.css">
<%
AdminOrderListRequestDto dtos = (AdminOrderListRequestDto) request.getAttribute("OrderListDto");
List<AdminOrderDto> orderList = dtos.getAdminOrders();

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
									.withLocale(Locale.KOREA).withZone(ZoneId.of("UTC"));

String keyWord = (String) request.getAttribute("keyWord");
if (keyWord == null) {
	keyWord = "";
}
%>

<div id="admin-product-list" align="center">
<h2 style="margin-top: 8px;">주문관리</h2>
<div class="searchBar">
<select>
	<option>주문번호</option>
</select>
<input type="text" id="search" value="<%=keyWord%>">
<input type="button" id="searchBtn" value="검색">
</div>
	<table id="admin-order-list-table" class="table table-hover">
		<col width="100px">
		<col width="100px">
		<col width="300px">
		<col width="200px">
		<col width="200px">
		<col width="200px">
		<col width="200px">
		<thead>
		<tr style="color: #35C5F0; text-align: center;" >
			<th>주문번호</th>
			<th>사용자ID</th>
			<th>주문가격</th>
			<th>주문 품목 수</th>
			<th>주문일시</th>
			<th>주문수정일시</th>
			<th>상세정보보기</th>
		</tr>
		</thead>
		<tbody style="font-family: 'JalpullineunOneul';">
		<%
			if (orderList.size() > 0) {
				for (AdminOrderDto dto : orderList) {
		%>
          <tr>
            <td style="text-align: center;"><%=dto.getId()%></td>
            <td style="text-align: center;"><%=dto.getMemberId()%></td>
            <td style="text-align: right;"><%=dto.getTotalPrice()%>원</td>
            <td style="text-align: center;"><%=dto.getProductCount()%> 종류</td>
            <td style="text-align: center;"><%=formatter.format(dto.getOrderedAt())%></td>
            <td style="text-align: center;"><%=formatter.format(dto.getUpdatedAt())%></td>
            <td style="text-align: center;">
              <button type="button" class="btn" onclick="location.href='adminOrderProductList.do?orderId=<%=dto.getId()%>'">상세정보</button>
            </td>
          </tr>
		<%
				}
		%>
				</tbody>
		</table>
		<% 
				} else {
		%>
			</tbody>
		</table>
				<p style="text-align:center;margin-top:200px;">앗! 찾으시는 결과가 없네요.</p>
		<%
			}
		%>
</div>

<script type="text/javascript">
 $(function() {
	const enterKey = 13;
	$(document).keypress(function(e) {
		if (e.keyCode === enterKey) {
			e.preventDefault();
		}
	});
	$('#searchBtn').click(function(e) {
		const keyWord = $('#search').val().trim();
		let str = keyWord;
		let check = /^[0-9]+$/; 
		if (!check.test(str)) {
			alert("숫자만 입력 가능합니다.");
			$('#search').val('').focus();
			return;
		}
		if (keyWord != '') {
			location.href='adminOrderList.do?keyWord=' + keyWord;
		} else {
			alert('검색어를 입력해 주세요!');
			$('#search').focus();
		}
	});
	$('#search').keypress(function(e) {
		const key = e.which;
		const keyWord = $('#search').val().trim();
		if (key === enterKey){
			let str = keyWord;
			let check = /^[0-9]+$/; 
			if (!check.test(str)) {
				alert("숫자만 입력 가능합니다.");
				$('#search').val('').focus();
				return;
			}
			if (keyWord != '') {
				location.href='adminOrderList.do?keyWord=' + keyWord;
			} else {
				alert('검색어를 입력해 주세요!');
			}
		}		
	});
});
</script>
