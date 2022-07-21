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
<!-- Link Swiper's CSS -->
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<!-- Swiper JS -->
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<!-- thoma폰트 -->
<link href="//db.onlinewebfonts.com/c/cd0381aa3322dff4babd137f03829c8c?family=Tahoma" rel="stylesheet" type="text/css"/>

</head>
<body>
	<style>
	.detailWrapper{
		font-family: 'JalpullineunOneul';
		width: 65%;
		height: 700px;
		margin: 0 auto 20px auto;
		padding-top: 3%;
		display: flex;
		flex-direction: row;
		justify-content: space-around;
	}
	
	.detailLeft img{
	 	border-radius: 5px;
	}
	
	.detailRight{
	 	text-align: left;
	 	margin: 80px 100px 0 0;
	}
	
	.detailRight .detailTitle{
		width: 260px;
	 	font-size: 25px;
	    line-height: 33px;
	    min-height: 43px;
	    margin: 15px 92px 25px 0;
	}
	
	.detailRight .detailPrice{
		line-height: 1;
	    font-size: 20px;
	    font-weight: 700;
	    margin-top: 5px;
	}
	
	.detailRight .detailPrice .detailPriceContent{
		margin: 20px 0px;
		font-family: Tahoma,Tahoma For Number;
	}
	
	.grade{
		color: #35c5f0;
	}
	
	.detailRight .detailStock{
		font-size: 14px;
	    line-height: 21px;
	    color: #828c94;
	}
	
	.detailRight form [type="button"]{
		width: 260px;
		background-color: #35c5f0;
	    border: none;
	    border-radius: 5px;
	    color: #fff;
	    font-size: 20px;
	    cursor: pointer;
	}
	
	.detailOrder{
		margin: 20px 0;
	}
	
	</style>

	<div class="detailWrapper" align="center">
		<div class="detailLeft">
			<img src="<%=product.getthumbnailUrl()%>" width="500" height="500">
		</div>
		<div class="detailRight">
			<form id="detail" action="addCart.do" method="post">
			<div class="detailTitle">
				<span><%=product.getName()%></span>
			</div>
			
			<div class="detailPrice">
				<div class="detailPriceContent">
					<span>정가 : <%=product.getPrice()%>원</span>
				</div>
				<div class="detailPriceContent grade">
					<span>회원 등급 적용가 : <%=product.getPrice()%>원</span>
				</div>
			</div>
			
			<div class="detailStock">
				<span>남은 수량 : <%=product.getStock()%>개</span>
			</div>
			
			<div class="detailOrder">
				수량 : <input type="text" name="quantity">개
			</div>
			<input type="hidden" value="<%=product.getId() %>" name="productId"/>
			<button type="button">장바구니</button>
		</form>
		
				<div class="swiper mySwiper" style="width: 260px; height: 70px;">
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<img alt=""
								src="<%=request.getContextPath()%>/images/product/slide1.png" width="260px" height="70px">
						</div>
						<div class="swiper-slide">
							<img alt=""
								src="<%=request.getContextPath()%>/images/product/slide2.png" width="260px" height="70px">
						</div>
						<div class="swiper-slide">
							<img alt=""
								src="<%=request.getContextPath()%>/images/product/slide3.png" width="260px" height="70px">
						</div>
					</div>
					<div class="swiper-pagination"></div>
				</div>	
		</div>




	</div>
	<script type="text/javascript">
		$("button").click(function() {
			$("#detail").submit();
		});
		
		
		<!-- Initialize Swiper -->
		var swiper = new Swiper(".mySwiper", {
		    autoplay: {
		    	   delay: 3000,
		    },
		  });
		
	</script>
</body>
</html>