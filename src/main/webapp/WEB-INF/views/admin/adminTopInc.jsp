<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header>
    <div class="header-container">
        <div class="header-wrapper">
            <div class="header-logo">
                <a class="header-logo-item" href="<%=request.getContextPath()%>/admin.do">
                    <img alt="" src="<%=request.getContextPath()%>/images/logo.png">
                </a>
            </div>
            <div class="header-items">
                <a class="header-nav-items"
                   href="<%=request.getContextPath()%>/adminProductList.do">
                    <style data-emotion="css 18nk785">
                        .css-18nk785 {
                            display: inline-block;
                            margin: -4px;
                            padding: 4px;
                            border-radius: 3px;
                        }
                    </style>
                    <span class="css-18nk785">상품목록</span>
                </a>
                <a class="header-nav-items" href="<%=request.getContextPath()%>/adminAddProduct.do">
                    <span class="css-18nk785">상품등록</span>
                </a>
                <a class="header-nav-items" href="<%=request.getContextPath()%>/adminMemberList.do">
                    <span class="css-18nk785">회원관리</span>
                </a>
            </div>

            <div class="header-items">
                <div class="header-links">
                    <a class="header-link-item" href="/logout.do">
                        로그아웃
                    </a>
                </div>
            </div>
        </div>
    </div>
</header>