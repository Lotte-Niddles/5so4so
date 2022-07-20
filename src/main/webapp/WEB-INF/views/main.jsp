<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.needle.FsoFso.product.dto.ProductDto"%>
<%
	List<ProductDto> productList = (List<ProductDto>) request.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/product/main.css">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>

<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

<!-- GSAP & ScrollToPlugin -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.9.1/gsap.min.js" integrity="sha512-H6cPm97FAsgIKmlBA4s774vqoN24V5gSQL4yBTDOY2su2DeXZVhQPxFK4P6GPdnZqM9fg1G3cMv5wD7e6cFLZQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.9.1/ScrollToPlugin.min.js" integrity="sha512-agNfXmEo6F+qcj3WGryaRvl9X9wLMQORbTt5ACS9YVqzKDMzhRxY+xjgO45HCLm61OwHWR1Oblp4QSw/SGh9SA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<!-- Link Swiper's CSS -->
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
<!-- Swiper JS -->
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>


</head>
<body>
	<div class="swiper mySwiper">
      <div class="swiper-wrapper">
        <div class="swiper-slide"><img alt="" src="<%=request.getContextPath() %>/images/product/slide1.png"></div>
        <div class="swiper-slide"><img alt="" src="<%=request.getContextPath() %>/images/product/slide2.png"></div>
        <div class="swiper-slide"><img alt="" src="<%=request.getContextPath() %>/images/product/slide3.png"></div>
        <div class="swiper-slide"><img alt="" src="<%=request.getContextPath() %>/images/product/slide4.png"></div>
        <div class="swiper-slide"><img alt="" src="<%=request.getContextPath() %>/images/product/slide5.png"></div>
       </div>
      <div class="swiper-pagination"></div>
    </div>


	<div class="productList">
		<div class="productListInner">
			<%
			for (int i = 0; i < productList.size(); i++) {

				ProductDto dto = productList.get(i);
			%>
			<div class="productWrapper">
				<div class="productImage">
					<a href="productDetail.do?id=<%=dto.getId()%>">
						<img alt="" src="<%=dto.getthumbnailUrl()%>" width="269" height="269" >
					</a>
				</div>
				<div class="productContent">
					<div class="productTitle">
						<a href="productDetail.do?id=<%=dto.getId()%>" style="text-decoration:none">
							<span class="productName"><%=dto.getName()%></span>
						</a>
					</div>
					<div class="productPrice">
						<span class="price"><%=dto.getPrice() %>원</span>
					</div>
					
				</div>
				
			</div>
		</div>
	<%
		}
	%>
	
	<div class="pageNum">
		<%
		// 페이지 번호
		String sPageNumber = (String)request.getAttribute("pageNumber");

		int pageNumber = 0;
		if(sPageNumber != null && !sPageNumber.equals("")){
			pageNumber = Integer.parseInt(sPageNumber);
		}

		// 글의 총수
		int len = (int)request.getAttribute("len");

		// 페이지의 수
		int bbsPage = len / 12;
		if((len % 12) > 0){
			bbsPage = bbsPage + 1;
		}

		%>
		<%
		for(int i = 0;i < bbsPage; i++){
			if(pageNumber == i){	// 현재 페이지
				%>
				<span style="font-size: 15pt;color: #35c5f0; font-weight: bold;">
					<%=i + 1 %>
				</span>
				<%
			}else{					// 그외의 페이지		[1] 2 [3]
				%>
				<a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)"
					style="font-size: 15pt; color: #000; font-weight: bold;text-decoration: none;">
					<%=i + 1 %>
				</a>
				<%	
			}	
		}
		%>
	</div>
</div>

<div id="to-top">
    <div class="material-icons">arrow_upward</div>
</div>



<script type="text/javascript">
<!-- Initialize Swiper -->
var swiper = new Swiper(".mySwiper", {
    pagination: {
      el: ".swiper-pagination",
    },
    autoplay: {
    	   delay: 3000,
    },
  });

function goPage( pageNumber ) {
	location.href = "productList.do?pageNumber=" + pageNumber;	
}



const toTopEl = document.querySelector('#to-top');

window.addEventListener('scroll', function(){
  if (window.scrollY > 300){
    // 배지 숨기기
    // gsap.to(요소, 지속시간, 옵션)
    gsap.to(toTopEl, .2, {
      x: 0
    });
  }
  else{
    // 버튼 숨기기!
    gsap.to(toTopEl, .2, {
      x: 100
    });
  }
}, 300);

toTopEl.addEventListener('click', function() {
  gsap.to(window, .7, {
    scrollTo: 0
  });
});


const spyEls = document.querySelectorAll('section.scroll-spy');
spyEls.forEach(function(spyEl) {
  new ScrollMagic
    .Scene({
      triggerElement: spyEl, // 보여짐 여부를 감시할 요소를 지정
      triggerHook: .8
    })
    .setClassToggle(spyEl, 'show')
    .addTo(new ScrollMagic.Controller());
});
</script>
</body>
</html>
