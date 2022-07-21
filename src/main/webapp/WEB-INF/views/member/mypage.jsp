<%@ page import="com.needle.FsoFso.common.util.AttributeContainer" %>
<%@ page import="com.needle.FsoFso.member.service.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");
%>
<style>
    .mypage-container {
        display: flex;
        justify-content: center;
        align-items: flex-start;

        min-height: 90vh;
    }

    .mypage-wrapper {
        display: grid;
        width: 80%;
        grid-template-columns: 20% minmax(70%, auto);
        grid-column-gap: 2rem;

        padding: 2rem;
    }

    .mypage-wrapper > div {
        padding: 2rem;
    }

    .mypage-profile {
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
        align-items: center;
    }

    .mypage-contents {
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
        align-items: flex-start;
    }

    .mypage-border {
        border: 1px solid #ebebeb;
        border-radius: 12px;
    }

    .divider {
        width: 100%;
        border-bottom: 1px solid #ebebeb;
        margin: 2rem 0;
    }

    .profile-head {
        font-size: 1.5rem;
        font-weight: 700;
        margin: 1rem 0 2rem 0;
    }

    .profile-contents-label {
        font-weight: 700;
    }

    .profile-img {
        max-width: 60%;
    }

    .content-head {
        /*font-family: 'JalpullineunOneul', serif;*/
        font-weight: 700;
        font-size: 1.2rem;
        color: #009FCE;

        margin-bottom: 2rem;
    }
</style>
<div class="mypage-container">
    <div class="mypage-wrapper">
        <div class="mypage-profile mypage-border">
            <img class="profile-img" src="<%=request.getContextPath()%>/images/smile.png"/>
            <div class="profile-head">이름</div>
            <div class="profile-contents-label">연령대</div>
            <div class="profile-contents-label">성별</div>
            <div class="profile-contents-label">회원등급?</div>
        </div>
        <div class="mypage-contents mypage-border">
            <div class="content-head">나의 주문</div>
            <div class="content-order">아직 주문 내역이 없어요.</div>
            <div class="content-order">쇼핑 하러 가기 <a href="<%=request.getContextPath()%>/productList.do">click!</a></div>
            <div class="divider"></div>
            <div class="content-head">나의 리뷰</div>
            <div class="content-review">작성한 리뷰가 없어요</div>
        </div>
    </div>
</div>