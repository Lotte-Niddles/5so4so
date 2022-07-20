<%@page import="com.needle.FsoFso.review.dto.ReviewDto"%>
<%@page import="java.util.List"%>
<%@page import="com.needle.FsoFso.product.dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ProductDto product = (ProductDto) request.getAttribute("product");
List<ReviewDto> reviewList = (List<ReviewDto>) request.getAttribute("reviewList");
List<String> nicknameList = (List<String>) request.getAttribute("nicknameList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Product</h2>
	<div align="center">
		<form id="detail" action="addCart.do" method="post">
			<table>
				<tr>
					<th>상품명</th>
					<td><%=product.getName()%></td>
				</tr>
				<tr>
					<th>이미지</th>
					<td><img src="<%=product.getthumbnailUrl()%>"></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><%=product.getPrice()%></td>
				</tr>
				<tr>
					<th>생성일</th>
					<td><%=product.getcreatedAt()%></td>
				</tr>
				<tr>
					<th>수정일</th>
					<td><%=product.getupdatedAt()%></td>
				</tr>
			</table>
			<input type="hidden" value="<%=product.getId() %>" name="productId"/>
			수량<input type="text" name="quantity">
			<button type="button">장바구니에 담기</button>
		</form>
		
		<div>
			<table>
				<tr>
					<th>닉네임</th>
					<th>내용</th>
					<th>일자</th>
				</tr>
				<%for(int i = 0 ; i < reviewList.size(); i++){
				%>
					<tr>
						<th><%=nicknameList.get(i) %></th>
						<th><%=reviewList.get(i).getContent() %></th>
						<th><%=reviewList.get(i).getCreatedAt() %></th>
					</tr>
					<%
				}
					%>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$("button").click(function() {
			$("#detail").submit();
		});
	</script>
</body>
</html>