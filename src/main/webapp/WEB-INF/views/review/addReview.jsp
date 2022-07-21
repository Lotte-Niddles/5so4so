<%@page import="com.needle.FsoFso.product.dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
ProductDto product = (ProductDto) request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="addReview.do" name="frmForm" id="frm" method="post">

			<table class="list_table" style="width: 85%">
				<col width="200">
				<col width="500">

				<tr>
					<th>상품명</th>
					<td style="text-align: left;"><input type="text"
						class="form-control" name="name" value="<%=product.getName()%>"
						size="50" readonly="readonly"></td>
				</tr>
				<tr>
					<th>대표이미지</th>
					<td style="text-align: left;"><img
						src="<%=product.getthumbnailUrl()%>"></td>
				</tr>
				<tr>
					<th>가격</th>
					<td style="text-align: left;"><input type="text"
						class="form-control" name="price" size="50"
						value="<%=product.getPrice()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>재고</th>
					<td style="text-align: left;"><input type="text"
							class="form-control" name="stock"
							value="<%=product.getStock()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>리뷰</th>
					<td style="text-align: left;"><textarea rows="10" cols="50"
							class="form-control" name="content" value="내용을 입력해 보세요"></textarea>
						<input type="hidden" name="productId"
						value="<%=product.getId()%>" /></td>
				</tr>

				<tr align="center">
					<td colspan="2">
						<button type="button" class="btn btn-primary">리뷰 작성</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script>
		$("button").click(function() {
			$("#frm").submit();
		});
	</script>
</body>
</html>