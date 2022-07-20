<%@ page import="com.needle.FsoFso.common.util.AttributeContainer" %>
<%@ page import="com.needle.FsoFso.member.service.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    boolean isLoggedIn = AttributeContainer.hasSessionAttributeOf(request, "member");
    final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");
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
                                <span>
									<img alt="search-icon"
                                         src="<%=request.getContextPath()%>/images/glass.png">
								</span>
                            <input id="search" type="text" placeholder="통합검색" autoComplete="off"
                                   aria-autocomplete="list" class="search-input"/>
                        </div>
                    </div>
                </div>
                <div class="header-links">
                    <%--TODO: 장바구니 링크--%>
                    <a class="header-link-item" href="#">
                        <img alt="" src="<%=request.getContextPath()%>/images/cart.png">
                    </a>
                    <% if (isLoggedIn) { %>
                    <a class="header-link-item"
                       href="<%=request.getContextPath()%>/logout.do?id=<%=member.getId()%>">
                        로그아웃
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
  //TODO: 검색 버튼 event
  $(function () {
    //Block Enter key events . 엔터키 이벤트 막기.
    $(document).keypress(function (e) {
      if (e.keyCode == 13) {
        e.preventDefault();
      }
    });		//Click the Search button when you press Enter in the search TextBox. 검색 TextBox에서 Enter 키를 누를 때 검색 버튼을 클릭.
    $('#txtFind').keypress(function (e) {
      var key = e.which;
      if (key == 13) {
        // the enter key code		 
        $('input[name = btnFind]').click();
        return false;
      }
    });
  });
</script>

