<%@ page import="com.needle.FsoFso.common.util.AttributeContainer" %>
<%@ page import="com.needle.FsoFso.member.service.Member" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.needle.FsoFso.review.dto.ReviewDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");

    final List<ReviewDto> reviews = Optional.ofNullable(
                    (List<ReviewDto>) AttributeContainer.attributeFrom(request, "reviewList"))
            .orElse(Collections.emptyList());
%>
<style>
    .flex-center {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .flex-col-center {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .mypage-container {
        align-items: flex-start;

        min-height: 90vh;
    }

    .mypage-wrapper {
        display: grid;
        width: 80%;
        grid-template-columns: 25% minmax(70%, auto);
        grid-column-gap: 2rem;

        padding: 2rem;
    }

    .mypage-wrapper > div {
        padding: 2rem;
    }

    .mypage-profile {
        justify-content: flex-start;
        max-height: 40vh;
    }

    .mypage-contents {
        justify-content: flex-start;
        height: 80vh;
        overflow: scroll;
        -ms-overflow-style: none;
        scrollbar-width: none;
    }

    .mypage-contents::-webkit-scrollbar {
        display: none;
    }

    .mypage-border {
        border: 1px solid #ebebeb;
        border-radius: 8px;
    }

    .divider {
        width: 100%;
        border-bottom: 1px solid #ebebeb;
        margin: 2rem 0;
    }

    .divider-col {
        color: #ebebeb;
        margin: 0 1rem;
    }

    .profile-head {
        font-size: 1.3rem;
        font-weight: 700;
        color: #35c5f0;
        margin: 1.5rem 0 1rem 0;
    }

    .profile-contents-label {
        font-weight: 700;
        margin-right: 5px;
    }

    .profile-text {
        font-size: 0.8rem;
    }


    .profile-img {
        max-width: 60%;
        opacity: 70%;
    }

    .content-head {
        font-size: 1.2rem;
    }

    .content-text {
        font-size: 0.9rem;
    }

    .content-img {
        max-width: 5rem;
        margin-right: 1rem;
    }

    .activated {
        color: #009FCE;
        font-weight: 700;
    }

    .disabled {
        color: #969696;
    }

    .pointer-cursor {
        cursor: pointer;
    }

    a, a:hover {
        text-decoration: none;
        outline: none;
        color: inherit;
    }

    .disabled-page {
        display: none;
    }

    .activated-page {
        display: flex;
    }
</style>
<div class="flex-center mypage-container">
    <div class="mypage-wrapper">
        <div class="flex-col-center mypage-profile mypage-border">
            <img class="profile-img" src="<%=request.getContextPath()%>/images/smile.png"/>
            <div class="profile-head"><%=member.getNickname()%>
            </div>
            <div class="flex-center profile-contents">
                <div class="profile-contents-label profile-text">
                    연령
                </div>
                <div class="profile-text">
                    <%=member.getAgeRange()%>
                </div>
                <div class="divider-col">|</div>
                <div class="profile-contents-label profile-text">
                    성별
                </div>
                <div class="profile-text">
                    <%="female".equals(member.getGender()) ? "여성" : "남성"%>
                </div>
            </div>
        </div>
        <div class="flex-col-center mypage-contents mypage-border activated-page">
            <div class="content-heads flex-center">
                <div class="content-head activated">나의 주문</div>
                <div class="divider-col content-head">|</div>
                <div onclick="handlePage()" class="content-head disabled pointer-cursor">나의 리뷰</div>
            </div>
            <div class="divider"></div>
            <div class="content-text">아직 주문 내역이 없어요.</div>
            <div class="content-text">쇼핑 하러 가기
                <a href="<%=request.getContextPath()%>/productList.do"
                   style="color: #35c5f0">click!</a>
            </div>
        </div>
        <div class="flex-col-center mypage-contents mypage-border disabled-page">
            <div class="content-heads flex-center">
                <div onclick="handlePage()" class="content-head disabled pointer-cursor">
                    나의 주문
                </div>
                <div class="divider-col content-head">|</div>
                <div class="content-head activated">나의 리뷰</div>
            </div>
            <div class="divider"></div>
            <% if (reviews.isEmpty()) {%>
            <div class="content-text">작성한 리뷰가 없어요.</div>
            <div class="content-text">첫 리뷰 쓰러 가기
                <a href="<%=request.getContextPath()%>/productList.do"
                   style="color: #35c5f0">click!</a>
            </div>
            <%
            } else {
                for (int i = 0; i < reviews.size(); i++) {
                    ReviewDto review = reviews.get(i);
            %>
            <div class="flex-center" style="align-self: flex-start; padding: 0 2rem;">
                <div>
                    <img
                            class="content-img pointer-cursor"
                            src="<%=review.getThumbnailUrl()%>"
                            alt="<%=review.getName()%>"
                            onclick="toProduct(<%=review.getProductId()%>)"
                    >
                </div>
                <div>
                    <div
                            style="font-weight: 700" class="content-text pointer-cursor"
                            onclick="toProduct(<%=review.getProductId()%>)"
                    >
                        <%=review.getName()%>
                    </div>
                    <div class="content-text"><%=review.getContent()%>
                    </div>
                </div>
            </div>
            <% if (i != reviews.size() - 1) { %>
            <div class="divider"></div>
            <%
                        }
                    }
                } %>
        </div>
    </div>
</div>
<script>
  function handlePage() {
    const $disabled_page = document.querySelector('.disabled-page');
    const $activated_page = document.querySelector('.activated-page');

    $disabled_page.classList.remove('disabled-page');
    $disabled_page.classList.add('activated-page');

    $activated_page.classList.remove('activated-page');
    $activated_page.classList.add('disabled-page')
  }

  function toProduct(product_id) {
    location.href = '<%=request.getContextPath()%>/productDetail.do?id=' + product_id;
  }
</script>