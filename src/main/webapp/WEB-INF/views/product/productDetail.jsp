<%@page import="com.needle.FsoFso.member.service.Member"%>
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
<script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
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
	.productDetailReview{
		width: 65%;
		margin: 0 auto 20px auto;
		font-family: 'JalpullineunOneul';
	}
	
	.detailWrapper{	
		height: 550px;
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
	
	.detailRight .swiper{
		margin: 0;
	    margin-top: 50px;
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
	
	.review{
		margin: 50px 260px 0 70px;
	}
	
	.review button{
		width: 130px;
		height: 45px;
		background-color: #35c5f0;
	    border: none;
	    border-radius: 5px;
	    color: #fff;
	    font-size: 20px;
	    cursor: pointer;
	}
	
	</style>
	<div class="productDetailReview">
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
					수량 : <input type="number" id="quantity" name="quantity" min="0" value="0" style="text-align: right; ">개
				</div>
				<input type="hidden" value="<%=product.getId() %>" name="productId"/>
				<button type="button" id="addCart">장바구니</button>
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

		<div class="review">
			<div style="display: flex; justify-content: space-between; margin-bottom: 25px;">
				<span style="font-size: 40px">리뷰</span>
				<button onclick="isValidMemberForAddReivew()">리뷰작성</button>
			</div>
			
			<table style="text-align: center">
				<col width="100"><col width="500"><col width="300">
				<tr height="50">
					<th>닉네임</th>
					<th>내용</th>
					<th>일자</th>
				</tr>
				<%
				for (int i = 0; i < reviewList.size(); i++) {
				%>
				<tr height="40">
					<td><%=nicknameList.get(i)%></td>
					<td><%=reviewList.get(i).getContent()%></td>
					<td><%=reviewList.get(i).getCreatedAt()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
		
		
	</div>
	<script type="text/javascript">
		$("#addCart").click(function() {
			if($("#quantity").val() == "" || $("#quantity").val() == 0){
				alert("수량을 입력하세요");
			}
			else if($("#quantity").val() > <%=product.getStock()%>){
				alert("재고가 부족합니다");
			}
			else{
				$("#detail").submit();
			}
		});
		
		<!-- Initialize Swiper -->
		var swiper = new Swiper(".mySwiper", {
		    autoplay: {
		    	   delay: 3000,
		    },
		  });
		
		function isValidMemberForAddReivew(){
			$.ajax({
				url: "checkBuyMember.do",
				type: "get",
				data: { 
					<%-- "memberId" : "<%= ((Member)request.getSession().getAttribute("Member")).getId() %>", --%>
					"memberId" : "12",
					"productId" : "<%=product.getId()%>"},
				dataType : "text",
				success: function(result){
					if(result == "true"){
						location.href = "addReview.do?id=<%=product.getId()%>";
					} 
					else {
								alert("상품을 구입한 회원이 아닙니다.");
							}
					}
				})
		}
	</script>
</body>
</html>