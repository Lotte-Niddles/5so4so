<%@ page import="com.needle.FsoFso.admin.dto.AdminProductDto" %>
<%@ page import="com.needle.FsoFso.admin.dto.AdminProductListRequestDto" %>

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

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/adminProductList.css" />
<%
AdminProductListRequestDto dtos = (AdminProductListRequestDto) request.getAttribute("productListDto");
List<AdminProductDto> productList = dtos.getAdminProducts();

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
									.withLocale(Locale.KOREA).withZone(ZoneId.of("UTC"));
String keyWord = (String) request.getAttribute("keyWord");
if (keyWord == null) {
	keyWord = "";
}
%>

<div id="admin-product-list" align="center">
<h2 style="margin-top: 8px;">상품관리</h2>
<div class="searchBar">
<select>
	<option>상품명</option>
</select>
<input type="text" id="search" value="<%=keyWord%>">
<input type="button" id="searchBtn" value="검색">
</div>
	<table id="admin-product-list-table" class="table table-hover">
		<col width="100px">
		<col width="100px">
		<col width="300px">
		<col width="100px">
		<col width="100px">
		<col width="200px">
		<col width="200px">
		<col width="200px">
		<thead>
		<tr style="color: #35C5F0; text-align: center;" >
			<th>상품번호</th>
			<th>이미지</th>
			<th>상품명</th>
			<th>재고 수</th>
			<th>판매건 수</th>
			<th>상품등록일시</th>
			<th>상품수정일시</th>
			<th>상품 삭제</th>
		</tr>
		</thead>
		<tbody style="font-family: 'JalpullineunOneul';">
		<%
			if (productList.size() > 0) {
				for (AdminProductDto dto : productList) {
		%>
					<tr>
						<td style="text-align: center;"><a href="<%=request.getContextPath()%>/productDetail.do?id=<%=dto.getProductId()%>"><%=dto.getProductId()%></a></td>
						<td style="text-align: center;"><a href="<%=request.getContextPath()%>/productDetail.do?id=<%=dto.getProductId()%>"><img src="<%=dto.getImgUrl()%>" width="30px" height="30px"></a></td>
						<td><a href="<%=request.getContextPath()%>/productDetail.do?id=<%=dto.getProductId()%>"><%=dto.getProductName()%></a></td>
						<td style="text-align: right;"><%=dto.getStock()%></td>
						<td style="text-align: right;"><%=dto.getSalesCount()%>회</td>
						<td style="text-align: center;"><%=formatter.format(dto.getCreatedAt())%></td>
						<td style="text-align: center;"><%=formatter.format(dto.getUpdatedAt())%></td>
						<td style="text-align: center;"> <button onclick="deleteProduct(<%=dto.getProductId()%>)">삭제</button> </td>
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
		if (keyWord != '') {
			location.href='adminProductList.do?keyWord=' + keyWord;
		} else {
			alert('검색어를 입력해 주세요!');
			$('#search').focus();
		}
	});
	$('#search').keypress(function(e) {
		const key = e.which;
		const keyWord = $('#search').val().trim();
		if (key === enterKey){
			if (keyWord != '') {
				location.href='adminProductList.do?keyWord=' + keyWord;
			} else {
				alert('검색어를 입력해 주세요!');
			}
		}		
	});
});
function deleteProduct(productId){
	if(confirm("상품을 삭제하시겠습니까?")){
		location.href='delProduct.do?productId=' + productId;
	}else{
		return;	
	}
}
</script>
