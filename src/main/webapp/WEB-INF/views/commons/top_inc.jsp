<%@ page import="com.needle.FsoFso.common.util.AttributeContainer" %>
<%@ page import="com.needle.FsoFso.member.service.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    boolean isLoggedIn = AttributeContainer.hasSessionAttributeOf(request, "member");
    System.out.println(isLoggedIn);
    final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");

	String keyWord = (String) request.getAttribute("keyWord");
	if (keyWord == null) {
		keyWord = "";
	}
%>
<header>
    <div class="header-container">
        <div class="header-wrapper">
            <div class="header-logo">
                <a class="header-logo-item" href="<%=request.getContextPath()%>/index.jsp">
                    <img alt="" src="<%=request.getContextPath()%>/images/logo.png">
                </a>
            </div>
            <div class="header-items">
                <div class="header-search-wrapper">
                    <div id="global-search-combobox" role="combobox" aria-expanded="false"
                         aria-haspopup="listbox">
                        <div class="search-input-box">
							<span id="searchBtn">
								<img alt="search-icon"
									 src="<%=request.getContextPath()%>/images/glass.png">
							</span>
							<input id="search" class="search-input" value="<%=keyWord%>" type="text" placeholder="통합검색" autoComplete="off" aria-autocomplete="list"/>
						</div>
                    </div>
                </div>
                <div class="header-links">
                    <a class="header-link-item" href="<%=request.getContextPath()%>/order.do">
                        <img alt="" src="<%=request.getContextPath()%>/images/cart.png">
                    </a>
                    <% if (isLoggedIn) { %>
                    <a class="header-link-item"
                       href="<%=request.getContextPath()%>/me.do">
                        마이페이지
                    </a>
                    <% } else { %>
                    <a class="header-link-item" href="<%=request.getContextPath()%>/login.do">
                        로그인
                    </a>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
</header>
<script>
$(function() {
	const enterKey = 13;
	$(document).keypress(function(e) {
		if (e.keyCode === enterKey) {
			e.preventDefault();
		}
	});
	$('#searchBtn').css('cursor', 'pointer').click(function(e) {
		const keyWord = $('#search').val().trim();
		if (keyWord != '') {
			location.href = 'searchList.do?keyWord=' + keyWord;
		} else {
			alert('검색어를 입력해 주세요!');
		}
	});
	$('#search').keypress(function(e) {
		const key = e.which;
		const keyWord = $('#search').val().trim();
		if (key === enterKey){
			if (keyWord != '') {
				location.href = 'searchList.do?keyWord=' + keyWord;
			} else {
				alert('검색어를 입력해 주세요!');
			}
		}		
	});
});
</script>
