<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
				<a class="css-loslz5" aria-label="오늘의집 로고" href="<%=request.getContextPath()%>/admin.do">
					<img alt="" src="<%=request.getContextPath()%>/images/logo.png">
				</a>
			</div>
			
			<div class="css-1h0hlgo">
			
				<a class="css-1scjy81" href="<%=request.getContextPath()%>/adminProductList.do">
					<style data-emotion="css 18nk785">
						.css-18nk785{display:inline-block;margin:-4px;padding:4px;border-radius:3px;}
					</style>
					<span class="css-18nk785">상품목록</span>
				</a>
				<a class="css-1scjy81" href="<%=request.getContextPath()%>/adminAddProduct.do">
					<span class="css-18nk785">상품등록</span>
				</a>
				<a class="css-1scjy81" href="<%=request.getContextPath()%>/adminMemberList.do">
					<span class="css-18nk785">회원관리</span>
				</a>
			</div>
		
			<div class="css-ff6c76">
				<div class="css-10vibjk">
					<div class="css-1f624s9">
						<div class="css-1kpxvh4">
							<a class="css-1g5o6hv" href="/logout.do">
								로그아웃
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