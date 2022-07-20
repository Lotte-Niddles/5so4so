<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String keyWord = (String) request.getAttribute("keyWord");
	if (keyWord == null) {
		keyWord = "";
	}
%>
<header>
<div class="sticky-container">
	<div class="css-i7a8i3">
		<div class="css-1pttzzz">
			<div class="css-1yg67sl">
				<button type="button" class="css-osmvbo">
					<span class="_menu_24 css-cwcsvq"></span>
				</button>
			</div>
			<div class="css-48o8iw">	
				<a class="css-loslz5" href="/">
					<img alt="" src="<%=request.getContextPath()%>/images/logo.png">
				</a>
			</div>
			<div class="css-1h0hlgo"></div>
			<div class="css-ff6c76">
				<div class="css-10vibjk">
					<div class="css-1o64euu">
						<div id="global-search-combobox" role="combobox" aria-expanded="false" aria-haspopup="listbox" class="css-7whenc">
							<div class="css-1cfhwdb">
								<span class="_search_24 css-p63a35"></span>
								<span id="searchBtn">
									<img alt="" src="<%=request.getContextPath()%>/images/glass.png">
								</span>
								<input id="search" value="<%=keyWord%>" type="text" placeholder="통합검색" autoComplete="off" aria-autocomplete="list" class="css-16px0cl"/>
								<div class="css-s5xdrg"></div>
							</div>
						</div>
					</div>
					<div class="css-t6whf">
						<button type="button" class="css-oh9y0">
							<span class="_search_24 css-cwcsvq"></span>
						</button>
					</div>
					<a aria-label="장바구니 페이지 링크 버튼" class="css-xh0ic1" href="/cart">
						<span class="_cart_24 css-17vaqfq"></span>
					</a>
					<div class="css-1f624s9">
						<div class="css-1kpxvh4">
							<a class="css-1g5o6hv" href="/users/sign_in?redirect_to=%2Fcustomer_center">
								<img alt="" src="<%=request.getContextPath()%>/images/cart.png">
							</a>
							<a class="css-1g5o6hv" href="/users/sign_in?redirect_to=%2Fcustomer_center">
								로그인
							</a>
						</div>
						<span class="css-1amee4m">
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</header>
<script>
$(function() {		
	$(document).keypress(function(e) {
		if (e.keyCode == 13) {
			e.preventDefault();		
		}
	});		
	$('#searchBtn').css('cursor', 'pointer').click(function(e) {
		let keyWord = $('#search').val();
		location.href = 'searchList.do?keyWord=' + keyWord; 
	});   	
	$('#search').keypress(function(e) {		 
		let key = e.which;
		let keyWord = $('#search').val();
		if (key == 13) {		
		location.href = 'searchList.do?keyWord=' + keyWord; 
		}		
	});   	
});
</script>