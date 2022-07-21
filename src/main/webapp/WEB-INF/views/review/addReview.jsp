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
		<style>
		.reviewWrapper{
			width: 60%;
			height: 450px;
			margin: 80px auto calc(100vh - 780px) auto;
			font-family: 'JalpullineunOneul';
		}
		
		.reviewWrapper .reviewTop .reviewTopLeft{
			width: 92%;
			margin: 0 auto 30px auto;
		}
		
		.reviewWrapper button{
			float: right;
			width: 150px;
			height: 50px;
			background-color: #35c5f0;
		    border: none;
		    border-radius: 5px;
		    color: #fff;
		    font-size: 20px;
		}
		
		.reviewWrapper button: hover{
			cursor: pointer;
		}
		
		.reviewTop, .reviewBottom{
			display: flex;
			flex-direction: row;
		}
		
		.reviewBottom .reviewBottomRight, .reviewBottom .reviewBottomLeft{
			width: 40%;
			margin: 0 auto;
		}
		</style>
	
	
		<form action="addReview.do" name="frmForm" id="frm" method="post">
			<div class="reviewWrapper">
				<div class="reviewTop">
					<div class="reviewTopLeft">
						<span style="margin-right: 30px">상품명</span> <span><%=product.getName()%></span>
					</div>
				</div>
				<div class="reviewBottom">
					<div class="reviewBottomLeft">
						<div>
							<span>대표이미지</span> 
						</div>
						<div>
							<img src="<%=product.getthumbnailUrl()%>" width="400" height="300">
						</div>	
					</div>
					<div class="reviewBottomRight" style="width: 500px">
						<div>
							<span>리뷰</span> 
						</div>
						<div>
							<span>
								<textarea rows="10" cols="50" name="content" value="내용을 입력해 보세요"></textarea>
								<input type="hidden" name="productId" value="<%=product.getId()%>" />
							</span>
						</div>
					</div>
				</div>
				<div class="reviewButton">
					<button type="button">리뷰 작성</button>
				</div>
				
			</div>
		</form>
	</div>
	<script>
		$("button").click(function() {
			$("#frm").submit();
		});
	</script>
</body>
</html>