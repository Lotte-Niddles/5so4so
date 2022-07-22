<%@page import="com.needle.FsoFso.search.dto.SearchDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<SearchDto> searchList = (List<SearchDto>) request.getAttribute("searchList");
	int pageNumber = (Integer)request.getAttribute("pageNumber");
	int searchPage = (Integer)request.getAttribute("searchPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchList</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/product/main.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.9.1/gsap.min.js"
        integrity="sha512-H6cPm97FAsgIKmlBA4s774vqoN24V5gSQL4yBTDOY2su2DeXZVhQPxFK4P6GPdnZqM9fg1G3cMv5wD7e6cFLZQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.9.1/ScrollToPlugin.min.js"
        integrity="sha512-agNfXmEo6F+qcj3WGryaRvl9X9wLMQORbTt5ACS9YVqzKDMzhRxY+xjgO45HCLm61OwHWR1Oblp4QSw/SGh9SA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
<div class="productList" id="productList">
	<div class="productListInner">
		<div class="productListItems">
			<%
				if (searchList.size() > 0) {
					for (int i = 0; i < searchList.size(); i++) {
						SearchDto searchDto = searchList.get(i);
			%>
					<div class="productWrapper">
						<div class="productImage">
							<a href="productDetail.do?id=<%=searchDto.getId()%>">
								<img alt="" src="<%=searchDto.getthumbnailUrl()%>" width="269" height="269">
							</a>
						</div>
						<div class="productContent">
							<div class="productTitle">
								<a href="productDetail.do?id=<%=searchDto.getId()%>" style="text-decoration: none">
									<span class="productName"><%=searchDto.getName()%></span>
								</a>
							</div>
							<div class="productCart">
								<span class="price"><%=searchDto.getPrice()%>원</span>
							</div>
						</div>
					</div>
			<%
					}
				} else {
			%>
				<script type="text/javascript">
					$('<p>').css({'text-align':'center', 'margin-top':'200px'})
					.text('앗! 찾으시는 결과가 없네요!').attr('id', 'nodata').prependTo($('#productList'));
				</script>
			<%
				}
			%>
		</div>
		<div class="productListPageNum">
		<%
			for (int i = 0; i < searchPage; i++){
				if (pageNumber == i) {
		%>
					<span style="font-size: 15pt; color: #35c5f0; font-weight: bold;">
						<%=i + 1%>
					</span>
		<%
				} else {
		%>
					<a href="#none" title="<%=i + 1%>페이지" onclick="goPage(<%=i%>)"
						style="font-size: 15pt; color: #000; font-weight: bold; text-decoration: none;">
						<%=i + 1%>
					</a>
		<%	
				}	
			}
		%>
		</div>
	</div>
</div>
<div id="to-top">
    <div class="material-icons">arrow_upward</div>
</div>
<script type="text/javascript">
function goPage(pageNumber) {
	let keyWord = $('#search').val();
	location.href = 'searchList.do?keyWord=' + keyWord + "&pageNumber=" + pageNumber; 
}
const toTopEl = document.querySelector('#to-top');
window.addEventListener('scroll', function() {
	if (window.scrollY > 300) {
		gsap.to(toTopEl, .2, {
	      x: 0
	    });
  	} else {
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
	  triggerElement: spyEl, 
	  triggerHook: .8
	})
	.setClassToggle(spyEl, 'show')
	.addTo(new ScrollMagic.Controller());
});
</script>
</body>
</html>